package com.bytedance.article.common.network;

import com.bytedance.retrofit2.b;
import java.util.List;
import java.util.Map;
import o4.a;
import o4.g;
import o4.g0;
import o4.h;
import o4.l;
import o4.o;
import o4.t;
import r4.e;
import r4.f;

/* JADX INFO: loaded from: classes.dex */
public interface ICommonApi {
    @h
    b<String> get(@o int r10, @g0 String r11, @l List<n4.b> r12, @a boolean r13);

    @t
    b<String> postData(@o int r10, @g0 String r11, @o4.b f r12, @l List<n4.b> r13, @a boolean r14);

    @t
    b<e> postDataStream(@o int r10, @g0 String r11, @o4.b f r12, @l List<n4.b> r13, @a boolean r14);

    @t
    @g
    b<String> postForm(@o int r10, @g0 String r11, @o4.f(encode = true) Map<String, String> r12, @l List<n4.b> r13, @a boolean r14);
}
