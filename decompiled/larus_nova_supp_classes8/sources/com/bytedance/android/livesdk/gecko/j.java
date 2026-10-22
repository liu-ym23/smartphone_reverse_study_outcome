package com.bytedance.android.livesdk.gecko;

import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface j {

    public static final class a {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Cache(accessKey=" + this.a + ", channel=" + this.b + ", version=" + this.c + ")";
        }

        public a(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "accessKey");
            Intrinsics.checkNotNullParameter(r3, "channel");
            Intrinsics.checkNotNullParameter(r4, "version");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface b {
    }

    public static final class c implements b {
        public final float a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Float.compare(this.a, ((c) r2).a) == 0) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.a);
        }

        public final String toString() {
            return "DownloadProgressEntry(percent=" + this.a + ")";
        }

        public c(float r1) {
            this.a = r1;
        }
    }

    public static final class d implements b {
        public final boolean a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L10;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            String r3 = this.b;
            if (r3 == null) goto L8;
            int r4 = r3.hashCode();
        L10:
            return r2 + r4;
        L8:
            r4 = 0;
            goto L10
        }

        public final String toString() {
            return "DownloadResultEntry(isCache=" + this.a + ", path=" + this.b + ")";
        }

        public d(boolean r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "path");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e implements j {
        public static final e a = null;

        public e() {
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final String a() {
            return "";
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final Long c() {
            Intrinsics.checkNotNullParameter("social_linkmic_dynamic_lynx_saas", "channel");
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final boolean d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "relativePath");
            return false;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final Long getChannelVersion(String r2) {
            Intrinsics.checkNotNullParameter(r2, "channel");
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final InputStream getInputStream(String r2) {
            Intrinsics.checkNotNullParameter(r2, "relativePath");
            Intrinsics.checkNotNullParameter("live_im_push_compress_zstd_dict", "channel");
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final WebResourceResponse interceptRequest(String r1) {
            return null;
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public void update(com.bytedance.android.livesdk.gecko.e r2) {
            Intrinsics.checkNotNullParameter(r2, "geckoUpdateListenerWrapper");
        }

        static {
            a = new e();
        }

        @Override // com.bytedance.android.livesdk.gecko.j
        public final List<String> b() {
            return CollectionsKt.emptyList();
        }
    }

    public static final class f {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L10;
            f r4 = (f) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GeckoArgs(channel=" + this.a + ", version=" + this.b + ")";
        }

        public f(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    String a();

    List<String> b();

    Long c();

    boolean d(String r1);

    Long getChannelVersion(String r1);

    InputStream getInputStream(String r1);

    WebResourceResponse interceptRequest(String r1);

    void update(com.bytedance.android.livesdk.gecko.e r1);
}
