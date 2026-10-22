package com.larus.dora.impl.dynamic.loader;

import android.content.Context;
import c59.z;
import com.bytedance.dora.annotation.ProductNameType;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceTheme;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.dora.impl.resource.j0;
import com.larus.dora.impl.resource.k;
import com.larus.dora.impl.util.s;
import com.larus.dora.impl.util.u;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DslLocalCache {
    public static final Set<String> a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/larus/dora/impl/dynamic/loader/DslLocalCache$PageName;", "", "productId", "", "pageKey", "", "resourceId", "<init>", "(Ljava/lang/String;IILjava/lang/String;I)V", "getProductId", "()I", "getPageKey", "()Ljava/lang/String;", "getResourceId", "KEY_DEVICE_LIST", "KEY_DEVICE_LIST_P", "KEY_LITE_BIND_DEVICE", "KEY_LITE_DYNAMIC_PAGE", "KEY_LITE_DYNAMIC_PAGE_P", "KEY_H_BIND_DEVICE", "KEY_H_DYNAMIC_PAGE", "KEY_H_BIND_DEVICE_P", "KEY_H_DYNAMIC_PAGE_P", "KEY_H_DYNAMIC_PAGE_P_G_O", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageName extends Enum<PageName> {
        public static final PageName KEY_DEVICE_LIST = null;
        public static final PageName KEY_DEVICE_LIST_P = null;
        public static final PageName KEY_H_BIND_DEVICE = null;
        public static final PageName KEY_H_BIND_DEVICE_P = null;
        public static final PageName KEY_H_DYNAMIC_PAGE = null;
        public static final PageName KEY_H_DYNAMIC_PAGE_P = null;
        public static final PageName KEY_H_DYNAMIC_PAGE_P_G_O = null;
        public static final PageName KEY_LITE_BIND_DEVICE = null;
        public static final PageName KEY_LITE_DYNAMIC_PAGE = null;
        public static final PageName KEY_LITE_DYNAMIC_PAGE_P = null;
        public static final /* synthetic */ PageName[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String pageKey;
        private final int productId;
        private final int resourceId;

        public static EnumEntries<PageName> getEntries() {
            return b;
        }

        static {
            PageName r6 = new PageName("KEY_DEVICE_LIST", 0, 1, "device_list_v2", 2131820582);
            KEY_DEVICE_LIST = r6;
            PageName r0 = new PageName("KEY_DEVICE_LIST_P", 1, 1, "device_list_p_v2", 2131820581);
            KEY_DEVICE_LIST_P = r0;
            PageName r1 = new PageName("KEY_LITE_BIND_DEVICE", 2, 1, "bind_device_v2", 2131820598);
            KEY_LITE_BIND_DEVICE = r1;
            PageName r2 = new PageName("KEY_LITE_DYNAMIC_PAGE", 3, 1, "device_manage_v3", 2131820599);
            KEY_LITE_DYNAMIC_PAGE = r2;
            PageName r3 = new PageName("KEY_LITE_DYNAMIC_PAGE_P", 4, 1, "device_manage_p_v3", 2131820600);
            KEY_LITE_DYNAMIC_PAGE_P = r3;
            int r5 = ProductNameType.H_FREE_CLIP_2.id;
            PageName r4 = new PageName("KEY_H_BIND_DEVICE", 5, r5, "bind_device_v2", 2131820590);
            KEY_H_BIND_DEVICE = r4;
            PageName r7 = new PageName("KEY_H_DYNAMIC_PAGE", 6, r5, "device_manage_v3", 2131820594);
            KEY_H_DYNAMIC_PAGE = r7;
            PageName r8 = new PageName("KEY_H_BIND_DEVICE_P", 7, r5, "bind_device_p_v2", 2131820590);
            KEY_H_BIND_DEVICE_P = r8;
            PageName r9 = new PageName("KEY_H_DYNAMIC_PAGE_P", 8, r5, "device_manage_p_v3", 2131820592);
            KEY_H_DYNAMIC_PAGE_P = r9;
            PageName r16 = new PageName("KEY_H_DYNAMIC_PAGE_P_G_O", 9, r5, "device_manage_p_v3_h_g_o", u.a.b("larus_dora_h_device_manager_p_v3_g_o"));
            KEY_H_DYNAMIC_PAGE_P_G_O = r16;
            PageName[] r10 = {r6, r0, r1, r2, r3, r4, r7, r8, r9, r16};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
        }

        public static PageName[] values() {
            return (PageName[]) a.clone();
        }

        public final String getPageKey() {
            return this.pageKey;
        }

        public final int getProductId() {
            return this.productId;
        }

        public final int getResourceId() {
            return this.resourceId;
        }

        public static PageName valueOf(String r1) {
            return (PageName) r27.a.a(PageName.class, r1);
        }

        public PageName(String r1, int r2, int r3, String r4, int r5) {
            super(r1, r2);
            this.productId = r3;
            this.pageKey = r4;
            this.resourceId = r5;
        }
    }

    public static final class a {
    }

    public DslLocalCache() {
    }

    static {
        a = SetsKt.setOf(new String[]{"auto_test", "dora_g_longcheer_test"});
    }

    public static String b(String r3) {
        if (s.a() == true) goto L5;
        return null;
    L5:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{PageName.KEY_DEVICE_LIST.getPageKey(), PageName.KEY_DEVICE_LIST_P.getPageKey()}), r3) == true) goto L8;
        return null;
    L8:
        if (a.contains(AppHost.a.getBuildChannel()) == false) goto L10;
        return "larus_dora_g_device_list_v2_auto_test";
    L10:
        return "larus_dora_g_device_list_v2";
    }

    public static int c(String r2) {
        PageName r0 = PageName.KEY_DEVICE_LIST;
        if (Intrinsics.areEqual(r2, r0.getPageKey()) == true) goto L10;
        PageName r1 = PageName.KEY_DEVICE_LIST_P;
        if (Intrinsics.areEqual(r2, r1.getPageKey()) == true) goto L11;
        return 0;
    L11:
        return r1.getResourceId();
    L10:
        return r0.getResourceId();
    }

    public static Integer d(Integer r2) {
        int r0 = ProductNameType.H_FREE_BUDS_PRO_5.id;
        if (r2 != null) goto L6;
    L8:
        int r1 = ProductNameType.H_FREE_CLIP_2.id;
        if (r2 != null) goto L12;
    L14:
        int r3 = ProductNameType.H_FREE_CLIP_2_HE.id;
        if (r2 != null) goto L18;
    L20:
        return null;
    L18:
        if (r2.intValue() != r3) goto L20;
        return e("larus_dora_h_free_clip_2_he_obric_explore");
    L12:
        if (r2.intValue() != r1) goto L14;
        return e("larus_dora_h_free_clip_2_obric_explore");
    L6:
        if (r2.intValue() != r0) goto L8;
        return e("larus_dora_h_free_buds_pro_5_obric_explore");
    }

    public static Integer e(String r1) {
        Integer r2 = Integer.valueOf(u.a.b(r1));
        if (r2.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r2;
    L5:
        r0 = false;
        goto L6
    }

    public static z f(Context r9, Integer r10, String r11, DoraResourceDeviceType r12) {
        if (r12 != null) goto L13;
        int r13 = ProductNameType.DORA_G.id;
        if (r10 == null) goto L10;
        if (r10.intValue() != r13) goto L10;
        r12 = DoraResourceDeviceType.G1;
    L10:
        if (o59.a.m(r10) == false) goto L12;
        r12 = DoraResourceDeviceType.G2;
        goto L13
    L12:
        r12 = DoraResourceDeviceType.G_SERIES;
    L13:
        j0 r0 = j0.a;
        DoraResourceType r1 = DoraResourceType.RAW;
        DoraResourceTheme r2 = DoraResourceTheme.LIGHT;
        r0.getClass();
        k r3 = j0.e(r12, r1, r11, r2);
        Object r4 = null;
        if ((r3 instanceof k.a) == false) goto L17;
        g49.d.d("DslLocalCache", "read G DSL resolved APK: productId=" + r10 + ", deviceType=" + r12 + ", resourceName=" + r11 + ", resourceId=" + ((k.a) r3).a);
    L19:
        u.a.getClass();
        String r14 = u.e(r9, r12, r11);
        if (r14 != null) goto L41;
        g49.d.e("DslLocalCache", "read G DSL content empty: productId=" + r10 + ", deviceType=" + r12 + ", resourceName=" + r11);
        return null;
    L41:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L25
        Object r6 = Result.constructor-impl((z) new Gson().fromJson(r14, z.class));     // Catch: Throwable -> L25
    L27:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L31;
        g49.d.c("DslLocalCache", "parse G DSL failed: productId=" + r10 + ", deviceType=" + r12 + ", resourceName=" + r11 + ", size=" + r14.length(), r7);
    L31:
        if (Result.isFailure-impl(r6) == true) goto L35;
        r4 = r6;
    L35:
        return (z) r4;
    L25:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L17:
        if ((r3 instanceof k.b) == false) goto L36;
        StringBuilder r15 = new StringBuilder("read G DSL resolved file: productId=");
        r15.append(r10);
        r15.append(", deviceType=");
        r15.append(r12);
        r15.append(", resourceName=");
        r15.append(r11);
        r15.append(", source=");
        k.b r16 = (k.b) r3;
        r15.append(r16.b);
        r15.append(", path=");
        r15.append(r16.a.getAbsolutePath());
        r15.append(", exists=");
        r15.append(r16.a.exists());
        r15.append(", size=");
        r15.append(r16.a.length());
        g49.d.d("DslLocalCache", r15.toString());
        goto L19
    L36:
        if (r3 != null) goto L40;
        g49.d.e("DslLocalCache", "read G DSL resource missing: productId=" + r10 + ", deviceType=" + r12 + ", resourceName=" + r11);
        return null;
    L40:
        throw new NoWhenBranchMatchedException();
    }

    public static z a(Context r5, Integer r6, Integer r7, String r8, DoraResourceDeviceType r9) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r6 != null) goto L129;
    L13:
        PageName r3 = PageName.KEY_DEVICE_LIST;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r3.getPageKey()) == false) goto L16;
    L17:
        String r4 = b(r8);     // Catch: Exception -> L124
        if (r4 == null) goto L22;
        z r10 = f(r5, r7, r4, r9);     // Catch: Exception -> L124
        if (r10 == null) goto L22;
        return r10;
    L22:
        if (r6 != null) goto L25;
    L72:
        if (r6 != null) goto L75;
    L97:
        if (r6 != null) goto L100;
    L107:
        Integer r11 = null;
    L108:
        if (r11 != null) goto L110;
        return null;
    L110:
        if (r11.intValue() <= 0) goto L133;
        Reader r12 = new InputStreamReader(r5.getResources().openRawResource(r11.intValue()), Charsets.UTF_8);     // Catch: Exception -> L124
        if ((r12 instanceof BufferedReader) == false) goto L115;
        BufferedReader r13 = (BufferedReader) r12;     // Catch: Exception -> L124
    L127:
        String r14 = TextStreamsKt.readText(r13);     // Catch: Throwable -> L119
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L124
        return (z) new Gson().fromJson(r14, z.class);
    L119:
        th = move-exception;
        throw th;     // Catch: Throwable -> L121
    L121:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L124
        throw th;     // Catch: Exception -> L124
    L124:
        e = move-exception;
        g49.d.b("DoraLocalCache", "fetchData: " + e.getMessage());
        return null;
    L115:
        r13 = new BufferedReader(r12, 8192);     // Catch: Exception -> L124
        goto L127
    L133:
        return null;
    L100:
        if (r6.intValue() != 0) goto L107;
        if (Intrinsics.areEqual(r8, r3.getPageKey()) == false) goto L105;
        r11 = Integer.valueOf(c(r8));     // Catch: Exception -> L124
        goto L108
    L105:
        if (Intrinsics.areEqual(r8, PageName.KEY_DEVICE_LIST_P.getPageKey()) == false) goto L107;
        r11 = Integer.valueOf(c(r8));     // Catch: Exception -> L124
        goto L108
    L75:
        if (r6.intValue() != 4096) goto L97;
        if (Intrinsics.areEqual(r8, r3.getPageKey()) == false) goto L79;
        r11 = Integer.valueOf(c(r8));     // Catch: Exception -> L124
        goto L108
    L79:
        PageName r15 = PageName.KEY_H_BIND_DEVICE;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r15.getPageKey()) == false) goto L82;
        r11 = Integer.valueOf(r15.getResourceId());     // Catch: Exception -> L124
        goto L108
    L82:
        PageName r16 = PageName.KEY_H_DYNAMIC_PAGE;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r16.getPageKey()) == false) goto L85;
        r11 = Integer.valueOf(r16.getResourceId());     // Catch: Exception -> L124
        goto L108
    L85:
        PageName r17 = PageName.KEY_H_DYNAMIC_PAGE_P;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r17.getPageKey()) == false) goto L88;
        r11 = Integer.valueOf(r17.getResourceId());     // Catch: Exception -> L124
        goto L108
    L88:
        PageName r18 = PageName.KEY_H_BIND_DEVICE_P;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r18.getPageKey()) == false) goto L92;
        r11 = Integer.valueOf(r18.getResourceId());     // Catch: Exception -> L124
        goto L108
    L92:
        if (Intrinsics.areEqual(r8, "obric_explore") == false) goto L95;
        r11 = d(r7);     // Catch: Exception -> L124
        goto L108
    L95:
        if (Intrinsics.areEqual(r8, "device_manage_p_v3_h_g_o") == false) goto L107;
        r11 = Integer.valueOf(PageName.KEY_H_DYNAMIC_PAGE_P_G_O.getResourceId());     // Catch: Exception -> L124
        goto L108
    L25:
        if (r6.intValue() != 1) goto L72;
        if (Intrinsics.areEqual(r8, r3.getPageKey()) == false) goto L30;
        r11 = Integer.valueOf(c(r8));     // Catch: Exception -> L124
        goto L108
    L30:
        if (Intrinsics.areEqual(r8, PageName.KEY_DEVICE_LIST_P.getPageKey()) == false) goto L32;
        r11 = Integer.valueOf(c(r8));     // Catch: Exception -> L124
        goto L108
    L32:
        PageName r20 = PageName.KEY_LITE_BIND_DEVICE;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r20.getPageKey()) == false) goto L44;
        int r21 = r20.getProductId();     // Catch: Exception -> L124
        if (r7 != null) goto L38;
    L41:
        if (o59.a.o(r7) == false) goto L107;
        return f(r5, r7, "larus_dora_g_bind_device_v2", null);
    L38:
        if (r7.intValue() != r21) goto L41;
        r11 = Integer.valueOf(r20.getResourceId());     // Catch: Exception -> L124
        goto L108
    L44:
        PageName r22 = PageName.KEY_LITE_DYNAMIC_PAGE;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r22.getPageKey()) == false) goto L56;
        int r23 = r22.getProductId();     // Catch: Exception -> L124
        if (r7 != null) goto L50;
    L53:
        if (o59.a.o(r7) == false) goto L107;
        return f(r5, r7, "larus_dora_g_device_manage_v2", null);
    L50:
        if (r7.intValue() != r23) goto L53;
        r11 = Integer.valueOf(r22.getResourceId());     // Catch: Exception -> L124
        goto L108
    L56:
        PageName r24 = PageName.KEY_LITE_DYNAMIC_PAGE_P;     // Catch: Exception -> L124
        if (Intrinsics.areEqual(r8, r24.getPageKey()) == false) goto L65;
        int r25 = r24.getProductId();     // Catch: Exception -> L124
        if (r7 == null) goto L107;
        if (r7.intValue() != r25) goto L107;
        r11 = Integer.valueOf(r24.getResourceId());     // Catch: Exception -> L124
        goto L108
    L65:
        if (Intrinsics.areEqual(r8, "obric_explore") == false) goto L107;
        int r26 = ProductNameType.DORA_LITE.id;     // Catch: Exception -> L124
        if (r7 == null) goto L107;
        if (r7.intValue() != r26) goto L107;
        r11 = e("larus_dora_lite_obric_explore");     // Catch: Exception -> L124
        goto L108
    L16:
        if (Intrinsics.areEqual(r8, PageName.KEY_DEVICE_LIST_P.getPageKey()) == false) goto L22;
    L129:
        if (r6.intValue() != 1) goto L13;
        if (Intrinsics.areEqual(r8, "obric_explore") == false) goto L13;
        if (o59.a.o(r7) == false) goto L13;
        return f(r5, r7, "larus_dora_g_obric_explore", null);
    }
}
