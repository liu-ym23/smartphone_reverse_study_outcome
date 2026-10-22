package com.bytedance.android.btm.bridge.bullet.support;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.btm.bridge.b;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import g66.c;
import h16.e;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/btm/bridge/bullet/support/BulletHybridContainerContext;", "Lcom/bytedance/android/btm/bridge/b;", "Lg66/c;", "contextProvider", "", "isLiveContainer", "Landroid/view/View;", "obtainView", "", "getPageUrl", "getHybridContainerType", "LYNX_VIEW_CLAZZ_NAME", "Ljava/lang/String;", "ANNIEX_LIVE__CLAZZ_NAME", "CONTAINER_BID_PARAMS_CLAZZ_NAME", "", "Ljava/lang/Class;", "viewClazzList", "Ljava/util/List;", "Ljava/lang/reflect/Field;", "bidParamField", "Ljava/lang/reflect/Field;", "<init>", "()V", "btm-bridge-bullet-support_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class BulletHybridContainerContext implements b {
    private final String ANNIEX_LIVE__CLAZZ_NAME;
    private final String CONTAINER_BID_PARAMS_CLAZZ_NAME;
    private final String LYNX_VIEW_CLAZZ_NAME;
    private Field bidParamField;
    private final List<Class<? extends View>> viewClazzList;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public BulletHybridContainerContext() {
        this.LYNX_VIEW_CLAZZ_NAME = "com.lynx.tasm.LynxView";
        this.ANNIEX_LIVE__CLAZZ_NAME = "com.bytedance.android.annie.param.AnnieXLiveContext";
        this.CONTAINER_BID_PARAMS_CLAZZ_NAME = "com.bytedance.ies.bullet.deprecate.fake.ContainerBidParam";
        this.viewClazzList = CollectionsKt.mutableListOf(new Class[]{WebView.class});
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_btm_bridge_bullet_support_BulletHybridContainerContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r10) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r11 = access$000(r10);     // Catch: Throwable -> L8
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
        Class r12 = access$000(r10);     // Catch: Throwable -> L17
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

    private final boolean isLiveContainer(c r10) {
        m16.b r11 = (m16.b) r10.c(m16.b.class);
        if (r11 == null) goto L29;
        Set r0 = ((ConcurrentHashMap) r11.a).keySet();
        if (r0 == null) goto L40;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L41;
        Class r12 = (Class) r1.next();
        if (Intrinsics.areEqual(r12.getName(), this.ANNIEX_LIVE__CLAZZ_NAME) == false) goto L15;
        if (r11.c(r12) == null) goto L15;
        return true;
    L15:
        if (Intrinsics.areEqual(r12.getName(), this.CONTAINER_BID_PARAMS_CLAZZ_NAME) == false) goto L8;
        Object r13 = r11.c(r12);
        if (this.bidParamField != null) goto L23;
        Field r14 = INVOKESTATIC_com_bytedance_android_btm_bridge_bullet_support_BulletHybridContainerContext_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(this.CONTAINER_BID_PARAMS_CLAZZ_NAME).getDeclaredField("bid");     // Catch: Exception -> L28
        this.bidParamField = r14;     // Catch: Exception -> L28
        if (r14 != null) goto L22;
        Intrinsics.throwNpe();     // Catch: Exception -> L28
    L22:
        r14.setAccessible(true);     // Catch: Exception -> L28
    L23:
        Field r15 = this.bidParamField;     // Catch: Exception -> L28
        if (r15 != null) goto L26;
        Intrinsics.throwNpe();     // Catch: Exception -> L28
    L26:
        return Intrinsics.areEqual(r15.get(r13), "webcast");
    L41:
        return false;
    L40:
        return false;
    L29:
        return false;
    }

    @Override // com.bytedance.android.btm.bridge.b
    public String getHybridContainerType(c r10) {
        View r0 = obtainView(r10);
        if (r0 != null) goto L5;
    L7:
        if (r0 == null) goto L9;
        return "bullet";
    L9:
        return "unkown";
    L5:
        if (isLiveContainer(r10) == false) goto L7;
        return "anniex_live";
    }

    @Override // com.bytedance.android.btm.bridge.b
    public String getPageUrl(c r10) {
        e r11 = (e) r10.c(e.class);
        if (r11 == null) goto L9;
        BulletContext r12 = r11.getBulletContext();
        if (r12 == null) goto L9;
        Uri r13 = r12.k;
        if (r13 == null) goto L9;
        return r13.toString();
    L9:
        return null;
    }

    @Override // com.bytedance.android.btm.bridge.b
    public View obtainView(c r10) {
        m16.b r11 = (m16.b) r10.c(m16.b.class);
        if (r11 == null) goto L25;
        Iterator r0 = ((ConcurrentHashMap) r11.a).keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L13;
        Class r1 = (Class) r0.next();
        if (Intrinsics.areEqual(r1.getName(), this.LYNX_VIEW_CLAZZ_NAME) == false) goto L6;
        Object r12 = r11.c(r1);
        if ((r12 instanceof View) == false) goto L6;
        return (View) r12;
    L13:
        Iterator<Class<? extends View>> r13 = this.viewClazzList.iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        View r14 = (View) r11.c(r13.next());
        if (r14 == null) goto L15;
        return r14;
    L19:
        Iterator r15 = ((List) HybridViewClassManager.a.getValue()).iterator();
    L21:
        if (r15.hasNext() == false) goto L39;
        View r16 = (View) r11.c((Class) r15.next());
        if (r16 == null) goto L21;
        return r16;
    L39:
        return null;
    L25:
        return null;
    }
}
