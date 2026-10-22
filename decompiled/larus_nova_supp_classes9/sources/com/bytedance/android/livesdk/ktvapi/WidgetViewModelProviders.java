package com.bytedance.android.livesdk.ktvapi;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wy.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/WidgetViewModelProviders;", "Landroidx/lifecycle/ViewModelProviders;", "<init>", "()V", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WidgetViewModelProviders extends ViewModelProviders {
    public static final WidgetViewModelProviders a = null;

    static {
        a = new WidgetViewModelProviders();
    }

    private WidgetViewModelProviders() {
    }

    public static ViewModelProvider a(HolderRoomWidget r3, ViewModelProvider.Factory r4) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if (((Widget) r3).isViewValid == false) goto L5;
        Context r0 = ((Widget) r3).context;
    L6:
        if (r0 == null) goto L13;
        Application r1 = ((FragmentActivity) r0).getApplication();
        if (r4 != null) goto L11;
        r4 = ViewModelProvider.AndroidViewModelFactory.getInstance(r1);
    L11:
        return new ViewModelProvider(r3, r4);
    L13:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L5:
        LocalTestManager.a(new Class[]{a.class});
        r0 = s1.getContext();
        goto L6
    }
}
