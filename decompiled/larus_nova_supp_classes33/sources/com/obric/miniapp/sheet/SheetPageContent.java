package com.obric.miniapp.sheet;

import com.lynx.tasm.TemplateBundle;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/miniapp/sheet/SheetPageContent;", "", "realUrl", "", "packageName", "bundleId", "isWidget", "", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/lynx/tasm/TemplateBundle;)V", "getRealUrl", "()Ljava/lang/String;", "getPackageName", "getBundleId", "()Z", "getBundle", "()Lcom/lynx/tasm/TemplateBundle;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SheetPageContent {
    private final TemplateBundle bundle;
    private final String bundleId;
    private final boolean isWidget;
    private final String packageName;
    private final String realUrl;

    public static /* synthetic */ SheetPageContent copy$default(SheetPageContent r3, String r4, String r5, String r6, boolean r7, TemplateBundle r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.realUrl;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.packageName;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.bundleId;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isWidget;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.bundle;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.realUrl;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.bundleId;
    }

    public final boolean component4() {
        return this.isWidget;
    }

    public final TemplateBundle component5() {
        return this.bundle;
    }

    public final SheetPageContent copy(String r8, String r9, String r10, boolean r11, TemplateBundle r12) {
        Intrinsics.checkNotNullParameter(r8, "realUrl");
        Intrinsics.checkNotNullParameter(r9, "packageName");
        return new SheetPageContent(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SheetPageContent) == true) goto L8;
        return false;
    L8:
        SheetPageContent r6 = (SheetPageContent) r5;
        if (Intrinsics.areEqual(this.realUrl, r6.realUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bundleId, r6.bundleId) == true) goto L18;
        return false;
    L18:
        if (this.isWidget == r6.isWidget) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bundle, r6.bundle) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String toString() {
        return "SheetPageContent(realUrl=" + this.realUrl + ", packageName=" + this.packageName + ", bundleId=" + this.bundleId + ", isWidget=" + this.isWidget + ", bundle=" + this.bundle + ')';
    }

    public int hashCode() {
        int r0 = ((this.realUrl.hashCode() * 31) + this.packageName.hashCode()) * 31;
        String r1 = this.bundleId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.isWidget == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        TemplateBundle r7 = this.bundle;
        if (r7 == null) goto L15;
        r7.getClass();
        r2 = System.identityHashCode(r7);
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final TemplateBundle getBundle() {
        return this.bundle;
    }

    public final String getBundleId() {
        return this.bundleId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getRealUrl() {
        return this.realUrl;
    }

    public final boolean isWidget() {
        return this.isWidget;
    }

    public SheetPageContent(String r2, String r3, String r4, boolean r5, TemplateBundle r6) {
        Intrinsics.checkNotNullParameter(r2, "realUrl");
        Intrinsics.checkNotNullParameter(r3, "packageName");
        this.realUrl = r2;
        this.packageName = r3;
        this.bundleId = r4;
        this.isWidget = r5;
        this.bundle = r6;
    }
}
