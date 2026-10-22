package com.obric.memorydata.memory.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.dd;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.review.model.j;
import com.obric.memorydata.memory.review.provider.AudioMemoryTranscriptCode;
import com.obric.memorydata.memory.review.provider.aj;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ak;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.i;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016JS\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J3\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001dJ=\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u001fJ&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00122\b\u0010$\u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0012H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u001c\u0010(\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010)\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010!H\u0002J\u0014\u0010*\u001a\u00020+2\n\u0010,\u001a\u00060-j\u0002`.H\u0002J\f\u0010/\u001a\u00020!*\u00020+H\u0002J\u001c\u00100\u001a\u00020!2\b\u0010$\u001a\u0004\u0018\u00010!2\b\u0010#\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u00064"}, d2 = {"Lcom/obric/memorydata/memory/provider/MemoryProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "audioMemoryTranscriptChunkService", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService;", "getAudioMemoryTranscriptChunkService", "()Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkService;", "audioMemoryTranscriptChunkService$delegate", "Lkotlin/Lazy;", "onCreate", "", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", BuildConfig.CHANNEL, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", "callingInfo", "refreshMemoryReviewEntryEnabled", "exportMemoryReviewFeedbackCsvFiles", "getMemoryReviewPage", "getMemoryReviewAudioTranscriptChunk", "audioTranscriptInternalError", "Lcom/obric/memorydata/memory/review/provider/AudioMemoryTranscriptChunkResponse;", "error", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "toBundle", "submitMemoryReviewFeedback", "memoryReviewPageErrorJson", "message", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryProvider extends PluginContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10352a = null;
    private static final Set<Integer> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f10353b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/provider/MemoryProvider$Companion;", "", "<init>", "()V", "TAG", "", "METHOD_OPEN_MEMORY_DETAIL", "METHOD_QUERY_IMAGE_MEMORY_STATUS", "KEY_RESULT", "KEY_UUID", "KEY_ENTITY_TYPE", "KEY_IS_MEMORIZED", "KEY_REMEMBERED_TIME", "KEY_IMAGE_HASH", "KEY_IMAGE_HASH_LIST", "KEY_IMAGE_STATUS_LIST", "METHOD_GET_MEMORY_REVIEW_PAGE", "METHOD_SUBMIT_MEMORY_REVIEW_FEEDBACK", "METHOD_EXPORT_MEMORY_REVIEW_FEEDBACK_CSV_FILES", "METHOD_REFRESH_MEMORY_REVIEW_ENTRY_ENABLED", "KEY_REQUEST_JSON", "KEY_FEEDBACK_JSON", "KEY_RESULT_JSON", "KEY_FILE_PATH_LIST", "KEY_ENABLED", "KEY_RESOLVED", "KEY_SOURCE", "KEY_ERROR_MSG", "ALL_OLD_MEMORY_TYPES", "", "", "getALL_OLD_MEMORY_TYPES$annotations", "getALL_OLD_MEMORY_TYPES", "()Ljava/util/Set;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10352a = new a(null);
        c = SetsKt.setOf(new Integer[]{10001, 10002, 10003, 10004, 10005, 10006, Integer.valueOf(EntityType.MEMORY_INFO_DOCUMENTS), Integer.valueOf(EntityType.MEMORY_INFO_ADDRESS), Integer.valueOf(EntityType.MEMORY_INFO_ANNIVERSARY), Integer.valueOf(EntityType.MEMORY_INFO_RELATIONSHIP), Integer.valueOf(EntityType.MEMORY_INFO_COMMON), Integer.valueOf(EntityType.MEMORY_COLLECT_CONTENT), Integer.valueOf(EntityType.MEMORY_COLLECT_STORE), Integer.valueOf(EntityType.MEMORY_EVENT_SCHEDULE), Integer.valueOf(EntityType.MEMORY_EVENT_TODO), Integer.valueOf(EntityType.MEMORY_COMMON_TEXT)});
    }

    public MemoryProvider() {
        this.f10353b = LazyKt.lazy($$Lambda$MemoryProvider$ySwTN_AVyilHSiCNEiODaDQwk08.INSTANCE);
    }

    private final Bundle a(Bundle r5) {
        com.obric.memorydata.memory.review.provider.c r0 = a();     // Catch: RuntimeException -> L15
        int r1 = -1;
        if (r5 == null) goto L5;
        r1 = r5.getInt("protocolVersion", -1);     // Catch: RuntimeException -> L15
    L5:
        String r2 = null;
        if (r5 == null) goto L8;
        String r3 = r5.getString("recordId");     // Catch: RuntimeException -> L15
    L9:
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        if (r5 == null) goto L13;
        r2 = r5.getString("cursor");     // Catch: RuntimeException -> L15
    L13:
        com.obric.memorydata.memory.review.provider.b r6 = r0.a(r1, r3, r2);     // Catch: RuntimeException -> L15
    L18:
        return a(r6);
    L8:
        r3 = null;
    L15:
        e = move-exception;
        r6 = a(e);
        goto L18
    }

    private final Bundle a(Bundle r3, String r4) {
        if (r3 == null) goto L25;
        String r5 = r3.getString("requestJson");
        if (r5 == null) goto L25;
        r4 = r5;
    L25:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        MemoryProvider r7 = (MemoryProvider) ZeusTransformUtils.preCheckCast(this, MemoryProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        com.obric.memorydata.memory.review.model.g r8 = com.obric.memorydata.memory.review.model.e.f10388a.a(r4);     // Catch: Throwable -> L14
        if (r8 != null) goto L11;
        String r9 = r7.a("invalid memory review page request");     // Catch: Throwable -> L14
    L12:
        Object r10 = Result.m1421constructorimpl(r9);     // Catch: Throwable -> L14
    L16:
        Throwable r11 = Result.m1424exceptionOrNullimpl(r10);
        if (r11 == null) goto L23;
        String r12 = r11.getMessage();
        if (r12 != null) goto L22;
        r12 = "get memory review page failed";
    L22:
        r10 = a(r12);
    L23:
        String r2 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.review.a.f10372a.b("get_memory_review_page");
        Bundle r13 = new Bundle();
        r13.putString("resultJson", r2);
        return r13;
    L11:
        r9 = com.obric.memorydata.memory.review.model.e.f10388a.a(aj.f10414a.a(r8));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private final Bundle a(com.obric.memorydata.memory.review.provider.b r3) {
        Bundle r2 = new Bundle();
        r2.putString("code", r3.a().name());
        r2.putString("chunk", r3.b());
        r2.putString("nextCursor", r3.c());
        r2.putBoolean("hasMore", r3.d());
        r2.putLong("totalBytes", r3.e());
        return r2;
    }

    private final com.obric.memorydata.memory.review.provider.b a(RuntimeException r11) {
        RunLog.INSTANCE.error("MemoryProvider", "get audio transcript chunk failed, errorType=" + r11.getClass().getSimpleName(), (Throwable) ZeusTransformUtils.preCheckCast(r11, Throwable.class, "com.obric.memorydata.plugin"));
        return new com.obric.memorydata.memory.review.provider.b(AudioMemoryTranscriptCode.INTERNAL_ERROR, null, null, false, 0, 30, null);
    }

    private final com.obric.memorydata.memory.review.provider.c a() {
        return (com.obric.memorydata.memory.review.provider.c) ZeusTransformUtils.preCheckCast(this.f10353b.getValue(), com.obric.memorydata.memory.review.provider.c.class, "com.obric.memorydata.plugin");
    }

    private final String a(String r3) {
        String r2 = new JSONObject().put("pendingRecords", new JSONArray()).put("completedRecords", new JSONArray()).put("feedbackByRecordId", new JSONObject()).put("nextPageCursor", JSONObject.NULL).put("hasMore", false).put("error", r3).toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        return r2;
    }

    private final Bundle b(Bundle r3, String r4) {
        if (r3 == null) goto L26;
        String r5 = r3.getString("feedbackJson");
        if (r5 == null) goto L26;
        r4 = r5;
    L26:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        MemoryProvider r2 = (MemoryProvider) ZeusTransformUtils.preCheckCast(this, MemoryProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        com.obric.memorydata.memory.review.model.c r6 = com.obric.memorydata.memory.review.model.e.f10388a.b(r4);     // Catch: Throwable -> L15
        if (r6 != null) goto L12;
        j r7 = new j(false, "invalid memory review feedback");     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L15
    L17:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L24;
        String r10 = r9.getMessage();
        if (r10 != null) goto L23;
        r10 = "submit memory review feedback failed";
    L23:
        r8 = new j(false, r10);
    L24:
        j r11 = (j) ZeusTransformUtils.preCheckCast(r8, j.class, "com.obric.memorydata.plugin");
        Bundle r12 = new Bundle();
        r12.putString("resultJson", com.obric.memorydata.memory.review.model.e.f10388a.a(r11));
        return r12;
    L12:
        r7 = aj.f10414a.a(r6);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    private final String b() {
        int r0 = Binder.getCallingUid();
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L9;
        PackageManager r11 = r10.getPackageManager();
        if (r11 == null) goto L9;
        String[] r1 = r11.getPackagesForUid(r0);
        if (r1 == null) goto L9;
        String r12 = ArraysKt.joinToString$default(r1, null, null, null, 0, null, null, 63, null);
    L10:
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        return "uid=" + r0 + ", packages=" + r12;
    L9:
        r12 = null;
        goto L10
    }

    private final Bundle c() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        MemoryProvider r8 = (MemoryProvider) ZeusTransformUtils.preCheckCast(this, MemoryProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(com.obric.memorydata.database.c.c.f8852a.c());     // Catch: Throwable -> L5
    L7:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r9);
        if (r2 == null) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "refreshMemoryReviewEntryEnabled failed: " + r2.getMessage(), null, 4, null);
        r9 = new com.obric.memorydata.database.c.c.a(false, false, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
    L11:
        com.obric.memorydata.database.c.c.a r10 = (com.obric.memorydata.database.c.c.a) ZeusTransformUtils.preCheckCast(r9, com.obric.memorydata.database.c.c.a.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "refreshMemoryReviewEntryEnabled result: enabled=" + r10.a() + ", resolved=" + r10.b() + ", source=" + r10.c(), false, 4, null);
        com.obric.memorydata.database.c.b.f8850a.a();
        Bundle r0 = new Bundle();
        r0.putBoolean("enabled", r10.a());
        r0.putBoolean("resolved", r10.b());
        r0.putString(AILabCheckPermissionTask.KEY_SOURCE, r10.c());
        r0.putString("resultJson", new JSONObject().put("accepted", true).put("enabled", r10.a()).put("resolved", r10.b()).put(AILabCheckPermissionTask.KEY_SOURCE, r10.c()).toString());
        return r0;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final Bundle d() {
        Bundle r1 = new Bundle();
        JSONObject r2 = new JSONObject();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        MemoryProvider r8 = (MemoryProvider) ZeusTransformUtils.preCheckCast(this, MemoryProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r9 = Result.m1421constructorimpl(com.obric.memorydata.memory.review.a.a.f10374a.a());     // Catch: Throwable -> L5
    L8:
        if (Result.m1428isSuccessimpl(r9) == false) goto L10;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        r1.putStringArrayList("filePathList", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")));
        r2.put("accepted", true);
        r2.put("filePathList", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")));
    L10:
        Throwable r10 = Result.m1424exceptionOrNullimpl(r9);
        if (r10 == null) goto L16;
        String r0 = r10.getMessage();
        if (r0 != null) goto L15;
        r0 = "export memory review feedback csv files failed";
    L15:
        RunLog.INSTANCE.error("MemoryProvider", r0, r10);
        r1.putStringArrayList("filePathList", new ArrayList());
        r2.put("accepted", false);
        r2.put("message", r0);
        r2.put("filePathList", new JSONArray());
    L16:
        r1.putString("resultJson", r2.toString());
        return r1;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private static final com.obric.memorydata.memory.review.provider.c e() {
        return new com.obric.memorydata.memory.review.provider.c(null, null, 3, null);
    }

    public static /* synthetic */ com.obric.memorydata.memory.review.provider.c lambda$ySwTN_AVyilHSiCNEiODaDQwk08() {
        return e();
    }

    public Bundle call(String r26, String r27, Bundle r28) {
        Intrinsics.checkNotNullParameter(r26, "method");
        long r4 = SystemClock.elapsedRealtime();
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder().append("call begin, method=").append(r26).append(", argPresent=");
        if (r27 == null) goto L5;
        boolean r10 = true;
    L6:
        StringBuilder r7 = r6.append(r10).append(", argLength=");
        if (r27 == null) goto L9;
        int r11 = r27.length();
    L10:
        StringBuilder r8 = r7.append(r11).append(", caller=").append(b()).append(", extrasKeys=");
        if (r28 == null) goto L13;
        Set<String> r12 = r28.keySet();
    L14:
        String r15 = null;
        IRunLog.a.a(r9, "MemoryProvider", r8.append(r12).toString(), false, 4, null);
        boolean r13 = ak.f13164a.c();
        if (r13 == false) goto L17;
        boolean r14 = false;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "call permission, method=" + r26 + ", isSelf=" + r13 + ", isPlatformSigned=" + r14 + ", caller=" + b(), false, 4, null);
        if (r13 == true) goto L24;
        if (r14 == true) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "call denied, method=" + r26 + ", caller=" + b(), null, 4, null);
        return null;
    L24:
        if (Intrinsics.areEqual(r26, "getMemoryReviewPage") == false) goto L28;
        return a(r28, r27);
    L28:
        if (Intrinsics.areEqual(r26, "getMemoryReviewAudioTranscriptChunk") == false) goto L32;
        return a(r28);
    L32:
        if (Intrinsics.areEqual(r26, "submitMemoryReviewFeedback") == false) goto L36;
        return b(r28, r27);
    L36:
        if (Intrinsics.areEqual(r26, "exportMemoryReviewFeedbackCsvFiles") == false) goto L40;
        return d();
    L40:
        if (Intrinsics.areEqual(r26, "refreshMemoryReviewEntryEnabled") == false) goto L44;
        return c();
    L44:
        if (com.obric.memorydata.memory.provider.a.f10354a.a(r26) == true) goto L46;
        String r16 = "";
        String r17 = "ms";
        if (Intrinsics.areEqual(r26, "openMemoryDetail") == false) goto L81;
        Bundle r0 = new Bundle();
        r0.putBoolean("result", false);
        r0.putString("error_msg", "");
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L56;
        if (UserSettings.INSTANCE.isEnterpriseAccount() == false) goto L56;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "reject openMemoryDetail for enterprise account", false, 4, null);
        r0.putString("error_msg", r18.getString(ZeusTransformUtils.mapRes(R.string.memory_enterprise_account_not_supported, TypedValues.Custom.S_STRING, "memory_enterprise_account_not_supported")));
        return r0;
    L56:
        if (r28 == null) goto L75;
        String r19 = r28.getString(Api.KEY_UUID);
        if (r19 == null) goto L75;
        int r20 = r28.getInt("entityType", -1);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "openMemoryDetail params, uuid=" + r19 + ", entityType=" + r20, false, 4, null);
        if (r20 != (-306)) goto L62;
    L70:
        MemoryEntity r21 = com.obric.memorydata.memory.utils.f.f11537a.a(r19);
        if (r21 == null) goto L74;
        MemoryDetailActivity.a r110 = MemoryDetailActivity.Companion;
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r111);
        MemoryDetailActivity.a.a(r110, r111, r21, MemoryEventTracker.SourceType.CALENDAR_DETAIL.getValue(), false, 8, null);
        r0.putBoolean("result", true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "openMemoryDetail success, uuid=" + r19 + ", cost=" + (SystemClock.elapsedRealtime() - r4) + "ms", false, 4, null);
        return r0;
    L74:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "openMemoryDetail failed, no memoryEntity, uuid = " + r19, false, 4, null);
        goto L75
    L62:
        if (c.contains(Integer.valueOf(r20)) == true) goto L70;
        AppEntity r1 = com.obric.memorydata.memory.utils.f.f11537a.a(r19, r20);
        if (r1 == null) goto L75;
        if (((Boolean) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryProvider$call$1$1$1(r1, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L75;
        r0.putBoolean("result", true);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "openMemoryDetail source app success, uuid=" + r19 + ", entityType=" + r20 + ", cost=" + (SystemClock.elapsedRealtime() - r4) + "ms", false, 4, null);
        return r0;
    L75:
        IRunLog r112 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("openMemoryDetail failed, uuid=");
        if (r28 == null) goto L78;
        r15 = r28.getString(Api.KEY_UUID);
    L78:
        IRunLog.a.a(r112, "MemoryProvider", r2.append(r15).append(", cost=").append(SystemClock.elapsedRealtime() - r4).append("ms").toString(), null, 4, null);
        return r0;
    L81:
        if (Intrinsics.areEqual(r26, "queryImageMemoryStatus") == true) goto L83;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "call unknown method, method=" + r26 + ", caller=" + b() + ", cost=" + (SystemClock.elapsedRealtime() - r4) + "ms", null, 4, null);
        return null;
    L83:
        if (r28 == null) goto L104;
        ArrayList<String> r3 = r28.getStringArrayList("image_hash_list");
        if (r3 == null) goto L104;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin");
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r22 = r5.iterator();
    L88:
        if (r22.hasNext() == false) goto L96;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r23);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L93;
        r23 = null;
    L93:
        if (r23 == null) goto L88;
        r113.add(r23);
        goto L88
    L96:
        List<String> r24 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r24 == null) goto L104;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r24, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L102;
        r24 = null;
    L102:
        if (r24 == null) goto L104;
    L120:
        List<String> r25 = r24;
        IRunLog r114 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r29 = new StringBuilder().append("queryImageMemoryStatus params, hashCount=").append(r25.size()).append(", firstHash=");
        String r30 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r25), String.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L124;
        r16 = r30;
    L124:
        IRunLog.a.a(r114, "MemoryProvider", r29.append(r16).toString(), false, 4, null);
        if (r25.isEmpty() == false) goto L168;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "queryImageMemoryStatus empty hash list, cost=" + (SystemClock.elapsedRealtime() - r4) + "ms", null, 4, null);
        Bundle r31 = new Bundle();
        r31.putBoolean("result", false);
        r31.putParcelableArrayList("image_status_list", new ArrayList());
        return r31;
    L168:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L135
        MemoryProvider r33 = (MemoryProvider) ZeusTransformUtils.preCheckCast(this, MemoryProvider.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L135
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemorySourceImageRelationDao().queryLatestStatusByHashes(r25), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L135
        Map r115 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r34, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L135
        Iterator r35 = r34.iterator();     // Catch: Throwable -> L135
    L131:
        if (r35.hasNext() == false) goto L133;
        Object r116 = r35.next();     // Catch: Throwable -> L135
        r115.put(((dd) ZeusTransformUtils.preCheckCast(r116, dd.class, "com.obric.memorydata.plugin")).a(), r116);     // Catch: Throwable -> L135
        goto L131
    L133:
        Object r36 = Result.m1421constructorimpl(r115);     // Catch: Throwable -> L135
    L137:
        Throwable r117 = Result.m1424exceptionOrNullimpl(r36);
        if (r117 == null) goto L141;
        RunLog.INSTANCE.error("MemoryProvider", "queryImageMemoryStatus db failed, hashCount=" + r25.size() + ", caller=" + b() + ", cost=" + (SystemClock.elapsedRealtime() - r4) + "ms", r117);
    L141:
        if (Result.m1424exceptionOrNullimpl(r36) != null) goto L164;
        Map r37 = (Map) ZeusTransformUtils.preCheckCast(r36, Map.class, "com.obric.memorydata.plugin");
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r40 = r38.iterator();
    L144:
        if (r40.hasNext() == false) goto L154;
        String r41 = (String) ZeusTransformUtils.preCheckCast(r40.next(), String.class, "com.obric.memorydata.plugin");
        Iterator r210 = r40;
        dd r42 = (dd) ZeusTransformUtils.preCheckCast(r37.get(r41), dd.class, "com.obric.memorydata.plugin");
        Bundle r118 = new Bundle();
        r118.putString("image_hash", r41);
        if (r42 == null) goto L148;
        boolean r43 = true;
    L149:
        r118.putBoolean("is_memorized", r43);
        if (r42 == null) goto L152;
        long r119 = r42.b();
    L153:
        r118.putLong("remembered_time", r119);
        r39.add(r118);
        r40 = r210;
        r17 = r17;
        goto L144
    L152:
        r119 = 0;
        goto L153
    L148:
        r43 = false;
        goto L149
    L154:
        String r44 = r17;
        List r45 = (List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin");
        dd r46 = (dd) ZeusTransformUtils.preCheckCast(r37.get(CollectionsKt.first(r25)), dd.class, "com.obric.memorydata.plugin");
        Bundle r47 = new Bundle();
        boolean r120 = true;
        r47.putBoolean("result", true);
        r47.putParcelableArrayList("image_status_list", new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r45, Collection.class, "com.obric.memorydata.plugin")));
        if (r46 != null) goto L158;
        r120 = false;
    L158:
        r47.putBoolean("is_memorized", r120);
        if (r46 == null) goto L161;
        long r121 = r46.b();
    L162:
        r47.putLong("remembered_time", r121);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryProvider", "queryImageMemoryStatus success, hashCount=" + r25.size() + ", hitCount=" + r37.size() + ", cost=" + (SystemClock.elapsedRealtime() - r4) + r44, false, 4, null);
        return r47;
    L161:
        r121 = 0;
        goto L162
    L164:
        Bundle r48 = new Bundle();
        r48.putBoolean("result", false);
        r48.putParcelableArrayList("image_status_list", new ArrayList());
        return r48;
    L135:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r36 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L104:
        if (r28 == null) goto L114;
        String r49 = r28.getString("image_hash");
        if (r49 == null) goto L114;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r49, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L111;
        r49 = null;
    L111:
        if (r49 == null) goto L114;
        String r123 = r49;
    L119:
        r24 = CollectionsKt.listOfNotNull(r123);
    L114:
        if (r27 != null) goto L116;
    L118:
        r123 = null;
        goto L119
    L116:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r27, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L118;
        r123 = r27;
        goto L119
    L46:
        return com.obric.memorydata.memory.provider.a.f10354a.call(r26, r28, r27);
    L17:
        r14 = ak.f13164a.b();
        goto L18
    L13:
        r12 = null;
        goto L14
    L9:
        r11 = 0;
        goto L10
    L5:
        r10 = false;
        goto L6
    }

    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return -1;
    }

    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return -1;
    }
}
