package com.larus.community.impl.detail.toptools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailTopToolsLayoutBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.AccountService;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J4\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u000eJ\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J>\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailTopToolsLayoutBinding;", "useHostChromeActions", "", "canShowMoreIcon", "trailingActionReservedWidth", "", "bindCreationData", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "setHostChromeMode", "enabled", "isRootPage", "backIconRes", "shareIconRes", "updateLeadingLayout", "updateActionVisibility", "bindAction", "moreAction", "Lkotlin/Function0;", "backAction", "shareAction", "jumpAuthorPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailTopToolsView extends ConstraintLayout {
    public static final /* synthetic */ int e = 0;
    public final LarusCommunityCreationDetailTopToolsLayoutBinding a;
    public boolean b;
    public boolean c;
    public int d;

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        if (this.b == false) goto L10;
        e1.o(this.a.d);
        e1.o(this.a.c);
        AppCompatImageView r0 = this.a.d;
        ViewGroup.LayoutParams r6 = r0.getLayoutParams();
        if (r6 == null) goto L9;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r6;
        r7.endToStart = -1;
        r7.endToEnd = 0;
        r7.setMarginEnd(this.d + getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)));
        r0.setLayoutParams(r7);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L10:
        e1.x(this.a.d);
        AppCompatImageView r1 = this.a.d;
        ViewGroup.LayoutParams r8 = r1.getLayoutParams();
        if (r8 == null) goto L18;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) r8;
        r9.endToEnd = -1;
        r9.endToStart = 2131380304;
        r9.setMarginEnd(getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462)));
        r1.setLayoutParams(r9);
        if (this.c == false) goto L15;
        e1.x(this.a.c);
        return;
    L15:
        e1.o(this.a.c);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public CreationDetailTopToolsView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void S5(UserCreation r5) {
        Intrinsics.checkNotNullParameter(r5, "userCreation");
        SimpleDraweeView r0 = this.a.e;
        AuthorInfo r1 = r5.g;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.c;
    L6:
        ImageLoaderKt.u(r0, r3, "creation_detail_user_avatar");
        AppCompatTextView r4 = this.a.f;
        AuthorInfo r6 = r5.g;
        if (r6 == null) goto L9;
        String r7 = r6.a;
    L10:
        r4.setText(r7);
        AuthorInfo r8 = r5.g;
        if (r8 == null) goto L13;
        r2 = r8.b;
    L13:
        this.c = Intrinsics.areEqual(r2, AccountService.a.getUserId());
        T5();
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDetailTopToolsView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        LayoutInflater.from(r8).inflate(2131561934, this);
        int r10 = 2131363779;
        AppCompatImageView r2 = ViewBindings.findChildViewById(this, 2131363779);
        if (r2 == null) goto L15;
        r10 = 2131380304;
        AppCompatImageView r3 = ViewBindings.findChildViewById(this, 2131380304);
        if (r3 == null) goto L15;
        r10 = 2131386080;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131386080);
        if (r4 == null) goto L15;
        r10 = 2131392000;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(this, 2131392000);
        if (r5 == null) goto L15;
        r10 = 2131392054;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131392054);
        if (r6 == null) goto L15;
        this.a = new LarusCommunityCreationDetailTopToolsLayoutBinding(this, r2, r3, r4, r5, r6);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public final void R5(final Function0<Unit> r3, final Function0<Unit> r4, final Function0<Unit> r5, final Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "moreAction");
        Intrinsics.checkNotNullParameter(r4, "backAction");
        Intrinsics.checkNotNullParameter(r5, "shareAction");
        Intrinsics.checkNotNullParameter(r6, "jumpAuthorPage");
        e1.d(this.a.c, new q(r3));
        e1.d(this.a.b, new r(r4));
        e1.d(this.a.d, new s(r5));
        e1.d(this.a.f, new t(r6));
        e1.d(this.a.e, new u(r6));
    }
}
