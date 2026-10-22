package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.model.chat.UploadFilePolicy;
import ic8.m0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isDisallowedEntityTypeMethod$2 extends FunctionReferenceImpl implements Function3<Boolean, m0, Boolean, Boolean> {
    public LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1$2$isDisallowedEntityTypeMethod$2(Object r8) {
        super(3, r8, LegacyMultimodalDataProcessor.class, "isDisallowedEntityType", "isDisallowedEntityType(ZLcom/larus/bmhome/chat/bean/ProcessFileInfo;Z)Z", 0);
    }

    public final Boolean invoke(boolean r4, m0 r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        LegacyMultimodalDataProcessor r0 = (LegacyMultimodalDataProcessor) ((CallableReference) this).receiver;
        int r1 = LegacyMultimodalDataProcessor.q;
        r0.getClass();
        boolean r2 = false;
        if (r4 == false) goto L24;
        String r7 = r5.b;
        String r8 = "";
        if (r7 == null) goto L9;
        String r9 = StringsKt.substringAfterLast(r7, '.', "");
        if (r9 == null) goto L9;
        String r10 = r9.toLowerCase(Locale.ROOT);
    L10:
        if (r10 == null) goto L13;
        r8 = r10;
    L13:
        ICoreInputAbility r11 = r0.E();
        if (r11 != null) goto L16;
    L18:
        boolean r12 = false;
    L19:
        if (r12 == false) goto L22;
        if (r6 == true) goto L24;
    L22:
        r2 = !UploadFilePolicy.g(r8);
        goto L24
    L16:
        if (r11.Pi() != true) goto L18;
        r12 = true;
    L9:
        r10 = null;
    L24:
        return Boolean.valueOf(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Boolean) r1).booleanValue(), (m0) r2, ((Boolean) r3).booleanValue());
    }
}
