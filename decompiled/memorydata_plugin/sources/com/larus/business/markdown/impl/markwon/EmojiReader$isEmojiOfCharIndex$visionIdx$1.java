package com.larus.business.markdown.impl.markwon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "node", "Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;", "invoke", "(Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class EmojiReader$isEmojiOfCharIndex$visionIdx$1 extends Lambda implements Function1<b.a, Integer> {
    final /* synthetic */ int $idx;

    EmojiReader$isEmojiOfCharIndex$visionIdx$1(int r1) {
        this.$idx = r1;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        if (this.$idx >= r3.a()) goto L6;
        int r2 = 1;
    L10:
        return Integer.valueOf(r2);
    L6:
        if (this.$idx < (r3.a() + r3.b())) goto L8;
        r2 = -1;
        goto L10
    L8:
        r2 = 0;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Integer invoke(b.a r3) {
        return invoke2((b.a) ZeusTransformUtils.preCheckCast(r3, b.a.class, "com.obric.memorydata.plugin"));
    }
}
