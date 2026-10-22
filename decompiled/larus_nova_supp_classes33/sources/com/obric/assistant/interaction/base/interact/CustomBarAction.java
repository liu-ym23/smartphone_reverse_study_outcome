package com.obric.assistant.interaction.base.interact;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/interaction/base/interact/CustomBarAction;", "", "key", "", "uri", "errorMsg", "fileSize", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getKey", "()Ljava/lang/String;", "getUri", "getErrorMsg", "getFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/assistant/interaction/base/interact/CustomBarAction;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomBarAction {
    private final String errorMsg;
    private final Long fileSize;
    private final String key;
    private final String uri;

    public static /* synthetic */ CustomBarAction copy$default(CustomBarAction r0, String r1, String r2, String r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.uri;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.errorMsg;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.fileSize;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.uri;
    }

    public final String component3() {
        return this.errorMsg;
    }

    public final Long component4() {
        return this.fileSize;
    }

    public final CustomBarAction copy(@ObricCustomBarActionType String r2, String r3, String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        return new CustomBarAction(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CustomBarAction) == true) goto L8;
        return false;
    L8:
        CustomBarAction r6 = (CustomBarAction) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorMsg, r6.errorMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileSize, r6.fileSize) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.key.hashCode() * 31) + this.uri.hashCode()) * 31) + this.errorMsg.hashCode()) * 31;
        Long r1 = this.fileSize;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "CustomBarAction(key=" + this.key + ", uri=" + this.uri + ", errorMsg=" + this.errorMsg + ", fileSize=" + this.fileSize + ')';
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUri() {
        return this.uri;
    }

    public CustomBarAction(@ObricCustomBarActionType String r2, String r3, String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        this.key = r2;
        this.uri = r3;
        this.errorMsg = r4;
        this.fileSize = r5;
    }

    public /* synthetic */ CustomBarAction(String r2, String r3, String r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = "";
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }
}
