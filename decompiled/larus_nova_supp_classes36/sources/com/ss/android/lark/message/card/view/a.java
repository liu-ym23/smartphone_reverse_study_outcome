package com.ss.android.lark.message.card.view;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.image.entity.ResourceCleanScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.chat.base.view.vo.message.f<CardContent> implements com.ss.android.lark.chat.base.view.vo.message.b {
    public boolean h;

    public final boolean a() {
        return ((v5b.a) this).a.resourceIsCleaned();
    }

    public final ResourceCleanScene b() {
        return ((v5b.a) this).a.firstResourceScene();
    }

    public final CardContent.CardHeader f() {
        throw null;
    }

    public final boolean d(v5b.a<?> r3) {
        if (super.d(r3) == true) goto L6;
        return false;
    L6:
        if ((r3 instanceof a) == true) goto L8;
        return false;
    L8:
        if (this.h != ((a) r3).h) goto L12;
        return true;
    L12:
        return false;
    }
}
