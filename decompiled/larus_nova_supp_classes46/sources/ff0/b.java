package ff0;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends AbsDownloadListener {
    public final /* synthetic */ Function1 a;

    public b(Function1 r1) {
        this.a = r1;
    }

    public final void onSuccessed(DownloadInfo r2) {
        super.onSuccessed(r2);
        if (r2 == null) goto L8;
        String r3 = r2.getTargetFilePath();
        if (r3 == null) goto L9;
        this.a.invoke(r3);
        return;
    L9:
        return;
    }

    public final void onFailed(DownloadInfo r1, BaseException r2) {
        super.onFailed(r1, r2);
    }
}
