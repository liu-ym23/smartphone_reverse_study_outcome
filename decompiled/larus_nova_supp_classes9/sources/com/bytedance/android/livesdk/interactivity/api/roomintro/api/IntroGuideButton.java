package com.bytedance.android.livesdk.interactivity.api.roomintro.api;

import am3.g;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/IntroGuideButton;", BuildConfig.FLAVOR, "()V", "buttonText", BuildConfig.FLAVOR, "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "guideText", "getGuideText", "setGuideText", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroGuideButton implements h {

    @SerializedName("button_text")
    protected String buttonText;

    @SerializedName("guide_text")
    protected String guideText;

    public IntroGuideButton() {
    }

    public IntroGuideButton(g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.buttonText = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.guideText = am3.h.c(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getGuideText() {
        return this.guideText;
    }

    public final void setButtonText(String r1) {
        this.buttonText = r1;
    }

    public final void setGuideText(String r1) {
        this.guideText = r1;
    }
}
