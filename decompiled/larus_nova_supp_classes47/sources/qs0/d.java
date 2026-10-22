package qs0;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d {

    public static final class a extends Response<Boolean> {
        public a() {
        }
    }

    Observable<a> f(long r1, long r3);

    boolean isPlayingGame();

    boolean isUserInAnchorLink(String r1);
}
