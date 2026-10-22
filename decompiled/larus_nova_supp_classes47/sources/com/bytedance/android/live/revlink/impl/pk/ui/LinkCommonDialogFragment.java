package com.bytedance.android.live.revlink.impl.pk.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/LinkCommonDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LinkCommonDialogFragment extends LiveDialogFragment {
    public final Lazy d;

    public LinkCommonDialogFragment() {
        this.d = LazyKt.lazy(LinkCommonDialogFragment$isAnimOptEnable$2.INSTANCE);
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Dialog r6 = getDialog();
        Intrinsics.checkNotNull(r6);
        Window r7 = r6.getWindow();
        if (r7 == null) goto L11;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L9:
        r0.setPadding(0, 0, 0, 0);
        r7.setLayout(-1, -1);
        r7.setGravity(80);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setSoftInputMode(48);
        return;
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (((Boolean) this.d.getValue()).booleanValue() == true) goto L5;
    L8:
        setStyle(1, 2131954719);
        return;
    L5:
        if (com.bytedance.android.live.revlink.impl.perf.f.a() == false) goto L7;
        return;
    L7:
        if (com.bytedance.android.live.revlink.impl.perf.f.b() == false) goto L8;
    }
}
