package bz9;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Size;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.LocalImageMeta;
import com.larus.im.bean.message.LocalVideoData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.chat.block.create.i;
import com.larus.utils.o0;
import cz9.m;
import cz9.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nr9.f;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final List<CreationItem> b(i r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        BlockContent r5 = ((jc8.a) r4).a.getContent();
        if (r5 == null) goto L14;
        CreationBlock r6 = r5.getCreationBlock();
        if (r6 == null) goto L14;
        List r7 = r6.creations;
        if (r7 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Object r2 = r8.next();
        CreationItem r3 = (CreationItem) r2;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (e(r3) == false) goto L10;
        r1.add(r2);
    L15:
        if (r1 == null) goto L17;
        return r1;
    L17:
        return CollectionsKt.emptyList();
    L14:
        r1 = null;
        goto L15
    }

    public static final boolean e(CreationItem r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Integer r0 = r4.type;
        if (r0 != null) goto L6;
    L20:
        if (r0 != null) goto L23;
        return false;
    L23:
        if (r0.intValue() != 4) goto L39;
        LocalVideoData r5 = r4.localVideo;
        if (r5 != null) goto L28;
        return false;
    L28:
        if (o0.d(r5.videoPath) == false) goto L30;
    L31:
        Integer r6 = r5.status;
        if (r6 != null) goto L34;
    L36:
        return true;
    L34:
        if (r6.intValue() == 3) goto L36;
        return false;
    L30:
        if (o0.d(r5.uri) == true) goto L31;
        return false;
    L39:
        return false;
    L6:
        if (r0.intValue() != 3) goto L20;
        LocalImageData r7 = r4.localImage;
        if (r7 == null) goto L42;
        String r1 = l(r7);
        if (r1 != null) goto L14;
        r1 = k(r7);
    L14:
        if (o0.d(r1) == false) goto L37;
        Integer r8 = r7.status;
        if (r8 == null) goto L36;
        if (r8.intValue() == 2) goto L36;
        return false;
    L37:
        return false;
    L42:
        return false;
    }

    public static final String h(String r4) {
        if (r4 == null) goto L22;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 != null) goto L7;
        return null;
    L7:
        if (r5.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r5 = null;
    L13:
        if (r5 != null) goto L16;
        return null;
    L16:
        if (StringsKt.startsWith(r5, "file://", true) == false) goto L19;
        return UriProtector.parse(r5).getPath();
    L19:
        if (StringsKt.startsWith$default(r5, "/", false, 2, null) == true) goto L21;
        return null;
    L21:
        return r5;
    L9:
        r1 = false;
        goto L10
    L22:
        return null;
    }

    public static final void i(CreationItem r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        LocalImageData r10 = r9.localImage;
        if (r10 == null) goto L83;
        LocalImageMeta r0 = r10.localImageOriRaw;
        Object r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.path;
    L8:
        if (r2 != null) goto L12;
        r2 = r10.uri;
        if (r2 != null) goto L12;
        return;
    L12:
        uh8.b r11 = uh8.b.a;
        AppHost.Companion r3 = AppHost.a;
        if (o0.d(uh8.b.c(r11, r3.getApplication(), r2)) == true) goto L89;
        Application r4 = r3.getApplication();
        monitor-enter(r11);
        Intrinsics.checkNotNullParameter(r4, "context");     // Catch: Throwable -> L80
        String r5 = StringsKt.trim(r2).toString();     // Catch: Throwable -> L80
        if (r5 == null) goto L78;
        boolean r6 = true;
        if (r5.length() <= 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L26;
        r5 = null;
    L26:
        if (r5 == null) goto L78;
        Uri r8 = uh8.b.f(r5);     // Catch: Throwable -> L80
        if (r8 != null) goto L32;
        monitor-exit(r11);
        return;
    L32:
        int r12 = 1440;
        Integer r13 = 1440;     // Catch: Throwable -> L80
        if (r13.intValue() > 0) goto L37;
        r6 = false;
    L37:
        if (r6 == true) goto L40;
        r13 = null;
    L40:
        if (r13 == null) goto L42;
        r12 = r13.intValue();     // Catch: Throwable -> L80
    L42:
        File r14 = uh8.b.a(r4, r5, r8, r12);     // Catch: Throwable -> L80
        if (uh8.b.d(r14) == false) goto L85;
        r14.getAbsolutePath();     // Catch: Throwable -> L80
        monitor-exit(r11);
        return;
    L85:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L69
        File r16 = r14.getParentFile();     // Catch: Throwable -> L69
        if (r16 == null) goto L50;
        r16.mkdirs();     // Catch: Throwable -> L69
    L50:
        Bitmap r17 = uh8.b.b(r4, r8, r12);     // Catch: Throwable -> L69
        if (r17 != null) goto L86;
        monitor-exit(r11);
        return;
    L86:
    L63:
        th = move-exception;
        r17.recycle();     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L55:
        if (uh8.b.g(r17, r14) == true) goto L57;
    L65:
        String r18 = null;
    L66:
        r17.recycle();     // Catch: Throwable -> L69
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L69
    L72:
        if (Result.isFailure-impl(r19) == true) goto L75;
        r1 = r19;
    L75:
        String r20 = (String) r1;     // Catch: Throwable -> L80
        monitor-exit(r11);
        return;
    L57:
        if (uh8.b.d(r14) == true) goto L60;
        r14 = null;
    L60:
        if (r14 == null) goto L65;
        r18 = r14.getAbsolutePath();     // Catch: Throwable -> L63
    L69:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L80
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L80
        goto L72
    L22:
        r7 = false;
    L78:
        monitor-exit(r11);
        return;
    L80:
        th = move-exception;
        throw th;
    L89:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static final String j(LocalVideoData r2) {
        Cover r0 = r2.cover;
        String r1 = null;
        if (r0 == null) goto L7;
        LocalImageMeta r3 = r0.localImagePreview;
        if (r3 == null) goto L7;
        String r4 = r3.path;
    L8:
        String r5 = h(r4);
        if (r5 != null) goto L15;
        Cover r6 = r2.cover;
        if (r6 == null) goto L14;
        r1 = r6.key;
    L14:
        return h(r1);
    L15:
        return r5;
    L7:
        r4 = null;
        goto L8
    }

    public static final String k(LocalImageData r1) {
        LocalImageMeta r0 = r1.localImageOriRaw;
        if (r0 == null) goto L5;
        String r2 = r0.path;
    L6:
        String r3 = m(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        return r1.uri;
    L5:
        r2 = null;
        goto L6
    }

    public static final String l(LocalImageData r2) {
        LocalImageMeta r0 = r2.localImageOriRaw;
        if (r0 == null) goto L5;
        String r1 = r0.path;
    L6:
        if (r1 != null) goto L11;
        r1 = r2.uri;
        if (r1 != null) goto L11;
        return null;
    L11:
        return m(uh8.b.c(uh8.b.a, AppHost.a.getApplication(), r1));
    L5:
        r1 = null;
        goto L6
    }

    public static final String m(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return null;
    L13:
        if (StringsKt.startsWith$default(r4, "file://", false, 2, null) == false) goto L15;
        return r4;
    L15:
        if (StringsKt.startsWith$default(r4, "content://", false, 2, null) == false) goto L18;
        return r4;
    L18:
        return Uri.fromFile(new PolarisFileWrapper(r4)).toString();
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public static final ImageInfo o(CreationItem r18) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        LocalImageData r1 = r18.localImage;
        Image r2 = null;
        Long r3 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        String r4 = l(r1);
        if (r4 != null) goto L8;
        r4 = k(r1);
    L8:
        if (r4 != null) goto L10;
        return null;
    L10:
        String r5 = k(r1);
        String r6 = l(r1);
        if (r6 != null) goto L14;
        r6 = k(r1);
    L14:
        if (r5 == null) goto L23;
        LocalImageMeta r7 = r1.localImageOriRaw;
        if (r7 == null) goto L18;
        Long r8 = r7.width;
    L19:
        if (r7 == null) goto L21;
        Long r9 = r7.height;
    L22:
        Image r10 = q(r5, r8, r9);
    L24:
        if (r6 == null) goto L33;
        LocalImageMeta r11 = r1.localImageOriRaw;
        if (r11 == null) goto L28;
        Long r12 = r11.width;
    L29:
        if (r11 == null) goto L31;
        Long r13 = r11.height;
    L32:
        Image r14 = q(r6, r12, r13);
    L34:
        LocalImageMeta r15 = r1.localImageOriRaw;
        if (r15 == null) goto L37;
        Long r16 = r15.width;
    L38:
        if (r15 == null) goto L40;
        Long r17 = r15.height;
    L41:
        Image r19 = q(r4, r16, r17);
        String r20 = r1.uri;
        if (r20 != null) goto L49;
        LocalImageMeta r21 = r1.localImageOriRaw;
        if (r21 == null) goto L46;
        r20 = r21.path;
    L47:
        if (r20 != null) goto L49;
        String r110 = r18.id;
    L51:
        if (r5 == null) goto L60;
        LocalImageMeta r0 = r1.localImageOriRaw;
        if (r0 == null) goto L55;
        Long r22 = r0.width;
    L56:
        if (r0 == null) goto L58;
        Long r23 = r0.height;
    L59:
        Image r111 = q(r5, r22, r23);
    L61:
        if (r6 == null) goto L70;
        LocalImageMeta r24 = r1.localImageOriRaw;
        if (r24 == null) goto L65;
        Long r25 = r24.width;
    L66:
        if (r24 == null) goto L68;
        r3 = r24.height;
    L68:
        r2 = q(r6, r25, r3);
        goto L70
    L65:
        r25 = null;
    L70:
        return new ImageInfo(r10, r14, r19, null, r110, null, null, r111, r2, 232);
    L58:
        r23 = null;
        goto L59
    L55:
        r22 = null;
        goto L56
    L60:
        r111 = null;
        goto L61
    L46:
        r20 = null;
    L49:
        r110 = r20;
        goto L51
    L40:
        r17 = null;
        goto L41
    L37:
        r16 = null;
        goto L38
    L31:
        r13 = null;
        goto L32
    L28:
        r12 = null;
        goto L29
    L33:
        r14 = null;
        goto L34
    L21:
        r9 = null;
        goto L22
    L18:
        r8 = null;
        goto L19
    L23:
        r10 = null;
        goto L24
    }

    public static final g p(CreationItem r21) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        LocalVideoData r1 = r21.localVideo;
        String r2 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        String r3 = m(j(r1));
        boolean r4 = false;
        if (r3 != null) goto L37;
        Cover r5 = r1.cover;
        if (r5 == null) goto L12;
        ImageObj r6 = r5.imagePreview;
        if (r6 == null) goto L12;
        String r7 = r6.url;
    L13:
        if (r7 == null) goto L29;
        r3 = StringsKt.trim(r7).toString();
        if (r3 == null) goto L29;
        if (r3.length() <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == true) goto L23;
        r3 = null;
    L23:
        if (r3 == null) goto L29;
        String r9 = m(h(r3));
        if (r9 == null) goto L30;
        r3 = r9;
    L30:
        if (r3 != null) goto L37;
        Cover r10 = r1.cover;
        if (r10 == null) goto L36;
        ImageObj r11 = r10.imageThumb;
        if (r11 == null) goto L36;
        r3 = a.a(r11);
    L36:
        String r12 = null;
    L38:
        String r13 = r1.videoPath;
        String r14 = r1.vid;
        if (r14 != null) goto L45;
        r14 = r1.uri;
        if (r14 != null) goto L45;
        if (r13 != null) goto L44;
        r14 = r21.id;
        goto L45
    L44:
        String r15 = r13;
    L46:
        String r16 = r1.uri;
        if (r16 == null) goto L54;
        if (r13 != null) goto L50;
    L51:
        r4 = true;
    L52:
        if (r4 == false) goto L54;
        r2 = r16;
        goto L54
    L50:
        if (r13.length() != 0) goto L52;
    L54:
        Double r17 = r1.duration;
        String r18 = r1.videoType;
        String r19 = j(r1);
        Cover r20 = r1.cover;
        long r110 = 0;
        if (r20 == null) goto L61;
        LocalImageMeta r22 = r20.localImagePreview;
        if (r22 == null) goto L61;
        Long r23 = r22.height;
        if (r23 == null) goto L61;
        long r24 = r23.longValue();
    L69:
        Integer r111 = Integer.valueOf((int) r24);
        Cover r25 = r1.cover;
        if (r25 == null) goto L76;
        LocalImageMeta r26 = r25.localImagePreview;
        if (r26 == null) goto L76;
        Long r27 = r26.width;
        if (r27 == null) goto L76;
        r110 = r27.longValue();
    L84:
        return new g(r15, r16, r2, null, r17, r18, new f(r12, r12, r19, r111, Integer.valueOf((int) r110), null, 32), r13, r21.id, null, 520);
    L76:
        if (r25 == null) goto L80;
        ImageObj r28 = r25.imagePreview;
        if (r28 == null) goto L80;
        r110 = r28.width;
    L80:
        Long r29 = r1.width;
        if (r29 == null) goto L84;
        r110 = r29.longValue();
    L61:
        if (r20 == null) goto L65;
        ImageObj r30 = r20.imagePreview;
        if (r30 == null) goto L65;
        r24 = r30.height;
    L65:
        Long r31 = r1.height;
        if (r31 == null) goto L68;
        r24 = r31.longValue();
        goto L69
    L68:
        r24 = 0;
    L45:
        r15 = r14;
        goto L46
    L19:
        r8 = false;
    L29:
        r3 = null;
    L12:
        r7 = null;
    L37:
        r12 = r3;
        goto L38
    }

    public static final boolean d(CreationItem r4, CreationItem r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "other");
        if (Intrinsics.areEqual(r4.type, r5.type) == true) goto L5;
        return false;
    L5:
        Integer r0 = r4.type;
        if (r0 != null) goto L9;
    L11:
        if (r0 != null) goto L14;
        return false;
    L14:
        if (r0.intValue() == 4) goto L16;
        return false;
    L16:
        return g(r4.localVideo, r5.localVideo);
    L9:
        if (r0.intValue() != 3) goto L11;
        return f(r4.localImage, r5.localImage);
    }

    public static final boolean f(LocalImageData r4, LocalImageData r5) {
        Integer r0 = null;
        if (r4 == null) goto L7;
        LocalImageMeta r1 = r4.localImageOriRaw;
        if (r1 == null) goto L7;
        String r2 = r1.path;
    L8:
        String r3 = "";
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (r5 == null) goto L15;
        LocalImageMeta r6 = r5.localImageOriRaw;
        if (r6 == null) goto L15;
        String r7 = r6.path;
    L16:
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        if (Intrinsics.areEqual(r2, r7) == false) goto L41;
        if (r4 == null) goto L22;
        String r8 = r4.uri;
    L23:
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        if (r5 == null) goto L27;
        String r9 = r5.uri;
    L28:
        if (r9 == null) goto L32;
        r3 = r9;
    L32:
        if (Intrinsics.areEqual(r8, r3) == false) goto L41;
        if (r4 == null) goto L35;
        Integer r10 = r4.status;
    L36:
        if (r5 == null) goto L39;
        r0 = r5.status;
    L39:
        if (Intrinsics.areEqual(r10, r0) == false) goto L41;
        return true;
    L35:
        r10 = null;
        goto L36
    L27:
        r9 = null;
        goto L28
    L22:
        r8 = null;
    L41:
        return false;
    L15:
        r7 = null;
    L7:
        r2 = null;
        goto L8
    }

    public static final boolean g(LocalVideoData r4, LocalVideoData r5) {
        Integer r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.vid;
    L6:
        String r2 = "";
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r5 == null) goto L11;
        String r3 = r5.vid;
    L12:
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        if (Intrinsics.areEqual(r1, r3) == false) goto L61;
        if (r4 == null) goto L18;
        String r6 = r4.videoPath;
    L19:
        if (r6 != null) goto L21;
        r6 = "";
    L21:
        if (r5 == null) goto L23;
        String r7 = r5.videoPath;
    L24:
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        if (Intrinsics.areEqual(r6, r7) == false) goto L61;
        if (r4 == null) goto L30;
        String r8 = r4.uri;
    L31:
        if (r8 != null) goto L33;
        r8 = "";
    L33:
        if (r5 == null) goto L35;
        String r9 = r5.uri;
    L36:
        if (r9 != null) goto L39;
        r9 = "";
    L39:
        if (Intrinsics.areEqual(r8, r9) == false) goto L61;
        if (r4 == null) goto L42;
        String r10 = j(r4);
    L43:
        if (r10 != null) goto L45;
        r10 = "";
    L45:
        if (r5 == null) goto L47;
        String r11 = j(r5);
    L48:
        if (r11 == null) goto L52;
        r2 = r11;
    L52:
        if (Intrinsics.areEqual(r10, r2) == false) goto L61;
        if (r4 == null) goto L55;
        Integer r12 = r4.status;
    L56:
        if (r5 == null) goto L59;
        r0 = r5.status;
    L59:
        if (Intrinsics.areEqual(r12, r0) == false) goto L61;
        return true;
    L55:
        r12 = null;
        goto L56
    L47:
        r11 = null;
        goto L48
    L42:
        r10 = null;
        goto L43
    L35:
        r9 = null;
        goto L36
    L30:
        r8 = null;
        goto L31
    L23:
        r7 = null;
        goto L24
    L18:
        r6 = null;
    L61:
        return false;
    L11:
        r3 = null;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public static final Size a(CreationItem r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Integer r0 = r6.type;
        if (r0 != null) goto L6;
    L23:
        int r1 = 0;
        if (r0 == null) goto L43;
        if (r0.intValue() != 4) goto L43;
        LocalVideoData r2 = r6.localVideo;
        if (r2 == null) goto L33;
        Long r3 = r2.width;
        if (r3 == null) goto L33;
        int r4 = (int) r3.longValue();
    L34:
        Integer r5 = Integer.valueOf(r4);
        LocalVideoData r9 = r6.localVideo;
        if (r9 == null) goto L39;
        Long r10 = r9.height;
        if (r10 == null) goto L39;
        r1 = (int) r10.longValue();
    L39:
        Pair r11 = new Pair(r5, Integer.valueOf(r1));
    L40:
        int r12 = b.a;
        return b.a(r7, r8, ((Number) r11.getFirst()).intValue(), ((Number) r11.getSecond()).intValue(), r6.type);
    L33:
        r4 = 0;
    L43:
        return new Size(0, 0);
    L6:
        if (r0.intValue() != 3) goto L23;
        LocalImageData r13 = r6.localImage;
        long r14 = 0;
        if (r13 == null) goto L14;
        LocalImageMeta r15 = r13.localImageOriRaw;
        if (r15 == null) goto L14;
        Long r16 = r15.width;
        if (r16 == null) goto L14;
        long r17 = r16.longValue();
    L15:
        Integer r18 = Integer.valueOf((int) r17);
        LocalImageData r19 = r6.localImage;
        if (r19 == null) goto L22;
        LocalImageMeta r20 = r19.localImageOriRaw;
        if (r20 == null) goto L22;
        Long r21 = r20.height;
        if (r21 == null) goto L22;
        r14 = r21.longValue();
    L22:
        r11 = new Pair(r18, Integer.valueOf((int) r14));
    L14:
        r17 = 0;
        goto L15
    }

    public static final int c(Message r5, String r6, CreationItem r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "blockId");
        Intrinsics.checkNotNullParameter(r7, "creationItem");
        Iterator r8 = com.larus.im.bean.message.a.k(r5).iterator();
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L40;
        Block r2 = (Block) r8.next();
        if (Intrinsics.areEqual(r2.getBlockId(), r6) == true) goto L16;
        BlockContent r3 = r2.getContent();
        if (r3 == null) goto L14;
        CreationBlock r4 = r3.getCreationBlock();
        if (r4 == null) goto L14;
        List r9 = r4.creations;
        if (r9 == null) goto L14;
        int r10 = r9.size();
    L15:
        r1 = r1 + r10;
    L14:
        r10 = 0;
        goto L15
    L16:
        BlockContent r11 = r2.getContent();
        if (r11 == null) goto L35;
        CreationBlock r12 = r11.getCreationBlock();
        if (r12 == null) goto L35;
        List r13 = r12.creations;
        if (r13 == null) goto L35;
        Iterator r14 = r13.iterator();
        int r15 = 0;
    L24:
        if (r14.hasNext() == false) goto L35;
        CreationItem r16 = (CreationItem) r14.next();
        if (a.e(r16, r7) == false) goto L28;
    L31:
        boolean r17 = true;
    L32:
        if (r17 == true) goto L36;
        r15 = r15 + 1;
    L36:
        if (r15 != (-1)) goto L39;
        return -1;
    L39:
        return r1 + r15;
    L28:
        if (d(r16, r7) == true) goto L31;
        r17 = false;
    L35:
        r15 = -1;
        goto L36
    L40:
        return -1;
    }

    public static final Image q(String r9, Long r10, Long r11) {
        if (r10 == null) goto L5;
        long r3 = r10.longValue();
    L6:
        if (r11 == null) goto L8;
        long r5 = r11.longValue();
    L10:
        return new Image(r9, r9, r3, r5, 16);
    L8:
        r5 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public static final cz9.b n(CreationItem r10, Message r11, String r12, int r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "blockId");
        Integer r1 = r10.type;
        if (r1 != null) goto L6;
    L12:
        if (r1 != null) goto L15;
    L21:
        return null;
    L15:
        if (r1.intValue() != 4) goto L21;
        if (r11 == null) goto L19;
        int r6 = c(r11, r12, r10);
    L24:
        return new n(2, r13, r14, r10, r11, r6, !r15, false);
    L19:
        r6 = 0;
        goto L24
    L6:
        if (r1.intValue() != 3) goto L12;
        if (r11 == null) goto L10;
        int r7 = c(r11, r12, r10);
    L23:
        return new m(1, r13, r14, r10, r11, r7, !r15, 1792);
    L10:
        r7 = 0;
        goto L23
    }
}
