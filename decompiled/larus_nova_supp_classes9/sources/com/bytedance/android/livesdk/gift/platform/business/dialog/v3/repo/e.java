package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ StringBuilder a;
    public final /* synthetic */ Ref.LongRef b;
    public final /* synthetic */ Ref.LongRef c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ GiftExtraRepo f;
    public final /* synthetic */ List g;
    public final /* synthetic */ Set h;
    public final /* synthetic */ Function2 i;
    public final /* synthetic */ IBaseUser j;
    public final /* synthetic */ String k;
    public final /* synthetic */ Function1 l;

    public e(StringBuilder r1, Ref.LongRef r2, Ref.LongRef r3, long r4, boolean r6, GiftExtraRepo r7, List r8, Set r9, Function2 r10, IBaseUser r11, String r13, Function1 r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r13;
        this.l = r14;
    }

    public final void accept(Object r13) {
        Throwable r14 = (Throwable) r13;
        jy0.b.b("GiftExtraRepo", "failed", r14);
        this.l.invoke(r14);
        GiftExtraRepo.n(this.f, this.g, this.a, this.k, this.b.element, this.c.element, this.d, r14, this.e);
        GiftExtraRepo.k(this.f, this.g, this.a, this.k, this.b.element, this.c.element, null, r14, this.e);
    }
}
