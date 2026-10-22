package com.bytedance.android.livesdk.interactivity.medialink.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/layout/MediaMultiAnchorGuestInfoCleanScreenLayout;", "Landroid/widget/FrameLayout;", BuildConfig.FLAVOR, "isPad", BuildConfig.FLAVOR, "setIsPad", BuildConfig.FLAVOR, "windowCount", "setWindowCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorGuestInfoCleanScreenLayout extends FrameLayout {
    public final HSImageView a;
    public final TextView b;
    public boolean c;
    public int d;

    public MediaMultiAnchorGuestInfoCleanScreenLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MediaMultiAnchorGuestInfoCleanScreenLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setIsPad(boolean r2) {
        if (this.c != r2) goto L5;
        return;
    L5:
        this.c = r2;
        if (r2 == false) goto L8;
    L11:
        boolean r3 = true;
    L12:
        UtilityKotlinExtentionsKt.z(this.a, r3);
        return;
    L8:
        if (this.d <= 2) goto L11;
        r3 = false;
        goto L12
    }

    public final void setWindowCount(int r2) {
        if (this.d != r2) goto L5;
        return;
    L5:
        this.d = r2;
        if (this.c == false) goto L8;
    L11:
        boolean r3 = true;
    L12:
        UtilityKotlinExtentionsKt.z(this.a, r3);
        return;
    L8:
        if (r2 <= 2) goto L11;
        r3 = false;
        goto L12
    }

    public MediaMultiAnchorGuestInfoCleanScreenLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131566912, null, false);
        addView(r5);
        this.a = r5.findViewById(2131374216);
        this.b = (TextView) r5.findViewById(2131380596);
    }

    public /* synthetic */ MediaMultiAnchorGuestInfoCleanScreenLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
