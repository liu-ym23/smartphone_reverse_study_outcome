package c12;

import com.bytedance.android.livesdk.gift.platform.core.d0;
import com.bytedance.android.livesdk.gift.platform.core.download.TTDownloadException;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends AbsDownloadListener {
    public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ m f;

    public final void onProgress(DownloadInfo r1) {
        super.onProgress(r1);
    }

    public final void onSuccessed(DownloadInfo r20) {
        super.onSuccessed(r20);
        if (this.f.a == false) goto L11;
        this.a.c = r20.getTotalBytes();
        long r4 = this.a.c;
        if (r4 != 0) goto L15;
        m r1 = this.f;
        String r5 = this.b;
        r1.getClass();
        PolarisFileWrapper r2 = new PolarisFileWrapper(r5);
        if (r2.exists() == false) goto L9;
        r4 = r2.length();
    L10:
        this.a.c = r4;
        goto L15
    L9:
        r4 = 0;
    L15:
        long r7 = r4;
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().d() == true) goto L21;
        JSONObject r3 = new JSONObject();
        long r6 = System.currentTimeMillis();
        long r8 = this.c - this.a.e;
        if (r20 == null) goto L20;
        d0.o(r3, "in_duration", Long.valueOf(r20.getDownloadStartTimeStamp() - this.c));
        d0.o(r3, "prepare", Long.valueOf(r20.getDownloadPrepareTime()));
        d0.o(r3, "speed", Double.valueOf(r20.getDownloadSpeed()));
        d0.o(r3, "real_time", Long.valueOf(r20.getRealDownloadTime()));
    L20:
        long r9 = r6 - this.a.e;
        d0.o(r3, "fileLength", Long.valueOf(r7));
        d0.o(r3, "downTime", Long.valueOf(r6 - this.c));
        d0.o(r3, "asset_id", Long.valueOf(this.a.i));
        d0.o(r3, "out_duration", Long.valueOf(r8));
        d0.o(r3, "total_duration", Long.valueOf(r9));
        d0.l(0, this.a.l, r3, this.d);
    L25:
        this.f.c.b(this.a, this.b);
        return;
    L21:
        if (r20 == null) goto L23;
        double r14 = r20.getDownloadSpeed();
        long r11 = r20.getRealDownloadTime();
    L24:
        m r10 = this.f;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r13 = this.a;
        long r15 = this.c;
        String r16 = this.e;
        r10.getClass();
        c.c(r13, r7, r15, r11, r16, r14, 0, BuildConfig.FLAVOR, 2);
        goto L25
    L23:
        r11 = 0;
        r14 = 0.0d;
        goto L24
    L11:
        PolarisFileWrapper r17 = new PolarisFileWrapper(this.b);
        if (r17.exists() == false) goto L14;
        r4 = r17.length();
        goto L15
    L14:
        r4 = 0;
        goto L15
    }

    public final void onFailed(DownloadInfo r14, BaseException r15) {
        super.onFailed(r14, r15);
        TTDownloadException r6 = new TTDownloadException(r15.getErrorMessage(), r15, this.a, r15.getErrorCode(), new dd6.a(r14.getUrl()));
        this.f.c.l(this.a, r6);
        if (com.bytedance.android.livesdk.gift.platform.core.h.g().d() == true) goto L5;
        Integer r0 = Integer.valueOf(r15.getErrorCode());
        String r1 = r15.getErrorMessage();
        Integer r2 = Integer.valueOf(r15.getErrorCode());
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r16 = this.a;
        d0.k(r0, r1, r2, r16.l, this.d, r16.i);
        return;
    L5:
        m r17 = this.f;
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r3 = this.a;
        long r4 = this.c;
        String r7 = this.e;
        int r10 = r15.getErrorCode();
        String r11 = r15.getErrorMessage();
        r17.getClass();
        c.c(r3, 0, r4, 0, r7, 0.0d, r10, r11, 2);
    }

    public l(m r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r2, String r3, long r4, String r6) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 10;
        this.e = r6;
    }
}
