package com.bytedance.android.annie.lynx;

import a9.j;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.annie.lynx.bridge.AnnieLynxBridgeModule;
import com.bytedance.android.annie.lynx.resource.LynxExternalJSProvider;
import com.bytedance.android.annie.lynx.resource.LynxTemplateProvider;
import com.bytedance.android.annie.lynx.resource.VerifyTemplateType;
import com.bytedance.android.annie.lynx.resource.h;
import com.bytedance.android.annie.param.k;
import com.bytedance.android.annie.param.l;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.android.annie.service.AnnieNGServiceCenter;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.preload.PreLoadUtils;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.resource.g;
import com.bytedance.android.annie.service.resource.i;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.annie.util.p;
import com.bytedance.crash.Npth;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.xml.transform.Transformer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n*\u0002\u0098\u0001\b\u0001\u0018\u0000 \u009d\u00012\u00020\u00012\u00020\u0002:\u0006\u009e\u0001\u009f\u0001 \u0001B3\u0012\u0006\u0010[\u001a\u00020Z\u0012\b\u0010]\u001a\u0004\u0018\u00010;\u0012\u0006\u0010_\u001a\u00020T\u0012\u0006\u0010b\u001a\u00020a\u0012\u0006\u0010e\u001a\u00020d¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J.\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J*\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00032\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0003J4\u0010\u001f\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u00032\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002J.\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\"2\b\b\u0002\u0010!\u001a\u00020 2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0002J4\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0017\u001a\u00020\u00032\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\u0012\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010*\u001a\u00020\u0003*\u0004\u0018\u00010\u0003H\u0002J&\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J.\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002J\u001a\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013*\u00020.H\u0002J>\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\"2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00032\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0002J\u0010\u00103\u001a\u0002022\u0006\u00101\u001a\u00020\u000fH\u0002J\n\u00104\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u00107\u001a\u0002062\b\u00105\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u00108\u001a\u00020 H\u0002J\b\u00109\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020\u0005H\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020;H\u0016J\u001e\u0010>\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0016J \u0010?\u001a\u00020\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016J\b\u0010@\u001a\u00020\u0003H\u0016J\u0018\u0010C\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0016J*\u0010E\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016J \u0010G\u001a\u00020\u00052\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0016J\b\u0010H\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u00020\u0005H\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020\u0005H\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\n\u0010O\u001a\u0004\u0018\u00010NH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010PH\u0016J\b\u0010R\u001a\u00020\u0005H\u0016J\b\u0010S\u001a\u00020\u0005H\u0016J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010U\u001a\u00020TH\u0016J\b\u0010W\u001a\u00020 H\u0016J\b\u0010X\u001a\u00020 H\u0016J\b\u0010Y\u001a\u00020 H\u0016R\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010_\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010g\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010i\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020o0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010r\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010t\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010w\u001a\u00060vR\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010z\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0017\u0010\u0080\u0001\u001a\u00020\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008f\u0001\u001a\u000b \u008a\u0001*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R)\u0010\u0092\u0001\u001a\u000b \u008a\u0001*\u0004\u0018\u00010 0 8BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u008c\u0001\u001a\u0006\b\u0091\u0001\u0010\u008e\u0001R7\u0010\u0096\u0001\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u0001j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0005\u0012\u00030\u0094\u0001`\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/android/annie/lynx/LynxComponent;", "Lcom/bytedance/android/annie/card/base/BaseHybridComponent;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "getForestSessionID", "", "initTemplateProviderCallback", "Lcom/lynx/tasm/LynxViewBuilder;", "lynxViewBuilder", "bindLynxModule", "Lcom/lynx/tasm/LynxView;", "createLynxViewAndBridge", "view", "realAddOnPreDrawListener", "Lkotlin/Pair;", "", "getViewPort", "getRealPair", "preLynxViewCreate", "", "", "data", "wrapperUpdateGlobalProps", com.bytedance.android.ec.core.event.a.KEY_URL, "setUrl", "getUrl", "appendUrlQuery", "otherParams", "realLoad", "", "templateFromLocal", "handleLocalTemplate", "", "isOffline", "", "getGlobalPropsParamsInternal", "template", "renderTemplate", "updateReportingEventsParamsForLynxView", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "generatePageIdWithSchema", "schemaStringByRemovingQueryAndFragment", "orUnknown", "createGlobalProps", "globalProps", "removeBlackKey", "Lcom/bytedance/android/annie/param/k;", "toMap", "getRenderData", "strategy", "Lcom/lynx/tasm/ThreadStrategyForRendering;", "getThreadStrategy", "getSchema", com.bytedance.android.ec.core.event.a.KEY_SCHEME, "Lcom/google/gson/JsonObject;", "getQueryItem", "enableAdapterFontScale", "enableViewZoom", "addOnPreDrawListener", "Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;", "params", "updateHybridParamsNew", "updateData", "updateGlobalProps", "getBizKey", "width", "height", "updateScreenMetrics", "renderData", "load", "templateData", "reloadTemplate", "show", "hide", "Lcom/bytedance/android/annie/api/card/IHybridComponent$HybridType;", "hybridType", com.bytedance.android.ec.core.event.a.VALUE_CLOSE, "release", "Lcom/bytedance/android/annie/bridge/JSBridgeManager;", "getJSBridgeManger", "Landroid/view/View;", "getView", "onResume", "onPause", "Lcom/bytedance/android/annie/card/base/b;", "lifecycleCallback", "registerLifecycleCallback", "onPreDraw", "isPopup", "isAnnieXComponent", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "mCardParamVoNew", "Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;", "mInitializeLifecycle", "Lcom/bytedance/android/annie/card/base/b;", "Lj9/a;", "monitorProvider", "Lj9/a;", "Lcom/bytedance/android/annie/param/a;", "mAnnieContext", "Lcom/bytedance/android/annie/param/a;", "mLynxView", "Lcom/lynx/tasm/LynxView;", "mJSBridgeManager", "Lcom/bytedance/android/annie/bridge/JSBridgeManager;", "Lc8/b;", "mBridgeImpl", "Lc8/b;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/bytedance/android/annie/lynx/f;", "mLifecycleCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "mPresetWidth", "I", "mIsOffline", "Z", "Lcom/bytedance/android/annie/lynx/LynxComponent$b;", "mLynxJsBridgeListenerProxy", "Lcom/bytedance/android/annie/lynx/LynxComponent$b;", "Lcom/bytedance/android/annie/lynx/resource/LynxTemplateProvider;", "templateProvider", "Lcom/bytedance/android/annie/lynx/resource/LynxTemplateProvider;", "Lcom/bytedance/android/annie/lynx/resource/d;", "dynamicComponentProvider", "Lcom/bytedance/android/annie/lynx/resource/d;", "Lcom/bytedance/android/annie/lynx/resource/LynxExternalJSProvider;", "externalJsProvider", "Lcom/bytedance/android/annie/lynx/resource/LynxExternalJSProvider;", "Lcom/bytedance/android/annie/service/resource/g;", "loaderConfig", "Lcom/bytedance/android/annie/service/resource/g;", "Lcom/bytedance/android/annie/lynx/resource/h;", "xResourceLoader", "Lcom/bytedance/android/annie/lynx/resource/h;", "mGlobalPropsParams", "Lcom/bytedance/android/annie/param/k;", "kotlin.jvm.PlatformType", "useForestLoadImg$delegate", "Lkotlin/Lazy;", "getUseForestLoadImg", "()Ljava/lang/Boolean;", "useForestLoadImg", "tryFixViewSizeOnPreDraw$delegate", "getTryFixViewSizeOnPreDraw", "tryFixViewSizeOnPreDraw", "Ljava/util/HashMap;", "Lcom/bytedance/android/annie/service/resource/i;", "Lkotlin/collections/HashMap;", "imageCache", "Ljava/util/HashMap;", "com/bytedance/android/annie/lynx/LynxComponent$d", "intercept", "Lcom/bytedance/android/annie/lynx/LynxComponent$d;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/annie/scheme/vo/refactor/CardParamVoNew;Lcom/bytedance/android/annie/card/base/b;Lj9/a;Lcom/bytedance/android/annie/param/a;)V", "Companion", "AnnieLynxViewClient", "a", "b", "annie-lynx_release"}, k = 1, mv = {1, 4, 3})
public final class LynxComponent extends BaseHybridComponent implements ViewTreeObserver.OnPreDrawListener {
    public static final a Companion = null;
    private static final String TAG = "LynxComponent";
    private static final String UNKNOWN = "unknown";
    private final com.bytedance.android.annie.lynx.resource.d dynamicComponentProvider;
    private final LynxExternalJSProvider externalJsProvider;
    private final HashMap<String, i> imageCache;
    private final d intercept;
    private final g loaderConfig;
    private final com.bytedance.android.annie.param.a mAnnieContext;
    private c8.b mBridgeImpl;
    private CardParamVoNew mCardParamVoNew;
    private final Context mContext;
    private volatile k mGlobalPropsParams;
    private final com.bytedance.android.annie.card.base.b mInitializeLifecycle;
    private boolean mIsOffline;
    private final JSBridgeManager mJSBridgeManager;
    private final ConcurrentLinkedQueue<f> mLifecycleCallbacks;
    private final b mLynxJsBridgeListenerProxy;
    private final LynxView mLynxView;
    private int mPresetWidth;
    private final j9.a monitorProvider;
    private final LynxTemplateProvider templateProvider;
    private final Lazy tryFixViewSizeOnPreDraw$delegate;
    private final Lazy useForestLoadImg$delegate;
    private final h xResourceLoader;

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016JF\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0014\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\u001e\u0010)\u001a\u00020\u00042\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J>\u0010-\u001a\u00020\u00042\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*\u0018\u00010&2\b\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016¨\u00060"}, d2 = {"Lcom/bytedance/android/annie/lynx/LynxComponent$AnnieLynxViewClient;", "Lcom/lynx/tasm/q1;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "", "onPageStart", "onLoadSuccess", com.bytedance.android.ec.core.event.a.KEY_MSG, "onLoadFailed", "Landroid/content/Context;", "context", "cacheKey", "src", "", "width", "height", "Ljavax/xml/transform/Transformer;", "transformer", "Lcom/lynx/tasm/behavior/m$a;", "handler", "loadImage", "onFirstScreen", "Lcom/lynx/tasm/LynxError;", IHostStyleUIDepend.TOAST_TYPE_ERROR, "onReceivedError", "onRuntimeReady", "Lcom/lynx/tasm/v0;", "metric", "onFirstLoadPerfReady", "onUpdatePerfReady", "onPageUpdate", "onLynxViewAndJSRuntimeDestroy", "shouldRedirectImageUrl", "Lcom/lynx/tasm/q1$b;", "info", "onScrollStart", "onScrollStop", "onUpdateDataWithoutChange", "", "", "timingInfo", "onTimingSetup", "", "updateTiming", "flag", "onTimingUpdate", "<init>", "(Lcom/bytedance/android/annie/lynx/LynxComponent;)V", "annie-lynx_release"}, k = 1, mv = {1, 4, 3})
    public final class AnnieLynxViewClient extends q1 {
        final /* synthetic */ LynxComponent this$0;

        public void onFirstScreen() {
            super.onFirstScreen();
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r10 = r0.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((f) r10.next()).n(LynxComponent.access$getMLynxView$p(r1));
            goto L4
        L6:
            x8.b r11 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r12 = new StringBuilder("===onFirstScreen: ");
            String r13 = LynxComponent.access$getUrl(this.this$0);
            if (r13 != null) goto L9;
            r13 = "empty";
        L9:
            r12.append(r13);
            r12.append("===");
            r11.f(LynxComponent.TAG, "on_first_screen", r12.toString());
        }

        public void onLoadSuccess() {
            super.onLoadSuccess();
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r10 = r0.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((f) r10.next()).e(LynxComponent.access$getMLynxView$p(r1));
            goto L4
        L6:
            x8.b r11 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r12 = new StringBuilder("===onLoadSuccess: ");
            String r13 = LynxComponent.access$getUrl(this.this$0);
            if (r13 != null) goto L9;
            r13 = "empty";
        L9:
            r12.append(r13);
            r12.append("===");
            r11.f(LynxComponent.TAG, "on_load_success", r12.toString());
        }

        public void onLynxViewAndJSRuntimeDestroy() {
            super.onLynxViewAndJSRuntimeDestroy();
            LynxComponent.access$getMJSBridgeManager$p(this.this$0).release();
        }

        public void onPageUpdate() {
            super.onPageUpdate();
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r10 = r0.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((f) r10.next()).o(LynxComponent.access$getMLynxView$p(r1));
            goto L4
        }

        public void onRuntimeReady() {
            super.onRuntimeReady();
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r10 = r0.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            ((f) r10.next()).g(LynxComponent.access$getMLynxView$p(r1), LynxComponent.access$getUrl(r1));
            goto L4
        L6:
            x8.b r11 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r12 = new StringBuilder("===onRuntimeReady: ");
            String r13 = LynxComponent.access$getUrl(this.this$0);
            if (r13 != null) goto L9;
            r13 = "empty";
        L9:
            r12.append(r13);
            r12.append("===");
            r11.f(LynxComponent.TAG, "on_runtime_ready", r12.toString());
        }

        public void onUpdateDataWithoutChange() {
            super.onUpdateDataWithoutChange();
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r10 = r0.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            f r11 = (f) r10.next();
            LynxView r12 = LynxComponent.access$getMLynxView$p(r1);
            r11.getClass();
            Intrinsics.checkNotNullParameter(r12, "lynxView");
            goto L4
        }

        public AnnieLynxViewClient(LynxComponent r1) {
            this.this$0 = r1;
        }

        public void onFirstLoadPerfReady(v0 r10) {
            if (AnnieConfigSettingKeys.SEND_LYNX_PERF_EVENT.a().booleanValue() == false) goto L5;
            this.this$0.sendJsEvent("perf", MapsKt.mapOf(new Pair[]{TuplesKt.to("perfBaseTimeStamp", String.valueOf(System.currentTimeMillis())), TuplesKt.to("perf", r10)}));
        L5:
            super.onFirstLoadPerfReady(r10);
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r11 = r0.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            ((f) r11.next()).d(LynxComponent.access$getMLynxView$p(r1), r10);
            goto L7
        L9:
            x8.b r12 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r13 = new StringBuilder("===onFirstLoadPerfReady: ");
            String r14 = LynxComponent.access$getUrl(this.this$0);
            if (r14 != null) goto L12;
            r14 = "empty";
        L12:
            r13.append(r14);
            r13.append("===");
            r12.e(LynxComponent.TAG, r13.toString());
        }

        public void onLoadFailed(String r10) {
            super.onLoadFailed(r10);
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r11 = r0.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((f) r11.next()).j(LynxComponent.access$getMLynxView$p(r1), null, r10);
            goto L4
        L6:
            x8.b r12 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r13 = new StringBuilder("===onLoadFailed: ");
            String r14 = LynxComponent.access$getUrl(this.this$0);
            if (r14 != null) goto L9;
            r14 = "empty";
        L9:
            r13.append(r14);
            r13.append("  error: ");
            r13.append(r10);
            r13.append("===");
            r12.f(LynxComponent.TAG, "on_load_failed", r13.toString());
        }

        public void onPageStart(String r10) {
            super.onPageStart(r10);
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r11 = r0.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((f) r11.next()).k(LynxComponent.access$getMLynxView$p(r1), r10, null, LynxComponent.access$getMIsOffline$p(r1));
            goto L4
        L6:
            LynxComponent.access$getMAnnieContext$p(this.this$0).d.f(LynxComponent.TAG, "on_page_start", "===onPageStart: " + r10 + "===");
        }

        public void onReceivedError(LynxError r10) {
            super.onReceivedError(r10);
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r11 = r0.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((f) r11.next()).q(LynxComponent.access$getMLynxView$p(r1), r10);
            goto L4
        L6:
            x8.b r12 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r13 = new StringBuilder("onReceivedError, errorCode: ");
            String r14 = "";
            if (r10 == null) goto L9;
            Object r15 = Integer.valueOf(r10.getErrorCode());
        L10:
            r13.append(r15);
            r13.append(", msg: ");
            if (r10 == null) goto L13;
            String r16 = r10.getMsg();
        L14:
            if (r16 == null) goto L17;
            r14 = r16;
        L17:
            r13.append(r14);
            r12.f(LynxComponent.TAG, "on_received_error", r13.toString());
            return;
        L13:
            r16 = null;
            goto L14
        L9:
            r15 = "";
            goto L10
        }

        public void onScrollStart(q1.b r10) {
            super.onScrollStart(r10);
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r11 = r0.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((f) r11.next()).r(LynxComponent.access$getMLynxView$p(r1), r10);
            goto L4
        }

        public void onScrollStop(q1.b r10) {
            super.onScrollStop(r10);
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r1 = this.this$0;
            Iterator r11 = r0.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((f) r11.next()).s(LynxComponent.access$getMLynxView$p(r1), r10);
            goto L4
        }

        public void onTimingSetup(Map<String, Object> r10) {
            super.onTimingSetup(r10);
            if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L17;
            Objects.toString(r10);
            if (r10 == null) goto L18;
            LynxComponent r0 = this.this$0;
            HashMap r11 = (HashMap) r10.get("setup_timing");
            Long r1 = null;
            if (r11 == null) goto L9;
            Object r12 = r11.get("draw_end");
        L10:
            Long r13 = (Long) r12;
            Bundle r14 = LynxComponent.access$getMAnnieContext$p(r0).getBundle();
            if (r14 == null) goto L13;
            r1 = Long.valueOf(r14.getLong("open_time"));
        L13:
            if (r1 == null) goto L19;
            if (r13 == null) goto L20;
            LynxComponent.access$getMAnnieContext$p(r0).d.e("livesdk_live_container_timing", "===onTimingSetup====full_time: " + (r13.longValue() - r1.longValue()));
            return;
        L20:
            return;
        L19:
            return;
        L9:
            r12 = null;
            goto L10
        L18:
            return;
        }

        public void onUpdatePerfReady(v0 r10) {
            super.onUpdatePerfReady(r10);
            ConcurrentLinkedQueue r11 = LynxComponent.access$getMLifecycleCallbacks$p(this.this$0);
            LynxComponent r0 = this.this$0;
            Iterator r12 = r11.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            f r1 = (f) r12.next();
            LynxView r13 = LynxComponent.access$getMLynxView$p(r0);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r13, "lynxView");
            goto L4
        L6:
            x8.b r14 = LynxComponent.access$getMAnnieContext$p(this.this$0).d;
            StringBuilder r15 = new StringBuilder("===onUpdatePerfReady: ");
            String r16 = LynxComponent.access$getUrl(this.this$0);
            if (r16 != null) goto L9;
            r16 = "empty";
        L9:
            r15.append(r16);
            r15.append("===");
            r14.f(LynxComponent.TAG, "on_update_perf_ready", r15.toString());
        }

        public String shouldRedirectImageUrl(String r10) {
            if (r10 == null) goto L4;
            boolean r1 = true;
            String r11 = null;
            if (LynxComponent.access$getLoaderConfig$p(this.this$0).a == true) goto L8;
        L12:
            boolean r0 = false;
        L13:
            if (r0 == false) goto L39;
            LinkedHashMap r12 = new LinkedHashMap();
            d r13 = LynxComponent.access$getIntercept$p(this.this$0);
            AnnieResType r14 = AnnieResType.LYNX_IMAGE;
            IHybridComponent.HybridType r15 = IHybridComponent.HybridType.LYNX;
            r13.b(r10, r14, r15, r12);
            PreLoadUtils.a.getClass();
            boolean r16 = CollectionsKt.contains(((com.bytedance.android.annie.service.preload.b) PreLoadUtils.b.getValue()).b, r10);
            if (r16 == false) goto L17;
        L18:
            i r17 = (i) LynxComponent.access$getImageCache$p(this.this$0).get(r10);
            if (r17 != null) goto L27;
            RequestConfig r18 = new RequestConfig(r14);
            LynxComponent r19 = this.this$0;
            r18.c = n.c(r15);
            r18.d = true;
            r18.g = r16;
            r18.e = false;
            r18.a().putAll(r12);
            if (LynxComponent.access$getLoaderConfig$p(r19).c == false) goto L23;
            r18.h = LynxComponent.access$getLoaderConfig$p(r19).d;
        L23:
            com.bytedance.android.annie.service.resource.h r20 = n.h(r10, r18);
            if (r20 == null) goto L26;
            r17 = r20.b();
            goto L27
        L26:
            r17 = null;
        L27:
            if (r17 == null) goto L37;
            LynxComponent r21 = this.this$0;
            String r22 = r17.a;
            if (r22 != null) goto L31;
        L34:
            if (r1 == false) goto L36;
            LynxComponent.access$getImageCache$p(r21).put(r10, r17);
            goto L37
        L36:
            r11 = "file://" + r17.a;
            HashMap r23 = LynxComponent.access$getImageCache$p(r21);
            Intrinsics.checkNotNull(r11);
            r23.put(r11, r17);
            goto L37
        L31:
            if (StringsKt.isBlank(r22) == true) goto L34;
            r1 = false;
        L37:
            if (r11 == null) goto L49;
            return r11;
        L49:
            return n.a(r10);
        L17:
            if (((com.bytedance.android.annie.service.resource.e) this.this$0.getService(com.bytedance.android.annie.service.resource.e.class)).l(r10) == false) goto L37;
        L39:
            String r24 = com.bytedance.android.annie.service.resource.a.a.Z(r10);
            if (r24 == null) goto L47;
            if (StringsKt.isBlank(r24) == false) goto L44;
            r24 = super.shouldRedirectImageUrl(r10);
        L44:
            String r25 = r24;
            if (r25 == null) goto L47;
            return r25;
        L47:
            return super.shouldRedirectImageUrl(r10);
        L8:
            if (LynxComponent.access$getUseForestLoadImg(this.this$0).booleanValue() == false) goto L12;
            if (StringsKt.startsWith$default(r10, "http", false, 2, null) == false) goto L12;
            r0 = true;
            goto L13
        L4:
            return super.shouldRedirectImageUrl(r10);
        }

        public void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
            super.onTimingUpdate(r10, r11, r12);
            if (com.bytedance.android.annie.ng.g.b().a.a == false) goto L14;
            Objects.toString(r11);
            if (r11 == null) goto L15;
            LynxComponent r13 = this.this$0;
            Long r14 = r11.get("draw_end");
            Bundle r15 = LynxComponent.access$getMAnnieContext$p(r13).getBundle();
            if (r15 == null) goto L9;
            Long r16 = Long.valueOf(r15.getLong("open_time"));
        L10:
            if (r16 == null) goto L16;
            if (r14 == null) goto L17;
            LynxComponent.access$getMAnnieContext$p(r13).d.e("livesdk_live_container_timing", "===onTimingUpdate====full_time: " + (r14.longValue() - r16.longValue()));
            return;
        L17:
            return;
        L16:
            return;
        L9:
            r16 = null;
            goto L10
        L15:
            return;
        }

        public void loadImage(Context r1, String r10, String r11, float r12, float r13, Transformer r14, m.a r15) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r15, "handler");
            if (r11 != null) goto L6;
            return;
        L6:
            if (StringsKt.startsWith$default(r11, "http", false, 2, null) == false) goto L8;
        L10:
            i r16 = (i) LynxComponent.access$getImageCache$p(this.this$0).get(r11);
            if (r16 == null) goto L13;
            CloseableReference<CloseableBitmap> r17 = r16.b();
        L14:
            if (r17 != null) goto L16;
            LynxComponent.access$getMAnnieContext$p(this.this$0).d.e(LynxComponent.TAG, "preload image failed url: ".concat(r11));
        L16:
            r15.a(r17, null);
            return;
        L13:
            r17 = null;
            goto L14
        L8:
            if (StringsKt.startsWith$default(r11, "file", false, 2, null) == true) goto L10;
        }
    }

    public static final class a {
        public a() {
        }

        public static String a(String r10) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            Uri r11 = UriProtector.parse(r10);
            Set r0 = UriProtector.getQueryParameterNames(r11);
            Uri.Builder r12 = r11.buildUpon();
            Map<String, String> r1 = ((com.bytedance.android.annie.service.network.i) Annie.getService$default(com.bytedance.android.annie.service.network.i.class, null, 2, null)).s1();
            x8.a.d(LynxComponent.TAG, "===LynxComponent 拼接公共参数===", false);
            if (r1 == null) goto L5;
            x8.a.d(LynxComponent.TAG, r1.toString(), false);
        L5:
            Iterator<T> r13 = r1.entrySet().iterator();
        L7:
            if (r13.hasNext() == false) goto L20;
            Map.Entry r14 = (Map.Entry) r13.next();
            CharSequence r15 = (CharSequence) r14.getValue();
            if (r15 != null) goto L11;
        L14:
            boolean r16 = true;
        L15:
            if (r16 == true) goto L7;
            if (r0.contains(r14.getKey()) == true) goto L7;
            r12.appendQueryParameter((String) r14.getKey(), (String) r14.getValue());
            goto L7
        L11:
            if (StringsKt.isBlank(r15) == true) goto L14;
            r16 = false;
            goto L15
        L20:
            return r12.build().toString();
        }

        public static k b(Context r10, String r11, String r12, String r13, com.bytedance.android.annie.param.a r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r13, "containerId");
            Intrinsics.checkNotNullParameter(r14, "annieContext");
            Bundle r0 = r14.getBundle();
            if (r0 == null) goto L5;
            Long r1 = Long.valueOf(r0.getLong("open_time"));
        L7:
            return c(r10, r11, r12, r13, r1, r15, r14.getBizKey());
        L5:
            r1 = null;
            goto L7
        }

        public static k c(Context r1, String r10, String r11, String r12, Long r13, boolean r14, String r15) {
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r12, "containerId");
            Intrinsics.checkNotNullParameter(r15, "bizKey");
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            k r16 = com.bytedance.android.annie.a.a(r1, r10, false, r11, r15);
            r16.I1(LynxEnv.inst().getLynxVersion());
            r16.h1(r12);
            r16.N1(r14 ? 1 : 0);
            r16.G1(r11);
            if (r13 == null) goto L8;
            r16.C1(r13.toString());
            r16.i1(r13.toString());
        L8:
            return r16;
        }
    }

    public final class b implements u {
        public List<? extends u> a;
        public final /* synthetic */ LynxComponent b;

        public final /* synthetic */ void b(c0 r1, int r10) {
        }

        public b(LynxComponent r1) {
            this.b = r1;
        }

        public final void a(String r10, String r11, o0 r12) {
            List<? extends u> r0 = this.a;
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((u) r1.next()).a(r10, r11, r12);
            goto L6
        L10:
            return;
        }

        public final void c(String r10, String r11, int r12, String r13, o0 r14) {
            List<? extends u> r0 = this.a;
            if (r0 == null) goto L8;
            Iterator<T> r1 = r0.iterator();
        L6:
            if (r1.hasNext() == false) goto L10;
            ((u) r1.next()).c(r10, r11, r12, r13, r14);
            goto L6
        L10:
            return;
        }
    }

    public static final class c implements com.bytedance.android.annie.lynx.resource.c {
        public final /* synthetic */ LynxComponent a;

        public c(LynxComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.lynx.resource.c
        public final void a(com.bytedance.android.annie.card.web.resource.a r10) {
            Intrinsics.checkNotNullParameter(r10, "resourceInfo");
            boolean r0 = r10.a;
            if (LynxComponent.access$getMIsOffline$p(this.a) == r0) goto L5;
            this.a.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("offline", Integer.valueOf(r0 ? 1 : 0))));
            LynxComponent.access$setMIsOffline$p(this.a, r0);
        L5:
            ConcurrentLinkedQueue r1 = LynxComponent.access$getMLifecycleCallbacks$p(this.a);
            LynxComponent r11 = this.a;
            Iterator r12 = r1.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            ((f) r12.next()).onTemplateLoaded(LynxComponent.access$getMLynxView$p(r11), r10.a);
            goto L7
        L9:
            ConcurrentLinkedQueue r13 = LynxComponent.access$getMLifecycleCallbacks$p(this.a);
            LynxComponent r14 = this.a;
            Iterator r15 = r13.iterator();
        L11:
            if (r15.hasNext() == false) goto L13;
            ((f) r15.next()).h(LynxComponent.access$getMLynxView$p(r14), r10);
            goto L11
        }

        @Override // com.bytedance.android.annie.lynx.resource.c
        public final void b(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r11, "path");
            ConcurrentLinkedQueue r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.a);
            LynxComponent r1 = this.a;
            Iterator r12 = r0.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            ((f) r12.next()).i(LynxComponent.access$getMLynxView$p(r1), r10, r11);
            goto L4
        }

        @Override // com.bytedance.android.annie.lynx.resource.c
        public final void c(String r10, String r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "type");
            Intrinsics.checkNotNullParameter(r11, "path");
            Iterator r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((f) r0.next()).t(r10, r11, r12, r13);
            goto L4
        }
    }

    public static final class d implements com.bytedance.android.annie.card.base.c {
        public boolean a;
        public final /* synthetic */ LynxComponent b;

        @Override // com.bytedance.android.annie.card.base.c
        public final void a(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Long> r13) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r11, "resType");
            Intrinsics.checkNotNullParameter(r12, "type");
            Intrinsics.checkNotNullParameter(r13, "performanceInfo");
        }

        public d(LynxComponent r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.annie.card.base.c
        public final void b(String r10, AnnieResType r11, IHybridComponent.HybridType r12, Map<String, Object> r13) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r11, "resType");
            Intrinsics.checkNotNullParameter(r12, "type");
            r13.put("use_ttnet", Boolean.valueOf(this.a));
            Iterator r0 = LynxComponent.access$getMLifecycleCallbacks$p(this.b).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((f) r0.next()).onBeforeLoadRequest(r10, r11, r12, r13);
            goto L4
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void close() {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public boolean isAnnieXComponent() {
        return false;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public void onPause() {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public void onResume() {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r10) {
        Intrinsics.checkNotNullParameter(r10, "l");
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, a7.b
    public /* bridge */ /* synthetic */ void setRadius(float r1) {
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, a7.b
    public /* bridge */ /* synthetic */ void setRadius(float r1, float r10, float r11, float r12) {
    }

    private final LynxView createLynxViewAndBridge() {
        x8.b r1 = this.mAnnieContext.d;
        StringBuilder r10 = new StringBuilder("===createLynxViewAndBridge: ");
        String r11 = getUrl();
        String r12 = "empty";
        if (r11 != null) goto L5;
        r11 = "empty";
    L5:
        r10.append(r11);
        r10.append("===");
        r1.f(TAG, "create_component_view", r10.toString());
        JsonObject r13 = getQueryItem(getSchema());
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L159
        c8.b r15 = new c8.b(this.mContext, this.mLifecycleCallbacks, getSchema(), this.mAnnieContext, new LynxComponent$createLynxViewAndBridge$1$1(this));     // Catch: Throwable -> L159
        Iterator<T> r16 = this.mLifecycleCallbacks.iterator();     // Catch: Throwable -> L159
    L8:
        if (r16.hasNext() == false) goto L10;
        ((f) r16.next()).onBeforeJsbRegister();     // Catch: Throwable -> L159
        goto L8
    L10:
        String r17 = getUrl();     // Catch: Throwable -> L159
        if (r17 != null) goto L14;
        String r18 = "";
    L15:
        CardParamVoNew r19 = this.mCardParamVoNew;     // Catch: Throwable -> L159
        if (r19 == null) goto L19;
        String r20 = r19.z();     // Catch: Throwable -> L159
        if (r20 == null) goto L19;
    L20:
        this.mJSBridgeManager.e(this, this.mContext, r15, CollectionsKt.listOf(this.mLynxJsBridgeListenerProxy), r18, r20);     // Catch: Throwable -> L159
        Iterator<T> r21 = this.mLifecycleCallbacks.iterator();     // Catch: Throwable -> L159
    L22:
        if (r21.hasNext() == false) goto L24;
        ((f) r21.next()).onJsbRegistered();     // Catch: Throwable -> L159
        goto L22
    L24:
        this.mBridgeImpl = r15;     // Catch: Throwable -> L159
        LynxViewBuilder r22 = LynxView.builder();     // Catch: Throwable -> L159
        bindLynxModule(r22);     // Catch: Throwable -> L159
        ILatchService.e r23 = this.mAnnieContext.a;     // Catch: Throwable -> L159
        String r24 = null;
        if ((r23 instanceof com.bytedance.android.annie.lynx.service.latch.a.InterfaceC0070a) == false) goto L27;
        com.bytedance.android.annie.lynx.service.latch.a.InterfaceC0070a r25 = (com.bytedance.android.annie.lynx.service.latch.a.InterfaceC0070a) r23;     // Catch: Throwable -> L159
    L28:
        if (r25 == null) goto L35;
        List<com.bytedance.android.latch.a.c> r26 = r25.a();     // Catch: Throwable -> L159
        if (r26 == null) goto L35;
        Iterator<T> r27 = r26.iterator();     // Catch: Throwable -> L159
    L33:
        if (r27.hasNext() == false) goto L35;
        com.bytedance.android.latch.a.c r28 = (com.bytedance.android.latch.a.c) r27.next();     // Catch: Throwable -> L159
        r22.registerModule(r28.getName(), r28.a(), r28.getParams());     // Catch: Throwable -> L159
    L35:
        CardParamVoNew r29 = this.mCardParamVoNew;     // Catch: Throwable -> L159
        boolean r30 = true;
        if (r29 != null) goto L38;
    L40:
        boolean r31 = false;
    L41:
        r22.setEnableCreateViewAsync(r31);     // Catch: Throwable -> L159
        f8.a r32 = e.a().a;     // Catch: Throwable -> L159
        if (r32 == null) goto L52;
        r22.addBehaviors(r32.provide());     // Catch: Throwable -> L159
        z8.b r33 = (z8.b) getService(z8.b.class);     // Catch: Throwable -> L159
        String r34 = getUrl();     // Catch: Throwable -> L159
        if (r34 == null) goto L52;
        Iterator<T> r35 = r33.M(this.mContext, r34).iterator();     // Catch: Throwable -> L159
    L48:
        if (r35.hasNext() == false) goto L52;
        Object r36 = r35.next();     // Catch: Throwable -> L159
        if ((r36 instanceof com.lynx.tasm.behavior.a) == false) goto L48;
        r22.addBehavior((com.lynx.tasm.behavior.a) r36);     // Catch: Throwable -> L159
        this.mAnnieContext.d.e(TAG, "add new behavior, name is " + r36 + ", url is " + r34);     // Catch: Throwable -> L159
    L52:
        List r37 = ((z8.b) getService(z8.b.class)).r1(this.mContext, this.xResourceLoader);     // Catch: Throwable -> L159
        if (r37 == null) goto L58;
        Iterator r38 = r37.iterator();     // Catch: Throwable -> L159
    L56:
        if (r38.hasNext() == false) goto L58;
        com.lynx.tasm.behavior.a r39 = (com.lynx.tasm.behavior.a) r38.next();     // Catch: Throwable -> L159
        r22.addBehavior(r39);     // Catch: Throwable -> L159
        this.mAnnieContext.d.e(TAG, "add new behavior, name is " + r39);     // Catch: Throwable -> L159
    L58:
        Pair<Integer, Integer> r40 = getViewPort();     // Catch: Throwable -> L159
        r22.setPresetMeasuredSpec(((Number) r40.getFirst()).intValue(), ((Number) r40.getSecond()).intValue());     // Catch: Throwable -> L159
        CardParamVoNew r41 = this.mCardParamVoNew;     // Catch: Throwable -> L159
        if (r41 == null) goto L61;
        int r42 = r41.D;     // Catch: Throwable -> L159
    L62:
        r22.setThreadStrategyForRendering(getThreadStrategy(r42));     // Catch: Throwable -> L159
        Iterator<T> r43 = this.mLifecycleCallbacks.iterator();     // Catch: Throwable -> L159
    L64:
        if (r43.hasNext() == false) goto L67;
        ((f) r43.next()).a(r22);     // Catch: Throwable -> L159
        goto L64
    L67:
        if (enableAdapterFontScale() == false) goto L76;
        p r44 = p.a;     // Catch: Throwable -> L159
        Context r45 = this.mContext;     // Catch: Throwable -> L159
        if (r45 == null) goto L73;
        float r46 = r45.getResources().getConfiguration().fontScale;     // Catch: Throwable -> L159
        if (r46 <= 1.3d) goto L74;
        r46 = 1.3f;
    L74:
        r22.setFontScale(r46);     // Catch: Throwable -> L159
        goto L76
    L73:
        r46 = 1.0f;
    L76:
        if (enableViewZoom() == false) goto L78;
        p r47 = p.a;     // Catch: Throwable -> L159
        float r48 = p.g(this.mContext);     // Catch: Throwable -> L159
        r22.setScreenSize((int) (r47.e() * r48), (int) (r47.d() * r48));     // Catch: Throwable -> L159
    L78:
        CardParamVoNew r49 = this.mCardParamVoNew;     // Catch: Throwable -> L159
        if (r49 == null) goto L84;
        String r50 = r49.o();     // Catch: Throwable -> L159
        if (r50 == null) goto L84;
        String r110 = r50;
    L85:
        String r51 = getUrl();     // Catch: Throwable -> L159
        if (r51 != null) goto L88;
        String r111 = "";
    L89:
        String r112 = containerId();     // Catch: Throwable -> L159
        JsonElement r52 = r13.get("enable_canvas");     // Catch: Throwable -> L159
        if (r52 != null) goto L92;
    L97:
        String r53 = null;
    L98:
        boolean r113 = Intrinsics.areEqual(r53, "1");     // Catch: Throwable -> L159
        JsonElement r54 = r13.get("enable_dynamic_v8");     // Catch: Throwable -> L159
        if (r54 != null) goto L101;
    L106:
        String r55 = null;
    L107:
        boolean r210 = Intrinsics.areEqual(r55, "1");     // Catch: Throwable -> L159
        JsonElement r56 = r13.get("enable_canvas_optimize");     // Catch: Throwable -> L159
        if (r56 != null) goto L110;
    L119:
        int r211 = -1;
    L120:
        com.bytedance.android.annie.lynx.runtime.a.b(r22, r110, r111, r112, r113, r210, r211);     // Catch: Throwable -> L159
        JsonElement r57 = r13.get("enable_animax");     // Catch: Throwable -> L159
        if (r57 != null) goto L123;
    L128:
        String r58 = null;
    L130:
        if (Intrinsics.areEqual(r58, "1") == false) goto L132;
        f26.a.a.c(r22, this.mContext);     // Catch: Throwable -> L159
    L132:
        r22.setDynamicComponentFetcher(this.dynamicComponentProvider);     // Catch: Throwable -> L159
        r22.setTemplateProvider(this.templateProvider);     // Catch: Throwable -> L159
        r22.setResourceProvider("EXTERNAL_JS_SOURCE", this.externalJsProvider);     // Catch: Throwable -> L159
        r22.setResourceProvider("FONT", new com.bytedance.android.annie.lynx.resource.b(this.loaderConfig, this.intercept));     // Catch: Throwable -> L159
        JsonElement r0 = r13.get("enable_js");     // Catch: Throwable -> L159
        if (r0 == null) goto L141;
        if (r0.isJsonPrimitive() == true) goto L138;
        r0 = null;
    L138:
        if (r0 == null) goto L141;
        r24 = r0.getAsString();     // Catch: Throwable -> L159
    L141:
        if (Intrinsics.areEqual(r24, "0") == false) goto L145;
        d8.f r59 = e.a().e;     // Catch: Throwable -> L159
        if (r59 == null) goto L145;
        r59.b(r22);     // Catch: Throwable -> L159
    L145:
        CardParamVoNew r60 = this.mCardParamVoNew;     // Catch: Throwable -> L159
        if (r60 != null) goto L148;
    L150:
        r30 = false;
    L151:
        if (r30 == false) goto L157;
        String r114 = getUrl();     // Catch: Throwable -> L159
        if (r114 == null) goto L157;
        String r61 = (String) ListProtector.get(StringsKt.split$default(r114, new String[]{"?"}, false, 0, 6, null), 0);     // Catch: Throwable -> L159
        d8.f r62 = e.a().e;     // Catch: Throwable -> L159
        if (r62 == null) goto L157;
        r62.a(r22, r61);     // Catch: Throwable -> L159
    L157:
        Object r63 = Result.constructor-impl(r22.build(this.mContext));     // Catch: Throwable -> L159
    L161:
        Throwable r64 = Result.exceptionOrNull-impl(r63);
        if (r64 == null) goto L168;
        x8.b r65 = this.mAnnieContext.d;
        StringBuilder r66 = new StringBuilder("===createLynxViewAndBridge:");
        String r67 = getUrl();
        if (r67 == null) goto L167;
        r12 = r67;
    L167:
        r66.append(r12);
        r66.append("  error msg: ");
        r66.append(r64.getMessage());
        r66.append("}===");
        r65.e(TAG, r66.toString());
        this.mJSBridgeManager.release();
    L168:
        ResultKt.throwOnFailure(r63);
        LynxView r68 = (LynxView) r63;
        r68.addLynxViewClient(new AnnieLynxViewClient(this));
        r68.setScrollBarStyle(0);
        c8.b r69 = this.mBridgeImpl;
        if (r69 == null) goto L172;
        Intrinsics.checkNotNullParameter(r68, "<set-?>");
        r69.t = r68;
    L172:
        b r70 = this.mLynxJsBridgeListenerProxy;
        r70.getClass();
        Intrinsics.checkNotNullParameter(r68, "lynxView");
        r70.a = access$getMonitorProvider$p(r70.b).b(r68);
        realAddOnPreDrawListener(r68);
        return r68;
    L148:
        if (r60.j0() != true) goto L150;
    L123:
        if (r57.isJsonPrimitive() == true) goto L126;
        r57 = null;
    L126:
        if (r57 == null) goto L128;
        r58 = r57.getAsString();     // Catch: Throwable -> L159
        goto L130
    L110:
        if (r56.isJsonPrimitive() == true) goto L113;
        r56 = null;
    L113:
        if (r56 == null) goto L119;
        String r71 = r56.getAsString();     // Catch: Throwable -> L159
        if (r71 == null) goto L119;
        Integer r72 = StringsKt.toIntOrNull(r71);     // Catch: Throwable -> L159
        if (r72 == null) goto L119;
        r211 = r72.intValue();     // Catch: Throwable -> L159
        goto L120
    L101:
        if (r54.isJsonPrimitive() == true) goto L104;
        r54 = null;
    L104:
        if (r54 == null) goto L106;
        r55 = r54.getAsString();     // Catch: Throwable -> L159
        goto L107
    L92:
        if (r52.isJsonPrimitive() == true) goto L95;
        r52 = null;
    L95:
        if (r52 == null) goto L97;
        r53 = r52.getAsString();     // Catch: Throwable -> L159
        goto L98
    L88:
        r111 = r51;
    L84:
        r110 = "";
        goto L85
    L61:
        r42 = 0;
        goto L62
    L38:
        if (r29.b0() != true) goto L40;
        r31 = true;
        goto L41
    L27:
        r25 = null;
    L19:
        r20 = "all";
        goto L20
    L14:
        r18 = r17;
    L159:
        th = move-exception;
        Result.Companion r73 = Result.Companion;
        r63 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L161
    }

    private final boolean enableAdapterFontScale() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        String r1 = null;
        if (r0 == null) goto L5;
        String r10 = r0.o0();
    L7:
        if (Intrinsics.areEqual(r10, "1") == false) goto L9;
        return true;
    L9:
        CardParamVoNew r11 = this.mCardParamVoNew;
        if (r11 == null) goto L13;
        r1 = r11.o0();
    L13:
        if (Intrinsics.areEqual(r1, "") == false) goto L19;
        String r12 = getUrl();
        if (r12 == null) goto L19;
        if (AnnieConfigSettingKeys.LYNX_FONT_SCALE_PAGE_LIST.a().contains((String) ListProtector.get(StringsKt.split$default(r12, new String[]{"?"}, false, 0, 6, null), 0)) == false) goto L19;
        return true;
    L19:
        return false;
    L5:
        r10 = null;
        goto L7
    }

    private final boolean enableViewZoom() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.v0() != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final String getForestSessionID() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 == null) goto L11;
        String r1 = r0.y0();
        if (r1 == null) goto L11;
        if (StringsKt.isBlank(r1) == false) goto L9;
        r1 = containerId();
    L9:
        if (r1 == null) goto L11;
        return r1;
    L11:
        return containerId();
    }

    private final Pair<Integer, Integer> getRealPair() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 == null) goto L7;
        boolean r10 = true;
        if (r0.L0() != true) goto L7;
    L9:
        if (r10 == false) goto L16;
        int r11 = this.mPresetWidth;
        if (r11 > 0) goto L15;
        r11 = p.a.e();
    L15:
        return new Pair(Integer.valueOf(View.MeasureSpec.makeMeasureSpec(r11, 1073741824)), Integer.valueOf(View.MeasureSpec.makeMeasureSpec(p.a.d(), 1073741824)));
    L16:
        int r12 = this.mPresetWidth;
        if (r12 > 0) goto L21;
        r12 = p.a.e();
    L21:
        return new Pair(Integer.valueOf(View.MeasureSpec.makeMeasureSpec(r12, 1073741824)), Integer.valueOf(View.MeasureSpec.makeMeasureSpec(0, 0)));
    L7:
        r10 = false;
        goto L9
    }

    private final String getSchema() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 == null) goto L9;
        String r1 = r0.o();
        if (r1 != null) goto L11;
        String r10 = r0.b;
        if (r10 != null) goto L12;
        return "";
    L12:
        return r10;
    L11:
        return r1;
    L9:
        return null;
    }

    private final Boolean getTryFixViewSizeOnPreDraw() {
        return (Boolean) this.tryFixViewSizeOnPreDraw$delegate.getValue();
    }

    private final String getUrl() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    private final Boolean getUseForestLoadImg() {
        return (Boolean) this.useForestLoadImg$delegate.getValue();
    }

    private final void initTemplateProviderCallback() {
        LynxTemplateProvider r0 = this.templateProvider;
        c r1 = new c(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        r0.e = r1;
        x8.b r10 = this.mAnnieContext.d;
        StringBuilder r11 = new StringBuilder("===initTemplateProviderCallback: ");
        String r12 = getUrl();
        if (r12 != null) goto L5;
        r12 = "empty";
    L5:
        r11.append(r12);
        r11.append("===");
        r10.e(TAG, r11.toString());
    }

    private final void preLynxViewCreate() {
        registerLifecycleCallback(this.mInitializeLifecycle);
        Iterator<T> r0 = this.monitorProvider.a().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        registerLifecycleCallback((com.bytedance.android.annie.card.base.b) r0.next());
        goto L4
    L6:
        boolean r1 = LynxEnv.inst().hasInited();
        Iterator<T> r10 = this.mLifecycleCallbacks.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        ((f) r10.next()).onBeforeLynxEnvInitialize(!r1);
        goto L8
    L10:
        if (r1 == true) goto L14;
        d8.d r11 = e.a().b;
        if (r11 == null) goto L14;
        r11.init();
    L14:
        Iterator<T> r12 = this.mLifecycleCallbacks.iterator();
    L16:
        if (r12.hasNext() == false) goto L18;
        ((f) r12.next()).onLynxEnvInitialized();
        goto L16
    L18:
        x8.b r13 = this.mAnnieContext.d;
        StringBuilder r14 = new StringBuilder("===preLynxViewCreate: ");
        String r15 = getUrl();
        if (r15 != null) goto L21;
        r15 = "empty";
    L21:
        r14.append(r15);
        r14.append("===");
        r13.f(TAG, "pre_create_view", r14.toString());
    }

    private final void updateReportingEventsParamsForLynxView() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        String r1 = orUnknown(getSchema());     // Catch: Throwable -> L4
        this.mLynxView.putParamsForReportingEvents(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, generatePageIdWithSchema(r1)), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r1), TuplesKt.to("container_name", "annie"), TuplesKt.to("container_sdk_version", orUnknown(Annie.getAnnieVersionName()))}));     // Catch: Throwable -> L4
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L12;
        this.mAnnieContext.d.a(TAG, "updateReportingEventsParamsForLynxView error: " + r11.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public void addOnPreDrawListener() {
        realAddOnPreDrawListener(this.mLynxView);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String getBizKey() {
        return this.mAnnieContext.getBizKey();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public boolean isPopup() {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 == null) goto L5;
        PageType r1 = r0.I0();
    L7:
        if (r1 != PageType.POPUP) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = null;
        goto L7
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.mLynxView.getWidth() == 0) goto L5;
    L9:
        this.mLynxView.getViewTreeObserver().removeOnPreDrawListener(this);
        if (AnnieConfigSettingKeys.ANNIE_OPEN_PRE_DRAW_FOR_LYNX.a().booleanValue() == false) goto L12;
        LynxView r0 = this.mLynxView;
        p r10 = p.a;
        r0.updateScreenMetrics(r10.e(), r10.d());
    L13:
        this.mLynxView.requestLayout();
        return true;
    L12:
        LynxView r1 = this.mLynxView;
        r1.updateScreenMetrics(r1.getWidth(), this.mLynxView.getHeight());
        goto L13
    L5:
        if (this.mLynxView.getHeight() != 0) goto L9;
        if (getTryFixViewSizeOnPreDraw().booleanValue() == false) goto L9;
        return true;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        this.imageCache.clear();
        super.release();
        Iterator<T> r0 = this.mLifecycleCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onRelease();
        goto L4
    L6:
        this.mLynxView.destroy();
        JSBridgeManager r1 = this.mJSBridgeManager;
        r1.s = true;
        j.I1(r1);
        LynxTemplateProvider r10 = this.templateProvider;
        r10.b = true;
        g r11 = r10.a;
        if (r11.c == false) goto L9;
        String r12 = r11.d;
        y9.m r13 = n.a;
        Intrinsics.checkNotNullParameter(r12, "containerId");
        ((com.bytedance.android.annie.service.resource.e) Annie.getService$default(com.bytedance.android.annie.service.resource.e.class, null, 2, null)).h(r12);
    L9:
        com.bytedance.android.annie.card.base.d.a.a(r10);
        com.bytedance.android.annie.lynx.resource.d r14 = this.dynamicComponentProvider;
        r14.b = true;
        com.bytedance.android.annie.card.base.d.a.a(r14);
        LynxExternalJSProvider r15 = this.externalJsProvider;
        r15.b = true;
        com.bytedance.android.annie.card.base.d.a.a(r15);
        this.mJSBridgeManager.i();
        this.mJSBridgeManager.release();
    }

    private final Pair<Integer, Integer> getViewPort() {
        return getRealPair();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public void hide() {
        super.hide();
        sendJsEvent("viewDisappeared", new JSONObject());
        this.mLynxView.onEnterBackground();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent, com.bytedance.android.annie.api.card.IHybridComponent
    public void show() {
        super.show();
        sendJsEvent("viewAppeared", new JSONObject());
        this.mLynxView.onEnterForeground();
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public JSBridgeManager getJSBridgeManger() {
        return this.mJSBridgeManager;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public View getView() {
        return this.mLynxView;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public IHybridComponent.HybridType hybridType() {
        return IHybridComponent.HybridType.LYNX;
    }

    public static final /* synthetic */ HashMap access$getImageCache$p(LynxComponent r0) {
        return r0.imageCache;
    }

    public static final /* synthetic */ d access$getIntercept$p(LynxComponent r0) {
        return r0.intercept;
    }

    public static final /* synthetic */ g access$getLoaderConfig$p(LynxComponent r0) {
        return r0.loaderConfig;
    }

    public static final /* synthetic */ com.bytedance.android.annie.param.a access$getMAnnieContext$p(LynxComponent r0) {
        return r0.mAnnieContext;
    }

    public static final /* synthetic */ boolean access$getMIsOffline$p(LynxComponent r0) {
        return r0.mIsOffline;
    }

    public static final /* synthetic */ JSBridgeManager access$getMJSBridgeManager$p(LynxComponent r0) {
        return r0.mJSBridgeManager;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getMLifecycleCallbacks$p(LynxComponent r0) {
        return r0.mLifecycleCallbacks;
    }

    public static final /* synthetic */ LynxView access$getMLynxView$p(LynxComponent r0) {
        return r0.mLynxView;
    }

    public static final /* synthetic */ j9.a access$getMonitorProvider$p(LynxComponent r0) {
        return r0.monitorProvider;
    }

    public static final /* synthetic */ String access$getUrl(LynxComponent r0) {
        return r0.getUrl();
    }

    public static final /* synthetic */ Boolean access$getUseForestLoadImg(LynxComponent r0) {
        return r0.getUseForestLoadImg();
    }

    private final String appendUrlQuery(String r10) {
        Companion.getClass();
        return a.a(r10);
    }

    private final void bindLynxModule(LynxViewBuilder r10) {
        this.mAnnieContext.d.e(TAG, "===注入XBridge LynxModule===");     // Catch: Exception -> L5
        g8.a r1 = (g8.a) getService(g8.a.class);     // Catch: Exception -> L5
        containerId();     // Catch: Exception -> L5
        r1.y0();     // Catch: Exception -> L5
        return;
    L5:
        this.mAnnieContext.d.e(TAG, "===注入Annie LynxModule===");
        r10.registerModule("bridge", AnnieLynxBridgeModule.class, this.mBridgeImpl);
    }

    private final String generatePageIdWithSchema(String r10) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L12;
        return UNKNOWN;
    L12:
        Uri r12 = UriProtector.parse(r10);
        String r13 = UriProtector.getQueryParameter(r12, "channel");
        String r14 = null;
        if (r13 != null) goto L15;
    L20:
        r13 = UriProtector.getQueryParameter(r12, "gecko_channel");
        if (r13 != null) goto L23;
    L25:
        r13 = null;
    L26:
        String r15 = UriProtector.getQueryParameter(r12, "bundle");
        if (r15 != null) goto L29;
    L34:
        r15 = UriProtector.getQueryParameter(r12, "gecko_bundle");
        if (r15 != null) goto L37;
    L39:
        r15 = null;
    L40:
        if (r13 != null) goto L42;
    L45:
        boolean r16 = true;
    L46:
        if (r16 == true) goto L54;
        if (r15 != null) goto L49;
    L50:
        r0 = true;
    L51:
        if (r0 == true) goto L54;
        return r13 + '/' + r15;
    L49:
        if (StringsKt.isBlank(r15) == false) goto L51;
    L54:
        String r1 = UriProtector.getQueryParameter(r12, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r1 == null) goto L63;
        if ((true ^ StringsKt.isBlank(r1)) == false) goto L59;
        r14 = r1;
    L59:
        if (r14 == null) goto L63;
        return orUnknown(schemaStringByRemovingQueryAndFragment(r14));
    L63:
        return orUnknown(schemaStringByRemovingQueryAndFragment(r10));
    L42:
        if (StringsKt.isBlank(r13) == true) goto L45;
        r16 = false;
        goto L46
    L37:
        if ((!StringsKt.isBlank(r15)) == false) goto L39;
    L29:
        if ((!StringsKt.isBlank(r15)) == true) goto L32;
        r15 = null;
    L32:
        if (r15 == null) goto L34;
    L23:
        if ((!StringsKt.isBlank(r13)) == false) goto L25;
    L15:
        if ((!StringsKt.isBlank(r13)) == true) goto L18;
        r13 = null;
    L18:
        if (r13 == null) goto L20;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r11 = false;
        goto L9
    }

    private final JsonObject getQueryItem(String r10) {
        JsonObject r0 = new JsonObject();
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L20;
        return r0;
    L20:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L17
        Uri r12 = UriProtector.parse(r10);     // Catch: Throwable -> L17
        Iterator r13 = UriProtector.getQueryParameterNames(r12).iterator();     // Catch: Throwable -> L17
    L13:
        if (r13.hasNext() == false) goto L15;
        String r14 = (String) r13.next();     // Catch: Throwable -> L17
        r0.addProperty(r14, UriProtector.getQueryParameter(r12, r14));     // Catch: Throwable -> L17
        goto L13
    L15:
        Result.constructor-impl(r12);     // Catch: Throwable -> L17
    L19:
        return r0;
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final ThreadStrategyForRendering getThreadStrategy(int r10) {
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L18;
        if (r10 == 2) goto L17;
        if (r10 == 3) goto L16;
        return ThreadStrategyForRendering.ALL_ON_UI;
    L16:
        return ThreadStrategyForRendering.MULTI_THREADS;
    L17:
        return ThreadStrategyForRendering.PART_ON_LAYOUT;
    L18:
        return ThreadStrategyForRendering.MOST_ON_TASM;
    L14:
        return ThreadStrategyForRendering.ALL_ON_UI;
    }

    private final String orUnknown(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if ((true ^ r1) == true) goto L13;
        r10 = null;
    L13:
        if (r10 != null) goto L16;
        return UNKNOWN;
    L16:
        return r10;
    L5:
        if (StringsKt.isBlank(r10) == true) goto L8;
        r1 = false;
        goto L10
    }

    private final void realAddOnPreDrawListener(LynxView r10) {
        CardParamVoNew r0 = this.mCardParamVoNew;
        if (r0 == null) goto L18;
        boolean r1 = r0.N0();
        if (AnnieConfigSettingKeys.ANNIE_OPEN_PRE_DRAW_FOR_LYNX.a().booleanValue() == true) goto L9;
        if (r1 == true) goto L9;
        boolean r11 = false;
    L10:
        if (r11 == true) goto L12;
        return;
    L12:
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L20;
        if (r10 == null) goto L21;
        ViewTreeObserver r12 = r10.getViewTreeObserver();
        if (r12 == null) goto L22;
        r12.addOnPreDrawListener(this);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r11 = true;
        goto L10
    }

    private final Map<String, Object> removeBlackKey(Map<String, ? extends Object> r10) {
        if (r10 == null) goto L4;
        String[] r0 = ((l) getService(l.class)).l0();
        int r11 = 0;
        if (r0.length != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return r10;
    L11:
        Map r12 = MapsKt.toMutableMap(r10);
        int r13 = r0.length;
    L12:
        if (r11 >= r13) goto L18;
        String r14 = r0[r11];
        if (r12.containsKey(r14) == false) goto L16;
        r12.remove(r14);
    L16:
        r11 = r11 + 1;
        goto L12
    L18:
        return MapsKt.toMap(r12);
    L8:
        r1 = false;
        goto L9
    L4:
        return MapsKt.emptyMap();
    }

    private final String schemaStringByRemovingQueryAndFragment(String r11) {
        if (r11 != null) goto L5;
    L8:
        boolean r10 = true;
    L10:
        if (r10 == false) goto L38;
        return null;
    L38:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L14
        Object r13 = Result.constructor-impl(UriProtector.parse(r11).buildUpon().clearQuery().fragment(null).build().toString());     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r13) == false) goto L19;
        r13 = null;
    L19:
        String r14 = (String) r13;
        if (r14 != null) goto L22;
    L25:
        boolean r15 = true;
    L26:
        if (r15 == true) goto L28;
        return r14;
    L28:
        int r16 = StringsKt.indexOfAny$default(r11, new char[]{'?', '#'}, 0, false, 6, null);
        if (r16 < 0) goto L37;
        if (r11 == null) goto L36;
        String r17 = r11.substring(0, r16);
        if ((!StringsKt.isBlank(r17)) == true) goto L34;
        return null;
    L34:
        return r17;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        return r11;
    L22:
        if (StringsKt.isBlank(r14) == true) goto L25;
        r15 = false;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        if (StringsKt.isBlank(r11) == true) goto L8;
        r10 = false;
        goto L10
    }

    private final void setUrl(String r10) {
        com.bytedance.android.annie.scheme.helper.a.d(this.mCardParamVoNew, com.bytedance.android.ec.core.event.a.KEY_URL, r10);
    }

    private final Map<String, Object> toMap(k r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(com.bytedance.android.annie.param.b.b(r10));
        int r11 = com.bytedance.android.annie.a.a;
        String r12 = getBizKey();
        Intrinsics.checkNotNullParameter(r0, "mutableMap");
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        ((com.bytedance.android.annie.param.m) Annie.getService(com.bytedance.android.annie.param.m.class, r12)).W0(r0);
        return r0;
    }

    private final Map<String, Object> wrapperUpdateGlobalProps(Map<String, ? extends Object> r10) {
        HashMap r0 = new HashMap();
        if (r10 == null) goto L5;
        r0.putAll(r10);
    L5:
        r0.put("offline", Boolean.valueOf(this.mIsOffline));
        return r0;
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public void registerLifecycleCallback(com.bytedance.android.annie.card.base.b r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycleCallback");
        if ((r10 instanceof f) == false) goto L5;
        this.mLifecycleCallbacks.add(r10);
        return;
    L5:
        this.mLifecycleCallbacks.add(new f(r10));
    }

    public void reloadTemplate(Map<String, ? extends Object> r10) {
        Iterator<T> r0 = this.mLifecycleCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onCardLoadStart();
        goto L4
    L6:
        LynxView r1 = this.mLynxView;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, java.lang.Object>");
        TemplateData r11 = TemplateData.fromMap(r10);
        r11.markReadOnly();
        r1.reloadTemplate(r11);
        Iterator<T> r12 = this.mLifecycleCallbacks.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((f) r12.next()).g(this.mLynxView, getUrl());
        goto L8
    L10:
        Iterator<T> r13 = this.mLifecycleCallbacks.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        ((f) r13.next()).onEngineLoadEnd();
        goto L12
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void updateData(Map<String, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        this.mLynxView.updateData(r10);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void updateGlobalProps(Map<String, ? extends Object> r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        k r1 = this.mGlobalPropsParams;
        if (r1 == null) goto L7;
        Map<String, Object> r11 = toMap(r1);
        if (r11 == null) goto L7;
        r0.putAll(r11);
    L7:
        if (r10 == null) goto L9;
        r0.putAll(r10);
    L9:
        this.mLynxView.updateGlobalProps(removeBlackKey(r0));
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public void updateHybridParamsNew(CardParamVoNew r10) {
        Intrinsics.checkNotNullParameter(r10, "params");
        super.updateHybridParamsNew(r10);
        this.mCardParamVoNew = r10;
        Pair<Integer, Integer> r11 = getViewPort();
        this.mLynxView.updateViewport(((Number) r11.getFirst()).intValue(), ((Number) r11.getSecond()).intValue());
    }

    public static final /* synthetic */ void access$setMIsOffline$p(LynxComponent r0, boolean r1) {
        r0.mIsOffline = r1;
    }

    private final Map<String, Object> createGlobalProps(boolean r10, String r11) {
        a r0 = Companion;
        Context r1 = this.mContext;
        String r12 = getSchema();
        String r13 = containerId();
        com.bytedance.android.annie.param.a r14 = this.mAnnieContext;
        r0.getClass();
        k r15 = a.b(r1, r12, r11, r13, r14, r10);
        r15.y1(getForestSessionID());
        Bundle r16 = this.mAnnieContext.getBundle();
        if (r16 == null) goto L5;
        int r17 = r16.getInt("isPrerender");
    L6:
        r15.W1(r17);
        this.mGlobalPropsParams = r15;
        return toMap(r15);
    L5:
        r17 = 0;
        goto L6
    }

    private final Map<String, Object> getGlobalPropsParamsInternal(boolean r10, String r11) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r0.putAll(createGlobalProps(r10, r11));
        return r0;
    }

    private final void realLoad(String r13, Map<String, ? extends Object> r14) {
        LynxTemplateProvider r0 = this.templateProvider;
        AnnieResType r1 = AnnieResType.LYNX_TEMPLATE;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r1, "resType");
        byte[] r10 = null;
        if (r0.a.a == false) goto L64;
    L62:
        handleLocalTemplate(r10, r13, r14);
        return;
    L64:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(UriProtector.parse(r13).getPath());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r12) == false) goto L12;
        r12 = null;
    L12:
        String r15 = (String) r12;
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        com.bytedance.android.annie.lynx.resource.c r16 = r0.e;
        if (r16 == null) goto L18;
        r16.b(r13, r15);
    L18:
        Boolean r17 = com.bytedance.android.annie.lynx.resource.a.a;
        WebResourceResponse r18 = com.bytedance.android.annie.service.resource.a.a.j(r13);
        if (r18 == null) goto L21;
        InputStream r19 = r18.getData();
    L22:
        byte[] r20 = com.bytedance.android.annie.lynx.resource.a.a(r19);
        if (r20 != null) goto L26;
    L52:
        com.bytedance.android.annie.lynx.resource.c r21 = r0.e;
        if (r21 == null) goto L62;
        if (r10 == null) goto L57;
        boolean r22 = true;
    L58:
        if (r10 != null) goto L60;
        String r23 = "cdn";
    L61:
        r21.a(new com.bytedance.android.annie.card.web.resource.a(r22, r23, 0, false));
        goto L62
    L60:
        r23 = "gecko";
        goto L61
    L57:
        r22 = false;
        goto L58
    L26:
        if (r20.length != 0) goto L28;
        boolean r24 = true;
    L29:
        if (r24 == false) goto L32;
        Pair r25 = TuplesKt.to(VerifyTemplateType.EMPTY_FILE, null);
    L39:
        VerifyTemplateType r26 = (VerifyTemplateType) r25.component1();
        Pair r27 = (Pair) r25.component2();
        if (r26 == VerifyTemplateType.VERIFY_SUCCEED) goto L51;
        com.bytedance.android.annie.lynx.resource.c r28 = r0.e;
        if (r28 == null) goto L52;
        String r29 = r26.getTYPE();
        if (r27 == null) goto L46;
        int r30 = ((Number) r27.getFirst()).intValue();
    L47:
        if (r27 == null) goto L49;
        int r31 = ((Number) r27.getSecond()).intValue();
    L50:
        r28.c(r29, r15, r30, r31);
        goto L52
    L49:
        r31 = 0;
        goto L50
    L46:
        r30 = 0;
        goto L47
    L51:
        r10 = r20;
        goto L52
    L32:
        if (r20.length >= 4) goto L34;
        int r32 = -1;
    L36:
        if (r32 == r20.length) goto L38;
        r25 = TuplesKt.to(VerifyTemplateType.BROKEN_FILE, TuplesKt.to(Integer.valueOf(r32), Integer.valueOf(r20.length)));
        goto L39
    L38:
        r25 = TuplesKt.to(VerifyTemplateType.VERIFY_SUCCEED, null);
        goto L39
    L34:
        r32 = (((r20[0] & 255) | ((r20[1] & 255) << 8)) | ((r20[2] & 255) << 16)) | ((r20[3] & 255) << 24);
        goto L36
    L28:
        r24 = false;
        goto L29
    L21:
        r19 = null;
    L7:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void load(String r10, Map<String, ? extends Object> r11) {
        x8.b r0 = this.mAnnieContext.d;
        StringBuilder r1 = new StringBuilder("===load start: ");
        String r12 = getUrl();
        String r13 = "empty";
        if (r12 != null) goto L5;
        r12 = "empty";
    L5:
        r1.append(r12);
        r1.append("===");
        r0.f(TAG, "component_load_start", r1.toString());
        Iterator<T> r14 = this.mLifecycleCallbacks.iterator();
    L7:
        if (r14.hasNext() == false) goto L10;
        ((f) r14.next()).onCardLoadStart();
        goto L7
    L10:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        Intrinsics.checkNotNull(r10);
        setUrl(r10);
        realLoad(r10, r11);
    L17:
        Iterator<T> r15 = this.mLifecycleCallbacks.iterator();
    L19:
        if (r15.hasNext() == false) goto L21;
        ((f) r15.next()).onEngineLoadEnd();
        goto L19
    L21:
        x8.b r16 = this.mAnnieContext.d;
        StringBuilder r17 = new StringBuilder("===load end: ");
        String r18 = getUrl();
        if (r18 == null) goto L25;
        r13 = r18;
    L25:
        r17.append(r13);
        r17.append("===");
        r16.f(TAG, "component_load_end", r17.toString());
        return;
    L13:
        if (this.mCardParamVoNew == null) goto L17;
        String r19 = getUrl();
        if (TextUtils.isEmpty(r19) == true) goto L17;
        Intrinsics.checkNotNull(r19);
        realLoad(r19, r11);
        goto L17
    }

    @Override // com.bytedance.android.annie.card.base.BaseHybridComponent
    public void updateScreenMetrics(int r10, int r11) {
        this.mLynxView.updateScreenMetrics(r10, r11);
    }

    private final Map<String, Object> getRenderData(boolean r10, String r11, Map<String, ? extends Object> r12) {
        Iterator<T> r0 = this.mLifecycleCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onBeforeGlobalPropsInitialize();
        goto L4
    L6:
        ((ILatchService) getService(ILatchService.class)).S0(r11);
        Map<String, Object> r13 = getGlobalPropsParamsInternal(r10, r11);
        Iterator<T> r1 = this.mLifecycleCallbacks.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((f) r1.next()).onGlobalPropsInitialized();
        goto L8
    L10:
        Iterator<T> r14 = this.mLifecycleCallbacks.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        ((f) r14.next()).onBeforeInitialPropsInitialize();
        goto L12
    L14:
        CardParamVoNew r15 = this.mCardParamVoNew;
        if (r15 == null) goto L17;
        String r16 = r15.o();
    L18:
        Map<String, Object> r17 = observeWith(r11, r16);
        Iterator<T> r18 = this.mLifecycleCallbacks.iterator();
    L20:
        if (r18.hasNext() == false) goto L22;
        ((f) r18.next()).onInitialPropsInitialized();
        goto L20
    L22:
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put(BaseHybridComponent.GLOBAL_PROPS, r13);
        r19.put(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY, r17);
        if (r12 == null) goto L25;
        r19.putAll(r12);
    L25:
        return r19;
    L17:
        r16 = null;
        goto L18
    }

    private final void handleLocalTemplate(byte[] r10, String r11, Map<String, ? extends Object> r12) {
        x8.b r0 = this.mAnnieContext.d;
        StringBuilder r1 = new StringBuilder("===handleLocalTemplate: ");
        String r13 = getUrl();
        if (r13 != null) goto L5;
        r13 = "empty";
    L5:
        r1.append(r13);
        r1.append("===");
        r0.e(TAG, r1.toString());
        if (r10 == null) goto L8;
        boolean r14 = true;
    L9:
        this.mIsOffline = r14;
        this.mAnnieContext.d.e(TAG, "===handleLocalTemplate realUrl: " + r11 + ", is Offline Resource: " + this.mIsOffline + ", is use forest loader: " + this.loaderConfig.a);
        this.templateProvider.g = r11;
        renderTemplate(r10, appendUrlQuery(r11), r12);
        return;
    L8:
        r14 = false;
        goto L9
    }

    private final void renderTemplate(byte[] r10, String r11, Map<String, ? extends Object> r12) {
        Iterator<T> r0 = this.mLifecycleCallbacks.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((f) r0.next()).onBeforeCreateRenderData(this.mLynxView);
        goto L4
    L6:
        if (r10 == null) goto L8;
        boolean r1 = true;
    L9:
        Map<String, Object> r13 = getRenderData(r1, r11, r12);
        Object r14 = r13.get(BaseHybridComponent.INITIAL_PROPS_QUERY_KEY);
        Map<String, ? extends Object> r15 = null;
        if ((r14 instanceof Map) == false) goto L15;
        Set<String> r16 = ((Map) r14).keySet();
        if ((r16 instanceof Set) == true) goto L16;
        r16 = null;
    L16:
        Iterator<T> r17 = this.mLifecycleCallbacks.iterator();
    L18:
        if (r17.hasNext() == false) goto L62;
        f r18 = (f) r17.next();
        LynxView r19 = this.mLynxView;
        if (r16 != null) goto L22;
        Set<String> r20 = SetsKt.emptySet();
    L23:
        r18.onCreateRenderData(r19, r20);
        goto L18
    L22:
        r20 = r16;
        goto L23
    L62:
        d8.b r21 = e.a;     // Catch: Throwable -> L26
        Intrinsics.checkNotNullParameter(r11, "<set-?>");     // Catch: Throwable -> L26
        e.c = r11;     // Catch: Throwable -> L26
        HashMap r22 = new HashMap();     // Catch: Throwable -> L26
        r22.put("last_lynx_url", r11);     // Catch: Throwable -> L26
        r22.put("lynx_sdk_version", LynxEnv.inst().getLynxVersion());     // Catch: Throwable -> L26
        Npth.addTags(r22);     // Catch: Throwable -> L26
    L27:
        Iterator<T> r23 = this.mLifecycleCallbacks.iterator();
    L29:
        if (r23.hasNext() == false) goto L31;
        ((f) r23.next()).onEngineLoadStart();
        goto L29
    L31:
        int r24 = com.bytedance.android.annie.param.b.a;
        Object r25 = r13.get(BaseHybridComponent.GLOBAL_PROPS);
        if ((r25 instanceof Map) == false) goto L34;
        Map<String, ? extends Object> r26 = (Map) r25;
    L35:
        k r27 = this.mGlobalPropsParams;
        if (r27 == null) goto L38;
        Map<String, ? extends Object> r28 = r27.a;
    L39:
        if (r28 != null) goto L43;
        if (r27 == null) goto L42;
        r15 = r27.b;
    L42:
        if (r15 != null) goto L43;
    L53:
        this.mLynxView.setGlobalProps(removeBlackKey(r26));
        r13.remove(BaseHybridComponent.GLOBAL_PROPS);
        ((i9.d) getService(i9.d.class)).U0(this.mLynxView);
        updateReportingEventsParamsForLynxView();
        if (r10 == null) goto L56;
        LynxView r29 = this.mLynxView;
        TemplateData r30 = TemplateData.fromMap(r13);
        r30.markReadOnly();
        Unit r31 = Unit.INSTANCE;
        r29.renderTemplateWithBaseUrl(r10, r30, r11);
    L57:
        x8.b r32 = this.mAnnieContext.d;
        StringBuilder r33 = new StringBuilder("===renderTemplate: ");
        String r34 = getUrl();
        if (r34 != null) goto L60;
        r34 = "empty";
    L60:
        r33.append(r34);
        r33.append("===");
        r32.f(TAG, "on_render_template", r33.toString());
        return;
    L56:
        LynxView r35 = this.mLynxView;
        TemplateData r36 = TemplateData.fromMap(r13);
        r36.markReadOnly();
        Unit r37 = Unit.INSTANCE;
        r35.renderTemplateUrl(r11, r36);
    L43:
        LinkedHashMap r38 = new LinkedHashMap();
        if (r26 == null) goto L46;
        r38.putAll(r26);
    L46:
        Map<String, ? extends Object> r39 = r27.a;
        if (r39 == null) goto L49;
        r38.put("prefetch_data", r39);
    L49:
        Map<String, ? extends Object> r40 = r27.b;
        if (r40 == null) goto L52;
        r38.put("storage_data", r40);
    L52:
        r26 = r38;
        goto L53
    L38:
        r28 = null;
        goto L39
    L34:
        r26 = null;
    L26:
        EnsureManager.ensureNotReachHere("Npth.addTags exception");
        goto L27
    L15:
        r16 = SetsKt.emptySet();
        goto L16
    L8:
        r1 = false;
        goto L9
    }

    public LynxComponent(Context r10, CardParamVoNew r11, com.bytedance.android.annie.card.base.b r12, j9.a r13, com.bytedance.android.annie.param.a r14) {
        Intrinsics.checkNotNullParameter(r10, "mContext");
        Intrinsics.checkNotNullParameter(r12, "mInitializeLifecycle");
        Intrinsics.checkNotNullParameter(r13, "monitorProvider");
        Intrinsics.checkNotNullParameter(r14, "mAnnieContext");
        super(r14);
        this.mContext = r10;
        this.mCardParamVoNew = r11;
        this.mInitializeLifecycle = r12;
        this.monitorProvider = r13;
        this.mAnnieContext = r14;
        ConcurrentLinkedQueue<f> r15 = new ConcurrentLinkedQueue();
        this.mLifecycleCallbacks = r15;
        CardParamVoNew r16 = this.mCardParamVoNew;
        if (r16 == null) goto L5;
        int r17 = r16.y;
    L6:
        this.mPresetWidth = r17;
        this.mLynxJsBridgeListenerProxy = new b(this);
        this.useForestLoadImg$delegate = LazyKt.lazy(LynxComponent$useForestLoadImg$2.INSTANCE);
        this.tryFixViewSizeOnPreDraw$delegate = LazyKt.lazy(LynxComponent$tryFixViewSizeOnPreDraw$2.INSTANCE);
        this.imageCache = new HashMap();
        d r18 = new d(this);
        this.intercept = r18;
        x8.b r19 = r14.d;
        StringBuilder r20 = new StringBuilder("===init start: ");
        String r0 = getUrl();
        String r1 = "empty";
        if (r0 != null) goto L9;
        r0 = "empty";
    L9:
        r20.append(r0);
        r20.append("===");
        r19.f(TAG, "init_component", r20.toString());
        preLynxViewCreate();
        this.mJSBridgeManager = new JSBridgeManager(r14);
        g r21 = new g();
        String r22 = getUrl();
        if (r22 != null) goto L12;
        r22 = "";
    L12:
        IHybridComponent.HybridType r110 = IHybridComponent.HybridType.LYNX;
        CardParamVoNew r23 = this.mCardParamVoNew;
        if (r23 == null) goto L15;
        String r24 = r23.j();
    L16:
        r21.a = n.j(r22, r110, r24);
        CardParamVoNew r25 = this.mCardParamVoNew;
        if (r25 == null) goto L19;
        boolean r26 = r25.p0();
    L20:
        r21.c = n.i(r26);
        String r27 = getForestSessionID();
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r21.d = r27;
        CardParamVoNew r28 = this.mCardParamVoNew;
        if (r28 == null) goto L23;
        String r29 = r28.w0();
    L24:
        boolean r30 = !Intrinsics.areEqual(r29, "downloader");
        r21.e = r30;
        r18.a = r30;
        this.loaderConfig = r21;
        this.xResourceLoader = new h(r21, r18);
        LynxTemplateProvider r31 = new LynxTemplateProvider(r21);
        Intrinsics.checkNotNullParameter(r18, "interceptor");
        r31.f = r18;
        this.templateProvider = r31;
        com.bytedance.android.annie.lynx.resource.d r32 = new com.bytedance.android.annie.lynx.resource.d(r21);
        Intrinsics.checkNotNullParameter(r18, "interceptor");
        r32.e = r18;
        this.dynamicComponentProvider = r32;
        LynxExternalJSProvider r33 = new LynxExternalJSProvider(r21);
        Intrinsics.checkNotNullParameter(r18, "interceptor");
        r33.d = r18;
        this.externalJsProvider = r33;
        this.mLynxView = createLynxViewAndBridge();
        initTemplateProviderCallback();
        Iterator<f> r34 = r15.iterator();
    L26:
        if (r34.hasNext() == false) goto L41;
        f r35 = r34.next();
        LynxView r36 = this.mLynxView;
        CardParamVoNew r111 = this.mCardParamVoNew;
        if (r111 == null) goto L30;
        String r112 = r111.H0();
    L31:
        r35.f(r36, new d8.a(r112, containerId()));
        goto L26
    L30:
        r112 = null;
        goto L31
    L41:
        g8.a r37 = (g8.a) getService(g8.a.class);     // Catch: Exception -> L34
        containerId();     // Catch: Exception -> L34
        r37.initXBridge();     // Catch: Exception -> L34
    L35:
        ((com.bytedance.android.annie.service.prefetch.p) getService(com.bytedance.android.annie.service.prefetch.p.class)).r0(this);
        x8.b r38 = this.mAnnieContext.d;
        StringBuilder r39 = new StringBuilder("===init end: ");
        String r40 = getUrl();
        if (r40 == null) goto L39;
        r1 = r40;
    L39:
        r39.append(r1);
        r39.append("===");
        r38.f(TAG, "init_component_end", r39.toString());
        AnnieNGServiceCenter.a.f(z8.b.class, new z8.a(), "default");
        return;
    L23:
        r29 = null;
        goto L24
    L19:
        r26 = false;
        goto L20
    L15:
        r24 = null;
        goto L16
    L5:
        r17 = -1;
        goto L6
    }

    public static /* synthetic */ Map getGlobalPropsParamsInternal$default(LynxComponent r0, boolean r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.mIsOffline;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.getUrl();
    L9:
        return r0.getGlobalPropsParamsInternal(r1, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void realLoad$default(LynxComponent r0, String r1, Map r10, int r11, Object r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        r0.realLoad(r1, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleLocalTemplate$default(LynxComponent r0, byte[] r1, String r10, Map r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        r0.handleLocalTemplate(r1, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void renderTemplate$default(LynxComponent r0, byte[] r1, String r10, Map r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        r0.renderTemplate(r1, r10, r11);
    }
}
