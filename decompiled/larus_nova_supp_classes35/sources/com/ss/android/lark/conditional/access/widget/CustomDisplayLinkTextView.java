package com.ss.android.lark.conditional.access.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomDisplayPageUiMode;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.a;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import u8b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\rJ*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0002J\b\u0010\u001f\u001a\u00020\tH\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/conditional/access/widget/CustomDisplayLinkTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/conditional/access/widget/CustomLoadingView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayHandler;", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "buttonTypeFunction", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/ButtonTypeFunction;", "pageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "setCustomDisplayHandler", BuildConfig.FLAVOR, "onClick", "v", "Landroid/view/View;", "onDetachedFromWindow", "startLoading", "endLoading", "linkTextColorRes", "linkLoadingColorRes", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomDisplayLinkTextView extends AppCompatTextView implements View.OnClickListener, b {
    public CustomDisplayHandler a;
    public InternalSecurityAction b;
    public a c;
    public CustomDisplayPageUiMode d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u8b.b
    public final void endLoading() {
        setEnabled(true);
        Resources r0 = getResources();
        if (this.d != CustomDisplayPageUiMode.LARK) goto L5;
        int r1 = 2131106614;
    L6:
        setTextColor(r0.getColor(r1));
        setCompoundDrawables(null, null, null, null);
        return;
    L5:
        r1 = 2131101385;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u8b.b
    public final void startLoading() {
        List r0 = CollectionsKt.listOf(new String[]{"DeviceApply", "DeviceAuth", "DeviceTokenClaimsChallenge", "DeviceCertAuth"});
        CustomDisplayHandler r1 = this.a;
        if (r1 == null) goto L5;
        String r2 = r1.type;
    L7:
        if (CollectionsKt.contains(r0, r2) == false) goto L18;
        CircularProgressDrawable r3 = new CircularProgressDrawable(getContext());
        r3.setStyle(1);
        int[] r4 = new int[1];
        Resources r5 = getResources();
        CustomDisplayPageUiMode r6 = this.d;
        CustomDisplayPageUiMode r7 = CustomDisplayPageUiMode.LARK;
        int r8 = 2131106615;
        if (r6 != r7) goto L11;
        int r9 = 2131106615;
    L12:
        r4[0] = r5.getColor(r9);
        r3.setColorSchemeColors(r4);
        r3.setCenterRadius(UIUtils.dp2px(getContext(), 5.0f));
        r3.setStrokeWidth(UIUtils.dp2px(getContext(), 1.5f));
        r3.setStrokeCap(Paint.Cap.ROUND);
        int r10 = ((int) (r3.getCenterRadius() + r3.getStrokeWidth())) * 2;
        r3.setBounds(0, 0, r10, r10);
        setCompoundDrawablePadding(UIUtils.dp2px(getContext(), 4.0f));
        setCompoundDrawables(r3, null, null, null);
        r3.start();
        setEnabled(false);
        Resources r11 = getResources();
        if (this.d == r7) goto L16;
        r8 = 2131101385;
    L16:
        setTextColor(r11.getColor(r8));
        return;
    L11:
        r9 = 2131101385;
        goto L12
    L18:
        return;
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.TextView*/.onDetachedFromWindow();
        Object[] r0 = getCompoundDrawables();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Object r3 = r0[r2];
        if ((r3 instanceof Animatable) == false) goto L9;
        Animatable r4 = (Animatable) r3;
        if (r4.isRunning() == false) goto L9;
        r4.stop();
    L9:
        r2 = r2 + 1;
        goto L3
    }

    public CustomDisplayLinkTextView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        CustomDisplayHandler r5 = this.a;
        if (r5 == null) goto L12;
        a r0 = this.c;
        if (r0 == null) goto L7;
        Boolean r6 = Boolean.valueOf(r0.dL(r5, this.b, getContext()));
    L9:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L13;
        startLoading();
        return;
    L13:
        return;
    L7:
        r6 = null;
        goto L9
    }

    public CustomDisplayLinkTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomDisplayLinkTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.d = CustomDisplayPageUiMode.LARK;
        setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setTextAppearance(2131953908);
    L5:
        setTextSize(2, 14.0f);
        setTextColor(getResources().getColor(2131106614));
        setClickable(true);
        setGravity(17);
    }
}
