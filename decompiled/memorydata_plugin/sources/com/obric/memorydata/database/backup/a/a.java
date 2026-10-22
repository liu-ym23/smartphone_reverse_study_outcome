package com.obric.memorydata.database.backup.a;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001a*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001aB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0013\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u000eX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", ExifInterface.GPS_DIRECTION_TRUE, "", "backupUserId", "", "backupDbVersion", "", "<init>", "(Ljava/lang/String;I)V", "getBackupUserId", "()Ljava/lang/String;", "getBackupDbVersion", "()I", OaidModel.KEY_ID, "", "getId", "()J", "setId", "(J)V", "convertToOriginalEntity", "()Ljava/lang/Object;", "convertToBackUpEntity", "originalEntity", "(Ljava/lang/Object;Ljava/lang/String;I)Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", "convertToFakeAppEntity", "Lcom/obric/memorydata/database/backup/appentity/AbstractFakeAppEntity;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0454a f8842a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8843b;
    private final int c;

    /* JADX INFO: renamed from: com.obric.memorydata.database.backup.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity$Companion;", "", "<init>", "()V", "PREFIX_TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0454a {
        private C0454a() {
        }

        public /* synthetic */ C0454a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8842a = new C0454a(null);
    }

    public a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "backupUserId");
        this.f8843b = r2;
        this.c = r3;
    }

    public abstract a<T> a(T r1, String r2, int r3);

    public String a() {
        return this.f8843b;
    }

    public abstract void a(long r1);

    public int b() {
        return this.c;
    }

    public abstract long c();

    public abstract T d();
}
