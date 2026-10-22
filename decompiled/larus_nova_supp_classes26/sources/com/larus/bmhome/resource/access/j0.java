package com.larus.bmhome.resource.access;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class j0 {
    public final ResourceInputType a;

    public static final class a extends j0 {
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((a) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "ContentUri(uri=" + this.b + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            return this.b;
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            super(ResourceInputType.CONTENT_URI);
            this.b = r2;
        }
    }

    public static final class b extends j0 {
        public final String b;
        public final String c;
        public final Boolean d;
        public final Long e;
        public final mr9.c f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Long r8 = this.e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            mr9.c r11 = this.f;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "LocalPath(path=" + this.b + ", originPath=" + this.c + ", originPathIsUri=" + this.d + ", uploadFileSize=" + this.e + ", instantUploadPolicy=" + this.f + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            String r0 = this.c;
            if (r0 == null) goto L13;
            if (r0.length() <= 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L11;
            r0 = null;
        L11:
            if (r0 == null) goto L13;
            return r0;
        L7:
            r1 = false;
        L13:
            return this.b;
        }

        public /* synthetic */ b(String r9, String r10, Boolean r11, Long r12, int r13) {
            if ((r13 & 2) == 0) goto L5;
            String r4 = null;
        L7:
            if ((r13 & 4) == 0) goto L9;
            Boolean r5 = null;
        L11:
            if ((r13 & 8) == 0) goto L13;
            Long r6 = null;
        L14:
            this(r9, r4, r5, r6, null);
            return;
        L13:
            r6 = r12;
            goto L14
        L9:
            r5 = r11;
            goto L11
        L5:
            r4 = r10;
            goto L7
        }

        public b(String r2, String r3, Boolean r4, Long r5, mr9.c r6) {
            Intrinsics.checkNotNullParameter(r2, MusicAppletPage.KEY_PATH);
            super(ResourceInputType.LOCAL_PATH);
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class c extends j0 {
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((c) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "RemoteUrl(url=" + this.b + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            return StringsKt.trim(this.b).toString();
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.URL);
            super(ResourceInputType.REMOTE_URL);
            this.b = r2;
        }
    }

    public static final class d extends j0 {
        public final String b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((d) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "TosKey(tosKey=" + this.b + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            return this.b;
        }

        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tosKey");
            super(ResourceInputType.TOS_KEY);
            this.b = r2;
        }
    }

    public abstract String a();

    public final ResourceInputType getType() {
        return this.a;
    }

    public j0(ResourceInputType r1) {
        this.a = r1;
    }
}
