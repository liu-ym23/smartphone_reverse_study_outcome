package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogShowResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "id", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ConfirmDialogShowResult implements NonProguard {
    private final String id;

    public static /* synthetic */ IWidget$Internal$ConfirmDialogShowResult copy$default(IWidget$Internal$ConfirmDialogShowResult r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.id;
    }

    public final IWidget$Internal$ConfirmDialogShowResult copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return new IWidget$Internal$ConfirmDialogShowResult(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof IWidget$Internal$ConfirmDialogShowResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.id, ((IWidget$Internal$ConfirmDialogShowResult) r4).id) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "ConfirmDialogShowResult(id=" + this.id + ')';
    }

    public final String getId() {
        return this.id;
    }

    public IWidget$Internal$ConfirmDialogShowResult(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        this.id = r2;
    }
}
