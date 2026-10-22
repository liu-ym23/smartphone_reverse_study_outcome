package com.ss.android.lark.profile.v2.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/TextField;", "Lcom/ss/android/lark/profile/v2/entity/BaseField;", "Ljava/io/Serializable;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textStyle", "Lcom/ss/android/lark/profile/v2/entity/TextStyle;", "getTextStyle", "()Lcom/ss/android/lark/profile/v2/entity/TextStyle;", "setTextStyle", "(Lcom/ss/android/lark/profile/v2/entity/TextStyle;)V", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class TextField extends BaseField {
    private String text;
    private TextStyle textStyle;

    public TextField() {
    }

    public final String getText() {
        return this.text;
    }

    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    public final void setText(String r1) {
        this.text = r1;
    }

    public final void setTextStyle(TextStyle r1) {
        this.textStyle = r1;
    }
}
