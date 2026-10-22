package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import ak6.g;
import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.cl0;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.f;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002R\"\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/hotmsg/NewHotMsgView;", "Landroid/widget/FrameLayout;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "action", "setFinishAction", "Lcom/bytedance/android/live/base/model/message/a5;", "rtfContent", "setRtfContent", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getLogExtraParams", "Landroid/animation/AnimatorSet;", "getResizeAnim", BuildConfig.FLAVOR, "p", "Z", "isShowInPSHighlightArea", "()Z", "setShowInPSHighlightArea", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewHotMsgView extends FrameLayout {
    public static final /* synthetic */ int q = 0;
    public i a;
    public final List<i> b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final FrameLayout h;
    public final LinearLayout i;
    public AnimatorSet j;
    public final AnonymousClass1 k;
    public final a l;
    public final b m;
    public Function0<Unit> n;
    public final boolean o;
    public boolean p;

    public static final class a implements Runnable {
        public final /* synthetic */ NewHotMsgView a;

        public a(NewHotMsgView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            NewHotMsgView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = NewHotMsgView.q;     // Catch: Throwable -> L4
            r0.f(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ NewHotMsgView a;

        public b(NewHotMsgView r1) {
            this.a = r1;
        }

        public final void a() {
            NewHotMsgView r0 = this.a;
            int r1 = NewHotMsgView.q;
            r0.getClass();
            NewHotMsgView.c("endRunnable run");
            if (((ArrayList) this.a.b).isEmpty() == false) goto L7;
            this.a.getClass();
            NewHotMsgView.c("waitingList is empty, finish");
            Function0<Unit> r2 = this.a.n;
            if (r2 == null) goto L9;
            Unit r3 = (Unit) r2.invoke();
            return;
        L9:
            return;
        L7:
            this.a.getClass();
            NewHotMsgView.c("remove waitList first element");
            NewHotMsgView r4 = this.a;
            r4.g((i) ListProtector.remove(r4.b, 0));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ NewHotMsgView a;

        public c(NewHotMsgView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            UtilityKotlinExtentionsKt.t(r7);
            NewHotMsgView.d(this.a.i, false);
            MainThreadPostUtils.b(this.a.k);
            NewHotMsgView r8 = this.a;
            Map r1 = NewHotMsgView.a(r8);
            Pair[] r2 = new Pair[4];
            i r3 = r8.a;
            Long r4 = null;
            if (r3 == null) goto L5;
            Long r5 = r3.e();
        L6:
            r2[0] = TuplesKt.to("msg_collection_cnt", String.valueOf(r5));
            i r6 = r8.a;
            if (r6 == null) goto L9;
            r4 = r6.a;
        L9:
            r2[1] = TuplesKt.to("tray_id", String.valueOf(r4));
            r2[2] = TuplesKt.to("hot_word_id", "0");
            r2[3] = TuplesKt.to("hot_word_title", r8.d.getText().toString());
            Map r9 = MapsKt.mutableMapOf(r2);
            Iterator r10 = r1.entrySet().iterator();
        L11:
            if (r10.hasNext() == false) goto L13;
            Map.Entry r11 = (Map.Entry) r10.next();
            r9.put(r11.getKey(), r11.getValue());
            goto L11
        L13:
            j0.l().sendLog("livesdk_live_message_tray_click", r9, new Object[]{IRoom.class, x.class});
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class d {
    }

    public static final class e implements qb2.e {
        public final /* synthetic */ NewHotMsgView a;

        public e(NewHotMsgView r1) {
            this.a = r1;
        }

        @Override // qb2.e
        public final void a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(g r9) {
            Intrinsics.checkNotNullParameter(r9, "rendResult");
            SpannableString r0 = new SpannableString(r9.a);
            ab2.a.e(r0, UtilityKotlinExtentionsKt.i(14));
            this.a.d.setText(r0);
            NewHotMsgView r10 = this.a;
            Map r1 = NewHotMsgView.a(r10);
            Pair[] r2 = new Pair[5];
            i r3 = r10.a;
            Long r4 = null;
            if (r3 == null) goto L5;
            Long r5 = r3.e();
        L6:
            r2[0] = TuplesKt.to("msg_collection_cnt", String.valueOf(r5));
            i r6 = r10.a;
            if (r6 == null) goto L9;
            r4 = r6.a;
        L9:
            r2[1] = TuplesKt.to("tray_id", String.valueOf(r4));
            String r7 = "0";
            r2[2] = TuplesKt.to("hot_word_id", "0");
            r2[3] = TuplesKt.to("hot_word_title", r10.d.getText().toString());
            if (r10.o == false) goto L12;
            r7 = "1";
        L12:
            r2[4] = TuplesKt.to("is_anchor", r7);
            Map r11 = MapsKt.mutableMapOf(r2);
            Iterator r8 = r1.entrySet().iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            Map.Entry r13 = (Map.Entry) r8.next();
            r11.put(r13.getKey(), r13.getValue());
            goto L14
        L16:
            j0.l().sendLog("livesdk_live_message_tray_show", r11, new Object[]{IRoom.class, x.class});
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    public NewHotMsgView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NewHotMsgView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final Map<String, String> getLogExtraParams() {
        LinkedHashMap r0 = new LinkedHashMap();
        if (this.p == false) goto L5;
        r0.put("show_area", "public_screen_emphasize");
    L7:
        if (this.o == false) goto L9;
        String r1 = "1";
    L10:
        r0.put("is_anchor", r1);
        return r0;
    L9:
        r1 = "0";
        goto L10
    L5:
        r0.put("show_area", "public_screen_normal");
        goto L7
    }

    private final AnimatorSet getResizeAnim() {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.f, "scaleX", new float[]{1.0f, 1.35f});
        r0.setDuration(200);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.f, "scaleY", new float[]{1.0f, 1.35f});
        r4.setDuration(200);
        AnimatorSet r2 = new AnimatorSet();
        r2.playTogether(new Animator[]{r0, r4});
        return r2;
    }

    public final void b() {
        c("cancelAnimation");
        AnimatorSet r0 = this.j;
        if (r0 != null) goto L5;
    L9:
        AnimatorSet r1 = this.j;
        if (r1 == null) goto L12;
        r1.removeAllListeners();
    L12:
        MainThreadPostUtils.d(this.k);
        MainThreadPostUtils.d(this.l);
        MainThreadPostUtils.d(this.m);
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        AnimatorSet r2 = this.j;
        if (r2 == null) goto L9;
        r2.cancel();
        goto L9
    }

    public final void e() {
        c("resetUI resource");
        this.c.setText(null);
        this.d.setText(null);
        this.e.setText(null);
        this.f.setText(null);
        f(false);
        if (this.o == true) goto L5;
        UtilityKotlinExtentionsKt.w(this.g);
        d(this.i, true);
    L6:
        b();
        ViewGroup.LayoutParams r0 = this.h.getLayoutParams();
        r0.width = -2;
        this.h.setLayoutParams(r0);
        return;
    L5:
        d(this.i, false);
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c("onAttachedToWindow");
        if (this.j != null) goto L6;
        this.j = getResizeAnim();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c("onDetachedFromWindow");
        b();
        this.j = null;
    }

    public static final /* synthetic */ Map a(NewHotMsgView r0) {
        return r0.getLogExtraParams();
    }

    public static void c(String r1) {
        ALogger.i("NewHotMsgViewManager", r1);
    }

    private final void setRtfContent(a5 r9) {
        int r0 = InteractivityOpt.a(14.0f);
        f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r1 = r.b;
        Intrinsics.checkNotNullParameter(r9, "text");
        tb2.d r10 = r.a(r9, null);
        Iterator<tb2.c> r2 = r10.a.iterator();
    L4:
        if (r2.hasNext() == false) goto L23;
        tb2.c r3 = r2.next();
        ITextPieceImage r4 = r3.getImageValue();
        if (r4 == null) goto L4;
        int r5 = (int) (r0 * r4.getScalingRate());
        if (r4.getScalingRate() <= 0.0f) goto L10;
        r4.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r4.setHeight(r5);
    L10:
        k r6 = r4.getImageModel();
        if (r6 == null) goto L15;
        k.b r7 = r6.getImageContent();
        if (r7 == null) goto L15;
        String r8 = r7.getName();
    L16:
        if (r8 == null) goto L4;
        if (r8.length() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 != true) goto L4;
        r4.setEnableTextWhenFailed(true);
        r3.setText(r8);
        goto L4
    L20:
        r11 = false;
    L15:
        r8 = null;
        goto L16
    L23:
        qb2.c.b(r10, new e(this), null, 28);
    }

    public final void f(boolean r1) {
        if (r1 == false) goto L4;
        UtilityKotlinExtentionsKt.u(this.e);
        UtilityKotlinExtentionsKt.w(this.f);
        return;
    L4:
        UtilityKotlinExtentionsKt.w(this.e);
        UtilityKotlinExtentionsKt.u(this.f);
    }

    public final void g(i r6) {
        c("showHotWord");
        e();
        this.a = r6;
        if (r6 == null) goto L7;
        a5 r0 = r6.a();
        if (r0 == null) goto L7;
        setRtfContent(r0);
    L7:
        TextView r1 = this.c;
        i r2 = this.a;
        if (r2 == null) goto L12;
        String r3 = r2.d();
        if (r3 == null) goto L12;
    L13:
        r1.setText(r3);
        TextView r4 = this.e;
        i r5 = this.a;
        String r7 = null;
        if (r5 == null) goto L16;
        String r8 = r5.b();
    L17:
        r4.setText(r8);
        i r9 = this.a;
        if (r9 == null) goto L20;
        Boolean r10 = r9.c();
    L22:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L28;
        i r11 = this.a;
        if (r11 == null) goto L31;
        Long r13 = r11.e();
        if (r13 == null) goto L31;
        r7 = String.valueOf(r13.longValue() + 1);
    L31:
        this.f.setText(r7);
        f(false);
        c("post an endRunnable");
        b r14 = this.m;
        if (r6 == null) goto L36;
        Long r15 = r6.f();
        if (r15 == null) goto L36;
        long r16 = r15.longValue();
    L37:
        MainThreadPostUtils.c(r14, r16 * 1000);
        return;
    L36:
        r16 = 0;
        goto L37
    L28:
        i r17 = this.a;
        if (r17 == null) goto L31;
        r7 = r17.b();
        goto L31
    L20:
        r10 = null;
        goto L22
    L16:
        r8 = null;
    L12:
        r3 = BuildConfig.FLAVOR;
        goto L13
    }

    public final void setFinishAction(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.n = r2;
    }

    public final void setShowInPSHighlightArea(boolean r1) {
        this.p = r1;
    }

    public static void d(View r3, boolean r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (((Boolean) cl0.a.getValue()).booleanValue() == true) goto L7;
        return;
    L7:
        int r0 = r3.getPaddingLeft();
        int r1 = r3.getPaddingTop();
        if (r4 == false) goto L10;
        int r5 = 4;
    L11:
        r3.setPadding(r0, r1, UtilityKotlinExtentionsKt.i(r5), r3.getPaddingBottom());
        return;
    L10:
        r5 = 8;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.NewHotMsgView$1] */
    public NewHotMsgView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.b = new ArrayList();
        LayoutInflater.from(r5).inflate(2131567788, this);
        this.c = (TextView) findViewById(2131374542);
        this.d = (TextView) findViewById(2131374540);
        this.e = (TextView) findViewById(2131368026);
        this.f = (TextView) findViewById(2131367265);
        TextView r8 = (TextView) findViewById(2131380212);
        this.g = r8;
        this.h = (FrameLayout) findViewById(2131368027);
        LinearLayout r9 = (LinearLayout) findViewById(2131374543);
        this.i = r9;
        IRoomContextService r10 = jc1.k.f(IRoomContextService.class);
        Boolean r0 = null;
        if (r10 == null) goto L7;
        o r11 = IRoomContextService.a.a(r10, null, 0, 3);
        if (r11 == null) goto L7;
        r0 = r11.isAnchor();
    L7:
        boolean r13 = Intrinsics.areEqual(r0, Boolean.TRUE);
        this.o = r13;
        if (r13 == false) goto L10;
        UtilityKotlinExtentionsKt.t(r8);
        d(r9, false);
    L11:
        this.j = getResizeAnim();
        this.k = new AnonymousClass1(this);
        this.l = new a(this);
        this.m = new b(this);
        r8.setOnClickListener(new c(this));
        return;
    L10:
        d(r9, true);
        goto L11
    }

    public /* synthetic */ NewHotMsgView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
