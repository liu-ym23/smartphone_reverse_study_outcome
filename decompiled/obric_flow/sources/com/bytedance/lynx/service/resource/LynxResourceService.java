package com.bytedance.lynx.service.resource;

import android.net.Uri;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.lynx.service.model.b;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.TTVideoEngine;
import df.c;
import eg.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import ko.e;
import ko.f;
import ko.g;
import ko.o;
import ko.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0006J\u0019\u0010\"\u001a\u00020!2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\"\u0010#J1\u0010(\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b*\u0010\u0019J\u001f\u0010.\u001a\u00020\u00172\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J+\u00105\u001a\u0004\u0018\u0001042\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b5\u00106J#\u00108\u001a\u0004\u0018\u0001072\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010=R6\u0010@\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010>j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010IR\u0014\u0010J\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010HR\u0014\u0010K\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010HR\u0014\u0010L\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u0010HR\u0014\u0010M\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010HR\u0014\u0010N\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010HR\u0014\u0010O\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010H¨\u0006P"}, d2 = {"Lcom/bytedance/lynx/service/resource/LynxResourceService;", "Lko/e;", "<init>", "()V", "", "isInitial", "()Z", "Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;", "resourceMeta", "", "prefix", "prefix2AccessKey", "(Lcom/bytedance/geckox/settings/model/GlobalConfigSettings$ResourceMeta;Ljava/lang/String;)Ljava/lang/String;", "url", "isFrescoLocalResource", "(Ljava/lang/String;)Z", SVGRenderEngine.PATH, "queryPrefixFromUrl", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "isContainerGeckoResource", "getPath", "(Ljava/lang/String;)Ljava/lang/String;", "getPrefix", "", "setPrefix", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/bytedance/lynx/service/model/b;", "lynxServiceConfig", "Leg/a;", "adapter", "initialize", "(Lcom/bytedance/lynx/service/model/b;Leg/a;)V", "isReady", "", "isLocalResource", "(Ljava/lang/String;)I", "preloadKey", "videoID", "", "size", "preloadMedia", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "cancelPreloadMedia", "", "loader", "templateUrl", "addResourceLoader", "(Ljava/lang/Object;Ljava/lang/String;)V", "Lko/p;", "lynxResourceRequestParams", "Lko/o;", "callback", "Lko/f;", "fetchResourceAsync", "(Ljava/lang/String;Lko/p;Lko/o;)Lko/f;", "Lko/g;", "fetchResourceSync", "(Ljava/lang/String;Lko/p;)Lko/g;", "shouldLogResourceMetaError", "Z", "shouldLogConfigError", "Lcom/bytedance/lynx/service/model/b;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "prefixMap", "Ljava/util/LinkedHashMap;", "MAX_SIZE", "I", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "TAG", "Ljava/lang/String;", "Leg/a;", "TRACE_RESOURCE_PROXY_IS_LOCAL_RESOURCE", "TRACE_RESOURCE_PROXY_FETCH_RESOURCE_ASYNC", "TRACE_RESOURCE_PROXY_FETCH_RESOURCE_SYNC", "TRACE_RESOURCE_PROXY_PRELOAD", "TRACE_RESOURCE_PROXY_PRELOAD_MEDIA", "TRACE_RESOURCE_PROXY_ADD_RESOURCE_LOADER", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxResourceService implements e {
    public static final LynxResourceService INSTANCE = null;
    private static final int MAX_SIZE = 16;
    private static final String TAG = "LynxResourceService";
    public static final String TRACE_RESOURCE_PROXY_ADD_RESOURCE_LOADER = "LynxServiceResourceProxy.addResourceLoader";
    public static final String TRACE_RESOURCE_PROXY_FETCH_RESOURCE_ASYNC = "LynxServiceResourceProxy.fetchResourceAsync";
    public static final String TRACE_RESOURCE_PROXY_FETCH_RESOURCE_SYNC = "LynxServiceResourceProxy.fetchResourceSync";
    public static final String TRACE_RESOURCE_PROXY_IS_LOCAL_RESOURCE = "LynxServiceResourceProxy.isLocalResource";
    public static final String TRACE_RESOURCE_PROXY_PRELOAD = "LynxServiceResourceProxy.preload";
    public static final String TRACE_RESOURCE_PROXY_PRELOAD_MEDIA = "LynxServiceResourceProxy.preloadMedia";
    private static a adapter;
    private static final ReentrantLock lock = null;
    private static b lynxServiceConfig;
    private static LinkedHashMap<String, String> prefixMap;
    private static boolean shouldLogConfigError;
    private static boolean shouldLogResourceMetaError;

    static {
        INSTANCE = new LynxResourceService();
        shouldLogResourceMetaError = true;
        shouldLogConfigError = true;
        lock = new ReentrantLock();
    }

    private LynxResourceService() {
    }

    private final String getPath(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L16;
        Uri r10 = Uri.parse(r5);
        if (r10.getScheme() == null) goto L15;
        String r11 = r10.getScheme();
        Intrinsics.checkNotNull(r11);
        if (StringsKt.P(r11, "http") == true) goto L13;
        return null;
    L13:
        return r10.getPath();
    L15:
        return null;
    L16:
        return null;
    }

    private final String getPrefix(String r5) {
        ReentrantLock r10 = lock;
        r10.lock();
        LinkedHashMap<String, String> r11 = prefixMap;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L6
        String r12 = r11.get(r5);     // Catch: Throwable -> L6
        r10.unlock();
        return r12;
    L6:
        th = move-exception;
        lock.unlock();
        throw th;
    }

    private final boolean isContainerGeckoResource(String r5) {
        Uri r10 = Uri.parse(r5);
        String r11 = r10.getQueryParameter("bundle");
        if (r11 != null) goto L5;
    L13:
        String r12 = r10.getQueryParameter("prefix");
        if (r12 != null) goto L16;
        return false;
    L16:
        if (r12.length() == 0) goto L21;
        return true;
    L21:
        return false;
    L5:
        if (r11.length() == 0) goto L13;
        String r13 = r10.getQueryParameter(LynxMonitorService.KEY_CHANNEL);
        if (r13 == null) goto L13;
        if (r13.length() == 0) goto L13;
        return true;
    }

    private final boolean isFrescoLocalResource(String r5) {
        if (StringsKt.P(r5, "file://") == false) goto L5;
        return true;
    L5:
        if (StringsKt.P(r5, "content://") == false) goto L7;
        return true;
    L7:
        if (StringsKt.P(r5, "asset://") == false) goto L9;
        return true;
    L9:
        if (StringsKt.P(r5, "data:") == true) goto L17;
        return false;
    L17:
        return true;
    }

    private final boolean isInitial() {
        return false;
    }

    private final String prefix2AccessKey(GlobalConfigSettings.ResourceMeta r5, String r10) {
        GlobalConfigSettings.CurrentLevelConfig r11 = r5.getConfig();
        if (r11 == null) goto L5;
        Map<String, String> r12 = r11.getPrefix2AccessKey();
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.get(r10);
    L5:
        if (shouldLogConfigError == false) goto L7;
        LynxLog.b(4, TAG, "could not get any valid config");
        shouldLogConfigError = false;
    L7:
        return null;
    }

    private final String queryPrefixFromUrl(String r5, String r10) {
        String r11 = Uri.parse(r5).getQueryParameter("prefix");
        if (r11 != null) goto L5;
    L14:
        return "";
    L5:
        if (r11.length() == 0) goto L14;
        int r12 = StringsKt.r(r11, 0, 6, r10);
        Integer r13 = Integer.valueOf(r12);
        if (r12 != (-1)) goto L11;
        r13 = null;
    L11:
        if (r13 == null) goto L14;
        int r14 = r13.intValue();
        return r10.substring(0, r11.length() + r14);
    }

    private final void setPrefix(String r5, String r10) {
        ReentrantLock r11 = lock;
        r11.lock();
        LinkedHashMap<String, String> r12 = prefixMap;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L6
        r12.put(r5, r10);     // Catch: Throwable -> L6
        r11.unlock();
        return;
    L6:
        th = move-exception;
        lock.unlock();
        throw th;
    }

    public void addResourceLoader(Object r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "loader");
        Intrinsics.checkNotNullParameter(r10, "templateUrl");
        if (isInitial() == true) goto L5;
        return;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        throw null;
    }

    @Override // ko.e
    public void cancelPreloadMedia(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "preloadKey");
        TTVideoEngine.cancelPreloadTask(r5);
        if (r10 == null) goto L6;
        TTVideoEngine.cancelPreloadTaskByVideoId(r10);
        return;
    }

    @Override // ko.e
    public f fetchResourceAsync(String r5, p r10, o r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxResourceRequestParams");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (isInitial() == true) goto L6;
        LynxLog.b(4, TAG, "Please initialize before call fetchResourceAsync.");
        Intrinsics.checkNotNullParameter("LynxResourceService is Not initialized", "errorMessage");
        r11.a(new wc.f(9));
        return null;
    L6:
        if (r5 != null) goto L8;
    L19:
        Intrinsics.checkNotNullParameter("empty url", "errorMessage");
        r11.a(new wc.f(9));
        return null;
    L8:
        if (r5.length() == 0) goto L19;
        String r12 = getPath(r5);
        if (r12 != null) goto L13;
    L17:
        Intrinsics.checkNotNullParameter("invalid url", "errorMessage");
        r11.a(new wc.f(9));
        return null;
    L13:
        if (r12.length() == 0) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        throw null;
    }

    public g fetchResourceSync(String r5, p r10) {
        Intrinsics.checkNotNullParameter(r10, "lynxResourceRequestParams");
        if (isInitial() == true) goto L6;
        LynxLog.b(4, TAG, "Please initialize before call fetchResourceSync.");
        Intrinsics.checkNotNullParameter("LynxResourceService is Not initialized", "errorMessage");
        return new wc.f(9);
    L6:
        if (r5 != null) goto L8;
    L19:
        Intrinsics.checkNotNullParameter("empty url", "errorMessage");
        return new wc.f(9);
    L8:
        if (r5.length() == 0) goto L19;
        String r11 = getPath(r5);
        if (r11 != null) goto L13;
    L17:
        Intrinsics.checkNotNullParameter("invalid url", "errorMessage");
        return new wc.f(9);
    L13:
        if (r11.length() == 0) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        throw null;
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    @NonNull
    public /* bridge */ /* synthetic */ Class getServiceClass() {
        return e.class;
    }

    public final void initialize(b r5, a r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxServiceConfig");
        Intrinsics.checkNotNullParameter(r10, "adapter");
        lynxServiceConfig = r5;
        r10.a();
        prefixMap = new AnonymousClass1();
    }

    @Override // ko.e
    public int isLocalResource(String r10) {
        if (isInitial() == false) goto L61;
        b r5 = lynxServiceConfig;
        Intrinsics.checkNotNull(r5);
        r5.getClass();
        if (r10 != null) goto L7;
    L60:
        return 0;
    L7:
        if (r10.length() == 0) goto L60;
        if (isFrescoLocalResource(r10) == false) goto L13;
        return 0;
    L13:
        if (StringsKt.P(r10, "http") == true) goto L15;
        return -1;
    L15:
        GlobalConfigSettings r11 = c.f16652i.d();
        if (r11 == null) goto L18;
        GlobalConfigSettings.ResourceMeta r12 = r11.getResourceMeta();
    L19:
        if (r12 == null) goto L21;
        String r13 = getPath(r10);
        if (r13 == null) goto L60;
        if (r13.length() == 0) goto L60;
        LinkedHashMap<String, String> r14 = prefixMap;
        Intrinsics.checkNotNull(r14);
        String r15 = "";
        if (r14.containsKey(r13) == false) goto L36;
        String r16 = getPrefix(r13);
        if (r16 == null) goto L36;
        r15 = r16;
    L36:
        if (r15.length() != 0) goto L38;
        r15 = queryPrefixFromUrl(r10, r13);
    L38:
        if (r15 != null) goto L40;
    L58:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        throw null;
    L40:
        if (r15.length() == 0) goto L58;
        if (r15.length() == 0) goto L44;
        setPrefix(r13, r15);
        String r17 = prefix2AccessKey(r12, r15);
        if (r17 == null) goto L55;
        if (r17.length() == 0) goto L55;
        return 1;
    L55:
        if (isContainerGeckoResource(r10) == false) goto L57;
        return -1;
    L57:
        return 0;
    L44:
        if (isContainerGeckoResource(r10) == false) goto L46;
        return -1;
    L46:
        return 0;
    L21:
        if (shouldLogResourceMetaError == false) goto L23;
        LynxLog.b(4, TAG, "could not get any valid resource meta");
        shouldLogResourceMetaError = false;
    L23:
        return 0;
    L18:
        r12 = null;
        goto L19
    L61:
        return -1;
    }

    public boolean isReady() {
        return isInitial();
    }

    @Override // ko.e
    public void preloadMedia(String r10, String r11, String r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "url");
        Intrinsics.checkNotNullParameter(r11, "preloadKey");
        TTVideoEngine.addTask(new PreloaderURLItem(r11, r12, r13, new String[]{r10}));
    }
}
