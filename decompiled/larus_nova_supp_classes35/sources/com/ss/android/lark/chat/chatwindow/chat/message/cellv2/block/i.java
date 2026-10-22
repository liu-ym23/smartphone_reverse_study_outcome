package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements View.OnLongClickListener {
    public final /* synthetic */ AvatarBlock.a a;
    public final /* synthetic */ AvatarBlock b;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> c;
    public final /* synthetic */ y6b.a<?> d;
    public final /* synthetic */ y6b.b e;

    public i(AvatarBlock.a r1, AvatarBlock r2, com.ss.android.lark.blueprint.m<y6b.a<?>> r3, y6b.a<?> r4, y6b.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        if (this.a.getView().getVisibility() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L8;
    L22:
        e6b.b r5 = this.c;
        if ((r5 instanceof e6b.b) == false) goto L25;
        e6b.b r6 = r5;
    L26:
        if (r6 != null) goto L28;
        return false;
    L28:
        return r6.e(this.b, this.d);
    L25:
        r6 = null;
        goto L26
    L8:
        if (this.b.c.s8() == true) goto L22;
        if (this.e.x == false) goto L15;
        Log.i("AvatarBlock", "chatter is anonymous block avatar click");
        return false;
    L15:
        if (this.b.c.isAIChat() == false) goto L18;
        Log.i("AvatarBlock", "AI chat doesn't support @");
        return false;
    L18:
        b3b.f r7 = this.b.d;
        if (r7 != null) goto L21;
        return false;
    L21:
        return r7.j(this.e);
    L5:
        r4 = false;
        goto L6
    }
}
