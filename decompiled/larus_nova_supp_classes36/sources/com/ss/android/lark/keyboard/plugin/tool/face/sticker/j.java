package com.ss.android.lark.keyboard.plugin.tool.face.sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements FaceNewAdapter.e {
    public final /* synthetic */ FacePageNewFragment2 a;

    public j(FacePageNewFragment2 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.face.sticker.FaceNewAdapter.e
    public final com.ss.android.lark.keyboard.plugin.tool.face.d a(String r1, int r2, int r3) {
        FacePageNewFragment2 r4 = this.a;
        int r5 = FacePageNewFragment2.n;
        k r6 = r4.U90();
        if (r6 != null) goto L7;
        return null;
    L7:
        return r6.d();
    }
}
