package com.larus.bmhome.chat.markdown.code;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/markdown/code/CodeRenderStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Success", "Failed", "Loading", "Placeholder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum CodeRenderStatus extends Enum<CodeRenderStatus> {
    public static final CodeRenderStatus Failed = null;
    public static final CodeRenderStatus Loading = null;
    public static final CodeRenderStatus Placeholder = null;
    public static final CodeRenderStatus Success = null;
    public static final /* synthetic */ CodeRenderStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CodeRenderStatus> getEntries() {
        return b;
    }

    static {
        CodeRenderStatus r0 = new CodeRenderStatus("Success", 0);
        Success = r0;
        CodeRenderStatus r1 = new CodeRenderStatus("Failed", 1);
        Failed = r1;
        CodeRenderStatus r3 = new CodeRenderStatus("Loading", 2);
        Loading = r3;
        CodeRenderStatus r5 = new CodeRenderStatus("Placeholder", 3);
        Placeholder = r5;
        CodeRenderStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static CodeRenderStatus[] values() {
        return (CodeRenderStatus[]) a.clone();
    }

    public static CodeRenderStatus valueOf(String r1) {
        return (CodeRenderStatus) r27.a.a(CodeRenderStatus.class, r1);
    }

    public CodeRenderStatus(String r1, int r2) {
        super(r1, r2);
    }
}
