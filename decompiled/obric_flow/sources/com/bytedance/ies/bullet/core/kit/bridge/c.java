package com.bytedance.ies.bullet.core.kit.bridge;

import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5338c;
    public long d;
    public long e;
    public long f;
    public long g;

    public final boolean a() {
        if (this.f5336a > 0) goto L5;
        return false;
    L5:
        if (this.f5337b > 0) goto L7;
        return false;
    L7:
        if (this.f5338c > 0) goto L9;
        return false;
    L9:
        if (this.d > 0) goto L11;
        return false;
    L11:
        if (this.e > 0) goto L13;
        return false;
    L13:
        if (this.f > 0) goto L15;
        return false;
    L15:
        if (this.g <= 0) goto L25;
        return true;
    L25:
        return false;
    }

    public final JSONObject b() {
        JSONObject r5 = new JSONObject();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
        r5.put("on_call_from_js", this.f5337b - this.f5336a);     // Catch: Throwable -> L5
        r5.put("on_decode_end", this.f5338c - this.f5336a);     // Catch: Throwable -> L5
        r5.put("on_method_call", this.d - this.f5336a);     // Catch: Throwable -> L5
        r5.put("on_callback_start", this.e - this.f5336a);     // Catch: Throwable -> L5
        r5.put("on_encode_end", this.f - this.f5336a);     // Catch: Throwable -> L5
        Result.m124constructorimpl(r5.put("on_callback_end", this.g - this.f5336a));     // Catch: Throwable -> L5
        return r5;
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return r5;
    }
}
