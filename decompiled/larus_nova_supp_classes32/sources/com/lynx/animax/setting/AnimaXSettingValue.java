package com.lynx.animax.setting;

import com.obric.aivoice.core.data.NameKeys;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AnimaXSettingValue {
    public final String a;
    public final Collection<String> b;
    public final SettingType c;

    public static final enum SettingType extends Enum<SettingType> {
        public static final SettingType BOOLEAN = null;
        public static final SettingType COLLECTION = null;
        public static final SettingType DOUBLE = null;
        public static final SettingType LONG = null;
        public static final SettingType STRING = null;
        public static final /* synthetic */ SettingType[] a = null;

        static {
            SettingType r0 = new SettingType("STRING", 0);
            STRING = r0;
            SettingType r1 = new SettingType("COLLECTION", 1);
            COLLECTION = r1;
            SettingType r3 = new SettingType("BOOLEAN", 2);
            BOOLEAN = r3;
            SettingType r5 = new SettingType("LONG", 3);
            LONG = r5;
            SettingType r7 = new SettingType("DOUBLE", 4);
            DOUBLE = r7;
            a = new SettingType[]{r0, r1, r3, r5, r7};
        }

        public static SettingType[] values() {
            return (SettingType[]) a.clone();
        }

        public static SettingType valueOf(String r1) {
            return (SettingType) r27.a.a(SettingType.class, r1);
        }

        public SettingType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SettingType.values().length];
            a = r0;
            r0[SettingType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[SettingType.COLLECTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[SettingType.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[SettingType.LONG.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[SettingType.DOUBLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final Collection<String> a() {
        if (this.c != SettingType.COLLECTION) goto L6;
        return this.b;
    L6:
        return Collections.emptyList();
    }

    public final String b() {
        if (this.c == SettingType.STRING) goto L7;
        return NameKeys.UnloadStrategy_No_Strategy;
    L7:
        return this.a;
    }

    public final boolean c() {
        if (this.c != SettingType.COLLECTION) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        if (this.c != SettingType.STRING) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("{type=");
        r0.append(this.c.name());
        r0.append(", value=");
        int r1 = a.a[this.c.ordinal()];
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        if (r1 != 1) goto L5;
        String r2 = this.a;
        if (r2 == null) goto L28;
        r3 = r2;
    L28:
        r0.append(r3);
    L29:
        r0.append("}");
        return r0.toString();
    L5:
        if (r1 == 2) goto L17;
        if (r1 != 3) goto L9;
        r0.append("false");
        goto L29
    L9:
        if (r1 != 4) goto L11;
        r0.append("0");
        goto L29
    L11:
        if (r1 == 5) goto L13;
        r0.append(NameKeys.UnloadStrategy_No_Strategy);
        goto L29
    L13:
        r0.append("0.0");
        goto L29
    L17:
        if (this.b == null) goto L24;
        r0.append('[');
        Collection<String> r4 = this.b;
        StringBuilder r5 = new StringBuilder();
        Iterator<T> r6 = r4.iterator();
        if (r6.hasNext() == false) goto L23;
    L20:
        r5.append((CharSequence) r6.next());
        if (r6.hasNext() == false) goto L23;
        r5.append(", ");
    L23:
        r0.append(r5.toString());
        r0.append(']');
        goto L29
    L24:
        r0.append("[]");
        goto L29
    }

    public AnimaXSettingValue(String r1) {
        this.a = r1;
        this.b = null;
        this.c = SettingType.STRING;
    }

    public AnimaXSettingValue(Collection<String> r2) {
        this.a = null;
        this.b = r2;
        this.c = SettingType.COLLECTION;
    }
}
