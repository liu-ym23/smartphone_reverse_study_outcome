package com.bytedance.android.live.liveinteract.revenue.fight.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.utils.r1;
import com.bytedance.android.livesdk.chatroom.model.interact.v0;
import com.bytedance.android.livesdk.chatroom.view.NoPaddingTextView;
import com.bytedance.android.livesdk.model.h0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0015\u0004B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightPKProgressLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightProgressBar$a;", "", "a", "Z", "getMIsAnchor", "()Z", "setMIsAnchor", "(Z)V", "mIsAnchor", "", "getTotalWidth", "()I", "totalWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "AnimationState", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamFightPKProgressLayout extends FrameLayout implements TeamFightProgressBar.a {
    public static final /* synthetic */ int F = 0;
    public final HSImageView A;
    public final HSImageView B;
    public Disposable C;
    public Disposable D;
    public com.bytedance.android.live.liveinteract.multiscene.a E;
    public boolean a;
    public int b;
    public final int c;
    public int d;
    public int e;
    public AnimationState f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final h0 j;
    public final CompositeDisposable k;
    public String l;
    public final NoPaddingTextView m;
    public final NoPaddingTextView n;
    public final HSImageView o;
    public final NoPaddingTextView p;
    public final NoPaddingTextView q;
    public final HSImageView r;
    public final NoPaddingTextView s;
    public final NoPaddingTextView t;
    public final TextView u;
    public final TextView v;
    public final ViewGroup w;
    public final ViewGroup x;
    public final TeamFightProgressBar y;
    public final CompactTailView z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/view/TeamFightPKProgressLayout$AnimationState;", "", "MIDDLE", "WEAK", "STRONG", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum AnimationState extends Enum<AnimationState> {
        public static final AnimationState MIDDLE = null;
        public static final AnimationState STRONG = null;
        public static final AnimationState WEAK = null;
        public static final /* synthetic */ AnimationState[] a = null;

        static {
            AnimationState r1 = new AnimationState("MIDDLE", 0);
            MIDDLE = r1;
            AnimationState r2 = new AnimationState("WEAK", 1);
            WEAK = r2;
            AnimationState r3 = new AnimationState("STRONG", 2);
            STRONG = r3;
            a = new AnimationState[]{r1, r2, r3};
        }

        public static AnimationState valueOf(String r1) {
            return (AnimationState) r27.a.a(AnimationState.class, r1);
        }

        public static AnimationState[] values() {
            return (AnimationState[]) a.clone();
        }

        public AnimationState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements Action {
        public final /* synthetic */ TeamFightPKProgressLayout a;

        public b(TeamFightPKProgressLayout r1) {
            this.a = r1;
        }

        public final void run() {
            UtilityKotlinExtentionsKt.t(this.a.u);
            this.a.y.b(0);
            com.bytedance.android.live.liveinteract.multiscene.a r0 = this.a.E;
            if (r0 == null) goto L11;
            j r1 = li0.d.i(r0);
            if (r1 == null) goto L12;
            TeamFightPKProgressLayout r2 = this.a;
            int r3 = (int) r1.getScore();
            String r4 = r1.getScoreFuzzy();
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            r2.h(r3, r4, r1.getBonusScore());
            return;
        L12:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TeamFightPKProgressLayout a;
        public final /* synthetic */ v0 b;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.multiscene.a c;

        public c(TeamFightPKProgressLayout r1, v0 r2, com.bytedance.android.live.liveinteract.multiscene.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            this.a.u.setText("X" + this.b.getCoefficient() + " | " + ((Long) r5) + 's');
            UtilityKotlinExtentionsKt.w(this.a.u);
            int r6 = (li0.d.h(this.a.w) + a1.f(this.a.w)) + a1.g(this.a.w);
            if (this.a.y.l == (s1.f(9.0f) + r6)) goto L13;
            this.a.y.b(r6 + s1.f(9.0f));
            com.bytedance.android.live.liveinteract.multiscene.a r7 = this.c;
            if (r7 == null) goto L14;
            j r8 = li0.d.i(r7);
            if (r8 == null) goto L15;
            TeamFightPKProgressLayout r0 = this.a;
            int r2 = (int) r8.getScore();
            String r1 = r8.getScoreFuzzy();
            if (r1 != null) goto L11;
            r1 = "";
        L11:
            r0.h(r2, r1, r8.getBonusScore());
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r2) {
            int r0 = TeamFightPKProgressLayout.F;
            ALogger.e("TeamFightPKProgressLayout", (Throwable) r2);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ TeamFightPKProgressLayout a;

        public e(TeamFightPKProgressLayout r1) {
            this.a = r1;
        }

        public final void run() {
            UtilityKotlinExtentionsKt.t(this.a.v);
            this.a.y.c(0);
            com.bytedance.android.live.liveinteract.multiscene.a r0 = this.a.E;
            if (r0 == null) goto L11;
            j r1 = li0.d.a(r0);
            if (r1 == null) goto L12;
            TeamFightPKProgressLayout r2 = this.a;
            int r3 = (int) r1.getScore();
            String r4 = r1.getScoreFuzzy();
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            r2.i(r3, r4, r1.getBonusScore());
            return;
        L12:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ TeamFightPKProgressLayout a;
        public final /* synthetic */ v0 b;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.multiscene.a c;

        public f(TeamFightPKProgressLayout r1, v0 r2, com.bytedance.android.live.liveinteract.multiscene.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            this.a.v.setText("X" + this.b.getCoefficient() + " | " + ((Long) r5) + 's');
            UtilityKotlinExtentionsKt.w(this.a.v);
            int r6 = (li0.d.h(this.a.x) + a1.f(this.a.x)) + a1.g(this.a.x);
            if (this.a.y.m == (s1.f(9.0f) + r6)) goto L13;
            this.a.y.c(r6 + s1.f(9.0f));
            com.bytedance.android.live.liveinteract.multiscene.a r7 = this.c;
            if (r7 == null) goto L14;
            j r8 = li0.d.a(r7);
            if (r8 == null) goto L15;
            TeamFightPKProgressLayout r0 = this.a;
            int r2 = (int) r8.getScore();
            String r1 = r8.getScoreFuzzy();
            if (r1 != null) goto L11;
            r1 = "";
        L11:
            r0.i(r2, r1, r8.getBonusScore());
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            int r0 = TeamFightPKProgressLayout.F;
            ALogger.e("TeamFightPKProgressLayout", (Throwable) r2);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightProgressBar.a
    public final void onProgressChange() {
    }

    public static boolean c() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.performance.a r1 = r0.getMultiLinkPerfAbilityManager(true);
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.a("multilink_base_degrade");
    L8:
        return true;
    }

    public final void b() {
        String r0 = this.l;
        if (r0 == null) goto L9;
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r2 = r1.getMultiLinkPerfAbilityManager(false);
        if (r2 == null) goto L9;
        r2.c("multilink_base_degrade", r0);
    L9:
        this.l = null;
    }

    public final void f() {
        this.A.setVisibility(0);
        this.B.setVisibility(8);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.g = false;
        this.f = AnimationState.MIDDLE;
        this.m.setVisibility(0);
        a1.m(this.m, s1.j(2131169160));
        this.m.setText("0");
        this.p.setVisibility(0);
        a1.n(this.p, s1.j(2131169160));
        this.p.setText("0");
        this.A.setVisibility(0);
        r1.a(this.A, this.j.c(), Boolean.valueOf(c()));
        TeamFightProgressBar r0 = this.y;
        r0.c = 0;
        r0.d = 0;
        r0.a = 0.5f;
        r0.p = true;
        r0.k = s1.f(30.0f);
        r0.invalidate();
        this.o.setVisibility(8);
        this.r.setVisibility(8);
        Disposable r1 = this.C;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        Disposable r2 = this.D;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        UtilityKotlinExtentionsKt.t(this.u);
        UtilityKotlinExtentionsKt.t(this.v);
        this.h = false;
        UtilityKotlinExtentionsKt.t(this.n);
        UtilityKotlinExtentionsKt.t(this.q);
        UtilityKotlinExtentionsKt.t(this.z);
        this.y.setEnlarge(false);
    }

    private final int getTotalWidth() {
        if (getWidth() <= 0) goto L6;
        return getWidth();
    L6:
        return s1.y();
    }

    public final boolean getMIsAnchor() {
        return this.a;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightProgressBar.a
    public final void a(float r6) {
        TeamFightProgressBar r0 = this.y;
        int r1 = r0.k;
        int r2 = r0.l;
        int r3 = r0.m;
        float r7 = (r6 * (getTotalWidth() - (r1 * 2))) + r1;
        float r4 = 0;
        if (r7 <= r4) goto L8;
        float r5 = r2;
        if (r7 >= r5) goto L8;
        r7 = r5;
    L8:
        if ((getTotalWidth() - r7) > r4) goto L10;
    L12:
        a1.m(this.B, (int) ((r7 - this.b) + s1.f(8.5f)));
        if (this.a == false) goto L15;
    L39:
        this.m.setVisibility(0);
        this.p.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        return;
    L15:
        if (this.g == false) goto L39;
        CharSequence r8 = this.s.getText();
        if (r8 != null) goto L19;
    L23:
        CharSequence r9 = this.t.getText();
        if (r9 == null) goto L39;
        if (r9.length() <= 0) goto L28;
        boolean r10 = true;
    L29:
        if (r10 != true) goto L39;
    L30:
        this.m.setVisibility(8);
        this.p.setVisibility(8);
        CharSequence r11 = this.s.getText();
        if (r11 != null) goto L33;
    L38:
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        return;
    L33:
        if (r11.length() <= 0) goto L35;
        boolean r12 = true;
    L36:
        if (r12 != true) goto L38;
        this.s.setVisibility(0);
        this.t.setVisibility(8);
        return;
    L35:
        r12 = false;
        goto L36
    L28:
        r10 = false;
        goto L29
    L19:
        if (r8.length() <= 0) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == true) goto L30;
    L21:
        r13 = false;
        goto L22
    L10:
        if ((getTotalWidth() - r7) >= r3) goto L12;
        r7 = getTotalWidth() - r3;
        goto L12
    }

    public final void e(boolean r3) {
        this.a = r3;
        String r4 = this.l;
        if (r4 != null) goto L10;
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L9;
        com.bytedance.android.live.liveinteract.plantform.performance.a r6 = r5.getMultiLinkPerfAbilityManager(true);
        if (r6 == null) goto L9;
        r4 = r6.b("multilink_base_degrade", new TeamFightPKProgressLayout$handlePerfInit$1(this));
    L9:
        r4 = null;
    L10:
        this.l = r4;
    }

    public final void setMIsAnchor(boolean r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [android.view.View, com.bytedance.android.live.liveinteract.revenue.fight.view.CompactTailView] */
    public TeamFightPKProgressLayout(Context r14, AttributeSet r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        super(r14, r15);
        this.b = s1.j(2131169158);
        this.c = s1.j(2131169162);
        this.f = AnimationState.MIDDLE;
        h0 r16 = (h0) vm2.d.u7.getValue(null, vm2.d.a[433(0x1b1, float:6.07E-43)]);
        this.j = r16;
        this.k = new CompositeDisposable();
        LayoutInflater.from(r14).inflate(2131567495, this);
        NoPaddingTextView r0 = findViewById(2131377814);
        this.m = r0;
        this.n = findViewById(2131377757);
        HSImageView r1 = findViewById(2131377766);
        this.o = r1;
        NoPaddingTextView r2 = findViewById(2131384632);
        this.p = r2;
        this.q = findViewById(2131384569);
        HSImageView r3 = findViewById(2131384574);
        this.r = r3;
        NoPaddingTextView r4 = findViewById(2131391349);
        this.s = r4;
        NoPaddingTextView r5 = findViewById(2131391350);
        this.t = r5;
        this.u = (TextView) findViewById(2131389810);
        this.v = (TextView) findViewById(2131389812);
        this.w = (ViewGroup) findViewById(2131377807);
        this.x = (ViewGroup) findViewById(2131384621);
        TeamFightProgressBar r6 = (TeamFightProgressBar) findViewById(2131382357);
        this.y = r6;
        ?? r7 = (CompactTailView) findViewById(2131393023);
        this.z = r7;
        HSImageView r8 = findViewById(2131380093);
        this.A = r8;
        this.B = findViewById(2131382358);
        HSImageView r9 = findViewById(2131377767);
        HSImageView r10 = findViewById(2131384576);
        a1.l(r0, s1.f(0.5f));
        a1.l(r2, s1.f(0.5f));
        r6.setOnProgressChangeListener(this);
        int r11 = s1.h(2131107686);
        int r12 = s1.h(2131107686);
        int r13 = s1.h(2131107687);
        int r17 = s1.h(2131107687);
        r6.g = r11;
        r6.h = r12;
        r6.i = r13;
        r6.j = r17;
        r8.setVisibility(0);
        r1.a(r8, r16.c(), Boolean.valueOf(c()));
        Typeface r18 = Typeface.createFromAsset(r14.getAssets(), "fonts/clarity_mono_bold.otf");
        r0.setTypeface(r18);
        r2.setTypeface(r18);
        r4.setTypeface(r18);
        r4.setVisibility(8);
        r5.setTypeface(r18);
        r5.setVisibility(8);
        r1.setVisibility(8);
        r3.setVisibility(8);
        a1.k(r7, TeamFightProgressBar.s);
        r7.setCircleRadius(24.0f);
    }

    public static Observable d(long r2, TimeUnit r4) {
        Intrinsics.checkNotNullParameter(r4, "unit");
        return Observable.interval(1, r4).map(new com.bytedance.android.live.liveinteract.revenue.fight.view.a(r2)).takeUntil(com.bytedance.android.live.liveinteract.revenue.fight.view.b.a).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(AndroidSchedulers.mainThread());
    }

    public final void j(com.bytedance.android.live.liveinteract.multiscene.a r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r26, "teamFightInfo");
        this.E = r26;
        j r4 = li0.d.i(r26);
        j r5 = li0.d.a(r26);
        Intrinsics.checkNotNullParameter(r26, "teamFightInfo");
        if (gh0.a.d() == true) goto L29;
        Intrinsics.checkNotNullParameter(r26, "$this$useRelativePkBar");
        if (r26.getPkBarStyle() != 2) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L29;
        String r6 = je0.d.b0();
        j r9 = li0.d.i(r26);
        if (r9 == null) goto L19;
        com.bytedance.android.live.liveinteract.multiscene.f.b r10 = r9.getContributors();
        if (r10 == null) goto L19;
        if (r10.contains(r6) != true) goto L19;
        if (r9.isScoreFuzzy() == true) goto L29;
    L19:
        j r11 = li0.d.a(r26);
        if (r11 == null) goto L28;
        com.bytedance.android.live.liveinteract.multiscene.f.b r12 = r11.getContributors();
        if (r12 == null) goto L28;
        if (r12.contains(r6) != true) goto L28;
        if (r11.isScoreFuzzy() == true) goto L29;
    L28:
        boolean r7 = true;
    L30:
        if (r7 == false) goto L80;
        j r13 = li0.d.i(r26);
        j r14 = li0.d.a(r26);
        if (r27 == false) goto L48;
        Long r15 = r26.getWinTeamId();
        long r16 = 2;
        if (r15 != null) goto L37;
    L43:
        if (r13 == null) goto L46;
        String r17 = r13.getScoreFuzzy();
        if (r17 == null) goto L46;
    L47:
        Pair r18 = TuplesKt.to(1, r17);
    L65:
        int r19 = ((Number) r18.component1()).intValue();
        String r20 = (String) r18.component2();
        this.g = true;
        if (r19 != 2) goto L68;
        Long r110 = null;
        this.s.setText(null);
        this.t.setText(r20);
    L69:
        if (r27 == true) goto L81;
        if (r4 == null) goto L75;
        if (r5 == null) goto L75;
        if (r4.getScore() >= r5.getScore()) goto L75;
        boolean r21 = true;
    L77:
        if (r21 == false) goto L79;
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        a1.n(this.t, s1.j(2131169160));
        goto L81
    L79:
        this.s.setVisibility(0);
        this.t.setVisibility(8);
        a1.m(this.s, s1.j(2131169160));
    L75:
        r21 = false;
    L81:
        StringBuilder r22 = new StringBuilder("setTeamFightInfo red=");
        if (r4 == null) goto L84;
        Long r111 = Long.valueOf(r4.getScore());
    L85:
        r22.append(r111);
        r22.append(" blue=");
        if (r5 == null) goto L88;
        Long r112 = Long.valueOf(r5.getScore());
    L89:
        r22.append(r112);
        r22.append(" useRelativeScore=");
        r22.append(r7);
        r22.append(" isPunish=");
        r22.append(r27);
        ALogger.w("TeamFightPKProgressLayout", r22.toString());
        String r113 = "";
        if (r4 == null) goto L99;
        String r114 = r4.getScoreStr();
        if (r114 != null) goto L94;
        r114 = r4.getScoreFuzzy();
    L94:
        if (r114 != null) goto L96;
        r114 = "";
    L96:
        h((int) r4.getScore(), r114, r4.getBonusScore());
        if (this.u.getVisibility() != 0) goto L99;
        this.y.b(((li0.d.h(this.w) + a1.f(this.w)) + a1.g(this.w)) + s1.f(9.0f));
    L99:
        if (r5 == null) goto L109;
        String r115 = r5.getScoreStr();
        if (r115 != null) goto L103;
        r115 = r5.getScoreFuzzy();
    L103:
        if (r115 == null) goto L106;
        r113 = r115;
    L106:
        i((int) r5.getScore(), r113, r5.getBonusScore());
        if (this.v.getVisibility() != 0) goto L109;
        this.y.c(((li0.d.h(this.x) + a1.f(this.x)) + a1.g(this.x)) + s1.f(9.0f));
    L109:
        if (r27 == true) goto L175;
        long r116 = r26.getCurrentTime();
        if (r4 == null) goto L113;
        Long r8 = r4.getBonusInfo();
    L114:
        if (r5 == null) goto L116;
        Long r23 = r5.getBonusInfo();
    L117:
        if (r8 == null) goto L119;
        Long r117 = Long.valueOf(r8.getDuration());
    L120:
        long r118 = 0;
        if (r8 == null) goto L123;
        long r24 = (r116 / ((long) 1000)) - r8.getStartTime();
    L124:
        StringBuilder r119 = new StringBuilder("red team duration ");
        r119.append(r117);
        r119.append(", start time ");
        if (r8 == null) goto L127;
        Long r120 = Long.valueOf(r8.getStartTime());
    L128:
        r119.append(r120);
        r119.append(" current time ");
        r119.append(r116);
        r119.append(" diff ");
        r119.append(r24);
        ALogger.i("TeamFightPKProgressLayout", r119.toString());
        if (r8 != null) goto L131;
    L147:
        boolean r25 = r7;
    L148:
        if (r23 == null) goto L150;
        Long r28 = Long.valueOf(r23.getDuration());
    L151:
        if (r23 == null) goto L153;
        long r1 = (r116 / ((long) 1000)) - r23.getStartTime();
    L154:
        StringBuilder r29 = new StringBuilder("blue team duration ");
        r29.append(r28);
        r29.append(", start time ");
        if (r23 == null) goto L157;
        Long r30 = Long.valueOf(r23.getStartTime());
    L158:
        r29.append(r30);
        r29.append(" current time ");
        r29.append(r116);
        r29.append(" diff ");
        r29.append(r1);
        ALogger.i("TeamFightPKProgressLayout", r29.toString());
        if (r23 != null) goto L161;
    L174:
        com.bytedance.android.live.liveinteract.multiscene.a r31 = r26;
    L176:
        if (r27 == false) goto L290;
        j r2 = li0.d.i(r26);
        if (r2 == null) goto L180;
        com.bytedance.android.live.liveinteract.multiscene.k.b(r2);
    L180:
        String r32 = this.j.f();
        Intrinsics.checkNotNullParameter(r31, "$this$isTeamFightInfo");
        if (r26.getFightType() != 1) goto L183;
        boolean r33 = true;
    L184:
        long r34 = -1;
        if (r33 == false) goto L199;
        Long r35 = r26.getWinTeamId();
        if (r35 != null) goto L190;
    L192:
        long r121 = 2;
        if (r35 != null) goto L196;
    L198:
        r32 = this.j.f();
    L220:
        String r36 = this.j.f();
        Intrinsics.checkNotNullParameter(r31, "$this$isTeamFightInfo");
        boolean r122 = true;
        if (r26.getFightType() != 1) goto L223;
        boolean r37 = true;
    L224:
        if (r37 == false) goto L238;
        Long r38 = r26.getWinTeamId();
        if (r38 != null) goto L229;
    L231:
        long r39 = 2;
        if (r38 != null) goto L235;
    L237:
        r36 = this.j.f();
    L258:
        this.o.setVisibility(0);
        this.r.setVisibility(0);
        r1.b(this.o, r32);
        r1.b(this.r, r36);
        if (r25 == false) goto L268;
        TeamFightProgressBar r40 = this.y;
        r40.k = this.c;
        r40.invalidate();
        Long r41 = r26.getWinTeamId();
        long r42 = 2;
        if (r41 != null) goto L264;
    L266:
        this.s.setVisibility(0);
        int r43 = 8;
        this.t.setVisibility(8);
        a1.m(this.s, this.c + s1.f(2.0f));
    L267:
        this.m.setVisibility(r43);
        this.p.setVisibility(r43);
    L283:
        Disposable r44 = this.D;
        if (r44 == null) goto L286;
        r44.dispose();
    L286:
        Disposable r45 = this.C;
        if (r45 == null) goto L291;
        r45.dispose();
        return;
    L291:
        return;
    L264:
        if (r41.longValue() != r42) goto L266;
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        a1.n(this.t, this.c + s1.f(2.0f));
        r43 = 8;
        goto L267
    L268:
        Long r46 = r26.getWinTeamId();
        if (r46 != null) goto L272;
    L274:
        long r47 = 2;
        if (r46 != null) goto L278;
    L281:
        int r48 = this.c;
    L282:
        TeamFightProgressBar r49 = this.y;
        r49.k = r48;
        r49.invalidate();
        a1.m(this.m, this.c);
        a1.n(this.p, this.c);
        this.m.setVisibility(0);
        this.p.setVisibility(0);
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        goto L283
    L278:
        if (r46.longValue() != r47) goto L281;
        int r50 = this.c + li0.d.h(this.m);
        int r51 = s1.f(9.0f);
    L280:
        r48 = r50 + r51;
        goto L282
    L272:
        if (r46.longValue() != 1) goto L274;
        r50 = this.c + li0.d.h(this.p);
        r51 = s1.f(9.0f);
        goto L280
    L235:
        if (r38.longValue() != r39) goto L237;
        r36 = this.j.g();
        goto L258
    L229:
        if (r38.longValue() != 1) goto L231;
        r36 = this.j.b();
        goto L258
    L238:
        Intrinsics.checkNotNullParameter(r31, "$this$isLinkRoomFightInfo");
        if (r26.getFightType() == 2) goto L242;
        r122 = false;
    L242:
        if (r122 == false) goto L258;
        j r52 = li0.d.a(r26);
        if (r52 == null) goto L246;
        r34 = r52.getTeamId();
    L246:
        Long r53 = r26.getWinTeamId();
        long r54 = je0.d.a0();
        if (r53 != null) goto L250;
    L252:
        if (r53 != null) goto L255;
    L257:
        r36 = this.j.f();
        goto L258
    L255:
        if (r53.longValue() != r34) goto L257;
        r36 = this.j.g();
        goto L258
    L250:
        if (r53.longValue() != r54) goto L252;
        r36 = this.j.b();
        goto L258
    L223:
        r37 = false;
        goto L224
    L196:
        if (r35.longValue() != r121) goto L198;
        r32 = this.j.b();
        goto L220
    L190:
        if (r35.longValue() != 1) goto L192;
        r32 = this.j.g();
        goto L220
    L199:
        Intrinsics.checkNotNullParameter(r31, "$this$isLinkRoomFightInfo");
        if (r26.getFightType() != 2) goto L202;
        boolean r55 = true;
    L203:
        if (r55 == false) goto L220;
        j r56 = li0.d.a(r26);
        if (r56 == null) goto L207;
        long r123 = r56.getTeamId();
    L208:
        Long r57 = r26.getWinTeamId();
        long r124 = je0.d.a0();
        if (r57 != null) goto L212;
    L214:
        if (r57 != null) goto L217;
    L219:
        r32 = this.j.f();
        goto L220
    L217:
        if (r57.longValue() != r123) goto L219;
        r32 = this.j.b();
        goto L220
    L212:
        if (r57.longValue() != r124) goto L214;
        r32 = this.j.g();
        goto L220
    L207:
        r123 = -1;
        goto L208
    L202:
        r55 = false;
        goto L203
    L183:
        r33 = false;
        goto L184
    L290:
        return;
    L161:
        if (r1 < 0) goto L174;
        if (r28 == null) goto L164;
        long r58 = r28.longValue();
    L166:
        if (r1 > r58) goto L174;
        Disposable r59 = this.D;
        if (r59 != null) goto L170;
    L171:
        if (r28 == null) goto L173;
        r118 = r28.longValue();
    L173:
        r31 = r26;
        this.D = d(r118 - r1, TimeUnit.SECONDS).doFinally(new e(this)).subscribe(new f(this, r23, r31), g.a);
        goto L176
    L170:
        if (r59.isDisposed() != true) goto L174;
    L164:
        r58 = 0;
        goto L166
    L157:
        r30 = null;
        goto L158
    L153:
        r1 = 0;
        goto L154
    L150:
        r28 = null;
        goto L151
    L131:
        if (r24 < 0) goto L147;
        if (r117 == null) goto L134;
        long r210 = r117.longValue();
    L136:
        if (r24 > r210) goto L147;
        Disposable r125 = this.C;
        if (r125 == null) goto L142;
        r25 = r7;
        if (r125.isDisposed() != true) goto L148;
    L143:
        if (r117 == null) goto L145;
        long r211 = r117.longValue();
    L146:
        this.C = d(r211 - r24, TimeUnit.SECONDS).doFinally(new b(this)).subscribe(new c(this, r8, r26), d.a);
        goto L148
    L145:
        r211 = 0;
        goto L146
    L142:
        r25 = r7;
        goto L143
    L134:
        r210 = 0;
        goto L136
    L127:
        r120 = null;
        goto L128
    L123:
        r24 = 0;
        goto L124
    L119:
        r117 = r110;
        goto L120
    L116:
        r23 = r110;
        goto L117
    L113:
        r8 = r110;
        goto L114
    L175:
        r25 = r7;
        r31 = r26;
        goto L176
    L88:
        r112 = r110;
        goto L89
    L84:
        r111 = r110;
        goto L85
    L68:
        r110 = null;
        this.s.setText(r20);
        this.t.setText(null);
    L46:
        r17 = this.s.getText().toString();
        goto L47
    L37:
        if (r15.longValue() != r16) goto L43;
        if (r14 == null) goto L41;
        String r60 = r14.getScoreFuzzy();
        if (r60 == null) goto L41;
    L42:
        r18 = TuplesKt.to(2, r60);
    L41:
        r60 = this.t.getText().toString();
        goto L42
    L48:
        if (r13 == null) goto L53;
        if (r14 == null) goto L53;
        if (r13.getScore() >= r14.getScore()) goto L53;
        boolean r61 = true;
    L54:
        if (r61 == false) goto L60;
        if (r14 == null) goto L58;
        String r62 = r14.getScoreFuzzy();
        if (r62 == null) goto L58;
    L59:
        r18 = TuplesKt.to(2, r62);
    L58:
        r62 = this.t.getText().toString();
        goto L59
    L60:
        if (r13 == null) goto L63;
        String r63 = r13.getScoreFuzzy();
        if (r63 == null) goto L63;
    L64:
        r18 = TuplesKt.to(1, r63);
    L63:
        r63 = this.s.getText().toString();
    L53:
        r61 = false;
        goto L54
    L80:
        r110 = null;
        this.g = false;
        goto L81
    L7:
        r3 = false;
    L29:
        r7 = false;
        goto L30
    }

    public final void g(int r4, int r5, boolean r6) {
        if (r4 != 0) goto L5;
        if (r5 != 0) goto L5;
        return;
    L5:
        this.A.setVisibility(8);
        this.B.setVisibility(0);
        if ((r4 / (r4 + r5)) <= 0.65f) goto L15;
        AnimationState r0 = this.f;
        AnimationState r1 = AnimationState.STRONG;
        if (r0 != r1) goto L11;
        if (r6 == true) goto L11;
    L23:
        this.d = r4;
        this.e = r5;
        return;
    L11:
        if (this.h == false) goto L13;
        r1.a(this.B, this.j.e(), Boolean.valueOf(c()));
    L14:
        this.f = r1;
        goto L23
    L13:
        r1.a(this.B, li0.c.b(), Boolean.valueOf(c()));
        goto L14
    L15:
        AnimationState r2 = this.f;
        AnimationState r3 = AnimationState.WEAK;
        if (r2 != r3) goto L19;
        if (r6 == false) goto L23;
    L19:
        if (this.h == false) goto L21;
        r1.a(this.B, this.j.e(), Boolean.valueOf(c()));
    L22:
        this.f = r3;
        goto L23
    L21:
        r1.a(this.B, li0.c.b(), Boolean.valueOf(c()));
        goto L22
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void h(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "fuzzyValue");
        boolean r1 = false;
        g(r3, this.y.getRightValue(), false);
        k(true, r4, r5);
        if (this.y.getLeftValue() == r3) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L8;
    L18:
        this.y.setLeftValue(r3);
        return;
    L8:
        if (this.h == false) goto L18;
        if (this.i == true) goto L18;
        com.bytedance.android.live.liveinteract.multiscene.a r7 = this.E;
        if (r7 == null) goto L18;
        Intrinsics.checkNotNullParameter(r7, "$this$isTeamFightInfo");
        if (r7.getFightType() != 1) goto L16;
        r1 = true;
    L16:
        if (r1 == true) goto L18;
        this.i = true;
        UtilityKotlinExtentionsKt.w(this.z);
        a1.p(this.z, RangesKt.coerceAtMost(s1.y() - this.y.m, (int) (s1.y() * this.y.getProgress())));
        this.z.setTranslationX(this.B.getRight() - a1.i(this.z));
        r1.a(this.z, this.j.d(), Boolean.valueOf(c()));
        this.k.add(Observable.timer(3, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.revenue.fight.view.c(this)));
        goto L18
    L5:
        r6 = false;
        goto L6
    }

    public final void i(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "fuzzyValue");
        g(this.y.getLeftValue(), r3, false);
        k(false, r4, r5);
        this.y.setRightValue(r3);
    }

    public final void k(boolean r4, String r5, String r6) {
        if (r4 == false) goto L17;
        this.m.setText(r5);
        this.m.setVisibility(0);
        if (r6 != null) goto L7;
    L16:
        UtilityKotlinExtentionsKt.t(this.n);
        this.y.b(0);
        return;
    L7:
        if (r6.length() <= 0) goto L9;
        boolean r7 = true;
    L10:
        if (r7 != true) goto L16;
        UtilityKotlinExtentionsKt.w(this.n);
        this.n.setText(r6);
        if (this.h == false) goto L14;
        int r8 = UtilityKotlinExtentionsKt.i(36);
    L15:
        this.y.b((li0.d.h(this.m) + li0.d.h(this.n)) + r8);
        return;
    L14:
        r8 = UtilityKotlinExtentionsKt.i(28);
        goto L15
    L9:
        r7 = false;
        goto L10
    L17:
        this.p.setText(r5);
        this.p.setVisibility(0);
        if (r6 != null) goto L20;
    L25:
        UtilityKotlinExtentionsKt.t(this.q);
        this.y.c(0);
        return;
    L20:
        if (r6.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 != true) goto L25;
        UtilityKotlinExtentionsKt.w(this.q);
        this.q.setText(r6);
        this.y.c((li0.d.h(this.p) + li0.d.h(this.q)) + UtilityKotlinExtentionsKt.i(28));
        return;
    L22:
        r9 = false;
        goto L23
    }
}
