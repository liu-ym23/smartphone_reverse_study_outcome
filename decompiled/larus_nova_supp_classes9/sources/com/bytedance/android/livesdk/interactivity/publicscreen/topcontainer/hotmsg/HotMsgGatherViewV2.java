package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import ak6.g;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.f1;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.f;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/hotmsg/HotMsgGatherViewV2;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "content", BuildConfig.FLAVOR, "setContent", "Lcom/bytedance/android/live/base/model/message/a5;", "rtfContent", "setRtfContent", "Lcom/bytedance/android/live/base/model/message/f1;", "msg", "setCurMsg", "Landroid/animation/AnimatorSet;", "getGiftComboAnim", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/hotmsg/c;", "showInfo", "setShowInfo", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/hotmsg/e;", "callBack", "setCallBack", "setHotMsgModel", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", BuildConfig.FLAVOR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HotMsgGatherViewV2 extends FrameLayout {
    public f1 a;
    public final TextView b;
    public final TextView c;
    public final LinearLayout d;
    public final TextView e;
    public final TextView f;
    public boolean g;
    public ArrayList<Long> h;
    public ArrayList<Long> i;
    public boolean j;
    public int k;
    public boolean l;
    public AnimatorSet m;
    public final long n;
    public final a o;
    public Function0<Unit> p;
    public com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.c q;

    public static final class a implements Runnable {
        public final /* synthetic */ HotMsgGatherViewV2 a;

        public a(HotMsgGatherViewV2 r1) {
            this.a = r1;
        }

        public final void a() {
            HotMsgGatherViewV2 r0 = this.a;
            if (r0.j == true) goto L6;
            return;
        L6:
            if (r0.k >= r0.h.size()) goto L14;
            HotMsgGatherViewV2 r1 = this.a;
            this.a.c.setText(String.valueOf(((Number) ListProtector.get(r1.h, r1.k)).longValue()));
            AnimatorSet r2 = this.a.m;
            if (r2 == null) goto L10;
            r2.cancel();
        L10:
            AnimatorSet r3 = this.a.m;
            if (r3 == null) goto L13;
            r3.start();
        L13:
            HotMsgGatherViewV2 r4 = this.a;
            long r5 = RangesKt.coerceAtLeast(((Number) ListProtector.get(r4.i, r4.k)).longValue(), this.a.n);
            HotMsgGatherViewV2 r6 = this.a;
            r6.postDelayed(r6.o, r5);
            this.a.k++;
            return;
        L14:
            HotMsgGatherViewV2 r7 = this.a;
            r7.j = false;
            Function0<Unit> r8 = r7.p;
            if (r8 == null) goto L17;
            Unit r9 = (Unit) r8.invoke();
        L17:
            HotMsgGatherViewV2 r10 = this.a;
            r10.p = null;
            r10.h.clear();
            this.a.i.clear();
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

    public static final class b {
    }

    public static final class c implements qb2.e {
        public final /* synthetic */ HotMsgGatherViewV2 a;

        public c(HotMsgGatherViewV2 r1) {
            this.a = r1;
        }

        @Override // qb2.e
        public final void a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        @Override // qb2.e
        public final void b(g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            this.a.f.setText(r2.a);
        }
    }

    static {
    }

    public HotMsgGatherViewV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HotMsgGatherViewV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a() {
        this.l = true;
        this.m = getGiftComboAnim();
    }

    public final void b() {
        this.j = false;
        AnimatorSet r0 = this.m;
        if (r0 != null) goto L5;
    L9:
        removeCallbacks(this.o);
        return;
    L5:
        if (r0.isRunning() != true) goto L9;
        AnimatorSet r1 = this.m;
        if (r1 == null) goto L9;
        r1.cancel();
        goto L9
    }

    public final void setCallBack(e r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
    }

    private final AnimatorSet getGiftComboAnim() {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.d, "scaleX", new float[]{1.15f, 1.0f});
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.d, "scaleY", new float[]{1.15f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        r3.playTogether(new Animator[]{r0, r2});
        r3.setDuration(120);
        return r3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l == true) goto L5;
        return;
    L5:
        if (this.m != null) goto L9;
        this.m = getGiftComboAnim();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        this.m = null;
    }

    private final void setContent(String r3) {
        TextView r0 = this.f;
        SpannableString r1 = new SpannableString(r3);
        ab2.a.e(r1, InteractivityOpt.a(16.0f));
        r0.setText(r1);
    }

    private final void setCurMsg(f1 r1) {
        this.a = r1;
    }

    private final void setRtfContent(a5 r9) {
        int r0 = InteractivityOpt.a(14.0f);
        f.a.getClass();
        x r1 = r.b;
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
        qb2.c.b(r10, new c(this), null, 28);
    }

    public final void setHotMsgModel(f1 r7) {
        if (this.g == true) goto L10;
        this.g = true;
        Typeface r0 = Typeface.createFromAsset(getContext().getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L8
        this.b.setTypeface(r0);     // Catch: Exception -> L8
        this.c.setTypeface(r0);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("HotMsgGatherViewV2", "load font asset exception: " + e.getMessage());
    L10:
        if (r7 == null) goto L50;
        List r1 = r7.getNum();
        if (r1 != null) goto L14;
        return;
    L14:
        if ((!r1.isEmpty()) != true) goto L52;
        List r2 = r7.getShowDuration();
        if (r2 != null) goto L18;
        return;
    L18:
        if ((!r2.isEmpty()) != true) goto L54;
        setCurMsg(r7);
        a5 r3 = r7.getRtfContent();
        String r4 = BuildConfig.FLAVOR;
        if (r3 == null) goto L23;
        setRtfContent(r3);
    L27:
        TextView r5 = this.e;
        String r6 = r7.getTitle();
        if (r6 == null) goto L30;
        r4 = r6;
    L30:
        r5.setText(r4);
        List r8 = r7.getNum();
        List r9 = null;
        if ((r8 instanceof ArrayList) == true) goto L33;
        r8 = null;
    L33:
        ArrayList<Long> r10 = (ArrayList) r8;
        if (r10 != null) goto L36;
        r10 = new ArrayList();
    L36:
        this.h = r10;
        if ((!r10.isEmpty()) == false) goto L39;
        this.c.setText(String.valueOf(((Number) ListProtector.get(this.h, 0)).longValue()));
    L39:
        this.k = 0;
        List r11 = r7.getShowDuration();
        if ((r11 instanceof ArrayList) == false) goto L43;
        r9 = r11;
    L43:
        ArrayList<Long> r13 = (ArrayList) r9;
        if (r13 != null) goto L46;
        r13 = new ArrayList();
    L46:
        this.i = r13;
        return;
    L23:
        String r14 = r7.getContent();
        if (r14 != null) goto L26;
        r14 = BuildConfig.FLAVOR;
    L26:
        setContent(r14);
        goto L27
    L54:
        return;
    L52:
        return;
    }

    public final void setShowInfo(com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg.c r2) {
        Intrinsics.checkNotNullParameter(r2, "showInfo");
        this.q = r2;
    }

    public HotMsgGatherViewV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.l = true;
        this.n = 200;
        LayoutInflater.from(r2).inflate(2131567686, this);
        this.e = (TextView) findViewById(2131374544);
        this.f = (TextView) findViewById(2131374540);
        this.c = (TextView) findViewById(2131374537);
        this.b = (TextView) findViewById(2131374538);
        this.d = (LinearLayout) findViewById(2131374536);
        this.m = getGiftComboAnim();
        this.o = new a(this);
    }

    public /* synthetic */ HotMsgGatherViewV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
