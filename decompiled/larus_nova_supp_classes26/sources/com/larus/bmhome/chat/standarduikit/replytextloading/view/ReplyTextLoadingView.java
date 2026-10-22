package com.larus.bmhome.chat.standarduikit.replytextloading.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.mainbot.impl.databinding.LarusBlockReplyTextLoadingViewBinding;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J)\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0010H\u0002J/\u0010$\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0019\u0010)\u001a\u0004\u0018\u00010\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010+J\"\u0010,\u001a\u00020\u00132\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u001dH\u0002J\u0006\u0010/\u001a\u00020\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u00060"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/replytextloading/view/ReplyTextLoadingView;", "Lcom/larus/bmhome/chat/layout/widget/ShimmerLinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/replytextloading/view/ReplyTextLoadingViewInput;", "Lcom/larus/bmhome/chat/standarduikit/replytextloading/view/ReplyTextLoadingViewOutput;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockReplyTextLoadingViewBinding;", "loadingIndicator", "Lcom/larus/bmhome/chat/layout/widget/ThreeLoadingIndicator;", "lastIsImmersive", "", "Ljava/lang/Boolean;", "setupViews", "", "bindData", "input", "output", "updateTextView", "content", "Landroid/text/SpannableStringBuilder;", "textColor", "", "textSize", "", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Integer;Ljava/lang/Float;)V", "updateIcon", "icon", "", "updateShimmer", "needShimmer", "updateLoadingIndicator", "isImmersive", "fontScale", "(Landroid/text/SpannableStringBuilder;ZFLjava/lang/Integer;)V", "getOrCreateIndicator", "resolveTextColor", "textColorRes", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "scaleImageSpanDot", "span", "Landroid/text/style/ImageSpan;", "onRecycle", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyTextLoadingView extends ShimmerLinearLayout {
    public final LarusBlockReplyTextLoadingViewBinding k;
    public ThreeLoadingIndicator l;
    public Boolean m;

    public ReplyTextLoadingView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReplyTextLoadingView(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, 4, 0);
        LayoutInflater.from(r7).inflate(2131561844, this);
        int r9 = 2131385505;
        SimpleDraweeView r10 = ViewBindings.findChildViewById(this, 2131385505);
        if (r10 == null) goto L9;
        r9 = 2131385615;
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131385615);
        if (r0 == null) goto L9;
        this.k = new LarusBlockReplyTextLoadingViewBinding(this, r10, r0);
        int r11 = i5.q();
        int r12 = i5.q();
        int r1 = i5.h();
        int r2 = i5.h();
        FLogger.a.i("updatePaddingRelative", "view:ReplyTextLoadingView,source:,start:" + r11 + ",top:" + r1 + ",end:" + r12 + ",bottom:" + r2);
        setPaddingRelative(r11, r1, r12, r2);
        r0.setLineSpacing(0.0f, 1.1f);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r9)));
    }
}
