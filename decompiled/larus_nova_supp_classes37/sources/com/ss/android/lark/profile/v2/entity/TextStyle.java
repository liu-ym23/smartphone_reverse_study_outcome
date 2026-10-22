package com.ss.android.lark.profile.v2.entity;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/profile/v2/entity/TextStyle;", "Ljava/io/Serializable;", "<init>", "()V", "maxLines", "", "getMaxLines", "()I", "setMaxLines", "(I)V", "expandable", "", "getExpandable", "()Z", "setExpandable", "(Z)V", "color", "", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "profile-entity_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class TextStyle implements Serializable {
    private String color;
    private boolean expandable;
    private int maxLines;

    public TextStyle() {
        this.color = UserInfo.NONE_NAME_CARD_ID;
    }

    public final String getColor() {
        return this.color;
    }

    public final boolean getExpandable() {
        return this.expandable;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    public final void setColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.color = r2;
    }

    public final void setExpandable(boolean r1) {
        this.expandable = r1;
    }

    public final void setMaxLines(int r1) {
        this.maxLines = r1;
    }
}
