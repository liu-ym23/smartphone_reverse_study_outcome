package com.bytedance.android.livesdk.interactivity.textmessage.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0005\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ltb2/d;", "kotlin.jvm.PlatformType", "p1", "invoke", "(Ltb2/d;)Ltb2/d;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class AudioChatTextMessage$getRenderText$1 extends FunctionReferenceImpl implements Function1<tb2.d, tb2.d> {
    public AudioChatTextMessage$getRenderText$1(AudioChatTextMessage r8) {
        super(1, r8, AudioChatTextMessage.class, "appendProperUser", "appendProperUser(Lcom/bytedance/android/livesdk/interactivity/service/textrender/data/RenderText;)Lcom/bytedance/android/livesdk/interactivity/service/textrender/data/RenderText;", 0);
    }

    public final tb2.d invoke(tb2.d r2) {
        ((AudioChatTextMessage) ((CallableReference) this).receiver).c(r2);
        return r2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((tb2.d) r1);
    }
}
