package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements com.ss.android.lark.chat.utils.v {
    public final /* synthetic */ ImageContentBlock a;
    public final /* synthetic */ ImageContentBlock.b b;

    @Override // com.ss.android.lark.chat.utils.v
    public final void onFinish() {
        ImageContentBlock r0 = this.a;
        ImageContentBlock.b r1 = this.b;
        r0.getClass();
        ImageContentBlock.i(false, r1);
    }

    @Override // com.ss.android.lark.chat.utils.v
    public final void onStart() {
        ImageContentBlock r0 = this.a;
        ImageContentBlock.b r1 = this.b;
        r0.getClass();
        ImageContentBlock.i(true, r1);
    }

    public m(ImageContentBlock r1, ImageContentBlock.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
