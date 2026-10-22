package com.bytedance.ai.resource.core.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformDebugSchemaData;", "", com.bytedance.android.ec.core.event.a.KEY_URL, "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformDebugSchemaData {
    private final String url;

    public OpenPlatformDebugSchemaData() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ OpenPlatformDebugSchemaData copy$default(OpenPlatformDebugSchemaData r0, String r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r1 = r0.url;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.url;
    }

    public final OpenPlatformDebugSchemaData copy(String r10) {
        return new OpenPlatformDebugSchemaData(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof OpenPlatformDebugSchemaData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.url, ((OpenPlatformDebugSchemaData) r10).url) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.url;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "OpenPlatformDebugSchemaData(url=" + this.url + ')';
    }

    public final String getUrl() {
        return this.url;
    }

    public OpenPlatformDebugSchemaData(String r1) {
        this.url = r1;
    }

    public /* synthetic */ OpenPlatformDebugSchemaData(String r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
