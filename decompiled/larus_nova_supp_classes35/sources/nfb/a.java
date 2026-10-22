package nfb;

import com.ss.android.lark.chat.entity.message.content.FilePreviewStage;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final String a;
    public final FileType b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final String g;
    public final String h;
    public final String i;
    public final FilePreviewStage j;
    public String k;
    public String l;

    /* JADX INFO: renamed from: nfb.a$a, reason: collision with other inner class name */
    public static final class C0266a {
        public String a;
        public FileType b;
        public String c;
        public long d;
        public long e;
        public long f;
        public String g;
        public String h;
        public String i;
        public FilePreviewStage j;
        public String k;
        public String l;

        public final a a() {
            return new a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
        }

        public C0266a() {
            this.a = BuildConfig.FLAVOR;
            this.b = FileType.FOLDER;
            this.c = BuildConfig.FLAVOR;
            this.g = BuildConfig.FLAVOR;
            this.h = BuildConfig.FLAVOR;
            this.j = FilePreviewStage.UnknownStage;
        }
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.e;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.f;
        int r6 = (((((r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String r7 = this.i;
        int r8 = 0;
        if (r7 != null) goto L5;
        int r9 = 0;
    L6:
        int r10 = (r6 + r9) * 31;
        FilePreviewStage r11 = this.j;
        if (r11 != null) goto L9;
        int r12 = 0;
    L10:
        int r13 = (r10 + r12) * 31;
        String r14 = this.k;
        if (r14 != null) goto L13;
        int r15 = 0;
    L14:
        int r16 = (r13 + r15) * 31;
        String r17 = this.l;
        if (r17 == null) goto L19;
        r8 = r17.hashCode();
    L19:
        return r16 + r8;
    L13:
        r15 = r14.hashCode();
        goto L14
    L9:
        r12 = r11.hashCode();
        goto L10
    L5:
        r9 = r7.hashCode();
        goto L6
    }

    public final String toString() {
        return "FilePreviewInfo(key=" + this.a + ", type=" + this.b + ", name=" + this.c + ", size=" + this.d + ", createTime=" + this.e + ", ownerId=" + this.f + ", ownerName=" + this.g + ", path=" + this.h + ", previewImageKey=" + this.i + ", filePreviewStage=" + this.j + ", previewId=" + this.k + ", msgLinkToken=" + this.l + ')';
    }

    public final FileType getType() {
        return this.b;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.filedetail.impl.folder.manage.entity.FilePreviewInfo");
        if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public a(String r8, FileType r9, String r10, long r11, long r13, long r15, String r17, String r18, String r19, FilePreviewStage r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r10, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r17, "ownerName");
        Intrinsics.checkNotNullParameter(r18, "path");
        this.a = r8;
        this.b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r13;
        this.f = r15;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
        this.l = r22;
    }
}
