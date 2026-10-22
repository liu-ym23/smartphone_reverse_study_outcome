package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginConstants;
import com.ss.android.lark.keyboard.plugin.tool.voice.widget.SmartTabLayout;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0011J*\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020.2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tJ\b\u0010:\u001a\u00020;H\u0002J\u001e\u0010<\u001a\u00020\u000b2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>2\u0006\u0010@\u001a\u00020\nH\u0002R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0017\u001a\u0004\b(\u0010%R\u001b\u0010*\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b+\u0010%R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPanelContainer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mOnTabChanged", "Lkotlin/Function1;", "", "", "mIndexMap", "", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mViewModel", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioViewModel;", "longPressRunnable", "Ljava/lang/Runnable;", "getLongPressRunnable", "()Ljava/lang/Runnable;", "longPressRunnable$delegate", "Lkotlin/Lazy;", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "getMViewPager", "()Landroidx/viewpager/widget/ViewPager;", "mViewPager$delegate", "mSmartTabLayout", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/widget/SmartTabLayout;", "getMSmartTabLayout", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/widget/SmartTabLayout;", "mSmartTabLayout$delegate", "mRecordInnerView", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPanelInnerView;", "getMRecordInnerView", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPanelInnerView;", "mRecordInnerView$delegate", "mRecognizeInnerView", "getMRecognizeInnerView", "mRecognizeInnerView$delegate", "mWithTextInnerView", "getMWithTextInnerView", "mWithTextInnerView$delegate", "isSingleClick", "", "downX", "", "downY", "onDownFeature", "setControllerAndViewModel", "controller", "viewModel", "setPanelTab", "audio2TextEnabled", "audioWithTextEnabled", "onTabChangedCallback", "getViewPagerOnTouchListener", "Landroid/view/View$OnTouchListener;", "onTabSelect", "tabViews", "", "Landroid/view/View;", "position", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AudioPanelContainer extends ConstraintLayout {
    public Function1<? super Integer, Unit> a;
    public final Map<Integer, Integer> b;
    public h c;
    public AudioViewModel d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public boolean k;
    public float l;
    public float m;
    public int n;

    public static final class a implements View.OnTouchListener {
        public final /* synthetic */ AudioPanelContainer a;

        public a(AudioPanelContainer r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r15v3, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelContainer] */
        /* JADX WARN: Type inference failed for: r15v4, types: [android.view.ViewGroup, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelContainer] */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r14, MotionEvent r15) {
            if (r15 != null) goto L5;
            return false;
        L5:
            float r0 = r15.getRawX();
            float r1 = r15.getRawY();
            int r16 = r15.getAction();
            if (r16 == 0) goto L40;
            if (r16 != 1) goto L41;
            ?? r17 = this.a;
            r17.removeCallbacks(AudioPanelContainer.R5(r17));
            AudioPanelContainer r18 = this.a;
            if (r18.n == AudioPanelContainer.T5(r18).getCurrentItem()) goto L12;
            boolean r19 = true;
        L13:
            if (r19 == true) goto L39;
            AudioPanelContainer r110 = this.a;
            if (r110.k == false) goto L39;
            int r3 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
            float r4 = r110.l;
            float r111 = r110.m;
            if (r4 > 0.0f) goto L20;
        L24:
            boolean r112 = false;
        L25:
            if (r112 == false) goto L27;
            return false;
        L27:
            List<View> r113 = AudioPanelContainer.S5(this.a).getTabs();
            AudioPanelContainer r5 = this.a;
            Iterator<T> r114 = r113.iterator();
            int r6 = 0;
        L29:
            if (r114.hasNext() == false) goto L41;
            Object r7 = r114.next();
            int r8 = r6 + 1;
            if (r6 >= 0) goto L33;
            CollectionsKt.throwIndexOverflow();
        L33:
            View r9 = (View) r7;
            if (r6 == r5.n) goto L38;
            int[] r10 = new int[2];
            r9.getLocationOnScreen(r10);
            int r11 = r10[0];
            if (new Rect(r11, r10[1], r9.getMeasuredWidth() + r11, r10[1] + r9.getMeasuredHeight()).contains((int) r0, (int) r1) == false) goto L38;
            AudioPanelContainer.T5(r5).setCurrentItem(r6);
        L38:
            r6 = r8;
            goto L29
        L20:
            if (r111 <= 0.0f) goto L24;
            double r12 = 2;
            if (((float) Math.sqrt(((float) Math.pow(r0 - r4, r12)) + ((float) Math.pow(r1 - r111, r12)))) <= 20.0f) goto L24;
            Log.i("AudioPluginUtils", "moveTooFarOnTouchEvent");
            r112 = true;
        L39:
            return false;
        L12:
            r19 = false;
        L41:
            return false;
        L40:
            AudioPanelContainer r115 = this.a;
            r115.l = r0;
            r115.m = r1;
            r115.n = AudioPanelContainer.T5(r115).getCurrentItem();
            ?? r116 = this.a;
            r116.k = true;
            r116.postDelayed(AudioPanelContainer.R5(r116), 500);
            goto L41
        }
    }

    public static final class b implements SmartTabLayout.g {
        public final /* synthetic */ AudioPanelContainer a;
        public final /* synthetic */ List<View> b;

        public b(AudioPanelContainer r1, List<View> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.widget.SmartTabLayout.g
        public final View a(com.ss.android.lark.keyboard.plugin.tool.voice.widget.a r5, int r6, PagerAdapter r7) {
            Intrinsics.checkNotNullParameter(r5, "container");
            Intrinsics.checkNotNullParameter(r7, "adapter");
            int r0 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
            int r1 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.m(this.a, 12);
            TextView r2 = new TextView(r5.getContext());
            r2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
            r2.setText(r7.getPageTitle(r6));
            r2.setGravity(17);
            r2.setPadding(r1, 0, r1, 0);
            this.b.add(r2);
            return r2;
        }
    }

    private final Runnable getLongPressRunnable() {
        return (Runnable) this.e.getValue();
    }

    private final AudioPanelInnerView getMRecognizeInnerView() {
        return (AudioPanelInnerView) this.i.getValue();
    }

    private final AudioPanelInnerView getMRecordInnerView() {
        return (AudioPanelInnerView) this.h.getValue();
    }

    private final SmartTabLayout getMSmartTabLayout() {
        return (SmartTabLayout) this.g.getValue();
    }

    private final ViewPager getMViewPager() {
        return (ViewPager) this.f.getValue();
    }

    private final AudioPanelInnerView getMWithTextInnerView() {
        return (AudioPanelInnerView) this.j.getValue();
    }

    private final View.OnTouchListener getViewPagerOnTouchListener() {
        return new a(this);
    }

    public static final /* synthetic */ Runnable R5(AudioPanelContainer r0) {
        return r0.getLongPressRunnable();
    }

    public static final /* synthetic */ SmartTabLayout S5(AudioPanelContainer r0) {
        return r0.getMSmartTabLayout();
    }

    public static final /* synthetic */ ViewPager T5(AudioPanelContainer r0) {
        return r0.getMViewPager();
    }

    public AudioPanelContainer(final Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = new HashMap();
        this.e = LazyKt.lazy(new AudioPanelContainer$longPressRunnable$2(this));
        this.f = LazyKt.lazy(new AudioPanelContainer$mViewPager$2(this));
        this.g = LazyKt.lazy(new AudioPanelContainer$mSmartTabLayout$2(this));
        this.h = LazyKt.lazy(new AudioPanelContainer$mRecordInnerView$2(r2, this));
        this.i = LazyKt.lazy(new AudioPanelContainer$mRecognizeInnerView$2(r2, this));
        this.j = LazyKt.lazy(new AudioPanelContainer$mWithTextInnerView$2(r2, this));
        this.k = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U5(List<? extends View> r8, int r9) {
        int r0 = r8.size();
        if (r9 >= r0) goto L16;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L16;
        Object r4 = ListProtector.get(r8, r3);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.TextView");
        TextView r5 = (TextView) r4;
        if (r9 != r3) goto L9;
        int r6 = 1;
    L10:
        r5.setTypeface(null, r6);
        int r7 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        if (r6 == 0) goto L13;
        int r10 = 2131106622;
    L14:
        r5.setTextColor(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.c(this, r10));
        r3 = r3 + 1;
        goto L5
    L13:
        r10 = 2131106607;
        goto L14
    L9:
        r6 = 0;
    L16:
        if (this.a == null) goto L22;
        h r11 = this.c;
        if (r11 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mController");
        r11 = null;
    L20:
        int r12 = h.a;
        r11.a(null);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(boolean r6, boolean r7, Function1<? super Integer, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onTabChangedCallback");
        ArrayList r0 = new ArrayList();
        final ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        if (r7 == false) goto L5;
        r0.add(getMWithTextInnerView());
        int r9 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        r2.add(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f(this, 2131890421));
        ((HashMap) this.b).put(Integer.valueOf(r2.size() - 1), Integer.valueOf(AudioPluginConstants.b));
    L5:
        r0.add(getMRecordInnerView());
        int r10 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        r2.add(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f(this, 2131890412));
        ((HashMap) this.b).put(Integer.valueOf(r2.size() - 1), Integer.valueOf(AudioPluginConstants.c));
        if (r6 == false) goto L8;
        r0.add(getMRecognizeInnerView());
        r2.add(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f(this, 2131890347));
        ((HashMap) this.b).put(Integer.valueOf(r2.size() - 1), Integer.valueOf(AudioPluginConstants.d));
    L8:
        ViewPager r11 = getMViewPager();
        getContext();
        r11.setAdapter(new AudioPagerAdapter(r0, r2));
        getMSmartTabLayout().setOnPageChangeListener(new AudioPanelContainer$setPanelTab$1(this, r1));
        getMSmartTabLayout().setCustomTabView(new b(this, r1));
        getMSmartTabLayout().setViewPager(getMViewPager());
        this.a = r8;
        getMViewPager().setCurrentItem(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.e());
        U5(r1, getMViewPager().getCurrentItem());
        getMViewPager().setOnTouchListener(getViewPagerOnTouchListener());
    }
}
