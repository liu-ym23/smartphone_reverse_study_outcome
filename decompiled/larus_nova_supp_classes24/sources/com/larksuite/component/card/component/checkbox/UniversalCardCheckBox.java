package com.larksuite.component.card.component.checkbox;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.lynx.tasm.base.TraceEvent;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0005NOPQRB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\"\u0010%\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0014J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020\u0016H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0016H\u0016J\u0006\u00102\u001a\u00020\u0010J\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u0010J\u000e\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u0012J\u0006\u00107\u001a\u00020\u0012J\u0010\u00108\u001a\u00020&2\b\b\u0001\u00109\u001a\u00020\u000bJ\b\u0010:\u001a\u00020\u000bH\u0007J\u0010\u0010;\u001a\u00020&2\b\b\u0001\u00109\u001a\u00020\u000bJ\u0010\u0010<\u001a\u00020&2\b\b\u0001\u00109\u001a\u00020\u000bJ\u000e\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\u0016J\u0006\u0010?\u001a\u00020\u0016J\u0010\u0010@\u001a\u00020&2\b\u0010A\u001a\u0004\u0018\u00010#J\b\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u00020&H\u0002J\u0010\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020EH\u0002J\f\u0010F\u001a\u00020E*\u00020\u0010H\u0002J\u0012\u0010:\u001a\u00020\u000b2\b\b\u0001\u0010G\u001a\u00020\u000bH\u0003J\b\u0010H\u001a\u00020\u0016H\u0002J(\u0010I\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010J\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000bH\u0002J\u001e\u0010L\u001a\u0004\u0018\u00010\u001f2\b\b\u0001\u0010M\u001a\u00020\u000b2\b\b\u0001\u00109\u001a\u00020\u000bH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox;", "Landroid/view/View;", "Landroid/widget/Checkable;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mType", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxType;", "mSize", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxSize;", "mColor", "uncheckedBackgroundColor", "hasUncheckedBackgroundColorSet", "", "uncheckedBorderColor", "hasUncheckedBorderColorSet", "mIndetermined", "mIsChecked", "mDrawableSize", "mMarkSize", "mMarkOffset", "mMarkDrawable", "Landroid/graphics/drawable/Drawable;", "mBorderDrawable", "mBackgroundDrawable", "mOnCheckedChangeListener", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$OnCheckedChangeListener;", "mNeedSetupDrawable", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawableStateChanged", "isChecked", "toggle", "setChecked", "checked", "getType", "setType", "value", "setSize", "size", "getSize", "setColor", "color", "getColor", "setUncheckedBackgroundColor", "setUncheckedBorderColor", "setIndetermined", "indetermined", "isIndetermined", "setOnCheckedChangeListener", "listener", "setupSize", "setupCurrDrawable", "res", "Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$ICheckBoxRes;", "getCheckBoxRes", "colorRes", "useCustomColor", "doDrawDrawable", "drawable", "offset", "getDrawable", "resId", "OnCheckedChangeListener", "CheckBoxType", "CheckBoxSize", "ICheckBoxRes", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class UniversalCardCheckBox extends View implements Checkable {
    public static final com.larksuite.component.card.component.checkbox.a q = null;
    public static final Lazy<UniversalCardCheckBox$Companion$checkboxRes$2.a> r = null;
    public static final Lazy<UniversalCardCheckBox$Companion$indeterminedCheckBoxRes$2.a> s = null;
    public static final Lazy<UniversalCardCheckBox$Companion$checkboxSquareRes$2.a> t = null;
    public static final Lazy<UniversalCardCheckBox$Companion$radioRes$2.a> u = null;
    public static final Lazy<UniversalCardCheckBox$Companion$checkMarkRes$2.a> v = null;
    public CheckBoxType a;
    public CheckBoxSize b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public Drawable m;
    public Drawable n;
    public Drawable o;
    public boolean p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxSize;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL_SIZE", "SMALL_SIZE", "SQUARE_SIZE", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CheckBoxSize extends Enum<CheckBoxSize> {
        public static final CheckBoxSize NORMAL_SIZE = null;
        public static final CheckBoxSize SMALL_SIZE = null;
        public static final CheckBoxSize SQUARE_SIZE = null;
        public static final /* synthetic */ CheckBoxSize[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CheckBoxSize> getEntries() {
            return b;
        }

        static {
            CheckBoxSize r0 = new CheckBoxSize("NORMAL_SIZE", 0);
            NORMAL_SIZE = r0;
            CheckBoxSize r1 = new CheckBoxSize("SMALL_SIZE", 1);
            SMALL_SIZE = r1;
            CheckBoxSize r3 = new CheckBoxSize("SQUARE_SIZE", 2);
            SQUARE_SIZE = r3;
            CheckBoxSize[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static CheckBoxSize[] values() {
            return (CheckBoxSize[]) a.clone();
        }

        public static CheckBoxSize valueOf(String r1) {
            return (CheckBoxSize) r27.a.a(CheckBoxSize.class, r1);
        }

        public CheckBoxSize(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/card/component/checkbox/UniversalCardCheckBox$CheckBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "CHECK_BOX", "RADIO", "CHECK_BOX_SQUARE", "CHECK_MARK", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CheckBoxType extends Enum<CheckBoxType> {
        public static final CheckBoxType CHECK_BOX = null;
        public static final CheckBoxType CHECK_BOX_SQUARE = null;
        public static final CheckBoxType CHECK_MARK = null;
        public static final CheckBoxType RADIO = null;
        public static final /* synthetic */ CheckBoxType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CheckBoxType> getEntries() {
            return b;
        }

        static {
            CheckBoxType r0 = new CheckBoxType("CHECK_BOX", 0);
            CHECK_BOX = r0;
            CheckBoxType r1 = new CheckBoxType("RADIO", 1);
            RADIO = r1;
            CheckBoxType r3 = new CheckBoxType("CHECK_BOX_SQUARE", 2);
            CHECK_BOX_SQUARE = r3;
            CheckBoxType r5 = new CheckBoxType("CHECK_MARK", 3);
            CHECK_MARK = r5;
            CheckBoxType[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static CheckBoxType[] values() {
            return (CheckBoxType[]) a.clone();
        }

        public static CheckBoxType valueOf(String r1) {
            return (CheckBoxType) r27.a.a(CheckBoxType.class, r1);
        }

        public CheckBoxType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final b a() {
            com.larksuite.component.card.component.checkbox.a r0 = UniversalCardCheckBox.q;
            return (b) UniversalCardCheckBox.r.getValue();
        }

        public a() {
        }
    }

    public interface b {
        int a(boolean r1);

        int b(boolean r1, boolean r2);

        int c(boolean r1, boolean r2);

        int d(boolean r1, boolean r2);

        int e(boolean r1, boolean r2);

        float f();

        int g(boolean r1, boolean r2);
    }

    public interface c {
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[CheckBoxSize.values().length];
            r0[CheckBoxSize.SMALL_SIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[CheckBoxSize.NORMAL_SIZE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r0[CheckBoxSize.SQUARE_SIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            a = r0;
            int[] r1 = new int[CheckBoxType.values().length];
            r1[CheckBoxType.CHECK_BOX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[CheckBoxType.RADIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r1[CheckBoxType.CHECK_BOX_SQUARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[CheckBoxType.CHECK_MARK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            b = r1;
        }
    }

    public final void setOnCheckedChangeListener(c r1) {
    }

    static {
        new a();
        q = new com.larksuite.component.card.component.checkbox.a();
        r = LazyKt.lazy(UniversalCardCheckBox$Companion$checkboxRes$2.INSTANCE);
        s = LazyKt.lazy(UniversalCardCheckBox$Companion$indeterminedCheckBoxRes$2.INSTANCE);
        t = LazyKt.lazy(UniversalCardCheckBox$Companion$checkboxSquareRes$2.INSTANCE);
        u = LazyKt.lazy(UniversalCardCheckBox$Companion$radioRes$2.INSTANCE);
        v = LazyKt.lazy(UniversalCardCheckBox$Companion$checkMarkRes$2.INSTANCE);
    }

    public final void d() {
        int r0 = d.a[this.b.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L6;
        int r1 = h18.d.d(getContext(), 2131169369);
    L12:
        this.j = r1;
        int r2 = (int) (r1 * b(this.a).f());
        this.k = r2;
        this.l = (this.j - r2) / 2;
        invalidate();
        return;
    L6:
        if (r0 != 3) goto L9;
        r1 = h18.d.d(getContext(), 2131165925);
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r1 = h18.d.d(getContext(), 2131169370);
        goto L12
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.i);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.p = true;
        invalidate();
    }

    public final int getColor() {
        return this.c;
    }

    public final CheckBoxSize getSize() {
        return this.b;
    }

    public final CheckBoxType getType() {
        return this.a;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.i;
    }

    public UniversalCardCheckBox(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    private final void setupCurrDrawable(b r7) {
        int r0 = r7.d(this.i, isEnabled());
        int r1 = 0;
        if (r0 != 0) goto L5;
        int r2 = 0;
    L6:
        boolean r3 = true;
        if (this.c != 0) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L17;
        if (isEnabled() == false) goto L17;
        int r5 = this.c;
    L28:
        if (this.c != 0) goto L30;
    L32:
        r3 = false;
    L33:
        if (r3 == false) goto L40;
        if (this.i == false) goto L40;
        if (isEnabled() == false) goto L40;
        r1 = this.c;
    L50:
        boolean r6 = this.i;
        isEnabled();
        this.m = c(r7.a(r6), r2);
        this.n = c(r7.e(this.i, isEnabled()), r5);
        this.o = c(r7.g(this.i, isEnabled()), r1);
        return;
    L40:
        if (this.e == true) goto L42;
    L46:
        int r8 = r7.b(this.i, isEnabled());
        if (r8 == 0) goto L50;
        r1 = UDColorUtils.getColor(getContext(), r8);
        goto L50
    L42:
        if (this.a == CheckBoxType.CHECK_MARK) goto L46;
        if (this.i == true) goto L46;
        r1 = this.d;
        goto L50
    L30:
        if (this.a == CheckBoxType.CHECK_MARK) goto L32;
    L17:
        if (this.g == true) goto L19;
    L23:
        int r9 = r7.c(this.i, isEnabled());
        if (r9 != 0) goto L26;
        r5 = 0;
        goto L28
    L26:
        r5 = UDColorUtils.getColor(getContext(), r9);
        goto L28
    L19:
        if (this.a == CheckBoxType.CHECK_MARK) goto L23;
        if (this.i == true) goto L23;
        r5 = this.f;
        goto L28
    L9:
        if (this.a == CheckBoxType.CHECK_MARK) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = UDColorUtils.getColor(getContext(), r0);
        goto L6
    }

    public final b b(CheckBoxType r2) {
        int r3 = d.b[r2.ordinal()];
        if (r3 == 1) goto L16;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L21;
        if (r3 != 4) goto L12;
        return (b) v.getValue();
    L12:
        throw new NoWhenBranchMatchedException();
    L21:
        return (b) t.getValue();
    L22:
        return (b) u.getValue();
    L16:
        if (this.h == false) goto L19;
        return (b) s.getValue();
    L19:
        return a.a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        TraceEvent.beginSection("UniversalCardCheckBox.onDraw");
        if (this.p == false) goto L5;
        setupCurrDrawable(b(this.a));
        invalidate();
        this.p = false;
    L5:
        Drawable r1 = this.o;
        if (r1 == null) goto L8;
        a(r6, r1, this.j - 4, 2);
    L8:
        Drawable r2 = this.n;
        if (r2 == null) goto L11;
        a(r6, r2, this.j, 0);
    L11:
        Drawable r3 = this.m;
        if (r3 == null) goto L14;
        a(r6, r3, this.k, this.l);
    L14:
        TraceEvent.endSection("UniversalCardCheckBox.onDraw");
        CheckBoxType r7 = CheckBoxType.CHECK_BOX;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.i != r2) goto L5;
        return;
    L5:
        this.i = r2;
        refreshDrawableState();
    }

    public final void setColor(int r1) {
        this.c = r1;
        this.p = true;
        invalidate();
    }

    public final void setIndetermined(boolean r3) {
        if (this.a == CheckBoxType.CHECK_BOX) goto L5;
        return;
    L5:
        this.h = r3;
        this.p = true;
        invalidate();
    }

    public final void setSize(CheckBoxSize r2) {
        Intrinsics.checkNotNullParameter(r2, "size");
        if (r2 != this.b) goto L5;
        return;
    L5:
        this.b = r2;
        if (this.a != CheckBoxType.CHECK_MARK) goto L8;
        this.b = CheckBoxSize.NORMAL_SIZE;
    L8:
        d();
    }

    public final void setType(CheckBoxType r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (this.a != r2) goto L5;
        return;
    L5:
        this.a = r2;
        if (r2 != CheckBoxType.CHECK_MARK) goto L9;
        setSize(CheckBoxSize.NORMAL_SIZE);
    L9:
        if (this.a != CheckBoxType.CHECK_BOX_SQUARE) goto L11;
        setSize(CheckBoxSize.SQUARE_SIZE);
    L11:
        this.p = true;
    }

    public final void setUncheckedBackgroundColor(int r2) {
        this.e = true;
        this.d = r2;
        invalidate();
    }

    public final void setUncheckedBorderColor(int r2) {
        this.g = true;
        this.f = r2;
        invalidate();
    }

    public UniversalCardCheckBox(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public final Drawable c(int r6, int r7) {
        if (r6 != 0) goto L5;
        return null;
    L5:
        com.larksuite.component.card.component.checkbox.a r0 = q;
        Context r1 = getContext();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "context");
        Pair r2 = new Pair(Integer.valueOf(r6), Integer.valueOf(r7));
        Drawable r3 = (Drawable) ((HashMap) r0.a).get(r2);
        if (r3 != null) goto L11;
        if (r7 != 0) goto L9;
        Drawable r8 = UDIconUtils.getIconDrawable(r1, r6);
    L10:
        r3 = r8;
        goto L11
    L9:
        r8 = UDIconUtils.getIconDrawable(r1, r6, r7);
    L11:
        ((HashMap) r0.a).put(r2, r3);
        return r3;
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L10;
        int r1 = this.j;
        if (r0.width != (-2)) goto L8;
        r6 = View.MeasureSpec.makeMeasureSpec((getPaddingLeft() + r1) + getPaddingRight(), 1073741824);
    L8:
        if (r0.height != (-2)) goto L10;
        r7 = View.MeasureSpec.makeMeasureSpec((r1 + getPaddingTop()) + getPaddingBottom(), 1073741824);
    L10:
        super.onMeasure(r6, r7);
    }

    public UniversalCardCheckBox(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5, 2131953837);
        this.a = CheckBoxType.CHECK_BOX;
        this.b = CheckBoxSize.NORMAL_SIZE;
        TypedArray r6 = getContext().obtainStyledAttributes(r4, new int[]{R.attr.enabled, R.attr.clickable, R.attr.checked, 2130974860, 2130974861, 2130974862, 2130974863, 2130974864, 2130974865}, r5, 2131953837);
        setClickable(r6.getBoolean(1, true));
        setChecked(r6.getBoolean(2, this.i));
        setEnabled(r6.getBoolean(0, isEnabled()));
        int r7 = r6.getInt(6, 0);
        this.a = CheckBoxType.values()[r7];
        this.c = r6.getColor(3, this.c);
        setIndetermined(r6.getBoolean(4, this.h));
        int r8 = r6.getInt(5, 0);
        setSize(CheckBoxSize.values()[r8]);
        d();
        if (r6.hasValue(7) == false) goto L6;
        setUncheckedBackgroundColor(r6.getColor(7, 0));
    L6:
        if (r6.hasValue(8) == false) goto L8;
        setUncheckedBorderColor(r6.getColor(8, 0));
    L8:
        r6.recycle();
    }

    public final void a(Canvas r4, Drawable r5, int r6, int r7) {
        int r0 = getPaddingLeft() + r7;
        int r1 = getPaddingTop() + r7;
        r5.setBounds(new Rect(r0, r1, r0 + r6, r6 + r1));
        r5.draw(r4);
        r4.save();
    }
}
