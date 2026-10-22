package com.bytedance.apm.impl;

import java.util.List;
import java.util.Map;
import o4.a0;
import o4.g0;
import o4.h;
import o4.l;
import o4.q;
import o4.t;
import o4.w;
import r4.e;
import r4.f;

/* JADX INFO: loaded from: classes.dex */
public interface RetrofitMonitorService {
    @h
    com.bytedance.retrofit2.b<e> fetch(@g0 String r10, @l List<n4.b> r11, @a0 Map<String, String> r12, @o4.a boolean r13);

    @h
    com.bytedance.retrofit2.b<e> fetch(@g0 String r10, @a0 Map<String, String> r11, @o4.a boolean r12);

    @t
    com.bytedance.retrofit2.b<e> report(@g0 String r10, @o4.b f r11, @l List<n4.b> r12, @o4.a boolean r13);

    @q
    @t
    com.bytedance.retrofit2.b<e> uploadFiles(@g0 String r10, @w Map<String, f> r11, @l List<n4.b> r12);
}
