package com.ss.android.lark.conditional.access.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.lark.pb.security.v1.CustomDisplayHandler;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.button.d;
import com.larksuite.component.universe_design.button.e;
import com.ss.android.lark.conditional.access.nopermission.ui.custom.a;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u8b.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\fB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\rJ*\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J \u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tH\u0002J\u0012\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u001cH\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/conditional/access/widget/CustomDisplayUDButton;", "Lcom/larksuite/component/universe_design/button/UDButton;", "Landroid/view/View$OnClickListener;", "Lcom/ss/android/lark/conditional/access/widget/CustomLoadingView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handler", "Lcom/bytedance/lark/pb/security/v1/CustomDisplayHandler;", "internalSecurityAction", "Lcom/ss/android/lark/conditional/access/traffic/InternalSecurityAction;", "buttonTypeFunction", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/ButtonTypeFunction;", "isLoading", BuildConfig.FLAVOR, "normalBackground", "Landroid/content/res/ColorStateList;", "normalTextColor", "loadingBackgroundRes", "loadingProgressColorRes", "setCustomDisplayHandler", BuildConfig.FLAVOR, "pageUiMode", "Lcom/ss/android/lark/conditional/access/nopermission/ui/custom/CustomDisplayPageUiMode;", "applyDoubaoStyle", "applyDoubaoPlainStyle", "doubaoPrimaryTextColorStateList", "doubaoPlainTextColorStateList", "doubaoStaticWhiteTextColorStateList", "doubaoColorStateList", "normal", "pressed", "disabled", "onClick", "v", "Landroid/view/View;", "startLoading", "endLoading", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomDisplayUDButton extends UDButton implements View.OnClickListener, b {
    public CustomDisplayHandler a;
    public InternalSecurityAction b;
    public a c;
    public boolean d;
    public ColorStateList e;
    public ColorStateList f;
    public int g;
    public int h;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u8b.b
    public final void endLoading() {
        this.d = false;
        CustomDisplayHandler r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.name;
        if (r1 == null) goto L6;
    L7:
        e.a r2 = e.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        e.b(this, r1);
        ColorStateList r3 = this.f;
        if (r3 == null) goto L10;
        setTextColor(r3);
    L10:
        ColorStateList r4 = this.e;
        if (r4 == null) goto L14;
        setBackgroundColor(r4);
        return;
    L14:
        return;
    L6:
        r1 = BuildConfig.FLAVOR;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u8b.b
    public final void startLoading() {
        this.d = true;
        d r0 = new d();
        CustomDisplayHandler r1 = this.a;
        if (r1 == null) goto L7;
        String r2 = r1.name;
        if (r2 == null) goto L7;
    L8:
        ((com.larksuite.component.universe_design.button.a) r0).b = r2;
        r0.j = Integer.valueOf(getResources().getColor(this.h));
        e.g(this, r0);
        if (this.f == null) goto L12;
        setTextColor(ColorStateList.valueOf(getResources().getColor(this.h)));
    L12:
        if (this.g == 0) goto L15;
        setBackgroundColor(AppCompatResources.getColorStateList(getContext(), this.g));
        return;
    L15:
        return;
    L7:
        r2 = BuildConfig.FLAVOR;
        goto L8
    }

    public CustomDisplayUDButton(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.d == false) goto L5;
        return;
    L5:
        CustomDisplayHandler r5 = this.a;
        if (r5 == null) goto L15;
        a r0 = this.c;
        if (r0 == null) goto L10;
        Boolean r6 = Boolean.valueOf(r0.dL(r5, this.b, getContext()));
    L12:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L16;
        startLoading();
        return;
    L16:
        return;
    L10:
        r6 = null;
        goto L12
    }

    public CustomDisplayUDButton(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public CustomDisplayUDButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = 2131106521;
    }

    public static ColorStateList a(int r7, int r8, int r9) {
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{R.attr.state_pressed}, new int[0]}, new int[]{r9, r8, r7});
    }
}
