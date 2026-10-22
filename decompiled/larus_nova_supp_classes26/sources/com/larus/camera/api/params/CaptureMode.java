package com.larus.camera.api.params;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/camera/api/params/CaptureMode;", "Ljava/io/Serializable;", "mode", "", "tabName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMode", "()Ljava/lang/String;", "getTabName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureMode implements Serializable {
    public static final a Companion = null;
    public static final CaptureMode a = null;
    private static final long serialVersionUID = 1;
    private final String mode;
    private final String tabName;

    public static final class a {
        public a() {
        }
    }

    public static /* synthetic */ CaptureMode copy$default(CaptureMode r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.mode;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tabName;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.mode;
    }

    public final String component2() {
        return this.tabName;
    }

    public final CaptureMode copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "tabName");
        return new CaptureMode(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CaptureMode) == true) goto L8;
        return false;
    L8:
        CaptureMode r6 = (CaptureMode) r5;
        if (Intrinsics.areEqual(this.mode, r6.mode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabName, r6.tabName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.mode.hashCode() * 31) + this.tabName.hashCode();
    }

    public String toString() {
        return "CaptureMode(mode=" + this.mode + ", tabName=" + this.tabName + ')';
    }

    static {
        Companion = new a();
        a = new CaptureMode("", "");
    }

    public static final /* synthetic */ CaptureMode access$getDEFAULT$cp() {
        return a;
    }

    public final String getMode() {
        return this.mode;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public CaptureMode(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "tabName");
        this.mode = r2;
        this.tabName = r3;
    }
}
