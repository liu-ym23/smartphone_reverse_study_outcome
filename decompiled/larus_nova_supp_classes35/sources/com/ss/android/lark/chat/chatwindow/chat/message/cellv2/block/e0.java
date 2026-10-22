package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e0 extends OnSingleClickListener {
    public final /* synthetic */ PostContentBlock a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ y6b.a<PostContentVO> c;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> d;

    public final void onSingleClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        PostContentBlock r0 = this.a;
        g3b.r r1 = r0.n;
        e6b.b r2 = null;
        if (r1 == null) goto L5;
        Function1<? super View, Unit> r3 = r1.d.a;
    L6:
        if (r3 == null) goto L9;
        r3.invoke(r5);
        return;
    L9:
        if (this.b == false) goto L15;
        boolean r4 = TextUtils.isEmpty(this.c.M());
        if (r4 == false) goto L13;
        String r6 = this.c.getId();
    L14:
        l1.a r7 = new l1.a();
        r7.e = r6;
        r7.l = this.c.getChatId();
        r7.n = !r4;
        r7.o = false;
        l1 r8 = new l1(r7);
        Context r9 = r5.getContext();
        Intrinsics.checkNotNull(r8);
        Boolean r10 = ReplyInThreadUtil.a;
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r8, "bundle");
        ReplyInThreadUtil.c(r9, r8, null);
        return;
    L13:
        r6 = this.c.M();
        goto L14
    L15:
        com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r11 = this.d;
        if ((r11 instanceof e6b.b) == false) goto L18;
        r2 = (e6b.b) r11;
    L18:
        if (r2 == null) goto L23;
        r2.j(r0, this.c);
        return;
    L23:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public e0(PostContentBlock r1, boolean r2, y6b.a<PostContentVO> r3, com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
