package com.ss.android.lark.chat.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/DocPermission;", "Ljava/io/Serializable;", "permissionCode", BuildConfig.FLAVOR, "permissionName", BuildConfig.FLAVOR, "isSet", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Z)V", "getPermissionCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPermissionName", "()Ljava/lang/String;", "()Z", "equals", "other", BuildConfig.FLAVOR, "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermission implements Serializable {
    private final boolean isSet;
    private final Integer permissionCode;
    private final String permissionName;

    public DocPermission() {
        this(null, null, false, 7, null);
    }

    public int hashCode() {
        Integer r0 = this.permissionCode;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        int r3 = r2 * 31;
        String r4 = this.permissionName;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        if (this.isSet == false) goto L12;
        int r6 = 1231;
    L14:
        return r5 + r6;
    L12:
        r6 = 1237;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    public final Integer getPermissionCode() {
        return this.permissionCode;
    }

    public final String getPermissionName() {
        return this.permissionName;
    }

    public final boolean isSet() {
        return this.isSet;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocPermission) == true) goto L8;
        return false;
    L8:
        DocPermission r6 = (DocPermission) r5;
        if (Intrinsics.areEqual(this.permissionCode, r6.permissionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.permissionName, r6.permissionName) == true) goto L15;
        return false;
    L15:
        if (this.isSet == r6.isSet) goto L17;
        return false;
    L17:
        return true;
    }

    public DocPermission(Integer r1, String r2, boolean r3) {
        this.permissionCode = r1;
        this.permissionName = r2;
        this.isSet = r3;
    }

    public /* synthetic */ DocPermission(Integer r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
