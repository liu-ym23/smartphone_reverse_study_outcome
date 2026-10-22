package com.bytedance.ttnet;

import java.util.List;
import java.util.Map;
import o4.a0;
import o4.e0;
import o4.g0;
import o4.l;
import o4.o;
import o4.q;
import o4.t;
import o4.w;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkApi {
    @o4.h
    com.bytedance.retrofit2.b<String> doGet(@o4.a boolean r10, @o int r11, @g0 String r12, @a0(encode = true) Map<String, String> r13, @l List<n4.b> r14, @o4.d Object r15);

    @o4.h
    com.bytedance.retrofit2.b<r4.e> doGetBytes(@o4.a boolean r10, @o int r11, @g0 String r12, @a0(encode = true) Map<String, String> r13, @l List<n4.b> r14, @o4.d Object r15);

    @t
    @o4.g
    com.bytedance.retrofit2.b<String> doPost(@o int r10, @g0 String r11, @a0 Map<String, String> r12, @o4.f(encode = true) Map<String, String> r13, @l List<n4.b> r14, @o4.d Object r15);

    @e0
    @o4.h
    com.bytedance.retrofit2.b<r4.e> downloadFile(@o4.a boolean r10, @o int r11, @g0 String r12, @a0(encode = true) Map<String, String> r13);

    @e0
    @o4.h
    com.bytedance.retrofit2.b<r4.e> downloadFile(@o4.a boolean r10, @o int r11, @g0 String r12, @a0(encode = true) Map<String, String> r13, @l List<n4.b> r14, @o4.d Object r15);

    @t
    com.bytedance.retrofit2.b<String> postBody(@o int r10, @g0 String r11, @a0(encode = true) Map<String, String> r12, @o4.b r4.f r13, @l List<n4.b> r14);

    @q
    @t
    com.bytedance.retrofit2.b<String> postMultiPart(@o int r10, @g0 String r11, @a0(encode = true) Map<String, String> r12, @w Map<String, r4.f> r13, @l List<n4.b> r14);
}
