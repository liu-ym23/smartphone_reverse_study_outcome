package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.text.TextUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResInfo;", BuildConfig.FLAVOR, "revision", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_VERSION, "(Ljava/lang/String;Ljava/lang/String;)V", "getRevision", "()Ljava/lang/String;", "setRevision", "(Ljava/lang/String;)V", "getVersion", "setVersion", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "isEmpty", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonResInfo {
    private String revision;
    private String version;

    public ChameleonResInfo() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ ChameleonResInfo copy$default(ChameleonResInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.revision;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.version;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.revision;
    }

    public final String component2() {
        return this.version;
    }

    public final ChameleonResInfo copy(String r2, String r3) {
        return new ChameleonResInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChameleonResInfo) == true) goto L8;
        return false;
    L8:
        ChameleonResInfo r6 = (ChameleonResInfo) r5;
        if (Intrinsics.areEqual(this.revision, r6.revision) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.version, r6.version) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.revision;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.version;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ChameleonResInfo(revision=" + this.revision + ", version=" + this.version + ')';
    }

    public final boolean isEmpty() {
        if (TextUtils.isEmpty(this.revision) == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(this.version) == false) goto L7;
        return true;
    }

    public final String getRevision() {
        return this.revision;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setRevision(String r1) {
        this.revision = r1;
    }

    public final void setVersion(String r1) {
        this.version = r1;
    }

    public ChameleonResInfo(String r1, String r2) {
        this.revision = r1;
        this.version = r2;
    }

    public /* synthetic */ ChameleonResInfo(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
