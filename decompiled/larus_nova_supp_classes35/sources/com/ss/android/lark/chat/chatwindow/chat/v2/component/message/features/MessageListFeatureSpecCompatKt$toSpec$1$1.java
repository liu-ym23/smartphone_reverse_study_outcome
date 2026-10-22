package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import androidx.arch.core.util.Function;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "vo", "Lcom/ss/android/lark/chat/vo/ChatMessageVO;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class MessageListFeatureSpecCompatKt$toSpec$1$1 extends Lambda implements Function1<y6b.c<?>, Unit> {
    final /* synthetic */ Function<y6b.c<?>, Boolean> $listener;

    public MessageListFeatureSpecCompatKt$toSpec$1$1(Function<y6b.c<?>, Boolean> r1) {
        this.$listener = r1;
        super(1);
    }

    public final void invoke(y6b.c<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        this.$listener.apply(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((y6b.c) r1);
        return Unit.INSTANCE;
    }
}
