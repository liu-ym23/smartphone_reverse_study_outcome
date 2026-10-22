package com.obric.memorydata.memory.ui.list;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/RecommendMemoryCategory;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", EventBody.KEY_CATEGORY, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getCategory", "()I", "UNKNOWN", "SHORT", "PORTRAIT", PendingMemoryCalendar.TYPE_TODO, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RecommendMemoryCategory extends Enum<RecommendMemoryCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RecommendMemoryCategory[] $VALUES = null;
    public static final RecommendMemoryCategory PORTRAIT = null;
    public static final RecommendMemoryCategory SHORT = null;
    public static final RecommendMemoryCategory TODO = null;
    public static final RecommendMemoryCategory UNKNOWN = null;
    private final int category;
    private final String text;

    private static final /* synthetic */ RecommendMemoryCategory[] $values() {
        return new RecommendMemoryCategory[]{UNKNOWN, SHORT, PORTRAIT, TODO};
    }

    static {
        UNKNOWN = new RecommendMemoryCategory("UNKNOWN", 0, "未知", -1);
        SHORT = new RecommendMemoryCategory("SHORT", 1, "记忆", 0);
        PORTRAIT = new RecommendMemoryCategory("PORTRAIT", 2, "画像", 1);
        TODO = new RecommendMemoryCategory(PendingMemoryCalendar.TYPE_TODO, 3, "日程安排", 2);
        RecommendMemoryCategory[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private RecommendMemoryCategory(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.text = r3;
        this.category = r4;
    }

    public static EnumEntries<RecommendMemoryCategory> getEntries() {
        return $ENTRIES;
    }

    public static RecommendMemoryCategory valueOf(String r2) {
        return (RecommendMemoryCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(RecommendMemoryCategory.class, r2), RecommendMemoryCategory.class, "com.obric.memorydata.plugin");
    }

    public static RecommendMemoryCategory[] values() {
        return (RecommendMemoryCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RecommendMemoryCategory[].class, "com.obric.memorydata.plugin");
    }

    public final int getCategory() {
        return this.category;
    }

    public final String getText() {
        return this.text;
    }
}
