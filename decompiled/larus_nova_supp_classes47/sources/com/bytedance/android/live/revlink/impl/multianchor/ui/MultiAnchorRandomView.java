package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.e0;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorRandomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/text/style/MetricAffectingSpan;", "getNumberSpan", "getTextSpan", "Lq21/k;", "item", "", "update", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorRandomView$a;", "j", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorRandomView$a;", "getLogCallback", "()Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorRandomView$a;", "setLogCallback", "(Lcom/bytedance/android/live/revlink/impl/multianchor/ui/MultiAnchorRandomView$a;)V", "logCallback", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/a;", "getMatchService", "()Lcom/bytedance/android/live/revlink/impl/multianchor/match/a;", "matchService", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/MultiPkMatchContext;", "getMatchContext", "()Lcom/bytedance/android/live/revlink/impl/multianchor/match/MultiPkMatchContext;", "matchContext", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/c;", "getMatchStatus", "()Lcom/bytedance/android/live/revlink/impl/multianchor/match/c;", "matchStatus", "", "getCountDownTime", "()J", "countDownTime", "Lcom/bytedance/android/livesdk/link/model/b0;", "getSelfAutoMatchInfo", "()Lcom/bytedance/android/livesdk/link/model/b0;", "selfAutoMatchInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiAnchorRandomView extends ConstraintLayout {
    public final View a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final Drawable h;
    public boolean i;
    public a j;

    public interface a {
        com.bytedance.android.live.revlink.impl.pk.utils.i NS();
    }

    public static final class b extends MetricAffectingSpan {
        public final /* synthetic */ MultiAnchorRandomView a;

        public b(MultiAnchorRandomView r1) {
            this.a = r1;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r3) {
            Typeface r0 = Typeface.createFromAsset(this.a.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf");
            if (r3 == null) goto L5;
            r3.setTypeface(r0);
        L5:
            if (r3 == null) goto L7;
            r3.setFakeBoldText(false);
        L7:
            if (r3 == null) goto L9;
            r3.setTextSize(s1.f(16.0f));
        L9:
            if (r3 == null) goto L12;
            r3.setColor(ColorProtector.parseColor("#FE2C55"));
            return;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r3) {
            Intrinsics.checkNotNullParameter(r3, "paint");
            r3.setTypeface(Typeface.createFromAsset(this.a.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
            r3.setFakeBoldText(false);
            r3.setTextSize(s1.f(16.0f));
            r3.setColor(ColorProtector.parseColor("#FE2C55"));
        }
    }

    public static final class c extends MetricAffectingSpan {
        public c() {
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            if (r2 == null) goto L5;
            r2.baselineShift = -s1.f(1.0f);
            return;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "paint");
            r2.baselineShift = -s1.f(1.0f);
        }
    }

    public MultiAnchorRandomView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MultiAnchorRandomView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final MetricAffectingSpan getNumberSpan() {
        return new b(this);
    }

    private final MetricAffectingSpan getTextSpan() {
        return new c();
    }

    public final void Z5() {
        this.b.setText(s1.B(2131920617));
        this.d.setText(s1.B(2131920610));
        this.d.setCompoundDrawablesWithIntrinsicBounds(this.h, null, null, null);
        this.c.setVisibility(4);
        this.g.setVisibility(8);
    }

    private final long getCountDownTime() {
        MultiPkMatchContext r0 = getMatchContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Long> r1 = r0.getCountDownTime();
        if (r1 == null) goto L9;
        Long r2 = (Long) r1.getValue();
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    private final MultiPkMatchContext getMatchContext() {
        return com.bytedance.android.live.revlink.impl.global.b.G();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.match.a getMatchService() {
        return com.bytedance.android.live.revlink.impl.global.b.I();
    }

    private final com.bytedance.android.live.revlink.impl.multianchor.match.c getMatchStatus() {
        MultiPkMatchContext r0 = getMatchContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L7;
        return (com.bytedance.android.live.revlink.impl.multianchor.match.c) r1.getValue();
    L7:
        return null;
    }

    private final b0 getSelfAutoMatchInfo() {
        MultiPkMatchContext r0 = getMatchContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<b0> r1 = r0.getSelfAutoMatchInfo();
        if (r1 == null) goto L7;
        return (b0) r1.getValue();
    L7:
        return null;
    }

    public final boolean U5() {
        com.bytedance.android.live.revlink.impl.multianchor.match.c r0 = getMatchStatus();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a;
    }

    public final a getLogCallback() {
        return this.j;
    }

    public static final /* synthetic */ com.bytedance.android.live.revlink.impl.multianchor.match.a R5(MultiAnchorRandomView r0) {
        return r0.getMatchService();
    }

    public static final /* synthetic */ b0 S5(MultiAnchorRandomView r0) {
        return r0.getSelfAutoMatchInfo();
    }

    public final void T5(boolean r3) {
        com.bytedance.android.live.revlink.impl.multianchor.match.f r0 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r0 == null) goto L5;
        r0.b(4);
    L5:
        if (r3 == false) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r4 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r4 == null) goto L9;
        r4.a(4);
    L9:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r5 = getMatchService();
        if (r5 == null) goto L13;
        r5.ni(0, "disable");
        return;
    }

    public final void V5(b0 r12) {
        Intrinsics.checkNotNullParameter(r12, "matchInfo");
        long r0 = r12.getWaitSec();
        this.b.setText(s1.B(2131920571));
        this.c.setVisibility(4);
        TextView r13 = this.d;
        int r2 = String.valueOf(r0).length();
        long r3 = 60;
        if (r0 >= r3) goto L5;
        String r1 = " " + r0 + " 秒";
    L10:
        SpannableStringBuilder r4 = new SpannableStringBuilder();
        r4.append(s1.C(2131920612, new Object[]{r1}));
        r4.setSpan(getTextSpan(), 0, 5, 34);
        int r5 = r2 + 5;
        r4.setSpan(getNumberSpan(), 5, r5, 34);
        r4.setSpan(getTextSpan(), r5, r4.length(), 34);
        r13.setText(r4);
        this.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.e.setText(s1.B(2131920602));
        this.e.setSelected(false);
        this.g.setVisibility(8);
        return;
    L5:
        long r6 = r0 % r3;
        long r7 = r0 / r3;
        if (r6 == 0) goto L9;
        r7 = r7 + 1;
    L9:
        r2 = String.valueOf(r7).length();
        r1 = " " + r7 + " 分钟";
        goto L10
    }

    public final void setLogCallback(a r1) {
        this.j = r1;
    }

    public final void update(q21.k r5) {
        Intrinsics.checkNotNullParameter(r5, "item");
        this.b.getPaint().setFakeBoldText(true);
        this.c.setTypeface(Typeface.createFromAsset(this.a.getContext().getAssets(), "fonts/clarity_mono_bold.otf"));
        b0 r6 = r5.a;
        if (U5() == false) goto L5;
        Y5(RangesKt.coerceAtLeast(getCountDownTime(), 0), r6);
    L6:
        this.e.setOnClickListener(x0.a(new MultiAnchorRandomView$bindMatchData$1(this, r6)));
        this.g.setTextColor(ColorProtector.parseColor("#FE2C55"));
        this.g.setOnClickListener(x0.a(new MultiAnchorRandomView$bindMatchData$2(this)));
        return;
    L5:
        V5(r6);
        goto L6
    }

    public final void Y5(long r19, b0 r22) {
        Intrinsics.checkNotNullParameter(r22, "matchInfo");
        long r5 = r22.getWaitSec();
        int r4 = (int) e0.a(r22);
        com.bytedance.android.live.revlink.impl.multianchor.match.c r3 = getMatchStatus();
        boolean r7 = false;
        if (r3 == null) goto L5;
        boolean r6 = r3.c;
    L7:
        if (r6 == false) goto L14;
        Z5();
        long r8 = r4;
        if (1 <= r19) goto L12;
    L60:
        this.e.setText(s1.B(2131917919));
        this.e.setSelected(true);
        com.bytedance.android.live.revlink.impl.multianchor.match.c r1 = getMatchStatus();
        if (r1 != null) goto L63;
    L65:
        if (r7 == false) goto L68;
        this.g.setVisibility(8);
        return;
    L68:
        return;
    L63:
        if ((r1 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.d) != true) goto L65;
        r7 = true;
        goto L65
    L12:
        if (r8 <= r19) goto L60;
        this.g.setVisibility(8);
        goto L60
    L14:
        long r12 = 60;
        if (r5 <= r12) goto L31;
        this.b.setText(s1.B(2131920617));
        TextView r9 = this.d;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r10 = getMatchStatus();
        if (r10 == null) goto L19;
        boolean r13 = r10.c;
    L20:
        if (r13 == true) goto L29;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r14 = getMatchStatus();
        if (r14 != null) goto L24;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L29;
        int r16 = 2131920619;
    L30:
        r9.setText(s1.B(r16));
        this.c.setVisibility(4);
        this.g.setVisibility(0);
        b6(r19, r4);
        goto L60
    L24:
        if ((r14 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.d) != true) goto L26;
        r15 = true;
    L29:
        r16 = 2131920609;
        goto L30
    L19:
        r13 = false;
        goto L20
    L31:
        long r17 = 59;
        if (1 > r5) goto L58;
        if (r17 < r5) goto L58;
        this.b.setText(s1.B(2131920616));
        TextView r18 = this.d;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r20 = getMatchStatus();
        if (r20 == null) goto L39;
        boolean r23 = r20.c;
    L40:
        if (r23 == true) goto L49;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r24 = getMatchStatus();
        if (r24 != null) goto L44;
    L46:
        boolean r25 = false;
    L47:
        if (r25 == false) goto L49;
        int r110 = 2131920619;
    L50:
        r18.setText(s1.B(r110));
        this.c.setVisibility(0);
        TextView r26 = this.c;
        SimpleDateFormat r27 = com.bytedance.live.kmp.util.e.a;
        StringBuilder r28 = new StringBuilder();
        long r111 = r19 / r12;
        long r112 = r19 - (r12 * r111);
        long r113 = 10;
        if (r111 >= r113) goto L53;
        r28.append(DataType.FALSE);
    L53:
        r28.append(r111);
        r28.append(":");
        if (r112 >= r113) goto L56;
        r28.append(DataType.FALSE);
    L56:
        r28.append(r112);
        r26.setText(r28.toString());
        this.g.setVisibility(0);
        this.d.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        b6(r19, r4);
        goto L60
    L44:
        if ((r24 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.d) != true) goto L46;
        r25 = true;
    L49:
        r110 = 2131920609;
        goto L50
    L39:
        r23 = false;
    L58:
        if (r19 > 0) goto L60;
        this.b.setText(s1.B(2131920617));
        this.d.setText(s1.B(2131920618));
        this.c.setVisibility(4);
        this.g.setVisibility(0);
        goto L60
    L5:
        r6 = false;
        goto L7
    }

    public final void b6(long r7, int r9) {
        com.bytedance.android.live.revlink.impl.multianchor.match.c r0 = getMatchStatus();
        if (r0 == null) goto L5;
        boolean r1 = r0.c;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        long r2 = r9;
        if (1 > r7) goto L15;
        if (r2 <= r7) goto L15;
        this.g.setVisibility(8);
    L15:
        if (r7 > 0) goto L18;
        this.b.setText(s1.B(2131920617));
        this.d.setText(s1.B(2131920618));
        this.c.setVisibility(4);
        this.g.setVisibility(0);
        return;
    L18:
        return;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiAnchorRandomView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131566334, this);
        this.a = r5;
        this.b = (TextView) r5.findViewById(2131379709);
        this.c = (TextView) r5.findViewById(2131379711);
        this.d = (TextView) r5.findViewById(2131379707);
        this.e = (TextView) r5.findViewById(2131379678);
        this.f = (TextView) r5.findViewById(2131379679);
        this.g = (TextView) r5.findViewById(2131379706);
        this.h = s1.m(2131251259);
        this.i = true;
    }

    public /* synthetic */ MultiAnchorRandomView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
