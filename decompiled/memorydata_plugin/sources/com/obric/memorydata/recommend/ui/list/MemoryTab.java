package com.obric.memorydata.recommend.ui.list;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", EventBody.KEY_CATEGORY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getCategory", "()I", "SHORT", "PORTRAIT", PendingMemoryCalendar.TYPE_TODO, "REALTIME_STATUS", "COMMON", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryTab extends Enum<MemoryTab> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryTab[] $VALUES = null;
    public static final MemoryTab COMMON = null;
    public static final a Companion = null;
    public static final MemoryTab PORTRAIT = null;
    public static final MemoryTab REALTIME_STATUS = null;
    public static final MemoryTab SHORT = null;
    public static final MemoryTab TODO = null;
    private final int category;
    private final String text;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/MemoryTab$Companion;", "", "<init>", "()V", "getByPosition", "Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "position", "", "getByMethod", "method", "getCount", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final int a() {
            return MemoryTab.values().length;
        }

        public final MemoryTab a(int r3) {
            MemoryTab r2 = (MemoryTab) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(MemoryTab.values(), r3), MemoryTab.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IllegalArgumentException("Invalid position: " + r3);
        }
    }

    private static final /* synthetic */ MemoryTab[] $values() {
        return new MemoryTab[]{SHORT, PORTRAIT, TODO, REALTIME_STATUS, COMMON};
    }

    static {
        SHORT = new MemoryTab("SHORT", 0, "记忆", 0);
        PORTRAIT = new MemoryTab("PORTRAIT", 1, "画像", 1);
        TODO = new MemoryTab(PendingMemoryCalendar.TYPE_TODO, 2, "日程安排", 2);
        REALTIME_STATUS = new MemoryTab("REALTIME_STATUS", 3, "实时状态", 5);
        COMMON = new MemoryTab("COMMON", 4, "常用信息", 6);
        MemoryTab[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryTab(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.text = r3;
        this.category = r4;
    }

    public static EnumEntries<MemoryTab> getEntries() {
        return $ENTRIES;
    }

    public static MemoryTab valueOf(String r2) {
        return (MemoryTab) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryTab.class, r2), MemoryTab.class, "com.obric.memorydata.plugin");
    }

    public static MemoryTab[] values() {
        return (MemoryTab[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryTab[].class, "com.obric.memorydata.plugin");
    }

    public final int getCategory() {
        return this.category;
    }

    public final String getText() {
        return this.text;
    }
}
