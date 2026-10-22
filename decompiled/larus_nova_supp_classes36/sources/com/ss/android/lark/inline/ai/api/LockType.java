package com.ss.android.lark.inline.ai.api;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/LockType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LOCK", "UNLOCK", "DEFAULT", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum LockType extends Enum<LockType> {
    public static final LockType DEFAULT = null;
    public static final LockType LOCK = null;
    public static final LockType UNLOCK = null;
    public static final /* synthetic */ LockType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<LockType> getEntries() {
        return b;
    }

    static {
        LockType r0 = new LockType("LOCK", 0, "lock");
        LOCK = r0;
        LockType r1 = new LockType("UNLOCK", 1, "unLock");
        UNLOCK = r1;
        LockType r2 = new LockType("DEFAULT", 2, LocationHitPoint$ResultType.DEFAULT);
        DEFAULT = r2;
        LockType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static LockType[] values() {
        return (LockType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LockType valueOf(String r1) {
        return (LockType) a.a(LockType.class, r1);
    }

    public LockType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
