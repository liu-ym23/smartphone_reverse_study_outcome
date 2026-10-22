package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {

    public static final class a {
        public static String a(b r2) {
            if (Intrinsics.areEqual(r2, c.a) == false) goto L6;
            return "none";
        L6:
            if ((r2 instanceof C0046b) == false) goto L9;
            StringBuilder r0 = new StringBuilder("key:");
            C0046b r3 = (C0046b) r2;
            r0.append(r3.a);
            r0.append(':');
            r0.append(r3.b);
            return r0.toString();
        L9:
            if ((r2 instanceof d) == false) goto L12;
            return "url:" + ((d) r2).a;
        L12:
            if ((r2 instanceof e) == false) goto L16;
            return "fallback:" + ((e) r2).a;
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b$b, reason: collision with other inner class name */
    public static final class C0046b implements b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0046b) == true) goto L8;
            return false;
        L8:
            C0046b r6 = (C0046b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Key(key=" + this.a + ", userId=" + this.b + ')';
        }

        public C0046b() {
            this("", "");
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }

        public C0046b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "userId");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof c) == true) goto L9;
            return false;
        L9:
            c r4 = (c) r3;
            return true;
        }

        public final int hashCode() {
            return -1489531885;
        }

        public final String toString() {
            return "None";
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }
    }

    public static final class d implements b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.a + ')';
        }

        public d() {
            this("");
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }

    public static final class e implements b {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UserIdFallback(userId=" + this.a + ')';
        }

        public e() {
            this("");
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }

        public e(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            this.a = r2;
        }
    }

    String a();
}
