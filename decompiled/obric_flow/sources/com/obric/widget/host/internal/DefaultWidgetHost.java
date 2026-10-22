package com.obric.widget.host.internal;

import ai.j0;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.obric.widget.host.CreateOptions;
import com.obric.widget.host.HostedWidget;
import com.obric.widget.host.WidgetDefinition;
import com.obric.widget.host.WidgetHost;
import com.obric.widget.host.WidgetHostContract;
import com.obric.widget.host.WidgetHostRuntime;
import com.obric.widget.host.WidgetInstanceKey;
import com.obric.widget.host.WidgetPerfEvent;
import com.obric.widget.host.WidgetPerfReporter;
import com.obric.widget.host.runtime.WidgetAvailability;
import com.obric.widget.host.runtime.WidgetBindReason;
import com.obric.widget.host.runtime.WidgetDataSnapshot;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetInstanceSnapshot;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002@AB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\rH\u0016J,\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010+\u001a\u00020!H\u0016J\u0010\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.H\u0017J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020.H\u0016J\b\u00101\u001a\u00020!H\u0016J\b\u00102\u001a\u00020!H\u0016J&\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209H\u0082@¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020.2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\f\u0010<\u001a\u000206*\u00020\u001aH\u0002J\u001e\u0010=\u001a\u00020>*\u0002062\u0006\u00107\u001a\u00020.2\b\u0010?\u001a\u0004\u0018\u00010\u0003H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/widget/host/internal/DefaultWidgetHost;", "Lcom/obric/widget/host/WidgetHost;", "hostId", "", "appContext", "Landroid/content/Context;", "contract", "Lcom/obric/widget/host/WidgetHostContract;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Lcom/obric/widget/host/WidgetHostContract;)V", "getHostId", "()Ljava/lang/String;", "ownsScope", "", "viewContext", "scope", "Lkotlinx/coroutines/CoroutineScope;", "runtimeServices", "Lcom/obric/widget/host/runtime/WidgetRuntimeServices;", "activeWidgets", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/widget/host/internal/DefaultWidgetHost$ActiveWidgetKey;", "Lcom/obric/widget/host/internal/DefaultHostedWidget;", "createWidget", "Lcom/obric/widget/host/HostedWidget;", "definition", "Lcom/obric/widget/host/WidgetDefinition;", "options", "Lcom/obric/widget/host/CreateOptions;", "(Lcom/obric/widget/host/WidgetDefinition;Lcom/obric/widget/host/CreateOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnabled", "hasWidgets", "onForeground", "", "onBackground", "onThemeChanged", "isNightMode", "onSystemChanged", "type", "action", "timeMillis", "", "timeZone", "syncVisibility", "destroyByAppWidgetId", "appWidgetId", "", "destroyByHostInstanceId", "hostInstanceId", "clearWidgets", "destroy", "primeSnapshotIfNeeded", "Lcom/obric/widget/host/internal/DefaultWidgetHost$PrimeSnapshotMetrics;", "metadata", "Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;", "instanceId", "bindReason", "Lcom/obric/widget/host/runtime/WidgetBindReason;", "(Lcom/obric/widget/host/runtime/WidgetDefinitionMetadata;ILcom/obric/widget/host/runtime/WidgetBindReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveInstanceId", "toMetadata", "toSnapshot", "Lcom/obric/widget/host/runtime/WidgetInstanceSnapshot;", "definitionId", "PrimeSnapshotMetrics", "ActiveWidgetKey", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDefaultWidgetHost.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultWidgetHost.kt\ncom/obric/widget/host/internal/DefaultWidgetHost\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,359:1\n1863#2,2:360\n1863#2,2:362\n1863#2,2:364\n1863#2,2:366\n1863#2,2:368\n1863#2,2:377\n1863#2,2:379\n487#3,7:370\n*S KotlinDebug\n*F\n+ 1 DefaultWidgetHost.kt\ncom/obric/widget/host/internal/DefaultWidgetHost\n*L\n211#1:360,2\n215#1:362,2\n219#1:364,2\n223#1:366,2\n227#1:368,2\n245#1:377,2\n249#1:379,2\n242#1:370,7\n*E\n"})
public final class DefaultWidgetHost implements WidgetHost {
    private final ConcurrentHashMap<ActiveWidgetKey, DefaultHostedWidget> activeWidgets;
    private final Context appContext;
    private final WidgetHostContract contract;
    private final String hostId;
    private final boolean ownsScope;
    private final WidgetRuntimeServices runtimeServices;
    private final CoroutineScope scope;
    private final Context viewContext;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/obric/widget/host/internal/DefaultWidgetHost$ActiveWidgetKey;", "", "instanceId", "", "<init>", "(I)V", "getInstanceId", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ActiveWidgetKey {
        private final int instanceId;

        public ActiveWidgetKey(int r5) {
            this.instanceId = r5;
        }

        public static /* synthetic */ ActiveWidgetKey copy$default(ActiveWidgetKey r5, int r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.instanceId;
        L6:
            return r5.copy(r10);
        }

        public final int component1() {
            return this.instanceId;
        }

        public final ActiveWidgetKey copy(int r5) {
            return new ActiveWidgetKey(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ActiveWidgetKey) == true) goto L9;
            return false;
        L9:
            if (this.instanceId == ((ActiveWidgetKey) r5).instanceId) goto L11;
            return false;
        L11:
            return true;
        }

        public final int getInstanceId() {
            return this.instanceId;
        }

        public int hashCode() {
            return Integer.hashCode(this.instanceId);
        }

        public String toString() {
            return j0.h(this.instanceId, "ActiveWidgetKey(instanceId=", ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/widget/host/internal/DefaultWidgetHost$PrimeSnapshotMetrics;", "", "queryMs", "", "remoteUpdateMs", "primePayloadLength", "", "hadSnapshotPayload", "", "<init>", "(JJIZ)V", "getQueryMs", "()J", "getRemoteUpdateMs", "getPrimePayloadLength", "()I", "getHadSnapshotPayload", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PrimeSnapshotMetrics {
        private final boolean hadSnapshotPayload;
        private final int primePayloadLength;
        private final long queryMs;
        private final long remoteUpdateMs;

        public PrimeSnapshotMetrics(long r5, long r10, int r11, boolean r12) {
            this.queryMs = r5;
            this.remoteUpdateMs = r10;
            this.primePayloadLength = r11;
            this.hadSnapshotPayload = r12;
        }

        public static /* synthetic */ PrimeSnapshotMetrics copy$default(PrimeSnapshotMetrics r10, long r11, long r12, int r13, boolean r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L5;
            r11 = r10.queryMs;
        L5:
            long r5 = r11;
            if ((r15 & 2) == 0) goto L8;
            r12 = r10.remoteUpdateMs;
        L8:
            long r17 = r12;
            if ((r15 & 4) == 0) goto L11;
            r13 = r10.primePayloadLength;
        L11:
            int r18 = r13;
            if ((r15 & 8) == 0) goto L15;
            r14 = r10.hadSnapshotPayload;
        L15:
            return r10.copy(r5, r17, r18, r14);
        }

        public final long component1() {
            return this.queryMs;
        }

        public final long component2() {
            return this.remoteUpdateMs;
        }

        public final int component3() {
            return this.primePayloadLength;
        }

        public final boolean component4() {
            return this.hadSnapshotPayload;
        }

        public final PrimeSnapshotMetrics copy(long r10, long r11, int r12, boolean r13) {
            return new PrimeSnapshotMetrics(r10, r11, r12, r13);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof PrimeSnapshotMetrics) == true) goto L8;
            return false;
        L8:
            PrimeSnapshotMetrics r11 = (PrimeSnapshotMetrics) r10;
            if (this.queryMs == r11.queryMs) goto L12;
            return false;
        L12:
            if (this.remoteUpdateMs == r11.remoteUpdateMs) goto L15;
            return false;
        L15:
            if (this.primePayloadLength == r11.primePayloadLength) goto L18;
            return false;
        L18:
            if (this.hadSnapshotPayload == r11.hadSnapshotPayload) goto L20;
            return false;
        L20:
            return true;
        }

        public final boolean getHadSnapshotPayload() {
            return this.hadSnapshotPayload;
        }

        public final int getPrimePayloadLength() {
            return this.primePayloadLength;
        }

        public final long getQueryMs() {
            return this.queryMs;
        }

        public final long getRemoteUpdateMs() {
            return this.remoteUpdateMs;
        }

        public int hashCode() {
            int r5 = androidx.room.jarjarred.org.antlr.runtime.a.e(Long.hashCode(this.queryMs) * 31, this.remoteUpdateMs, 31);
            int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.primePayloadLength, r5, 31);
            return Boolean.hashCode(this.hadSnapshotPayload) + r10;
        }

        public String toString() {
            long r5 = this.queryMs;
            long r10 = this.remoteUpdateMs;
            int r11 = this.primePayloadLength;
            boolean r12 = this.hadSnapshotPayload;
            StringBuilder r13 = j0.t(r5, "PrimeSnapshotMetrics(queryMs=", ", remoteUpdateMs=");
            r13.append(r10);
            r13.append(", primePayloadLength=");
            r13.append(r11);
            r13.append(", hadSnapshotPayload=");
            r13.append(r12);
            r13.append(")");
            return r13.toString();
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHost$createWidget$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost", f = "DefaultWidgetHost.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {82, 86, 123, 131, 140}, m = "createWidget", n = {"this", "definition", "options", "activeKey", STGroup.DICT_KEY, "bindReason", "createStartElapsed", "instanceId", "this", "definition", "options", "activeKey", STGroup.DICT_KEY, "bindReason", "widgetMetadata", "createStartElapsed", "instanceId", "this", "definition", "activeKey", STGroup.DICT_KEY, "bindReason", "widgetMetadata", "availability", "snapshot", "createStartElapsed", "instanceId", "this", "definition", "activeKey", STGroup.DICT_KEY, "bindReason", "widgetMetadata", "availability", "snapshot", "primeMetrics", "createStartElapsed", "instanceId", "preMainMs", "mainDispatchStartElapsed", "this", "definition", "activeKey", STGroup.DICT_KEY, "bindReason", "widgetMetadata", "availability", "snapshot", "primeMetrics", "widgetView", "createStartElapsed", "instanceId", "preMainMs", "mainDispatchMs"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "I$0", "J$1", "J$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "J$0", "I$0", "J$1", "J$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DefaultWidgetHost this$0;

        public AnonymousClass1(DefaultWidgetHost r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.createWidget(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHost$primeSnapshotIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost", f = "DefaultWidgetHost.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {268, 286}, m = "primeSnapshotIfNeeded", n = {"this", "metadata", "bindReason", "instanceId", "queryStartElapsed", "payload", "queryMs", "remoteUpdateStartElapsed"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0", "L$0", "J$0", "J$1"})
    public static final class C01881 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DefaultWidgetHost this$0;

        public C01881(DefaultWidgetHost r5, Continuation<? super C01881> r10) {
            this.this$0 = r5;
            super(r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            this.result = r5;
            this.label |= Integer.MIN_VALUE;
            return DefaultWidgetHost.access$primeSnapshotIfNeeded(this.this$0, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHost$primeSnapshotIfNeeded$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost$primeSnapshotIfNeeded$2", f = "DefaultWidgetHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WidgetBindReason $bindReason;
        final /* synthetic */ int $instanceId;
        final /* synthetic */ WidgetDefinitionMetadata $metadata;
        final /* synthetic */ Ref.ObjectRef<String> $payload;
        int label;
        final /* synthetic */ DefaultWidgetHost this$0;

        /* JADX INFO: renamed from: com.obric.widget.host.internal.DefaultWidgetHost$primeSnapshotIfNeeded$2$WhenMappings */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[WidgetBindReason.values().length];
                r5[WidgetBindReason.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r5[WidgetBindReason.RESTORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public AnonymousClass2(Ref.ObjectRef<String> r5, DefaultWidgetHost r10, WidgetDefinitionMetadata r11, int r12, WidgetBindReason r13, Continuation<? super AnonymousClass2> r14) {
            this.$payload = r5;
            this.this$0 = r10;
            this.$metadata = r11;
            this.$instanceId = r12;
            this.$bindReason = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass2(this.$payload, this.this$0, this.$metadata, this.$instanceId, this.$bindReason, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r10);
            Ref.ObjectRef<String> r11 = this.$payload;
            WidgetRuntimeServices r5 = DefaultWidgetHost.access$getRuntimeServices$p(this.this$0);
            String r12 = this.$metadata.getAppletId();
            String r13 = this.$metadata.getWidgetId();
            int r14 = this.$instanceId;
            WidgetBindReason r15 = this.$bindReason;
            int r16 = WhenMappings.$EnumSwitchMapping$0[r15.ordinal()];
            if (r16 != 1) goto L7;
            String r17 = "onAdd";
        L12:
            r11.element = r5.updateWidget(r12, r13, r14, r17.concat(":coldStart"));
            return Unit.INSTANCE;
        L7:
            if (r16 != 2) goto L10;
            r17 = "onRestore";
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public DefaultWidgetHost(String r10, Context r11, WidgetHostContract r12) {
        Intrinsics.checkNotNullParameter(r10, "hostId");
        Intrinsics.checkNotNullParameter(r11, "appContext");
        Intrinsics.checkNotNullParameter(r12, "contract");
        this.hostId = r10;
        this.appContext = r11;
        this.contract = r12;
        if (r12.getCoroutineScope() != null) goto L5;
        boolean r13 = true;
    L6:
        this.ownsScope = r13;
        this.viewContext = r12.getContext();
        CoroutineScope r14 = r12.getCoroutineScope();
        if (r14 != null) goto L9;
        r14 = h0.a(CoroutineContext.Element.DefaultImpls.plus(kotlinx.coroutines.j0.b(), Dispatchers.getIO()));
    L9:
        CoroutineScope r5 = r14;
        this.scope = r5;
        this.runtimeServices = WidgetHostRuntime.runtimeServices$default(r11, getHostId(), r5, r12.getPerfReporter(), false, 16, null);
        this.activeWidgets = new ConcurrentHashMap();
        return;
    L5:
        r13 = false;
        goto L6
    }

    public static /* synthetic */ Unit a(DefaultWidgetHost r5, ActiveWidgetKey r10) {
        return createWidget$lambda$0(r5, r10);
    }

    public static final /* synthetic */ WidgetHostContract access$getContract$p(DefaultWidgetHost r5) {
        return r5.contract;
    }

    public static final /* synthetic */ WidgetRuntimeServices access$getRuntimeServices$p(DefaultWidgetHost r5) {
        return r5.runtimeServices;
    }

    public static final /* synthetic */ CoroutineScope access$getScope$p(DefaultWidgetHost r5) {
        return r5.scope;
    }

    public static final /* synthetic */ Context access$getViewContext$p(DefaultWidgetHost r5) {
        return r5.viewContext;
    }

    public static final /* synthetic */ Object access$primeSnapshotIfNeeded(DefaultWidgetHost r5, WidgetDefinitionMetadata r10, int r11, WidgetBindReason r12, Continuation r13) {
        return r5.primeSnapshotIfNeeded(r10, r11, r12, r13);
    }

    private static final Unit createWidget$lambda$0(DefaultWidgetHost r5, ActiveWidgetKey r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$activeKey");
        r5.activeWidgets.remove(r10);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object primeSnapshotIfNeeded(WidgetDefinitionMetadata r27, int r28, WidgetBindReason r29, Continuation<? super PrimeSnapshotMetrics> r30) {
        if ((r30 instanceof C01881) == false) goto L7;
        C01881 r5 = (C01881) r30;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.label;
        int r14 = 0;
        if (r13 == 0) goto L16;
        if (r13 == 1) goto L15;
        if (r13 != 2) goto L14;
        long r15 = r5.J$1;
        long r16 = r5.J$0;
        Ref.ObjectRef r17 = (Ref.ObjectRef) r5.L$0;
        ResultKt.throwOnFailure(r11);
        long r18 = r16;
    L39:
        long r19 = SystemClock.elapsedRealtime() - r15;
        String r20 = (String) r17.element;
        if (r20 == null) goto L43;
        r14 = r20.length();
    L43:
        return new PrimeSnapshotMetrics(r18, r19, r14, false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r21 = r5.J$0;
        int r22 = r5.I$0;
        WidgetBindReason r23 = (WidgetBindReason) r5.L$2;
        WidgetDefinitionMetadata r24 = (WidgetDefinitionMetadata) r5.L$1;
        DefaultWidgetHost r110 = (DefaultWidgetHost) r5.L$0;
        ResultKt.throwOnFailure(r11);
        int r111 = r22;
        WidgetBindReason r112 = r23;
        WidgetDefinitionMetadata r113 = r24;
        DefaultWidgetHost r114 = r110;
    L20:
        WidgetDataSnapshot r25 = (WidgetDataSnapshot) r11;
        long r26 = SystemClock.elapsedRealtime() - r21;
        if (r25 == null) goto L23;
        String r31 = r25.getWidgetData();
    L24:
        if (r31 != null) goto L26;
    L35:
        long r32 = SystemClock.elapsedRealtime();
        Ref.ObjectRef r33 = new Ref.ObjectRef();
        z r34 = Dispatchers.getIO();
        AnonymousClass2 r115 = new AnonymousClass2(r33, r114, r113, r111, r112, null);
        r5.L$0 = r33;
        r5.L$1 = null;
        r5.L$2 = null;
        r5.J$0 = r26;
        r5.J$1 = r32;
        r5.label = 2;
        if (BuildersKt.withContext(r34, r115, r5) != r12) goto L38;
        return r12;
    L38:
        r18 = r26;
        r15 = r32;
        r17 = r33;
        goto L39
    L26:
        if (StringsKt.isBlank(r31) == true) goto L35;
        if (r25 == null) goto L34;
        String r35 = r25.getWidgetData();
        if (r35 == null) goto L34;
        r14 = r35.length();
    L34:
        return new PrimeSnapshotMetrics(r26, -1, r14, true);
    L23:
        r31 = null;
        goto L24
    L16:
        ResultKt.throwOnFailure(r11);
        long r116 = SystemClock.elapsedRealtime();
        z r36 = Dispatchers.getIO();
        DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1 r37 = new DefaultWidgetHost$primeSnapshotIfNeeded$snapshot$1(this, r27, r28, null);
        r5.L$0 = this;
        r5.L$1 = r27;
        r5.L$2 = r29;
        r5.I$0 = r28;
        r5.J$0 = r116;
        r5.label = 1;
        r11 = BuildersKt.withContext(r36, r37, r5);
        if (r11 != r12) goto L19;
        return r12;
    L19:
        r114 = this;
        r113 = r27;
        r111 = r28;
        r21 = r116;
        r112 = r29;
    L7:
        r5 = new C01881(this, r30);
        goto L8
    }

    private final int resolveInstanceId(CreateOptions r5) {
        String r10 = r5.getInstanceId();
        if (r10 == null) goto L8;
        Integer r11 = StringsKt.toIntOrNull(r10);
        if (r11 == null) goto L8;
        return r11.intValue();
    L8:
        if (r5.getInstanceId() != null) goto L12;
        return View.generateViewId();
    L12:
        throw new IllegalArgumentException(j0.C("Widget instanceId must be numeric: ", r5.getInstanceId()));
    }

    private final WidgetDefinitionMetadata toMetadata(WidgetDefinition r10) {
        String r5 = r10.getAppletId();
        String r11 = r10.getWidgetId();
        Object r12 = r10.getExtras().get("previewUri");
        Number r13 = null;
        if ((r12 instanceof String) == false) goto L5;
        String r14 = (String) r12;
    L6:
        Object r15 = r10.getExtras().get("previewRes");
        if ((r15 instanceof Number) == false) goto L9;
        r13 = (Number) r15;
    L9:
        if (r13 == null) goto L12;
        int r16 = r13.intValue();
    L14:
        return new WidgetDefinitionMetadata(r5, r11, r14, r16, r10.getSpanX(), r10.getSpanY(), r10.getMinSpanX(), r10.getMinSpanY());
    L12:
        r16 = 0;
        goto L14
    L5:
        r14 = null;
        goto L6
    }

    private final WidgetInstanceSnapshot toSnapshot(WidgetDefinitionMetadata r15, int r16, String r17) {
        return new WidgetInstanceSnapshot(r16, r16, r16, getHostId(), r15.getAppletId(), r15.getWidgetId(), r17, 0, 0, 0, r15.getSpanX(), r15.getSpanY());
    }

    @Override // com.obric.widget.host.WidgetHost
    public void clearWidgets() {
        Iterator r5 = CollectionsKt.toList(this.activeWidgets.values()).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DefaultHostedWidget) r5.next()).destroy();
        goto L4
    L6:
        this.activeWidgets.clear();
    }

    @Override // com.obric.widget.host.WidgetHost
    public Object createWidget(WidgetDefinition r56, CreateOptions r57, Continuation<? super HostedWidget> r58) {
        CreateOptions r5 = r57;
        if ((r58 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r58;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        String r15 = "instanceId";
        String r16 = "widgetId";
        String r17 = "appletId";
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L21;
        if (r14 == 2) goto L20;
        if (r14 == 3) goto L19;
        if (r14 == 4) goto L18;
        if (r14 != 5) goto L17;
        long r18 = r10.J$2;
        long r19 = r10.J$1;
        int r20 = r10.I$0;
        long r21 = r10.J$0;
        View r22 = (View) r10.L$9;
        PrimeSnapshotMetrics r110 = (PrimeSnapshotMetrics) r10.L$8;
        WidgetInstanceSnapshot r111 = (WidgetInstanceSnapshot) r10.L$7;
        WidgetAvailability r112 = (WidgetAvailability) r10.L$6;
        WidgetDefinitionMetadata r23 = (WidgetDefinitionMetadata) r10.L$5;
        WidgetBindReason r24 = (WidgetBindReason) r10.L$4;
        WidgetInstanceKey r25 = (WidgetInstanceKey) r10.L$3;
        ActiveWidgetKey r26 = (ActiveWidgetKey) r10.L$2;
        WidgetDefinition r27 = (WidgetDefinition) r10.L$1;
        DefaultWidgetHost r28 = (DefaultWidgetHost) r10.L$0;
        ResultKt.throwOnFailure(r12);
        long r36 = r18;
        WidgetDefinitionMetadata r43 = r23;
        View r42 = r22;
        r15 = "instanceId";
        r16 = "widgetId";
        r17 = "appletId";
        WidgetAvailability r29 = r112;
        WidgetInstanceSnapshot r44 = r111;
        WidgetInstanceKey r113 = r25;
        DefaultWidgetHost r114 = r28;
        Object r30 = r12;
        WidgetDefinition r31 = r27;
        ActiveWidgetKey r32 = r26;
    L61:
        long r115 = SystemClock.elapsedRealtime() - r21;
        String r39 = r114.getHostId();
        WidgetAvailability r55 = r29;
        WidgetInstanceKey r40 = r113;
        DefaultHostedWidget r33 = new DefaultHostedWidget(r39, r40, (DefaultWidgetHostView) r30, r42, r43, r44, r114.runtimeServices, r114.contract.getPerfReporter(), r114.scope, new c(2, r114, r32));
        r114.activeWidgets.put(r32, r33);
        WidgetPerfReporter r34 = r114.contract.getPerfReporter();
        String r210 = r114.getHostId();
        String r35 = r17;
        Pair r38 = TuplesKt.to(r35, r31.getAppletId());
        String r116 = r16;
        Pair r310 = TuplesKt.to(r116, r31.getWidgetId());
        String r37 = r15;
        Pair r41 = TuplesKt.to(r37, Boxing.boxInt(r20));
        Pair r45 = TuplesKt.to("bindReason", r24.name());
        Pair r46 = TuplesKt.to("createWallMs", Boxing.boxLong(r115));
        Pair r47 = TuplesKt.to("preMainMs", Boxing.boxLong(r19));
        Pair r48 = TuplesKt.to("remoteUpdateMs", Boxing.boxLong(r110.getRemoteUpdateMs()));
        Pair r49 = TuplesKt.to("mainDispatchMs", Boxing.boxLong(r36));
        Pair r410 = TuplesKt.to("createCallMs", Boxing.boxLong(r36));
        Pair r411 = TuplesKt.to("internalQueryMs", Boxing.boxLong(r110.getQueryMs()));
        Boolean r50 = null;
        String r117 = "widget_host_create_breakdown";
        long r211 = 0;
        WidgetInstanceKey r212 = r113;
        r34.report(new WidgetPerfEvent(r117, r210, r212, r211, MapsKt.mapOf(new Pair[]{r38, r310, r41, r45, r46, r47, r48, r49, r410, r411, TuplesKt.to("sdkCreateMs", null), TuplesKt.to("applyMs", Boxing.boxLong(0)), TuplesKt.to("primePayloadLength", Boxing.boxInt(r110.getPrimePayloadLength())), TuplesKt.to("hadSnapshotPayload", Boxing.boxBoolean(r110.getHadSnapshotPayload()))}), 8, null));
        WidgetPerfReporter r51 = r114.contract.getPerfReporter();
        String r213 = r114.getHostId();
        Pair r52 = TuplesKt.to(r35, r31.getAppletId());
        Pair r53 = TuplesKt.to(r116, r31.getWidgetId());
        Pair r54 = TuplesKt.to(r37, Boxing.boxInt(r20));
        if (r55 == null) goto L64;
        r50 = Boxing.boxBoolean(r55.getReady());
    L64:
        String r118 = "widget_host_create_success";
        long r214 = 0;
        WidgetInstanceKey r215 = r113;
        r51.report(new WidgetPerfEvent(r118, r213, r215, r214, MapsKt.mapOf(new Pair[]{r52, r53, r54, TuplesKt.to("availabilityReady", r50)}), 8, null));
        return r33;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r59 = r10.J$2;
        long r60 = r10.J$1;
        int r61 = r10.I$0;
        long r62 = r10.J$0;
        PrimeSnapshotMetrics r119 = (PrimeSnapshotMetrics) r10.L$8;
        WidgetInstanceSnapshot r120 = (WidgetInstanceSnapshot) r10.L$7;
        WidgetAvailability r63 = (WidgetAvailability) r10.L$6;
        WidgetDefinitionMetadata r64 = (WidgetDefinitionMetadata) r10.L$5;
        WidgetBindReason r65 = (WidgetBindReason) r10.L$4;
        WidgetInstanceKey r66 = (WidgetInstanceKey) r10.L$3;
        ActiveWidgetKey r67 = (ActiveWidgetKey) r10.L$2;
        WidgetDefinition r68 = (WidgetDefinition) r10.L$1;
        DefaultWidgetHost r69 = (DefaultWidgetHost) r10.L$0;
        ResultKt.throwOnFailure(r12);
        r15 = "instanceId";
        r16 = "widgetId";
        r17 = "appletId";
        r114 = r69;
        long r121 = r60;
        long r70 = r62;
        WidgetDefinitionMetadata r71 = r64;
        WidgetBindReason r122 = r65;
        Object r72 = r13;
        int r73 = r61;
        WidgetAvailability r74 = r63;
        PrimeSnapshotMetrics r75 = r119;
        r113 = r66;
        Object r76 = r12;
        r31 = r68;
        WidgetInstanceSnapshot r510 = r120;
        ActiveWidgetKey r123 = r67;
        long r124 = r59;
    L57:
        View r77 = (View) r76;
        int r511 = r73;
        WidgetBindReason r125 = r122;
        long r78 = SystemClock.elapsedRealtime() - r124;
        MainCoroutineDispatcher r79 = Dispatchers.getMain().getImmediate();
        WidgetAvailability r311 = r74;
        PrimeSnapshotMetrics r312 = r75;
        long r313 = r70;
        Object r216 = r72;
        r36 = r78;
        DefaultWidgetHost$createWidget$hostView$1 r126 = new DefaultWidgetHost$createWidget$hostView$1(r114, r71, r510, r77, null);
        r10.L$0 = r114;
        r10.L$1 = r31;
        r10.L$2 = r123;
        r10.L$3 = r113;
        r10.L$4 = r125;
        r10.L$5 = r71;
        r10.L$6 = r311;
        WidgetInstanceSnapshot r80 = r510;
        r10.L$7 = r80;
        r10.L$8 = r312;
        r10.L$9 = r77;
        r10.J$0 = r313;
        r10.I$0 = r511;
        r10.J$1 = r121;
        WidgetDefinitionMetadata r512 = r71;
        r10.J$2 = r36;
        r10.label = 5;
        Object r81 = BuildersKt.withContext(r79, r126, r10);
        if (r81 != r216) goto L60;
        return r216;
    L60:
        r43 = r512;
        r30 = r81;
        r42 = r77;
        r110 = r312;
        r44 = r80;
        r32 = r123;
        r24 = r125;
        r21 = r313;
        r29 = r311;
        r19 = r121;
        r20 = r511;
        goto L61
    L19:
        int r82 = r10.I$0;
        long r83 = r10.J$0;
        WidgetInstanceSnapshot r84 = (WidgetInstanceSnapshot) r10.L$7;
        WidgetAvailability r85 = (WidgetAvailability) r10.L$6;
        WidgetDefinitionMetadata r86 = (WidgetDefinitionMetadata) r10.L$5;
        r122 = (WidgetBindReason) r10.L$4;
        r113 = (WidgetInstanceKey) r10.L$3;
        r123 = (ActiveWidgetKey) r10.L$2;
        WidgetDefinition r87 = (WidgetDefinition) r10.L$1;
        DefaultWidgetHost r88 = (DefaultWidgetHost) r10.L$0;
        ResultKt.throwOnFailure(r12);
        r15 = "instanceId";
        r16 = "widgetId";
        r17 = "appletId";
        Object r127 = r13;
        WidgetAvailability r89 = r85;
        Object r90 = r12;
        WidgetInstanceSnapshot r91 = r84;
        int r92 = r82;
    L53:
        PrimeSnapshotMetrics r93 = (PrimeSnapshotMetrics) r90;
        long r128 = SystemClock.elapsedRealtime() - r83;
        Object r217 = r127;
        long r129 = SystemClock.elapsedRealtime();
        MainCoroutineDispatcher r130 = Dispatchers.getMain().getImmediate();
        r124 = r129;
        DefaultWidgetHost$createWidget$widgetView$1 r131 = new DefaultWidgetHost$createWidget$widgetView$1(r88, r86, r92, null);
        r10.L$0 = r88;
        r10.L$1 = r87;
        r10.L$2 = r123;
        r10.L$3 = r113;
        r10.L$4 = r122;
        r10.L$5 = r86;
        r10.L$6 = r89;
        r10.L$7 = r91;
        r10.L$8 = r93;
        r10.J$0 = r83;
        r10.I$0 = r92;
        r10.J$1 = r128;
        DefaultWidgetHost r218 = r88;
        int r219 = r92;
        r10.J$2 = r124;
        r10.label = 4;
        Object r94 = BuildersKt.withContext(r130, r131, r10);
        r72 = r217;
        if (r94 != r72) goto L56;
        return r72;
    L56:
        r510 = r91;
        r31 = r87;
        r121 = r128;
        r114 = r218;
        WidgetAvailability r513 = r89;
        r76 = r94;
        r71 = r86;
        r73 = r219;
        long r514 = r83;
        r74 = r513;
        r75 = r93;
        r70 = r514;
        goto L57
    L20:
        int r95 = r10.I$0;
        long r96 = r10.J$0;
        WidgetDefinitionMetadata r97 = (WidgetDefinitionMetadata) r10.L$6;
        WidgetBindReason r98 = (WidgetBindReason) r10.L$5;
        WidgetInstanceKey r99 = (WidgetInstanceKey) r10.L$4;
        ActiveWidgetKey r132 = (ActiveWidgetKey) r10.L$3;
        CreateOptions r133 = (CreateOptions) r10.L$2;
        WidgetDefinition r134 = (WidgetDefinition) r10.L$1;
        DefaultWidgetHost r100 = (DefaultWidgetHost) r10.L$0;
        ResultKt.throwOnFailure(r12);
        r16 = "widgetId";
        r17 = "appletId";
        r92 = r95;
        r88 = r100;
        CreateOptions r101 = r133;
        r113 = r99;
        r86 = r97;
        r122 = r98;
        r87 = r134;
        r123 = r132;
    L37:
        WidgetAvailability r102 = (WidgetAvailability) r12;
        if (r102 == null) goto L43;
        if (r102.getReady() == true) goto L43;
        String r220 = "widget_host_create_availability_not_ready";
        long r221 = 0;
        WidgetInstanceKey r222 = r113;
        r88.contract.getPerfReporter().report(new WidgetPerfEvent(r220, r88.getHostId(), r222, r221, MapsKt.mapOf(new Pair[]{TuplesKt.to("installState", r102.getInstallState()), TuplesKt.to("errorCode", r102.getErrorCode()), TuplesKt.to("errorMessage", r102.getErrorMessage()), TuplesKt.to("retryable", Boxing.boxBoolean(r102.getRetryable()))}), 8, null));
    L43:
        Object r103 = r87.getExtras().get("definitionId");
        if (r103 != null) goto L47;
        r103 = r101.getConfig().getExtras().get("definitionId");
    L47:
        if ((r103 instanceof String) == false) goto L49;
        String r104 = (String) r103;
    L50:
        r91 = r88.toSnapshot(r86, r92, r104);
        r88.runtimeServices.getInstanceManager().bindInstance(r91, r122);
        r88.runtimeServices.getInstanceManager().onViewAttached(r91);
        r10.L$0 = r88;
        r10.L$1 = r87;
        r10.L$2 = r123;
        r10.L$3 = r113;
        r10.L$4 = r122;
        r10.L$5 = r86;
        r89 = r102;
        r10.L$6 = r89;
        r10.L$7 = r91;
        r83 = r96;
        r10.J$0 = r83;
        r10.I$0 = r92;
        r10.label = 3;
        r90 = r88.primeSnapshotIfNeeded(r86, r92, r122, r10);
        r127 = r13;
        if (r90 != r127) goto L53;
        return r127;
    L49:
        r104 = null;
        goto L50
    L21:
        int r105 = r10.I$0;
        r96 = r10.J$0;
        WidgetBindReason r106 = (WidgetBindReason) r10.L$5;
        WidgetInstanceKey r107 = (WidgetInstanceKey) r10.L$4;
        ActiveWidgetKey r108 = (ActiveWidgetKey) r10.L$3;
        CreateOptions r135 = (CreateOptions) r10.L$2;
        WidgetDefinition r136 = (WidgetDefinition) r10.L$1;
        DefaultWidgetHost r137 = (DefaultWidgetHost) r10.L$0;
        ResultKt.throwOnFailure(r12);
        WidgetBindReason r109 = r106;
        r5 = r135;
    L30:
        WidgetDefinitionMetadata r138 = (WidgetDefinitionMetadata) r12;
        if (r138 != null) goto L33;
        r138 = r137.toMetadata(r136);
    L33:
        HostedWidgetRuntimeBootstrap.INSTANCE.ensureInitialized(r137.appContext);
        z r139 = Dispatchers.getIO();
        DefaultWidgetHost$createWidget$availability$1 r140 = new DefaultWidgetHost$createWidget$availability$1(r137, r136, r109, null);
        r10.L$0 = r137;
        r10.L$1 = r136;
        r10.L$2 = r5;
        r10.L$3 = r108;
        r10.L$4 = r107;
        r10.L$5 = r109;
        r10.L$6 = r138;
        r10.J$0 = r96;
        r10.I$0 = r105;
        r10.label = 2;
        Object r141 = BuildersKt.withContext(r139, r140, r10);
        if (r141 != r13) goto L36;
        return r13;
    L36:
        CreateOptions r515 = r5;
        r92 = r105;
        r88 = r137;
        r123 = r108;
        r101 = r515;
        WidgetBindReason r516 = r109;
        r86 = r138;
        r12 = r141;
        r122 = r516;
        WidgetDefinition r517 = r136;
        r113 = r107;
        r87 = r517;
        goto L37
    L22:
        ResultKt.throwOnFailure(r12);
        r96 = SystemClock.elapsedRealtime();
        int r142 = resolveInstanceId(r5);
        r108 = new ActiveWidgetKey(r142);
        r107 = new WidgetInstanceKey(r56.getAppletId(), r56.getWidgetId(), String.valueOf(r142), getHostId());
        if (r57.getRestoreData() == null) goto L25;
        r109 = WidgetBindReason.RESTORE;
    L26:
        String r223 = "widget_host_create_start";
        long r224 = 0;
        this.contract.getPerfReporter().report(new WidgetPerfEvent(r223, getHostId(), r107, r224, MapsKt.mapOf(new Pair[]{TuplesKt.to("appletId", r56.getAppletId()), TuplesKt.to("widgetId", r56.getWidgetId()), TuplesKt.to("instanceId", Boxing.boxInt(r142))}), 8, null));
        WidgetRuntimeServices r143 = this.runtimeServices;
        String r144 = r56.getAppletId();
        String r145 = r56.getWidgetId();
        r10.L$0 = this;
        r136 = r56;
        r10.L$1 = r136;
        r10.L$2 = r5;
        r10.L$3 = r108;
        r10.L$4 = r107;
        r10.L$5 = r109;
        r10.J$0 = r96;
        r10.I$0 = r142;
        r10.label = 1;
        Object r146 = r143.getWidgetInfo(r144, r145, r10);
        if (r146 != r13) goto L29;
        return r13;
    L29:
        r137 = this;
        r105 = r142;
        r12 = r146;
        goto L30
    L25:
        r109 = WidgetBindReason.ADD;
    L7:
        r10 = new AnonymousClass1(this, r58);
        goto L8
    }

    @Override // com.obric.widget.host.WidgetHost
    public void destroy() {
        clearWidgets();
        if (this.ownsScope == false) goto L5;
        h0.c(this.scope, null);
    L5:
        WidgetHostRuntime.clearRuntimeServices(getHostId());
    }

    @Override // com.obric.widget.host.WidgetHost
    @Deprecated(message = "Launcher compatibility API. Non-Launcher hosts should call HostedWidget.destroy() or destroyByHostInstanceId() with their own stable instance id.", replaceWith = @ReplaceWith(expression = "destroyByHostInstanceId(appWidgetId)", imports = {}))
    public void destroyByAppWidgetId(int r5) {
        destroyByHostInstanceId(r5);
    }

    @Override // com.obric.widget.host.WidgetHost
    public void destroyByHostInstanceId(int r5) {
        ConcurrentHashMap<ActiveWidgetKey, DefaultHostedWidget> r10 = this.activeWidgets;
        LinkedHashMap r11 = new LinkedHashMap();
        Iterator<Map.Entry<ActiveWidgetKey, DefaultHostedWidget>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<ActiveWidgetKey, DefaultHostedWidget> r13 = r12.next();
        if (r13.getKey().getInstanceId() != r5) goto L4;
        r11.put(r13.getKey(), r13.getValue());
        goto L4
    L8:
        Iterator r14 = CollectionsKt.toList(r11.values()).iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        ((DefaultHostedWidget) r14.next()).destroy();
        goto L10
    }

    @Override // com.obric.widget.host.WidgetHost
    public String getHostId() {
        return this.hostId;
    }

    @Override // com.obric.widget.host.WidgetHost
    public boolean hasWidgets() {
        return !this.activeWidgets.isEmpty();
    }

    @Override // com.obric.widget.host.WidgetHost
    public boolean isEnabled() {
        return true;
    }

    @Override // com.obric.widget.host.WidgetHost
    public void onBackground() {
        Iterator<T> r5 = this.activeWidgets.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DefaultHostedWidget) r5.next()).onHide();
        goto L4
    }

    @Override // com.obric.widget.host.WidgetHost
    public void onForeground() {
        Iterator<T> r5 = this.activeWidgets.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DefaultHostedWidget) r5.next()).onForeground();
        goto L4
    }

    @Override // com.obric.widget.host.WidgetHost
    public void onSystemChanged(String r10, String r11, long r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "type");
        Iterator<T> r14 = this.activeWidgets.values().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        ((DefaultHostedWidget) r14.next()).onSystemChanged(r10, r11, r12, r13);
        goto L4
    }

    @Override // com.obric.widget.host.WidgetHost
    public void onThemeChanged(boolean r5) {
        Iterator<T> r10 = this.activeWidgets.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((DefaultHostedWidget) r10.next()).onThemeChanged(r5);
        goto L4
    }

    @Override // com.obric.widget.host.WidgetHost
    public Object restoreWidget(WidgetDefinition r5, CreateOptions r10, Continuation<? super HostedWidget> r11) {
        return WidgetHost.DefaultImpls.restoreWidget(this, r5, r10, r11);
    }

    @Override // com.obric.widget.host.WidgetHost
    public void syncVisibility() {
        Iterator<T> r5 = this.activeWidgets.values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((DefaultHostedWidget) r5.next()).syncVisibility();
        goto L4
    }
}
