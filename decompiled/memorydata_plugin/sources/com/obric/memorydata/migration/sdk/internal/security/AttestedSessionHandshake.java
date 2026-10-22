package com.obric.memorydata.migration.sdk.internal.security;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crypto.e2eetrans.CryptoException;
import com.bytedance.crypto.e2eetrans.CryptoSession;
import com.bytedance.crypto.e2eetrans.KeyManagerAttestationService;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u000289B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001cJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001cJL\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0015\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00052 \b\u0004\u0010!\u001a\u001a\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u00150\"H\u0082H¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0005H\u0002J\u001c\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010'H\u0002J\u000e\u0010-\u001a\u0004\u0018\u00010.*\u00020/H\u0002J \u00100\u001a\u00020)2\u0006\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u0002042\u0006\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/security/AttestedSessionHandshake;", "", "<init>", "()V", "APP_ID", "", "ARCHIVE_KEY_DATA_ID", "ARCHIVE_KEY_VERSION", "", "ARCHIVE_KEY_BYTES", "HANDSHAKE_TIMEOUT_MS", "SESSION_TIMEOUT_MS", "", "MAX_FRAME_BYTES", "FRAME_MAGIC", "TYPE_INITIATOR_AUTH", "TYPE_RESPONDER_AUTH", "TYPE_RESPONDER_FINISH", "TYPE_INITIATOR_FINISH", "TYPE_ARCHIVE_KEY", "asInitiator", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/internal/security/AttestedSessionHandshake$Result;", "context", "Landroid/content/Context;", "socket", "Ljava/net/Socket;", "accountId", "(Landroid/content/Context;Ljava/net/Socket;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asResponder", "runHandshake", ExifInterface.GPS_DIRECTION_TRUE, "role", "block", "Lkotlin/Function2;", "Ljava/io/DataInputStream;", "Ljava/io/DataOutputStream;", "(Ljava/net/Socket;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newAttestationService", "Lcom/bytedance/crypto/e2eetrans/KeyManagerAttestationService;", "closeFailedSession", "", "session", "Lcom/bytedance/crypto/e2eetrans/CryptoSession;", "attestation", "findCryptoException", "Lcom/bytedance/crypto/e2eetrans/CryptoException;", "", "writeFrame", "output", "type", "payload", "", "readFrame", "input", "expectedType", "Result", "StageException", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AttestedSessionHandshake {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AttestedSessionHandshake f11950a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/security/AttestedSessionHandshake$StageException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "stage", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getStage", "()Ljava/lang/String;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class StageException extends RuntimeException {
        private final String stage;

        public StageException(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "stage");
            Intrinsics.checkNotNullParameter(r3, "cause");
            super(r3);
            this.stage = r2;
        }

        public final String getStage() {
            return this.stage;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/security/AttestedSessionHandshake$Result;", "", "cryptoSession", "Lcom/bytedance/crypto/e2eetrans/CryptoSession;", "archiveKey", "", "<init>", "(Lcom/bytedance/crypto/e2eetrans/CryptoSession;[B)V", "getCryptoSession", "()Lcom/bytedance/crypto/e2eetrans/CryptoSession;", "getArchiveKey", "()[B", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CryptoSession f11951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f11952b;

        public a(CryptoSession r3, byte[] r4) {
            CryptoSession r5 = (CryptoSession) ZeusTransformUtils.wrapperContextForParams(r3, CryptoSession.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "cryptoSession");
            Intrinsics.checkNotNullParameter(r4, "archiveKey");
            this.f11951a = r5;
            this.f11952b = r4;
        }

        public final CryptoSession a() {
            return this.f11951a;
        }

        public final byte[] b() {
            return this.f11952b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f11951a, r6.f11951a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f11952b, r6.f11952b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f11951a.hashCode() * 31) + Arrays.hashCode(this.f11952b);
        }

        public String toString() {
            return "Result(cryptoSession=" + this.f11951a + ", archiveKey=" + Arrays.toString(this.f11952b) + ')';
        }
    }

    static {
        f11950a = new AttestedSessionHandshake();
    }

    private AttestedSessionHandshake() {
    }

    public static final /* synthetic */ CryptoException a(AttestedSessionHandshake r0, Throwable r1) {
        return r0.a(r1);
    }

    private final CryptoException a(Throwable r2) {
    L2:
        if (r2 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r2, CryptoException.class) == true) goto L6;
        r2 = r2.getCause();
        goto L2
    L6:
        return (CryptoException) ZeusTransformUtils.preCheckCast(r2, CryptoException.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }

    private final KeyManagerAttestationService a(Context r8, String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("memory_migration_v2_").append(r9).append('_');
        String r1 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        String r11 = r10.append(StringsKt.replace$default(r1, "-", "", false, 4, null)).toString();
        return new KeyManagerAttestationService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11);
    }

    public static final /* synthetic */ KeyManagerAttestationService a(AttestedSessionHandshake r2, Context r3, String r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void a(CryptoSession r4, KeyManagerAttestationService r5) {
        CryptoSession r6 = (CryptoSession) ZeusTransformUtils.wrapperContextForParams(r4, CryptoSession.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L5;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L11
        AttestedSessionHandshake r3 = (AttestedSessionHandshake) ZeusTransformUtils.preCheckCast(this, AttestedSessionHandshake.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        r6.close();     // Catch: Throwable -> L11
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L5:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L11
        AttestedSessionHandshake r9 = (AttestedSessionHandshake) ZeusTransformUtils.preCheckCast(this, AttestedSessionHandshake.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        r5.destroy();     // Catch: Throwable -> L11
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Result.m1421constructorimpl(r10);     // Catch: Throwable -> L11
        return;
    L8:
        r10 = null;
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    }

    public static final /* synthetic */ void a(AttestedSessionHandshake r2, CryptoSession r3, KeyManagerAttestationService r4) {
        r2.a((CryptoSession) ZeusTransformUtils.wrapperContextForParams(r3, CryptoSession.class, "com.obric.memorydata.plugin"), r4);
    }

    public static final /* synthetic */ void a(AttestedSessionHandshake r0, DataOutputStream r1, int r2, byte[] r3) {
        r0.a(r1, r2, r3);
    }

    private final void a(DataOutputStream r4, int r5, byte[] r6) {
        boolean r0 = false;
        if (r6.length != 0) goto L5;
        boolean r3 = true;
    L7:
        if ((!r3) == true) goto L9;
    L11:
        if (r0 == false) goto L15;
        r4.writeInt(1296520754);
        r4.writeInt(r5);
        r4.writeInt(r6.length);
        r4.write(r6);
        r4.flush();
        return;
    L15:
        throw new IllegalArgumentException(("invalid V2 frame size=" + r6.length).toString());
    L9:
        if (r6.length > 65536) goto L11;
        r0 = true;
        goto L11
    L5:
        r3 = false;
        goto L7
    }

    public static final /* synthetic */ byte[] a(AttestedSessionHandshake r0, DataInputStream r1, int r2) {
        return r0.a(r1, r2);
    }

    private final byte[] a(DataInputStream r4, int r5) {
        boolean r0 = true;
        if (r4.readInt() != 1296520754) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L26;
        int r6 = r4.readInt();
        if (r6 != r5) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L24;
        int r7 = r4.readInt();
        if (1 <= r7) goto L15;
    L17:
        r0 = false;
    L18:
        if (r0 == false) goto L22;
        byte[] r8 = new byte[r7];
        r4.readFully(r8);
        return r8;
    L22:
        throw new IllegalStateException(("invalid V2 frame size=" + r7).toString());
    L15:
        if (r7 >= 65537) goto L17;
    L24:
        throw new IllegalStateException(("unexpected V2 frame type=" + r6 + ", expected=" + r5).toString());
    L10:
        r2 = false;
        goto L11
    L26:
        throw new IllegalStateException("invalid V2 frame magic".toString());
    L5:
        r3 = false;
        goto L6
    }

    public final Object a(Context r8, Socket r9, String r10, Continuation<? super z<a>> r11) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AttestedSessionHandshake$asInitiator$$inlined$runHandshake$1(r9, "initiator", null, r5, r10), Function2.class, "com.obric.memorydata.plugin"), r7);
    }

    public final Object b(Context r8, Socket r9, String r10, Continuation<? super z<a>> r11) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AttestedSessionHandshake$asResponder$$inlined$runHandshake$1(r9, "responder", null, r5, r10), Function2.class, "com.obric.memorydata.plugin"), r7);
    }
}
