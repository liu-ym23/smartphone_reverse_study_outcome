package c12;

import ca0.v;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IRoomStateService;
import com.bytedance.android.livesdk.gift.platform.core.download.TTDownloadException;
import com.bytedance.android.livesdk.gift.platform.core.z;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.exception.WriteStorageException;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends m implements v {
    public boolean g;
    public final List<Integer> h;
    public boolean i;
    public final boolean j;

    public static final class a {
    }

    public static final class b extends AbsDownloadListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ com.bytedance.android.livesdk.gift.platform.business.effect.assets.e b;
        public final /* synthetic */ String c;

        public final void onProgress(DownloadInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "entity");
            super.onProgress(r4);
            if (this.a.j == false) goto L8;
            ALogger.d("HuoshanTTSpeedLimitDownloadProducer", "TTDownload Progress assetsId:  " + this.b.i + "  md5=  " + r4.getName() + "  speed(MB/s)=  " + r4.getDownloadSpeed());
            f r0 = this.a;
            r0.getClass();
            if (z.a() == false) goto L9;
            r0.f = (float) r4.getDownloadSpeed();
            return;
        L9:
            return;
        }

        public final void onSuccessed(DownloadInfo r4) {
            Intrinsics.checkNotNullParameter(r4, "entity");
            super.onSuccessed(r4);
            com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.b(this.b, this.c);
        L6:
            if (this.a.j == false) goto L9;
            ALogger.d("HuoshanTTSpeedLimitDownloadProducer", "TTDownload Success assetsId:  " + this.b.i + "  md5=  " + r4.getName() + "  speed(MB/s)=  " + r4.getDownloadSpeed());
            this.a.e(r4);
            return;
        }

        public final void onFailed(DownloadInfo r9, BaseException r10) {
            Intrinsics.checkNotNullParameter(r9, "entity");
            Intrinsics.checkNotNullParameter(r10, "e");
            super.onFailed(r9, r10);
            TTDownloadException r0 = new TTDownloadException("HuoshanTTSpeedLimitDownloadProducer" + r10.getErrorMessage(), r10, this.b, r10.getErrorCode(), new dd6.a(r9.getUrl()));
            com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r11 = this.a.c;
            if (r11 == null) goto L6;
            r11.l(this.b, r0);
        L6:
            if (this.a.j == false) goto L9;
            ALogger.d("HuoshanTTSpeedLimitDownloadProducer", "TTDownloadFailed assetsId:  " + this.b.i + "  md5=  " + r9.getName() + "  speed(MB/s)=  " + r9.getDownloadSpeed());
            return;
        }

        public b(f r1, com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void onEnterRoom() {
        g(true);
    }

    public final void onExitRoom() {
        g(false);
    }

    public f(com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mFileCacheFactory");
        super(r2);
        this.h = new ArrayList();
        this.j = z.a();
    }

    public final void g(boolean r3) {
        this.g = !r3;
        Iterator r4 = ((ArrayList) this.h).iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        DownloadInfo r0 = Downloader.getInstance(s1.getContext()).getDownloadInfo(((Number) r4.next()).intValue());
        if (r0 == null) goto L11;
        if (r0.getDownloadProcess() > 0) goto L11;
        r0.setOpenLimitSpeed(this.g);
    L11:
        r4.remove();
        goto L4
    }

    @Override // c12.m
    public final void a(com.bytedance.android.livesdk.gift.platform.business.effect.assets.e r4, com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r5) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r5, "consumer");
        boolean r1 = true;
        if (this.i == true) goto L5;
        jc1.k.n(IRoomStateService.class).registRoomStateListner(this);
        this.i = true;
    L5:
        this.c = r5;
        String r6 = b(r4);
        if (r6 != null) goto L8;
    L11:
        if (r1 == false) goto L16;
        WriteStorageException r7 = new WriteStorageException("write storage failed.", new IOException("mkdirs return false"), r4);
        com.bytedance.kmp.livesdk.gift.platform.resourcemanager.a<String> r0 = this.c;
        if (r0 == null) goto L22;
        r0.l(r4, r7);
        return;
    L22:
        return;
    L16:
        DownloadTask r2 = Downloader.with(s1.getContext()).url(r4.b());
        int r3 = r6.lastIndexOf("/");
        if (r3 == (-1)) goto L19;
        String r8 = r6.substring(r3);
    L20:
        int r9 = r2.name(r8).savePath(d(r6)).monitorScene("gift_asset").isOpenLimitSpeed(this.g).subThreadListener(new b(this, r4, r6)).download();
        List<Integer> r10 = this.h;
        ArrayList r11 = (ArrayList) r10;
        r11.add(Integer.valueOf(r9));
        return;
    L19:
        r8 = null;
        goto L20
    L8:
        if (r6.length() == 0) goto L11;
        r1 = false;
        goto L11
    }
}
