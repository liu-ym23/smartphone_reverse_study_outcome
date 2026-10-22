package com.bytedance.ai.monitor.auth;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import d3.a0;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletAuthTaskMonitor {
    public static final SecureRandom a = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/monitor/auth/AppletAuthTaskMonitor$ErrorCode;", "", "code", "", "errorName", "", "defaultMsg", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getErrorName", "()Ljava/lang/String;", "getDefaultMsg", "UNKNOWN", "CONTEXT_MISSING", "INVALID_STATE", "CONCURRENT_FLOW", "INVALID_PARAM", "TIMEOUT", "API_FAILED", "INVALID_RESPONSE", "USER_CANCELLED", "USER_REFUSED", "UI_RENDER_FAILED", "ROUTE_FAILED", "EMPTY_LOGIN_CODE", "INVALID_LOGIN_CODE", "AUTH_LINK_INVALID", "SYSTEM_PERMISSION_DENIED", "SYSTEM_PERMISSION_RESTRICTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ErrorCode extends Enum<ErrorCode> {
        public static final ErrorCode API_FAILED = null;
        public static final ErrorCode AUTH_LINK_INVALID = null;
        public static final ErrorCode CONCURRENT_FLOW = null;
        public static final ErrorCode CONTEXT_MISSING = null;
        public static final ErrorCode EMPTY_LOGIN_CODE = null;
        public static final ErrorCode INVALID_LOGIN_CODE = null;
        public static final ErrorCode INVALID_PARAM = null;
        public static final ErrorCode INVALID_RESPONSE = null;
        public static final ErrorCode INVALID_STATE = null;
        public static final ErrorCode ROUTE_FAILED = null;
        public static final ErrorCode SYSTEM_PERMISSION_DENIED = null;
        public static final ErrorCode SYSTEM_PERMISSION_RESTRICTED = null;
        public static final ErrorCode TIMEOUT = null;
        public static final ErrorCode UI_RENDER_FAILED = null;
        public static final ErrorCode UNKNOWN = null;
        public static final ErrorCode USER_CANCELLED = null;
        public static final ErrorCode USER_REFUSED = null;
        public static final /* synthetic */ ErrorCode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int code;
        private final String defaultMsg;
        private final String errorName;

        public static EnumEntries<ErrorCode> getEntries() {
            return b;
        }

        static {
            ErrorCode r10 = new ErrorCode("UNKNOWN", 0, IServerListener.WHAT_BYTELINK_SINK_ERROR, "UNKNOWN", "unknown error");
            UNKNOWN = r10;
            ErrorCode r0 = new ErrorCode("CONTEXT_MISSING", 1, IServerListener.WHAT_NSD_ERROR, "CONTEXT_MISSING", "context missing");
            CONTEXT_MISSING = r0;
            ErrorCode r1 = new ErrorCode("INVALID_STATE", 2, 1002, "INVALID_STATE", "invalid state");
            INVALID_STATE = r1;
            ErrorCode r11 = new ErrorCode("CONCURRENT_FLOW", 3, 1003, "CONCURRENT_FLOW", "concurrent auth flow");
            CONCURRENT_FLOW = r11;
            ErrorCode r12 = new ErrorCode("INVALID_PARAM", 4, 1004, "INVALID_PARAM", "invalid parameter");
            INVALID_PARAM = r12;
            ErrorCode r13 = new ErrorCode("TIMEOUT", 5, 1005, "TIMEOUT", "auth task timeout");
            TIMEOUT = r13;
            ErrorCode r14 = new ErrorCode("API_FAILED", 6, 1006, "API_FAILED", "api failed");
            API_FAILED = r14;
            ErrorCode r15 = new ErrorCode("INVALID_RESPONSE", 7, 1007, "INVALID_RESPONSE", "invalid response");
            INVALID_RESPONSE = r15;
            ErrorCode r16 = new ErrorCode("USER_CANCELLED", 8, 1008, "USER_CANCELLED", "user cancelled");
            USER_CANCELLED = r16;
            ErrorCode r17 = new ErrorCode("USER_REFUSED", 9, 1009, "USER_REFUSED", "user refused");
            USER_REFUSED = r17;
            ErrorCode r18 = new ErrorCode("UI_RENDER_FAILED", 10, 1010, "UI_RENDER_FAILED", "ui render failed");
            UI_RENDER_FAILED = r18;
            ErrorCode r19 = new ErrorCode("ROUTE_FAILED", 11, 1011, "ROUTE_FAILED", "route failed");
            ROUTE_FAILED = r19;
            ErrorCode r110 = new ErrorCode("EMPTY_LOGIN_CODE", 12, 1012, "EMPTY_LOGIN_CODE", "login code is empty");
            EMPTY_LOGIN_CODE = r110;
            ErrorCode r111 = new ErrorCode("INVALID_LOGIN_CODE", 13, 1013, "INVALID_LOGIN_CODE", "login code is invalid");
            INVALID_LOGIN_CODE = r111;
            ErrorCode r20 = new ErrorCode("AUTH_LINK_INVALID", 14, 1014, "AUTH_LINK_INVALID", "auth link is invalid");
            AUTH_LINK_INVALID = r20;
            ErrorCode r112 = new ErrorCode("SYSTEM_PERMISSION_DENIED", 15, 1015, "SYSTEM_PERMISSION_DENIED", "system permission denied");
            SYSTEM_PERMISSION_DENIED = r112;
            ErrorCode r113 = new ErrorCode("SYSTEM_PERMISSION_RESTRICTED", 16, 1016, "SYSTEM_PERMISSION_RESTRICTED", "system permission restricted");
            SYSTEM_PERMISSION_RESTRICTED = r113;
            ErrorCode[] r114 = {r10, r0, r1, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r112, r113};
            a = r114;
            b = EnumEntriesKt.enumEntries(r114);
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public final String getDefaultMsg() {
            return this.defaultMsg;
        }

        public final String getErrorName() {
            return this.errorName;
        }

        public static ErrorCode valueOf(String r1) {
            return (ErrorCode) r27.a.a(ErrorCode.class, r1);
        }

        public ErrorCode(String r1, int r10, int r11, String r12, String r13) {
            super(r1, r10);
            this.code = r11;
            this.errorName = r12;
            this.defaultMsg = r13;
        }
    }

    public static final class Session {
        public final b a;
        public final String b;
        public final long c;
        public final AtomicBoolean d;
        public Long e;
        public long f;
        public long g;

        public final void b() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.e != null) goto L6;
            this.e = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L9
        L6:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        public final void c() {
            monitor-enter(this);
            Long r0 = this.e;     // Catch: Throwable -> L10
            if (r0 == null) goto L8;
            this.f += System.currentTimeMillis() - r0.longValue();     // Catch: Throwable -> L10
            this.e = null;     // Catch: Throwable -> L10
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L8:
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public final long e() {
            monitor-enter(this);
            long r0 = RangesKt.coerceAtLeast(this.g, 0);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public final void a(long r10) {
            monitor-enter(this);
            this.g += RangesKt.coerceAtLeast(r10, 0);     // Catch: Throwable -> L6
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final void d(a r10) {
            Intrinsics.checkNotNullParameter(r10, "info");
            if (this.d.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            c();
            SecureRandom r0 = AppletAuthTaskMonitor.a;
            AppletAuthTaskMonitor.f(this, r10, System.currentTimeMillis(), false);
        }

        public final <T> Object f(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
            if ((r11 instanceof AppletAuthTaskMonitor$Session$trackBackend$1) == false) goto L7;
            AppletAuthTaskMonitor$Session$trackBackend$1 r0 = (AppletAuthTaskMonitor$Session$trackBackend$1) r11;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r12 = r0.result;
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r14 = r0.label;
            if (r14 == 0) goto L18;
            if (r14 != 1) goto L17;
            long r15 = r0.J$0;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L14
        L23:
            a(System.currentTimeMillis() - r15);
            return r12;
        L14:
            th = th;
        L27:
            a(System.currentTimeMillis() - r15);
            throw th;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L18:
            ResultKt.throwOnFailure(r12);
            long r16 = System.currentTimeMillis();
            r0.J$0 = r16;     // Catch: Throwable -> L25
            r0.label = 1;     // Catch: Throwable -> L25
            r12 = r10.invoke(r0);     // Catch: Throwable -> L25
            if (r12 != r13) goto L22;
            return r13;
        L22:
            r15 = r16;
        L25:
            th = th;
            r15 = r16;
        L7:
            r0 = new AppletAuthTaskMonitor$Session$trackBackend$1(this, r11);
            goto L8
        }

        public final <T> Object g(Function1<? super Continuation<? super T>, ? extends Object> r10, Continuation<? super T> r11) {
            if ((r11 instanceof AppletAuthTaskMonitor$Session$trackUserWait$1) == false) goto L7;
            AppletAuthTaskMonitor$Session$trackUserWait$1 r0 = (AppletAuthTaskMonitor$Session$trackUserWait$1) r11;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r12 = r0.result;
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r14 = r0.label;
            if (r14 == 0) goto L15;
            if (r14 != 1) goto L14;
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
        L19:
            c();
            return r12;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r12);
            b();
            r0.label = 1;     // Catch: Throwable -> L21
            r12 = r10.invoke(r0);     // Catch: Throwable -> L21
            if (r12 != r13) goto L19;
            return r13;
        L21:
            th = move-exception;
            c();
            throw th;
        L7:
            r0 = new AppletAuthTaskMonitor$Session$trackUserWait$1(this, r11);
            goto L8
        }

        public Session(b r10, String r11, long r12) {
            Intrinsics.checkNotNullParameter(r10, "meta");
            Intrinsics.checkNotNullParameter(r11, "traceId");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = new AtomicBoolean(false);
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final ErrorCode d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r11.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            String r13 = this.c;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            ErrorCode r16 = this.d;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            String r19 = this.e;
            if (r19 != null) goto L17;
            int r20 = 0;
        L18:
            int r21 = (r18 + r20) * 31;
            String r22 = this.f;
            if (r22 != null) goto L21;
            int r23 = 0;
        L22:
            int r24 = (r21 + r23) * 31;
            String r25 = this.g;
            if (r25 != null) goto L25;
            int r26 = 0;
        L26:
            int r27 = (r24 + r26) * 31;
            String r28 = this.h;
            if (r28 != null) goto L29;
            int r29 = 0;
        L30:
            int r30 = (r27 + r29) * 31;
            String r31 = this.i;
            if (r31 == null) goto L35;
            r10 = r31.hashCode();
        L35:
            return r30 + r10;
        L29:
            r29 = r28.hashCode();
            goto L30
        L25:
            r26 = r25.hashCode();
            goto L26
        L21:
            r23 = r22.hashCode();
            goto L22
        L17:
            r20 = r19.hashCode();
            goto L18
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "FinishInfo(result=" + this.a + ", detail=" + this.b + ", stopStage=" + this.c + ", errorCode=" + this.d + ", errorMsg=" + this.e + ", bridgeTraceId=" + this.f + ", appletPermissionStatus=" + this.g + ", systemPermissionStatus=" + this.h + ", finalPermissionStatus=" + this.i + ')';
        }

        public static a a(a r10, String r11) {
            String r1 = r10.a;
            String r12 = r10.c;
            ErrorCode r13 = r10.d;
            String r14 = r10.e;
            String r15 = r10.f;
            String r16 = r10.g;
            String r17 = r10.h;
            String r18 = r10.i;
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_RESULT);
            return new a(r1, r11, r12, r13, r14, r15, r16, r17, r18);
        }

        public /* synthetic */ a(String r14, String r15, String r16, ErrorCode r17, String r18, String r19, String r20, String r21, int r22) {
            if ((r22 & 2) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r22 & 4) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r22 & 8) == 0) goto L13;
            ErrorCode r12 = null;
        L15:
            if ((r22 & 16) == 0) goto L17;
            String r13 = null;
        L19:
            if ((r22 & 64) == 0) goto L21;
            String r110 = null;
        L23:
            if ((r22 & 128) == 0) goto L25;
            String r111 = null;
        L27:
            if ((r22 & 256) == 0) goto L29;
            String r112 = null;
        L30:
            this(r14, r10, r11, r12, r13, null, r110, r111, r112);
            return;
        L29:
            r112 = r21;
            goto L30
        L25:
            r111 = r20;
            goto L27
        L21:
            r110 = r19;
            goto L23
        L17:
            r13 = r18;
            goto L19
        L13:
            r12 = r17;
            goto L15
        L9:
            r11 = r16;
            goto L11
        L5:
            r10 = r15;
            goto L7
        }

        public a(String r10, String r11, String r12, ErrorCode r13, String r14, String r15, String r16, String r17, String r18) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final String l;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r11.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r11.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r11.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r11.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r11.l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            String r1 = this.g;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            String r13 = this.h;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            String r16 = this.i;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            String r19 = this.j;
            if (r19 != null) goto L17;
            int r20 = 0;
        L18:
            int r21 = (r18 + r20) * 31;
            String r22 = this.k;
            if (r22 != null) goto L21;
            int r23 = 0;
        L22:
            int r24 = (r21 + r23) * 31;
            String r25 = this.l;
            if (r25 == null) goto L27;
            r10 = r25.hashCode();
        L27:
            return r24 + r10;
        L21:
            r23 = r22.hashCode();
            goto L22
        L17:
            r20 = r19.hashCode();
            goto L18
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Meta(domain=" + this.a + ", scene=" + this.b + ", subType=" + this.c + ", detail=" + this.d + ", appletId=" + this.e + ", containerType=" + this.f + ", widgetId=" + this.g + ", pageId=" + this.h + ", msgId=" + this.i + ", cardId=" + this.j + ", grantingName=" + this.k + ", permissionKey=" + this.l + ')';
        }

        public b(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r10, "domain");
            Intrinsics.checkNotNullParameter(r11, "scene");
            Intrinsics.checkNotNullParameter(r12, "subType");
            Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB);
            Intrinsics.checkNotNullParameter(r14, "appletId");
            Intrinsics.checkNotNullParameter(r15, "containerType");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
            this.e = r14;
            this.f = r15;
            this.g = r16;
            this.h = r17;
            this.i = r18;
            this.j = r19;
            this.k = r110;
            this.l = r111;
        }

        public /* synthetic */ b(String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29) {
            if ((r29 & 64) == 0) goto L5;
            String r10 = null;
        L7:
            if ((r29 & 128) == 0) goto L9;
            String r11 = null;
        L11:
            if ((r29 & 256) == 0) goto L13;
            String r12 = null;
        L15:
            if ((r29 & 512) == 0) goto L17;
            String r13 = null;
        L19:
            if ((r29 & 1024) == 0) goto L21;
            String r14 = null;
        L23:
            if ((r29 & 2048) == 0) goto L25;
            String r15 = null;
        L26:
            this(r17, r18, r19, r20, r21, r22, r10, r11, r12, r13, r14, r15);
            return;
        L25:
            r15 = r28;
            goto L26
        L21:
            r14 = r27;
            goto L23
        L17:
            r13 = r26;
            goto L19
        L13:
            r12 = r25;
            goto L15
        L9:
            r11 = r24;
            goto L11
        L5:
            r10 = r23;
            goto L7
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements j {
        public final /* synthetic */ Session a;
        public final /* synthetic */ a b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;
        public final /* synthetic */ long f;
        public final /* synthetic */ long g;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            SecureRandom r0 = AppletAuthTaskMonitor.a;
            AppletAuthTaskMonitor.d(r10, this.a, this.b.b);
            r10.f(com.bytedance.android.ec.core.event.a.KEY_RESULT, this.b.a);
            r10.e("start_ts", this.a.c);
            r10.e("result_ts", this.c);
            AppletAuthTaskMonitor.e(r10, "stop_stage", this.b.c);
            a r1 = this.b;
            ErrorCode r11 = r1.d;
            if (r11 == null) goto L8;
            r10.d(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, r11.getCode());
            r10.f("error_name", r11.getErrorName());
            String r12 = r1.e;
            if (r12 != null) goto L7;
            r12 = r11.getDefaultMsg();
        L7:
            r10.f(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r12);
        L8:
            a r13 = this.b;
            if (r13.d != null) goto L11;
            AppletAuthTaskMonitor.e(r10, com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r13.e);
        L11:
            r10.e("total_duration", this.d);
            r10.e("technical_duration", this.e);
            r10.e("backend_duration", this.f);
            r10.e("user_wait_duration", this.g);
            AppletAuthTaskMonitor.e(r10, "bridge_trace_id", this.b.f);
            AppletAuthTaskMonitor.e(r10, "applet_permission_status", this.b.g);
            AppletAuthTaskMonitor.e(r10, "system_permission_status", this.b.h);
            AppletAuthTaskMonitor.e(r10, "final_permission_status", this.b.i);
        }

        public d(Session r1, a r10, long r11, long r12, long r13, long r14, long r15) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
        }
    }

    public AppletAuthTaskMonitor() {
    }

    static {
        a = new SecureRandom();
    }

    public static String a(long r10) {
        byte[] r1 = new byte[16];
        a.nextBytes(r1);
        return "applet_authv1_" + r10 + '_' + ArraysKt.joinToString$default(r1, "", null, null, 0, null, new com.bytedance.ai.monitor.auth.a(), 30, null);
    }

    public static Session g(b r10) {
        Intrinsics.checkNotNullParameter(r10, "meta");
        long r0 = System.currentTimeMillis();
        Session r11 = new Session(r10, a(r0), r0);
        com.bytedance.ai.monitor.b.b("flow_applet_auth_task_start", new com.bytedance.ai.monitor.auth.b(r11));
        return r11;
    }

    public static void d(AppletMonitorableEvent r10, Session r11, String r12) {
        b r0 = r11.a;
        r10.f("trace_id", r11.b);
        r10.f("domain", r0.a);
        r10.f("scene", r0.b);
        r10.f("sub_type", r0.c);
        if (r12 != null) goto L5;
        r12 = r0.d;
    L5:
        r10.f(com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB, r12);
        r10.f("applet_id", r0.e);
        r10.f("container_type", r0.f);
        e(r10, "widget_id", r0.g);
        e(r10, com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r0.h);
        e(r10, "msg_id", r0.i);
        e(r10, "card_id", r0.j);
        e(r10, "granting_name", r0.k);
        e(r10, "permission_key", r0.l);
    }

    public static void e(AppletMonitorableEvent r1, String r10, String r11) {
        if (r11 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        r1.f(r10, r11);
        return;
    L11:
        return;
    L4:
        if (StringsKt.isBlank(r11) == true) goto L7;
        r0 = false;
        goto L8
    }

    public static void f(Session r15, a r16, long r17, boolean r19) {
        if (r19 == false) goto L5;
        long r10 = 0;
    L6:
        if (r19 == false) goto L8;
        long r12 = 0;
    L16:
        if (r19 == false) goto L18;
        long r11 = 0;
    L19:
        com.bytedance.ai.monitor.b.b("flow_applet_auth_task_result", new d(r15, r16, r17, r10, RangesKt.coerceAtLeast(r10 - r12, 0), r11, r12));
        return;
    L18:
        r11 = r15.e();
        goto L19
    L8:
        monitor-enter(r15);
        Long r13 = r15.e;     // Catch: Throwable -> L21
        if (r13 == null) goto L12;
        long r14 = System.currentTimeMillis() - r13.longValue();     // Catch: Throwable -> L21
    L13:
        long r18 = RangesKt.coerceAtLeast(r15.f + r14, 0);     // Catch: Throwable -> L21
        monitor-exit(r15);
        r12 = r18;
        goto L16
    L12:
        r14 = 0;
    L21:
        th = move-exception;
        throw th;
    L5:
        r10 = RangesKt.coerceAtLeast(r17 - r15.c, 0);
        goto L6
    }

    public static /* synthetic */ b c(e3.d r10, String r11, String r12, String r13, String r14) {
        return b(r10, "login", r11, r12, r13, r14, null);
    }

    public static b b(e3.d r17, String r18, String r19, String r20, String r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r18, "domain");
        Intrinsics.checkNotNullParameter(r19, "defaultScene");
        Intrinsics.checkNotNullParameter(r20, "subType");
        Intrinsics.checkNotNullParameter(r21, com.bytedance.android.ec.core.event.a.VALUE_DETAIL_TAB);
        Intrinsics.checkNotNullParameter(r22, "appletId");
        a0 r10 = r17.getContainerContext();
        if (r10 == null) goto L5;
        ContainerType r11 = r10.getContainerType();
    L6:
        if (r11 != null) goto L8;
        int r12 = -1;
    L10:
        if (r12 != 1) goto L12;
        String r13 = "widget_container";
    L16:
        String r14 = r13;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        a0 r15 = r17.getContainerContext();
        if (r15 == null) goto L19;
        ContainerType r16 = r15.getContainerType();
    L21:
        if (r16 != ContainerType.WIDGET) goto L25;
        String r24 = r15.getContainerId();
        if ((!StringsKt.isBlank(r24)) == false) goto L25;
        String r110 = r24;
    L26:
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        a0 r0 = r17.getContainerContext();
        if (r0 == null) goto L29;
        ContainerType r1 = r0.getContainerType();
    L31:
        if (r1 != ContainerType.PAGE) goto L35;
        String r25 = r0.getContainerId();
        if ((!StringsKt.isBlank(r25)) == false) goto L35;
    L37:
        return new b(r18, r19, r20, r21, r22, r14, r110, r25, null, null, null, r23, 1792);
    L35:
        r25 = null;
        goto L37
    L29:
        r1 = null;
    L25:
        r110 = null;
        goto L26
    L19:
        r16 = null;
        goto L21
    L12:
        if (r12 == 2) goto L14;
        r13 = "unknown";
        goto L16
    L14:
        r13 = "page_container";
        goto L16
    L8:
        r12 = c.a[r11.ordinal()];
        goto L10
    L5:
        r11 = null;
        goto L6
    }
}
