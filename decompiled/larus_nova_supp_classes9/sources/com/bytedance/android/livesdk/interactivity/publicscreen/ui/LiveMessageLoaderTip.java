package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/LiveMessageLoaderTip;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "getResourceLayout", "visibility", BuildConfig.FLAVOR, "setVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMessageLoaderTip extends FrameLayout {
    public final TextView a;
    public final View b;
    public final q4.b c;

    public LiveMessageLoaderTip(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LiveMessageLoaderTip(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getResourceLayout() {
        return 2131566860;
    }

    @Override // android.view.View
    public void setVisibility(int r2) {
        super.setVisibility(r2);
        if (r2 != 0) goto L9;
        TextView r3 = this.a;
        if (r3 == null) goto L7;
        r3.setAlpha(0.0f);
    L7:
        this.c.c();
        return;
    L9:
        if (this.c.b() == false) goto L13;
        this.c.a();
        return;
    }

    public LiveMessageLoaderTip(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LayoutInflater.from(r2).inflate(getResourceLayout(), this, true);
        TextView r5 = (TextView) findViewById(2131388367);
        this.a = r5;
        if (r5 == null) goto L5;
        r5.setText(2131919530);
        r5.setTextColor(-1);
        r5.setMinHeight((int) UtilityKotlinExtentionsKt.h(28));
    L5:
        this.c = u4.c(new LiveMessageLoaderTip$animController$1(this));
    }

    public /* synthetic */ LiveMessageLoaderTip(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
