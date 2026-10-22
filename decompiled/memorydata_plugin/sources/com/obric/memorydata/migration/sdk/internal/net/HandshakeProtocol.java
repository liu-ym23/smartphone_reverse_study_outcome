package com.obric.memorydata.migration.sdk.internal.net;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fJ4\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fJj\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0007\"\u0004\b\u0000\u0010\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2>\b\u0004\u0010\u0016\u001a8\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u00070\u0017H\u0082H¢\u0006\u0002\u0010\u001eJ\f\u0010\u001f\u001a\u00020 *\u00020!H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00072\u0006\u0010$\u001a\u00020%H\u0002J\u001a\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\fH\u0002J\u001a\u0010)\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\fH\u0002J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol;", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(Lcom/google/gson/Gson;)V", "asReceiver", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "socket", "Ljava/net/Socket;", "pairingCode", "", "protocolVersion", "senderUidHash", "(Ljava/net/Socket;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asSender", "expectedPairingCode", "expectedProtocolVersion", "runHandshake", ExifInterface.GPS_DIRECTION_TRUE, "role", "block", "Lkotlin/Function2;", "Ljava/io/DataInputStream;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "input", "Ljava/io/DataOutputStream;", "out", "(Ljava/net/Socket;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isHandshakeDisconnected", "", "", "ackToResult", "", "ack", "Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol$Ack;", "decodeBase64OrThrow", "base64", "errMsg", "decodeNonceOrThrow", "writeFrame", "json", "readFrame", "Companion", "Hello", "Ack", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HandshakeProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Gson f11934b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol$Ack;", "", "ok", "", "code", "", "message", "senderNonceBase64", "pairingProofBase64", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOk", "()Z", "getCode", "()Ljava/lang/String;", "getMessage", "getSenderNonceBase64", "getPairingProofBase64", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Ack {

        @SerializedName("code")
        private final String code;

        @SerializedName("message")
        private final String message;

        @SerializedName("ok")
        private final boolean ok;

        @SerializedName("pairingProofBase64")
        private final String pairingProofBase64;

        @SerializedName("senderNonceBase64")
        private final String senderNonceBase64;

        public Ack(boolean r1, String r2, String r3, String r4, String r5) {
            this.ok = r1;
            this.code = r2;
            this.message = r3;
            this.senderNonceBase64 = r4;
            this.pairingProofBase64 = r5;
        }

        public /* synthetic */ Ack(boolean r8, String r9, String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r13 & 4) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r13 & 8) == 0) goto L13;
            String r5 = null;
        L15:
            if ((r13 & 16) == 0) goto L17;
            String r6 = null;
        L18:
            this(r8, r3, r4, r5, r6);
            return;
        L17:
            r6 = r12;
            goto L18
        L13:
            r5 = r11;
            goto L15
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public static /* synthetic */ Ack copy$default(Ack r3, boolean r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.ok;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.code;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.message;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.senderNonceBase64;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.pairingProofBase64;
        L17:
            boolean r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final boolean component1() {
            return this.ok;
        }

        public final String component2() {
            return this.code;
        }

        public final String component3() {
            return this.message;
        }

        public final String component4() {
            return this.senderNonceBase64;
        }

        public final String component5() {
            return this.pairingProofBase64;
        }

        public final Ack copy(boolean r7, String r8, String r9, String r10, String r11) {
            return new Ack(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Ack.class) == true) goto L8;
            return false;
        L8:
            Ack r6 = (Ack) ZeusTransformUtils.preCheckCast(r5, Ack.class, "com.obric.memorydata.plugin");
            if (this.ok == r6.ok) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.code, r6.code) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.message, r6.message) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.senderNonceBase64, r6.senderNonceBase64) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.pairingProofBase64, r6.pairingProofBase64) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public final boolean getOk() {
            return this.ok;
        }

        public final String getPairingProofBase64() {
            return this.pairingProofBase64;
        }

        public final String getSenderNonceBase64() {
            return this.senderNonceBase64;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.ok) * 31;
            String r1 = this.code;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.message;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.senderNonceBase64;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.pairingProofBase64;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Ack(ok=" + this.ok + ", code=" + this.code + ", message=" + this.message + ", senderNonceBase64=" + this.senderNonceBase64 + ", pairingProofBase64=" + this.pairingProofBase64 + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol$Hello;", "", "protocolVersion", "", "receiverNonceBase64", "pairingProofBase64", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProtocolVersion", "()Ljava/lang/String;", "getReceiverNonceBase64", "getPairingProofBase64", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Hello {

        @SerializedName("pairingProofBase64")
        private final String pairingProofBase64;

        @SerializedName("protocolVersion")
        private final String protocolVersion;

        @SerializedName("receiverNonceBase64")
        private final String receiverNonceBase64;

        public Hello(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "protocolVersion");
            Intrinsics.checkNotNullParameter(r3, "receiverNonceBase64");
            Intrinsics.checkNotNullParameter(r4, "pairingProofBase64");
            this.protocolVersion = r2;
            this.receiverNonceBase64 = r3;
            this.pairingProofBase64 = r4;
        }

        public static /* synthetic */ Hello copy$default(Hello r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.protocolVersion;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.receiverNonceBase64;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.pairingProofBase64;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.protocolVersion;
        }

        public final String component2() {
            return this.receiverNonceBase64;
        }

        public final String component3() {
            return this.pairingProofBase64;
        }

        public final Hello copy(String r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "protocolVersion");
            Intrinsics.checkNotNullParameter(r2, "receiverNonceBase64");
            Intrinsics.checkNotNullParameter(r3, "pairingProofBase64");
            return new Hello(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Hello.class) == true) goto L8;
            return false;
        L8:
            Hello r6 = (Hello) ZeusTransformUtils.preCheckCast(r5, Hello.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.protocolVersion, r6.protocolVersion) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.receiverNonceBase64, r6.receiverNonceBase64) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pairingProofBase64, r6.pairingProofBase64) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getPairingProofBase64() {
            return this.pairingProofBase64;
        }

        public final String getProtocolVersion() {
            return this.protocolVersion;
        }

        public final String getReceiverNonceBase64() {
            return this.receiverNonceBase64;
        }

        public int hashCode() {
            return (((this.protocolVersion.hashCode() * 31) + this.receiverNonceBase64.hashCode()) * 31) + this.pairingProofBase64.hashCode();
        }

        public String toString() {
            return "Hello(protocolVersion=" + this.protocolVersion + ", receiverNonceBase64=" + this.receiverNonceBase64 + ", pairingProofBase64=" + this.pairingProofBase64 + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/net/HandshakeProtocol$Companion;", "", "<init>", "()V", "HANDSHAKE_SOCKET_TIMEOUT_MS", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class b implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HandshakeProtocol f11935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataInputStream f11936b;

        b(HandshakeProtocol r1, DataInputStream r2) {
            this.f11935a = r1;
            this.f11936b = r2;
        }

        public final String a() {
            return HandshakeProtocol.a(this.f11935a, this.f11936b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class c implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HandshakeProtocol f11937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataOutputStream f11938b;

        c(HandshakeProtocol r1, DataOutputStream r2) {
            this.f11937a = r1;
            this.f11938b = r2;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            HandshakeProtocol.a(this.f11937a, this.f11938b, r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HandshakeProtocol f11939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataInputStream f11940b;

        d(HandshakeProtocol r1, DataInputStream r2) {
            this.f11939a = r1;
            this.f11940b = r2;
        }

        public final String a() {
            return HandshakeProtocol.a(this.f11939a, this.f11940b);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* synthetic */ String invoke() {
            return a();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class e implements Function1<String, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HandshakeProtocol f11941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DataOutputStream f11942b;

        e(HandshakeProtocol r1, DataOutputStream r2) {
            this.f11941a = r1;
            this.f11942b = r2;
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            HandshakeProtocol.a(this.f11941a, this.f11942b, r2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(String r3) {
            a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    static {
        f11933a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HandshakeProtocol() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public HandshakeProtocol(Gson r2) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        this.f11934b = r2;
    }

    public /* synthetic */ HandshakeProtocol(Gson r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new Gson();
    L5:
        this(r1);
    }

    public static final /* synthetic */ Gson a(HandshakeProtocol r0) {
        return r0.f11934b;
    }

    private final z<Unit> a(Ack r9) {
        if (r9.getOk() == false) goto L7;
        Object r8 = new z.b(Unit.INSTANCE);
    L6:
        return (z) ZeusTransformUtils.preCheckCast(r8, z.class, "com.obric.memorydata.plugin");
    L7:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(MigrationErrorCode.getEntries(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        Object r1 = r10.next();
        if (Intrinsics.areEqual(((MigrationErrorCode) ZeusTransformUtils.preCheckCast(r1, MigrationErrorCode.class, "com.obric.memorydata.plugin")).name(), r9.getCode()) == false) goto L9;
    L14:
        MigrationErrorCode r11 = (MigrationErrorCode) ZeusTransformUtils.preCheckCast(r1, MigrationErrorCode.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L17;
        r11 = MigrationErrorCode.CONNECT_FAILED;
    L17:
        MigrationErrorCode r2 = r11;
        String r12 = r9.getMessage();
        if (r12 != null) goto L20;
        r12 = "握手失败";
    L20:
        r8 = new z.a(new o(r2, r12, null, 4, null));
        goto L6
    L13:
        r1 = null;
        goto L14
    }

    public static final /* synthetic */ z a(HandshakeProtocol r0, Ack r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ String a(HandshakeProtocol r0, DataInputStream r1) {
        return r0.a(r1);
    }

    private final String a(DataInputStream r4) {
        int r3 = r4.readInt();
        boolean r0 = false;
        if (1 <= r3) goto L5;
    L7:
        if (r0 == false) goto L11;
        byte[] r5 = new byte[r3];
        r4.readFully(r5);
        return new String(r5, Charsets.UTF_8);
    L11:
        throw new IllegalStateException("invalid frame size=" + r3);
    L5:
        if (r3 >= 1048577) goto L7;
        r0 = true;
        goto L7
    }

    public static final /* synthetic */ void a(HandshakeProtocol r0, DataOutputStream r1, String r2) {
        r0.a(r1, r2);
    }

    private final void a(DataOutputStream r1, String r2) {
        byte[] r0 = r2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");
        r1.writeInt(r0.length);
        r1.write(r0);
        r1.flush();
    }

    public static final /* synthetic */ boolean a(HandshakeProtocol r0, Throwable r1) {
        return r0.a(r1);
    }

    private final boolean a(Throwable r6) {
    L2:
        if (r6 == null) goto L26;
        if (ZeusTransformUtils.instanceOf(r6, EOFException.class) == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r6, SocketException.class) == true) goto L8;
        if (ZeusTransformUtils.instanceOf(r6, IOException.class) == false) goto L25;
        String r5 = ((IOException) ZeusTransformUtils.preCheckCast(r6, IOException.class, "com.obric.memorydata.plugin")).getMessage();
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("ECONNRESET", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L24;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("EPIPE", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L24;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Broken pipe", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L24;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Connection reset", CharSequence.class, "com.obric.memorydata.plugin"), true) == true) goto L24;
        if (StringsKt.contains((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Connection aborted", CharSequence.class, "com.obric.memorydata.plugin"), true) == false) goto L25;
    L24:
        return true;
    L25:
        r6 = r6.getCause();
        goto L2
    L8:
        return true;
    L5:
        return true;
    L26:
        return false;
    }

    public static final /* synthetic */ byte[] a(HandshakeProtocol r0, String r1, String r2) {
        return r0.b(r1, r2);
    }

    private final byte[] a(String r2, String r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L13;
        byte[] r5 = Base64.decode(r2, 2);
        Intrinsics.checkNotNullExpressionValue(r5, "decode(...)");
        return r5;
    L13:
        throw new IllegalStateException(r3);
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r4 = false;
        goto L9
    }

    public static final /* synthetic */ byte[] b(HandshakeProtocol r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    private final byte[] b(String r2, String r3) {
        byte[] r1 = a(r2, r3);
        if (r1.length != 32) goto L6;
        return r1;
    L6:
        throw new IllegalStateException(r3 + ", size=" + r1.length);
    }

    public final Object a(Socket r14, String r15, String r16, String r17, Continuation<? super z<byte[]>> r18) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new HandshakeProtocol$asReceiver$$inlined$runHandshake$1("receiver", r14, this, null, r15, this, r16, r17), Function2.class, "com.obric.memorydata.plugin"), r0);
    }

    public final Object b(Socket r14, String r15, String r16, String r17, Continuation<? super z<byte[]>> r18) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r18, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new HandshakeProtocol$asSender$$inlined$runHandshake$1("sender", r14, this, null, this, r16, r15, r17), Function2.class, "com.obric.memorydata.plugin"), r0);
    }
}
