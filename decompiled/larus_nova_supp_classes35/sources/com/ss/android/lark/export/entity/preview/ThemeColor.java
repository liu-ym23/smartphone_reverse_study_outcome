package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.chameleon.util.AppInfoUtils;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0006\u0010\u0016\u001a\u00020\u0000J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J0\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "Ljava/io/Serializable;", "token", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "key", "Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;)V", "getToken", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKey", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "clone", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;)Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "toString", "Key", "KeyType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeColor implements Serializable {
    private final Key key;
    private final String token;
    private final Integer value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0006\u0010\u0015\u001a\u00020\u0000J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J0\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "Ljava/io/Serializable;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;", "value", BuildConfig.FLAVOR, AppInfoUtils.VERSION_TYPE.VERSION_ALPHA, "<init>", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;Ljava/lang/Integer;I)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAlpha", "()I", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "clone", "component1", "component2", "component3", "copy", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;Ljava/lang/Integer;I)Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Serializable {
        private final int alpha;
        private final KeyType type;
        private final Integer value;

        public Key() {
            this(null, null, 0, 7, null);
        }

        public static /* synthetic */ Key copy$default(Key r0, KeyType r1, Integer r2, int r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.value;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.alpha;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final KeyType component1() {
            return this.type;
        }

        public final Integer component2() {
            return this.value;
        }

        public final int component3() {
            return this.alpha;
        }

        public final Key copy(KeyType r2, Integer r3, int r4) {
            return new Key(r2, r3, r4);
        }

        public String toString() {
            return "Key(type=" + this.type + ", value=" + this.value + ", alpha=" + this.alpha + ')';
        }

        public final Key clone() {
            return new Key(this.type, this.value, this.alpha);
        }

        public int hashCode() {
            KeyType r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.value;
            if (r4 == null) goto L10;
            r1 = r4.intValue();
        L10:
            return ((r3 + r1) * 31) + this.alpha;
        L5:
            r2 = 0;
            goto L6
        }

        public final int getAlpha() {
            return this.alpha;
        }

        public final KeyType getType() {
            return this.type;
        }

        public final Integer getValue() {
            return this.value;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Key) == true) goto L8;
            return false;
        L8:
            Key r6 = (Key) r5;
            if (this.type == r6.type) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.value, r6.value) == true) goto L15;
            return false;
        L15:
            if (this.alpha == r6.alpha) goto L17;
            return false;
        L17:
            return true;
        }

        public Key(KeyType r1, Integer r2, int r3) {
            this.type = r1;
            this.value = r2;
            this.alpha = r3;
        }

        public /* synthetic */ Key(KeyType r2, Integer r3, int r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 100;
        L11:
            this(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "N", "B", "W", "T", "G", "L", "Y", "S", "O", "R", "C", "V", "P", "I", "STATIC_WHITE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KeyType extends Enum<KeyType> {
        public static final KeyType B = null;
        public static final KeyType C = null;
        public static final a Companion = null;
        public static final KeyType G = null;
        public static final KeyType I = null;
        public static final KeyType L = null;
        public static final KeyType N = null;
        public static final KeyType O = null;
        public static final KeyType P = null;
        public static final KeyType R = null;
        public static final KeyType S = null;
        public static final KeyType STATIC_WHITE = null;
        public static final KeyType T = null;
        public static final KeyType V = null;
        public static final KeyType W = null;
        public static final KeyType Y = null;
        public static final /* synthetic */ KeyType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static KeyType a(Integer r2) {
                if (r2 != null) goto L5;
            L7:
                if (r2 != null) goto L10;
            L12:
                if (r2 != null) goto L15;
            L17:
                if (r2 != null) goto L20;
            L22:
                if (r2 != null) goto L25;
            L27:
                if (r2 != null) goto L30;
            L32:
                if (r2 != null) goto L35;
            L37:
                if (r2 != null) goto L40;
            L42:
                if (r2 != null) goto L45;
            L47:
                if (r2 != null) goto L50;
            L52:
                if (r2 != null) goto L55;
            L57:
                if (r2 != null) goto L60;
            L62:
                if (r2 != null) goto L65;
            L67:
                if (r2 != null) goto L70;
            L72:
                if (r2 != null) goto L75;
            L77:
                return null;
            L75:
                if (r2.intValue() != 14) goto L77;
                return KeyType.STATIC_WHITE;
            L70:
                if (r2.intValue() != 13) goto L72;
                return KeyType.I;
            L65:
                if (r2.intValue() != 12) goto L67;
                return KeyType.P;
            L60:
                if (r2.intValue() != 11) goto L62;
                return KeyType.V;
            L55:
                if (r2.intValue() != 10) goto L57;
                return KeyType.C;
            L50:
                if (r2.intValue() != 9) goto L52;
                return KeyType.R;
            L45:
                if (r2.intValue() != 8) goto L47;
                return KeyType.O;
            L40:
                if (r2.intValue() != 7) goto L42;
                return KeyType.S;
            L35:
                if (r2.intValue() != 6) goto L37;
                return KeyType.Y;
            L30:
                if (r2.intValue() != 5) goto L32;
                return KeyType.L;
            L25:
                if (r2.intValue() != 4) goto L27;
                return KeyType.G;
            L20:
                if (r2.intValue() != 3) goto L22;
                return KeyType.T;
            L15:
                if (r2.intValue() != 2) goto L17;
                return KeyType.W;
            L10:
                if (r2.intValue() != 1) goto L12;
                return KeyType.B;
            L5:
                if (r2.intValue() != 0) goto L7;
                return KeyType.N;
            }
        }

        public static EnumEntries<KeyType> getEntries() {
            return b;
        }

        static {
            KeyType r0 = new KeyType("N", 0, 0);
            N = r0;
            KeyType r1 = new KeyType("B", 1, 1);
            B = r1;
            KeyType r3 = new KeyType("W", 2, 2);
            W = r3;
            KeyType r5 = new KeyType("T", 3, 3);
            T = r5;
            KeyType r7 = new KeyType("G", 4, 4);
            G = r7;
            KeyType r9 = new KeyType("L", 5, 5);
            L = r9;
            KeyType r11 = new KeyType("Y", 6, 6);
            Y = r11;
            KeyType r13 = new KeyType("S", 7, 7);
            S = r13;
            KeyType r15 = new KeyType("O", 8, 8);
            O = r15;
            KeyType r14 = new KeyType("R", 9, 9);
            R = r14;
            KeyType r12 = new KeyType("C", 10, 10);
            C = r12;
            KeyType r10 = new KeyType("V", 11, 11);
            V = r10;
            KeyType r8 = new KeyType("P", 12, 12);
            P = r8;
            KeyType r6 = new KeyType("I", 13, 13);
            I = r6;
            KeyType r4 = new KeyType("STATIC_WHITE", 14, 14);
            STATIC_WHITE = r4;
            KeyType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
            Companion = new a();
        }

        public static KeyType[] values() {
            return (KeyType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static KeyType valueOf(String r1) {
            return (KeyType) r27.a.a(KeyType.class, r1);
        }

        public KeyType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public ThemeColor() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ThemeColor copy$default(ThemeColor r0, String r1, Integer r2, Key r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.value;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.key;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.token;
    }

    public final Integer component2() {
        return this.value;
    }

    public final Key component3() {
        return this.key;
    }

    public final ThemeColor copy(String r2, Integer r3, Key r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        return new ThemeColor(r2, r3, r4);
    }

    public String toString() {
        return "ThemeColor(token=" + this.token + ", value=" + this.value + ", key=" + this.key + ')';
    }

    public final ThemeColor clone() {
        return new ThemeColor(this.token, this.value, this.key);
    }

    public int hashCode() {
        String r0 = this.token;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.value;
        if (r4 == null) goto L10;
        r1 = r4.intValue();
    L10:
        return ((r3 + r1) * 31) + this.key.hashCode();
    L5:
        r2 = 0;
        goto L6
    }

    public final Key getKey() {
        return this.key;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getValue() {
        return this.value;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ThemeColor) == true) goto L8;
        return false;
    L8:
        ThemeColor r6 = (ThemeColor) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r6.value) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public ThemeColor(String r2, Integer r3, Key r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        this.token = r2;
        this.value = r3;
        this.key = r4;
    }

    public /* synthetic */ ThemeColor(String r7, Integer r8, Key r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r8 = null;
    L9:
        if ((r10 & 4) == 0) goto L11;
        r9 = new Key(null, null, 0, 7, null);
    L11:
        this(r7, r8, r9);
    }
}
