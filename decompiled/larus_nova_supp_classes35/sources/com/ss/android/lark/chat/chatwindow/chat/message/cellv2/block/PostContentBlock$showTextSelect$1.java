package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "copyText", BuildConfig.FLAVOR, "finalIsTranslated", BuildConfig.FLAVOR, "partialContentRelativePosition", "Lcom/ss/android/lark/chat/entity/message/PartialReplyInfo$PartialContentRelativePosition;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class PostContentBlock$showTextSelect$1 extends Lambda implements Function3<CharSequence, Boolean, PartialReplyInfo.PartialContentRelativePosition, Unit> {
    final /* synthetic */ y6b.a<PostContentVO> $item;
    final /* synthetic */ PostContentBlock this$0;

    public PostContentBlock$showTextSelect$1(y6b.a<PostContentVO> r1, PostContentBlock r2) {
        this.$item = r1;
        this.this$0 = r2;
        super(3);
    }

    public final void invoke(CharSequence r2, boolean r3, PartialReplyInfo.PartialContentRelativePosition r4) {
        Intrinsics.checkNotNullParameter(r2, "copyText");
        Intrinsics.checkNotNullParameter(r4, "partialContentRelativePosition");
        this.$item.b().t = r2;
        this.$item.b().u = r2;
        this.$item.b().v = r4;
        this.$item.b().y = r3;
        PostContentBlock r5 = this.this$0;
        y6b.a<PostContentVO> r6 = this.$item;
        int r7 = PostContentBlock.o;
        r5.getClass();
        if (com.ss.android.lark.message.lynxcard.message.r.a(null) == false) goto L6;
        r6.b().w = null;
    L6:
        if (com.ss.android.lark.message.lynxcard.message.r.a(null) == false) goto L9;
        r6.b().x = null;
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((CharSequence) r1, ((Boolean) r2).booleanValue(), (PartialReplyInfo.PartialContentRelativePosition) r3);
        return Unit.INSTANCE;
    }
}
