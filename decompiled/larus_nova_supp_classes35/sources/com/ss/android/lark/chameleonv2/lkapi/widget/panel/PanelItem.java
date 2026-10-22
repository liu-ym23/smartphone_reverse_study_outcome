package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "actionCallback", BuildConfig.FLAVOR, "getActionCallback", "()Ljava/lang/Boolean;", "setActionCallback", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "leftText", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Text;", "getLeftText", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Text;", "setLeftText", "(Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Text;)V", "desc", "getDesc", "setDesc", "leftIcon", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;", "getLeftIcon", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;", "setLeftIcon", "(Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/Icon;)V", "leftIconTag", "getLeftIconTag", "setLeftIconTag", "rightIcon", "getRightIcon", "setRightIcon", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelItem implements NonProguard {
    private Boolean actionCallback;
    private Text desc;
    private String id;
    private Icon leftIcon;
    private Icon leftIconTag;
    private Text leftText;
    private Icon rightIcon;

    public PanelItem() {
    }

    public final Boolean getActionCallback() {
        return this.actionCallback;
    }

    public final Text getDesc() {
        return this.desc;
    }

    public final String getId() {
        return this.id;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final Icon getLeftIconTag() {
        return this.leftIconTag;
    }

    public final Text getLeftText() {
        return this.leftText;
    }

    public final Icon getRightIcon() {
        return this.rightIcon;
    }

    public final void setActionCallback(Boolean r1) {
        this.actionCallback = r1;
    }

    public final void setDesc(Text r1) {
        this.desc = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setLeftIcon(Icon r1) {
        this.leftIcon = r1;
    }

    public final void setLeftIconTag(Icon r1) {
        this.leftIconTag = r1;
    }

    public final void setLeftText(Text r1) {
        this.leftText = r1;
    }

    public final void setRightIcon(Icon r1) {
        this.rightIcon = r1;
    }
}
