package com.obric.memorydata.migration.sdk;

import com.bytedance.crypto.e2eetrans.CryptoSession;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u000b\u0082\u0001\u0001\r¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/migration/sdk/Connection;", "", "<init>", "()V", "outputStream", "Ljava/io/OutputStream;", "inputStream", "Ljava/io/InputStream;", "dataKey", "", IslandSession.REOPEN_VALUE_CLOSE, "", "Tcp", "Lcom/obric/memorydata/migration/sdk/Connection$Tcp;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class e {

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/obric/memorydata/migration/sdk/Connection$Tcp;", "Lcom/obric/memorydata/migration/sdk/Connection;", "socket", "Ljava/net/Socket;", "dataKey", "", "securityProtocol", "Lcom/obric/memorydata/migration/sdk/MigrationSecurityProtocol;", "cryptoSession", "Lcom/bytedance/crypto/e2eetrans/CryptoSession;", "<init>", "(Ljava/net/Socket;[BLcom/obric/memorydata/migration/sdk/MigrationSecurityProtocol;Lcom/bytedance/crypto/e2eetrans/CryptoSession;)V", "getSocket", "()Ljava/net/Socket;", "getDataKey", "()[B", "getSecurityProtocol", "()Lcom/obric/memorydata/migration/sdk/MigrationSecurityProtocol;", "getCryptoSession", "()Lcom/bytedance/crypto/e2eetrans/CryptoSession;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Socket f11895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f11896b;
        private final MigrationSecurityProtocol c;
        private final CryptoSession d;

        public a(Socket r3, byte[] r4, MigrationSecurityProtocol r5, CryptoSession r6) {
            CryptoSession r7 = (CryptoSession) ZeusTransformUtils.wrapperContextForParams(r6, CryptoSession.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "socket");
            Intrinsics.checkNotNullParameter(r4, "dataKey");
            Intrinsics.checkNotNullParameter(r5, "securityProtocol");
            super(null);
            this.f11895a = r3;
            this.f11896b = r4;
            this.c = r5;
            this.d = r7;
        }

        public /* synthetic */ a(Socket r2, byte[] r3, MigrationSecurityProtocol r4, CryptoSession r5, int r6, DefaultConstructorMarker r7) {
            CryptoSession r8 = (CryptoSession) ZeusTransformUtils.wrapperContextForParams(r5, CryptoSession.class, "com.obric.memorydata.plugin");
            if ((r6 & 8) == 0) goto L5;
            r8 = null;
        L5:
            this(r2, r3, r4, r8);
        }

        public final Socket e() {
            return this.f11895a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11895a, r6.f11895a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11896b, r6.f11896b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final byte[] f() {
            return this.f11896b;
        }

        public final MigrationSecurityProtocol g() {
            return this.c;
        }

        public final CryptoSession h() {
            return this.d;
        }

        public int hashCode() {
            int r0 = ((((this.f11895a.hashCode() * 31) + Arrays.hashCode(this.f11896b)) * 31) + this.c.hashCode()) * 31;
            CryptoSession r2 = this.d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "Tcp(socket=" + this.f11895a + ", dataKey=" + Arrays.toString(this.f11896b) + ", securityProtocol=" + this.c + ", cryptoSession=" + this.d + ')';
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker r1) {
        this();
    }

    public final OutputStream a() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.Connection.Tcp");
        OutputStream r2 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).e().getOutputStream();
        Intrinsics.checkNotNullExpressionValue(r2, "getOutputStream(...)");
        return r2;
    }

    public final InputStream b() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.Connection.Tcp");
        InputStream r2 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).e().getInputStream();
        Intrinsics.checkNotNullExpressionValue(r2, "getInputStream(...)");
        return r2;
    }

    public final byte[] c() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.obric.memorydata.migration.sdk.Connection.Tcp");
        return ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).f();
    }

    public final void d() {
        if (ZeusTransformUtils.instanceOf(this, a.class) == false) goto L22;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        CryptoSession r2 = ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).h();     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        r2.close();     // Catch: Throwable -> L10
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Result.m1421constructorimpl(r3);     // Catch: Throwable -> L10
    L12:
        ArraysKt.fill$default(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).f(), (byte) 0, 0, 0, 6, null);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin")).e().close();     // Catch: Throwable -> L15
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        return;
    L7:
        r3 = null;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
