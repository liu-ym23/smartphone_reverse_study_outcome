package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.utils.ImFileUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class FileProcessor$execIncludeClone$isFileOverSizeMethod$2 extends FunctionReferenceImpl implements Function3<Boolean, Long, Boolean, Boolean> {
    public FileProcessor$execIncludeClone$isFileOverSizeMethod$2(Object r8) {
        super(3, r8, ImFileUtil.class, "isFileOverSize", "isFileOverSize(ZJZ)Z", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4, Object r5) {
        return invoke(((Boolean) r3).booleanValue(), ((Number) r4).longValue(), ((Boolean) r5).booleanValue());
    }

    public final Boolean invoke(boolean r1, long r2, boolean r4) {
        ((ImFileUtil) ((CallableReference) this).receiver).getClass();
        return Boolean.valueOf(ImFileUtil.v(r2, r4));
    }
}
