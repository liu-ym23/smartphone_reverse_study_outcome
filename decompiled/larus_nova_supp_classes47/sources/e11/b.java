package e11;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        a = a.a;
    }

    Observable<ExtraResponse<r, Extra>> getLinkAnchorList(long r1, long r3, long r5, long r7, int r9, boolean r10, String r12, long r13);

    Observable<ExtraResponse<Object, Extra>> sendSignalV3(long r1, String r3, int r4);
}
