package com.bytedance.android.bcm.impl.paramcheck;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/bcm/impl/paramcheck/EnumTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "BasicType", "a", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class EnumTypeAdapterFactory implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/bcm/impl/paramcheck/EnumTypeAdapterFactory$BasicType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "Companion", "a", "INT", "STRING", "LONG", "DOUBLE", "BOOLEAN", "bcm-impl_cnRelease"}, k = 1, mv = {1, 4, 0})
    public static final enum BasicType extends Enum<BasicType> {
        public static final BasicType BOOLEAN = null;
        public static final a Companion = null;
        public static final BasicType DOUBLE = null;
        public static final BasicType INT = null;
        public static final BasicType LONG = null;
        public static final BasicType STRING = null;
        public static final /* synthetic */ BasicType[] a = null;
        private String value;

        public static final class a {
            public a() {
            }
        }

        static {
            BasicType r1 = new BasicType("INT", 0, "int");
            INT = r1;
            BasicType r10 = new BasicType("STRING", 1, "java.lang.String");
            STRING = r10;
            BasicType r11 = new BasicType("LONG", 2, "long");
            LONG = r11;
            BasicType r12 = new BasicType("DOUBLE", 3, "double");
            DOUBLE = r12;
            BasicType r13 = new BasicType("BOOLEAN", 4, "boolean");
            BOOLEAN = r13;
            a = new BasicType[]{r1, r10, r11, r12, r13};
            Companion = new a();
        }

        public static BasicType valueOf(String r1) {
            return (BasicType) r27.a.a(BasicType.class, r1);
        }

        public static BasicType[] values() {
            return (BasicType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public final void setValue(String r1) {
            this.value = r1;
        }

        public BasicType(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public static final class a {
        public final Object a;
        public final BasicType b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L4;
            return true;
        L4:
            if ((r10 instanceof a) == false) goto L10;
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Object r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r10 = r0.hashCode();
        L6:
            int r11 = r10 * 31;
            BasicType r12 = this.b;
            if (r12 == null) goto L10;
            r1 = r12.hashCode();
        L10:
            return r11 + r1;
        L5:
            r10 = 0;
            goto L6
        }

        public final String toString() {
            return "ValueType(value=" + this.a + ", type=" + this.b + ")";
        }

        public final BasicType getType() {
            return this.b;
        }

        public a(Object r1, BasicType r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public EnumTypeAdapterFactory() {
    }

    public final <T> TypeAdapter<T> create(Gson r14, TypeToken<T> r15) {
        if (r15.getRawType().isEnum() == true) goto L5;
        return null;
    L5:
        final LinkedHashMap r16 = new LinkedHashMap();
        Object[] r17 = r15.getRawType().getEnumConstants();
        if (r17 == null) goto L74;
        ArrayList r1 = new ArrayList();
        int r10 = r17.length;
        int r11 = 0;
    L8:
        boolean r12 = true;
        if (r11 >= r10) goto L17;
        Object r13 = r17[r11];
        if (r13 != null) goto L14;
        r12 = false;
    L14:
        if (r12 == false) goto L16;
        r1.add(r13);
    L16:
        r11 = r11 + 1;
        goto L8
    L17:
        Iterator<T> r18 = r1.iterator();
    L19:
        if (r18.hasNext() == false) goto L74;
        T r19 = r18.next();
        if (r19 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        if (r19 == null) goto L72;
        SerializedName r20 = r19.getClass().getField(r19.toString()).getAnnotation(SerializedName.class);
        if (r20 != null) goto L26;
        Field[] r21 = r19.getClass().getDeclaredFields();
        int r22 = r21.length;
        int r23 = 0;
    L28:
        if (r23 >= r22) goto L39;
        Field r24 = r21[r23];
        BasicType.a r25 = BasicType.Companion;
        String r26 = r24.getType().getName();
        r25.getClass();
        BasicType[] r27 = BasicType.values();
        int r110 = r27.length;
        int r111 = 0;
    L30:
        if (r111 >= r110) goto L35;
        if (Intrinsics.areEqual(r27[r111].getValue(), r26) == true) goto L33;
        r111 = r111 + 1;
        goto L30
    L33:
        boolean r28 = true;
    L36:
        if (r28 == true) goto L40;
        r23 = r23 + 1;
    L40:
        if (r24 != null) goto L41;
        r16.put(r19, new a(r19.toString(), BasicType.STRING));
        goto L19
    L41:
        r24.setAccessible(true);
        BasicType.a r29 = BasicType.Companion;
        String r30 = r24.getType().getName();
        r29.getClass();
        BasicType[] r31 = BasicType.values();
        int r32 = r31.length;
        int r33 = 0;
    L42:
        if (r33 >= r32) goto L69;
        BasicType r34 = r31[r33];
        if (Intrinsics.areEqual(r34.getValue(), r30) == true) goto L45;
        r33 = r33 + 1;
        goto L42
    L45:
        int r35 = b.a[r34.ordinal()];
        if (r35 != 1) goto L48;
        Object r36 = Integer.valueOf(r24.getInt(r19));
    L66:
        r16.put(r19, new a(r36, r34));
        goto L19
    L48:
        if (r35 != 2) goto L50;
        Object r37 = r24.get(r19);
        if (r37 == null) goto L64;
        r36 = (String) r37;
        goto L66
    L64:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L50:
        if (r35 != 3) goto L52;
        r36 = Long.valueOf(r24.getLong(r19));
        goto L66
    L52:
        if (r35 != 4) goto L54;
        r36 = Double.valueOf(r24.getDouble(r19));
        goto L66
    L54:
        if (r35 != 5) goto L57;
        r36 = Boolean.valueOf(r24.getBoolean(r19));
        goto L66
    L57:
        throw new NoWhenBranchMatchedException();
    L69:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L35:
        r28 = false;
        goto L36
    L39:
        r24 = null;
        goto L40
    L26:
        r16.put(r19, new a(r20.value(), BasicType.STRING));
        goto L19
    L72:
        throw new TypeCastException("null cannot be cast to non-null type T");
    L74:
        return new AnonymousClass3(r16);
    }
}
