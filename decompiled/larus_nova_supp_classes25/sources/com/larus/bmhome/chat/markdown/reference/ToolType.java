package com.larus.bmhome.chat.markdown.reference;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/markdown/reference/ToolType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SearchPlugin", "ScholarSearch", "LinkReader", "SearchPoi", "RoutePlan", "ImageAnalysis", "SearchImage", "TextSearchImage", "CodeRunning", "Default", "None", "BrowserControl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final enum ToolType extends Enum<ToolType> {
    public static final ToolType BrowserControl = null;
    public static final ToolType CodeRunning = null;
    public static final a Companion = null;
    public static final ToolType Default = null;
    public static final ToolType ImageAnalysis = null;
    public static final ToolType LinkReader = null;
    public static final ToolType None = null;
    public static final ToolType RoutePlan = null;
    public static final ToolType ScholarSearch = null;
    public static final ToolType SearchImage = null;
    public static final ToolType SearchPlugin = null;
    public static final ToolType SearchPoi = null;
    public static final ToolType TextSearchImage = null;
    public static final /* synthetic */ ToolType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static ToolType a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "value");
            ToolType[] r0 = ToolType.values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            ToolType r3 = r0[r2];
            if (Intrinsics.areEqual(r3.getValue(), r5) == true) goto L9;
            r2 = r2 + 1;
        L9:
            if (r3 == null) goto L11;
            return r3;
        L11:
            return ToolType.SearchPlugin;
        L8:
            r3 = null;
            goto L9
        }
    }

    public static EnumEntries<ToolType> getEntries() {
        return b;
    }

    static {
        ToolType r0 = new ToolType("SearchPlugin", 0, "SearchPlugin");
        SearchPlugin = r0;
        ToolType r1 = new ToolType("ScholarSearch", 1, "ScholarSearch");
        ScholarSearch = r1;
        ToolType r3 = new ToolType("LinkReader", 2, "LinkReader");
        LinkReader = r3;
        ToolType r5 = new ToolType("SearchPoi", 3, "PoiSearch");
        SearchPoi = r5;
        ToolType r7 = new ToolType("RoutePlan", 4, "RoutePlan");
        RoutePlan = r7;
        ToolType r9 = new ToolType("ImageAnalysis", 5, "ZoomIn");
        ImageAnalysis = r9;
        ToolType r11 = new ToolType("SearchImage", 6, "SearchImage");
        SearchImage = r11;
        ToolType r13 = new ToolType("TextSearchImage", 7, "TextSearchImage");
        TextSearchImage = r13;
        ToolType r15 = new ToolType("CodeRunning", 8, "CodeRunning");
        CodeRunning = r15;
        ToolType r14 = new ToolType("Default", 9, "Default");
        Default = r14;
        ToolType r12 = new ToolType("None", 10, "None");
        None = r12;
        ToolType r10 = new ToolType("BrowserControl", 11, "BrowserControl");
        BrowserControl = r10;
        ToolType[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static ToolType[] values() {
        return (ToolType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ToolType valueOf(String r1) {
        return (ToolType) r27.a.a(ToolType.class, r1);
    }

    public ToolType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
