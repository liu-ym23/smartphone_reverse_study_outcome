package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i7 implements View.OnLayoutChangeListener {
    public float a;
    public final /* synthetic */ LiveProfileManageDialogV2 b;

    public i7(LiveProfileManageDialogV2 r1) {
        this.b = r1;
        this.a = -1.0f;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r1, "v");
        if (PadConfigUtils.c() == false) goto L5;
        return;
    L5:
        LiveProfileManageDialogV2 r10 = this.b;
        if (r10.b == true) goto L9;
        return;
    L9:
        if (this.a >= 0) goto L12;
        this.a = r10.d * 0.75f;
    L12:
        if (r5 >= this.a) goto L17;
        if (r10.c == true) goto L20;
        r10.c = true;
        xs2.b.a().post(new zg1.i1(r5 - r9, true));
        ((LiveProfileManageViewPager) this.b.findViewById(2131386019)).h();
        return;
    L20:
        return;
    L17:
        if (r10.c == false) goto L22;
        r10.c = false;
        xs2.b.a().post(new zg1.i1(r5 - r9, false));
        ((LiveProfileManageViewPager) this.b.findViewById(2131386019)).h();
        return;
    }
}
