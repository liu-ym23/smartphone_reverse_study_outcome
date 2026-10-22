package com.obric.memorydata.awareness.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005+,-./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J2\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001dH\u0002J:\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\rH\u0002J\"\u0010#\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002J \u0010&\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010$\u001a\u00020'2\u0006\u0010%\u001a\u00020\u0005H\u0002J \u0010(\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0005H\u0002J \u0010)\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010$\u001a\u00020*2\u0006\u0010%\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureDurationManager;", "", "<init>", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sourceRegistrations", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$Registration;", "watcherStates", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherKey;", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherState;", "featureListeners", "Lcom/obric/memorydata/awareness/api/EventListener;", "syncSource", "", "sourceKey", "registrations", "removeSource", "rebuildWatchers", "refreshWatcherFromCurrentFeature", "watcher", "handleFeatureChanged", "featureName", "newValue", "extras", "", "handleWatcherStateLocked", "fromRefresh", "", "triggerIfStillMatched", "key", "matchesTargetValue", "currentValue", "targetFeatureValue", "compareIntegral", "", "compareBoolean", "compareFloating", "", "TriggerInfo", "Registration", "WatcherKey", "WatcherState", "CallbackEntry", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f8704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f8705b = null;
    private static final ConcurrentHashMap<String, List<b>> c = null;
    private static final ConcurrentHashMap<d, e> d = null;
    private static final ConcurrentHashMap<String, com.obric.memorydata.awareness.api.a> e = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$CallbackEntry;", "", "oneShot", "", "onTriggered", "Lkotlin/Function1;", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$TriggerInfo;", "", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "getOneShot", "()Z", "getOnTriggered", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f8706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1<c, Unit> f8707b;

        public a(boolean r3, Function1<? super c, Unit> r4) {
            Function1<c, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "onTriggered");
            this.f8706a = r3;
            this.f8707b = r5;
        }

        public final boolean a() {
            return this.f8706a;
        }

        public final Function1<c, Unit> b() {
            return this.f8707b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f8706a == r6.f8706a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8707b, r6.f8707b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f8706a) * 31) + this.f8707b.hashCode();
        }

        public String toString() {
            return "CallbackEntry(oneShot=" + this.f8706a + ", onTriggered=" + this.f8707b + ')';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$Registration;", "", "featureName", "", "targetFeatureValue", "durationSec", "", "oneShot", "", "onTriggered", "Lkotlin/Function1;", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$TriggerInfo;", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZLkotlin/jvm/functions/Function1;)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "getOneShot", "()Z", "getOnTriggered", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8709b;
        private final long c;
        private final boolean d;
        private final Function1<c, Unit> e;

        public b(String r3, String r4, long r5, boolean r7, Function1<? super c, Unit> r8) {
            Function1<c, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "featureName");
            Intrinsics.checkNotNullParameter(r4, "targetFeatureValue");
            Intrinsics.checkNotNullParameter(r9, "onTriggered");
            this.f8708a = r3;
            this.f8709b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r9;
        }

        public final String a() {
            return this.f8708a;
        }

        public final String b() {
            return this.f8709b;
        }

        public final long c() {
            return this.c;
        }

        public final boolean d() {
            return this.d;
        }

        public final Function1<c, Unit> e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8708a, r10.f8708a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8709b, r10.f8709b) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f8708a.hashCode() * 31) + this.f8709b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "Registration(featureName=" + this.f8708a + ", targetFeatureValue=" + this.f8709b + ", durationSec=" + this.c + ", oneShot=" + this.d + ", onTriggered=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$TriggerInfo;", "", "featureName", "", "targetFeatureValue", "durationSec", "", "currentFeatureValue", "extras", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;Ljava/util/Map;)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "getCurrentFeatureValue", "()Ljava/lang/Object;", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8711b;
        private final long c;
        private final Object d;
        private final Map<String, Object> e;

        public c(String r3, String r4, long r5, Object r7, Map<String, ? extends Object> r8) {
            Map<String, Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "featureName");
            Intrinsics.checkNotNullParameter(r4, "targetFeatureValue");
            this.f8710a = r3;
            this.f8711b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r9;
        }

        public final String a() {
            return this.f8710a;
        }

        public final String b() {
            return this.f8711b;
        }

        public final long c() {
            return this.c;
        }

        public final Object d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8710a, r10.f8710a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8711b, r10.f8711b) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f8710a.hashCode() * 31) + this.f8711b.hashCode()) * 31) + Long.hashCode(this.c)) * 31;
            Object r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Map<String, Object> r5 = this.e;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "TriggerInfo(featureName=" + this.f8710a + ", targetFeatureValue=" + this.f8711b + ", durationSec=" + this.c + ", currentFeatureValue=" + this.d + ", extras=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherKey;", "", "featureName", "", "targetFeatureValue", "durationSec", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getFeatureName", "()Ljava/lang/String;", "getTargetFeatureValue", "getDurationSec", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8713b;
        private final long c;

        public d(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "featureName");
            Intrinsics.checkNotNullParameter(r3, "targetFeatureValue");
            this.f8712a = r2;
            this.f8713b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f8712a;
        }

        public final String b() {
            return this.f8713b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, d.class) == true) goto L8;
            return false;
        L8:
            d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8712a, r8.f8712a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8713b, r8.f8713b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f8712a.hashCode() * 31) + this.f8713b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "WatcherKey(featureName=" + this.f8712a + ", targetFeatureValue=" + this.f8713b + ", durationSec=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherState;", "", "key", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherKey;", "callbacks", "", "Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$CallbackEntry;", "<init>", "(Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherKey;Ljava/util/List;)V", "getKey", "()Lcom/obric/memorydata/awareness/impl/FeatureDurationManager$WatcherKey;", "activeJob", "Lkotlinx/coroutines/Job;", "getActiveJob", "()Lkotlinx/coroutines/Job;", "setActiveJob", "(Lkotlinx/coroutines/Job;)V", "currentFeatureValue", "getCurrentFeatureValue", "()Ljava/lang/Object;", "setCurrentFeatureValue", "(Ljava/lang/Object;)V", "currentExtras", "", "", "getCurrentExtras", "()Ljava/util/Map;", "setCurrentExtras", "(Ljava/util/Map;)V", "inTargetState", "", "getInTargetState", "()Z", "setInTargetState", "(Z)V", "hasTriggered", "getHasTriggered", "setHasTriggered", "getCallbacks", "()Ljava/util/List;", "setCallbacks", "(Ljava/util/List;)V", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f8714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile bx f8715b;
        private volatile Object c;
        private volatile Map<String, ? extends Object> d;
        private volatile boolean e;
        private volatile boolean f;
        private volatile List<a> g;

        public e(d r3, List<a> r4) {
            List<a> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r5, "callbacks");
            this.f8714a = r3;
            this.g = r5;
        }

        public final d a() {
            return this.f8714a;
        }

        public final void a(Object r1) {
            this.c = r1;
        }

        public final void a(List<a> r3) {
            List<a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.g = r4;
        }

        public final void a(Map<String, ? extends Object> r3) {
            this.d = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        }

        public final void a(bx r3) {
            this.f8715b = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        }

        public final void a(boolean r1) {
            this.e = r1;
        }

        public final bx b() {
            return this.f8715b;
        }

        public final void b(boolean r1) {
            this.f = r1;
        }

        public final Object c() {
            return this.c;
        }

        public final Map<String, Object> d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public final boolean f() {
            return this.f;
        }

        public final List<a> g() {
            return this.g;
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016J<\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/awareness/impl/FeatureDurationManager$rebuildWatchers$4$listener$1", "Lcom/obric/memorydata/awareness/api/EventListener;", "observable", "", "onEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "onFeatureChanged", "feature", "oldValue", "newValue", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements com.obric.memorydata.awareness.api.a {
        f() {
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
            Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "feature");
            k.a(k.f8704a, r1, r3, r0);
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void a(String r2, Map<String, ? extends Object> r3) {
            Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "eventName");
        }

        @Override // com.obric.memorydata.awareness.api.a
        public boolean a() {
            return false;
        }

        @Override // com.obric.memorydata.awareness.api.a
        public void b(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
            com.obric.memorydata.awareness.api.a.C0430a.a(this, r3, r4, r5, (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f8704a = new k();
        f8705b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
    }

    private k() {
    }

    private final synchronized void a() {
        monitor-enter(this);
        LinkedHashMap r0 = new LinkedHashMap();     // Catch: Throwable -> L43
        Collection<List<b>> r1 = c.values();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r1, "<get-values>(...)");     // Catch: Throwable -> L43
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.flatten((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L43
    L5:
        if (r2.hasNext() == false) goto L10;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        d r4 = new d(r3.a(), r3.b(), r3.c());     // Catch: Throwable -> L43
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        Object r6 = r5.get(r4);     // Catch: Throwable -> L43
        if (r6 != null) goto L9;
        r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        r5.put(r4, r6);     // Catch: Throwable -> L43
    L9:
        ((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")).add(new a(r3.d(), r3.e()));     // Catch: Throwable -> L43
        goto L5
    L10:
        Set<d> r7 = d.keySet();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r7, "<get-keys>(...)");     // Catch: Throwable -> L43
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        Set r9 = r0.keySet();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r9, "<get-keys>(...)");     // Catch: Throwable -> L43
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.subtract(r8, (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L43
    L12:
        if (r10.hasNext() == false) goto L19;
        d r11 = (d) ZeusTransformUtils.preCheckCast(r10.next(), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        e r12 = (e) ZeusTransformUtils.preCheckCast(d.remove(r11), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r12 == null) goto L12;
        bx r13 = r12.b();     // Catch: Throwable -> L43
        if (r13 == null) goto L18;
        bx.a.a(r13, null, 1, null);     // Catch: Throwable -> L43
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "remove watcher feature=" + r11.a() + ", target=" + r11.b() + ", duration=" + r11.c(), false, 4, null);     // Catch: Throwable -> L43
        goto L12
    L19:
        Iterator r14 = ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L43
    L21:
        if (r14.hasNext() == false) goto L26;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        d r16 = (d) ZeusTransformUtils.preCheckCast(r15.getKey(), d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        List r17 = (List) ZeusTransformUtils.preCheckCast(r15.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        ConcurrentHashMap<d, e> r18 = d;     // Catch: Throwable -> L43
        e r19 = (e) ZeusTransformUtils.preCheckCast(r18.get(r16), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r19 == null) goto L24;
        r19.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L43
        goto L21
    L24:
        e r20 = new e(r16, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L43
        ((Map) ZeusTransformUtils.preCheckCast(r18, Map.class, "com.obric.memorydata.plugin")).put(r16, r20);     // Catch: Throwable -> L43
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "add watcher feature=" + r16.a() + ", target=" + r16.b() + ", duration=" + r16.c(), false, 4, null);     // Catch: Throwable -> L43
        f8704a.a(r20);     // Catch: Throwable -> L43
        goto L21
    L26:
        Set<d> r21 = d.keySet();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r21, "<get-keys>(...)");     // Catch: Throwable -> L43
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        Collection r23 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        Iterator r24 = r22.iterator();     // Catch: Throwable -> L43
    L28:
        if (r24.hasNext() == false) goto L30;
        r23.add(((d) ZeusTransformUtils.preCheckCast(r24.next(), d.class, "com.obric.memorydata.plugin")).a());     // Catch: Throwable -> L43
        goto L28
    L30:
        Set r25 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r23, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        Set<String> r26 = e.keySet();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullExpressionValue(r26, "<get-keys>(...)");     // Catch: Throwable -> L43
        Set r27 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r26, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        Set r28 = CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        Set r29 = CollectionsKt.subtract((Iterable) ZeusTransformUtils.preCheckCast(r27, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L43
    L32:
        if (r30.hasNext() == false) goto L34;
        String r31 = (String) ZeusTransformUtils.preCheckCast(r30.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        f r32 = new f();     // Catch: Throwable -> L43
        ((Map) ZeusTransformUtils.preCheckCast(e, Map.class, "com.obric.memorydata.plugin")).put(r31, r32);     // Catch: Throwable -> L43
        AwarenessManager.INSTANCE.registerAwarenessEvent(r31, (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(r32, com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "register feature listener for duration feature=" + r31, false, 4, null);     // Catch: Throwable -> L43
        goto L32
    L34:
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(r29, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L43
    L35:
        if (r33.hasNext() == false) goto L41;
        String r34 = (String) ZeusTransformUtils.preCheckCast(r33.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        com.obric.memorydata.awareness.api.a r35 = (com.obric.memorydata.awareness.api.a) ZeusTransformUtils.preCheckCast(e.remove(r34), com.obric.memorydata.awareness.api.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r35 == null) goto L35;
        AwarenessManager r36 = AwarenessManager.INSTANCE;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r34);     // Catch: Throwable -> L43
        r36.unregisterAwarenessEvent(r34, r35);     // Catch: Throwable -> L43
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "unregister feature listener for duration feature=" + r34, false, 4, null);     // Catch: Throwable -> L43
        goto L35
    L41:
        monitor-exit(this);
        return;
    L43:
        th = move-exception;
        throw th;
    }

    private final void a(d r19) {
        monitor-enter(this);
        e r0 = (e) ZeusTransformUtils.preCheckCast(d.get(r19), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        if (r0 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        r0.a(null);     // Catch: Throwable -> L77
        Object r8 = r0.c();     // Catch: Throwable -> L77
        if (r0.e() == true) goto L11;
    L74:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "skip duration trigger feature=" + r19.a() + ", currentValue=" + r8, false, 4, null);     // Catch: Throwable -> L77
        monitor-exit(this);
        return;
    L11:
        if (r0.f() == true) goto L74;
        if (f8704a.a(r19.a(), r8, r19.b()) == false) goto L74;
        r0.b(true);     // Catch: Throwable -> L77
        List r10 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0.g(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L77
        c r11 = new c(r19.a(), r19.b(), r19.c(), r8, r0.d());     // Catch: Throwable -> L77
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L77
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L18;
    L20:
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L77
    L22:
        if (r2.hasNext() == false) goto L26;
        if (((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin")).a() == false) goto L22;
        boolean r3 = true;
    L27:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "trigger duration watcher feature=" + r19.a() + ", target=" + r19.b() + ", duration=" + r19.c(), false, 4, null);     // Catch: Throwable -> L77
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(this);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L31:
        if (r5.hasNext() == false) goto L40;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin");
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L35
        r6.b().invoke(r11);     // Catch: Throwable -> L35
        Object r9 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        Throwable r12 = Result.m1424exceptionOrNullimpl(r9);
        if (r12 == null) goto L31;
        RunLog.INSTANCE.warn("FeatureDurationManager", "duration callback failed for feature=" + r19.a(), r12);
    L35:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L37
    L40:
        if (r3 == false) goto L73;
        monitor-enter(this);
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Map r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r14.size())), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L70
    L44:
        if (r16.hasNext() == false) goto L61;
        Object r17 = r16.next();     // Catch: Throwable -> L70
        Object r18 = ((Map.Entry) ZeusTransformUtils.preCheckCast(r17, Map.Entry.class, "com.obric.memorydata.plugin")).getKey();     // Catch: Throwable -> L70
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r17, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Iterator r22 = r20.iterator();     // Catch: Throwable -> L70
    L47:
        if (r22.hasNext() == false) goto L60;
        Object r23 = r22.next();     // Catch: Throwable -> L70
        b r24 = (b) ZeusTransformUtils.preCheckCast(r23, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if (r24.d() == true) goto L51;
    L57:
        boolean r25 = false;
    L58:
        if (r25 == true) goto L47;
        r21.add(r23);     // Catch: Throwable -> L70
        goto L47
    L51:
        if (Intrinsics.areEqual(r24.a(), r19.a()) == false) goto L57;
        if (Intrinsics.areEqual(r24.b(), r19.b()) == false) goto L57;
        if (r24.c() != r19.c()) goto L57;
        r25 = true;
        goto L58
    L60:
        r15.put(r18, (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L70
        goto L44
    L61:
        LinkedHashMap r26 = new LinkedHashMap();     // Catch: Throwable -> L70
        Iterator r27 = r15.entrySet().iterator();     // Catch: Throwable -> L70
    L63:
        if (r27.hasNext() == false) goto L67;
        Map.Entry r28 = (Map.Entry) ZeusTransformUtils.preCheckCast(r27.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if ((!((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28.getValue(), List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L63;
        r26.put(r28.getKey(), r28.getValue());     // Catch: Throwable -> L70
        goto L63
    L67:
        Map<? extends String, ? extends List<b>> r29 = (Map) ZeusTransformUtils.preCheckCast(r26, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        ConcurrentHashMap<String, List<b>> r30 = c;     // Catch: Throwable -> L70
        r30.clear();     // Catch: Throwable -> L70
        r30.putAll(r29);     // Catch: Throwable -> L70
        f8704a.a();     // Catch: Throwable -> L70
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "oneShot registrations removed for feature=" + r19.a() + ", target=" + r19.b() + ", duration=" + r19.c(), false, 4, null);     // Catch: Throwable -> L70
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L70
        monitor-exit(this);
        return;
    L70:
        th = move-exception;
        throw th;
    L73:
        return;
    L26:
        r3 = false;
        goto L27
    L18:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L20;
    L77:
        th = move-exception;
        throw th;
    }

    private final synchronized void a(e r4) {
        monitor-enter(this);
        a(r4, FeatureManager.INSTANCE.getFeature(r4.a().a()), FeatureManager.INSTANCE.getFeatureExtra(r4.a().a()), true);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final void a(e r10, Object r11, Map<String, ? extends Object> r12, boolean r13) {
        Map<String, ? extends Object> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        r10.a(r11);
        r10.a(r14);
        if (a(r10.a().a(), r11, r10.a().b()) == true) goto L15;
        if (r10.e() == false) goto L7;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "cancel duration watcher feature=" + r10.a().a() + ", target=" + r10.a().b() + ", value=" + r11, false, 4, null);
    L9:
        r10.a(false);
        r10.b(false);
        bx r9 = r10.b();
        if (r9 == null) goto L12;
        bx.a.a(r9, null, 1, null);
    L12:
        r10.a(null);
        return;
    L7:
        if (r10.b() == null) goto L9;
    L15:
        if (r10.e() == false) goto L17;
        return;
    L17:
        r10.a(true);
        r10.b(false);
        bx r15 = r10.b();
        if (r15 == null) goto L20;
        bx.a.a(r15, null, 1, null);
    L20:
        r10.a(kotlinx.coroutines.i.a(f8705b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new FeatureDurationManager$handleWatcherStateLocked$1(r13, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
    }

    public static final /* synthetic */ void a(k r0, d r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(k r2, String r3, Object r4, Map r5) {
        r2.a(r3, r4, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
    }

    private final synchronized void a(String r6, Object r7, Map<String, ? extends Object> r8) {
        monitor-enter(this);
        Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection<e> r0 = d.values();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r0, "<get-values>(...)");     // Catch: Throwable -> L16
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Iterator r3 = r1.iterator();     // Catch: Throwable -> L16
    L5:
        if (r3.hasNext() == false) goto L9;
        Object r4 = r3.next();     // Catch: Throwable -> L16
        if (Intrinsics.areEqual(((e) ZeusTransformUtils.preCheckCast(r4, e.class, "com.obric.memorydata.plugin")).a().a(), r6) == false) goto L5;
        r2.add(r4);     // Catch: Throwable -> L16
        goto L5
    L9:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L16
    L10:
        if (r10.hasNext() == false) goto L14;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r10.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        k r11 = f8704a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L16
        r11.a(r5, r7, r9, false);     // Catch: Throwable -> L16
        goto L10
    L14:
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private final boolean a(String r8, double r9, String r11) {
        Double r7 = StringsKt.toDoubleOrNull(r11);
        if (r7 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "invalid floating target for feature=" + r8 + ", target=" + r11, null, 4, null);
        return false;
    L7:
        if (Math.abs(r9 - r7.doubleValue()) >= 1.0E-6d) goto L10;
        return true;
    L10:
        return false;
    }

    private final boolean a(String r8, long r9, String r11) {
        Long r7 = StringsKt.toLongOrNull(r11);
        if (r7 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "invalid integral target for feature=" + r8 + ", target=" + r11, null, 4, null);
        return false;
    L7:
        if (r9 != r7.longValue()) goto L10;
        return true;
    L10:
        return false;
    }

    private final boolean a(String r3, Object r4, String r5) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L9;
        return Intrinsics.areEqual(r4, r5);
    L9:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == false) goto L14;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).intValue();
    L11:
        long r0 = r6;
    L35:
        return a(r3, r0, r5);
    L14:
        if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L17;
        r0 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue();
        goto L35
    L17:
        if (ZeusTransformUtils.instanceOf(r4, Short.class) == false) goto L20;
        r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).shortValue();
        goto L11
    L20:
        if (ZeusTransformUtils.instanceOf(r4, Byte.class) == false) goto L23;
        r6 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).byteValue();
        goto L11
    L23:
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L26;
        return a(r3, ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r5);
    L26:
        if (ZeusTransformUtils.instanceOf(r4, Float.class) == false) goto L30;
        double r1 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue();
    L37:
        return a(r3, r1, r5);
    L30:
        if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L33;
        r1 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        goto L37
    L33:
        return Intrinsics.areEqual(r4.toString(), r5);
    }

    private final boolean a(String r9, boolean r10, String r11) {
        if (StringsKt.equals(r11, "true", true) == false) goto L6;
        Boolean r8 = true;
    L9:
        if (r8 != null) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FeatureDurationManager", "invalid boolean target for feature=" + r9 + ", target=" + r11, null, 4, null);
        return false;
    L13:
        return Intrinsics.areEqual(Boolean.valueOf(r10), r8);
    L6:
        if (StringsKt.equals(r11, "false", true) == false) goto L8;
        r8 = false;
        goto L9
    L8:
        r8 = null;
        goto L9
    }

    public final synchronized void a(String r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "sourceKey");     // Catch: Throwable -> L8
        if (c.remove(r2) == null) goto L6;
        a();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r4, List<b> r5) {
        monitor-enter(this);
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r4, "sourceKey");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r6, "registrations");     // Catch: Throwable -> L11
        if (r6.isEmpty() == false) goto L8;
        a(r4);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r4, r6);     // Catch: Throwable -> L11
        a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
