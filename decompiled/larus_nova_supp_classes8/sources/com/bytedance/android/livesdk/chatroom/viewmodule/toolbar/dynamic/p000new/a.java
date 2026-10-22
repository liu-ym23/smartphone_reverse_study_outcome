package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p000new;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ot2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements b {
    public static final a b = null;
    public final /* synthetic */ b a;

    public final String a() {
        return this.a.a();
    }

    public final String b() {
        return this.a.b();
    }

    public final Disposable c(int r2, Function1<? super Integer, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "checkFunc");
        return this.a.c(r2, r3);
    }

    public final String d() {
        return this.a.d();
    }

    public final String e() {
        return this.a.e();
    }

    public final void f(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, "room");
        this.a.f(r2);
    }

    public final void g(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "reason");
        this.a.g(r2, r3, r4);
    }

    public final String getTAG() {
        return this.a.getTAG();
    }

    public final void h(List<s> r2, Set<Integer> r3, Set<Integer> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "loadErrorIds");
        Intrinsics.checkNotNullParameter(r4, "showErrorIds");
        this.a.h(r2, r3, r4, r5);
    }

    public final int i() {
        return this.a.i();
    }

    public final void j(s r8, String r9, boolean r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r9, "action");
        this.a.j(r8, r9, r10, r11, r12);
    }

    static {
        b = new a();
    }

    public a() {
        this.a = k.n(IToolbarPlatformService.class).getBottomToolbarLogImpl();
    }
}
