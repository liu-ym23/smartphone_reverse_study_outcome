package com.bytedance.android.live.platformplayer.panel;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ w1 b;

    public j(k r1, w1 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Object r0 = this.b.a.get();
        Dialog r2 = null;
        if ((r0 instanceof LiveDialogFragment) == true) goto L5;
        r0 = null;
    L5:
        LiveDialogFragment r1 = (LiveDialogFragment) r0;
        if (r1 == null) goto L12;
        ds0.b r3 = new ds0.b();
        r3.a(LivePanelType.PERSONAL_PROFILE);
        r3.c = r1.getContentViewHeight();
        Intrinsics.checkNotNullParameter("open", "<set-?>");
        r3.b = "open";
        r3.e = 2131389519;
        DialogFragment r4 = (DialogFragment) this.b.a.get();
        if (r4 == null) goto L10;
        r2 = r4.getDialog();
    L10:
        WeakReference<Dialog> r5 = new WeakReference(r2);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.d = r5;
        o.a(this.a.a, r3);
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
