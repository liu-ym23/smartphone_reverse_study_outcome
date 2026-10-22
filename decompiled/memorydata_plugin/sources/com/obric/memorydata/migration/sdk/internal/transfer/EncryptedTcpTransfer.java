package com.obric.memorydata.migration.sdk.internal.transfer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0000\u0018\u0000 J2\u00020\u0001:\u0006EFGHIJB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J.\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0014J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J$\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001a0$2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J&\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0002JY\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020%2)\b\u0004\u0010/\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n01¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002H,00H\u0082H¢\u0006\u0002\u00105J.\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00109\u001a\u00020:H\u0002J\u0018\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020>2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010?\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0002J2\u0010@\u001a\u0002H,\"\u0004\b\u0000\u0010,2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00032\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H,01H\u0082\b¢\u0006\u0002\u0010AJ\f\u0010B\u001a\u00020C*\u00020DH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer;", "", "bufferSize", "", "gson", "Lcom/google/gson/Gson;", "<init>", "(ILcom/google/gson/Gson;)V", "send", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", WsConstants.KEY_CONNECTION, "Lcom/obric/memorydata/migration/sdk/Connection;", "pkg", "Lcom/obric/memorydata/migration/sdk/MigrationPackage;", "callback", "Lcom/obric/memorydata/migration/sdk/MigrationCallback;", "(Lcom/obric/memorydata/migration/sdk/Connection;Lcom/obric/memorydata/migration/sdk/MigrationPackage;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFinalAck", "overallTimeoutMs", "(Lcom/obric/memorydata/migration/sdk/Connection;Lcom/obric/memorydata/migration/sdk/MigrationCallback;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFinalAck", "result", "(Lcom/obric/memorydata/migration/sdk/Connection;Lcom/obric/memorydata/migration/sdk/MigrationResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendRemoteError", "message", "", "(Lcom/obric/memorydata/migration/sdk/Connection;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receive", "outputFile", "Ljava/io/File;", "(Lcom/obric/memorydata/migration/sdk/Connection;Ljava/io/File;Lcom/obric/memorydata/migration/sdk/MigrationCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendHeartbeat", LocationMonitorConst.TAG, "sendHeaderFrame", "awaitHeaderFrame", "Lkotlin/Pair;", "", "input", "Ljava/io/DataInputStream;", "awaitFinalAckV2", "parseFrameType", "json", "withTransferInactivityWatchdog", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.CycleType.S_WAVE_PHASE, "timeoutMs", "block", "Lkotlin/Function1;", "Lkotlin/Function0;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "markProgress", "(Lcom/obric/memorydata/migration/sdk/Connection;Ljava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAck", "expectedPhase", "ackToResult", "ack", "Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$Ack;", "sendAck", "writeFrame", "out", "Ljava/io/DataOutputStream;", "readFrame", "withSocketTimeout", "(Lcom/obric/memorydata/migration/sdk/Connection;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isDisconnectedLikeError", "", "", "Ack", "Heartbeat", "TransferHeader", "RemoteErrorFrame", "RemoteErrorException", "Companion", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EncryptedTcpTransfer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11957b;
    private final Gson c;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$Ack;", "", TypedValues.CycleType.S_WAVE_PHASE, "", "ok", "", "code", "message", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getPhase", "()Ljava/lang/String;", "getOk", "()Z", "getCode", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Ack {

        @SerializedName("code")
        private final String code;

        @SerializedName("message")
        private final String message;

        @SerializedName("ok")
        private final boolean ok;

        @SerializedName(TypedValues.CycleType.S_WAVE_PHASE)
        private final String phase;

        public Ack(String r2, boolean r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, TypedValues.CycleType.S_WAVE_PHASE);
            this.phase = r2;
            this.ok = r3;
            this.code = r4;
            this.message = r5;
        }

        public /* synthetic */ Ack(String r2, boolean r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 4) == 0) goto L6;
            r4 = null;
        L6:
            if ((r6 & 8) == 0) goto L8;
            r5 = null;
        L8:
            this(r2, r3, r4, r5);
        }

        public static /* synthetic */ Ack copy$default(Ack r0, String r1, boolean r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.phase;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.ok;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.code;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.message;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.phase;
        }

        public final boolean component2() {
            return this.ok;
        }

        public final String component3() {
            return this.code;
        }

        public final String component4() {
            return this.message;
        }

        public final Ack copy(String r1, boolean r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r1, TypedValues.CycleType.S_WAVE_PHASE);
            return new Ack(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, Ack.class) == true) goto L8;
            return false;
        L8:
            Ack r6 = (Ack) ZeusTransformUtils.preCheckCast(r5, Ack.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.phase, r6.phase) == true) goto L12;
            return false;
        L12:
            if (this.ok == r6.ok) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.code, r6.code) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.message, r6.message) == true) goto L20;
            return false;
        L20:
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

        public final String getPhase() {
            return this.phase;
        }

        public int hashCode() {
            int r0 = ((this.phase.hashCode() * 31) + Boolean.hashCode(this.ok)) * 31;
            String r1 = this.code;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.message;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Ack(phase=" + this.phase + ", ok=" + this.ok + ", code=" + this.code + ", message=" + this.message + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$Heartbeat;", "", "type", "", LocationMonitorConst.TAG, "tsMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getType", "()Ljava/lang/String;", "getTag", "getTsMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Heartbeat {

        @SerializedName(LocationMonitorConst.TAG)
        private final String tag;

        @SerializedName("tsMs")
        private final long tsMs;

        @SerializedName("type")
        private final String type;

        public Heartbeat(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, LocationMonitorConst.TAG);
            this.type = r2;
            this.tag = r3;
            this.tsMs = r4;
        }

        public /* synthetic */ Heartbeat(String r1, String r2, long r3, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L5;
            r1 = "HB";
        L5:
            this(r1, r2, r3);
        }

        public static /* synthetic */ Heartbeat copy$default(Heartbeat r0, String r1, String r2, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.tag;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.tsMs;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.tag;
        }

        public final long component3() {
            return this.tsMs;
        }

        public final Heartbeat copy(String r1, String r2, long r3) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            return new Heartbeat(r1, r2, r3);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, Heartbeat.class) == true) goto L8;
            return false;
        L8:
            Heartbeat r8 = (Heartbeat) ZeusTransformUtils.preCheckCast(r7, Heartbeat.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.type, r8.type) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.tag, r8.tag) == true) goto L15;
            return false;
        L15:
            if (this.tsMs == r8.tsMs) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getTag() {
            return this.tag;
        }

        public final long getTsMs() {
            return this.tsMs;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + this.tag.hashCode()) * 31) + Long.hashCode(this.tsMs);
        }

        public String toString() {
            return "Heartbeat(type=" + this.type + ", tag=" + this.tag + ", tsMs=" + this.tsMs + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$RemoteErrorException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "<init>", "(Ljava/lang/String;)V", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class RemoteErrorException extends RuntimeException {
        public RemoteErrorException(String r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$RemoteErrorFrame;", "", "type", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class RemoteErrorFrame {

        @SerializedName("message")
        private final String message;

        @SerializedName("type")
        private final String type;

        public RemoteErrorFrame(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "message");
            this.type = r2;
            this.message = r3;
        }

        public /* synthetic */ RemoteErrorFrame(String r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = CipherConst.LEVEL_ERROR;
        L5:
            this(r1, r2);
        }

        public static /* synthetic */ RemoteErrorFrame copy$default(RemoteErrorFrame r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.message;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.message;
        }

        public final RemoteErrorFrame copy(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r2, "message");
            return new RemoteErrorFrame(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, RemoteErrorFrame.class) == true) goto L8;
            return false;
        L8:
            RemoteErrorFrame r6 = (RemoteErrorFrame) ZeusTransformUtils.preCheckCast(r5, RemoteErrorFrame.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.message, r6.message) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.type.hashCode() * 31) + this.message.hashCode();
        }

        public String toString() {
            return "RemoteErrorFrame(type=" + this.type + ", message=" + this.message + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$TransferHeader;", "", "type", "", "totalBytes", "", "checksumSha256", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTotalBytes", "()J", "getChecksumSha256", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class TransferHeader {

        @SerializedName("checksumSha256")
        private final String checksumSha256;

        @SerializedName("totalBytes")
        private final long totalBytes;

        @SerializedName("type")
        private final String type;

        public TransferHeader(String r2, long r3, String r5) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r5, "checksumSha256");
            this.type = r2;
            this.totalBytes = r3;
            this.checksumSha256 = r5;
        }

        public /* synthetic */ TransferHeader(String r1, long r2, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L5;
            r1 = "HEADER";
        L5:
            this(r1, r2, r4);
        }

        public static /* synthetic */ TransferHeader copy$default(TransferHeader r0, String r1, long r2, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.type;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.totalBytes;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.checksumSha256;
        L12:
            return r0.copy(r1, r2, r4);
        }

        public final String component1() {
            return this.type;
        }

        public final long component2() {
            return this.totalBytes;
        }

        public final String component3() {
            return this.checksumSha256;
        }

        public final TransferHeader copy(String r1, long r2, String r4) {
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r4, "checksumSha256");
            return new TransferHeader(r1, r2, r4);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, TransferHeader.class) == true) goto L8;
            return false;
        L8:
            TransferHeader r10 = (TransferHeader) ZeusTransformUtils.preCheckCast(r9, TransferHeader.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.type, r10.type) == true) goto L12;
            return false;
        L12:
            if (this.totalBytes == r10.totalBytes) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.checksumSha256, r10.checksumSha256) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getChecksumSha256() {
            return this.checksumSha256;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + Long.hashCode(this.totalBytes)) * 31) + this.checksumSha256.hashCode();
        }

        public String toString() {
            return "TransferHeader(type=" + this.type + ", totalBytes=" + this.totalBytes + ", checksumSha256=" + this.checksumSha256 + ')';
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/transfer/EncryptedTcpTransfer$Companion;", "", "<init>", "()V", "ACK_PHASE_READY", "", "ACK_PHASE_FINAL", "FRAME_TYPE_HEARTBEAT", "FRAME_TYPE_HEADER", "FRAME_TYPE_ERROR", "HEARTBEAT_INTERVAL_MS", "", "CONTROL_CHANNEL_INACTIVITY_TIMEOUT_MS", "FINAL_ACK_READ_TIMEOUT_MS_V2", "", "FINAL_ACK_OVERALL_TIMEOUT_MS_V2", "READY_ACK_TIMEOUT_MS", "TRANSFER_INACTIVITY_TIMEOUT_MS", "TRANSFER_WATCHDOG_CHECK_INTERVAL_MS", "MAX_FRAME_SIZE", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11956a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EncryptedTcpTransfer() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public EncryptedTcpTransfer(int r2, Gson r3) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        this.f11957b = r2;
        this.c = r3;
    }

    public /* synthetic */ EncryptedTcpTransfer(int r1, Gson r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 8192;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new Gson();
    L8:
        this(r1, r2);
    }

    public static final /* synthetic */ int a(EncryptedTcpTransfer r0) {
        return r0.f11957b;
    }

    private final z<Unit> a(e r11, m r12, int r13) {
        m r14 = (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L27
        EncryptedTcpTransfer r2 = (EncryptedTcpTransfer) ZeusTransformUtils.preCheckCast(this, EncryptedTcpTransfer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        DataInputStream r3 = new DataInputStream(r11.b());     // Catch: Throwable -> L27
        long r4 = System.nanoTime() + (((long) r13) * TimeUtils.NANOSECONDS_PER_MILLISECOND);     // Catch: Throwable -> L27
    L4:
        int r15 = (int) ((r4 - System.nanoTime()) / TimeUtils.NANOSECONDS_PER_MILLISECOND);     // Catch: Throwable -> L27
        if (r15 <= 0) goto L26;
        int r16 = Math.min(7000, r15);     // Catch: Throwable -> L27
        Socket r7 = null;
        if (ZeusTransformUtils.instanceOf(r11, e.a.class) == false) goto L9;
        e.a r6 = (e.a) ZeusTransformUtils.preCheckCast(r11, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
    L10:
        if (r6 == null) goto L12;
        r7 = r6.e();     // Catch: Throwable -> L27
    L12:
        if (r7 != null) goto L14;
        String r17 = r2.a(r3);     // Catch: Throwable -> L27
    L18:
        if (Intrinsics.areEqual(r2.a(r17), "HB") == true) goto L4;
        Ack r18 = (Ack) ZeusTransformUtils.preCheckCast(r2.c.fromJson(r17, Ack.class), Ack.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (Intrinsics.areEqual(r18.getPhase(), "FINAL") == false) goto L4;
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L27
        Object r19 = Result.m1421constructorimpl(r2.a(r18));     // Catch: Throwable -> L27
    L29:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L46;
        t.f11981a.a("tcp: await final ack(v2) failed", r110);
        MigrationErrorCode r111 = MigrationErrorCode.DISCONNECTED;
        if (ZeusTransformUtils.instanceOf(r110, SocketTimeoutException.class) == false) goto L38;
        if (Intrinsics.areEqual(r110.getMessage(), "overall timeout") == false) goto L38;
        String r10 = "等待对端恢复超时";
    L45:
        r19 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r111, r10, r110)), z.class, "com.obric.memorydata.plugin");
    L38:
        if (ZeusTransformUtils.instanceOf(r110, SocketTimeoutException.class) == false) goto L41;
        r10 = "等待对端响应超时";
        goto L45
    L41:
        if (a(r110) == false) goto L43;
        StringBuilder r112 = new StringBuilder();
        String r0 = "连接断开: ";
    L44:
        r10 = r112.append(r0).append(r110.getMessage()).toString();
        goto L45
    L43:
        r112 = new StringBuilder();
        r0 = "等待对端响应失败: ";
    L46:
        z<Unit> r113 = (z) ZeusTransformUtils.preCheckCast(r19, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r113, z.a.class) == false) goto L49;
        r14.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, ((z.a) ZeusTransformUtils.preCheckCast(r113, z.a.class, "com.obric.memorydata.plugin")).a()), p.class, "com.obric.memorydata.plugin"));
    L49:
        return r113;
    L14:
        int r8 = r7.getSoTimeout();     // Catch: Throwable -> L27
        r7.setSoTimeout(r16);     // Catch: Throwable -> L27
        r17 = r2.a(r3);     // Catch: Throwable -> L22
        r7.setSoTimeout(r8);     // Catch: Throwable -> L27
        goto L18
    L22:
        th = move-exception;
        r7.setSoTimeout(r8);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L9:
        r6 = null;
        goto L10
    L26:
        throw new SocketTimeoutException("overall timeout");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    }

    private final z<Unit> a(e r5, String r6, int r7, m r8) {
        m r9 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        EncryptedTcpTransfer r1 = (EncryptedTcpTransfer) ZeusTransformUtils.preCheckCast(this, EncryptedTcpTransfer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        Socket r3 = null;
        if (ZeusTransformUtils.instanceOf(r5, e.a.class) == false) goto L6;
        e.a r2 = (e.a) ZeusTransformUtils.preCheckCast(r5, e.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L7:
        if (r2 == null) goto L9;
        r3 = r2.e();     // Catch: Throwable -> L22
    L9:
        if (r3 != null) goto L11;
        String r10 = r1.a(new DataInputStream(r5.b()));     // Catch: Throwable -> L22
    L14:
        Ack r11 = (Ack) ZeusTransformUtils.preCheckCast(r1.c.fromJson(r10, Ack.class), Ack.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r11.getPhase(), r6) == false) goto L18;
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L22
        Object r12 = Result.m1421constructorimpl(r1.a(r11));     // Catch: Throwable -> L22
    L24:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L36;
        t.f11981a.a("tcp: await ack failed, phase=" + r6, r13);
        MigrationErrorCode r14 = MigrationErrorCode.DISCONNECTED;
        if (ZeusTransformUtils.instanceOf(r13, SocketTimeoutException.class) == false) goto L31;
        String r4 = "等待对端响应超时";
    L35:
        r12 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(r14, r4, r13)), z.class, "com.obric.memorydata.plugin");
        goto L36
    L31:
        if (a(r13) == false) goto L33;
        StringBuilder r15 = new StringBuilder();
        String r16 = "连接断开: ";
    L34:
        r4 = r15.append(r16).append(r13.getMessage()).toString();
        goto L35
    L33:
        r15 = new StringBuilder();
        r16 = "等待对端响应失败: ";
    L36:
        z<Unit> r17 = (z) ZeusTransformUtils.preCheckCast(r12, z.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, z.a.class) == false) goto L39;
        r9.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, ((z.a) ZeusTransformUtils.preCheckCast(r17, z.a.class, "com.obric.memorydata.plugin")).a()), p.class, "com.obric.memorydata.plugin"));
    L39:
        return r17;
    L18:
        throw new IllegalStateException(("unexpected ack phase=" + r11.getPhase() + ", expected=" + r6).toString());     // Catch: Throwable -> L22
    L11:
        int r18 = r3.getSoTimeout();     // Catch: Throwable -> L22
        r3.setSoTimeout(r7);     // Catch: Throwable -> L22
        r10 = r1.a(new DataInputStream(r5.b()));     // Catch: Throwable -> L19
        r3.setSoTimeout(r18);     // Catch: Throwable -> L22
        goto L14
    L19:
        th = move-exception;
        r3.setSoTimeout(r18);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L6:
        r2 = null;
    L22:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L24
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
        r11 = MigrationErrorCode.OTHER;
    L17:
        MigrationErrorCode r2 = r11;
        String r12 = r9.getMessage();
        if (r12 != null) goto L20;
        r12 = "对端失败";
    L20:
        r8 = new z.a(new o(r2, r12, null, 4, null));
        goto L6
    L13:
        r1 = null;
        goto L14
    }

    public static final /* synthetic */ z a(EncryptedTcpTransfer r2, e r3, m r4, int r5) {
        return r2.a(r3, (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin"), r5);
    }

    public static final /* synthetic */ z a(EncryptedTcpTransfer r2, e r3, String r4, int r5, m r6) {
        return r2.a(r3, r4, r5, (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin"));
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

    private final String a(String r5) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl((JsonObject) ZeusTransformUtils.preCheckCast(((EncryptedTcpTransfer) ZeusTransformUtils.preCheckCast(this, EncryptedTcpTransfer.class, "com.obric.memorydata.plugin")).c.fromJson(r5, JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
    L7:
        Object r3 = null;
        if (Result.m1427isFailureimpl(r6) == false) goto L10;
        r6 = null;
    L10:
        JsonObject r7 = (JsonObject) ZeusTransformUtils.preCheckCast(r6, JsonObject.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
        return null;
    L13:
        JsonElement r8 = r7.get("type");
        if (r8 != null) goto L28;
        return null;
    L28:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        EncryptedTcpTransfer r9 = (EncryptedTcpTransfer) ZeusTransformUtils.preCheckCast(this, EncryptedTcpTransfer.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        Object r10 = Result.m1421constructorimpl(r8.getAsString());     // Catch: Throwable -> L18
    L21:
        if (Result.m1427isFailureimpl(r10) == true) goto L25;
        r3 = r10;
    L25:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final Pair<Long, String> a(e r7, DataInputStream r8) {
    L2:
        Object r2 = null;
        if (ZeusTransformUtils.instanceOf(r7, e.a.class) == false) goto L5;
        e.a r1 = (e.a) ZeusTransformUtils.preCheckCast(r7, e.a.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        Socket r3 = r1.e();
    L9:
        if (r3 != null) goto L11;
        String r0 = a(r8);
    L14:
        String r4 = a(r0);
        if (r4 == null) goto L2;
        int r5 = r4.hashCode();
        if (r5 != 2298) goto L19;
        r4.equals("HB");
        goto L2
    L19:
        if (r5 != 66247144) goto L21;
        if (r4.equals(CipherConst.LEVEL_ERROR) == false) goto L2;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L33
        Object r6 = Result.m1421constructorimpl((RemoteErrorFrame) ZeusTransformUtils.preCheckCast(((EncryptedTcpTransfer) ZeusTransformUtils.preCheckCast(this, EncryptedTcpTransfer.class, "com.obric.memorydata.plugin")).c.fromJson(r0, RemoteErrorFrame.class), RemoteErrorFrame.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L33
    L36:
        if (Result.m1427isFailureimpl(r6) == true) goto L39;
        r2 = r6;
    L39:
        RemoteErrorFrame r10 = (RemoteErrorFrame) ZeusTransformUtils.preCheckCast(r2, RemoteErrorFrame.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L43;
        String r11 = r10.getMessage();
        if (r11 == null) goto L43;
    L45:
        throw new RemoteErrorException(r11);
    L43:
        r11 = "对端失败";
    L33:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L36
    L21:
        if (r5 != 2127025805) goto L2;
        if (r4.equals("HEADER") == false) goto L2;
        TransferHeader r13 = (TransferHeader) ZeusTransformUtils.preCheckCast(this.c.fromJson(r0, TransferHeader.class), TransferHeader.class, "com.obric.memorydata.plugin");
        t.f11981a.a("tcp: recv header, bytes=" + r13.getTotalBytes());
        return TuplesKt.to(Long.valueOf(r13.getTotalBytes()), r13.getChecksumSha256());
    L11:
        int r14 = r3.getSoTimeout();
        r3.setSoTimeout(7000);
        r0 = a(r8);     // Catch: Throwable -> L47
        r3.setSoTimeout(r14);
    L47:
        th = move-exception;
        r3.setSoTimeout(r14);
        throw th;
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ Pair a(EncryptedTcpTransfer r0, e r1, DataInputStream r2) {
        return r0.a(r1, r2);
    }

    private final void a(e r2, Ack r3) {
        String r4 = this.c.toJson(r3);
        DataOutputStream r0 = new DataOutputStream(r2.a());
        Intrinsics.checkNotNull(r4);
        a(r0, r4);
    }

    private final void a(e r9, w r10) {
        String r1 = null;
        TransferHeader r7 = new TransferHeader(r1, r10.b(), r10.c(), 1, null);
        DataOutputStream r11 = new DataOutputStream(r9.a());
        String r12 = this.c.toJson(r7);
        Intrinsics.checkNotNullExpressionValue(r12, "toJson(...)");
        a(r11, r12);
    }

    public static final /* synthetic */ void a(EncryptedTcpTransfer r0, e r1, Ack r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(EncryptedTcpTransfer r0, e r1, w r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(EncryptedTcpTransfer r0, DataOutputStream r1, String r2) {
        r0.a(r1, r2);
    }

    private final void a(DataOutputStream r1, String r2) {
        byte[] r0 = r2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r0, "getBytes(...)");
        r1.writeInt(r0.length);
        r1.write(r0);
        r1.flush();
    }

    private final boolean a(Throwable r2) {
    L2:
        if (r2 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r2, EOFException.class) == true) goto L5;
        if (ZeusTransformUtils.instanceOf(r2, SocketException.class) == true) goto L8;
        r2 = r2.getCause();
        goto L2
    L8:
        return true;
    L5:
        return true;
    L10:
        return false;
    }

    public static final /* synthetic */ Gson b(EncryptedTcpTransfer r0) {
        return r0.c;
    }

    public final Object a(e r9, w r10, m r11, Continuation<? super z<Unit>> r12) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$send$2(r10, r9, this, r6, null), Function2.class, "com.obric.memorydata.plugin"), r13);
    }

    public final Object a(e r9, File r10, m r11, Continuation<? super z<w>> r12) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$receive$2(r10, r9, this, r6, null), Function2.class, "com.obric.memorydata.plugin"), r13);
    }

    public final Object a(e r5, String r6, Continuation<? super z<Unit>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$sendRemoteError$2(r6, this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    public final Object b(e r5, String r6, Continuation<? super z<Unit>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$sendHeartbeat$2(r6, this, r5, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }
}
