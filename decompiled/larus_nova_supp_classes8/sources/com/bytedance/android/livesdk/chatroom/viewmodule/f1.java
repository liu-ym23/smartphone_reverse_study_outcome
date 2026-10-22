package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f1 implements x2 {
    public boolean a;
    public final CompositeDisposable b;
    public final Function1<Long, Unit> c;
    public final long d;
    public final TimeUnit e;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x2
    public final void a() {
        if (this.a == false) goto L5;
        return;
    L5:
        this.a = true;
        com.bytedance.android.live.core.utils.rxutils.j.a r0 = com.bytedance.android.live.core.utils.rxutils.j.a;
        RxUtilKt.c(com.bytedance.android.live.core.utils.rxutils.j.a(0, this.d, this.e).filter(new a1(this)).doOnDispose(new b1(this)).doOnComplete(new c1(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d1(this), new e1(this)), this.b);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.x2
    public final void b() {
        this.b.clear();
        this.a = false;
    }

    public f1(Function1 r3, long r4) {
        TimeUnit r0 = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(r3, "task");
        Intrinsics.checkNotNullParameter(r0, "timeUnit");
        this.c = r3;
        this.d = r4;
        this.e = r0;
        this.b = new CompositeDisposable();
    }
}
