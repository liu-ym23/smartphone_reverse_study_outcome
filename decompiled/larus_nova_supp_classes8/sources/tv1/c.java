package tv1;

import com.bytedance.android.livesdk.feed.dislike.DislikeApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final DislikeApi a;

    public c(DislikeApi r1) {
        this.a = r1;
    }

    public final Observable a(long r10, String r12, String r13, String r14, String r15) {
        return this.a.dislikeRoomSaasLegacy(r10, r12, r12, r13, "", r14, r15).map(new a()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
