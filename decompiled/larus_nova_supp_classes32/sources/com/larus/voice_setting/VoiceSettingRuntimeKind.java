package com.larus.voice_setting;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voice_setting/VoiceSettingRuntimeKind;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "NATIVE", "KMP", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceSettingRuntimeKind extends Enum<VoiceSettingRuntimeKind> {
    public static final VoiceSettingRuntimeKind KMP = null;
    public static final VoiceSettingRuntimeKind NATIVE = null;
    public static final /* synthetic */ VoiceSettingRuntimeKind[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<VoiceSettingRuntimeKind> getEntries() {
        return b;
    }

    static {
        VoiceSettingRuntimeKind r0 = new VoiceSettingRuntimeKind("NATIVE", 0);
        NATIVE = r0;
        VoiceSettingRuntimeKind r1 = new VoiceSettingRuntimeKind("KMP", 1);
        KMP = r1;
        VoiceSettingRuntimeKind[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static VoiceSettingRuntimeKind[] values() {
        return (VoiceSettingRuntimeKind[]) a.clone();
    }

    public static VoiceSettingRuntimeKind valueOf(String r1) {
        return (VoiceSettingRuntimeKind) a.a(VoiceSettingRuntimeKind.class, r1);
    }

    public VoiceSettingRuntimeKind(String r1, int r2) {
        super(r1, r2);
    }
}
