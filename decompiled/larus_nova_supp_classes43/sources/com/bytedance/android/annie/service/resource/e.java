package com.bytedance.android.annie.service.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.preload.PreloadSource;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e extends com.bytedance.android.annie.service.a {
    int A1(String r1, boolean r10, String r11, String r12, IHybridComponent.HybridType r13, boolean r14);

    boolean D1(String r1);

    boolean F0(String r1);

    d b1(String r1, String r10);

    void h(String r1);

    boolean l(String r1);

    int m(String r1, JSONObject r10, @PreloadSource String r11, String r12, String r13, IHybridComponent.HybridType r14, String r15, boolean r16);

    h o0(String r1, RequestConfig r10);

    String t1(String r1);

    h x(String r1, RequestConfig r10, Function1<? super i, Unit> r11);
}
