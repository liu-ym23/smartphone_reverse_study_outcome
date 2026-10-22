package ua;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.core.kit.bridge.h;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.salamander.anniex.AnnieXCommonUIViewModel;
import com.bytedance.salamander.anniex.AnnieXLoadingViewModel;
import com.bytedance.salamander.anniex.AnnieXSLEngineType;
import com.bytedance.salamander.anniex.f;
import com.bytedance.salamander.anniex.g3;
import com.bytedance.salamander.anniex.l;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;
import y36.e;
import y36.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class b implements ia.c, ua.a {
    public final Activity a;
    public final AnnieXCommonUIViewModel b;
    public final t36.d c;
    public final Function1<Boolean, Unit> d;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.q();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // ia.c
    public final void bindContainerId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "containerId");
    }

    @Override // ia.c
    public final boolean canBackPress() {
        return false;
    }

    @Override // ia.c
    public final boolean canGoBack() {
        return false;
    }

    @Override // ia.c
    public final void enterBackground() {
    }

    @Override // ia.c
    public final void enterForeground() {
    }

    @Override // ia.c
    public final void finish() {
    }

    @Override // ia.c
    public final String getBDXTag() {
        return null;
    }

    @Override // ia.c
    public final m16.b getContextProviderFactory() {
        return null;
    }

    @Override // ia.c
    public final t36.d getCurrentSchema() {
        return null;
    }

    @Override // ia.c
    public final View getKitView() {
        return null;
    }

    @Override // ia.c
    public final Context getSystemContext() {
        return null;
    }

    @Override // ia.c
    public final void goBack() {
    }

    @Override // ia.c
    public final void hideError() {
    }

    @Override // ia.c
    public final void loadSchema(String r1, Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }

    @Override // ia.c
    public final void onAttachToWindow() {
    }

    @Override // ia.c
    public final void onCreate(Bundle r1) {
    }

    @Override // ia.c
    public final void onVisibleChange(boolean r1, Boolean r10) {
    }

    @Override // ia.c
    public final <T> void registerWeakHolder(Class<T> r1, T r10) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
    }

    @Override // ia.c
    public final void reloadTemplate(Map<String, ? extends Object> r1) {
    }

    @Override // ia.c
    public final void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }

    @Override // ia.c
    public final void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalProps");
    }

    @Override // ia.c
    public final void updateScreenMetrics(int r1, int r10) {
    }

    @Override // ia.c
    public final LaunchMode getBDXLaunchMode() {
        LaunchMode r0 = (LaunchMode) ((i) new e(this.c, null)).b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return LaunchMode.MODE_UNSPECIFIED;
    }

    @Override // ia.c
    public final String getBid() {
        return ((f) this.b.f()).a;
    }

    @Override // ia.c
    public final String getContainerId() {
        return ((f) this.b.f()).e;
    }

    @Override // ia.c
    public final String getCurrentUrl() {
        return ((f) this.b.f()).c;
    }

    @Override // ia.c
    public final KitType getKitType() {
        if (((f) this.b.f()).b != AnnieXSLEngineType.lynx) goto L6;
        return KitType.LYNX;
    L6:
        return KitType.WEB;
    }

    @Override // ia.c
    public final WeakReference<Context> getWeakContext() {
        return new WeakReference(this.b.f().a().getContext());
    }

    @Override // ia.c
    public final void hideLoading() {
        AnnieXLoadingViewModel r0 = this.b.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_loadingViewModel");
        r0 = null;
    L5:
        r0.a(null, false, true);
    }

    @Override // ia.c
    public final void release() {
        g3 r0 = this.b.a().a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
        r0 = null;
    L5:
        r0.c();
    }

    @Override // ia.c
    public final Map<String, Long> getPerfMap() {
        return MapsKt.emptyMap();
    }

    public final void q() {
        g3 r10 = null;
        if (getKitType() != KitType.LYNX) goto L10;
        Object r0 = this.b.a().b();
        if ((r0 instanceof AnnieXLynxView) == false) goto L7;
        AnnieXLynxView r1 = (AnnieXLynxView) r0;
    L8:
        if (r1 == null) goto L10;
        i16.c r11 = i16.c.a;
        r1.updateScreenMetrics(i16.c.j(this.a), i16.c.i(this.a));
        goto L10
    L7:
        r1 = null;
    L10:
        AnnieXCommonUIViewModel r12 = this.b;
        r12.getClass();
        l r13 = new l(r12);
        g3 r14 = r12.a().a;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_engine");
    L14:
        r10.a(r13);
        return;
    L13:
        r10 = r14;
        goto L14
    }

    @Override // ia.c
    public final t36.d getSchemaData() {
        return this.c;
    }

    @Override // ia.c
    public final t36.d generateSchemaData(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        return this.c;
    }

    @Override // ia.c
    public final void interceptBackPress(boolean r10) {
        Function1<Boolean, Unit> r0 = this.d;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r10));
        return;
    }

    @Override // ia.c
    public final void onEngineReady(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
    }

    @Override // ia.c
    public final void reload(Map<String, ? extends Object> r10) {
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L5;
        q();
        return;
    L5:
        this.a.runOnUiThread(new a(this));
    }

    @Override // ia.c
    public final void sendEvent(h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Map r0 = new LinkedHashMap();
        if (r10.getParams() == null) goto L10;
        Object r1 = r10.getParams();
        if ((r1 instanceof JSONObject) == false) goto L8;
        ConvertUtils r11 = ConvertUtils.INSTANCE;
        Object r12 = r10.getParams();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type org.json.JSONObject");
        Map r13 = r11.jsonToMap((JSONObject) r12);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.bytedance.rts.foundation.RTSMapKt.RTSMap<kotlin.String, kotlin.Any> }");
        r0 = TypeIntrinsics.asMutableMap(r13);
        goto L10
    L8:
        if ((r1 instanceof HashMap) == false) goto L10;
        Object r14 = r10.getParams();
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>{ com.bytedance.rts.foundation.RTSMapKt.RTSMap<kotlin.String, kotlin.Any> }");
        r0 = TypeIntrinsics.asMutableMap(r14);
    L10:
        this.b.a().a().sendEvent(r10.getName(), r0);
    }

    @Override // ia.c
    public final void showLoading(String r10) {
        AnnieXLoadingViewModel r0 = this.b.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_loadingViewModel");
        r0 = null;
    L5:
        r0.a(r10, true, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Activity r10, AnnieXCommonUIViewModel r11, t36.d r12, Function1<? super Boolean, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "selfActivity");
        Intrinsics.checkNotNullParameter(r11, "annieXCommonUIViewModel");
        Intrinsics.checkNotNullParameter(r12, "schemaData");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
