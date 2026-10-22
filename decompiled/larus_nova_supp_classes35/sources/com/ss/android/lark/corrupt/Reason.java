package com.ss.android.lark.corrupt;

import com.bytedance.lark.pb.basic.v1.PushDataCorruptResponse;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum Reason extends Enum<Reason> {
    public static final Reason DATABASE_CORRUPT = null;
    public static final /* synthetic */ Reason[] a = null;
    private int mValue;

    static {
        Reason r0 = new Reason();
        DATABASE_CORRUPT = r0;
        a = new Reason[]{r0};
    }

    public Reason() {
        super("DATABASE_CORRUPT", 0);
        this.mValue = 1;
    }

    public static Reason[] values() {
        return (Reason[]) a.clone();
    }

    public boolean isDbCorrupt() {
        if (this.mValue == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getValue() {
        return this.mValue;
    }

    public static Reason convert(PushDataCorruptResponse.Reason r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return fromValue(r0.getValue());
    }

    public static Reason fromValue(int r1) {
        if (r1 == 1) goto L7;
        return null;
    L7:
        return DATABASE_CORRUPT;
    }

    public static Reason valueOf(String r1) {
        return (Reason) a.a(Reason.class, r1);
    }

    public static Reason valueOf(int r0) {
        return fromValue(r0);
    }
}
