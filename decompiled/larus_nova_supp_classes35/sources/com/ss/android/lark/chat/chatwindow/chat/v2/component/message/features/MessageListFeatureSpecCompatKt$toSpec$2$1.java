package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import androidx.arch.core.util.Function;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "vo", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "invoke", "(Lcom/ss/android/lark/chat/vo/ChatMessageVO;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class MessageListFeatureSpecCompatKt$toSpec$2$1 extends Lambda implements Function1<y6b.c<?>, Boolean> {
    final /* synthetic */ Function<y6b.c<?>, Boolean> $listener;

    public MessageListFeatureSpecCompatKt$toSpec$2$1(Function<y6b.c<?>, Boolean> r1) {
        this.$listener = r1;
        super(1);
    }

    public final Boolean invoke(y6b.c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        return (Boolean) this.$listener.apply(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((y6b.c) r1);
    }
}
