package com.obric.memorydata.memory.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "", "textResId", "", "<init>", "(Ljava/lang/String;II)V", "COLLECT", "PROFILE", "OBSERVATION", "AUDIO", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "getText", "()Ljava/lang/String;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MemoryTab extends Enum<MemoryTab> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MemoryTab[] $VALUES = null;
    public static final MemoryTab AUDIO = null;
    public static final MemoryTab COLLECT = null;
    public static final a Companion = null;
    public static final MemoryTab OBSERVATION = null;
    public static final MemoryTab PROFILE = null;
    private final int textResId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemoryTab$Companion;", "", "<init>", "()V", "getByPosition", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "position", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
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
        return new MemoryTab[]{COLLECT, PROFILE, OBSERVATION, AUDIO};
    }

    static {
        COLLECT = new MemoryTab("COLLECT", 0, ZeusTransformUtils.mapRes(R.string.memory_tab_collect, TypedValues.Custom.S_STRING, "memory_tab_collect"));
        PROFILE = new MemoryTab("PROFILE", 1, ZeusTransformUtils.mapRes(R.string.memory_tab_profile, TypedValues.Custom.S_STRING, "memory_tab_profile"));
        OBSERVATION = new MemoryTab("OBSERVATION", 2, ZeusTransformUtils.mapRes(R.string.memory_tab_observation, TypedValues.Custom.S_STRING, "memory_tab_observation"));
        AUDIO = new MemoryTab("AUDIO", 3, ZeusTransformUtils.mapRes(R.string.memory_tab_audio, TypedValues.Custom.S_STRING, "memory_tab_audio"));
        MemoryTab[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private MemoryTab(String r1, int r2, int r3) {
        super(r1, r2);
        this.textResId = r3;
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

    public final String getText() {
        return com.obric.memorydata.utils.at.a(this.textResId);
    }
}
