package com.larksuite.component.universe_design.gradient;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class UDLinearGradientDrawable extends c {
    public final int a;
    public final int b;
    public final Orientation c;
    public final Paint d;
    public Shader e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/universe_design/gradient/UDLinearGradientDrawable$Orientation;", "", "<init>", "(Ljava/lang/String;I)V", "TO_RIGHT", "TO_BOTTOM_RIGHT", "TO_BOTTOM", "TO_BOTTOM_LEFT", "TO_LEFT", "TO_TOP_LEFT", "TO_TOP", "TO_TOP_RIGHT", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Orientation extends Enum<Orientation> {
        public static final Orientation TO_BOTTOM = null;
        public static final Orientation TO_BOTTOM_LEFT = null;
        public static final Orientation TO_BOTTOM_RIGHT = null;
        public static final Orientation TO_LEFT = null;
        public static final Orientation TO_RIGHT = null;
        public static final Orientation TO_TOP = null;
        public static final Orientation TO_TOP_LEFT = null;
        public static final Orientation TO_TOP_RIGHT = null;
        public static final /* synthetic */ Orientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Orientation> getEntries() {
            return b;
        }

        static {
            Orientation r0 = new Orientation("TO_RIGHT", 0);
            TO_RIGHT = r0;
            Orientation r1 = new Orientation("TO_BOTTOM_RIGHT", 1);
            TO_BOTTOM_RIGHT = r1;
            Orientation r3 = new Orientation("TO_BOTTOM", 2);
            TO_BOTTOM = r3;
            Orientation r5 = new Orientation("TO_BOTTOM_LEFT", 3);
            TO_BOTTOM_LEFT = r5;
            Orientation r7 = new Orientation("TO_LEFT", 4);
            TO_LEFT = r7;
            Orientation r9 = new Orientation("TO_TOP_LEFT", 5);
            TO_TOP_LEFT = r9;
            Orientation r11 = new Orientation("TO_TOP", 6);
            TO_TOP = r11;
            Orientation r13 = new Orientation("TO_TOP_RIGHT", 7);
            TO_TOP_RIGHT = r13;
            Orientation[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
        }

        public static Orientation[] values() {
            return (Orientation[]) a.clone();
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) r27.a.a(Orientation.class, r1);
        }

        public Orientation(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Orientation.values().length];
            r0[Orientation.TO_BOTTOM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[Orientation.TO_BOTTOM_LEFT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[Orientation.TO_LEFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[Orientation.TO_TOP_LEFT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[Orientation.TO_TOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[Orientation.TO_TOP_RIGHT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[Orientation.TO_RIGHT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[Orientation.TO_BOTTOM_RIGHT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r1) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r1) {
    }

    public final Shader a() {
        switch(a.a[this.c.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r0 = getBounds().left;
        int r1 = getBounds().top;
        int r2 = getBounds().right;
        int r3 = getBounds().bottom;
    L17:
        return new LinearGradient(r0, r1, r2, r3, this.a, this.b, Shader.TileMode.CLAMP);
    L7:
        r0 = getBounds().left;
        r1 = getBounds().top;
        r2 = getBounds().right;
    L12:
        r3 = r1;
        goto L17
    L8:
        r0 = getBounds().left;
        r1 = getBounds().bottom;
        r2 = getBounds().right;
        r3 = getBounds().top;
        goto L17
    L9:
        r0 = getBounds().left;
        r1 = getBounds().bottom;
        r3 = getBounds().top;
    L15:
        r2 = r0;
        goto L17
    L10:
        r0 = getBounds().right;
        r1 = getBounds().bottom;
        r2 = getBounds().left;
        r3 = getBounds().top;
        goto L17
    L11:
        r0 = getBounds().right;
        r1 = getBounds().top;
        r2 = getBounds().left;
        goto L12
    L13:
        r0 = getBounds().right;
        r1 = getBounds().top;
        r2 = getBounds().left;
        r3 = getBounds().bottom;
        goto L17
    L14:
        r0 = getBounds().left;
        r1 = getBounds().top;
        r3 = getBounds().bottom;
        goto L15
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void b(Xfermode r2) {
        this.d.setXfermode(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        this.d.setShader(this.e);
        r3.drawRect(getBounds(), this.d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.e = a();
    }

    public UDLinearGradientDrawable(int r2, int r3, Orientation r4) {
        Intrinsics.checkNotNullParameter(r4, "orientation");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        Paint r5 = new Paint();
        r5.setAntiAlias(true);
        this.d = r5;
        this.e = a();
    }
}
