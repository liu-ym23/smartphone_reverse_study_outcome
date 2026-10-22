package av0;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.rank.widget.HourEntranceState;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import dy0.d;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends d {

    /* JADX INFO: renamed from: av0.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        public static /* synthetic */ void a(a r9, Context r10, int r12, IRoom r13, String r14, long r15, Function1 r16) {
            r9.wg(r10, r12, r13, r14, r15, null, r16);
        }
    }

    public interface b {
        BehaviorSubject<Pair<Boolean, Boolean>> getFromClient();

        BehaviorSubject<Pair<Boolean, Boolean>> getFromLynx();
    }

    Class<? extends Widget> A1();

    void H7(Context r1);

    Class<? extends Widget> Nh();

    void U5(Context r1, long r2, IBaseUser r4, String r5, DialogInterface.OnDismissListener r6);

    HourEntranceState Uc();

    boolean enableHourRank();

    void wg(Context r1, int r2, IRoom r3, String r4, long r5, DialogInterface.OnDismissListener r7, Function1 r8);

    void x8(boolean r1, boolean r2);
}
