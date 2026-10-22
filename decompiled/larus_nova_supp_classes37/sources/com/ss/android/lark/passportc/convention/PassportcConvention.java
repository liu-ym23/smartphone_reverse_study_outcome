package com.ss.android.lark.passportc.convention;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passportc.entity.UserSession;
import e0c.k;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportcConvention {
    public static final UserSession a(Application r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ((a) k.a(r1, a.class)).b();
    }

    public static final UserSession b(final Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        UserSession r0 = d(r3.requireContext(), r3, r3, r3.getArguments(), new PassportcConvention$getSessionByConvention$2(r3));
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Can't find user session from 'arguments' by convention key 'iji.convention.user_id', 'iji.convention.session_key' in " + r3.getClass() + ' ');
    }

    public static final UserSession c(final FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intent r0 = r3.getIntent();
        if (r0 == null) goto L5;
        Bundle r1 = r0.getExtras();
    L6:
        UserSession r2 = d(r3, r3, r3, r1, new PassportcConvention$getSessionByConvention$1(r3));
        if (r2 == null) goto L10;
        return r2;
    L10:
        throw new IllegalStateException("Can't find user session from 'intent' by convention key 'iji.convention.user_id', 'iji.convention.session_key' in " + r3.getClass() + ' ');
    L5:
        r1 = null;
        goto L6
    }

    public static final void e(Intent r1, Application r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "app");
        ((a) k.a(r2, a.class)).a(r1);
    }

    public static final void f(Bundle r1, Application r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "app");
        ((a) k.a(r2, a.class)).d(r1);
    }

    public static final void g(Intent r2, UserSession r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r2.putExtra("iji.convention.user_id", r3.b);
        r2.putExtra("iji.convention.session_key", r3.a);
    }

    public static final void h(Bundle r2, UserSession r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r2.putString("iji.convention.user_id", r3.b);
        r2.putString("iji.convention.session_key", r3.a);
    }

    public static final UserSession d(final Context r2, ViewModelStoreOwner r3, final SavedStateRegistryOwner r4, final Bundle r5, final Function0<UserSession> r6) {
        if ((r4 instanceof FragmentActivity) == true) goto L5;
    L7:
        ViewModelProvider r0 = new ViewModelProvider(r3, new PassportcConvention$getUserIdWithViewModel$2(r2, r6));
    L9:
        return ((SaveSessionViewModel) r0.get(SaveSessionViewModel.class)).getUserSession();
    L5:
        if (((FragmentActivity) r4).isDestroyed() == true) goto L7;
        r0 = new ViewModelProvider(r3, new PassportcConvention$getUserIdWithViewModel$1(r4, r5, r2, r6));
        goto L9
    }
}
