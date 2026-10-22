package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g0 {
    public View a;
    public final BaseFragment b;
    public final FragmentActivity c;

    public g0() {
    }

    public final FragmentActivity getActivity() {
        return this.c;
    }

    public final <T extends View> T a(int r2) {
        View r0 = this.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("origin");
        r0 = null;
    L7:
        return (T) r0.findViewById(r2);
    }

    public g0(View r2, BaseFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
        this.b = r3;
        this.c = r3.getActivity();
    }
}
