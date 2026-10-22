package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$UserType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ALL", "SELF", "OTHERS", "toString", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum Condition$UserType extends Enum<Condition$UserType> implements Serializable {
    public static final Condition$UserType ALL = null;
    public static final a Companion = null;
    public static final int OFFSET = 2;
    public static final Condition$UserType OTHERS = null;
    public static final Condition$UserType SELF = null;
    public static final /* synthetic */ Condition$UserType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Condition$UserType> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$UserType$a] */
    static {
        Condition$UserType r0 = new Condition$UserType("ALL", 0, 0);
        ALL = r0;
        Condition$UserType r1 = new Condition$UserType("SELF", 1, 1);
        SELF = r1;
        Condition$UserType r3 = new Condition$UserType("OTHERS", 2, 2);
        OTHERS = r3;
        Condition$UserType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static Condition$UserType[] values() {
        return (Condition$UserType[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL";
    L5:
        if (r0 != 1) goto L7;
        return "SELF";
    L7:
        if (r0 == 2) goto L9;
        return "null";
    L9:
        return "OTHERS";
    }

    public final int getValue() {
        return this.value;
    }

    public static Condition$UserType valueOf(String r1) {
        return (Condition$UserType) r27.a.a(Condition$UserType.class, r1);
    }

    public Condition$UserType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
