package com.obric.memorydata.migration.sdk.internal.archive;

import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003 !\"B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J4\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J \u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/archive/ZipArchive;", "", "bufferSize", "", "<init>", "(I)V", "ioBufferSize", "pack", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Lcom/obric/memorydata/migration/sdk/MigrationPackage;", "inputDir", "Ljava/io/File;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "dataKey", "", "(Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unpack", "encryptedPackageFile", "outputDir", "(Ljava/io/File;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcDirBytes", "", "dir", "readFullyOrThrow", "", "Ljava/io/InputStream;", "buf", "copyStream", "input", "output", "Ljava/io/OutputStream;", "ChunkedGcmEncryptingOutputStream", "ChunkedGcmDecryptingInputStream", "GcmDecryptingInputStream", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11906a;

    /* JADX INFO: renamed from: com.obric.memorydata.migration.sdk.internal.archive.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u00020\u0007H\u0016J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/archive/ZipArchive$ChunkedGcmDecryptingInputStream;", "Ljava/io/InputStream;", "encryptedIn", "key32", "", "baseNonce", "bufferSize", "", "<init>", "(Ljava/io/InputStream;[B[BI)V", "input", "Ljava/io/DataInputStream;", "cipherBuf", "singleByte", "plainBuf", "plainOff", "chunkIndex", "eof", "", "read", "b", f.g, "len", IslandSession.REOPEN_VALUE_CLOSE, "", "readNextChunk", "newChunkCipher", "Ljavax/crypto/Cipher;", "mode", "deriveNonce", "intToBytes", BaseSwitches.V, "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0644a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f11907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f11908b;
        private final DataInputStream c;
        private final byte[] d;
        private final byte[] e;
        private byte[] f;
        private int g;
        private int h;
        private boolean i;

        public C0644a(InputStream r2, byte[] r3, byte[] r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "encryptedIn");
            Intrinsics.checkNotNullParameter(r3, "key32");
            Intrinsics.checkNotNullParameter(r4, "baseNonce");
            this.f11907a = r3;
            this.f11908b = r4;
            this.c = new DataInputStream(r2);
            this.d = new byte[r5 + 64];
            this.e = new byte[1];
            this.f = new byte[0];
        }

        private final Cipher a(int r7, int r8) {
            byte[] r0 = a(r8);
            Cipher r1 = Cipher.getInstance("AES/GCM/NoPadding");
            byte[] r3 = Arrays.copyOf(this.f11907a, 32);
            Intrinsics.checkNotNullExpressionValue(r3, "copyOf(...)");
            r1.init(r7, (Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r3, CryptoConst.ALGORITHM_AES), Key.class, "com.obric.memorydata.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new GCMParameterSpec(128, r0), AlgorithmParameterSpec.class, "com.obric.memorydata.plugin"));
            r1.updateAAD(com.obric.memorydata.migration.sdk.internal.security.b.f11954a.b());
            r1.updateAAD(b(r8));
            Intrinsics.checkNotNull(r1);
            return r1;
        }

        private final boolean a() {
            boolean r0 = false;
            int r1 = this.c.readInt();     // Catch: EOFException -> L21
            if (r1 >= 0) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == false) goto L20;
            if (r1 != 0) goto L14;
            this.f = new byte[0];
            this.g = 0;
            this.h++;
            return true;
        L14:
            this.c.readFully(this.d, 0, r1);
            byte[] r2 = a(2, this.h).doFinal(this.d, 0, r1);
            Intrinsics.checkNotNullExpressionValue(r2, "doFinal(...)");
            this.f = r2;
            this.g = 0;
            this.h++;
            if (r2.length != 0) goto L18;
            r0 = true;
        L18:
            return !r0;
        L20:
            throw new IllegalStateException("invalid encrypted frame size=" + r1);
        L7:
            if (r1 > this.d.length) goto L9;
            r3 = true;
        L21:
            return false;
        }

        private final byte[] a(int r7) {
            byte[] r6 = this.f11908b;
            byte[] r8 = Arrays.copyOf(r6, r6.length);
            Intrinsics.checkNotNullExpressionValue(r8, "copyOf(...)");
            int r1 = ((((r8[8] << 24) | ((r8[9] & 255) << 16)) | ((r8[10] & 255) << 8)) | (r8[11] & 255)) + r7;
            r8[8] = (byte) (r1 >>> 24);
            r8[9] = (byte) (r1 >>> 16);
            r8[10] = (byte) (r1 >>> 8);
            r8[11] = (byte) r1;
            return r8;
        }

        private final byte[] b(int r3) {
            return new byte[]{(byte) (r3 >>> 24), (byte) (r3 >>> 16), (byte) (r3 >>> 8), (byte) r3};
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.c.close();
        }

        @Override // java.io.InputStream
        public int read() {
            if (read(this.e, 0, 1) > 0) goto L6;
            return -1;
        L6:
            return this.e[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "b");
            if (r6 != 0) goto L6;
            return 0;
        L6:
            int r0 = this.g;
            byte[] r1 = this.f;
            if (r0 < r1.length) goto L8;
            if (this.i == true) goto L12;
            if (a() == true) goto L6;
            this.i = true;
            return -1;
        L12:
            return -1;
        L8:
            int r7 = Math.min(r6, r1.length - r0);
            System.arraycopy(this.f, this.g, r4, r5, r7);
            this.g += r7;
            return r7;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/archive/ZipArchive$ChunkedGcmEncryptingOutputStream;", "Ljava/io/OutputStream;", "output", "key32", "", "baseNonce", "bufferSize", "", "<init>", "(Ljava/io/OutputStream;[B[BI)V", "out", "Ljava/io/DataOutputStream;", "plainBuf", "singleByte", "plainLen", "chunkIndex", "closed", "", "write", "", "b", f.g, "len", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, IslandSession.REOPEN_VALUE_CLOSE, "flushChunk", "newChunkCipher", "Ljavax/crypto/Cipher;", "mode", "deriveNonce", "intToBytes", BaseSwitches.V, "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f11909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f11910b;
        private final int c;
        private final DataOutputStream d;
        private final byte[] e;
        private final byte[] f;
        private int g;
        private int h;
        private boolean i;

        public b(OutputStream r2, byte[] r3, byte[] r4, int r5) {
            Intrinsics.checkNotNullParameter(r2, "output");
            Intrinsics.checkNotNullParameter(r3, "key32");
            Intrinsics.checkNotNullParameter(r4, "baseNonce");
            this.f11909a = r3;
            this.f11910b = r4;
            this.c = r5;
            this.d = new DataOutputStream(r2);
            this.e = new byte[r5];
            this.f = new byte[1];
        }

        private final Cipher a(int r7, int r8) {
            byte[] r0 = a(r8);
            Cipher r1 = Cipher.getInstance("AES/GCM/NoPadding");
            byte[] r3 = Arrays.copyOf(this.f11909a, 32);
            Intrinsics.checkNotNullExpressionValue(r3, "copyOf(...)");
            r1.init(r7, (Key) ZeusTransformUtils.preCheckCast(new SecretKeySpec(r3, CryptoConst.ALGORITHM_AES), Key.class, "com.obric.memorydata.plugin"), (AlgorithmParameterSpec) ZeusTransformUtils.preCheckCast(new GCMParameterSpec(128, r0), AlgorithmParameterSpec.class, "com.obric.memorydata.plugin"));
            r1.updateAAD(com.obric.memorydata.migration.sdk.internal.security.b.f11954a.b());
            r1.updateAAD(b(r8));
            Intrinsics.checkNotNull(r1);
            return r1;
        }

        private final void a() {
            if (this.g > 0) goto L5;
            return;
        L5:
            byte[] r0 = a(1, this.h).doFinal(this.e, 0, this.g);
            this.d.writeInt(r0.length);
            this.d.write(r0);
            this.g = 0;
            this.h++;
        }

        private final byte[] a(int r7) {
            byte[] r6 = this.f11910b;
            byte[] r8 = Arrays.copyOf(r6, r6.length);
            Intrinsics.checkNotNullExpressionValue(r8, "copyOf(...)");
            int r1 = ((((r8[8] << 24) | ((r8[9] & 255) << 16)) | ((r8[10] & 255) << 8)) | (r8[11] & 255)) + r7;
            r8[8] = (byte) (r1 >>> 24);
            r8[9] = (byte) (r1 >>> 16);
            r8[10] = (byte) (r1 >>> 8);
            r8[11] = (byte) r1;
            return r8;
        }

        private final byte[] b(int r3) {
            return new byte[]{(byte) (r3 >>> 24), (byte) (r3 >>> 16), (byte) (r3 >>> 8), (byte) r3};
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.i == false) goto L5;
            return;
        L5:
            this.i = true;
            a();
            this.d.flush();
            this.d.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.d.flush();
        }

        @Override // java.io.OutputStream
        public void write(int r3) {
            byte[] r0 = this.f;
            r0[0] = (byte) r3;
            write(r0, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "b");
            if (this.i == true) goto L12;
            if (r6 != 0) goto L6;
            return;
        L6:
            if (r6 <= 0) goto L10;
            int r0 = Math.min(r6, this.e.length - this.g);
            System.arraycopy(r4, r5, this.e, this.g, r0);
            int r1 = this.g + r0;
            this.g = r1;
            r5 = r5 + r0;
            r6 = r6 - r0;
            if (r1 != this.e.length) goto L6;
            a();
            goto L6
        L10:
            return;
        L12:
            throw new IOException("stream closed");
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/archive/ZipArchive$GcmDecryptingInputStream;", "Ljava/io/InputStream;", "encryptedIn", "cipher", "Ljavax/crypto/Cipher;", "bufferSize", "", "<init>", "(Ljava/io/InputStream;Ljavax/crypto/Cipher;I)V", "encryptedBuf", "", "plainBuf", "plainLen", "plainOff", "finalized", "", "read", "b", f.g, "len", IslandSession.REOPEN_VALUE_CLOSE, "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f11911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f11912b;
        private final int c;
        private final byte[] d;
        private final byte[] e;
        private int f;
        private int g;
        private boolean h;

        public c(InputStream r2, Cipher r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "encryptedIn");
            Intrinsics.checkNotNullParameter(r3, "cipher");
            this.f11911a = r2;
            this.f11912b = r3;
            this.c = r4;
            this.d = new byte[r4];
            this.e = new byte[RangesKt.coerceAtLeast(r3.getOutputSize(r4), r4 + 32)];
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.h == false) goto L11;
        L9:
            this.f11911a.close();
            return;
        L11:
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
            c r1 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            Result.m1421constructorimpl(Integer.valueOf(r1.f11912b.doFinal(r1.e, 0)));     // Catch: Throwable -> L6
        L8:
            this.h = true;
        L6:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // java.io.InputStream
        public int read() {
            byte[] r1 = new byte[1];
            if (read(r1, 0, 1) > 0) goto L6;
            return -1;
        L6:
            return r1[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] r11, int r12, int r13) {
            Intrinsics.checkNotNullParameter(r11, "b");
            if (r13 != 0) goto L5;
            return 0;
        L5:
            int r1 = this.g;
            int r2 = this.f;
            if (r1 < r2) goto L7;
            if (this.h == true) goto L11;
            int r7 = this.f11911a.read(this.d);
            if (r7 < 0) goto L14;
            if (r7 == 0) goto L5;
            int r3 = this.f11912b.update(this.d, 0, r7, this.e, 0);
            if (r3 <= 0) goto L5;
            this.f = r3;
            this.g = 0;
            goto L5
        L14:
            int r4 = this.f11912b.doFinal(this.e, 0);
            this.h = true;
            this.f = r4;
            this.g = 0;
            if (r4 != 0) goto L5;
            return -1;
        L11:
            return -1;
        L7:
            int r14 = Math.min(r13, r2 - r1);
            System.arraycopy(this.e, this.g, r11, r12, r14);
            this.g += r14;
            return r14;
        }
    }

    public a() {
        this(0, 1, null);
    }

    public a(int r3) {
        this.f11906a = RangesKt.coerceIn(r3, 4096, 262144);
    }

    public /* synthetic */ a(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 8192;
    L5:
        this(r1);
    }

    public static final /* synthetic */ int a(a r0) {
        return r0.f11906a;
    }

    public static final /* synthetic */ long a(a r0, File r1) {
        return r0.a(r1);
    }

    private final long a(File r9) {
        Iterator r10 = ((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkTopDown(r9), Sequence.class, "com.obric.memorydata.plugin")).iterator();
        long r4 = 0;
    L4:
        if (r10.hasNext() == false) goto L15;
        File r0 = (File) ZeusTransformUtils.preCheckCast(r10.next(), File.class, "com.obric.memorydata.plugin");
        if (r0.isFile() == false) goto L4;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        Object r1 = Result.m1421constructorimpl(Long.valueOf(r0.length()));     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r1) == false) goto L14;
        r1 = 0L;
    L14:
        r4 = r4 + ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    L15:
        return r4;
    }

    public static final /* synthetic */ void a(a r0, InputStream r1, OutputStream r2, byte[] r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ void a(a r0, InputStream r1, byte[] r2) {
        r0.a(r1, r2);
    }

    private final void a(InputStream r2, OutputStream r3, byte[] r4) {
    L2:
        int r1 = r2.read(r4);
        if (r1 < 0) goto L4;
        if (r1 == 0) goto L2;
        r3.write(r4, 0, r1);
        goto L2
    }

    private final void a(InputStream r2, byte[] r3) {
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L10;
        int r0 = r2.read(r3, r1, r3.length - r1);
        if (r0 <= 0) goto L9;
        r1 = r1 + r0;
        goto L4
    L9:
        throw new EOFException("unexpected EOF");
    }

    public final Object a(File r9, m r10, byte[] r11, Continuation<? super z<w>> r12) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r10, m.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ZipArchive$pack$2(r9, this, r5, r11, null), Function2.class, "com.obric.memorydata.plugin"), r13);
    }

    public final Object a(File r10, File r11, m r12, byte[] r13, Continuation<? super z<? extends File>> r14) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.memorydata.plugin");
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new ZipArchive$unpack$2(r10, r11, r5, this, r13, null), Function2.class, "com.obric.memorydata.plugin"), r15);
    }
}
