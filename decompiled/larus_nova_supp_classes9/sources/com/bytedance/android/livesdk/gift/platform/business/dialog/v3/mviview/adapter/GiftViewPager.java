package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.gift.configmodel.r0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/GiftViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftViewPager extends ViewPager {
    public float a;
    public float b;
    public boolean c;
    public final int d;
    public final r0 e;
    public int f;
    public View g;
    public final Method h;
    public Field i;

    public GiftViewPager(Context r2) {
        this(r2, null);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L20;
        jy0.b.a("yz-debug-SSGridLayoutManager", "y " + r5.getY() + ", action: " + r5.getAction());
        int r0 = r5.getAction();
        if (r0 != 0) goto L6;
        this.a = r5.getX();
        this.b = r5.getY();
        goto L20
    L6:
        if (r0 != 2) goto L20;
        float r1 = r5.getX();
        float r2 = r5.getY();
        if (Math.abs(this.a - r1) <= this.d) goto L20;
        if ((Math.abs(r1 - this.a) * 0.5f) <= Math.abs(r2 - this.b)) goto L20;
        if (this.c == true) goto L20;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.t0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[70])).booleanValue() == false) goto L20;
        return true;
    L20:
        return super.onInterceptTouchEvent(r5);
    }

    public GiftViewPager(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7);
        this.d = ViewConfiguration.get(r6).getScaledTouchSlop();
        r0 r8 = (r0) com.bytedance.android.livesdk.gift.platform.core.h.x0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[74]);
        this.e = r8;
        if (r8.b() == false) goto L18;
        addOnPageChangeListener(new AnonymousClass1(this));
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L10
        Method r10 = GiftViewPager.class.getDeclaredMethod("infoForChild", new Class[]{View.class});     // Catch: Throwable -> L10
        this.h = r10;     // Catch: Throwable -> L10
        if (r10 == null) goto L8;
        r10.setAccessible(true);     // Catch: Throwable -> L10
    L8:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L13:
        if (Result.exceptionOrNull-impl(r11) == null) goto L19;
        this.h = null;
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDescendantInvalidated(View r8, View r9) {
        Intrinsics.checkNotNullParameter(r8, "child");
        Intrinsics.checkNotNullParameter(r9, "target");
        if (this.e.e() == false) goto L8;
        if (this.e.a(this.f) == false) goto L8;
        return;
    L8:
        if (this.e.d() == true) goto L10;
    L44:
        super/*android.view.ViewGroup*/.onDescendantInvalidated(r8, r9);
        return;
    L10:
        if (r8.getParent() != this) goto L44;
        if (r9 == r8) goto L44;
        if (this.g != r9) goto L46;
        return;
    L46:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L35
        Method r3 = this.h;     // Catch: Throwable -> L35
        if (r3 == null) goto L19;
        Object r4 = r3.invoke(this, new Object[]{r8});     // Catch: Throwable -> L35
    L20:
        if (r4 != null) goto L22;
    L30:
        int r5 = -1;
    L48:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L38:
        if (r5 != (-1)) goto L40;
    L43:
        this.g = null;
        goto L44
    L40:
        if (r5 == getCurrentItem()) goto L43;
        this.g = r9;
        return;
    L33:
        th = move-exception;
        int r6 = r5;
        th = th;
    L37:
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        r5 = r6;
        goto L38
    L22:
        if (this.i != null) goto L26;
        Field r10 = r4.getClass().getDeclaredField("position");     // Catch: Throwable -> L35
        this.i = r10;     // Catch: Throwable -> L35
        if (r10 == null) goto L26;
        r10.setAccessible(true);     // Catch: Throwable -> L35
    L26:
        Field r11 = this.i;     // Catch: Throwable -> L35
        if (r11 == null) goto L30;
        r5 = r11.getInt(r4);     // Catch: Throwable -> L35
        goto L48
    L19:
        r4 = null;
    L35:
        th = th;
        r6 = -1;
        goto L37
    }
}
