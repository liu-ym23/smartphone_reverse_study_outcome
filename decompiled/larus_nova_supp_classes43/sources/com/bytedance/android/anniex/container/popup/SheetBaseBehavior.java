package com.bytedance.android.anniex.container.popup;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\u000b\f\rB\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior;", "Landroid/view/View;", "V", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "State", "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class SheetBaseBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public b b;
    public boolean c;
    public e d;
    public com.bytedance.android.anniex.container.popup.d e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior$State;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
    }

    public static final class a {
    }

    public interface b {
        void a(View r1, int r10);

        void b(View r1, float r10);
    }

    public static final class c implements com.bytedance.android.anniex.container.popup.d {
        public c() {
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean a() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean c() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean d() {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean e() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.d
        public final boolean f(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            return false;
        }
    }

    public static final class d implements e {
        public d() {
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean disableDragDown() {
            return false;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean shouldInterceptSlide(int r1) {
            return true;
        }

        @Override // com.bytedance.android.anniex.container.popup.e
        public final boolean a(MotionEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            return false;
        }
    }

    static {
    }

    public void setPeekHeight(int r1) {
    }

    public void setState(int r1) {
    }

    public SheetBaseBehavior() {
        this.d = new d();
        this.e = new c();
    }

    public final String a(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        Resources r0 = r10.getResources();
        if (r10.getId() == (-1)) goto L8;
        if (r0 == null) goto L8;
        String r1 = r0.getResourceEntryName(r10.getId());
        if (Intrinsics.areEqual("annie_x_bottom_sheet", r1) == true) goto L8;
        return r1;
    L8:
        int r11 = r10.getChildCount();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L19;
        View r13 = r10.getChildAt(r12);
        if ((r13 instanceof ViewGroup) == true) goto L13;
        if (r13.getId() != (-1)) goto L16;
        r12 = r12 + 1;
        goto L9
    L16:
        Intrinsics.checkNotNull(r0);
        return r0.getResourceEntryName(r13.getId());
    L13:
        return a((ViewGroup) r13);
    L19:
        return "";
    }

    public final View findScrollingChild(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (ViewCompat.isNestedScrollingEnabled(r10) == false) goto L8;
        return r10;
    L8:
        int r11 = 0;
        if ((r10 instanceof ViewPager) == false) goto L32;
        ViewPager r12 = (ViewPager) r10;
        int r1 = r12.getCurrentItem();
        int r13 = r12.getChildCount();
    L11:
        if (r11 >= r13) goto L22;
        View r14 = r12.getChildAt(r11);
        ViewPager.LayoutParams r15 = r14.getLayoutParams();
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager.LayoutParams");
        ViewPager.LayoutParams r16 = r15;
        Field r17 = r16.getClass().getDeclaredField("position");     // Catch: Throwable -> L40
        r17.setAccessible(true);     // Catch: Throwable -> L40
        Object r18 = r17.get(r16);     // Catch: Throwable -> L40
        if (r16.isDecor == true) goto L21;
        if ((r18 instanceof Integer) == false) goto L21;
        if (r1 != ((Number) r18).intValue()) goto L21;
    L23:
        if (r14 != null) goto L25;
        return null;
    L25:
        View r19 = findScrollingChild(r14);
        if (r19 != null) goto L28;
        return null;
    L28:
        if (r19.getVisibility() == 0) goto L30;
        return null;
    L30:
        return r19;
    L21:
        r11 = r11 + 1;
    L22:
        r14 = null;
        goto L23
    L32:
        if ((r10 instanceof ViewGroup) == false) goto L39;
        ViewGroup r20 = (ViewGroup) r10;
        int r21 = r20.getChildCount();
    L34:
        if (r11 >= r21) goto L39;
        View r22 = findScrollingChild(r20.getChildAt(r11));
        if (r22 != null) goto L37;
        r11 = r11 + 1;
        goto L34
    L37:
        return r22;
    L39:
        return null;
    }

    public SheetBaseBehavior(Context r1, AttributeSet r10) {
        super(r1, r10);
        this.d = new d();
        this.e = new c();
    }
}
