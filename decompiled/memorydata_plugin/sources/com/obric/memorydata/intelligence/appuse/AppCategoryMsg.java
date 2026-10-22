package com.obric.memorydata.intelligence.appuse;

import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\""}, d2 = {"Lcom/obric/memorydata/intelligence/appuse/AppCategoryMsg;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "appType", "", EventBody.KEY_CATEGORY, "categoryId", "", "subCategory", "subCategoryId", "<init>", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;J)V", "getPackageName", "()Ljava/lang/String;", "getAppType", "()I", "getCategory", "getCategoryId", "()J", "getSubCategory", "getSubCategoryId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppCategoryMsg {
    private final int appType;
    private final String category;
    private final long categoryId;
    private final String packageName;
    private final String subCategory;
    private final long subCategoryId;

    public AppCategoryMsg(String r2, int r3, String r4, long r5, String r7, long r8) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r7, "subCategory");
        this.packageName = r2;
        this.appType = r3;
        this.category = r4;
        this.categoryId = r5;
        this.subCategory = r7;
        this.subCategoryId = r8;
    }

    public static /* synthetic */ AppCategoryMsg copy$default(AppCategoryMsg r9, String r10, int r11, String r12, long r13, String r15, long r16, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r1 = r9.packageName;
    L7:
        if ((r18 & 2) == 0) goto L9;
        int r2 = r9.appType;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r3 = r9.category;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r4 = r9.categoryId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.subCategory;
    L23:
        if ((r18 & 32) == 0) goto L25;
        long r7 = r9.subCategoryId;
    L27:
        return r9.copy(r1, r2, r3, r4, r6, r7);
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String component1() {
        return this.packageName;
    }

    public final int component2() {
        return this.appType;
    }

    public final String component3() {
        return this.category;
    }

    public final long component4() {
        return this.categoryId;
    }

    public final String component5() {
        return this.subCategory;
    }

    public final long component6() {
        return this.subCategoryId;
    }

    public final AppCategoryMsg copy(String r11, int r12, String r13, long r14, String r16, long r17) {
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r13, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r16, "subCategory");
        return new AppCategoryMsg(r11, r12, r13, r14, r16, r17);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AppCategoryMsg.class) == true) goto L8;
        return false;
    L8:
        AppCategoryMsg r10 = (AppCategoryMsg) ZeusTransformUtils.preCheckCast(r9, AppCategoryMsg.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L12;
        return false;
    L12:
        if (this.appType == r10.appType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.category, r10.category) == true) goto L18;
        return false;
    L18:
        if (this.categoryId == r10.categoryId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subCategory, r10.subCategory) == true) goto L24;
        return false;
    L24:
        if (this.subCategoryId == r10.subCategoryId) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getAppType() {
        return this.appType;
    }

    public final String getCategory() {
        return this.category;
    }

    public final long getCategoryId() {
        return this.categoryId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSubCategory() {
        return this.subCategory;
    }

    public final long getSubCategoryId() {
        return this.subCategoryId;
    }

    public int hashCode() {
        return (((((((((this.packageName.hashCode() * 31) + Integer.hashCode(this.appType)) * 31) + this.category.hashCode()) * 31) + Long.hashCode(this.categoryId)) * 31) + this.subCategory.hashCode()) * 31) + Long.hashCode(this.subCategoryId);
    }

    public String toString() {
        return "AppCategoryMsg(packageName=" + this.packageName + ", appType=" + this.appType + ", category=" + this.category + ", categoryId=" + this.categoryId + ", subCategory=" + this.subCategory + ", subCategoryId=" + this.subCategoryId + ')';
    }
}
