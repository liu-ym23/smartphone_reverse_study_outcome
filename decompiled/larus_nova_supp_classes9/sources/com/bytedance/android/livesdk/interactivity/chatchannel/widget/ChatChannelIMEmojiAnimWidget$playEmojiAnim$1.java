package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "path", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
final class ChatChannelIMEmojiAnimWidget$playEmojiAnim$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $name;
    final /* synthetic */ ChatChannelIMEmojiAnimWidget this$0;

    public ChatChannelIMEmojiAnimWidget$playEmojiAnim$1(ChatChannelIMEmojiAnimWidget r1, String r2) {
        this.this$0 = r1;
        this.$name = r2;
        super(1);
    }

    public final void invoke(String r4) {
        ChatChannelIMEmojiAnimWidget r0 = this.this$0;
        String r1 = "play emoji anim name=" + this.$name + " path=" + r4;
        int r2 = ChatChannelIMEmojiAnimWidget.h;
        r0.xq(r1);
        if (r4 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.api.c r3 = this.this$0.b;
        if (r3 == null) goto L9;
        r3.a(new com.bytedance.android.livesdk.interactivity.api.c.a(r4, 2));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
