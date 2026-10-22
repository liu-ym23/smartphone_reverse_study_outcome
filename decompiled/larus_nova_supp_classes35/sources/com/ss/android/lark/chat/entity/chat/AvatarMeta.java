package com.ss.android.lark.chat.entity.chat;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class AvatarMeta implements Parcelable {
    public static final Parcelable.Creator<AvatarMeta> CREATOR = null;
    public final Type a;
    public final StyleType b;
    public final int c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final CharSequence j;

    public static final enum StyleType extends Enum<StyleType> {
        public static final StyleType BORDER = null;
        public static final StyleType FILL = null;
        public static final StyleType UNKNOWN_STYLE = null;
        public static final /* synthetic */ StyleType[] a = null;
        private final int value;

        static {
            StyleType r0 = new StyleType("UNKNOWN_STYLE", 0, 0);
            UNKNOWN_STYLE = r0;
            StyleType r1 = new StyleType("FILL", 1, 1);
            FILL = r1;
            StyleType r3 = new StyleType("BORDER", 2, 2);
            BORDER = r3;
            a = new StyleType[]{r0, r1, r3};
        }

        public static StyleType[] values() {
            return (StyleType[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static /* synthetic */ int access$100(StyleType r0) {
            return r0.value;
        }

        public static StyleType fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN_STYLE;
        L9:
            return BORDER;
        L11:
            return FILL;
        }

        public static StyleType valueOf(String r1) {
            return (StyleType) r27.a.a(StyleType.class, r1);
        }

        public StyleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type COLLAGE = null;
        public static final Type RANDOM = null;
        public static final Type UNKNOWN = null;
        public static final Type UPLOAD = null;
        public static final Type WORDS = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("RANDOM", 1, 1);
            RANDOM = r1;
            Type r3 = new Type("WORDS", 2, 2);
            WORDS = r3;
            Type r5 = new Type("UPLOAD", 3, 3);
            UPLOAD = r5;
            Type r7 = new Type("COLLAGE", 4, 4);
            COLLAGE = r7;
            a = new Type[]{r0, r1, r3, r5, r7};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Type r0) {
            return r0.value;
        }

        public static Type fromValue(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return UNKNOWN;
        L13:
            return COLLAGE;
        L15:
            return UPLOAD;
        L17:
            return WORDS;
        L19:
            return RANDOM;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public class a implements Parcelable.Creator<AvatarMeta> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AvatarMeta createFromParcel(Parcel r2) {
            return new AvatarMeta(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AvatarMeta[] newArray(int r1) {
            return new AvatarMeta[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "AvatarMeta{type=" + this.a + ", styleType=" + this.b + ", color=" + this.c + ", borderColor=" + this.e + ", backgroundColor=" + this.f + ", centerColor=" + this.g + "', startColor=" + this.h + "', endColor=" + this.i + "'}";
    }

    public AvatarMeta() {
    }

    public Type getType() {
        return this.a;
    }

    public AvatarMeta(Parcel r2) {
        this.a = Type.fromValue(r2.readInt());
        this.b = StyleType.fromValue(r2.readInt());
        this.c = r2.readInt();
        this.d = r2.readString();
        this.e = r2.readInt();
        this.f = r2.readInt();
        this.g = r2.readInt();
        this.h = r2.readInt();
        this.i = r2.readInt();
        this.j = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(Type.access$000(this.a));
        StyleType r3 = this.b;
        if (r3 != null) goto L5;
        int r4 = 0;
    L6:
        r1.writeInt(r4);
        r1.writeInt(this.c);
        r1.writeString(this.d);
        r1.writeInt(this.e);
        r1.writeInt(this.f);
        r1.writeInt(this.g);
        r1.writeInt(this.h);
        r1.writeInt(this.i);
        CharSequence r5 = this.j;
        if (r5 != null) goto L9;
        String r6 = null;
    L10:
        r1.writeString(r6);
        return;
    L9:
        r6 = ((String) r5).toString();
        goto L10
    L5:
        r4 = StyleType.access$100(r3);
        goto L6
    }
}
