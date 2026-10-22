package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingRoute;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.e0;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;
    public Map<String, String> c;
    public Map<String, String> d;
    public Map<String, String> e;
    public Set<String> f;
    public Map<String, String> g;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getNativeLocalBoundMeetingMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getPendingUploadCompletedSyncMeetingIds$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class c extends TypeToken<Set<? extends String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getRecordingAudioPathMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class d extends TypeToken<Map<String, ? extends String>> {
        public d() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$getStandaloneAIInterpretationRecordingIdMap$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class C0028e extends TypeToken<Map<String, ? extends String>> {
        public C0028e() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/ss/android/lark/officesdk/minutes/service/recording/common/core/service/statessync/MmRecordingStatesLocalStorage$loadOfflineRecordingIndex$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class f extends TypeToken<Map<String, Long>> {
        public f() {
        }
    }

    static {
    }

    public final Map<String, Long> x() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl((Map) e0.b(this.a.H().getString("minutes_recording_v2_offline_index_key", null), new f().getType()));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L11;
        lvb.a.b(this.b, "[offlineIndex] load failed, err=" + r3.getMessage());
    L11:
        if (Result.isFailure-impl(r2) == true) goto L14;
        r0 = r2;
    L14:
        Map<String, Long> r4 = (Map) r0;
        if (r4 == null) goto L17;
        return r4;
    L17:
        return new LinkedHashMap();
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final Map<String, String> j() {
        if (this.e != null) goto L8;
        Type r0 = new b().getType();
        Map<String, String> r1 = (Map) e0.b(this.a.H().getString("minutes_recording_v2_native_local_bound_map_prefix", null), r0);
        if (r1 != null) goto L7;
        r1 = new HashMap();
    L7:
        this.e = r1;
    L8:
        Map<String, String> r2 = this.e;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return MapsKt.emptyMap();
    }

    public final Map<String, Long> m() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(MapsKt.toMap(x()));     // Catch: Throwable -> L4
    L6:
        Map r2 = MapsKt.emptyMap();
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return (Map) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final Set<String> n() {
        if (this.f != null) goto L19;
        Type r0 = new c().getType();
        String r1 = this.a.H().getString("minutes_recording_v2_pending_upload_completed_sync_prefix", null);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        Set r3 = (Set) e0.b(r1, r0);     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        Object r4 = CollectionsKt.toMutableSet(r3);     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
    L10:
        Object r5 = Result.constructor-impl(r4);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L18;
        lvb.a.b(this.b, "[pendingUploadCompletedSync] parse failed, localCache:" + r1 + ", error:" + r6);
        this.a.H().remove("minutes_recording_v2_pending_upload_completed_sync_prefix");
        r5 = new HashSet();
    L18:
        this.f = (Set) r5;
    L9:
        r4 = new HashSet();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L19:
        Set<String> r8 = this.f;
        if (r8 != null) goto L22;
        r8 = SetsKt.emptySet();
    L22:
        lvb.a.e(this.b, "[pendingUploadCompletedSync] get, meetingIds:" + r8);
        return r8;
    }

    public final Map<String, String> p() {
        if (this.d != null) goto L8;
        Type r0 = new d().getType();
        Map<String, String> r1 = (Map) e0.b(this.a.H().getString("minutes_recording_v2_audio_path_map_prefix", null), r0);
        if (r1 != null) goto L7;
        r1 = new HashMap();
    L7:
        this.d = r1;
    L8:
        Map<String, String> r2 = this.d;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return MapsKt.emptyMap();
    }

    public final Map<String, String> v() {
        if (this.g != null) goto L8;
        Type r0 = new C0028e().getType();
        Map<String, String> r1 = (Map) e0.b(this.a.H().getString("minutes_recording_v2_standalone_ai_interpretation_recording_id_map_prefix", null), r0);
        if (r1 != null) goto L7;
        r1 = new HashMap();
    L7:
        this.g = r1;
    L8:
        Map<String, String> r2 = this.g;
        if (r2 == null) goto L11;
        return r2;
    L11:
        return MapsKt.emptyMap();
    }

    public e(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentContext");
        this.a = r2;
        this.b = "MmRecordingStatesLocalStorage";
    }

    public final void A(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        if (this.c != null) goto L6;
        this.c = new HashMap();     // Catch: Throwable -> L12
    L6:
        Map<String, String> r2 = this.c;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.putAll(r4);     // Catch: Throwable -> L12
        lvb.a.e(this.b, "putMeetingIdTokenMapping, meetingId2TokenMap:" + r2);     // Catch: Throwable -> L12
        this.a.H().putString("minutes_recording_v2_meeting_map_prefix", e0.c(r2));     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.constructor-impl(r5);     // Catch: Throwable -> L12
        return;
    L9:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void B(String r6) {
        Intrinsics.checkNotNullParameter(r6, "sessionKey");
        if (StringsKt.isBlank(r6) == false) goto L21;
        return;
    L21:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        Map<String, Long> r4 = x();     // Catch: Throwable -> L18
        if (r4.remove(r6) == null) goto L8;
        y(r4);     // Catch: Throwable -> L18
        lvb.a.e(this.b, "[offlineIndex] remove, sessionKey:" + r6);     // Catch: Throwable -> L18
    L8:
        Intrinsics.checkNotNullParameter(r6, "sessionKey");     // Catch: Throwable -> L18
        if (StringsKt.isBlank(r6) == true) goto L13;
        this.a.H().remove("minutes_recording_v2_offline_audio_path_" + r6);     // Catch: Throwable -> L18
    L13:
        if (StringsKt.isBlank(r6) == true) goto L16;
        this.a.H().remove("minutes_recording_v2_offline_hardware_device_id_".concat(r6));     // Catch: Throwable -> L18
    L16:
        d(r6);     // Catch: Throwable -> L18
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        lvb.a.e(this.b, "clearDoubaoBizInfo, meetingId:" + r4);
        this.a.H().remove("minutes_recording_v2_doubao_biz_info_prefix" + r4);
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        if (StringsKt.isBlank(r5) == false) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Set<String> r2 = CollectionsKt.toMutableSet(n());     // Catch: Throwable -> L7
        r2.remove(r5);     // Catch: Throwable -> L7
        this.f = r2;     // Catch: Throwable -> L7
        lvb.a.e(this.b, "[pendingUploadCompletedSync] clear, meetingId:" + r5 + ", meetingIds:" + r2);     // Catch: Throwable -> L7
        this.a.H().putString("minutes_recording_v2_pending_upload_completed_sync_prefix", e0.c(r2));     // Catch: Throwable -> L7
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L15;
        lvb.a.b(this.b, "[pendingUploadCompletedSync] clear failed, meetingId:" + r5 + ", error:" + r3);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        if (StringsKt.isBlank(r5) == false) goto L10;
        return;
    L10:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Map<String, String> r2 = MapsKt.toMutableMap(p());     // Catch: Throwable -> L7
        r2.remove(r5);     // Catch: Throwable -> L7
        this.d = r2;     // Catch: Throwable -> L7
        lvb.a.e(this.b, "[recordingAudioPath] clear, recordingId:" + r5);     // Catch: Throwable -> L7
        this.a.H().putString("minutes_recording_v2_audio_path_map_prefix", e0.c(r2));     // Catch: Throwable -> L7
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        lvb.a.e(this.b, "[recordingSource] clear, meetingId:" + r4);
        this.a.H().remove("minutes_recording_v2_source_prefix" + r4);
    }

    public final void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "recordingId");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        lvb.a.e(this.b, "[recordingTraceId] clear, recordingId:" + r4);
        this.a.H().remove("minutes_recording_v2_trace_id_prefix" + r4);
    }

    public final void f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        if (StringsKt.isBlank(r5) == false) goto L13;
        return;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Map<String, String> r2 = MapsKt.toMutableMap(v());     // Catch: Throwable -> L7
        r2.remove(r5);     // Catch: Throwable -> L7
        this.g = r2;     // Catch: Throwable -> L7
        lvb.a.e(this.b, "[standaloneAIInterpretationRecordingId] clear, meetingId:" + r5);     // Catch: Throwable -> L7
        this.a.H().putString("minutes_recording_v2_standalone_ai_interpretation_recording_id_map_prefix", e0.c(r2));     // Catch: Throwable -> L7
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r0);
        if (r3 == null) goto L15;
        lvb.a.b(this.b, "[standaloneAIInterpretationRecordingId] clear failed, meetingId:" + r5 + ", error:" + r3);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "recordingId");
        if (StringsKt.isBlank(r3) == false) goto L5;
        return;
    L5:
        lvb.a.e(this.b, "[standaloneAIInterpretationSaveArtifact] clear, recordingId:".concat(r3));
        this.a.H().remove("minutes_recording_v2_standalone_ai_interpretation_save_artifact_prefix".concat(r3));
    }

    public final DoubaoBizInfo h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        String r6 = this.a.H().getString("minutes_recording_v2_doubao_biz_info_prefix" + r5, null);     // Catch: Throwable -> L8
        if (r6 != null) goto L6;
        return null;
    L6:
        Gson r0 = e0.a;     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl((DoubaoBizInfo) e0.a(r6, DoubaoBizInfo.class));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r1 = r7;
    L15:
        return (DoubaoBizInfo) r1;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final String i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionKey");
        String r0 = j().get(r5);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        lvb.a.e(this.b, "[nativeLocalBoundMeeting] get, sessionKey:" + r5 + ", meetingId:" + r0);
        return r0;
    }

    public final String k(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionKey");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return "";
    L5:
        String r6 = this.a.H().getString("minutes_recording_v2_offline_audio_path_" + r5, null);
        if (r6 != null) goto L9;
        return "";
    L9:
        return r6;
    }

    public final String l(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sessionKey");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return "";
    L5:
        String r6 = this.a.H().getString("minutes_recording_v2_offline_hardware_device_id_" + r5, null);
        if (r6 != null) goto L9;
        return "";
    L9:
        return r6;
    }

    public final String o(String r5) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        String r0 = p().get(r5);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        lvb.a.e(this.b, "[recordingAudioPath] get, recordingId:" + r5 + ", audioFilePath:" + r0);
        return r0;
    }

    public final MmRecordingRoute q(String r7) {
        Intrinsics.checkNotNullParameter(r7, "meetingId");
        String r8 = this.a.H().getString("minutes_recording_v2_route_prefix".concat(r7), null);
        MmRecordingRoute.Companion.getClass();
        MmRecordingRoute[] r0 = MmRecordingRoute.values();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        MmRecordingRoute r4 = r0[r3];
        if (Intrinsics.areEqual(r4.getStorageValue(), r8) == true) goto L8;
        r3 = r3 + 1;
        goto L3
    L8:
        return r4;
    L11:
        return null;
    }

    public final MmRecordingSource r(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        MmRecordingSource r2 = null;
        Object r3 = null;
        String r0 = this.a.H().getString("minutes_recording_v2_source_prefix" + r5, null);
        if (r0 != null) goto L15;
    L13:
        lvb.a.e(this.b, "[recordingSource] get, meetingId:" + r5 + ", source:" + r2);
        return r2;
    L15:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        Object r4 = Result.constructor-impl(MmRecordingSource.valueOf(r0));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r4) == true) goto L12;
        r3 = r4;
    L12:
        r2 = (MmRecordingSource) r3;
    L6:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final String s(String r5) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        String r1 = "";
        if (StringsKt.isBlank(r5) == false) goto L5;
        return "";
    L5:
        String r0 = this.a.H().getString("minutes_recording_v2_trace_id_prefix".concat(r5), null);
        if (r0 == null) goto L9;
        r1 = r0;
    L9:
        lvb.a.e(this.b, "[recordingTraceId] get, recordingId:" + r5 + ", traceId:" + r1);
        return r1;
    }

    public final String t(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        String r0 = this.a.H().getString("minutes_recording_v2_source_session_key_prefix" + r5, null);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        lvb.a.e(this.b, "[sourceSessionKey] get, meetingId:" + r5 + ", sessionKey:" + r0);
        return r0;
    }

    public final String u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "meetingId");
        String r1 = "";
        if (StringsKt.isBlank(r5) == false) goto L5;
        return "";
    L5:
        String r0 = v().get(r5);
        if (r0 == null) goto L9;
        r1 = r0;
    L9:
        lvb.a.e(this.b, "[standaloneAIInterpretationRecordingId] get, meetingId:" + r5 + ", recordingId:" + r1);
        return r1;
    }

    public final boolean w(String r5) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return false;
    L5:
        boolean r0 = this.a.H().getBoolean("minutes_recording_v2_standalone_ai_interpretation_save_artifact_prefix" + r5, false);
        lvb.a.e(this.b, "[standaloneAIInterpretationSaveArtifact] get, recordingId:" + r5 + ", saveArtifact:" + r0);
        return r0;
    }

    public final void y(Map<String, Long> r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        this.a.H().putString("minutes_recording_v2_offline_index_key", e0.c(r4));     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        lvb.a.b(this.b, "[offlineIndex] persist failed, err=" + r6.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void C(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "audioFilePath");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r6) == true) goto L19;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, String> r2 = MapsKt.toMutableMap(p());     // Catch: Throwable -> L9
        r2.put(r5, r6);     // Catch: Throwable -> L9
        this.d = r2;     // Catch: Throwable -> L9
        lvb.a.e(this.b, "[recordingAudioPath] save, recordingId:" + r5 + ", audioFilePath:" + r6);     // Catch: Throwable -> L9
        this.a.H().putString("minutes_recording_v2_audio_path_map_prefix", e0.c(r2));     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        lvb.a.b(this.b, "[recordingAudioPath] save failed, recordingId:" + r5 + ", error:" + r8);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void D(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "recordingId");
        Intrinsics.checkNotNullParameter(r5, "traceId");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r5) == true) goto L10;
        lvb.a.e(this.b, "[recordingTraceId] save, recordingId:" + r4 + ", traceId:" + r5);
        KVRepo r0 = this.a.H();
        StringBuilder r1 = new StringBuilder("minutes_recording_v2_trace_id_prefix");
        r1.append(r4);
        r0.putString(r1.toString(), r5);
        return;
    }

    public final void E(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "sessionKey");
        lvb.a.e(this.b, "[sourceSessionKey] save, meetingId:" + r4 + ", sessionKey:" + r5);
        KVRepo r0 = this.a.H();
        StringBuilder r1 = new StringBuilder("minutes_recording_v2_source_session_key_prefix");
        r1.append(r4);
        r0.putString(r1.toString(), r5);
    }

    public final void F(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "recordingId");
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        lvb.a.e(this.b, "[standaloneAIInterpretationSaveArtifact] save, recordingId:" + r4 + ", saveArtifact:" + r5);
        KVRepo r0 = this.a.H();
        StringBuilder r1 = new StringBuilder("minutes_recording_v2_standalone_ai_interpretation_save_artifact_prefix");
        r1.append(r4);
        r0.putBoolean(r1.toString(), r5);
    }

    public final void z(String r4, com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c r5) {
        Intrinsics.checkNotNullParameter(r4, "meetingId");
        Intrinsics.checkNotNullParameter(r5, "status");
        this.a.H().putInt("minutes_recording_v2_local_state_" + r4, r5.a);
    }
}
