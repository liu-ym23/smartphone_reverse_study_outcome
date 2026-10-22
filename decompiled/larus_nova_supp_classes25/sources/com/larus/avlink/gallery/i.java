package com.larus.avlink.gallery;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.bigimg.t1;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final long a;
        public final int b;
        public final double c;
        public final int d;
        public final int e;
        public final long f;
        public final int g;

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
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (Double.compare(this.c, r9.c) == 0) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L27;
            return false;
        L27:
            if (this.g == r9.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
            long r3 = Double.doubleToLongBits(this.c);
            int r2 = (((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31;
            long r4 = this.f;
            return ((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.g;
        }

        public final String toString() {
            return "MediaFileInfo(id=" + this.a + ", side=" + this.b + ", duration=" + this.c + ", height=" + this.d + ", width=" + this.e + ", createTime=" + this.f + ", index=" + this.g + ')';
        }

        public a(long r1, int r3, double r4, int r6, int r7, long r8, int r10) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r10;
        }
    }

    static {
    }

    @Deprecated(message = "已弃用，避免从文件名解析")
    public static a c(String r18) {
        Intrinsics.checkNotNullParameter(r18, "fileName");
        Intrinsics.checkNotNullParameter(r18, "<this>");
        String r0 = StringsKt.substringBeforeLast$default(r18, ".", null, 2, null);
        if (StringsKt.endsWith$default(r0, "_t", false, 2, null) == false) goto L5;
        r0 = StringsKt.substringBeforeLast$default(r0, "_t", null, 2, null);
    L5:
        List r1 = StringsKt.split$default(r0, new char[]{'_'}, false, 0, 6, null);
        if (r1.size() >= 6) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(ListProtector.get(r1, 0), "media") == false) goto L10;
    L26:
        long r8 = CastLongProtector.parseLong((String) ListProtector.get(r1, 1));     // Catch: NumberFormatException -> L25
        int r10 = CastIntegerProtector.parseInt((String) ListProtector.get(r1, 2));     // Catch: NumberFormatException -> L25
        double r11 = CastDoubleProtector.parseDouble((String) ListProtector.get(r1, 3));     // Catch: NumberFormatException -> L25
        int r13 = CastIntegerProtector.parseInt((String) ListProtector.get(r1, 4));     // Catch: NumberFormatException -> L25
        int r14 = CastIntegerProtector.parseInt((String) ListProtector.get(r1, 5));     // Catch: NumberFormatException -> L25
        long r15 = CastLongProtector.parseLong((String) ListProtector.get(r1, 6));     // Catch: NumberFormatException -> L25
        if (r1.size() < 8) goto L21;
        int r17 = CastIntegerProtector.parseInt((String) ListProtector.get(r1, 7));     // Catch: NumberFormatException -> L25
    L22:
        return new a(r8, r10, r11, r13, r14, r15, r17);
    L21:
        r17 = 0;
    L30:
        return null;
    L10:
        if (Intrinsics.areEqual(ListProtector.get(r1, 0), "hdr") == true) goto L26;
        if (Intrinsics.areEqual(ListProtector.get(r1, 0), "llhdr") == true) goto L26;
        if (Intrinsics.areEqual(ListProtector.get(r1, 0), "mfnr") == true) goto L26;
        if (Intrinsics.areEqual(ListProtector.get(r1, 0), "motion") == true) goto L26;
        return null;
    }

    public static t1 b(MediaMetadata r18, boolean r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "metadata");
        if (r18.getLifecycleState() != MediaLifecycleState.DOWNLOAD) goto L5;
    L29:
        return null;
    L5:
        if (r18.getLifecycleState() == MediaLifecycleState.FAILED) goto L29;
        String r6 = r18.getCurrentFilePath();
        PolarisFileWrapper r0 = new PolarisFileWrapper(r6);
        if (r0.exists() == true) goto L11;
        FLogger.a.w("MediaItemFactory", StringsKt.trimIndent("\n                File not found for media: " + r18.getUniqId() + "\n                - lifecycleState: " + r18.getLifecycleState() + "\n                - currentPath (from getCurrentFilePath): " + r6 + "\n                - filePath (legacy): " + r18.getFilePath() + "\n                - downloadFilePath: " + r18.getDownloadFilePath() + "\n                - tempFilePath: " + r18.getTempFilePath() + "\n                - processedFilePath: " + r18.getProcessedFilePath() + "\n                - finalFilePath: " + r18.getFinalFilePath() + "\n            "));
        return null;
    L11:
        String r2 = r18.getMediaType();
        if (r2 == null) goto L16;
        boolean r4 = true;
        if (StringsKt.contains(r2, "video", true) != true) goto L16;
    L17:
        if (r4 == false) goto L23;
        String r3 = r18.getFileName();
        if (r3 != null) goto L21;
        String r5 = r0.getName();
    L22:
        Intrinsics.checkNotNull(r5);
        return new yt8.p(r5, r6, r18.getCreateTime(), r18.getUniqId(), r19, r20, 0, r18.getGeoLocationInfo(), r18.getDuration(), r18.getWidth(), r18.getHeight());
    L21:
        r5 = r3;
        goto L22
    L23:
        String r7 = r18.getFileName();
        if (r7 != null) goto L26;
        String r8 = r0.getName();
    L27:
        Intrinsics.checkNotNull(r8);
        return new yt8.a(r8, r6, r18.getCreateTime(), r18.getUniqId(), r19, r20, 0, r18.getGeoLocationInfo(), r18.getWidth(), r18.getHeight());
    L26:
        r8 = r7;
    L16:
        r4 = false;
        goto L17
    }

    public static t1 a(File r20, String r21, boolean r22, GeoLocationInfo r23) {
        MediaMetadata r4 = (MediaMetadata) BuildersKt.runBlocking$default(null, new MediaItemFactory$parseWithFallback$metadata$1(r20, null), 1, null);     // Catch: Exception -> L7
        if (r4 == null) goto L9;
        FLogger.a.d("MediaItemFactory", "Loaded metadata from Keva for: " + r20.getName());     // Catch: Exception -> L7
        a r0 = new a(r4.getMediaId(), 0, (double) r4.getDuration(), r4.getHeight(), r4.getWidth(), r4.getCreateTime(), 0);     // Catch: Exception -> L7
    L10:
        if (r0 != null) goto L12;
        return null;
    L12:
        long r5 = r0.f;
        if (r5 >= 1471228928) goto L15;
        r5 = r20.lastModified();
    L15:
        long r9 = r5;
        int r2 = AlbumUtils.a;
        Intrinsics.checkNotNullParameter(r20, "file");
        if (CollectionsKt.listOf(new String[]{"mp4", "mkv", "avi", "mov"}).contains(FilesKt.getExtension(r20).toLowerCase(Locale.getDefault())) == false) goto L18;
        StringsKt.split$default(FilesKt.getNameWithoutExtension(r20), new String[]{"_"}, false, 0, 6, null);
        return new yt8.p(r20.getName(), r20.getAbsolutePath(), r9, r21, r22, true, r0.g, r23, r0.c, r0.e, r0.d);
    L18:
        Intrinsics.checkNotNullParameter(r20, "file");
        if (CollectionsKt.listOf(new String[]{"jpg", "jpeg", "png", "gif"}).contains(FilesKt.getExtension(r20).toLowerCase(Locale.getDefault())) == true) goto L21;
        return null;
    L21:
        return new yt8.a(r20.getName(), r20.getAbsolutePath(), r9, r21, r22, true, r0.g, r23, r0.e, r0.d);
    L9:
        r0 = c(r20.getName());
    L7:
        e = move-exception;
        FLogger.a.d("MediaItemFactory", "Failed to load from Keva, trying legacy format: " + e.getMessage());
        goto L9
    }
}
