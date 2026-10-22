package com.obric.memorydata.awareness.audio;

import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioError;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioQueryResult;
import com.obric.memorydata.awareness.api.audio.AlwaysOnAudioSegment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a \u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\tH\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"parseAlwaysOnAudioSegments", "Lcom/obric/memorydata/awareness/api/audio/AlwaysOnAudioQueryResult;", "jsonArray", "Lorg/json/JSONArray;", "KEY_TIMESTAMP", "", "KEY_DURATION", "KEY_ORIGINAL_FILE_PATH", "normalizeSdkQueryResult", "Lcom/obric/memorydata/awareness/audio/PlatformResult;", "result", "awareness_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final AlwaysOnAudioQueryResult a(JSONArray r15) {
        if (r15 == null) goto L5;
        ArrayList r1 = new ArrayList(r15.length());
        int r3 = r15.length();     // Catch: JSONException -> L25
        int r5 = 0;
    L10:
        if (r5 >= r3) goto L23;
        JSONObject r7 = r15.getJSONObject(r5);     // Catch: JSONException -> L25
        long r10 = r7.getLong("timestamp");     // Catch: JSONException -> L25
        long r12 = r7.getLong("duration");     // Catch: JSONException -> L25
        String r14 = r7.getString("originalFilePath");     // Catch: JSONException -> L25
        if (r10 < 0) goto L21;
        if (r12 <= 0) goto L21;
        if (r10 > (Long.MAX_VALUE - r12)) goto L21;
        Intrinsics.checkNotNull(r14);     // Catch: JSONException -> L25
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L21;
        ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).add(new AlwaysOnAudioSegment(r10, r12, r14));     // Catch: JSONException -> L25
        r5 = r5 + 1;     // Catch: JSONException -> L25
    L21:
        return new AlwaysOnAudioQueryResult(null, AlwaysOnAudioError.MALFORMED_RESPONSE, 1, null);
    L23:
        CollectionsKt.sortWith((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), ComparisonsKt.compareBy(new Function1[]{AlwaysOnAudioSourceImplKt$parseAlwaysOnAudioSegments$1.INSTANCE, AlwaysOnAudioSourceImplKt$parseAlwaysOnAudioSegments$2.INSTANCE}));
        return new AlwaysOnAudioQueryResult((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), null, 2, null);
    L26:
        return new AlwaysOnAudioQueryResult(null, AlwaysOnAudioError.MALFORMED_RESPONSE, 1, null);
    L5:
        return new AlwaysOnAudioQueryResult(null, null, 3, null);
    }

    public static final f<JSONArray> a(f<? extends JSONArray> r4) {
        f<JSONArray> r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "result");
        if (ZeusTransformUtils.instanceOf(r5, f.b.class) == true) goto L5;
        return r5;
    L5:
        if (((f.b) ZeusTransformUtils.preCheckCast(r5, f.b.class, "com.obric.memorydata.plugin")).a() == null) goto L7;
        return r5;
    L7:
        return (f) ZeusTransformUtils.preCheckCast(new f.a(AlwaysOnAudioError.AUDIO_NOT_READY_OR_EMPTY, null, 2, null), f.class, "com.obric.memorydata.plugin");
    }
}
