package com.obric.memorydata.datatransport.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/ImageFileNameNormalizer;", "", "<init>", "()V", "IMAGE_HEADER_SIZE", "", "JPEG_EXTENSIONS", "", "", "HEIF_BRANDS", "PNG_SIGNATURE", "", "normalize", "fileName", "input", "Ljava/io/BufferedInputStream;", "detectImageExtension", "header", "size", "extensionsMatch", "", "current", "actual", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f9842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f9843b = null;
    private static final Set<String> c = null;
    private static final byte[] d = null;

    static {
        f9842a = new h();
        f9843b = SetsKt.setOf(new String[]{"jpg", "jpeg"});
        c = SetsKt.setOf(new String[]{"heic", "heix", "hevc", "hevx", "mif1", "msf1"});
        d = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
    }

    private h() {
    }

    private final String a(byte[] r8, int r9) {
        if (r9 < 3) goto L13;
        if (r8[0] != (-1)) goto L13;
        if (r8[1] != (-40)) goto L13;
        if (r8[2] != (-1)) goto L13;
        return "jpg";
    L13:
        if (r9 < 8) goto L19;
        if (Arrays.equals(ArraysKt.copyOfRange(r8, 0, 8), d) == false) goto L19;
        return "png";
    L19:
        if (r9 < 6) goto L27;
        String r4 = new String(r8, 0, 6, Charsets.US_ASCII);
        if (Intrinsics.areEqual(r4, "GIF87a") == false) goto L23;
        return "gif";
    L23:
        if (Intrinsics.areEqual(r4, "GIF89a") == false) goto L27;
        return "gif";
    L27:
        if (r9 < 12) goto L40;
        String r3 = new String(r8, 4, 4, Charsets.US_ASCII);
        String r5 = new String(r8, 8, 4, Charsets.US_ASCII);
        if (Intrinsics.areEqual(r3, "ftyp") == false) goto L35;
        if (c.contains(r5) == false) goto L35;
        return "heif";
    L35:
        if (Intrinsics.areEqual(new String(r8, 0, 4, Charsets.US_ASCII), "RIFF") == false) goto L40;
        if (Intrinsics.areEqual(new String(r8, 8, 4, Charsets.US_ASCII), "WEBP") == false) goto L40;
        return "webp";
    L40:
        if (r9 >= 2) goto L42;
        return null;
    L42:
        if (r8[0] == 66) goto L44;
        return null;
    L44:
        if (r8[1] != 77) goto L51;
        return "bmp";
    L51:
        return null;
    }

    private final boolean a(String r2, String r3) {
        if (Intrinsics.areEqual(r2, r3) == false) goto L5;
        return true;
    L5:
        Set<String> r1 = f9843b;
        if (r1.contains(r2) == true) goto L8;
    L10:
        return false;
    L8:
        if (r1.contains(r3) == false) goto L10;
        return true;
    }

    public final String a(String r4, BufferedInputStream r5) {
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter(r5, "input");
        r5.mark(32);
        byte[] r0 = new byte[32];
        int r1 = r5.read(r0);
        r5.reset();
        if (r1 > 0) goto L5;
        return r4;
    L5:
        String r6 = a(r0, r1);
        if (r6 != null) goto L8;
        return r4;
    L8:
        String r2 = StringsKt.substringAfterLast(r4, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r2, "toLowerCase(...)");
        if (a(r2, r6) == false) goto L12;
        return r4;
    L12:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
        r4 = StringsKt.substringBeforeLast$default(r4, '.', null, 2, null);
    L16:
        return r4 + '.' + r6;
    }
}
