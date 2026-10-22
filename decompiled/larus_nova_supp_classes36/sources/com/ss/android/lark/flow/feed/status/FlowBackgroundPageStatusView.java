package com.ss.android.lark.flow.feed.status;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.ss.android.lark.feed.shared.page.status.FeedBackgroundStatusView;
import com.ss.android.lark.flow.feed.databinding.FlowFeedBackgroundStatusBinding;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/flow/feed/status/FlowBackgroundPageStatusView;", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/flow/feed/databinding/FlowFeedBackgroundStatusBinding;", "retryAction", "Lkotlin/Function0;", "", "setStatus", "status", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "description", "", "onRetry", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowBackgroundPageStatusView extends FeedBackgroundStatusView {
    public final FlowFeedBackgroundStatusBinding b;
    public Function0<Unit> c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FlowBackgroundPageStatusView a;

        public a(FlowBackgroundPageStatusView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            Function0<Unit> r2 = this.a.c;
            if (r2 == null) goto L6;
            r2.invoke();
            return;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FeedBackgroundStatusView.FeedPageStatus.values().length];
            r0[FeedBackgroundStatusView.FeedPageStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FeedBackgroundStatusView.FeedPageStatus.EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FeedBackgroundStatusView.FeedPageStatus.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlowBackgroundPageStatusView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        View r10 = LayoutInflater.from(r7).inflate(2131561141, this, false);
        addView(r10);
        int r11 = 2131364816;
        AppCompatButton r12 = ViewBindings.findChildViewById(r10, 2131364816);
        if (r12 == null) goto L19;
        r11 = 2131371583;
        if (ViewBindings.findChildViewById(r10, 2131371583) == null) goto L19;
        r11 = 2131376220;
        if (ViewBindings.findChildViewById(r10, 2131376220) == null) goto L19;
        r11 = 2131378942;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131378942);
        if (r3 == null) goto L19;
        r11 = 2131378943;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, 2131378943);
        if (r4 == null) goto L19;
        r11 = 2131379091;
        AppCompatImageView r5 = ViewBindings.findChildViewById(r10, 2131379091);
        if (r5 == null) goto L19;
        r11 = 2131390579;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131390579)) == null) goto L19;
        this.b = new FlowFeedBackgroundStatusBinding((RelativeLayout) r10, r12, r3, r4, r5);
        r12.setOnClickListener(new a(this));
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(FeedBackgroundStatusView.FeedPageStatus r2, String r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r3, "description");
        this.c = r4;
        int r5 = b.a[r2.ordinal()];
        if (r5 != 1) goto L5;
        setVisibility(0);
        this.b.d.setVisibility(0);
        this.b.b.setVisibility(8);
        this.b.c.setVisibility(8);
        return;
    L5:
        if (r5 != 2) goto L7;
        setVisibility(0);
        this.b.d.setVisibility(8);
        this.b.b.setVisibility(0);
        this.b.c.setVisibility(8);
        return;
    L7:
        if (r5 == 3) goto L9;
        setVisibility(8);
        return;
    L9:
        setVisibility(0);
        this.b.d.setVisibility(8);
        this.b.b.setVisibility(8);
        this.b.c.setVisibility(0);
    }
}
