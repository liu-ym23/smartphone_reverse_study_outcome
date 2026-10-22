package com.larus.bmhome.chat.component.bottom.multimodal;

import android.net.Uri;
import com.larus.platform.api.FlowDriveFileType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a {
    public final Uri a;
    public final String b;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.a$a, reason: collision with other inner class name */
    public static final class C0050a extends a {
        public final Uri c;
        public final String d;

        public C0050a() {
            this(null, null, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0050a) == true) goto L8;
            return false;
        L8:
            C0050a r6 = (C0050a) r5;
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Uri r0 = this.c;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.d;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entity(uri=" + this.c + ", path=" + this.d + ')';
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final String a() {
            return this.d;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final Uri b() {
            return this.c;
        }

        public C0050a(Uri r3, String r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            super(r3, r4);
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b extends a {
        public final Uri c;
        public final String d;
        public final String e;
        public final Long f;
        public final String g;
        public final FlowDriveFileType h;
        public final int i;
        public final String j;
        public final float k;
        public final String l;
        public final String m;
        public final Map<String, String> n;

        public b() {
            this(null, null, null, null, null, 0, null, 0.0f, null, null, null, 4095);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L24;
            return false;
        L24:
            if (this.h == r6.h) goto L27;
            return false;
        L27:
            if (this.i == r6.i) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L33;
            return false;
        L33:
            if (Float.compare(this.k, r6.k) == 0) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            Uri r0 = this.c;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.d;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.e;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Long r10 = this.f;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.g;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (((((r12 + r14) * 31) + this.h.hashCode()) * 31) + this.i) * 31;
            String r16 = this.j;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (((r15 + r17) * 31) + Float.floatToIntBits(this.k)) * 31;
            String r19 = this.l;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.m;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            Map<String, String> r25 = this.n;
            if (r25 == null) goto L39;
            r1 = r25.hashCode();
        L39:
            return r24 + r1;
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "RemoteEntity(uri=" + this.c + ", path=" + this.d + ", fileName=" + this.e + ", fileSize=" + this.f + ", fileUrl=" + this.g + ", fileType=" + this.h + ", ccmType=" + this.i + ", videoCoverUrl=" + this.j + ", videoDuration=" + this.k + ", originImgUrl=" + this.l + ", thumbImgUrl=" + this.m + ", extra=" + this.n + ')';
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final String a() {
            return this.d;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final Uri b() {
            return this.c;
        }

        public final int c() {
            return this.i;
        }

        public final Map<String, String> d() {
            return this.n;
        }

        public final String e() {
            return this.e;
        }

        public final Long f() {
            return this.f;
        }

        public final FlowDriveFileType g() {
            return this.h;
        }

        public final String h() {
            return this.g;
        }

        public final String i() {
            return this.l;
        }

        public final String j() {
            return this.m;
        }

        public final float k() {
            return this.k;
        }

        public b(Uri r3, String r4, Long r5, String r6, FlowDriveFileType r7, int r8, String r9, float r10, String r11, String r12, Map r13, int r14) {
            if ((r14 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r14 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r14 & 8) == 0) goto L12;
            r5 = null;
        L12:
            if ((r14 & 16) == 0) goto L15;
            r6 = null;
        L15:
            if ((r14 & 32) == 0) goto L18;
            r7 = FlowDriveFileType.FILE;
        L18:
            if ((r14 & 64) == 0) goto L21;
            r8 = 12;
        L21:
            if ((r14 & 128) == 0) goto L24;
            r9 = null;
        L24:
            if ((r14 & 256) == 0) goto L27;
            r10 = 0.0f;
        L27:
            if ((r14 & 512) == 0) goto L30;
            r11 = null;
        L30:
            if ((r14 & 1024) == 0) goto L33;
            r12 = null;
        L33:
            if ((r14 & 2048) == 0) goto L35;
            r13 = null;
        L35:
            Intrinsics.checkNotNullParameter(r7, "fileType");
            super(r3, null);
            this.c = r3;
            this.d = null;
            this.e = r4;
            this.f = r5;
            this.g = r6;
            this.h = r7;
            this.i = r8;
            this.j = r9;
            this.k = r10;
            this.l = r11;
            this.m = r12;
            this.n = r13;
        }
    }

    public String a() {
        return this.b;
    }

    public Uri b() {
        return this.a;
    }

    public a(Uri r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
