package com.ss.android.lark.export.entity.turtle;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "Ljava/io/Serializable;", "scriptKey", BuildConfig.FLAVOR, "scriptVersion", BuildConfig.FLAVOR, "scriptPath", "pbData", "Lokio/ByteString;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lokio/ByteString;)V", "getScriptKey", "()Ljava/lang/String;", "getScriptVersion", "()I", "getScriptPath", "getPbData", "()Lokio/ByteString;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TurtleCanvasEntity implements Serializable {
    private final ByteString pbData;
    private final String scriptKey;
    private final String scriptPath;
    private final int scriptVersion;

    public TurtleCanvasEntity() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ TurtleCanvasEntity copy$default(TurtleCanvasEntity r0, String r1, int r2, String r3, ByteString r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.scriptKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.scriptVersion;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.scriptPath;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.pbData;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.scriptKey;
    }

    public final int component2() {
        return this.scriptVersion;
    }

    public final String component3() {
        return this.scriptPath;
    }

    public final ByteString component4() {
        return this.pbData;
    }

    public final TurtleCanvasEntity copy(String r2, int r3, String r4, ByteString r5) {
        return new TurtleCanvasEntity(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TurtleCanvasEntity) == true) goto L8;
        return false;
    L8:
        TurtleCanvasEntity r6 = (TurtleCanvasEntity) r5;
        if (Intrinsics.areEqual(this.scriptKey, r6.scriptKey) == true) goto L12;
        return false;
    L12:
        if (this.scriptVersion == r6.scriptVersion) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scriptPath, r6.scriptPath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pbData, r6.pbData) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.scriptKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.scriptVersion) * 31;
        String r4 = this.scriptPath;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        ByteString r7 = this.pbData;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TurtleCanvasEntity(scriptKey=" + this.scriptKey + ", scriptVersion=" + this.scriptVersion + ", scriptPath=" + this.scriptPath + ", pbData=" + this.pbData + ')';
    }

    public final ByteString getPbData() {
        return this.pbData;
    }

    public final String getScriptKey() {
        return this.scriptKey;
    }

    public final String getScriptPath() {
        return this.scriptPath;
    }

    public final int getScriptVersion() {
        return this.scriptVersion;
    }

    public TurtleCanvasEntity(String r1, int r2, String r3, ByteString r4) {
        this.scriptKey = r1;
        this.scriptVersion = r2;
        this.scriptPath = r3;
        this.pbData = r4;
    }

    public /* synthetic */ TurtleCanvasEntity(String r2, int r3, String r4, ByteString r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
