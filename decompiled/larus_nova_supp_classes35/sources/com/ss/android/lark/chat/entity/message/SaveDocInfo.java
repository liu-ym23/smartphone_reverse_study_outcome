package com.ss.android.lark.chat.entity.message;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/SaveDocInfo;", "Ljava/io/Serializable;", "saveCardDocButton", "Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;", "cardKey", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;Ljava/lang/String;)V", "getSaveCardDocButton", "()Lcom/ss/android/lark/chat/entity/message/CustomizeAIButton;", "getCardKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveDocInfo implements Serializable {

    @SerializedName("card_key")
    private final String cardKey;

    @SerializedName("save_card_doc_button")
    private final CustomizeAIButton saveCardDocButton;

    /* JADX WARN: Multi-variable type inference failed */
    public SaveDocInfo() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SaveDocInfo copy$default(SaveDocInfo r0, CustomizeAIButton r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.saveCardDocButton;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.cardKey;
    L9:
        return r0.copy(r1, r2);
    }

    public final CustomizeAIButton component1() {
        return this.saveCardDocButton;
    }

    public final String component2() {
        return this.cardKey;
    }

    public final SaveDocInfo copy(CustomizeAIButton r2, String r3) {
        return new SaveDocInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SaveDocInfo) == true) goto L8;
        return false;
    L8:
        SaveDocInfo r6 = (SaveDocInfo) r5;
        if (Intrinsics.areEqual(this.saveCardDocButton, r6.saveCardDocButton) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cardKey, r6.cardKey) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        CustomizeAIButton r0 = this.saveCardDocButton;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.cardKey;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SaveDocInfo(saveCardDocButton=" + this.saveCardDocButton + ", cardKey=" + this.cardKey + ')';
    }

    public final String getCardKey() {
        return this.cardKey;
    }

    public final CustomizeAIButton getSaveCardDocButton() {
        return this.saveCardDocButton;
    }

    public SaveDocInfo(CustomizeAIButton r1, String r2) {
        this.saveCardDocButton = r1;
        this.cardKey = r2;
    }

    public /* synthetic */ SaveDocInfo(CustomizeAIButton r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
