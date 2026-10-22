package com.larus.bmhome.chat.detail.code.preview;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/preview/CodePreviewStatus;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "FAIL", "LOADING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CodePreviewStatus extends Enum<CodePreviewStatus> {
    public static final CodePreviewStatus FAIL = null;
    public static final CodePreviewStatus LOADING = null;
    public static final CodePreviewStatus SUCCESS = null;
    public static final /* synthetic */ CodePreviewStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CodePreviewStatus> getEntries() {
        return b;
    }

    static {
        CodePreviewStatus r0 = new CodePreviewStatus("SUCCESS", 0);
        SUCCESS = r0;
        CodePreviewStatus r1 = new CodePreviewStatus("FAIL", 1);
        FAIL = r1;
        CodePreviewStatus r3 = new CodePreviewStatus("LOADING", 2);
        LOADING = r3;
        CodePreviewStatus[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static CodePreviewStatus[] values() {
        return (CodePreviewStatus[]) a.clone();
    }

    public static CodePreviewStatus valueOf(String r1) {
        return (CodePreviewStatus) r27.a.a(CodePreviewStatus.class, r1);
    }

    public CodePreviewStatus(String r1, int r2) {
        super(r1, r2);
    }
}
