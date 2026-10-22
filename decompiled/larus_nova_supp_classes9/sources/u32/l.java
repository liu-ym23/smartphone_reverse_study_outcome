package u32;

import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface l {

    public interface a {
        void b(l r1, com.bytedance.android.livesdk.interactivity.api.like.model.a r2);

        void d(l r1, int r2, int r3, Text r4, Text r5);

        void e(l r1, int r2);

        void k(l r1, List<d4> r2);

        void l(l r1, com.bytedance.android.livesdk.interactivity.api.like.model.a r2);
    }

    void addListener(a r1, boolean r2);

    void onLocalLike(int r1);

    void onLocalLikeResult(int r1, boolean r2, boolean r3);

    void removeListener(a r1);

    void setDoubleLikeEnable(boolean r1);
}
