package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.platform.api.FlowDriveFileType;
import ic8.m0;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isDisallowedEntityTypeMethod$1 extends FunctionReferenceImpl implements Function3<Boolean, m0, Boolean, Boolean> {
    public LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isDisallowedEntityTypeMethod$1(Object r8) {
        super(3, r8, LegacyMultimodalDataProcessor.class, "isDisallowedAudioEntityType", "isDisallowedAudioEntityType(ZLcom/larus/bmhome/chat/bean/ProcessFileInfo;Z)Z", 0);
    }

    public final Boolean invoke(boolean r1, m0 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        LegacyMultimodalDataProcessor r4 = (LegacyMultimodalDataProcessor) ((CallableReference) this).receiver;
        int r5 = LegacyMultimodalDataProcessor.q;
        r4.getClass();
        FlowDriveFileType r6 = r2.k;
        if (r6 != null) goto L5;
        ImFileUtil r7 = ImFileUtil.a;
        String r8 = r2.b;
        String r9 = r2.d;
        r7.getClass();
        boolean r10 = ImFileUtil.u(r8, r9);
    L10:
        return Boolean.valueOf(r10);
    L5:
        if (r6 == FlowDriveFileType.AUDIO) goto L7;
        r10 = true;
        goto L10
    L7:
        r10 = false;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Boolean) r1).booleanValue(), (m0) r2, ((Boolean) r3).booleanValue());
    }
}
