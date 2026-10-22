package com.larus.avlink.gallery.storage;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/avlink/gallery/storage/InvalidLegacyDataException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "fileId", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class InvalidLegacyDataException extends Exception {
    public static final int $stable = 8;
    private final String fileId;

    public final String getFileId() {
        return this.fileId;
    }

    public InvalidLegacyDataException(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileId");
        Intrinsics.checkNotNullParameter(r3, "message");
        super(r3);
        this.fileId = r2;
    }
}
