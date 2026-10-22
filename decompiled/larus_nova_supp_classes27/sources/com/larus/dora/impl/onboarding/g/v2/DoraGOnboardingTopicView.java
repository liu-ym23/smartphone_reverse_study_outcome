package com.larus.dora.impl.onboarding.g.v2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.settings.DoraSetting;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0014\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010'\u001a\u00020%J\f\u0010)\u001a\u00020%*\u00020*H\u0002J\b\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020%H\u0002J\f\u0010-\u001a\u00020%*\u00020*H\u0002J\u001c\u0010.\u001a\u00020%*\u00020*2\u0006\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u00020\nH\u0002J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\nH\u0016J\b\u00103\u001a\u00020%H\u0014J\b\u00104\u001a\u00020%H\u0014R&\u0010\f\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011¨\u00066"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/DoraGOnboardingTopicView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "offlineTopicList", "", "", "Lkotlin/jvm/internal/EnhancedNullability;", "getOfflineTopicList", "()Ljava/util/List;", "offlineTopicList$delegate", "Lkotlin/Lazy;", "data", "itemScale", "", "itemSpace", "itemMinHeight", "paddingHorizontal", "topChildIndex", "isScrolling", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "loopJob", "Lkotlinx/coroutines/Job;", "backgroundView", "Landroid/view/View;", "contentView", "setTopicList", "", "queryTopicFromSettings", "refreshTopics", "getQueryTopicFromSettings", "addAllChildView", "Landroid/view/ViewGroup;", "startScroll", "stopScroll", "scrollToNext", "endAction", "topChildView", "nextChildViewIndex", "setVisibility", "visibility", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingTopicView extends FrameLayout {
    public static final /* synthetic */ int n = 0;
    public final Lazy a;
    public List<String> b;
    public final float c;
    public final int d;
    public final int e;
    public final int f;
    public int g;
    public boolean h;
    public final CoroutineScope i;
    public Job j;
    public final View k;
    public final FrameLayout l;
    public final List<String> m;

    public static final class a {
    }

    public static final class b implements View.OnLayoutChangeListener {
        public final /* synthetic */ DoraGOnboardingTopicView a;

        public b(DoraGOnboardingTopicView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            View r10 = this.a.l.getChildAt(0);
            if (r10 == null) goto L10;
            View r11 = this.a.k;
            ViewGroup.LayoutParams r12 = r11.getLayoutParams();
            if (r12 == null) goto L7;
            r12.height = (int) (r10.getHeight() * this.a.c);
            r12.width = (int) (r10.getWidth() * this.a.c);
        L8:
            r11.setLayoutParams(r12);
            return;
        L7:
            r12 = null;
            goto L8
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public final /* synthetic */ DoraGOnboardingTopicView a;

        public c(DoraGOnboardingTopicView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            View r10 = this.a.l.getChildAt(0);
            if (r10 == null) goto L10;
            View r11 = this.a.k;
            ViewGroup.LayoutParams r12 = r11.getLayoutParams();
            if (r12 == null) goto L7;
            r12.height = (int) (r10.getHeight() * this.a.c);
            r12.width = (int) (r10.getWidth() * this.a.c);
        L8:
            r11.setLayoutParams(r12);
            return;
        L7:
            r12 = null;
            goto L8
        }
    }

    public static final class d implements View.OnLayoutChangeListener {
        public final /* synthetic */ DoraGOnboardingTopicView a;

        public d(DoraGOnboardingTopicView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            r1.removeOnLayoutChangeListener(this);
            View r10 = this.a.l.getChildAt(0);
            if (r10 == null) goto L10;
            View r11 = this.a.k;
            ViewGroup.LayoutParams r12 = r11.getLayoutParams();
            if (r12 == null) goto L7;
            r12.height = (int) (r10.getHeight() * this.a.c);
            r12.width = (int) (r10.getWidth() * this.a.c);
        L8:
            r11.setLayoutParams(r12);
            return;
        L7:
            r12 = null;
            goto L8
        }
    }

    static {
    }

    private final List<String> getOfflineTopicList() {
        return (List) this.a.getValue();
    }

    public final void c() {
        Job r0 = this.j;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L10;
        g49.d.d("DoraOnboardingTopicView", "startScroll: loopJob is active");
        return;
    L10:
        this.j = BuildersKt.launch$default(this.i, null, null, new DoraGOnboardingTopicView$startScroll$1(this, null), 3, null);
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() != 0) goto L6;
        c();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r0 = this.j;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    public final List<String> getQueryTopicFromSettings() {
        return this.m;
    }

    public DoraGOnboardingTopicView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.a = LazyKt.lazy(new z(this));
        this.b = getOfflineTopicList();
        this.c = 1.1f;
        this.d = i5.h();
        this.e = i5.X();
        int r6 = (int) ((com.larus.utils.i.d(getContext()) * 0.33600003f) / 2);
        this.f = r6;
        this.i = CoroutineScopeKt.MainScope();
        setClipChildren(false);
        setClipToPadding(false);
        setPadding(r6, 0, r6, 0);
        View r7 = new View(getContext());
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 1;
        r7.setLayoutParams(r1);
        r7.setBackground(ContextCompat.getDrawable(r7.getContext(), com.larus.dora.impl.util.u.a.a("larus_dora_g_onboarding_query_topic_highlight_bg")));
        this.k = r7;
        addView(r7);
        FrameLayout r8 = new FrameLayout(getContext());
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        b(r8);
        this.l = r8;
        addView(r8);
        addOnLayoutChangeListener(new b(this));
        DoraSetting.a.getClass();
        List<String> r9 = DoraSetting.d();
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        this.m = r9;
    }

    public static List a(DoraGOnboardingTopicView r3) {
        return CollectionsKt.listOf(new String[]{r3.getContext().getResources().getString(2131902773), r3.getContext().getResources().getString(2131902774), r3.getContext().getResources().getString(2131902775), r3.getContext().getResources().getString(2131902777), r3.getContext().getResources().getString(2131902778), r3.getContext().getResources().getString(2131902779), r3.getContext().getResources().getString(2131902780)});
    }

    public final void b(ViewGroup r12) {
        r12.removeAllViews();
        int r0 = ((com.larus.utils.i.c(r12.getContext()) - ((Number) i5.O1.getValue()).intValue()) / (this.e + this.d)) + 2;
        g49.d.d("DoraOnboardingTopicView", "#####maxChildCount=" + r0);
        int r2 = com.larus.utils.i.d(r12.getContext()) - (this.f * 2);
        float r4 = 0.0f;
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L9;
        TextView r6 = new TextView(r12.getContext());
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 1;
        r6.setLayoutParams(r7);
        r6.setMaxLines(2);
        r6.setEllipsize(TextUtils.TruncateAt.END);
        r6.setTextSize(15.0f);
        r6.setMinHeight(this.e);
        r6.setGravity(17);
        List<String> r8 = this.b;
        r6.setText((CharSequence) ListProtector.get(r8, r5 % r8.size()));
        r6.setTextColor(ContextCompat.getColor(r6.getContext(), v19.c.b(2130972079, r6.getContext(), 2131103136)));
        r6.setTag(Integer.valueOf(r5 % this.b.size()));
        r6.setPaddingRelative(i5.q(), i5.h(), i5.q(), i5.h());
        r6.measure(View.MeasureSpec.makeMeasureSpec(r2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r9 = r6.getMeasuredHeight();
        if (r5 != 0) goto L7;
        r6.setScaleX(this.c);
        r6.setScaleY(this.c);
        float r10 = r9;
        r6.setTranslationY(((this.c * r10) - r10) / 2.0f);
        float r11 = (r10 * this.c) + this.d;
    L8:
        r4 = r4 + r11;
        r12.addView(r6);
        r5 = r5 + 1;
        goto L3
    L7:
        r6.setTranslationY(r4);
        r11 = r9 + this.d;
        goto L8
    }

    public final void setTopicList(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "queryTopicFromSettings");
        if (r5.size() > 6) goto L5;
        r5 = CollectionsKt.plus(r5, getOfflineTopicList());
    L5:
        Iterator<String> r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        g49.d.d("DoraOnboardingTopicView", "DoraOnboardingTopicView: queryTopic=" + r0.next());
        goto L7
    L9:
        this.b = r5;
        Job r6 = this.j;
        if (r6 == null) goto L12;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L12:
        b(this.l);
        this.g = 0;
        this.h = false;
        if (getVisibility() != 0) goto L17;
        c();
        return;
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        c();
        return;
    L5:
        Job r4 = this.j;
        if (r4 == null) goto L10;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        return;
    }

    public DoraGOnboardingTopicView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        this.a = LazyKt.lazy(new z(this));
        this.b = getOfflineTopicList();
        this.c = 1.1f;
        this.d = i5.h();
        this.e = i5.X();
        int r6 = (int) ((com.larus.utils.i.d(getContext()) * 0.33600003f) / 2);
        this.f = r6;
        this.i = CoroutineScopeKt.MainScope();
        setClipChildren(false);
        setClipToPadding(false);
        setPadding(r6, 0, r6, 0);
        View r7 = new View(getContext());
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 1;
        r7.setLayoutParams(r0);
        r7.setBackground(ContextCompat.getDrawable(r7.getContext(), com.larus.dora.impl.util.u.a.a("larus_dora_g_onboarding_query_topic_highlight_bg")));
        this.k = r7;
        addView(r7);
        FrameLayout r8 = new FrameLayout(getContext());
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r8.setClipChildren(false);
        r8.setClipToPadding(false);
        b(r8);
        this.l = r8;
        addView(r8);
        addOnLayoutChangeListener(new c(this));
        DoraSetting.a.getClass();
        List<String> r9 = DoraSetting.d();
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        this.m = r9;
    }

    public DoraGOnboardingTopicView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = LazyKt.lazy(new z(this));
        this.b = getOfflineTopicList();
        this.c = 1.1f;
        this.d = i5.h();
        this.e = i5.X();
        int r6 = (int) ((com.larus.utils.i.d(getContext()) * 0.33600003f) / 2);
        this.f = r6;
        this.i = CoroutineScopeKt.MainScope();
        setClipChildren(false);
        setClipToPadding(false);
        setPadding(r6, 0, r6, 0);
        View r7 = new View(getContext());
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, -2);
        r8.gravity = 1;
        r7.setLayoutParams(r8);
        r7.setBackground(ContextCompat.getDrawable(r7.getContext(), com.larus.dora.impl.util.u.a.a("larus_dora_g_onboarding_query_topic_highlight_bg")));
        this.k = r7;
        addView(r7);
        FrameLayout r9 = new FrameLayout(getContext());
        r9.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r9.setClipChildren(false);
        r9.setClipToPadding(false);
        b(r9);
        this.l = r9;
        addView(r9);
        addOnLayoutChangeListener(new d(this));
        DoraSetting.a.getClass();
        List<String> r10 = DoraSetting.d();
        if (r10 != null) goto L5;
        r10 = CollectionsKt.emptyList();
    L5:
        this.m = r10;
    }
}
