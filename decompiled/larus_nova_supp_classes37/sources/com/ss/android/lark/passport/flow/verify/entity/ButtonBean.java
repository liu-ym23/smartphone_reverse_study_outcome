package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/ButtonBean;", "Ljava/io/Serializable;", "text", "", "actionType", "", "next", "Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/passport/flow/core/router/FlowStep;)V", "getText", "()Ljava/lang/String;", "getActionType", "()I", "getNext", "()Lcom/ss/android/lark/passport/flow/core/router/FlowStep;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ButtonBean implements Serializable {
    private final int actionType;
    private final FlowStep next;
    private final String text;

    public static /* synthetic */ ButtonBean copy$default(ButtonBean r0, String r1, int r2, FlowStep r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.actionType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.next;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.actionType;
    }

    public final FlowStep component3() {
        return this.next;
    }

    public final ButtonBean copy(@JSONField(name = "text") String r2, @JSONField(name = "action_type") int r3, @JSONField(name = "next") FlowStep r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return new ButtonBean(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ButtonBean) == true) goto L8;
        return false;
    L8:
        ButtonBean r6 = (ButtonBean) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (this.actionType == r6.actionType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.next, r6.next) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.text.hashCode() * 31) + this.actionType) * 31;
        FlowStep r1 = this.next;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ButtonBean(text=" + this.text + ", actionType=" + this.actionType + ", next=" + this.next + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final FlowStep getNext() {
        return this.next;
    }

    public final String getText() {
        return this.text;
    }

    public ButtonBean(@JSONField(name = "text") String r2, @JSONField(name = "action_type") int r3, @JSONField(name = "next") FlowStep r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.text = r2;
        this.actionType = r3;
        this.next = r4;
    }

    public /* synthetic */ ButtonBean(String r1, int r2, FlowStep r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2, r3);
    }
}
