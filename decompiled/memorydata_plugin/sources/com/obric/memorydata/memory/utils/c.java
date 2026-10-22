package com.obric.memorydata.memory.utils;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0005H&J\u0018\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR.\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0016\u0010#\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "", "<init>", "()V", "clickPos", "", "getClickPos", "()[I", "isLongClickTriggered", "", "isLongClickTriggered$memory_obricRelease", "()Z", "setLongClickTriggered$memory_obricRelease", "(Z)V", "downTime", "", "downPos", "touchLockAcquired", "canTriggerLongPress", "longPressLockAcquired", "enableLongPressThrottle", "getEnableLongPressThrottle", "setEnableLongPressThrottle", "exclusiveTouchHandler", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/view/MotionEvent;", "", "getExclusiveTouchHandler", "()Lkotlin/jvm/functions/Function2;", "setExclusiveTouchHandler", "(Lkotlin/jvm/functions/Function2;)V", "extraTouchHandler", "getExtraTouchHandler", "setExtraTouchHandler", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getOnTouchListener", "()Landroid/view/View$OnTouchListener;", "onLongClick", "view", "rawPos", "onClick", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class c {
    public static final a d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f11532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11533b;
    private long c;
    private final int[] e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Function2<? super View, ? super MotionEvent, Unit> j;
    private Function2<? super View, ? super MotionEvent, Unit> k;
    private final View.OnTouchListener l;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/utils/EnhancedTouchListener$Companion;", "", "<init>", "()V", "CLICK_TIME_THRESHOLD", "", "CLICK_DISTANCE_THRESHOLD", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        d = new a(null);
    }

    public c() {
        this.f11532a = new int[2];
        this.e = new int[2];
        this.i = true;
        this.l = new $$Lambda$c$T49n3Da5NHG5vyXYTsMCF7dk00A(this);
    }

    private static final boolean a(c r10, View r11, MotionEvent r12) {
        if (r12 == null) goto L4;
        Integer r0 = Integer.valueOf(r12.getAction());
    L6:
        if (r0 == null) goto L31;
        if (r0.intValue() != 0) goto L31;
        if (r10.i == false) goto L13;
        w r1 = w.f11568a;
        Intrinsics.checkNotNull(r11);
        boolean r2 = r1.a(r11);
    L14:
        r10.f = r2;
        boolean r4 = r10.i;
        if (r4 == false) goto L18;
        if (r2 == false) goto L18;
        w r3 = w.f11568a;
        Intrinsics.checkNotNull(r11);
        boolean r5 = r3.a(r11, true);
        r10.h = r5;
    L21:
        r10.g = r5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TouchEnhanceUtil", "ACTION_DOWN: touchLockAcquired=" + r10.f + " canTriggerLongPress=" + r10.g, false, 4, null);
        r10.f11533b = false;
        r10.c = SystemClock.elapsedRealtime();
        r10.e[0] = (int) r12.getRawX();
        r10.e[1] = (int) r12.getRawY();
        r10.f11532a[0] = (int) r12.getRawX();
        r10.f11532a[1] = (int) r12.getRawY();
        if (r10.f == false) goto L26;
        Function2<? super View, ? super MotionEvent, Unit> r6 = r10.j;
        if (r6 == null) goto L26;
        Intrinsics.checkNotNull(r11);
        r6.invoke(r11, r12);
    L26:
        Function2<? super View, ? super MotionEvent, Unit> r13 = r10.k;
        if (r13 == null) goto L98;
    L28:
        Intrinsics.checkNotNull(r11);
    L29:
        r13.invoke(r11, r12);
        return false;
    L98:
        return false;
    L18:
        if (r4 == true) goto L20;
        r5 = true;
        goto L21
    L20:
        r5 = false;
        goto L21
    L13:
        r2 = true;
    L31:
        if (r0 != null) goto L34;
    L43:
        if (r0 == null) goto L48;
        if (r0.intValue() != 1) goto L48;
    L57:
        if (r10.f == false) goto L61;
        Function2<? super View, ? super MotionEvent, Unit> r7 = r10.j;
        if (r7 == null) goto L61;
        Intrinsics.checkNotNull(r11);
        r7.invoke(r11, r12);
    L61:
        Function2<? super View, ? super MotionEvent, Unit> r8 = r10.k;
        if (r8 == null) goto L65;
        Intrinsics.checkNotNull(r11);
        r8.invoke(r11, r12);
    L65:
        if (r10.f11533b == false) goto L67;
    L75:
        boolean r14 = false;
    L76:
        boolean r9 = r10.f11533b;
        if (r10.i == true) goto L79;
    L82:
        boolean r15 = true;
    L83:
        r10.f11533b = false;
        if (r10.h == false) goto L87;
        w r16 = w.f11568a;
        Intrinsics.checkNotNull(r11);
        r16.c(r11);
        r10.h = false;
    L87:
        if (r10.f == false) goto L89;
        w r17 = w.f11568a;
        Intrinsics.checkNotNull(r11);
        r17.b(r11);
        r10.f = false;
    L89:
        r11.cancelLongPress();
        r11.setPressed(false);
        if (r14 == false) goto L96;
        if (r15 == false) goto L93;
        Intrinsics.checkNotNull(r11);
        return r10.b(r11, r10.f11532a);
    L93:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TouchEnhanceUtil", "ignore non-exclusive click view=" + r11.hashCode(), false, 4, null);
        return true;
    L96:
        return r9;
    L79:
        if (r10.f == true) goto L82;
        r15 = false;
        goto L83
    L67:
        if (r12.getAction() != 1) goto L75;
        if ((SystemClock.elapsedRealtime() - r10.c) >= 500) goto L75;
        if (Math.abs(((int) r12.getRawX()) - r10.e[0]) >= 20) goto L75;
        if (Math.abs(((int) r12.getRawY()) - r10.e[1]) >= 20) goto L75;
        r14 = true;
    L48:
        if (r0 != null) goto L51;
    L53:
        RunLog.INSTANCE.debug("TouchEnhanceUtil", "extraTouchHandler OTHER view=" + r11.hashCode() + ", action=" + r12.getAction());
        r13 = r10.k;
        if (r13 == null) goto L101;
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        goto L29
    L101:
        return false;
    L51:
        if (r0.intValue() != 3) goto L53;
    L34:
        if (r0.intValue() != 2) goto L43;
        r10.f11532a[0] = (int) r12.getRawX();
        r10.f11532a[1] = (int) r12.getRawY();
        if (r10.f == false) goto L40;
        RunLog.INSTANCE.debug("TouchEnhanceUtil", "exclusiveTouchHandler MOVE view=" + r11.hashCode());
        Function2<? super View, ? super MotionEvent, Unit> r18 = r10.j;
        if (r18 == null) goto L40;
        Intrinsics.checkNotNull(r11);
        r18.invoke(r11, r12);
    L40:
        RunLog.INSTANCE.debug("TouchEnhanceUtil", "extraTouchHandler MOVE view=" + r11.hashCode());
        r13 = r10.k;
        if (r13 != null) goto L28;
        return false;
    L4:
        r0 = null;
        goto L6
    }

    public static /* synthetic */ boolean lambda$T49n3Da5NHG5vyXYTsMCF7dk00A(c r0, View r1, MotionEvent r2) {
        return a(r0, r1, r2);
    }

    public final void a(Function2<? super View, ? super MotionEvent, Unit> r3) {
        this.j = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
    }

    public final void a(boolean r1) {
        this.f11533b = r1;
    }

    public abstract boolean a(View r1, int[] r2);

    public final int[] a() {
        return this.f11532a;
    }

    public View.OnTouchListener b() {
        return this.l;
    }

    public boolean b(View r1, int[] r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "rawPos");
        return false;
    }
}
