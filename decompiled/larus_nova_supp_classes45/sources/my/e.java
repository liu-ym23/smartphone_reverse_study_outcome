package my;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public final boolean a;
    public final String b;
    public final String c;
    public final long d;
    public final long e;

    public final String toString() {
        return "BackupSeiInfo[isFromBackup = " + this.a + ", backupSource = " + this.b + ", streamId = " + this.c + ", backupPts = " + this.d + ", timeDiff = " + this.e + ']';
    }

    public e(boolean r2, String r3, String r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r3, "backupSource");
        Intrinsics.checkNotNullParameter(r4, "streamId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
    }
}
