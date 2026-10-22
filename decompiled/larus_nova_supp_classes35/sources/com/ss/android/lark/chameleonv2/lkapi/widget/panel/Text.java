package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Text;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", BuildConfig.FLAVOR, "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "bold", BuildConfig.FLAVOR, "getBold", "()Z", "setBold", "(Z)V", "udColor", "getUdColor", "setUdColor", "style", BuildConfig.FLAVOR, "getStyle", "()Ljava/lang/Integer;", "setStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "maxLines", "getMaxLines", "setMaxLines", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Text implements NonProguard {
    private boolean bold;
    private Integer maxLines;
    private Integer style;
    private String udColor;
    private String value;

    public Text() {
        this.value = BuildConfig.FLAVOR;
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final Integer getMaxLines() {
        return this.maxLines;
    }

    public final Integer getStyle() {
        return this.style;
    }

    public final String getUdColor() {
        return this.udColor;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setBold(boolean r1) {
        this.bold = r1;
    }

    public final void setMaxLines(Integer r1) {
        this.maxLines = r1;
    }

    public final void setStyle(Integer r1) {
        this.style = r1;
    }

    public final void setUdColor(String r1) {
        this.udColor = r1;
    }

    public final void setValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.value = r2;
    }
}
