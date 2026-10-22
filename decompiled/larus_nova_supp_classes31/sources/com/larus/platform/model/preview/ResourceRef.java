package com.larus.platform.model.preview;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/platform/model/preview/ResourceRef;", "Ljava/io/Serializable;", "uri", "", "kind", "Lcom/larus/platform/model/preview/ResourceRefKind;", "remoteKey", "width", "", "height", "<init>", "(Ljava/lang/String;Lcom/larus/platform/model/preview/ResourceRefKind;Ljava/lang/String;II)V", "getUri", "()Ljava/lang/String;", "getKind", "()Lcom/larus/platform/model/preview/ResourceRefKind;", "getRemoteKey", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ResourceRef implements Serializable {
    private final int height;
    private final ResourceRefKind kind;
    private final String remoteKey;
    private final String uri;
    private final int width;

    public static /* synthetic */ ResourceRef copy$default(ResourceRef r3, String r4, ResourceRefKind r5, String r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.uri;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.kind;
    L8:
        ResourceRefKind r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.remoteKey;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.width;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.height;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.uri;
    }

    public final ResourceRefKind component2() {
        return this.kind;
    }

    public final String component3() {
        return this.remoteKey;
    }

    public final int component4() {
        return this.width;
    }

    public final int component5() {
        return this.height;
    }

    public final ResourceRef copy(String r8, ResourceRefKind r9, String r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "uri");
        Intrinsics.checkNotNullParameter(r9, "kind");
        return new ResourceRef(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResourceRef) == true) goto L8;
        return false;
    L8:
        ResourceRef r6 = (ResourceRef) r5;
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
        return false;
    L12:
        if (this.kind == r6.kind) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.remoteKey, r6.remoteKey) == true) goto L18;
        return false;
    L18:
        if (this.width == r6.width) goto L21;
        return false;
    L21:
        if (this.height == r6.height) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.uri.hashCode() * 31) + this.kind.hashCode()) * 31;
        String r1 = this.remoteKey;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.width) * 31) + this.height;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ResourceRef(uri=" + this.uri + ", kind=" + this.kind + ", remoteKey=" + this.remoteKey + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public final int getHeight() {
        return this.height;
    }

    public final ResourceRefKind getKind() {
        return this.kind;
    }

    public final String getRemoteKey() {
        return this.remoteKey;
    }

    public final String getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public ResourceRef(String r2, ResourceRefKind r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "kind");
        this.uri = r2;
        this.kind = r3;
        this.remoteKey = r4;
        this.width = r5;
        this.height = r6;
    }

    public /* synthetic */ ResourceRef(String r7, ResourceRefKind r8, String r9, int r10, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = ResourceRefKind.LOCAL_URI;
    L5:
        ResourceRefKind r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = null;
    L8:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L11;
        int r4 = 0;
    L13:
        if ((r12 & 16) == 0) goto L15;
        int r5 = 0;
    L16:
        this(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L11:
        r4 = r10;
        goto L13
    }
}
