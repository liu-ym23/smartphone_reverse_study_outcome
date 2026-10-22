package d12;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.download.TTDownloadException;
import com.bytedance.android.livesdk.gift.platform.core.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftResourceFileCacheService;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdk.revenue.monitor.EventType;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.WriteStorageException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import cy0.j;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends c12.c {
    public static final ExecutorService d = null;
    public com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> c;

    public class a extends AbsDownloadListener {
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e a;
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;
        public final /* synthetic */ d f;

        public final void onSuccessed(DownloadInfo r21) {
            super.onSuccessed(r21);
            JSONObject r1 = new JSONObject();
            long r3 = 0;
            if (this.f.a == false) goto L11;
            long r5 = this.a.c;
            if (r5 != 0) goto L15;
            PolarisFileWrapper r6 = new PolarisFileWrapper(this.b);
            if (r6.exists() == false) goto L9;
            r5 = r6.length();
        L10:
            this.a.c = r5;
            goto L15
        L9:
            r5 = 0;
        L15:
            long r8 = r5;
            if (h.g().d() == true) goto L18;
            d0.o(r1, "fileLength", Long.valueOf(r8));
            d0.o(r1, "downTime", Long.valueOf(System.currentTimeMillis() - this.c));
            d0.o(r1, "fromPcdn", "1");
            d0.l(0, this.a.l, r1, this.d);
        L22:
            this.f.c.b(this.a, this.b);
            return;
        L18:
            if (r21 == null) goto L20;
            double r2 = r21.getDownloadSpeed();
            r3 = r21.getRealDownloadTime();
        L21:
            double r15 = r2;
            d r4 = this.f;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r7 = this.a;
            long r10 = this.c;
            String r14 = this.e;
            r4.getClass();
            c12.c.c(r7, r8, r10, r3, r14, r15, 0, BuildConfig.FLAVOR, 3);
            goto L22
        L20:
            r2 = 0.0d;
            goto L21
        L11:
            PolarisFileWrapper r9 = new PolarisFileWrapper(this.b);
            if (r9.exists() == false) goto L14;
            r5 = r9.length();
            goto L15
        L14:
            r5 = 0;
            goto L15
        }

        public final void onFailed(DownloadInfo r14, BaseException r15) {
            super.onFailed(r14, r15);
            TTDownloadException r6 = new TTDownloadException(r15.getErrorMessage(), r15, this.a, r15.getErrorCode(), new dd6.a(r14.getUrl()));
            this.f.c.l(this.a, r6);
            if (h.g().d() == true) goto L5;
            Integer r0 = Integer.valueOf(r15.getErrorCode());
            String r1 = r15.getErrorMessage();
            Integer r2 = Integer.valueOf(r15.getErrorCode());
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r16 = this.a;
            d0.k(r0, r1, r2, r16.l, this.d, r16.i);
            return;
        L5:
            d r17 = this.f;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3 = this.a;
            long r4 = this.c;
            String r7 = this.e;
            int r10 = r15.getErrorCode();
            String r11 = r15.getErrorMessage();
            r17.getClass();
            c12.c.c(r3, 0, r4, 0, r7, 0.0d, r10, r11, 3);
        }

        public a(d r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r2, String r3, long r4, int r6, String r7) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r7;
        }
    }

    static {
        d = PThreadExecutorsUtils.newSingleThreadExecutor(new b());
    }

    public d(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r1) {
        super(r1);
    }

    public final void a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r13, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r14) {
        if (r13 != null) goto L6;
        jy0.b.a("PcdnDownloadProducer", "GetResourceRequest is null.");
        return;
    L6:
        this.c = r14;
        String r15 = b(r13);
        if (r15 != null) goto L9;
    L35:
        this.c.l(r13, new WriteStorageException("write storage failed.", new IOException("mkdirs return false"), r13));
        return;
    L9:
        if (r15.isEmpty() == true) goto L35;
        if (d12.a.a == false) goto L14;
        jy0.b.a("PcdnDownloadProducer", "createTask = " + r13.b());
    L14:
        String r7 = r13.k;
        Intrinsics.checkNotNullParameter(r7, "md5");
        Intrinsics.checkNotNullParameter(r15, "filePath");
        if (((GiftResourceFileCacheService) com.bytedance.android.live.revenue.core.util.f.a(GiftResourceFileCacheService.class)).h().getEnable() == false) goto L19;
        int r1 = StringsKt.lastIndexOf$default(r15, "/zip", 0, false, 6, null);
        if (r1 == (-1)) goto L22;
        String r2 = r15.substring(r1);
    L23:
        long r3 = r13.l;
        if (r3 == 1000) goto L28;
        if (r3 == 1010) goto L28;
    L33:
        r13.b();
        e.b().a();
        d(r13, r15, 12).download();
        jy0.b.a("PcdnDownloadProducer", "downloadTask is null, url = " + r13.b() + ", id = " + r13.k + ", fileName = " + r2);
        long r16 = r13.l;
        boolean r0 = d0.a;
        Intrinsics.checkNotNullParameter("ttlive_gift_pcdn_download_result", "serviceName");
        JSONObject r6 = new JSONObject();
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "extra");
        Intrinsics.checkNotNullParameter(r8, "metric");
        EventModule r4 = EventModule.LIVE_GIFT;
        Intrinsics.checkNotNullParameter(r4, "eventModule");
        String r5 = r4.getValue();
        EventType r10 = EventType.BUSSINESS_API_CALL;
        Intrinsics.checkNotNullParameter(r10, "eventType");
        String r11 = r10.getValue();
        Intrinsics.checkNotNullParameter(r6, "map");
        Intrinsics.checkNotNullParameter("status_code", "key");
        Intrinsics.checkNotNullParameter(2, "value");
        r6.put("status_code", 2);
        Long r17 = Long.valueOf(r16);
        Intrinsics.checkNotNullParameter("source", "key");
        Intrinsics.checkNotNullParameter(r17, "value");
        r6.put("source", r17);
        Intrinsics.checkNotNullParameter(r9, "map");
        cy0.e.a.getClass();
        j r18 = cy0.e.a.a;
        m.e.getClass();
        Object r19 = m.b(r18).b(n97.a.class);
        Intrinsics.checkNotNull(r19);
        ((com.bytedance.live.kmp.core.c) r19).g("ttlive_gift_pcdn_download_result", r5, r11, r6, r8, r9);
        return;
    L28:
        if (h.g().e() == false) goto L33;
        if (h.g().f() == false) goto L32;
        r13.h = true;
        d(r13, r15, 11).fastDownload().download();
        return;
    L32:
        d(r13, r15, 11).download();
        return;
    L22:
        r2 = null;
        goto L23
    L19:
        int r20 = StringsKt.lastIndexOf$default(r15, "/", 0, false, 6, null);
        if (r20 == (-1)) goto L22;
        r2 = r7 + r15.substring(r20);
        goto L23
    }

    public final DownloadTask d(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r11, String r13, int r14) {
        long r4 = System.currentTimeMillis();
        String r7 = r11.b();
        if (d12.a.a == false) goto L5;
        jy0.b.a("PcdnDownloadProducer", "pcdn fail, back to Downloader for retry ,uri:" + r7);
    L5:
        DownloadTask r0 = Downloader.with(s1.getContext()).url(r7);
        int r2 = r13.lastIndexOf("/");
        String r3 = null;
        if (r2 == (-1)) goto L8;
        String r5 = r13.substring(r2);
    L9:
        DownloadTask r1 = r0.name(r5).monitorScene("gift_asset");
        int r6 = r13.lastIndexOf("/");
        if (r6 == (-1)) goto L13;
        r3 = r13.substring(0, r6);
    L13:
        return r1.savePath(r3).subThreadListener(new a(this, r11, r13, r4, r14, r7));
    L8:
        r5 = null;
        goto L9
    }
}
