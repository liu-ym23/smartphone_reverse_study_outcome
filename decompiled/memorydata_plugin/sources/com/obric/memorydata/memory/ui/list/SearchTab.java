package com.obric.memorydata.memory.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.memoryentity.search.MemorySearchResultCategory;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchTab;", "", "titleRes", "", EventBody.KEY_CATEGORY, "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "<init>", "(Ljava/lang/String;IILcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;)V", "getTitleRes", "()I", "getCategory", "()Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "FAVORITE", "PERSONAL", "AUTO_MEMORY_TASK", "CONTEXT_AWARENESS", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final enum SearchTab extends Enum<SearchTab> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SearchTab[] $VALUES = null;
    public static final SearchTab AUTO_MEMORY_TASK = null;
    public static final SearchTab CONTEXT_AWARENESS = null;
    public static final a Companion = null;
    public static final SearchTab FAVORITE = null;
    public static final SearchTab PERSONAL = null;
    private final MemorySearchResultCategory category;
    private final int titleRes;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/SearchTab$Companion;", "", "<init>", "()V", "fromCategories", "", "Lcom/obric/memorydata/memory/ui/list/SearchTab;", "categories", "Lcom/obric/memorydata/memory/memoryentity/search/MemorySearchResultCategory;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final List<SearchTab> a(List<? extends MemorySearchResultCategory> r7) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "categories");
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r10 = r8.iterator();
        L3:
            int r2 = 0;
            if (r10.hasNext() == false) goto L10;
            Object r1 = r10.next();
            if (((MemorySearchResultCategory) ZeusTransformUtils.preCheckCast(r1, MemorySearchResultCategory.class, "com.obric.memorydata.plugin")) != MemorySearchResultCategory.ALL) goto L8;
            r2 = 1;
        L8:
            if (r2 != 0) goto L3;
            r9.add(r1);
            goto L3
        L10:
            Set r11 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
            SearchTab[] r12 = SearchTab.values();
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            int r4 = r12.length;
        L11:
            if (r2 >= r4) goto L17;
            SearchTab r5 = r12[r2];
            if (r11.contains(r5.getCategory()) == false) goto L15;
            r3.add(r5);
        L15:
            r2 = r2 + 1;
            goto L11
        L17:
            return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ SearchTab[] $values() {
        return new SearchTab[]{FAVORITE, PERSONAL, AUTO_MEMORY_TASK, CONTEXT_AWARENESS};
    }

    static {
        FAVORITE = new SearchTab("FAVORITE", 0, ZeusTransformUtils.mapRes(R.string.memory_search_tab_favorite, TypedValues.Custom.S_STRING, "memory_search_tab_favorite"), MemorySearchResultCategory.FAVORITE);
        PERSONAL = new SearchTab("PERSONAL", 1, ZeusTransformUtils.mapRes(R.string.memory_search_tab_personal, TypedValues.Custom.S_STRING, "memory_search_tab_personal"), MemorySearchResultCategory.PERSONAL);
        AUTO_MEMORY_TASK = new SearchTab("AUTO_MEMORY_TASK", 2, ZeusTransformUtils.mapRes(R.string.memory_search_tab_task, TypedValues.Custom.S_STRING, "memory_search_tab_task"), MemorySearchResultCategory.AUTO_MEMORY_TASK);
        CONTEXT_AWARENESS = new SearchTab("CONTEXT_AWARENESS", 3, ZeusTransformUtils.mapRes(R.string.memory_search_tab_context_awareness, TypedValues.Custom.S_STRING, "memory_search_tab_context_awareness"), MemorySearchResultCategory.CONTEXT_AWARENESS);
        SearchTab[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private SearchTab(String r1, int r2, int r3, MemorySearchResultCategory r4) {
        super(r1, r2);
        this.titleRes = r3;
        this.category = r4;
    }

    public static EnumEntries<SearchTab> getEntries() {
        return $ENTRIES;
    }

    public static SearchTab valueOf(String r2) {
        return (SearchTab) ZeusTransformUtils.preCheckCast(Enum.valueOf(SearchTab.class, r2), SearchTab.class, "com.obric.memorydata.plugin");
    }

    public static SearchTab[] values() {
        return (SearchTab[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SearchTab[].class, "com.obric.memorydata.plugin");
    }

    public final MemorySearchResultCategory getCategory() {
        return this.category;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
