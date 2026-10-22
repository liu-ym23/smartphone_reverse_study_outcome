package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.config.vo;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/ProhibitDoubleMeasureBannerFrameLayout;", "Lcom/bytedance/android/livesdk/chatroom/ui/BannerFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProhibitDoubleMeasureBannerFrameLayout extends BannerFrameLayout {
    public final Boolean a;

    @Override // android.view.View, android.view.ViewParent
    @Deprecated(message = "Deprecated in Java")
    public final void requestFitSystemWindows() {
        if (this.a.booleanValue() == false) goto L5;
        return;
    L5:
        super.requestFitSystemWindows();
    }

    public ProhibitDoubleMeasureBannerFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = vo.a.getValue();
    }
}
