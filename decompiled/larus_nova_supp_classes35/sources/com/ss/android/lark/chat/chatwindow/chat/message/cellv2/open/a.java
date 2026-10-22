package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open;

import android.view.View;
import b3b.f;
import com.ss.android.lark.chat.entity.message.Message;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;
import r5b.c;
import r5b.d;
import r5b.e;
import v5b.a;
import v5b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<VO extends v5b.a<?>, CT extends v5b.b<VO>, CP extends d<VO>> implements c<v5b.a<?>> {
    public final CT a;
    public final CP b;
    public final b c;
    public c<?> d;

    public final boolean a(y6b.a<?> r3) {
        Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
        if (r3.getType() == Message.Type.forNumber(this.a.a().getNumber())) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r3.b().getClass(), this.b.c()) == false) goto L7;
        return true;
    }

    @Override // r5b.c
    public final boolean d(View r3, v5b.c<v5b.a<?>> r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "item");
        c<?> r0 = this.d;
        if ((r0 instanceof c) == true) goto L6;
        r0 = null;
    L6:
        if (r0 != null) goto L10;
        return false;
    L10:
        return r0.d(r3, r4);
    }

    public a(m2b.a r3, f r4, e<VO, CT, CP> r5) {
        Intrinsics.checkNotNullParameter(r3, "chatContext");
        Intrinsics.checkNotNullParameter(r5, "factory");
        if ((r4 instanceof q5b.a) == true) goto L6;
        r4 = null;
    L6:
        p2b.b r0 = new p2b.b(r4);
        r0.a = this;
        CT r6 = (CT) r5.b();
        this.a = r6;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.export.ui.message.IOpenCellCallback<VO of com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.OpenCellAdapter>");
        CP r7 = (CP) r5.a(r3, r0);
        this.b = r7;
        this.c = new b(r6.a().getNumber(), r7.c().getName());
    }
}
