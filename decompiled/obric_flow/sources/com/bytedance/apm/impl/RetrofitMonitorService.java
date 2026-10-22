package com.bytedance.apm.impl;

import ai.c;
import ci.a;
import ci.a0;
import ci.b;
import ci.g0;
import ci.h;
import ci.l;
import ci.q;
import ci.t;
import ci.w;
import fi.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface RetrofitMonitorService {
    @h
    c fetch(@g0 String r5, @a0 Map<String, String> r10, @a boolean r11);

    @t
    c report(@g0 String r5, @b j r10, @l List<bi.c> r11, @a boolean r12);

    @q
    @t
    c uploadFiles(@g0 String r5, @w Map<String, j> r10, @l List<bi.c> r11);
}
