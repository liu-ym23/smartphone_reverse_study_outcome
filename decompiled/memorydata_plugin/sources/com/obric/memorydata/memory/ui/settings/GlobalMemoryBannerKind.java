package com.obric.memorydata.memory.ui.settings;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/GlobalMemoryBannerKind;", "", "titleRes", "", "defaultTipRes", "<init>", "(Ljava/lang/String;III)V", "getTitleRes", "()I", "ASSISTANT", "AUTO_MEMORY", "MEMORY_QA", "KEY_MEMORY", "tipRes", "supportVolumeKeyV2", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum GlobalMemoryBannerKind extends Enum<GlobalMemoryBannerKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GlobalMemoryBannerKind[] $VALUES = null;
    public static final GlobalMemoryBannerKind ASSISTANT = null;
    public static final GlobalMemoryBannerKind AUTO_MEMORY = null;
    public static final GlobalMemoryBannerKind KEY_MEMORY = null;
    public static final GlobalMemoryBannerKind MEMORY_QA = null;
    private final int defaultTipRes;
    private final int titleRes;

    private static final /* synthetic */ GlobalMemoryBannerKind[] $values() {
        return new GlobalMemoryBannerKind[]{ASSISTANT, AUTO_MEMORY, MEMORY_QA, KEY_MEMORY};
    }

    static {
        ASSISTANT = new GlobalMemoryBannerKind("ASSISTANT", 0, ZeusTransformUtils.mapRes(R.string.banner_global_memory_title_assistant_quick_note, TypedValues.Custom.S_STRING, "banner_global_memory_title_assistant_quick_note"), ZeusTransformUtils.mapRes(R.string.banner_global_memory_tip_1, TypedValues.Custom.S_STRING, "banner_global_memory_tip_1"));
        AUTO_MEMORY = new GlobalMemoryBannerKind("AUTO_MEMORY", 1, ZeusTransformUtils.mapRes(R.string.banner_global_memory_title_auto_memory, TypedValues.Custom.S_STRING, "banner_global_memory_title_auto_memory"), ZeusTransformUtils.mapRes(R.string.banner_global_memory_tip_2, TypedValues.Custom.S_STRING, "banner_global_memory_tip_2"));
        MEMORY_QA = new GlobalMemoryBannerKind("MEMORY_QA", 2, ZeusTransformUtils.mapRes(R.string.banner_global_memory_title_memory_qa, TypedValues.Custom.S_STRING, "banner_global_memory_title_memory_qa"), ZeusTransformUtils.mapRes(R.string.banner_global_memory_tip_4, TypedValues.Custom.S_STRING, "banner_global_memory_tip_4"));
        KEY_MEMORY = new GlobalMemoryBannerKind("KEY_MEMORY", 3, ZeusTransformUtils.mapRes(R.string.banner_global_memory_title_key_memory, TypedValues.Custom.S_STRING, "banner_global_memory_title_key_memory"), ZeusTransformUtils.mapRes(R.string.banner_global_memory_tip_3, TypedValues.Custom.S_STRING, "banner_global_memory_tip_3"));
        GlobalMemoryBannerKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private GlobalMemoryBannerKind(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.titleRes = r3;
        this.defaultTipRes = r4;
    }

    public static EnumEntries<GlobalMemoryBannerKind> getEntries() {
        return $ENTRIES;
    }

    public static GlobalMemoryBannerKind valueOf(String r2) {
        return (GlobalMemoryBannerKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(GlobalMemoryBannerKind.class, r2), GlobalMemoryBannerKind.class, "com.obric.memorydata.plugin");
    }

    public static GlobalMemoryBannerKind[] values() {
        return (GlobalMemoryBannerKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GlobalMemoryBannerKind[].class, "com.obric.memorydata.plugin");
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int tipRes(boolean r2) {
        if (this != KEY_MEMORY) goto L7;
        if (r2 == false) goto L7;
        return ZeusTransformUtils.mapRes(R.string.banner_global_memory_tip_3_v2, TypedValues.Custom.S_STRING, "banner_global_memory_tip_3_v2");
    L7:
        return this.defaultTipRes;
    }
}
