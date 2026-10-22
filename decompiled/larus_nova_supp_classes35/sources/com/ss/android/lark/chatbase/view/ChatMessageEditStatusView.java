package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0000J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chatbase/view/ChatMessageEditStatusView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "iconWrapper", "Landroid/view/ViewGroup;", "ivEditStatusFailed", "Landroid/widget/ImageView;", "progressEditLoading", "Landroid/widget/ProgressBar;", "tvEditStatus", "Landroid/widget/TextView;", "showLoadFailed", "retryHandler", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showLoading", "setSize", "iconSizePx", "textSizePx", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatMessageEditStatusView extends FrameLayout {
    public final ViewGroup a;
    public final ImageView b;
    public final ProgressBar c;
    public final TextView d;

    public ChatMessageEditStatusView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public ChatMessageEditStatusView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public ChatMessageEditStatusView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public final void b() {
        TextView r0 = this.d;
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        ForegroundColorSpan r2 = new ForegroundColorSpan(UIUtils.getColor(getContext(), 2131106616));
        int r3 = r1.length();
        r1.append(getContext().getString(2131891085));
        r1.setSpan(r2, r3, r1.length(), 17);
        r0.setText(new SpannedString(r1));
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    public final void a(Function0 r7) {
        Intrinsics.checkNotNullParameter(r7, "retryHandler");
        TextView r0 = this.d;
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        ForegroundColorSpan r2 = new ForegroundColorSpan(UIUtils.getColor(getContext(), 2131102093));
        int r3 = r1.length();
        r1.append(getContext().getString(2131891084));
        r1.setSpan(r2, r3, r1.length(), 17);
        r1.setSpan(new c(r7), 0, r1.length(), 33);
        r0.setText(new SpannedString(r1));
        this.b.setVisibility(0);
        this.c.setVisibility(8);
    }

    public ChatMessageEditStatusView(Context r2, AttributeSet r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        LayoutInflater.from(r2).inflate(2131559343, this, true);
        this.a = (ViewGroup) findViewById(2131380362);
        ImageView r6 = (ImageView) findViewById(2131376419);
        this.b = r6;
        ProgressBar r7 = (ProgressBar) findViewById(2131383336);
        this.c = r7;
        TextView r8 = (TextView) findViewById(2131390967);
        this.d = r8;
        r8.setMovementMethod(LinkMovementMethod.getInstance());
        r8.setHighlightColor(0);
        zz7.a.a(r6, 14);
        zz7.a.a(r7, 14);
        zz7.a.c(r8, 12);
    }
}
