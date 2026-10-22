package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.awemeplay.model.VideoTab;
import com.bytedance.android.live.liveinteract.awemeplay.viewmodel.LiveVideoCommentSelectAwemePanelViewModel;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import gd0.q;
import gd0.r;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/awemeplay/view/LiveVideoCommentSelectAwemePanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lgd0/q;", "Landroid/view/View$OnClickListener;", "", "getCurrentTabType", "Lgd0/r;", "callback", "", "setCallback", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveVideoCommentSelectAwemePanelView extends ConstraintLayout implements q, View.OnClickListener {
    public static final /* synthetic */ int w = 0;
    public LiveVideoCommentSelectAwemePanelViewModel a;
    public List<VideoTab> b;
    public TabLayout c;
    public TabLayout d;
    public TextView e;
    public ViewPager f;
    public View g;
    public View h;
    public TextView i;
    public LiveDoubleColorBallAnimationView j;
    public ImageView k;
    public Fragment l;
    public r m;
    public LinearLayout n;
    public LinearLayout o;
    public View p;
    public final CompositeDisposable q;
    public x0 r;
    public boolean s;
    public Integer t;
    public final boolean u;
    public final boolean v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveVideoCommentSelectAwemePanelView a;

        public b(LiveVideoCommentSelectAwemePanelView r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            k42.d r2 = (k42.d) r1;
            r r3 = this.a.m;
            if (r3 == null) goto L6;
            r3.c();
            return;
        }
    }

    static {
    }

    private final int getCurrentTabType() {
        List<VideoTab> r0 = this.b;
        if (r0 == null) goto L16;
        ViewPager r2 = this.f;
        if (r2 == null) goto L7;
        int r3 = r2.getCurrentItem();
    L8:
        if (r3 >= 0) goto L10;
    L12:
        Integer r1 = 0;
    L13:
        if (r1 != null) goto L15;
        return 0;
    L15:
        return r1.intValue();
    L10:
        if (r3 >= r0.size()) goto L12;
        r1 = ((VideoTab) ListProtector.get(r0, r3)).getType();
        goto L13
    L7:
        r3 = 0;
        goto L8
    L16:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        Disposable r0 = xs2.b.a().b(k42.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        this.q.add(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        this.q.dispose();
    }

    public static final /* synthetic */ int R5(LiveVideoCommentSelectAwemePanelView r0) {
        return r0.getCurrentTabType();
    }

    public static void T5(String r5) {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L8;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L8;
        String r2 = r1.getOwnerUserIdString();
        if (r2 == null) goto L8;
    L9:
        m r3 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r3 == null) goto L14;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L14;
        long r6 = r4.getRoomId();
    L15:
        Map<Integer, String> r7 = td0.b.a;
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r5, "action");
        LinkedHashMap r8 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r8);
        r8.put("anchor_id", r2);
        r8.put("room_id", String.valueOf(r6));
        td0.b.b(r8);
        TalkRoomLogUtils.B0(r8, null, null, 6);
        r8.put("action_type", r5);
        j0.l().sendLog("livesdk_video_comment_search_entry", r8, new Object[0]);
        return;
    L14:
        r6 = 0;
    L8:
        r2 = "";
        goto L9
    }

    public final void S5(int r4) {
        List<VideoTab> r0 = this.b;
        if (r0 == null) goto L21;
        boolean r2 = true;
        if ((!r0.isEmpty()) == false) goto L10;
        if (r4 < 0) goto L10;
        if (r4 >= r0.size()) goto L10;
    L11:
        if (r2 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L22;
        LiveVideoCommentSelectAwemePanelViewModel r1 = this.a;
        if (r1 == null) goto L23;
        MutableLiveData<VideoTab> r3 = r1.getSelectPageTab();
        if (r3 == null) goto L24;
        r3.setValue(ListProtector.get(r0, r4));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L10:
        r2 = false;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        sd0.a r0 = null;
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.getId());
    L6:
        if (r5 != null) goto L9;
    L13:
        if (r5 == null) goto L30;
        if (r5.intValue() != 2131387926) goto L30;
        LiveVideoCommentSelectAwemePanelViewModel r6 = this.a;
        if (r6 == null) goto L22;
        MutableLiveData<sd0.a> r7 = r6.getSelectedAwemeVideo();
        if (r7 == null) goto L22;
        r0 = (sd0.a) r7.getValue();
    L22:
        if (r0 == null) goto L26;
        LiveVideoCommentSelectAwemePanelViewModel r8 = this.a;
        if (r8 == null) goto L49;
        r8.doAction(new ud0.c.b(r0, getCurrentTabType()));
        return;
    L49:
        return;
    L26:
        r r9 = this.m;
        if (r9 == null) goto L51;
        r9.d();
        return;
    L51:
        return;
    L30:
        if (r5 != null) goto L33;
    L38:
        if (r5 != null) goto L41;
        return;
    L41:
        if (r5.intValue() != 2131385632) goto L54;
        r r10 = this.m;
        if (r10 == null) goto L45;
        r10.b();
    L45:
        T5("click");
        return;
    L54:
        return;
    L33:
        if (r5.intValue() != 2131385633) goto L38;
        r r11 = this.m;
        if (r11 == null) goto L37;
        r11.b();
    L37:
        T5("click");
        return;
    L9:
        if (r5.intValue() != 2131389878) goto L13;
        LiveVideoCommentSelectAwemePanelViewModel r12 = this.a;
        if (r12 == null) goto L47;
        r12.doAction(ud0.c.a.a);
        return;
    L47:
        return;
    L5:
        r5 = null;
        goto L6
    }

    @Override // gd0.q
    public void setCallback(r r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.m = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveVideoCommentSelectAwemePanelView(Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, null);
        this.v = r7;
        this.q = new CompositeDisposable();
        boolean r1 = true;
        this.u = true;
        LayoutInflater.from(r6).inflate(2131565202, this);
        setBackgroundResource(2131109391);
        if (r7 == false) goto L5;
    L8:
        this.u = r1;
        this.p = findViewById(2131389119);
        if (r7 == false) goto L14;
        this.c = findViewById(2131389881);
        this.d = findViewById(2131389880);
        View r3 = this.p;
        if (r3 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r3);
    L13:
        this.n = (LinearLayout) findViewById(2131385633);
        this.o = (LinearLayout) findViewById(2131385632);
    L15:
        TabLayout r8 = this.d;
        if (r8 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r8);
    L18:
        LinearLayout r9 = this.o;
        if (r9 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r9);
    L21:
        TabLayout r10 = this.c;
        if (r10 == null) goto L24;
        UtilityKotlinExtentionsKt.w(r10);
    L24:
        LinearLayout r11 = this.n;
        if (r11 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r11);
    L27:
        ViewPager r12 = findViewById(2131389882);
        this.f = r12;
        if (r12 == null) goto L30;
        r12.setOffscreenPageLimit(4);
    L30:
        this.g = findViewById(2131389877);
        this.j = findViewById(2131389876);
        this.h = findViewById(2131389879);
        this.i = (TextView) findViewById(2131389878);
        this.k = (ImageView) findViewById(2131387926);
        this.e = (TextView) findViewById(2131389233);
        TextView r13 = this.i;
        if (r13 == null) goto L33;
        r13.setOnClickListener(this);
    L33:
        ViewPager r14 = this.f;
        if (r14 == null) goto L36;
        r14.addOnPageChangeListener(new LiveVideoCommentSelectAwemePanelView$initView$1(this));
    L36:
        if (r7 == false) goto L43;
        ImageView r15 = this.k;
        if (r15 == null) goto L40;
        UtilityKotlinExtentionsKt.t(r15);
    L40:
        ImageView r16 = this.k;
        if (r16 == null) goto L54;
        r16.setOnClickListener(null);
        return;
    L54:
        return;
    L43:
        if (r1 == false) goto L50;
        ImageView r17 = this.k;
        if (r17 == null) goto L47;
        r17.setBackgroundResource(2131253233);
    L47:
        ImageView r18 = this.k;
        if (r18 == null) goto L56;
        r18.setOnClickListener(new c(this));
        return;
    L56:
        return;
    L50:
        ImageView r19 = this.k;
        if (r19 == null) goto L58;
        r19.setOnClickListener(this);
        return;
    L58:
        return;
    L14:
        this.c = findViewById(2131389880);
        this.d = findViewById(2131389881);
        this.n = (LinearLayout) findViewById(2131385632);
        this.o = (LinearLayout) findViewById(2131385633);
        goto L15
    L5:
        if (((Boolean) vm2.d.s6.getValue(null, vm2.d.a[380(0x17c, float:5.32E-43)])).booleanValue() == true) goto L8;
        r1 = false;
        goto L8
    }
}
