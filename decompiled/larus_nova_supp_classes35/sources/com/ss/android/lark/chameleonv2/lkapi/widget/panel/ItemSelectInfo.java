package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/ItemSelectInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "selectId", BuildConfig.FLAVOR, "getSelectId", "()Ljava/lang/String;", "setSelectId", "(Ljava/lang/String;)V", "selectIds", BuildConfig.FLAVOR, "getSelectIds", "()Ljava/util/List;", "setSelectIds", "(Ljava/util/List;)V", "textStyle", BuildConfig.FLAVOR, "getTextStyle", "()Ljava/lang/Integer;", "setTextStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "descStyle", "getDescStyle", "setDescStyle", "leftIcon", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;", "getLeftIcon", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;", "setLeftIcon", "(Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;)V", "rightIcon", "getRightIcon", "setRightIcon", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemSelectInfo implements NonProguard {
    private Integer descStyle;
    private Icon leftIcon;
    private Icon rightIcon;
    private String selectId;
    private List<String> selectIds;
    private Integer textStyle;

    public ItemSelectInfo() {
    }

    public final Integer getDescStyle() {
        return this.descStyle;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final String getSelectId() {
        return this.selectId;
    }

    public final List<String> getSelectIds() {
        return this.selectIds;
    }

    public final Integer getTextStyle() {
        return this.textStyle;
    }

    public final void setDescStyle(Integer r1) {
        this.descStyle = r1;
    }

    public final void setLeftIcon(Icon r1) {
        this.leftIcon = r1;
    }

    public final void setRightIcon(Icon r1) {
        this.rightIcon = r1;
    }

    public final void setSelectId(String r1) {
        this.selectId = r1;
    }

    public final void setSelectIds(List<String> r1) {
        this.selectIds = r1;
    }

    public final void setTextStyle(Integer r1) {
        this.textStyle = r1;
    }
}
