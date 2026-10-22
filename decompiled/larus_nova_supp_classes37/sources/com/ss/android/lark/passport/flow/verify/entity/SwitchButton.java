package com.ss.android.lark.passport.flow.verify.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/entity/SwitchButton;", "Ljava/io/Serializable;", "text", "", "actionType", "", "<init>", "(Ljava/lang/String;I)V", "getText", "()Ljava/lang/String;", "getActionType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class SwitchButton implements Serializable {
    private final int actionType;
    private final String text;

    public SwitchButton() {
        String r2 = null;
        this(r2, 0, 3, r2);
    }

    public static /* synthetic */ SwitchButton copy$default(SwitchButton r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.actionType;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.text;
    }

    public final int component2() {
        return this.actionType;
    }

    public final SwitchButton copy(@JSONField(name = "text") String r2, @JSONField(name = "action_type") int r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        return new SwitchButton(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SwitchButton) == true) goto L8;
        return false;
    L8:
        SwitchButton r6 = (SwitchButton) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (this.actionType == r6.actionType) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.actionType;
    }

    public String toString() {
        return "SwitchButton(text=" + this.text + ", actionType=" + this.actionType + ')';
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getText() {
        return this.text;
    }

    public SwitchButton(@JSONField(name = "text") String r2, @JSONField(name = "action_type") int r3) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.text = r2;
        this.actionType = r3;
    }

    public /* synthetic */ SwitchButton(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
