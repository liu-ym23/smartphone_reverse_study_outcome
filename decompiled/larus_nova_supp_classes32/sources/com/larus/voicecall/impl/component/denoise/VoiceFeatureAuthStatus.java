package com.larus.voicecall.impl.component.denoise;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/voicecall/impl/component/denoise/VoiceFeatureAuthStatus;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "desc", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getValue", "()I", "getDesc", "()Ljava/lang/String;", "AUTHORIZED", "UNAUTHORIZED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceFeatureAuthStatus extends Enum<VoiceFeatureAuthStatus> {
    public static final VoiceFeatureAuthStatus AUTHORIZED = null;
    public static final VoiceFeatureAuthStatus UNAUTHORIZED = null;
    public static final /* synthetic */ VoiceFeatureAuthStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String desc;
    private final int value;

    public static EnumEntries<VoiceFeatureAuthStatus> getEntries() {
        return b;
    }

    static {
        VoiceFeatureAuthStatus r0 = new VoiceFeatureAuthStatus("AUTHORIZED", 0, 1, "AUTHORIZED");
        AUTHORIZED = r0;
        VoiceFeatureAuthStatus r1 = new VoiceFeatureAuthStatus("UNAUTHORIZED", 1, 2, "UNAUTHORIZED");
        UNAUTHORIZED = r1;
        VoiceFeatureAuthStatus[] r4 = {r0, r1};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static VoiceFeatureAuthStatus[] values() {
        return (VoiceFeatureAuthStatus[]) a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getValue() {
        return this.value;
    }

    public static VoiceFeatureAuthStatus valueOf(String r1) {
        return (VoiceFeatureAuthStatus) r27.a.a(VoiceFeatureAuthStatus.class, r1);
    }

    public VoiceFeatureAuthStatus(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.value = r3;
        this.desc = r4;
    }
}
