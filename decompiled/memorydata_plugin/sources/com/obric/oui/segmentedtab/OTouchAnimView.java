package com.obric.oui.segmentedtab;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b \u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH&J\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animValue", "", "pressAnimator", "Landroid/animation/ValueAnimator;", "releaseAnimator", "canPerFormAnim", "", "cancelAnim", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "isAnimRunning", "onTouchAnimUpdate", "animFraction", MemoryInfoSectionEditActivity.KIND_SCENE, "", "startPressAnim", "startReleaseAnim", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OTouchAnimView extends RelativeLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14440b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14441a;
    private ValueAnimator c;
    private ValueAnimator d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "PRESS_ANIM_SCENE_PRESS", "", "PRESS_ANIM_SCENE_RELEASE", "TAG", "getAnimatedPressAlpha", "fraction", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final float a(float r2) {
            return 1 - (r2 * 0.5f);
        }
    }

    static {
        f14440b = new a(null);
    }

    public OTouchAnimView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTouchAnimView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OTouchAnimView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
    }

    public /* synthetic */ OTouchAnimView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private static final void a(OTouchAnimView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.f14441a = r5;
        r2.a(r5, "press_anim");
    }

    private final void b() {
        if (a() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.d;
        if (r0 == null) goto L9;
        r0.removeAllUpdateListeners();
    L9:
        ValueAnimator r1 = this.d;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        ValueAnimator r2 = this.c;
        if (r2 == null) goto L17;
        r2.cancel();
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.f14441a, 1.0f});
        r3.setDuration(50);
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r3.addUpdateListener(new $$Lambda$OTouchAnimView$GwT5YHCGj_RqXv0Ut3E68qtNUA(this));
        r3.start();
        this.c = r3;
    }

    private static final void b(OTouchAnimView r2, ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin")).floatValue();
        r2.f14441a = r5;
        r2.a(r5, "release_anim");
    }

    private final void c() {
        if (a() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L9;
        r0.removeAllUpdateListeners();
    L9:
        ValueAnimator r1 = this.c;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        ValueAnimator r2 = this.d;
        if (r2 == null) goto L17;
        r2.cancel();
    L17:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.f14441a, 0.0f});
        r3.setDuration(200);
        r3.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r3.addUpdateListener(new $$Lambda$OTouchAnimView$3ODvfIo1tPD8PYkhn7uJmoMHy3c(this));
        r3.start();
        this.d = r3;
    }

    public static /* synthetic */ void lambda$3ODvfIo1tPD8PYkhn7uJmoMHy3c(OTouchAnimView r0, ValueAnimator r1) {
        b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$GwT5-YHCGj_RqXv0Ut3E68qtNUA, reason: not valid java name */
    public static /* synthetic */ void m1357lambda$GwT5YHCGj_RqXv0Ut3E68qtNUA(OTouchAnimView r0, ValueAnimator r1) {
        a(r0, r1);
    }

    public abstract void a(float r1, String r2);

    public abstract boolean a();

    public final boolean d() {
        ValueAnimator r0 = this.c;
        if (r0 != null) goto L6;
    L4:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L17;
        ValueAnimator r3 = this.d;
        if (r3 != null) goto L13;
    L11:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L17;
        return false;
    L13:
        if (r3.isRunning() != true) goto L11;
        r4 = true;
    L17:
        return true;
    L6:
        if (r0.isRunning() != true) goto L4;
        r1 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 != 0) goto L5;
        b();
    L12:
        return super.dispatchTouchEvent(r3);
    L5:
        if (r0 != 1) goto L7;
    L9:
        c();
        goto L12
    L7:
        if (r0 == 3) goto L9;
        goto L9
    }

    public final void e() {
        ValueAnimator r0 = this.c;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        ValueAnimator r1 = this.d;
        if (r1 == null) goto L11;
        r1.cancel();
        return;
    }
}
