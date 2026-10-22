package com.larus.ugc.feed.impl.detail.bottomtools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.ugc.feed.impl.databinding.LarusCreationDetailBottomToolsLayoutKmpBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000fJ\"\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/ugc/feed/impl/detail/bottomtools/CreationDetailBottomToolsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/ugc/feed/impl/databinding/LarusCreationDetailBottomToolsLayoutKmpBinding;", "bindAction", "", "likeAction", "Lkotlin/Function0;", "makeSameAction", "Lkotlin/Function1;", "", "setMakeSameContent", "isCustomContent", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "ignoreDynamicInfo", "bindCreationLikeState", "state", "Lcom/larus/ugc/feed/api/detail/state/CreationDetailBottomToolsUiState;", "createAnimatorSet", "Landroid/view/animation/AnimationSet;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationDetailBottomToolsView extends ConstraintLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusCreationDetailBottomToolsLayoutKmpBinding a;

    public CreationDetailBottomToolsView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDetailBottomToolsView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10);
        LayoutInflater.from(r9).inflate(2131561994, this);
        int r11 = 2131368260;
        RoundConstraintLayout r2 = ViewBindings.findChildViewById(this, 2131368260);
        if (r2 == null) goto L17;
        r11 = 2131368262;
        RoundConstraintLayout r3 = ViewBindings.findChildViewById(this, 2131368262);
        if (r3 == null) goto L17;
        r11 = 2131374698;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131374698);
        if (r4 == null) goto L17;
        r11 = 2131374699;
        AppCompatImageView r5 = ViewBindings.findChildViewById(this, 2131374699);
        if (r5 == null) goto L17;
        r11 = 2131390863;
        TextView r6 = (TextView) ViewBindings.findChildViewById(this, 2131390863);
        if (r6 == null) goto L17;
        r11 = 2131390918;
        TextView r7 = (TextView) ViewBindings.findChildViewById(this, 2131390918);
        if (r7 == null) goto L17;
        this.a = new LarusCreationDetailBottomToolsLayoutKmpBinding(this, r2, r3, r4, r5, r6, r7);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }
}
