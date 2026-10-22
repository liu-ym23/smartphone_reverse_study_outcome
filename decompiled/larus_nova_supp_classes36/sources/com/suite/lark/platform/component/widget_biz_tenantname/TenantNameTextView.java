package com.suite.lark.platform.component.widget_biz_tenantname;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\"\u001a\u00020!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'J0\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\nH\u0002R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\r8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_tenantname/TenantNameTextView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ivTenantNameFromXml", "Landroid/widget/TextView;", "getIvTenantNameFromXml", "()Landroid/widget/TextView;", "setIvTenantNameFromXml", "(Landroid/widget/TextView;)V", "ivTenantCertTagFromXml", "getIvTenantCertTagFromXml", "setIvTenantCertTagFromXml", "tenantNameContainerFromXml", "Landroid/widget/LinearLayout;", "getTenantNameContainerFromXml", "()Landroid/widget/LinearLayout;", "setTenantNameContainerFromXml", "(Landroid/widget/LinearLayout;)V", "tenantNameData", "Lcom/suite/lark/platform/component/widget_biz_tenantname/data/TenantNameData;", "hasValidTenantName", "", "isShowTenantCertification", "initCustomAttrs", "", "setTenantNameData", "checkTenantNameIsEllipse", "resetTenantName", "setTenantCertificationData", "certificationInfo", "Lcom/suite/lark/platform/component/widget_biz_tenantname/data/TenantCertificationData;", "onLayout", "changed", "left", "top", "right", "bottom", "setRealTenantName", "tenantName", "", "setEllipsize", "ellipsize", "Companion", "widget-biz-tenantname_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TenantNameTextView extends FrameLayout {
    public TextView a;
    public TextView b;
    public LinearLayout c;
    public gpc.a d;
    public boolean e;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TenantNameStatus.values().length];
            r0[TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[TenantNameStatus.TENANT_NAME_STATUS_HIDE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[TenantNameStatus.TENANT_NAME_STATUS_NOT_FRIEND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[TenantNameStatus.TENANT_NAME_STATUS_VISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final TextView getIvTenantCertTagFromXml() {
        KeyEvent.Callback r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131376661);
        this.b = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final TextView getIvTenantNameFromXml() {
        KeyEvent.Callback r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131376662);
        this.a = (TextView) r0;
    L6:
        return (TextView) r0;
    }

    public final LinearLayout getTenantNameContainerFromXml() {
        KeyEvent.Callback r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131388358);
        this.c = (LinearLayout) r0;
    L6:
        return (LinearLayout) r0;
    }

    public TenantNameTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        FrameLayout.inflate(getContext(), 2131568207, this);
    }

    private final void setEllipsize(int r2) {
        if (r2 != 1) goto L5;
        TextView r3 = getIvTenantNameFromXml();
        if (r3 == null) goto L30;
        r3.setEllipsize(TextUtils.TruncateAt.START);
        return;
    L30:
        return;
    L5:
        if (r2 != 2) goto L7;
        TextView r4 = getIvTenantNameFromXml();
        if (r4 == null) goto L28;
        r4.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        return;
    L28:
        return;
    L7:
        if (r2 != 3) goto L9;
        TextView r5 = getIvTenantNameFromXml();
        if (r5 == null) goto L26;
        r5.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L26:
        return;
    L9:
        if (r2 != 4) goto L31;
        TextView r6 = getIvTenantNameFromXml();
        if (r6 == null) goto L24;
        r6.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        return;
    L24:
        return;
    }

    private final void setRealTenantName(String r5) {
        StringBuilder r0 = new StringBuilder("setRealTenantName chatterId:");
        gpc.a r1 = this.d;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.e;
    L6:
        r0.append(r3);
        r0.append(", tenantName isEmpty: ");
        gpc.a r4 = this.d;
        if (r4 == null) goto L10;
        r2 = r4.a;
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        r0.append(r6);
        Log.i("TenantName", r0.toString());
        if (r5 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L25;
        getIvTenantNameFromXml().setText(r5);
        this.e = true;
        setVisibility(0);
        return;
    L25:
        setVisibility(8);
        return;
    L19:
        if (r5.length() == 0) goto L22;
        r7 = false;
        goto L23
    L12:
        if (r2.length() == 0) goto L15;
        r6 = false;
        goto L16
    L5:
        r3 = null;
        goto L6
    }

    public final void setIvTenantCertTagFromXml(TextView r1) {
        this.b = r1;
    }

    public final void setIvTenantNameFromXml(TextView r1) {
        this.a = r1;
    }

    public final void setTenantCertificationData(TenantCertificationData r5) {
        qqb.a.h("TenantName");     // Catch: Throwable -> L29
        if (this.e == false) goto L26;
        if (r5 == null) goto L26;
        StringBuilder r2 = new StringBuilder("setTenantCertificationData chatterId:");     // Catch: Throwable -> L29
        gpc.a r0 = this.d;     // Catch: Throwable -> L29
        if (r0 == null) goto L10;
        String r1 = r0.e;     // Catch: Throwable -> L29
    L11:
        r2.append(r1);     // Catch: Throwable -> L29
        r2.append(", certificationInfo.isShowCertSign: ");     // Catch: Throwable -> L29
        r2.append(r5.a);     // Catch: Throwable -> L29
        r2.append(", certificationInfo.CertificateStatus: ");     // Catch: Throwable -> L29
        r2.append(r5.b);     // Catch: Throwable -> L29
        Log.i("TenantName", r2.toString());     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r5.a, Boolean.TRUE) == false) goto L23;
        fpc.a r3 = new fpc.a(getContext());     // Catch: Throwable -> L29
        r3.b = r5;     // Catch: Throwable -> L29
        SpannableStringBuilder r6 = r3.a();     // Catch: Throwable -> L29
        if (r6 != null) goto L16;
    L19:
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L29
    L24:
        qqb.a.a();
        return;
    L22:
        getIvTenantCertTagFromXml().setVisibility(0);     // Catch: Throwable -> L29
        getIvTenantCertTagFromXml().setText(r6);     // Catch: Throwable -> L29
        goto L24
    L16:
        if (r6.length() == 0) goto L19;
        r4 = false;
        goto L20
    L23:
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L29
        goto L24
    L10:
        r1 = null;
    L26:
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L29
        qqb.a.a();
        return;
    L29:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public final void setTenantNameContainerFromXml(LinearLayout r1) {
        this.c = r1;
    }

    public final void setTenantNameData(gpc.a r7) {
        qqb.a.h("TenantName");     // Catch: Throwable -> L45
        this.d = r7;     // Catch: Throwable -> L45
        this.e = false;     // Catch: Throwable -> L45
        if (r7 != null) goto L8;
        setVisibility(4);     // Catch: Throwable -> L45
        qqb.a.a();
        return;
    L8:
        getIvTenantCertTagFromXml().setVisibility(8);     // Catch: Throwable -> L45
        getIvTenantNameFromXml().invalidate();     // Catch: Throwable -> L45
        getIvTenantNameFromXml().requestLayout();     // Catch: Throwable -> L45
        TenantNameStatus r4 = r7.b;     // Catch: Throwable -> L45
        if (r4 != null) goto L11;
    L42:
        setRealTenantName(r7.a);     // Catch: Throwable -> L45
        qqb.a.a();
        return;
    L11:
        if (r7.d == true) goto L42;
        if (r4 == TenantNameStatus.TENANT_NAME_STATUS_UNKNOWN) goto L42;
        StringBuilder r5 = new StringBuilder("setTenantNameData chatterId:");     // Catch: Throwable -> L45
        r5.append(r7.e);     // Catch: Throwable -> L45
        r5.append(", tenantNameStatus:");     // Catch: Throwable -> L45
        r5.append(r7.b);     // Catch: Throwable -> L45
        r5.append(", tenantName isEmpty: ");     // Catch: Throwable -> L45
        String r0 = r7.a;     // Catch: Throwable -> L45
        if (r0 != null) goto L18;
    L21:
        boolean r1 = true;
    L22:
        r5.append(r1);     // Catch: Throwable -> L45
        Log.i("TenantName", r5.toString());     // Catch: Throwable -> L45
        TenantNameStatus r2 = r7.b;     // Catch: Throwable -> L45
        if (r2 != null) goto L25;
        int r3 = -1;
    L26:
        if (r3 != 1) goto L28;
        setVisibility(4);     // Catch: Throwable -> L45
    L40:
        qqb.a.a();
        return;
    L28:
        if (r3 != 2) goto L30;
        setVisibility(0);     // Catch: Throwable -> L45
        getIvTenantNameFromXml().setText(UIUtils.getString(getContext(), 2131891289));     // Catch: Throwable -> L45
        goto L40
    L30:
        if (r3 == 3) goto L35;
        if (r3 == 4) goto L33;
        setVisibility(4);     // Catch: Throwable -> L45
        goto L40
    L33:
        setRealTenantName(r7.a);     // Catch: Throwable -> L45
        goto L40
    L35:
        if (r7.c == false) goto L37;
        setRealTenantName(r7.a);     // Catch: Throwable -> L45
        goto L40
    L37:
        setVisibility(0);     // Catch: Throwable -> L45
        getIvTenantNameFromXml().setText(UIUtils.getString(getContext(), 2131891286));     // Catch: Throwable -> L45
        goto L40
    L25:
        r3 = b.a[r2.ordinal()];     // Catch: Throwable -> L45
        goto L26
    L18:
        if (r0.length() == 0) goto L21;
        r1 = false;
    L45:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    public TenantNameTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public TenantNameTextView(Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        FrameLayout.inflate(getContext(), 2131568207, this);
        Resources.Theme r3 = r17.getTheme();     // Catch: Throwable -> L27
        int r6 = R.attr.gravity;
        int r9 = 2;
        int r10 = 3;
        int r14 = 7;
        TypedArray r4 = r3.obtainStyledAttributes(r18, new int[]{R.attr.gravity, 2130969826, 2130969830, 2130969941, 2130972701, 2130974095, 2130974525, 2130974542}, r19, 0);     // Catch: Throwable -> L27
        int r5 = r4.getIndexCount();     // Catch: Throwable -> L27
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L83;
        int r15 = r4.getIndex(r7);     // Catch: Throwable -> L27
        if (r15 != r14) goto L13;
        float r16 = UIUtils.px2sp(r17, r4.getDimensionPixelSize(r15, 0));     // Catch: Throwable -> L27
        TextView r110 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r110 == null) goto L10;
        r110.setTextSize(r16);     // Catch: Throwable -> L27
    L10:
        TextView r111 = getIvTenantCertTagFromXml();     // Catch: Throwable -> L27
        if (r111 == null) goto L58;
        r111.setTextSize(r16);     // Catch: Throwable -> L27
    L58:
        r7 = r7 + 1;
        r6 = R.attr.gravity;
        r9 = 2;
        r10 = 3;
        r14 = 7;
        goto L4
    L13:
        if (r15 != 6) goto L17;
        TextView r112 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r112 == null) goto L58;
        r112.setTextColor(r4.getColor(r15, 0));     // Catch: Throwable -> L27
        goto L58
    L17:
        if (r15 != 4) goto L21;
        int r113 = r4.getInt(r15, 1);     // Catch: Throwable -> L27
        TextView r114 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r114 == null) goto L58;
        r114.setMaxLines(r113);     // Catch: Throwable -> L27
        goto L58
    L21:
        if (r15 != r10) goto L23;
        setEllipsize(r4.getInt(r15, -1));     // Catch: Throwable -> L27
        goto L58
    L23:
        if (r15 != 1) goto L29;
        TextView r115 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r115 == null) goto L58;
        r115.setCompoundDrawablePadding(r4.getDimensionPixelSize(r15, 0));     // Catch: Throwable -> L27
        goto L58
    L29:
        FrameLayout.LayoutParams r116 = null;
        if (r15 != 0) goto L43;
        LinearLayout r117 = getTenantNameContainerFromXml();     // Catch: Throwable -> L27
        if (r117 == null) goto L34;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();     // Catch: Throwable -> L27
    L36:
        if ((r118 instanceof FrameLayout.LayoutParams) == false) goto L38;
        r116 = (FrameLayout.LayoutParams) r118;     // Catch: Throwable -> L27
    L38:
        if (r116 == null) goto L58;
        TypedArray r11 = r17.obtainStyledAttributes(r18, new int[]{r6});     // Catch: Throwable -> L27
        r116.gravity = r11.getInteger(0, 8388613);     // Catch: Throwable -> L27
        LinearLayout r119 = getTenantNameContainerFromXml();     // Catch: Throwable -> L27
        if (r119 == null) goto L42;
        r119.setLayoutParams(r116);     // Catch: Throwable -> L27
    L42:
        r11.recycle();     // Catch: Throwable -> L27
        goto L58
    L34:
        r118 = null;
        goto L36
    L43:
        if (r15 != r9) goto L54;
        TextView r12 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r12 == null) goto L58;
        if (r12.getLayoutDirection() != 1) goto L51;
        TextView r8 = (TextView) r12.findViewById(2131376662);     // Catch: Throwable -> L27
        if (r8 == null) goto L58;
        r8.setCompoundDrawablesWithIntrinsicBounds(null, null, r4.getDrawable(r15), null);     // Catch: Throwable -> L27
        goto L58
    L51:
        TextView r13 = (TextView) r12.findViewById(2131376662);     // Catch: Throwable -> L27
        if (r13 == null) goto L58;
        r13.setCompoundDrawablesWithIntrinsicBounds(r4.getDrawable(r15), null, null, null);     // Catch: Throwable -> L27
        goto L58
    L54:
        if (r15 != 5) goto L58;
        TextView r20 = getIvTenantNameFromXml();     // Catch: Throwable -> L27
        if (r20 == null) goto L58;
        r20.setSingleLine(r4.getBoolean(r15, false));     // Catch: Throwable -> L27
        goto L58
    L83:
        return;
    L27:
        th = move-exception;
        Log.e("TenantName", "TenantNameTextView init failed", th);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    L13:
        th = move-exception;
        Log.e("TenantName", "adjust 2 lines layout failed", th);
        return;
    L4:
        if (getIvTenantNameFromXml().getLayout().getLineCount() > 1) goto L6;
        return;
    L6:
        if (getTenantNameContainerFromXml().getOrientation() == 1) goto L19;
        TextView r6 = getIvTenantNameFromXml();     // Catch: Throwable -> L13
        gpc.a r7 = this.d;     // Catch: Throwable -> L13
        if (r7 == null) goto L10;
        String r8 = r7.a;     // Catch: Throwable -> L13
    L11:
        r6.setText(r8);     // Catch: Throwable -> L13
        getIvTenantNameFromXml().invalidate();     // Catch: Throwable -> L13
        getIvTenantNameFromXml().requestLayout();     // Catch: Throwable -> L13
        getTenantNameContainerFromXml().setOrientation(1);     // Catch: Throwable -> L13
        return;
    L10:
        r8 = null;
        goto L11
    }
}
