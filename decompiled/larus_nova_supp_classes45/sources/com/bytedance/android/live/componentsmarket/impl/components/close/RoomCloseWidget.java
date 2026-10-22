package com.bytedance.android.live.componentsmarket.impl.components.close;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c0;
import com.bytedance.android.live.core.setting.f0;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.config.fl;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstCompShowConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import ev1.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t70.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.MatchRoomCount, needDynamicControl = true, type = PlayerViewControl.Type.TOP)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/close/RoomCloseWidget;", "Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsTetris;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/a;", "Lp70/d;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomCloseWidget extends BaseComponentsTetris implements o70.a, p70.d {
    public final String s;
    public Disposable t;
    public final Lazy u;

    @Override // o70.a
    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(new Class[]{bh1.a.class, bh1.b.class});
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ViewModel a0(FragmentActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "cxt");
        return null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final o40.a c0() {
        return null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void d0() {
    }

    @Override // p70.d
    public final Set<p70.c<?>> ud() {
        return SetsKt.setOf((RoomCloseWidget$fullInterceptProcessor$2.a) this.u.getValue());
    }

    public RoomCloseWidget() {
        this.s = "RoomCloseWidget";
        this.u = LazyKt.lazy(new RoomCloseWidget$fullInterceptProcessor$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void O() {
        super.O();
        d90.a r0 = (d90.a) K();
        final f r1 = new f(this, r0);
        if (((Boolean) f0.a.getValue()).booleanValue() == false) goto L7;
        ViewGroup r2 = Z();
        if (r2 == null) goto L16;
        UtilityKotlinExtentionsKt.w(r2);
    L16:
        r3.c(Z(), s1.B(2131918650), true);
        DataCenter r3 = ((d90.a) K()).h;
        if (r3 == null) goto L19;
        r3.observe("data_media_introduction_showing", this);
    L19:
        DataCenter r4 = ((d90.a) K()).h;
        if (r4 == null) goto L23;
        r4.observe("cmd_p0_widget_loaded", this);
    L23:
        if (((Boolean) fl.a.getValue()).booleanValue() == false) goto L40;
        DataCenter r5 = ((d90.a) K()).h;
        if (r5 == null) goto L30;
        Boolean r6 = (Boolean) r5.get("enable_rxjava_async", Boolean.FALSE);
        if (r6 == null) goto L30;
        boolean r7 = r6.booleanValue();
    L31:
        Observable r8 = xs2.b.a().b(y.class).filter(new g(this));
        if (r7 == false) goto L34;
        Scheduler r9 = Schedulers.io();
    L35:
        Disposable r11 = r8.subscribeOn(r9).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(this));
        Disposable r12 = this.t;
        if (r12 == null) goto L38;
        r12.dispose();
    L38:
        this.t = r11;
        goto L40
    L34:
        r9 = AndroidSchedulers.mainThread();
    L30:
        r7 = false;
    L40:
        if (FirstCompShowConfig.INSTANCE.isDelayClose() == false) goto L45;
        ViewGroup r13 = Z();
        if (r13 == null) goto L46;
        UtilityKotlinExtentionsKt.u(r13);
        return;
    L46:
        return;
    L45:
        return;
    L7:
        RoomContext.a r14 = RoomContext.Companion;
        DataCenter r15 = r0.h;
        Room r16 = d90.c.q(r0);
        if (r16 == null) goto L10;
        long r17 = r16.getRoomId();
    L11:
        r14.getClass();
        RoomContext r18 = RoomContext.a.a(r15, r17);
        if (r18 == null) goto L16;
        j r19 = r18.getWidgetLoadTaskScheduler();
        if (r19 == null) goto L16;
        r19.c(new RoomCloseWidget$initCloseLayout$1(this, r1));
        goto L16
    L10:
        r17 = 0;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final void onDestroy() {
        super.onDestroy();
        if (((Boolean) c0.a.getValue()).booleanValue() == false) goto L7;
        DataCenter r0 = ((d90.a) K()).h;
        if (r0 == null) goto L7;
        r0.removeObserver("data_media_introduction_showing", this);
    L7:
        DataCenter r1 = ((d90.a) K()).h;
        if (r1 == null) goto L10;
        r1.removeObserver("cmd_p0_widget_loaded", this);
    L10:
        Disposable r2 = this.t;
        if (r2 == null) goto L13;
        r2.dispose();
    L13:
        this.t = null;
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris, com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris
    public final View G(k r2) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return super.G(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final ConstraintLayout b0(k r3) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        if (p.e(((d90.a) K()).h) == false) goto L6;
        int r0 = 2131565314;
    L17:
        ConstraintLayout r4 = r3.b(r0);
        if (r4 == null) goto L22;
        return r4;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    L6:
        if (p.f(((d90.a) K()).h) == false) goto L8;
        r0 = 2131566998;
        goto L17
    L8:
        DataCenter r1 = ((d90.a) K()).h;
        p.a.getClass();
        if (p.d(r1) == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        r0 = 2131565313;
        goto L17
    L16:
        r0 = 2131565312;
        goto L17
    L11:
        if (p.a(r1) != 3) goto L13;
        r2 = true;
        goto L14
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final void g0(KVData r4) {
        if (r4 == null) goto L4;
        String r0 = r4.getKey();
    L5:
        if (r0 == null) goto L46;
        int r1 = r0.hashCode();
        if (r1 == (-1575056762)) goto L27;
        if (r1 == 309908432) goto L13;
        return;
    L13:
        if (r0.equals("data_media_introduction_showing") == false) goto L38;
        Boolean r2 = Boolean.FALSE;
        Boolean r5 = (Boolean) r4.getData(r2);
        if (r5 == null) goto L19;
        r2 = r5;
    L19:
        if (r2.booleanValue() == false) goto L23;
        ViewGroup r6 = Z();
        if (r6 == null) goto L39;
        r6.setImportantForAccessibility(4);
        return;
    L39:
        return;
    L23:
        ViewGroup r7 = Z();
        if (r7 == null) goto L41;
        r7.setImportantForAccessibility(0);
        return;
    L41:
        return;
    L38:
        return;
    L27:
        if (r0.equals("cmd_p0_widget_loaded") == true) goto L29;
        return;
    L29:
        if (FirstCompShowConfig.INSTANCE.isDelayClose() == false) goto L44;
        Boolean r3 = Boolean.FALSE;
        Boolean r8 = (Boolean) r4.getData(r3);
        if (r8 == null) goto L35;
        r3 = r8;
    L35:
        if (r3.booleanValue() == false) goto L45;
        UtilityKotlinExtentionsKt.w(Z());
        return;
    L45:
        return;
    L44:
        return;
    L46:
        return;
    L4:
        r0 = null;
        goto L5
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.BaseComponentsTetris
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        g0((KVData) r1);
    }

    @Override // o70.a
    public void onEvent(o70.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if ((r5 instanceof bh1.b) == false) goto L8;
        int r6 = ((bh1.b) r5).a;
        ViewGroup r0 = Z();
        if (r0 == null) goto L19;
        r0.setTranslationY(r6);
        return;
    L19:
        return;
    L8:
        if ((r5 instanceof bh1.a) == false) goto L21;
        bh1.a r7 = (bh1.a) r5;
        boolean r1 = r7.a;
        boolean r8 = r7.b;
        if (r1 == false) goto L12;
        int r2 = 4;
    L13:
        ALogger.i(this.s, "setAllViewsVisibility " + r2);
        if (r8 == true) goto L22;
        ViewGroup r9 = Z();
        if (r9 == null) goto L23;
        r9.setVisibility(r2);
        return;
    L23:
        return;
    L22:
        return;
    L12:
        r2 = 0;
        goto L13
    }
}
