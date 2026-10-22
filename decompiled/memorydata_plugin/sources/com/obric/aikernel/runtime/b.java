package com.obric.aikernel.runtime;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/aikernel/runtime/PackageDumpCommand;", "", "DownloadStatus", "RequestAllBackground", "UpdateTargetBackground", "Lcom/obric/aikernel/runtime/PackageDumpCommand$DownloadStatus;", "Lcom/obric/aikernel/runtime/PackageDumpCommand$RequestAllBackground;", "Lcom/obric/aikernel/runtime/PackageDumpCommand$UpdateTargetBackground;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface b {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/runtime/PackageDumpCommand$DownloadStatus;", "Lcom/obric/aikernel/runtime/PackageDumpCommand;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", Params.LORA_TYPE, "(Ljava/lang/String;Ljava/lang/String;)V", "getLoraType", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6188b;

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r3, Params.LORA_TYPE);
            this.f6187a = r2;
            this.f6188b = r3;
        }

        public final String a() {
            return this.f6187a;
        }

        public final String b() {
            return this.f6188b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6187a, r6.f6187a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6188b, r6.f6188b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f6187a.hashCode() * 31) + this.f6188b.hashCode();
        }

        public String toString() {
            return "DownloadStatus(packageName=" + this.f6187a + ", loraType=" + this.f6188b + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/aikernel/runtime/PackageDumpCommand$RequestAllBackground;", "Lcom/obric/aikernel/runtime/PackageDumpCommand;", "caller", "", "(Ljava/lang/String;)V", "getCaller", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0276b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6189a;

        public C0276b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "caller");
            this.f6189a = r2;
        }

        public final String a() {
            return this.f6189a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0276b.class) == true) goto L8;
            return false;
        L8:
            C0276b r6 = (C0276b) ZeusTransformUtils.preCheckCast(r5, C0276b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6189a, r6.f6189a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f6189a.hashCode();
        }

        public String toString() {
            return "RequestAllBackground(caller=" + this.f6189a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/runtime/PackageDumpCommand$UpdateTargetBackground;", "Lcom/obric/aikernel/runtime/PackageDumpCommand;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", Params.LORA_TYPE, "caller", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCaller", "()Ljava/lang/String;", "getLoraType", "getPackageName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6191b;
        private final String c;

        public c(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r3, Params.LORA_TYPE);
            Intrinsics.checkNotNullParameter(r4, "caller");
            this.f6190a = r2;
            this.f6191b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f6190a;
        }

        public final String b() {
            return this.f6191b;
        }

        public final String c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6190a, r6.f6190a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6191b, r6.f6191b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f6190a.hashCode() * 31) + this.f6191b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "UpdateTargetBackground(packageName=" + this.f6190a + ", loraType=" + this.f6191b + ", caller=" + this.c + ')';
        }
    }
}
