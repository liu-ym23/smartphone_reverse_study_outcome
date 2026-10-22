package com.bytedance.forest.pollyfill;

import android.net.Uri;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f4507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f4508b = null;

    static {
        f4507a = LazyKt.lazy(CDNFetchDepender$directory$2.f4450a);
        f4508b = CollectionsKt.listOf(new String[]{"x-gecko-proxy-pkgid", "content-type", "content-length", "content-encoding", "x-gecko-proxy-logid", "x-gecko-proxy-tvid", "x-tos-version-id", "x-bdcdn-cache-status", "x-cache", "x-response-cache", "x-tt-trace-host", "via"});
    }

    public static String a(String r5) {
        Uri.Builder r10 = Uri.parse(r5).buildUpon();
        Iterator<Map.Entry<String, String>> r11 = GeckoXAdapter.Companion.getCDNMultiVersionCommonParams().entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        Map.Entry<String, String> r12 = r11.next();
        r10.appendQueryParameter(r12.getKey(), r12.getValue());
        goto L4
    L7:
        return r10.build().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(String r5, File r10, com.bytedance.forest.utils.e r11) {
        AtomicBoolean r12 = q.f4535b;
        if (r10 == null) goto L7;
        final String r13 = r10.getName();
        if (r13 == null) goto L7;
    L8:
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        Boolean r15 = null;
        r14.element = null;
        ConcurrentHashMap r16 = com.bytedance.forest.utils.o.f4654a;
        com.bytedance.forest.utils.o.a(r5, r11.g, null, new TTNetDepender$Companion$checkExpired$1(r13, r14), null);
        Boolean r17 = (Boolean) r14.element;
        if (r17 == null) goto L11;
        r15 = r17;
    L21:
        if (r15 != null) goto L23;
        return true;
    L23:
        return r15.booleanValue();
    L11:
        JSONObject r18 = i.f4516b;
        if (r10 == null) goto L20;
        DownloadInfo r19 = Downloader.b(Forest.Companion.getApp()).a(r5, r10.getParent());
        if (r19 == null) goto L21;
        char[] r20 = DownloadUtils.f16142a;
        if (DownloadUtils.a(r19, r19.f15828o, r19.C) == true) goto L18;
        boolean r21 = true;
    L19:
        r15 = Boolean.valueOf(r21);
        goto L21
    L18:
        r21 = DownloadUtils.a(r19, false);
        goto L19
    L20:
        r15 = Boolean.TRUE;
    L7:
        r13 = "";
        goto L8
    }
}
