package com.larus.bmhome.debug;

import android.app.Application;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.LocalImageMeta;
import com.larus.im.bean.message.LocalVideoData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o0 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            return "ResolvedMockAsset(localPath=" + this.a + ", uri=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "localPath");
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static CreationItem c() {
        a r0 = d("/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783491283917.mp4");
        a r1 = d("/mnt/sdcard/Android/data/com.larus.nova/cache/zeus_com.obric.aiagent.plugin/omni_exports/1783437666678.png");
        LocalVideoData r11 = new LocalVideoData("mock_local_video_1", new Cover(r1.a, null, null, new LocalImageMeta(r1.a, 1280L, 720L, "image/png"), 6, null), 3, "video/mp4", r0.a, r0.b, 1280L, 720L, Double.valueOf(10.0d));
        return new CreationItem(4, "mock_local_video_1", null, Boolean.FALSE, null, null, null, r11, 116, null);
    }

    public static List a(String r10) {
        Application r0 = AppHost.a.getApplication();
        String r1 = new PolarisFileWrapper(r10).getName();
        String r2 = StringsKt.substringAfter(r10, "/cache/", "");
        LinkedHashSet r3 = new LinkedHashSet();
        if ((!StringsKt.isBlank(r2)) == false) goto L5;
        r3.add(r2);
    L5:
        r3.add("zeus_com.obric.aiagent.plugin/omni_exports/" + r1);
        r3.add("omni_exports/" + r1);
        List r4 = CollectionsKt.listOfNotNull(new File[]{r0.getExternalCacheDir(), r0.getCacheDir(), r0.getExternalFilesDir(null), r0.getFilesDir()});
        LinkedHashSet r5 = new LinkedHashSet();
        r5.add(r10);
        r5.add(StringsKt.replace$default(r10, "/mnt/sdcard/", "/storage/emulated/0/", false, 4, null));
        Iterator r11 = r4.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        File r6 = (File) r11.next();
        Iterator r7 = r3.iterator();
    L10:
        if (r7.hasNext() == false) goto L7;
        r5.add(new PolarisFileWrapper(r6, (String) r7.next()).getAbsolutePath());
        goto L10
    L12:
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r8 = r5.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r12.add(new PolarisFileWrapper((String) r8.next()));
        goto L14
    L16:
        return r12;
    }

    public static a d(String r4) {
        Iterator r0 = ((ArrayList) a(r4)).iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((File) r1).exists() == false) goto L3;
    L9:
        File r3 = (File) r1;
        if (r3 == null) goto L15;
        String r5 = r3.getAbsolutePath();
        if (r5 == null) goto L15;
        r4 = r5;
    L22:
        return new a(r4, "file://".concat(r4));
    L15:
        File r6 = (File) CollectionsKt.firstOrNull(a(r4));
        if (r6 == null) goto L18;
        r2 = r6.getAbsolutePath();
    L18:
        if (r2 == null) goto L22;
        r4 = r2;
        goto L22
    L8:
        r1 = null;
        goto L9
    }

    public static CreationItem b(String r11, String r12) {
        a r13 = d(r12);
        LocalImageData r7 = new LocalImageData(r13.b, 2, new LocalImageMeta(r13.a, 2848L, 1600L, "image/png"));
        return new CreationItem(3, r11, null, Boolean.FALSE, null, null, r7, null, 180, null);
    }
}
