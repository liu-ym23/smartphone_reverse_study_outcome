package com.lynx.animax;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements hm.a, pn.g, lk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9574c;

    public /* synthetic */ a(int r5, Object r10, Object r11) {
        this.f9572a = r5;
        this.f9573b = r10;
        this.f9574c = r11;
    }

    @Override // pn.g
    public HashMap a() {
        al.a r5 = (al.a) this.f9573b;
        r5.getClass();
        HashMap r10 = new HashMap();
        qn.b r11 = (qn.b) r5.f314b;
        r10.put("lynxsdk_fluency_scene", r11.f21536a);
        r10.put("lynxsdk_fluency_tag", r11.f21537b);
        qn.c r12 = (qn.c) this.f9574c;
        r10.put("lynxsdk_fluency_maximum_frames", Integer.valueOf(r12.f21541c));
        r10.put("lynxsdk_fluency_frames_number", Integer.valueOf(r12.f21539a));
        r10.put("lynxsdk_fluency_fps", Integer.valueOf(r12.f21540b));
        r10.put("lynxsdk_fluency_dur", Long.valueOf(r12.d));
        r10.put("lynxsdk_fluency_drop1_count", Integer.valueOf(r12.e));
        r10.put("lynxsdk_fluency_drop1_duration", Long.valueOf(r12.f));
        r10.put("lynxsdk_fluency_drop3_count", Integer.valueOf(r12.g));
        r10.put("lynxsdk_fluency_drop3_duration", Long.valueOf(r12.f21542h));
        r10.put("lynxsdk_fluency_drop7_count", Integer.valueOf(r12.f21543i));
        r10.put("lynxsdk_fluency_drop7_duration", Long.valueOf(r12.f21544j));
        r10.put("lynxsdk_fluency_drop25_count", Integer.valueOf(r12.f21545k));
        r10.put("lynxsdk_fluency_drop25_duration", Long.valueOf(r12.f21546l));
        r10.put("lynxsdk_fluency_drop1_count_per_second", Double.valueOf((((double) r12.e) * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop3_count_per_second", Double.valueOf((((double) r12.g) * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop7_count_per_second", Double.valueOf((((double) r12.f21543i) * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop25_count_per_second", Double.valueOf((((double) r12.f21545k) * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop1_ratio", Double.valueOf((r12.f * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop3_ratio", Double.valueOf((r12.f21542h * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop7_ratio", Double.valueOf((r12.f21544j * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_drop25_ratio", Double.valueOf((r12.f21546l * 1000.0d) / r12.d));
        r10.put("lynxsdk_fluency_pageconfig_probability", Double.valueOf(r11.f21538c));
        r10.put("lynxsdk_fluency_enabled_by_sampling", Integer.valueOf(r11.d.ordinal()));
        return r10;
    }

    @Override // hm.a
    public void a(AnimaXPlayer r5) {
        ((UIAnimaX) this.f9573b).getClass();
        JavaOnlyMap r10 = (JavaOnlyMap) ((ReadableMap) this.f9574c);
        com.lynx.animax.base.bridge.JavaOnlyMap r11 = new com.lynx.animax.base.bridge.JavaOnlyMap();
        r10.getClass();
        Iterator<Map.Entry<String, Object>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<String, Object> r13 = r12.next();
        if ((r13.getValue() instanceof String) == false) goto L4;
        r11.put(r13.getKey(), r13.getValue());
        goto L4
    L8:
        r5.setSrcPolyfill(r11);
    }

    @Override // lk.a
    public void a(String r5) {
        switch(this.f9572a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNull(r5);
        ((a2.c) this.f9573b).invoke(r5);
        ((Ref.BooleanRef) this.f9574c).element = false;
        return;
    L6:
        rh.i r10 = (rh.i) this.f9573b;
        r10.getClass();
        ((rh.g) this.f9574c).f21752a.f20239j.b(-7, "worker", r5);
        r10.f21761b.c(r5);
    }
}
