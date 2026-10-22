package o7;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h extends AbsDownloadListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void onSuccessed(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getTargetFilePath() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10.getTargetFilePath()) == false) goto L8;
        int r11 = k.a;
        k.b(this.a);
        return;
    L8:
        int r12 = k.a;
        Context r13 = this.a;
        String r0 = this.b;
        String r1 = this.c + "long_click_img.tmp";
        if (r13 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r1) == true) goto L22;
        Observable.create(new f(r13, r0, r1)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe();
        return;
    }

    public final void onFailed(DownloadInfo r1, BaseException r10) {
        int r11 = k.a;
        k.b(this.a);
    }

    public h(Context r1, String r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
