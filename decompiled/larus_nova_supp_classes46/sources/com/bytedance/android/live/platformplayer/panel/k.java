package com.bytedance.android.live.platformplayer.panel;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.w1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ o a;

    public k(o r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        w1 r4 = (w1) r3;
        if (r4.b == false) goto L11;
        DialogFragment r0 = (DialogFragment) r4.a.get();
        if (r0 == null) goto L13;
        Dialog r1 = r0.getDialog();
        if (r1 == null) goto L14;
        View r2 = r1.findViewById(2131389519);
        if (r2 == null) goto L15;
        r2.post(new j(this, r4));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L11:
        ds0.b r5 = new ds0.b();
        r5.a(LivePanelType.PERSONAL_PROFILE);
        Intrinsics.checkNotNullParameter("close", "<set-?>");
        r5.b = "close";
        o.a(this.a, r5);
    }
}
