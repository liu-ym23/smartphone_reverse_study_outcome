package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ImFileUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class FileProcessor$execIncludeClone$isFileOverSizeMethod$1 extends FunctionReferenceImpl implements Function3<Boolean, Long, Boolean, Boolean> {
    public FileProcessor$execIncludeClone$isFileOverSizeMethod$1(Object r8) {
        super(3, r8, ImFileUtil.class, "isAudioFileOverSize", "isAudioFileOverSize(ZJZ)Z", 0);
    }

    public final Boolean invoke(boolean r5, long r6, boolean r8) {
        ((ImFileUtil) ((CallableReference) this).receiver).getClass();
        long r0 = ((Number) ImFileUtil.o.getValue()).longValue();
        if (r6 > 0) goto L5;
    L8:
        boolean r7 = true;
    L10:
        return Boolean.valueOf(r7);
    L5:
        if (r6 > r0) goto L8;
        r7 = false;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        return invoke(((Boolean) r3).booleanValue(), ((Number) r4).longValue(), ((Boolean) r5).booleanValue());
    }
}
