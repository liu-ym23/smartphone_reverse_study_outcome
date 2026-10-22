package llc;

import bytekn.foundation.logger.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.capabilitykit.entity.app.EntityType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.ugc.effectplatform.bridge.network.EmptyByteReadStream;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c implements IDownloadListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ com.ss.ugc.effectplatform.bridge.network.a b;

    public static final class a extends FilterInputStream {
        public final /* synthetic */ FileInputStream a;

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            super.close();
            this.a.close();
        }

        public a(PolarisFileInputStreamWrapper r1, PolarisFileInputStreamWrapper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public final void onFirstStart(DownloadInfo r1) {
    }

    public final void onFirstSuccess(DownloadInfo r1) {
    }

    public final void onPrepare(DownloadInfo r1) {
    }

    public final void onRetryDelay(DownloadInfo r1, BaseException r2) {
    }

    public final void onCanceled(DownloadInfo r8) {
        Triple r0 = (Triple) this.a.b.get(b.c(r8.getUrl()));
        if (r0 == null) goto L7;
        String r1 = (String) r0.getFirst();
        if (r1 == null) goto L7;
    L8:
        Logger.e$default(Logger.INSTANCE, "JKL", "[取消][SDK][" + r1 + "][网络响应码：" + r8.getHttpStatusCode() + "][耗时:" + r8.getDownloadTime() + ']', null, 4, null);
        Triple r2 = (Triple) this.a.b.get(b.c(r8.getUrl()));
        if (r2 == null) goto L13;
        NetResponse r3 = (NetResponse) r2.getThird();
        if (r3 == null) goto L13;
        r3.setStatusCode(600);
        r3.setBodyStream(new EmptyByteReadStream());
        r3.setContentLength(-3);
    L13:
        Triple r4 = (Triple) this.a.b.remove(b.c(r8.getUrl()));
        b.b(this.a, r8.getId());
        return;
    L7:
        r1 = "";
        goto L8
    }

    public final void onPause(DownloadInfo r5) {
        Triple r0 = (Triple) this.a.b.get(b.c(r5.getUrl()));
        if (r0 == null) goto L7;
        String r1 = (String) r0.getFirst();
        if (r1 == null) goto L7;
    L8:
        Logger.INSTANCE.w("JKL", "[暂停][SDK][" + r1 + "][网络状态码:" + r5.getHttpStatusCode() + "][进度:" + r5.getDownloadProcess() + ']');
        Triple r2 = (Triple) this.a.b.get(b.c(r5.getUrl()));
        if (r2 == null) goto L13;
        NetResponse r3 = (NetResponse) r2.getThird();
        if (r3 == null) goto L13;
        r3.setStatusCode(206);
        r3.setBodyStream(new EmptyByteReadStream());
        r3.setContentLength(-2);
    L13:
        b.b(this.a, r5.getId());
        return;
    L7:
        r1 = "";
        goto L8
    }

    public final void onProgress(DownloadInfo r5) {
        com.ss.ugc.effectplatform.bridge.network.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onProgress(r5.getDownloadProcess(), r5.getTotalBytes());
        return;
    }

    public final void onStart(DownloadInfo r4) {
        Triple r5 = (Triple) this.a.b.get(b.c(r4.getUrl()));
        if (r5 == null) goto L7;
        String r6 = (String) r5.getFirst();
        if (r6 == null) goto L7;
    L8:
        Logger.INSTANCE.d("JKL", "[开始][SDK][" + r6 + ']');
        return;
    L7:
        r6 = "";
        goto L8
    }

    public final void onSuccessed(DownloadInfo r6) {
        Triple r0 = (Triple) this.a.b.get(b.c(r6.getUrl()));
        if (r0 == null) goto L7;
        String r1 = (String) r0.getFirst();
        if (r1 == null) goto L7;
    L8:
        Logger.INSTANCE.d("JKL", "[成功][SDK][" + r1 + "][状态码:" + r6.getHttpStatusCode() + "][总大小:" + r6.getTotalBytes() + "][单次耗时:" + r6.getDownloadTime() + "][总体耗时:" + r6.getRealDownloadTime() + ']');
        PolarisFileInputStreamWrapper r2 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r6.getTargetFilePath()));
        e r3 = new e(new a(r2, r2));
        Triple r4 = (Triple) this.a.b.get(b.c(r6.getUrl()));
        if (r4 == null) goto L13;
        NetResponse r5 = (NetResponse) r4.getThird();
        if (r5 == null) goto L13;
        r5.setStatusCode(200);
        r5.setBodyStream(r3);
        r5.setContentLength(r6.getTotalBytes());
        r5.setFilePath(r6.getSavePath() + File.separator + r6.getName());
    L13:
        Triple r7 = (Triple) this.a.b.remove(b.c(r6.getUrl()));
        b.b(this.a, r6.getId());
        return;
    L7:
        r1 = "";
        goto L8
    }

    public c(b r1, com.ss.ugc.effectplatform.bridge.network.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r8, BaseException r9) {
        Triple r0 = (Triple) this.a.b.get(b.c(r8.getUrl()));
        if (r0 == null) goto L7;
        String r1 = (String) r0.getFirst();
        if (r1 == null) goto L7;
    L8:
        Logger.e$default(Logger.INSTANCE, "JKL", "[失败][SDK][" + r1 + "][耗时:" + r8.getDownloadTime() + "][StatusCode:" + r8.getHttpStatusCode() + "][Size：" + r8.getExpectFileLength() + "][ErrorMsg:" + r9.getErrorMessage() + ']', null, 4, null);
        Triple r2 = (Triple) this.a.b.get(b.c(r8.getUrl()));
        if (r2 == null) goto L17;
        NetResponse r3 = (NetResponse) r2.getThird();
        if (r3 == null) goto L17;
        if (r8.getHttpStatusCode() != 200) goto L15;
        int r4 = EntityType.NOTE;
    L16:
        r3.setStatusCode(r4);
        r3.setBodyStream(new EmptyByteReadStream());
        r3.setContentLength(-1);
        r3.setErrorMsg(r9.getErrorMessage());
        goto L17
    L15:
        r4 = r8.getHttpStatusCode();
    L17:
        r9.printStackTrace();
        Triple r10 = (Triple) this.a.b.remove(b.c(r8.getUrl()));
        b.b(this.a, r8.getId());
        return;
    L7:
        r1 = "";
        goto L8
    }

    public final void onRetry(DownloadInfo r7, BaseException r8) {
        Logger.e$default(Logger.INSTANCE, "JKL", "[重试][SDK] : " + r7.getId(), null, 4, null);
    }
}
