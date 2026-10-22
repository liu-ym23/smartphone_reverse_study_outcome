package com.bytedance.android.livesdk.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/common/CoHostAnchorPauseTipsView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/common/AnchorPauseTipsView;", "getPauseView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CoHostAnchorPauseTipsView extends FrameLayout {
    public Map<Integer, View> a;

    public final AnchorPauseTipsView getPauseView() {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        Object r0 = (View) ((LinkedHashMap) this.a).get(2131381986);
        if (r0 != null) goto L12;
        r0 = findViewById(2131381986);
        if (r0 == null) goto L10;
        this.a.put(2131381986, (View) r0);
        goto L12
    L10:
        r0 = null;
    L12:
        return (AnchorPauseTipsView) r0;
    }

    public CoHostAnchorPauseTipsView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(2131567635, this);
    }

    public CoHostAnchorPauseTipsView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(2131567635, this);
    }

    public CoHostAnchorPauseTipsView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        LayoutInflater.from(getContext()).inflate(2131567635, this);
    }
}
