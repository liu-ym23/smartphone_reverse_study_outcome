package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.larus.common_res.common_ui.databinding.LarusCommonUiAuthorInfoLayoutBinding;
import com.larus.common_ui.widget.roundlayout.CircleFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;
import v19.r5;
import z19.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0002J(\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0010H\u0007J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/common_ui/widget/CommonAuthorInfoLayout;", "Lcom/larus/common_ui/widget/LinearLayoutWithLastMotion;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusCommonUiAuthorInfoLayoutBinding;", "tryInitViews", "", "setAvatarIcon", "url", "", "bizTag", "resizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "setAuthorName", "name", "setUseCount", "count", "", "getAuthorName", "", "getUseCount", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonAuthorInfoLayout extends LinearLayoutWithLastMotion {
    public static final /* synthetic */ int c = 0;
    public LarusCommonUiAuthorInfoLayoutBinding b;

    public static final class a {
        public static String a(Context r2, long r3) {
            String r0 = r5.a(r2, r3);
            if (Intrinsics.areEqual(r0, String.valueOf(r3)) == false) goto L5;
            r0 = r0 + ' ';
        L5:
            if (r2 == null) goto L9;
            Resources r4 = r2.getResources();
            if (r4 == null) goto L9;
            return r4.getQuantityString(2131755159, (int) r3, new Object[]{r0});
        L9:
            return null;
        }
    }

    static {
    }

    public CommonAuthorInfoLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonAuthorInfoLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void b() {
        if (this.b != null) goto L15;
        setGravity(16);
        int r0 = i5.r0();
        setPadding(r0, r0, r0, r0);
        LayoutInflater.from(getContext()).inflate(2131561919, this);
        int r1 = 2131374260;
        if (((CircleFrameLayout) ViewBindings.findChildViewById(this, 2131374260)) == null) goto L14;
        r1 = 2131374261;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(this, 2131374261);
        if (r2 == null) goto L14;
        r1 = 2131380610;
        TextView r3 = (TextView) ViewBindings.findChildViewById(this, 2131380610);
        if (r3 == null) goto L14;
        r1 = 2131391970;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131391970);
        if (r4 == null) goto L14;
        this.b = new LarusCommonUiAuthorInfoLayoutBinding(this, r2, r3, r4);
        return;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r1)));
    }

    public final CharSequence getAuthorName() {
        LarusCommonUiAuthorInfoLayoutBinding r0 = this.b;
        if (r0 == null) goto L7;
        TextView r1 = r0.c;
        if (r1 == null) goto L7;
        return r1.getText();
    L7:
        return null;
    }

    public final CharSequence getUseCount() {
        LarusCommonUiAuthorInfoLayoutBinding r0 = this.b;
        if (r0 == null) goto L7;
        TextView r1 = r0.d;
        if (r1 == null) goto L7;
        return r1.getText();
    L7:
        return null;
    }

    public final void setAuthorName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        b();
        LarusCommonUiAuthorInfoLayoutBinding r0 = this.b;
        if (r0 == null) goto L8;
        TextView r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    L9:
        return;
    }

    public final void setUseCount(long r3) {
        b();
        if (getContext() != null) goto L5;
        return;
    L5:
        LarusCommonUiAuthorInfoLayoutBinding r0 = this.b;
        if (r0 == null) goto L11;
        TextView r1 = r0.d;
        if (r1 == null) goto L12;
        r1.setText(a.a(getContext(), r3));
        return;
    L12:
        return;
    }

    public final void a(String r4, final ResizeOptions r5) {
        Intrinsics.checkNotNullParameter("community_creation_photo", "bizTag");
        b();
        SimpleDraweeView r0 = null;
        if (r5 == null) goto L16;
        if (r4 != null) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L16;
        LarusCommonUiAuthorInfoLayoutBinding r3 = this.b;
        if (r3 == null) goto L15;
        r0 = r3.b;
    L15:
        ImageLoaderKt.y(r0, r4, "community_creation_photo", new i(this, r5), 4);
        return;
    L6:
        if (r4.length() == 0) goto L9;
        r2 = false;
    L16:
        LarusCommonUiAuthorInfoLayoutBinding r6 = this.b;
        if (r6 == null) goto L19;
        r0 = r6.b;
    L19:
        ImageLoaderKt.u(r0, r4, "community_creation_photo");
    }

    public CommonAuthorInfoLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CommonAuthorInfoLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
