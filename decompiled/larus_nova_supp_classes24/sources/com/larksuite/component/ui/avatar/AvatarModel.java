package com.larksuite.component.ui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class AvatarModel {
    public static final int k = 0;
    public final Drawable a;
    public final int b;
    public final String c;
    public final String d;
    public final Drawable e;
    public final int f;
    public final Size g;
    public final boolean h;
    public final Biz i;
    public final Scene j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/avatar/AvatarModel$Size;", "", "dpValue", "", "<init>", "(Ljava/lang/String;II)V", "getDpValue", "()I", "MINI", "SMALL", "MIDDLE", "LARGE", "ORIGIN", "getPxValue", "context", "Landroid/content/Context;", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Size extends Enum<Size> {
        public static final Size LARGE = null;
        public static final Size MIDDLE = null;
        public static final Size MINI = null;
        public static final Size ORIGIN = null;
        public static final Size SMALL = null;
        public static final /* synthetic */ Size[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int dpValue;

        public static EnumEntries<Size> getEntries() {
            return b;
        }

        static {
            Size r0 = new Size("MINI", 0, 22);
            MINI = r0;
            Size r1 = new Size("SMALL", 1, 30);
            SMALL = r1;
            Size r2 = new Size("MIDDLE", 2, 48);
            MIDDLE = r2;
            Size r4 = new Size("LARGE", 3, 300);
            LARGE = r4;
            Size r6 = new Size("ORIGIN", 4, -1);
            ORIGIN = r6;
            Size[] r8 = {r0, r1, r2, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
        }

        public static Size[] values() {
            return (Size[]) a.clone();
        }

        public final int getDpValue() {
            return this.dpValue;
        }

        public static Size valueOf(String r1) {
            return (Size) r27.a.a(Size.class, r1);
        }

        public final int getPxValue(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            return (int) j08.b.a(r2, this.dpValue);
        }

        public Size(String r1, int r2, int r3) {
            super(r1, r2);
            this.dpValue = r3;
        }
    }

    public static class a<T extends a<T>> {
        public Drawable a;
        public int b;
        public String c;
        public String d;
        public final Drawable e;
        public int f;
        public Size g;
        public boolean h;
        public Biz i;
        public Scene j;

        public a() {
            GradientDrawable r0 = new GradientDrawable();
            r0.setShape(1);
            r0.setColor(AvatarModel.k);
            this.e = r0;
            this.g = Size.MIDDLE;
            this.i = Biz.Messenger;
            this.j = Scene.Chat;
        }

        public final void a(boolean r1) {
            this.h = r1;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void b(String r1) {
            this.c = r1;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void c(Biz r2) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            this.i = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void d(int r1) {
            this.b = r1;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void e(Drawable r1) {
            this.a = r1;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void f(String r1) {
            this.d = r1;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void g(Scene r2) {
            Intrinsics.checkNotNullParameter(r2, "scene");
            this.j = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void h(Size r2) {
            Intrinsics.checkNotNullParameter(r2, "size");
            this.g = r2;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }
    }

    public static final class b {
    }

    static {
        k = ColorProtector.parseColor("#EFF0F1");
    }

    public AvatarModel(a<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        Drawable r0 = r10.a;
        int r1 = r10.b;
        String r2 = r10.c;
        String r3 = r10.d;
        Drawable r4 = r10.e;
        int r5 = r10.f;
        Size r6 = r10.g;
        boolean r7 = r10.h;
        Biz r8 = r10.i;
        Scene r11 = r10.j;
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r11;
    }

    public final Drawable a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Drawable r0 = this.e;
        if (r0 != null) goto L11;
        int r1 = this.f;
        if (r1 > 0) goto L10;
        return null;
    L10:
        return UDIconUtils.getIconDrawable(r2, r1);
    L11:
        return r0;
    }
}
