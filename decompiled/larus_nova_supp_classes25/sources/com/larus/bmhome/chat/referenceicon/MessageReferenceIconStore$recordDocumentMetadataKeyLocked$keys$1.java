package com.larus.bmhome.chat.referenceicon;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$1 INSTANCE = null;

    static {
        INSTANCE = new MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$1();
    }

    public MessageReferenceIconStore$recordDocumentMetadataKeyLocked$keys$1() {
        super(1, StringsKt.class, "trim", "trim(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    public final String invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return StringsKt.trim(r2).toString();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
