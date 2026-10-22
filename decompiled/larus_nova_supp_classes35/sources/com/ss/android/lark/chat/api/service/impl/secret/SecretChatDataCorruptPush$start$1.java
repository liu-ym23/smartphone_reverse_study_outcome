package com.ss.android.lark.chat.api.service.impl.secret;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PushSecretChatDataCorruptResponse;
import com.bytedance.lark.rustclient.api.t;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SecretChatDataCorruptPush$start$1 extends Lambda implements Function0<Disposable> {
    final /* synthetic */ SecretChatDataCorruptPush this$0;

    public SecretChatDataCorruptPush$start$1(SecretChatDataCorruptPush r1) {
        this.this$0 = r1;
        super(0);
    }

    public final Disposable invoke() {
        Observable r0 = this.this$0.b.i(Command.PUSH_SECRET_CHAT_DATA_CORRUPT, PushSecretChatDataCorruptResponse.ADAPTER);
        SecretChatDataCorruptPush r1 = this.this$0;
        return t.g(r0, r1.g, r1.f);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m96invoke() {
        return invoke();
    }
}
