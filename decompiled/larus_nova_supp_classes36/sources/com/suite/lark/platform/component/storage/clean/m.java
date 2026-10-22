package com.suite.lark.platform.component.storage.clean;

import com.suite.lark.platform.component.storage.clean.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface m<T extends f> {

    public static final class a {
        public static final /* synthetic */ int h = 0;
        public final boolean a;
        public final i b;
        public final String c;
        public final List<String> d;
        public final List<String> e;
        public final long f;
        public final String g;

        /* JADX INFO: renamed from: com.suite.lark.platform.component.storage.clean.m$a$a, reason: collision with other inner class name */
        public static final class C0239a {
        }

        static {
        }

        public a() {
            throw null;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            i r2 = this.b;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            String r6 = this.c;
            if (r6 != null) goto L13;
            int r7 = 0;
        L14:
            int r8 = (((((r5 + r7) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            long r9 = this.f;
            int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
            String r11 = this.g;
            if (r11 == null) goto L19;
            r3 = r11.hashCode();
        L19:
            return r10 + r3;
        L13:
            r7 = r6.hashCode();
            goto L14
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "EraserResult(success=" + this.a + ", code=" + this.b + ", message=" + this.c + ", successList=" + this.d + ", errors=" + this.e + ", cleanSize=" + this.f + ", cleanFailedPath=" + this.g + ')';
        }

        public a(boolean r5, i r6, String r7, long r8, String r10, int r11) {
            if ((r11 & 2) == 0) goto L6;
            r6 = i.a;
        L6:
            if ((r11 & 4) == 0) goto L9;
            r7 = "";
        L9:
            if ((r11 & 8) == 0) goto L11;
            List<String> r0 = CollectionsKt.emptyList();
        L13:
            if ((r11 & 16) == 0) goto L15;
            List<String> r2 = CollectionsKt.emptyList();
        L17:
            if ((r11 & 32) == 0) goto L20;
            r8 = 0;
        L20:
            if ((r11 & 64) == 0) goto L22;
            r10 = null;
        L22:
            Intrinsics.checkNotNullParameter(r0, "successList");
            Intrinsics.checkNotNullParameter(r2, "errors");
            this.a = r5;
            this.b = r6;
            this.c = r7;
            this.d = r0;
            this.e = r2;
            this.f = r8;
            this.g = r10;
            return;
        L15:
            r2 = null;
            goto L17
        L11:
            r0 = null;
            goto L13
        }
    }

    Class<T> a();
}
