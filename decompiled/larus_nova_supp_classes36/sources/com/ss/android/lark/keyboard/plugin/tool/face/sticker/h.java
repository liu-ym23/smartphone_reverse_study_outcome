package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements FaceNewAdapter.c {
    public final /* synthetic */ FacePageNewFragment2 a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.c
    public final void a() {
        WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> r0 = this.a.d;
        if (r0 == null) goto L5;
        com.ss.android.lark.keyboard.plugin.tool.face.b r1 = r0.get();
    L6:
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public h(FacePageNewFragment2 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.c
    public final void b(com.ss.android.lark.keyboard.plugin.tool.face.d r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        WeakReference<com.ss.android.lark.keyboard.plugin.tool.face.b> r2 = this.a.d;
        if (r2 == null) goto L7;
        com.ss.android.lark.keyboard.plugin.tool.face.b r3 = r2.get();
    L8:
        if (r3 == null) goto L11;
        r3.b();
        return;
    L11:
        return;
    L7:
        r3 = null;
        goto L8
    }
}
