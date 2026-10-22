package com.bytedance.android.ec.core.anchorv3;

import android.content.Context;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.common.profilesdk.snapboost.ClassList;
import com.bytedance.common.profilesdk.snapboost.ProfileEditor;
import com.bytedance.common.profilesdk.snapboost.SnapBoost;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public h() {
    }

    public static final void c() {
        if (com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getApplicationContext() == null) goto L10;
        a("com.bytedance.android.shopping.slice.preload.SlcCodeWarmUp").getMethod("warmUp", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L6
        return;
    L6:
        Unit r0 = Unit.INSTANCE;
        return;
    }

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r11 = Class.forName(r10);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L8
    L7:
        return r11;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r10);
    L12:
        throw th;
    L34:
        Class<?> r12 = Class.forName(r10);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r10);     // Catch: Throwable -> L17
    L16:
        return r12;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r10);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r10);
    }

    public static final void b(List r10) {
        long r0 = System.currentTimeMillis();
        if (SnapBoost.hasInited() == true) goto L8;
        Context r11 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostAppInfo().getApplicationContext();
        if (r11 == null) goto L48;
        SnapBoost.init(r11, false);
        goto L8
    L48:
        return;
    L8:
        List r12 = r10;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r13.add(SnapBoost.findClassList((String) r14.next()));
        goto L10
    L12:
        ProfileEditor r15 = SnapBoost.createEditorBuidler().name("ecom_pdp").version("1").build();
        Iterator r16 = r13.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.addClassList((ClassList) r16.next());
        goto L14
    L16:
        int r17 = r15.commit();
        long r18 = System.currentTimeMillis() - r0;
        long r1 = System.currentTimeMillis();
        if (r17 != ProfileEditor.RESULT_FAILED_UNSUPPORTED) goto L19;
    L30:
        int r19 = ECSdk.a;
        cj.b r20 = (cj.b) ECSdk.a(cj.b.class);
        if (r20 == null) goto L33;
        r20.j(r13);
    L33:
        int r21 = com.bytedance.android.ec.core.opt.b.a;
        Intrinsics.checkNotNullParameter("ShoppingPerfOptPreloadClasses", "scene");
        Iterator r22 = r13.iterator();
    L35:
        if (r22.hasNext() == false) goto L37;
        ((ClassList) r22.next()).tryPreloadClasses();
        goto L35
    L37:
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r24 = r13.iterator();
    L39:
        if (r24.hasNext() == false) goto L41;
        r23.add(Integer.valueOf(((ClassList) r24.next()).getClassNames().size()));
        goto L39
    L41:
        int r25 = CollectionsKt.sumOfInt(r23);
        Lazy r26 = PdpPerfOpt.a;
        PdpPerfOpt.i("preload classes ret=" + r17 + " duration1=" + r18 + " duration2=" + (System.currentTimeMillis() - r1) + " count=" + r25);
        return;
    L19:
        if (r17 == ProfileEditor.RESULT_FAILED_CREATE_LIST) goto L30;
        if (r17 == ProfileEditor.RESULT_FAILED_CREATE_PROFILE) goto L30;
        if (r17 == ProfileEditor.RESULT_FAILED_MERGE_CUR) goto L30;
        if (r17 == ProfileEditor.RESULT_COMPILED_NOIMAGE) goto L30;
        if (r17 == ProfileEditor.RESULT_FAILED_COMPILED) goto L30;
        Lazy r27 = PdpPerfOpt.a;
        PdpPerfOpt.i("preload classes ret=" + r17 + " duration1=" + r18);
    }
}
