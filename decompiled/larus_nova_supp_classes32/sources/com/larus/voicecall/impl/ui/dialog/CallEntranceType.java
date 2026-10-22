package com.larus.voicecall.impl.ui.dialog;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/impl/ui/dialog/CallEntranceType;", NameKeys.UnloadStrategy_No_Strategy, "type", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "VIDEO", "CALL", "SHARE_SCREEN", "CALL_SCENE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CallEntranceType extends Enum<CallEntranceType> {
    public static final CallEntranceType CALL = null;
    public static final CallEntranceType CALL_SCENE = null;
    public static final CallEntranceType SHARE_SCREEN = null;
    public static final CallEntranceType VIDEO = null;
    public static final /* synthetic */ CallEntranceType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int type;

    public static EnumEntries<CallEntranceType> getEntries() {
        return b;
    }

    static {
        CallEntranceType r0 = new CallEntranceType("VIDEO", 0, 1);
        VIDEO = r0;
        CallEntranceType r1 = new CallEntranceType("CALL", 1, 2);
        CALL = r1;
        CallEntranceType r4 = new CallEntranceType("SHARE_SCREEN", 2, 3);
        SHARE_SCREEN = r4;
        CallEntranceType r6 = new CallEntranceType("CALL_SCENE", 3, 4);
        CALL_SCENE = r6;
        CallEntranceType[] r8 = {r0, r1, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static CallEntranceType[] values() {
        return (CallEntranceType[]) a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static CallEntranceType valueOf(String r1) {
        return (CallEntranceType) a.a(CallEntranceType.class, r1);
    }

    public CallEntranceType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
