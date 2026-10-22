package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Ipc$ConfirmDialogClosedDetails;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", BuildConfig.FLAVOR, "reason", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogCloseReason;", "actionKey", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogCloseReason;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getReason", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogCloseReason;", "getActionKey", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Ipc$ConfirmDialogClosedDetails implements NonProguard {
    private final String actionKey;
    private final String id;
    private final IWidget$Internal$ConfirmDialogCloseReason reason;

    public static /* synthetic */ IWidget$Ipc$ConfirmDialogClosedDetails copy$default(IWidget$Ipc$ConfirmDialogClosedDetails r0, String r1, IWidget$Internal$ConfirmDialogCloseReason r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.reason;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.actionKey;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.id;
    }

    public final IWidget$Internal$ConfirmDialogCloseReason component2() {
        return this.reason;
    }

    public final String component3() {
        return this.actionKey;
    }

    public final IWidget$Ipc$ConfirmDialogClosedDetails copy(String r2, IWidget$Internal$ConfirmDialogCloseReason r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "reason");
        return new IWidget$Ipc$ConfirmDialogClosedDetails(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWidget$Ipc$ConfirmDialogClosedDetails) == true) goto L8;
        return false;
    L8:
        IWidget$Ipc$ConfirmDialogClosedDetails r6 = (IWidget$Ipc$ConfirmDialogClosedDetails) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (this.reason == r6.reason) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actionKey, r6.actionKey) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.id.hashCode() * 31) + this.reason.hashCode()) * 31;
        String r1 = this.actionKey;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ConfirmDialogClosedDetails(id=" + this.id + ", reason=" + this.reason + ", actionKey=" + this.actionKey + ')';
    }

    public final String getActionKey() {
        return this.actionKey;
    }

    public final String getId() {
        return this.id;
    }

    public final IWidget$Internal$ConfirmDialogCloseReason getReason() {
        return this.reason;
    }

    public IWidget$Ipc$ConfirmDialogClosedDetails(String r2, IWidget$Internal$ConfirmDialogCloseReason r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.id = r2;
        this.reason = r3;
        this.actionKey = r4;
    }
}
