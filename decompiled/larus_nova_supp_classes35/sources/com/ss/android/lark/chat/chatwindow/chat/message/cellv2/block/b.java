package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.a {
    public final /* synthetic */ y6b.a<AudioContentVO> a;
    public final /* synthetic */ AudioContentBlock b;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> c;
    public final /* synthetic */ com.ss.android.lark.audio.f d;

    public final void a(PlayControlBar r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ArrayList r4 = new ArrayList();
        r4.add(this.a.getcId());
        if (this.a.C() < 2) goto L5;
    L23:
        this.d.e(r4);
        return;
    L5:
        if (this.a.h() == true) goto L23;
        if (this.b.k == null) goto L23;
        xza.a r0 = this.c;
        if ((r0 instanceof xza.a) == false) goto L11;
        xza.a r1 = r0;
    L12:
        if (r1 == null) goto L16;
        BlueprintCellViewHolder r2 = r1.i();
        if (r2 == null) goto L16;
        int r5 = r2.getAdapterPosition();
    L17:
        if (r5 < 0) goto L23;
        b3b.f r6 = this.b.k;
        if (r6 == null) goto L23;
        List<String> r7 = r6.y0(r5);
        if (r7 == null) goto L23;
        r4.addAll(r7);
    L16:
        r5 = -1;
        goto L17
    L11:
        r1 = null;
        goto L12
    }

    public b(y6b.a<AudioContentVO> r1, AudioContentBlock r2, com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r3, com.ss.android.lark.audio.f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
