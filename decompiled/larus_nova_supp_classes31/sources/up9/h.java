package up9;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.ui.MyBottomSheetBehavior;
import com.larus.platform.api.g3;
import com.larus.platform.model.album.TouchState;
import com.larus.platform.service.k2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h implements View.OnTouchListener {
    public float a;
    public float b;
    public boolean c;
    public boolean d;
    public int e;
    public boolean f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public boolean j;
    public float k;
    public final Queue<Float> l;
    public final float m;
    public final int n;
    public boolean o;
    public final float p;
    public final /* synthetic */ Activity q;
    public final /* synthetic */ i r;
    public final /* synthetic */ MyBottomSheetBehavior s;

    public final void c() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = false;
        this.d = false;
        this.e = 0;
        this.f = false;
        this.j = false;
        MutableLiveData<TouchState> r0 = kq9.f.a;
        kq9.f.a.setValue(TouchState.DEFAULT);
    }

    public final float a(float r3) {
        if (((LinkedList) this.l).size() < this.n) goto L5;
        ((LinkedList) this.l).poll();
    L5:
        ((LinkedList) this.l).add(Float.valueOf(r3));
        return CollectionsKt.sumOfFloat(this.l) / ((LinkedList) this.l).size();
    }

    public final void b(MotionEvent r22) {
        int r6 = r22.getPointerCount();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        int r5 = 0;
    L3:
        if (r5 >= r6) goto L5;
        MotionEvent.PointerProperties r7 = new MotionEvent.PointerProperties();
        r22.getPointerProperties(r5, r7);
        r2.add(r7);
        MotionEvent.PointerCoords r8 = new MotionEvent.PointerCoords();
        r22.getPointerCoords(r5, r8);
        r8.y += ((Number) this.g.getValue()).intValue();
        r3.add(r8);
        r5 = r5 + 1;
        goto L3
    L5:
        MotionEvent r1 = MotionEvent.obtain(r22.getDownTime(), r22.getEventTime(), r22.getAction(), r6, (MotionEvent.PointerProperties[]) r2.toArray(new MotionEvent.PointerProperties[0]), (MotionEvent.PointerCoords[]) r3.toArray(new MotionEvent.PointerCoords[0]), r22.getMetaState(), r22.getButtonState(), r22.getXPrecision(), r22.getYPrecision(), r22.getDeviceId(), r22.getEdgeFlags(), r22.getSource(), r22.getFlags());
        Activity r4 = this.q;
        if (r4 == null) goto L8;
        r4.dispatchTouchEvent(r1);
    L8:
        r1.recycle();
    }

    public final void d(boolean r5) {
        final MyBottomSheetBehavior r0 = this.s;
        if (r0 == null) goto L15;
        final i r1 = this.r;
        if (r5 == false) goto L7;
    L11:
        r0.setState(4);
        if (r0.getPeekHeight() <= 0) goto L18;
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{r0.getPeekHeight(), 0});
        r6.addUpdateListener(new d(r0, r1));
        r6.setInterpolator(new AccelerateInterpolator());
        r6.setDuration(Math.min(r0.getPeekHeight(), 150));
        r6.start();
        return;
    L18:
        return;
    L7:
        if (r0.getPeekHeight() < ((Number) this.h.getValue()).intValue()) goto L11;
        r0.setState(3);
        com.larus.platform.api.b0 r7 = r1.b;
        if (r7 == null) goto L16;
        r7.f();
        return;
    L16:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r9, MotionEvent r10) {
        MyBottomSheetBehavior r11 = this.s;
        i r0 = this.r;
        Activity r1 = this.q;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L132
        if (r10 != null) goto L6;
    L53:
        if (r10 == null) goto L55;
        Integer r2 = Integer.valueOf(r10.getAction());     // Catch: Throwable -> L132
    L56:
        if (r2 != null) goto L59;
    L65:
        if (r2 != null) goto L68;
    L108:
        if (r2 != null) goto L111;
    L131:
        return true;
    L111:
        if (r2.intValue() != 1) goto L131;
        if (this.f == true) goto L131;
        if (r11 != null) goto L116;
    L124:
        boolean r12 = false;
    L125:
        kq9.f.a.setValue(TouchState.ACTION_UP);     // Catch: Throwable -> L132
        k2 r13 = k2.a;     // Catch: Throwable -> L132
        if (g3.a.d() == false) goto L128;
        d(false);     // Catch: Throwable -> L132
    L128:
        c();     // Catch: Throwable -> L132
        return !r12;
    L116:
        if (r11.getPeekHeight() > 0) goto L124;
        if (r11.getState() != 4) goto L124;
        if (this.j == true) goto L124;
        if (kq9.f.a.getValue() == TouchState.ACTION_MOVE_CONSUMED) goto L124;
        b(r10);     // Catch: Throwable -> L132
        r12 = true;
        goto L125
    L68:
        if (r2.intValue() != 2) goto L108;
        if (this.f == true) goto L131;
        float r4 = this.a - r10.getRawX();     // Catch: Throwable -> L132
        float r5 = this.b - r10.getRawY();     // Catch: Throwable -> L132
        if (Math.abs(r4) > Math.abs(r5)) goto L74;
    L76:
        boolean r6 = false;
    L77:
        if (r6 == false) goto L80;
        b(r10);     // Catch: Throwable -> L132
        goto L131
    L80:
        if (this.d == true) goto L82;
        this.d = true;     // Catch: Throwable -> L132
    L82:
        k2 r7 = k2.a;     // Catch: Throwable -> L132
        if (g3.a.d() == false) goto L101;
        if (this.o == false) goto L89;
        float r8 = this.p;     // Catch: Throwable -> L132
        if (r5 <= r8) goto L89;
        this.b = r10.getRawY();     // Catch: Throwable -> L132
        this.o = false;     // Catch: Throwable -> L132
        r5 = r8;
    L89:
        this.k = a(r5) * this.m;     // Catch: Throwable -> L132
        int r14 = Math.max(0, Math.min(((Number) this.i.getValue()).intValue(), (int) (this.e + this.k)));     // Catch: Throwable -> L132
        if (r14 <= 0) goto L94;
        MutableLiveData<TouchState> r15 = kq9.f.a;     // Catch: Throwable -> L132
        Object r16 = r15.getValue();     // Catch: Throwable -> L132
        TouchState r17 = TouchState.ACTION_MOVE_CONSUMED;     // Catch: Throwable -> L132
        if (r16 == r17) goto L94;
        r15.setValue(r17);     // Catch: Throwable -> L132
    L94:
        if (r11 == null) goto L96;
        r11.setPeekHeight(r14);     // Catch: Throwable -> L132
    L96:
        com.larus.platform.api.b0 r18 = r0.b;     // Catch: Throwable -> L132
        if (r18 == null) goto L99;
        r18.e(r14);     // Catch: Throwable -> L132
    L99:
        r0.r(r0.e, r14);     // Catch: Throwable -> L132
        goto L131
    L101:
        if (this.j == true) goto L131;
        if (r5 <= 200.0f) goto L131;
        com.larus.platform.api.b0 r19 = r0.b;     // Catch: Throwable -> L132
        if (r19 == null) goto L107;
        r19.b();     // Catch: Throwable -> L132
    L107:
        this.j = true;     // Catch: Throwable -> L132
        goto L131
    L74:
        if (this.d == true) goto L76;
        r6 = true;
        goto L77
    L59:
        if (r2.intValue() != 0) goto L65;
        this.a = r10.getRawX();     // Catch: Throwable -> L132
        this.b = r10.getRawY();     // Catch: Throwable -> L132
        if (r11 == null) goto L63;
        int r20 = r11.getPeekHeight();     // Catch: Throwable -> L132
    L64:
        this.e = r20;     // Catch: Throwable -> L132
        this.k = 0.0f;     // Catch: Throwable -> L132
        this.o = true;     // Catch: Throwable -> L132
        ((LinkedList) this.l).clear();     // Catch: Throwable -> L132
        this.j = false;     // Catch: Throwable -> L132
        kq9.f.a.setValue(TouchState.ACTION_DOWN);     // Catch: Throwable -> L132
        b(r10);     // Catch: Throwable -> L132
        goto L131
    L63:
        r20 = 0;
        goto L64
    L55:
        r2 = null;
        goto L56
    L6:
        if (this.f == true) goto L13;
        if (r10.getPointerCount() <= 1) goto L10;
        boolean r21 = true;
    L11:
        this.f = r21;     // Catch: Throwable -> L132
        goto L13
    L10:
        r21 = false;
    L13:
        if (this.f == true) goto L49;
        com.larus.platform.api.b0 r22 = r0.b;     // Catch: Throwable -> L132
        if (r22 != null) goto L17;
    L19:
        boolean r23 = false;
    L20:
        if (r23 == true) goto L49;
        if (this.c == true) goto L42;
        float r24 = this.a - r10.getRawX();     // Catch: Throwable -> L132
        float r25 = this.b - r10.getRawY();     // Catch: Throwable -> L132
        if (this.a != 0.0f) goto L27;
        boolean r26 = true;
    L28:
        if (r26 == false) goto L35;
        if (this.b != 0.0f) goto L32;
        boolean r27 = true;
    L33:
        if (r27 == false) goto L35;
    L39:
        boolean r28 = false;
    L40:
        this.c = r28;     // Catch: Throwable -> L132
        goto L42
    L32:
        r27 = false;
    L35:
        if (Math.abs(r24) <= Math.abs(r25)) goto L39;
        if (this.d == true) goto L39;
        r28 = true;
        goto L40
    L27:
        r26 = false;
    L42:
        if (this.c == false) goto L53;
        if (r1 == null) goto L46;
        r1.dispatchTouchEvent(r10);     // Catch: Throwable -> L132
    L46:
        if (r10.getAction() != 1) goto L48;
        d(true);     // Catch: Throwable -> L132
        c();     // Catch: Throwable -> L132
    L48:
        return false;
    L17:
        if (r22.d() == true) goto L19;
        r23 = true;
    L49:
        b(r10);     // Catch: Throwable -> L132
        if (r10.getAction() != 1) goto L52;
        d(true);     // Catch: Throwable -> L132
        c();     // Catch: Throwable -> L132
    L52:
        return false;
    L132:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) == null) goto L137;
        return false;
    L137:
        throw new KotlinNothingValueException();
    }

    public h(final Activity r2, final i r3, MyBottomSheetBehavior r4) {
        this.q = r2;
        this.r = r3;
        this.s = r4;
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.g = LazyKt.lazy(r5, new e(r2));
        this.h = LazyKt.lazy(r5, new f(r3));
        this.i = LazyKt.lazy(r5, new g(r2));
        this.l = new LinkedList();
        this.m = 1.5f;
        this.n = 5;
        this.o = true;
        this.p = 20.0f;
    }
}
