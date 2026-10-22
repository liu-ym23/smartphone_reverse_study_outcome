package com.obric.memorydata.memory;

import android.content.ComponentName;
import android.graphics.Bitmap;
import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.dc.PageContextRequest;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0015J\u001d\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aJ.\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010\u001fJ6\u0010 \u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0002J*\u0010(\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J*\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020-H\u0002J(\u00103\u001a\u00020\"2\u0006\u00104\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u00106\u001a\u00020-H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/InAppAutoMemoryCoordinator;", "", "<init>", "()V", "TAG", "", "RECENT_CANCEL_WINDOW_MS", "", "DEEP_CAPTURE_WAIT_MS", "EVENT_DEDUP_WINDOW_MS", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeRecords", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/InAppAutoMemoryCoordinator$ActiveRecord;", "eventDeduplicator", "Lcom/obric/memorydata/memory/InAppFavoriteEventDeduplicator;", "clearEventHistory", "", "clearEventHistory$memory_obricRelease", "stopDisallowedWork", "stopDisallowedWork$memory_obricRelease", "onL1Event", "raw", "spec", "Lcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEvent;", "onL1Event$memory_obricRelease", "createMemory", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "eventTime", "(Ljava/lang/String;Ljava/lang/String;JLcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelMemory", "trackingParams", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$AutoMemoryRuleHitParams;", "(Ljava/lang/String;Ljava/lang/String;JLcom/obric/memorydata/memory/InAppL1LocalRuleCatalog$FavoriteEvent;Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$AutoMemoryRuleHitParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "capturePageContext", "Lcom/obric/memorydata/dc/PageContextHandle;", "component", "Landroid/content/ComponentName;", "findCurrentActive", "ruleFamily", "queryRecent", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "deleteEntity", "", "entityId", InfoRequestQPSOptTraceLogger.REASON, "reportCancellationIfSuccessful", "record", "deleted", "ruleHitParams", "event", "Lorg/json/JSONObject;", "favorite", "ActiveRecord", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f10111b = null;
    private static final ConcurrentHashMap<String, a> c = null;
    private static final f d = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000fHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011HÆ\u0003Ju\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/obric/memorydata/memory/InAppAutoMemoryCoordinator$ActiveRecord;", "", "key", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "ruleFamily", "eventTime", "", "control", "Lcom/obric/memorydata/memory/llm/MemoryBuildControl;", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "deleteStarted", "cancelReportGate", "Lcom/obric/memorydata/memory/AutoMemoryCancellationReportGate;", "cancelTrackingParams", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/obric/memorydata/memory/tracker/MemoryEventTracker$AutoMemoryRuleHitParams;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/obric/memorydata/memory/llm/MemoryBuildControl;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/obric/memorydata/memory/AutoMemoryCancellationReportGate;Ljava/util/concurrent/atomic/AtomicReference;)V", "getKey", "()Ljava/lang/String;", "getPackageName", "getActivityName", "getRuleFamily", "getEventTime", "()J", "getControl", "()Lcom/obric/memorydata/memory/llm/MemoryBuildControl;", "getCancelled", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getDeleteStarted", "getCancelReportGate", "()Lcom/obric/memorydata/memory/AutoMemoryCancellationReportGate;", "getCancelTrackingParams", "()Ljava/util/concurrent/atomic/AtomicReference;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10113b;
        private final String c;
        private final String d;
        private final long e;
        private final com.obric.memorydata.memory.llm.c f;
        private final AtomicBoolean g;
        private final AtomicBoolean h;
        private final com.obric.memorydata.memory.a i;
        private final AtomicReference<MemoryEventTracker.AutoMemoryRuleHitParams> j;

        public a(String r2, String r3, String r4, String r5, long r6, com.obric.memorydata.memory.llm.c r8, AtomicBoolean r9, AtomicBoolean r10, com.obric.memorydata.memory.a r11, AtomicReference<MemoryEventTracker.AutoMemoryRuleHitParams> r12) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r4, "activityName");
            Intrinsics.checkNotNullParameter(r5, "ruleFamily");
            Intrinsics.checkNotNullParameter(r8, "control");
            Intrinsics.checkNotNullParameter(r9, "cancelled");
            Intrinsics.checkNotNullParameter(r10, "deleteStarted");
            Intrinsics.checkNotNullParameter(r11, "cancelReportGate");
            Intrinsics.checkNotNullParameter(r12, "cancelTrackingParams");
            this.f10112a = r2;
            this.f10113b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
        }

        public /* synthetic */ a(String r16, String r17, String r18, String r19, long r20, com.obric.memorydata.memory.llm.c r22, AtomicBoolean r23, AtomicBoolean r24, com.obric.memorydata.memory.a r25, AtomicReference r26, int r27, DefaultConstructorMarker r28) {
            if ((r27 & 64) == 0) goto L5;
            AtomicBoolean r11 = new AtomicBoolean(false);
        L7:
            if ((r27 & 128) == 0) goto L9;
            AtomicBoolean r12 = new AtomicBoolean(false);
        L11:
            if ((r27 & 256) == 0) goto L13;
            com.obric.memorydata.memory.a r13 = new com.obric.memorydata.memory.a();
        L15:
            if ((r27 & 512) == 0) goto L17;
            AtomicReference r14 = new AtomicReference(null);
        L18:
            this(r16, r17, r18, r19, r20, r22, r11, r12, r13, r14);
            return;
        L17:
            r14 = r26;
            goto L18
        L13:
            r13 = r25;
            goto L15
        L9:
            r12 = r24;
            goto L11
        L5:
            r11 = r23;
            goto L7
        }

        public final String a() {
            return this.f10112a;
        }

        public final String b() {
            return this.f10113b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10112a, r10.f10112a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10113b, r10.f10113b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r10.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final com.obric.memorydata.memory.llm.c f() {
            return this.f;
        }

        public final AtomicBoolean g() {
            return this.g;
        }

        public final AtomicBoolean h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((((((this.f10112a.hashCode() * 31) + this.f10113b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode();
        }

        public final com.obric.memorydata.memory.a i() {
            return this.i;
        }

        public final AtomicReference<MemoryEventTracker.AutoMemoryRuleHitParams> j() {
            return this.j;
        }

        public String toString() {
            return "ActiveRecord(key=" + this.f10112a + ", packageName=" + this.f10113b + ", activityName=" + this.c + ", ruleFamily=" + this.d + ", eventTime=" + this.e + ", control=" + this.f + ", cancelled=" + this.g + ", deleteStarted=" + this.h + ", cancelReportGate=" + this.i + ", cancelTrackingParams=" + this.j + ')';
        }
    }

    static {
        f10110a = new d();
        f10111b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new ConcurrentHashMap();
        d = new f(1200);
    }

    private d() {
    }

    private final com.obric.memorydata.dc.a a(ComponentName r4) {
        return com.obric.memorydata.dc.b.f9848a.a(new PageContextRequest(r4, 3000));
    }

    private final a a(String r10, String r11, String r12, long r13) {
        Collection<a> r9 = c.values();
        Intrinsics.checkNotNullExpressionValue(r9, "<get-values>(...)");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L4:
        if (r15.hasNext() == false) goto L22;
        Object r2 = r15.next();
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        if (Intrinsics.areEqual(r3.b(), r10) == true) goto L8;
    L19:
        r5 = false;
    L20:
        if (r5 == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        if (Intrinsics.areEqual(r3.c(), r11) == false) goto L19;
        if (Intrinsics.areEqual(r3.d(), r12) == false) goto L19;
        long r4 = r13 - r3.e();
        if (0 <= r4) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L19;
    L14:
        if (r4 >= 5001) goto L16;
        r6 = true;
        goto L17
    L22:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r16.hasNext() == true) goto L25;
        Object r17 = null;
    L36:
        return (a) ZeusTransformUtils.preCheckCast(r17, a.class, "com.obric.memorydata.plugin");
    L25:
        Object r18 = r16.next();
        if (r16.hasNext() == true) goto L28;
    L27:
        r17 = r18;
        goto L36
    L28:
        long r19 = ((a) ZeusTransformUtils.preCheckCast(r18, a.class, "com.obric.memorydata.plugin")).e();
    L29:
        Object r110 = r16.next();
        long r7 = ((a) ZeusTransformUtils.preCheckCast(r110, a.class, "com.obric.memorydata.plugin")).e();
        if (r19 >= r7) goto L33;
        r18 = r110;
        r19 = r7;
    L33:
        if (r16.hasNext() == true) goto L29;
        goto L27
    }

    private final MemoryEventTracker.AutoMemoryRuleHitParams a(JSONObject r15, String r16, String r17, boolean r18) {
        com.obric.memorydata.utils.c.a r1 = com.obric.memorydata.utils.c.f13193a.b(r16, r17);
        String r3 = r15.optString("ruleId");
        Intrinsics.checkNotNullExpressionValue(r3, "optString(...)");
        String r4 = null;
        if (r1 == null) goto L5;
        String r6 = r1.a();
    L6:
        String r7 = "";
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        if (r1 == null) goto L11;
        r4 = r1.c();
    L11:
        if (r4 == null) goto L14;
        r7 = r4;
    L14:
        String r2 = r15.optString("engineVersion");
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");
        String r8 = r15.optString("templateVersion");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        String r11 = r15.optString("eventType");
        Intrinsics.checkNotNullExpressionValue(r11, "optString(...)");
        if (r18 == false) goto L17;
        String r0 = "create";
    L19:
        return new MemoryEventTracker.AutoMemoryRuleHitParams(r3, r6, r16, r7, r2, r8, "in_app", r17, r11, r0);
    L17:
        r0 = ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL;
        goto L19
    L5:
        r6 = null;
        goto L6
    }

    public static final /* synthetic */ Object a(d r8, String r9, String r10, long r11, g.e r13, MemoryEventTracker.AutoMemoryRuleHitParams r14, Continuation r15) {
        return r8.a(r9, r10, r11, r13, r14, (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(d r7, String r8, String r9, long r10, g.e r12, Continuation r13) {
        return r7.a(r8, r9, r10, r12, (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(String r14, String r15, long r16, g.e r18, MemoryEventTracker.AutoMemoryRuleHitParams r19, Continuation<? super Unit> r20) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (b.f10076a.a(r14) == false) goto L5;
        a r9 = a(r14, r15, r18.b(), r16);
        String r10 = null;
        if (r9 == null) goto L9;
        r9.j().set(r19);
        r9.g().set(true);
        r9.f().d();
        String r1 = r9.f().c();
        c.remove(r9.a(), r9);
        String r11 = "active-current";
    L10:
        boolean r12 = false;
        if (r9 == null) goto L16;
        if (r1 == null) goto L16;
        if (r9.h().compareAndSet(false, true) == true) goto L16;
        r1 = null;
    L16:
        if (r9 != null) goto L24;
        es r2 = b(r14, r15, r18.b(), r16);
        if (r2 == null) goto L20;
        r10 = r2.b();
    L20:
        if (r10 == null) goto L22;
        r11 = "db-recent";
    L22:
        r1 = r10;
    L24:
        if (b.f10076a.a(r14) == false) goto L26;
        if (r1 == null) goto L29;
        r12 = f10110a.a(r1, r11);
    L29:
        if (r9 == null) goto L31;
        a(r9, r12);
    L33:
        if (r12 == false) goto L36;
        if (r9 != null) goto L36;
        x r3 = x.f11587a;
        String r4 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        r3.a(r4);
    L36:
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("unfavorite package=").append(r14).append(" activity=").append(r15).append(" family=").append(r18.b()).append(" match=").append(r11).append(" entityId=");
        if (r1 != null) goto L39;
        r1 = "";
    L39:
        IRunLog.a.a(r5, "InAppAutoMemory", r6.append(r1).append(" deleted=").append(r12).toString(), false, 4, null);
        return Unit.INSTANCE;
    L31:
        if (r12 == false) goto L33;
        MemoryEventTracker.f10515a.a(r19);
        goto L33
    L26:
        return Unit.INSTANCE;
    L9:
        r11 = "none";
        r1 = null;
        goto L10
    L5:
        return Unit.INSTANCE;
    }

    private final Object a(String r25, String r26, long r27, g.e r29, Continuation<? super Unit> r30) {
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r30, Continuation.class, "com.obric.memorydata.plugin");
        if (b.f10076a.a(r25) == false) goto L5;
        ComponentName r12 = new ComponentName(r25, r26);
        final com.obric.memorydata.memory.llm.c r11 = new com.obric.memorydata.memory.llm.c();
        final a r10 = new a(r11.a(), r25, r26, r29.b(), r27, r11, null, null, null, null, 960, null);
        r11.b($$Lambda$d$grnbwkbtbJWsQsQGGickYFgvA8k.INSTANCE);
        r11.a(new $$Lambda$d$3X94O4KBGQGv1U7S7p31Qu2SEs(r10));
        r11.a(new $$Lambda$d$srp5_U7C75HeDYkjE1oDvG9AxU(r10, r11));
        ConcurrentHashMap<String, a> r0 = c;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r10.a(), r10);
        String r4 = null;
        Bitmap r6 = com.obric.memorydata.utils.e.c.a(com.obric.memorydata.utils.e.c.f13216a, r25, null, 2, null);
        if (r6 != null) goto L11;
        r11.e();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppAutoMemory", "favorite ignored: screenshot unavailable package=" + r25, null, 4, null);
    L10:
        return Unit.INSTANCE;
    L11:
        com.obric.memorydata.dc.a r9 = a(r12);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppAutoMemory", "favorite context package=" + r25 + " activity=" + r26 + " family=" + r29.b() + " cancelled=" + r10.g().get(), false, 4, null);
        if (r10.g().get() == false) goto L14;
    L33:
        r11.d();
        r11.e();
        r0.remove(r10.a(), r10);
        goto L10
    L14:
        if (r11.b() == true) goto L33;
        if (b.f10076a.a(r25) == false) goto L33;
        com.obric.memorydata.utils.c.a r1 = com.obric.memorydata.utils.c.f13193a.b(r25, r26);
        if (r1 == null) goto L21;
        r4 = r1.a();
    L21:
        if (r4 != null) goto L23;
        String r7 = "";
    L24:
        com.obric.memorydata.memory.utils.t r13 = com.obric.memorydata.memory.utils.t.f11563a;
        String r14 = "收藏" + r7;
        if (r9 != null) goto L27;
        boolean r2 = true;
    L28:
        com.obric.memorydata.middleware.api.logging.e r15 = new com.obric.memorydata.middleware.api.logging.e(null, r11.a(), null, 5, null);
        String r3 = r7;
        Object r5 = com.obric.memorydata.memory.utils.t.a(r13, r25, r3, r6, r14, null, true, r2, r12, r9, r11, new com.obric.memorydata.memory.memoryentity.b(null, r29.b(), r26, r27), r15, r16, 16, null);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        return r5;
    L32:
        return Unit.INSTANCE;
    L27:
        r2 = false;
        goto L28
    L23:
        r7 = r4;
        goto L24
    L5:
        return Unit.INSTANCE;
    }

    private static final Unit a(a r2, com.obric.memorydata.memory.llm.c r3) {
        com.obric.memorydata.memory.a r0 = r2.i();
        boolean r1 = r2.g().get();
        if (r3.c() == null) goto L5;
        boolean r4 = true;
    L7:
        if (r0.a(r1, r4) == false) goto L11;
        MemoryEventTracker.AutoMemoryRuleHitParams r5 = (MemoryEventTracker.AutoMemoryRuleHitParams) ZeusTransformUtils.preCheckCast(r2.j().get(), MemoryEventTracker.AutoMemoryRuleHitParams.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        MemoryEventTracker.f10515a.a(r5);
    L11:
        c.remove(r2.a(), r2);
        return Unit.INSTANCE;
    L5:
        r4 = false;
        goto L7
    }

    private static final Unit a(a r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "entityId");
        if (r7.g().get() == false) goto L8;
        if (r7.h().compareAndSet(false, true) == false) goto L8;
        kotlinx.coroutines.i.a(f10111b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppAutoMemoryCoordinator$createMemory$3$1(r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L8:
        return Unit.INSTANCE;
    }

    private static final Unit a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "operationId");
        x.f11587a.a(r1);
        return Unit.INSTANCE;
    }

    private final void a(a r1, boolean r2) {
        if (r1.i().a(r2) == true) goto L5;
        return;
    L5:
        MemoryEventTracker.AutoMemoryRuleHitParams r0 = (MemoryEventTracker.AutoMemoryRuleHitParams) ZeusTransformUtils.preCheckCast(r1.j().get(), MemoryEventTracker.AutoMemoryRuleHitParams.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        MemoryEventTracker.f10515a.a(r0);
        return;
    }

    public static final /* synthetic */ void a(d r0, a r1, boolean r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(d r0, String r1, String r2) {
        return r0.a(r1, r2);
    }

    private final boolean a(String r9, String r10) {
        MemoryEntity r3 = com.obric.memorydata.memory.utils.f.a(com.obric.memorydata.memory.utils.f.f11537a, r9, null, 2, null);
        if (r3 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppAutoMemory", "delete skipped: entity unavailable id=" + r9 + " reason=" + r10, false, 4, null);
        return false;
    L6:
        boolean r1 = MemoryEntityManager.deleteDirectly$default(MemoryEntityManager.INSTANCE, r3, null, null, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppAutoMemory", "delete entity id=" + r9 + " reason=" + r10 + " result=" + r1, false, 4, null);
        return r1;
    }

    private final es b(String r9, String r10, String r11, long r12) {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryLatestRecentInApp(r9, r10, r11, r12 - 5000, r12);
    }

    /* JADX INFO: renamed from: lambda$3X94O4KBGQGv1U7S7p31Qu-2SEs, reason: not valid java name */
    public static /* synthetic */ Unit m693lambda$3X94O4KBGQGv1U7S7p31Qu2SEs(a r0, String r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$grnbwkbtbJWsQsQGGickYFgvA8k(String r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$srp5_U7C75HeDYkjE1oDv-G9AxU, reason: not valid java name */
    public static /* synthetic */ Unit m694lambda$srp5_U7C75HeDYkjE1oDvG9AxU(a r0, com.obric.memorydata.memory.llm.c r1) {
        return a(r0, r1);
    }

    public final synchronized void a() {
        monitor-enter(this);
        d.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r19, g.e r20) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r19, "raw");     // Catch: Throwable -> L65
        Intrinsics.checkNotNullParameter(r20, "spec");     // Catch: Throwable -> L65
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Object r0 = Result.m1421constructorimpl(new JSONObject(r19));     // Catch: Throwable -> L7
    L10:
        if (Result.m1424exceptionOrNullimpl(r0) == null) goto L13;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppAutoMemory", "invalid L1 event", null, 4, null);     // Catch: Throwable -> L65
    L13:
        if (Result.m1427isFailureimpl(r0) == false) goto L15;
        r0 = null;
    L15:
        JSONObject r1 = (JSONObject) ZeusTransformUtils.preCheckCast(r0, JSONObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L65
        if (r1 != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        String r4 = r1.optString("eventType");     // Catch: Throwable -> L65
        String r5 = r1.optString(ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L65
        String r6 = r1.optString("activityName");     // Catch: Throwable -> L65
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L65
        boolean r8 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L63;
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L65
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L27;
        boolean r9 = true;
    L28:
        if (r9 == true) goto L63;
        if (b.f10076a.a(r5) == false) goto L63;
        Long r10 = Long.valueOf(r1.optLong("wallTime"));     // Catch: Throwable -> L65
        if (((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L35;
        boolean r11 = true;
    L36:
        if (r11 == true) goto L39;
        r10 = null;
    L39:
        if (r10 == null) goto L41;
        long r12 = r10.longValue();     // Catch: Throwable -> L65
    L42:
        String r13 = r5 + '|' + r6 + '|' + r20.b();     // Catch: Throwable -> L65
        Long r14 = Long.valueOf(r1.optLong("elapsedTime"));     // Catch: Throwable -> L65
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L46;
        r8 = false;
    L46:
        if (r8 == false) goto L48;
        Long r15 = r14;
    L49:
        if (r15 == null) goto L51;
        long r16 = r15.longValue();     // Catch: Throwable -> L65
    L53:
        if (d.a(r13, r20.a(), r16) == false) goto L57;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "InAppAutoMemory", "dedup L1 event type=" + r4, false, 4, null);     // Catch: Throwable -> L65
        monitor-exit(this);
        return;
    L57:
        MemoryEventTracker.AutoMemoryRuleHitParams r17 = a(r1, r5, r6, r20.a());     // Catch: Throwable -> L65
        if (r20.a() == false) goto L60;
        MemoryEventTracker.f10515a.a(r17);     // Catch: Throwable -> L65
    L60:
        kotlinx.coroutines.i.a(f10111b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new InAppAutoMemoryCoordinator$onL1Event$1(r5, r20, r6, r12, r17, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L65
        monitor-exit(this);
        return;
    L51:
        r16 = r12;
        goto L53
    L48:
        r15 = null;
        goto L49
    L41:
        r12 = System.currentTimeMillis();     // Catch: Throwable -> L65
        goto L42
    L35:
        r11 = false;
        goto L36
    L27:
        r9 = false;
    L63:
        monitor-exit(this);
        return;
    L22:
        r7 = false;
    L7:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L65
        r0 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Collection<a> r5 = c.values();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-values>(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r2 = r7.next();
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin");
        if (b.f10076a.a(r3.b()) == true) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");
        r1.f().d();
        r1.f().e();
        goto L10
    }
}
