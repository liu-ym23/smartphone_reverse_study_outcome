package com.bytedance.ai.ex.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Trace;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.bridge.context.RefType;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.ex.widget.jsb.AbsAddBizEntityMethodIDL;
import com.bytedance.ai.ex.widget.jsb.AddBizEntityMethod;
import com.bytedance.ai.ex.widget.jsb.AddBizEntityMethodKt;
import com.bytedance.ai.ex.widget.rpc.MiniAppWidgetManagerRemote;
import com.bytedance.ai.model.objects.WidgetInfo;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.models.OAppletWrap;
import com.bytedance.ai.widget.o;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c0;
import kotlinx.coroutines.flow.d2;
import kotlinx.coroutines.flow.n1;
import kotlinx.coroutines.flow.q2;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.t0;
import w0.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0091\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0091\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0012J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0012J7\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\rH\u0016¢\u0006\u0004\b%\u0010&JD\u00101\u001a\u00020\u00102\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/H\u0086@¢\u0006\u0004\b1\u00102J!\u00106\u001a\u00020\r2\u0006\u00103\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J!\u0010;\u001a\u0016\u0012\u0004\u0012\u000209\u0018\u000108j\n\u0012\u0004\u0012\u000209\u0018\u0001`:¢\u0006\u0004\b;\u0010<J\u0015\u0010=\u001a\u00020\r2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b=\u0010>J3\u0010E\u001a\u00020\u0010\"\u0004\b\u0000\u0010?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@2\u0006\u0010B\u001a\u00028\u00002\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ#\u0010G\u001a\u00020\u0010\"\u0004\b\u0000\u0010?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@H\u0016¢\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010?2\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@H\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u00102\u0006\u0010K\u001a\u00020\u0019H\u0016¢\u0006\u0004\bL\u0010MJA\u0010S\u001a\u00020\u00102\u0006\u0010N\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u0001042\u000e\u0010P\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010O2\u000e\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010OH\u0016¢\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001a\u00020\u00102\u0006\u0010U\u001a\u00020\rH\u0016¢\u0006\u0004\bV\u0010&J\u0019\u0010Y\u001a\u00020\u00102\b\u0010X\u001a\u0004\u0018\u00010WH\u0014¢\u0006\u0004\bY\u0010ZJ\u0019\u0010]\u001a\u00020\u00102\b\u0010\\\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020+H\u0002¢\u0006\u0004\b_\u0010`J\u001b\u0010b\u001a\u00020\u00102\n\b\u0002\u0010a\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0004\bb\u0010cJ!\u0010d\u001a\u00020\r2\u0006\u00103\u001a\u00020+2\b\u00105\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0004\bd\u00107J\u000f\u0010e\u001a\u00020\u0010H\u0002¢\u0006\u0004\be\u0010\u0012R\u0018\u0010g\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010i\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010k\u001a\u0004\u0018\u00010)8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b*\u0010l\"\u0004\bm\u0010nR\u0018\u0010o\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010pR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020r0q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR0\u0010v\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R0\u0010|\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010u8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b|\u0010w\u001a\u0004\b}\u0010y\"\u0004\b~\u0010{R\u001f\u0010\u0080\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001f\u0010\u0082\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0081\u0001R\u001f\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0081\u0001R\u001f\u0010\u0084\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0081\u0001R\u001c\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008a\u0001R%\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u0002040\u008c\u00018BX\u0082\u0004¢\u0006\u000f\u0012\u0005\b\u008f\u0001\u0010\u0012\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/ai/ex/widget/WidgetView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ai/ex/widget/MessageReceiver;", "Lcom/bytedance/ai/ex/widget/BridgeContext;", "Lcom/bytedance/ai/ex/widget/OnThemeChangedListener;", "Lcom/bytedance/ai/ex/widget/EventCall;", "Lcom/bytedance/ai/ex/widget/OnHideSensitiveChangedListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "onAttachedToWindow", "()V", "onDetachedFromWindow", "destroyHost", "destroyHostIfNeeded", "()Z", "requestLayout", "changed", "", OpenPageMethod.ALIGN_LEFT, "top", "right", "bottom", "onLayout", "(ZIIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "Lcom/bytedance/ai/model/objects/WidgetInfo;", "widgetInfo", "", "host", "", "messageId", "Lw0/m;", "widgetLifeObserver", "Lcom/bytedance/ai/widget/models/OAppletWrap;", "appletWrap", "bindData", "(Lcom/bytedance/ai/model/objects/WidgetInfo;Ljava/lang/Object;Ljava/lang/String;Lw0/m;Lcom/bytedance/ai/widget/models/OAppletWrap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "eventName", "Lcom/google/gson/JsonObject;", LynxResourceModule.PARAMS_KEY, "onMessageToAIBridge", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)Z", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlin/collections/ArrayList;", "assistContent", "()Ljava/util/ArrayList;", MiniAppWidgetManagerRemote.METHOD_UPDATE_WIDGET_DATA, "(Lcom/bytedance/ai/model/objects/WidgetInfo;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", "t", "Lcom/bytedance/ai/bridge/context/RefType;", "refType", "registerObject", "(Ljava/lang/Class;Ljava/lang/Object;Lcom/bytedance/ai/bridge/context/RefType;)V", "unregisterObject", "(Ljava/lang/Class;)V", "getObject", "(Ljava/lang/Class;)Ljava/lang/Object;", "theme", "onThemeChanged", "(I)V", "name", "Landroidx/core/util/Consumer;", "resolve", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "reject", "sendCall", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Landroidx/core/util/Consumer;Landroidx/core/util/Consumer;)V", "isHideSensitive", WidgetView.ON_HIDE_SENSITIVE_CHANGED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "setupAliveRepeat", "(Landroidx/lifecycle/LifecycleOwner;)V", "getIdentity", "()Ljava/lang/String;", "messageIdToRemove", "clearHostBinding", "(Ljava/lang/String;)V", "onMessageToAIBridgeInternal", "checkConfigurationChanged", "Landroid/view/View;", "rootView", "Landroid/view/View;", "destroyRequested", "Z", "value", "Ljava/lang/Object;", "setHost", "(Ljava/lang/Object;)V", "widgetId", "Ljava/lang/String;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ai/ex/widget/jsb/AbsAddBizEntityMethodIDL$AddBizEntityMethodParamModel;", "donateEntity", "Landroidx/lifecycle/MutableLiveData;", "", "environmentConfig", "Ljava/util/Map;", "getEnvironmentConfig", "()Ljava/util/Map;", "setEnvironmentConfig", "(Ljava/util/Map;)V", "viewContext", "getViewContext", "setViewContext", "Lkotlinx/coroutines/flow/d2;", "isHideSensitiveFlow", "Lkotlinx/coroutines/flow/d2;", "themeFlow", "dataFlow", "viewDataFlow", "Lkotlinx/coroutines/t0;", "dataObserver", "Lkotlinx/coroutines/t0;", "", WidgetView.DENSITY, "Ljava/lang/Float;", "fontScale", "Lkotlinx/coroutines/flow/g;", "getOnWidgetDataChanged", "()Lkotlinx/coroutines/flow/g;", "getOnWidgetDataChanged$annotations", "onWidgetDataChanged", "Companion", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWidgetView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetView.kt\ncom/bytedance/ai/ex/widget/WidgetView\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 5 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,445:1\n190#2:446\n20#3:447\n22#3:451\n50#4:448\n55#4:450\n106#5:449\n1#6:452\n*S KotlinDebug\n*F\n+ 1 WidgetView.kt\ncom/bytedance/ai/ex/widget/WidgetView\n*L\n99#1:446\n106#1:447\n106#1:451\n106#1:448\n106#1:450\n106#1:449\n*E\n"})
public final class WidgetView extends FrameLayout implements MessageReceiver, BridgeContext, OnThemeChangedListener, EventCall, OnHideSensitiveChangedListener {
    private static final long BACKGROUND_THROTTLE = 0;
    public static final Companion Companion = null;
    public static final String DENSITY = "density";
    public static final String ENV_DESTROY_ON_DETACH = "destroyOnDetach";
    public static final String FONT_SCALE = "font_Scale";
    public static final String ON_HIDE_SENSITIVE_CHANGED = "onHideSensitiveChanged";
    public static final String ON_THEME_CHANGED = "onThemeChange";
    public static final String TAG = "WidgetView";
    public static final String UI_MODE_DARK = "dark";
    public static final String UI_MODE_LIGHT = "light";
    private final d2 dataFlow;
    private t0 dataObserver;
    private Float density;
    private volatile boolean destroyRequested;
    private final MutableLiveData<AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel> donateEntity;
    private Map<Object, Object> environmentConfig;
    private Float fontScale;
    private Object host;
    private final d2 isHideSensitiveFlow;
    private String messageId;
    private View rootView;
    private final d2 themeFlow;
    private Map<String, String> viewContext;
    private final d2 viewDataFlow;
    private String widgetId;

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LifecycleOwner;", ST.IMPLICIT_ARG_NAME, "Landroid/view/View;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$1", f = "WidgetView.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<LifecycleOwner, View, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetView this$0;

        public AnonymousClass1(WidgetView r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(3, r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.this$0, r11);
            r12.L$0 = r10;
            return r12.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v11 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L9;
            if (r11 != 1) goto L8;
            ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L13
            AnonymousClass1 this = this;
        L21:
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.flow.g r12 = RepeatWhenAttachedKt.isVisible((View) this.L$0);     // Catch: CancellationException -> L13
            final WidgetView r13 = this.this$0;     // Catch: CancellationException -> L13
            kotlinx.coroutines.flow.h r14 = new C00141(r13);     // Catch: CancellationException -> L13
            this.label = 1;     // Catch: CancellationException -> L13
            Object r15 = r12.collect(r14, this);     // Catch: CancellationException -> L13
            this = r15;
            if (r15 != r5) goto L21;
            return r5;
        L13:
            LogProxy r16 = LogAdapter.INSTANCE.getImpl();
            if (r16 == null) goto L16;
            LogProxy.DefaultImpls.i$default(r16, WidgetView.TAG, "change " + WidgetView.access$getIdentity(this.this$0) + " visible onHide", null, 4, null);
        L16:
            com.bytedance.ai.widget.contianer.f r17 = WidgetRenderService.INSTANCE.findWidgetContainerByView(WidgetView.access$getRootView$p(this.this$0));
            if (r17 == null) goto L20;
            ((WidgetContainer) r17).l();
            goto L20
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LifecycleOwner;", ST.IMPLICIT_ARG_NAME, "Landroid/view/View;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$2", f = "WidgetView.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<LifecycleOwner, View, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetView this$0;

        public AnonymousClass2(WidgetView r5, Continuation<? super AnonymousClass2> r10) {
            this.this$0 = r5;
            super(3, r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(this.this$0, r11);
            r12.L$0 = r5;
            return r12.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            final LifecycleOwner r12 = (LifecycleOwner) this.L$0;
            d2 r13 = WidgetView.access$isHideSensitiveFlow$p(this.this$0);
            final WidgetView r14 = this.this$0;
            kotlinx.coroutines.flow.h r15 = new AnonymousClass1(r12, r14);
            this.label = 1;
            Object r16 = r13.collect(new n1(r15), this);
            if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r16 = Unit.INSTANCE;
        L12:
            if (r16 != r5) goto L15;
            return r5;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetView$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LifecycleOwner;", ST.IMPLICIT_ARG_NAME, "Landroid/view/View;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$3", f = "WidgetView.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<LifecycleOwner, View, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetView this$0;

        public AnonymousClass3(WidgetView r5, Continuation<? super AnonymousClass3> r10) {
            this.this$0 = r5;
            super(3, r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            AnonymousClass3 r12 = new AnonymousClass3(this.this$0, r11);
            r12.L$0 = r5;
            return r12.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            final LifecycleOwner r12 = (LifecycleOwner) this.L$0;
            d2 r13 = WidgetView.access$getThemeFlow$p(this.this$0);
            final WidgetView r14 = this.this$0;
            kotlinx.coroutines.flow.h r15 = new AnonymousClass1(r12, r14);
            this.label = 1;
            Object r16 = r13.collect(new n1(r15), this);
            if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r16 = Unit.INSTANCE;
        L12:
            if (r16 != r5) goto L15;
            return r5;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u00020\u000e¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/ex/widget/WidgetView$Companion;", "", "<init>", "()V", "ENV_DESTROY_ON_DETACH", "", "ON_THEME_CHANGED", "ON_HIDE_SENSITIVE_CHANGED", "UI_MODE_DARK", "UI_MODE_LIGHT", "TAG", "DENSITY", "FONT_SCALE", "BACKGROUND_THROTTLE", "Lkotlin/time/Duration;", "getBACKGROUND_THROTTLE-UwyO8pc", "()J", "J", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        /* JADX INFO: renamed from: getBACKGROUND_THROTTLE-UwyO8pc, reason: not valid java name */
        public final long m85getBACKGROUND_THROTTLEUwyO8pc() {
            return WidgetView.access$getBACKGROUND_THROTTLE$cp();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetView$bindData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView", f = "WidgetView.kt", i = {0, 0, 0, 0}, l = {281}, m = "bindData", n = {"this", "host", "widgetLifeObserver", "boundMessageId"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class C01681 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetView this$0;

        public C01681(WidgetView r5, Continuation<? super C01681> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.bindData(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.ex.widget.WidgetView$setupAliveRepeat$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LifecycleOwner;", ST.IMPLICIT_ARG_NAME, "Landroid/view/View;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.ex.widget.WidgetView$setupAliveRepeat$1", f = "WidgetView.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01691 extends SuspendLambda implements Function3<LifecycleOwner, View, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WidgetView this$0;

        public C01691(WidgetView r5, Continuation<? super C01691> r10) {
            this.this$0 = r5;
            super(3, r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            return new C01691(this.this$0, r11).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            kotlinx.coroutines.flow.g r12 = WidgetView.access$getOnWidgetDataChanged(this.this$0);
            final WidgetView r13 = this.this$0;
            kotlinx.coroutines.flow.h r14 = new C00151(r13);
            this.label = 1;
            if (r12.collect(r14, this) != r10) goto L12;
            return r10;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(LifecycleOwner r5, View r10, Continuation<? super Unit> r11) {
            return invoke2(r5, r10, r11);
        }
    }

    static {
        Companion = new Companion(null);
        Duration.Companion r5 = Duration.Companion;
        BACKGROUND_THROTTLE = DurationKt.toDuration(3, DurationUnit.SECONDS);
    }

    public WidgetView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.donateEntity = new MutableLiveData();
        this.isHideSensitiveFlow = kotlinx.coroutines.flow.i.b(null);
        this.themeFlow = kotlinx.coroutines.flow.i.b(null);
        this.dataFlow = kotlinx.coroutines.flow.i.b(null);
        this.viewDataFlow = kotlinx.coroutines.flow.i.b(null);
        RepeatWhenAttachedKt.repeatWhenAttached$default(this, null, new AnonymousClass1(this, null), 1, null);
        RepeatWhenAttachedKt.repeatWhenAttached$default(this, null, new AnonymousClass2(this, null), 1, null);
        RepeatWhenAttachedKt.repeatWhenAttached$default(this, null, new AnonymousClass3(this, null), 1, null);
    }

    public static /* synthetic */ void a(Job r5) {
        setupAliveRepeat$realSetup$lambda$3$lambda$2(r5);
    }

    public static final /* synthetic */ long access$getBACKGROUND_THROTTLE$cp() {
        return BACKGROUND_THROTTLE;
    }

    public static final /* synthetic */ d2 access$getDataFlow$p(WidgetView r5) {
        return r5.dataFlow;
    }

    public static final /* synthetic */ String access$getIdentity(WidgetView r5) {
        return r5.getIdentity();
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.g access$getOnWidgetDataChanged(WidgetView r5) {
        return r5.getOnWidgetDataChanged();
    }

    public static final /* synthetic */ View access$getRootView$p(WidgetView r5) {
        return r5.rootView;
    }

    public static final /* synthetic */ d2 access$getThemeFlow$p(WidgetView r5) {
        return r5.themeFlow;
    }

    public static final /* synthetic */ d2 access$getViewDataFlow$p(WidgetView r5) {
        return r5.viewDataFlow;
    }

    public static final /* synthetic */ d2 access$isHideSensitiveFlow$p(WidgetView r5) {
        return r5.isHideSensitiveFlow;
    }

    public static final /* synthetic */ boolean access$onMessageToAIBridgeInternal(WidgetView r5, String r10, JsonObject r11) {
        return r5.onMessageToAIBridgeInternal(r10, r11);
    }

    public static /* synthetic */ boolean b(String r5, com.bytedance.ai.widget.contianer.f r10) {
        return bindData$lambda$7(r5, r10);
    }

    public static /* synthetic */ Object bindData$default(WidgetView r10, WidgetInfo r11, Object r12, String r13, m r14, OAppletWrap r15, Continuation r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        m r19 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        OAppletWrap r20 = null;
    L15:
        return r10.bindData(r11, r12, r5, r19, r20, r16);
    L13:
        r20 = r15;
        goto L15
    L9:
        r19 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    private static final boolean bindData$lambda$7(String r5, com.bytedance.ai.widget.contianer.f r10) {
        Intrinsics.checkNotNullParameter(r5, "$boundMessageId");
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        com.bytedance.ai.widget.contianer.h r11 = ((WidgetContainer) r10).f;
        if (r11 == null) goto L5;
        String r12 = r11.e;
    L7:
        return Intrinsics.areEqual(r12, r5);
    L5:
        r12 = null;
        goto L7
    }

    private final void checkConfigurationChanged() {
        float r5 = getContext().getResources().getDisplayMetrics().density;
        float r10 = getContext().getResources().getConfiguration().fontScale;
        if (Intrinsics.areEqual(r5, this.density) == true) goto L5;
    L8:
        this.density = Float.valueOf(r5);
        this.fontScale = Float.valueOf(r10);
        JsonObject r11 = new JsonObject();
        r11.addProperty(DENSITY, this.density);
        r11.addProperty(FONT_SCALE, this.fontScale);
        Unit r12 = Unit.INSTANCE;
        onMessageToAIBridge("obric.onConfigurationChanged", r11);
        return;
    L5:
        if (Intrinsics.areEqual(r10, this.fontScale) == false) goto L8;
    }

    private final void clearHostBinding(String r5) {
        TypeIntrinsics.asMutableMap(AddBizEntityMethod.Companion.getDonateCallback()).remove(r5);
        this.rootView = null;
        setHost(null);
        this.widgetId = null;
        this.messageId = null;
    }

    public static /* synthetic */ void clearHostBinding$default(WidgetView r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = r5.messageId;
    L5:
        r5.clearHostBinding(r10);
    }

    private final String getIdentity() {
        return this.widgetId + '-' + System.identityHashCode(this);
    }

    private final kotlinx.coroutines.flow.g getOnWidgetDataChanged() {
        kotlinx.coroutines.flow.g r10 = kotlinx.coroutines.flow.i.h(new c0(RepeatWhenAttachedKt.isVisible(this), new WidgetView$onWidgetDataChanged$1(null)));
        WidgetView$special$$inlined$flatMapLatest$1 r5 = new WidgetView$special$$inlined$flatMapLatest$1(null, this);
        int r11 = u0.f18908a;
        final kotlinx.coroutines.flow.internal.i r12 = new kotlinx.coroutines.flow.internal.i(r5, r10, EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
        return new WidgetView$special$$inlined$filter$1(r12, this);
    }

    private static /* synthetic */ void getOnWidgetDataChanged$annotations() {
    }

    private final boolean onMessageToAIBridgeInternal(String r10, JsonObject r11) {
        com.bytedance.ai.widget.contianer.f r5 = WidgetRenderService.INSTANCE.findWidgetContainerByView(this.rootView);
        if (r5 == null) goto L12;
        LogProxy r12 = LogAdapter.INSTANCE.getImpl();
        if (r12 == null) goto L7;
        LogProxy.DefaultImpls.i$default(r12, TAG, "onMessageToAIBridge, " + getIdentity() + ", data: " + r11, null, 4, null);
    L7:
        m1.i r13 = ((WidgetContainer) r5).f3025l;
        if (r13 == null) goto L14;
        r13.e(r10, r11);
        return true;
    L14:
        return true;
    L12:
        return false;
    }

    private final void setHost(Object r5) {
        LifecycleOwner r10 = null;
        if (r5 != null) goto L9;
        t0 r11 = this.dataObserver;
        if (r11 == null) goto L7;
        r11.dispose();
    L7:
        this.dataObserver = null;
    L12:
        this.host = r5;
        return;
    L9:
        if ((r5 instanceof LifecycleOwner) == false) goto L11;
        r10 = (LifecycleOwner) r5;
    L11:
        setupAliveRepeat(r10);
        goto L12
    }

    private final void setupAliveRepeat(LifecycleOwner r5) {
        t0 r10 = this.dataObserver;
        if (r10 == null) goto L5;
        r10.dispose();
    L5:
        this.dataObserver = setupAliveRepeat$realSetup(r5, this, new C01691(this, null));
    }

    private static final t0 setupAliveRepeat$realSetup(LifecycleOwner r10, WidgetView r11, Function3<? super LifecycleOwner, ? super View, ? super Continuation<? super Unit>, ? extends Object> r12) {
        if (r10 == null) goto L11;
        LifecycleCoroutineScope r5 = LifecycleOwnerKt.getLifecycleScope(r10);
        if (r5 == null) goto L11;
        final Job r13 = BuildersKt.launch$default(r5, null, null, new WidgetView$setupAliveRepeat$realSetup$1(r12, r10, r11, null), 3, null);
        if (r13 == null) goto L11;
        return new i(r13);
    L11:
        return RepeatWhenAttachedKt.repeatWhenAttached$default(r11, null, r12, 1, null);
    }

    private static final void setupAliveRepeat$realSetup$lambda$3$lambda$2(Job r5) {
        Intrinsics.checkNotNullParameter(r5, "$it");
        r5.cancel(null);
    }

    public final ArrayList<AppEntity> assistContent() {
        AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel r5 = this.donateEntity.getValue();
        if (r5 == null) goto L8;
        AppEntity r10 = AddBizEntityMethodKt.toAppEntity(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return CollectionsKt.arrayListOf(new AppEntity[]{r10});
    L8:
        return null;
    }

    public final Object bindData(WidgetInfo r22, Object r23, String r24, m r25, OAppletWrap r26, Continuation<? super Unit> r27) {
        WidgetView r10 = this;
        Object r11 = r23;
        m r12 = r25;
        if ((r27 instanceof C01681) == false) goto L8;
        C01681 r5 = (C01681) r27;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L8;
        r5.label = r13 - Integer.MIN_VALUE;
    L7:
        C01681 r14 = r5;
        Object r15 = r14.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r14.label;
        if (r17 == 0) goto L15;
        if (r17 != 1) goto L14;
        String r18 = (String) r14.L$3;
        m r19 = (m) r14.L$2;
        Object r20 = r14.L$1;
        WidgetView r21 = (WidgetView) r14.L$0;
        ResultKt.throwOnFailure(r15);
        r12 = r19;
        r11 = r20;
        r10 = r21;
    L45:
        View r28 = (View) r15;
        if (r10.destroyRequested == false) goto L55;
        WidgetRenderService.INSTANCE.destroyOwnedWidgetHost(r10, r18, r28);
        r10.clearHostBinding(r18);
        if (r12 == null) goto L50;
        r12.onDestroy();
    L50:
        LogProxy r29 = LogAdapter.INSTANCE.getImpl();
        if (r29 == null) goto L54;
        LogProxy.DefaultImpls.w$default(r29, TAG, f4.b.b(new StringBuilder("bindData destroyed created widget because host destroy requested, "), r10.getIdentity(), ", messageId=", r18), null, 4, null);
    L54:
        return Unit.INSTANCE;
    L55:
        r10.rootView = r28;
        WidgetRenderService r30 = WidgetRenderService.INSTANCE;
        x0.a r31 = r30.getWidgetManager(r10);
        if (r31 == null) goto L61;
        o r32 = (o) r31;
        com.bytedance.ai.widget.contianer.f r33 = r32.c(new f(r18, 2));
        if (r33 == null) goto L61;
        ((AppletWidgetContainer) r33).d();
    L61:
        if (r10.rootView != null) goto L64;
        if (r12 == null) goto L64;
        r12.onPageError();
    L64:
        r30.onViewCreated(r11);
        com.bytedance.ai.widget.contianer.f r34 = r30.findWidgetContainerByView(r10.rootView);
        if ((r34 instanceof WidgetContainer) == false) goto L67;
        WidgetContainer r35 = (WidgetContainer) r34;
    L68:
        if (r35 == null) goto L71;
        r35.i(WidgetContainer.LifecycleEvent.d);
    L71:
        return Unit.INSTANCE;
    L67:
        r35 = null;
        goto L68
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        if (r10.destroyRequested == false) goto L24;
        if (r12 == null) goto L19;
        r25.onDestroy();
    L19:
        LogProxy r36 = LogAdapter.INSTANCE.getImpl();
        if (r36 == null) goto L23;
        LogProxy.DefaultImpls.w$default(r36, TAG, f4.b.b(new StringBuilder("bindData skipped because host destroy requested, "), getIdentity(), ", incomingMessageId=", r24), null, 4, null);
    L23:
        return Unit.INSTANCE;
    L24:
        float r37 = getContext().getResources().getDisplayMetrics().density;
        r10.density = Boxing.boxFloat(r37);
        Map<String, String> r38 = r10.viewContext;
        if (r38 == null) goto L27;
        String r39 = r38.put(DENSITY, String.valueOf(r37));
    L27:
        float r40 = getContext().getResources().getConfiguration().fontScale;
        r10.fontScale = Boxing.boxFloat(r40);
        Map<String, String> r41 = r10.viewContext;
        if (r41 == null) goto L30;
        String r42 = r41.put(FONT_SCALE, String.valueOf(r40));
    L30:
        r10.setHost(r11);
        r10.widgetId = r22.getWidgetId();
        if (r24 != null) goto L33;
        String r110 = UUID.randomUUID().toString();
    L34:
        AddBizEntityMethod.Companion.getDonateCallback().put(r110, r10.donateEntity);
        r10.messageId = r110;
        LogProxy r111 = LogAdapter.INSTANCE.getImpl();
        if (r111 == null) goto L37;
        StringBuilder r43 = new StringBuilder("bindData, ");
        f8.b.e(r43, getIdentity(), ", incomingMessageId=", r24, ", data: ");
        r43.append(r22.getWidgetData());
        LogProxy.DefaultImpls.i$default(r111, TAG, r43.toString(), null, 4, null);
    L37:
        WidgetRenderService r44 = WidgetRenderService.INSTANCE;
        if (r12 != null) goto L40;
        m r45 = new WidgetView$bindData$createdRootView$1();
    L41:
        Map<String, String> r46 = r10.viewContext;
        r14.L$0 = r10;
        r14.L$1 = r11;
        r14.L$2 = r12;
        r14.L$3 = r110;
        r14.label = 1;
        r15 = r44.createWidget(r22, this, r23, r110, r45, null, r46, r26, r14);
        if (r15 != r16) goto L44;
        return r16;
    L44:
        r18 = r110;
        goto L45
    L40:
        r45 = r12;
        goto L41
    L33:
        r110 = r24;
    L8:
        r5 = new C01681(r10, r27);
        goto L7
    }

    public final void destroyHost() {
        destroyHostIfNeeded();
    }

    public final boolean destroyHostIfNeeded() {
        if (this.destroyRequested == true) goto L5;
    L11:
        this.destroyRequested = true;
        String r5 = this.messageId;
        View r10 = this.rootView;
        if (Intrinsics.areEqual(this, this.host) == true) goto L15;
        if (r5 != null) goto L15;
        if (r10 != null) goto L15;
    L16:
        clearHostBinding(r5);
        return true;
    L15:
        WidgetRenderService.INSTANCE.destroyOwnedWidgetHost(this, r5, r10);
        goto L16
    L5:
        if (this.host != null) goto L11;
        if (this.messageId != null) goto L11;
        if (this.rootView != null) goto L11;
        return true;
    }

    public final Map<Object, Object> getEnvironmentConfig() {
        return this.environmentConfig;
    }

    @Override // com.bytedance.ai.ex.widget.BridgeContext
    public <T> T getObject(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Map<Object, Object> r10 = this.environmentConfig;
        if (r10 == null) goto L5;
        T r11 = (T) r10.get(r5);
    L6:
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public final Map<String, String> getViewContext() {
        return this.viewContext;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        checkConfigurationChanged();
        if (Intrinsics.areEqual(this, this.host) == false) goto L6;
        WidgetRenderService.INSTANCE.onHostShow(this);
        return;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        checkConfigurationChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Intrinsics.areEqual(this, this.host) == false) goto L17;
        Map<Object, Object> r5 = this.environmentConfig;
        Boolean r10 = null;
        if (r5 == null) goto L7;
        Object r11 = r5.get(ENV_DESTROY_ON_DETACH);
    L9:
        if ((r11 instanceof Boolean) == false) goto L11;
        r10 = (Boolean) r11;
    L11:
        if (r10 == null) goto L13;
        boolean r12 = r10.booleanValue();
    L14:
        WidgetRenderService r13 = WidgetRenderService.INSTANCE;
        r13.onHostHide(this);
        if (r12 == false) goto L17;
        r13.onHostDestroy(this);
        goto L17
    L13:
        r12 = true;
        goto L14
    L7:
        r11 = null;
    L17:
        Map<String, MutableLiveData<AbsAddBizEntityMethodIDL.AddBizEntityMethodParamModel>> r14 = AddBizEntityMethod.Companion.getDonateCallback();
        TypeIntrinsics.asMutableMap(r14).remove(this.messageId);
    }

    @Override // com.bytedance.ai.ex.widget.OnHideSensitiveChangedListener
    public void onHideSensitiveChanged(boolean r5) {
        d2 r10 = this.isHideSensitiveFlow;
        Boolean r11 = Boolean.valueOf(r5);
        q2 r12 = (q2) r10;
        r12.getClass();
        r12.j(null, r11);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        return !isEnabled();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        Trace.beginSection("WidgetView.onLayout");
        super.onLayout(r5, r10, r11, r12, r13);
        Trace.endSection();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        Trace.beginSection("WidgetView.onMeasure");
        super.onMeasure(r5, r10);
        Trace.endSection();
    }

    @Override // com.bytedance.ai.ex.widget.MessageReceiver
    public boolean onMessageToAIBridge(String r5, JsonObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        if (WidgetRenderService.INSTANCE.getWidgetManager(this.host) != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r5, "obric.onWidgetDataChange") == false) goto L11;
        ((q2) this.dataFlow).i(r10);
        return true;
    L11:
        return onMessageToAIBridgeInternal(r5, r10);
    }

    @Override // com.bytedance.ai.ex.widget.OnThemeChangedListener
    public void onThemeChanged(int r5) {
        if (this.destroyRequested == false) goto L5;
        return;
    L5:
        d2 r10 = this.themeFlow;
        Integer r11 = Integer.valueOf(r5);
        q2 r12 = (q2) r10;
        r12.getClass();
        r12.j(null, r11);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r5) {
        super.onWindowFocusChanged(r5);
        if (Intrinsics.areEqual(this, this.host) == true) goto L5;
        return;
    L5:
        if (r5 == false) goto L8;
        WidgetRenderService.INSTANCE.onHostShow(this);
        return;
    L8:
        WidgetRenderService.INSTANCE.onHostHide(this);
    }

    @Override // com.bytedance.ai.ex.widget.BridgeContext
    public <T> void registerObject(Class<T> r5, T r10, RefType r11) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r11, "refType");
        Map<Object, Object> r12 = this.environmentConfig;
        if (r12 != null) goto L5;
        r12 = new LinkedHashMap();
    L5:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Any");
        r12.put(r5, r10);
        this.environmentConfig = r12;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Trace.beginSection("WidgetView.requestLayout");
        super.requestLayout();
        Trace.endSection();
    }

    @Override // com.bytedance.ai.ex.widget.EventCall
    public void sendCall(String r16, JsonObject r17, Consumer<JsonObject> r18, Consumer<AIBridgeMethod$Error> r19) {
        Intrinsics.checkNotNullParameter(r16, "name");
        WidgetRenderService r5 = WidgetRenderService.INSTANCE;
        if (r5.getWidgetManager(this.host) != null) goto L6;
        if (r19 == null) goto L6;
        r19.accept(new AIBridgeMethod$Error("WidgetView.sendCall, host is null", 0));
        Unit r10 = Unit.INSTANCE;
    L6:
        com.bytedance.ai.widget.contianer.f r11 = r5.findWidgetContainerByView(this.rootView);
        if (r11 == null) goto L16;
        LogProxy r12 = LogAdapter.INSTANCE.getImpl();
        if (r12 == null) goto L12;
        LogProxy.DefaultImpls.i$default(r12, TAG, "sendCall, " + getIdentity() + ", data: " + r17, null, 4, null);
    L12:
        m1.i r13 = ((WidgetContainer) r11).f3025l;
        Unit r14 = null;
        if (r13 == null) goto L15;
        Intrinsics.checkNotNullParameter(r16, "name");
        ProtocolMessage r15 = new ProtocolMessage(r16, r17, null, null, ProtocolMessage.Type.Call, 44);
        Intrinsics.checkNotNullParameter(r15, "protocolMessage");
        ((Handler) m1.i.f19971j.getValue()).post(new com.bytedance.ai.model.widgets.m(r18, r19, r13, r14, r15, 4));
        r14 = Unit.INSTANCE;
    L15:
        if (r14 == null) goto L16;
        return;
    L16:
        if (r19 == null) goto L20;
        r19.accept(new AIBridgeMethod$Error("WidgetView.sendCall, rootView is null", 0));
        Unit r20 = Unit.INSTANCE;
        return;
    }

    public final void setEnvironmentConfig(Map<Object, Object> r5) {
        this.environmentConfig = r5;
    }

    public final void setViewContext(Map<String, String> r5) {
        this.viewContext = r5;
    }

    @Override // com.bytedance.ai.ex.widget.BridgeContext
    public <T> void unregisterObject(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Map<Object, Object> r10 = this.environmentConfig;
        if (r10 == null) goto L6;
        r10.remove(r5);
        return;
    }

    public final boolean updateWidgetData(WidgetInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetInfo");
        return WidgetRenderService.INSTANCE.updateWidgetData(r10, this.host, this.messageId, this.rootView, this.viewContext);
    }
}
