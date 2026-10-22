package com.ss.android.lark.export.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/export/entity/Orientation;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "ROW", "COLUMN", "ROW_REVERSE", "COLUMN_REVERSE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Orientation extends Enum<Orientation> implements Serializable {
    public static final Orientation COLUMN = null;
    public static final Orientation COLUMN_REVERSE = null;
    public static final a Companion = null;
    public static final Orientation ROW = null;
    public static final Orientation ROW_REVERSE = null;
    public static final /* synthetic */ Orientation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Orientation a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L18;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L16;
            return Orientation.ROW;
        L16:
            return Orientation.COLUMN_REVERSE;
        L17:
            return Orientation.ROW_REVERSE;
        L18:
            return Orientation.COLUMN;
        L14:
            return Orientation.ROW;
        }
    }

    public static EnumEntries<Orientation> getEntries() {
        return b;
    }

    static {
        Orientation r0 = new Orientation("ROW", 0, 0);
        ROW = r0;
        Orientation r1 = new Orientation("COLUMN", 1, 1);
        COLUMN = r1;
        Orientation r3 = new Orientation("ROW_REVERSE", 2, 2);
        ROW_REVERSE = r3;
        Orientation r5 = new Orientation("COLUMN_REVERSE", 3, 3);
        COLUMN_REVERSE = r5;
        Orientation[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static Orientation[] values() {
        return (Orientation[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Orientation valueOf(String r1) {
        return (Orientation) r27.a.a(Orientation.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public Orientation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
