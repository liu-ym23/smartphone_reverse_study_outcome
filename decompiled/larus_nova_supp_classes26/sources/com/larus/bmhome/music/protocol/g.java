package com.larus.bmhome.music.protocol;

import com.larus.network.http.HttpExtKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final Object a(String r12, String r13, Continuation<? super com.larus.network.http.a<BigMusicLyrics>> r14) {
        JSONObject r3 = new JSONObject();
        if (r12 == null) goto L5;
        r3.put("prompt", r12);
    L5:
        if (r13 == null) goto L7;
        r3.put("instruction_options", r13);
    L7:
        Unit r15 = Unit.INSTANCE;
        return HttpExtKt.k("Social", BigMusicLyrics.class, "/alice/media/bigmusic/lyrics", r3, null, null, false, null, null, null, r14, 1008);
    }
}
