package com.bytedance.android.livesdk.chatroom.vs.video;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.tetris.widgets.h;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.ReplayVideoPlayerView;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.videoshop.context.VideoContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import jm1.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nm1.l;
import pm1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/MultiVideoFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/livesdk/chatroom/vs/video/b;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiVideoFragment extends BaseFragment implements b {
    public static final /* synthetic */ int z = 0;
    public PaidPrivilegeItem d;
    public RecyclableWidgetManager e;
    public Map<Widget, Integer> f;
    public Map<Widget, Integer> g;
    public View h;
    public LinearLayout i;
    public FrameLayout j;
    public FrameLayout k;
    public ConstraintLayout l;
    public View m;
    public View n;
    public View o;
    public View p;
    public DataCenter q;
    public boolean r;
    public int s;
    public final int t;
    public final int u;
    public final Lazy v;
    public final Lazy w;
    public g x;
    public final VideoPlayerWidget y;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        ViewGroup.LayoutParams r4 = null;
        if (this.r == false) goto L19;
        ConstraintLayout r0 = this.l;
        if (r0 == null) goto L13;
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(36.0f)));
        a1.j(r0, 80);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        r4 = r1;
    L10:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L13;
        r5.bottomMargin = s1.f(46.0f);
    L13:
        FrameLayout r2 = this.k;
        if (r2 == null) goto L16;
        r2.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(90.0f)));
        a1.j(r2, 80);
    L16:
        View r3 = this.o;
        if (r3 == null) goto L59;
        UtilityKotlinExtentionsKt.t(r3);
    L59:
        ObjectAnimator r6 = (ObjectAnimator) this.v.getValue();
        if (r6 == null) goto L62;
        r6.cancel();
    L62:
        ObjectAnimator r7 = (ObjectAnimator) this.w.getValue();
        if (r7 == null) goto L66;
        r7.start();
        return;
    L66:
        return;
    L19:
        DataCenter r8 = this.q;
        if (r8 != null) goto L22;
    L44:
        ConstraintLayout r9 = this.l;
        if (r9 == null) goto L53;
        r9.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(36.0f)));
        a1.j(r9, 81);
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        r4 = r10;
    L50:
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r4;
        if (r11 == null) goto L53;
        r11.bottomMargin = s1.f(12.0f);
    L53:
        FrameLayout r12 = this.k;
        if (r12 == null) goto L56;
        r12.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(90.0f)));
        a1.j(r12, 81);
    L56:
        View r13 = this.o;
        if (r13 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r13);
        goto L59
    L22:
        if (z.m(r8, true) != true) goto L44;
        ConstraintLayout r14 = this.l;
        if (r14 == null) goto L32;
        r14.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(36.0f)));
        a1.j(r14, 80);
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r15 = null;
    L29:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r15;
        if (r16 == null) goto L32;
        r16.bottomMargin = s1.f(12.0f);
    L32:
        FrameLayout r17 = this.k;
        if (r17 == null) goto L41;
        r17.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(90.0f)));
        a1.j(r17, 17);
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        r4 = r18;
    L38:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r4;
        if (r19 == null) goto L41;
        r19.topMargin = (this.s - s1.f(90.0f)) / 2;
    L41:
        View r20 = this.o;
        if (r20 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r20);
        goto L59
    }

    public final void T90() {
        DataCenter r0 = this.q;
        ViewGroup.LayoutParams r2 = null;
        if (r0 != null) goto L5;
    L20:
        LinearLayout r1 = this.i;
        if (r1 == null) goto L29;
        r1.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(24.0f)));
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r2 = r3;
    L26:
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r2;
        if (r4 == null) goto L29;
        r4.topMargin = s1.f(44.0f);
        r1.setPadding(s1.f(16.0f), 0, s1.f(50.0f), 0);
    L29:
        FrameLayout r5 = this.j;
        if (r5 == null) goto L35;
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(90.0f)));
        return;
    L35:
        return;
    L5:
        if (z.m(r0, true) == true) goto L20;
        LinearLayout r6 = this.i;
        if (r6 == null) goto L17;
        r6.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(24.0f)));
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        r2 = r7;
    L13:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r2;
        if (r8 == null) goto L16;
        r8.topMargin = s1.f(10.0f);
    L16:
        r6.setPadding(s1.f(10.0f), 0, s1.f(10.0f), 0);
    L17:
        FrameLayout r9 = this.j;
        if (r9 == null) goto L33;
        r9.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(90.0f)));
        a1.j(r9, 49);
        return;
    }

    public final int U90() {
        DataCenter r0 = this.q;
        if (r0 == null) goto L9;
        if (z.m(r0, true) == true) goto L9;
        return RangesKt.coerceAtMost((this.t * 16) / 9, this.u);
    L9:
        return this.t;
    }

    public final void V90() {
        Iterator<Map.Entry<Widget, Integer>> r0 = this.f.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Widget, Integer> r1 = r0.next();
        RecyclableWidgetManager r2 = this.e;
        if (r2 == null) goto L4;
        r2.unload(r1.getKey());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final List<View> vf() {
        ArrayList r0 = new ArrayList();
        View r1 = this.h;
        if (r1 == null) goto L7;
        View r2 = r1.findViewById(2131392345);
        if (r2 == null) goto L7;
        r0.add(r2);
    L7:
        View r3 = this.h;
        if (r3 == null) goto L12;
        View r4 = r3.findViewById(2131383296);
        if (r4 == null) goto L12;
        r0.add(r4);
    L12:
        View r5 = this.h;
        if (r5 == null) goto L17;
        View r6 = r5.findViewById(2131371691);
        if (r6 == null) goto L17;
        r0.add(r6);
    L17:
        View r7 = this.h;
        if (r7 == null) goto L22;
        View r8 = r7.findViewById(2131392259);
        if (r8 == null) goto L22;
        r0.add(r8);
    L22:
        View r9 = this.h;
        if (r9 == null) goto L27;
        View r10 = r9.findViewById(2131392403);
        if (r10 == null) goto L27;
        r0.add(r10);
    L27:
        LinearLayout r11 = this.i;
        if (r11 == null) goto L30;
        r0.add(r11);
    L30:
        return r0;
    }

    public MultiVideoFragment() {
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.t = x1.h();
        this.u = x1.g();
        this.v = LazyKt.lazy(new MultiVideoFragment$hideAnimator$2(this));
        this.w = LazyKt.lazy(new MultiVideoFragment$showAnimator$2(this));
        l r0 = f.j();
        if (r0 == null) goto L5;
        ReplayVideoPlayerView r1 = r0.c();
    L6:
        this.x = r1;
        this.y = new VideoPlayerWidget(r1, this);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void W90() {
        V90();
        Iterator<Map.Entry<Widget, Integer>> r0 = this.f.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Map.Entry<Widget, Integer> r1 = r0.next();
        Widget r2 = r1.getKey();
        Integer r3 = r1.getValue();
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
        RecyclableWidgetManager r5 = this.e;
        if (r5 == null) goto L10;
        WidgetManager r6 = r5.load(r4, r2);
    L11:
        if (r6 != null) goto L4;
    L10:
        r6 = null;
    L12:
        RecyclableWidgetManager r7 = this.e;
        if (r7 == null) goto L4;
        r7.load(r2);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final SharedPreferences oS() {
        return jc1.a.b().getSharedPreferences("simple_video_progress_history", 0);
    }

    public final void onDestroy() {
        super.onDestroy();
        V90();
        Iterator<Map.Entry<Widget, Integer>> r0 = this.g.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry<Widget, Integer> r1 = r0.next();
        RecyclableWidgetManager r2 = this.e;
        if (r2 == null) goto L4;
        r2.unload(r1.getKey());
        goto L4
    L8:
        g r3 = this.x;
        if (r3 == null) goto L11;
        r3.release();
    L11:
        this.x = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final void mn(int r3) {
        V90();
        Window r0 = null;
        if (r3 != 0) goto L8;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        r0 = r1.getWindow();
    L7:
        t8.d(r0);
    L12:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L16;
        r2.setRequestedOrientation(r3);
        return;
    L16:
        return;
    L8:
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L11;
        r0 = r4.getWindow();
    L11:
        t8.b(r0);
        t8.e(getActivity());
        goto L12
    }

    public final void onConfigurationChanged(Configuration r6) {
        Intrinsics.checkNotNullParameter(r6, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r6);
        boolean r1 = true;
        if (r6.orientation != 1) goto L7;
        VideoContext r0 = VideoContext.n0(getContext());
        if (r0 == null) goto L10;
        r0.l0();
    L10:
        DataCenter r2 = this.q;
        if (r2 != null) goto L13;
    L17:
        g r3 = this.x;
        if (r3 != null) goto L20;
    L24:
        VideoPlayerWidget r4 = this.y;
        r4.Aq(r4.g, r4.h);
        ((ObjectAnimator) this.v.getValue()).start();
        T90();
        W90();
        ILinkServiceExternal r5 = k.f(ILinkServiceExternal.class);
        if (r5 != null) goto L27;
        return;
    L27:
        if (r6.orientation == 1) goto L30;
        r1 = false;
    L30:
        r5.updatePortrait(r1);
        return;
    L20:
        if (r3.isPlaying() != true) goto L24;
        DataCenter r7 = this.q;
        if (r7 == null) goto L24;
        r7.put("video_start_play_ts", Long.valueOf(System.currentTimeMillis()));
        goto L24
    L13:
        if (r6.orientation != 1) goto L15;
        boolean r8 = true;
    L16:
        r2.put("data_is_portrait", Boolean.valueOf(r8));
        goto L17
    L15:
        r8 = false;
        goto L16
    L7:
        VideoContext r9 = VideoContext.n0(getContext());
        if (r9 == null) goto L10;
        r9.k0();
        goto L10
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        PaidPrivilegeItem r5 = this.d;
        if (r5 != null) goto L5;
    L6:
        SharedPreferences.Editor r6 = oS().edit();
        if (r6 == null) goto L12;
        SharedPreferences.Editor r7 = r6.clear();
        if (r7 == null) goto L12;
        r7.apply();
    L12:
        if (this.q != null) goto L14;
        this.q = DataCenter.create(ViewModelProviders.of(this), this);
    L14:
        DataCenter r8 = this.q;
        if (r8 == null) goto L17;
        r8.put("data_is_portrait", Boolean.valueOf(!e5.l()));
    L17:
        DataCenter r9 = this.q;
        if (r9 == null) goto L20;
        r9.put("paid_privilege_item", this.d);
    L20:
        ILinkServiceExternal r10 = k.f(ILinkServiceExternal.class);
        if (r10 == null) goto L24;
        r10.updatePortrait(true ^ e5.l());
        return;
    L24:
        return;
    L5:
        if (r5.getNeedHistoryStart() == true) goto L12;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final void Aj(int r2, int r3) {
        this.s = r3;
        if (r2 > r3) goto L5;
        boolean r4 = true;
    L7:
        if (this.r == r4) goto L22;
        this.r = r4;
        if (r4 == false) goto L15;
        DataCenter r5 = this.q;
        if (r5 == null) goto L15;
        if (z.m(r5, true) == true) goto L15;
        mn(1);
    L15:
        ObjectAnimator r6 = (ObjectAnimator) this.w.getValue();
        if (r6 == null) goto L18;
        r6.cancel();
    L18:
        ObjectAnimator r7 = (ObjectAnimator) this.v.getValue();
        if (r7 == null) goto L21;
        r7.start();
    L21:
        T90();
    L27:
        this.r = r4;
        return;
    L22:
        FrameLayout r8 = this.k;
        if (r8 == null) goto L27;
        if (r8.getVisibility() != 8) goto L27;
        S90();
        goto L27
    L5:
        r4 = false;
        goto L7
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        View r9 = r6.inflate(2131567019, r7, false);
        this.h = r9;
        if (r9 == null) goto L5;
        FrameLayout r10 = (FrameLayout) r9.findViewById(2131389112);
    L6:
        this.j = r10;
        if (r9 == null) goto L9;
        LinearLayout r11 = (LinearLayout) r9.findViewById(2131389120);
    L10:
        this.i = r11;
        if (r9 == null) goto L13;
        FrameLayout r12 = (FrameLayout) r9.findViewById(2131392256);
    L14:
        this.k = r12;
        if (r9 == null) goto L17;
        ConstraintLayout r13 = (ConstraintLayout) r9.findViewById(2131392258);
    L18:
        this.l = r13;
        if (r9 == null) goto L21;
        View r1 = r9.findViewById(2131380467);
    L22:
        this.m = r1;
        if (r9 == null) goto L25;
        View r2 = r9.findViewById(2131383296);
    L26:
        this.n = r2;
        if (r9 == null) goto L29;
        View r3 = r9.findViewById(2131371866);
    L30:
        this.p = r3;
        if (r9 == null) goto L33;
        View r14 = r9.findViewById(2131371690);
    L34:
        this.o = r14;
        View r15 = this.p;
        if (r15 == null) goto L37;
        r15.setOnClickListener(new c(this));
    L37:
        RecyclableWidgetManager r16 = RecyclableWidgetManager.ga0(this, this.h);
        this.e = r16;
        r16.d = h.c();
        RecyclableWidgetManager r17 = this.e;
        if (r17 == null) goto L40;
        r17.setDataCenter(this.q);
    L40:
        this.f = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(new VideoTitleWidget(), 2131380469), TuplesKt.to(new VideoProgressAreaWidget(), 2131383296), TuplesKt.to(new VideoPlayControlWidget(), 2131392345), TuplesKt.to(new EnterFullScreenWidget(this), 2131371690), TuplesKt.to(new VideoPlayControlVisibilityWidget(this), 2131382430)});
        Map<Widget, Integer> r18 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(this.y, 2131380467)});
        this.g = r18;
        Iterator<Map.Entry<Widget, Integer>> r19 = r18.entrySet().iterator();
    L42:
        if (r19.hasNext() == false) goto L53;
        Map.Entry<Widget, Integer> r20 = r19.next();
        Widget r0 = r20.getKey();
        Integer r21 = r20.getValue();
        if (r21 == null) goto L50;
        int r22 = r21.intValue();
        RecyclableWidgetManager r4 = this.e;
        if (r4 == null) goto L48;
        WidgetManager r23 = r4.load(r22, r0);
    L49:
        if (r23 != null) goto L42;
    L48:
        r23 = null;
    L50:
        RecyclableWidgetManager r24 = this.e;
        if (r24 == null) goto L42;
        r24.load(r0);
        goto L42
    L53:
        W90();
        return this.h;
    L33:
        r14 = null;
        goto L34
    L29:
        r3 = null;
        goto L30
    L25:
        r2 = null;
        goto L26
    L21:
        r1 = null;
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    L9:
        r11 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }
}
