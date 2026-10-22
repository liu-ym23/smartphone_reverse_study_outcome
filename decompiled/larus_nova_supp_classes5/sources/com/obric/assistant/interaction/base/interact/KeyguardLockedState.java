package com.obric.assistant.interaction.base.interact;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "Lcom/obric/assistant/interaction/base/interact/IStatable;", "", "<init>", "(Ljava/lang/String;I)V", "UNLOCKED", "LOCKED", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum KeyguardLockedState extends Enum<KeyguardLockedState> implements IStatable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ KeyguardLockedState[] $VALUES = null;
    public static final KeyguardLockedState LOCKED = null;
    public static final KeyguardLockedState UNLOCKED = null;

    private static final /* synthetic */ KeyguardLockedState[] $values() {
        return new KeyguardLockedState[]{UNLOCKED, LOCKED};
    }

    public static EnumEntries<KeyguardLockedState> getEntries() {
        return $ENTRIES;
    }

    static {
        UNLOCKED = new KeyguardLockedState("UNLOCKED", 0);
        LOCKED = new KeyguardLockedState("LOCKED", 1);
        KeyguardLockedState[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static KeyguardLockedState[] values() {
        return (KeyguardLockedState[]) $VALUES.clone();
    }

    public static KeyguardLockedState valueOf(String r1) {
        return (KeyguardLockedState) a.a(KeyguardLockedState.class, r1);
    }

    private KeyguardLockedState(String r1, int r2) {
        super(r1, r2);
    }
}
