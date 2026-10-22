package com.bytedance.android.live.matchroom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\n\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/matchroom/MatchLandFullShadowFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/matchroom/c;", "", "a", "Ljava/lang/String;", "getInputColors", "()Ljava/lang/String;", "setInputColors", "(Ljava/lang/String;)V", "inputColors", "b", "getInputPositions", "setInputPositions", "inputPositions", "", "c", "Z", "getEnableShader", "()Z", "setEnableShader", "(Z)V", "enableShader", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchLandFullShadowFrameLayout extends FrameLayout implements c {
    public String a;
    public String b;
    public boolean c;
    public final Paint d;

    public MatchLandFullShadowFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MatchLandFullShadowFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.live.matchroom.c
    public boolean getEnableShader() {
        return this.c;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public String getInputColors() {
        return this.a;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public String getInputPositions() {
        return this.b;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        Intrinsics.checkNotNullParameter(r8, "canvas");
        if (getEnableShader() == false) goto L5;
        setBackground(null);
    L5:
        Paint r3 = this.d;
        float r4 = getHeight();
        float r5 = getWidth();
        Intrinsics.checkNotNullParameter(r3, "paint");
        Intrinsics.checkNotNullParameter("MatchLandFullShadowFrameLayout", "logTag");
        c.a.a(this, r8, r3, r4, r5, "MatchLandFullShadowFrameLayout");
        super.onDraw(r8);
    }

    public void setEnableShader(boolean r1) {
        this.c = r1;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public void setInputColors(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    @Override // com.bytedance.android.live.matchroom.c
    public void setInputPositions(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public MatchLandFullShadowFrameLayout(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        this.a = "";
        this.b = "";
        this.c = true;
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130969956, 2130974027, 2130974031}, r6, 0);
        String r8 = r7.getString(1);
        if (r8 != null) goto L5;
        r8 = "#00000000,#26000000,#4D000000,#73000000,#99000000,#B2000000,#C7000000,#D9000000,#E5000000";
    L5:
        setInputColors(r8);
        String r9 = r7.getString(2);
        if (r9 != null) goto L8;
        r9 = "0.0,0.11,0.21,0.32,0.45,0.58,0.7,0.84,1.0";
    L8:
        setInputPositions(r9);
        setEnableShader(r7.getBoolean(0, true));
        setWillNotDraw(false);
        this.d = new Paint();
    }

    public /* synthetic */ MatchLandFullShadowFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // com.bytedance.android.live.matchroom.c
    public final void Y0(Paint r2, float r3, float r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "paint");
        Intrinsics.checkNotNullParameter(r5, "logTag");
        c.a.b(this, r2, r3, r4, r5);
    }
}
