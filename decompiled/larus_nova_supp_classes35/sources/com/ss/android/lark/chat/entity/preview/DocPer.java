package com.ss.android.lark.chat.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/DocPer;", "Ljava/io/Serializable;", "docTitle", BuildConfig.FLAVOR, "docType", "Lcom/ss/android/lark/chat/entity/preview/DocType;", "ownerName", "docUrl", "permissions", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/preview/DocPermission;", "messageIds", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/preview/DocType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDocTitle", "()Ljava/lang/String;", "getDocType", "()Lcom/ss/android/lark/chat/entity/preview/DocType;", "getOwnerName", "getDocUrl", "getPermissions", "()Ljava/util/List;", "getMessageIds", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPer implements Serializable {
    private final String docTitle;
    private final DocType docType;
    private final String docUrl;
    private final List<String> messageIds;
    private final String ownerName;
    private final List<DocPermission> permissions;

    public DocPer() {
        this(null, null, null, null, null, null, 63, null);
    }

    public int hashCode() {
        String r0 = this.docTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((((r2 * 31) + this.docType.hashCode()) * 31) + this.ownerName.hashCode()) * 31) + this.docUrl.hashCode()) * 31;
        List<DocPermission> r4 = this.permissions;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.messageIds;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String getDocTitle() {
        return this.docTitle;
    }

    public final DocType getDocType() {
        return this.docType;
    }

    public final String getDocUrl() {
        return this.docUrl;
    }

    public final List<String> getMessageIds() {
        return this.messageIds;
    }

    public final String getOwnerName() {
        return this.ownerName;
    }

    public final List<DocPermission> getPermissions() {
        return this.permissions;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocPer) == true) goto L8;
        return false;
    L8:
        DocPer r6 = (DocPer) r5;
        if (Intrinsics.areEqual(this.docTitle, r6.docTitle) == true) goto L12;
        return false;
    L12:
        if (this.docType == r6.docType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ownerName, r6.ownerName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.docUrl, r6.docUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.permissions, r6.permissions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageIds, r6.messageIds) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public DocPer(String r2, DocType r3, String r4, String r5, List<DocPermission> r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r3, "docType");
        Intrinsics.checkNotNullParameter(r4, "ownerName");
        Intrinsics.checkNotNullParameter(r5, "docUrl");
        this.docTitle = r2;
        this.docType = r3;
        this.ownerName = r4;
        this.docUrl = r5;
        this.permissions = r6;
        this.messageIds = r7;
    }

    public /* synthetic */ DocPer(String r5, DocType r6, String r7, String r8, List r9, List r10, int r11, DefaultConstructorMarker r12) {
        int r13 = r11 & 1;
        String r0 = BuildConfig.FLAVOR;
        if (r13 == 0) goto L5;
        String r14 = BuildConfig.FLAVOR;
    L7:
        if ((r11 & 2) == 0) goto L9;
        r6 = DocType.UNKNOWN;
    L9:
        DocType r1 = r6;
        if ((r11 & 4) == 0) goto L12;
        String r2 = BuildConfig.FLAVOR;
    L14:
        if ((r11 & 8) != 0) goto L18;
        r0 = r8;
    L18:
        if ((r11 & 16) == 0) goto L20;
        List r3 = null;
    L22:
        if ((r11 & 32) == 0) goto L24;
        List r15 = null;
    L25:
        this(r14, r1, r2, r0, r3, r15);
        return;
    L24:
        r15 = r10;
        goto L25
    L20:
        r3 = r9;
        goto L22
    L12:
        r2 = r7;
        goto L14
    L5:
        r14 = r5;
        goto L7
    }
}
