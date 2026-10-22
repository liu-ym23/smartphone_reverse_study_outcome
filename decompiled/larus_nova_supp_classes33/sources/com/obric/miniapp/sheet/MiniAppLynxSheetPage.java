package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.applet.render.core.lynx.AppletBridgeModule;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.viewmodel.AIPrivateViewModel;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.utils.o;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import d3.a0;
import d3.b0;
import d3.w;
import d3.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0002 #\b\u0000\u0018\u0000 a2\u00020\u0001:\u0001aB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ,\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u00108\u001a\u0004\u0018\u00010\u00182\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0017H\u0016J\u0010\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u0017H\u0016J\u001a\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020\u0017H\u0016JY\u0010B\u001a\u0004\u0018\u0001042\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010D2\u0016\u0010E\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2#\u0010F\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\bG\u0012\b\bH\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0016J\u0018\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020LH\u0016J\b\u0010N\u001a\u00020\fH\u0016J\u0006\u0010O\u001a\u00020\fJ\u0010\u0010P\u001a\u00020\f2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010Q\u001a\u00020\fH\u0002J\u0012\u0010R\u001a\u00020:2\b\u0010S\u001a\u0004\u0018\u00010TH\u0002J\b\u0010U\u001a\u00020VH\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J.\u0010X\u001a\u0004\u0018\u00010\u001e2\b\u0010Y\u001a\u0004\u0018\u00010\u00172\u0006\u0010Z\u001a\u00020\u00172\b\u0010[\u001a\u0004\u0018\u00010\u00172\u0006\u0010\\\u001a\u00020:H\u0002J\u0018\u0010]\u001a\u0004\u0018\u00010T2\u0006\u0010^\u001a\u00020\u001eH\u0082@¢\u0006\u0002\u0010_J\f\u0010`\u001a\u00020\t*\u00020LH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppLynxSheetPage;", "Lcom/bytedance/ai/model/widgets/AIContainerViewBase;", "appletRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "pageInfo", "Lcom/bytedance/ai/model/objects/PageInfo;", "bodyContainer", "Landroid/view/ViewGroup;", "contentLayoutHeight", "", "onAdaptiveHeightChanged", "Lkotlin/Function1;", "", "<init>", "(Lcom/bytedance/ai/model/AppletRuntime;Lcom/bytedance/ai/model/objects/PageInfo;Landroid/view/ViewGroup;ILkotlin/jvm/functions/Function1;)V", "destroyHandler", "Landroid/os/Handler;", "lynxRemoteBridgeMessages", "Lcom/bytedance/ai/bridge/utils/CacheHandle;", "Lcom/lynx/react/bridge/ReadableMap;", "Lcom/bytedance/ai/utils/LynxReadableMap;", "aiViewModelMap", "", "", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "destroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "preloadStarted", "preloadedPageContent", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/miniapp/sheet/SheetPageContent;", "lynxViewClient", "com/obric/miniapp/sheet/MiniAppLynxSheetPage$lynxViewClient$1", "Lcom/obric/miniapp/sheet/MiniAppLynxSheetPage$lynxViewClient$1;", "lifecycleListener", "com/obric/miniapp/sheet/MiniAppLynxSheetPage$lifecycleListener$1", "Lcom/obric/miniapp/sheet/MiniAppLynxSheetPage$lifecycleListener$1;", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "lynxView", "Lcom/bytedance/ai/lynx/AppletLynxView;", "lynxBridgePort", "Lcom/bytedance/ai/bridge/protocol/AbsAIBridgePort;", "createContainer", "root", "params", "Lcom/bytedance/ai/api/model/view/AIViewRenderData;", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "realView", "Landroid/view/View;", "engineView", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", "getViewModel", "isShared", "", "groupId", "onMessageToJS", "message", "onMessageToAIBridge", "eventName", "Lcom/google/gson/JsonObject;", "getRenderType", "createPage", "context", "Landroid/content/Context;", "onSuccess", "onFail", "Lkotlin/ParameterName;", "name", "msg", "handleContentSizeChange", "width", "", "height", "onDestroy", "warmUp", "createLynxView", "initLynxBridge", "renderTemplate", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "buildTemplateData", "Lcom/lynx/tasm/TemplateData;", "resolvePageContent", "buildSheetPageContent", "realUrl", "packageName", "bundleId", "isWidget", "loadTemplateBundle", "pageContent", "(Lcom/obric/miniapp/sheet/SheetPageContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scaleSize", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppLynxSheetPage extends com.bytedance.ai.model.widgets.c {
    public static final Companion Companion = null;
    private static final String TAG = "MiniAppLynxSheetPage";
    private w aiBridge;
    private final Map<String, a6.a> aiViewModelMap;
    private final ViewGroup bodyContainer;
    private final int contentLayoutHeight;
    private final Handler destroyHandler;
    private final AtomicBoolean destroyed;
    private final MiniAppLynxSheetPage$lifecycleListener$1 lifecycleListener;
    private m4.c lynxBridgePort;
    private final s4.c<ReadableMap> lynxRemoteBridgeMessages;
    private com.bytedance.ai.lynx.g lynxView;
    private final MiniAppLynxSheetPage$lynxViewClient$1 lynxViewClient;
    private final Function1<Integer, Unit> onAdaptiveHeightChanged;
    private final AtomicBoolean preloadStarted;
    private final AtomicReference<SheetPageContent> preloadedPageContent;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppLynxSheetPage$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.sheet.MiniAppLynxSheetPage$createPage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.sheet.MiniAppLynxSheetPage$createPage$1", f = "MiniAppSheetHost.kt", i = {}, l = {712}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onFail;
        final /* synthetic */ Function1<Integer, Unit> $onSuccess;
        final /* synthetic */ SheetPageContent $pageContent;
        int label;
        final /* synthetic */ MiniAppLynxSheetPage this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(SheetPageContent r1, MiniAppLynxSheetPage r2, Function1<? super String, Unit> r3, Function1<? super Integer, Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.$pageContent = r1;
            this.this$0 = r2;
            this.$onFail = r3;
            this.$onSuccess = r4;
            super(2, r5);
        }

        public static /* synthetic */ void a(MiniAppLynxSheetPage r0, TemplateBundle r1, Function1 r2, Function1 r3) {
            invokeSuspend$lambda$0(r0, r1, r2, r3);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$pageContent, this.this$0, this.$onFail, this.$onSuccess, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L13:
            final TemplateBundle r6 = (TemplateBundle) r5;
        L14:
            final MiniAppLynxSheetPage r2 = this.this$0;
            final Function1<String, Unit> r3 = this.$onFail;
            final Function1<Integer, Unit> r4 = this.$onSuccess;
            p2.c.d(new g(r2, r6, r3, r4));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            r6 = this.$pageContent.getBundle();
            if (r6 != null) goto L14;
            MiniAppLynxSheetPage r7 = this.this$0;
            SheetPageContent r8 = this.$pageContent;
            this.label = 1;
            r5 = MiniAppLynxSheetPage.access$loadTemplateBundle(r7, r8, this);
            if (r5 != r0) goto L13;
            return r0;
        }

        private static final void invokeSuspend$lambda$0(MiniAppLynxSheetPage r1, TemplateBundle r2, Function1 r3, Function1 r4) {
            if (MiniAppLynxSheetPage.access$getDestroyed$p(r1).get() == false) goto L6;
            return;
        L6:
            if (MiniAppLynxSheetPage.access$renderTemplate(r1, r2) == true) goto L10;
            if (r3 == null) goto L13;
            r3.invoke("renderTemplate failed");
            return;
        L13:
            return;
        L10:
            if (r4 == null) goto L14;
            r4.invoke(null);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.sheet.MiniAppLynxSheetPage$loadTemplateBundle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.sheet.MiniAppLynxSheetPage", f = "MiniAppSheetHost.kt", i = {}, l = {943}, m = "loadTemplateBundle", n = {}, s = {})
    public static final class C00881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MiniAppLynxSheetPage this$0;

        public C00881(MiniAppLynxSheetPage r1, Continuation<? super C00881> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MiniAppLynxSheetPage.access$loadTemplateBundle(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.sheet.MiniAppLynxSheetPage$resolvePageContent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/miniapp/sheet/SheetPageContent;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.sheet.MiniAppLynxSheetPage$resolvePageContent$1", f = "MiniAppSheetHost.kt", i = {}, l = {911}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SheetPageContent>, Object> {
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $pageName;
        int label;
        final /* synthetic */ MiniAppLynxSheetPage this$0;

        public C00891(String r1, String r2, MiniAppLynxSheetPage r3, Continuation<? super C00891> r4) {
            this.$packageName = r1;
            this.$pageName = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C00891(this.$packageName, this.$pageName, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super SheetPageContent> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            Widget r7 = (Widget) r6;
            if (r7 != null) goto L15;
            return null;
        L15:
            return MiniAppLynxSheetPage.access$buildSheetPageContent(this.this$0, AppletResourceTool.m(AppletResourceTool.a, r7, r7.L), this.$packageName, this.$pageName, true);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            AIManager r8 = AIManager.a;
            String r2 = this.$packageName;
            String r4 = this.$pageName;
            this.label = 1;
            r6 = r8.E(r2, r4, null, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.miniapp.sheet.MiniAppLynxSheetPage$warmUp$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.sheet.MiniAppLynxSheetPage$warmUp$1", f = "MiniAppSheetHost.kt", i = {}, l = {767}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MiniAppLynxSheetPage this$0;

        public C00901(MiniAppLynxSheetPage r1, Continuation<? super C00901> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00901(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            int r2 = this.I$0;
            SheetPageContent r3 = (SheetPageContent) this.L$1;
            AtomicReference r4 = (AtomicReference) this.L$0;
            ResultKt.throwOnFailure(r14);
        L6:
            AtomicReference r12 = r4;
            SheetPageContent r5 = r3;
            if (r2 == 0) goto L20;
            boolean r8 = true;
        L21:
            r12.set(SheetPageContent.copy$default(r5, null, null, null, r8, (TemplateBundle) r14, 15, null));
            return Unit.INSTANCE;
        L20:
            r8 = false;
            goto L21
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
            MiniAppLynxSheetPage r15 = this.this$0;
            r3 = MiniAppLynxSheetPage.access$resolvePageContent(r15, r15.getPageInfo());
            if (r3 == null) goto L12;
            r4 = MiniAppLynxSheetPage.access$getPreloadedPageContent$p(this.this$0);
            MiniAppLynxSheetPage r16 = this.this$0;
            this.L$0 = r4;
            this.L$1 = r3;
            this.I$0 = 0;
            this.label = 1;
            r14 = MiniAppLynxSheetPage.access$loadTemplateBundle(r16, r3, this);
            if (r14 != r0) goto L16;
            return r0;
        L16:
            r2 = 0;
            goto L6
        L12:
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void h(MiniAppLynxSheetPage r0) {
        onDestroy$lambda$3(r0);
    }

    public static /* synthetic */ void j(MiniAppLynxSheetPage r0, Function1 r1) {
        initLynxBridge$lambda$12$lambda$11(r0, r1);
    }

    public static /* synthetic */ void k(MiniAppLynxSheetPage r0, View r1, boolean r2) {
        createLynxView$lambda$10$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ m4.c l(MiniAppLynxSheetPage r0) {
        return createLynxView$lambda$8$lambda$6(r0);
    }

    public static /* synthetic */ Unit m(MiniAppLynxSheetPage r0, Context r1, LynxViewBuilder r2) {
        return createLynxView$lambda$8(r0, r1, r2);
    }

    public void createContainer(ViewGroup r1, k2.b r2, Activity r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r1, "root");
        Intrinsics.checkNotNullParameter(r2, "params");
    }

    private final void initLynxBridge() {
        com.bytedance.ai.lynx.g r0 = this.lynxView;
        if (r0 != null) goto L5;
        return;
    L5:
        MiniAppLynxAIBridgePort r1 = new MiniAppLynxAIBridgePort(r0, this.lynxRemoteBridgeMessages);
        this.lynxBridgePort = r1;
        w r2 = new w();
        r2.j(r0);
        r2.i.e(a0.class, new MiniAppLynxSheetPage$initLynxBridge$1$1(this));
        e3.d.a.a(r2.i, k2.j.class, this);
        e3.d.a.a(r2.i, AppletRuntime.class, getAppletRuntime());
        r2.i.e(z.class, new f(this));
        r2.k(r1);
        this.aiBridge = r2;
    }

    public String getRenderType() {
        return RenderType.LYNX.getTypeName();
    }

    public void onDestroy() {
        if (this.destroyed.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        super.onDestroy();
        this.destroyHandler.postDelayed(new b(this), 2000);
    }

    public final void warmUp() {
        if (this.preloadStarted.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C00901(this, null), 3, null);
    }

    private final TemplateData buildTemplateData() {
        TemplateData r1 = TemplateData.empty();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(new JSONObject(viewContext()));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        JSONObject r4 = (JSONObject) r3;
        if (r4 != null) goto L13;
        r4 = new JSONObject();
    L13:
        r1.put("viewContext", r4);
        String r5 = getPageInfo().getPageData();     // Catch: JSONException -> L19
        if (r5 != null) goto L17;
        r5 = "{}";
    L17:
        r1.put("viewData", new JSONObject(r5));     // Catch: JSONException -> L19
    L21:
        return r1;
    L19:
        e = move-exception;
        FLogger.a.e(TAG, "parse viewData error: " + getPageInfo().getPageData(), e);
        r1.put("viewData", new JSONObject());
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public View engineView() {
        return this.lynxView;
    }

    public b0 getAIBridge() {
        return this.aiBridge;
    }

    public View realView() {
        return this.lynxView;
    }

    public static final /* synthetic */ w access$getAiBridge$p(MiniAppLynxSheetPage r0) {
        return r0.aiBridge;
    }

    public static final /* synthetic */ AtomicBoolean access$getDestroyed$p(MiniAppLynxSheetPage r0) {
        return r0.destroyed;
    }

    public static final /* synthetic */ AtomicReference access$getPreloadedPageContent$p(MiniAppLynxSheetPage r0) {
        return r0.preloadedPageContent;
    }

    private final void createLynxView(final Context r10) {
        com.bytedance.ai.lynx.g r0 = this.lynxView;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        int r1 = AppletLynxViewApi.a;
        h2.a r2 = f2.b.c;
        if (r2 == null) goto L9;
        String r3 = r2.m;
        if (r3 == null) goto L9;
    L10:
        com.bytedance.ai.lynx.g r11 = AppletLynxViewApi.a(r10, r3, ((AIPackage) getAppletRuntime().h).x, getPageInfo().getPackageName(), null, null, new c(this, r10), 48);
        r11.setTag(2131363149, new WeakReference(this));
        r11.addLynxViewClient(this.lynxViewClient);
        r11.addLynxViewClient(new MiniAppLynxSheetPage$createLynxView$2$1(this));
        r11.setClickable(false);
        r11.setFocusable(true);
        r11.setFocusableInTouchMode(true);
        r11.setOnFocusChangeListener(new d(this));
        this.lynxView = r11;
        return;
    L9:
        r3 = "";
        goto L10
    }

    private static final m4.c createLynxView$lambda$8$lambda$6(MiniAppLynxSheetPage r0) {
        return r0.lynxBridgePort;
    }

    private static final void onDestroy$lambda$3(MiniAppLynxSheetPage r3) {
        View r0 = r3.engineView();
        if (r0 == null) goto L5;
        r0.setTag(2131363149, null);
    L5:
        w r1 = r3.aiBridge;
        if (r1 == null) goto L8;
        r1.g();
    L8:
        r3.aiBridge = null;
        r3.lynxBridgePort = null;
        com.bytedance.ai.lynx.g r2 = r3.lynxView;
        if (r2 == null) goto L11;
        r2.destroy();
    L11:
        r3.lynxView = null;
        r3.bodyContainer.removeAllViews();
    }

    private final boolean renderTemplate(TemplateBundle r9) {
        if (r9 != null) goto L5;
    L15:
        FLogger.a.e(TAG, "renderTemplate: bundle is null or invalid");
        return false;
    L5:
        if (r9.i() == false) goto L15;
        String r3 = getPageInfo().getPageUrl();
        if (r3 != null) goto L10;
        return false;
    L10:
        com.bytedance.ai.lynx.g r2 = this.lynxView;
        if (r2 != null) goto L13;
        return false;
    L13:
        TemplateData r5 = buildTemplateData();
        MiniAppLynxSheetPage$lifecycleListener$1 r6 = this.lifecycleListener;
        int r0 = com.bytedance.ai.lynx.g.l;
        r2.i(r3, r9, r5, r6, null);
        return true;
    }

    private final SheetPageContent resolvePageContent(PageInfo r8) {
        String r0 = r8.getPackageName();
        if (StringsKt.isBlank(r0) == false) goto L5;
        r0 = ((AIPackage) getAppletRuntime().h).b;
    L5:
        String r1 = r8.getPageUrl();
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
        String r9 = r8.getPageName();
        if (r9 != null) goto L17;
        return null;
    L17:
        List r3 = getAppletRuntime().h.L;
        if (r3 == null) goto L29;
        Iterator r4 = r3.iterator();
    L21:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((Page) r5).pageId(), r9) == false) goto L21;
    L26:
        Page r6 = (Page) r5;
        if (r6 == null) goto L29;
        String r7 = r6.getEntry();
    L30:
        if (r7 != null) goto L32;
    L35:
        boolean r10 = true;
    L36:
        if (r10 == true) goto L40;
        return buildSheetPageContent(AppletResourceTool.l(AppletResourceTool.a, getAppletRuntime().h, r7), r0, r9, false);
    L40:
        return (SheetPageContent) BuildersKt.runBlocking$default(null, new C00891(r0, r9, this, null), 1, null);
    L32:
        if (r7.length() == 0) goto L35;
        r10 = false;
        goto L36
    L25:
        r5 = null;
    L29:
        r7 = null;
        goto L30
    L13:
        return buildSheetPageContent(r8.getPageUrl(), r0, r8.getPageName(), r8.isWidget());
    L8:
        if (StringsKt.startsWith$default(r1, "http", false, 2, null) != true) goto L10;
        r2 = true;
        goto L11
    }

    private final int scaleSize(double r3) {
        h2.a r0 = f2.b.c;
        if (r0 == null) goto L8;
        Integer r1 = r0.s;
        if (r1 == null) goto L8;
        return (int) (o.c(Double.valueOf(r3)) * (r1.intValue() / o.a(17.0f)));
    L8:
        int r2 = o.a;
        return o.c(Double.valueOf(r3));
    }

    public void onMessageToJS(String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        FLogger.a.i(TAG, "onMessageToJS is not supported, message=" + r4);
    }

    public static final /* synthetic */ boolean access$renderTemplate(MiniAppLynxSheetPage r0, TemplateBundle r1) {
        return r0.renderTemplate(r1);
    }

    public static final /* synthetic */ SheetPageContent access$resolvePageContent(MiniAppLynxSheetPage r0, PageInfo r1) {
        return r0.resolvePageContent(r1);
    }

    public static final /* synthetic */ void access$setAiBridge$p(MiniAppLynxSheetPage r0, w r1) {
        r0.aiBridge = r1;
    }

    public static final /* synthetic */ void access$setLynxBridgePort$p(MiniAppLynxSheetPage r0, m4.c r1) {
        r0.lynxBridgePort = r1;
    }

    private static final void initLynxBridge$lambda$12$lambda$11(MiniAppLynxSheetPage r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.invoke(r1.getAppletRuntime());
    }

    private final Object loadTemplateBundle(SheetPageContent r8, Continuation<? super TemplateBundle> r9) {
        if ((r9 instanceof C00881) == false) goto L7;
        C00881 r0 = (C00881) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        C00881 r6 = r0;
        Object r10 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L28
    L26:
        Object r11 = Result.constructor-impl((TemplateBundle) r10);     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r11) == false) goto L36;
        return null;
    L36:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L28
        int r13 = AppletLynxViewApi.a;     // Catch: Throwable -> L28
        String r14 = ((AIPackage) getAppletRuntime().h).x;     // Catch: Throwable -> L28
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        String r4 = r14;
        String r15 = r8.getRealUrl();     // Catch: Throwable -> L28
        if (((AIPackage) getAppletRuntime().h).E != 1) goto L22;
        boolean r5 = true;
    L23:
        String r7 = r8.getPackageName();     // Catch: Throwable -> L28
        String r16 = r8.getBundleId();     // Catch: Throwable -> L28
        r6.label = 1;     // Catch: Throwable -> L28
        r10 = AppletLynxViewApi.b(r4, r15, r5, r7, r16, r6);     // Catch: Throwable -> L28
        if (r10 != r2) goto L26;
        return r2;
    L22:
        r5 = false;
    L28:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new C00881(this, r9);
        goto L8
    }

    public a6.a getViewModel(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        if (r4 == false) goto L13;
        LifecycleOwner r6 = MiniAppSheetHostKt.access$findActivity(this.bodyContainer.getContext());
        if ((r6 instanceof LifecycleOwner) == false) goto L7;
        LifecycleOwner r7 = r6;
    L8:
        if (r7 != null) goto L12;
        FLogger.a.w(TAG, "shared ViewModel requested but no LifecycleOwner found, groupId=" + r5);
        return null;
    L12:
        return SharedViewModelExtKt.b(r7, r5);
    L7:
        r7 = null;
        goto L8
    L13:
        a6.a r8 = this.aiViewModelMap.get(r5);
        if (r8 != null) goto L17;
        a6.a r9 = new AIPrivateViewModel.a(r5);
        this.aiViewModelMap.put(r5, r9);
        return r9;
    L17:
        return r8;
    }

    public void handleContentSizeChange(double r1, double r3) {
        Function1<Integer, Unit> r2 = this.onAdaptiveHeightChanged;
        if (r2 == null) goto L6;
        r2.invoke(Integer.valueOf(scaleSize(r3)));
        return;
    }

    public void onMessageToAIBridge(String r2, JsonObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        w r0 = this.aiBridge;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    public static final /* synthetic */ Object access$loadTemplateBundle(MiniAppLynxSheetPage r0, SheetPageContent r1, Continuation r2) {
        return r0.loadTemplateBundle(r1, r2);
    }

    private static final void createLynxView$lambda$10$lambda$9(MiniAppLynxSheetPage r0, View r1, boolean r2) {
        r0.onFocusChange(r2);
    }

    private static final Unit createLynxView$lambda$8(final MiniAppLynxSheetPage r5, Context r6, LynxViewBuilder r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$createLynxView");
        String r0 = r5.getAppletId();
        if (r0 == null) goto L7;
        b3.a r1 = b3.b.a.a(r0);
        if (r1 == null) goto L7;
        r7.setLynxGroup(r1.c);
    L7:
        r7.registerModule("AppletBridgeModule", AppletBridgeModule.class, new AppletBridgeModule.b(r5.lynxRemoteBridgeMessages, null, new e(r5), ContainerType.PAGE));
        h2.a r8 = f2.b.c;
        if (r8 == null) goto L13;
        Integer r9 = r8.s;
        if (r9 == null) goto L13;
        AppletLynxViewApi.c(r7, r6, r9.intValue() / o.a(17.0f));
    L13:
        return Unit.INSTANCE;
    }

    private final SheetPageContent buildSheetPageContent(String r8, String r9, String r10, boolean r11) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new SheetPageContent(r8, r9, r10, r11, null);
    }

    public View createPage(PageInfo r10, Context r11, Function1<? super Integer, Unit> r12, Function1<? super String, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        super.createPage(r10, r11, null, null);
        setPageInfo(r10);
        getPageInfo().setPageId(getPageID());
        SheetPageContent r1 = this.preloadedPageContent.get();
        if (r1 != null) goto L9;
        r1 = resolvePageContent(r10);
        if (r1 != null) goto L9;
        if (r13 == null) goto L8;
        r13.invoke("openSheetPage failed to resolve page content");
    L8:
        return null;
    L9:
        SheetPageContent r2 = r1;
        getPageInfo().setPageUrl(r2.getRealUrl());
        getPageInfo().setPackageName(r2.getPackageName());
        getPageInfo().setWidget(r2.isWidget());
        AppletRuntimeManager.INSTANCE.getClass();
        setEventCommonParams(AppletRuntimeManager.e);
        if (r11 != null) goto L12;
        r11 = this.bodyContainer.getContext();
    L12:
        Intrinsics.checkNotNull(r11);
        createLynxView(r11);
        initLynxBridge();
        View r14 = this.lynxView;
        if (r14 != null) goto L17;
        if (r13 == null) goto L16;
        r13.invoke("createLynxView failed");
    L16:
        return null;
    L17:
        this.bodyContainer.removeAllViews();
        this.bodyContainer.addView(r14, new FrameLayout.LayoutParams(-1, this.contentLayoutHeight));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r2, this, r13, r12, null), 3, null);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.obric.miniapp.sheet.MiniAppLynxSheetPage$lynxViewClient$1] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.obric.miniapp.sheet.MiniAppLynxSheetPage$lifecycleListener$1] */
    public MiniAppLynxSheetPage(AppletRuntime r2, final PageInfo r3, ViewGroup r4, int r5, Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "appletRuntime");
        Intrinsics.checkNotNullParameter(r3, "pageInfo");
        Intrinsics.checkNotNullParameter(r4, "bodyContainer");
        super(r2, r3);
        this.bodyContainer = r4;
        this.contentLayoutHeight = r5;
        this.onAdaptiveHeightChanged = r6;
        this.destroyHandler = new Handler(Looper.getMainLooper());
        this.lynxRemoteBridgeMessages = new s4.c();
        this.aiViewModelMap = new LinkedHashMap();
        this.destroyed = new AtomicBoolean(false);
        this.preloadStarted = new AtomicBoolean(false);
        this.preloadedPageContent = new AtomicReference(null);
        this.lynxViewClient = new MiniAppLynxSheetPage$lynxViewClient$1(r3);
        this.lifecycleListener = new MiniAppLynxSheetPage$lifecycleListener$1(this);
        r3.setPageId(getPageID());
    }

    public static final /* synthetic */ SheetPageContent access$buildSheetPageContent(MiniAppLynxSheetPage r0, String r1, String r2, String r3, boolean r4) {
        return r0.buildSheetPageContent(r1, r2, r3, r4);
    }
}
