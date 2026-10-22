package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class MultiAttachmentSelectorComponent$openAlbumInternal$2 extends FunctionReferenceImpl implements Function0<Unit> {
    public MultiAttachmentSelectorComponent$openAlbumInternal$2(Object r8) {
        super(0, r8, MultiAttachmentSelectorComponent.class, "cancelAlbumSelectionPrewarm", "cancelAlbumSelectionPrewarm()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m107invoke() {
        MultiAttachmentSelectorComponent r0 = (MultiAttachmentSelectorComponent) ((CallableReference) this).receiver;
        int r1 = MultiAttachmentSelectorComponent.Z;
        r0.G3();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m107invoke();
        return Unit.INSTANCE;
    }
}
