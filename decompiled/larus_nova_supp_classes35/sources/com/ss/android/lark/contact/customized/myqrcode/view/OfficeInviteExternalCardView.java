package com.ss.android.lark.contact.customized.myqrcode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalCardLayoutBinding;
import com.ss.android.lark.image.api.DataSource;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\u0015\u001a\u00020\u00122:\u0010\u0016\u001a6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\n\u001a6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeInviteExternalCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteExternalCardLayoutBinding;", "avatarLoadListener", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/ParameterName;", IPortraitService.NAME, ChameleonOpenTracker.OpenResult.SUCCESS, "Lcom/ss/android/lark/image/api/DataSource;", "dataSource", BuildConfig.FLAVOR, "mainBotAvatarCallback", "Landroid/graphics/drawable/Drawable$Callback;", "setOnAvatarLoadListener", "listener", "initCard", "model", "Lcom/ss/android/lark/contact/customized/myqrcode/model/OfficeInviteExternalCardRenderModel;", "getCardLayout", "Landroid/view/View;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalCardView extends ConstraintLayout {
    public final ContactDbInviteExternalCardLayoutBinding a;
    public Function2<? super Boolean, ? super DataSource, Unit> b;

    public static final class a {
    }

    static {
    }

    public final View getCardLayout() {
        return this.a.b;
    }

    public OfficeInviteExternalCardView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setOnAvatarLoadListener(Function2<? super Boolean, ? super DataSource, Unit> r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeInviteExternalCardView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        LayoutInflater.from(getContext()).inflate(2131559912, this, true);
        int r12 = 2131378573;
        LKUIRoundLinearLayout r2 = ViewBindings.findChildViewById(this, 2131378573);
        if (r2 == null) goto L23;
        r12 = 2131385251;
        LKUIRoundedImageView2 r3 = ViewBindings.findChildViewById(this, 2131385251);
        if (r3 == null) goto L23;
        r12 = 2131385252;
        if (ViewBindings.findChildViewById(this, 2131385252) == null) goto L23;
        r12 = 2131385253;
        LKUIRoundedImageView2 r4 = ViewBindings.findChildViewById(this, 2131385253);
        if (r4 == null) goto L23;
        r12 = 2131385254;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131385254);
        if (r5 == null) goto L23;
        r12 = 2131385255;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131385255);
        if (r6 == null) goto L23;
        r12 = 2131385256;
        LKUIRoundedImageView2 r7 = ViewBindings.findChildViewById(this, 2131385256);
        if (r7 == null) goto L23;
        r12 = 2131385257;
        if (((TextView) ViewBindings.findChildViewById(this, 2131385257)) == null) goto L23;
        r12 = 2131385258;
        TextView r8 = (TextView) ViewBindings.findChildViewById(this, 2131385258);
        if (r8 == null) goto L23;
        this.a = new ContactDbInviteExternalCardLayoutBinding(this, r2, r3, r4, r5, r6, r7, r8);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r12)));
    }
}
