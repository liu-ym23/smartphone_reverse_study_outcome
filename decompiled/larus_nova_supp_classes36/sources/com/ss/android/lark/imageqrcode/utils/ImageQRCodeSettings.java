package com.ss.android.lark.imageqrcode.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageQRCodeSettings {
    public static final Lazy a = null;
    public static final Lazy b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/imageqrcode/utils/ImageQRCodeSettings$ImageQRCodeConfig;", "", "superRatio", "", "superSizeSmallSide", "superSizeBigSide", "<init>", "(III)V", "getSuperRatio", "()I", "setSuperRatio", "(I)V", "getSuperSizeSmallSide", "setSuperSizeSmallSide", "getSuperSizeBigSide", "setSuperSizeBigSide", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ImageQRCodeConfig {

        @SerializedName("super_ratio")
        private int superRatio;

        @SerializedName("super_size_big_side")
        private int superSizeBigSide;

        @SerializedName("super_size_small_side")
        private int superSizeSmallSide;

        public ImageQRCodeConfig() {
            this(0, 0, 0, 7, null);
        }

        public final int getSuperRatio() {
            return this.superRatio;
        }

        public final int getSuperSizeBigSide() {
            return this.superSizeBigSide;
        }

        public final int getSuperSizeSmallSide() {
            return this.superSizeSmallSide;
        }

        public final void setSuperRatio(int r1) {
            this.superRatio = r1;
        }

        public final void setSuperSizeBigSide(int r1) {
            this.superSizeBigSide = r1;
        }

        public final void setSuperSizeSmallSide(int r1) {
            this.superSizeSmallSide = r1;
        }

        public ImageQRCodeConfig(int r1, int r2, int r3) {
            this.superRatio = r1;
            this.superSizeSmallSide = r2;
            this.superSizeBigSide = r3;
        }

        public /* synthetic */ ImageQRCodeConfig(int r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 3;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = 1440;
        L9:
            if ((r4 & 4) == 0) goto L11;
            r3 = 2560;
        L11:
            this(r1, r2, r3);
        }
    }

    @AppConfig(key = "image_qr_code_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/imageqrcode/utils/ImageQRCodeSettings$ImageQRCodeSetting;", "", "<init>", "()V", "imageqrcode_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ImageQRCodeSetting {
        public ImageQRCodeSetting() {
        }
    }

    static {
        a = LazyKt.lazy(ImageQRCodeSettings$remoteSetting$2.INSTANCE);
        b = LazyKt.lazy(ImageQRCodeSettings$config$2.INSTANCE);
    }
}
