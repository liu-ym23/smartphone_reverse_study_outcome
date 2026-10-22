package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import com.bytedance.ies.sdk.widgets.KVData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/ies/sdk/widgets/KVData;", "invoke"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class ToolbarAudioInteractBehavior$resetData$1 extends FunctionReferenceImpl implements Function1<KVData, Unit> {
    public ToolbarAudioInteractBehavior$resetData$1(ToolbarAudioInteractBehavior r8) {
        super(1, r8, ToolbarAudioInteractBehavior.class, "onChanged", "onChanged(Lcom/bytedance/ies/sdk/widgets/KVData;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((KVData) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(KVData r2) {
        ((ToolbarAudioInteractBehavior) ((CallableReference) this).receiver).b(r2);
    }
}
