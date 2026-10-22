package com.obric.aee.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.obric.aee.PythonException;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import org.msgpack.core.MessageBufferPacker;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class EngineBridge {
    public static final EngineBridge INSTANCE = null;
    private static final String TAG = "ExecutionEngine";
    private static final Lazy _config$delegate = null;
    private static final String _opt_pipe = null;
    private static b _param;
    private static final Map<String, KFunction<Unit>> _pipeDispatch = null;
    private static final ConcurrentHashMap<String, c> _serviceInfos = null;
    private static final kotlinx.coroutines.sync.a _serviceLock = null;
    private static final ConcurrentHashMap<String, g> _sessionPool = null;
    private static final ConcurrentHashMap<String, Unit> _sessionWatcher = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f4308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f4309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<String> f4310c;

        public a(boolean r10, long r11, Set<String> r12) {
            Intrinsics.checkNotNullParameter(r12, "whiteList");
            this.f4308a = r10;
            this.f4309b = r11;
            this.f4310c = r12;
        }

        public final boolean a() {
            return this.f4308a;
        }

        public final long b() {
            return this.f4309b;
        }

        public final Set<String> c() {
            return this.f4310c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.f4308a == r11.f4308a) goto L12;
            return false;
        L12:
            if (this.f4309b == r11.f4309b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4310c, r11.f4310c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean r10 = this.f4308a;
            ?? r11 = r10;
            if (r10 == false) goto L6;
            r11 = 1;
        L6:
            return (((r11 * 31) + Long.hashCode(this.f4309b)) * 31) + this.f4310c.hashCode();
        }

        public String toString() {
            return "AutoCloseConfig(enable=" + this.f4308a + ", timeout=" + this.f4309b + ", whiteList=" + this.f4310c + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EngineConfig f4311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f4312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f4313c;

        public b(EngineConfig r10, a r11, PowerManager r12) {
            Intrinsics.checkNotNullParameter(r10, "cfg");
            Intrinsics.checkNotNullParameter(r11, "autoCloseConfig");
            this.f4311a = r10;
            this.f4312b = r11;
            this.f4313c = r12;
        }

        public final a a() {
            return this.f4312b;
        }

        public final EngineConfig b() {
            return this.f4311a;
        }

        public final PowerManager c() {
            return this.f4313c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.f4311a, r11.f4311a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f4312b, r11.f4312b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4313c, r11.f4313c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r10 = ((this.f4311a.hashCode() * 31) + this.f4312b.hashCode()) * 31;
            PowerManager r11 = this.f4313c;
            if (r11 != null) goto L5;
            int r12 = 0;
        L7:
            return r10 + r12;
        L5:
            r12 = r11.hashCode();
            goto L7
        }

        public String toString() {
            return "BridgeInitParam(cfg=" + this.f4311a + ", autoCloseConfig=" + this.f4312b + ", powerMgr=" + this.f4313c + ')';
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y6.b f4314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicLong f4316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final v1 f4317d;

        public c(y6.b r10, int r11, AtomicLong r12, v1 r13) {
            Intrinsics.checkNotNullParameter(r10, "pkg");
            Intrinsics.checkNotNullParameter(r12, "lastVisit");
            Intrinsics.checkNotNullParameter(r13, "daemon");
            this.f4314a = r10;
            this.f4315b = r11;
            this.f4316c = r12;
            this.f4317d = r13;
        }

        public final v1 a() {
            return this.f4317d;
        }

        public final int b() {
            return this.f4315b;
        }

        public final AtomicLong c() {
            return this.f4316c;
        }

        public final y6.b d() {
            return this.f4314a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.f4314a, r11.f4314a) == true) goto L12;
            return false;
        L12:
            if (this.f4315b == r11.f4315b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f4316c, r11.f4316c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f4317d, r11.f4317d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f4314a.hashCode() * 31) + Integer.hashCode(this.f4315b)) * 31) + this.f4316c.hashCode()) * 31) + this.f4317d.hashCode();
        }

        public String toString() {
            return "ServiceInfo(pkg=" + this.f4314a + ", fd=" + this.f4315b + ", lastVisit=" + this.f4316c + ", daemon=" + this.f4317d + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$getAllServices$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {}, l = {311}, m = "getAllServices", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        AnonymousClass1(EngineBridge r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getAllServices(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$getServiceInner$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {456, 225}, m = "getServiceInner", n = {"pkg", WsConstants.KEY_EXTRA, "serviceName", "$this$withLock_u24default$iv", "pkg", WsConstants.KEY_EXTRA, "serviceName", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class C03431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03431(EngineBridge r10, Continuation<? super C03431> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$getServiceInner(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$isServiceAlive$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {}, l = {294}, m = "isServiceAlive", n = {}, s = {})
    static final class C03441 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03441(EngineBridge r10, Continuation<? super C03441> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.isServiceAlive(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$runOptFunc$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0}, l = {451}, m = "runOptFunc", n = {"ret", "sid", "buffer"}, s = {"L$0", "L$1", "L$2"})
    static final class C03451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03451(EngineBridge r10, Continuation<? super C03451> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$runOptFunc(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$runPackage$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {245, 451}, m = "runPackage", n = {"packInfo", "args", NotificationCompat.CATEGORY_EVENT, "context", "sid", WsConstants.KEY_EXTRA, "packStartTime", "packInfo", "args", NotificationCompat.CATEGORY_EVENT, "context", "sid", WsConstants.KEY_EXTRA, "serv", "ret", "packStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0"})
    static final class C03461 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03461(EngineBridge r10, Continuation<? super C03461> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runPackage(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$runPackageSteaming$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {272, 451}, m = "runPackageSteaming", n = {"packInfo", "args", NotificationCompat.CATEGORY_EVENT, "context", "callback", "sid", WsConstants.KEY_EXTRA, "packStartTime", "packInfo", "args", NotificationCompat.CATEGORY_EVENT, "context", "callback", "sid", WsConstants.KEY_EXTRA, "serv", "ret", "packStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0"})
    static final class C03471 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03471(EngineBridge r10, Continuation<? super C03471> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runPackageSteaming(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$stopService$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 1}, l = {456, 302}, m = "stopService", n = {"packInfo", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class C03481 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03481(EngineBridge r10, Continuation<? super C03481> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.stopService(null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aee.impl.EngineBridge$watchPackageLife$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "com.obric.aee.impl.EngineBridge", f = "EngineBridge.kt", i = {0, 0, 0, 0, 0, 0}, l = {414, 433}, m = "watchPackageLife", n = {"this", "packInfo", "lastVisit", "pingTime", "fd", "timeoutDur"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "J$0"})
    static final class C03491 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EngineBridge this$0;

        C03491(EngineBridge r10, Continuation<? super C03491> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return EngineBridge.access$watchPackageLife(this.this$0, null, null, 0, this);
        }
    }

    static {
        EngineBridge r10 = new EngineBridge();
        INSTANCE = r10;
        _sessionPool = new ConcurrentHashMap();
        _sessionWatcher = new ConcurrentHashMap();
        _serviceInfos = new ConcurrentHashMap();
        _serviceLock = MutexKt.b(false, 1, null);
        _config$delegate = LazyKt.lazy(EngineBridge$_config$2.INSTANCE);
        _opt_pipe = "opt_entry";
        _pipeDispatch = MapsKt.mapOf(TuplesKt.to("finish_entry", new EngineBridge$_pipeDispatch$1(r10)));
    }

    private EngineBridge() {
    }

    public static final /* synthetic */ byte[] access$encodeRunPackage(EngineBridge r10, String r11, String r12) {
        return r10.encodeRunPackage(r11, r12);
    }

    public static final /* synthetic */ Object access$getServiceInner(EngineBridge r10, y6.b r11, Bundle r12, Continuation r13) {
        return r10.getServiceInner(r11, r12, r13);
    }

    public static final /* synthetic */ String access$get_opt_pipe$p() {
        return _opt_pipe;
    }

    public static final /* synthetic */ b access$get_param$p() {
        return _param;
    }

    public static final /* synthetic */ ConcurrentHashMap access$get_sessionPool$p() {
        return _sessionPool;
    }

    public static final /* synthetic */ void access$onEntryFinish(EngineBridge r10, byte[] r11) {
        r10.onEntryFinish(r11);
    }

    public static final /* synthetic */ Object access$runOptFunc(EngineBridge r10, Object[] r11, Continuation r12) {
        return r10.runOptFunc(r11, r12);
    }

    public static final /* synthetic */ Object access$watchPackageLife(EngineBridge r10, y6.b r11, AtomicLong r12, int r13, Continuation r14) {
        return r10.watchPackageLife(r11, r12, r13, r14);
    }

    private final boolean checkServiceStop(y6.b r10, AtomicLong r11) {
        b r12 = _param;
        if (r12 == null) goto L16;
        a r13 = r12.a();
        if (r13 != null) goto L8;
        return false;
    L8:
        if (r13.a() == true) goto L10;
        return false;
    L10:
        if (r13.c().contains(r10.c()) == true) goto L20;
        long r14 = SystemClock.elapsedRealtime();
        if ((r11.get() + (r13.b() * ((long) 1000))) >= r14) goto L18;
        return true;
    L18:
        return false;
    L20:
        return false;
    L16:
        return false;
    }

    private final byte[] encodeRunArgs(String r10, Object... r11) {
        MessageBufferPacker r12 = MessagePack.newDefaultBufferPacker();
        r12.packArrayHeader(r11.length + 1);
        r12.packString(r10);
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L26;
        Object r15 = r11[r14];
        if ((r15 instanceof String) == false) goto L8;
        r12.packString((String) r15);
    L25:
        r14 = r14 + 1;
        goto L3
    L8:
        if ((r15 instanceof Integer) == false) goto L11;
        r12.packInt(((Number) r15).intValue());
        goto L25
    L11:
        if ((r15 instanceof Short) == false) goto L14;
        r12.packShort(((Number) r15).shortValue());
        goto L25
    L14:
        if ((r15 instanceof Long) == false) goto L17;
        r12.packLong(((Number) r15).longValue());
        goto L25
    L17:
        if ((r15 instanceof Double) == false) goto L20;
        r12.packDouble(((Number) r15).doubleValue());
        goto L25
    L20:
        if ((r15 instanceof Boolean) == false) goto L23;
        r12.packBoolean(((Boolean) r15).booleanValue());
        goto L25
    L23:
        if ((r15 instanceof Float) == false) goto L25;
        r12.packFloat(((Number) r15).floatValue());
        goto L25
    L26:
        byte[] r16 = r12.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r16, "newDefaultBufferPacker()…}\n        }.toByteArray()");
        return r16;
    }

    private final byte[] encodeRunPackage(String r10, String r11) {
        MessageBufferPacker r12 = MessagePack.newDefaultBufferPacker();
        r12.packArrayHeader(2);
        r12.packString(r10);
        r12.packString(r11);
        byte[] r13 = r12.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r13, "newDefaultBufferPacker()…)\n        }.toByteArray()");
        return r13;
    }

    private final long getCheckDur() {
        b r10 = _param;
        boolean r11 = true;
        if (r10 == null) goto L9;
        PowerManager r12 = r10.c();
        if (r12 == null) goto L9;
        if (r12.isPowerSaveMode() != true) goto L9;
    L10:
        if (r11 == false) goto L12;
        return VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER;
    L12:
        return 5000;
    L9:
        r11 = false;
        goto L10
    }

    private final a getLowMemConfig(Map<String, String> r13) {
        String r12 = StringsKt.trim(r13.getOrDefault("autoclose_mode", "")).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        switch(r12.hashCode()) {
            case -1609594047: goto L21;
            case -1298848381: goto L18;
            case 49: goto L15;
            case 3551: goto L12;
            case 119527: goto L9;
            case 3569038: goto L6;
            default: goto L50;
        };
    L50:
        boolean r14 = false;
    L25:
        Long r10 = StringsKt.toLongOrNull(StringsKt.trim(r13.getOrDefault("autoclose_service_timeout", "")).toString());
        if (r10 == null) goto L28;
        long r11 = r10.longValue();
    L29:
        long r15 = RangesKt.coerceAtLeast(r11, 1);
        List r16 = StringsKt.split$default(r13.getOrDefault("autoclose_whitelist", ""), new char[]{',', ';', '\n', '\r', '\t'}, false, 0, 6, null);
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L31:
        if (r18.hasNext() == false) goto L33;
        r17.add(StringsKt.trim((String) r18.next()).toString());
        goto L31
    L33:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r17.iterator();
    L35:
        if (r20.hasNext() == false) goto L43;
        Object r21 = r20.next();
        if (((String) r21).length() <= 0) goto L39;
        boolean r22 = true;
    L40:
        if (r22 == false) goto L35;
        r19.add(r21);
        goto L35
    L39:
        r22 = false;
        goto L40
    L43:
        return new a(r14, r15, CollectionsKt.toSet(r19));
    L28:
        r11 = 300;
        goto L29
    L6:
        if (r12.equals("true") == false) goto L51;
    L23:
        r14 = true;
        goto L25
    L51:
        r14 = false;
        goto L25
    L9:
        if (r12.equals("yes") == true) goto L23;
        r14 = false;
        goto L25
    L12:
        if (r12.equals("on") == true) goto L23;
        r14 = false;
        goto L25
    L15:
        if (r12.equals(NetConst.ENCRYPT_VERISON_CODE) == true) goto L23;
        r14 = false;
        goto L25
    L18:
        if (r12.equals("enable") == true) goto L23;
        r14 = false;
        goto L25
    L21:
        if (r12.equals("enabled") == true) goto L23;
        r14 = false;
        goto L25
    }

    private final String getPackageInfo(String r10) {
        c r11 = _serviceInfos.get(r10);
        if (r11 != null) goto L6;
        return "{}";
    L6:
        String r12 = new com.google.gson.d().t(r11.d());
        Intrinsics.checkNotNullExpressionValue(r12, "Gson().toJson(info.pkg)");
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [y6.b] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.Object, kotlinx.coroutines.sync.a, y6.b] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.gson.d] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v6 */
    private final Object getServiceInner(y6.b r13, Bundle r14, Continuation<? super c> r15) {
        if ((r15 instanceof C03431) == false) goto L7;
        C03431 r10 = (C03431) r15;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L20;
        if (r17 == 1) goto L19;
        if (r17 != 2) goto L18;
        kotlinx.coroutines.sync.a r18 = (kotlinx.coroutines.sync.a) r10.L$3;
        String r19 = (String) r10.L$2;
        Bundle r110 = (Bundle) r10.L$1;
        y6.b r20 = (y6.b) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
        ?? r21 = r20;
    L36:
        int r111 = ((Bundle) r12).getInt(IdlKeys.Result, -1);     // Catch: Throwable -> L15
        if (r111 <= 0) goto L42;
        AtomicLong r22 = new AtomicLong(SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        c r23 = new c(r21, r111, r22, h.d(m0.a(z0.b()), null, null, new EngineBridge$getServiceInner$2$ret$1(r21, r22, r111, null), 3, null));     // Catch: Throwable -> L15
        _serviceInfos.put(r19, r23);     // Catch: Throwable -> L15
        r110.putLong(ApiPerfDetails.onLoadServiceEnd, SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        r18.c(null);
        return r23;
    L42:
        throw new Exception("init service failed.");     // Catch: Throwable -> L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r18 = (kotlinx.coroutines.sync.a) r10.L$3;
        String r112 = (String) r10.L$2;
        Bundle r24 = (Bundle) r10.L$1;
        y6.b r25 = (y6.b) r10.L$0;
        ResultKt.throwOnFailure(r12);
        String r113 = r112;
        r14 = r24;
        ?? r26 = r25;
    L27:
        r14.putBoolean(ApiPerfDetails.FLAG_NEW_SERVICE, true);     // Catch: Throwable -> L15
        r14.putBoolean("track_is_new_service", true);     // Catch: Throwable -> L15
        r14.putLong(ApiPerfDetails.onLoadServiceStart, SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        c r27 = _serviceInfos.get(r113);     // Catch: Throwable -> L15
        if (r27 == null) goto L32;
        r14.putLong(ApiPerfDetails.onLoadServiceEnd, SystemClock.elapsedRealtime());     // Catch: Throwable -> L15
        r18.c(null);
        return r27;
    L32:
        EngineBridge r28 = INSTANCE;     // Catch: Throwable -> L15
        String r29 = new com.google.gson.d().t(r26);     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r29, "Gson().toJson(pkg)");     // Catch: Throwable -> L15
        r10.L$0 = r26;     // Catch: Throwable -> L15
        r10.L$1 = r14;     // Catch: Throwable -> L15
        r10.L$2 = r113;     // Catch: Throwable -> L15
        r10.L$3 = r18;     // Catch: Throwable -> L15
        r10.label = 2;     // Catch: Throwable -> L15
        Object r30 = r28.runOptFunc(new Object[]{"init_service", r113, r29}, r10);     // Catch: Throwable -> L15
        if (r30 != r16) goto L35;
        return r16;
    L35:
        r110 = r14;
        r19 = r113;
        r12 = r30;
        r21 = r26;
        goto L36
    L20:
        ResultKt.throwOnFailure(r12);
        r113 = r13.g();
        c r31 = _serviceInfos.get(r113);
        if (r31 == null) goto L23;
        return r31;
    L23:
        kotlinx.coroutines.sync.a r32 = _serviceLock;
        r10.L$0 = r13;
        r10.L$1 = r14;
        r10.L$2 = r113;
        r10.L$3 = r32;
        r10.label = 1;
        if (r32.b(null, r10) != r16) goto L26;
        return r16;
    L26:
        r26 = r13;
        r18 = r32;
    L15:
        th = move-exception;
        r13.c(null);
        throw th;
    L7:
        r10 = new C03431(this, r15);
        goto L8
    }

    private final Bundle getSessionArgs(String r10) {
        g r11 = _sessionPool.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.a();
    }

    private final Bundle getSessionContext(String r10) {
        g r11 = _sessionPool.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.c();
    }

    private final SafeBundle getSessionExtra(String r10) {
        g r11 = _sessionPool.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.d();
    }

    private final Bundle getSessionRet(String r10) {
        g r11 = _sessionPool.get(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.e();
    }

    private final EngineConfig get_config() {
        return (EngineConfig) _config$delegate.getValue();
    }

    private final void onEntryFinish(byte[] r11) {
        MessageUnpacker r10 = MessagePack.newDefaultUnpacker(r11);
        int r12 = r10.unpackArrayHeader();
        String r13 = r10.unpackString();
        if (r13 == null) goto L47;
        int r14 = r13.hashCode();
        if (r14 == (-1922171997)) goto L32;
        if (r14 == (-1274442605)) goto L16;
        if (r14 != 3446776) goto L47;
        if (r13.equals("pong") == false) goto L47;
        Unit r15 = _sessionWatcher.remove(r10.unpackString());
        return;
    L16:
        if (r13.equals("finish") == false) goto L47;
        String r16 = r10.unpackString();
        INSTANCE.hostLogD(TAG, "onAeeEntryFinish sid = " + r16);
        g r17 = _sessionPool.remove(r16);
        if (r17 == null) goto L50;
        long r18 = SystemClock.elapsedRealtime();
        c r19 = r17.f();
        if (r19 == null) goto L25;
        AtomicLong r110 = r19.c();
        if (r110 == null) goto L25;
        r110.set(r18);
    L25:
        SafeBundle r111 = r17.d();
        if (r111 == null) goto L30;
        Bundle r112 = r111.detach();
        if (r112 == null) goto L30;
        r112.putLong(ApiPerfDetails.onVmPyStart, r17.g());
        r112.putLong(ApiPerfDetails.onVmPyEnd, r18);
    L30:
        Continuation<Unit> r113 = r17.b();
        Result.Companion r114 = Result.Companion;
        r113.resumeWith(Result.m32constructorimpl(Unit.INSTANCE));
        return;
    L50:
        return;
    L32:
        if (r13.equals("finish_exception") == false) goto L47;
        String r115 = r10.unpackString();
        String r20 = r10.unpackString();
        int r21 = r10.unpackInt();
        String r22 = r10.unpackString();
        String r116 = r10.unpackString();
        INSTANCE.hostLogD(TAG, "onAeeEntryFinishException sid = " + r115 + ", except: " + r22);
        g r117 = _sessionPool.remove(r115);
        if (r117 == null) goto L52;
        long r23 = SystemClock.elapsedRealtime();
        c r24 = r117.f();
        if (r24 == null) goto L41;
        AtomicLong r25 = r24.c();
        if (r25 == null) goto L41;
        r25.set(r23);
    L41:
        SafeBundle r26 = r117.d();
        if (r26 == null) goto L46;
        Bundle r27 = r26.detach();
        if (r27 == null) goto L46;
        r27.putLong(ApiPerfDetails.onVmPyStart, r117.g());
        r27.putLong(ApiPerfDetails.onVmPyEnd, r23);
    L46:
        Continuation<Unit> r118 = r117.b();
        Result.Companion r28 = Result.Companion;
        Intrinsics.checkNotNullExpressionValue(r20, "exceptType");
        Intrinsics.checkNotNullExpressionValue(r22, "exceptContent");
        Intrinsics.checkNotNullExpressionValue(r116, "trace");
        r118.resumeWith(Result.m32constructorimpl(ResultKt.createFailure(new PythonException(r20, r21, r22, r116))));
        return;
    L52:
        return;
    L47:
        EngineBridge r119 = INSTANCE;
        StringBuilder r29 = new StringBuilder();
        r29.append("unsupported finish event : ");
        r29.append(r13);
        r29.append(", len(args) = ");
        r29.append(r12 - 1);
        r119.hostLogE(TAG, r29.toString());
    }

    private final void onGlobalEvent(String r10, Bundle r11) {
        get_config().onGlobalEvent(r10, r11);
    }

    private final void onSessionStreamingResult(String r10, Bundle r11) {
        g r12 = _sessionPool.get(r10);
        if (r12 == null) goto L8;
        Function1<Bundle, Unit> r13 = r12.h();
        if (r13 == null) goto L9;
        r13.invoke(r11);
        return;
    L9:
        return;
    }

    private final Object runOptFunc(Object[] r22, Continuation<? super Bundle> r23) {
        if ((r23 instanceof C03451) == false) goto L7;
        C03451 r10 = (C03451) r23;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        byte[] r15 = (byte[]) r10.L$2;
        String r16 = (String) r10.L$1;
        Bundle r17 = (Bundle) r10.L$0;
        ResultKt.throwOnFailure(r12);
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        Bundle r18 = new Bundle();
        final String r19 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r19, "randomUUID().toString()");
        byte[] r20 = encodeRunArgs(r19, Arrays.copyOf(r22, r22.length));
        r10.L$0 = r18;
        r10.L$1 = r19;
        r10.L$2 = r20;
        r10.label = 1;
        o r21 = new o(IntrinsicsKt.intercepted(r10), 1);
        r21.F();
        access$get_sessionPool$p().put(r19, new g(null, new Bundle(), r18, new Bundle(), null, null, SystemClock.elapsedRealtime(), null, r21));
        HostExtension.INSTANCE.g(access$get_opt_pipe$p(), r20);     // Catch: Exception -> L23
        r21.h(new EngineBridge$runOptFunc$2$1(r19));
        Object r24 = r21.B();
        if (r24 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L19:
        if (r24 != r13) goto L22;
        return r13;
    L22:
        return r18;
    L23:
        e = move-exception;
        access$get_sessionPool$p().remove(r19);
        throw e;
    L7:
        r10 = new C03451(this, r23);
        goto L8
    }

    private final void setThreadName(String r10) {
        Thread.currentThread().setName(r10);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0085 -> B:21:0x008b). Please report as a decompilation issue!!! */
    private final Object watchPackageLife(y6.b r22, AtomicLong r23, int r24, Continuation<? super Unit> r25) {
        if ((r25 instanceof C03491) == false) goto L7;
        C03491 r10 = (C03491) r25;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
        EngineBridge r12 = this;
    L8:
        Object r13 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r10.label;
        int r16 = 1;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r17 = r10.J$0;
        int r18 = r10.I$0;
        Pair r19 = (Pair) r10.L$3;
        AtomicLong r110 = (AtomicLong) r10.L$2;
        y6.b r111 = (y6.b) r10.L$1;
        EngineBridge r112 = (EngineBridge) r10.L$0;
        ResultKt.throwOnFailure(r13);
        y6.b r20 = r111;
        C03491 r21 = r10;
        Object r26 = r14;
        AtomicLong r27 = r110;
        int r28 = r18;
        long r113 = r17;
        r12 = r112;
    L22:
        if (r19 == null) goto L32;
        if (_sessionWatcher.get(r19.getFirst()) == null) goto L32;
        long r29 = SystemClock.elapsedRealtime() - ((Number) r19.getSecond()).longValue();
        if (r29 <= r113) goto L28;
        r12.get_config().logE(TAG, "[STUCK_TRACING] watchPackageLife timeout !!!, package=" + r20.i());
        EngineConfig r30 = r12.get_config();
        Bundle r31 = new Bundle();
        r31.putString("package", r20.i());
        Unit r32 = Unit.INSTANCE;
        r30.onGlobalEvent("ServiceNotResponse", r31);
        r19 = null;
    L30:
        r16 = 1;
        Object r114 = r26;
        Pair r33 = r19;
        C03491 r34 = r21;
        Object r35 = r114;
    L17:
        long r115 = r12.getCheckDur();
        r34.L$0 = r12;
        r34.L$1 = r20;
        r34.L$2 = r27;
        r34.L$3 = r33;
        r34.I$0 = r28;
        r34.J$0 = r113;
        r34.label = r16;
        if (DelayKt.b(r115, r34) != r35) goto L20;
        return r35;
    L20:
        Object r116 = r35;
        r21 = r34;
        r19 = r33;
        r26 = r116;
        goto L22
    L28:
        r12.get_config().logW(TAG, "[STUCK_TRACING] Service[" + r20.i() + "] hasn't response for " + r29 + "ms");
    L32:
        if (r12.checkServiceStop(r20, r27) == false) goto L38;
        r12.hostLogI(TAG, "Service[" + r20.g() + "] should be stopped, cause autoclose is enabled, lastUse before " + (SystemClock.elapsedRealtime() - r27.get()) + "ms");
        r21.L$0 = null;
        r21.L$1 = null;
        r21.L$2 = null;
        r21.L$3 = null;
        r21.label = 2;
        if (r12.stopService(r20, r21) != r26) goto L37;
        return r26;
    L38:
        r19 = null;
        String r36 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r36, "randomUUID().toString()");
        Pair r37 = new Pair(r36, Boxing.boxLong(SystemClock.elapsedRealtime()));
        _sessionWatcher.put((String) r37.getFirst(), Unit.INSTANCE);
        HostExtension.INSTANCE.h(r28, r12.encodeRunPackage((String) r37.getFirst(), "_PING"));     // Catch: Exception -> L41
        r34 = r21;
        r35 = r26;
        r33 = r37;
        r16 = 1;
    L41:
        _sessionWatcher.remove(r37.getFirst());
        r12.hostLogD(TAG, "[STUCK_TRACING] Service[" + r20.i() + "]: send checker failed, maybe stuck.");
        goto L30
    L16:
        ResultKt.throwOnFailure(r13);
        r20 = r22;
        r34 = r10;
        r113 = 30000;
        r33 = null;
        r27 = r23;
        r35 = r14;
        r28 = r24;
    L7:
        r12 = this;
        r10 = new C03491(r12, r25);
        goto L8
    }

    public final int[] getAeeVersion() {
        List r10 = StringsKt.split$default((String) StringsKt.split$default("0.2.7.15", new String[]{"-"}, false, 0, 6, null).get(0), new String[]{"."}, false, 0, 6, null);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        r11.add(Integer.valueOf(Integer.parseInt((String) r12.next())));
        goto L4
    L7:
        return CollectionsKt.toIntArray(r11);
    }

    public final Object getAllServices(Continuation<? super List<y6.b>> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r11 = (AnonymousClass1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        Set<String> r16 = ((Bundle) r13).keySet();
        Intrinsics.checkNotNullExpressionValue(r16, "runOptFunc(\"get_all_services\").keySet()");
        ArrayList r17 = new ArrayList();
        Iterator<T> r18 = r16.iterator();
    L19:
        if (r18.hasNext() == false) goto L23;
        c r19 = _serviceInfos.get((String) r18.next());
        if (r19 == null) goto L19;
        r17.add(r19);
        goto L19
    L23:
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r21 = r17.iterator();
    L25:
        if (r21.hasNext() == false) goto L27;
        r20.add(((c) r21.next()).d());
        goto L25
    L27:
        return r20;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.label = 1;
        r13 = runOptFunc(new Object[]{"get_all_services"}, r11);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r11 = new AnonymousClass1(this, r10);
        goto L8
    }

    public final Context getAndroidContext() {
        return get_config().getContext();
    }

    public final void handlePipeData(String r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "data");
        KFunction<Unit> r12 = _pipeDispatch.get(r10);
        if (r12 == null) goto L6;
        ((Function1) r12).invoke(r11);
        return;
    }

    public final void hostLogD(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "content");
        get_config().logD(r10, r11);
    }

    public final void hostLogE(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "content");
        get_config().logE(r10, r11);
    }

    public final void hostLogI(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "content");
        get_config().logI(r10, r11);
    }

    public final void hostLogV(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "content");
        get_config().logV(r10, r11);
    }

    public final void hostLogW(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "content");
        get_config().logW(r10, r11);
    }

    public final void initCfg(EngineConfig r11) {
        Intrinsics.checkNotNullParameter(r11, "cfg");
        Map<String, String> r10 = r11.getGlobalConfig();
        Object r12 = r11.getContext().getSystemService("power");
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.os.PowerManager");
        a r13 = getLowMemConfig(r10);
        _param = new b(r11, r13, (PowerManager) r12);
        Iterator<Map.Entry<String, KFunction<Unit>>> r14 = _pipeDispatch.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        String r15 = r14.next().getKey();
        HostExtension.INSTANCE.c(r15);
        goto L4
    L6:
        StringBuilder r16 = new StringBuilder();
        r16.append("lowMemCfg: ");
        b r17 = _param;
        Intrinsics.checkNotNull(r17);
        r16.append(r17.a().a());
        r16.append(", ");
        b r18 = _param;
        Intrinsics.checkNotNull(r18);
        r16.append(r18.a().b());
        r16.append(", \"");
        b r19 = _param;
        Intrinsics.checkNotNull(r19);
        r16.append(CollectionsKt.joinToString$default(r19.a().c(), "|", null, null, 0, null, null, 62, null));
        r16.append(Typography.quote);
        hostLogI(TAG, r16.toString());
    }

    public final Object isServiceAlive(y6.b r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof C03441) == false) goto L7;
        C03441 r12 = (C03441) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L22:
        return Boxing.boxBoolean(((Bundle) r14).getBoolean(IdlKeys.Result, false));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        c r17 = _serviceInfos.get(r10.g());
        if (r17 == null) goto L17;
        Object[] r18 = {"is_service_alive", r17.d().g()};
        r12.label = 1;
        r14 = runOptFunc(r18, r12);
        if (r14 != r15) goto L22;
        return r15;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r12 = new C03441(this, r11);
        goto L8
    }

    public final Object requestPythonGc(Continuation<? super Unit> r10) {
        Object r11 = runOptFunc(new Object[]{"request_manual_gc"}, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public final Object runPackage(y6.b r25, Bundle r26, String r27, Bundle r28, Continuation<? super Bundle> r29) {
        y6.b r10 = r25;
        if ((r29 instanceof C03461) == false) goto L7;
        C03461 r11 = (C03461) r29;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        long r16 = r11.J$0;
        Bundle r17 = (Bundle) r11.L$7;
        c r18 = (c) r11.L$6;
        Bundle r19 = (Bundle) r11.L$5;
        String r20 = (String) r11.L$4;
        Bundle r21 = (Bundle) r11.L$3;
        String r22 = (String) r11.L$2;
        Bundle r23 = (Bundle) r11.L$1;
        y6.b r24 = (y6.b) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L35:
        r19.putLong(ApiPerfDetails.onVmRun, r16);
        r19.putLong(ApiPerfDetails.onVmEnd, SystemClock.elapsedRealtime());
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r30 = r11.J$0;
        Bundle r31 = (Bundle) r11.L$5;
        String r32 = (String) r11.L$4;
        Bundle r33 = (Bundle) r11.L$3;
        String r110 = (String) r11.L$2;
        Bundle r111 = (Bundle) r11.L$1;
        y6.b r112 = (y6.b) r11.L$0;
        ResultKt.throwOnFailure(r13);
        Bundle r113 = r33;
        Bundle r114 = r111;
        final String r34 = r32;
        Bundle r35 = r31;
        Object r36 = r13;
        long r37 = r30;
        r10 = r112;
    L20:
        final c r38 = (c) r36;
        Bundle r115 = new Bundle();
        r11.L$0 = r10;
        r11.L$1 = r114;
        r11.L$2 = r110;
        r11.L$3 = r113;
        r11.L$4 = r34;
        r11.L$5 = r35;
        r11.L$6 = r38;
        r11.L$7 = r115;
        r11.J$0 = r37;
        r11.label = 2;
        o r39 = new o(IntrinsicsKt.intercepted(r11), 1);
        r39.F();
        ConcurrentHashMap r40 = access$get_sessionPool$p();
        Intrinsics.checkNotNullExpressionValue(r34, "sid");
        long r210 = r37;
        y6.b r116 = r10;
        r40.put(r34, new g(r38, r114, r115, r113, new SafeBundle(r35), r116, SystemClock.elapsedRealtime(), null, r39));
        if (HostExtension.INSTANCE.h(r38.b(), access$encodeRunPackage(INSTANCE, r34, z6.a.f13800a.c(r110))) >= 0) goto L29;
        g r41 = (g) access$get_sessionPool$p().remove(r34);
        if (r41 == null) goto L28;
        SafeBundle r42 = r41.d();
        if (r42 == null) goto L28;
        r42.detach();
    L28:
        throw new RuntimeException("service has been stopped.");
    L29:
        r39.h(new EngineBridge$runPackage$2$1(r34, r38));
        Object r43 = r39.B();
        if (r43 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L32:
        if (r43 != r14) goto L34;
        return r14;
    L34:
        r16 = r210;
        r17 = r115;
        r19 = r35;
        goto L35
    L16:
        ResultKt.throwOnFailure(r13);
        String r44 = r28.getString("_session", UUID.randomUUID().toString());
        long r45 = SystemClock.elapsedRealtime();
        Bundle r46 = new Bundle();
        r28.putBundle(WsConstants.KEY_EXTRA, r46);
        r11.L$0 = r10;
        r11.L$1 = r26;
        r11.L$2 = r27;
        r11.L$3 = r28;
        r11.L$4 = r44;
        r11.L$5 = r46;
        r11.J$0 = r45;
        r11.label = 1;
        r36 = getServiceInner(r10, r46, r11);
        if (r36 != r14) goto L19;
        return r14;
    L19:
        r113 = r28;
        r114 = r26;
        r35 = r46;
        r37 = r45;
        r110 = r27;
        r34 = r44;
    L7:
        r11 = new C03461(this, r29);
        goto L8
    }

    public final Object runPackageSteaming(y6.b r26, Bundle r27, String r28, Bundle r29, Function2<? super Bundle, ? super Boolean, Unit> r30, Continuation<? super Unit> r31) {
        y6.b r10 = r26;
        if ((r31 instanceof C03471) == false) goto L7;
        C03471 r11 = (C03471) r31;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        long r16 = r11.J$0;
        Bundle r17 = (Bundle) r11.L$8;
        c r18 = (c) r11.L$7;
        Bundle r19 = (Bundle) r11.L$6;
        String r20 = (String) r11.L$5;
        Function2<? super Bundle, ? super Boolean, Unit> r21 = (Function2) r11.L$4;
        Bundle r22 = (Bundle) r11.L$3;
        String r23 = (String) r11.L$2;
        Bundle r24 = (Bundle) r11.L$1;
        y6.b r25 = (y6.b) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L35:
        r19.putLong(ApiPerfDetails.onVmRun, r16);
        r19.putLong(ApiPerfDetails.onVmEnd, SystemClock.elapsedRealtime());
        r21.invoke(r17, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r32 = r11.J$0;
        Bundle r33 = (Bundle) r11.L$6;
        String r34 = (String) r11.L$5;
        final Function2<? super Bundle, ? super Boolean, Unit> r35 = (Function2) r11.L$4;
        Bundle r110 = (Bundle) r11.L$3;
        String r111 = (String) r11.L$2;
        Bundle r112 = (Bundle) r11.L$1;
        y6.b r113 = (y6.b) r11.L$0;
        ResultKt.throwOnFailure(r13);
        String r114 = r34;
        Bundle r115 = r110;
        Bundle r116 = r33;
        Object r36 = r13;
        long r37 = r32;
        String r38 = r111;
        r10 = r113;
        Bundle r117 = r112;
    L20:
        final c r39 = (c) r36;
        Bundle r118 = new Bundle();
        r11.L$0 = r10;
        r11.L$1 = r117;
        r11.L$2 = r38;
        r11.L$3 = r115;
        r11.L$4 = r35;
        r11.L$5 = r114;
        r11.L$6 = r116;
        r11.L$7 = r39;
        r11.L$8 = r118;
        r11.J$0 = r37;
        r11.label = 2;
        o r40 = new o(IntrinsicsKt.intercepted(r11), 1);
        r40.F();
        ConcurrentHashMap r119 = access$get_sessionPool$p();
        Intrinsics.checkNotNullExpressionValue(r114, "sid");
        long r210 = r37;
        Function2<? super Bundle, ? super Boolean, Unit> r211 = r35;
        Bundle r120 = r115;
        Bundle r212 = r116;
        final String r121 = r114;
        y6.b r122 = r10;
        r119.put(r121, new g(r39, r117, r118, r120, new SafeBundle(r116), r122, SystemClock.elapsedRealtime(), new EngineBridge$runPackageSteaming$2$1(r35), r40));
        r40.h(new EngineBridge$runPackageSteaming$2$2(r39, r121));
        if (HostExtension.INSTANCE.h(r39.b(), access$encodeRunPackage(INSTANCE, r121, z6.a.f13800a.c(r38))) >= 0) goto L29;
        g r41 = (g) access$get_sessionPool$p().remove(r121);
        if (r41 == null) goto L28;
        SafeBundle r42 = r41.d();
        if (r42 == null) goto L28;
        r42.detach();
    L28:
        throw new RuntimeException("service has been stopped.");
    L29:
        Object r43 = r40.B();
        if (r43 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L32:
        if (r43 != r14) goto L34;
        return r14;
    L34:
        r16 = r210;
        r21 = r211;
        r19 = r212;
        r17 = r118;
        goto L35
    L16:
        ResultKt.throwOnFailure(r13);
        String r44 = r29.getString("_session", UUID.randomUUID().toString());
        long r45 = SystemClock.elapsedRealtime();
        Bundle r46 = new Bundle();
        r29.putBundle(WsConstants.KEY_EXTRA, r46);
        r29.putBoolean(IdlKeys.Args_StreamingCall, true);
        r11.L$0 = r10;
        r11.L$1 = r27;
        r11.L$2 = r28;
        r11.L$3 = r29;
        r11.L$4 = r30;
        r11.L$5 = r44;
        r11.L$6 = r46;
        r11.J$0 = r45;
        r11.label = 1;
        Object r47 = getServiceInner(r10, r46, r11);
        if (r47 != r14) goto L19;
        return r14;
    L19:
        r115 = r29;
        r114 = r44;
        r36 = r47;
        r38 = r28;
        r116 = r46;
        r37 = r45;
        r35 = r30;
        r117 = r27;
    L7:
        r11 = new C03471(this, r31);
        goto L8
    }

    public final Object stopService(y6.b r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C03481) == false) goto L7;
        C03481 r12 = (C03481) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L20;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        kotlinx.coroutines.sync.a r17 = (kotlinx.coroutines.sync.a) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L32:
        Bundle r18 = (Bundle) r14;     // Catch: Throwable -> L15
        r17.c(null);
        return Unit.INSTANCE;
    L15:
        Throwable th = th;
    L37:
        r17.c(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) r12.L$1;
        y6.b r20 = (y6.b) r12.L$0;
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.sync.a r21 = r19;
        r10 = r20;
    L41:
        c r110 = _serviceInfos.remove(r10.g());     // Catch: Throwable -> L35
        if (r110 != null) goto L28;
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r21.c(null);
        return r111;
    L28:
        v1.a.a(r110.a(), null, 1, null);     // Catch: Throwable -> L35
        EngineBridge r22 = INSTANCE;     // Catch: Throwable -> L35
        Object[] r23 = {"stop_service", r110.d().g()};     // Catch: Throwable -> L35
        r12.L$0 = r21;     // Catch: Throwable -> L35
        r12.L$1 = null;     // Catch: Throwable -> L35
        r12.label = 2;     // Catch: Throwable -> L35
        Object r112 = r22.runOptFunc(r23, r12);     // Catch: Throwable -> L35
        if (r112 != r15) goto L31;
        return r15;
    L31:
        r17 = r21;
        r14 = r112;
    L35:
        th = move-exception;
        r17 = r21;
        th = th;
        goto L37
    L20:
        ResultKt.throwOnFailure(r14);
        r21 = _serviceLock;
        r12.L$0 = r10;
        r12.L$1 = r21;
        r12.label = 1;
        if (r21.b(null, r12) != r15) goto L41;
        return r15;
    L7:
        r12 = new C03481(this, r11);
        goto L8
    }
}
