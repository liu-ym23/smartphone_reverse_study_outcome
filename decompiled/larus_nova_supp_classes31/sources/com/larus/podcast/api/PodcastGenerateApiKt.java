package com.larus.podcast.api;

import com.larus.network.http.HttpExtKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class PodcastGenerateApiKt {
    public static final Object a(String r15, boolean r16, PodcastClickSource r17, String r18, Continuation<? super com.larus.network.http.a<a>> r19) {
        if ((r19 instanceof PodcastGenerateApiKt$generatePodcast$1) == false) goto L7;
        PodcastGenerateApiKt$generatePodcast$1 r2 = (PodcastGenerateApiKt$generatePodcast$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        PodcastGenerateApiKt$generatePodcast$1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L21:
        return (com.larus.network.http.a) r1;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        JSONObject r6 = new JSONObject();
        r6.put("resource_id", r15);
        r6.put("need_fullscreen_player", r16);
        r6.put("click_source", r17.getValue());
        if (r18 == null) goto L17;
        r6.put("conversation_id", r18);
    L17:
        Unit r0 = Unit.INSTANCE;
        r13.label = 1;
        r1 = HttpExtKt.k("Audio", a.class, "/chat/podcast/generate", r6, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L21;
        return r4;
    L7:
        r2 = new PodcastGenerateApiKt$generatePodcast$1(r19);
        goto L8
    }
}
