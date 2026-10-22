package com.obric.memorydata.migration.sdk;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "Success", "Failure", "Lcom/obric/memorydata/migration/sdk/MigrationResult$Failure;", "Lcom/obric/memorydata/migration/sdk/MigrationResult$Success;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class z<T> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationResult$Failure;", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "error", "Lcom/obric/memorydata/migration/sdk/MigrationError;", "<init>", "(Lcom/obric/memorydata/migration/sdk/MigrationError;)V", "getError", "()Lcom/obric/memorydata/migration/sdk/MigrationError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f11990a;

        public a(o r2) {
            Intrinsics.checkNotNullParameter(r2, "error");
            super(null);
            this.f11990a = r2;
        }

        public final o a() {
            return this.f11990a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11990a, r6.f11990a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f11990a.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.f11990a + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationResult$Success;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/obric/memorydata/migration/sdk/MigrationResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> extends z<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f11991a;

        public b(T r2) {
            super(null);
            this.f11991a = r2;
        }

        public final T a() {
            return this.f11991a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11991a, r6.f11991a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            T r0 = this.f11991a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f11991a + ')';
        }
    }

    private z() {
    }

    public /* synthetic */ z(DefaultConstructorMarker r1) {
        this();
    }
}
