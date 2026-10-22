package c12;

import com.bytedance.android.live.revenue.common.c0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends fd6.e {
    public final boolean c;

    public a(h r3) {
        Intrinsics.checkNotNullParameter(r3, "mInputProducer");
        super(r3);
        boolean r0 = true;
        if (((Number) com.bytedance.android.livesdk.gift.platform.business.b.C.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[27])).intValue() == 1) goto L6;
        r0 = false;
    L6:
        this.c = r0;
    }

    public final void b(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r13, Object r14) {
        String r15 = (String) r14;
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r15, "s");
        GiftResourceFileCacheService r2 = (GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class);
        if (r2.h().getEnable() == false) goto L51;
        Intrinsics.checkNotNullParameter(r13, "request");
        StringBuilder r0 = new StringBuilder();
        int r1 = uy0.a.a;
        String r3 = r2.f();
        if (r3 != null) goto L7;
        r3 = BuildConfig.FLAVOR;
    L7:
        r0.append(uy0.a.a(r3));
        r0.append(r13.k);
        String r4 = r0.toString();
        new PolarisFileWrapper(r4).mkdirs();
        if (this.c == false) goto L28;
        PolarisZipFileWrapper r5 = new PolarisZipFileWrapper(r15);
        Enumeration<? extends ZipEntry> r16 = r5.entries();
    L11:
        if (r16.hasMoreElements() == false) goto L27;
        ZipEntry r7 = r16.nextElement();
        String r8 = r7.getName();
        if (r8.contains("../") == true) goto L11;
        if (r7.isDirectory() == true) goto L17;
        PolarisFileWrapper r9 = new PolarisFileWrapper(r4 + File.separator + r8);
        if (r9.exists() == false) goto L21;
        r9.delete();
    L22:
        r9.createNewFile();
        BufferedOutputStream r10 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r9));
        byte[] r11 = new byte[2048];
        InputStream r17 = r5.getInputStream(r7);
    L23:
        int r18 = r17.read(r11);
        if (r18 == (-1)) goto L26;
        r10.write(r11, 0, r18);
        goto L23
    L26:
        r10.flush();
        r10.close();
        r17.close();
        goto L11
    L21:
        r9.getParentFile().mkdirs();
        goto L22
    L17:
        new PolarisFileWrapper(r4 + File.separator + r8).mkdirs();
        goto L11
    L27:
        r5.close();
    L47:
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a r19 = ((fd6.e) this).a;
        if (r19 == null) goto L50;
        r19.b(r13, r4);
    L50:
        c0.b(new PolarisFileWrapper(r2.a(r13)));
        return;
    L28:
        ZipInputStream r6 = new ZipInputStream(new BufferedInputStream(new PolarisFileInputStreamWrapper(r15)));
    L29:
        ZipEntry r110 = r6.getNextEntry();
        if (r110 == null) goto L46;
        String r20 = r110.getName();
        if (r20.contains("../") == true) goto L29;
        if (r110.isDirectory() == true) goto L36;
        PolarisFileWrapper r111 = new PolarisFileWrapper(r4 + File.separator + r20);
        if (r111.exists() == false) goto L40;
        r111.delete();
    L41:
        r111.createNewFile();
        BufferedOutputStream r21 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r111));
        byte[] r112 = new byte[2048];
    L42:
        int r23 = r6.read(r112);
        if (r23 == (-1)) goto L45;
        r21.write(r112, 0, r23);
        goto L42
    L45:
        r21.flush();
        r21.close();
        goto L29
    L40:
        r111.getParentFile().mkdirs();
        goto L41
    L36:
        new PolarisFileWrapper(r4 + File.separator + r20).mkdirs();
        goto L29
    L46:
        r6.close();
        goto L47
    L51:
        Intrinsics.checkNotNullParameter(r13, "request");
        Intrinsics.checkNotNullParameter(r15, "s");
        Ref.ObjectRef r24 = new Ref.ObjectRef();
        r24.element = r15.substring(0, StringsKt.lastIndexOf$default(r15, "/", 0, false, 6, null));
        uy0.b r25 = com.bytedance.android.live.revenue.core.util.f.a(uy0.b.class);
        r25.unZipFolder(r15, (String) r24.element).subscribe(new fd6.c(this, r13, r24, r25, r15), new fd6.d(this, r13, r25, r24));
    }
}
