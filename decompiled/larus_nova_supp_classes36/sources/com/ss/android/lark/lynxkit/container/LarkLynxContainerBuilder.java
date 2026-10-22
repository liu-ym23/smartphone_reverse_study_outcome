package com.ss.android.lark.lynxkit.container;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.canvas.KryptonLoaderService;
import com.lynx.canvas.LynxKryptonUtils;
import com.lynx.devtoolwrapper.DevToolSettings;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.q1;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolBuilderConfigurator;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolBuilderHandle;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.bridge.LarkBridgeModuleEntity;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeModule;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolBuilderContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeRuntimeProtocol;
import com.ss.android.lark.lynxkit.initializer.LarkLynxKitInitializer;
import com.ss.android.lark.lynxkit.monitor.LynxKitMonitor;
import com.ss.android.lark.maintab.export.TabAppInfo;
import d8a.k;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\f\b\u0007\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00101\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\fJ\u000e\u00102\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\fJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010=\u001a\u00020.J\u000e\u00100\u001a\u00020\u00002\u0006\u0010=\u001a\u00020.J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0018J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020EJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\bJ\u000e\u00103\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\fJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010K\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\bJ\u001a\u0010#\u001a\u00020\u00002\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"J\u0016\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u0001J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020)J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u000e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020;J\u000e\u0010V\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\fJ\u000e\u0010W\u001a\u00020\u00002\u0006\u0010X\u001a\u00020\bJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u000205J\u0006\u0010[\u001a\u00020\\J,\u0010]\u001a\u00020\\2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u0012\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010aH\u0002J\u0012\u0010i\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010jH\u0002J\n\u0010k\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010l\u001a\u0004\u0018\u00010\b2\b\u0010B\u001a\u0004\u0018\u00010\u0018H\u0002J&\u0010m\u001a\u0004\u0018\u00010j2\b\u0010B\u001a\u0004\u0018\u00010\u00182\u0006\u0010n\u001a\u00020o2\b\u0010F\u001a\u0004\u0018\u00010\bH\u0002J0\u0010p\u001a\u0004\u0018\u00010a2\b\u0010B\u001a\u0004\u0018\u00010\u00182\u0006\u0010^\u001a\u00020_2\b\u0010F\u001a\u0004\u0018\u00010\b2\b\u0010q\u001a\u0004\u0018\u00010jH\u0002J&\u0010r\u001a\u00020g2\b\u0010s\u001a\u0004\u0018\u00010t2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0002J\u0018\u0010u\u001a\u00020g2\u0006\u0010^\u001a\u00020_2\u0006\u0010b\u001a\u00020cH\u0002J0\u0010v\u001a\u00020w2\u0006\u0010b\u001a\u00020c2\u0006\u0010x\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\bH\u0002J0\u0010y\u001a\u00020w2\u0006\u0010b\u001a\u00020c2\u0006\u0010x\u001a\u00020\b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010z\u001a\u00020g2\u0006\u0010b\u001a\u00020c2\u0006\u0010{\u001a\u00020wH\u0002J \u0010|\u001a\u00020g2\u0006\u0010b\u001a\u00020c2\u0006\u0010{\u001a\u00020w2\u0006\u0010}\u001a\u00020~H\u0002J\u0010\u0010\u007f\u001a\u00020\b2\u0006\u0010}\u001a\u00020~H\u0002J\u001e\u0010\u0080\u0001\u001a\u00020w2\u0006\u0010b\u001a\u00020c2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\bH\u0002J\t\u0010\u0082\u0001\u001a\u00020cH\u0002J\u0011\u0010\u0083\u0001\u001a\u00020\"2\u0006\u0010b\u001a\u00020cH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020g2\u0006\u0010n\u001a\u00020oH\u0002J\t\u0010\u0085\u0001\u001a\u00020gH\u0002J!\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0087\u0001\u001a\u00020\b2\u000f\u0010\u0088\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010&j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001`'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u0012\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u0012\u00100\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0004\n\u0002\u0010/R\u000e\u00101\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R%\u00106\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t07¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lcom/ss/android/lark/lynxkit/container/LarkLynxContainerBuilder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "providers", "", "", "Lcom/lynx/tasm/provider/LynxResourceProvider;", "codeCacheSourceUrl", "enableUserCodeCache", "", "tagForJsContext", "tagForCustomComponent", "tagForGlobalData", "tagForBridgeMethodDispatcher", "tagForJSModule", "tagForTemplateLoader", "templateLoadListener", "Lcom/ss/android/lark/lynxkit/container/ITemplateLoadListener;", "tagForBridgeMethodGroup", "tagForBridgeProtocol", "bridgeProtocol", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocol;", "bridgeProtocolContainerId", "lynxContainerContext", "Lcom/ss/android/lark/lynxkit/container/ILynxContainerContext;", "devToolSocketUrl", "templateByteArray", "", "templateUrl", "templatePathForTemplateLoader", "lynxViewClient", "Lcom/lynx/tasm/LynxViewClient;", "initData", "Lcom/lynx/tasm/TemplateData;", "shareDataMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "imageInterceptor", "Lcom/lynx/tasm/behavior/ImageInterceptor;", "fontScale", "", "Ljava/lang/Float;", "widthMeasureSpec", "", "Ljava/lang/Integer;", "heightMeasureSpec", "enableAsyncRender", "enableAsyncRenderForList", "enableDevToolsDebug", "dynamicComponentFetcher", "Lcom/lynx/tasm/component/DynamicComponentFetcher;", "resourceProviders", "", "getResourceProviders", "()Ljava/util/Map;", "customLynxBridgeModule", "Lcom/ss/android/lark/lynxkit/bridge/CustomLynxBridgeModule;", "enable", "measureSpec", "tag", "dispatcherTag", "bridgeGroupTag", "protocolTag", "protocol", "bridgeRuntimeFactory", "factory", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntimeFactory;", "containerId", "containerContext", "url", "templateData", "byteArray", "templatePath", "initDataJson", "initDataMap", "lynxViewLifeCycle", "lynxContextShareData", TabAppInfo.IMAGE_JSON_KEY, "data", "imageLoader", "interpolator", "bridgeModule", "module", "setEnableUserCodeCache", "setCodeCacheSourceUrl", "sourceUrl", "setDynamicComponentFetcher", "fetcher", "build", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "createContainer", "lynxView", "Lcom/lynx/tasm/LynxView;", "attachedBridgeProtocolHandle", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolHandle;", "monitorState", "Lcom/ss/android/lark/lynxkit/container/LynxKitContainerMonitorState;", "debugTagOverlay", "Lcom/ss/android/lark/lynxkit/container/LarkLynxDebugTagOverlay;", "detachBridgeProtocol", "", "handle", "disposeBridgeProtocolBuilderHandle", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeProtocolBuilderHandle;", "resolveBridgeProtocol", "resolveBridgeProtocolContainerId", "configureBridgeProtocol", "lynxViewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "attachBridgeProtocol", "builderHandle", "configLynxContextShareData", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "configLynxViewLifeCycle", "updateMonitorRenderInfo", "Lcom/ss/android/lark/lynxkit/monitor/LynxKitMonitorInfo;", "renderSource", "createMonitorInfoForRender", "applyMonitorInfo", "monitorInfo", "monitorTemplateLoadError", "throwable", "", "createTemplateLoadErrorMessage", "createMonitorInfo", "pageUrl", "createMonitorState", "createMonitorLynxViewClient", "initDevTool", "configureDevToolSettings", "setResourceProvider", "type", "provider", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxContainerBuilder {
    public static final a Companion = null;
    private static final String RENDER_SOURCE_TEMPLATE_BUNDLE = "template_bundle";
    private static final String RENDER_SOURCE_TEMPLATE_DATA = "template_data";
    private static final String RENDER_SOURCE_TEMPLATE_PATH = "template_path";
    private static final String RENDER_SOURCE_TEMPLATE_URL = "template_url";
    private static final String TAG = "LarkLynxContainerBuilder";
    private ILarkLynxBridgeProtocol bridgeProtocol;
    private String bridgeProtocolContainerId;
    private String codeCacheSourceUrl;
    private final Context context;
    private rqb.b customLynxBridgeModule;
    private String devToolSocketUrl;
    private k7a.a dynamicComponentFetcher;
    private boolean enableAsyncRender;
    private boolean enableAsyncRenderForList;
    private boolean enableDevToolsDebug;
    private boolean enableUserCodeCache;
    private Float fontScale;
    private Integer heightMeasureSpec;
    private m imageInterceptor;
    private TemplateData initData;
    private ILynxContainerContext lynxContainerContext;
    private q1 lynxViewClient;
    private final Map<String, k<Object, Object>> providers;
    private final Map<String, k<?, ?>> resourceProviders;
    private final HashMap<String, Object> shareDataMap;
    private String tagForBridgeMethodDispatcher;
    private String tagForBridgeMethodGroup;
    private String tagForBridgeProtocol;
    private String tagForCustomComponent;
    private String tagForGlobalData;
    private String tagForJSModule;
    private String tagForJsContext;
    private String tagForTemplateLoader;
    private byte[] templateByteArray;
    private sqb.a templateLoadListener;
    private String templatePathForTemplateLoader;
    private String templateUrl;
    private Integer widthMeasureSpec;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ILarkLynxContainer {
        public boolean a;
        public boolean b;
        public final CompositeDisposable c;
        public ILarkLynxBridgeProtocolHandle d;
        public final /* synthetic */ LynxView e;
        public final /* synthetic */ LarkLynxContainerBuilder f;
        public final /* synthetic */ sqb.c g;
        public final /* synthetic */ com.ss.android.lark.lynxkit.container.a h;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;
            public final /* synthetic */ LynxView d;

            public a(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3, LynxView r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            public final void accept(Object r4) {
                LarkLynxContainerBuilder.access$applyMonitorInfo(this.a, this.b, this.c);
                this.d.renderTemplateWithBaseUrl(((uqb.c) r4).a, LarkLynxContainerBuilder.access$getInitData$p(this.a), "");
                sqb.a r5 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r5 == null) goto L6;
                r5.onSuccess();
                return;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder$b$b, reason: collision with other inner class name */
        public static final class C0171b<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;

            public C0171b(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r4) {
                Throwable r5 = (Throwable) r4;
                Log.e(LarkLynxContainerBuilder.TAG, "ResourceLoader template load error", r5);
                LarkLynxContainerBuilder r0 = this.a;
                sqb.c r1 = this.b;
                com.ss.android.lark.lynxkit.monitor.b r2 = this.c;
                Intrinsics.checkNotNull(r5);
                LarkLynxContainerBuilder.access$monitorTemplateLoadError(r0, r1, r2, r5);
                sqb.a r3 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r3 == null) goto L6;
                r3.onFailed(r5);
                return;
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;
            public final /* synthetic */ Map<String, Object> d;
            public final /* synthetic */ LynxView e;
            public final /* synthetic */ Map<String, Object> f;

            public c(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3, Map<String, ? extends Object> r4, LynxView r5, Map<String, ? extends Object> r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final void accept(Object r4) {
                uqb.c r5 = (uqb.c) r4;
                LarkLynxContainerBuilder.access$applyMonitorInfo(this.a, this.b, this.c);
                Map<String, Object> r0 = this.d;
                if (r0 == null) goto L5;
                LarkLynxContainerBuilder.access$configLynxContextShareData(this.a, this.e.getLynxContext(), r0);
            L5:
                this.e.renderTemplateWithBaseUrl(r5.a, this.f, "");
                sqb.a r6 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r6 == null) goto L9;
                r6.onSuccess();
                return;
            }
        }

        public static final class d<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;

            public d(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r4) {
                Throwable r5 = (Throwable) r4;
                Log.e(LarkLynxContainerBuilder.TAG, "ResourceLoader template load error", r5);
                LarkLynxContainerBuilder r0 = this.a;
                sqb.c r1 = this.b;
                com.ss.android.lark.lynxkit.monitor.b r2 = this.c;
                Intrinsics.checkNotNull(r5);
                LarkLynxContainerBuilder.access$monitorTemplateLoadError(r0, r1, r2, r5);
                sqb.a r3 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r3 == null) goto L6;
                r3.onFailed(r5);
                return;
            }
        }

        public static final class e<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;
            public final /* synthetic */ Map<String, Object> d;
            public final /* synthetic */ LynxView e;
            public final /* synthetic */ String f;

            public e(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3, Map<String, ? extends Object> r4, LynxView r5, String r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final void accept(Object r4) {
                uqb.c r5 = (uqb.c) r4;
                LarkLynxContainerBuilder.access$applyMonitorInfo(this.a, this.b, this.c);
                Map<String, Object> r0 = this.d;
                if (r0 == null) goto L5;
                LarkLynxContainerBuilder.access$configLynxContextShareData(this.a, this.e.getLynxContext(), r0);
            L5:
                this.e.renderTemplateWithBaseUrl(r5.a, this.f, "");
                sqb.a r6 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r6 == null) goto L9;
                r6.onSuccess();
                return;
            }
        }

        public static final class f<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;

            public f(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r4) {
                Throwable r5 = (Throwable) r4;
                Log.e(LarkLynxContainerBuilder.TAG, "ResourceLoader template load error", r5);
                LarkLynxContainerBuilder r0 = this.a;
                sqb.c r1 = this.b;
                com.ss.android.lark.lynxkit.monitor.b r2 = this.c;
                Intrinsics.checkNotNull(r5);
                LarkLynxContainerBuilder.access$monitorTemplateLoadError(r0, r1, r2, r5);
                sqb.a r3 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r3 == null) goto L6;
                r3.onFailed(r5);
                return;
            }
        }

        public static final class g<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;
            public final /* synthetic */ Map<String, Object> d;
            public final /* synthetic */ LynxView e;
            public final /* synthetic */ TemplateData f;

            public g(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3, Map<String, ? extends Object> r4, LynxView r5, TemplateData r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final void accept(Object r4) {
                uqb.c r5 = (uqb.c) r4;
                LarkLynxContainerBuilder.access$applyMonitorInfo(this.a, this.b, this.c);
                Map<String, Object> r0 = this.d;
                if (r0 == null) goto L5;
                LarkLynxContainerBuilder.access$configLynxContextShareData(this.a, this.e.getLynxContext(), r0);
            L5:
                this.e.renderTemplateWithBaseUrl(r5.a, this.f, "");
                sqb.a r6 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r6 == null) goto L9;
                r6.onSuccess();
                return;
            }
        }

        public static final class h<T> implements Consumer {
            public final /* synthetic */ LarkLynxContainerBuilder a;
            public final /* synthetic */ sqb.c b;
            public final /* synthetic */ com.ss.android.lark.lynxkit.monitor.b c;

            public h(LarkLynxContainerBuilder r1, sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r4) {
                Throwable r5 = (Throwable) r4;
                Log.e(LarkLynxContainerBuilder.TAG, "ResourceLoader template load error", r5);
                LarkLynxContainerBuilder r0 = this.a;
                sqb.c r1 = this.b;
                com.ss.android.lark.lynxkit.monitor.b r2 = this.c;
                Intrinsics.checkNotNull(r5);
                LarkLynxContainerBuilder.access$monitorTemplateLoadError(r0, r1, r2, r5);
                sqb.a r3 = LarkLynxContainerBuilder.access$getTemplateLoadListener$p(this.a);
                if (r3 == null) goto L6;
                r3.onFailed(r5);
                return;
            }
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void destroy() {
            if (this.b == false) goto L5;
            return;
        L5:
            this.b = true;
            LarkLynxContainerBuilder.access$detachBridgeProtocol(this.f, this.d);
            this.d = null;
            this.c.dispose();
            com.ss.android.lark.lynxkit.container.a r0 = this.h;
            if (r0 == null) goto L8;
            r0.a.removeOnLayoutChangeListener(r0);
            r0.a.getOverlay().remove(r0.b);
        L8:
            this.e.destroy();
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void hide() {
            this.e.onEnterBackground();
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void render() {
            byte[] r1 = LarkLynxContainerBuilder.access$getTemplateByteArray$p(this.f);
            if (r1 == null) goto L5;
            LarkLynxContainerBuilder r10 = this.f;
            sqb.c r4 = this.g;
            LynxView r11 = this.e;
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(r10, r4, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_DATA, null, null, 12, null);
            r11.renderTemplateWithBaseUrl(r1, LarkLynxContainerBuilder.access$getInitData$p(r10), "");
            this.a = true;
            return;
        L5:
            LarkLynxContainerBuilder r2 = this.f;
            sqb.c r3 = this.g;
            LynxView r5 = this.e;
            if (TextUtils.isEmpty(LarkLynxContainerBuilder.access$getTemplateUrl$p(r2)) == true) goto L11;
            String r6 = LarkLynxContainerBuilder.access$getTemplateUrl$p(r2);
            if (r6 == null) goto L18;
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(r2, r3, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_URL, r6, null, 8, null);
            r5.renderTemplateUrl(r6, LarkLynxContainerBuilder.access$getInitData$p(r2));
            this.a = true;
            return;
        L18:
            return;
        L11:
            if (TextUtils.isEmpty(LarkLynxContainerBuilder.access$getTemplatePathForTemplateLoader$p(r2)) == true) goto L15;
            String r7 = LarkLynxContainerBuilder.access$getTemplatePathForTemplateLoader$p(r2);
            if (r7 == null) goto L20;
            com.ss.android.lark.lynxkit.monitor.b r8 = LarkLynxContainerBuilder.createMonitorInfoForRender$default(r2, r3, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_PATH, null, r7, 4, null);
            List<uqb.b> r9 = a(r3, r8);
            this.c.add(uqb.d.a(r7, r9).subscribe(new a(r2, r3, r8, r5), new C0171b(r2, r3, r8)));
            this.a = true;
            return;
        L20:
            return;
        L15:
            Log.e(LarkLynxContainerBuilder.TAG, "must set templateByteArray/templateUrl/templatePathForTemplateLoader before call render");
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void show() {
            this.e.onEnterForeground();
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final ILarkLynxBridgeProtocolHandle getBridgeProtocolHandle() {
            return this.d;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final View getLynxView() {
            return this.e;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final boolean hasRendered() {
            return this.a;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void resetData(String r2) {
            if (this.b == false) goto L5;
            return;
        L5:
            this.e.resetData(TemplateData.fromString(r2));
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void sendDataToJSByModule(List<? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r4, "data");
            JavaOnlyArray r5 = JavaOnlyArray.from(r4);
            String r0 = LarkLynxContainerBuilder.access$getTagForJSModule$p(this.f);
            if (r0 == null) goto L11;
            LynxView r1 = this.e;
            LarkLynxKitInitializer.Companion.getClass();
            if (LarkLynxKitInitializer.b.a().getJSModuleEntity$lark_lynx_kit_release(r0) == null) goto L10;
            Unit r2 = null;
            com.lynx.jsbridge.c r3 = r1.getJSModule(null);
            if (r3 == null) goto L9;
            r3.a(null, r5);
            r2 = Unit.INSTANCE;
        L9:
            if (r2 == null) goto L10;
            return;
        L10:
            Log.e(LarkLynxContainerBuilder.TAG, "jsModule tag " + r0 + " not exist");
            return;
        L11:
            com.lynx.jsbridge.c r6 = this.e.getJSModule("BDLynxAPIModule");
            if (r6 == null) goto L17;
            r6.a("trigger", r5);
            return;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateGlobalData(String r2) {
            Intrinsics.checkNotNullParameter(r2, "dataJson");
            this.e.updateGlobalProps(TemplateData.fromString(r2));
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateShareData(HashMap<String, Object> r3) {
            Intrinsics.checkNotNullParameter(r3, "shareData");
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r3);
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateGlobalData(Map<String, ? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "dataMap");
            this.e.updateGlobalProps(r2);
        }

        public final List<uqb.b> a(sqb.c r5, com.ss.android.lark.lynxkit.monitor.b r6) {
            String r0 = r5.b;     // Catch: Throwable -> L20
            boolean r1 = true;
            if (r0 != null) goto L5;
        L8:
            boolean r3 = true;
        L9:
            if (r3 == true) goto L23;
            LarkLynxKitInitializer.Companion.getClass();     // Catch: Throwable -> L20
            List<uqb.b> r2 = LarkLynxKitInitializer.b.a().getTemplateLoadersByTag$lark_lynx_kit_release(r0);     // Catch: Throwable -> L20
            List<uqb.b> r4 = r2;     // Catch: Throwable -> L20
            if (r4 != null) goto L13;
        L16:
            if (r1 == true) goto L19;
            return r2;
        L19:
            throw new IllegalStateException("can't find TemplateLoader,templateLoaders isNullOrEmpty, please call tagForTemplateLoader() first");     // Catch: Throwable -> L20
        L13:
            if (r4.isEmpty() == true) goto L16;
            r1 = false;
            goto L16
        L23:
            throw new IllegalStateException("can't find TemplateLoader,tagForTemplateLoader is empty");     // Catch: Throwable -> L20
        L5:
            if (r0.length() == 0) goto L8;
            r3 = false;
        L20:
            th = move-exception;
            LarkLynxContainerBuilder.access$monitorTemplateLoadError(this.f, r5, r6, th);
            throw th;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void reloadTemplate(String r3, Map<String, ? extends Object> r4) {
            if (this.b == false) goto L5;
            return;
        L5:
            if (r4 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r4);
        L7:
            this.e.reloadTemplate(TemplateData.fromString(r3), TemplateData.fromMap(r4));
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void sendGlobalEventToJS(String r4, List<? extends Object> r5) {
            Intrinsics.checkNotNullParameter(r4, "eventName");
            Intrinsics.checkNotNullParameter(r5, "data");
            if (TextUtils.isEmpty(r4) == false) goto L6;
            Log.e(LarkLynxContainerBuilder.TAG, "lynx callJS<<< call js error : no event name");
            return;
        L6:
            Log.i(LarkLynxContainerBuilder.TAG, "lynx callJS<<<callJS " + r4);
            this.e.sendGlobalEvent(r4, JavaOnlyArray.from(r5));
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateData(String r3, Map<String, ? extends Object> r4) {
            if (this.b == false) goto L5;
            return;
        L5:
            if (r4 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r4);
        L7:
            this.e.updateData(r3);
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateSize(int r2, int r3) {
            this.e.updateViewport(r2, r3);
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateTemplateData(TemplateData r3, Map<String, ? extends Object> r4) {
            if (this.b == false) goto L5;
            return;
        L5:
            if (r4 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r4);
        L7:
            this.e.updateData(r3);
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void updateData(Map<String, ? extends Object> r3, Map<String, ? extends Object> r4) {
            if (this.b == false) goto L5;
            return;
        L5:
            if (r4 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r4);
        L7:
            this.e.updateData(r3);
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void render(TemplateBundle r10, String r11, Map<String, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r10, "bundle");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_BUNDLE, null, null, 12, null);
            this.e.renderTemplateBundle(r10, TemplateData.fromString(r11), "");
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void renderByTemplateLoader(String r16, String r17, Map<String, ? extends Object> r18) {
            Intrinsics.checkNotNullParameter(r16, "templatePath");
            if (this.b == false) goto L5;
            return;
        L5:
            com.ss.android.lark.lynxkit.monitor.b r1 = LarkLynxContainerBuilder.createMonitorInfoForRender$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_PATH, null, r16, 4, null);
            List<uqb.b> r2 = a(this.g, r1);
            CompositeDisposable r3 = this.c;
            Single r4 = uqb.d.a(r16, r2);
            LarkLynxContainerBuilder r5 = this.f;
            sqb.c r6 = this.g;
            r3.add(r4.subscribe(new e(r5, r6, r1, r18, this.e, r17), new f(r5, r6, r1)));
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void renderByTemplateLoaderWithTemplateData(String r16, TemplateData r17, Map<String, ? extends Object> r18) {
            Intrinsics.checkNotNullParameter(r16, "templatePath");
            if (this.b == false) goto L5;
            return;
        L5:
            com.ss.android.lark.lynxkit.monitor.b r1 = LarkLynxContainerBuilder.createMonitorInfoForRender$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_PATH, null, r16, 4, null);
            List<uqb.b> r2 = a(this.g, r1);
            CompositeDisposable r3 = this.c;
            Single r4 = uqb.d.a(r16, r2);
            LarkLynxContainerBuilder r5 = this.f;
            sqb.c r6 = this.g;
            r3.add(r4.subscribe(new g(r5, r6, r1, r18, this.e, r17), new h(r5, r6, r1)));
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void renderWithTemplateData(TemplateBundle r10, TemplateData r11, Map<String, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r10, "bundle");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_BUNDLE, null, null, 12, null);
            this.e.renderTemplateBundle(r10, r11, "");
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void render(byte[] r10, String r11, Map<String, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r10, "templateData");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_DATA, null, null, 12, null);
            this.e.renderTemplateWithBaseUrl(r10, r11, "");
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void renderByTemplateLoader(String r16, Map<String, ? extends Object> r17, Map<String, ? extends Object> r18) {
            Intrinsics.checkNotNullParameter(r16, "templatePath");
            if (this.b == false) goto L5;
            return;
        L5:
            com.ss.android.lark.lynxkit.monitor.b r1 = LarkLynxContainerBuilder.createMonitorInfoForRender$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_PATH, null, r16, 4, null);
            List<uqb.b> r2 = a(this.g, r1);
            CompositeDisposable r3 = this.c;
            Single r4 = uqb.d.a(r16, r2);
            LarkLynxContainerBuilder r5 = this.f;
            sqb.c r6 = this.g;
            r3.add(r4.subscribe(new c(r5, r6, r1, r18, this.e, r17), new d(r5, r6, r1)));
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void renderWithTemplateData(String r10, TemplateData r11, Map<String, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r10, "templateUrl");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_URL, r10, null, 8, null);
            this.e.renderTemplateUrl(r10, r11);
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void render(String r10, String r11, Map<String, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r10, "templateUrl");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_URL, r10, null, 8, null);
            this.e.renderTemplateUrl(r10, r11);
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void render(String r10, Map<String, ? extends Object> r11, Map<String, ? extends Object> r12) {
            Intrinsics.checkNotNullParameter(r10, "templateUrl");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_URL, r10, null, 8, null);
            this.e.renderTemplateUrl(r10, r11);
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void render(byte[] r10, Map<String, ? extends Object> r11, Map<String, ? extends Object> r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "templateData");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_DATA, r13, null, 8, null);
            this.e.renderTemplateWithBaseUrl(r10, r11, r13);
            this.a = true;
        }

        @Override // com.ss.android.lark.lynxkit.container.ILarkLynxContainer
        public final void renderWithTemplateData(byte[] r10, TemplateData r11, Map<String, ? extends Object> r12, String r13) {
            Intrinsics.checkNotNullParameter(r10, "templateData");
            if (this.b == false) goto L5;
            return;
        L5:
            if (r12 == null) goto L7;
            LarkLynxContainerBuilder.access$configLynxContextShareData(this.f, this.e.getLynxContext(), r12);
        L7:
            LarkLynxContainerBuilder.updateMonitorRenderInfo$default(this.f, this.g, LarkLynxContainerBuilder.RENDER_SOURCE_TEMPLATE_DATA, r13, null, 8, null);
            this.e.renderTemplateWithBaseUrl(r10, r11, r13);
            this.a = true;
        }

        public b(ILarkLynxBridgeProtocolHandle r1, LynxView r2, LarkLynxContainerBuilder r3, sqb.c r4, com.ss.android.lark.lynxkit.container.a r5) {
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.c = new CompositeDisposable();
            this.d = r1;
        }
    }

    public static final class c extends q1 {
        public final /* synthetic */ sqb.c a;
        public final /* synthetic */ LarkLynxContainerBuilder b;

        public final void onLoadSuccess() {
            LynxKitMonitor r0 = LynxKitMonitor.a;
            sqb.c r1 = this.a;
            r0.d(r1.a, LarkLynxContainerBuilder.createMonitorInfo$default(this.b, r1, null, 2, null));
        }

        public final void onPageStart(String r6) {
            sqb.c r0 = this.a;
            r0.j = r6;
            LynxKitMonitor.a.e(r0.a, LarkLynxContainerBuilder.createMonitorInfo$default(this.b, r0, null, 2, null));
        }

        public final void onReceivedError(LynxError r7) {
            LynxKitMonitor r0 = LynxKitMonitor.a;
            sqb.c r1 = this.a;
            ILynxContainerContext r2 = r1.a;
            String r5 = null;
            com.ss.android.lark.lynxkit.monitor.b r3 = LarkLynxContainerBuilder.createMonitorInfo$default(this.b, r1, null, 2, null);
            if (r7 == null) goto L5;
            Integer r4 = Integer.valueOf(r7.getErrorCode());
        L6:
            if (r7 == null) goto L8;
            r5 = r7.getMsg();
        L8:
            r0.b(r2, r4, r5, r3);
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void onTimingSetup(Map<String, Object> r7) {
            LynxKitMonitor r0 = LynxKitMonitor.a;
            sqb.c r1 = this.a;
            LynxKitMonitor.c(r1.a, LynxKitMonitor.TimingType.SETUP_TIMING, r7, LarkLynxContainerBuilder.createMonitorInfo$default(this.b, r1, null, 2, null));
        }

        public c(sqb.c r1, LarkLynxContainerBuilder r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onTimingUpdate(Map<String, Object> r5, Map<String, Long> r6, String r7) {
            LynxKitMonitor r8 = LynxKitMonitor.a;
            sqb.c r9 = this.a;
            LynxKitMonitor.c(r9.a, LynxKitMonitor.TimingType.UPDATE_TIMING, r5, LarkLynxContainerBuilder.createMonitorInfo$default(this.b, r9, null, 2, null));
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public final LarkLynxContainerBuilder bridgeModule(rqb.b r2) {
        Intrinsics.checkNotNullParameter(r2, "module");
        return this;
    }

    private final sqb.c createMonitorState() {
        return new sqb.c(this.lynxContainerContext, this.tagForTemplateLoader, this.tagForJSModule, this.tagForBridgeMethodDispatcher, this.tagForBridgeMethodGroup, this.tagForCustomComponent);
    }

    private final ILarkLynxBridgeProtocol resolveBridgeProtocol() {
        ILarkLynxBridgeProtocol r0 = this.bridgeProtocol;
        if (r0 == null) goto L5;
        return r0;
    L5:
        String r1 = this.tagForBridgeProtocol;
        if (r1 != null) goto L9;
        return null;
    L9:
        LarkLynxKitInitializer.Companion.getClass();
        ILarkLynxBridgeProtocol r2 = LarkLynxKitInitializer.b.a().getBridgeProtocolByTag$lark_lynx_kit_release(r1);
        if (r2 != null) goto L12;
        Log.e(TAG, "bridge protocol tag " + r1 + " not exist");
    L12:
        return r2;
    }

    public final ILarkLynxContainer build() {
        LarkLynxKitInitializer.Companion.getClass();
        LarkLynxKitInitializer.b.a();
        sqb.c r0 = createMonitorState();
        LynxViewBuilder r1 = new LynxViewBuilder();
        ILarkLynxBridgeProtocol r2 = resolveBridgeProtocol();
        String r3 = resolveBridgeProtocolContainerId(r2);
        Iterator<Map.Entry<String, k<?, ?>>> r4 = this.resourceProviders.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, k<?, ?>> r5 = r4.next();
        r1.setResourceProvider(r5.getKey(), r5.getValue());
        goto L4
    L6:
        k7a.a r6 = this.dynamicComponentFetcher;
        if (r6 == null) goto L9;
        r1.setDynamicComponentFetcher(r6);
    L9:
        String r7 = this.tagForCustomComponent;
        if (r7 == null) goto L14;
        LarkLynxKitInitializer.Companion.getClass();
        List<com.lynx.tasm.behavior.a> r8 = LarkLynxKitInitializer.b.a().getCustomComponentsByTag$lark_lynx_kit_release(r7);
        if (r8 == null) goto L14;
        r1.addBehaviors(r8);
    L14:
        String r9 = this.tagForJsContext;
        if (r9 == null) goto L20;
        LarkLynxKitInitializer.Companion.getClass();
        LynxGroup r10 = LarkLynxKitInitializer.b.a().getLynxGroupByTag$lark_lynx_kit_release(r9);
        if (r10 == null) goto L20;
        r1.setLynxGroup(r10);
    L20:
        if (TextUtils.isEmpty(this.templatePathForTemplateLoader) == false) goto L22;
    L26:
        r1.registerModule(LarkLynxBridgeModule.LYNX_MODULE_NAME, LarkLynxBridgeModule.class, new LarkBridgeModuleEntity(this.context, this.lynxContainerContext, this.tagForBridgeMethodDispatcher, this.tagForBridgeMethodGroup, this.tagForJSModule));
        Integer r11 = this.widthMeasureSpec;
        if (r11 == null) goto L34;
        int r12 = r11.intValue();
        Integer r13 = this.heightMeasureSpec;
        if (r13 == null) goto L31;
        int r14 = r13.intValue();
    L32:
        r1.setPresetMeasuredSpec(r12, r14);
        goto L34
    L31:
        r14 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L34:
        if (this.enableAsyncRender == false) goto L36;
    L37:
        r1.setThreadStrategyForRendering(ThreadStrategyForRendering.MULTI_THREADS);
        r1.setEnableCreateViewAsync(true);
        if (this.enableAsyncRenderForList == false) goto L40;
        r1.setEnableSyncFlush(true);
    L40:
        r1.setEnableUserBytecode(this.enableUserCodeCache);
        String r15 = this.codeCacheSourceUrl;
        if (r15 == null) goto L43;
        r1.setBytecodeSourceUrl(r15);
    L43:
        Iterator<Map.Entry<String, k<Object, Object>>> r16 = this.providers.entrySet().iterator();
    L45:
        if (r16.hasNext() == false) goto L47;
        Map.Entry<String, k<Object, Object>> r17 = r16.next();
        r1.setResourceProvider(r17.getKey(), r17.getValue());
        goto L45
    L47:
        int r18 = com.larksuite.framework.utils.autoscale.a.a;
        initDevTool(r1);
        ILarkLynxBridgeProtocolBuilderHandle r19 = configureBridgeProtocol(r2, r1, r3);
        ce6.b r20 = new ce6.b();
        Float r21 = this.fontScale;
        if (r21 == null) goto L79;
        r1.setFontScale(r21.floatValue());
    L79:
        LynxView r22 = r1.build(this.context);     // Catch: Throwable -> L76
        configLynxContextShareData(r22.getLynxContext(), this.shareDataMap);     // Catch: Throwable -> L76
        r22.setImageInterceptor(this.imageInterceptor);     // Catch: Throwable -> L76
        r20.b = new WeakReference(r22.getLynxContext());     // Catch: Throwable -> L76
        LynxKryptonHelper r23 = LynxKryptonUtils.getLynxKryptonHelper(r22);     // Catch: Throwable -> L73
        if (r23 == null) goto L54;
        r23.registerService(KryptonLoaderService.class, r20);     // Catch: Throwable -> L73
    L54:
        String r24 = this.tagForGlobalData;     // Catch: Throwable -> L73
        if (r24 == null) goto L59;
        LarkLynxKitInitializer.Companion.getClass();     // Catch: Throwable -> L73
        Map<String, Object> r25 = LarkLynxKitInitializer.b.a().getGlobalDataByTag$lark_lynx_kit_release(r24);     // Catch: Throwable -> L73
        if (r25 == null) goto L59;
        r22.updateGlobalProps(r25);     // Catch: Throwable -> L73
    L59:
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L73
        configLynxViewLifeCycle(r22, r0);     // Catch: Throwable -> L73
        ILarkLynxBridgeProtocolHandle r26 = attachBridgeProtocol(r2, r22, r3, r19);     // Catch: Throwable -> L73
        if (r26 != null) goto L65;
        if (r19 == null) goto L65;
        disposeBridgeProtocolBuilderHandle(r19);
        r22.destroy();
        throw new IllegalStateException("bridge protocol attach returned null after builder handle created");
    L65:
        if (r26 != null) goto L67;
        disposeBridgeProtocolBuilderHandle(r19);
    L67:
        int r27 = com.ss.android.lark.lynxkit.container.a.c;
        Intrinsics.checkNotNullParameter(r22, "lynxView");
        if (DevEnvUtil.isDevelopPackage(r22.getContext()) == true) goto L70;
        com.ss.android.lark.lynxkit.container.a r28 = null;
    L72:
        return createContainer(r22, r26, r0, r28);
    L70:
        r28 = new com.ss.android.lark.lynxkit.container.a(r22, new sqb.b(r22, "Lynx View(" + LynxEnv.inst().getLynxVersion() + ')'));
    L73:
        th = move-exception;
        disposeBridgeProtocolBuilderHandle(r19);
        r22.destroy();
        throw th;
    L76:
        th = move-exception;
        disposeBridgeProtocolBuilderHandle(r19);
        throw th;
    L36:
        if (this.enableAsyncRenderForList == false) goto L40;
    L22:
        if (TextUtils.isEmpty(this.tagForTemplateLoader) == false) goto L26;
        throw new IllegalStateException("tagForTemplateLoader can't be empty, when templatePathForTemplateLoader isn't empty");
    }

    private final void configureDevToolSettings() {
        DevToolSettings r0 = DevToolSettings.inst();
        int r1 = 0;
        r0.setLongPressMenuEnabled(false);
        r0.setLogBoxEnabled(false);
        String[] r2 = {"enable_cdp_domain_dom", "enable_cdp_domain_css", "enable_cdp_domain_page"};
    L4:
        if (r1 >= 3) goto L6;
        r0.setCDPDomainEnabled(r2[r1], true);
        r1 = r1 + 1;
        goto L4
    }

    public final Map<String, k<?, ?>> getResourceProviders() {
        return this.resourceProviders;
    }

    public LarkLynxContainerBuilder(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.providers = new HashMap();
        this.shareDataMap = new HashMap();
        this.resourceProviders = new HashMap();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_lark_lynxkit_container_LarkLynxContainerBuilder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static final /* synthetic */ TemplateData access$getInitData$p(LarkLynxContainerBuilder r0) {
        return r0.initData;
    }

    public static final /* synthetic */ String access$getTagForJSModule$p(LarkLynxContainerBuilder r0) {
        return r0.tagForJSModule;
    }

    public static final /* synthetic */ byte[] access$getTemplateByteArray$p(LarkLynxContainerBuilder r0) {
        return r0.templateByteArray;
    }

    public static final /* synthetic */ sqb.a access$getTemplateLoadListener$p(LarkLynxContainerBuilder r0) {
        return r0.templateLoadListener;
    }

    public static final /* synthetic */ String access$getTemplatePathForTemplateLoader$p(LarkLynxContainerBuilder r0) {
        return r0.templatePathForTemplateLoader;
    }

    public static final /* synthetic */ String access$getTemplateUrl$p(LarkLynxContainerBuilder r0) {
        return r0.templateUrl;
    }

    private final q1 createMonitorLynxViewClient(sqb.c r2) {
        return new c(r2, this);
    }

    private final String createTemplateLoadErrorMessage(Throwable r3) {
        String r0 = r3.getClass().getSimpleName();
        Intrinsics.checkNotNull(r0);
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L12;
        r0 = r3.getClass().getName();
    L12:
        return "template load failed: ".concat(r0);
    L5:
        r1 = false;
        goto L6
    }

    private final void detachBridgeProtocol(ILarkLynxBridgeProtocolHandle r3) {
        if (r3 == null) goto L10;
        r3.detach();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(TAG, "detach bridge protocol failed", th);
        return;
    }

    private final void disposeBridgeProtocolBuilderHandle(ILarkLynxBridgeProtocolBuilderHandle r3) {
        if (r3 == null) goto L10;
        r3.dispose();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e(TAG, "dispose bridge protocol builder handle failed", th);
        return;
    }

    private final void initDevTool(LynxViewBuilder r10) {
        if (this.enableDevToolsDebug == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.devToolSocketUrl) == true) goto L24;
        LynxEnv.inst().enableLynxDebug(true);
        LynxEnv.inst().initDevtool();
        LynxEnv.inst().enableDevtool(false);
        configureDevToolSettings();
        Class r1 = INVOKESTATIC_com_ss_android_lark_lynxkit_container_LarkLynxContainerBuilder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.debugrouter.DebugRouter");     // Catch: Exception -> L10
        Object r4 = r1.getMethod("getInstance", new Class[0]).invoke(r1, new Object[0]);     // Catch: Exception -> L10
        r1.getMethod("setConfig", new Class[]{String.class, Boolean.TYPE}).invoke(r4, new Object[]{"debugrouter_forbid_reconnect_on_close", Boolean.TRUE});     // Catch: Exception -> L10
        Log.i(TAG, "DebugRouterSetConfig");     // Catch: Exception -> L10
    L12:
        r10.setDebuggable(true);
        if (LynxDevtoolGlobalHelper.getInstance().shouldPrepareRemoteDebug(this.devToolSocketUrl) == true) goto L15;
        return;
    L15:
        if (LynxDevtoolGlobalHelper.getInstance().prepareRemoteDebug(this.devToolSocketUrl) == false) goto L17;
        Log.i(TAG, "devtool web socket connect success");
        return;
    L17:
        Log.i(TAG, "devtool web socket connect fail");
        return;
    L10:
        e = move-exception;
        Log.e(TAG, "Exception", e);
        goto L12
    }

    private final String resolveBridgeProtocolContainerId(ILarkLynxBridgeProtocol r3) {
        String r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        String r4 = this.bridgeProtocolContainerId;
        if (r4 == null) goto L15;
        if (r4.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        r0 = r4;
    L13:
        if (r0 == null) goto L15;
        return r0;
    L10:
        r1 = false;
    L15:
        return "lark_lynx_" + UUID.randomUUID();
    }

    public final LarkLynxContainerBuilder bridgeProtocol(ILarkLynxBridgeProtocol r2) {
        Intrinsics.checkNotNullParameter(r2, "protocol");
        this.bridgeProtocol = r2;
        return this;
    }

    public final LarkLynxContainerBuilder bridgeProtocolContainerId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "containerId");
        this.bridgeProtocolContainerId = r2;
        return this;
    }

    public final LarkLynxContainerBuilder bridgeRuntimeFactory(ILarkLynxBridgeRuntimeFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        this.bridgeProtocol = new LarkLynxBridgeRuntimeProtocol(r2);
        return this;
    }

    public final LarkLynxContainerBuilder containerContext(ILynxContainerContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.lynxContainerContext = r2;
        return this;
    }

    public final LarkLynxContainerBuilder devToolSocketUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.devToolSocketUrl = r2;
        return this;
    }

    public final LarkLynxContainerBuilder enableAsyncRender(boolean r1) {
        this.enableAsyncRender = r1;
        return this;
    }

    public final LarkLynxContainerBuilder enableAsyncRenderForList(boolean r1) {
        this.enableAsyncRenderForList = r1;
        return this;
    }

    public final LarkLynxContainerBuilder enableDevToolsDebug(boolean r1) {
        this.enableDevToolsDebug = r1;
        return this;
    }

    public final LarkLynxContainerBuilder fontScale(float r1) {
        this.fontScale = Float.valueOf(r1);
        return this;
    }

    public final LarkLynxContainerBuilder heightMeasureSpec(int r1) {
        this.heightMeasureSpec = Integer.valueOf(r1);
        return this;
    }

    public final LarkLynxContainerBuilder imageLoader(m r2) {
        Intrinsics.checkNotNullParameter(r2, "interpolator");
        this.imageInterceptor = r2;
        return this;
    }

    public final LarkLynxContainerBuilder initData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "initDataJson");
        this.initData = TemplateData.fromString(r2);
        return this;
    }

    public final LarkLynxContainerBuilder lynxViewLifeCycle(q1 r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxViewClient");
        this.lynxViewClient = r2;
        return this;
    }

    public final LarkLynxContainerBuilder setCodeCacheSourceUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sourceUrl");
        this.codeCacheSourceUrl = r2;
        return this;
    }

    public final LarkLynxContainerBuilder setDynamicComponentFetcher(k7a.a r2) {
        Intrinsics.checkNotNullParameter(r2, "fetcher");
        this.dynamicComponentFetcher = r2;
        return this;
    }

    public final LarkLynxContainerBuilder setEnableUserCodeCache(boolean r1) {
        this.enableUserCodeCache = r1;
        return this;
    }

    public final LarkLynxContainerBuilder tagForBridgeMethodDispatcher(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatcherTag");
        this.tagForBridgeMethodDispatcher = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForBridgeMethodGroup(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bridgeGroupTag");
        this.tagForBridgeMethodGroup = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForBridgeProtocol(String r2) {
        Intrinsics.checkNotNullParameter(r2, "protocolTag");
        this.tagForBridgeProtocol = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForCustomComponent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tagForCustomComponent = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForGlobalData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tagForGlobalData = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForJSModule(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tagForJSModule = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForJsContext(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tagForJsContext = r2;
        return this;
    }

    public final LarkLynxContainerBuilder tagForTemplateLoader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.tagForTemplateLoader = r2;
        return this;
    }

    public final LarkLynxContainerBuilder templateData(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "byteArray");
        this.templateByteArray = r2;
        return this;
    }

    public final LarkLynxContainerBuilder templateLoadListener(sqb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "templateLoadListener");
        this.templateLoadListener = r2;
        return this;
    }

    public final LarkLynxContainerBuilder templatePathForTemplateLoader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "templatePath");
        this.templatePathForTemplateLoader = r2;
        return this;
    }

    public final LarkLynxContainerBuilder templateUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        this.templateUrl = r2;
        return this;
    }

    public final LarkLynxContainerBuilder widthMeasureSpec(int r1) {
        this.widthMeasureSpec = Integer.valueOf(r1);
        return this;
    }

    public final LarkLynxContainerBuilder initData(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "initDataMap");
        this.initData = TemplateData.fromMap(r2);
        return this;
    }

    public static final /* synthetic */ void access$detachBridgeProtocol(LarkLynxContainerBuilder r0, ILarkLynxBridgeProtocolHandle r1) {
        r0.detachBridgeProtocol(r1);
    }

    private final void applyMonitorInfo(sqb.c r2, com.ss.android.lark.lynxkit.monitor.b r3) {
        r2.i = r3.d;
        r2.g = r3.a;
        r2.h = r3.b;
        r2.j = r3.c;
    }

    private final void configLynxContextShareData(LynxContext r3, Map<String, ? extends Object> r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r0 = r5.next();
        r3.putSharedData(r0.getKey(), r0.getValue());
        goto L6
    }

    private final void configLynxViewLifeCycle(LynxView r1, sqb.c r2) {
        r1.addLynxViewClient(createMonitorLynxViewClient(r2));
        q1 r3 = this.lynxViewClient;
        if (r3 == null) goto L6;
        r1.addLynxViewClient(r3);
        return;
    }

    private final com.ss.android.lark.lynxkit.monitor.b createMonitorInfo(sqb.c r12, String r13) {
        return new com.ss.android.lark.lynxkit.monitor.b(r12.g, r12.h, r13, r12.i, r12.b, r12.c, r12.d, r12.e, r12.f);
    }

    public final LarkLynxContainerBuilder lynxContextShareData(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "data");
        this.shareDataMap.put(r2, r3);
        return this;
    }

    public final LarkLynxContainerBuilder setResourceProvider(String r2, k<?, ?> r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.resourceProviders.put(r2, r3);
        return this;
    }

    public static final /* synthetic */ void access$applyMonitorInfo(LarkLynxContainerBuilder r0, sqb.c r1, com.ss.android.lark.lynxkit.monitor.b r2) {
        r0.applyMonitorInfo(r1, r2);
    }

    public static final /* synthetic */ void access$configLynxContextShareData(LarkLynxContainerBuilder r0, LynxContext r1, Map r2) {
        r0.configLynxContextShareData(r1, r2);
    }

    private final ILarkLynxBridgeProtocolBuilderHandle configureBridgeProtocol(ILarkLynxBridgeProtocol r4, LynxViewBuilder r5, String r6) {
        if ((r4 instanceof ILarkLynxBridgeProtocolBuilderConfigurator) == false) goto L5;
        ILarkLynxBridgeProtocolBuilderConfigurator r7 = (ILarkLynxBridgeProtocolBuilderConfigurator) r4;
    L6:
        if (r7 != null) goto L8;
        return null;
    L8:
        if (r6 != null) goto L15;
        return null;
    L15:
        return r7.configure(new LarkLynxBridgeProtocolBuilderContext(this.context, r5, r6, this.lynxContainerContext));
    L12:
        th = move-exception;
        Log.e(TAG, "configure bridge protocol failed", th);
        throw th;
    L5:
        r7 = null;
        goto L6
    }

    private final void monitorTemplateLoadError(sqb.c r3, com.ss.android.lark.lynxkit.monitor.b r4, Throwable r5) {
        LynxKitMonitor.a.b(r3.a, null, createTemplateLoadErrorMessage(r5), r4);
    }

    public static final /* synthetic */ void access$monitorTemplateLoadError(LarkLynxContainerBuilder r0, sqb.c r1, com.ss.android.lark.lynxkit.monitor.b r2, Throwable r3) {
        r0.monitorTemplateLoadError(r1, r2, r3);
    }

    private final ILarkLynxBridgeProtocolHandle attachBridgeProtocol(ILarkLynxBridgeProtocol r8, LynxView r9, String r10, ILarkLynxBridgeProtocolBuilderHandle r11) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r10 != null) goto L12;
        return null;
    L12:
        return r8.attach(new LarkLynxBridgeProtocolContext(this.context, r9, r10, r11, this.lynxContainerContext));
    L9:
        th = move-exception;
        Log.e(TAG, "attach bridge protocol failed", th);
        throw th;
    }

    private final ILarkLynxContainer createContainer(LynxView r8, ILarkLynxBridgeProtocolHandle r9, sqb.c r10, com.ss.android.lark.lynxkit.container.a r11) {
        return new b(r9, r8, this, r10, r11);
    }

    private final com.ss.android.lark.lynxkit.monitor.b createMonitorInfoForRender(sqb.c r12, String r13, String r14, String r15) {
        return new com.ss.android.lark.lynxkit.monitor.b(r14, r15, r13, r12.b, r12.c, r12.d, r12.e, r12.f, 4);
    }

    private final com.ss.android.lark.lynxkit.monitor.b updateMonitorRenderInfo(sqb.c r1, String r2, String r3, String r4) {
        r1.i = r2;
        r1.g = r3;
        r1.h = r4;
        r1.j = null;
        return createMonitorInfo$default(this, r1, null, 2, null);
    }

    public static com.ss.android.lark.lynxkit.monitor.b createMonitorInfo$default(LarkLynxContainerBuilder r0, sqb.c r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r1.j;
    L6:
        return r0.createMonitorInfo(r1, r2);
    }

    public static /* synthetic */ com.ss.android.lark.lynxkit.monitor.b createMonitorInfoForRender$default(LarkLynxContainerBuilder r1, sqb.c r2, String r3, String r4, String r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.createMonitorInfoForRender(r2, r3, r4, r5);
    }

    public static /* synthetic */ com.ss.android.lark.lynxkit.monitor.b updateMonitorRenderInfo$default(LarkLynxContainerBuilder r1, sqb.c r2, String r3, String r4, String r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = null;
    L9:
        return r1.updateMonitorRenderInfo(r2, r3, r4, r5);
    }
}
