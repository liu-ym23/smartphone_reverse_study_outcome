package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements com.ss.android.lark.threaddetail.b.a {
    public final /* synthetic */ b a;

    public final void b() {
    }

    public final m2b.a a() {
        return this.a.getContext();
    }

    public final int getContainerWidth() {
        m2b.a r0 = a();
        if (r0 == null) goto L9;
        lya.a r1 = r0.l();
        if (r1 == null) goto L9;
        Integer r2 = r1.a();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    public a(b r1) {
        this.a = r1;
    }
}
