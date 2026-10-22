package com.larksuite.component.universe_design.toast;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.compose.foundation.toast.f;
import com.ss.android.lark.compose.foundation.toast.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larksuite/component/universe_design/toast/UDToast;", "", "<init>", "()V", "LENGTH_LONG", "", "LENGTH_SHORT", "show", "", "context", "Landroid/content/Context;", "text", "", "stringId", "", "drawableId", "makeToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "build", "Lcom/larksuite/component/universe_design/toast/UDToast$Builder;", "createTintedIcon", "Landroid/graphics/drawable/Drawable;", "tintDrawable", "drawable", "Builder", "Duration", "OnActionClickListener", "OnToastDismissListener", "flow-ud-toast-compat_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UDToast {
    public static final UDToast INSTANCE = null;
    public static final long LENGTH_LONG = -2;
    public static final long LENGTH_SHORT = -1;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/larksuite/component/universe_design/toast/UDToast$Duration;", "", "flow-ud-toast-compat_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Duration {
    }

    public static final class a {
        public final Context a;
        public final FlowToast.a b;

        public final g a() {
            return this.b.a();
        }

        public final void h() {
            a().show();
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = FlowToast.a(r2);
        }

        public final void d(int r4) {
            this.b.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, this.a, r4));
        }

        public final void e(Drawable r4) {
            Intrinsics.checkNotNullParameter(r4, "value");
            this.b.d(UDToast.access$tintDrawable(UDToast.INSTANCE, this.a, r4));
        }

        public final void f(c r4) {
            Intrinsics.checkNotNullParameter(r4, "dismiss");
            FlowToast.a r1 = this.b;
            com.larksuite.component.universe_design.toast.b r2 = new com.larksuite.component.universe_design.toast.b(r4);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "dismiss");
            r1.g = r2;
        }

        public final void g(CharSequence r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            FlowToast.a r1 = this.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "value");
            r1.b = r3;
        }

        public final void b(int r3, b r4) {
            Intrinsics.checkNotNullParameter(r4, "action");
            this.b.b(r3, new com.larksuite.component.universe_design.toast.a(r4));
        }

        public final void c(String r5, b r6) {
            Intrinsics.checkNotNullParameter(r5, "text");
            Intrinsics.checkNotNullParameter(r6, "action");
            FlowToast.a r2 = this.b;
            com.larksuite.component.universe_design.toast.a r3 = new com.larksuite.component.universe_design.toast.a(r6);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r5, "text");
            Intrinsics.checkNotNullParameter(r3, "action");
            r2.e = r5;
            r2.f = r3;
        }
    }

    public interface b {
        void a(com.ss.android.lark.compose.foundation.toast.b r1);
    }

    public interface c {
        void a();
    }

    static {
        INSTANCE = new UDToast();
    }

    private UDToast() {
    }

    @JvmStatic
    public static final a build(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return new a(r1);
    }

    private final Drawable createTintedIcon(Context r3, int r4) {
        return UDIconUtils.getIconDrawable(r3, r4, r3.getResources().getColor(2131102418));
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r1 = FlowToast.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        f r0 = new f(r2);
        r0.setText(r3);
        return r0;
    }

    @JvmStatic
    public static final void show(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        FlowToast.d(r1, r2);
    }

    private final Drawable tintDrawable(Context r3, Drawable r4) {
        r4.mutate().setTint(r3.getResources().getColor(2131102418));
        return r4;
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        return FlowToast.b(r1, r2);
    }

    @JvmStatic
    public static final void show(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        FlowToast.c(r1, r2);
    }

    public static final /* synthetic */ Drawable access$createTintedIcon(UDToast r0, Context r1, int r2) {
        return r0.createTintedIcon(r1, r2);
    }

    public static final /* synthetic */ Drawable access$tintDrawable(UDToast r0, Context r1, Drawable r2) {
        return r0.tintDrawable(r1, r2);
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r1 = FlowToast.a;
        Intrinsics.checkNotNullParameter(r2, "context");
        f r0 = new f(r2);
        r0.setText(r3);
        r0.setIcon(INSTANCE.createTintedIcon(r2, r4));
        return r0;
    }

    @JvmStatic
    public static final void show(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        makeToast(r1, r2, r3).show();
    }

    @JvmStatic
    public static final com.larksuite.component.universe_design.toast.c makeToast(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "text");
        f r4 = FlowToast.b(r1, r2);
        r4.setIcon(INSTANCE.createTintedIcon(r1, r3));
        return r4;
    }

    @JvmStatic
    public static final void show(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        makeToast(r1, r2, r3).show();
    }
}
