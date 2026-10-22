package com.ss.android.lark.officewebview.quality;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@AppConfig(key = "chameleon_webview_optimize_config")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/officewebview/quality/WebViewOptimizeConfig;", "", "blankScreen", "Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;", "hangDetect", "Lcom/ss/android/lark/officewebview/quality/HangDetectConfig;", "<init>", "(Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;Lcom/ss/android/lark/officewebview/quality/HangDetectConfig;)V", "getBlankScreen", "()Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;", "setBlankScreen", "(Lcom/ss/android/lark/officewebview/quality/BlankScreenConfig;)V", "getHangDetect", "()Lcom/ss/android/lark/officewebview/quality/HangDetectConfig;", "setHangDetect", "(Lcom/ss/android/lark/officewebview/quality/HangDetectConfig;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class WebViewOptimizeConfig {

    @SerializedName("blank_screen")
    private BlankScreenConfig blankScreen;

    @SerializedName("hang_detect")
    private HangDetectConfig hangDetect;

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewOptimizeConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WebViewOptimizeConfig copy$default(WebViewOptimizeConfig r0, BlankScreenConfig r1, HangDetectConfig r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.blankScreen;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hangDetect;
    L9:
        return r0.copy(r1, r2);
    }

    public final BlankScreenConfig component1() {
        return this.blankScreen;
    }

    public final HangDetectConfig component2() {
        return this.hangDetect;
    }

    public final WebViewOptimizeConfig copy(BlankScreenConfig r2, HangDetectConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "blankScreen");
        Intrinsics.checkNotNullParameter(r3, "hangDetect");
        return new WebViewOptimizeConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebViewOptimizeConfig) == true) goto L8;
        return false;
    L8:
        WebViewOptimizeConfig r6 = (WebViewOptimizeConfig) r5;
        if (Intrinsics.areEqual(this.blankScreen, r6.blankScreen) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hangDetect, r6.hangDetect) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.blankScreen.hashCode() * 31) + this.hangDetect.hashCode();
    }

    public String toString() {
        return "WebViewOptimizeConfig(blankScreen=" + this.blankScreen + ", hangDetect=" + this.hangDetect + ')';
    }

    public final BlankScreenConfig getBlankScreen() {
        return this.blankScreen;
    }

    public final HangDetectConfig getHangDetect() {
        return this.hangDetect;
    }

    public final void setBlankScreen(BlankScreenConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blankScreen = r2;
    }

    public final void setHangDetect(HangDetectConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.hangDetect = r2;
    }

    public WebViewOptimizeConfig(BlankScreenConfig r2, HangDetectConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "blankScreen");
        Intrinsics.checkNotNullParameter(r3, "hangDetect");
        this.blankScreen = r2;
        this.hangDetect = r3;
    }

    public /* synthetic */ WebViewOptimizeConfig(BlankScreenConfig r19, HangDetectConfig r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 1) == 0) goto L5;
        BlankScreenConfig r0 = new BlankScreenConfig(false, false, 0, 0, 0.0f, false, false, 0, false, 0, false, null, 4095, null);
    L7:
        if ((r21 & 2) == 0) goto L9;
        HangDetectConfig r1 = new HangDetectConfig(false, false, 0, 0, 0, 0, 0, 0, 0, 511, null);
    L10:
        this(r0, r1);
        return;
    L9:
        r1 = r20;
        goto L10
    L5:
        r0 = r19;
        goto L7
    }
}
