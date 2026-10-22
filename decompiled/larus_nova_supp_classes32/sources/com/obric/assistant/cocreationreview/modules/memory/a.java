package com.obric.assistant.cocreationreview.modules.memory;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.Vote;
import com.obric.assistant.cocreationreview.s3;
import f06.d;
import hda.n0;
import hda.w0;
import hda.x0;
import hda.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements hda.b {
    public static final Uri b = null;
    public final Context a;

    /* JADX INFO: renamed from: com.obric.assistant.cocreationreview.modules.memory.a$a, reason: collision with other inner class name */
    public static final class C0080a {
    }

    static {
        b = UriProtector.parse("content://com.obric.memorydata.memory.provider");
    }

    public a(Context r1) {
        this.a = r1;
    }

    public static void f(ContentProviderClient r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r2.close();
        return;
    L5:
        r2.release();
    }

    @Override // hda.b
    public final x0 a(w0 r5) {
        Intrinsics.checkNotNullParameter(r5, "feedback");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r5, "feedback");
        JSONObject r0 = new JSONObject().put("recordId", r5.a).put("module", r5.b.getRaw()).put("vote", r5.c.getRaw()).put("reasons", new JSONArray(CollectionsKt.toList(r5.d))).put("comment", r5.e).put("businessPayloadJson", r5.f);
        String r6 = r5.g;
        if (r6 == null) goto L5;
        r0.put("traceJson", r6);
    L5:
        String r7 = r0.toString();
        Bundle r2 = new Bundle();
        r2.putString("feedbackJson", r7);
        Unit r8 = Unit.INSTANCE;
        Bundle r9 = c("submitMemoryReviewFeedback", r2);
        if (r9 == null) goto L8;
        String r10 = r9.getString("resultJson");
    L10:
        if (r10 == null) goto L13;
        Intrinsics.checkNotNullParameter(r10, "jsonText");
        JSONObject r3 = new JSONObject(r10);
        return new x0(r3.optBoolean("accepted", false), r3.optString("message", NameKeys.UnloadStrategy_No_Strategy));
    L13:
        return new x0(false, "MemoryData provider unavailable");
    L8:
        r10 = null;
        goto L10
    }

    @Override // hda.b
    public final c b(n0 r30) {
        Intrinsics.checkNotNullParameter(r30, "request");
        int r2 = b.a;
        Intrinsics.checkNotNullParameter(r30, "request");
        JSONObject r1 = new JSONObject().put("module", r30.a.getRaw());
        Object r3 = r30.b;
        if (r3 != null) goto L5;
        r3 = JSONObject.NULL;
    L5:
        String r4 = r1.put("pageCursor", r3).put("pageSize", r30.c).put("observeFromTimeMillis", r30.d).put("windowEndTimeMillis", r30.e).toString();
        Bundle r5 = new Bundle();
        r5.putString("requestJson", r4);
        Unit r6 = Unit.INSTANCE;
        Bundle r7 = c("getMemoryReviewPage", r5);
        if (r7 == null) goto L8;
        String r8 = r7.getString("resultJson");
    L9:
        if (r8 == null) goto L61;
        Intrinsics.checkNotNullParameter(r8, "jsonText");
        JSONObject r0 = new JSONObject(r8);
        MemoryDataReviewModuleKey.a r9 = MemoryDataReviewModuleKey.Companion;
        String r10 = b.a(r0, "module");
        r9.getClass();
        MemoryDataReviewModuleKey[] r11 = MemoryDataReviewModuleKey.values();
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L16;
        MemoryDataReviewModuleKey r14 = r11[r13];
        if (Intrinsics.areEqual(r14.getRaw(), r10) == true) goto L17;
        r13 = r13 + 1;
    L17:
        if (r14 != null) goto L19;
        r14 = MemoryDataReviewModuleKey.SCREEN_MEMORY;
    L19:
        MemoryDataReviewModuleKey r15 = r14;
        long r16 = r0.optLong("observeFromTimeMillis", 0);
        long r17 = r0.optLong("windowEndTimeMillis", System.currentTimeMillis());
        List r18 = b.b(r0.optJSONArray("pendingRecords"), r15);
        List r19 = b.b(r0.optJSONArray("completedRecords"), r15);
        JSONObject r20 = r0.optJSONObject("feedbackByRecordId");
        if (r20 != null) goto L22;
        Map r110 = MapsKt.emptyMap();
    L57:
        String r21 = b.a(r0, "nextPageCursor");
        if (r21 != null) goto L73;
        r21 = b.a(r0, "nextCursor");
    L73:
        return new c(r15, r16, r17, r18, r19, r110, r21, r0.optBoolean("hasMore", false), b.a(r0, "error"));
    L22:
        LinkedHashMap r22 = new LinkedHashMap();
        Iterator<String> r23 = r20.keys();
    L24:
        if (r23.hasNext() == false) goto L56;
        String r24 = r23.next();
        JSONObject r111 = r20.optJSONObject(r24);
        if (r111 == null) goto L24;
        MemoryReviewFeedbackState.a r112 = MemoryReviewFeedbackState.Companion;
        String r25 = b.a(r111, "state");
        r112.getClass();
        MemoryReviewFeedbackState r26 = MemoryReviewFeedbackState.a.a(r25);
        Vote.a r27 = Vote.Companion;
        String r28 = b.a(r111, "vote");
        r27.getClass();
        Vote r29 = Vote.a.a(r28);
        JSONArray r31 = r111.optJSONArray("reasons");
        if (r31 != null) goto L31;
        Set r210 = SetsKt.emptySet();
    L41:
        String r211 = r111.optString("comment", NameKeys.UnloadStrategy_No_Strategy);
        String r32 = b.a(r111, "displayedCardJson");
        if (r32 != null) goto L47;
        Object r33 = r111.opt("displayedCard");
        if (r33 == null) goto L46;
        r32 = r33.toString();
        goto L47
    L46:
        String r212 = null;
    L48:
        String r34 = b.a(r111, "traceJson");
        if (r34 != null) goto L54;
        Object r35 = r111.opt("trace");
        if (r35 == null) goto L53;
        r34 = r35.toString();
        goto L54
    L53:
        String r213 = null;
    L55:
        r22.put(r24, new y(r26, r29, r210, r211, r212, r213, r111.optLong("updateTimeMillis", 0)));
        r20 = r20;
    L54:
        r213 = r34;
    L47:
        r212 = r32;
        goto L48
    L31:
        LinkedHashSet r36 = new LinkedHashSet();
        int r113 = r31.length();
        int r37 = 0;
    L32:
        if (r37 >= r113) goto L40;
        String r114 = r31.optString(r37);
        Intrinsics.checkNotNull(r114);
        if ((!StringsKt.isBlank(r114)) == false) goto L36;
        String r38 = r114;
    L37:
        if (r38 == null) goto L39;
        r36.add(r38);
    L39:
        r37 = r37 + 1;
        goto L32
    L36:
        r38 = null;
        goto L37
    L40:
        r210 = r36;
        goto L41
    L56:
        r110 = r22;
        goto L57
    L16:
        r14 = null;
        goto L17
    L61:
        int r39 = c.j;
        MemoryDataReviewModuleKey r40 = r30.a;
        long r41 = r30.d;
        long r42 = r30.e;
        Intrinsics.checkNotNullParameter(r40, "module");
        return new c(r40, r41, r42, CollectionsKt.emptyList(), CollectionsKt.emptyList(), MapsKt.emptyMap(), null, false, "MemoryData provider unavailable");
    L8:
        r8 = null;
        goto L9
    }

    public static ContentProviderClient d(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final Bundle c(String r7, Bundle r8) {
        Context r3 = this.a;
        Bundle r4 = null;
        if (r3 == null) goto L25;
        Context r5 = r3.getApplicationContext();
        if (r5 == null) goto L25;
        ContentProviderClient r6 = d(r5.getContentResolver(), b);     // Catch: IllegalArgumentException -> L9 SecurityException -> L10
    L26:
        if (r6 != null) goto L28;
        return null;
    L28:
        r4 = r6.call(r7, null, r8);     // Catch: Throwable -> L16 RemoteException -> L18 DeadObjectException -> L20
    L21:
        f(r6);
        return r4;
    L18:
        e = move-exception;
        int r0 = s3.a;     // Catch: Throwable -> L16
        s3.c("memory.bridge", "provider remote failure method=" + r7 + " type=" + e.getClass().getSimpleName());     // Catch: Throwable -> L16
    L20:
        int r9 = s3.a;     // Catch: Throwable -> L16
        s3.c("memory.bridge", "provider died method=".concat(r7));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        f(r6);
        throw th;
    L9:
        int r10 = s3.a;
        s3.c("memory.bridge", "provider missing method=".concat(r7));
    L11:
        r6 = null;
    L10:
        int r11 = s3.a;
        s3.c("memory.bridge", "acquire denied method=".concat(r7));
    L25:
        return null;
    }

    public final hda.a e(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "recordId");
        if (StringsKt.isBlank(r9) == true) goto L5;
        Bundle r1 = new Bundle();
        r1.putInt("protocolVersion", 1);
        r1.putString("recordId", r9);
        r1.putString("cursor", r10);
        Unit r11 = Unit.INSTANCE;
        Bundle r12 = c("getMemoryReviewAudioTranscriptChunk", r1);
        if (r12 == null) goto L9;
        MemoryReviewAudioTranscriptCode.a r0 = MemoryReviewAudioTranscriptCode.Companion;
        String r2 = r12.getString(LynxResourceModule.CODE_KEY);
        r0.getClass();
        MemoryReviewAudioTranscriptCode[] r3 = MemoryReviewAudioTranscriptCode.values();
        int r4 = r3.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L16;
        MemoryReviewAudioTranscriptCode r6 = r3[r5];
        if (Intrinsics.areEqual(r6.name(), r2) == true) goto L17;
        r5 = r5 + 1;
    L17:
        if (r6 != null) goto L19;
        MemoryReviewAudioTranscriptCode r7 = MemoryReviewAudioTranscriptCode.INTERNAL_ERROR;
    L20:
        String r8 = r12.getString("chunk");
        if (r8 != null) goto L24;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        return new hda.a(r7, r8, r12.getString("nextCursor"), r12.getBoolean("hasMore", false), r12.getLong("totalBytes", 0));
    L19:
        r7 = r6;
        goto L20
    L16:
        r6 = null;
        goto L17
    L9:
        return new hda.a(MemoryReviewAudioTranscriptCode.INTERNAL_ERROR);
    L5:
        return new hda.a(MemoryReviewAudioTranscriptCode.NOT_FOUND);
    }
}
