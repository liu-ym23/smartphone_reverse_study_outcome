package com.bytedance.ai.widget.contianer;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.api.model.view.WidgetEvent;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.widgets.f1;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.LifecycleRegistryExtKt;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.widget.UIContextStrategy;
import com.bytedance.keva.Keva;
import com.google.gson.JsonObject;
import d3.b0;
import d3.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import m5.i1;
import m5.y0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 Ü\u00012\u00020\u00012\u00020\u0002:\u0006Ü\u0001Ý\u0001Þ\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020<H\u0002J\u0012\u0010p\u001a\u00020^2\b\u0010k\u001a\u0004\u0018\u00010mH\u0016J\u0010\u0010v\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010j\u001a\u00020\u001eH\u0016J\u0010\u0010y\u001a\u00020^2\u0006\u0010z\u001a\u00020\u001eH\u0016J\b\u0010{\u001a\u00020\u0006H\u0016J\n\u0010|\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010}\u001a\u00020^2\u0006\u0010~\u001a\u00020\u00062\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u007f\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0081\u0001\u001a\u00020^2\u0015\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020^\u0018\u00010hH\u0016J\u0017\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020^\u0018\u00010hH\u0016J\u0012\u0010\u0084\u0001\u001a\u00020^2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0006J\u0007\u0010\u0086\u0001\u001a\u00020^J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\rJ\u000b\u0010\u008a\u0001\u001a\u0004\u0018\u00010xH\u0016J\u000b\u0010\u008b\u0001\u001a\u0004\u0018\u00010xH\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\t\u0010\u008e\u0001\u001a\u00020^H\u0016J\t\u0010\u008f\u0001\u001a\u00020^H\u0002J+\u0010\u0090\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u00020\u00062\u0017\b\u0002\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0004J+\u0010\u0093\u0001\u001a\u00020^2\u0007\u0010\u0094\u0001\u001a\u00020\u00062\u0017\b\u0002\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010\u0096\u0001\u001a\u00020^2\u0007\u0010\u0097\u0001\u001a\u00020\u0006H\u0016J\u001e\u0010\u0098\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u00020\u00062\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\u001c\u0010\u009b\u0001\u001a\u00020^2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010_\u001a\u00030\u009d\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\u00020^2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0004J\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010¢\u0001\u001a\u00020&H\u0082@¢\u0006\u0003\u0010£\u0001J\t\u0010¤\u0001\u001a\u00020^H\u0002J\u0019\u0010¥\u0001\u001a\u00020^2\u0007\u0010¢\u0001\u001a\u00020&H\u0096@¢\u0006\u0003\u0010£\u0001J\u0014\u0010¦\u0001\u001a\u00020^2\t\u0010§\u0001\u001a\u0004\u0018\u000101H\u0016J\u0013\u0010¨\u0001\u001a\u00020\u001e2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\u000b\u0010«\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\u0011\u0010¬\u0001\u001a\u00020^2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020^2\u0007\u0010¢\u0001\u001a\u00020&H\u0002J\t\u0010®\u0001\u001a\u00020^H\u0016J\t\u0010¯\u0001\u001a\u00020^H\u0016J\t\u0010°\u0001\u001a\u00020^H\u0016J\u0012\u0010±\u0001\u001a\u00020^2\u0007\u0010²\u0001\u001a\u00020\u001eH\u0016J\t\u0010³\u0001\u001a\u00020^H\u0016J\t\u0010´\u0001\u001a\u00020^H\u0016J\t\u0010µ\u0001\u001a\u00020^H\u0016J\u0012\u0010¶\u0001\u001a\u00020^2\u0007\u0010¢\u0001\u001a\u00020&H\u0016J\u0014\u0010·\u0001\u001a\u00020^2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010¹\u0001\u001a\u00020^2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010º\u0001\u001a\u00020^2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010¼\u0001\u001a\u00020\u001eH\u0016J\b\u0010A\u001a\u0004\u0018\u00010BJ\u0012\u0010½\u0001\u001a\u00020^2\u0007\u0010¾\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010¿\u0001\u001a\u00020^2\u0007\u0010À\u0001\u001a\u00020!H\u0016J\u0012\u0010Á\u0001\u001a\u00020^2\u0007\u0010À\u0001\u001a\u00020!H\u0016J\t\u0010Â\u0001\u001a\u00020^H\u0016J\t\u0010Ã\u0001\u001a\u00020^H\u0016J\u0010\u0010Ä\u0001\u001a\u00020^2\u0007\u0010Å\u0001\u001a\u00020BJ\t\u0010Æ\u0001\u001a\u00020\u001eH\u0016J\t\u0010Ç\u0001\u001a\u00020^H\u0016J\u001d\u0010È\u0001\u001a\u0004\u0018\u00010\u001c2\u0007\u0010É\u0001\u001a\u00020\u001e2\u0007\u0010Ê\u0001\u001a\u00020\u0006H\u0016J\u000b\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\f\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0016J\t\u0010Î\u0001\u001a\u00020^H\u0002J\u0012\u0010Ï\u0001\u001a\u00020^2\u0007\u0010Ð\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010Ñ\u0001\u001a\u00020^2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030Ó\u0001H\u0016J\"\u0010Õ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030×\u00010Ö\u00012\t\u0010Ø\u0001\u001a\u0004\u0018\u00010&H\u0007J\u0013\u0010Ù\u0001\u001a\u00020^2\b\u0010\u009f\u0001\u001a\u00030Ú\u0001H\u0007J\t\u0010Û\u0001\u001a\u00020\u001eH\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0019\u00106\u001a\n 8*\u0004\u0018\u00010707¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020>X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR\u000e\u0010\\\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\nR\u001c\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020^\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010k\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010lX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020s8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010u¨\u0006ß\u0001"}, d2 = {"Lcom/bytedance/ai/widget/contianer/WidgetContainer;", "Lcom/bytedance/ai/widget/contianer/IWidgetContainer;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "traceId", "", "(Ljava/lang/String;)V", "conversationId", "getConversationId", "()Ljava/lang/String;", "setConversationId", "webView", "Landroid/webkit/WebView;", "containerJSBridge", "Lcom/bytedance/ai/widget/contianer/ContainerJSBridge;", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "get_lifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "set_lifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "aiViewModelMap", "", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "isOverScrolled", "", "lifeCycleObserverList", "", "Lcom/bytedance/ai/api/model/view/IWidgetLifeObserver;", "getLifeCycleObserverList", "()Ljava/util/List;", "containerId", "currentData", "Lcom/bytedance/ai/widget/contianer/WidgetContainerData;", "getCurrentData", "()Lcom/bytedance/ai/widget/contianer/WidgetContainerData;", "setCurrentData", "(Lcom/bytedance/ai/widget/contianer/WidgetContainerData;)V", "widget", "Lcom/bytedance/ai/model/objects/Widget;", "appSettings", "", "", "widgetConfig", "Lcom/bytedance/ai/model/objects/WidgetConfig;", "getWidgetConfig", "()Lcom/bytedance/ai/model/objects/WidgetConfig;", "setWidgetConfig", "(Lcom/bytedance/ai/model/objects/WidgetConfig;)V", "widgetHeightRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getWidgetHeightRepo", "()Lcom/bytedance/keva/Keva;", "widgetSavedHeight", "", "widgetHeightDebouncer", "Lcom/bytedance/ai/utils/CoroutineDebouncer;", "getWidgetHeightDebouncer", "()Lcom/bytedance/ai/utils/CoroutineDebouncer;", "currentLifeCycle", "Lcom/bytedance/ai/widget/contianer/WidgetContainer$LifecycleEvent;", "pendingOnShow", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "getAiBridge", "()Lcom/bytedance/ai/bridge/AIBridge;", "setAiBridge", "(Lcom/bytedance/ai/bridge/AIBridge;)V", "webViewPort", "Lcom/bytedance/ai/applet/render/core/web/WebViewAIBridgePort;", "longPressController", "Lcom/bytedance/ai/utils/IWidgetLongPressController;", "getLongPressController", "()Lcom/bytedance/ai/utils/IWidgetLongPressController;", "setLongPressController", "(Lcom/bytedance/ai/utils/IWidgetLongPressController;)V", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "finishHandler", "Lcom/bytedance/ai/widget/contianer/WidgetContainer$FinishHandler;", "getFinishHandler", "()Lcom/bytedance/ai/widget/contianer/WidgetContainer$FinishHandler;", "finishHandler$delegate", "Lkotlin/Lazy;", "monitorEventLifecycleObserver", "updateLayoutHeight", "", "height", "uiContextStrategy", "Lcom/bytedance/ai/widget/UIContextStrategy;", "getUiContextStrategy", "()Lcom/bytedance/ai/widget/UIContextStrategy;", "additionalContext", "defaultBotId", "getDefaultBotId", "additionalContextCallback", "Lkotlin/Function1;", "visible", "isForeground", "prefetcher", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ai/widget/WidgetPrefetcher;", "getPrefetcher", "()Ljava/lang/ref/WeakReference;", "setPrefetcher", "(Ljava/lang/ref/WeakReference;)V", "renderType", "Lcom/bytedance/ai/widget/WidgetRenderType;", "getRenderType", "()Lcom/bytedance/ai/widget/WidgetRenderType;", "containsView", "view", "Landroid/view/View;", "setForeground", "foreground", "getPageID", "getBotId", "setAdditionalContext", "ctx", "botId", "getAdditionalContext", "setAdditionalContextCallback", "callback", "getAdditionalContextCallback", "sendUIContext", "uiContext", "scrollToHostBottom", "getMessageId", "getContainerId", "getWebView", "realView", "engineView", "getActivity", "Landroid/app/Activity;", "onCreated", "setupAIBridge", "reportWidgetEvent", "eventName", "extraParams", "reportErrorEvent", MessageIndication.MESSAGE_TYPE_MSG, "viewContext", "onMessageToJS", com.bytedance.android.ec.core.event.a.KEY_MSG, "onMessageToAIBridge", "params", "Lcom/google/gson/JsonObject;", "handleContentSizeChange", "width", "", "sendWidgetEvent", "event", "Lcom/bytedance/ai/api/model/view/WidgetEvent;", "getWidget", "widgetContainerData", "(Lcom/bytedance/ai/widget/contianer/WidgetContainerData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseWidget", "bindData", "updateStyle", "config", "isSameContext", "context", "Landroid/content/Context;", "getRenderView", "bindWebView", "injectWebViewData", "onDestroy", "onShow", "onHide", "onFocusChange", "hasFocus", "onHostShow", "onHostHide", "onHostDestroy", "updateData", "onViewStart", com.bytedance.android.ec.core.event.a.KEY_URL, "onViewFinish", "onViewError", "errorMsg", "hasError", "dispatchLifecycleEventToWeb", "lifecycleEventName", "addLifeCycleObserver", "widgetLifeObserver", "removeLifeCycleObserver", "resetLifeCycleObserver", "clearLongClickCallback", "dispatchLifecycleEvent", "lifecycleEvent", "checkViewVisible", "resendLifecycleEvent", "getViewModel", "isShared", "groupId", "getAppletId", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", "clearAiViewModel", "sendUIAction", "action", "handleWebViewDrawEnd", "navigationStart", "", "drawEnd", "getThreadStrategy", "Lkotlin/Pair;", "Lcom/lynx/tasm/ThreadStrategyForRendering;", "data", "testLifecycle", "Landroidx/lifecycle/Lifecycle$Event;", "isShow", "Companion", "FinishHandler", "LifecycleEvent", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WidgetContainer extends h implements LifecycleOwner {
    public static final /* synthetic */ int x = 0;
    public String b;
    public final LifecycleRegistry c;
    public final Map<String, a6.a> d;
    public final List<u> e;
    public final String f;
    public m g;
    public Widget h;
    public Map<String, ? extends Object> i;
    public h5.j j;
    public final Keva k;
    public final com.bytedance.ai.utils.d l;
    public LifecycleEvent m;
    public boolean n;
    public w o;
    public com.bytedance.ai.utils.i p;
    public final Lazy q;
    public final d r;
    public final Map<String, String> s;
    public final String t;
    public Function1<? super h, Unit> u;
    public boolean v;
    public boolean w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/widget/contianer/WidgetContainer$LifecycleEvent;", "", "<init>", "(Ljava/lang/String;I)V", "ON_START", "ON_LOAD_START", "ON_LOAD_ERROR", "ON_LOAD_FINISHED", "ON_DESTROY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleEvent extends Enum<LifecycleEvent> {
        public static final LifecycleEvent ON_DESTROY = null;
        public static final LifecycleEvent ON_LOAD_ERROR = null;
        public static final LifecycleEvent ON_LOAD_FINISHED = null;
        public static final LifecycleEvent ON_LOAD_START = null;
        public static final LifecycleEvent ON_START = null;
        public static final /* synthetic */ LifecycleEvent[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LifecycleEvent> getEntries() {
            return b;
        }

        static {
            LifecycleEvent r0 = new LifecycleEvent("ON_START", 0);
            ON_START = r0;
            LifecycleEvent r1 = new LifecycleEvent("ON_LOAD_START", 1);
            ON_LOAD_START = r1;
            LifecycleEvent r10 = new LifecycleEvent("ON_LOAD_ERROR", 2);
            ON_LOAD_ERROR = r10;
            LifecycleEvent r11 = new LifecycleEvent("ON_LOAD_FINISHED", 3);
            ON_LOAD_FINISHED = r11;
            LifecycleEvent r12 = new LifecycleEvent("ON_DESTROY", 4);
            ON_DESTROY = r12;
            LifecycleEvent[] r13 = {r0, r1, r10, r11, r12};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static LifecycleEvent[] values() {
            return (LifecycleEvent[]) a.clone();
        }

        public static LifecycleEvent valueOf(String r1) {
            return (LifecycleEvent) r27.a.a(LifecycleEvent.class, r1);
        }

        public LifecycleEvent(String r1, int r10) {
            super(r1, r10);
        }
    }

    public static final class a {
    }

    public static final class b extends Handler {
        public final WeakReference<WidgetContainer> a;

        public static final class a {
        }

        static {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r10) {
            Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
            if (r10.what != 3) goto L20;
            WidgetContainer r11 = this.a.get();
            m r0 = null;
            if (r11 == null) goto L7;
            LifecycleEvent r12 = r11.m;
        L9:
            if (r12 != LifecycleEvent.ON_START) goto L22;
            com.bytedance.ai.utils.g.a.d("WidgetContainer", "request time out " + this.a.get());
            WidgetContainer r13 = this.a.get();
            if (r13 == null) goto L23;
            StringBuilder r1 = new StringBuilder("request time out widget=");
            WidgetContainer r14 = this.a.get();
            if (r14 == null) goto L15;
            Widget r15 = r14.h;
        L16:
            r1.append(r15);
            r1.append(" data=");
            WidgetContainer r16 = this.a.get();
            if (r16 == null) goto L19;
            r0 = r16.g;
        L19:
            r1.append(r0);
            r13.onViewError(r1.toString());
            return;
        L15:
            r15 = null;
            goto L16
        L23:
            return;
        L22:
            return;
        L7:
            r12 = null;
            goto L9
        L20:
            super.handleMessage(r10);
        }

        public b(Looper r10, WidgetContainer r11) {
            Intrinsics.checkNotNullParameter(r10, "looper");
            Intrinsics.checkNotNullParameter(r11, "widgetContainer");
            super(r10);
            this.a = new WeakReference(r11);
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LifecycleEvent.values().length];
            r0[LifecycleEvent.ON_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[LifecycleEvent.ON_LOAD_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[LifecycleEvent.ON_LOAD_FINISHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[LifecycleEvent.ON_LOAD_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[LifecycleEvent.ON_DESTROY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public static final class d implements u {
        public long a;
        public final /* synthetic */ WidgetContainer b;

        @Override // k2.u
        public final void onDestroy() {
        }

        @Override // k2.u
        public void onEvent(WidgetEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
        }

        @Override // k2.u
        public final void onStart() {
        }

        @Override // k2.u
        public final void b() {
            LinkedHashMap r0 = new LinkedHashMap();
            if (this.a <= 0) goto L5;
            r0.put("costTime", Long.valueOf(System.currentTimeMillis() - this.a));
        L5:
            this.b.getClass();
            Boolean r1 = Boolean.FALSE;
            r0.put("isPreload", r1);
            r0.put("isSuccessful", r1);
            WidgetContainer r10 = this.b;
            r10.getClass();
            Intrinsics.checkNotNullParameter("applet_view_load_finish", "eventName");
            com.bytedance.ai.monitor.b.d("applet_view_load_finish", new l(r10, r0));
        }

        @Override // k2.u
        public final void c() {
            LinkedHashMap r0 = new LinkedHashMap();
            if (this.a <= 0) goto L5;
            r0.put("costTime", Long.valueOf(System.currentTimeMillis() - this.a));
        L5:
            this.b.getClass();
            r0.put("isPreload", Boolean.FALSE);
            r0.put("isSuccessful", Boolean.TRUE);
            WidgetContainer r1 = this.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter("applet_view_load_finish", "eventName");
            com.bytedance.ai.monitor.b.d("applet_view_load_finish", new l(r1, r0));
        }

        @Override // k2.u
        public final void a() {
            this.a = System.currentTimeMillis();
            WidgetContainer r0 = this.b;
            int r1 = WidgetContainer.x;
            r0.getClass();
            Intrinsics.checkNotNullParameter("applet_view_start", "eventName");
            com.bytedance.ai.monitor.b.d("applet_view_start", new l(r0, null));
        }

        public d(WidgetContainer r1) {
            this.b = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$1", f = "WidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ WidgetContainer this$0;

        public AnonymousClass1(WidgetContainer r1, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r11);
            r0.I$0 = ((Number) r10).intValue();
            return r0;
        }

        public final Object invoke(int r1, Continuation<? super Unit> r10) {
            return create(Integer.valueOf(r1), r10).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke(((Number) r1).intValue(), (Continuation) r10);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L40;
            ResultKt.throwOnFailure(r10);
            int r11 = this.I$0;
            com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
            StringBuilder r1 = new StringBuilder("handleContentSizeChange: ");
            m r12 = this.this$0.g;
            String r13 = null;
            if (r12 == null) goto L7;
            String r14 = r12.a();
        L8:
            r1.append(r14);
            r1.append(" widget change height to ");
            r1.append(r11);
            r0.d("WidgetContainer", r1.toString());
            WidgetContainer r15 = this.this$0;
            LifecycleEvent r16 = r15.m;
            LifecycleEvent r17 = LifecycleEvent.ON_LOAD_FINISHED;
            if (r16 == r17) goto L11;
            r15.r(r17);
        L12:
            WidgetContainer r18 = this.this$0;
            View r19 = r18.realView();
            if (r19 == null) goto L15;
            ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        L16:
            if (r20 == null) goto L18;
            r20.height = r11;
        L18:
            View r21 = r18.realView();
            if (r21 == null) goto L21;
            r21.setLayoutParams(r20);
        L21:
            View r22 = r18.realView();
            if (r22 == null) goto L27;
            ViewParent r23 = r22.getParent();
            if (r23 == null) goto L27;
            r23.requestLayout();
        L27:
            if (r18.w == false) goto L38;
            if (r11 <= 0) goto L38;
            Keva r24 = r18.k;
            m r25 = r18.g;
            if (r25 == null) goto L32;
            String r26 = r25.a();
        L33:
            r24.storeInt(r26, r11);
            StringBuilder r27 = new StringBuilder();
            m r28 = r18.g;
            if (r28 == null) goto L36;
            r13 = r28.a();
        L36:
            r27.append(r13);
            r27.append(" storeInt ");
            r27.append(r11);
            r0.d("WidgetContainer", r27.toString());
            goto L38
        L32:
            r26 = null;
        L38:
            return Unit.INSTANCE;
        L15:
            r20 = null;
            goto L16
        L11:
            r15.u(WidgetEvent.PAGE_UPDATE);
            goto L12
        L7:
            r14 = null;
            goto L8
        L40:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$2", f = "WidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WidgetContainer this$0;

        public AnonymousClass2(WidgetContainer r1, Continuation<? super AnonymousClass2> r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            this.this$0.u(WidgetEvent.PAGE_UPDATE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public View engineView() {
        return null;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public void o(m r10) {
        Intrinsics.checkNotNullParameter(r10, "widgetContainerData");
    }

    @Override // k2.i
    public final void onHide() {
        this.n = false;
        if (this.w == true) goto L5;
        return;
    L5:
        if (this.v == false) goto L10;
        s("onHide");
        this.v = false;
        return;
    }

    @Override // k2.i
    public final void onHostHide() {
        this.w = false;
        s("onBackground");
    }

    @Override // k2.i
    public final void onHostShow() {
        this.w = true;
        s("onForeground");
    }

    @Override // k2.r
    public final void onMessageToJS(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final boolean f() {
        Rect r0 = new Rect();
        View r1 = realView();
        if (r1 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == false) goto L17;
        View r11 = realView();
        if (r11 != null) goto L12;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L17;
        return true;
    L12:
        if (r11.getGlobalVisibleRect(r0) != true) goto L14;
        r12 = true;
    L17:
        return false;
    L5:
        if (r1.isAttachedToWindow() != true) goto L7;
        r10 = true;
        goto L8
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public Activity getActivity() {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r0 = AppletRuntimeManager.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.currentActivity();
    }

    @Override // k2.i
    public final String getAppletId() {
        m r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // k2.i
    public final String getBotId() {
        m r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final String l() {
        m r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final void m() {
        ((ArrayList) this.e).clear();
        d r0 = this.r;
        Intrinsics.checkNotNullParameter(r0, "widgetLifeObserver");
        ((ArrayList) this.e).add(r0);
    }

    @Override // k2.i
    public final void onDestroy() {
        r(LifecycleEvent.ON_DESTROY);
        s("onDestroy");
        Iterator r0 = ((LinkedHashMap) this.d).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a6.a) r0.next()).getIStorage().cleanup();
        goto L4
    L6:
        ((ConcurrentHashMap) this.s).clear();
    }

    @Override // k2.i
    public void onHostDestroy() {
        ((b) this.q.getValue()).postDelayed(new i(this), 2000);
        CoroutineScopeKt.cancel$default(this.l.b, null, 1, null);
        com.bytedance.ai.utils.g.a.i("CoroutineDebouncer", "Debouncer cancel");
        Widget r0 = this.h;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        this.h = null;
        this.u = null;
        ((ArrayList) this.e).clear();
    }

    @Override // k2.i
    public final void onShow() {
        if (this.w == true) goto L5;
        return;
    L5:
        if (this.v == false) goto L8;
        return;
    L8:
        if (this.m == LifecycleEvent.ON_LOAD_FINISHED) goto L11;
        this.n = true;
        return;
    L11:
        s("onShow");
        this.v = true;
        LifecycleRegistryExtKt.a(this.c, Lifecycle.Event.ON_START);
    }

    public WidgetContainer() {
        this.c = new LifecycleRegistry(this);
        this.d = new LinkedHashMap();
        this.e = new ArrayList();
        this.f = UUID.randomUUID().toString();
        this.k = Keva.getRepo("WIDGET_HEIGHT");
        this.l = new com.bytedance.ai.utils.d();
        this.q = LazyKt.lazy(new k(this));
        this.r = new d(this);
        UIContextStrategy r0 = UIContextStrategy.DEFAULT;
        this.s = new ConcurrentHashMap();
        this.t = "default_context_widget_bot_id";
        this.w = true;
    }

    public View realView() {
        if (getActivity() == null) goto L9;
        com.bytedance.ai.utils.g.a.e("WidgetContainer", "Fail to create render view.");
        r(LifecycleEvent.ON_LOAD_ERROR);
        t(this, "Fail to create render view.");
        m r0 = this.g;
        if (r0 == null) goto L10;
        i1 r1 = y0.a;
        y0.b(r0.e, "Fail to create render view.", AppletErrorCode.WEB_VIEW_CREATE_ERROR.getType(), "applet_widget_timeline_full");
        return null;
    L10:
        return null;
    L9:
        return null;
    }

    @Override // k2.h
    public final b0 getAIBridge() {
        return this.o;
    }

    public final Lifecycle getLifecycle() {
        return this.c;
    }

    @Override // k2.i
    public final String getPageID() {
        return this.f;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final String j() {
        return this.f;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final m k() {
        return this.g;
    }

    public Widget x() {
        return this.h;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final boolean g(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (super.g(r10) == true) goto L12;
        View r0 = engineView();
        if ((r0 instanceof WebView) == false) goto L7;
        WebView r1 = (WebView) r0;
    L9:
        if (Intrinsics.areEqual(r1, r10) == true) goto L12;
        return false;
    L7:
        r1 = null;
    L12:
        return true;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final String h(String r10) {
        Map<String, String> r0 = this.s;
        if (r10 != null) goto L11;
        m r11 = this.g;
        if (r11 == null) goto L7;
        r10 = r11.d;
    L8:
        if (r10 != null) goto L11;
        r10 = this.t;
        goto L11
    L7:
        r10 = null;
    L11:
        return (String) ((ConcurrentHashMap) r0).get(r10);
    }

    @Override // k2.i
    public final void onViewError(String r10) {
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        String r11 = "Fail to load widget: ".concat(r10);
        com.bytedance.ai.utils.g.a.e("WidgetContainer", r11);
        r(LifecycleEvent.ON_LOAD_ERROR);
        t(this, r11);
    }

    public final void r(LifecycleEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleEvent");
        com.bytedance.ai.utils.g.a.d("WidgetContainer", this + " dispatchLifecycleEvent " + r10);
        this.m = r10;
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L28;
        u r1 = (u) r0.next();
        int r11 = c.a[r10.ordinal()];
        if (r11 != 1) goto L8;
        r1.onStart();
        goto L4
    L8:
        if (r11 != 2) goto L10;
        r1.a();
        goto L4
    L10:
        if (r11 != 3) goto L12;
        r1.c();
        new Rect();
        if (this.n == true) goto L25;
        if (this.w == false) goto L4;
        if (f() == false) goto L4;
    L25:
        onShow();
        goto L4
    L12:
        if (r11 != 4) goto L14;
        r1.b();
        goto L4
    L14:
        if (r11 != 5) goto L17;
        r1.onDestroy();
        goto L4
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final void s(String r10) {
        com.bytedance.ai.utils.g.a.d("WidgetContainer", "dispatchLifecycleEventToWeb " + this + " lifecycle ==> " + r10);
        w r0 = this.o;
        if (r0 == null) goto L50;
        JsonObject r1 = new JsonObject();
        Pair[] r11 = new Pair[10];
        r11[0] = TuplesKt.to("viewId", this.f);
        m r12 = this.g;
        String r13 = "";
        if (r12 == null) goto L8;
        String r14 = r12.b;
        if (r14 == null) goto L8;
    L9:
        r11[1] = TuplesKt.to("pageName", r14);
        m r15 = this.g;
        if (r15 == null) goto L13;
        String r16 = r15.d;
        if (r16 == null) goto L13;
    L14:
        r11[2] = TuplesKt.to("botId", r16);
        m r17 = this.g;
        if (r17 == null) goto L18;
        String r18 = r17.e;
        if (r18 == null) goto L18;
    L19:
        r11[3] = TuplesKt.to("msgId", r18);
        m r19 = this.g;
        if (r19 == null) goto L23;
        String r20 = r19.j;
        if (r20 == null) goto L23;
    L24:
        r11[4] = TuplesKt.to("mixtureCardId", r20);
        m r21 = this.g;
        if (r21 == null) goto L30;
        String r22 = r21.g;
        if (r22 == null) goto L30;
        r13 = r22;
    L30:
        r11[5] = TuplesKt.to("replyFor", r13);
        r11[6] = TuplesKt.to("conversationId", this.b);
        m r23 = this.g;
        Map<String, Object> r24 = null;
        if (r23 == null) goto L35;
        Map<String, Object> r25 = r23.i;
        if (r25 == null) goto L35;
        Object r26 = r25.get("createTime");
    L36:
        r11[7] = TuplesKt.to("msgCreateTime", r26);
        r11[8] = TuplesKt.to("appSettings", this.i);
        m r27 = this.g;
        if (r27 == null) goto L39;
        r24 = r27.i;
    L39:
        r11[9] = TuplesKt.to("extra", r24);
        Map r28 = MapsKt.mutableMapOf(r11);
        m r29 = this.g;
        if (r29 == null) goto L47;
        Map<String, String> r30 = r29.h;
        if (r30 == null) goto L47;
        Iterator<Map.Entry<String, String>> r31 = r30.entrySet().iterator();
    L45:
        if (r31.hasNext() == false) goto L47;
        Map.Entry<String, String> r32 = r31.next();
        r28.put(r32.getKey(), r32.getValue());
    L47:
        r1.addProperty("eventName", new JSONObject(MapsKt.toMap(r28)).toString());
        Unit r33 = Unit.INSTANCE;
        r0.a(r10, r1);
        return;
    L35:
        r26 = null;
    L23:
        r20 = "";
    L18:
        r18 = "";
    L13:
        r16 = "";
    L8:
        r14 = "";
        goto L9
    }

    public final void u(WidgetEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((u) r0.next()).onEvent(r10);
        goto L4
    }

    public void w(h5.j r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.j = r10;
        if (this.h == null) goto L35;
        View r11 = realView();
        ViewGroup r0 = null;
        if (r11 == null) goto L9;
        ViewParent r12 = r11.getParent();
    L11:
        if ((r12 instanceof ViewGroup) == false) goto L13;
        r0 = (ViewGroup) r12;
    L13:
        if (r0 != null) goto L15;
        return;
    L15:
        Widget r13 = this.h;
        int r1 = 1;
        int r14 = 0;
        if (r13 != null) goto L18;
    L20:
        boolean r15 = false;
    L21:
        if (r15 == true) goto L23;
        return;
    L23:
        if (Build.VERSION.SDK_INT < 23) goto L37;
        GradientDrawable r16 = new GradientDrawable();
        r16.setShape(0);
        h5.j r17 = this.j;
        if (r17 == null) goto L27;
        r1 = r17.b;
    L27:
        if (r17 == null) goto L29;
        r14 = r17.c;
    L29:
        r16.setStroke(r1, r14);
        h5.j r18 = this.j;
        if (r18 == null) goto L32;
        float r19 = r18.d;
    L33:
        r16.setCornerRadius(r19);
        r0.setForeground(r16);
        return;
    L32:
        r19 = 0.0f;
        goto L33
    L37:
        return;
    L18:
        if (r13.O != true) goto L20;
        r15 = true;
        goto L21
    L9:
        r12 = null;
        goto L11
    }

    public static void t(final WidgetContainer r10, String r11) {
        r10.getClass();
        com.bytedance.ai.utils.g.a.i("WidgetContainer", "reportErrorEvent: " + r11);
        AtomicBoolean r0 = com.bytedance.ai.monitor.b.a;
        final Map r12 = null;
        com.bytedance.ai.monitor.b.a(AppletErrorCode.WIDGET_LOAD_ERROR, r11, null, new j(r10, r12));
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "groupId");
        if (r10 == false) goto L8;
        com.bytedance.ai.utils.g.a.d("WidgetContainer", "getViewModel state " + getLifecycle().getCurrentState());
        if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L12;
        return null;
    L12:
        return SharedViewModelExtKt.b(this, r11);
    L8:
        a6.a r12 = (a6.a) ((LinkedHashMap) this.d).get(r11);
        if (r12 != null) goto L14;
        f1.b r13 = new f1.b(r11);
        this.d.put(r11, r13);
        return r13;
    L14:
        return r12;
    }

    public final void handleContentSizeChange(double r10, double r11) {
        int r12 = o.a((float) r11);
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        StringBuilder r14 = new StringBuilder("handleContentSizeChange: ");
        m r0 = this.g;
        if (r0 == null) goto L5;
        String r1 = r0.a();
    L6:
        r14.append(r1);
        r14.append(" widgetSavedHeight = 0, webContentHeight = ");
        r14.append(r12);
        r13.d("WidgetContainer", r14.toString());
        if (r12 <= 0) goto L16;
        StringBuilder r15 = new StringBuilder("handleContentSizeChange: ");
        m r16 = this.g;
        if (r16 == null) goto L11;
        String r17 = r16.a();
    L12:
        r15.append(r17);
        r15.append(" immediate = false");
        r13.d("WidgetContainer", r15.toString());
        this.l.a(Integer.valueOf(r12), new AnonymousClass1(this, null));
        if (this.m != LifecycleEvent.ON_LOAD_FINISHED) goto L17;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.e), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L17:
        return;
    L11:
        r17 = null;
        goto L12
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // k2.o
    public final void handleWebViewDrawEnd(long r10, long r11) {
        com.bytedance.ai.utils.g.a.d("WidgetContainer", "navigationStart:" + r10 + " drawEnd:" + r11 + ", duration:" + (r11 - r10));
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r10, JsonObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        w r0 = this.o;
        if (r0 == null) goto L6;
        r0.a(r10, r11);
        return;
    }

    public final void v(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "ctx");
        Map<String, String> r0 = this.s;
        if (r11 != null) goto L10;
        m r12 = this.g;
        if (r12 == null) goto L7;
        r11 = r12.d;
    L8:
        if (r11 != null) goto L10;
        r11 = this.t;
        goto L10
    L7:
        r11 = null;
    L10:
        ((ConcurrentHashMap) r0).put(r11, r10);
        Function1<? super h, Unit> r13 = this.u;
        if (r13 == null) goto L14;
        r13.invoke(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ai.model.objects.AIPackage, com.bytedance.ai.model.objects.Widget] */
    public static final Object p(WidgetContainer r10, m r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof WidgetContainer$getWidget$1) == false) goto L7;
        WidgetContainer$getWidget$1 r0 = (WidgetContainer$getWidget$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r11 = (m) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L23:
        r14 = (Widget) r13;
        if (r14 != 0) goto L26;
        com.bytedance.ai.utils.g.a.e("WidgetContainer", "<createWidget> 404: can't find widget named '" + r11.b + '\'');
        r10.r(LifecycleEvent.ON_LOAD_ERROR);
        t(r10, "Not Found Widget");
    L26:
        if (r14 == 0) goto L28;
        r14.e();
    L28:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AIManager r16 = AIManager.a;
        String r17 = r11.a;
        String r18 = r11.b;
        m r19 = r10.g;
        if (r19 == null) goto L19;
        Map<String, Object> r20 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("message_id", r19.e), TuplesKt.to("botId", r19.d)});
        String r21 = r19.s;
        if (r21 == null) goto L20;
        r20.put("version_tag", r21);
    L20:
        r0.L$0 = r11;
        r0.label = 1;
        r13 = r16.E(r17, r18, r20, r0);
        if (r13 != r14) goto L23;
    L19:
        r20 = null;
    L7:
        r0 = new WidgetContainer$getWidget$1(r10, r12);
        goto L8
    }
}
