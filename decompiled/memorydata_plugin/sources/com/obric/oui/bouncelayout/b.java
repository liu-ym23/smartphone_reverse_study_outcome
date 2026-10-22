package com.obric.oui.bouncelayout;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u0005¢\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J3\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010'\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010(\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/oui/bouncelayout/BounceClickDuringOverScrollDelegate;", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/View;", "translationProvider", "Lkotlin/Function0;", "", "effectsProvider", "", "Lcom/obric/oui/bouncelayout/BounceEdgeEffect;", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "", "allowClickDuringOverScroll", "getAllowClickDuringOverScroll", "()Z", "touchDownAllowsClick", "touchDownTranslation", "getTouchDownTranslation", "()F", "touchDownX", "touchDownY", "touchMovedBeyondClickSlop", "touchSlop", "", "", "allow", "clearIfFinished", "event", "Landroid/view/MotionEvent;", "dispatchWithAdjustedLocationIfNeeded", "offsetX", "offsetY", "dispatch", "(Landroid/view/MotionEvent;FFLkotlin/jvm/functions/Function0;)Ljava/lang/Boolean;", "effectsLogMessage", "", "isMovedBeyondClickSlop", "onDispatchTouchEventStart", "shouldAllowClick", "shouldLetChildHandleTouch", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f13358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Float> f13359b;
    private final Function0<e[]> c;
    private boolean d;
    private float e;
    private final int f;
    private float g;
    private float h;
    private boolean i;
    private boolean j;

    public b(View r3, Function0<Float> r4, Function0<e[]> r5) {
        Function0<Float> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<e[]> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r6, "translationProvider");
        Intrinsics.checkNotNullParameter(r7, "effectsProvider");
        this.f13358a = r3;
        this.f13359b = r6;
        this.c = r7;
        this.d = true;
        this.f = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getScaledTouchSlop();
    }

    private final String c() {
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(this.c.invoke(), Object[].class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r11.length), Collection.class, "com.obric.memorydata.plugin");
        int r2 = r11.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L10;
        int r6 = r4 + 1;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r11[r3], e.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L7;
        StringBuilder r7 = new StringBuilder().append("effect").append(r4).append("=null");
    L8:
        r0.add(r7.toString());
        r3 = r3 + 1;
        r4 = r6;
        goto L3
    L7:
        r7 = new StringBuilder().append("effect").append(r4).append("(distance=").append(r5.getDistance()).append(",translation=").append(r5.a()).append(",finished=").append(r5.isFinished()).append(')');
        goto L8
    L10:
        return "effects=[" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ']';
    }

    private final boolean c(MotionEvent r8) {
        if (this.d == true) goto L5;
        return false;
    L5:
        if (r8.getActionMasked() != 0) goto L33;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(this.c.invoke(), Object[].class, "com.obric.memorydata.plugin");
        int r9 = r7.length;
        int r2 = 0;
    L9:
        if (r2 >= r9) goto L34;
        e r4 = (e) ZeusTransformUtils.preCheckCast(r7[r2], e.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
    L25:
        boolean r5 = false;
    L26:
        if (r5 == true) goto L32;
        r2 = r2 + 1;
        goto L9
    L32:
        return true;
    L13:
        if (r4.getDistance() != 0.0f) goto L15;
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
    L24:
        r5 = true;
        goto L26
    L18:
        if (r4.a() != 0.0f) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == false) goto L24;
        if (r4.isFinished() == true) goto L25;
    L20:
        r10 = false;
        goto L21
    L15:
        r6 = false;
        goto L16
    L34:
        return false;
    L33:
        return false;
    }

    private final boolean d(MotionEvent r3) {
        float r0 = r3.getX() - this.g;
        float r4 = r3.getY() - this.h;
        float r1 = (r0 * r0) + (r4 * r4);
        int r2 = this.f;
        if (r1 <= (r2 * r2)) goto L5;
        return true;
    L5:
        return false;
    }

    private final void e(MotionEvent r3) {
        if (r3.getActionMasked() != 1) goto L5;
    L6:
        this.e = 0.0f;
        this.i = false;
        this.j = false;
        return;
    L5:
        if (r3.getActionMasked() == 3) goto L6;
    }

    public final Boolean a(MotionEvent r8, float r9, float r10, Function0<Boolean> r11) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r12, "dispatch");
        if (this.i == true) goto L6;
        e(r8);
        return null;
    L6:
        d r0 = d.f13362a;
        if (d.a() == false) goto L9;
        d.a(this.f13358a, "allowClickDispatch", "action=" + r8.getActionMasked() + " movedBeyondSlop=" + this.j + " rawX=" + r8.getX() + " rawY=" + r8.getY() + " offsetX=" + r9 + " offsetY=" + r10);
    L9:
        boolean r3 = true;
        if (r9 != 0.0f) goto L12;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L16;
    L26:
        r8.offsetLocation(r9, r10);
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r8.offsetLocation(-r9, -r10);
        d r14 = d.f13362a;
        if (d.a() == false) goto L29;
        d.a(this.f13358a, "allowClickDispatchResult", Intrinsics.stringPlus("handled=", Boolean.valueOf(r13)));
    L29:
        e(r8);
        return Boolean.valueOf(r13);
    L16:
        if (r10 == 0.0f) goto L19;
        r3 = false;
    L19:
        if (r3 == false) goto L26;
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r12.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        d r16 = d.f13362a;
        if (d.a() == false) goto L24;
        d.a(this.f13358a, "allowClickDispatchResult", Intrinsics.stringPlus("handled=", Boolean.valueOf(r15)));
    L24:
        e(r8);
        return Boolean.valueOf(r15);
    L12:
        r2 = false;
        goto L14
    }

    public final void a(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L5;
        this.g = r5.getX();
        this.h = r5.getY();
        this.j = false;
        this.e = ((Number) ZeusTransformUtils.preCheckCast(this.f13359b.invoke(), Number.class, "com.obric.memorydata.plugin")).floatValue();
        this.i = c(r5);
        d r6 = d.f13362a;
        if (d.a() == false) goto L24;
        d.a(this.f13358a, "allowClickDownDecision", "allow=" + a() + " allowClick=" + this.i + " translation=" + b() + ' ' + c());
    L24:
        if (this.i == false) goto L35;
        ViewParent r4 = this.f13358a.getParent();
        if (r4 == null) goto L37;
        r4.requestDisallowInterceptTouchEvent(true);
        return;
    L37:
        return;
    L35:
        return;
    L5:
        if (r0 == 2) goto L8;
        return;
    L8:
        if (this.i == true) goto L10;
        return;
    L10:
        if (this.j == false) goto L12;
        return;
    L12:
        if (d(r5) == false) goto L32;
        this.j = true;
        ViewParent r1 = this.f13358a.getParent();
        if (r1 == null) goto L17;
        r1.requestDisallowInterceptTouchEvent(false);
    L17:
        d r2 = d.f13362a;
        if (d.a() == false) goto L33;
        d.a(this.f13358a, "allowClickCancelByDrag", "dx=" + (r5.getX() - this.g) + " dy=" + (r5.getY() - this.h) + " touchSlop=" + this.f);
        return;
    L33:
        return;
    }

    public final void a(boolean r2) {
        this.d = r2;
        d r0 = d.f13362a;
        if (d.a() == false) goto L6;
        d.a(this.f13358a, "allowClickDuringOverScroll", Intrinsics.stringPlus("allow=", Boolean.valueOf(r2)));
        return;
    }

    public final boolean a() {
        return this.d;
    }

    public final float b() {
        return this.e;
    }

    public final boolean b(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (this.i == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        d r1 = d.f13362a;
        if (d.a() == false) goto L14;
        if (r0 == false) goto L12;
    L13:
        d.a(this.f13358a, "allowClickChildTouch", "action=" + r4.getActionMasked() + " allowChild=" + r0);
        goto L14
    L12:
        if (r4.getActionMasked() == 0) goto L13;
    L14:
        return r0;
    L5:
        if (this.j == true) goto L7;
        r0 = true;
        goto L8
    }
}
