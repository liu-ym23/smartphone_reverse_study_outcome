package com.larus.camera.impl.edulibs.camera.internal.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/util/RpcEnumTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "", "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "ValueType", "BasicType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RpcEnumTypeAdapterFactory implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/util/RpcEnumTypeAdapterFactory$BasicType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "INT", "STRING", "LONG", "DOUBLE", "BOOLEAN", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BasicType extends Enum<BasicType> {
        public static final BasicType BOOLEAN = null;
        public static final a Companion = null;
        public static final BasicType DOUBLE = null;
        public static final BasicType INT = null;
        public static final BasicType LONG = null;
        public static final BasicType STRING = null;
        public static final /* synthetic */ BasicType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private String value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BasicType> getEntries() {
            return b;
        }

        static {
            BasicType r0 = new BasicType("INT", 0, "int");
            INT = r0;
            BasicType r1 = new BasicType("STRING", 1, "java.lang.String");
            STRING = r1;
            BasicType r3 = new BasicType("LONG", 2, "long");
            LONG = r3;
            BasicType r5 = new BasicType("DOUBLE", 3, ItemStyle.ITEM_STYLE_DOUBLE);
            DOUBLE = r5;
            BasicType r7 = new BasicType("BOOLEAN", 4, "boolean");
            BOOLEAN = r7;
            BasicType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static BasicType[] values() {
            return (BasicType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static BasicType valueOf(String r1) {
            return (BasicType) r27.a.a(BasicType.class, r1);
        }

        public final void setValue(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.value = r2;
        }

        public BasicType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public final Object a;
        public final BasicType b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ValueType(value=" + this.a + ", type=" + this.b + ')';
        }

        public final BasicType getType() {
            return this.b;
        }

        public a(Object r2, BasicType r3) {
            Intrinsics.checkNotNullParameter(r2, "value");
            Intrinsics.checkNotNullParameter(r3, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BasicType.values().length];
            r0[BasicType.INT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[BasicType.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[BasicType.LONG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[BasicType.DOUBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[BasicType.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public RpcEnumTypeAdapterFactory() {
    }

    public final <T> TypeAdapter<T> create(Gson r17, TypeToken<T> r18) {
        Intrinsics.checkNotNullParameter(r17, "gson");
        Intrinsics.checkNotNullParameter(r18, "type");
        if (r18.getRawType().isEnum() == true) goto L5;
        return null;
    L5:
        final LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r1 = ArraysKt.filterNotNull(r18.getRawType().getEnumConstants()).iterator();
    L7:
        if (r1.hasNext() == false) goto L53;
        T r3 = r1.next();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type T of com.larus.camera.impl.edulibs.camera.internal.util.RpcEnumTypeAdapterFactory.create");
        Field[] r4 = r3.getClass().getDeclaredFields();
        int r5 = r4.length;
        int r6 = 0;
        int r7 = 0;
    L10:
        if (r7 >= r5) goto L21;
        Field r10 = r4[r7];
        BasicType.a r11 = BasicType.Companion;
        String r12 = r10.getType().getName();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "name");
        BasicType[] r13 = BasicType.values();
        int r14 = r13.length;
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L17;
        if (Intrinsics.areEqual(r13[r15].getValue(), r12) == true) goto L15;
        r15 = r15 + 1;
        goto L12
    L15:
        boolean r16 = true;
    L18:
        if (r16 == true) goto L22;
        r7 = r7 + 1;
    L22:
        if (r10 != null) goto L23;
        SerializedName r8 = r3.getClass().getField(r3.toString()).getAnnotation(SerializedName.class);
        if (r8 != null) goto L50;
        r0.put(r3, new a(r3.toString(), BasicType.STRING));
        goto L7
    L50:
        r0.put(r3, new a(r8.value(), BasicType.STRING));
        goto L7
    L23:
        r10.setAccessible(true);
        BasicType.a r9 = BasicType.Companion;
        String r19 = r10.getType().getName();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r19, "name");
        BasicType[] r20 = BasicType.values();
        int r21 = r20.length;
    L24:
        if (r6 >= r21) goto L47;
        BasicType r22 = r20[r6];
        if (Intrinsics.areEqual(r22.getValue(), r19) == true) goto L27;
        r6 = r6 + 1;
        goto L24
    L27:
        int r23 = b.a[r22.ordinal()];
        if (r23 != 1) goto L30;
        Object r24 = Integer.valueOf(r10.getInt(r3));
    L44:
        r0.put(r3, new a(r24, r22));
        goto L7
    L30:
        if (r23 != 2) goto L32;
        Object r25 = r10.get(r3);
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type kotlin.String");
        r24 = (String) r25;
        goto L44
    L32:
        if (r23 != 3) goto L34;
        r24 = Long.valueOf(r10.getLong(r3));
        goto L44
    L34:
        if (r23 != 4) goto L36;
        r24 = Double.valueOf(r10.getDouble(r3));
        goto L44
    L36:
        if (r23 != 5) goto L39;
        r24 = Boolean.valueOf(r10.getBoolean(r3));
        goto L44
    L39:
        throw new NoWhenBranchMatchedException();
    L47:
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    L17:
        r16 = false;
        goto L18
    L21:
        r10 = null;
        goto L22
    L53:
        return new AnonymousClass2(r0);
    }
}
