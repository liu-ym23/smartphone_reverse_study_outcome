package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Margin;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "top", BuildConfig.FLAVOR, "getTop", "()Ljava/lang/Float;", "setTop", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "bottom", "getBottom", "setBottom", "left", "getLeft", "setLeft", "right", "getRight", "setRight", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Margin implements NonProguard {
    private Float bottom;
    private Float left;
    private Float right;
    private Float top;

    public Margin() {
    }

    public final Float getBottom() {
        return this.bottom;
    }

    public final Float getLeft() {
        return this.left;
    }

    public final Float getRight() {
        return this.right;
    }

    public final Float getTop() {
        return this.top;
    }

    public final void setBottom(Float r1) {
        this.bottom = r1;
    }

    public final void setLeft(Float r1) {
        this.left = r1;
    }

    public final void setRight(Float r1) {
        this.right = r1;
    }

    public final void setTop(Float r1) {
        this.top = r1;
    }
}
