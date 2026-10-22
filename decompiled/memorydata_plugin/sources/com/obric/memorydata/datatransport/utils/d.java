package com.obric.memorydata.datatransport.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult;", "", "<init>", "()V", "Success", "Failure", "Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult$Failure;", "Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult$Success;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class d {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult$Failure;", "Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult;", "privilegedStatus", "", "error", "", "<init>", "(ILjava/lang/Throwable;)V", "getPrivilegedStatus", "()I", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f9833b;

        public a(int r2, Throwable r3) {
            super(null);
            this.f9832a = r2;
            this.f9833b = r3;
        }

        public final int a() {
            return this.f9832a;
        }

        public final Throwable b() {
            return this.f9833b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f9832a == r6.f9832a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9833b, r6.f9833b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.f9832a) * 31;
            Throwable r1 = this.f9833b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Failure(privilegedStatus=" + this.f9832a + ", error=" + this.f9833b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult$Success;", "Lcom/obric/memorydata/datatransport/utils/AttachmentStreamOpenResult;", "<init>", "()V", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9834a = null;

        static {
            f9834a = new b();
        }

        private b() {
            super(null);
        }
    }

    private d() {
    }

    public /* synthetic */ d(DefaultConstructorMarker r1) {
        this();
    }
}
