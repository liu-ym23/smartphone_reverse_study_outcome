package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements com.ss.android.lark.chat.utils.v {
    public final /* synthetic */ MediaContentBlock a;
    public final /* synthetic */ MediaContentBlock.b b;

    @Override // com.ss.android.lark.chat.utils.v
    public final void onFinish() {
        MediaContentBlock r0 = this.a;
        MediaContentBlock.b r1 = this.b;
        r0.getClass();
        MediaContentBlock.j(false, r1);
    }

    @Override // com.ss.android.lark.chat.utils.v
    public final void onStart() {
        MediaContentBlock r0 = this.a;
        MediaContentBlock.b r1 = this.b;
        r0.getClass();
        MediaContentBlock.j(true, r1);
    }

    public u(MediaContentBlock r1, MediaContentBlock.b r2) {
        this.a = r1;
        this.b = r2;
    }
}
