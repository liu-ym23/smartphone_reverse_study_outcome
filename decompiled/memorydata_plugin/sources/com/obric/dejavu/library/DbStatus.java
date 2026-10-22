package com.obric.dejavu.library;

import androidx.core.app.NotificationCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/obric/dejavu/library/DbStatus;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "(ILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "equals", "", "other", "Companion", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbStatus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7870a = null;
    private static final DbStatus d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7871b;
    private final String c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/dejavu/library/DbStatus$Companion;", "", "()V", "Success", "Lcom/obric/dejavu/library/DbStatus;", "getSuccess", "()Lcom/obric/dejavu/library/DbStatus;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final DbStatus a() {
            return DbStatus.c();
        }
    }

    static {
        f7870a = new a(null);
        d = new DbStatus(0, "");
    }

    public DbStatus(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, NotificationCompat.CATEGORY_MESSAGE);
        this.f7871b = r2;
        this.c = r3;
    }

    public static final /* synthetic */ DbStatus c() {
        return d;
    }

    public final int a() {
        return this.f7871b;
    }

    public final String b() {
        return this.c;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 == null) goto L8;
        Class<?> r3 = r7.getClass();
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.dejavu.library.DbStatus");
        DbStatus r4 = (DbStatus) ZeusTransformUtils.preCheckCast(r7, DbStatus.class, "com.obric.memorydata.plugin");
        if (this.f7871b == ((DbStatus) ZeusTransformUtils.preCheckCast(r7, DbStatus.class, "com.obric.memorydata.plugin")).f7871b) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.c, ((DbStatus) ZeusTransformUtils.preCheckCast(r7, DbStatus.class, "com.obric.memorydata.plugin")).c) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r3 = null;
        goto L10
    }
}
