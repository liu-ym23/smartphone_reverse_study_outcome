package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.comment.newinput.framework.InputSectionType;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioComposePageViewPager;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordBtnView;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.AudioRecordViewV3;
import com.bytedance.android.livesdk.r3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AudioComposeSectionProvider implements com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j, z62.a> {
    public static final b v = null;
    public final InputSectionType a;
    public com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g b;
    public final g c;
    public View d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public LinearLayout h;
    public final com.bytedance.android.livesdk.sharedpref.e<Integer> i;
    public AudioSectionController j;
    public Audio2TextSectionController k;
    public AudioComposePageViewPager l;
    public final int m;
    public final float n;
    public final float o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public int u;

    public static final class a extends PagerAdapter {
        public final List<View> a;

        public final int getCount() {
            return this.a.size();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends View> r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            this.a = r2;
        }

        public final Object instantiateItem(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "container");
            View r5 = (View) ListProtector.get(this.a, r4);
            r3.addView(r5, new ViewGroup.LayoutParams(-1, -1));
            return r5;
        }

        public final boolean isViewFromObject(View r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "object");
            return Intrinsics.areEqual(r2, r3);
        }
    }

    public static final class b implements z62.a {
        public b() {
        }

        @Override // z62.a
        public final int f() {
            return 0;
        }

        @Override // z62.a
        public final boolean m() {
            return false;
        }
    }

    public static final class c {
    }

    public static final class d implements com.bytedance.android.livesdk.interactivity.comment.audio.c.b {
        public final /* synthetic */ AudioComposeSectionProvider a;

        public d(AudioComposeSectionProvider r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
            Audio2TextSectionController r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
        public final void c(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            AudioSectionController r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.c(r2);
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.comment.audio.c.b
        public final void f(String r2, long r3) {
            AudioSectionController r0 = this.a.j;
            if (r0 == null) goto L6;
            r0.f(r2, r3);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ AudioComposeSectionProvider a;

        public e(AudioComposeSectionProvider r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            AudioComposePageViewPager r3 = this.a.l;
            if (r3 == null) goto L6;
            r3.setCurrentItem(0, false);
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ AudioComposeSectionProvider a;

        public f(AudioComposeSectionProvider r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            AudioComposePageViewPager r4 = this.a.l;
            if (r4 == null) goto L6;
            r4.setCurrentItem(1, false);
            return;
        }
    }

    public static final class g implements z62.a {
        public final /* synthetic */ AudioComposeSectionProvider a;

        @Override // z62.a
        public final int f() {
            AudioComposeSectionProvider r0 = this.a;
            int r1 = r0.u;
            if (r1 == (-1)) goto L5;
            return r1;
        L5:
            return ((Number) r0.i.getValue()).intValue();
        }

        @Override // z62.a
        public final boolean m() {
            Audio2TextSectionController r0 = this.a.k;
            return false;
        }

        public g(AudioComposeSectionProvider r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final com.bytedance.android.livesdk.interactivity.comment.newinput.framework.j c() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void f() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void g(boolean r1) {
    }

    static {
        v = new b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void a() {
        if (((fc2.e) ec2.f0.a.getValue()).a() == false) goto L12;
        f72.a.b("on Audio2text Section Switch off");
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r0 = this.b;
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r1 = r0.c;
        if (r1 == null) goto L14;
        r1.n.set(0);
        mf2.a r2 = r1.c.getAndSet(null);
        if (r2 == null) goto L15;
        r2.b();
        com.bytedance.android.livesdk.interactivity.comment.audio.c.b(r2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void d() {
        AudioSectionController r0 = this.j;
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r2 = r0.j;
        if (r2 == null) goto L7;
        r2.clear();
    L7:
        MainThreadPostUtils.d(r0.g());
        AudioRecordViewV3 r3 = r0.e;
        if (r3 == null) goto L10;
        r3.b();
    L10:
        AudioComposePageViewPager r1 = r0.n;
        if (r1 == null) goto L13;
        r1.setCanScroll(true);
    L13:
        Audio2TextSectionController r4 = this.k;
        if (r4 == null) goto L19;
        MainThreadPostUtils.d((Runnable) r4.g.getValue());
        MainThreadPostUtils.d((Runnable) r4.h.getValue());
        AudioComposePageViewPager r5 = r4.i;
        if (r5 == null) goto L20;
        r5.setCanScroll(true);
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final void e() {
        View r0 = this.d;
        if (r0 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 != null) goto L7;
    L9:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r2 = this.b;
        if (r2 == null) goto L12;
        int r3 = r2.W();
    L13:
        com.bytedance.android.live.core.utils.a1.k(r0, r3);
        goto L14
    L12:
        r3 = 0;
        goto L13
    L7:
        if (r1.W() != 0) goto L9;
        r3 = InputPanelSectionContainer.m;
    L14:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r4 = this.b;
        if (r4 == null) goto L22;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r5 = r4.c;
        if (r5 == null) goto L23;
        d r6 = new d(this);
        Intrinsics.checkNotNullParameter(r6, "listener");
        r5.o = r6;
        if (((fc2.e) ec2.f0.a.getValue()).a() == false) goto L24;
        f72.a.b("on Audio2text Section Switch on");
        r5.c();
        return;
    L24:
        return;
    L23:
        return;
    }

    public AudioComposeSectionProvider() {
        this.a = InputSectionType.AUDIO_COMPOSE;
        this.c = new g(this);
        this.i = l42.a.p;
        this.m = com.bytedance.android.live.core.utils.s1.j(2131168499);
        this.n = com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.j(2131168498));
        this.o = com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.j(2131168497));
        this.p = com.bytedance.android.live.core.utils.s1.h(2131107031);
        this.q = com.bytedance.android.live.core.utils.s1.h(2131106926);
        this.r = com.bytedance.android.live.core.utils.s1.y();
        this.s = 2131250266;
        this.t = 2131250265;
        this.u = -1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final InputSectionType b() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.newinput.framework.k
    public final View h(com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9) {
        Intrinsics.checkNotNullParameter(r9, "panelBridge");
        Activity r0 = r9.getActivity();
        if (r0 != null) goto L5;
        return null;
    L5:
        this.b = r9;
        View r2 = LayoutInflater.from(r0).inflate(2131567693, null);
        this.d = r2;
        if (r2 != null) goto L8;
        return null;
    L8:
        this.l = (AudioComposePageViewPager) r2.findViewById(2131363452);
        this.e = (LinearLayout) r2.findViewById(2131367728);
        this.f = (TextView) r2.findViewById(2131364646);
        this.g = (TextView) r2.findViewById(2131364645);
        this.h = (LinearLayout) r2.findViewById(2131363434);
        ArrayList r3 = new ArrayList();
        if (r9.e0() == false) goto L31;
        View r4 = LayoutInflater.from(r0).inflate(2131567694, null);
        AudioSectionController r5 = new AudioSectionController(r4, r9, this.l);
        com.bytedance.android.livesdk.interactivity.comment.audio.c r6 = r5.b.c;
        if (r6 != null) goto L13;
        com.bytedance.android.livesdk.interactivity.comment.audio.c r7 = new com.bytedance.android.livesdk.interactivity.comment.audio.c(r5.b.R());
        r5.j = r7;
        r5.b.c = r7;
    L14:
        r5.c = (AudioRecordBtnView) r5.a.findViewById(2131364997);
        r5.d = (TextView) r5.a.findViewById(2131388402);
        AudioRecordViewV3 r8 = (AudioRecordViewV3) r5.a.findViewById(2131363480);
        r5.e = r8;
        if (r8 == null) goto L17;
        r8.setFinishListener(r5.m);
    L17:
        AudioRecordBtnView r10 = r5.c;
        if (r10 == null) goto L20;
        r10.setListener(new com.bytedance.android.livesdk.interactivity.comment.newinput.provider.b(r5));
    L20:
        AudioRecordBtnView r11 = r5.c;
        if (r11 == null) goto L23;
        r11.setFocusable(true);
    L23:
        AudioRecordBtnView r13 = r5.c;
        if (r13 == null) goto L26;
        r13.setClickable(true);
    L26:
        AudioRecordBtnView r14 = r5.c;
        if (r14 == null) goto L29;
        r14.setLongClickable(true);
    L29:
        r3.c(r5.c, com.bytedance.android.live.core.utils.s1.B(2131914435), true);
        Unit r15 = Unit.INSTANCE;
        this.j = r5;
        r3.add(r4);
        goto L31
    L13:
        r5.j = r6;
    L31:
        if (r9.c0() == false) goto L33;
        View r1 = LayoutInflater.from(r0).inflate(2131567695, null);
        Audio2TextSectionController r16 = new Audio2TextSectionController(r1, r9, this.l);
        r16.g();
        Unit r17 = Unit.INSTANCE;
        this.k = r16;
        r3.add(r1);
    L33:
        a r18 = new a(r3);
        AudioComposePageViewPager r19 = this.l;
        if (r19 == null) goto L37;
        r19.setAdapter(r18);
    L37:
        if (r3.size() <= 1) goto L51;
        LinearLayout r20 = this.e;
        if (r20 == null) goto L41;
        UtilityKotlinExtentionsKt.w(r20);
    L41:
        AudioComposePageViewPager r21 = this.l;
        if (r21 == null) goto L44;
        r21.addOnPageChangeListener(new AudioComposeSectionProvider$provideSection$3(this));
    L44:
        TextView r23 = this.f;
        if (r23 == null) goto L47;
        r23.setOnClickListener(new e(this));
    L47:
        TextView r24 = this.g;
        if (r24 == null) goto L50;
        r24.setOnClickListener(new f(this));
    L50:
        i(((Number) this.i.getValue()).intValue(), true);
    L58:
        int r25 = InputPanelSectionContainer.m;
        if (r9.W() == 0) goto L61;
        r25 = r9.W();
    L61:
        View r26 = this.d;
        if (r26 == null) goto L65;
        com.bytedance.android.live.core.utils.a1.k(r26, r25);
    L65:
        return this.d;
    L51:
        LinearLayout r27 = this.e;
        if (r27 == null) goto L55;
        UtilityKotlinExtentionsKt.t(r27);
    L55:
        if (r9.e0() == false) goto L57;
        this.u = 0;
        r9.F(this.s);
        goto L58
    L57:
        this.u = 1;
        r9.F(this.t);
        goto L58
    }

    public final void i(int r13, boolean r14) {
        this.u = r13;
        if (r13 != 0) goto L16;
        float r5 = (this.r / 2.0f) - (this.m / 2.0f);
        LinearLayout r3 = this.h;
        if (r3 == null) goto L7;
        com.bytedance.android.live.core.utils.a1.m(r3, (int) r5);
    L7:
        TextView r4 = this.f;
        if (r4 == null) goto L10;
        r4.setTextColor(this.q);
        r4.setTextSize(this.o);
        r3.d(r4, com.bytedance.android.live.core.utils.s1.B(2131914435), true, true);
    L10:
        TextView r0 = this.g;
        if (r0 == null) goto L13;
        r0.setTextColor(this.p);
        r0.setTextSize(this.n);
        r3.d(r0, com.bytedance.android.live.core.utils.s1.B(2131914436), false, true);
    L13:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r1 = this.b;
        if (r1 == null) goto L28;
        r1.F(this.s);
    L28:
        if (r14 == false) goto L33;
        AudioComposePageViewPager r15 = this.l;
        if (r15 == null) goto L34;
        r15.setCurrentItem(r13, false);
        return;
    L34:
        return;
    L33:
        return;
    L16:
        double r6 = ((double) (this.r / 2.0f)) - (((double) this.m) * 1.5d);
        LinearLayout r7 = this.h;
        if (r7 == null) goto L19;
        com.bytedance.android.live.core.utils.a1.m(r7, (int) r6);
    L19:
        TextView r8 = this.g;
        if (r8 == null) goto L22;
        r8.setTextColor(this.q);
        r8.setTextSize(this.o);
        r3.d(r8, com.bytedance.android.live.core.utils.s1.B(2131914436), true, true);
    L22:
        TextView r2 = this.f;
        if (r2 == null) goto L25;
        r2.setTextColor(this.p);
        r2.setTextSize(this.n);
        r3.d(r2, com.bytedance.android.live.core.utils.s1.B(2131914435), false, true);
    L25:
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.g r9 = this.b;
        if (r9 == null) goto L28;
        r9.F(this.t);
        goto L28
    }
}
