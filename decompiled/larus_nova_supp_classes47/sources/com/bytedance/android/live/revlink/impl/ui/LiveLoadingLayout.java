package com.bytedance.android.live.revlink.impl.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/ui/LiveLoadingLayout;", "Landroid/widget/FrameLayout;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveLoadingLayout extends FrameLayout {
    public TextView a;
    public LiveDoubleColorBallAnimationView b;

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131566644, this, true);
        this.b = findViewById(2131370123);
        this.a = (TextView) findViewById(2131370122);
    }

    public LiveLoadingLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a();
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 != 0) goto L10;
        LiveDoubleColorBallAnimationView r3 = this.b;
        if (r3 == null) goto L7;
        r3.setVisibility(0);
    L7:
        TextView r4 = this.a;
        if (r4 == null) goto L14;
        r4.setVisibility(0);
        return;
    L14:
        return;
    L10:
        LiveDoubleColorBallAnimationView r5 = this.b;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
        return;
    }

    public LiveLoadingLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a();
    }

    public LiveLoadingLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a();
    }
}
