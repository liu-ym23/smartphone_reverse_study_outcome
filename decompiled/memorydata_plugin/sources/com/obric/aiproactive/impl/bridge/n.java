package com.obric.aiproactive.impl.bridge;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u001c\bÀ\u0002\u0018\u00002\u00020\u0001:\u000556789B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\bH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\bH\u0002J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001bJ \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u001f\u0010 \u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010#J\u001f\u0010$\u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010#J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0013H\u0002R\u000e\u0010&\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer;", "", "<init>", "()V", "normalize", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizationResult;", "file", "Ljava/io/File;", "Ljava/io/RandomAccessFile;", "inspect", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveLayout;", "readHeader", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveHeader;", "scanChunks", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveChunks;", "header", "readFormat", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveFormat;", TypedValues.CycleType.S_WAVE_OFFSET, "", "isUnambiguousStreamingPcm", "", "format", "dataSize", "readFourCc", "", "readUInt16", "(Ljava/io/RandomAccessFile;)Ljava/lang/Long;", "readUInt32", "writeUInt32", "", EventBody.KEY_VALUE, "checkedAdd", "left", "right", "(JJ)Ljava/lang/Long;", "checkedMultiply", "isWritableSize", "RIFF", "WAVE", "FORMAT", "DATA", "PCM_FORMAT", "UINT16_MAX", "UINT32_MAX", "UINT32_SENTINEL", "BITS_PER_BYTE", "FOUR_CC_BYTES", "RIFF_SIZE_OFFSET", "RIFF_HEADER_PREFIX_BYTES", "RIFF_HEADER_BYTES", "CHUNK_HEADER_BYTES", "MIN_FORMAT_BYTES", "WaveHeader", "WaveChunks", "WaveFormat", "WaveData", "WaveLayout", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f6422a = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveChunks;", "", "format", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveFormat;", "data", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveData;", "<init>", "(Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveFormat;Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveData;)V", "getFormat", "()Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveFormat;", "getData", "()Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f6423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f6424b;

        public a(c r1, b r2) {
            this.f6423a = r1;
            this.f6424b = r2;
        }

        public final c a() {
            return this.f6423a;
        }

        public final b b() {
            return this.f6424b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6423a, r6.f6423a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f6424b, r6.f6424b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            c r0 = this.f6423a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            b r4 = this.f6424b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "WaveChunks(format=" + this.f6423a + ", data=" + this.f6424b + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveData;", "", "sizeOffset", "", "size", "hasSentinel", "", "<init>", "(JJZ)V", "getSizeOffset", "()J", "getSize", "getHasSentinel", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6426b;
        private final boolean c;

        public b(long r1, long r3, boolean r5) {
            this.f6425a = r1;
            this.f6426b = r3;
            this.c = r5;
        }

        public final long a() {
            return this.f6425a;
        }

        public final long b() {
            return this.f6426b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.f6425a == r10.f6425a) goto L12;
            return false;
        L12:
            if (this.f6426b == r10.f6426b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f6425a) * 31) + Long.hashCode(this.f6426b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "WaveData(sizeOffset=" + this.f6425a + ", size=" + this.f6426b + ", hasSentinel=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveFormat;", "", "formatTag", "", "channels", "sampleRate", "byteRate", "blockAlign", "bitsPerSample", "<init>", "(JJJJJJ)V", "getFormatTag", "()J", "getChannels", "getSampleRate", "getByteRate", "getBlockAlign", "getBitsPerSample", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6428b;
        private final long c;
        private final long d;
        private final long e;
        private final long f;

        public c(long r1, long r3, long r5, long r7, long r9, long r11) {
            this.f6427a = r1;
            this.f6428b = r3;
            this.c = r5;
            this.d = r7;
            this.e = r9;
            this.f = r11;
        }

        public final long a() {
            return this.f6427a;
        }

        public final long b() {
            return this.f6428b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (this.f6427a == r10.f6427a) goto L12;
            return false;
        L12:
            if (this.f6428b == r10.f6428b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final long f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.f6427a) * 31) + Long.hashCode(this.f6428b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f);
        }

        public String toString() {
            return "WaveFormat(formatTag=" + this.f6427a + ", channels=" + this.f6428b + ", sampleRate=" + this.c + ", byteRate=" + this.d + ", blockAlign=" + this.e + ", bitsPerSample=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveHeader;", "", "fileSize", "", "end", "hasSentinel", "", "<init>", "(JJZ)V", "getFileSize", "()J", "getEnd", "getHasSentinel", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6430b;
        private final boolean c;

        public d(long r1, long r3, boolean r5) {
            this.f6429a = r1;
            this.f6430b = r3;
            this.c = r5;
        }

        public final long a() {
            return this.f6429a;
        }

        public final long b() {
            return this.f6430b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (this.f6429a == r10.f6429a) goto L12;
            return false;
        L12:
            if (this.f6430b == r10.f6430b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f6429a) * 31) + Long.hashCode(this.f6430b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "WaveHeader(fileSize=" + this.f6429a + ", end=" + this.f6430b + ", hasSentinel=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveLayout;", "", "requiresRewrite", "", "dataSizeOffset", "", "riffSize", "dataSize", "<init>", "(ZJJJ)V", "getRequiresRewrite", "()Z", "getDataSizeOffset", "()J", "getRiffSize", "getDataSize", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6431a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6432b;
        private final long c;
        private final long d;
        private final long e;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveLayout$Companion;", "", "<init>", "()V", "canonical", "Lcom/obric/aiproactive/impl/bridge/RemoteWaveNormalizer$WaveLayout;", "streaming", "dataSizeOffset", "", "riffSize", "dataSize", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final e a() {
                return new e(false, 0, 0, 0);
            }

            public final e a(long r9, long r11, long r13) {
                return new e(true, r9, r11, r13);
            }
        }

        static {
            f6431a = new a(null);
        }

        public e(boolean r1, long r2, long r4, long r6) {
            this.f6432b = r1;
            this.c = r2;
            this.d = r4;
            this.e = r6;
        }

        public final boolean a() {
            return this.f6432b;
        }

        public final long b() {
            return this.c;
        }

        public final long c() {
            return this.d;
        }

        public final long d() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
            return false;
        L8:
            e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.memorydata.plugin");
            if (this.f6432b == r10.f6432b) goto L12;
            return false;
        L12:
            if (this.c == r10.c) goto L15;
            return false;
        L15:
            if (this.d == r10.d) goto L18;
            return false;
        L18:
            if (this.e == r10.e) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.f6432b) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e);
        }

        public String toString() {
            return "WaveLayout(requiresRewrite=" + this.f6432b + ", dataSizeOffset=" + this.c + ", riffSize=" + this.d + ", dataSize=" + this.e + ')';
        }
    }

    static {
        f6422a = new n();
    }

    private n() {
    }

    private final RemoteWaveNormalizationResult a(RandomAccessFile r14) {
        e r0 = b(r14);
        if (r0 != null) goto L7;
        return RemoteWaveNormalizationResult.INVALID;
    L7:
        if (r0.a() == false) goto L9;
        a(r14, 4, r0.c());
        a(r14, r0.b(), r0.d());
        r14.getFD().sync();
        e r13 = b(r14);
        boolean r15 = false;
        if (r13 != null) goto L13;
    L15:
        if (r15 == false) goto L18;
        return RemoteWaveNormalizationResult.VALID;
    L18:
        return RemoteWaveNormalizationResult.INVALID;
    L13:
        if (r13.a() == true) goto L15;
        r15 = true;
        goto L15
    L9:
        return RemoteWaveNormalizationResult.VALID;
    }

    private final a a(RandomAccessFile r23, d r24) {
        a r2 = null;
        long r3 = 12;
        c r5 = null;
        b r6 = null;
    L4:
        if (r3 >= r24.b()) goto L49;
        Long r7 = a(r3, 8);
        if (r7 == null) goto L70;
        long r8 = r7.longValue();
        if (r8 > r24.b()) goto L9;
        r23.seek(r3);
        String r9 = d(r23);
        Long r10 = f(r23);
        if (r10 == null) goto L71;
        long r14 = r10.longValue();
        if (r14 == 4294967295L) goto L15;
        Long r11 = a(r8, r14);
        if (r11 == null) goto L72;
        long r20 = r3;
        Long r4 = a(r11.longValue(), r14 & 1);
        if (r4 == null) goto L46;
        r3 = r4.longValue();
        if (r3 > r24.b()) goto L29;
        if (Intrinsics.areEqual(r9, "fmt ") == false) goto L41;
        if (r5 != null) goto L39;
        if (r14 < 16) goto L39;
        r5 = a(r23, r8);
        if (r5 == null) goto L39;
    L45:
        r2 = null;
    L39:
        return null;
    L41:
        if (Intrinsics.areEqual(r9, "data") == false) goto L45;
        if (r6 != null) goto L43;
        r6 = new b(r20 + 4, r14, false);
        goto L45
    L43:
        return null;
    L29:
        return null;
    L46:
        return null;
    L72:
        return r2;
    L15:
        if (r24.c() == false) goto L22;
        if (Intrinsics.areEqual(r9, "data") == false) goto L22;
        if (r6 != null) goto L22;
        if (r5 == null) goto L22;
        r6 = new b(r3 + 4, r24.b() - r8, true);
        r3 = r24.b();
    L22:
        return r2;
    L71:
        return r2;
    L9:
        return r2;
    L70:
        return r2;
    L49:
        return new a(r5, r6);
    }

    private final c a(RandomAccessFile r16, long r17) {
        r16.seek(r17);
        Long r0 = e(r16);
        if (r0 == null) goto L16;
        long r3 = r0.longValue();
        Long r1 = e(r16);
        if (r1 == null) goto L16;
        long r5 = r1.longValue();
        Long r2 = f(r16);
        if (r2 == null) goto L16;
        long r7 = r2.longValue();
        Long r4 = f(r16);
        if (r4 == null) goto L16;
        long r9 = r4.longValue();
        Long r6 = e(r16);
        if (r6 == null) goto L16;
        long r11 = r6.longValue();
        Long r8 = e(r16);
        if (r8 == null) goto L16;
        return new c(r3, r5, r7, r9, r11, r8.longValue());
    L16:
        return null;
    }

    private final Long a(long r3, long r5) {
        if (r5 <= (Long.MAX_VALUE - r3)) goto L6;
        return null;
    L6:
        return Long.valueOf(r3 + r5);
    }

    private final void a(RandomAccessFile r1, long r2, long r4) {
        r1.seek(r2);
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L6;
        r1.writeByte(((int) (r4 >> (r0 * 8))) & 255);
        r0 = r0 + 1;
        goto L4
    }

    private final boolean a(long r4) {
        if (1 <= r4) goto L5;
        return false;
    L5:
        if (r4 >= 4294967295L) goto L9;
        return true;
    L9:
        return false;
    }

    private final boolean a(c r11, long r12) {
        if (r11.a() == 1) goto L5;
        return false;
    L5:
        if (r11.b() > 0) goto L7;
        return false;
    L7:
        if (r11.c() > 0) goto L9;
        return false;
    L9:
        if (r11.f() > 0) goto L11;
        return false;
    L11:
        if ((r11.f() % 8) == 0) goto L13;
        return false;
    L13:
        if (r11.e() > 1) goto L15;
        return false;
    L15:
        if (r11.d() > 0) goto L17;
        return false;
    L17:
        if (r12 > 0) goto L19;
        return false;
    L19:
        if ((r12 % r11.e()) == 0) goto L21;
        return false;
    L21:
        if ((r12 % 2) != 0) goto L52;
        long r13 = r11.f() / 8;
        Long r14 = b(r11.b(), r13);
        if (r14 == null) goto L46;
        long r15 = r14.longValue();
        Long r10 = b(r11.c(), r11.e());
        if (r10 == null) goto L47;
        long r2 = r10.longValue();
        if (r15 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) goto L30;
        return false;
    L30:
        if (r15 == r11.e()) goto L32;
        return false;
    L32:
        if (r2 <= 4294967295L) goto L34;
        return false;
    L34:
        if (r2 != r11.d()) goto L51;
        return true;
    L51:
        return false;
    L47:
        return false;
    L46:
        return false;
    L52:
        return false;
    }

    private final e b(RandomAccessFile r14) {
        d r0 = c(r14);
        if (r0 != null) goto L5;
        return null;
    L5:
        a r15 = a(r14, r0);
        if (r15 != null) goto L8;
        return null;
    L8:
        c r2 = r15.a();
        if (r2 != null) goto L11;
        return null;
    L11:
        b r16 = r15.b();
        if (r16 != null) goto L15;
        return null;
    L15:
        if (r0.c() == true) goto L19;
        return e.f6431a.a();
    L19:
        if (r16.c() == true) goto L21;
    L30:
        return null;
    L21:
        if (a(r2, r16.b()) == false) goto L30;
        long r9 = r0.a() - 8;
        if (a(r9) == false) goto L30;
        if (a(r16.b()) == false) goto L30;
        return e.f6431a.a(r16.a(), r9, r16.b());
    }

    private final Long b(long r5, long r7) {
        if (r5 >= 0) goto L5;
        return null;
    L5:
        if (r7 < 0) goto L18;
        if (r5 == 0) goto L15;
        if (r7 == 0) goto L15;
        if (r5 <= (Long.MAX_VALUE / r7)) goto L17;
        return null;
    L17:
        return Long.valueOf(r5 * r7);
    L15:
        return 0L;
    L18:
        return null;
    }

    private final d c(RandomAccessFile r9) {
        long r1 = r9.length();
        if (r1 >= 12) goto L5;
        return null;
    L5:
        r9.seek(0);
        if (Intrinsics.areEqual(d(r9), "RIFF") == true) goto L8;
        return null;
    L8:
        Long r0 = f(r9);
        if (r0 == null) goto L26;
        long r4 = r0.longValue();
        if (Intrinsics.areEqual(d(r9), "WAVE") == true) goto L14;
        return null;
    L14:
        if (r4 != 4294967295L) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == false) goto L19;
        Long r8 = Long.valueOf(r1);
    L20:
        if (r8 == null) goto L26;
        if (r8.longValue() != r1) goto L26;
        return new d(r1, r8.longValue(), r10);
    L19:
        r8 = a(8, r4);
        goto L20
    L16:
        r10 = false;
    L26:
        return null;
    }

    private final String d(RandomAccessFile r2) {
        byte[] r1 = new byte[4];
        r2.readFully(r1);
        return new String(r1, Charsets.US_ASCII);
    }

    private final Long e(RandomAccessFile r4) {
        return Long.valueOf((((long) r4.readUnsignedByte()) << 8) | r4.readUnsignedByte());
    L4:
        return null;
    }

    private final Long f(RandomAccessFile r5) {
        Long r0 = e(r5);
        if (r0 == null) goto L8;
        long r2 = r0.longValue();
        Long r4 = e(r5);
        if (r4 == null) goto L8;
        return Long.valueOf((r4.longValue() << 16) | r2);
    L8:
        return null;
    }

    public final RemoteWaveNormalizationResult a(File r4) {
        Intrinsics.checkNotNullParameter(r4, "file");
        if (r4.isFile() == false) goto L5;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(new RandomAccessFile(r4, "rw"), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        RemoteWaveNormalizationResult r3 = a((RandomAccessFile) ZeusTransformUtils.preCheckCast(r5, RandomAccessFile.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L16 Throwable -> L16 Throwable -> L16
        return r3;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L16 Throwable -> L16 Throwable -> L16
        throw th;     // Catch: Throwable -> L16 Throwable -> L16 Throwable -> L16
    L17:
        return RemoteWaveNormalizationResult.IO_FAILURE;
    L5:
        return RemoteWaveNormalizationResult.IO_FAILURE;
    }
}
