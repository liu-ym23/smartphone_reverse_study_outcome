package com.ss.android.lark.chameleonv2.lkapi.widget;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/IWidget$FilePickerShowOptions;", "Lcom/bytedance/ee/util/io/NonProguard;", "maxSelectedCount", BuildConfig.FLAVOR, "title", BuildConfig.FLAVOR, "confirmText", "showSystemPicker", BuildConfig.FLAVOR, "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getMaxSelectedCount", "()I", "getTitle", "()Ljava/lang/String;", "getConfirmText", "getShowSystemPicker", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IWidget$FilePickerShowOptions implements NonProguard {
    private final String confirmText;
    private final int maxSelectedCount;
    private final boolean showSystemPicker;
    private final String title;

    public static /* synthetic */ IWidget$FilePickerShowOptions copy$default(IWidget$FilePickerShowOptions r0, int r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.maxSelectedCount;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.title;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.confirmText;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.showSystemPicker;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.maxSelectedCount;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.confirmText;
    }

    public final boolean component4() {
        return this.showSystemPicker;
    }

    public final IWidget$FilePickerShowOptions copy(int r2, String r3, String r4, boolean r5) {
        return new IWidget$FilePickerShowOptions(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IWidget$FilePickerShowOptions) == true) goto L8;
        return false;
    L8:
        IWidget$FilePickerShowOptions r6 = (IWidget$FilePickerShowOptions) r5;
        if (this.maxSelectedCount == r6.maxSelectedCount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.confirmText, r6.confirmText) == true) goto L18;
        return false;
    L18:
        if (this.showSystemPicker == r6.showSystemPicker) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.maxSelectedCount * 31;
        String r1 = this.title;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.confirmText;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (r4 + r2) * 31;
        if (this.showSystemPicker == false) goto L13;
        int r7 = 1231;
    L15:
        return r6 + r7;
    L13:
        r7 = 1237;
        goto L15
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "FilePickerShowOptions(maxSelectedCount=" + this.maxSelectedCount + ", title=" + this.title + ", confirmText=" + this.confirmText + ", showSystemPicker=" + this.showSystemPicker + ')';
    }

    public final String getConfirmText() {
        return this.confirmText;
    }

    public final int getMaxSelectedCount() {
        return this.maxSelectedCount;
    }

    public final boolean getShowSystemPicker() {
        return this.showSystemPicker;
    }

    public final String getTitle() {
        return this.title;
    }

    public IWidget$FilePickerShowOptions(int r1, String r2, String r3, boolean r4) {
        this.maxSelectedCount = r1;
        this.title = r2;
        this.confirmText = r3;
        this.showSystemPicker = r4;
    }

    public /* synthetic */ IWidget$FilePickerShowOptions(int r2, String r3, String r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = true;
    L8:
        this(r2, r3, r4, r5);
    }
}
