package com.bytedance.android.livesdk.interactivity.medialink.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.android.livesdk.common.AnchorPauseTipsView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/MediaMultiAnchorPauseTipsView;", "Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/WindowLayoutType;", "windowLayoutType", BuildConfig.FLAVOR, "setWindowLayoutType", BuildConfig.FLAVOR, "getLayoutResource", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title", "f", "getContent", "content", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorPauseTipsView extends AnchorPauseTipsView {
    public final TextView e;
    public final TextView f;
    public WindowLayoutType g;

    public static final class a {
    }

    static {
    }

    public MediaMultiAnchorPauseTipsView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MediaMultiAnchorPauseTipsView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public int getLayoutResource() {
        return 2131566915;
    }

    public final TextView getContent() {
        return this.f;
    }

    public final TextView getTitle() {
        return this.e;
    }

    public final void setWindowLayoutType(WindowLayoutType r4) {
        Intrinsics.checkNotNullParameter(r4, "windowLayoutType");
        if (this.g != r4) goto L5;
        return;
    L5:
        this.g = r4;
        if (r4 != WindowLayoutType.EnlargeSmall) goto L8;
        this.e.setTextSize(1, 11.0f);
        this.f.setTextSize(1, 8.0f);
        return;
    L8:
        this.e.setTextSize(1, 15.0f);
        this.f.setTextSize(1, 11.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaMultiAnchorPauseTipsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = (TextView) findViewById(2131388920);
        this.f = (TextView) findViewById(2131367861);
        this.g = WindowLayoutType.Normal;
    }

    public /* synthetic */ MediaMultiAnchorPauseTipsView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
