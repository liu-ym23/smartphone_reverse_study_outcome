package com.bytedance.forest.pollyfill;

import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ErrorInfo$Type;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import com.bytedance.geckox.utils.MD5Utils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f4516b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f4517c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.forest.utils.e f4518a;

    static {
        JSONObject r5 = new JSONObject();
        r5.put("net_lib_strategy", 5);
        f4516b = r5;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        Object r11 = Result.m124constructorimpl(DownloadTask.class.getDeclaredMethod("a", new Class[]{Long.TYPE}));     // Catch: Throwable -> L5
    L8:
        if (Result.m130isFailureimpl(r11) == false) goto L10;
        r11 = null;
    L10:
        f4517c = (Method) r11;
        return;
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public i(com.bytedance.forest.utils.e r5) {
        this.f4518a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.forest.pollyfill.m
    public final void a(w r23, a r24, boolean r25) {
        com.bytedance.forest.utils.e r10 = this.f4518a;
        r10.b(new String[]{"cdn_cache_start", "cdn_downloader_build_cached_path_start"});
        String r11 = r23.f4441q.getUrl();
        String r5 = MD5Utils.stringToMd5(r11);
        String r12 = r23.f4441q.getUri$forest_release().getEncodedPath();
        if (r12 == null) goto L12;
        String r13 = FilesKt.getExtension(new File(r12));
        if (r13 == null) goto L12;
        if (TextUtils.isEmpty(r13) == false) goto L10;
        r13 = null;
    L10:
        if (r13 == null) goto L12;
    L13:
        File r14 = new File((File) b.f4507a.getValue(), androidx.constraintlayout.motion.widget.a.m(r5, '.', r13));
        r10.b(new String[]{"cdn_downloader_build_cached_path_finish"});
        CountDownLatch r15 = new CountDownLatch(1);
        Request r16 = r23.f4441q;
        if (r25 == false) goto L24;
        r10.b(new String[]{"cdn_downloader_load_cache_start"});
        DownloadInfo r17 = Downloader.b(Forest.Companion.getApp()).a(r11, r14.getParent());
        r10.b(new String[]{"cdn_downloader_load_cache_finish"});
        if (r17 != null) goto L18;
    L21:
        r10.b(new String[]{"cdn_cache_finish"});
        r24.c(true, new Throwable("only local but no download info found"));
        r10.b(new String[]{"cdn_finish"});
        return;
    L18:
        if (d(r23, r14) == false) goto L21;
        r10.b(new String[]{"cdn_cache_finish"});
        r17.U = true;
        c(r23, r24, r17);
        return;
    L24:
        if (r16.getOnlyOnline() == false) goto L26;
    L38:
        Ref.ObjectRef r18 = new Ref.ObjectRef();
        r18.element = null;
        g r19 = new g(this, r18, r23, r14, r24, r15, r11);
        boolean r20 = GeckoXAdapter.Companion.isCDNMultiVersionResource(r11);
        r10.b(new String[]{"cdn_download_start"});
        if (r20 == false) goto L41;
        r11 = b.a(r11);
    L41:
        Downloader.b(Forest.Companion.getApp());
        DownloadTask r21 = new DownloadTask();
        r21.f15884k.f15853c = r11;
        r21.f15884k.f15851a = r14.getName();
        String r22 = r14.getParent();
        DownloadInfo.Builder r26 = r21.f15884k;
        r26.d = r22;
        r26.f15869x = true;
        r26.D = true;
        int r27 = r16.getLoadRetryTimes();
        DownloadInfo.Builder r28 = r21.f15884k;
        r28.f15856j = r27;
        r21.f15895w = true;
        if (r20 == false) goto L44;
        List r29 = b.f4508b;
    L45:
        r28.I = r29;
        List r30 = com.bytedance.forest.model.b.f4359a;
        r28.E = 20000;
        r21.f15884k.B = r16.getEnableNegotiation();
        boolean r31 = r16.getOnlyOnline();
        DownloadInfo.Builder r32 = r21.f15884k;
        r32.C = r31;
        r32.f15870y = f4516b;
        r21.f15884k.f15858l = !r16.getEnableCDNCache();
        DownloadTask r33 = r21.c(r19.hashCode(), r19);
        r33.f15884k.f15871z = GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG;
        LinkedHashMap r34 = new LinkedHashMap();
        Object r35 = r16.getWebResourceRequest();
        if ((r35 instanceof WebResourceRequest) == false) goto L50;
        Map<String, String> r36 = ((WebResourceRequest) r35).getRequestHeaders();
        if (r36 == null) goto L50;
        r34.putAll(r36);
    L50:
        Iterator<Map.Entry<String, String>> r37 = r16.getInjectedHttpHeaders().entrySet().iterator();
    L52:
        if (r37.hasNext() == false) goto L56;
        Map.Entry<String, String> r38 = r37.next();
        if (r34.containsKey(r38.getKey()) == true) goto L52;
        r34.put(r38.getKey(), r38.getValue());
        goto L52
    L56:
        ArrayList r39 = new ArrayList(r34.size());
        Iterator r40 = r34.entrySet().iterator();
    L58:
        if (r40.hasNext() == false) goto L60;
        Map.Entry r41 = (Map.Entry) r40.next();
        r39.add(new HttpHeader((String) r41.getKey(), (String) r41.getValue()));
        goto L58
    L60:
        r33.f15884k.f15854h = r39;
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L69
        Method r43 = f4517c;     // Catch: Throwable -> L69
        if (r43 == null) goto L73;
        int r44 = Forest.Companion.getCdnCacheDiskMaxAge$forest_release();     // Catch: Throwable -> L69
        Integer r45 = Integer.valueOf(r44);     // Catch: Throwable -> L69
        if (r44 <= 0) goto L66;
        Integer r46 = r45;
    L67:
        if (r46 == null) goto L71;
        int r47 = r46.intValue();     // Catch: Throwable -> L69
    L72:
        Object r48 = r43.invoke(r33, new Object[]{Long.valueOf(((long) (r47 * 1440)) * 60)});     // Catch: Throwable -> L69
    L74:
        Object r49 = Result.m124constructorimpl(r48);     // Catch: Throwable -> L69
    L77:
        final Throwable r50 = Result.m127exceptionOrNullimpl(r49);
        if (r50 == null) goto L80;
        com.bytedance.forest.utils.d.c(r10.g, 5, "res-downloaderdepend", null, null, new DownloadDepender$fetchFile$3$1(r50), 28);
    L80:
        r24.d = Integer.valueOf(r33.d());
        r15.await();
        if (((Integer) r18.element) == null) goto L95;
        Downloader r51 = Downloader.b(r10.f4621c);
        Integer r52 = (Integer) r18.element;
        if (r52 != null) goto L85;
        Intrinsics.throwNpe();
    L85:
        r51.a(r52.intValue(), r19);
        return;
    L95:
        return;
    L71:
        r47 = 14;
        goto L72
    L66:
        r46 = null;
        goto L67
    L73:
        r48 = null;
    L69:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r49 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L77
    L44:
        r29 = null;
        goto L45
    L26:
        if (r16.getEnableCDNCache() == false) goto L38;
        r10.b(new String[]{"cdn_downloader_load_cache_start"});
        DownloadInfo r54 = Downloader.b(Forest.Companion.getApp()).a(r11, r14.getParent());
        r10.b(new String[]{"cdn_downloader_load_cache_finish"});
        if (r54 == null) goto L38;
        char[] r55 = DownloadUtils.f16142a;
        if (DownloadUtils.a(r54, r54.f15828o, r54.C) == true) goto L32;
        boolean r56 = true;
    L33:
        if (r56 == true) goto L38;
        if (d(r23, r14) == false) goto L38;
        r10.b(new String[]{"cdn_cache_finish"});
        r54.U = true;
        c(r23, r24, r54);
        return;
    L32:
        r56 = DownloadUtils.a(r54, false);
    L12:
        r13 = "js";
        goto L13
    }

    @Override // com.bytedance.forest.pollyfill.m
    public final void b(j r5) {
        Object r10 = r5.d;
        if ((r10 instanceof Integer) == true) goto L5;
        r10 = null;
    L5:
        Integer r11 = (Integer) r10;
        if (r11 == null) goto L9;
        int r12 = r11.intValue();
        Downloader.b(Forest.Companion.getApp()).a(r12);
        return;
    }

    public final void c(w r5, a r10, DownloadInfo r11) {
        com.bytedance.forest.utils.e r12 = this.f4518a;
        r12.b(new String[]{"cdn_finish"});
        if (r11 == null) goto L5;
        boolean r13 = r11.U;
    L6:
        r5.f4446w = r13;
        if (r13 == true) goto L9;
        r5.f4441q.getForest().getMemoryManager$forest_release().a(r5.f4441q.getCacheKey$forest_release());
    L9:
        if (r11 == null) goto L13;
        String r14 = r11.f15839u;
        if (r14 == null) goto L13;
        r5.g = StringsKt.X(r14, ";");
        r5.f4434j = StringsKt.X(StringsKt.Q(r14, "charset="), ";");
    L13:
        if (r11 == null) goto L23;
        HashMap r15 = r11.f15807a1;
        if (r15 == null) goto L23;
        String r16 = (String) r15.get("x-gecko-proxy-pkgid");
        if (r16 == null) goto L21;
        Long r17 = StringsKt.toLongOrNull(r16);
        if (r17 == null) goto L21;
        long r18 = r17.longValue();
    L22:
        r5.f4449z = r18;
        r5.f4441q.getCustomParams().put("http_response_headers", r15.toString());
    L21:
        r18 = 0;
    L23:
        r10.d();
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final boolean d(w r5, File r10) {
        if (r10.exists() == false) goto L9;
        if (r10.isFile() == false) goto L9;
        r5.f4442r = true;
        r5.f4443t = r10.getAbsolutePath();
        r5.d(this.f4518a.a(new h(this, r10), r5.f4441q));
        r5.f4444u = ResourceFrom.f4340c;
        return true;
    L9:
        if (StringsKt.isBlank(r5.s.f4367l) == false) goto L11;
        com.bytedance.forest.model.c r11 = r5.s;
        ErrorInfo$Type r12 = ErrorInfo$Type.e;
        r11.getClass();
        r11.f4360a += r11.a(r12, 4, "file not exists or a directory");
    L11:
        return false;
    }
}
