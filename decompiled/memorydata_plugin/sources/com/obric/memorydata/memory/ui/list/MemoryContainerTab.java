package com.obric.memorydata.memory.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import com.obric.memorydata.memory.ui.automemory.AutoMemoryTaskFragment;
import com.obric.memorydata.memory.ui.list.contextawareness.ContextAwarenessTimelineFragment;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB;\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bj\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "", "textResId", "", "selectIconImageId", "pageKey", "pageOrder", "fragmentCreator", "Lkotlin/Function0;", "Landroidx/fragment/app/Fragment;", "<init>", "(Ljava/lang/String;IILjava/lang/Integer;IILkotlin/jvm/functions/Function0;)V", "getSelectIconImageId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageKey", "()I", "getPageOrder", "getFragmentCreator", "()Lkotlin/jvm/functions/Function0;", "GLOBAL_MEMORY", "PERSONAL_MEMORY", "CONTEXT_AWARENESS", "AUTO_MEMORY_TASK", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryContainerTab extends Enum<MemoryContainerTab> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryContainerTab[] $VALUES = null;
    public static final MemoryContainerTab AUTO_MEMORY_TASK = null;
    public static final MemoryContainerTab CONTEXT_AWARENESS = null;
    public static final a Companion = null;
    public static final MemoryContainerTab GLOBAL_MEMORY = null;
    public static final MemoryContainerTab PERSONAL_MEMORY = null;
    private final Function0<Fragment> fragmentCreator;
    private final int pageKey;
    private final int pageOrder;
    private final Integer selectIconImageId;
    private final int textResId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab$Companion;", "", "<init>", "()V", "fromPageKey", "Lcom/obric/memorydata/memory/ui/list/MemoryContainerTab;", "pageKey", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final MemoryContainerTab a(int r6) {
            MemoryContainerTab[] r5 = MemoryContainerTab.values();
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            MemoryContainerTab r3 = r5[r2];
            if (r3.getPageKey() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L15;
            r2 = r2 + 1;
            goto L3
        L15:
            return r3;
        L7:
            r4 = false;
            goto L8
        L11:
            return null;
        }
    }

    private static final /* synthetic */ MemoryContainerTab[] $values() {
        return new MemoryContainerTab[]{GLOBAL_MEMORY, PERSONAL_MEMORY, CONTEXT_AWARENESS, AUTO_MEMORY_TASK};
    }

    static {
        GLOBAL_MEMORY = new MemoryContainerTab("GLOBAL_MEMORY", 0, ZeusTransformUtils.mapRes(R.string.memory_tab_collect, TypedValues.Custom.S_STRING, "memory_tab_collect"), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.global_memory_tab_selected_icon, "drawable", "global_memory_tab_selected_icon")), 100, 0, $$Lambda$MemoryContainerTab$hC9ZdGGCjUX0Weg_lBfJRBf7toM.INSTANCE);
        PERSONAL_MEMORY = new MemoryContainerTab("PERSONAL_MEMORY", 1, ZeusTransformUtils.mapRes(R.string.memory_tab_profile, TypedValues.Custom.S_STRING, "memory_tab_profile"), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.personal_memory_tab_selected_icon, "drawable", "personal_memory_tab_selected_icon")), 200, 1, $$Lambda$MemoryContainerTab$8VTpyUMKI5ka8f60C1h2m9XszFI.INSTANCE);
        CONTEXT_AWARENESS = new MemoryContainerTab("CONTEXT_AWARENESS", 2, ZeusTransformUtils.mapRes(R.string.memory_tab_context_awareness, TypedValues.Custom.S_STRING, "memory_tab_context_awareness"), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_context_awareness_tab, "drawable", "ic_context_awareness_tab")), 600, 2, $$Lambda$MemoryContainerTab$ZYVzUlmMYnafuvdyFyY5fCWzkM.INSTANCE);
        AUTO_MEMORY_TASK = new MemoryContainerTab("AUTO_MEMORY_TASK", 3, ZeusTransformUtils.mapRes(R.string.memory_tab_task, TypedValues.Custom.S_STRING, "memory_tab_task"), Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.global_memory_collection_tab_selected_icon, "drawable", "global_memory_collection_tab_selected_icon")), 300, 3, $$Lambda$MemoryContainerTab$XDzqLayQl9aQJMKnkT13KJx_0.INSTANCE);
        MemoryContainerTab[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryContainerTab(String r3, int r4, int r5, Integer r6, int r7, int r8, Function0 r9) {
        Function0<Fragment> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r9, Function0.class, "com.obric.memorydata.plugin");
        super(r3, r4);
        this.textResId = r5;
        this.selectIconImageId = r6;
        this.pageKey = r7;
        this.pageOrder = r8;
        this.fragmentCreator = r10;
    }

    private static final Fragment _init_$lambda$0() {
        return (Fragment) ZeusTransformUtils.preCheckCast(new GlobalMemoryTabFragment(), Fragment.class, "com.obric.memorydata.plugin");
    }

    private static final Fragment _init_$lambda$1() {
        return (Fragment) ZeusTransformUtils.preCheckCast(PersonalTabFragment.Companion.b(), Fragment.class, "com.obric.memorydata.plugin");
    }

    private static final Fragment _init_$lambda$2() {
        return (Fragment) ZeusTransformUtils.preCheckCast(new ContextAwarenessTimelineFragment(), Fragment.class, "com.obric.memorydata.plugin");
    }

    private static final Fragment _init_$lambda$3() {
        return (Fragment) ZeusTransformUtils.preCheckCast(AutoMemoryTaskFragment.Companion.a(), Fragment.class, "com.obric.memorydata.plugin");
    }

    public static EnumEntries<MemoryContainerTab> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ Fragment lambda$8VTpyUMKI5ka8f60C1h2m9XszFI() {
        return _init_$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$XDz-qLayQl9aQJMKnkT13KJx_-0, reason: not valid java name */
    public static /* synthetic */ Fragment m883lambda$XDzqLayQl9aQJMKnkT13KJx_0() {
        return _init_$lambda$3();
    }

    /* JADX INFO: renamed from: lambda$ZYVzUlmMYnafuvdyF-yY5fCWzkM, reason: not valid java name */
    public static /* synthetic */ Fragment m884lambda$ZYVzUlmMYnafuvdyFyY5fCWzkM() {
        return _init_$lambda$2();
    }

    public static /* synthetic */ Fragment lambda$hC9ZdGGCjUX0Weg_lBfJRBf7toM() {
        return _init_$lambda$0();
    }

    public static MemoryContainerTab valueOf(String r2) {
        return (MemoryContainerTab) ZeusTransformUtils.preCheckCast(Enum.valueOf(MemoryContainerTab.class, r2), MemoryContainerTab.class, "com.obric.memorydata.plugin");
    }

    public static MemoryContainerTab[] values() {
        return (MemoryContainerTab[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MemoryContainerTab[].class, "com.obric.memorydata.plugin");
    }

    public final Function0<Fragment> getFragmentCreator() {
        return this.fragmentCreator;
    }

    public final int getPageKey() {
        return this.pageKey;
    }

    public final int getPageOrder() {
        return this.pageOrder;
    }

    public final Integer getSelectIconImageId() {
        return this.selectIconImageId;
    }

    public final String getText() {
        return com.obric.memorydata.utils.at.a(this.textResId);
    }
}
