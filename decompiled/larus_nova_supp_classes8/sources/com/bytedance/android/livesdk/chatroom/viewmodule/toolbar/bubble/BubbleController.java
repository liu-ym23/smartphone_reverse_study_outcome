package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class BubbleController {
    public final String a;
    public final Lazy b;
    public final Lazy c;
    public final CompositeDisposable d;
    public final BubbleEnv e;

    public final List<? extends h> a() {
        return (List) this.b.getValue();
    }

    public final void b() {
        if (this.e.a().d() == false) goto L6;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r0 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r0.d(this.a);
        r0.c("受频控影响无法加载气泡");
        MorePanelBubbleAlog.a(r0.b());
        return;
    L6:
        Function0<Unit> r1 = new BubbleController$onLoad$2(this);
        RoomContext r2 = this.e.b;
        if (r2 == null) goto L21;
        n r3 = r2.getInteractionDataPrepared();
        if (r3 == null) goto L21;
        if (((Room) r3.getValue()) == null) goto L14;
        r1.invoke();
        return;
    L14:
        Observable r4 = r3.a();
        if (r4 == null) goto L24;
        Observable r5 = RxUtilKt.h(r4);
        if (r5 == null) goto L25;
        Disposable r6 = r5.subscribe(new f(r1));
        if (r6 == null) goto L26;
        RxUtilKt.c(r6, this.d);
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L21:
        r1.invoke();
    }

    public BubbleController(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.e = r2;
        this.a = "BubbleController";
        this.b = LazyKt.lazy(new BubbleController$bubbleLoaders$2(this));
        this.c = LazyKt.lazy(new BubbleController$interceptors$2(this));
        this.d = new CompositeDisposable();
    }
}
