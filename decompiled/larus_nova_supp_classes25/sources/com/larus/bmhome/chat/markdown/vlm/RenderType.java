package com.larus.bmhome.chat.markdown.vlm;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/markdown/vlm/RenderType;", "", "<init>", "(Ljava/lang/String;I)V", "Video", "Picture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType Picture = null;
    public static final RenderType Video = null;
    public static final /* synthetic */ RenderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RenderType> getEntries() {
        return b;
    }

    static {
        RenderType r0 = new RenderType("Video", 0);
        Video = r0;
        RenderType r1 = new RenderType("Picture", 1);
        Picture = r1;
        RenderType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static RenderType[] values() {
        return (RenderType[]) a.clone();
    }

    public static RenderType valueOf(String r1) {
        return (RenderType) a.a(RenderType.class, r1);
    }

    public RenderType(String r1, int r2) {
        super(r1, r2);
    }
}
