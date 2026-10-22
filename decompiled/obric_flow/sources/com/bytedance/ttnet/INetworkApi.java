package com.bytedance.ttnet;

import ai.c;
import ci.a;
import ci.a0;
import ci.b;
import ci.d;
import ci.e0;
import ci.f;
import ci.g;
import ci.g0;
import ci.h;
import ci.l;
import ci.o;
import ci.q;
import ci.t;
import ci.w;
import fi.j;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface INetworkApi {
    @h
    c doGet(@a boolean r5, @o int r10, @g0 String r11, @a0(encode = true) Map<String, String> r12, @l List<bi.c> r13, @d Object r14);

    @g
    @t
    c doPost(@o int r5, @g0 String r10, @a0 Map<String, String> r11, @f(encode = true) Map<String, String> r12, @l List<bi.c> r13, @d Object r14);

    @e0
    @h
    c downloadFile(@a boolean r5, @o int r10, @g0 String r11, @a0(encode = true) Map<String, String> r12);

    @e0
    @h
    c downloadFile(@a boolean r5, @o int r10, @g0 String r11, @a0(encode = true) Map<String, String> r12, @l List<bi.c> r13, @d Object r14);

    @t
    c postBody(@o int r5, @g0 String r10, @a0(encode = true) Map<String, String> r11, @b j r12, @l List<bi.c> r13);

    @q
    @t
    c postMultiPart(@o int r5, @g0 String r10, @a0(encode = true) Map<String, String> r11, @w Map<String, j> r12, @l List<bi.c> r13);
}
