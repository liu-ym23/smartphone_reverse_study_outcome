package com.larus.dora.impl.onboarding.othersmart;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/AvatarUiState;", "", "<init>", "(Ljava/lang/String;I)V", "WAITING", "THINKING", "SPEAKING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvatarUiState extends Enum<AvatarUiState> {
    public static final AvatarUiState SPEAKING = null;
    public static final AvatarUiState THINKING = null;
    public static final AvatarUiState WAITING = null;
    public static final /* synthetic */ AvatarUiState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AvatarUiState> getEntries() {
        return b;
    }

    static {
        AvatarUiState r0 = new AvatarUiState("WAITING", 0);
        WAITING = r0;
        AvatarUiState r1 = new AvatarUiState("THINKING", 1);
        THINKING = r1;
        AvatarUiState r3 = new AvatarUiState("SPEAKING", 2);
        SPEAKING = r3;
        AvatarUiState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static AvatarUiState[] values() {
        return (AvatarUiState[]) a.clone();
    }

    public static AvatarUiState valueOf(String r1) {
        return (AvatarUiState) r27.a.a(AvatarUiState.class, r1);
    }

    public AvatarUiState(String r1, int r2) {
        super(r1, r2);
    }
}
