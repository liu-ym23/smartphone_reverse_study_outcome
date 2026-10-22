package com.bytedance.forest;

import android.app.Application;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebResourceResponse;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.solver.CodeGenScope;
import androidx.room.writer.DaoWriter;
import com.bytedance.android.anniex.scene.core.i;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.chain.fetchers.MemoryFetcher;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.ForestEnvData;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.Status;
import com.bytedance.forest.model.k;
import com.bytedance.forest.model.m;
import com.bytedance.forest.model.r;
import com.bytedance.forest.model.s;
import com.bytedance.forest.model.t;
import com.bytedance.forest.model.u;
import com.bytedance.forest.model.w;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.forest.pollyfill.q;
import com.bytedance.forest.postprocessor.ForestPostProcessor;
import com.bytedance.forest.postprocessor.PostProcessRequest;
import com.bytedance.forest.postprocessor.h;
import com.bytedance.forest.utils.ThreadUtils$Priority;
import com.bytedance.forest.utils.e;
import com.bytedance.forest.utils.j;
import com.bytedance.forest.utils.l;
import com.bytedance.keva.Keva;
import com.google.android.material.internal.ViewUtils;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.p;
import com.lynx.tasm.behavior.v0;
import com.lynx.tasm.ui.image.f0;
import com.lynx.tasm.utils.g;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 x2\u00020\u0001:\u0001xB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u0018\u001a\u0004\u0018\u00010\u0017\"\b\b\u0000\u0010\u0012*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001f\"\b\b\u0000\u0010\u0012*\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0017H\u0001¢\u0006\u0004\b#\u0010$J-\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\b\b\u0000\u0010\u0012*\u00020\u00012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0001¢\u0006\u0004\b&\u0010'J\u0019\u0010*\u001a\u00020\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\b¢\u0006\u0004\b,\u0010-J/\u00100\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b0\u00101JO\u00100\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u0001022\"\b\u0002\u00106\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u000104\u0018\u00010\u0014j\u0004\u0018\u0001`5H\u0007¢\u0006\u0004\b0\u00107J\u0099\u0001\u00100\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00109\u001a\u0002082\u000e\b\u0002\u0010:\u001a\b\u0012\u0002\b\u0003\u0018\u0001042\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010>\u001a\u00020=2\"\b\u0002\u00106\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u000104\u0018\u00010\u0014j\u0004\u0018\u0001`5H\u0007¢\u0006\u0004\b0\u0010?JA\u00100\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010@\u001a\u00020\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b0\u0010AJc\u00100\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010@\u001a\u00020\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\b2\"\b\u0002\u00106\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u000104\u0018\u00010\u0014j\u0004\u0018\u0001`5¢\u0006\u0004\b0\u0010BJ\u001f\u0010C\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\bC\u0010\u000eJ/\u0010H\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001a2\u0006\u0010E\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bH\u0010IJ;\u0010J\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010G\u001a\u00020F2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002¢\u0006\u0004\bJ\u0010KJ3\u0010M\u001a\u00020\u000f2\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020F2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002¢\u0006\u0004\bM\u0010NJ3\u0010O\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020F2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010L\u001a\u00020\u001aH\u0002¢\u0006\u0004\bO\u0010PJ)\u0010Q\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010G\u001a\u00020FH\u0002¢\u0006\u0004\bQ\u0010RJ\u007f\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020Z0Y\u0018\u00010T2\b\u0010S\u001a\u0004\u0018\u0001022\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0T2\u0006\u0010V\u001a\u00020\f2\u0006\u0010X\u001a\u00020W2\u0006\u0010>\u001a\u00020=2\"\b\u0002\u00106\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u000104\u0018\u00010\u0014j\u0004\u0018\u0001`5H\u0002¢\u0006\u0004\b[\u0010\\R\u0017\u0010^\u001a\u00020]8\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010c\u001a\u00020b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001b\u0010l\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u001a\u0010n\u001a\u00020m8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010r\u001a\u0004\bs\u0010tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010u\u001a\u0004\bv\u0010w¨\u0006y"}, d2 = {"Lcom/bytedance/forest/Forest;", "", "Landroid/app/Application;", "application", "Lcom/bytedance/forest/model/k;", "config", "<init>", "(Landroid/app/Application;Lcom/bytedance/forest/model/k;)V", "", "url", "Lcom/bytedance/forest/model/t;", LynxResourceModule.PARAMS_KEY, "", "isPreloaded", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;)Z", "", "onLowMemory", "()V", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/forest/postprocessor/e;", "Lkotlin/Function1;", "Lcom/bytedance/forest/postprocessor/g;", "callback", "Lcom/bytedance/forest/model/s;", "fetchAsyncWithProcessor", "(Ljava/lang/String;Lcom/bytedance/forest/postprocessor/e;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/forest/model/s;", "Lcom/bytedance/forest/model/w;", "fetchResourceAsync", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/forest/model/s;", "createSyncRequest", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;)Lcom/bytedance/forest/model/s;", "Lcom/bytedance/forest/postprocessor/d;", "createSyncRequestWithProcessor", "(Ljava/lang/String;Lcom/bytedance/forest/postprocessor/e;)Lcom/bytedance/forest/postprocessor/d;", "operation", "fetchSync$forest_release", "(Lcom/bytedance/forest/model/s;)Lcom/bytedance/forest/model/w;", "fetchSync", "fetchSyncWithProcessor$forest_release", "(Lcom/bytedance/forest/postprocessor/d;)Lcom/bytedance/forest/postprocessor/g;", "fetchSyncWithProcessor", "sessionId", "openSession", "(Ljava/lang/String;)Ljava/lang/String;", "closeSession", "(Ljava/lang/String;)V", "Lcom/bytedance/forest/model/r;", "containerId", "preload", "(Lcom/bytedance/forest/model/r;Ljava/lang/String;Ljava/lang/String;)V", "Lorg/json/JSONObject;", "subRes", "Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "Lcom/bytedance/forest/PostProcessorBuilder;", "postProcessorBuilder", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;Lorg/json/JSONObject;Lkotlin/jvm/functions/Function1;)V", "Lcom/bytedance/forest/model/PreloadType;", "type", "processor", "from", "userAgent", "", "maxAge", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/forest/model/PreloadType;Lcom/bytedance/forest/postprocessor/ForestPostProcessor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "withSubResources", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;ZLjava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;ZLjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "checkRequestValid", "originResponse", "waited", "Lcom/bytedance/forest/utils/e;", "context", "reuseResponse", "(Lcom/bytedance/forest/model/w;ZLcom/bytedance/forest/model/t;Lcom/bytedance/forest/utils/e;)Lcom/bytedance/forest/model/w;", "fetchAsyncInner", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;Lcom/bytedance/forest/utils/e;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/forest/model/s;", "response", "finishWithCallback", "(Lcom/bytedance/forest/model/w;Lcom/bytedance/forest/utils/e;Lkotlin/jvm/functions/Function1;)V", "triggerCallback", "(Lcom/bytedance/forest/utils/e;Lkotlin/jvm/functions/Function1;Lcom/bytedance/forest/model/w;)V", "checkRequestReuseValid", "(Lcom/bytedance/forest/model/w;Lcom/bytedance/forest/model/t;Lcom/bytedance/forest/utils/e;)Z", "json", "", "envParams", "disableCdn", "Lcom/bytedance/forest/pollyfill/NetWorker;", "netWorker", "", "Lcom/bytedance/forest/model/u;", "parseSubResourceConfig", "(Lorg/json/JSONObject;Ljava/util/Map;ZLcom/bytedance/forest/pollyfill/NetWorker;ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "geckoXAdapter", "Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "getGeckoXAdapter", "()Lcom/bytedance/forest/chain/fetchers/GeckoXAdapter;", "Lcom/bytedance/forest/utils/j;", "memoryManager", "Lcom/bytedance/forest/utils/j;", "getMemoryManager$forest_release", "()Lcom/bytedance/forest/utils/j;", "Lcom/bytedance/forest/preload/d;", "preLoader$delegate", "Lkotlin/Lazy;", "getPreLoader", "()Lcom/bytedance/forest/preload/d;", "preLoader", "Lcom/bytedance/forest/d;", "sessionManager", "Lcom/bytedance/forest/d;", "getSessionManager$forest_release", "()Lcom/bytedance/forest/d;", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "Lcom/bytedance/forest/model/k;", "getConfig", "()Lcom/bytedance/forest/model/k;", "Companion", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class Forest {
    public static final Companion Companion = null;
    public static Application app;
    private static int cdnCacheDiskMaxAge;
    private static boolean enableKEVAOpt;
    private static ForestEnvData envData;
    private static final CopyOnWriteArrayList<WeakReference<Forest>> instanceRefs = null;
    private final Application application;
    private final k config;
    private final GeckoXAdapter geckoXAdapter;
    private final j memoryManager;
    private final Lazy preLoader$delegate;
    private final d sessionManager;

    @Keep
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\bR#\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0%8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u0015R\"\u00101\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u0010\u0018¨\u00066"}, d2 = {"Lcom/bytedance/forest/Forest$Companion;", "", "<init>", "()V", "Lcom/bytedance/forest/model/ForestEnvData;", "env", "", "injectEnv", "(Lcom/bytedance/forest/model/ForestEnvData;)V", "", "url", "Lcom/bytedance/forest/model/t;", LynxResourceModule.PARAMS_KEY, "", "isPreloaded", "(Ljava/lang/String;Lcom/bytedance/forest/model/t;)Z", "onLowMemory", "sweepCDNDiskCachedFiles", "", "maxAgeInDay", "setCDNCacheDiskMaxAge", "(I)V", "enable", "setKEVAOptimize", "(Z)V", "Landroid/app/Application;", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "setApp", "(Landroid/app/Application;)V", "envData", "Lcom/bytedance/forest/model/ForestEnvData;", "getEnvData$forest_release", "()Lcom/bytedance/forest/model/ForestEnvData;", "setEnvData$forest_release", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/forest/Forest;", "instanceRefs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getInstanceRefs", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "cdnCacheDiskMaxAge", "I", "getCdnCacheDiskMaxAge$forest_release", "()I", "setCdnCacheDiskMaxAge$forest_release", "enableKEVAOpt", "Z", "getEnableKEVAOpt$forest_release", "()Z", "setEnableKEVAOpt$forest_release", "forest_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ boolean isPreloaded$default(Companion r5, String r10, t r11, int r12, Object r13) {
            if ((r12 & 2) == 0) goto L6;
            r11 = null;
        L6:
            return r5.isPreloaded(r10, r11);
        }

        public final Application getApp() {
            Application r5 = Forest.access$getApp$cp();
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("app");
        L5:
            return r5;
        }

        public final int getCdnCacheDiskMaxAge$forest_release() {
            return Forest.access$getCdnCacheDiskMaxAge$cp();
        }

        public final boolean getEnableKEVAOpt$forest_release() {
            return Forest.access$getEnableKEVAOpt$cp();
        }

        public final ForestEnvData getEnvData$forest_release() {
            return Forest.access$getEnvData$cp();
        }

        public final CopyOnWriteArrayList<WeakReference<Forest>> getInstanceRefs() {
            return Forest.access$getInstanceRefs$cp();
        }

        @Keep
        public final void injectEnv(ForestEnvData r5) {
            setEnvData$forest_release(r5);
        }

        @Deprecated(message = "Using instance scope check instead of global scope", replaceWith = @ReplaceWith(expression = "forest.isPreloaded(url)", imports = {}))
        @JvmOverloads
        public final boolean isPreloaded(String r5) {
            return isPreloaded$default(this, r5, null, 2, null);
        }

        public final void onLowMemory() {
            Iterator<T> r5 = getInstanceRefs().iterator();
        L4:
            if (r5.hasNext() == false) goto L8;
            Forest r10 = (Forest) ((WeakReference) r5.next()).get();
            if (r10 == null) goto L4;
            r10.onLowMemory();
            goto L4
        }

        public final void setApp(Application r5) {
            Forest.access$setApp$cp(r5);
        }

        @JvmStatic
        public final void setCDNCacheDiskMaxAge(int r5) {
            setCdnCacheDiskMaxAge$forest_release(r5);
        }

        public final void setCdnCacheDiskMaxAge$forest_release(int r5) {
            Forest.access$setCdnCacheDiskMaxAge$cp(r5);
        }

        public final void setEnableKEVAOpt$forest_release(boolean r5) {
            Forest.access$setEnableKEVAOpt$cp(r5);
        }

        public final void setEnvData$forest_release(ForestEnvData r5) {
            Forest.access$setEnvData$cp(r5);
        }

        public final void setKEVAOptimize(boolean r5) {
            setEnableKEVAOpt$forest_release(r5);
        }

        @JvmStatic
        public final void sweepCDNDiskCachedFiles() {
            boolean r5 = true;
            if (q.f4535b.compareAndSet(false, true) == false) goto L57;
            long r10 = System.currentTimeMillis();
            long r11 = ((long) (Forest.Companion.getCdnCacheDiskMaxAge$forest_release() * 86400)) * 1000;
            File[] r12 = ((File) com.bytedance.forest.pollyfill.b.f4507a.getValue()).listFiles();
            if (r12 == null) goto L8;
        L7:
            File[] r13 = r12;
            int r14 = r13.length;
            int r15 = 0;
        L11:
            if (r15 >= r14) goto L52;
            File r16 = r13[r15];
            String r17 = r16.getName();
            List r18 = com.bytedance.forest.utils.k.f4646a;
            if (StringsKt.k(r17, CodeGenScope.TMP_VAR_DEFAULT_PREFIX) == true) goto L38;
            List r19 = StringsKt.K(r17, new String[]{DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD}, 0, 6);
            Object r110 = null;
            if (r19.size() == 3) goto L19;
            r19 = null;
        L19:
            if (r19 == null) goto L44;
            Keva r20 = l.f4649a;
            if (r20 == null) goto L23;
            boolean r21 = r20.contains(r17);
        L24:
            if (r21 == false) goto L38;
            Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L28
            Object r23 = Result.m124constructorimpl(StringsKt.toLongOrNull((String) r19.get(2)));     // Catch: Throwable -> L28
        L31:
            if (Result.m130isFailureimpl(r23) == true) goto L34;
            r110 = r23;
        L34:
            Long r111 = (Long) r110;
            if (r111 == null) goto L38;
            if (r111.longValue() >= System.currentTimeMillis()) goto L44;
        L28:
            th = move-exception;
            Result.Companion r24 = Result.Companion;
            r23 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L31
        L23:
            r21 = false;
        L44:
            if (r11 > 0) goto L45;
        L42:
            r5 = true;
            r15 = r15 + 1;
            goto L11
        L45:
            List r25 = com.bytedance.forest.utils.k.f4646a;
            if ((r16.lastModified() + r11) >= System.currentTimeMillis()) goto L42;
            f0.h("TTNetDepender", 60, g.d("clean file: ", r17, " cause last usage time overdue"), false);
            Keva r26 = l.f4649a;
            if (r26 == null) goto L50;
            r26.erase(r17);
        L50:
            r16.delete();
        L38:
            f0.h("TTNetDepender", 60, g.d("clean file: ", r17, " cause overdue"), false);
            Keva r27 = l.f4649a;
            if (r27 == null) goto L41;
            r27.erase(r17);
        L41:
            r16.delete();
            goto L42
        L52:
            l.a();
            f0.h("TTNetDepender", 56, "sweep cached files cost:" + (System.currentTimeMillis() - r10), r5);
            q.f4535b.set(false);
            return;
        L8:
            r12 = new File[0];
            goto L7
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @Deprecated(message = "Using instance scope check instead of global scope", replaceWith = @ReplaceWith(expression = "forest.isPreloaded(url)", imports = {}))
        @JvmOverloads
        public final boolean isPreloaded(String r10, t r11) {
            boolean r5 = false;
            if (r11 != null) goto L27;
            r11 = new t(Scene.f4354n);
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L8
            Object r13 = Result.m124constructorimpl(Uri.parse(r10));     // Catch: Throwable -> L8
        L11:
            if (Result.m130isFailureimpl(r13) == false) goto L13;
            r13 = null;
        L13:
            Uri r14 = (Uri) r13;
            if (r14 == null) goto L27;
            String r15 = com.lynx.tasm.utils.b.g(r14, "forest_key_include");
            if (r15 == null) goto L25;
            List r16 = StringsKt.K(r15, new String[]{","}, 0, 6);
            if (r16 == null) goto L25;
            if (r16.isEmpty() == false) goto L23;
            r16 = null;
        L23:
            if (r16 == null) goto L25;
            Set r17 = CollectionsKt.toSet(r16);
        L26:
            r11.F = r17;
            r11.G = Intrinsics.areEqual(r14.getQueryParameter("forest_key_ua_include"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        L25:
            r17 = null;
        L8:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        L27:
            com.bytedance.forest.utils.a r19 = p.c(r10, r11, null);
            if (r19 == null) goto L35;
            Iterator r20 = com.bytedance.forest.preload.d.f4569c.iterator();
        L31:
            if (r20.hasNext() == false) goto L35;
            com.bytedance.forest.preload.d r21 = (com.bytedance.forest.preload.d) ((WeakReference) r20.next()).get();
            if (r21 == null) goto L31;
            r5 = r5 | r21.e(r19);
        L35:
            return r5;
        }
    }

    static {
        Companion = new Companion(null);
        instanceRefs = new CopyOnWriteArrayList();
    }

    public Forest(Application r5, k r10) {
        this.application = r5;
        this.config = r10;
        this.geckoXAdapter = new GeckoXAdapter(r5, this);
        this.memoryManager = new j(r10.d, r10.e);
        this.preLoader$delegate = LazyKt.lazy(new Forest$preLoader$2(this));
        app = r5;
        CopyOnWriteArrayList<WeakReference<Forest>> r11 = instanceRefs;
        if (r11.isEmpty() == false) goto L5;
        com.bytedance.forest.utils.k.e(r5);
    L5:
        r11.add(new WeakReference(this));
        this.sessionManager = new d(r5);
    }

    public static final /* synthetic */ boolean access$checkRequestReuseValid(Forest r5, w r10, t r11, e r12) {
        return r5.checkRequestReuseValid(r10, r11, r12);
    }

    public static final /* synthetic */ s access$fetchAsyncInner(Forest r5, String r10, t r11, e r12, Function1 r13) {
        return r5.fetchAsyncInner(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$finishWithCallback(Forest r5, w r10, e r11, Function1 r12) {
        r5.finishWithCallback(r10, r11, r12);
    }

    public static final /* synthetic */ Application access$getApp$cp() {
        return app;
    }

    public static final /* synthetic */ int access$getCdnCacheDiskMaxAge$cp() {
        return cdnCacheDiskMaxAge;
    }

    public static final /* synthetic */ boolean access$getEnableKEVAOpt$cp() {
        return enableKEVAOpt;
    }

    public static final /* synthetic */ ForestEnvData access$getEnvData$cp() {
        return envData;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getInstanceRefs$cp() {
        return instanceRefs;
    }

    public static final /* synthetic */ com.bytedance.forest.preload.d access$getPreLoader$p(Forest r5) {
        return r5.getPreLoader();
    }

    public static final /* synthetic */ Map access$parseSubResourceConfig(Forest r5, JSONObject r10, Map r11, boolean r12, NetWorker r13, int r14, Function1 r15) {
        return r5.parseSubResourceConfig(r10, r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ w access$reuseResponse(Forest r5, w r10, boolean r11, t r12, e r13) {
        return r5.reuseResponse(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$setApp$cp(Application r5) {
        app = r5;
    }

    public static final /* synthetic */ void access$setCdnCacheDiskMaxAge$cp(int r5) {
        cdnCacheDiskMaxAge = r5;
    }

    public static final /* synthetic */ void access$setEnableKEVAOpt$cp(boolean r5) {
        enableKEVAOpt = r5;
    }

    public static final /* synthetic */ void access$setEnvData$cp(ForestEnvData r5) {
        envData = r5;
    }

    public static final /* synthetic */ void access$triggerCallback(Forest r5, e r10, Function1 r11, w r12) {
        r5.triggerCallback(r10, r11, r12);
    }

    private final boolean checkRequestReuseValid(w r10, t r11, e r12) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.f4442r == true) goto L9;
        return false;
    L9:
        if (r10.f4441q.getScene() == Scene.f) goto L11;
    L13:
        String r5 = r10.f4443t;
        ResourceFrom r13 = null;
        if (r5 != null) goto L16;
    L21:
        File r14 = null;
    L22:
        ResourceFrom r15 = r10.f4444u;
        if (r15 == ResourceFrom.d) goto L25;
        r13 = r15;
    L25:
        if (r13 != null) goto L28;
        r13 = r10.f4445v;
    L28:
        if (r13 == null) goto L35;
        int r16 = r13.ordinal();
        if (r16 == 0) goto L52;
        if (r16 != 1) goto L34;
        boolean r17 = com.lynx.tasm.behavior.utils.d.g(r10.f4443t);
    L54:
        if (r17 == true) goto L57;
        return false;
    L57:
        if ((r10 instanceof com.bytedance.forest.postprocessor.g) == true) goto L59;
    L70:
        return true;
    L59:
        if (((com.bytedance.forest.postprocessor.g) r10).D == false) goto L70;
        if ((r11 instanceof com.bytedance.forest.postprocessor.e) == true) goto L63;
        return false;
    L63:
        Request r18 = r10.f4441q;
        if (r18 == null) goto L69;
        if (Intrinsics.areEqual(((PostProcessRequest) r18).getPostProcessor$forest_release().getClass(), ((com.bytedance.forest.postprocessor.e) r11).I.getClass()) == true) goto L70;
        return false;
    L69:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.PostProcessRequest<*>");
    L34:
        if (r16 != 2) goto L35;
        String r19 = r10.f4441q.getOriginUrl();
        com.bytedance.forest.chain.fetchers.j r20 = MemoryFetcher.Companion;
        com.bytedance.forest.pollyfill.l r21 = r10.b();
        int r22 = r10.f4441q.getCustomHttpMaxAge();
        r20.getClass();
        if (com.bytedance.forest.chain.fetchers.j.a(r19, r21, r14, r12, r22) == false) goto L45;
        r10.f4441q.getForest().memoryManager.a(r10.f4441q.getCacheKey$forest_release());
    L44:
        r17 = false;
        goto L54
    L45:
        if (r14 == null) goto L49;
        if (r14.isFile() != true) goto L49;
    L50:
        r17 = true;
    L49:
        if (r10.i() == null) goto L44;
    L52:
        if (r14 == null) goto L44;
        r17 = r14.isFile();
    L35:
        if (r14 == null) goto L39;
        if (r14.isFile() == true) goto L50;
    L39:
        if (r10.i() == null) goto L44;
    L16:
        if (com.lynx.tasm.behavior.utils.d.g(r5) == true) goto L19;
        r5 = null;
    L19:
        if (r5 == null) goto L21;
        r14 = new File(r5);
        goto L22
    L11:
        if (r10.h() == null) goto L13;
        return true;
    }

    private final boolean checkRequestValid(String r5, t r10) {
        if (com.lynx.tasm.behavior.utils.d.g(r10.f4407c) == true) goto L5;
    L6:
        ArrayList r11 = r10.e;
        if (r11 == null) goto L11;
        if (r11.isEmpty() == true) goto L11;
        return true;
    L11:
        if (StringsKt.isBlank(r5) == false) goto L13;
        return false;
    L13:
        if (Uri.parse(r5).isHierarchical() == false) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (com.lynx.tasm.behavior.utils.d.g(r10.d) == false) goto L6;
        return true;
    }

    private final s fetchAsyncInner(String r11, t r12, final e r13, final Function1<? super w, Unit> r14) {
        com.bytedance.forest.interceptor.b.d(r11, r12);
        r13.b(new String[]{"init_start", "req_build_start"});
        Request r5 = v0.b(r11, this, r12, true, r13);
        r13.b(new String[]{"req_build_finish"});
        com.bytedance.forest.interceptor.b.a();
        w r10 = new w(r5, r13.g);
        if ((r5 instanceof PostProcessRequest) == false) goto L5;
        r10 = new com.bytedance.forest.postprocessor.g(r10, (PostProcessRequest) r5);
    L5:
        com.bytedance.forest.utils.d.b(r13.g, 3, "fetchResourceAsync", "start request", true, null, "req_build_finish", 16);
        com.bytedance.forest.chain.a r15 = com.lynx.tasm.behavior.ui.utils.e.d(r5, r10, new h(r5, r13), r13);
        r13.b(new String[]{"init_finish"});
        final s r16 = new s(r12, r11, this, r15, Status.f4357b);
        r13.b(new String[]{"res_pipeline_start"});
        r15.b(new AnonymousClass1(this, r13, r16, r14));
        return r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void finishWithCallback(final w r10, e r11, Function1<? super w, Unit> r12) {
        com.bytedance.forest.utils.d.c(r11.g, 4, "fetchResourceAsync", null, "res_load_internal_finish", new C01731(r10), 8);
        Iterator r5 = r11.f.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r13 = (Map.Entry) r5.next();
        r10.f4441q.getCustomParams().put(r13.getKey(), r13.getValue());
        goto L4
    L6:
        triggerCallback(r11, r12, r10);
        com.bytedance.forest.interceptor.b.c(r10, r11);
        r11.f4619a.c(r10);
    }

    private final com.bytedance.forest.preload.d getPreLoader() {
        return (com.bytedance.forest.preload.d) this.preLoader$delegate.getValue();
    }

    public static /* synthetic */ boolean isPreloaded$default(Forest r5, String r10, t r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r11 = null;
    L6:
        return r5.isPreloaded(r10, r11);
    }

    public static /* synthetic */ String openSession$default(Forest r5, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return r5.openSession(r10);
    }

    private final Map<String, List<u>> parseSubResourceConfig(JSONObject r26, Map<String, String> r27, boolean r28, NetWorker r29, int r30, Function1<? super String, ? extends ForestPostProcessor<?>> r31) {
        JSONObject r5 = r26;
        if (r5 == null) goto L56;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<String> r11 = r26.keys();
    L6:
        if (r11.hasNext() == false) goto L55;
        String r12 = r11.next();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L42
        Object r14 = r5.get(r12);     // Catch: Throwable -> L42
        if (r14 == null) goto L48;
        JSONArray r15 = (JSONArray) r14;     // Catch: Throwable -> L42
        ArrayList r16 = new ArrayList(r15.length());     // Catch: Throwable -> L42
        r10.put(r12, r16);     // Catch: Throwable -> L42
        int r17 = r15.length();     // Catch: Throwable -> L42
        int r18 = 0;
    L11:
        if (r18 >= r17) goto L46;
        Object r19 = r15.get(r18);     // Catch: Throwable -> L42
        if (r19 == null) goto L45;
        JSONObject r20 = (JSONObject) r19;     // Catch: Throwable -> L42
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L31
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L31
        Object r112 = r20.get("url");     // Catch: Throwable -> L31
        if (r112 == null) goto L33;
        r111.append((String) r112);     // Catch: Throwable -> L31
        r111.append('?');     // Catch: Throwable -> L31
        r111.append(CollectionsKt.q(r27.entrySet(), "&", null, null, 0, null, null, 62));     // Catch: Throwable -> L31
        String r113 = StringsKt.B(r111.toString(), "?");     // Catch: Throwable -> L31
        boolean r114 = r20.optBoolean("enableMemory", false);     // Catch: Throwable -> L31
        LinkedHashMap r115 = r10;
        Iterator<String> r116 = r11;
        r20.optDouble("size", 0.0d);     // Catch: Throwable -> L23
        boolean r21 = r20.optBoolean("disableCdn", r28);     // Catch: Throwable -> L23
        NetWorker.valueOf(r20.optString("netWorker", r29.name()));     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r20.optString("processType", ""), "templateBundle") == false) goto L25;
        if (r31 == null) goto L25;
        ForestPostProcessor<?> r22 = r31.invoke("templateBundle");     // Catch: Throwable -> L23
    L26:
        u r23 = new u(r113, r114, r21, r22);     // Catch: Throwable -> L23
        r23.f4427b = r20.optInt("maxAge", r30);     // Catch: Throwable -> L29
        Object r24 = Result.m124constructorimpl(Boolean.valueOf(r16.add(r23)));     // Catch: Throwable -> L29
    L60:
        Throwable r25 = Result.m127exceptionOrNullimpl(r24);     // Catch: Throwable -> L39
        if (r25 == null) goto L41;
        f0.f(56, "PreloadAPI", "Parse " + r18 + " in sub resource config of " + r12 + " failed, caused by " + r25.getMessage());     // Catch: Throwable -> L39
    L41:
        r18 = r18 + 1;     // Catch: Throwable -> L39
        r10 = r115;
        r11 = r116;
    L39:
        th = th;
    L49:
        Result.Companion r32 = Result.Companion;
        Object r33 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L50:
        Throwable r34 = Result.m127exceptionOrNullimpl(r33);
        if (r34 == null) goto L53;
        StringBuilder r35 = com.lynx.tasm.utils.e.b("Parse sub resource config of ", r12, " failed, caused by ");
        r35.append(r34.getMessage());
        f0.f(56, "PreloadAPI", r35.toString());
    L53:
        r5 = r26;
        r10 = r115;
        r11 = r116;
    L29:
        th = th;
    L35:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L39
        r24 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L39
    L25:
        r22 = null;
    L23:
        th = th;
        goto L35
    L33:
        r115 = r10;
        r116 = r11;
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L29
    L31:
        th = th;
        r115 = r10;
        r116 = r11;
        goto L35
    L45:
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: Throwable -> L39
    L46:
        r115 = r10;
        r116 = r11;
        r33 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L39
        goto L50
    L48:
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONArray");     // Catch: Throwable -> L39
    L42:
        th = th;
        r115 = r10;
        r116 = r11;
        goto L49
    L55:
        return r10;
    L56:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Map parseSubResourceConfig$default(Forest r10, JSONObject r11, Map r12, boolean r13, NetWorker r14, int r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 32) == 0) goto L6;
        r16 = null;
    L6:
        return r10.parseSubResourceConfig(r11, r12, r13, r14, r15, r16);
    }

    public static /* synthetic */ void preload$default(Forest r5, r r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        r5.preload(r10, r11, r12);
    }

    private final w reuseResponse(w r10, boolean r11, t r12, e r13) {
        if ((r12 instanceof com.bytedance.forest.postprocessor.e) == true) goto L5;
        w r5 = new w(r10, r13.g);
    L13:
        r13.b(new String[]{"req_reuse_start"});
        r5.f4437m = true;
        r5.g = r10.f();
        r5.f4434j = r10.e();
        r5.f4435k = r10.f4435k;
        r5.e = r10.e;
        r5.f = r10.f;
        r5.f4448y = r10.f4448y;
        r5.f4447x = r10.f4447x;
        r5.f4439o = r10.f4439o;
        r5.s.b(r10.s, new ErrorInfo$Type[0]);
        r5.f4441q.setPreload(false);
        r5.f4441q.setEnableRequestReuse(true);
        r5.f4441q.setScene(r12.H);
        r5.f4441q.setGroupId(r12.f4419t);
        r5.f4441q.setCustomParams((Map) r12.f4421v.getValue());
        if (r5.f4441q.getScene() == Scene.f) goto L16;
    L18:
        com.bytedance.forest.utils.h r14 = r5.f4441q.getForest().memoryManager.b(r5.f4441q.getCacheKey$forest_release(), r5.f4441q.getEnableRequestReuse());
        if (r14 == null) goto L23;
        com.bytedance.forest.model.p r15 = r14.f4625a;
        if (r15 == null) goto L23;
    L24:
        if (r15 == null) goto L39;
        r15.setContext$forest_release(r13);
        if (r15.isCacheReady$forest_release() == false) goto L28;
    L36:
        if (r11 == true) goto L38;
        r5.f4436l = true;
    L38:
        r5.d(r15);
        goto L39
    L28:
        if (r5.f4441q.getLoadToMemory() == false) goto L36;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L31
        r15.tryLoadToMemory$forest_release(r5);     // Catch: Throwable -> L31
        Object r17 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L38;
        com.bytedance.forest.model.c r19 = r5.s;
        ErrorInfo$Type r20 = ErrorInfo$Type.f4309a;
        String r21 = r18 + " occurred, " + r18.getMessage();
        r19.getClass();
        r19.f4360a += r19.a(r20, 4, r21);
    L31:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L39:
        WebResourceResponse r23 = null;
        Map r24 = null;
        if (r10.d == null) goto L49;
        List r25 = com.bytedance.forest.utils.k.f4646a;
        String r26 = r5.f();
        String r27 = r5.e();
        com.bytedance.forest.model.p r28 = r5.i();
        if (r28 == null) goto L44;
        InputStream r29 = r28.provideInputStream(r5);
    L45:
        String r30 = r5.f4441q.getUrl();
        com.bytedance.forest.pollyfill.d r31 = r5.e;
        if (r31 == null) goto L48;
        r24 = r31.f4528c;
    L48:
        r23 = com.bytedance.forest.utils.k.a(r26, r27, r29, r30, r24);
        goto L49
    L44:
        r29 = null;
    L49:
        r5.d = r23;
        if (r11 == false) goto L52;
    L56:
        r13.b(new String[]{"req_reuse_finish"});
        return r5;
    L52:
        if (r5.f4436l == false) goto L56;
        ResourceFrom r32 = r5.f4444u;
        ResourceFrom r33 = ResourceFrom.d;
        if (r32 == r33) goto L56;
        r5.f4445v = r10.f4444u;
        r5.f4444u = r33;
    L23:
        r15 = r10.i();
        goto L24
    L16:
        if (r5.h() == null) goto L18;
        r5.f4436l = true;
        goto L18
    L5:
        if ((r10 instanceof com.bytedance.forest.postprocessor.g) == false) goto L7;
        com.bytedance.forest.postprocessor.g r34 = (com.bytedance.forest.postprocessor.g) r10;
        r5 = new com.bytedance.forest.postprocessor.g(r34, r34.C);
        goto L13
    L7:
        Request r35 = r10.f4441q;
        ForestPostProcessor r36 = ((com.bytedance.forest.postprocessor.e) r12).I;
        if (r36 == null) goto L11;
        r5 = new com.bytedance.forest.postprocessor.g(r10, new PostProcessRequest(r35, r36));
        goto L13
    L11:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.postprocessor.ForestPostProcessor<kotlin.Any>");
    }

    @JvmStatic
    public static final void setCDNCacheDiskMaxAge(int r5) {
        Companion.setCDNCacheDiskMaxAge(r5);
    }

    @JvmStatic
    public static final void sweepCDNDiskCachedFiles() {
        Companion.sweepCDNDiskCachedFiles();
    }

    private final void triggerCallback(e r5, Function1<? super w, Unit> r10, w r11) {
        if (r5.f4620b == false) goto L9;
        r5.b(new String[]{"res_callback_switch_thread_start"});
        i r12 = new i(r5, 4, r10, r11);
        com.bytedance.forest.utils.g r13 = com.bytedance.forest.utils.q.f4656a;
        ThreadUtils$Priority r14 = ThreadUtils$Priority.f4598a;
        if (com.bytedance.forest.utils.q.b() == false) goto L7;
        r12.run();
        return;
    L7:
        com.bytedance.forest.utils.g r15 = com.bytedance.forest.utils.q.f4656a;
        r15.getClass();
        ((Handler) r15.f4624a.getValue()).post(r12);
        return;
    L9:
        r5.b(new String[]{"res_load_finish", "callback_execute_start"});
        r10.invoke(r11);
        r5.b(new String[]{"callback_execute_finish"});
    }

    public final void closeSession(String r5) {
        d r10 = this.sessionManager;
        r10.getClass();
        LinkedHashMap r11 = r10.f4302a;
        monitor-enter(r11);
        Iterator r12 = r10.f4302a.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L12;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L10
        if (Intrinsics.areEqual((String) ((Pair) r13.getKey()).getFirst(), r5) == false) goto L6;
        ((qa.b) r13.getValue()).b();     // Catch: Throwable -> L10
        r12.remove();     // Catch: Throwable -> L10
        goto L6
    L12:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r11);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final s createSyncRequest(String r10, t r11) {
        f0.f(60, "createSyncRequest", "url:" + r10 + " params:" + r11);
        t r5 = null;
        if (checkRequestValid(r10, r11) == true) goto L7;
        f0.n(5, null, "url is blank or no channel/bundle/prefix in params");
        return null;
    L7:
        if ((r11 instanceof com.bytedance.forest.postprocessor.e) == false) goto L10;
        r5 = r11;
    L10:
        com.bytedance.forest.postprocessor.e r12 = (com.bytedance.forest.postprocessor.e) r5;
        if (r12 == null) goto L16;
        com.bytedance.forest.postprocessor.d r13 = createSyncRequestWithProcessor(r10, r12);
        if (r13 == null) goto L16;
        return r13;
    L16:
        return new s(r11, r10, this, null, Status.f4356a);
    }

    public final <T> com.bytedance.forest.postprocessor.d createSyncRequestWithProcessor(String r10, com.bytedance.forest.postprocessor.e r11) {
        f0.f(60, "createSyncRequestWithProcessor", "url:" + r10 + " params:" + r11);
        if (checkRequestValid(r10, r11) == true) goto L7;
        f0.n(5, null, r10 + " is invalid and no channel/bundle/prefix in params");
        return null;
    L7:
        return new com.bytedance.forest.postprocessor.d(r11, r10, this, null, Status.f4356a);
    }

    public final <T> s fetchAsyncWithProcessor(String r5, com.bytedance.forest.postprocessor.e r10, final Function1<? super com.bytedance.forest.postprocessor.g, Unit> r11) {
        return fetchResourceAsync(r5, r10, new C01711(r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final s fetchResourceAsync(final String r46, final t r47, final Function1<? super w, Unit> r48) {
        final e r10 = new e(this.application);
        r10.b(new String[]{"res_load_start", "res_load_internal_start"});
        Object r5 = ((Map) r47.f4421v.getValue()).get("rl_container_uuid");
        if ((r5 instanceof String) == true) goto L5;
        r5 = null;
    L5:
        String r11 = (String) r5;
        if (r11 != null) goto L9;
        r11 = r47.f4419t;
    L9:
        com.bytedance.forest.utils.d r14 = r10.g;
        r14.getClass();
        r14.f4617b = r11;
        r14.f4616a = this.config.f4379b;
        r14.f4618c = r46;
        com.bytedance.forest.utils.d.b(r14, 4, "fetchResourceAsync", "resource async load start.", true, null, "res_load_start", 16);
        if (checkRequestValid(r46, r47) == true) goto L14;
        String r13 = r46.concat(" is invalid and no channel/bundle/prefix in params");
        com.bytedance.forest.utils.d.b(r10.g, 6, null, r13, false, null, null, 58);
        Map r12 = (Map) r47.f4421v.getValue();
        m r15 = null;
        boolean r16 = false;
        boolean r17 = false;
        boolean r18 = false;
        boolean r19 = false;
        boolean r20 = false;
        boolean r110 = false;
        boolean r111 = false;
        Scene r112 = null;
        boolean r113 = false;
        Object[] r114 = 0 == true ? 1 : 0;
        Object[] r115 = 0 == true ? 1 : 0;
        Object[] r116 = 0 == true ? 1 : 0;
        Object[] r117 = 0 == true ? 1 : 0;
        w r118 = new w(new Request(r46, this, r12, r15, r16, r17, r18, r19, r20, r110, r111, r114, r115, r116, r117, r112, r113, null, false, false, false, null, false, false, false, null, null, false, false, 0, false, null, null, false, false, null, -8, 15, null), r14);
        com.bytedance.forest.model.c r21 = r118.s;
        r21.getClass();
        r21.f4368m = r13;
        r48.invoke(r118);
        return null;
    L14:
        if (r47.f4422w == true) goto L24;
        final com.bytedance.forest.utils.a r22 = p.c(r46, r47, this);
        com.bytedance.forest.utils.d.c(r10.g, 4, "preload", null, null, new C01721(r22), 24);
        if (r47.f4423x == false) goto L18;
    L21:
        r47.f4423x = true;
        final s r119 = new s(r47, r46, this, null, Status.f4357b);
        getPreLoader().c(r22, r47.f4424y, r10.g, this.memoryManager, new AnonymousClass2(this, r47, r10, r48, r46, r119));
        return r119;
    L18:
        if (getPreLoader().e(r22) == true) goto L21;
    L24:
        return fetchAsyncInner(r46, r47, r10, r48);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [T, com.bytedance.forest.model.w] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v26 */
    @RequiresApi(21)
    public final w fetchSync$forest_release(s r23) {
        final t r5 = r23.f4402a;
        final e r10 = new e(this.application);
        r10.b(new String[]{"res_load_start", "res_load_internal_start"});
        com.bytedance.forest.utils.d r11 = r10.g;
        Object r12 = ((Map) r5.f4421v.getValue()).get("rl_container_uuid");
        final w r13 = null;
        if ((r12 instanceof String) == true) goto L5;
        r12 = null;
    L5:
        String r14 = (String) r12;
        if (r14 != null) goto L9;
        r14 = r5.f4419t;
    L9:
        r11.getClass();
        r11.f4617b = r14;
        com.bytedance.forest.utils.d r15 = r10.g;
        r15.f4616a = this.config.f4379b;
        r15.f4618c = r23.f4403b;
        com.bytedance.forest.utils.d.b(r15, 4, "fetchSync", "resource sync load start.", true, null, "res_load_start", 16);
        if (r5.f4422w == true) goto L26;
        final com.bytedance.forest.utils.a r16 = p.c(r23.f4403b, r23.f4402a, this);
        com.bytedance.forest.utils.d.c(r10.g, 4, "preload", null, null, new Forest$fetchSync$1(r16), 24);
        if (r5.f4423x == false) goto L14;
    L15:
        r5.f4423x = true;
        final com.bytedance.forest.preload.e r17 = getPreLoader().a(r16, r5.f4424y, r10.g, this.memoryManager);
        if (r17 == null) goto L25;
        w r18 = r17.f4572a;
        if (r18 == null) goto L25;
        if (checkRequestReuseValid(r18, r5, r10) == false) goto L22;
        r13 = r18;
    L22:
        if (r13 == null) goto L25;
        final w r19 = reuseResponse(r13, r17.f4573b, r5, r10);
        r10.b(new String[]{"res_load_finish"});
        com.bytedance.forest.utils.d.c(r10.g, 4, "preload", null, "res_load_finish", new Forest$fetchSync$3$1(r19), 8);
        com.bytedance.forest.utils.d.c(r10.g, 4, "preload", null, "res_load_finish", new Forest$fetchSync$3$2(r13), 8);
        com.bytedance.forest.interceptor.b.c(r19, r10);
        r10.f4619a.c(r19);
        return r19;
    L25:
        com.bytedance.forest.utils.d.c(r10.g, 4, "fetchSync", null, "preload_request_reused_failed", new Forest$fetchSync$4(r17, r5), 8);
        goto L26
    L14:
        if (getPreLoader().e(r16) == true) goto L15;
    L26:
        ArrayList r20 = com.bytedance.forest.interceptor.b.f4306a;
        com.bytedance.forest.interceptor.b.d(r23.f4403b, r23.f4402a);
        r10.b(new String[]{"init_start", "req_build_start"});
        Request r21 = v0.b(r23.f4403b, this, r23.f4402a, false, r10);
        r10.b(new String[]{"req_build_finish"});
        com.bytedance.forest.interceptor.b.a();
        com.bytedance.forest.utils.d.b(r10.g, 4, "fetchSync", "start request", true, null, "req_build_finish", 16);
        final Ref.ObjectRef r22 = new Ref.ObjectRef();
        w r24 = new w(r21, r10.g);
        ?? r25 = r24;
        if ((r21 instanceof PostProcessRequest) == false) goto L29;
        r25 = new com.bytedance.forest.postprocessor.g(r24, (PostProcessRequest) r21);
    L29:
        r22.element = r25;
        com.bytedance.forest.chain.a r26 = com.lynx.tasm.behavior.ui.utils.e.d(r21, r25, new h(r21, r10), r10);
        r23.d = r26;
        r10.b(new String[]{"init_finish"});
        r26.b(new Forest$fetchSync$5(r10, r22));
        r23.e = Status.f4358c;
        com.bytedance.forest.utils.d.c(r10.g, 4, "fetchSync", null, "res_load_internal_finish", new Forest$fetchSync$6(r22), 8);
        Iterator r27 = r10.f.entrySet().iterator();
    L31:
        if (r27.hasNext() == false) goto L33;
        Map.Entry r28 = (Map.Entry) r27.next();
        ((w) r22.element).f4441q.getCustomParams().put(r28.getKey(), r28.getValue());
        goto L31
    L33:
        r10.f4619a.c((w) r22.element);
        ArrayList r29 = com.bytedance.forest.interceptor.b.f4306a;
        com.bytedance.forest.interceptor.b.c((w) r22.element, r10);
        return (w) r22.element;
    }

    @RequiresApi(21)
    public final <T> com.bytedance.forest.postprocessor.g fetchSyncWithProcessor$forest_release(com.bytedance.forest.postprocessor.d r5) {
        w r10 = fetchSync$forest_release(r5);
        if ((r10 instanceof com.bytedance.forest.postprocessor.g) == true) goto L5;
        w r11 = null;
    L6:
        com.bytedance.forest.postprocessor.g r12 = (com.bytedance.forest.postprocessor.g) r11;
        if (r12 == null) goto L9;
        return r12;
    L9:
        com.bytedance.forest.postprocessor.g r13 = new com.bytedance.forest.postprocessor.g(r10, null);
        ErrorInfo$Type r14 = ErrorInfo$Type.f;
        String r15 = "Can not cast from " + r10.getClass() + " to " + com.bytedance.forest.postprocessor.g.class;
        com.bytedance.forest.model.c r16 = r13.s;
        r16.getClass();
        r16.f4360a += r16.a(r14, 2, r15);
        return r13;
    L5:
        r11 = r10;
        goto L6
    }

    public final Application getApplication() {
        return this.application;
    }

    public final k getConfig() {
        return this.config;
    }

    public final GeckoXAdapter getGeckoXAdapter() {
        return this.geckoXAdapter;
    }

    public final j getMemoryManager$forest_release() {
        return this.memoryManager;
    }

    public final d getSessionManager$forest_release() {
        return this.sessionManager;
    }

    @JvmOverloads
    public final boolean isPreloaded(String r5) {
        return isPreloaded$default(this, r5, null, 2, null);
    }

    public final void onLowMemory() {
        j r5 = this.memoryManager;
        r5.f4645b.f4652a.evictAll();
        r5.f4644a.f4652a.evictAll();
    }

    public final String openSession(String r5) {
        this.sessionManager.getClass();
        if (r5 == null) goto L6;
        return r5;
    L6:
        return String.valueOf(System.currentTimeMillis()) + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + UUID.randomUUID().toString();
    }

    @JvmOverloads
    public final void preload(r r10) {
        preload$default(this, r10, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void preload$default(Forest r5, String r10, t r11, JSONObject r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        r5.preload(r10, r11, r12, r13);
    }

    @JvmOverloads
    public final boolean isPreloaded(String r10, t r11) {
        if (r11 != null) goto L26;
        r11 = new t(Scene.f4354n);
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.m124constructorimpl(Uri.parse(r10));     // Catch: Throwable -> L8
    L10:
        Set r13 = null;
        if (Result.m130isFailureimpl(r12) == false) goto L13;
        r12 = null;
    L13:
        Uri r14 = (Uri) r12;
        if (r14 == null) goto L26;
        String r15 = com.lynx.tasm.utils.b.g(r14, "forest_key_include");
        if (r15 == null) goto L25;
        List r16 = StringsKt.K(r15, new String[]{","}, 0, 6);
        if (r16 == null) goto L25;
        if (r16.isEmpty() == false) goto L23;
        r16 = null;
    L23:
        if (r16 == null) goto L25;
        r13 = CollectionsKt.toSet(r16);
    L25:
        r11.F = r13;
        r11.G = Intrinsics.areEqual(r14.getQueryParameter("forest_key_ua_include"), IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
    L8:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L26:
        com.bytedance.forest.utils.a r18 = p.c(r10, r11, this);
        if (r18 != null) goto L29;
        return false;
    L29:
        return getPreLoader().e(r18);
    }

    @JvmOverloads
    public final void preload(r r10, String r11) {
        preload$default(this, r10, r11, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void preload$default(Forest r14, String r15, JSONObject r16, PreloadType r17, ForestPostProcessor r18, String r19, String r20, String r21, String r22, int r23, Function1 r24, int r25, Object r26) {
        if ((r25 & 8) == 0) goto L5;
        ForestPostProcessor r10 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r25 & 32) == 0) goto L13;
        String r12 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        String r13 = null;
    L19:
        if ((r25 & 128) == 0) goto L21;
        String r110 = null;
    L23:
        if ((r25 & 256) == 0) goto L25;
        int r111 = 0;
    L27:
        if ((r25 & 512) == 0) goto L29;
        Function1 r112 = null;
    L30:
        r14.preload(r15, r16, r17, r10, r11, r12, r13, r110, r111, r112);
        return;
    L29:
        r112 = r24;
        goto L30
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

    @JvmOverloads
    @RequiresApi(21)
    public final void preload(String r10, t r11) {
        preload$default(this, r10, r11, false, null, null, 28, null);
    }

    public static /* synthetic */ void preload$default(Forest r10, String r11, t r12, boolean r13, String r14, String r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        r13 = false;
    L5:
        boolean r5 = r13;
        if ((r16 & 8) == 0) goto L8;
        String r18 = null;
    L10:
        if ((r16 & 16) == 0) goto L12;
        String r19 = null;
    L13:
        r10.preload(r11, r12, r5, r18, r19);
        return;
    L12:
        r19 = r15;
        goto L13
    L8:
        r18 = r14;
        goto L10
    }

    @JvmOverloads
    public final void preload(String r10, t r11, JSONObject r12) {
        preload$default(this, r10, r11, r12, null, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void preload$default(Forest r10, String r11, t r12, boolean r13, String r14, String r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 4) == 0) goto L5;
        r13 = false;
    L5:
        boolean r5 = r13;
        if ((r17 & 8) == 0) goto L8;
        String r19 = null;
    L10:
        if ((r17 & 16) == 0) goto L12;
        String r20 = null;
    L14:
        if ((r17 & 32) == 0) goto L16;
        Function1 r21 = null;
    L17:
        r10.preload(r11, r12, r5, r19, r20, r21);
        return;
    L16:
        r21 = r16;
        goto L17
    L12:
        r20 = r15;
        goto L14
    L8:
        r19 = r14;
        goto L10
    }

    @JvmOverloads
    @RequiresApi(21)
    public final void preload(String r10, t r11, boolean r12) {
        preload$default(this, r10, r11, r12, null, null, 24, null);
    }

    @JvmOverloads
    @RequiresApi(21)
    public final void preload(String r10, t r11, boolean r12, String r13) {
        preload$default(this, r10, r11, r12, r13, null, 16, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16) {
        preload$default(this, r14, r15, r16, null, null, null, null, null, 0, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16, ForestPostProcessor<?> r17) {
        preload$default(this, r14, r15, r16, r17, null, null, null, null, 0, null, PointerIconCompat.TYPE_TEXT, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16, ForestPostProcessor<?> r17, String r18) {
        preload$default(this, r14, r15, r16, r17, r18, null, null, null, 0, null, 992, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16, ForestPostProcessor<?> r17, String r18, String r19) {
        preload$default(this, r14, r15, r16, r17, r18, r19, null, null, 0, null, 960, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16, ForestPostProcessor<?> r17, String r18, String r19, String r20) {
        preload$default(this, r14, r15, r16, r17, r18, r19, r20, null, 0, null, 896, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16, ForestPostProcessor<?> r17, String r18, String r19, String r20, String r21) {
        preload$default(this, r14, r15, r16, r17, r18, r19, r20, r21, 0, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r14, JSONObject r15, PreloadType r16, ForestPostProcessor<?> r17, String r18, String r19, String r20, String r21, int r22) {
        preload$default(this, r14, r15, r16, r17, r18, r19, r20, r21, r22, null, 512, null);
    }

    @JvmOverloads
    public final void preload(r r10, String r11, String r12) {
        com.bytedance.forest.utils.q.a(new com.bytedance.apm.e(this, r10, r11, r12, 1));
    }

    @JvmOverloads
    public final void preload(String r10, t r11, JSONObject r12, Function1<? super String, ? extends ForestPostProcessor<?>> r13) {
        com.bytedance.forest.utils.q.a(new i(this, 3, r10, r11));
        if (r12 != null) goto L6;
        return;
    L6:
        if (r11.H != Scene.f4351k) goto L8;
        PreloadType r5 = PreloadType.f4334b;
    L9:
        r12.remove("type");
        r r14 = new r(r5, parseSubResourceConfig(r12, com.lynx.tasm.utils.b.k(Uri.parse(r10)), false, NetWorker.f4465a, r11.C, r13));
        Lazy r15 = r11.f4421v;
        Object r16 = ((Map) r15.getValue()).get("x-forest-preload-from");
        Object r17 = null;
        if ((r16 instanceof String) == true) goto L12;
        r16 = null;
    L12:
        r14.f4399a = (String) r16;
        Object r18 = ((Map) r15.getValue()).get("x-forest-injected-ua");
        if ((r18 instanceof String) == false) goto L16;
        r17 = r18;
    L16:
        r14.f4400b = (String) r17;
        preload(r14, r11.f4419t, r11.f4420u);
        return;
    L8:
        r5 = PreloadType.f4333a;
        goto L9
    }

    @Deprecated(message = "use\nfun preload(\n        url: String?,\n        params: RequestParams,\n        subRes: JSONObject?,\n        postProcessorBuilder: PostProcessorBuilder? = null\n    )\ninstead")
    @JvmOverloads
    public final void preload(String r10, JSONObject r11, PreloadType r12, ForestPostProcessor<?> r13, String r14, String r15, String r16, String r17, int r18, Function1<? super String, ? extends ForestPostProcessor<?>> r19) {
        if (r10 != null) goto L5;
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r10 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        NetWorker r5 = NetWorker.f4465a;
        u r20 = new u(r10, true, false, r13);
        r20.f4427b = r18;
        if (r11 == null) goto L14;
        r11.remove("type");
    L14:
        r r21 = new r(r20, r12, parseSubResourceConfig(r11, com.lynx.tasm.utils.b.k(Uri.parse(r10)), false, r5, r18, r19));
        r21.f4399a = r16;
        r21.f4400b = r17;
        preload(r21, r14, r15);
        return;
    L5:
        if (r10.length() != 0) goto L9;
        goto L6
    }

    @JvmOverloads
    @RequiresApi(21)
    public final void preload(String r10, t r11, boolean r12, String r13, String r14) {
        preload(r10, r11, r12, r13, r14, null);
    }

    public final void preload(String r10, t r11, boolean r12, String r13, String r14, Function1<? super String, ? extends ForestPostProcessor<?>> r15) {
        com.bytedance.forest.utils.q.a(new a(this, r10, r11, r13, r14, r12, r15));
    }
}
