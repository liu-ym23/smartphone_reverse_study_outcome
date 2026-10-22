package com.bytedance.android.anniex.lite.container;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.base.builder.UIComponentBuilder;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.SLContainerTiming;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y36.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\t*\u0002Ë\u0001\b!\u0018\u0000 Ñ\u00012\u00020\u0001:\u0002Ò\u0001B\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J$\u0010.\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020\u001bH\u0002J,\u00103\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0002J\u0012\u00106\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000104H\u0002J\b\u00107\u001a\u00020\u000fH\u0002J\u0006\u00108\u001a\u000200J\b\u00109\u001a\u000200H\u0014J\b\u0010;\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<H\u0004J\b\u0010?\u001a\u00020\u000fH\u0014J\b\u0010@\u001a\u00020\u000fH\u0004J\b\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u001bH\u0004J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020+H\u0016J!\u0010H\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u001b2\b\u0010G\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\bH\u0010IJ\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016J\b\u0010M\u001a\u00020LH\u0016J\b\u0010N\u001a\u000200H\u0016J\n\u0010P\u001a\u0004\u0018\u00010OH\u0016J&\u0010R\u001a\u00020\u000f2\u0006\u0010Q\u001a\u0002002\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0016J:\u0010R\u001a\u00020\u000f2\u0006\u0010Q\u001a\u0002002\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u0001042\b\u0010T\u001a\u0004\u0018\u00010SH\u0016J\b\u0010V\u001a\u00020UH\u0016J\u0010\u0010W\u001a\u00020O2\u0006\u0010Q\u001a\u000200H\u0016J\n\u0010X\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010[\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020YH\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\b\u0010]\u001a\u00020\u000fH\u0016J\b\u0010^\u001a\u00020\u000fH\u0016J\u001e\u0010_\u001a\u00020\u000f2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0016J\b\u0010`\u001a\u00020\u001bH\u0016J\b\u0010a\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010d\u001a\u00020\u000fH\u0016J\u0010\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u000200H\u0016J+\u0010k\u001a\u00020\u000f\"\u0004\b\u0000\u0010g2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000h2\u0006\u0010j\u001a\u00028\u0000H\u0016¢\u0006\u0004\bk\u0010lJ\u001c\u0010n\u001a\u00020\u000f2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/H\u0016J\u001c\u0010p\u001a\u00020\u000f2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/H\u0016J\u0010\u0010p\u001a\u00020\u000f2\u0006\u0010o\u001a\u000200H\u0016J\n\u0010q\u001a\u0004\u0018\u000104H\u0016J\u0018\u0010s\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0014\u0010u\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020t0/H\u0016J\b\u0010v\u001a\u000200H\u0016J\u0010\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0wH\u0016J\b\u0010y\u001a\u00020\u001bH\u0016J\u0010\u0010{\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020\u001bH\u0016J\b\u0010|\u001a\u00020\u000fH\u0016J\u0012\u0010~\u001a\u00020\u000f2\b\u0010}\u001a\u0004\u0018\u000100H\u0016J\b\u0010\u007f\u001a\u00020\u000fH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u000fH\u0016J\u000b\u0010\u0081\u0001\u001a\u0004\u0018\u000100H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016J-\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0085\u0001\u001a\u00020\r2\u0007\u0010\u0086\u0001\u001a\u00020\r2\u0007\u0010\u0087\u0001\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R#\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0094\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u009a\u0001\u001a\u0002008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001f\u0010\u009c\u0001\u001a\u00020U8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001f\u0010\n\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b \u0001\u0010\u0096\u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R \u0010¦\u0001\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010\u0096\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0017\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b=\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0004@\u0004X\u0084.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u0019\u0010¯\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010²\u0001R\u0019\u0010´\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010²\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¸\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010²\u0001R\u001b\u0010¹\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010»\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010²\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010º\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010º\u0001R \u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020\r0¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R)\u0010Â\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010²\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010y\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\by\u0010²\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010²\u0001R\u001b\u0010È\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Ê\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010É\u0001R\u001a\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010°\u0001¨\u0006Ó\u0001"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Lia/b;", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "builder", "Lqa/a;", "createAnnieXContext", "Landroid/os/Bundle;", "bundle", "Landroid/net/Uri;", "getUriByBundle", "annieXContext", "Lna/a;", "createEngine", "", "state", "", "putState", "changeState", "transferToTargetState", "initContainerColor", "addScreenCaptureListener", "removeScreenCaptureListener", "softHeight", "possiblyResizeChildOfContent", "Landroid/view/View;", "decorView", "getContentView", "", "isShowing", "height", "sendKeyboardStatusChangeEvent", "needAdapterKeyboard", "possiblyResizeChildOfContent4Web", "needAdapterKeyboard4Web", "useSystemDialog", "addTagView", "Lg16/b;", "debugInfo", "showContainerTag", "setContainerColor", "setBackgroundColor", "updateLynxScreenMetrics", "view", "Landroid/content/res/Configuration;", "configuration", "isKitViewCreate", "padAdaptation", "", "", "", "renderData", "completeRenderData", "Lm16/b;", "contextProviderFactory", "mergeContext", "bindWebOnScrollChangeListener", "getUrl", "getPageOptType", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getScenes", "Lia/j;", "uiComponent", "setUiComponent", "addKitView", "initUi", "observerKeyboardStatusChange", "hasSoftInput", "onSoftInputChange", "newConfig", "onConfigurationChanged", "visible", "hasReadySendVisibleEvent", "onVisibleChange", "(ZLjava/lang/Boolean;)V", "getBid", "getContainerId", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "getCurrentUrl", "Lt36/d;", "getSchemaData", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "loadSchema", "Lcom/bytedance/android/anniex/base/lifecycle/a;", "lifecycle", "Landroid/content/Context;", "getSystemContext", "generateSchemaData", "getCurrentSchema", "Lcom/bytedance/ies/bullet/core/kit/bridge/h;", "event", "sendEvent", "canBackPress", "enterForeground", "enterBackground", "reload", "canGoBack", "goBack", "release", "getKitView", "removeKitView", com.bytedance.android.ec.core.event.a.KEY_URL, "recreateKitView", "T", "Ljava/lang/Class;", "clazz", "item", "registerWeakHolder", "(Ljava/lang/Class;Ljava/lang/Object;)V", "globalProps", "updateGlobalProps", "data", "updateData", "getContextProviderFactory", "width", "updateScreenMetrics", "", "getPerfMap", "getViewType", "Ljava/lang/ref/WeakReference;", "getWeakContext", "isVisibility", "enable", "interceptBackPress", "showError", "text", "showLoading", "hideLoading", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "getBDXTag", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXLaunchMode", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onWebScrollChanged", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "getBuilder", "()Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "Lb46/e;", "screenCaptureListener", "Lb46/e;", "Lcom/bytedance/android/anniex/container/b;", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/b;", "getLifecycleDispatcher", "()Lcom/bytedance/android/anniex/container/b;", "Lv36/a;", "containerModel$delegate", "Lkotlin/Lazy;", "getContainerModel", "()Lv36/a;", "containerModel", "currentBid", "Ljava/lang/String;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "annieXContext$delegate", "getAnnieXContext", "()Lqa/a;", "engine$delegate", "getEngine", "()Lna/a;", "engine", "Lia/j;", "Landroid/view/ViewGroup;", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "currentState", "I", "isResuming", "Z", "isRuntimeReady", "loadSuccess", "Landroid/graphics/drawable/Drawable;", "originBackground", "Landroid/graphics/drawable/Drawable;", "useCustomBackground", "errorView", "Landroid/view/View;", "errorViewAdded", "loadingView", "noticeView", "denyView", "Ljava/util/concurrent/ArrayBlockingQueue;", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "containerVisible", "getContainerVisible", "()Z", "setContainerVisible", "(Z)V", "isNotRelease", "padAdapterWidth", "Ljava/lang/Integer;", "padAdapterHeight", "com/bytedance/android/anniex/lite/container/AnnieXLiteContainer$b", "annieLifeCycle", "Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer$b;", "usableHeightPrevious", "<init>", "(Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;)V", "Companion", "a", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class AnnieXLiteContainer extends ia.b {
    public static final a Companion = null;
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_DESTROY = 6;
    private static final int LOAD_STATUS_FINISH = 4;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_LOADING = 3;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_RUNTIME_READY = 5;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private b annieLifeCycle;
    private final Lazy annieXContext$delegate;
    private final UIComponentBuilder builder;
    private final Lazy containerModel$delegate;
    private volatile boolean containerVisible;
    private final Context context;
    private final String currentBid;
    private int currentState;
    private View denyView;
    private final Lazy engine$delegate;
    private View errorView;
    private boolean errorViewAdded;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private final com.bytedance.android.anniex.container.b lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View noticeView;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private b46.e screenCaptureListener;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private ia.j uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends com.bytedance.android.anniex.base.lifecycle.a {
        public final /* synthetic */ AnnieXLiteContainer a;

        public b(AnnieXLiteContainer r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void d(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            this.a.getLifecycleDispatcher().d(r10, r11);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void e(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            HybridLogger r0 = HybridLogger.a;
            y36.i r12 = null;
            HybridLogger.m(AnnieXLiteContainer.TAG, "===onKitViewCreate:  " + r10, null, null, 12);
            AnnieXLiteContainer.access$putState(this.a, 1);
            AnnieXLiteContainer.access$putState(this.a, 2);
            View r13 = r11.getKitView();
            if (r13 == null) goto L25;
            AnnieXLiteContainer r1 = this.a;
            v36.a r14 = r1.getContainerModel();
            if (r14 == null) goto L14;
            y36.i r15 = r14.r;
            if (r15 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("webBgColor");
            r15 = null;
        L10:
            if (r15 == null) goto L14;
            Integer r16 = (Integer) r15.b;
            if (r16 == null) goto L14;
            r13.setBackgroundColor(r16.intValue());
        L14:
            v36.a r17 = r1.getContainerModel();
            if (r17 == null) goto L24;
            y36.i r18 = ((x36.a) r17).e;
            if (r18 == null) goto L19;
            r12 = r18;
        L20:
            if (r12 == null) goto L24;
            Integer r19 = (Integer) r12.b;
            if (r19 == null) goto L24;
            r13.setBackgroundColor(r19.intValue());
            goto L24
        L19:
            Intrinsics.throwUninitializedPropertyAccessException("contentBgColor");
        L24:
            ExecutorService r20 = com.bytedance.ies.bullet.service.monitor.a.a;
            com.bytedance.ies.bullet.service.monitor.a.b(r11.getContainerId(), r13, r11.getKitType().getTag());
        L25:
            this.a.onKitViewCreate();
            this.a.getLifecycleDispatcher().e(this.a.getUrl(), this.a);
            AnnieXLiteContainer.access$bindWebOnScrollChangeListener(this.a);
            AnnieXLiteContainer.access$addScreenCaptureListener(this.a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void f(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            HybridLogger r12 = HybridLogger.a;
            HybridLogger.m(AnnieXLiteContainer.TAG, "kit_view_destroy", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r10)), null, 8);
            AnnieXLiteContainer.access$putState(this.a, 6);
            this.a.getLifecycleDispatcher().f(this.a.getUrl(), this.a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void h(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            HybridLogger r0 = HybridLogger.a;
            HybridLogger.m(AnnieXLiteContainer.TAG, "===onLoadStart:  " + r10, null, null, 12);
            AnnieXLiteContainer.access$putState(this.a, 3);
            super.h(r10, r11);
            this.a.getLifecycleDispatcher().h(this.a.getUrl(), this.a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            AnnieXLiteContainer.access$setLoadSuccess$p(this.a, true);
            AnnieXLiteContainer.access$putState(this.a, 4);
            this.a.getLifecycleDispatcher().i(this.a.getUrl(), this.a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void k(String r10, ia.c r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            HybridLogger r12 = HybridLogger.a;
            HybridLogger.m(AnnieXLiteContainer.TAG, "===onRuntimeReady:  " + r10, null, null, 12);
            AnnieXLiteContainer.access$putState(this.a, 5);
            this.a.getLifecycleDispatcher().k(this.a.getUrl(), this.a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void g(String r10, ia.c r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
            Intrinsics.checkNotNullParameter(r11, "container");
            Intrinsics.checkNotNullParameter(r12, "throwable");
            AnnieXLiteContainer.access$setLoadSuccess$p(this.a, false);
            AnnieXLiteContainer.access$putState(this.a, 4);
            this.a.getLifecycleDispatcher().g(this.a.getUrl(), this.a, r12);
        }
    }

    public static final class c implements SSWebView.e {
        public final /* synthetic */ AnnieXLiteContainer a;

        public c(AnnieXLiteContainer r1) {
            this.a = r1;
        }

        public final void onScrollChanged(int r10, int r11, int r12, int r13) {
            this.a.onWebScrollChanged(r10, r11, r12, r13);
        }
    }

    public static final class d implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public final Object getParams() {
            JSONObject r0 = new JSONObject();
            if (this.b == false) goto L5;
            r0.put("type", "systemBack");
        L5:
            return r0;
        }

        public final String getName() {
            return this.a;
        }

        public d(String r1, boolean r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class e implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ AnnieXLiteContainer b;

        public final String getName() {
            return "pageVisibilityChange";
        }

        public final Object getParams() {
            JSONObject r0 = new JSONObject();
            boolean r1 = this.a;
            AnnieXLiteContainer r10 = this.b;
            r0.put("visible", r1);
            if (Intrinsics.areEqual(r10.getViewType(), "card") == true) goto L12;
            ia.j r11 = AnnieXLiteContainer.access$getUiComponent$p(r10);
            if (r11 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
            r11 = null;
        L8:
            if (r11.e() == false) goto L10;
            String r12 = AnnieXLiteContainer.VISIBLE_CHANGE_TYPE_APP;
        L11:
            r0.put("source", r12);
            goto L12
        L10:
            r12 = "page";
        L12:
            return r0;
        }

        public e(boolean r1, AnnieXLiteContainer r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ AnnieXLiteContainer a;
        public final /* synthetic */ int b;

        public f(AnnieXLiteContainer r1, int r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnieXLiteContainer.access$changeState(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final JSONObject a;

        public final String getName() {
            return "H5_keyboardStatusChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public g(JSONObject r1) {
            this.a = r1;
        }
    }

    public static final class h implements com.bytedance.ies.bullet.core.kit.bridge.h {
        public final JSONObject a;

        public final String getName() {
            return "keyboardStatusChange";
        }

        public final Object getParams() {
            return this.a;
        }

        public h(JSONObject r1) {
            this.a = r1;
        }
    }

    static {
        Companion = new a();
    }

    @Override // ia.b, ia.c
    public void enterBackground() {
        this.isVisibility = false;
        getEngine().enterBackground();
    }

    @Override // ia.b, ia.c
    public void enterForeground() {
        this.isVisibility = true;
        getEngine().enterForeground();
    }

    public String getPageOptType() {
        return "lite_page";
    }

    @Override // ia.b, ia.c
    public String getViewType() {
        return "card";
    }

    @Override // ia.b, ia.c
    public void goBack() {
        HybridLogger.m(TAG, "goBack", null, null, 12);
        if (getEngine().canGoBack() == false) goto L5;
        getEngine().goBack();
        return;
    L5:
        close();
    }

    public void onWebScrollChanged(int r1, int r10, int r11, int r12) {
    }

    private final void addTagView() {
        HybridLogger r0 = HybridLogger.a;
        DebugTagTextView r10 = null;
        HybridLogger.m(TAG, "===addTagView: " + getUrl(), null, null, 12);
        ConcurrentHashMap r1 = g16.a.a;
        g16.b r11 = g16.a.a(this.currentBid);
        if (showContainerTag(r11) == true) goto L6;
        r11 = null;
    L6:
        if (r11 == null) goto L12;
        DebugTagTextView r12 = LayoutInflater.from(this.context).inflate(2131559209, getParentViewGroup(), false);
        if ((r12 instanceof DebugTagTextView) == false) goto L10;
        r10 = r12;
    L10:
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(-2, -2);
        r13.gravity = 8388661;
        getParentViewGroup().addView(r10, r13);
        return;
    }

    private final void transferToTargetState() {
    L3:
        if ((!this.stateBlockingQueue.isEmpty()) == false) goto L5;
        changeState(this.stateBlockingQueue.take().intValue());
        goto L3
    }

    private final boolean useSystemDialog() {
        return !(this instanceof AnnieXFlowPageContainer);
    }

    public void addKitView() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===addKitView: " + getUrl(), null, null, 12);
        getParentViewGroup().removeAllViews();
        View r1 = getEngine().d();
        if (r1 == null) goto L6;
        getParentViewGroup().addView(r1);
        padAdaptation(r1, this.context.getResources().getConfiguration(), true);
        this.lifecycleDispatcher.a(getUrl(), this);
        return;
    }

    @Override // ia.b, ia.c
    public void close() {
        HybridLogger r0 = HybridLogger.a;
        ia.j r10 = null;
        HybridLogger.m(TAG, "===close: " + getUrl(), null, null, 12);
        if (this.isNotRelease == false) goto L10;
        ia.j r1 = this.uiComponent;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L8:
        r10.a();
        return;
    L7:
        r10 = r1;
        goto L8
    }

    public final qa.a getAnnieXContext() {
        return (qa.a) this.annieXContext$delegate.getValue();
    }

    public final v36.a getContainerModel() {
        return (v36.a) this.containerModel$delegate.getValue();
    }

    public final na.a getEngine() {
        return (na.a) this.engine$delegate.getValue();
    }

    public final ViewGroup getParentViewGroup() {
        ViewGroup r0 = this.parentViewGroup;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        return null;
    }

    @Override // ia.b, ia.c
    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    @Override // ia.b, ia.c
    public WeakReference<Context> getWeakContext() {
        return new WeakReference(getAnnieXContext().getContext());
    }

    @Override // ia.b, ia.c
    public void hideLoading() {
        HybridLogger r0 = HybridLogger.a;
        com.bytedance.ies.bullet.service.base.q r10 = null;
        HybridLogger.m(TAG, "===hideLoading: " + getUrl(), null, null, 12);
        View r1 = this.loadingView;
        boolean r11 = r1 instanceof com.bytedance.ies.bullet.service.base.q;
        if (r11 == false) goto L8;
        if (r11 == false) goto L6;
        r10 = (com.bytedance.ies.bullet.service.base.q) r1;
    L6:
        if (r10 == null) goto L12;
        r10.hide();
        return;
    L12:
        return;
    L8:
        if (r1 == null) goto L14;
        r1.setVisibility(8);
        return;
    }

    public final void initUi() {
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===initUi: " + getUrl(), null, null, 12);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        observerKeyboardStatusChange();     // Catch: Throwable -> L5
        putState(0);     // Catch: Throwable -> L5
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L13;
        HybridLogger r12 = HybridLogger.a;
        HybridLogger.i(TAG, "initUi===>" + r11.getMessage(), null, 12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // ia.b, ia.c
    public void release() {
        if (this.isNotRelease == true) goto L5;
        return;
    L5:
        super.release();
        HybridLogger r0 = HybridLogger.a;
        HybridLogger.m(TAG, "===release: " + getUrl(), null, null, 12);
        removeScreenCaptureListener();
        getEngine().release();
        getAnnieXContext().release();
        this.errorView = null;
        this.loadingView = null;
        this.noticeView = null;
        this.denyView = null;
        this.isNotRelease = false;
    }

    @Override // ia.b, ia.c
    public void showError() {
        HybridLogger r0 = HybridLogger.a;
        ia.j r10 = null;
        HybridLogger.m(TAG, "===showError: " + getUrl(), null, null, 12);
        if (this.errorView == null) goto L5;
    L13:
        com.bytedance.ies.bullet.service.base.i r1 = this.errorView;
        if (r1 != null) goto L16;
        return;
    L16:
        if (this.errorViewAdded == true) goto L19;
        getParentViewGroup().addView(r1);
        this.errorViewAdded = true;
    L19:
        if ((r1 instanceof com.bytedance.ies.bullet.service.base.i) == false) goto L21;
        r1.show();
        return;
    L21:
        r1.setVisibility(0);
        return;
    L5:
        if (this.isNotRelease == false) goto L13;
        HybridLogger.m(TAG, "create error view", null, null, 12);
        ia.j r11 = this.uiComponent;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L10:
        View r12 = r10.b();
        if (r12 == null) goto L13;
        this.errorView = r12;
        goto L13
    L9:
        r10 = r11;
        goto L10
    }

    private final void addScreenCaptureListener() {
        if (com.bytedance.ies.bullet.service.base.h.e() == true) goto L5;
        return;
    L5:
        na.a r0 = getEngine();
        Context r1 = this.context;
        if ((r1 instanceof Activity) == false) goto L8;
        Activity r10 = (Activity) r1;
    L9:
        r0.c(r10);
        return;
    L8:
        r10 = null;
        goto L9
    }

    private final void bindWebOnScrollChangeListener() {
        if ((getKitView() instanceof SSWebView) == false) goto L6;
        SSWebView r0 = getKitView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
        r0.setWebScrollListener(new c(this));
        return;
    }

    private final void initContainerColor() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L16;
        Integer r1 = (Integer) ((y36.i) r0.e()).b;
        if (r1 != null) goto L7;
        r1 = (Integer) ((y36.i) r0.b()).b;
    L7:
        if (r1 == null) goto L17;
        int r10 = r1.intValue();
        Drawable r11 = getParentViewGroup().getBackground();
        if (r11 == null) goto L13;
        Drawable.ConstantState r12 = r11.getConstantState();
        if (r12 == null) goto L13;
        Drawable r13 = r12.newDrawable();
    L14:
        this.originBackground = r13;
        this.useCustomBackground = true;
        getParentViewGroup().setBackgroundColor(r10);
        return;
    L13:
        r13 = null;
        goto L14
    L17:
        return;
    }

    private final boolean needAdapterKeyboard() {
        if ((getEngine().d() instanceof LynxView) == false) goto L5;
        return false;
    L5:
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L15;
        y36.i r1 = r0.z;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r1 = null;
    L11:
        if (r1 == null) goto L15;
        Integer r10 = (Integer) r1.b;
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
    L17:
        if (r11 <= (-1)) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(getViewType(), "page") == false) goto L40;
        v36.a r12 = getContainerModel();
        if (r12 == null) goto L26;
        y36.a r13 = r12.h();
        if (r13 == null) goto L26;
        boolean r14 = Intrinsics.areEqual(((y36.i) r13).b, Boolean.TRUE);
    L27:
        if (r14 == true) goto L36;
        v36.a r15 = getContainerModel();
        if (r15 == null) goto L33;
        y36.a r16 = r15.j();
        if (r16 == null) goto L33;
        boolean r17 = Intrinsics.areEqual(((y36.i) r16).b, Boolean.TRUE);
    L34:
        if (r17 == true) goto L36;
        return false;
    L33:
        r17 = false;
    L36:
        if (r11 != (-2)) goto L45;
        return true;
    L45:
        return false;
    L26:
        r14 = false;
        goto L27
    L40:
        if (Intrinsics.areEqual(getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L46;
        if (r11 != (-1)) goto L47;
        return true;
    L47:
        return false;
    L46:
        return false;
    L15:
        r11 = 0;
        goto L17
    }

    private final boolean needAdapterKeyboard4Web() {
        if (getKitType() != KitType.LYNX) goto L5;
        return false;
    L5:
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L15;
        y36.i r1 = r0.z;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r1 = null;
    L11:
        if (r1 == null) goto L15;
        Integer r10 = (Integer) r1.b;
        if (r10 == null) goto L15;
        int r11 = r10.intValue();
    L16:
        if (r11 <= (-1)) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(getViewType(), "page") == false) goto L39;
        v36.a r12 = getContainerModel();
        if (r12 == null) goto L25;
        y36.a r13 = r12.h();
        if (r13 == null) goto L25;
        boolean r14 = Intrinsics.areEqual(((y36.i) r13).b, Boolean.TRUE);
    L26:
        if (r14 == true) goto L35;
        v36.a r15 = getContainerModel();
        if (r15 == null) goto L32;
        y36.a r16 = r15.j();
        if (r16 == null) goto L32;
        boolean r17 = Intrinsics.areEqual(((y36.i) r16).b, Boolean.TRUE);
    L33:
        if (r17 == true) goto L35;
        return false;
    L32:
        r17 = false;
    L35:
        if (r11 != (-2)) goto L44;
        return true;
    L44:
        return false;
    L25:
        r14 = false;
        goto L26
    L39:
        if (Intrinsics.areEqual(getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L45;
        if (r11 != (-1)) goto L46;
        return true;
    L46:
        return false;
    L45:
        return false;
    L15:
        r11 = -1;
        goto L16
    }

    private final void removeScreenCaptureListener() {
        if (com.bytedance.ies.bullet.service.base.h.e() == true) goto L5;
        return;
    L5:
        na.a r0 = getEngine();
        Context r1 = this.context;
        if ((r1 instanceof Activity) == false) goto L8;
        Activity r10 = (Activity) r1;
    L9:
        r0.e(r10);
        return;
    L8:
        r10 = null;
        goto L9
    }

    private final void setBackgroundColor() {
        v36.a r0 = getContainerModel();
        Intrinsics.checkNotNull(r0);
        Integer r1 = (Integer) ((y36.i) r0.b()).b;
        if (r1 == null) goto L5;
        int r10 = r1.intValue();
        getParentViewGroup().setBackgroundColor(r10);
        Unit r11 = Unit.INSTANCE;
    L6:
        if (r11 == null) goto L8;
        return;
    L8:
        if (this.useCustomBackground == false) goto L12;
        getParentViewGroup().setBackground(this.originBackground);
        this.useCustomBackground = false;
        return;
    L12:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private final void setContainerColor() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L23;
        XBaseRuntime.a.getClass();
        IHostContextDepend r1 = XBaseRuntime.f;
        Unit r10 = null;
        if (r1 == null) goto L7;
        String r11 = r1.getSkinName();
    L8:
        if (r11 != null) goto L10;
        setBackgroundColor();
        return;
    L10:
        if (Intrinsics.areEqual(r11.toLowerCase(), "light") == false) goto L16;
        Integer r12 = (Integer) ((y36.i) r0.d()).b;
        if (r12 == null) goto L14;
        getParentViewGroup().setBackgroundColor(r12.intValue());
        r10 = Unit.INSTANCE;
    L14:
        if (r10 != null) goto L24;
        setBackgroundColor();
        return;
    L24:
        return;
    L16:
        Integer r13 = (Integer) ((y36.i) r0.c()).b;
        if (r13 == null) goto L19;
        getParentViewGroup().setBackgroundColor(r13.intValue());
        r10 = Unit.INSTANCE;
    L19:
        if (r10 != null) goto L26;
        setBackgroundColor();
        return;
    L26:
        return;
    L7:
        r11 = null;
        goto L8
    }

    private final void updateLynxScreenMetrics() {
        View r0 = getEngine().d();
        if (r0 == null) goto L10;
        t36.j r1 = getAnnieXContext().f;
        Integer r10 = b46.c.a;
        Intrinsics.areEqual(getViewType(), "page");
        Scenes r11 = Scenes.AbsActivity;
        b46.c.d(r1);
        Context r12 = r0.getContext();
        if (r12 == null) goto L11;
        b46.i r13 = b46.m.a(r12);
        if (r13 == null) goto L12;
        updateScreenMetrics(r13.a, r13.b);
        HybridLogger r14 = HybridLogger.a;
        HybridLogger.m(TAG, "updateLynxScreenMetrics : enableIpadAdapter false , width " + r13.a + " , height " + r13.b, null, null, 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ia.b, ia.c
    public boolean canBackPress() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L7;
        y36.a r1 = r0.g();
        if (r1 == null) goto L7;
        boolean r10 = Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L8:
        if (r10 == false) goto L10;
        String r11 = "containerShouldClose";
    L11:
        sendEvent(new d(r11, r10));
        return !r10;
    L10:
        r11 = "on_key_back";
    L7:
        r10 = false;
        goto L8
    }

    @Override // ia.b, ia.c
    public boolean canGoBack() {
        return getEngine().canGoBack();
    }

    @Override // ia.b, ia.c
    public LaunchMode getBDXLaunchMode() {
        LaunchMode r0 = (LaunchMode) ((y36.i) new y36.e(getAnnieXContext().f.a, null)).b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return LaunchMode.MODE_UNSPECIFIED;
    }

    @Override // ia.b, ia.c
    public String getBDXTag() {
        return (String) ((y36.i) new y36.p(getAnnieXContext().f.a, "bdx_tag", null)).b;
    }

    @Override // ia.b, ia.c
    public String getBid() {
        return getAnnieXContext().c;
    }

    @Override // ia.b, ia.c
    public String getContainerId() {
        return getAnnieXContext().b;
    }

    @Override // ia.b, ia.c
    public m16.b getContextProviderFactory() {
        return getAnnieXContext().h;
    }

    @Override // ia.b, ia.c
    public t36.d getCurrentSchema() {
        return getAnnieXContext().f.a;
    }

    @Override // ia.b, ia.c
    public String getCurrentUrl() {
        return getAnnieXContext().e;
    }

    @Override // ia.b, ia.c
    public KitType getKitType() {
        return getAnnieXContext().d;
    }

    @Override // ia.b, ia.c
    public View getKitView() {
        return getEngine().d();
    }

    @Override // ia.b, ia.c
    public t36.d getSchemaData() {
        return getAnnieXContext().f.a;
    }

    public final String getUrl() {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L9;
        s r1 = r0.f();
        if (r1 == null) goto L9;
        Uri r10 = (Uri) ((y36.i) r1).b;
        if (r10 == null) goto L9;
        String r11 = r10.toString();
    L10:
        if (r11 != null) goto L13;
        return "unknown";
    L13:
        return r11;
    L9:
        r11 = null;
        goto L10
    }

    @Override // ia.b
    public void observerKeyboardStatusChange() {
        if (com.bytedance.ies.bullet.service.base.h.o0() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(getViewType(), "card") == true) goto L14;
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L10;
        final Activity r1 = (Activity) r0;
    L11:
        if (r1 == null) goto L15;
        SoftInputKt.c(r1, new AnnieXLiteContainer$observerKeyboardStatusChange$1$1(r1, this));
        return;
    L15:
        return;
    L10:
        r1 = null;
        goto L11
    }

    @Override // ia.b
    public void removeKitView() {
        removeScreenCaptureListener();
        getEngine().release();
    }

    public final UIComponentBuilder getBuilder() {
        return this.builder;
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final Context getContext() {
        return this.context;
    }

    public final com.bytedance.android.anniex.container.b getLifecycleDispatcher() {
        return this.lifecycleDispatcher;
    }

    public Scenes getScenes() {
        return Scenes.LitePage;
    }

    @Override // ia.b, ia.c
    public Context getSystemContext() {
        return this.context;
    }

    @Override // ia.b
    public boolean isVisibility() {
        return this.isVisibility;
    }

    public AnnieXLiteContainer(UIComponentBuilder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        this.builder = r10;
        com.bytedance.android.anniex.container.b r0 = new com.bytedance.android.anniex.container.b();
        com.bytedance.android.anniex.base.lifecycle.a r1 = r10.f;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r1, "lifecycle");
        r0.a.add(r1);
    L5:
        this.lifecycleDispatcher = r0;
        this.containerModel$delegate = LazyKt.lazy(new AnnieXLiteContainer$containerModel$2(this));
        this.currentBid = r10.b;
        Context r11 = r10.a;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r11 = null;
    L9:
        this.context = r11;
        this.annieXContext$delegate = LazyKt.lazy(new AnnieXLiteContainer$annieXContext$2(this));
        this.engine$delegate = LazyKt.lazy(new AnnieXLiteContainer$engine$2(this));
        this.currentState = -1;
        this.stateBlockingQueue = new ArrayBlockingQueue(10);
        this.isNotRelease = true;
        this.annieLifeCycle = new b(this);
    }

    public static final /* synthetic */ void access$addScreenCaptureListener(AnnieXLiteContainer r0) {
        r0.addScreenCaptureListener();
    }

    public static final /* synthetic */ void access$bindWebOnScrollChangeListener(AnnieXLiteContainer r0) {
        r0.bindWebOnScrollChangeListener();
    }

    public static final /* synthetic */ ia.j access$getUiComponent$p(AnnieXLiteContainer r0) {
        return r0.uiComponent;
    }

    private final void changeState(int r10) {
        this.currentState = r10;
        if (r10 != 0) goto L5;
        transferToTargetState();
        initContainerColor();
        return;
    L5:
        if (r10 == 1) goto L52;
        if (r10 != 2) goto L9;
        getParentViewGroup().removeAllViews();
        this.errorViewAdded = false;
        addKitView();
        v36.a r11 = getContainerModel();
        if (r11 == null) goto L74;
        y36.a r12 = r11.i();
        if (r12 == null) goto L75;
        Boolean r13 = (Boolean) ((y36.i) r12).b;
        if (r13 != null) goto L28;
        return;
    L28:
        if (r13.booleanValue() == true) goto L31;
        r13 = null;
    L31:
        if (r13 == null) goto L77;
        r13.booleanValue();
        if (this.loadingView == null) goto L35;
    L40:
        View r14 = this.loadingView;
        if (r14 == null) goto L50;
        ViewGroup.LayoutParams r0 = r14.getLayoutParams();
        if ((r0 instanceof FrameLayout.LayoutParams) == false) goto L45;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
    L46:
        if (r1 == null) goto L49;
        r1.gravity = 17;
    L49:
        getParentViewGroup().addView(r14);
        goto L50
    L45:
        r1 = null;
    L50:
        showLoading(null);
        return;
    L35:
        if (this.isNotRelease == false) goto L40;
        HybridLogger.m(TAG, "create loading view", null, null, 12);
        ia.j r15 = this.uiComponent;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r15 = null;
    L39:
        this.loadingView = r15.c();
        goto L40
    L77:
        return;
    L75:
        return;
    L74:
        return;
    L9:
        if (r10 == 4) goto L17;
        if (r10 != 5) goto L80;
        this.isRuntimeReady = true;
        if (this.isResuming == false) goto L71;
        getEngine().enterForeground();
        return;
    L71:
        return;
    L80:
        return;
    L17:
        if (this.loadSuccess == false) goto L19;
        HybridLogger.f(TAG, "load success", null, 12);
        setContainerColor();
    L20:
        hideLoading();
        addTagView();
        return;
    L19:
        HybridLogger.f(TAG, "load fail", null, 12);
        showError();
        goto L20
    L52:
        if (Intrinsics.areEqual(getViewType(), com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP) == false) goto L61;
        com.bytedance.android.anniex.assemble.a r16 = com.bytedance.android.anniex.assemble.a.a;
        Iterator r17 = com.bytedance.android.anniex.assemble.a.e().entrySet().iterator();
    L55:
        if (r17.hasNext() == false) goto L61;
        ia.c r18 = (ia.c) ((WeakReference) ((Map.Entry) r17.next()).getValue()).get();
        if (r18 == null) goto L55;
        if (Intrinsics.areEqual(r18.getWeakContext().get(), this.context) == false) goto L55;
        r18.onVisibleChange(false, Boolean.FALSE);
    L61:
        AnnieXContainerManager.INSTANCE.addContainer(this);
    }

    private final Map<String, Object> completeRenderData(Map<String, ? extends Object> r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = getAnnieXContext().b;
        if (r1 == null) goto L15;
        Map<String, i36.d> r11 = MonitorManager.a;
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        i36.d r12 = (i36.d) ((LinkedHashMap) MonitorManager.a).get(r1);
        if (r12 == null) goto L7;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("open_time", Long.valueOf(r12.b("open_time")));
        r13.put("container_init_start", Long.valueOf(r12.b("container_init_start")));
        r13.put("container_init_end", Long.valueOf(r12.b("container_init_end")));
    L8:
        if (r13 == null) goto L15;
        r0.putAll(r13);
        Object r14 = r13.get("open_time");
        if (r14 == null) goto L15;
        if (Intrinsics.areEqual(this.builder.b, "webcast") == false) goto L14;
        r0.put("initTimestamp", r14.toString());
        r0.remove("open_time");
        goto L15
    L14:
        r0.put("containerInitTime", r14);
        goto L15
    L7:
        r13 = null;
    L15:
        r0.put("page_type_opt", getPageOptType());
        if (r10 == null) goto L18;
        r0.putAll(r10);
    L18:
        return r0;
    }

    private final qa.a createAnnieXContext(UIComponentBuilder r11) {
        Uri r0 = getUriByBundle(r11.c);
        String r10 = q26.i.b(r0, r11.c);
        LruCache<String, AnnieXWebModel> r1 = com.bytedance.android.anniex.lite.c.a;
        t36.j r12 = com.bytedance.android.anniex.lite.c.a(this.currentBid, r0, r10);
        String r13 = (String) r12.a.c().get(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r13 != null) goto L5;
        r13 = r0.toString();
    L5:
        String r14 = r13;
        AnnieXJSWorkerManager r15 = AnnieXJSWorkerManager.a;
        Context r16 = this.context.getApplicationContext();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.app.Application");
        r15.c((Application) r16, r0.toString());
        qa.a r17 = new qa.a(getScenes(), r10, this.currentBid, r11.c, r14, com.bytedance.android.anniex.lite.utils.c.a(UriProtector.parse(r14)), r12);
        Context r18 = r11.a;
        if (r18 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r18 = null;
    L9:
        r17.g = r18;
        return r17;
    }

    private final na.a createEngine(qa.a r10) {
        if (r10.d == KitType.LYNX) goto L17;
        Map r0 = x26.a.a;
        w26.g r1 = (w26.g) x26.a.a(w26.g.class);
        if (r1 == null) goto L10;
        w26.e r11 = (w26.e) r1.n0(w26.e.class);
        if (r11 == null) goto L10;
        boolean r12 = r11.h0();
    L11:
        if (r12 == false) goto L16;
        if (StringsKt.contains$default(r10.e, "template.js", false, 2, null) == false) goto L16;
        HybridLogger r13 = HybridLogger.a;
        HybridLogger.i(TAG, "===createEngine Web error:" + r10.f.a.getOriginUrl(), null, 12);
    L16:
        return new o(r10, this);
    L10:
        r12 = true;
        goto L11
    L17:
        return new l(r10, this);
    }

    private final View getContentView(View r10) {
        View r11 = r10.findViewById(R.id.content);
        if ((r11 instanceof ViewGroup) == true) goto L7;
        return null;
    L7:
        return (ViewGroup) r11;
    }

    private final Uri getUriByBundle(Bundle r10) {
        String r11 = r10.getString("__x_inner_schema");
        if (r11 == null) goto L5;
        Uri r12 = UriProtector.parse(r11);
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        return Uri.EMPTY;
    L5:
        r12 = null;
        goto L6
    }

    private final m16.b mergeContext(m16.b r10) {
        m16.b r0 = getAnnieXContext().h;
        if (r10 == null) goto L5;
        r0.b(r10);
    L5:
        r0.d(com.bytedance.android.anniex.lite.utils.a.class, new com.bytedance.android.anniex.lite.utils.a("nl"));
        return r0;
    }

    private final void possiblyResizeChildOfContent(int r10) {
        if (needAdapterKeyboard() == true) goto L5;
        return;
    L5:
        View r0 = getParentViewGroup().getRootView();
        int r1 = r0.getHeight();
        int r11 = r1 - r10;
        if (r11 == this.usableHeightPrevious) goto L18;
        View r12 = getContentView(r0);
        if (r12 == null) goto L10;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
    L11:
        if (r13 != null) goto L13;
        return;
    L13:
        if (r10 <= (r1 / 4)) goto L15;
        r13.height = r11;
    L16:
        r12.requestLayout();
        this.usableHeightPrevious = r11;
        return;
    L15:
        r13.height = r1;
        goto L16
    L10:
        r13 = null;
        goto L11
    }

    private final void possiblyResizeChildOfContent4Web(int r10) {
        if (needAdapterKeyboard4Web() == true) goto L5;
        return;
    L5:
        v36.a r0 = getContainerModel();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L13;
        y36.i r11 = r0.G;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r11 = null;
    L11:
        if (r11 == null) goto L13;
        boolean r12 = Intrinsics.areEqual(r11.b, Boolean.TRUE);
    L14:
        if (r12 == false) goto L16;
        return;
    L16:
        View r13 = getParentViewGroup().getRootView();
        int r14 = r13.getHeight();
        int r15 = r14 - r10;
        if (r15 == this.usableHeightPrevious) goto L38;
        View r16 = getContentView(r13);
        if (useSystemDialog() == true) goto L21;
    L29:
        if (r16 == null) goto L31;
        r1 = r16.getLayoutParams();
    L31:
        if (r1 != null) goto L33;
        return;
    L33:
        if (r10 <= (r14 / 4)) goto L35;
        r1.height = r15;
    L36:
        r16.requestLayout();
        this.usableHeightPrevious = r15;
        return;
    L35:
        r1.height = r14;
        goto L36
    L21:
        if (AnnieXContainerManager.isTopContainer(this) == false) goto L29;
        if (r10 != 0) goto L25;
        if (r16 == null) goto L27;
        r16.scrollTo(0, 0);
    L27:
        this.usableHeightPrevious = r15;
        return;
    L25:
        if (r16 == null) goto L27;
        r16.scrollBy(0, r10);
        goto L27
    L38:
        return;
    L13:
        r12 = false;
        goto L14
    }

    private final void putState(int r10) {
        if (this.parentViewGroup == null) goto L10;
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L7;
        Activity r1 = (Activity) r0;
    L8:
        if (r1 == null) goto L12;
        r1.runOnUiThread(new f(this, r10));
        return;
    L12:
        return;
    L7:
        r1 = null;
        goto L8
    L10:
        this.stateBlockingQueue.put(Integer.valueOf(r10));
    }

    private final boolean showContainerTag(g16.b r10) {
        com.bytedance.ies.bullet.core.h r0 = com.bytedance.ies.bullet.core.h.h;
        com.bytedance.ies.bullet.core.h r1 = com.bytedance.ies.bullet.core.h.h;
        if (r1.a == false) goto L7;
        r1.getClass();
        if (r10.a == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // ia.b, ia.c
    public t36.d generateSchemaData(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        return getAnnieXContext().f.a;
    }

    @Override // ia.b, ia.c
    public void interceptBackPress(boolean r10) {
        v36.a r0 = getContainerModel();
        if (r0 == null) goto L6;
        y36.a r1 = new y36.a(Boolean.valueOf(r10));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.i = r1;
    L6:
        ia.j r11 = this.uiComponent;
        if (r11 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r11 = null;
    L9:
        r11.d(r10);
    }

    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        padAdaptation$default(this, getEngine().d(), r10, false, 4, null);
        updateLynxScreenMetrics();
    }

    public final void onSoftInputChange(boolean r10) {
        Context r0 = this.context;
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 == null) goto L25;
        if (r10 == false) goto L21;
        int r11 = z06.c.b(r1);
        int r12 = (int) com.bytedance.android.anniex.container.util.i.a.e(z06.c.b(r1));
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L11
        possiblyResizeChildOfContent4Web(r11);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        sendKeyboardStatusChangeEvent(true, r12);
        return;
    L11:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L21:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        possiblyResizeChildOfContent4Web(0);     // Catch: Throwable -> L17
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        sendKeyboardStatusChangeEvent(false, 0);
        return;
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ia.b
    public void recreateKitView(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        loadSchema(r10, null);
    }

    @Override // ia.b, ia.c
    public void reload(Map<String, ? extends Object> r10) {
        if (this.loadSuccess == false) goto L10;
        int r0 = this.currentState;
        if (r0 != 5) goto L7;
    L8:
        getEngine().reload();
        return;
    L7:
        if (r0 == 4) goto L8;
    L10:
        loadSchema(getUrl(), r10);
    }

    @Override // ia.b, ia.c
    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        getEngine().sendEvent(r10);
    }

    public final void setContainerVisible(boolean r1) {
        this.containerVisible = r1;
    }

    public final void setParentViewGroup(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.parentViewGroup = r10;
    }

    public final void setUiComponent(ia.j r10) {
        Intrinsics.checkNotNullParameter(r10, "uiComponent");
        this.uiComponent = r10;
    }

    @Override // ia.b, ia.c
    public void showLoading(String r10) {
        HybridLogger r11 = HybridLogger.a;
        com.bytedance.ies.bullet.service.base.q r12 = null;
        HybridLogger.m(TAG, "===showLoading: " + getUrl(), null, null, 12);
        View r13 = this.loadingView;
        boolean r0 = r13 instanceof com.bytedance.ies.bullet.service.base.q;
        if (r0 == false) goto L8;
        if (r0 == false) goto L6;
        r12 = (com.bytedance.ies.bullet.service.base.q) r13;
    L6:
        if (r12 == null) goto L12;
        r12.show();
        return;
    L12:
        return;
    L8:
        if (r13 == null) goto L14;
        r13.setVisibility(0);
        return;
    }

    @Override // ia.b
    public void updateData(String r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        getEngine().updateData(r10);
    }

    @Override // ia.b, ia.c
    public void updateGlobalProps(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "globalProps");
        getAnnieXContext().i.putAll(r10);
        getEngine().updateGlobalProps(r10);
    }

    @Override // ia.b, ia.c
    public void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        getEngine().updateData(r10);
    }

    public static final /* synthetic */ void access$changeState(AnnieXLiteContainer r0, int r1) {
        r0.changeState(r1);
    }

    public static final /* synthetic */ qa.a access$createAnnieXContext(AnnieXLiteContainer r0, UIComponentBuilder r1) {
        return r0.createAnnieXContext(r1);
    }

    public static final /* synthetic */ na.a access$createEngine(AnnieXLiteContainer r0, qa.a r1) {
        return r0.createEngine(r1);
    }

    public static final /* synthetic */ void access$possiblyResizeChildOfContent(AnnieXLiteContainer r0, int r1) {
        r0.possiblyResizeChildOfContent(r1);
    }

    public static final /* synthetic */ void access$putState(AnnieXLiteContainer r0, int r1) {
        r0.putState(r1);
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(AnnieXLiteContainer r0, boolean r1) {
        r0.loadSuccess = r1;
    }

    private final void sendKeyboardStatusChangeEvent(boolean r10, int r11) {
        JSONObject r0 = new JSONObject();
        r0.put("visible", r10);
        r0.put("height", r11);
        sendEvent(new g(r0));
        sendEvent(new h(r0));
    }

    @Override // ia.b, ia.c
    public void loadSchema(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        loadSchema(r10, r11, null, this.annieLifeCycle);
    }

    @Override // ia.b, ia.c
    public void onVisibleChange(boolean r1, Boolean r10) {
        if (r1 != this.containerVisible) goto L5;
        return;
    L5:
        this.containerVisible = r1;
        sendEvent(new e(r1, this));
    }

    @Override // ia.b, ia.c
    public <T> void registerWeakHolder(Class<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "clazz");
        m16.b r0 = getAnnieXContext().h;
        if (r0 == null) goto L6;
        r0.g(r10, r11);
        return;
    }

    @Override // ia.b, ia.c
    public void updateScreenMetrics(int r1, int r10) {
        getEngine().a();
    }

    public static final /* synthetic */ void access$sendKeyboardStatusChangeEvent(AnnieXLiteContainer r0, boolean r1, int r10) {
        r0.sendKeyboardStatusChangeEvent(r1, r10);
    }

    private final void padAdaptation(View r10, Configuration r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        Intrinsics.areEqual(getViewType(), "page");
        Scenes r13 = Scenes.AbsActivity;
        Integer r14 = b46.c.a;
        b46.c.d(getAnnieXContext().f);
        HybridLogger r15 = HybridLogger.a;
        HybridLogger.m(TAG, "padAdaptation : current scenes=" + getViewType() + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, null, null, 12);
    }

    @Override // ia.b
    public void loadSchema(String r10, Map<String, ? extends Object> r11, m16.b r12, com.bytedance.android.anniex.base.lifecycle.a r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        String r14 = getAnnieXContext().b;
        if (r14 == null) goto L5;
        Map<String, i36.d> r0 = MonitorManager.a;
        Intrinsics.checkNotNullParameter(r14, "sessionId");
        long r1 = System.currentTimeMillis();
        MonitorManager.d0(MonitorManager.a, r14).c("container_init_end", Long.valueOf(r1));
        ExecutorService r15 = com.bytedance.ies.bullet.service.monitor.a.a;
        com.bytedance.ies.bullet.service.monitor.a.c(r14, "container_init_end", Long.valueOf(r1));
        SLMonitorCompat r16 = SLMonitorCompat.a;
        SLContainerTiming r17 = SLContainerTiming.ContainerInitEnd;
        r16.getClass();
        SLMonitorCompat.g(r14, r17, r1);
        SLMonitorCompat.r(r14, r10);
    L5:
        getEngine().b(r10, completeRenderData(r11), mergeContext(r12), this.annieLifeCycle);
    }

    public static /* synthetic */ void padAdaptation$default(AnnieXLiteContainer r0, View r1, Configuration r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 4) == 0) goto L6;
        r11 = false;
    L6:
        r0.padAdaptation(r1, r10, r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
    }
}
