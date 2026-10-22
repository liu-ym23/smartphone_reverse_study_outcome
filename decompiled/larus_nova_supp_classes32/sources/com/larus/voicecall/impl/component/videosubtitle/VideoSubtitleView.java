package com.larus.voicecall.impl.component.videosubtitle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.audio.call.subtitle.DisplayType;
import com.larus.voicecall.impl.databinding.ViewVideoSubtitleBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\u00020\u0001:\u0001NB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0014J&\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000eJ\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u000eH\u0002J\u0018\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH\u0002J \u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010)\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH\u0002J \u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020-2\u0006\u00102\u001a\u00020\tH\u0002J\u0018\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\tH\u0002J\b\u00107\u001a\u00020\tH\u0002J\u0010\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u0016H\u0002J\u000e\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020$J\u0006\u0010>\u001a\u00020\u001cJ\u0006\u0010?\u001a\u00020\u001cJ\b\u0010@\u001a\u00020\u001cH\u0002J\b\u0010A\u001a\u00020\u001cH\u0002J\b\u0010B\u001a\u00020\u001cH\u0002J\b\u0010C\u001a\u00020\u001cH\u0002J\u0016\u0010D\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0EH\u0002J\b\u0010F\u001a\u00020\u000eH\u0002J\f\u0010G\u001a\u00020\u0016*\u00020\u000bH\u0002J\f\u0010H\u001a\u00020\u0016*\u00020\u000bH\u0002J\u0013\u0010I\u001a\u0004\u0018\u00010\u0016*\u00020\u000bH\u0002¢\u0006\u0002\u0010JJ\u001b\u0010K\u001a\u00020\u001c*\u00020\u000b2\b\u0010L\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010MR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/larus/voicecall/impl/component/videosubtitle/VideoSubtitleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lastSubtitleIndex", NameKeys.UnloadStrategy_No_Strategy, "lastSubtitleData", "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "subtitleStartOffset", "subtitlePrefixLine", NameKeys.UnloadStrategy_No_Strategy, "binding", "Lcom/larus/voicecall/impl/databinding/ViewVideoSubtitleBinding;", "currentTranslateAnim", "Landroid/view/ViewPropertyAnimator;", "thinkingDotAnimator", "Landroid/animation/ObjectAnimator;", "lastScrollEndTime", NameKeys.UnloadStrategy_No_Strategy, "textTranslationAnimListener", "Landroid/animation/AnimatorListenerAdapter;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onVisibilityChanged", NameKeys.UnloadStrategy_No_Strategy, "changedView", "Landroid/view/View;", "visibility", "updateSubtitle", LynxResourceModule.DATA_KEY, "index", "append", NameKeys.UnloadStrategy_No_Strategy, "reason", "scrollToEnd", "checkToScrollNextLine", "calculateTranslationOffset", "topLineIndex", "offsetLineCount", "moveToNextLine", "layout", "Landroid/text/Layout;", "bottomLineIndex", "calcStayDuration", "textView", "Landroid/widget/TextView;", "currentBottomLineIndex", "createAnimator", "offsetY", "stayDuration", "getCurrentTopLineIndex", "getCurrentBottomLineIndex", "calcDuration", "lineText", "calcTextOffset", "duration", "showThinking", "breakSubtitle", "pauseSubtitle", "resumeSubtitle", "resetTextView", "resetScrollAnim", "resetScrollValue", "resetThinkingAnim", "resetSubtitleData", "Lkotlin/Pair;", "getLastLineText", "getPausedDuration", "updatePausedDuration", "getPauseStartTime", "(Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;)Ljava/lang/Long;", "setPauseStartTime", "pauseStartTime", "(Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;Ljava/lang/Long;)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoSubtitleView extends ConstraintLayout {
    public static final /* synthetic */ int k = 0;
    public int a;
    public com.larus.voicecall.impl.subtitle.c b;
    public int c;
    public String d;
    public final ViewVideoSubtitleBinding e;
    public ViewPropertyAnimator f;
    public ObjectAnimator g;
    public long h;
    public final b i;
    public final i j;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ VideoSubtitleView b;

        public b(VideoSubtitleView r1) {
            this.b = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            this.a = true;
            this.b.f = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            int r4 = c68.b.a;
            c68.b.d("VideoSubtitleView", "onAnimationEnd: canceled: " + this.a + ", translationY: " + this.b.e.c.getTranslationY());
            if (this.a == false) goto L5;
            return;
        L5:
            VideoSubtitleView r5 = this.b;
            r5.f = null;
            r5.h = System.currentTimeMillis();
            this.b.R5("scroll_end");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            this.a = false;
        }
    }

    static {
    }

    private final int getCurrentTopLineIndex() {
        Layout r0 = this.e.c.getLayout();
        if (r0 != null) goto L5;
        return 0;
    L5:
        float r2 = -this.e.c.getTranslationY();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r2) goto L11;
        if (r4 >= r0.getLineCount()) goto L11;
        r4 = r4 + 1;
        r3 = r0.getLineTop(r4) - r0.getLineTop(0);
    L11:
        return r4;
    }

    private final String getLastLineText() {
        Layout r0 = this.e.c.getLayout();
        if (r0 != null) goto L5;
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        int r2 = r0.getLineCount() - 1;
    L6:
        if (r2 < 0) goto L11;
        String r3 = this.e.c.getText().subSequence(r0.getLineStart(r2), r0.getLineEnd(r2)).toString();
        if (StringsKt.isBlank(r3) == false) goto L10;
        r2 = r2 - 1;
        goto L6
    L10:
        return r3;
    L11:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final void V5() {
        ViewPropertyAnimator r0 = this.f;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.f = null;
    }

    public final void Y5() {
        ObjectAnimator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.g = null;
        this.e.d.setVisibility(8);
    }

    public final void Z5() {
        com.larus.voicecall.impl.subtitle.c r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        Long r1 = T5(r0);
        if (r1 == null) goto L8;
        long r6 = U5(r0) + (System.currentTimeMillis() - r1.longValue());
        r0.k.put("pause_duration", Long.valueOf(r6));
    L9:
        r0.k.put("pause_start_time", null);
        if (r6 <= 0) goto L12;
        Pair r2 = TuplesKt.to(this.b, Integer.valueOf(this.a));
        this.b = null;
        this.a = -1;
        i6(r0, ((Number) r2.component2()).intValue(), false, "resume");
    L12:
        int r3 = c68.b.a;
        c68.b.d("VideoSubtitleView", "resumeSubtitle, pausedDuration:" + r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }

    private final int getCurrentBottomLineIndex() {
        int r0 = getCurrentTopLineIndex();
        if (r0 >= 0) goto L5;
        return r0;
    L5:
        Layout r1 = this.e.c.getLayout();
        int r2 = 0;
        if (r1 != null) goto L8;
        return 0;
    L8:
        int r3 = r1.getLineTop(r0);
        int r4 = (this.e.b.getHeight() - this.e.b.getPaddingTop()) - this.e.b.getPaddingBottom();
        int r5 = 0;
    L9:
        if (r2 >= r4) goto L14;
        if ((r0 + r5) >= r1.getLineCount()) goto L14;
        r5 = r5 + 1;
        r2 = r1.getLineBottom((r0 + r5) - 1) - r3;
    L14:
        return (r0 + r5) - 1;
    }

    public VideoSubtitleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static Long T5(com.larus.voicecall.impl.subtitle.c r1) {
        Object r2 = ((LinkedHashMap) r1.k).get("pause_start_time");
        if ((r2 instanceof Long) == true) goto L7;
        return null;
    L7:
        return (Long) r2;
    }

    public static long U5(com.larus.voicecall.impl.subtitle.c r2) {
        Object r3 = ((LinkedHashMap) r2.k).get("pause_duration");
        if ((r3 instanceof Long) == false) goto L5;
        Long r4 = (Long) r3;
    L6:
        if (r4 != null) goto L10;
        return 0;
    L10:
        return r4.longValue();
    L5:
        r4 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(String r20) {
        if (this.f == null) goto L6;
        return;
    L6:
        if (getVisibility() == 0) goto L8;
        return;
    L8:
        Layout r2 = this.e.c.getLayout();
        if (r2 != null) goto L11;
        return;
    L11:
        int r3 = getCurrentTopLineIndex();
        int r4 = getCurrentBottomLineIndex();
        int r5 = r2.getLineCount();
        int r6 = r5 - 1;
        if (r4 < r6) goto L14;
        int r7 = c68.b.a;
        c68.b.d("VideoSubtitleView", "moveToNextLine, topLineIndex: " + r3 + ", bottomLine: " + r4 + ", already scroll to last line or no need to scroll, return");
        int r8 = 0;
    L22:
        if (r8 != 0) goto L25;
        c68.b.d("VideoSubtitleView", "checkToScrollNextLine: " + r20 + ", bottomLine: " + r4 + ", no next line, return");
        return;
    L25:
        Layout r9 = this.e.c.getLayout();
        if (r9 != null) goto L28;
        int r10 = 0;
    L29:
        AppCompatTextView r11 = this.e.c;
        if (r11.getTranslationY() != 0.0f) goto L32;
        boolean r12 = true;
    L33:
        if (r12 == true) goto L35;
        int r15 = r8;
        String r16 = "checkToScrollNextLine: ";
        int r13 = r2.getLineStart(r4);
        CharSequence r14 = StringsKt.trim(r11.getText().subSequence(r13, r2.getLineEnd(r4)));
        if ((true ^ StringsKt.isBlank(r14)) == false) goto L47;
        String r17 = r14.toString();
    L48:
        int r18 = StringsKt.trim(r17).toString().length();
        long r19 = (long) (((double) (r18 * 1000)) / 4.5d);
        c68.b.d("VideoSubtitleView", "calcDuration: lineText: " + r17 + ", readableLen: " + r18 + ", duration: " + r19);
        int r21 = r15;
        if (this.h != 0) goto L51;
        long r110 = 0;
    L52:
        c68.b.d("VideoSubtitleView", "calcStayDuration, firstScroll: " + r12 + ", stayText: " + r17 + ", stayDuration: " + r19 + ", alreadyStayDuration: " + r110);
        long r22 = Math.max(0, r19 - r110);
        c68.b.d("VideoSubtitleView", r16 + r20 + ", bottomLineIndex: " + r4 + ", nextLineIndex: " + (r4 + r21) + ", offsetTranslation: " + r10 + ", stayDuration: " + r22);
        ViewPropertyAnimator r1 = S5(r10, r22);
        r1.start();
        this.f = r1;
        return;
    L51:
        r110 = System.currentTimeMillis() - this.h;
        goto L52
    L47:
        int r23 = r2.getLineStart(r4 - 1);
        r17 = r11.getText().subSequence(r23, (r13 + r23) / 2).toString();
        goto L48
    L35:
        if (this.d.length() <= 0) goto L37;
        boolean r111 = true;
    L38:
        if (r111 == false) goto L40;
        r17 = NameKeys.UnloadStrategy_No_Strategy;
    L42:
        r15 = r8;
        r16 = "checkToScrollNextLine: ";
        goto L48
    L40:
        if (r4 != 0) goto L43;
        r17 = r11.getText().subSequence(0, r2.getLineEnd(r4)).toString();
        goto L42
    L43:
        r15 = r8;
        r16 = "checkToScrollNextLine: ";
        r17 = r11.getText().subSequence(0, (int) Math.max(((double) r2.getLineEnd(0)) + (((double) (r2.getLineEnd(1) - r2.getLineStart(1))) * 0.2d), ((double) r2.getLineEnd(r4)) * 0.5d)).toString();
        goto L48
    L37:
        r111 = false;
        goto L38
    L32:
        r12 = false;
        goto L33
    L28:
        r10 = r9.getLineTop(r8 + r3) - r9.getLineTop(r3);
        goto L29
    L14:
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = 1;
    L15:
        int r113 = Integer.valueOf(r112.element + r3).intValue();
        if (StringsKt.isBlank(StringsKt.trim(this.e.c.getText().subSequence(r2.getLineStart(r113), r2.getLineEnd(r113)))) == false) goto L20;
        if (Integer.valueOf(r112.element + r4).intValue() >= r6) goto L20;
        r112.element++;
    L20:
        int r24 = c68.b.a;
        c68.b.d("VideoSubtitleView", "moveToNextLine, topLineIndex: " + r3 + ", bottomLineIndex: " + r4 + ", offsetCount: " + r112.element + ", lineCount: " + r5);
        r8 = r112.element;
        goto L22
    }

    public final long b6(String r12) {
        Intrinsics.checkNotNullParameter(r12, "reason");
        V5();
        Layout r0 = this.e.c.getLayout();
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r3 = getCurrentTopLineIndex();
        int r4 = getCurrentBottomLineIndex();
        int r1 = r0.getLineCount() - 1;
        if (r4 < r1) goto L9;
        int r2 = c68.b.a;
        c68.b.d("VideoSubtitleView", "scrollToEnd: " + r12 + ", topLineIndex: " + r3 + ", bottomLine: " + r4 + ", already scroll to last line or no need to scroll, return");
        return 0;
    L9:
        int r5 = r1 - r4;
        Layout r9 = this.e.c.getLayout();
        if (r9 != null) goto L12;
        int r10 = 0;
    L13:
        int r11 = c68.b.a;
        c68.b.d("VideoSubtitleView", "scrollToEnd: " + r12 + ", topLineIndex: " + r3 + ", bottomLine: " + r4 + ", offsetLineCount: " + r5);
        ViewPropertyAnimator r13 = S5(r10, 0);
        r13.start();
        this.f = r13;
        return 100;
    L12:
        r10 = r9.getLineTop(r5 + r3) - r9.getLineTop(r3);
        goto L13
    }

    public final void c6(boolean r5) {
        int r0 = c68.b.a;
        c68.b.d("VideoSubtitleView", "showThinking, breakSubtitle: " + r5);
        if (r5 == false) goto L6;
        this.e.c.setText(NameKeys.UnloadStrategy_No_Strategy);
        V5();
        this.e.c.setTranslationY(0.0f);
    L6:
        if (StringsKt.isBlank(this.e.c.getText()) == false) goto L8;
        this.e.c.setText(" ");
        long r1 = 0;
    L9:
        this.e.d.setVisibility(0);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.e.d, ViewGroup.ALPHA, new float[]{1.0f, 0.0f, 1.0f}).setDuration(1500);
        r6.setInterpolator(new LinearInterpolator());
        r6.setRepeatCount(-1);
        r6.setRepeatMode(1);
        r6.setStartDelay(r1);
        r6.start();
        this.g = r6;
        return;
    L8:
        this.e.c.append("\n");
        r1 = b6("think");
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.voicecall.impl.component.videosubtitle.i] */
    public VideoSubtitleView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.a = -1;
        this.d = NameKeys.UnloadStrategy_No_Strategy;
        this.i = new b(this);
        this.j = new i(this);
        ViewGroup.inflate(r3, 2131568210, this);
        int r5 = 2131387640;
        VideoSubtitleContainer r6 = (VideoSubtitleContainer) ViewBindings.findChildViewById(this, 2131387640);
        if (r6 == null) goto L11;
        r5 = 2131387644;
        AppCompatTextView r0 = ViewBindings.findChildViewById(this, 2131387644);
        if (r0 == null) goto L11;
        r5 = 2131387645;
        AppCompatTextView r1 = ViewBindings.findChildViewById(this, 2131387645);
        if (r1 == null) goto L11;
        this.e = new ViewVideoSubtitleBinding(this, r6, r0, r1);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public final ViewPropertyAnimator S5(int r5, long r6) {
        float r0 = this.e.c.getTranslationY();
        float r1 = r0 - r5;
        int r2 = c68.b.a;
        c68.b.d("VideoSubtitleView", "createAnimator: startTranslationY: " + r0 + ", endTranslationY: " + r1 + ", offsetY: " + r5 + ", stayDuration: " + r6);
        return this.e.c.animate().translationY(r1).setInterpolator(new LinearInterpolator()).setDuration(100).setStartDelay(r6).setListener(this.i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "changedView");
        super/*android.view.ViewGroup*/.onVisibilityChanged(r3, r4);
        if (Intrinsics.areEqual(r3, this) == false) goto L12;
        int r5 = c68.b.a;
        c68.b.d("VideoSubtitleView", "onVisibilityChanged: " + r4);
        if (r4 != 0) goto L10;
        this.e.c.addOnLayoutChangeListener(this.j);
        Pair r6 = TuplesKt.to(this.b, Integer.valueOf(this.a));
        this.b = null;
        this.a = -1;
        com.larus.voicecall.impl.subtitle.c r0 = (com.larus.voicecall.impl.subtitle.c) r6.component1();
        int r7 = ((Number) r6.component2()).intValue();
        if (r0 == null) goto L13;
        if (r7 == (-1)) goto L14;
        i6(r0, r7, false, LynxUIOverlay.PROP_VISIBLE);
        return;
    L14:
        return;
    L13:
        return;
    L10:
        this.e.c.removeOnLayoutChangeListener(this.j);
        this.e.c.setText(NameKeys.UnloadStrategy_No_Strategy);
        V5();
        this.e.c.setTranslationY(0.0f);
        Y5();
        return;
    }

    public final void i6(com.larus.voicecall.impl.subtitle.c r18, int r19, boolean r20, String r21) {
        Intrinsics.checkNotNullParameter(r18, LynxResourceModule.DATA_KEY);
        Intrinsics.checkNotNullParameter(r21, "reason");
        DisplayType r4 = r18.c;
        DisplayType r5 = DisplayType.REPLY_BLOCK;
        if (r4 != r5) goto L11;
        com.larus.voicecall.impl.subtitle.c r6 = this.b;
        if (r6 == null) goto L17;
        String r7 = r6.d;
        if (r7 == null) goto L17;
        String r8 = StringsKt.trim(r7).toString();
        if (r8 == null) goto L17;
    L19:
        if (r18.c != r5) goto L25;
        String r9 = r18.d;
        if (r9 == null) goto L24;
        String r10 = StringsKt.trim(r9).toString();
        if (r10 == null) goto L24;
    L27:
        if (r19 != this.a) goto L32;
        if (Intrinsics.areEqual(r10, r8) == false) goto L32;
        return;
    L32:
        if (r19 == this.a) goto L51;
        if (r20 == false) goto L51;
        if (r8.length() <= 0) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == false) goto L51;
        if (U5(r18) != 0) goto L51;
        if (T5(r18) != null) goto L51;
        V5();
        this.e.c.setTranslationY(0.0f);
        this.h = System.currentTimeMillis();
        String r3 = StringsKt.trimEnd(getLastLineText()).toString();
        this.d = r3;
        if (r3.length() <= 0) goto L46;
        boolean r12 = true;
    L47:
        if (r12 == false) goto L49;
        this.d += '\n';
    L49:
        this.c = 0;
        CharSequence r13 = this.d + r10;
    L66:
        this.e.c.setText(r13);
        this.a = r19;
        this.b = r18;
        if (r13.length() <= 0) goto L69;
        boolean r14 = true;
    L70:
        if (r14 == false) goto L73;
        Y5();
        return;
    L73:
        return;
    L69:
        r14 = false;
        goto L70
    L46:
        r12 = false;
        goto L47
    L37:
        r11 = false;
    L51:
        if (r19 == this.a) goto L53;
    L57:
        V5();
        this.e.c.setTranslationY(0.0f);
        this.h = System.currentTimeMillis();
        this.d = NameKeys.UnloadStrategy_No_Strategy;
        long r15 = U5(r18);
        Long r16 = T5(r18);
        if (r16 == null) goto L60;
        long r17 = r16.longValue();
    L62:
        if (r17 <= 0) goto L64;
        long r110 = r17;
    L65:
        String r111 = r10;
        int r22 = (int) (((((r110 - r18.e) - r15) - ((long) (-200))) * 4.5d) / ((double) 1000));
        this.c = r22;
        this.c = Math.max(0, Math.min(r22, r111.length()));
        int r23 = c68.b.a;
        c68.b.d("VideoSubtitleView", "updateSubtitle: " + r21 + ", index: " + r19 + ", pausedDuration: " + r15 + ", pauseStartTime: " + r17 + ", readTs: " + r110 + ", subtitleStartOffset: " + this.c + ", trimedContent: " + r111);
        r13 = r111.subSequence(this.c, r111.length());
        goto L66
    L64:
        r110 = System.currentTimeMillis();
        goto L65
    L60:
        r17 = 0;
        goto L62
    L53:
        if (StringsKt.startsWith$default(r10, r8, false, 2, null) == false) goto L57;
        r13 = this.d + r10.subSequence(this.c, r10.length());
    L24:
        r10 = NameKeys.UnloadStrategy_No_Strategy;
        goto L27
    L25:
        r10 = StringsKt.trim(r18.a).toString();
    L17:
        r8 = NameKeys.UnloadStrategy_No_Strategy;
        goto L19
    L11:
        com.larus.voicecall.impl.subtitle.c r24 = this.b;
        if (r24 == null) goto L17;
        String r25 = r24.a;
        if (r25 == null) goto L17;
        r8 = StringsKt.trim(r25).toString();
        if (r8 != null) goto L19;
        goto L17
    }
}
