package com.lynx.tasm.behavior;

import com.bytedance.ai.monitor.AppletJSBEvent$JSBType;
import com.lynx.react.bridge.JavaOnlyArray;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f10332c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ s0(t0 r5, long r10, int r11, Object[] r12) {
        this.f10330a = 0;
        this.d = r5;
        this.f10332c = r10;
        this.f10331b = r11;
        this.e = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10330a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        z2.e r5 = new z2.e((String) this.d, this.f10331b);
        q7.a r10 = (q7.a) this.e;
        Intrinsics.checkNotNullParameter(r5, "event");
        r5.f = (String) r10.f21488b;
        AppletJSBEvent$JSBType r11 = AppletJSBEvent$JSBType.f2382b;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r5.f23378m = r11;
        bj.a r12 = (bj.a) r10.f21489c;
        Object r13 = r12.b();
        if ((r13 instanceof JSONObject) == false) goto L7;
        JSONObject r14 = (JSONObject) r13;
    L8:
        r5.f23381p = r14;
        r5.f23379n = r12.f939l;
        r5.f23380o = r12.f940m;
        r5.f23382q = r12.d();
        r5.e = this.f10332c;
        z2.d.c(r5);
        return;
    L7:
        r14 = null;
        goto L8
    L10:
        t0 r15 = (t0) this.d;
        r15.getClass();
        JavaOnlyArray r16 = new JavaOnlyArray(Arrays.asList((Object[]) this.e));
        long r17 = this.f10332c;
        int r18 = this.f10331b;
        PaintingContext.a(r15.f, r17, r18, r16);
    }

    public /* synthetic */ s0(String r5, int r10, q7.a r11, long r12) {
        this.f10330a = 1;
        this.d = r5;
        this.f10331b = r10;
        this.e = r11;
        this.f10332c = r12;
    }
}
