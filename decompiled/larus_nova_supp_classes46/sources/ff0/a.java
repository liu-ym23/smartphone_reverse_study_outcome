package ff0;

import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements SingleOnSubscribe {
    public final /* synthetic */ DownloadTask a;

    public a(DownloadTask r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<Object> r1) {
        this.a.download();
    }
}
