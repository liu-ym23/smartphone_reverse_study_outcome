package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements s42.c {
    public static final c a = null;

    public c() {
    }

    @Override // s42.c
    public final void b(int r1) {
    }

    @Override // s42.c
    public final void c() {
    }

    @Override // s42.c
    public final void d(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void e(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void f(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void g(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void i() {
    }

    @Override // s42.c
    public final void k(tlc.d r1) {
    }

    @Override // s42.c
    public final void l(tlc.d r1) {
    }

    @Override // s42.c
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void p(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void q(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.c
    public final void t(tlc.d r1) {
    }

    static {
        a = new c();
    }

    @Override // s42.c
    public final void n(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_COMMENT));
    }

    @Override // s42.c
    public final void o(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3) {
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_COMMENT));
    }

    @Override // s42.c
    public final void j(IWidget r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "cause");
        s42.c.a.b(r2, r3);
    }

    @Override // s42.c
    public final void s(IWidget r2, IRoom r3, s42.c.b r4) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r2, "widget");
        Intrinsics.checkNotNullParameter(r3, "room");
    }

    @Override // s42.c
    public final void a(TextMessageWidget r1, IRoom r2, boolean r3, boolean r4, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m r5) {
        Intrinsics.checkNotNullParameter(r1, "widget");
        Intrinsics.checkNotNullParameter(r2, "room");
        Intrinsics.checkNotNullParameter(r5, "publicScreenData");
        s42.c.a.a(r1, r2, r5);
    }
}
