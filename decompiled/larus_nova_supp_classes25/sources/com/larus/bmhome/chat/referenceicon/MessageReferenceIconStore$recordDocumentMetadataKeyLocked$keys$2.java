package com.larus.bmhome.chat.referenceicon;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public static final MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2 INSTANCE = null;

    static {
        INSTANCE = new MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2();
    }

    public MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$2() {
        super(1, StringsKt.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
    }

    public final Boolean invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return Boolean.valueOf(!StringsKt.isBlank(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
