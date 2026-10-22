package com.larus.bmhome.chat.standarduikit.browsercontrol.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.browsercontrol.utils.a$a, reason: collision with other inner class name */
    public static final class C0005a {
        public final String a;
        public final Integer b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0005a) == true) goto L8;
            return false;
        L8:
            C0005a r6 = (C0005a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Integer r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "TrackParams(blockId=" + this.a + ", interactionType=" + this.b + ", displayType=" + this.c + ", agentType=" + this.d + ')';
        }

        public C0005a(String r2, Integer r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "blockId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }
}
