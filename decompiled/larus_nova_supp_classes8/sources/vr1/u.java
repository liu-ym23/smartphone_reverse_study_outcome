package vr1;

import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import com.bytedance.android.livesdk.chatroom.model.z3;
import com.bytedance.android.livesdk.chatroom.widget.i0;
import com.bytedance.android.livesdk.chatroom.widget.m0;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.JsonObject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface u {
    com.bytedance.live.datacontext.m<Boolean> A();

    com.bytedance.live.datacontext.m<MutableLiveData<Boolean>> B1();

    com.bytedance.live.datacontext.j<ViewModel> E();

    com.bytedance.live.datacontext.j<i0> F();

    z3 I();

    boolean J();

    com.bytedance.live.datacontext.m<Integer> J0();

    com.bytedance.live.datacontext.n<xn1.a> K();

    com.bytedance.live.datacontext.m<z0> K0();

    com.bytedance.live.datacontext.n<JsonObject> L();

    com.bytedance.android.livesdk.chatroom.msgboard.a L0();

    com.bytedance.live.datacontext.j<m0> N();

    ylc.e N0();

    com.bytedance.live.datacontext.n<JsonObject> R();

    com.bytedance.live.datacontext.i<Boolean> S();

    com.bytedance.live.datacontext.m<Long> S0();

    com.bytedance.live.datacontext.n<lh1.b> T0();

    com.bytedance.live.datacontext.m<Integer> U();

    boolean X();

    com.bytedance.live.datacontext.m<Boolean> X0();

    com.bytedance.live.datacontext.m<String> Y();

    com.bytedance.live.datacontext.k<Boolean> Y0();

    com.bytedance.live.datacontext.j<vlc.d> a();

    com.bytedance.live.datacontext.n<h80.d<GestureDetector.SimpleOnGestureListener>> b0();

    ViewModel c();

    com.bytedance.live.datacontext.m<Long> cameraId();

    com.bytedance.live.datacontext.n<Rect> d();

    long d1();

    boolean e0();

    com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0<pp1.c>> e1();

    com.bytedance.live.datacontext.m<Integer> f();

    com.bytedance.live.datacontext.j<cq1.a> f0();

    com.bytedance.live.datacontext.n<?> g();

    com.bytedance.live.datacontext.j<?> h();

    com.bytedance.live.datacontext.m<Long> i();

    com.bytedance.live.datacontext.m<Boolean> isCleanMode();

    boolean isPortraitInteraction();

    Boolean isVSVerticalStream();

    com.bytedance.live.datacontext.m<Boolean> j();

    Room j0();

    com.bytedance.live.datacontext.j<Unit> k();

    IRoom k2();

    com.bytedance.live.datacontext.n<h80.d<com.bytedance.android.live.core.tetris.layer.view.a>> n();

    User o();

    com.bytedance.live.datacontext.m<Boolean> o0();

    com.bytedance.live.datacontext.n<JsonObject> p0();

    com.bytedance.live.datacontext.j<Long> q();

    com.bytedance.live.datacontext.n<h80.d<Pair<Fragment, FragmentManager>>> s();

    com.bytedance.live.datacontext.n<PadOrientation> w();

    com.bytedance.live.datacontext.n<RecyclableWidgetManager> w0();

    com.bytedance.live.datacontext.n<h80.d<Function1<MotionEvent, Unit>>> x();

    com.bytedance.live.datacontext.m<Boolean> x0();

    com.bytedance.live.datacontext.m<Boolean> x1();

    com.bytedance.live.datacontext.m<Boolean> y();

    float y0();

    com.bytedance.live.datacontext.n<Long> y7();

    com.bytedance.live.datacontext.m<Boolean> z1();
}
