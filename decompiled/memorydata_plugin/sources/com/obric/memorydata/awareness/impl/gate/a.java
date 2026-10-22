package com.obric.memorydata.awareness.impl.gate;

import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.awareness.impl.AwarenessEventTriggerType;
import com.obric.memorydata.awareness.impl.data.AwarenessEventTriggerConfig;
import com.obric.memorydata.middleware.api.logging.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\n\b\u0000\u0018\u0000 <2\u00020\u0001:\u000589:;<B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u001e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\bJ\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J$\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\u000f2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002J\u0012\u0010'\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007*\u0004\u0018\u00010!H\u0002JN\u0010,\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u000f2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001f0\u000f2\u001e\u0010/\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\u000f0\u000fH\u0002J2\u00100\u001a\u00020\b2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000703022\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u001fH\u0002J\u0018\u00105\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u001fH\u0002J$\u00106\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u001f0\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate;", "", "provider", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;", "onPackagesMayHaveChanged", "Lkotlin/Function1;", "", "", "", "<init>", "(Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchValueProvider;Lkotlin/jvm/functions/Function1;)V", "snapshot", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$GateSnapshot;", "replacePackageConfigs", "configs", "", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerPackageSwitchConfig;", "isAutoTriggerEnabled", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isPackageEnabled", "currentSnapshot", "isAwarenessEventAutoTriggerEnabled", "type", "Lcom/obric/memorydata/awareness/impl/AwarenessEventTriggerType;", ActivityLifecycle.NAME, "release", "isEnabled", "config", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$ParsedFeatureSwitch;", "parsePackageGate", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate;", "element", "Lcom/google/gson/JsonElement;", "parseEventGates", "Lcom/obric/memorydata/awareness/impl/AwarenessEventSubscription;", "triggers", "", "Lcom/obric/memorydata/awareness/impl/data/AwarenessEventTriggerConfig;", "parseEventGate", "parseSwitch", "parseDefaultValue", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;", "asRequiredString", "buildReverseIndex", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "packageGates", "eventGates", "addGateKeys", "packagesByKey", "", "", "gate", "reportInvalidPackageGate", "reportInvalidEventGates", "gates", "SwitchGate", "ParsedFeatureSwitch", "FeatureSwitchDefaultValue", "GateSnapshot", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0438a f8669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.awareness.impl.gate.d f8670b;
    private final Function1<Set<String>, Unit> c;
    private volatile c d;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.gate.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$Companion;", "", "<init>", "()V", "ENABLED_INT_VALUE", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0438a {
        private C0438a() {
        }

        public /* synthetic */ C0438a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;", "", "BooleanValue", "IntValue", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue$BooleanValue;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue$IntValue;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private interface b {

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.gate.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue$BooleanValue;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;", EventBody.KEY_VALUE, "", "<init>", "(Z)V", "getValue", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0439a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final boolean f8671a;

            public C0439a(boolean r1) {
                this.f8671a = r1;
            }

            public final boolean a() {
                return this.f8671a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0439a.class) == true) goto L8;
                return false;
            L8:
                C0439a r6 = (C0439a) ZeusTransformUtils.preCheckCast(r5, C0439a.class, "com.obric.memorydata.plugin");
                if (this.f8671a == r6.f8671a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Boolean.hashCode(this.f8671a);
            }

            public String toString() {
                return "BooleanValue(value=" + this.f8671a + ')';
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.gate.a$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue$IntValue;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;", EventBody.KEY_VALUE, "", "<init>", "(I)V", "getValue", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0440b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f8672a;

            public C0440b(int r1) {
                this.f8672a = r1;
            }

            public final int a() {
                return this.f8672a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0440b.class) == true) goto L8;
                return false;
            L8:
                C0440b r6 = (C0440b) ZeusTransformUtils.preCheckCast(r5, C0440b.class, "com.obric.memorydata.plugin");
                if (this.f8672a == r6.f8672a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Integer.hashCode(this.f8672a);
            }

            public String toString() {
                return "IntValue(value=" + this.f8672a + ')';
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBc\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00030\u0003\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J!\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00030\u0003HÆ\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003Jm\u0010\u0018\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00030\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$GateSnapshot;", "", "packageGates", "", "", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate;", "eventGates", "Lcom/obric/memorydata/awareness/impl/AwarenessEventSubscription;", "packagesByKey", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "", "removedPackages", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;)V", "getPackageGates", "()Ljava/util/Map;", "getEventGates", "getPackagesByKey", "getRemovedPackages", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0441a f8673a = null;
        private static final c f = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, e> f8674b;
        private final Map<String, Map<com.obric.memorydata.awareness.impl.c, e>> c;
        private final Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> d;
        private final Set<String> e;

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.gate.a$c$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$GateSnapshot$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$GateSnapshot;", "getEMPTY", "()Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$GateSnapshot;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0441a {
            private C0441a() {
            }

            public /* synthetic */ C0441a(DefaultConstructorMarker r1) {
                this();
            }

            public final c a() {
                return c.e();
            }
        }

        static {
            f8673a = new C0441a(null);
            f = new c(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), SetsKt.emptySet());
        }

        public c(Map<String, ? extends e> r3, Map<String, ? extends Map<com.obric.memorydata.awareness.impl.c, ? extends e>> r4, Map<com.obric.memorydata.awareness.impl.gate.c, ? extends Set<String>> r5, Set<String> r6) {
            Map<String, e> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Map<String, Map<com.obric.memorydata.awareness.impl.c, e>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "packageGates");
            Intrinsics.checkNotNullParameter(r8, "eventGates");
            Intrinsics.checkNotNullParameter(r9, "packagesByKey");
            Intrinsics.checkNotNullParameter(r10, "removedPackages");
            this.f8674b = r7;
            this.c = r8;
            this.d = r9;
            this.e = r10;
        }

        public static final /* synthetic */ c e() {
            return f;
        }

        public final Map<String, e> a() {
            return this.f8674b;
        }

        public final Map<String, Map<com.obric.memorydata.awareness.impl.c, e>> b() {
            return this.c;
        }

        public final Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> c() {
            return this.d;
        }

        public final Set<String> d() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8674b, r6.f8674b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f8674b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "GateSnapshot(packageGates=" + this.f8674b + ", eventGates=" + this.c + ", packagesByKey=" + this.d + ", removedPackages=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$ParsedFeatureSwitch;", "", "key", "Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "defaultValue", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;", "<init>", "(Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;)V", "getKey", "()Lcom/obric/memorydata/awareness/impl/gate/FeatureSwitchKey;", "getDefaultValue", "()Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$FeatureSwitchDefaultValue;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.memorydata.awareness.impl.gate.c f8675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f8676b;

        public d(com.obric.memorydata.awareness.impl.gate.c r3, b r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r5, "defaultValue");
            this.f8675a = r3;
            this.f8676b = r5;
        }

        public final com.obric.memorydata.awareness.impl.gate.c a() {
            return this.f8675a;
        }

        public final b b() {
            return this.f8676b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8675a, r6.f8675a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8676b, r6.f8676b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8675a.hashCode() * 31) + this.f8676b.hashCode();
        }

        public String toString() {
            return "ParsedFeatureSwitch(key=" + this.f8675a + ", defaultValue=" + this.f8676b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate;", "", "Ungated", "Invalid", "Valid", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate$Invalid;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate$Ungated;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate$Valid;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private interface e {

        /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.gate.a$e$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate$Invalid;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate;", InfoRequestQPSOptTraceLogger.REASON, "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0442a implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f8677a;

            public C0442a(String r2) {
                Intrinsics.checkNotNullParameter(r2, InfoRequestQPSOptTraceLogger.REASON);
                this.f8677a = r2;
            }

            public final String a() {
                return this.f8677a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, C0442a.class) == true) goto L8;
                return false;
            L8:
                C0442a r6 = (C0442a) ZeusTransformUtils.preCheckCast(r5, C0442a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f8677a, r6.f8677a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f8677a.hashCode();
            }

            public String toString() {
                return "Invalid(reason=" + this.f8677a + ')';
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate$Ungated;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate;", "<init>", "()V", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f8678a = null;

            static {
                f8678a = new b();
            }

            private b() {
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate$Valid;", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$SwitchGate;", "switches", "", "Lcom/obric/memorydata/awareness/impl/gate/AutoTriggerFeatureSwitchGate$ParsedFeatureSwitch;", "<init>", "(Ljava/util/List;)V", "getSwitches", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class c implements e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final List<d> f8679a;

            public c(List<d> r3) {
                List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r4, "switches");
                this.f8679a = r4;
            }

            public final List<d> a() {
                return this.f8679a;
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
                return false;
            L8:
                c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f8679a, r6.f8679a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return this.f8679a.hashCode();
            }

            public String toString() {
                return "Valid(switches=" + this.f8679a + ')';
            }
        }
    }

    static {
        f8669a = new C0438a(null);
    }

    public a(com.obric.memorydata.awareness.impl.gate.d r3, Function1<? super Set<String>, Unit> r4) {
        com.obric.memorydata.awareness.impl.gate.d r5 = (com.obric.memorydata.awareness.impl.gate.d) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.awareness.impl.gate.d.class, "com.obric.memorydata.plugin");
        Function1<Set<String>, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "provider");
        Intrinsics.checkNotNullParameter(r6, "onPackagesMayHaveChanged");
        this.f8670b = r5;
        this.c = r6;
        this.d = c.f8673a.a();
    }

    private final e a(JsonElement r7) {
        if (r7 != null) goto L9;
    L4:
        Object r6 = e.b.f8678a;
    L5:
        Object r8 = ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.memorydata.plugin");
    L7:
        return (e) r8;
    L9:
        if (r7.isJsonArray() == true) goto L12;
        r6 = new e.C0442a("switches_not_array");
        goto L5
    L12:
        if (r7.getAsJsonArray().size() == 0) goto L4;
        JsonArray r9 = r7.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(r9, "getAsJsonArray(...)");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        Iterator r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L24;
        Object r3 = r11.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        JsonElement r5 = (JsonElement) ZeusTransformUtils.preCheckCast(r3, JsonElement.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        d r12 = c(r5);
        if (r12 == null) goto L22;
        r1.add(r12);
        r2 = r4;
        goto L16
    L22:
        r6 = new e.C0442a("invalid_switch_" + r2);
        goto L5
    L24:
        r8 = ZeusTransformUtils.preCheckCast(new e.c((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin");
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<com.obric.memorydata.awareness.impl.c, e> a(List<AwarenessEventTriggerConfig> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L23;
        AwarenessEventTriggerConfig r2 = (AwarenessEventTriggerConfig) ZeusTransformUtils.preCheckCast(r11.next(), AwarenessEventTriggerConfig.class, "com.obric.memorydata.plugin");
        AwarenessEventTriggerType r3 = AwarenessEventTriggerType.Companion.a(r2.getType());
        Pair r4 = null;
        if (r3 == null) goto L21;
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2.getName(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == true) goto L18;
        r5 = null;
    L18:
        if (r5 == null) goto L21;
        r4 = TuplesKt.to(new com.obric.memorydata.awareness.impl.c(r3, r5), b(r2.getFeatureSwitch()));
        goto L21
    L14:
        r6 = false;
    L21:
        if (r4 == null) goto L7;
        r0.add(r4);
        goto L7
    L23:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r13 = r7.iterator();
    L25:
        if (r13.hasNext() == false) goto L30;
        Object r1 = r13.next();
        com.obric.memorydata.awareness.impl.c r14 = (com.obric.memorydata.awareness.impl.c) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r1, Pair.class, "com.obric.memorydata.plugin")).getFirst(), com.obric.memorydata.awareness.impl.c.class, "com.obric.memorydata.plugin");
        Object r15 = r12.get(r14);
        if (r15 != null) goto L29;
        r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r12.put(r14, r15);
    L29:
        ((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin")).add((e) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r1, Pair.class, "com.obric.memorydata.plugin")).getSecond(), e.class, "com.obric.memorydata.plugin"));
        goto L25
    L30:
        Map<com.obric.memorydata.awareness.impl.c, e> r16 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r12.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L32:
        if (r17.hasNext() == false) goto L37;
        Object r18 = r17.next();
        Object r19 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r18, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        e r20 = (e) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r18, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"))), e.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L36;
        r20 = (e) ZeusTransformUtils.preCheckCast(new e.C0442a("duplicate_trigger_gate_conflict"), e.class, "com.obric.memorydata.plugin");
    L36:
        r16.put(r19, r20);
        goto L32
    L37:
        return r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> a(Map<String, ? extends e> r6, Map<String, ? extends Map<com.obric.memorydata.awareness.impl.c, ? extends e>> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> r0 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a(r0, (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"), (e) ZeusTransformUtils.preCheckCast(r2.getValue(), e.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        Iterator r11 = r9.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r12.getValue(), Map.class, "com.obric.memorydata.plugin")).values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r13.hasNext() == false) goto L8;
        a(r0, r3, (e) ZeusTransformUtils.preCheckCast(r13.next(), e.class, "com.obric.memorydata.plugin"));
        goto L11
    L13:
        Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r0.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        Object r15 = r14.next();
        r5.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r15, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r15, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Iterable.class, "com.obric.memorydata.plugin")));
        goto L15
    L17:
        return r5;
    }

    private static final Unit a(a r2, com.obric.memorydata.awareness.impl.gate.c r3) {
        Intrinsics.checkNotNullParameter(r3, "changedKey");
        Set<String> r4 = (Set) ZeusTransformUtils.preCheckCast(r2.d.c().get(r3), Set.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L11;
        r2.c.invoke(r4);
    L11:
        return Unit.INSTANCE;
    }

    private final void a(String r9, e r10) {
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r10, e.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, e.C0442a.class) == true) goto L5;
        return;
    L5:
        o r11 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        r1.a("package_name", r9);
        r1.a("scope", "package");
        r1.a(InfoRequestQPSOptTraceLogger.REASON, ((e.C0442a) ZeusTransformUtils.preCheckCast(r8, e.C0442a.class, "com.obric.memorydata.plugin")).a());
        r11.a("auto_trigger_switch_config_invalid", "算法包自动触发开关配置非法，已关闭自动触发", r7, r1.a());
    }

    private final void a(String r11, Map<com.obric.memorydata.awareness.impl.c, ? extends e> r12) {
        Iterator r10 = ((Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.awareness.impl.c r1 = (com.obric.memorydata.awareness.impl.c) ZeusTransformUtils.preCheckCast(r13.getKey(), com.obric.memorydata.awareness.impl.c.class, "com.obric.memorydata.plugin");
        e r14 = (e) ZeusTransformUtils.preCheckCast(r13.getValue(), e.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, e.C0442a.class) == false) goto L4;
        o r2 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.b.f11611a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r9 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        com.obric.memorydata.middleware.api.logging.g r3 = new com.obric.memorydata.middleware.api.logging.g();
        r3.a("package_name", r11);
        r3.a("scope", "awareness_event");
        r3.a("trigger_type", r1.getType().getValue());
        r3.a(InfoRequestQPSOptTraceLogger.REASON, ((e.C0442a) ZeusTransformUtils.preCheckCast(r14, e.C0442a.class, "com.obric.memorydata.plugin")).a());
        r2.a("auto_trigger_switch_config_invalid", "感知事件自动触发开关配置非法，已关闭对应事件", r9, r3.a());
        goto L4
    }

    private final void a(Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> r4, String r5, e r6) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, e.c.class) == false) goto L11;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(((e.c) ZeusTransformUtils.preCheckCast(r7, e.c.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L15;
        com.obric.memorydata.awareness.impl.gate.c r9 = ((d) ZeusTransformUtils.preCheckCast(r8.next(), d.class, "com.obric.memorydata.plugin")).a();
        Object r1 = r3.get(r9);
        if (r1 != null) goto L10;
        r1 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r3.put(r9, r1);
    L10:
        ((Set) ZeusTransformUtils.preCheckCast(r1, Set.class, "com.obric.memorydata.plugin")).add(r5);
        goto L6
    L15:
        return;
    }

    private final boolean a(d r6) {
        b r0 = r6.b();
        if (ZeusTransformUtils.instanceOf(r0, b.C0439a.class) == false) goto L6;
        return this.f8670b.a(r6.a().a(), r6.a().b(), ((b.C0439a) ZeusTransformUtils.preCheckCast(r0, b.C0439a.class, "com.obric.memorydata.plugin")).a());
    L6:
        if (ZeusTransformUtils.instanceOf(r0, b.C0440b.class) == false) goto L13;
        if (this.f8670b.a(r6.a().a(), r6.a().b(), ((b.C0440b) ZeusTransformUtils.preCheckCast(r0, b.C0440b.class, "com.obric.memorydata.plugin")).a()) == 1) goto L15;
        return false;
    L15:
        return true;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    private final boolean a(String r5, c r6) {
        e r0 = (e) ZeusTransformUtils.preCheckCast(r6.a().get(r5), e.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return !r6.d().contains(r5);
    L7:
        if (Intrinsics.areEqual(r0, e.b.f8678a) == false) goto L10;
        return true;
    L10:
        if (ZeusTransformUtils.instanceOf(r0, e.C0442a.class) == false) goto L13;
    L24:
        return false;
    L13:
        if (ZeusTransformUtils.instanceOf(r0, e.c.class) == false) goto L26;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(((e.c) ZeusTransformUtils.preCheckCast(r0, e.c.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L17;
    L19:
        Iterator r8 = r7.iterator();
    L21:
        if (r8.hasNext() == false) goto L24;
        if (a((d) ZeusTransformUtils.preCheckCast(r8.next(), d.class, "com.obric.memorydata.plugin")) == false) goto L21;
        return true;
    L17:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L19;
    L26:
        throw new NoWhenBranchMatchedException();
    }

    private final e b(JsonElement r3) {
        if (r3 != null) goto L9;
        Object r2 = e.b.f8678a;
    L5:
        Object r4 = ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
    L7:
        return (e) r4;
    L9:
        if (r3.isJsonObject() == true) goto L11;
        r2 = new e.C0442a("feature_switch_not_object");
        goto L5
    L11:
        d r5 = c(r3);
        if (r5 != null) goto L14;
        r2 = new e.C0442a("invalid_feature_switch");
        goto L5
    L14:
        r4 = ZeusTransformUtils.preCheckCast(new e.c(CollectionsKt.listOf(r5)), e.class, "com.obric.memorydata.plugin");
        goto L7
    }

    private final d c(JsonElement r5) {
        if (r5.isJsonObject() == true) goto L5;
        return null;
    L5:
        JsonObject r6 = r5.getAsJsonObject();
        String r0 = e(r6.get("repo"));
        if (r0 != null) goto L8;
        return null;
    L8:
        String r2 = e(r6.get("key"));
        if (r2 != null) goto L11;
        return null;
    L11:
        b r4 = d(r6.get("default_value"));
        if (r4 != null) goto L15;
        return null;
    L15:
        return new d(new com.obric.memorydata.awareness.impl.gate.c(r0, r2), r4);
    }

    private final b d(JsonElement r3) {
        Object r2 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isJsonPrimitive() == false) goto L19;
        JsonPrimitive r4 = r3.getAsJsonPrimitive();
        if (r4.isBoolean() == false) goto L12;
        r2 = new b.C0439a(r4.getAsBoolean());
    L17:
        return (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin");
    L12:
        if (r4.isNumber() == false) goto L18;
        String r5 = r4.getAsString();
        Intrinsics.checkNotNullExpressionValue(r5, "getAsString(...)");
        Integer r6 = StringsKt.toIntOrNull(r5);
        if (r6 == null) goto L17;
        r2 = new b.C0440b(((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue());
        goto L17
    L18:
        return null;
    L19:
        return null;
    }

    private final String e(JsonElement r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isJsonPrimitive() == true) goto L7;
        return null;
    L7:
        if (r3.getAsJsonPrimitive().isString() == false) goto L19;
        String r4 = r3.getAsString();
        Intrinsics.checkNotNullExpressionValue(r4, "getAsString(...)");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == true) goto L15;
        return null;
    L15:
        return r5;
    L12:
        r0 = false;
        goto L13
    L19:
        return null;
    }

    /* JADX INFO: renamed from: lambda$-qJE6n3PPYX2vcRu5DC58XZVuQk, reason: not valid java name */
    public static /* synthetic */ Unit m513lambda$qJE6n3PPYX2vcRu5DC58XZVuQk(a r0, com.obric.memorydata.awareness.impl.gate.c r1) {
        return a(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Map<String, com.obric.memorydata.awareness.impl.gate.b> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "configs");
        c r0 = this.d;
        Set<String> r2 = r0.a().keySet();
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r11.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Object r5 = r4.next();
        Object r6 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");
        e r9 = a(((com.obric.memorydata.awareness.impl.gate.b) ZeusTransformUtils.preCheckCast(r7.getValue(), com.obric.memorydata.awareness.impl.gate.b.class, "com.obric.memorydata.plugin")).a());
        a(r8, r9);
        r3.put(r6, r9);
        goto L4
    L6:
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r11.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r11.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Object r14 = r13.next();
        Object r15 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14, Map.Entry.class, "com.obric.memorydata.plugin");
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin");
        Map<com.obric.memorydata.awareness.impl.c, e> r18 = a(((com.obric.memorydata.awareness.impl.gate.b) ZeusTransformUtils.preCheckCast(r16.getValue(), com.obric.memorydata.awareness.impl.gate.b.class, "com.obric.memorydata.plugin")).b());
        a(r17, r18);
        r12.put(r15, r18);
        goto L8
    L10:
        Map<com.obric.memorydata.awareness.impl.gate.c, Set<String>> r19 = a(r3, r12);
        this.d = new c(r3, r12, r19, SetsKt.minus(SetsKt.plus(r0.d(), (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), (Iterable) ZeusTransformUtils.preCheckCast(r3.keySet(), Iterable.class, "com.obric.memorydata.plugin")));
        this.f8670b.a(r19.keySet(), new $$Lambda$a$qJE6n3PPYX2vcRu5DC58XZVuQk(this));
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return a(r2, this.d);
    }

    public final boolean a(String r6, AwarenessEventTriggerType r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r7, "type");
        Intrinsics.checkNotNullParameter(r8, ActivityLifecycle.NAME);
        c r0 = this.d;
        if (a(r6, r0) == true) goto L5;
        return false;
    L5:
        com.obric.memorydata.awareness.impl.c r1 = new com.obric.memorydata.awareness.impl.c(r7, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r0.b().get(r6), Map.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9.get(r1), e.class, "com.obric.memorydata.plugin");
    L10:
        if (r10 == null) goto L33;
        if (Intrinsics.areEqual(r10, e.b.f8678a) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, e.C0442a.class) == false) goto L18;
        return false;
    L18:
        if (ZeusTransformUtils.instanceOf(r10, e.c.class) == false) goto L31;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(((e.c) ZeusTransformUtils.preCheckCast(r10, e.c.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L22;
    L24:
        Iterator r12 = r11.iterator();
    L26:
        if (r12.hasNext() == false) goto L39;
        if (a((d) ZeusTransformUtils.preCheckCast(r12.next(), d.class, "com.obric.memorydata.plugin")) == false) goto L26;
    L39:
        return false;
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L24;
        return false;
    L31:
        throw new NoWhenBranchMatchedException();
    L33:
        return true;
    L8:
        r10 = null;
        goto L10
    }
}
