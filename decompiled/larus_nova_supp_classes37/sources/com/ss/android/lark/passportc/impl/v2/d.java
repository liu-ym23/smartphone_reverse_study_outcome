package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import com.ss.android.lark.passportc.impl.v2.state.AllUserState;
import h0c.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface d extends f<UpdateUserContext, UserState, j0c.a> {
    void a(UpdateUserContext r1, UserState r2, UserState r3, boolean r4);

    void b(UpdateUserContext r1, UserState r2, UserState r3, boolean r4);

    void c(UpdateUserRequest r1, com.ss.android.lark.passportc.api.d r2);

    void e(AllUserState r1, AllUserState r2);

    void g(UpdateUserContext r1, UserState r2, UserState r3, h0c.b<j0c.a> r4);

    void h(UpdateUserRequest r1, com.ss.android.lark.passportc.api.d r2, com.ss.android.lark.passportc.impl.v2.entity.c r3);

    void i(UpdateUserRequest r1, com.ss.android.lark.passportc.api.d r2);

    void j(UpdateUserRequest r1, com.ss.android.lark.passportc.api.d r2, Throwable r3);

    void k(UpdateUserContext r1, UserState r2, UserState r3, h0c.b.c r4);

    void m(UpdateUserContext r1, UserState r2, UserState r3);

    void n(UpdateUserContext r1, UserState r2, UserState r3, boolean r4);

    void o(UpdateUserContext r1, UserState r2, UserState r3, boolean r4);

    void p(UpdateUserContext r1, UserState r2, UserState r3);

    void q(com.ss.android.lark.passportc.impl.v2.entity.a r1);

    void r(UpdateUserRequest r1, com.ss.android.lark.passportc.api.d r2);
}
