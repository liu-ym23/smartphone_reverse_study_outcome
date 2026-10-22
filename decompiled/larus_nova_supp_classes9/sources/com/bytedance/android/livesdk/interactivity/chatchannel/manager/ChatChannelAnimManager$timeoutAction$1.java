package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelAnimManager$a;", "it", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/interactivity/chatchannel/manager/ChatChannelAnimManager$a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ChatChannelAnimManager$timeoutAction$1 extends Lambda implements Function1<ChatChannelAnimManager.a, Unit> {
    final /* synthetic */ ChatChannelAnimManager this$0;

    public ChatChannelAnimManager$timeoutAction$1(ChatChannelAnimManager r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(ChatChannelAnimManager.a r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (Intrinsics.areEqual(this.this$0.b, r2) == false) goto L6;
        ChatChannelAnimManager.c(this.this$0, r2.b);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((ChatChannelAnimManager.a) r1);
        return Unit.INSTANCE;
    }
}
