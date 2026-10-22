package com.larus.dora.impl.nl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class AppListItem {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/nl/AppListItem$BackgroundType;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST", "MIDDLE", "LAST", "DEFAULT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundType extends Enum<BackgroundType> {
        public static final BackgroundType DEFAULT = null;
        public static final BackgroundType FIRST = null;
        public static final BackgroundType LAST = null;
        public static final BackgroundType MIDDLE = null;
        public static final /* synthetic */ BackgroundType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<BackgroundType> getEntries() {
            return b;
        }

        static {
            BackgroundType r0 = new BackgroundType("FIRST", 0);
            FIRST = r0;
            BackgroundType r1 = new BackgroundType("MIDDLE", 1);
            MIDDLE = r1;
            BackgroundType r3 = new BackgroundType("LAST", 2);
            LAST = r3;
            BackgroundType r5 = new BackgroundType("DEFAULT", 3);
            DEFAULT = r5;
            BackgroundType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static BackgroundType[] values() {
            return (BackgroundType[]) a.clone();
        }

        public static BackgroundType valueOf(String r1) {
            return (BackgroundType) r27.a.a(BackgroundType.class, r1);
        }

        public BackgroundType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends AppListItem {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends AppListItem {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Header(title=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }
    }

    public static final class c extends AppListItem {
        public final boolean a;
        public BackgroundType b;
        public final com.larus.dora.impl.network.s c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L7:
            return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        L5:
            r0 = 1237;
            goto L7
        }

        public final String toString() {
            return "Item(isEnabled=" + this.a + ", bgType=" + this.b + ", data=" + this.c + ')';
        }

        public final void a(BackgroundType r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.b = r2;
        }

        public c(boolean r2, BackgroundType r3, com.larus.dora.impl.network.s r4) {
            Intrinsics.checkNotNullParameter(r3, "bgType");
            Intrinsics.checkNotNullParameter(r4, "data");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public AppListItem() {
    }
}
