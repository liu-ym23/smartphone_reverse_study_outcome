package com.obric.memorydata.datatransport.manager;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution;", "", "<init>", "()V", "IdentityUnavailable", "StoreUnavailable", "Available", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution$Available;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution$IdentityUnavailable;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution$StoreUnavailable;", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class i {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution$Available;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution;", "store", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStore;", "<init>", "(Lcom/obric/memorydata/datatransport/manager/DataExportTaskStore;)V", "getStore", "()Lcom/obric/memorydata/datatransport/manager/DataExportTaskStore;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f9775a;

        public a(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "store");
            super(null);
            this.f9775a = r4;
        }

        public final h a() {
            return this.f9775a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f9775a, r6.f9775a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f9775a.hashCode();
        }

        public String toString() {
            return "Available(store=" + this.f9775a + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution$IdentityUnavailable;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9776a = null;

        static {
            f9776a = new b();
        }

        private b() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return 170550301;
        }

        public String toString() {
            return "IdentityUnavailable";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution$StoreUnavailable;", "Lcom/obric/memorydata/datatransport/manager/DataExportTaskStoreResolution;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9777a = null;

        static {
            f9777a = new c();
        }

        private c() {
            super(null);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L9;
            return false;
        L9:
            c r2 = (c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin");
            return true;
        }

        public int hashCode() {
            return -1420199644;
        }

        public String toString() {
            return "StoreUnavailable";
        }
    }

    private i() {
    }

    public /* synthetic */ i(DefaultConstructorMarker r1) {
        this();
    }
}
