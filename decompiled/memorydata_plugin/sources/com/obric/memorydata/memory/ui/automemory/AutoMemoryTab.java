package com.obric.memorydata.memory.ui.automemory;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "iconRes", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getIconRes", "()I", "AUTO", "DISCOVER", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AutoMemoryTab extends Enum<AutoMemoryTab> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AutoMemoryTab[] $VALUES = null;
    public static final AutoMemoryTab AUTO = null;
    public static final a Companion = null;
    public static final AutoMemoryTab DISCOVER = null;
    private final int iconRes;
    private final String text;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab$Companion;", "", "<init>", "()V", "fromIndex", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryTab;", "index", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AutoMemoryTab a(int r2) {
            return (AutoMemoryTab) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull(AutoMemoryTab.values(), r2), AutoMemoryTab.class, "com.obric.memorydata.plugin");
        }
    }

    private static final /* synthetic */ AutoMemoryTab[] $values() {
        return new AutoMemoryTab[]{AUTO, DISCOVER};
    }

    static {
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_task_my_tasks, TypedValues.Custom.S_STRING, "memory_task_my_tasks"));
        Intrinsics.checkNotNullExpressionValue(r1, "getString(...)");
        AUTO = new AutoMemoryTab("AUTO", 0, r1, ZeusTransformUtils.mapRes(R.drawable.global_memory_tab_selected_icon, "drawable", "global_memory_tab_selected_icon"));
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_discover, TypedValues.Custom.S_STRING, "memory_discover"));
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        DISCOVER = new AutoMemoryTab("DISCOVER", 1, r2, ZeusTransformUtils.mapRes(R.drawable.global_memory_collection_tab_selected_icon, "drawable", "global_memory_collection_tab_selected_icon"));
        AutoMemoryTab[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private AutoMemoryTab(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.text = r3;
        this.iconRes = r4;
    }

    public static EnumEntries<AutoMemoryTab> getEntries() {
        return $ENTRIES;
    }

    public static AutoMemoryTab valueOf(String r2) {
        return (AutoMemoryTab) ZeusTransformUtils.preCheckCast(Enum.valueOf(AutoMemoryTab.class, r2), AutoMemoryTab.class, "com.obric.memorydata.plugin");
    }

    public static AutoMemoryTab[] values() {
        return (AutoMemoryTab[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AutoMemoryTab[].class, "com.obric.memorydata.plugin");
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getText() {
        return this.text;
    }
}
