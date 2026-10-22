package com.larus.business.markdown.impl.markwon;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "node", "Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;", "invoke", "(Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EmojiReader$isEmojiOfCharIndex$visionIdx$1 extends Lambda implements Function1<EmojiReader$Node, Integer> {
    final /* synthetic */ int $idx;

    public EmojiReader$isEmojiOfCharIndex$visionIdx$1(int r1) {
        this.$idx = r1;
        super(1);
    }

    public final Integer invoke(EmojiReader$Node r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        int r0 = this.$idx;
        r2.getClass();
        if (r0 >= 0) goto L6;
        int r3 = 1;
    L10:
        return Integer.valueOf(r3);
    L6:
        if (this.$idx < 0) goto L8;
        r3 = -1;
        goto L10
    L8:
        r3 = 0;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((EmojiReader$Node) r1);
    }
}
