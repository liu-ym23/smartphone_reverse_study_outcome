package rj0;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomAnchorWidget;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonObject;
import dq2.w;
import gd0.p;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Pair;
import tf0.q;
import tf0.v;
import w20.xc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface m extends d {
    public static final v a = null;

    void A(w.a r1);

    boolean C(boolean r1, String r2);

    Observable<Boolean> D();

    v E();

    com.bytedance.android.live.liveinteract.videotalk.ui.a F();

    boolean G();

    int H();

    boolean I(boolean r1, User r2);

    void J(Context r1, IRoom r2, b r3);

    int K(boolean r1);

    Pair<Boolean, Long> M(String r1);

    void N(String r1, int r2, LinkApplyType r3, tf0.b r4);

    void Q();

    BehaviorSubject<Boolean> U4();

    void a(q r1);

    void b3();

    void c(Context r1, String r2);

    boolean d(String r1, boolean r2);

    boolean e(boolean r1, String r2);

    void f(String r1);

    boolean finishVideoTalk(String r1);

    void forceReverseCamera();

    MultiLinkVideoTalkRoomAnchorWidget g(v0 r1, com.bytedance.android.live.pushstream.d r2);

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    boolean isRtcEngineOn();

    com.bytedance.android.live.liveinteract.api.data.a j();

    void k(int r1, int r2, boolean r3, boolean r4, int r5, xc.a r6);

    void l(String r1);

    int m();

    void o(h80.a r1);

    void openEmojiDialog(String r1, String r2);

    void r();

    String s();

    void s3();

    int t();

    boolean u(boolean r1, String r2);

    void x(String r1, LinkApplyType r2);

    MultiLinkVideoTalkRoomGuestWidget y(p r1);

    boolean z();

    static {
        a = new v();
    }
}
