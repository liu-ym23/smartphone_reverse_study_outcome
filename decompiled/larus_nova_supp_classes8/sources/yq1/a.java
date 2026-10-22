package yq1;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.replay.paid.PaidReplayPresenter;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.bytedance.android.livesdk.vscore_api.paid.PaidInteractEntry;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_impl.paidlive.ablity.common.container.PaidReplayContainerWidget;
import com.bytedance.android.livesdk.vscore_impl.paidlive.widget.replay.PaidReplayConversionCardWidget;
import com.bytedance.android.livesdk.vscore_impl.paidlive.widget.replay.PaidReplayPlayerTipServiceWidget;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.replay.PaidReplayCallback;
import com.bytedance.android.livesdkapi.replay.paid.ReplayUpdatePaidData;
import com.bytedance.android.scope.j;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.videoshop.context.VideoContext;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ls2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {

    /* JADX INFO: renamed from: yq1.a$a, reason: collision with other inner class name */
    public static final class C0428a {
        public static /* synthetic */ boolean a(a r1, DataCenter r2, Boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = Boolean.FALSE;
        L9:
            return r1.L(r2, r3);
        }
    }

    Map<String, String> A(DataCenter r1, Episode r2);

    boolean E(DataCenter r1, PaidSceneEnum r2, List<? extends PaidSceneEnum> r3);

    void F(j r1, ViewGroup r2, PaidReplayPresenter r3, Map r4);

    PaidReplayConversionCardWidget I();

    void J(DataCenter r1, PaidSceneEnum r2, Map r3, Episode r4);

    Map<String, String> K(DataCenter r1, PaidSceneEnum r2);

    boolean L(DataCenter r1, Boolean r2);

    boolean N(DataCenter r1, PaidSceneEnum r2);

    void R(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r1, PaidSceneViewEntry r2, boolean r3);

    PaidReplayPlayerTipServiceWidget a();

    com.bytedance.android.livesdk.vscore_api.paidlive.scope.b c(long r1, int r3, FragmentActivity r4, LifecycleOwner r5, DataCenter r6, VideoContext r7, Function0 r8, ReplayPaidInfo r9, Function0 r10, PaidSceneViewEntry r11);

    void d(j r1, PaidSceneViewEntry r2);

    boolean f(long r1, int r3, PaidSceneViewEntry r4);

    void g(long r1, String r3, boolean r4, e r5, EndReason r6);

    void h(DataCenter r1, LifecycleOwner r2, PaidReplayCallback r3);

    void i(DataCenter r1, Function0 r2);

    void j(long r1, int r3, PaidSceneViewEntry r4);

    PaidReplayContainerWidget k(ViewGroup r1, Episode r2);

    boolean n(DataCenter r1, PaidInteractEntry r2);

    PaidSceneEnum o(Episode r1);

    String q(DataCenter r1);

    boolean s(DataCenter r1);

    void w(long r1, ls2.a r3);

    void x(j r1, Function0<Unit> r2);

    MutableLiveData<ReplayUpdatePaidData> y(DataCenter r1);
}
