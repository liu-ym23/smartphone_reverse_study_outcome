package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAction;", "Lcom/bytedance/ee/util/io/NonProguard;", "key", BuildConfig.FLAVOR, "disabled", BuildConfig.FLAVOR, "text", "typeX", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getDisabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getText", "getTypeX", IPortraitService.TYPE, "Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogActionType;", "getType", "()Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogActionType;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$Internal$ConfirmDialogAction;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$Internal$ConfirmDialogAction implements NonProguard {
    private final Boolean disabled;
    private final String key;
    private final String text;
    private final String typeX;

    public static /* synthetic */ IWidget$Internal$ConfirmDialogAction copy$default(IWidget$Internal$ConfirmDialogAction r0, String r1, Boolean r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.disabled;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.text;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.typeX;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.key;
    }

    public final Boolean component2() {
        return this.disabled;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.typeX;
    }

    public final IWidget$Internal$ConfirmDialogAction copy(String r2, Boolean r3, String r4, @JSONField(name = IPortraitService.TYPE) String r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "typeX");
        return new IWidget$Internal$ConfirmDialogAction(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWidget$Internal$ConfirmDialogAction) == true) goto L8;
        return false;
    L8:
        IWidget$Internal$ConfirmDialogAction r6 = (IWidget$Internal$ConfirmDialogAction) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.disabled, r6.disabled) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.typeX, r6.typeX) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.key.hashCode() * 31;
        Boolean r1 = this.disabled;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.text.hashCode()) * 31) + this.typeX.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ConfirmDialogAction(key=" + this.key + ", disabled=" + this.disabled + ", text=" + this.text + ", typeX=" + this.typeX + ')';
    }

    public final IWidget$Internal$ConfirmDialogActionType getType() {
        IWidget$Internal$ConfirmDialogActionType.a r0 = IWidget$Internal$ConfirmDialogActionType.Companion;
        String r1 = this.typeX;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "value");
        IWidget$Internal$ConfirmDialogActionType[] r2 = IWidget$Internal$ConfirmDialogActionType.values();
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L8;
        IWidget$Internal$ConfirmDialogActionType r5 = r2[r4];
        if (Intrinsics.areEqual(r5.getValue(), r1) == true) goto L9;
        r4 = r4 + 1;
    L9:
        if (r5 == null) goto L12;
        return r5;
    L12:
        return IWidget$Internal$ConfirmDialogActionType.Secondary;
    L8:
        r5 = null;
        goto L9
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTypeX() {
        return this.typeX;
    }

    public IWidget$Internal$ConfirmDialogAction(String r2, Boolean r3, String r4, @JSONField(name = IPortraitService.TYPE) String r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "text");
        Intrinsics.checkNotNullParameter(r5, "typeX");
        this.key = r2;
        this.disabled = r3;
        this.text = r4;
        this.typeX = r5;
    }
}
