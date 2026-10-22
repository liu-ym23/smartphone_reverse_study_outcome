package com.bytedance.android.live.profit.format.voicechat.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.livesdk.config.bi1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nu0.j;
import nu0.m;
import nu0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003%&'B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u001b\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatActionView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatActionView$e;", "listener", "", "setActionListener", "Landroid/graphics/drawable/Drawable;", "i", "Lkotlin/Lazy;", "getMuteDrawable", "()Landroid/graphics/drawable/Drawable;", "muteDrawable", "j", "getUnMuteDrawable", "unMuteDrawable", "", "k", "getConnectingText", "()Ljava/lang/String;", "connectingText", "l", "getTimeUPText", "timeUPText", "m", "getWaitingText", "waitingText", "n", "getMutedText", "mutedText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d", "e", "VoiceChatAction", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VoiceChatActionView extends FrameLayout {
    public static final String s = null;
    public final ImageView a;
    public e b;
    public final TextView c;
    public final ViewGroup d;
    public final ViewGroup e;
    public final ViewGroup f;
    public final ViewGroup g;
    public final TextView h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public VoiceChatState o;
    public View p;
    public Animator q;
    public boolean r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/profit/format/voicechat/view/VoiceChatActionView$VoiceChatAction;", "", "ACTION_CLOSE", "ACTION_MUTE", "ACTION_INTERCEPT", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VoiceChatAction extends Enum<VoiceChatAction> {
        public static final VoiceChatAction ACTION_CLOSE = null;
        public static final VoiceChatAction ACTION_INTERCEPT = null;
        public static final VoiceChatAction ACTION_MUTE = null;
        public static final /* synthetic */ VoiceChatAction[] a = null;

        static {
            VoiceChatAction r1 = new VoiceChatAction("ACTION_CLOSE", 0);
            ACTION_CLOSE = r1;
            VoiceChatAction r2 = new VoiceChatAction("ACTION_MUTE", 1);
            ACTION_MUTE = r2;
            VoiceChatAction r3 = new VoiceChatAction("ACTION_INTERCEPT", 2);
            ACTION_INTERCEPT = r3;
            a = new VoiceChatAction[]{r1, r2, r3};
        }

        public static VoiceChatAction valueOf(String r1) {
            return (VoiceChatAction) r27.a.a(VoiceChatAction.class, r1);
        }

        public static VoiceChatAction[] values() {
            return (VoiceChatAction[]) a.clone();
        }

        public VoiceChatAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ VoiceChatActionView a;

        public a(VoiceChatActionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            e r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(VoiceChatAction.ACTION_CLOSE);
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VoiceChatActionView a;

        public b(VoiceChatActionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            e r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(VoiceChatAction.ACTION_MUTE);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ VoiceChatActionView a;

        public c(VoiceChatActionView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            e r3 = this.a.b;
            if (r3 == null) goto L6;
            r3.a(VoiceChatAction.ACTION_INTERCEPT);
            return;
        }
    }

    public static final class d {
    }

    public interface e {
        void a(VoiceChatAction r1);
    }

    public static final class f implements Animator.AnimatorListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            if (this.b == true) goto L6;
            ViewUtilsKt.e(this.a);
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            if (this.b == false) goto L6;
            UtilityKotlinExtentionsKt.w(this.a);
            return;
        }

        public f(View r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g implements Animator.AnimatorListener {
        public final /* synthetic */ VoiceChatActionView a;
        public final /* synthetic */ View b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            VoiceChatActionView r3 = this.a;
            r3.p = this.b;
        }

        public g(VoiceChatActionView r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class h implements Animator.AnimatorListener {
        public final /* synthetic */ View a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        public h(View r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            ViewUtilsKt.e(this.a);
        }
    }

    public static final class i implements Animator.AnimatorListener {
        public final /* synthetic */ View a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
        }

        public i(View r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            UtilityKotlinExtentionsKt.w(this.a);
        }
    }

    public VoiceChatActionView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceChatActionView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getConnectingText() {
        return (String) this.k.getValue();
    }

    private final Drawable getMuteDrawable() {
        return (Drawable) this.i.getValue();
    }

    private final String getMutedText() {
        return (String) this.n.getValue();
    }

    private final String getTimeUPText() {
        return (String) this.l.getValue();
    }

    private final Drawable getUnMuteDrawable() {
        return (Drawable) this.j.getValue();
    }

    private final String getWaitingText() {
        return (String) this.m.getValue();
    }

    static {
        s = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/voice_chat_listening.webp";
    }

    public final void b(VoiceChatState r19) {
        Intrinsics.checkNotNullParameter(r19, "state");
        j.a(this, "on chat state change, currentState:" + this.o + ", targetState: " + r19);
        if (this.o != r19) goto L5;
        return;
    L5:
        this.o = r19;
        switch(com.bytedance.android.live.profit.format.voicechat.view.e.a[r19.ordinal()]) {
            case 1: goto L15;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L8;
            default: goto L43;
        };
    L8:
        TextView r1 = this.h;
        Object r2 = bi1.a(Boolean.valueOf(this.r), getMutedText());
        String r3 = getWaitingText();
        if (r2 != null) goto L11;
        r2 = r3;
    L11:
        r1.setText((CharSequence) r2);
        d(this.f);
        return;
    L12:
        d(this.e);
        return;
    L13:
        d(this.d);
        return;
    L43:
        return;
    L15:
        if (r19 != VoiceChatState.CONNECTING) goto L17;
        boolean r4 = true;
    L18:
        Object r5 = bi1.a(Boolean.valueOf(r4), getConnectingText());
        String r6 = getTimeUPText();
        if (r5 != null) goto L21;
        r5 = r6;
    L21:
        String r7 = (String) r5;
        if (Intrinsics.areEqual(this.p, this.c) == false) goto L37;
        TextView r8 = this.c;
        LinearInterpolator r9 = new LinearInterpolator();
        LinearInterpolator r10 = new LinearInterpolator();
        Intrinsics.checkNotNullParameter(r8, "$this$getChangeTextAnim");
        Intrinsics.checkNotNullParameter(r9, "hideInterpolator");
        Intrinsics.checkNotNullParameter(r10, "showInterpolator");
        AnimatorSet r12 = new AnimatorSet();
        Animator[] r13 = new Animator[2];
        long r14 = 680 / ((long) 2);
        Property r15 = View.ALPHA;
        float[] r16 = new float[2];
        Boolean r17 = Boolean.FALSE;
        Object r18 = Float.valueOf(0.0f);
        Object r110 = bi1.a(r17, r18);
        Float r20 = Float.valueOf(1.0f);
        if (r110 != null) goto L26;
        r110 = r20;
    L26:
        r16[0] = ((Number) r110).floatValue();
        Object r111 = bi1.a(r17, r20);
        if (r111 != null) goto L29;
        r111 = r18;
    L29:
        r16[1] = ((Number) r111).floatValue();
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r8, r15, r16);
        r112.setDuration(r14);
        r112.setStartDelay(0);
        r112.setInterpolator(r9);
        r112.addListener(new n(r8, r8, r7));
        r13[0] = r112;
        Property r22 = View.ALPHA;
        float[] r113 = new float[2];
        Boolean r114 = Boolean.TRUE;
        Object r115 = bi1.a(r114, r18);
        if (r115 != null) goto L32;
        r115 = r20;
    L32:
        r113[0] = ((Number) r115).floatValue();
        Object r23 = bi1.a(r114, r20);
        if (r23 == null) goto L36;
        r18 = r23;
    L36:
        r113[1] = ((Number) r18).floatValue();
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r8, r22, r113);
        r24.setDuration(r14);
        r24.setStartDelay(0);
        r24.setInterpolator(r10);
        r24.addListener(new m(r8));
        r13[1] = r24;
        r12.playSequentially(r13);
        r12.start();
        return;
    L37:
        this.c.setText(r7);
        d(this.c);
        return;
    L17:
        r4 = false;
        goto L18
    }

    public final void c(boolean r4) {
        ImageView r0 = this.a;
        Object r1 = bi1.a(Boolean.valueOf(r4), getUnMuteDrawable());
        Drawable r2 = getMuteDrawable();
        if (r1 != null) goto L5;
        r1 = r2;
    L5:
        r0.setImageDrawable((Drawable) r1);
        this.r = r4;
        if (this.o != VoiceChatState.WAITING) goto L12;
        TextView r3 = this.h;
        Object r5 = bi1.a(Boolean.valueOf(r4), getMutedText());
        String r6 = getWaitingText();
        if (r5 != null) goto L10;
        r5 = r6;
    L10:
        r3.setText((CharSequence) r5);
        return;
    }

    public final void d(View r19) {
        if (Intrinsics.areEqual(this.p, r19) == false) goto L5;
        return;
    L5:
        Animator r2 = this.q;
        if (r2 == null) goto L8;
        r2.cancel();
    L8:
        View r3 = this.p;
        if (r3 == null) goto L17;
        PathInterpolator r15 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Property r4 = View.ALPHA;
        float[] r8 = new float[2];
        Boolean r7 = Boolean.FALSE;
        Object r9 = bi1.a(r7, Float.valueOf(0.0f));
        Float r17 = Float.valueOf(1.0f);
        if (r9 != null) goto L13;
        r9 = r17;
    L13:
        r8[0] = ((Number) r9).floatValue();
        Object r10 = bi1.a(r7, Float.valueOf(1.0f));
        Float r12 = Float.valueOf(0.0f);
        if (r10 != null) goto L16;
        r10 = r12;
    L16:
        r8[1] = ((Number) r10).floatValue();
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r3, r4, r8);
        r5.setDuration(340);
        r5.setStartDelay(0);
        r5.setInterpolator(r15);
        r5.addListener(new h(r3));
    L18:
        if (r19 == null) goto L26;
        PathInterpolator r6 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Property r13 = View.ALPHA;
        float[] r14 = new float[2];
        Boolean r16 = Boolean.TRUE;
        Object r18 = bi1.a(r16, Float.valueOf(0.0f));
        Float r110 = Float.valueOf(1.0f);
        if (r18 != null) goto L22;
        r18 = r110;
    L22:
        r14[0] = ((Number) r18).floatValue();
        Object r20 = bi1.a(r16, Float.valueOf(1.0f));
        Float r22 = Float.valueOf(0.0f);
        if (r20 != null) goto L25;
        r20 = r22;
    L25:
        r14[1] = ((Number) r20).floatValue();
        ObjectAnimator r23 = ObjectAnimator.ofFloat(r19, r13, r14);
        r23.setDuration(340);
        r23.setStartDelay(0);
        r23.setInterpolator(r6);
        r23.addListener(new i(r19));
        ObjectAnimator r111 = r23;
    L27:
        AnimatorSet r24 = new AnimatorSet();
        r24.playSequentially(new Animator[]{r5, r111});
        r24.addListener(new g(this, r19));
        r24.start();
        Unit r1 = Unit.INSTANCE;
        this.q = r24;
        return;
    L26:
        r111 = null;
        goto L27
    L17:
        r5 = null;
        goto L18
    }

    public final void setActionListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    public final Animator a(boolean r10, long r12) {
        Object r0 = bi1.a(Boolean.valueOf(r10), 467L);
        if (r0 != null) goto L5;
        r0 = 933L;
    L5:
        long r1 = ((Number) r0).longValue();
        PathInterpolator r2 = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        Property r3 = View.ALPHA;
        float[] r5 = new float[2];
        Object r7 = bi1.a(Boolean.valueOf(r10), Float.valueOf(0.0f));
        Float r8 = Float.valueOf(1.0f);
        if (r7 != null) goto L8;
        r7 = r8;
    L8:
        r5[0] = ((Number) r7).floatValue();
        Object r6 = bi1.a(Boolean.valueOf(r10), Float.valueOf(1.0f));
        Float r4 = Float.valueOf(0.0f);
        if (r6 != null) goto L11;
        r6 = r4;
    L11:
        r5[1] = ((Number) r6).floatValue();
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this, r3, r5);
        r9.setDuration(r1);
        r9.setStartDelay(r12);
        r9.setInterpolator(r2);
        r9.addListener(new f(this, r10));
        return r9;
    }

    public VoiceChatActionView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.i = LazyKt.lazy(new VoiceChatActionView$muteDrawable$2(r2));
        this.j = LazyKt.lazy(new VoiceChatActionView$unMuteDrawable$2(r2));
        this.k = LazyKt.lazy(new VoiceChatActionView$connectingText$2(r2));
        this.l = LazyKt.lazy(new VoiceChatActionView$timeUPText$2(r2));
        this.m = LazyKt.lazy(new VoiceChatActionView$waitingText$2(r2));
        this.n = LazyKt.lazy(new VoiceChatActionView$mutedText$2(r2));
        this.o = VoiceChatState.CONNECTING;
        LayoutInflater.from(r2).inflate(2131566021, this);
        setAlpha(0.0f);
        View r5 = findViewById(2131362080);
        if (r5 == null) goto L5;
        r5.setOnClickListener(new a(this));
    L5:
        ImageView r6 = (ImageView) findViewById(2131362123);
        this.a = r6;
        r6.setOnClickListener(new b(this));
        View r7 = findViewById(2131362099);
        if (r7 == null) goto L8;
        r7.setOnClickListener(new c(this));
    L8:
        HSImageView r8 = findViewById(2131362109);
        if (r8 == null) goto L11;
        r8.setController(Fresco.newDraweeControllerBuilder().setUri(s).setAutoPlayAnimations(true).build());
    L11:
        this.g = (ViewGroup) findViewById(2131362082);
        TextView r9 = (TextView) findViewById(2131362149);
        this.c = r9;
        this.d = (ViewGroup) findViewById(2131362098);
        this.e = (ViewGroup) findViewById(2131362108);
        this.f = (ViewGroup) findViewById(2131362154);
        this.h = (TextView) findViewById(2131362156);
        this.p = r9;
    }

    public /* synthetic */ VoiceChatActionView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
