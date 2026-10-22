package com.ss.android.lark.flow.chat.message.block.threadforward;

import android.view.View;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ m<y6b.a<ThreadForwardContentVOV2>> a;
    public final /* synthetic */ FlowThreadForwardExposureBlock b;
    public final /* synthetic */ y6b.a<ThreadForwardContentVOV2> c;

    public b(m<y6b.a<ThreadForwardContentVOV2>> r1, FlowThreadForwardExposureBlock r2, y6b.a<ThreadForwardContentVOV2> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        e6b.b r4 = this.a;
        if ((r4 instanceof e6b.b) == false) goto L5;
        e6b.b r5 = r4;
    L6:
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.e(this.b, this.c);
    L5:
        r5 = null;
        goto L6
    }
}
