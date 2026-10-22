package com.larus.audio.utils;

import com.google.gson.Gson;
import com.mammon.audiosdk.structures.SAMICoreBlock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j1 {
    public static final j1 a = null;
    public static final Lazy b = null;

    public j1() {
    }

    static {
        a = new j1();
        b = LazyKt.lazy(new i1());
    }

    public static String a(SAMICoreBlock r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.constructor-impl(new JSONObject(new JSONObject(((Gson) b.getValue()).toJson(r4.audioData[0])).optString("textMsg")).optString("speech_alignment_result"));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r5) == false) goto L11;
        r5 = null;
    L11:
        return (String) r5;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
