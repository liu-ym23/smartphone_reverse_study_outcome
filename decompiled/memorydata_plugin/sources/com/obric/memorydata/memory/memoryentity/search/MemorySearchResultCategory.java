package com.obric.memorydata.memory.memoryentity.search;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.d;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.model.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "FAVORITE", "PERSONAL", "AUTO_MEMORY_TASK", "CONTEXT_AWARENESS", "SCREEN", "AUDIO", "UNKNOWN", "acceptsCategory", "", "resultCategory", "accepts", "result", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResult;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemorySearchResultCategory extends Enum<MemorySearchResultCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemorySearchResultCategory[] $VALUES = null;
    public static final MemorySearchResultCategory ALL = null;
    public static final MemorySearchResultCategory AUDIO = null;
    public static final MemorySearchResultCategory AUTO_MEMORY_TASK = null;
    public static final MemorySearchResultCategory CONTEXT_AWARENESS = null;
    public static final a Companion = null;
    public static final MemorySearchResultCategory FAVORITE = null;
    public static final MemorySearchResultCategory PERSONAL = null;
    public static final MemorySearchResultCategory SCREEN = null;
    public static final MemorySearchResultCategory UNKNOWN = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory$Companion;", "", "<init>", "()V", "defaultSearchTabs", "", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "fromExtraDataValue", EventBody.KEY_VALUE, "", "fromEntity", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemorySearchResultCategory a(d r5) {
            Intrinsics.checkNotNullParameter(r5, "entity");
            if (ZeusTransformUtils.instanceOf(r5, AutoMemoryProEntity.class) == false) goto L6;
            return MemorySearchResultCategory.AUTO_MEMORY_TASK;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, fj.class) == false) goto L9;
            return MemorySearchResultCategory.AUDIO;
        L9:
            if (ZeusTransformUtils.instanceOf(r5, RawMemoryEntity.class) == false) goto L21;
            if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r5, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType() != (-303)) goto L16;
            if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r5, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType() != 1003) goto L16;
        L39:
            return MemorySearchResultCategory.FAVORITE;
        L16:
            if (((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r5, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getType() != (-303)) goto L36;
            if (e.f9611a.a(((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r5, RawMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType()) == false) goto L36;
        L40:
            return MemorySearchResultCategory.SCREEN;
        L36:
            return MemorySearchResultCategory.UNKNOWN;
        L21:
            if (ZeusTransformUtils.instanceOf(r5, EpisodicMemoryEntity.class) == false) goto L33;
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType() != (-306)) goto L28;
            if (e.f9611a.a(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType()) == true) goto L40;
        L28:
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getType() != (-306)) goto L36;
            if (((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r5, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getProductType() != 1003) goto L36;
        L33:
            if (r5.getType() != (-401)) goto L36;
            return MemorySearchResultCategory.PERSONAL;
        }

        public final MemorySearchResultCategory a(String r1) {
            Intrinsics.checkNotNullParameter(r1, EventBody.KEY_VALUE);
            switch(r1.hashCode()) {
                case -907689876: goto L25;
                case 93166550: goto L21;
                case 330417957: goto L17;
                case 443164224: goto L13;
                case 1050790300: goto L10;
                case 2086229875: goto L6;
                default: goto L28;
            };
        L28:
            return null;
        L6:
            if (r1.equals("auto_memory_task") == false) goto L28;
            return MemorySearchResultCategory.AUTO_MEMORY_TASK;
        L10:
            if (r1.equals("favorite") == false) goto L28;
            return MemorySearchResultCategory.FAVORITE;
        L13:
            if (r1.equals("personal") == false) goto L28;
            return MemorySearchResultCategory.PERSONAL;
        L17:
            if (r1.equals("context_awareness") == false) goto L28;
            return MemorySearchResultCategory.CONTEXT_AWARENESS;
        L21:
            if (r1.equals("audio") == false) goto L28;
            return MemorySearchResultCategory.AUDIO;
        L25:
            if (r1.equals("screen") == false) goto L28;
            return MemorySearchResultCategory.SCREEN;
        }

        public final List<MemorySearchResultCategory> a() {
            return CollectionsKt.listOf(new MemorySearchResultCategory[]{MemorySearchResultCategory.FAVORITE, MemorySearchResultCategory.PERSONAL, MemorySearchResultCategory.AUTO_MEMORY_TASK, MemorySearchResultCategory.CONTEXT_AWARENESS});
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10325a = null;

        static {
            int[] r0 = new int[MemorySearchResultCategory.values().length];
            r0[MemorySearchResultCategory.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MemorySearchResultCategory.CONTEXT_AWARENESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f10325a = r0;
        }
    }

    private static final /* synthetic */ MemorySearchResultCategory[] $values() {
        return new MemorySearchResultCategory[]{ALL, FAVORITE, PERSONAL, AUTO_MEMORY_TASK, CONTEXT_AWARENESS, SCREEN, AUDIO, UNKNOWN};
    }

    static {
        ALL = new MemorySearchResultCategory("ALL", 0);
        FAVORITE = new MemorySearchResultCategory("FAVORITE", 1);
        PERSONAL = new MemorySearchResultCategory("PERSONAL", 2);
        AUTO_MEMORY_TASK = new MemorySearchResultCategory("AUTO_MEMORY_TASK", 3);
        CONTEXT_AWARENESS = new MemorySearchResultCategory("CONTEXT_AWARENESS", 4);
        SCREEN = new MemorySearchResultCategory("SCREEN", 5);
        AUDIO = new MemorySearchResultCategory("AUDIO", 6);
        UNKNOWN = new MemorySearchResultCategory("UNKNOWN", 7);
        MemorySearchResultCategory[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemorySearchResultCategory(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<MemorySearchResultCategory> getEntries() {
        return $ENTRIES;
    }

    public static MemorySearchResultCategory valueOf(String r2) {
        return (MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemorySearchResultCategory.class, r2), MemorySearchResultCategory.class, "com.obric.memorydata.plugin");
    }

    public static MemorySearchResultCategory[] values() {
        return (MemorySearchResultCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemorySearchResultCategory[].class, "com.obric.memorydata.plugin");
    }

    public final boolean accepts(c r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        return acceptsCategory(r2.b());
    }

    public final boolean acceptsCategory(MemorySearchResultCategory r5) {
        Intrinsics.checkNotNullParameter(r5, "resultCategory");
        int r0 = b.f10325a[ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L9;
        if (r5 == this) goto L15;
        return false;
    L9:
        if (r5 == CONTEXT_AWARENESS) goto L15;
        if (r5 == SCREEN) goto L15;
        if (r5 == AUDIO) goto L15;
        return false;
    L15:
        return true;
    }
}
