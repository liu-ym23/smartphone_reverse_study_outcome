package com.obric.memorydata.awareness.impl.location;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.fence.GeoFence;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002hiB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005J\u001d\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/JG\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00105\u001a\u0004\u0018\u000106¢\u0006\u0002\u00107JE\u00108\u001a\u00020'2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020*2\b\u00104\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0000¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010\u0005J\u0006\u0010=\u001a\u00020'J\u0014\u0010>\u001a\u00020'2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@J\"\u0010A\u001a\u00020'2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050@J4\u0010C\u001a\u00020'2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0E2\u0006\u0010G\u001a\u00020*2\u0016\b\u0002\u0010H\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'\u0018\u00010IJ?\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050K2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010L\u001a\u00020*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bMJ!\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050K2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0005H\u0000¢\u0006\u0002\bSJQ\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010K2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020*2\b\u00104\u001a\u0004\u0018\u00010\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0000¢\u0006\u0004\bU\u0010VJ+\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010K2\u0006\u0010)\u001a\u00020*2\b\u0010<\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\bXJ'\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010K2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@H\u0000¢\u0006\u0002\bZJ7\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010K2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00050@2\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00050@H\u0000¢\u0006\u0002\b\\J/\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010K2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020F0E2\u0006\u0010G\u001a\u00020*H\u0000¢\u0006\u0002\b^J4\u0010_\u001a\u00020'2\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010K2\u0016\b\u0002\u0010H\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'\u0018\u00010IH\u0002J\u001c\u0010a\u001a\u00020\u00052\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010KH\u0002J\f\u0010b\u001a\u00020\u0001*\u00020\u0001H\u0002J\u0018\u0010c\u001a\u00020*2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0018\u0010d\u001a\u00020*2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u0010e\u001a\u00020'2\u0006\u0010f\u001a\u00020\u0005H\u0002J\u0010\u0010g\u001a\u00020'2\u0006\u0010f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationContextInputDispatcher;", "", "<init>", "()V", "TAG", "", "CONTROLLER_PACKAGE_NAME", "KEY_INPUT_TYPE", "KEY_REPORT_TYPE", "KEY_FENCE_ID", "KEY_BOUNDARY", "KEY_ACTION", "KEY_INSIDE_FENCE_IDS", "KEY_INSIDE_OUTER_BOUNDARY_FENCE_IDS", "KEY_SNAPSHOT_COMPLETE", "KEY_INSIDE_AOIS", "KEY_AOI_ID", "KEY_AOI_NAME", "KEY_AOI_TYPE", "KEY_STATION_NAME", "KEY_BOUND_LOCATION_TYPE", "KEY_ENTERED_AT_MS", "KEY_SOURCE_TIMESTAMP_MS", "INPUT_TYPE_FENCE", "INPUT_TYPE_FENCE_REMOVED", "INPUT_TYPE_CURRENT_GEOFENCES_SNAPSHOT", "INPUT_TYPE_HOME_COMPANY_BOUNDARY_SNAPSHOT", "INPUT_TYPE_AOI_SNAPSHOT", "INPUT_TYPE_AOI_CHANGE", "INPUT_TYPE_SUBWAY_TRANSITION", "INPUT_TYPE_LOCATION_UNAVAILABLE", "REPORT_TYPE_TRANSITION", "REPORT_TYPE_STATE_SYNC", "ACTION_ENTER", "ACTION_EXIT", "HOME_FENCE_ID", "HOME_FENCE_PREFIX", "COMPANY_FENCE_ID", "dispatchFenceTransition", "", "fenceId", "isEnter", "", "boundary", "dispatchFenceStateSync", "dispatchFenceStateSync$awareness_obricRelease", "dispatchFenceRemoved", "dispatchFenceRemoved$awareness_obricRelease", "dispatchAoiTransition", "locationType", "aoiId", "aoiName", "boundLocationType", "sourceTimestampMs", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "dispatchAoiTransitionNow", "dispatchAoiTransitionNow$awareness_obricRelease", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;)V", "dispatchSubwayTransition", "stationName", "dispatchLocationUnavailable", "dispatchHomeCompanyBoundarySnapshot", "insideFenceIds", "", "dispatchCurrentGeoFencesSnapshot", "insideOuterBoundaryFenceIds", "dispatchAoiSnapshot", "states", "", "Lcom/obric/memorydata/awareness/impl/location/LocationContextInputDispatcher$AoiSnapshotState;", "complete", "onFinished", "Lkotlin/Function1;", "buildFenceInput", "", "stateSync", "buildFenceInput$awareness_obricRelease", "buildFenceRemovedInput", "buildFenceRemovedInput$awareness_obricRelease", "aoiSnapshotKey", "aoiSnapshotKey$awareness_obricRelease", "isHomeCompanyFenceId", "isHomeCompanyFenceId$awareness_obricRelease", "buildAoiInput", "buildAoiInput$awareness_obricRelease", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;)Ljava/util/Map;", "buildSubwayTransitionInput", "buildSubwayTransitionInput$awareness_obricRelease", "buildHomeCompanyBoundarySnapshotInput", "buildHomeCompanyBoundarySnapshotInput$awareness_obricRelease", "buildCurrentGeoFencesSnapshotInput", "buildCurrentGeoFencesSnapshotInput$awareness_obricRelease", "buildAoiSnapshotInput", "buildAoiSnapshotInput$awareness_obricRelease", "enqueue", "input", "buildLogSummary", "toJsonValue", "isValidAoiIdentity", "isValidAoiTransitionIdentity", "info", "message", "debug", "AoiSnapshotState", "TaskCompletionCallback", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8730a = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationContextInputDispatcher$AoiSnapshotState;", "", "locationType", "", "aoiId", "aoiName", "boundLocationType", "enteredAtMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getLocationType", "()Ljava/lang/String;", "getAoiId", "getAoiName", "getBoundLocationType", "getEnteredAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/memorydata/awareness/impl/location/LocationContextInputDispatcher$AoiSnapshotState;", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8732b;
        private final String c;
        private final String d;
        private final Long e;

        public a(String r2, String r3, String r4, String r5, Long r6) {
            Intrinsics.checkNotNullParameter(r2, "locationType");
            Intrinsics.checkNotNullParameter(r3, "aoiId");
            this.f8731a = r2;
            this.f8732b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final String a() {
            return this.f8731a;
        }

        public final String b() {
            return this.f8732b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final Long e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8731a, r6.f8731a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8732b, r6.f8732b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f8731a.hashCode() * 31) + this.f8732b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            Long r8 = this.e;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AoiSnapshotState(locationType=" + this.f8731a + ", aoiId=" + this.f8732b + ", aoiName=" + this.c + ", boundLocationType=" + this.d + ", enteredAtMs=" + this.e + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.impl.location.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationContextInputDispatcher$TaskCompletionCallback;", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "summary", "", "onFinished", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "callbackDelivered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onChanged", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0445b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1<Boolean, Unit> f8734b;
        private final AtomicBoolean c;

        public C0445b(String r3, Function1<? super Boolean, Unit> r4) {
            Function1<Boolean, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "summary");
            Intrinsics.checkNotNullParameter(r5, "onFinished");
            this.f8733a = r3;
            this.f8734b = r5;
            this.c = new AtomicBoolean(false);
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r9) {
            Intrinsics.checkNotNullParameter(r9, "taskInfo");
            if (r9.c().isFinished() == false) goto L15;
            boolean r1 = false;
            if (this.c.compareAndSet(false, true) == true) goto L8;
            return;
        L8:
            if (r9.c() != TaskInfo.State.SUCCEEDED) goto L10;
            r1 = true;
        L10:
            if (r1 == false) goto L12;
            b.a(b.f8730a, "位置中控输入执行完成：" + this.f8733a);
        L13:
            this.f8734b.invoke(Boolean.valueOf(r1));
            return;
        L12:
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextInputDispatcher", "Location controller input failed: summary=" + this.f8733a + ", state=" + r9.c(), null, 4, null);
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {
        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            Long r3 = ((a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin")).e();
            if (r3 == null) goto L5;
            Object r6 = ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin");
        L6:
            Comparable r7 = (Comparable) r6;
            Long r8 = ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).e();
            if (r8 == null) goto L9;
            Object r9 = ZeusTransformUtils.preCheckCast(r8, Comparable.class, "com.obric.memorydata.plugin");
        L11:
            return ComparisonsKt.compareValues(r7, (Comparable) r9);
        L9:
            r9 = ZeusTransformUtils.preCheckCast(0L, Comparable.class, "com.obric.memorydata.plugin");
            goto L11
        L5:
            r6 = ZeusTransformUtils.preCheckCast(0L, Comparable.class, "com.obric.memorydata.plugin");
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f8735a;

        public d(Comparator r3) {
            this.f8735a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f8735a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).b(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f8730a = new b();
    }

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object] */
    private final Object a(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == false) goto L18;
        ?? r4 = new JSONObject();
        Iterator r6 = ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L28;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L6;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        Object r8 = f8730a.a(r3);
        if (r8 == null) goto L14;
    L15:
        r4.put(r7, r8);
    L14:
        r8 = JSONObject.NULL;
    L28:
        return r4;
    L18:
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == false) goto L37;
        r4 = new JSONArray();
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r9.hasNext() == false) goto L28;
        Object r0 = r9.next();
        if (r0 == null) goto L26;
        Object r10 = f8730a.a(r0);
        if (r10 == null) goto L26;
    L27:
        r4.put(r10);
    L26:
        r10 = JSONObject.NULL;
        goto L27
    L37:
        return r5;
    }

    private final String a(Map<String, ? extends Object> r11) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        Object r12 = r10.get("input_type");
        Map r1 = null;
        Collection r2 = null;
        Collection r3 = null;
        if (r12 == null) goto L5;
        String r13 = r12.toString();
    L6:
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        int r5 = 0;
        List r4 = CollectionsKt.mutableListOf(new String[]{"type=" + r13});
        Object r6 = r10.get("report_type");
        if (r6 == null) goto L11;
        r4.add("report=" + r6);
    L11:
        Object r7 = r10.get("action");
        if (r7 == null) goto L15;
        r4.add("action=" + r7);
    L15:
        switch(r13.hashCode()) {
            case -1798903067: goto L61;
            case -1040672888: goto L52;
            case -987597196: goto L43;
            case -781418474: goto L28;
            case 232190871: goto L18;
            default: goto L69;
        };
    L18:
        if (r13.equals("home_company_boundary_snapshot") == false) goto L69;
        Object r14 = r10.get("inside_fence_ids");
        if (ZeusTransformUtils.instanceOf(r14, Collection.class) == false) goto L23;
        r2 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin");
    L23:
        if (r2 == null) goto L25;
        r5 = r2.size();
    L25:
        StringBuilder r15 = new StringBuilder().append("insideCount=");
    L26:
        StringBuilder r16 = r15.append(r5);
    L67:
        r4.add(r16.toString());
        goto L69
    L28:
        if (r13.equals("current_geofences_snapshot") == false) goto L69;
        Object r17 = r10.get("inside_fence_ids");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == false) goto L32;
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin");
    L33:
        if (r18 == null) goto L35;
        int r19 = r18.size();
    L36:
        r4.add("insideCount=" + r19);
        Object r110 = r10.get("inside_outer_boundary_fence_ids");
        if (ZeusTransformUtils.instanceOf(r110, Collection.class) == false) goto L39;
        r3 = (Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin");
    L39:
        if (r3 == null) goto L41;
        r5 = r3.size();
    L41:
        r15 = new StringBuilder().append("outerInsideCount=");
        goto L26
    L35:
        r19 = 0;
        goto L36
    L32:
        r18 = null;
        goto L33
    L43:
        if (r13.equals("aoi_change") == false) goto L69;
        Object r111 = r10.get("aoi_type");
        if (r111 == null) goto L48;
        r4.add("aoiType=" + r111);
    L48:
        Object r112 = r10.get("bound_location_type");
        if (r112 == null) goto L69;
        StringBuilder r113 = new StringBuilder();
        String r8 = "boundType=";
    L66:
        r16 = r113.append(r8).append(r112);
        goto L67
    L52:
        if (r13.equals("aoi_snapshot") == false) goto L69;
        Object r114 = r10.get("inside_aois");
        if (ZeusTransformUtils.instanceOf(r114, Map.class) == false) goto L57;
        r1 = (Map) ZeusTransformUtils.preCheckCast(r114, Map.class, "com.obric.memorydata.plugin");
    L57:
        if (r1 == null) goto L59;
        r5 = r1.size();
    L59:
        r4.add("insideCount=" + r5);
        r16 = new StringBuilder().append("complete=").append(Intrinsics.areEqual(r10.get("snapshot_complete"), true));
        goto L67
    L61:
        if (r13.equals("subway_transition") == false) goto L69;
        r112 = r10.get("station_name");
        if (r112 == null) goto L69;
        r113 = new StringBuilder();
        r8 = "stationName=";
    L69:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L5:
        r13 = null;
        goto L6
    }

    public static /* synthetic */ Map a(b r0, String r1, boolean r2, boolean r3, String r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 8) == 0) goto L9;
        r4 = null;
    L9:
        return r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(b r0, String r1) {
        r0.d(r1);
    }

    public static /* synthetic */ void a(b r0, String r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(b r1, Map r2, Function1 r3, int r4, Object r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        r1.a(r6, r7);
    }

    private final void a(Map<String, ? extends Object> r7, Function1<? super Boolean, Unit> r8) {
        Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        if (r9.isEmpty() == false) goto L7;
        if (r10 == null) goto L17;
        r10.invoke(false);
        return;
    L17:
        return;
    L7:
        String r0 = a(r9);
        e("准备将位置中控输入加入队列：" + r0 + "，详细参数=" + r9);
        JSONObject r2 = new JSONObject();
        Iterator<Map.Entry<String, ? extends Object>> r11 = r9.entrySet().iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r2.put((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin"), f8730a.a(r3.getValue()));
        goto L9
    L11:
        TaskRequest.Builder r12 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("location_context_controller").setInputParam(r2), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L14;
        TaskRequest.Builder r13 = (TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r12.setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new C0445b(r0, r10), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin");
    L14:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(r12.build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        d("位置中控输入已入队：" + r0);
    }

    private final boolean a(String r2, String r3) {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        return true;
    }

    private final boolean b(String r1, String r2) {
        return a(r1, r2);
    }

    private final void d(String r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextInputDispatcher", r7, false, 4, null);
    }

    private final void e(String r2) {
        RunLog.INSTANCE.debug("LocationContextInputDispatcher", r2);
    }

    public final Map<String, String> a(String r6, boolean r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "fenceId");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        boolean r1 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == true) goto L8;
        Pair[] r11 = new Pair[4];
        r11[0] = TuplesKt.to("input_type", GeoFence.BUNDLE_KEY_FENCE);
        if (r8 == false) goto L12;
        String r12 = "state_sync";
    L13:
        r11[1] = TuplesKt.to("report_type", r12);
        r11[2] = TuplesKt.to("fence_id", r5);
        if (r7 == false) goto L16;
        String r13 = "enter";
    L17:
        r11[3] = TuplesKt.to("action", r13);
        LinkedHashMap r14 = MapsKt.linkedMapOf(r11);
        if (r9 == null) goto L31;
        String r15 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r15 == null) goto L31;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L25;
        r1 = false;
    L25:
        if (r1 == true) goto L28;
        r15 = null;
    L28:
        if (r15 == null) goto L31;
        r14.put("boundary", r15);
    L31:
        return (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin");
    L16:
        r13 = "exit";
        goto L17
    L12:
        r12 = "transition";
        goto L13
    L8:
        return MapsKt.emptyMap();
    L5:
        r10 = false;
        goto L6
    }

    public final Map<String, Object> a(List<a> r17, boolean r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "states");
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new c(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r3 = false;
        boolean r4 = false;
    L3:
        boolean r6 = true;
        if (r1.hasNext() == false) goto L38;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (f8730a.a(r8, r7) == false) goto L7;
        if (r2.containsKey(r7) == false) goto L11;
        r4 = true;
    L11:
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin");
        LinkedHashMap r10 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("aoi_type", r8)});
        String r11 = r5.c();
        Long r12 = null;
        if (r11 != null) goto L14;
    L19:
        String r13 = r5.d();
        if (r13 != null) goto L22;
    L27:
        Long r14 = r5.e();
        if (r14 != null) goto L30;
    L37:
        r9.put(r7, r10);
        goto L3
    L30:
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L33;
        r6 = false;
    L33:
        if (r6 == false) goto L35;
        r12 = r14;
    L35:
        if (r12 == null) goto L37;
        r10.put("entered_at_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).longValue()));
        goto L37
    L22:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L25;
        r13 = null;
    L25:
        if (r13 == null) goto L27;
        r10.put("bound_location_type", r13);
        goto L27
    L14:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L17;
        r11 = null;
    L17:
        if (r11 == null) goto L19;
        r10.put("aoi_name", r11);
        goto L19
    L7:
        r4 = true;
        goto L3
    L38:
        Pair[] r15 = new Pair[3];
        r15[0] = TuplesKt.to("input_type", "aoi_snapshot");
        if (r18 == false) goto L42;
        if (r4 == true) goto L42;
        r3 = true;
    L42:
        r15[1] = TuplesKt.to("snapshot_complete", Boolean.valueOf(r3));
        r15[2] = TuplesKt.to("inside_aois", r2);
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.linkedMapOf(r15), Map.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        a(this, MapsKt.mapOf(TuplesKt.to("input_type", "location_unavailable")), null, 2, null);
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "fenceId");
        a(this, b(r3), null, 2, null);
    }

    public final void a(String r2, String r3, String r4, boolean r5, String r6, Long r7) {
        Intrinsics.checkNotNullParameter(r2, "locationType");
        Intrinsics.checkNotNullParameter(r3, "aoiId");
        a(this, b(r2, r3, r4, r5, r6, r7), null, 2, null);
    }

    public final void a(String r8, String r9, boolean r10, String r11, String r12, Long r13) {
        Intrinsics.checkNotNullParameter(r8, "locationType");
        Intrinsics.checkNotNullParameter(r9, "aoiId");
        if (b(r8, r9) == true) goto L5;
        return;
    L5:
        com.obric.memorydata.awareness.impl.location.c.f8736a.a(r8, r9, r11, r10, r12, r13);
    }

    public final void a(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "fenceId");
        a(this, a(this, r9, r10, true, null, 8, null), null, 2, null);
    }

    public final void a(String r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "fenceId");
        a(this, a(this, r9, r10, false, r11, 4, null), null, 2, null);
    }

    public final void a(Collection<String> r3) {
        Collection<String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "insideFenceIds");
        a(this, b(r4), null, 2, null);
    }

    public final void a(Collection<String> r3, Collection<String> r4) {
        Collection<String> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Collection<String> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "insideFenceIds");
        Intrinsics.checkNotNullParameter(r6, "insideOuterBoundaryFenceIds");
        a(this, b(r5, r6), null, 2, null);
    }

    public final void a(List<a> r3, boolean r4, Function1<? super Boolean, Unit> r5) {
        List<a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Function1<? super Boolean, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "states");
        a(a(r6, r4), r7);
    }

    public final void a(boolean r2, String r3) {
        a(this, b(r2, r3), null, 2, null);
    }

    public final Map<String, String> b(String r6) {
        Intrinsics.checkNotNullParameter(r6, "fenceId");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L10;
        return MapsKt.emptyMap();
    L10:
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("input_type", "fence_removed"), TuplesKt.to("fence_id", r5)}), Map.class, "com.obric.memorydata.plugin");
    L5:
        r7 = false;
        goto L6
    }

    public final Map<String, Object> b(String r6, String r7, String r8, boolean r9, String r10, Long r11) {
        Intrinsics.checkNotNullParameter(r6, "locationType");
        Intrinsics.checkNotNullParameter(r7, "aoiId");
        String r12 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        String r13 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (b(r12, r13) == false) goto L5;
        Pair[] r5 = new Pair[5];
        boolean r2 = false;
        r5[0] = TuplesKt.to("input_type", "aoi_change");
        r5[1] = TuplesKt.to("report_type", "transition");
        if (r9 == false) goto L9;
        String r14 = "enter";
    L10:
        r5[2] = TuplesKt.to("action", r14);
        r5[3] = TuplesKt.to("aoi_id", r13);
        r5[4] = TuplesKt.to("aoi_type", r12);
        LinkedHashMap r15 = MapsKt.linkedMapOf(r5);
        if (r8 != null) goto L13;
    L18:
        if (r10 != null) goto L20;
    L25:
        if (r11 == null) goto L35;
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L29;
        r2 = true;
    L29:
        if (r2 == true) goto L32;
        r11 = null;
    L32:
        if (r11 == null) goto L35;
        r15.put("source_timestamp_ms", Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.memorydata.plugin")).longValue()));
    L35:
        return (Map) ZeusTransformUtils.preCheckCast(r15, Map.class, "com.obric.memorydata.plugin");
    L20:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L23;
        r10 = null;
    L23:
        if (r10 == null) goto L25;
        r15.put("bound_location_type", r10);
        goto L25
    L13:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L16;
        r8 = null;
    L16:
        if (r8 == null) goto L18;
        r15.put("aoi_name", r8);
        goto L18
    L9:
        r14 = "exit";
        goto L10
    L5:
        return MapsKt.emptyMap();
    }

    public final Map<String, Object> b(Collection<String> r5) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "insideFenceIds");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (f8730a.c(r1) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L4;
        r7.add(r1);
        goto L4
    L11:
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("input_type", "home_company_boundary_snapshot"), TuplesKt.to("inside_fence_ids", CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")))}), Map.class, "com.obric.memorydata.plugin");
    }

    public final Map<String, Object> b(Collection<String> r4, Collection<String> r5) {
        Collection r3 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "insideFenceIds");
        Intrinsics.checkNotNullParameter(r6, "insideOuterBoundaryFenceIds");
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("input_type", "current_geofences_snapshot"), TuplesKt.to("inside_fence_ids", CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"))), TuplesKt.to("inside_outer_boundary_fence_ids", CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")))}), Map.class, "com.obric.memorydata.plugin");
    }

    public final Map<String, Object> b(boolean r4, String r5) {
        Pair[] r3 = new Pair[2];
        boolean r1 = false;
        r3[0] = TuplesKt.to("input_type", "subway_transition");
        if (r4 == false) goto L5;
        String r6 = "enter";
    L6:
        r3[1] = TuplesKt.to("action", r6);
        LinkedHashMap r7 = MapsKt.linkedMapOf(r3);
        if (r5 == null) goto L19;
        String r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r8 == null) goto L19;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L13;
        r1 = true;
    L13:
        if (r1 == true) goto L16;
        r8 = null;
    L16:
        if (r8 == null) goto L19;
        r7.put("station_name", r8);
    L19:
        return (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin");
    L5:
        r6 = "exit";
        goto L6
    }

    public final boolean c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "fenceId");
        if (Intrinsics.areEqual(r4, "home_fence") == false) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.startsWith$default(r4, "home_fence_", false, 2, null) == true) goto L8;
        if (Intrinsics.areEqual(r4, "company_fence") == true) goto L8;
        return false;
    }
}
