package com.bytedance.android.live.profit.format.voicechat.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FormatVoiceChatFragment$startChat$3 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public FormatVoiceChatFragment$startChat$3(FormatVoiceChatFragment r8) {
        super(1, r8, FormatVoiceChatFragment.class, "onSendGiftFailed", "onSendGiftFailed(Ljava/lang/Throwable;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Throwable) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable r2) {
        FormatVoiceChatFragment.T90((FormatVoiceChatFragment) ((CallableReference) this).receiver, r2);
    }
}
