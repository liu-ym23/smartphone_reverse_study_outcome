package com.bytedance.ai.ex.widget;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer;
import com.bytedance.ai.ex.widget.inittasks.IvyKitInitializer;
import com.bytedance.ai.ex.widget.jsb.AddBizEntityMethod;
import com.bytedance.ai.ex.widget.jsb.CreateWidgetProxy;
import com.bytedance.ai.ex.widget.jsb.OpenMethodProxy;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.settings.AISDKSettingConfigManager;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.IBridgeService;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w0.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u0006*\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJA\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u008a\u0001\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010!2\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010!2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0086@¢\u0006\u0004\b)\u0010*J8\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$H\u0086@¢\u0006\u0004\b)\u0010+J8\u0010)\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010,H\u0086@¢\u0006\u0004\b)\u0010-J\u001d\u00100\u001a\u00020\u00062\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0004¢\u0006\u0004\b0\u00101R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/bytedance/ai/ex/widget/WidgetSDK;", "", "<init>", "()V", "", "useSelf", "", "forceSetResourceDownloadType", "(Z)V", "Landroidx/lifecycle/LifecycleOwner;", "", "delayDestroy", "addObserver", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/Long;)V", "Landroid/app/Application;", "context", "", "did", "Lu0/a;", "config", "Lt0/b;", "ability", "Lul/d;", "geckoConfigs", "Lcom/bytedance/ai/ex/widget/LogProxy;", "log", "init", "(Landroid/app/Application;Ljava/lang/String;Lu0/a;Lt0/b;Lul/d;Lcom/bytedance/ai/ex/widget/LogProxy;)V", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "widgetInfo", "Landroid/content/Context;", "lifecycleOwner", "messageId", "", "environmentConfig", "viewContext", "Lw0/m;", "widgetLifeObserver", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "appletWrap", "Lcom/bytedance/ai/ex/widget/WidgetView;", "createWidget", "(Lcom/bytedance/ai/model/objects/WidgetInfo;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lw0/m;Ljava/lang/Long;Lcom/bytedance/ai/widget/models/OAppletWrap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/bytedance/ai/model/objects/WidgetInfo;Landroid/content/Context;Ljava/lang/String;Lw0/m;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/bytedance/ai/ex/widget/IWidgetLifeObserverDelegate;", "(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/ai/ex/widget/IWidgetLifeObserverDelegate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "widgetView", "isNightMode", "notifyWidgetThemeChanged", "(Lcom/bytedance/ai/ex/widget/WidgetView;Z)V", "", "lifecycleOwnerMap", "Ljava/util/Map;", "LifecycleObserverImpl", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetSDK {
    public static final WidgetSDK INSTANCE = null;
    private static final Map<Object, Object> lifecycleOwnerMap = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/ex/widget/WidgetSDK$LifecycleObserverImpl;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "delayDestroy", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/Long;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getDelayDestroy", "()Ljava/lang/Long;", "Ljava/lang/Long;", "onResume", "", "onDestroy", "onPause", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LifecycleObserverImpl implements LifecycleObserver {
        private final Long delayDestroy;
        private final LifecycleOwner lifecycleOwner;

        public LifecycleObserverImpl(LifecycleOwner r5, Long r10) {
            Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
            this.lifecycleOwner = r5;
            this.delayDestroy = r10;
        }

        public static /* synthetic */ void a(g r5) {
            onDestroy$lambda$2$lambda$1(r5);
        }

        public static /* synthetic */ Unit b(LifecycleObserverImpl r5) {
            return onDestroy$lambda$0(r5);
        }

        private static final Unit onDestroy$lambda$0(LifecycleObserverImpl r5) {
            Intrinsics.checkNotNullParameter(r5, "this$0");
            WidgetRenderService.INSTANCE.onHostDestroy(r5.lifecycleOwner);
            r5.lifecycleOwner.getLifecycle().removeObserver(r5);
            WidgetSDK.access$getLifecycleOwnerMap$p().remove(r5.lifecycleOwner);
            return Unit.INSTANCE;
        }

        private static final void onDestroy$lambda$2$lambda$1(Function0 r5) {
            Intrinsics.checkNotNullParameter(r5, "$tmp0");
            r5.invoke();
        }

        public final Long getDelayDestroy() {
            return this.delayDestroy;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ai.ex.widget.g] */
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            final ?? r5 = new g(this);
            Long r10 = this.delayDestroy;
            if (r10 == null) goto L6;
            long r11 = r10.longValue();
            new Handler(Looper.getMainLooper()).postDelayed(new h(r5), r11);
            return;
        L6:
            r5.invoke();
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public final void onPause() {
            WidgetRenderService.INSTANCE.onHostHide(this.lifecycleOwner);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public final void onResume() {
            WidgetRenderService.INSTANCE.onHostShow(this.lifecycleOwner);
        }

        public /* synthetic */ LifecycleObserverImpl(LifecycleOwner r5, Long r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 2) == 0) goto L5;
            r10 = null;
        L5:
            this(r5, r10);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetSDK$createWidget$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetSDK", f = "WidgetSDK.kt", i = {0, 0, 0}, l = {77}, m = "createWidget", n = {"lifecycleOwner", "delayDestroy", "widgetView"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetSDK this$0;

        public AnonymousClass1(WidgetSDK r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            this.result = r12;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidget(null, null, null, null, null, null, null, null, null, this);
        }
    }

    static {
        INSTANCE = new WidgetSDK();
        lifecycleOwnerMap = new LinkedHashMap();
    }

    private WidgetSDK() {
    }

    public static /* synthetic */ void a(WidgetView r5, int r10) {
        notifyWidgetThemeChanged$lambda$1(r5, r10);
    }

    public static final /* synthetic */ Map access$getLifecycleOwnerMap$p() {
        return lifecycleOwnerMap;
    }

    private final void addObserver(LifecycleOwner r5, Long r10) {
        Map<Object, Object> r11 = lifecycleOwnerMap;
        if (r11.get(r5) != null) goto L6;
        Lifecycle r12 = r5.getLifecycle();
        LifecycleObserverImpl r13 = new LifecycleObserverImpl(r5, r10);
        r11.put(r5, r13);
        r12.addObserver(r13);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object createWidget$default(WidgetSDK r14, WidgetInfo r15, Context r16, LifecycleOwner r17, String r18, Map r19, Map r20, m r21, Long r22, OAppletWrap r23, Continuation r24, int r25, Object r26) {
        if ((r25 & 8) == 0) goto L5;
        String r10 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        Map r11 = null;
    L11:
        if ((r25 & 32) == 0) goto L13;
        Map r12 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        m r13 = null;
    L19:
        if ((r25 & 128) == 0) goto L21;
        Long r110 = null;
    L23:
        if ((r25 & 256) == 0) goto L25;
        OAppletWrap r111 = null;
    L27:
        return r14.createWidget(r15, r16, r17, r10, r11, r12, r13, r110, r111, r24);
    L25:
        r111 = r23;
        goto L27
    L21:
        r110 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    private final void forceSetResourceDownloadType(boolean r5) {
        Field r10 = AISDKSettingConfigManager.class.getDeclaredField("PACKAGE_DOWNLOAD_TYPE");
        r10.setAccessible(true);
        Object r11 = r10.get(AISDKSettingConfigManager.INSTANCE);
        Field r12 = r11.getClass().getDeclaredField("defaultValue");
        r12.setAccessible(true);
        r12.set(r11, Integer.valueOf(r5 ? 1 : 0));
    }

    private static final void notifyWidgetThemeChanged$lambda$1(WidgetView r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "$widgetView");
        r5.onThemeChanged(r10);
    }

    public final Object createWidget(WidgetInfo r17, Context r18, LifecycleOwner r19, String r20, Map<Object, ? extends Object> r21, Map<String, String> r22, m r23, Long r24, OAppletWrap r25, Continuation<? super WidgetView> r26) {
        LifecycleOwner r5 = r19;
        if ((r26 instanceof AnonymousClass1) == false) goto L8;
        AnonymousClass1 r10 = (AnonymousClass1) r26;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L8;
        r10.label = r11 - Integer.MIN_VALUE;
    L7:
        AnonymousClass1 r12 = r10;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L15;
        if (r15 != 1) goto L14;
        WidgetView r16 = (WidgetView) r12.L$2;
        Long r27 = (Long) r12.L$1;
        LifecycleOwner r28 = (LifecycleOwner) r12.L$0;
        ResultKt.throwOnFailure(r13);
        WidgetView r29 = r16;
        Long r110 = r27;
        r5 = r28;
    L32:
        if (r5 == null) goto L35;
        WidgetRenderService.INSTANCE.onViewCreated(r5);
        INSTANCE.addObserver(r5, r110);
        return r29;
    L35:
        WidgetRenderService.INSTANCE.onViewCreated(r29);
        return r29;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
        LogProxy r111 = LogAdapter.INSTANCE.getImpl();
        if (r111 == null) goto L18;
        LogProxy.DefaultImpls.d$default(r111, "WidgetSDK", "createWidget", null, 4, null);
    L18:
        r29 = new WidgetView(r18);
        Map<String, String> r30 = null;
        if (r21 == null) goto L21;
        Map<Object, Object> r31 = MapsKt.toMutableMap(r21);
    L22:
        r29.setEnvironmentConfig(r31);
        if (r22 == null) goto L25;
        r30 = MapsKt.toMutableMap(r22);
    L25:
        r29.setViewContext(r30);
        if (r5 != null) goto L28;
        Object r32 = r29;
    L29:
        r12.L$0 = r5;
        r110 = r24;
        r12.L$1 = r110;
        r12.L$2 = r29;
        r12.label = 1;
        if (r29.bindData(r17, r32, r20, r23, r25, r12) != r14) goto L32;
        return r14;
    L28:
        r32 = r5;
        goto L29
    L21:
        r31 = null;
    L8:
        r10 = new AnonymousClass1(this, r26);
        goto L7
    }

    public final void init(Application r10, String r11, u0.a r12, t0.b r13, ul.d r14, LogProxy r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "ability");
        Intrinsics.checkNotNullParameter(r14, "geckoConfigs");
        LogAdapter.INSTANCE.setImpl(r15);
        forceSetResourceDownloadType(true);
        IvyKitInitializer.INSTANCE.init(r10, r11, r14);
        IBridgeService.Companion.init(new com.ivy.ivykit.api.bridge.a(false, CollectionsKt.emptyList()));
        AISdkInitializer.init$default(AISdkInitializer.INSTANCE, null, r12, r13, null, null, 24, null);
        o1.i r16 = o1.i.f20397c;
        r16.b(CreateWidgetProxy.class);
        r16.b(OpenMethodProxy.class);
        r16.b(AddBizEntityMethod.class);
    }

    public final void notifyWidgetThemeChanged(WidgetView r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "widgetView");
        if (r10 == false) goto L5;
        int r11 = 32;
    L6:
        androidx.core.content.res.a r12 = new androidx.core.content.res.a(r11, 1, r5);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L10;
        r12.run();
        return;
    L10:
        new Handler(Looper.getMainLooper()).post(r12);
        return;
    L5:
        r11 = 16;
        goto L6
    }

    public static /* synthetic */ Object createWidget$default(WidgetSDK r10, WidgetInfo r11, Context r12, String r13, m r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        m r18 = null;
    L11:
        return r10.createWidget(r11, r12, r5, r18, r15);
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static /* synthetic */ Object createWidget$default(WidgetSDK r10, String r11, Context r12, String r13, IWidgetLifeObserverDelegate r14, Continuation r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        IWidgetLifeObserverDelegate r18 = null;
    L11:
        return r10.createWidget(r11, r12, r5, r18, r15);
    L9:
        r18 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public final Object createWidget(WidgetInfo r14, Context r15, String r16, m r17, Continuation<? super WidgetView> r18) {
        return createWidget$default(this, r14, r15, null, r16, null, null, r17, null, null, r18, 432, null);
    }

    public final Object createWidget(String r15, Context r16, String r17, IWidgetLifeObserverDelegate r18, Continuation<? super WidgetView> r19) {
        return createWidget$default(this, (WidgetInfo) new Gson().fromJson(r15, WidgetInfo.class), r16, null, r17, null, null, r18, null, null, r19, 432, null);
    }
}
