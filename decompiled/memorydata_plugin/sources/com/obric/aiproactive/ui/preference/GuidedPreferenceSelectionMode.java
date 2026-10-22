package com.obric.aiproactive.ui.preference;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceSelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "MULTIPLE", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum GuidedPreferenceSelectionMode extends Enum<GuidedPreferenceSelectionMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ GuidedPreferenceSelectionMode[] $VALUES = null;
    public static final GuidedPreferenceSelectionMode MULTIPLE = null;
    public static final GuidedPreferenceSelectionMode SINGLE = null;

    private static final /* synthetic */ GuidedPreferenceSelectionMode[] $values() {
        return new GuidedPreferenceSelectionMode[]{SINGLE, MULTIPLE};
    }

    static {
        SINGLE = new GuidedPreferenceSelectionMode("SINGLE", 0);
        MULTIPLE = new GuidedPreferenceSelectionMode("MULTIPLE", 1);
        GuidedPreferenceSelectionMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private GuidedPreferenceSelectionMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<GuidedPreferenceSelectionMode> getEntries() {
        return $ENTRIES;
    }

    public static GuidedPreferenceSelectionMode valueOf(String r2) {
        return (GuidedPreferenceSelectionMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(GuidedPreferenceSelectionMode.class, r2), GuidedPreferenceSelectionMode.class, "com.obric.memorydata.plugin");
    }

    public static GuidedPreferenceSelectionMode[] values() {
        return (GuidedPreferenceSelectionMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GuidedPreferenceSelectionMode[].class, "com.obric.memorydata.plugin");
    }
}
