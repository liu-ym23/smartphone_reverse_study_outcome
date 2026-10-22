package com.larus.bmhome.chat.standarduikit.richmedia.view;

import com.larus.bmhome.instruction.handler.InstructionHandlerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/view/RichMediaKind;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", InstructionHandlerType.VIDEO, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RichMediaKind extends Enum<RichMediaKind> {
    public static final RichMediaKind IMAGE = null;
    public static final RichMediaKind VIDEO = null;
    public static final /* synthetic */ RichMediaKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RichMediaKind> getEntries() {
        return b;
    }

    static {
        RichMediaKind r0 = new RichMediaKind("IMAGE", 0);
        IMAGE = r0;
        RichMediaKind r1 = new RichMediaKind(InstructionHandlerType.VIDEO, 1);
        VIDEO = r1;
        RichMediaKind[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RichMediaKind[] values() {
        return (RichMediaKind[]) a.clone();
    }

    public static RichMediaKind valueOf(String r1) {
        return (RichMediaKind) a.a(RichMediaKind.class, r1);
    }

    public RichMediaKind(String r1, int r2) {
        super(r1, r2);
    }
}
