package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Shield;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ALL", "NORMAL", "SHIELD", "toString", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum Condition$Shield extends Enum<Condition$Shield> implements Serializable {
    public static final Condition$Shield ALL = null;
    public static final a Companion = null;
    public static final Condition$Shield NORMAL = null;
    public static final int OFFSET = 8;
    public static final Condition$Shield SHIELD = null;
    public static final /* synthetic */ Condition$Shield[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<Condition$Shield> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Shield$a] */
    static {
        Condition$Shield r0 = new Condition$Shield("ALL", 0, 0);
        ALL = r0;
        Condition$Shield r1 = new Condition$Shield("NORMAL", 1, 1);
        NORMAL = r1;
        Condition$Shield r3 = new Condition$Shield("SHIELD", 2, 2);
        SHIELD = r3;
        Condition$Shield[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static Condition$Shield[] values() {
        return (Condition$Shield[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r0 = this.value;
        if (r0 != 0) goto L5;
        return "ALL";
    L5:
        if (r0 != 1) goto L7;
        return "NORMAL";
    L7:
        if (r0 == 2) goto L9;
        return "null";
    L9:
        return "SHIELD";
    }

    public final int getValue() {
        return this.value;
    }

    public static Condition$Shield valueOf(String r1) {
        return (Condition$Shield) r27.a.a(Condition$Shield.class, r1);
    }

    public Condition$Shield(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
