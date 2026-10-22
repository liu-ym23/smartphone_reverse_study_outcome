package llc;

import android.content.Context;
import bytekn.foundation.logger.Logger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import com.ss.ugc.effectplatform.util.i;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements com.ss.ugc.effectplatform.bridge.network.b {
    public static final Object e = null;
    public static b f;
    public static final a g = null;
    public final Context a;
    public final ConcurrentHashMap<String, Triple<String, DownloadTask, NetResponse>> b;
    public final ConcurrentHashMap<Integer, Object> c;
    public final Object d;

    public static final class a {
        public a() {
        }
    }

    static {
        g = new a();
        e = new Object();
    }

    public final Object getContext() {
        return this.d;
    }

    public b(Object r2) {
        this.d = r2;
        if (r2 == null) goto L7;
        this.a = (Context) r2;
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
    }

    public static String c(String r7) {
        String r0 = (String) CollectionsKt.last(StringsKt.split$default(r7, new String[]{"/"}, false, 0, 6, null));
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return r7;
    L9:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void cancel(String r8) {
        Triple<String, DownloadTask, NetResponse> r9 = this.b.get(c(r8));
        if (r9 == null) goto L5;
        String r0 = r9.getFirst();
        DownloadTask r10 = r9.getSecond();
    L6:
        if (r10 == null) goto L11;
        Logger.e$default(Logger.INSTANCE, "JKL", "[取消][调用SDK][" + r0 + "][剩余任务" + this.b.values().size() + "个][DownLoadID : " + r10.getDownloadId() + ']', null, 4, null);
        Downloader.getInstance(this.a).cancel(r10.getDownloadId());
        if (a0.a.a() == true) goto L12;
        d(r10);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r10 = null;
        r0 = "";
        goto L6
    }

    public final void d(DownloadTask r4) {
        if (this.c.get(Integer.valueOf(r4.getDownloadId())) != null) goto L5;
        this.c.put(Integer.valueOf(r4.getDownloadId()), new Object());
    L5:
        Object r0 = this.c.get(Integer.valueOf(r4.getDownloadId()));
        if (r0 == null) goto L19;
        monitor-enter(r0);
        r0.wait();     // Catch: Throwable -> L10 Exception -> L12
    L14:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
        goto L19
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L19:
        this.c.remove(Integer.valueOf(r4.getDownloadId()));
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.INetworkClient
    public final NetResponse fetchFromNetwork(NetRequest r9) {
        return new NetResponse(601, new EmptyByteReadStream(), -1, null, 8, null);
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final void pause(String r6) {
        Triple<String, DownloadTask, NetResponse> r7 = this.b.get(c(r6));
        String r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getFirst();
        DownloadTask r8 = r7.getSecond();
    L6:
        if (r8 == null) goto L14;
        Logger r2 = Logger.INSTANCE;
        StringBuilder r3 = new StringBuilder("[暂停][调用SDK][");
        r3.append(r1);
        r3.append("][剩余任务");
        r3.append(this.b.values().size());
        r3.append("个][暂停链接:");
        DownloadInfo r4 = r8.getDownloadInfo();
        if (r4 == null) goto L10;
        r0 = r4.getUrl();
    L10:
        r3.append(r0);
        r3.append(']');
        r2.w("JKL", r3.toString());
        Downloader.getInstance(this.a).pause(r8.getDownloadId());
        if (a0.a.a() == true) goto L15;
        d(r8);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = "";
        r8 = null;
        goto L6
    }

    public static final void b(b r0, int r1) {
        Object r2 = r0.c.get(Integer.valueOf(r1));
        if (r2 == null) goto L16;
        monitor-enter(r2);
        r2.notifyAll();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        goto L11
    }

    @Override // com.ss.ugc.effectplatform.bridge.network.b
    public final NetResponse a(NetRequest r16, String r17, String r18, com.ss.ugc.effectplatform.bridge.network.a r19) {
        Triple<String, DownloadTask, NetResponse> r2 = this.b.get(c(r16.getUrl()));
        Object r3 = null;
        if (r2 == null) goto L5;
        DownloadTask r4 = r2.getSecond();
    L7:
        if (r4 != null) goto L9;
    L12:
        r4 = Downloader.with(this.a);
        r4.url(r16.getUrl());
        List<String> r5 = r16.getBackupUrl();
        if (r5 == null) goto L15;
        r4.backUpUrls(r5);
    L15:
        i r6 = i.a;
        r4.savePath(i.g(r17));
        r4.name(i.e(r17));
        Map<String, Object> r7 = r16.getExtraParms();
        if (r7 == null) goto L19;
        r3 = r7.get("ParamsNetLimit");
    L19:
        if ((r3 instanceof Long) == true) goto L21;
    L23:
        r4.subThreadListener(new c(this, r19));
        r2 = new Triple(r18, r4, new NetResponse(601, new EmptyByteReadStream(), -1, null, 8, null));
        this.b.put(c(r16.getUrl()), r2);
        r4.download();
        Logger.INSTANCE.d("JKL", "[收到下载请求][SDK][" + r18 + ']');
    L24:
        d(r4);
        if (r2 == null) goto L30;
        NetResponse r1 = r2.getThird();
        if (r1 == null) goto L30;
        return r1;
    L30:
        return new NetResponse(601, new EmptyByteReadStream(), -1, null, 8, null);
    L21:
        if ((!Intrinsics.areEqual(r3, 0L)) == false) goto L23;
        r4.throttleNetSpeed(((Number) r3).longValue());
        goto L23
    L9:
        if (r4.getDownloadId() == 0) goto L12;
        Logger.INSTANCE.d("JKL", "[恢复下载请求][SDK][" + r18 + ']');
        Downloader.getInstance(this.a).resume(r4.getDownloadId());
        goto L24
    L5:
        r4 = null;
        goto L7
    }
}
