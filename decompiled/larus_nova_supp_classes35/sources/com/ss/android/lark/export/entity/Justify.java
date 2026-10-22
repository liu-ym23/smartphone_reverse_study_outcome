package com.ss.android.lark.export.entity;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/export/entity/Justify;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "START", "CENTER", "END", "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Justify extends Enum<Justify> implements Serializable {
    public static final Justify CENTER = null;
    public static final a Companion = null;
    public static final Justify END = null;
    public static final Justify SPACE_AROUND = null;
    public static final Justify SPACE_BETWEEN = null;
    public static final Justify SPACE_EVENLY = null;
    public static final Justify START = null;
    public static final /* synthetic */ Justify[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Justify a(int r1) {
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L26;
            if (r1 == 2) goto L25;
            if (r1 == 3) goto L24;
            if (r1 == 4) goto L23;
            if (r1 == 5) goto L22;
            return Justify.START;
        L22:
            return Justify.SPACE_EVENLY;
        L23:
            return Justify.SPACE_AROUND;
        L24:
            return Justify.SPACE_BETWEEN;
        L25:
            return Justify.END;
        L26:
            return Justify.CENTER;
        L20:
            return Justify.START;
        }
    }

    public static EnumEntries<Justify> getEntries() {
        return b;
    }

    static {
        Justify r0 = new Justify("START", 0, 0);
        START = r0;
        Justify r1 = new Justify("CENTER", 1, 1);
        CENTER = r1;
        Justify r3 = new Justify("END", 2, 2);
        END = r3;
        Justify r5 = new Justify("SPACE_BETWEEN", 3, 3);
        SPACE_BETWEEN = r5;
        Justify r7 = new Justify("SPACE_AROUND", 4, 4);
        SPACE_AROUND = r7;
        Justify r9 = new Justify("SPACE_EVENLY", 5, 5);
        SPACE_EVENLY = r9;
        Justify[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static Justify[] values() {
        return (Justify[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Justify valueOf(String r1) {
        return (Justify) r27.a.a(Justify.class, r1);
    }

    public final void setValue(int r1) {
        this.value = r1;
    }

    public Justify(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
