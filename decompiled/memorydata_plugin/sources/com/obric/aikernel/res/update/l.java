package com.obric.aikernel.res.update;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.google.gson.Gson;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 -2\u00020\u0001:\u0002-.B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010J(\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0018J \u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0018J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0018J\b\u0010#\u001a\u00020\u0007H\u0002J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010%\u001a\u00020\u0007H\u0002J\u0016\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010,\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder;", "", "rootDir", "Ljava/io/File;", "listener", "Lkotlin/Function1;", "Lcom/obric/aikernel/res/update/ModelDownloadResult;", "", "clock", "Lcom/obric/aikernel/res/update/ModelDownloadClock;", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;Lcom/obric/aikernel/res/update/ModelDownloadClock;)V", "gson", "Lcom/google/gson/Gson;", "stateFile", "states", "", "", "Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder$ModelDownloadState;", "activeStart", "key", "activeStop", "buildResultLocked", "state", "status", "", "failureReason", "now", "", "closeActiveLocked", "failure", InfoRequestQPSOptTraceLogger.REASON, "invalidateOwner", "ownerType", "ownerName", "invalidatePendingModels", "loadStates", "pause", "saveStatesLocked", "startModel", "identity", "Lcom/obric/aikernel/res/update/ModelDownloadIdentity;", "foreground", "", "stopActiveLocked", "success", "Companion", "ModelDownloadState", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<j, Unit> f6137b;
    private final h c;
    private final File d;
    private final Gson e;
    private final Map<String, b> f;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder$Companion;", "", "()V", "FAILURE_REASON_DOWNLOAD_TASK_CLEARED", "", "FAILURE_REASON_DOWNLOAD_TASK_FAILED", "FAILURE_REASON_NONE", "FAILURE_REASON_PENDING_PACKAGE_CLEANED", "FAILURE_REASON_UNKNOWN_INVALIDATION", "FAILURE_REASON_UPDATE_DOWNLOADS_CLEANED", "FOREGROUND_FALSE", "FOREGROUND_TRUE", "STATE_FILE_NAME", "", "STATUS_FAILED", "STATUS_SUCCESS", "TAG", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b2\b\u0082\b\u0018\u0000 B2\u00020\u0001:\u0001BB{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000eHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\u008f\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001J\u0006\u0010<\u001a\u00020\u0003J\u0006\u0010=\u001a\u00020\u0003J\u0013\u0010>\u001a\u00020\f2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0011HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019¨\u0006C"}, d2 = {"Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder$ModelDownloadState;", "", "ownerType", "", "ownerName", "ownerVersion", "ownerDepVersion", "modelName", "modelVersion", "bizName", Params.LORA_TYPE, "foreground", "", "startTimestamp", "", "downloadDuration", "activeCount", "", "activeStartTimestamp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJIJ)V", "getActiveCount", "()I", "setActiveCount", "(I)V", "getActiveStartTimestamp", "()J", "setActiveStartTimestamp", "(J)V", "getBizName", "()Ljava/lang/String;", "getDownloadDuration", "setDownloadDuration", "getForeground", "()Z", "setForeground", "(Z)V", "key", "getKey", "getLoraType", "getModelName", "getModelVersion", "getOwnerDepVersion", "getOwnerName", "getOwnerType", "getOwnerVersion", "getStartTimestamp", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "effectiveBizName", "effectiveLoraType", "equals", "other", "hashCode", "toString", "Companion", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6138a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6139b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private final String h;
        private final String i;
        private boolean j;
        private final long k;
        private long l;
        private int m;
        private long n;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder$ModelDownloadState$Companion;", "", "()V", "from", "Lcom/obric/aikernel/res/update/ModelDownloadTelemetryRecorder$ModelDownloadState;", "identity", "Lcom/obric/aikernel/res/update/ModelDownloadIdentity;", "foreground", "", "startTimestamp", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final b a(i r21, boolean r22, long r23) {
                Intrinsics.checkNotNullParameter(r21, "identity");
                String r1 = r21.a();
                String r2 = r21.b();
                String r3 = r21.c();
                String r4 = r21.d();
                String r7 = r21.e();
                String r8 = r21.f();
                return new b(r1, r2, r3, r4, r21.g(), r21.h(), r7, r8, r22, r23, 0, 0, 0, 7168, null);
            }
        }

        static {
            f6138a = new a(null);
        }

        public b(String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, boolean r17, long r18, long r20, int r22, long r23) {
            Intrinsics.checkNotNullParameter(r9, "ownerType");
            Intrinsics.checkNotNullParameter(r10, "ownerName");
            Intrinsics.checkNotNullParameter(r11, "ownerVersion");
            Intrinsics.checkNotNullParameter(r12, "ownerDepVersion");
            Intrinsics.checkNotNullParameter(r13, "modelName");
            Intrinsics.checkNotNullParameter(r14, "modelVersion");
            this.f6139b = r9;
            this.c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.h = r15;
            this.i = r16;
            this.j = r17;
            this.k = r18;
            this.l = r20;
            this.m = r22;
            this.n = r23;
        }

        public /* synthetic */ b(String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, boolean r29, long r30, long r32, int r34, long r35, int r37, DefaultConstructorMarker r38) {
            if ((r37 & 64) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r37 & 128) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r37 & 1024) == 0) goto L13;
            long r15 = 0;
        L15:
            if ((r37 & 2048) == 0) goto L17;
            int r17 = 0;
        L19:
            if ((r37 & 4096) == 0) goto L21;
            long r18 = 0;
        L22:
            this(r21, r22, r23, r24, r25, r26, r10, r11, r29, r30, r15, r17, r18);
            return;
        L21:
            r18 = r35;
            goto L22
        L17:
            r17 = r34;
            goto L19
        L13:
            r15 = r32;
            goto L15
        L9:
            r11 = r28;
            goto L11
        L5:
            r10 = r27;
            goto L7
        }

        public final String a() {
            return this.f6139b;
        }

        public final void a(int r1) {
            this.m = r1;
        }

        public final void a(long r1) {
            this.l = r1;
        }

        public final void a(boolean r1) {
            this.j = r1;
        }

        public final String b() {
            return this.c;
        }

        public final void b(long r1) {
            this.n = r1;
        }

        public final String c() {
            return this.f;
        }

        public final String d() {
            return this.g;
        }

        public final boolean e() {
            return this.j;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f6139b, r10.f6139b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L33;
            return false;
        L33:
            if (this.j == r10.j) goto L36;
            return false;
        L36:
            if (this.k == r10.k) goto L39;
            return false;
        L39:
            if (this.l == r10.l) goto L42;
            return false;
        L42:
            if (this.m == r10.m) goto L45;
            return false;
        L45:
            if (this.n == r10.n) goto L47;
            return false;
        L47:
            return true;
        }

        public final long f() {
            return this.k;
        }

        public final long g() {
            return this.l;
        }

        public final int h() {
            return this.m;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v25 */
        public int hashCode() {
            int r0 = ((((((((((this.f6139b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            String r1 = this.h;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.i;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            int r6 = (r4 + r2) * 31;
            boolean r7 = this.j;
            ?? r8 = r7;
            if (r7 == false) goto L14;
            r8 = 1;
        L14:
            return ((((((((r6 + r8) * 31) + Long.hashCode(this.k)) * 31) + Long.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Long.hashCode(this.n);
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final long i() {
            return this.n;
        }

        public final String j() {
            return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{this.f6139b, this.c, this.d, this.e, this.f, this.g}), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\u001f", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        }

        public final String k() {
            String r0 = this.h;
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
            if (r1.length() != 0) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L12;
            r1 = this.c;
        L12:
            return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        L8:
            r2 = false;
            goto L9
        }

        public final String l() {
            String r0 = this.i;
            String r1 = "";
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
            if (r2.length() != 0) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L15;
            if (Intrinsics.areEqual(this.f6139b, "lora") == false) goto L13;
            r1 = this.c;
        L13:
            r2 = r1;
        L15:
            return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        L8:
            r3 = false;
            goto L9
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ModelDownloadState(ownerType=").append(this.f6139b).append(", ownerName=").append(this.c).append(", ownerVersion=").append(this.d).append(", ownerDepVersion=").append(this.e).append(", modelName=").append(this.f).append(", modelVersion=").append(this.g).append(", bizName=").append(this.h).append(", loraType=").append(this.i).append(", foreground=").append(this.j).append(", startTimestamp=").append(this.k).append(", downloadDuration=").append(this.l).append(", activeCount=");
            r0.append(this.m).append(", activeStartTimestamp=").append(this.n).append(')');
            return r0.toString();
        }
    }

    static {
        f6136a = new a(null);
    }

    public l(File r3, Function1<? super j, Unit> r4, h r5) {
        Function1<j, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "rootDir");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Intrinsics.checkNotNullParameter(r7, "clock");
        this.f6137b = r6;
        this.c = r7;
        this.d = new File(r3, "model_download_telemetry.json");
        this.e = new Gson();
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        a();
    }

    public /* synthetic */ l(File r2, Function1 r3, h r4, int r5, DefaultConstructorMarker r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        h r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r8 = (h) ZeusTransformUtils.preCheckCast(p.f6146a, h.class, "com.obric.memorydata.plugin");
    L5:
        this(r2, r7, r8);
    }

    private final j a(b r21, int r22, int r23, long r24) {
        b(r21, r24);
        long r2 = Math.max(0, r24 - r21.f());
        long r12 = RangesKt.coerceIn(r21.g(), 0, r2);
        String r7 = r21.c();
        String r17 = r21.d();
        String r18 = r21.k();
        String r19 = r21.l();
        return new j(r7, r22, r23, r2, r12, r2 - r12, r21.e() ? 1 : 0, r17, r18, r19);
    }

    private final void a() {
        if (this.d.exists() == true) goto L37;
        return;
    L37:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        l r3 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Object r4 = (Object[]) ZeusTransformUtils.preCheckCast(r3.e.fromJson(FilesKt.readText$default(r3.d, null, 1, null), b[].class), Object[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r4 != null) goto L9;
        r4 = new b[0];     // Catch: Throwable -> L20
    L9:
        b[] r5 = (b[]) ZeusTransformUtils.preCheckCast(r4, b[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        monitor-enter(r3);     // Catch: Throwable -> L20
        r3.f.clear();     // Catch: Throwable -> L17
        int r6 = r5.length;     // Catch: Throwable -> L17
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L14;
        b r8 = r5[r7];     // Catch: Throwable -> L17
        r8.a(0);     // Catch: Throwable -> L17
        r8.b(0);     // Catch: Throwable -> L17
        r3.f.put(r8.j(), r8);     // Catch: Throwable -> L17
        r7 = r7 + 1;     // Catch: Throwable -> L17
        goto L12
    L14:
        r3.b();     // Catch: Throwable -> L17
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r3);     // Catch: Throwable -> L20
        Object r10 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L39;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L26
        Object r0 = Result.m1421constructorimpl(Boolean.valueOf(((l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin")).d.delete()));     // Catch: Throwable -> L26
    L29:
        if (Result.m1427isFailureimpl(r0) == false) goto L31;
        r0 = false;
    L31:
        com.obric.aikernel.runtime.utils.d.f6216a.f("ModelDownloadTelemetry", "load model download telemetry failed " + this.d.getPath() + ", deleted=" + ((Boolean) ZeusTransformUtils.preCheckCast(r0, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() + ": " + r11);
        return;
    L26:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L39:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    private final void a(b r7, long r8) {
        if (r7.h() > 0) goto L6;
        r7.a(0);
        r7.b(0);
        return;
    L6:
        r7.a(r7.h() - 1);
        if (r7.h() != 0) goto L10;
        r7.a(r7.g() + Math.max(0, r8 - r7.i()));
        r7.b(0);
        return;
    }

    private final void b() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        l r1 = (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r1.f.isEmpty() == false) goto L5;
        Object r2 = Boolean.valueOf(r1.d.delete());     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.m1421constructorimpl(r2);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r3);
        if (r4 == null) goto L16;
        com.obric.aikernel.runtime.utils.d.f6216a.f("ModelDownloadTelemetry", "save model download telemetry failed " + this.d.getPath() + ": " + r4);
        return;
    L16:
        return;
    L5:
        com.obric.aikernel.res.utils.a r5 = com.obric.aikernel.res.utils.a.f6155a;     // Catch: Throwable -> L8
        File r6 = r1.d;     // Catch: Throwable -> L8
        String r7 = r1.e.toJson(r1.f.values());     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r7, "gson.toJson(states.values)");     // Catch: Throwable -> L8
        r5.b(r6, r7);     // Catch: Throwable -> L8
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void b(b r8, long r9) {
        if (r8.h() > 0) goto L6;
    L4:
        r8.a(0);
        r8.b(0);
        return;
    L6:
        r8.a(r8.g() + Math.max(0, r9 - r8.i()));
        goto L4
    }

    public final void a(int r11) {
        monitor-enter(this);
        long r7 = this.c.a();     // Catch: Throwable -> L16
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f.values(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L16
    L5:
        if (r1.hasNext() == false) goto L7;
        r9.add(a((b) ZeusTransformUtils.preCheckCast(r1.next(), b.class, "com.obric.memorydata.plugin"), 0, r11, r7));     // Catch: Throwable -> L16
        goto L5
    L7:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.f.clear();     // Catch: Throwable -> L16
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        b();     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Function1<j, Unit> r10 = this.f6137b;
        Iterator r14 = r13.iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        r10.invoke((j) r14.next());
        goto L13
    L15:
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final void a(i r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "identity");
        monitor-enter(this);
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r6.i()), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r0 != null) goto L8;
        this.f.put(r6.i(), b.f6138a.a(r6, r7, this.c.a()));     // Catch: Throwable -> L17
    L14:
        b();     // Catch: Throwable -> L17
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L8:
        if (r0.e() == true) goto L12;
        if (r7 == true) goto L12;
        boolean r9 = false;
    L13:
        r0.a(r9);     // Catch: Throwable -> L17
    L12:
        r9 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        monitor-enter(this);
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r4), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r5 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r0 = this.c.a();     // Catch: Throwable -> L14
        if (r5.h() != 0) goto L11;
        r5.b(r0);     // Catch: Throwable -> L14
    L11:
        r5.a(r5.h() + 1);     // Catch: Throwable -> L14
        b();     // Catch: Throwable -> L14
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void a(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        monitor-enter(this);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f.remove(r7), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        j r9 = a(r1, 0, r8, this.c.a());     // Catch: Throwable -> L13
        b();     // Catch: Throwable -> L13
        monitor-exit(this);
        this.f6137b.invoke(r9);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(String r11, String r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "ownerName");
        monitor-enter(this);
        long r7 = this.c.a();     // Catch: Throwable -> L29
        Map<String, b> r0 = this.f;     // Catch: Throwable -> L29
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, b>> r2 = r0.entrySet().iterator();     // Catch: Throwable -> L29
    L5:
        boolean r9 = true;
        if (r2.hasNext() == false) goto L16;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.getValue(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (Intrinsics.areEqual(r4.b(), r12) == false) goto L13;
        if (r11 != null) goto L11;
    L14:
        if (r9 == false) goto L5;
        r1.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L29
        goto L5
    L11:
        if (Intrinsics.areEqual(r4.a(), r11) == true) goto L14;
    L13:
        r9 = false;
        goto L14
    L16:
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r14.size()), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Iterator r16 = r14.entrySet().iterator();     // Catch: Throwable -> L29
    L18:
        if (r16.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        b r8 = (b) ZeusTransformUtils.preCheckCast(r5.getValue(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        this.f.remove(r6);     // Catch: Throwable -> L29
        r15.add(a(r8, 0, r13, r7));     // Catch: Throwable -> L29
        goto L18
    L20:
        List r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L23;
        b();     // Catch: Throwable -> L29
    L23:
        monitor-exit(this);
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Function1<j, Unit> r10 = this.f6137b;
        Iterator r19 = r18.iterator();
    L26:
        if (r19.hasNext() == false) goto L28;
        r10.invoke((j) r19.next());
        goto L26
    L28:
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        monitor-enter(this);
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r3), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r4 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        a(r4, this.c.a());     // Catch: Throwable -> L11
        b();     // Catch: Throwable -> L11
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.f.containsKey(r2) == false) goto L7;
        b();     // Catch: Throwable -> L10
    L7:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final void d(String r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        monitor-enter(this);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f.remove(r7), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        monitor-exit(this);
        return;
    L9:
        j r8 = a(r1, 1, 0, this.c.a());     // Catch: Throwable -> L13
        b();     // Catch: Throwable -> L13
        monitor-exit(this);
        this.f6137b.invoke(r8);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
