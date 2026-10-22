package com.obric.oui.sheet.v2;

import ai.j0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import cn.nubia.neopush.commons.Constant;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zm.p;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001xB'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\"\u00102\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020\u00018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010;\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010\u0010R\"\u0010C\u001a\u00020<8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010L\u001a\u00020D2\u0006\u0010E\u001a\u00020D8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR.\u0010R\u001a\u0004\u0018\u00010\u00112\b\u0010E\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\u0013R.\u0010V\u001a\u0004\u0018\u00010\u00112\b\u0010E\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010N\u001a\u0004\bT\u0010P\"\u0004\bU\u0010\u0013R.\u0010Z\u001a\u0004\u0018\u00010\u00112\b\u0010E\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010N\u001a\u0004\bX\u0010P\"\u0004\bY\u0010\u0013R*\u0010b\u001a\u00020[2\u0006\u0010E\u001a\u00020[8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010j\u001a\u00020c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010n\u001a\u00020c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010e\u001a\u0004\bl\u0010g\"\u0004\bm\u0010iR$\u0010u\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0011\u0010w\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\bv\u0010\u0016¨\u0006y"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar;", "Landroid/widget/FrameLayout;", "Lcom/obric/oui/material/b;", "Lcom/obric/oui/material/d;", "", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "", "setCenterText", "(I)V", "", Constant.TITLE, "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "Landroid/view/View;", "view", "setBackdropTarget", "(Landroid/view/View;)V", "getDefaultTargetView", "()Landroid/view/View;", "getCenterTitleGap", "()I", "getTitleBarContentWidth", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "getMLeftContainer", "()Landroid/widget/LinearLayout;", "setMLeftContainer", "(Landroid/widget/LinearLayout;)V", "mLeftContainer", "b", "getMRightContainer", "setMRightContainer", "mRightContainer", "c", "Landroid/widget/FrameLayout;", "getMCenterContainer", "()Landroid/widget/FrameLayout;", "setMCenterContainer", "(Landroid/widget/FrameLayout;)V", "mCenterContainer", "d", "getMFixedCenterContainer", "setMFixedCenterContainer", "mFixedCenterContainer", "s", "I", "getCurrentTheme", "setCurrentTheme", "currentTheme", "Lcom/obric/oui/button/OIconButtonFloating;", "x", "Lcom/obric/oui/button/OIconButtonFloating;", "getMLeftActionBack", "()Lcom/obric/oui/button/OIconButtonFloating;", "setMLeftActionBack", "(Lcom/obric/oui/button/OIconButtonFloating;)V", "mLeftActionBack", "", "value", "y", "Z", "getShowLeftBack", "()Z", "setShowLeftBack", "(Z)V", "showLeftBack", "z", "Ljava/lang/String;", "getSubTitleText", "()Ljava/lang/String;", "setSubTitleText", "subTitleText", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getTitleText", "setTitleText", "titleText", "B", "getDesText", "setDesText", "desText", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "C", "Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "getMTitlePosition", "()Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "setMTitlePosition", "(Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;)V", "mTitlePosition", "", "D", "F", "getTouchStartX", "()F", "setTouchStartX", "(F)V", "touchStartX", ExifInterface.LONGITUDE_EAST, "getTouchStartY", "setTouchStartY", "touchStartY", "Landroid/view/VelocityTracker;", "Landroid/view/VelocityTracker;", "getVelocityTracker", "()Landroid/view/VelocityTracker;", "setVelocityTracker", "(Landroid/view/VelocityTracker;)V", "velocityTracker", "getMTitleView", "mTitleView", "TitlePosition", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSheetTitleBar extends FrameLayout implements com.obric.oui.material.b, com.obric.oui.material.d {
    public String A;
    public String B;
    public TitlePosition C;
    public float D;
    public float E;
    public VelocityTracker F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f14460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f14461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f14462c;
    public FrameLayout d;
    public final ViewGroup e;
    public final TextView f;
    public final TextView g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f14463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f14464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f14465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OTextView f14466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f14467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f14468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f14469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14472q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14473r;
    public int s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f14474t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f14475u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14476v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Function1 f14477w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OIconButtonFloating f14478x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f14479y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f14480z;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetTitleBar$TitlePosition;", "", "", "value", "I", "getValue", "()I", "FIXED_CENTER", "FLOW_WITH_ACTION", "LEFT_IN_ACTION", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum TitlePosition extends Enum<TitlePosition> {
        public static final TitlePosition FIXED_CENTER = null;
        public static final TitlePosition FLOW_WITH_ACTION = null;
        public static final TitlePosition LEFT_IN_ACTION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitlePosition[] f14481a = null;
        private final int value;

        static {
            TitlePosition r5 = new TitlePosition("FIXED_CENTER", 0, 0);
            FIXED_CENTER = r5;
            TitlePosition r10 = new TitlePosition("FLOW_WITH_ACTION", 1, 1);
            FLOW_WITH_ACTION = r10;
            TitlePosition r11 = new TitlePosition("LEFT_IN_ACTION", 2, 2);
            LEFT_IN_ACTION = r11;
            f14481a = new TitlePosition[]{r5, r10, r11};
        }

        public TitlePosition(String r5, int r10, int r11) {
            super(r5, r10);
            this.value = r11;
        }

        public static TitlePosition valueOf(String r5) {
            return (TitlePosition) Enum.valueOf(TitlePosition.class, r5);
        }

        public static TitlePosition[] values() {
            return (TitlePosition[]) f14481a.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmOverloads
    public OSheetTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static int c(LinearLayout r5) {
        int r10 = 0;
        if (r5.getVisibility() == 0) goto L5;
    L12:
        return 0;
    L5:
        if (r5.getMeasuredWidth() <= 0) goto L12;
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        r10 = r12.getMarginStart() + r12.getMarginEnd();
    L11:
        return r5.getMeasuredWidth() + r10;
    }

    private final int getCenterTitleGap() {
        if (this.f14470o == false) goto L6;
        return this.f14472q;
    L6:
        return this.f14471p;
    }

    private final View getDefaultTargetView() {
        Integer r5 = com.obric.oui.material.n.f13677a;
        return this;
    }

    private final int getTitleBarContentWidth() {
        ViewGroup r5 = this.e;
        ViewGroup r10 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r5 = null;
    L6:
        if (r5.getMeasuredWidth() <= 0) goto L13;
        ViewGroup r11 = this.e;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L14:
        return r10.getMeasuredWidth();
    L10:
        r10 = r11;
        goto L14
    L13:
        return getMeasuredWidth();
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        this.f14476v = r5;
        p.q(CollectionsKt.listOf(getMLeftActionBack()), r5);
        a.a.F(this, r5);
    }

    public final Pair b(int r10) {
        ViewGroup r5 = this.e;
        ViewGroup r11 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
        r5 = null;
    L5:
        int r12 = r5.getPaddingLeft();
        ViewGroup r13 = this.e;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mTitleBarRoot");
    L9:
        int r14 = r11.getPaddingRight();
        int r15 = getCenterTitleGap();
        int r16 = c(getMLeftContainer());
        int r17 = c(getMRightContainer());
        if (r16 <= 0) goto L12;
        int r18 = (r12 + r16) + r15;
    L13:
        if (r17 <= 0) goto L15;
        int r19 = ((r10 - r14) - r17) - r15;
    L17:
        return TuplesKt.to(Integer.valueOf(r18), Integer.valueOf(r19));
    L15:
        r19 = (r10 - r14) - this.f14473r;
        goto L17
    L12:
        r18 = r12 + this.f14473r;
        goto L13
    L8:
        r11 = r13;
        goto L9
    }

    public final boolean d() {
        if (this.C == TitlePosition.FIXED_CENTER) goto L5;
    L19:
        return false;
    L5:
        if (getMFixedCenterContainer().getVisibility() != 0) goto L19;
        TextView r5 = this.f14463h;
        TextView r10 = null;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r5 = null;
    L10:
        if (r5.getVisibility() == 0) goto L18;
        TextView r11 = this.f14464i;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L17:
        if (r10.getVisibility() != 0) goto L19;
    L15:
        r10 = r11;
    L18:
        return true;
    }

    @Override // com.obric.oui.material.b
    public final void e() {
        int r5 = this.f14476v;
        if (r5 == (-1)) goto L6;
        p.l(this, r5);
        return;
    L6:
        p.m(this, this.f14475u);
    }

    public final void f() {
        int r5 = this.s;
        com.obric.oui.material.c r10 = null;
        if (r5 != 0) goto L5;
        TextView r11 = this.g;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r11 = null;
    L12:
        if (r11.getVisibility() != 0) goto L17;
        TextView r12 = this.g;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        r12 = null;
    L16:
        int r13 = r12.getTextColors().getDefaultColor();
    L27:
        boolean r14 = !ym.h.j(r13);
    L28:
        com.obric.oui.material.c r15 = (com.obric.oui.material.c) this.f14477w.invoke(Boolean.valueOf(!r14));
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("currentMaskMaterialConfig");
    L32:
        com.obric.oui.material.n.o(this, r10, this.f14476v);
        View r16 = this.f14474t;
        if (r16 != null) goto L36;
        r16 = this;
    L36:
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.obric.oui.material.n.r(r16, this);
        return;
    L31:
        r10 = r15;
        goto L32
    L17:
        TextView r17 = this.f14463h;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r17 = null;
    L21:
        if (r17.getVisibility() != 0) goto L26;
        TextView r18 = this.f14463h;
        if (r18 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r18 = null;
    L25:
        r13 = r18.getTextColors().getDefaultColor();
        goto L27
    L26:
        r13 = ViewCompat.MEASURED_STATE_MASK;
        goto L27
    L5:
        if (r5 != 2) goto L7;
        r14 = true;
        goto L28
    L7:
        r14 = false;
        goto L28
    }

    public final int getCurrentTheme() {
        return this.s;
    }

    public final String getDesText() {
        return this.B;
    }

    public final FrameLayout getMCenterContainer() {
        FrameLayout r5 = this.f14462c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mCenterContainer");
        return null;
    }

    public final FrameLayout getMFixedCenterContainer() {
        FrameLayout r5 = this.d;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterContainer");
        return null;
    }

    public final OIconButtonFloating getMLeftActionBack() {
        OIconButtonFloating r5 = this.f14478x;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftActionBack");
        return null;
    }

    public final LinearLayout getMLeftContainer() {
        LinearLayout r5 = this.f14460a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLeftContainer");
        return null;
    }

    public final LinearLayout getMRightContainer() {
        LinearLayout r5 = this.f14461b;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightContainer");
        return null;
    }

    public final TitlePosition getMTitlePosition() {
        return this.C;
    }

    public final TextView getMTitleView() {
        TitlePosition r5 = this.C;
        int r10 = n.f14519a[r5.ordinal()];
        if (r10 != 1) goto L5;
        TextView r11 = this.f14463h;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        return null;
    L22:
        return r11;
    L5:
        if (r10 != 2) goto L7;
        r11 = this.f;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        return null;
    L7:
        if (r10 != 3) goto L13;
        r11 = this.g;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
        return null;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean getShowLeftBack() {
        return this.f14479y;
    }

    public final String getSubTitleText() {
        return this.f14480z;
    }

    public final String getTitleText() {
        return this.A;
    }

    public final TextView getTitleView() {
        return getMTitleView();
    }

    public final float getTouchStartX() {
        return this.D;
    }

    public final float getTouchStartY() {
        return this.E;
    }

    public final VelocityTracker getVelocityTracker() {
        return this.F;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        if (r5 == null) goto L6;
        this.f14470o = p.t(r5.fontScale);
    L6:
        this.f14471p = com.lynx.tasm.utils.a.B(12, this);
        this.f14472q = com.lynx.tasm.utils.a.B(4, this);
        this.f14473r = com.lynx.tasm.utils.a.B(8, this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (d() == true) goto L5;
        return;
    L5:
        int r14 = getTitleBarContentWidth();
        if (r14 > 0) goto L8;
        return;
    L8:
        Pair r15 = b(r14);
        int r16 = ((Number) r15.component1()).intValue();
        int r17 = ((Number) r15.component2()).intValue();
        int r18 = Math.max(0, r17 - r16);
        int r19 = getMFixedCenterContainer().getMeasuredWidth();
        int r20 = (r14 - r19) / 2;
        int r21 = r20 + r19;
        if (r19 <= r18) goto L11;
    L10:
        r20 = r16;
    L17:
        if (this.f14467l == false) goto L20;
        if (r19 > r18) goto L20;
        r20 = j0.c(r18, r19, 2, r16);
        r17 = r20 + r19;
    L20:
        getMFixedCenterContainer().layout(r20, getMFixedCenterContainer().getTop(), r17, getMFixedCenterContainer().getBottom());
        return;
    L11:
        if (r20 >= r16) goto L13;
        r17 = r16 + r19;
        goto L10
    L13:
        if (r21 <= r17) goto L15;
        r20 = r17 - r19;
        goto L17
    L15:
        r17 = r21;
        goto L17
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        boolean r5 = false;
        this.f14467l = false;
        TextView r12 = this.f14463h;
        TextView r13 = null;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r12 = null;
    L5:
        r12.setMaxWidth(this.f14468m);
        TextView r14 = this.f14464i;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r14 = null;
    L8:
        r14.setMaxWidth(this.f14469n);
        super.onMeasure(r10, r11);
        if (d() == true) goto L11;
        return;
    L11:
        int r15 = getTitleBarContentWidth();
        if (r15 > 0) goto L14;
        return;
    L14:
        Pair r16 = b(r15);
        int r17 = ((Number) r16.component1()).intValue();
        int r18 = ((Number) r16.component2()).intValue();
        int r19 = r15 / 2;
        int r20 = Math.max(0, Math.min((r19 - r17) * 2, (r18 - r19) * 2));
        int r21 = Math.max(0, r18 - r17);
        if (getMFixedCenterContainer().getMeasuredWidth() <= r20) goto L39;
        boolean r22 = true;
        this.f14467l = true;
        int r23 = Math.min(this.f14468m, r21);
        int r24 = Math.min(this.f14469n, r21);
        TextView r25 = this.f14463h;
        if (r25 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r25 = null;
    L20:
        if (r25.getMaxWidth() == r23) goto L25;
        TextView r26 = this.f14463h;
        if (r26 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r26 = null;
    L24:
        r26.setMaxWidth(r23);
        r5 = true;
    L25:
        TextView r27 = this.f14464i;
        if (r27 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r27 = null;
    L29:
        if (r27.getMaxWidth() == r24) goto L35;
        TextView r28 = this.f14464i;
        if (r28 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L34:
        r13.setMaxWidth(r24);
    L36:
        if (r22 == false) goto L40;
        super.onMeasure(r10, r11);
        return;
    L40:
        return;
    L33:
        r13 = r28;
        goto L34
    L35:
        r22 = r5;
        goto L36
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        this.f14474t = r5;
        if (r5 != null) goto L6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.obric.oui.material.n.r(this, this);
        View r10 = getDefaultTargetView();
        getMLeftActionBack().setBackdropTarget(r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.obric.oui.material.n.r(r5, this);
        List r11 = CollectionsKt.listOf(getMLeftActionBack());
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ((com.obric.oui.material.d) r12.next()).setBackdropTarget(r5);
        goto L8
    }

    public final void setCenterText(int r5) {
        setTitleText(getResources().getString(r5));
    }

    public final void setCurrentTheme(int r5) {
        this.s = r5;
    }

    public final void setDesText(String r5) {
        this.B = r5;
        FrameLayout r10 = null;
        OTextView r11 = null;
        if (r5 != null) goto L5;
    L15:
        FrameLayout r12 = this.f14465j;
        if (r12 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
    L19:
        r10.setVisibility(8);
        return;
    L18:
        r10 = r12;
        goto L19
    L5:
        if (r5.length() == 0) goto L15;
        FrameLayout r13 = this.f14465j;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mDesContainerView");
        r13 = null;
    L10:
        r13.setVisibility(0);
        OTextView r14 = this.f14466k;
        if (r14 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
    L14:
        r11.setText(r5);
        return;
    L13:
        r11 = r14;
        goto L14
    }

    public final void setMCenterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14462c = r5;
    }

    public final void setMFixedCenterContainer(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.d = r5;
    }

    public final void setMLeftActionBack(OIconButtonFloating r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14478x = r5;
    }

    public final void setMLeftContainer(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14460a = r5;
    }

    public final void setMRightContainer(LinearLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.f14461b = r5;
    }

    public final void setMTitlePosition(TitlePosition r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        this.C = r10;
        int r11 = n.f14519a[r10.ordinal()];
        TextView r12 = null;
        if (r11 != 1) goto L5;
        TextView r13 = this.f14463h;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r13 = null;
    L34:
        r13.setVisibility(0);
        TextView r14 = this.f;
        if (r14 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r14 = null;
    L37:
        r14.setVisibility(8);
        TextView r15 = this.g;
        if (r15 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L41:
        r12.setVisibility(8);
    L42:
        getMTitleView().setText(this.A);
        return;
    L40:
        r12 = r15;
        goto L41
    L5:
        if (r11 != 2) goto L7;
        TextView r16 = this.f14463h;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r16 = null;
    L23:
        r16.setVisibility(8);
        TextView r17 = this.f;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r17 = null;
    L26:
        r17.setVisibility(0);
        TextView r18 = this.g;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L30:
        r12.setVisibility(8);
        goto L42
    L29:
        r12 = r18;
        goto L30
    L7:
        if (r11 != 3) goto L42;
        TextView r19 = this.f14463h;
        if (r19 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r19 = null;
    L12:
        r19.setVisibility(8);
        TextView r20 = this.f;
        if (r20 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mCenterTitleView");
        r20 = null;
    L15:
        r20.setVisibility(8);
        TextView r21 = this.g;
        if (r21 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLeftTitleView");
    L19:
        r12.setVisibility(0);
        setShowLeftBack(false);
        goto L42
    L18:
        r12 = r21;
        goto L19
    }

    public final void setShowLeftBack(boolean r5) {
        this.f14479y = r5;
        OIconButtonFloating r10 = getMLeftActionBack();
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        if (this.C != TitlePosition.LEFT_IN_ACTION) goto L10;
        getMLeftActionBack().setVisibility(8);
        return;
    L10:
        return;
    L5:
        r11 = 8;
        goto L6
    }

    public final void setSubTitleText(String r5) {
        this.f14480z = r5;
        TextView r10 = null;
        if (r5 != null) goto L9;
        TextView r11 = this.f14464i;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L8:
        r10.setVisibility(8);
        return;
    L7:
        r10 = r11;
        goto L8
    L9:
        TextView r12 = this.f14464i;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
        r12 = null;
    L12:
        r12.setVisibility(0);
        TextView r13 = this.f14464i;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L16:
        r10.setText(r5);
        return;
    L15:
        r10 = r13;
        goto L16
    }

    public final void setTitleText(String r5) {
        this.A = r5;
        if (r5 != null) goto L5;
        getMTitleView().setVisibility(4);
        return;
    L5:
        getMTitleView().setVisibility(0);
        getMTitleView().setText(r5);
    }

    public final void setTouchStartX(float r5) {
        this.D = r5;
    }

    public final void setTouchStartY(float r5) {
        this.E = r5;
    }

    public final void setVelocityTracker(VelocityTracker r5) {
        this.F = r5;
    }

    @JvmOverloads
    public OSheetTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSheetTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    public final void setCenterText(String r5) {
        Intrinsics.checkNotNullParameter(r5, Constant.TITLE);
        setTitleText(r5);
    }

    @JvmOverloads
    public OSheetTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        this.f14468m = Integer.MAX_VALUE;
        this.f14469n = Integer.MAX_VALUE;
        this.f14470o = p.t(r5.getResources().getConfiguration().fontScale);
        this.f14475u = true;
        this.f14476v = 2;
        this.f14477w = new OSheetTitleBar$maskMaterial$1(this);
        this.f14479y = true;
        TitlePosition r12 = TitlePosition.FIXED_CENTER;
        this.C = r12;
        this.f14471p = com.lynx.tasm.utils.a.B(12, this);
        this.f14472q = com.lynx.tasm.utils.a.B(4, this);
        this.f14473r = com.lynx.tasm.utils.a.B(8, this);
        View.inflate(r5, R$layout.o_sheet_title_bar_container_v2, this);
        this.e = (ViewGroup) findViewById(R$id.sheet_title_bar_main);
        this.f = (TextView) findViewById(R$id.center_title);
        this.g = (TextView) findViewById(R$id.left_title);
        setMLeftContainer((LinearLayout) findViewById(R$id.ll_left_action_container));
        setMRightContainer((LinearLayout) findViewById(R$id.ll_right_action_container));
        setMCenterContainer((FrameLayout) findViewById(R$id.fl_center_action_container));
        setMFixedCenterContainer((FrameLayout) findViewById(R$id.fl_fixed_center_action_container));
        this.f14463h = (TextView) findViewById(R$id.fixed_center_title);
        setMLeftActionBack((OIconButtonFloating) findViewById(R$id.left_action_back));
        this.f14464i = (TextView) findViewById(R$id.fixed_center_sub_title);
        this.f14465j = (FrameLayout) findViewById(R$id.sheet_title_bar_des);
        OTextView r13 = (OTextView) findViewById(R$id.sheet_title_bar_des_text);
        this.f14466k = r13;
        TextView r14 = null;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDesTextView");
        r13 = null;
    L5:
        r13.setEnableAutoAlignLeft(true);
        TextView r15 = this.f14463h;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterTitleView");
        r15 = null;
    L8:
        this.f14468m = r15.getMaxWidth();
        TextView r16 = this.f14464i;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFixedCenterSubTitleView");
    L12:
        this.f14469n = r14.getMaxWidth();
        if (r10 == null) goto L20;
        TypedArray r17 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCTitleBar, 0, 0);
        setMTitlePosition(TitlePosition.values()[r17.getInt(R$styleable.OCTitleBar_oui_title_pos, r12.getValue())]);     // Catch: Throwable -> L17
        setTitleText(r17.getString(R$styleable.OCTitleBar_oui_title_text));     // Catch: Throwable -> L17
        setDesText(r17.getString(R$styleable.OCTitleBar_oui_title_des_text));     // Catch: Throwable -> L17
        setShowLeftBack(r17.getBoolean(R$styleable.OCTitleBar_oui_useBackIcon, true));     // Catch: Throwable -> L17
        setSubTitleText(r17.getString(R$styleable.OCTitleBar_oui_sub_title_text));     // Catch: Throwable -> L17
        r17.recycle();
    L17:
        th = move-exception;
        r17.recycle();
        throw th;
    L20:
        f();
        return;
    L11:
        r14 = r16;
        goto L12
    }
}
