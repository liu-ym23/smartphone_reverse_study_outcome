package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/MarkdownListMarginInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "dotDiameter", BuildConfig.FLAVOR, "getDotDiameter", "()Ljava/lang/Float;", "setDotDiameter", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "bulletDotOffset", "getBulletDotOffset", "setBulletDotOffset", "listMargin", "getListMargin", "setListMargin", "textStartMargin", "getTextStartMargin", "setTextStartMargin", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownListMarginInfo implements NonProguard {
    private Float bulletDotOffset;
    private Float dotDiameter;
    private Float listMargin;
    private Float textStartMargin;

    public MarkdownListMarginInfo() {
    }

    public final Float getBulletDotOffset() {
        return this.bulletDotOffset;
    }

    public final Float getDotDiameter() {
        return this.dotDiameter;
    }

    public final Float getListMargin() {
        return this.listMargin;
    }

    public final Float getTextStartMargin() {
        return this.textStartMargin;
    }

    public final void setBulletDotOffset(Float r1) {
        this.bulletDotOffset = r1;
    }

    public final void setDotDiameter(Float r1) {
        this.dotDiameter = r1;
    }

    public final void setListMargin(Float r1) {
        this.listMargin = r1;
    }

    public final void setTextStartMargin(Float r1) {
        this.textStartMargin = r1;
    }
}
