package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class MultiAttachmentSelectorComponent$albumPipelinePrewarmerDelegate$1$1 extends FunctionReferenceImpl implements Function3<kq9.d, String, Continuation<? super com.larus.bmhome.resource.access.b0>, Object>, SuspendFunction {
    public MultiAttachmentSelectorComponent$albumPipelinePrewarmerDelegate$1$1(Object r8) {
        super(3, r8, MultiAttachmentSelectorComponent.class, "submitAlbumSelectionPrewarm", "submitAlbumSelectionPrewarm(Lcom/larus/platform/model/album/AlbumSelectionEventItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((kq9.d) r1, (String) r2, (Continuation) r3);
    }

    public final Object invoke(kq9.d r2, String r3, Continuation<? super com.larus.bmhome.resource.access.b0> r4) {
        return MultiAttachmentSelectorComponent.z3((MultiAttachmentSelectorComponent) ((CallableReference) this).receiver, r2, r3, r4);
    }
}
