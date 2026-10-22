package com.bytedance.android.annie;

import a9.j;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.api.param.AnnieViewType;
import com.bytedance.android.annie.bridge.method.abs.PrerenderParamModel;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.card.web.resource.ForestWebHelper;
import com.bytedance.android.annie.container.dialog.AnnieDialog;
import com.bytedance.android.annie.container.dialog.k;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragmentManager;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.FragmentParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.annie.service.AnnieNGServiceCenter;
import com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.preload.PreLoadUtils;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.monitorV2.AnnieXMonitorConstants;
import com.bytedance.ies.bullet.assembler.settings.BulletMixSwitch;
import com.bytedance.ies.bullet.flow.FlowContainerLoaderSwitch;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.agilelogger.ALog;
import i9.e;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s9.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b^\u0010_J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J2\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J.\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J.\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0007J2\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J,\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J,\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J*\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J4\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J,\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u001c\u0010 \u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007J.\u0010!\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J.\u0010\"\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0014\u0010(\u001a\u00020\u001c2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0007J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001fH\u0007J\u0012\u0010+\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010&H\u0007J6\u00102\u001a\u0002012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00100\u001a\u00020/H\u0002J6\u00105\u001a\u00020,2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00112\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u00104\u001a\u000203H\u0002J\u0016\u00106\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J \u00108\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020,H\u0002J\u0018\u00109\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0002J \u0010;\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001eH\u0003J \u0010>\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u001eH\u0007J3\u0010C\u001a\u00028\u0000\"\b\b\u0000\u0010@*\u00020?2\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000A2\b\b\u0002\u0010<\u001a\u00020\u001eH\u0007¢\u0006\u0004\bC\u0010DJ;\u0010F\u001a\u00020\u001c\"\b\b\u0000\u0010@*\u00020?2\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020?0A2\u0006\u0010E\u001a\u00028\u00002\b\b\u0002\u0010<\u001a\u00020\u001eH\u0007¢\u0006\u0004\bF\u0010GJ@\u0010O\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001e2\b\b\u0002\u0010J\u001a\u00020I2\b\b\u0002\u0010L\u001a\u00020K2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010MH\u0007J\u0018\u0010P\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001e2\u0006\u0010<\u001a\u00020\u001eH\u0007J\b\u0010Q\u001a\u00020\u001eH\u0007J\b\u0010R\u001a\u00020/H\u0007J.\u0010S\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ=\u0010V\u001a\u00020\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u00100\u001a\u00020/H\u0000¢\u0006\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Y\u001a\u00020\u001e8\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u0010XR$\u0010[\u001a\u00020\u001f2\u0006\u0010Z\u001a\u00020\u001f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b[\u0010]¨\u0006`"}, d2 = {"Lcom/bytedance/android/annie/Annie;", "", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "schemaUri", "Lb7/b;", "commonLifecycle", "Lcom/bytedance/android/annie/api/container/HybridDialog;", "showHybridDialog", "schemaRawUri", "Landroid/os/Bundle;", "bundle", "Lh8/c;", "monitorProxy", "showHybridDialogWithAnnieX", "showHybridDialogWithWebcast", "Lb7/a;", "Lcom/bytedance/android/annie/api/card/HybridCard;", "getHybridCard", "getHybridCardWithAnnieX", "getHybridCardWithWebcast", "uri", "Lcom/bytedance/android/annie/api/container/HybridFragment;", "getHybridFragment", "resolveParamsConflict", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "kitType", "", "anniePreload", "", "", "isAnnieXPreloadEnable", "getHybridFragmentWithAnnieX", "getHybridFragmentWithWebcast", "", "throwable", "commonErrorProcess", "Landroid/app/Activity;", com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY, "closeAllAnnieDialog", "background", "appStateChange", "onNewActivityCreated", "Lcom/bytedance/android/annie/param/a;", "annieContext", com.bytedance.android.ec.core.event.a.KEY_URL, "", "openTime", "Lcom/bytedance/android/annie/service/latch/ILatchService$e;", "handlePrefetch", "Lcom/bytedance/android/annie/api/param/AnnieViewType;", "viewType", "initAnnieContext", "getOpenTimeBundle", com.bytedance.android.ec.core.event.a.KEY_SCHEME, "preloadResource", "monitorInit", "uuid", "copyQueryForLatch", "bizKey", "Lcom/bytedance/android/annie/ng/c;", "with", "Lcom/bytedance/android/annie/service/a;", "T", "Ljava/lang/Class;", "clazz", "getService", "(Ljava/lang/Class;Ljava/lang/String;)Lcom/bytedance/android/annie/service/a;", "obj", "registerService", "(Ljava/lang/Class;Lcom/bytedance/android/annie/service/a;Ljava/lang/String;)V", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "", "expiredTime", "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "strategy", "Ls9/e;", "callBack", "prerenderWithSchema", "releasePrerender", "getAnnieVersionName", "getAnnieVersionCode", "showLiteFullScreenFragment", "prefetchAndPreload$annie_release", "(Landroid/content/Context;Lcom/bytedance/android/annie/param/a;Landroid/net/Uri;Ljava/lang/String;J)V", "prefetchAndPreload", "TAG", "Ljava/lang/String;", "ANNIE_TAG", "<set-?>", "isBackground", "Z", "()Z", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class Annie {
    public static final String ANNIE_TAG = "Annie";
    public static final Annie INSTANCE = null;
    private static final String TAG = "Init";
    private static volatile boolean isBackground;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ILatchService.PrefetchStrategy.values().length];
            r0[ILatchService.PrefetchStrategy.Prefetch.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
        INSTANCE = new Annie();
    }

    private Annie() {
    }

    @JvmStatic
    public static final void closeAllAnnieDialog() {
        closeAllAnnieDialog$default(null, 1, null);
    }

    @JvmStatic
    public static final String getAnnieVersionName() {
        return "10.4.0";
    }

    @JvmStatic
    public static final <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        return (T) getService$default(r10, null, 2, null);
    }

    @JvmStatic
    public static final <T extends com.bytedance.android.annie.service.a> void registerService(Class<? extends com.bytedance.android.annie.service.a> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "obj");
        registerService$default(r10, r11, null, 4, null);
    }

    @JvmStatic
    public static final long getAnnieVersionCode() {
        return AnnieXMonitorConstants.a();
    }

    public final boolean isBackground() {
        return isBackground;
    }

    @JvmStatic
    public static final void appStateChange(boolean r10) {
        if (isBackground != r10) goto L5;
        return;
    L5:
        isBackground = r10;
        j r0 = j.a;
        JSONObject r1 = new JSONObject();
        r1.put("active", !r10);
        Unit r11 = Unit.INSTANCE;
        r0.sendEventToAllJsBridges("appStatusChange", r1);
    }

    @JvmStatic
    public static final void closeAllAnnieDialog(Activity r10) {
        Map<String, HybridDialog> r0 = k.a;
        if (e.a.booleanValue() == false) goto L20;
        Iterator r1 = ((LinkedHashMap) k.b).keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        WeakReference r11 = (WeakReference) ((LinkedHashMap) k.b).get((String) r1.next());
        if (r11 == null) goto L10;
        HybridDialog r12 = (HybridDialog) r11.get();
    L11:
        if (r10 == null) goto L17;
        if (r12 == null) goto L14;
        FragmentActivity r13 = r12.getActivity();
    L16:
        if (Intrinsics.areEqual(r13, r10) == false) goto L6;
    L14:
        r13 = null;
    L17:
        if (r12 == null) goto L6;
        k.a(r12);
        goto L6
    L10:
        r12 = null;
        goto L11
    L19:
        ((LinkedHashMap) k.b).clear();
        return;
    L20:
        Iterator r14 = ((LinkedHashMap) k.a).keySet().iterator();
    L22:
        if (r14.hasNext() == false) goto L32;
        HybridDialog r15 = (HybridDialog) ((LinkedHashMap) k.a).get((String) r14.next());
        if (r10 == null) goto L30;
        if (r15 == null) goto L27;
        FragmentActivity r16 = r15.getActivity();
    L29:
        if (Intrinsics.areEqual(r16, r10) == false) goto L22;
    L27:
        r16 = null;
    L30:
        if (r15 == null) goto L22;
        k.a(r15);
        goto L22
    L32:
        ((LinkedHashMap) k.a).clear();
    }

    private final Bundle getOpenTimeBundle(Bundle r10) {
        if (r10 != null) goto L6;
        Bundle r11 = new Bundle();
        r11.putString("biz_key", "webcast");
        r11.putLong("open_time", System.currentTimeMillis());
        return r11;
    L6:
        if (r10.getString("biz_key") != null) goto L9;
        r10.putString("biz_key", "webcast");
    L9:
        if (r10.getLong("open_time") > 0) goto L13;
        r10.putLong("open_time", System.currentTimeMillis());
        return r10;
    L13:
        return r10;
    }

    @JvmStatic
    public static final void onNewActivityCreated(Activity r10) {
        if (r10 != null) goto L4;
        Lazy r11 = AnnieFragmentManager.a;
        return;
    L4:
        Map.Entry r12 = (Map.Entry) CollectionsKt.lastOrNull(AnnieFragmentManager.c().entrySet());
        if (r12 == null) goto L9;
        HybridFragment r13 = (HybridFragment) ((WeakReference) r12.getValue()).get();
        if (r13 == null) goto L9;
        r13.realVisibleChange(false);
    L9:
        com.bytedance.android.anniex.assemble.a r14 = com.bytedance.android.anniex.assemble.a.a;
        Map.Entry r15 = (Map.Entry) CollectionsKt.lastOrNull(com.bytedance.android.anniex.assemble.a.e().entrySet());
        if (r15 == null) goto L16;
        ia.c r16 = (ia.c) ((WeakReference) r15.getValue()).get();
        if (r16 == null) goto L17;
        r16.onVisibleChange(false, Boolean.FALSE);
        return;
    L17:
        return;
    }

    private final Uri resolveParamsConflict(Uri r10) {
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.TRY_FIX_REUSE_CARD_CONFLICT.a(), Boolean.FALSE) == false) goto L6;
        return r10;
    L6:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r10, "enable_card_cache"), "1") == true) goto L8;
        return r10;
    L8:
        boolean r1 = Intrinsics.areEqual(UriProtector.getQueryParameter(r10, "enable_latch"), "1");
        boolean r11 = r10.getBooleanQueryParameter("enable_preload", true);
        if (r1 == true) goto L12;
        if (r11 == true) goto L12;
        return r10;
    L12:
        Map<String, WeakReference<IHybridComponent>> r12 = com.bytedance.android.annie.container.fragment.a.a;
        IHybridComponent r13 = com.bytedance.android.annie.container.fragment.a.b(com.bytedance.android.annie.container.fragment.a.a(r10.toString()));
        if (r13 != null) goto L15;
        return r10;
    L15:
        Set r14 = UriProtector.getQueryParameterNames(r10);
        Uri.Builder r15 = r10.buildUpon().clearQuery();
        Iterator r16 = r14.iterator();
    L17:
        if (r16.hasNext() == false) goto L23;
        String r17 = (String) r16.next();
        if (Intrinsics.areEqual(r17, "enable_latch") == true) goto L17;
        if (Intrinsics.areEqual(r17, "enable_preload") == true) goto L17;
        r15.appendQueryParameter(r17, UriProtector.getQueryParameter(r10, r17));
        goto L17
    L23:
        if (r1 == false) goto L25;
        r15.appendQueryParameter("enable_latch", "0");
    L25:
        if (r11 == false) goto L27;
        r15.appendQueryParameter("enable_preload", "");
    L27:
        int r18 = x8.a.a;
        x8.a.d(TAG, "resolveParamsConflict: latch=" + r1 + ", preload=" + r11 + ", cachedCard=" + r13, false);
        return r15.build();
    }

    @JvmStatic
    private static final void commonErrorProcess(Throwable r10, b7.b r11) {
        String r0 = r10.getMessage();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r11.onContainerError(null, 100, r0);
        String r12 = r10.getMessage();
        if (r12 == null) goto L9;
        r1 = r12;
    L9:
        r11.onFallback(100, r1);
    }

    @JvmStatic
    public static final <T extends com.bytedance.android.annie.service.a> T getService(Class<? extends T> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        AnnieNGServiceCenter r0 = AnnieNGServiceCenter.a;
        Intrinsics.checkNotNullParameter(r10, "clazz");
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        if (g.f.contains(r11) == true) goto L6;
        ALog.e("AnnieNGServiceCenter", "未注册的bizKey: " + r11);
    L6:
        if (AnnieNGServiceCenter.d().get("default") == null) goto L9;
        Object r12 = AnnieNGServiceCenter.d().get("default");
        Intrinsics.checkNotNull(r12);
        if (((Map) r12).isEmpty() == true) goto L9;
    L10:
        Object r13 = AnnieNGServiceCenter.c;
        monitor-enter(r13);
        Map r14 = (Map) AnnieNGServiceCenter.d().get(r11);     // Catch: Throwable -> L37
        com.bytedance.android.annie.service.a r15 = null;
        if (r14 == null) goto L16;
        T r16 = (T) r14.get(r10);     // Catch: Throwable -> L37
    L17:
        if (r16 == null) goto L20;
        monitor-exit(r13);
        return r16;
    L20:
        Map r17 = (Map) AnnieNGServiceCenter.d().get("host");     // Catch: Throwable -> L37
        if (r17 == null) goto L24;
        T r18 = (T) r17.get(r10);     // Catch: Throwable -> L37
    L25:
        if (r18 == null) goto L28;
        monitor-exit(r13);
        return r18;
    L28:
        Map r19 = (Map) AnnieNGServiceCenter.d().get("default");     // Catch: Throwable -> L37
        if (r19 == null) goto L31;
        r15 = (com.bytedance.android.annie.service.a) r19.get(r10);     // Catch: Throwable -> L37
    L31:
        if (r15 == null) goto L35;
        monitor-exit(r13);
        return (T) r15;
    L35:
        ALog.e("AnnieNGServiceCenter", "===bizKey is " + r11 + " service type is " + r10 + "  未找到对应的service===");     // Catch: Throwable -> L37
        throw new NullPointerException("未找到对应的Service,bizKey is " + r11 + " service type is " + r10);     // Catch: Throwable -> L37
    L24:
        r18 = null;
        goto L25
    L16:
        r16 = null;
    L37:
        th = move-exception;
        throw th;
    L9:
        AnnieNGServiceCenter.e();
        goto L10
    }

    @JvmStatic
    public static final boolean isAnnieXPreloadEnable(String r10, KitType r11) {
        if (r10 != null) goto L4;
        return false;
    L4:
        return FlowContainerLoaderSwitch.INSTANCE.enableAnnieXFlowLoader("webcast", r10, r11);
    }

    private final void monitorInit(Uri r10, com.bytedance.android.annie.param.a r11) {
        String r0 = r10.toString();
        Bundle r1 = r11.getBundle();
        if (r1 == null) goto L5;
        r1.putString(com.bytedance.android.ec.core.event.a.KEY_URL, r0);
    L5:
        b7.b r12 = r11.getCommonLifecycle();
        if (r12 == null) goto L8;
        r12.onInit(r11);
    L8:
        b7.b r13 = r11.getCommonLifecycle();
        if (r13 == null) goto L11;
        r13.onBeforeOpenContainer();
    L11:
        b7.b r14 = r11.getCommonLifecycle();
        if (r14 == null) goto L18;
        String r15 = UriProtector.getQueryParameter(r10, "fallback_url");
        if (r15 != null) goto L16;
        r15 = "";
    L16:
        r14.onPrepareInitDataStart(r0, r15, false);
        return;
    }

    @JvmStatic
    public static final void releasePrerender(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        ConcurrentHashMap<Integer, f> r12 = s9.a.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        if (Intrinsics.areEqual(AnnieConfigSettingKeys.ANNIEX_ENABLE_PRE_RENDER_FIX.a(), Boolean.FALSE) == true) goto L49;
        s9.a.d = null;
        Uri r0 = UriProtector.parse(r10);
        String r1 = UriProtector.getQueryParameter(r0, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r1 != null) goto L8;
    L11:
        boolean r13 = true;
    L13:
        if (r13 == false) goto L15;
        int r14 = x8.a.a;
        x8.a.b(ANNIE_TAG, "releasePrerender ：url == null schema is: " + r10, false);
        return;
    L15:
        String r15 = UriProtector.getQueryParameter(r0, "prerender_cache_key");
        if (r15 != null) goto L18;
    L21:
        boolean r16 = true;
    L22:
        if (r16 == false) goto L40;
        int r17 = x8.a.a;
        x8.a.b(ANNIE_TAG, "releasePrerender ：prerenderCacheKey == null schema is: " + r10, false);
        return;
    L40:
        Uri r18 = UriProtector.parse(r1);     // Catch: Exception -> L38
        StringBuilder r19 = new StringBuilder();     // Catch: Exception -> L38
        r19.append(r18.getScheme());     // Catch: Exception -> L38
        r19.append(':');     // Catch: Exception -> L38
        if (r18.getPort() != (-1)) goto L27;
        Object r20 = "";
    L28:
        r19.append(r20);     // Catch: Exception -> L38
        r19.append("//");     // Catch: Exception -> L38
        r19.append(r18.getHost());     // Catch: Exception -> L38
        r19.append(r18.getPath());     // Catch: Exception -> L38
        String r21 = r19.toString() + '_' + r15;
        if (s9.a.d(r11, r21) == false) goto L44;
        int r22 = x8.a.a;
        x8.a.b(ANNIE_TAG, "releasePrerender ：当前缓存中已存在指定card schema is: " + r10, false);
        s9.a.f(r21, r11, true);
        ConcurrentHashMap<String, WeakReference<Disposable>> r23 = s9.a.b;
        WeakReference<Disposable> r24 = r23.get(r21);
        if (r24 == null) goto L45;
        r23.remove(r21);
        Disposable r25 = r24.get();
        if (r25 != null) goto L36;
        return;
    L36:
        if (r25.isDisposed() == true) goto L47;
        r25.dispose();
        return;
    L47:
        return;
    L45:
        return;
    L44:
        return;
    L27:
        r20 = Integer.valueOf(r18.getPort());     // Catch: Exception -> L38
    L38:
        int r26 = x8.a.a;
        x8.a.b(ANNIE_TAG, "releasePrerender ：解析schema种的url失败:" + r10, false);
        return;
    L18:
        if (r15.length() == 0) goto L21;
        r16 = false;
        goto L22
    L8:
        if (r1.length() == 0) goto L11;
        r13 = false;
        goto L13
    }

    public static /* synthetic */ void closeAllAnnieDialog$default(Activity r0, int r1, Object r10) {
        if ((r1 & 1) == 0) goto L5;
        r0 = null;
    L5:
        closeAllAnnieDialog(r0);
    }

    @JvmStatic
    private static final String copyQueryForLatch(Uri r10, String r11, String r12) {
        Uri.Builder r0 = UriProtector.parse(r11).buildUpon();
        String r13 = UriProtector.getQueryParameter(r10, "loader_name");
        boolean r14 = true;
        if (r13 == null) goto L5;
        r0.appendQueryParameter("loader_name", r13);
        boolean r1 = true;
    L6:
        String r15 = UriProtector.getQueryParameter(r10, "lock_resource");
        if (r15 == null) goto L15;
        r0.appendQueryParameter("lock_resource", r15);
        String r16 = UriProtector.getQueryParameter(r10, "forest_session_id");
        if (r16 != null) goto L11;
    L16:
        if (r14 == true) goto L18;
        return r11;
    L18:
        return r0.build().toString();
    L11:
        if (StringsKt.isBlank(r16) == true) goto L14;
        r12 = r16;
    L14:
        r0.appendQueryParameter("forest_session_id", r12);
        goto L16
    L15:
        r14 = r1;
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.with(context, uri, bizKey).bundle().commonLifecycle().createCard()的方式创建", replaceWith = @ReplaceWith(expression = "Annie.with(context, uri, bizKey).bundle().commonLifecycle().createCard()", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final HybridCard getHybridCard(Context r1, Uri r10, b7.a r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "schemaUri");
        return getHybridCard(r1, r10, r11, null);
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.with(context, uri, bizKey).bundle().commonLifecycle().createFragment()的方式创建", replaceWith = @ReplaceWith(expression = "Annie.with(context, uri, bizKey).bundle().commonLifecycle().createFragment()", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final HybridFragment getHybridFragment(Uri r1, b7.b r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return getHybridFragment(null, r1, r10, r11);
    }

    private final void preloadResource(Uri r11, String r12, com.bytedance.android.annie.param.a r13) {
        PreLoadUtils r0 = PreLoadUtils.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEME);
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r13, "annieContext");
        String r1 = "";
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L45
        if ((!StringsKt.isBlank(r12)) == false) goto L8;
        String r14 = UriProtector.getQueryParameter(UriProtector.parse(r12), "enable_preload");     // Catch: Throwable -> L45
        if (r14 == null) goto L8;
    L10:
        if (StringsKt.isBlank(r14) == false) goto L16;
        r14 = UriProtector.getQueryParameter(r11, "enable_preload");     // Catch: Throwable -> L45
        if (r14 != null) goto L16;
        r14 = "";
    L16:
        if (StringsKt.isBlank(r14) == false) goto L27;
        if (Intrinsics.areEqual(r11.getHost(), "webcast_lynxview") == false) goto L20;
        IHybridComponent.HybridType r15 = IHybridComponent.HybridType.LYNX;     // Catch: Throwable -> L45
    L22:
        if (n.j(r12, r15, UriProtector.getQueryParameter(r11, "loader_name")) == false) goto L27;
        if (AnnieConfigSettingKeys.FOREST_ENABLE_DEFAULT_PRELOAD.a().booleanValue() == false) goto L27;
        r14 = "main";
        goto L27
    L20:
        r15 = IHybridComponent.HybridType.H5;     // Catch: Throwable -> L45
    L27:
        if (StringsKt.isBlank(r14) == true) goto L29;
    L44:
        r1 = r14;
    L50:
        if (PreLoadUtils.c.contains(r1) == true) goto L52;
        int r16 = x8.a.a;
        x8.a.d("preload", "no enable preload by query = ".concat(r1), true);
        return;
    L52:
        if (AnnieConfigSettingKeys.LIVE_ENABLE_PRELOAD.a().booleanValue() == false) goto L54;
        r13.c = 2;
        x8.a.d("preload", "start preload", true);
        Schedulers.io().scheduleDirect(new com.bytedance.android.annie.service.preload.a(r12, r11, r1, r13));
        x8.a.d("preload", "finish preload", true);
        return;
    L54:
        PreLoadUtils.d(r0, 100, "disable by setting", r12, null, r13.getMonitorID(), r13.getBizKey(), 8);
        x8.a.d("preload", "disable by setting", true);
        return;
    L29:
        if (Intrinsics.areEqual(r11.getHost(), "webcast_webview") == false) goto L44;
        Lazy r17 = ForestWebHelper.a;     // Catch: Throwable -> L45
        if (r12 == null) goto L50;
        Iterator<String> r18 = ForestWebHelper.a().b().iterator();     // Catch: Throwable -> L45
    L34:
        if (r18.hasNext() == false) goto L50;
        if (StringsKt.contains$default(r12, r18.next(), false, 2, null) == false) goto L34;
        if (ForestWebHelper.a().a() == 2) goto L43;
        if (ForestWebHelper.a().a() != 4) goto L34;
    L43:
        r1 = "main";
    L8:
        r14 = "";
    L45:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Throwable r20 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r20 == null) goto L50;
        x8.a.c("preload", r20, false);
        goto L50
    }

    @JvmStatic
    public static final <T extends com.bytedance.android.annie.service.a> void registerService(Class<? extends com.bytedance.android.annie.service.a> r1, T r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "clazz");
        Intrinsics.checkNotNullParameter(r10, "obj");
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        AnnieNGServiceCenter.a.f(r1, r10, r11);
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.with(context, uri, bizKey).bundle().commonLifecycle().createPopup()的方式创建", replaceWith = @ReplaceWith(expression = "Annie.with(context, uri, bizKey).bundle().commonLifecycle().createPopup()", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final HybridDialog showHybridDialog(Context r1, Uri r10, b7.b r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "schemaUri");
        return showHybridDialog(r1, r10, r11, null);
    }

    @JvmStatic
    public static final com.bytedance.android.annie.ng.c with(Context r1, Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "bizKey");
        return new com.bytedance.android.annie.ng.c(r1, r10, r11);
    }

    @JvmStatic
    public static final void anniePreload(KitType r10, Context r11, Uri r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "kitType");
        Intrinsics.checkNotNullParameter(r12, "schemaRawUri");
        Uri r14 = INSTANCE.resolveParamsConflict(r12);
        if (h7.b.c(null, r14, BulletMixSwitch.ContainerType.FULLSCREEN) == false) goto L6;
        int r0 = h7.b.a;
        h7.b.b(r11, r14, "fullscreen");
        ((b9.b) getService$default(b9.b.class, null, 2, null)).f0(r10, r14, r13);
        return;
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.with(context, uri, bizKey).bundle().commonLifecycle().createCard()的方式创建", replaceWith = @ReplaceWith(expression = "Annie.with(context, uri, bizKey).bundle().commonLifecycle().createCard()", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final HybridCard getHybridCard(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "schemaRawUri");
        Annie r0 = INSTANCE;
        Uri r14 = r0.resolveParamsConflict(r11);
        boolean r1 = h7.b.c(r10, r14, BulletMixSwitch.ContainerType.CARD);
        h8.c r15 = new h8.c(r12);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L15
        int r17 = 0;
        if (r13 == null) goto L6;
        r17 = r13.getInt("isPrerender", 0);     // Catch: Throwable -> L15
    L6:
        if (r1 == true) goto L8;
    L10:
        if (r1 == false) goto L12;
        HybridCard r18 = r0.getHybridCardWithAnnieX(r10, r14, r15, r13);     // Catch: Throwable -> L15
    L13:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L15
    L18:
        if (Result.isSuccess-impl(r19) == true) goto L20;
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 != null) goto L38;
        h7.b.d("Card", r1, "hybridCard is null", r14, null);
        return null;
    L38:
        commonErrorProcess(r20, r15);     // Catch: Throwable -> L29
        if (r1 == false) goto L26;
        ((IAnnieBusinessLatchService) getService$default(IAnnieBusinessLatchService.class, null, 2, null)).P0(r14);     // Catch: Throwable -> L29
    L27:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        int r21 = h7.b.a;
        String r22 = r20.getMessage();
        if (r22 != null) goto L34;
        r22 = "unknown";
    L34:
        h7.b.d("Card", r1, r22, r14, r20);
        return null;
    L26:
        ((ILatchService) getService$default(ILatchService.class, null, 2, null)).s(r14);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L20:
        return (HybridCard) r19;
    L12:
        r18 = r0.getHybridCardWithWebcast(r10, r14, r15, r13);     // Catch: Throwable -> L15
        goto L13
    L8:
        if (r17 != 1) goto L10;
        r18 = null;
    L15:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    private final HybridCard getHybridCardWithAnnieX(Context r10, Uri r11, h8.c r12, Bundle r13) {
        int r0 = x8.a.a;
        x8.a.d("BulletMixSwitch", "match new annie card schema is: " + r11, false);
        int r1 = h7.b.a;
        h7.b.b(r10, r11, "card");
        HybridCard r14 = ((b9.b) getService$default(b9.b.class, null, 2, null)).J0(r10, r11, r12, getOpenTimeBundle(r13));
        if (r14 != null) goto L6;
        h7.b.d("Card", true, "newAnnie hybridCard is null", r11, null);
        x8.a.d("BulletMixSwitch", "fallback old annie card schema is: " + r11, false);
        return getHybridCardWithWebcast(r10, r11, r12, r13);
    L6:
        return r14;
    }

    private final HybridCard getHybridCardWithWebcast(Context r14, Uri r15, h8.c r16, Bundle r17) {
        com.bytedance.android.annie.param.a r1 = initAnnieContext(r14, r15, r16, r17, AnnieViewType.CARD);
        r1.d.f("BulletMixSwitch", "init", "match old annie card schema is: " + r15);
        c r0 = d.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "uri");
        Intrinsics.checkNotNullParameter(r1, "annieContext");
        String r10 = r15.getHost();
        boolean r11 = false;
        if (r10 != null) goto L5;
    L7:
        if (r11 == false) goto L22;
        b7.b r12 = r1.getCommonLifecycle();
        if (r12 == null) goto L11;
        r12.onPrepareInitDataEnd();
    L11:
        b7.b r13 = r1.getCommonLifecycle();
        if (r13 == null) goto L14;
        r13.onContainerInitStart();
    L14:
        AnnieCard r18 = new AnnieCard(r14, null, r1);
        String r19 = UriProtector.getQueryParameter(r15, "error_page_theme");
        if (r19 != null) goto L17;
        String r20 = "default";
    L18:
        boolean r21 = !Intrinsics.areEqual(r20, "default");
        Bundle r22 = r1.getBundle();
        if (r22 == null) goto L21;
        r22.putLong("resolve_short_link_start", System.currentTimeMillis());
    L21:
        ((v9.c) getService(v9.c.class, r1.getBizKey())).X0(r15.toString(), new b(r1, r18, r15, r14, r21, r20));
        return r18;
    L17:
        r20 = r19;
        goto L18
    L22:
        CardParamVoNew r23 = com.bytedance.android.annie.param.c.a(r15, r1.getBundle());
        r1.d.f("AnnieInner", "schema_parse", "scheme parsed done: " + r23);
        b7.b r24 = r1.getCommonLifecycle();
        if (r24 == null) goto L25;
        r24.onPrepareInitDataEnd();
    L25:
        b7.b r25 = r1.getCommonLifecycle();
        if (r25 == null) goto L28;
        r25.onContainerInitStart();
    L28:
        c47.c r26 = com.bytedance.android.annie.pia.b.a;
        com.bytedance.android.annie.pia.b.b(r23.o(), r23.b, r23.j(), r1);
        return new AnnieCard(r14, r23, r1);
    L5:
        if (StringsKt.contains$default(r10, "webcast_redirect", false, 2, null) != true) goto L7;
        r11 = true;
        goto L7
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.with(context, uri, bizKey).bundle().commonLifecycle().createFragment()的方式创建", replaceWith = @ReplaceWith(expression = "Annie.with(context, uri, bizKey).bundle().commonLifecycle().createFragment()", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final HybridFragment getHybridFragment(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "schemaRawUri");
        Annie r0 = INSTANCE;
        Uri r14 = r0.resolveParamsConflict(r11);
        boolean r1 = h7.b.c(r10, r14, BulletMixSwitch.ContainerType.FULLSCREEN);
        h8.c r15 = new h8.c(r12);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L9
        if (r1 == false) goto L6;
        HybridFragment r17 = r0.getHybridFragmentWithAnnieX(r10, r14, r15, r13);     // Catch: Throwable -> L9
    L7:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L9
    L12:
        if (Result.isSuccess-impl(r18) == true) goto L14;
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 != null) goto L32;
        h7.b.d("Fullscreen", r1, "hybridFragment is null", r14, null);
        return null;
    L32:
        commonErrorProcess(r19, r15);     // Catch: Throwable -> L23
        if (r1 == false) goto L20;
        ((IAnnieBusinessLatchService) getService$default(IAnnieBusinessLatchService.class, null, 2, null)).P0(r14);     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        int r20 = h7.b.a;
        String r21 = r19.getMessage();
        if (r21 != null) goto L28;
        r21 = "unknown";
    L28:
        h7.b.d("Fullscreen", r1, r21, r14, r19);
        return null;
    L20:
        ((ILatchService) getService$default(ILatchService.class, null, 2, null)).s(r14);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L14:
        return (HybridFragment) r18;
    L6:
        r17 = r0.getHybridFragmentWithWebcast(r10, r14, r15, r13);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    private final HybridFragment getHybridFragmentWithAnnieX(Context r10, Uri r11, h8.c r12, Bundle r13) {
        int r0 = x8.a.a;
        x8.a.d("BulletMixSwitch", "match new annie fragment schema is: " + r11, false);
        int r1 = h7.b.a;
        h7.b.b(r10, r11, "fullscreen");
        HybridFragment r14 = ((b9.b) getService$default(b9.b.class, null, 2, null)).B1(r10, r11, r12, getOpenTimeBundle(r13));
        if (r14 != null) goto L6;
        h7.b.d("Fullscreen", true, "newAnnie hybridFragment is null", r11, null);
        x8.a.d("BulletMixSwitch", "fallback old annie fragment schema is: " + r11, false);
        return getHybridFragmentWithWebcast(r10, r11, r12, r13);
    L6:
        return r14;
    }

    private final HybridFragment getHybridFragmentWithWebcast(Context r10, Uri r11, h8.c r12, Bundle r13) {
        com.bytedance.android.annie.param.a r14 = initAnnieContext(r10, r11, r12, r13, AnnieViewType.FULLSCREEN);
        r14.d.f("BulletMixSwitch", "init", "match old annie fragment schema is: " + r11);
        c r15 = d.a;
        Intrinsics.checkNotNullParameter(r11, "uri");
        Intrinsics.checkNotNullParameter(r14, "annieContext");
        Bundle r16 = new Bundle();
        Bundle r17 = r14.getBundle();
        int r0 = com.bytedance.android.annie.param.c.a;
        Intrinsics.checkNotNullParameter(r11, "uri");
        HybridTypeNew r18 = com.bytedance.android.annie.param.c.b(r11);
        String r1 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        u8.a r19 = new u8.a(r1, r11, r17, r18, new v8.a(r11, r1, r17));
        int r20 = 0;
        FragmentParamVoNew r21 = new FragmentParamVoNew(r20);
        r21.F(r19);
        Boolean r110 = Boolean.TRUE;
        com.bytedance.android.annie.scheme.helper.a.d(r21, "is_fullScreen", r110);
        if (r17 != null) goto L5;
    L7:
        if (r20 == 0) goto L10;
        com.bytedance.android.annie.scheme.helper.a.d(r21, "is_real_full_screen", r110);
    L10:
        if (r21.b2() == false) goto L12;
        int r111 = com.bytedance.android.annie.container.fragment.n.a;
        String r112 = r21.a2();
        g.b().getClass();
        o8.a r22 = com.bytedance.android.annie.ng.e.a;
        com.bytedance.android.annie.scheme.helper.a.d(r21, "status_bar_color", com.bytedance.android.annie.container.fragment.n.b(r112, r22.k));
        String r113 = r21.Z1();
        g.b().getClass();
        com.bytedance.android.annie.scheme.helper.a.d(r21, "status_bar_bg_color", com.bytedance.android.annie.container.fragment.n.b(r113, !r22.k));
    L12:
        com.bytedance.android.annie.scheme.helper.a.d(r21, com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, PageType.FULLSCREEN);
        if (r21.a() == false) goto L15;
        AnnieFragmentManager.a(r21.k(), true, 4);
    L15:
        c47.c r114 = com.bytedance.android.annie.pia.b.a;
        com.bytedance.android.annie.pia.b.b(r21.o(), r21.b, r21.j(), r14);
        r14.d.f("AnnieInner", "schema_parse", "scheme parsed done: " + r21.toString());
        r16.putParcelable("hybrid_common_vo_new", r21);
        b7.b r23 = r14.getCommonLifecycle();
        if (r23 == null) goto L18;
        r23.onPrepareInitDataEnd();
    L18:
        b7.b r24 = r14.getCommonLifecycle();
        if (r24 == null) goto L21;
        r24.onContainerInitStart();
    L21:
        String r25 = r14.getBizKey();
        Intrinsics.checkNotNullParameter(r25, "bizKey");
        AnnieFragment r26 = ((e9.b) getService(e9.b.class, r25)).f();
        if (r26 != null) goto L24;
        r26 = new AnnieFragment();
    L24:
        r26.f = r14;
        r26.setArguments(r16);
        return r26;
    L5:
        if (r17.getBoolean("create_by_router") != true) goto L7;
        r20 = 1;
        goto L7
    }

    public static /* synthetic */ Bundle getOpenTimeBundle$default(Annie r0, Bundle r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.getOpenTimeBundle(r1);
    }

    public static /* synthetic */ com.bytedance.android.annie.service.a getService$default(Class r0, String r1, int r10, Object r11) {
        if ((r10 & 2) == 0) goto L6;
        r1 = "host";
    L6:
        return getService(r0, r1);
    }

    @Deprecated(message = "直播业务专用，其他请使用Annie.with(context, uri, bizKey).bundle().commonLifecycle().createPopup()的方式创建", replaceWith = @ReplaceWith(expression = "Annie.with(context, uri, bizKey).bundle().commonLifecycle().createPopup()", imports = {"com.bytedance.android.annie.Annie"}))
    @JvmStatic
    public static final HybridDialog showHybridDialog(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "schemaRawUri");
        Annie r1 = INSTANCE;
        Uri r14 = r1.resolveParamsConflict(r11);
        boolean r15 = h7.b.c(r10, r14, BulletMixSwitch.ContainerType.POPUP);
        h8.c r16 = new h8.c(r12);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L11
        if (r15 == false) goto L6;
        HybridDialog r18 = r1.showHybridDialogWithAnnieX(r10, r14, r16, r13);     // Catch: Throwable -> L11
    L9:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L11
    L14:
        if (Result.isSuccess-impl(r19) == true) goto L16;
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 != null) goto L34;
        h7.b.d("Popup", r15, "hybridDialog is null", r14, null);
        return null;
    L34:
        commonErrorProcess(r20, r16);     // Catch: Throwable -> L25
        if (r15 == false) goto L22;
        ((IAnnieBusinessLatchService) getService$default(IAnnieBusinessLatchService.class, null, 2, null)).P0(r14);     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        int r21 = h7.b.a;
        String r22 = r20.getMessage();
        if (r22 != null) goto L30;
        r22 = "unknown";
    L30:
        h7.b.d("Popup", r15, r22, r14, r20);
        return null;
    L22:
        ((ILatchService) getService$default(ILatchService.class, null, 2, null)).s(r14);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L16:
        return (HybridDialog) r19;
    L6:
        r18 = r1.showHybridDialogWithWebcast(r10, r14, r16, r13);     // Catch: Throwable -> L11
        if (r18 != null) goto L9;
        h7.b.d("Popup", false, "oldAnnie hybridDialog is null", r14, null);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private final HybridDialog showHybridDialogWithAnnieX(Context r10, Uri r11, h8.c r12, Bundle r13) {
        int r0 = x8.a.a;
        x8.a.d("BulletMixSwitch", "match new annie dialog schema is: " + r11, false);
        int r1 = h7.b.a;
        h7.b.b(r10, r11, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
        HybridDialog r14 = ((b9.b) getService$default(b9.b.class, null, 2, null)).o1(r10, r11, r12, getOpenTimeBundle(r13));
        if (r14 != null) goto L9;
        h7.b.d("Popup", true, "newAnnie hybridDialog is null", r11, null);
        x8.a.d("BulletMixSwitch", "fallback old annie dialog schema is: " + r11, false);
        HybridDialog r15 = showHybridDialogWithWebcast(r10, r11, r12, r13);
        if (r15 != null) goto L8;
        x8.a.d("BulletMixSwitch", "fallback old annie dialog error schema is: " + r11, false);
        h7.b.d("Popup", false, "fallback hybridDialog is null", r11, null);
    L8:
        return r15;
    L9:
        return r14;
    }

    private final HybridDialog showHybridDialogWithWebcast(Context r18, Uri r19, h8.c r20, Bundle r21) {
        com.bytedance.android.annie.param.a r10 = initAnnieContext(r18, r19, r20, r21, AnnieViewType.POPUP);
        r10.d.f("BulletMixSwitch", "init", "match old annie dialog schema is: " + r19);
        c r0 = d.a;
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "uri");
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        Bundle r11 = new Bundle();
        int r1 = com.bytedance.android.annie.param.c.a;
        Intrinsics.checkNotNullParameter(r19, "uri");
        if (Intrinsics.areEqual(com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP, UriProtector.getQueryParameter(r19, "type")) == false) goto L101;
        HybridTypeNew r12 = com.bytedance.android.annie.param.c.b(r19);
        String r13 = UriProtector.getQueryParameter(r19, "gravity");
        String r14 = UriProtector.getQueryParameter(r19, com.bytedance.android.ec.core.event.a.KEY_URL);
        v8.a r15 = new v8.a(r19, r14, null);
        u8.a r16 = new u8.a(r14, r19, null, r12, r15);
        PopupHybridParamVoNew r17 = new PopupHybridParamVoNew(0);
        r17.F(r16);
        if (Intrinsics.areEqual("bottom", r13) == false) goto L10;
        int r22 = com.bytedance.android.annie.scheme.helper.a.a;
        Intrinsics.checkNotNullParameter(r15, "parsing");
        if (r17.F3() != 0) goto L9;
        p r23 = p.a;
        com.bytedance.android.annie.scheme.helper.a.d(r17, "width", Integer.valueOf((int) r23.h(r23.e())));
    L9:
        com.bytedance.android.annie.scheme.helper.a.d(r17, "gravity", 80);
        com.bytedance.android.annie.scheme.helper.a.d(r17, "use_player_bottom_height", r15.b("use_player_bottom_height", 0));
        com.bytedance.android.annie.scheme.helper.a.d(r17, "pad_use_player_bottom_height", r15.b("pad_use_player_bottom_height", 0));
        com.bytedance.android.annie.scheme.helper.a.d(r17, "popup_type", r15.b("show_from", ""));
    L10:
        boolean r24 = true;
        if (r17.b2() == false) goto L13;
        int r25 = com.bytedance.android.annie.container.fragment.n.a;
        String r26 = r17.a2();
        g.b().getClass();
        o8.a r27 = com.bytedance.android.annie.ng.e.a;
        com.bytedance.android.annie.scheme.helper.a.d(r17, "status_bar_color", com.bytedance.android.annie.container.fragment.n.b(r26, r27.k));
        String r28 = r17.Z1();
        g.b().getClass();
        com.bytedance.android.annie.scheme.helper.a.d(r17, "status_bar_bg_color", com.bytedance.android.annie.container.fragment.n.b(r28, !r27.k));
    L13:
        if (r14 != null) goto L15;
    L17:
        com.bytedance.android.annie.scheme.helper.a.d(r17, com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, PageType.POPUP);
        com.bytedance.android.annie.scheme.helper.a.d(r17, "hide_status_bar", Boolean.valueOf(r17.D()));
        com.bytedance.android.annie.scheme.helper.a.d(r17, "is_fullScreen", Boolean.FALSE);
        Boolean r29 = Boolean.TRUE;
        com.bytedance.android.annie.scheme.helper.a.d(r17, "hide_nav_bar", r29);
        if (r17.S2() == false) goto L29;
        if (r17.t3() == (-1)) goto L22;
        boolean r30 = true;
    L23:
        com.bytedance.android.annie.scheme.helper.a.d(r17, "show_close", Boolean.valueOf(r30));
        if (r17.t3() != 1) goto L26;
        boolean r31 = true;
    L27:
        com.bytedance.android.annie.scheme.helper.a.d(r17, "close_position_right", Boolean.valueOf(r31));
        com.bytedance.android.annie.scheme.helper.a.d(r17, "is_pull_up_popup", r29);
        goto L29
    L26:
        r31 = false;
        goto L27
    L22:
        r30 = false;
    L29:
        if (r17.h3() == true) goto L38;
        if (g.b().b.c == false) goto L35;
        g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.j == true) goto L35;
    L36:
        com.bytedance.android.annie.scheme.helper.a.d(r17, "width_percent", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r17, "height_percent", 0);
        com.bytedance.android.annie.scheme.helper.a.d(r17, "popup_type", "right");
    L35:
        if (g.b().b.d == true) goto L36;
    L38:
        if (com.bytedance.android.annie.param.c.a.a[r12.ordinal()] != 1) goto L40;
        String r32 = "AnnieSchemeHelperNew->getPopupHybridParamByScheme--H5: ";
    L41:
        int r33 = x8.a.a;
        x8.a.d("tag_hybrid_parse", r32 + r17, false);
        StringBuilder r34 = new StringBuilder("AnnieSchemeHelperNew->getPopupHybridParamByScheme: ");
        r34.append(r17);
        x8.a.d("tag_hybrid_parse", r34.toString(), false);
        if (r17.a() == false) goto L44;
        AnnieFragmentManager.a(r17.k(), true, 4);
    L44:
        c47.c r35 = com.bytedance.android.annie.pia.b.a;
        com.bytedance.android.annie.pia.b.b(r17.o(), r17.b, r17.j(), r10);
        r10.d.f("AnnieInner", "schema_parse", "scheme parsed done: " + r17.toString());
        r11.putParcelable("hybrid_pop_vo_new", r17);
        b7.b r36 = r10.getCommonLifecycle();
        if (r36 == null) goto L47;
        r36.onPrepareInitDataEnd();
    L47:
        b7.b r37 = r10.getCommonLifecycle();
        if (r37 == null) goto L50;
        r37.onContainerInitStart();
    L50:
        AnnieDialog r38 = new AnnieDialog();
        Intrinsics.checkNotNullParameter(r10, "annieContext");
        r38.u = r10;
        r38.setArguments(r11);
        if (AnnieConfigSettingKeys.ANNIE_ALLOW_POPUP_DELAY_OPEN.a().booleanValue() == true) goto L53;
    L76:
        FragmentActivity r39 = d.a(r18, r10);
        if (r39 == null) goto L100;
        FragmentManager r40 = r39.getSupportFragmentManager();
        if (r40 == null) goto L100;
        if (r17.O2() == true) goto L85;
        r24 = false;
    L85:
        if (r24 == false) goto L91;
        FragmentTransaction r41 = r40.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r41, r38, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "Annie Dialog", 0) == true) goto L90;
        r41 = r41.add(r38, "Annie Dialog");
    L90:
        r41.commitAllowingStateLoss();
    L97:
        if (r38.q == false) goto L100;
    L106:
        return r38;
    L91:
        LandscapeRestrictionOperation r42 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r38, "Annie Dialog", r42);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r40, r38, r42) == true) goto L97;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L103
    L95:
        r38.show(r40, "Annie Dialog");
    L100:
        return null;
    L53:
        if (r17.Q2() != true) goto L55;
        boolean r43 = true;
    L56:
        if (r43 == false) goto L58;
    L67:
        r10.d.e("AnnieInner", "popup scheme delay open");
        Context r44 = r18.getApplicationContext();
        if ((r44 instanceof Application) == false) goto L70;
        Application r45 = (Application) r44;
    L71:
        if (r45 == null) goto L100;
        d.b = true;
        d.c = r38;
        if (d.a != null) goto L106;
        c r46 = new c(r10, r17);
        d.a = r46;
        r45.registerActivityLifecycleCallbacks(r46);
        goto L106
    L70:
        r45 = null;
        goto L71
    L58:
        if ((r18 instanceof Activity) == false) goto L60;
        Activity r47 = (Activity) r18;
    L61:
        if (r47 != null) goto L63;
    L65:
        boolean r48 = false;
    L66:
        if (r48 == false) goto L76;
    L63:
        if (r47.isFinishing() != true) goto L65;
        r48 = true;
        goto L66
    L60:
        r47 = null;
        goto L61
    L55:
        r43 = false;
        goto L56
    L40:
        r32 = "AnnieSchemeHelperNew->getPopupHybridParamByScheme--Lynx: ";
        goto L41
    L15:
        if (com.bytedance.android.annie.container.dialog.j.a(r14) == false) goto L17;
        com.bytedance.android.annie.scheme.helper.a.d(r17, "pull_down_close", Boolean.TRUE);
        goto L17
    L101:
        int r49 = com.bytedance.android.annie.util.e.a;
        Intrinsics.checkNotNullParameter("Scheme params type error", MessageIndication.MESSAGE_TYPE_MSG);
        boolean r50 = g.b().a.a;
        throw new Exception("Scheme params type error");
    }

    public final boolean showLiteFullScreenFragment(Context r10, Uri r11, b7.b r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "schemaRawUri");
        Uri r14 = resolveParamsConflict(r11);
        h8.c r0 = new h8.c(r12);
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L5
        int r16 = h7.b.a;     // Catch: Throwable -> L5
        h7.b.b(r10, r14, "fullscreen");     // Catch: Throwable -> L5
        Object r17 = Result.constructor-impl(Boolean.valueOf(((b9.b) getService$default(b9.b.class, null, 2, null)).p1(r10, r14, r0, INSTANCE.getOpenTimeBundle(r13))));     // Catch: Throwable -> L5
    L8:
        if (Result.isSuccess-impl(r17) == true) goto L10;
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L23;
        commonErrorProcess(r18, r0);     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return false;
    L23:
        return false;
    L10:
        return ((Boolean) r17).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static /* synthetic */ HybridCard getHybridCard$default(Context r0, Uri r1, b7.a r10, int r11, Object r12) {
        if ((r11 & 4) == 0) goto L6;
        r10 = null;
    L6:
        return getHybridCard(r0, r1, r10);
    }

    public static /* synthetic */ HybridFragment getHybridFragment$default(Uri r1, b7.b r10, Bundle r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L9;
        r11 = null;
    L9:
        return getHybridFragment(r1, r10, r11);
    }

    private final ILatchService.e handlePrefetch(Context r17, com.bytedance.android.annie.param.a r18, Uri r19, String r20, long r21) {
        String r0 = UriProtector.getQueryParameter(r19, "type");
        int r11 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        r0 = "fullscreen";
    L11:
        String r10 = r0;
        ILatchService r12 = (ILatchService) getService$default(ILatchService.class, null, 2, null);
        String r13 = "";
        if (r20 != null) goto L14;
        String r14 = "";
    L15:
        Pair<ILatchService.PrefetchStrategy, String> r15 = r12.k(r19, r14);
        ILatchService.d r16 = ((ILatchService) getService$default(ILatchService.class, null, 2, null)).e(r21, r10, (String) r15.getSecond(), r20);
        r16.e = r18.getUuid();
        Map<String, String> r22 = r16.g;
        String r23 = "1";
        if (r19.getBooleanQueryParameter("enableLatchXBridge", false) == false) goto L18;
        String r24 = "1";
    L19:
        r22.put("enableRegisterXBridge", r24);
        Map<String, String> r25 = r16.g;
        if (AnnieConfigSettingKeys.LATCH_ENABLE_CHECK_VERSION.a().booleanValue() == true) goto L23;
        r23 = "0";
    L23:
        r25.put("enableCheckVersion", r23);
        ILatchService r26 = (ILatchService) getService$default(ILatchService.class, null, 2, null);
        if (r20 == null) goto L27;
        r13 = r20;
    L27:
        String r27 = copyQueryForLatch(r19, r13, r18.getUuid());
        Object r28 = r15.getFirst();
        ILatchService.PrefetchStrategy r29 = ILatchService.PrefetchStrategy.Latch;
        if (r28 != r29) goto L30;
        boolean r30 = true;
    L31:
        ILatchService.e r31 = r26.u0(r17, r27, r19, r21, r16, r30);
        ILatchService.PrefetchStrategy r32 = (ILatchService.PrefetchStrategy) r15.getFirst();
        if (a.a[r32.ordinal()] != 1) goto L35;
        if (r20 == null) goto L35;
        ((com.bytedance.android.annie.service.prefetch.p) getService$default(com.bytedance.android.annie.service.prefetch.p.class, null, 2, null)).prefetch(r20);
    L35:
        String r33 = r18.getMonitorID();
        if (r33 == null) goto L45;
        k9.d r34 = ((k9.e) getService$default(k9.e.class, null, 2, null)).V0();
        if (r15.getFirst() != r29) goto L40;
        int r35 = 1;
    L41:
        r34.a(r33, "is_latch", r35);
        if (r15.getFirst() != ILatchService.PrefetchStrategy.Prefetch) goto L44;
        r11 = 1;
    L44:
        r34.a(r33, "is_prefetch", r11);
        goto L45
    L40:
        r35 = 0;
    L45:
        return r31;
    L30:
        r30 = false;
        goto L31
    L18:
        r24 = "0";
        goto L19
    L14:
        r14 = r20;
        goto L15
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final com.bytedance.android.annie.param.a initAnnieContext(Context r11, Uri r12, b7.a r13, Bundle r14, AnnieViewType r15) {
        Bundle r0 = getOpenTimeBundle(r14);
        String r10 = UriProtector.getQueryParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        com.bytedance.android.annie.param.a r16 = new com.bytedance.android.annie.param.a(r13, r0, ((ILatchService) getService$default(ILatchService.class, null, 2, null)).i(r12), 16);
        r16.setUrl(r10);
        r16.setViewType(r15);
        int r1 = 0;
        if (r15 != AnnieViewType.CARD) goto L8;
        r16.setAnnieIsCard(1);
        if (r14 == null) goto L7;
        r1 = r14.getInt("isPrerender", 0);
    L7:
        r16.setAnnieIsPreRender(r1);
    L9:
        monitorInit(r12, r16);
        if (Intrinsics.areEqual(r12.getHost(), "webcast_redirect") == true) goto L16;
        Annie r17 = INSTANCE;
        if (r14 == null) goto L14;
        long r18 = r14.getLong("open_time");
    L15:
        r17.prefetchAndPreload$annie_release(r11, r16, r12, r10, r18);
        goto L16
    L14:
        r18 = 0;
    L16:
        return r16;
    L8:
        r16.setAnnieIsCard(0);
        goto L9
    }

    public static /* synthetic */ void registerService$default(Class r0, com.bytedance.android.annie.service.a r1, String r10, int r11, Object r12) {
        if ((r11 & 4) == 0) goto L5;
        r10 = "host";
    L5:
        registerService(r0, r1, r10);
    }

    public static /* synthetic */ HybridDialog showHybridDialog$default(Context r0, Uri r1, b7.b r10, int r11, Object r12) {
        if ((r11 & 4) == 0) goto L6;
        r10 = null;
    L6:
        return showHybridDialog(r0, r1, r10);
    }

    public final void prefetchAndPreload$annie_release(Context r10, com.bytedance.android.annie.param.a r11, Uri r12, String r13, long r14) {
        Intrinsics.checkNotNullParameter(r11, "annieContext");
        Intrinsics.checkNotNullParameter(r12, "uri");
        r11.a = handlePrefetch(r10, r11, r12, r13, r14);
        if (r13 == null) goto L6;
        preloadResource(r12, r13, r11);
        return;
    }

    public static /* synthetic */ HybridCard getHybridCard$default(Context r1, Uri r10, b7.b r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r12 = null;
    L9:
        return getHybridCard(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridFragment getHybridFragment$default(Context r1, Uri r10, b7.b r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r12 = null;
    L9:
        return getHybridFragment(r1, r10, r11, r12);
    }

    @JvmStatic
    public static final void prerenderWithSchema(Context r10, String r11, String r12, int r13, PrerenderParamModel.Strategy r14, s9.e r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        Intrinsics.checkNotNullParameter(r14, "strategy");
        ConcurrentHashMap<Integer, f> r16 = s9.a.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        Intrinsics.checkNotNullParameter(r14, "strategy");
        com.bytedance.android.annie.ng.a r0 = g.c.get(r12);
        boolean r1 = true;
        if (r0 == null) goto L9;
        o8.g r17 = r0.d;
        if (r17 == null) goto L9;
        if (r17.b == true) goto L9;
        boolean r18 = true;
    L10:
        if (r18 == false) goto L14;
        if (r15 == null) goto L41;
        r15.onFailed(r11, "本地未开启预渲染功能");
        return;
    L41:
        return;
    L14:
        if ((r10 instanceof Activity) == true) goto L17;
        if (r15 == null) goto L43;
        r15.onFailed(r11, "需要activity类型的context参数");
        return;
    L43:
        return;
    L17:
        Uri r19 = UriProtector.parse(r11);
        String r20 = UriProtector.getQueryParameter(r19, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r20 != null) goto L20;
    L23:
        boolean r21 = true;
    L24:
        if (r21 == false) goto L27;
        if (r15 == null) goto L45;
        r15.onFailed(r11, "url.isNullOrEmpty");
        return;
    L45:
        return;
    L27:
        String r22 = UriProtector.getQueryParameter(r19, "prerender_cache_key");
        if (r22 != null) goto L30;
    L33:
        if (r1 == false) goto L37;
        if (r15 == null) goto L47;
        r15.onFailed(r11, "prerenderCacheKey.isNullOrEmpty");
        return;
    L47:
        return;
    L37:
        if (r14 != PrerenderParamModel.Strategy.Immediately) goto L39;
        s9.a.c(r10, r11, r12, r13, r15);
        return;
    L39:
        Looper.myQueue().addIdleHandler(new s9.b(r10, r11, r12, r13, r15));
        return;
    L30:
        if (r22.length() == 0) goto L33;
        r1 = false;
        goto L33
    L20:
        if (r20.length() == 0) goto L23;
        r21 = false;
    L9:
        r18 = false;
        goto L10
    }

    public static /* synthetic */ HybridDialog showHybridDialog$default(Context r1, Uri r10, b7.b r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r12 = null;
    L9:
        return showHybridDialog(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridCard getHybridCardWithAnnieX$default(Annie r0, Context r1, Uri r10, h8.c r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r0.getHybridCardWithAnnieX(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridCard getHybridCardWithWebcast$default(Annie r0, Context r1, Uri r10, h8.c r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r0.getHybridCardWithWebcast(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridFragment getHybridFragmentWithAnnieX$default(Annie r0, Context r1, Uri r10, h8.c r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r0.getHybridFragmentWithAnnieX(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridFragment getHybridFragmentWithWebcast$default(Annie r0, Context r1, Uri r10, h8.c r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r0.getHybridFragmentWithWebcast(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridDialog showHybridDialogWithAnnieX$default(Annie r0, Context r1, Uri r10, h8.c r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r0.showHybridDialogWithAnnieX(r1, r10, r11, r12);
    }

    public static /* synthetic */ HybridDialog showHybridDialogWithWebcast$default(Annie r0, Context r1, Uri r10, h8.c r11, Bundle r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        return r0.showHybridDialogWithWebcast(r1, r10, r11, r12);
    }

    public static /* synthetic */ boolean showLiteFullScreenFragment$default(Annie r1, Context r10, Uri r11, b7.b r12, Bundle r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = null;
    L9:
        return r1.showLiteFullScreenFragment(r10, r11, r12, r13);
    }

    public static /* synthetic */ ILatchService.e handlePrefetch$default(Annie r10, Context r11, com.bytedance.android.annie.param.a r12, Uri r13, String r14, long r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L6;
        r15 = 0;
    L6:
        return r10.handlePrefetch(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ com.bytedance.android.annie.param.a initAnnieContext$default(Annie r10, Context r11, Uri r12, b7.a r13, Bundle r14, AnnieViewType r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L6;
        r14 = null;
    L6:
        return r10.initAnnieContext(r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void prefetchAndPreload$annie_release$default(Annie r10, Context r11, com.bytedance.android.annie.param.a r12, Uri r13, String r14, long r15, int r16, Object r17) {
        if ((r16 & 16) == 0) goto L5;
        r15 = 0;
    L5:
        r10.prefetchAndPreload$annie_release(r11, r12, r13, r14, r15);
    }

    public static void prerenderWithSchema$default(Context r10, String r11, String r12, int r13, PrerenderParamModel.Strategy r14, s9.e r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L10;
        com.bytedance.android.annie.ng.a r18 = g.c.get(r12);
        if (r18 == null) goto L9;
        o8.g r19 = r18.d;
        if (r19 == null) goto L9;
        r13 = r19.c;
    L9:
        r13 = 10;
    L10:
        int r20 = r13;
        if ((r16 & 16) == 0) goto L13;
        r14 = PrerenderParamModel.Strategy.Onidle;
    L13:
        PrerenderParamModel.Strategy r21 = r14;
        if ((r16 & 32) == 0) goto L16;
        r15 = null;
    L16:
        prerenderWithSchema(r10, r11, r12, r20, r21, r15);
    }
}
