package com.larus.bmhome.chat.layout.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\"\u001a\u00020#2\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020#H\u0002J\u0018\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0011H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011@CX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ThreeLoadingIndicator;", "Lcom/larus/bmhome/chat/layout/widget/LoadingAnimationLifecycleAware;", "anchorView", "Landroid/view/View;", "resId", "", "context", "Landroid/content/Context;", "tint", "<init>", "(Landroid/view/View;ILandroid/content/Context;Ljava/lang/Integer;)V", "indicators", "", "Lcom/larus/bmhome/chat/layout/widget/LoadingIndicatorImageSpan;", "getIndicators", "()Ljava/util/List;", "minAlpha", "", "maxAlpha", "value", "curDuration", "setCurDuration", "(F)V", "animator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "registered", "", "isAppForeground", "needAnim", "getNeedAnim", "()Z", "setNeedAnim", "(Z)V", "setTintColor", "", "(Ljava/lang/Integer;)V", "startLoading", "cancelLoading", "onAppForeground", "onAppBackground", "setupUIToDuration", "setupChildUIToDuration", "child", "duration", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThreeLoadingIndicator implements q0 {
    public final View a;
    public final List<v0> b;
    public final float c;
    public final float d;
    public final ObjectAnimator e;
    public boolean f;
    public boolean g;
    public boolean h;

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppBackground() {
        this.g = false;
        a();
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppForeground() {
        this.g = true;
        d();
    }

    public final void a() {
        if (this.e.isStarted() == true) goto L5;
        return;
    L5:
        this.e.cancel();
    }

    public final void d() {
        if (this.e.isStarted() == false) goto L5;
        return;
    L5:
        if (this.h == true) goto L8;
        return;
    L8:
        if (this.f == true) goto L11;
        CopyOnWriteArrayList<WeakReference<q0>> r0 = s0.a;
        s0.a(this);
        this.g = !AppHost.a.a().isAppBackground();
        this.f = true;
    L11:
        if (this.g == false) goto L15;
        this.e.start();
        return;
    }

    private final void setCurDuration(float r5) {
        Iterator r0 = CollectionsKt.reversed(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L23;
        c((v0) r0.next(), r5);
        View r1 = this.a;
        Unit r3 = null;
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 == null) goto L19;
        View r4 = r2.getChildAt(r2.getChildCount() - 1);
        if ((r4 instanceof FrameLayout) == false) goto L13;
        FrameLayout r6 = (FrameLayout) r4;
    L14:
        if (r6 == null) goto L18;
        View r7 = r6.getChildAt(0);
        if (r7 == null) goto L18;
        r7.invalidate();
        r3 = Unit.INSTANCE;
    L18:
        if (r3 == null) goto L19;
    L22:
        r5 = r5 + 0.16666667f;
        goto L4
    L13:
        r6 = null;
    L19:
        View r8 = this.a;
        if (r8 == null) goto L22;
        r8.invalidate();
        Unit r9 = Unit.INSTANCE;
        goto L22
    L8:
        r2 = null;
        goto L9
    L23:
        View r10 = this.a;
        if (r10 == null) goto L31;
        r10.invalidate();
        return;
    }

    public final void b(boolean r1) {
        this.h = r1;
        if (r1 == true) goto L6;
        a();
        return;
    }

    public final void c(v0 r6, float r7) {
        boolean r1 = true;
        if (0.0f <= r7) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L12;
        float r2 = this.d;
        r6.j = (int) ((r2 - (((r2 - this.c) * r7) / 0.5f)) * 255);
        return;
    L12:
        if (0.5f <= r7) goto L14;
    L16:
        r1 = false;
    L17:
        if (r1 == false) goto L19;
        float r3 = this.c;
        r6.j = (int) ((r3 + (((this.d - r3) * (r7 - 0.5f)) / 0.5f)) * 255);
        return;
    L19:
        c(r6, r7 - ((int) r7));
        return;
    L14:
        if (r7 > 1.0f) goto L16;
    L5:
        if (r7 > 0.5f) goto L7;
        r0 = true;
        goto L9
    }

    public ThreeLoadingIndicator(View r10, int r11, Context r12, Integer r13) {
        this.a = r10;
        v0[] r0 = new v0[3];
        int r1 = 0;
    L3:
        if (r1 >= 3) goto L5;
        r0[r1] = new v0(null, r11, r12, true, r13);
        r1 = r1 + 1;
        goto L3
    L5:
        this.b = ArraysKt.toList(r0);
        this.c = 0.1f;
        this.d = 1.0f;
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r14.setRepeatCount(-1);
        r14.setDuration(800);
        this.e = r14;
        this.g = true;
    }
}
