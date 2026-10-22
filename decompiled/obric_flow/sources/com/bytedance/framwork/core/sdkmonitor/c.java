package com.bytedance.framwork.core.sdkmonitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f4707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f4708c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ long e;
    public final /* synthetic */ e f;

    public c(e r5, String r10, JSONObject r11, JSONObject r12, JSONObject r13, long r14) {
        this.f = r5;
        this.f4706a = r10;
        this.f4707b = r11;
        this.f4708c = r12;
        this.d = r13;
        this.e = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r5 = this.d;
        JSONObject r10 = this.f4707b;
        JSONObject r11 = this.f4708c;
        this.f.q(this.f4706a, r10, r11, r5, this.e);
    }
}
