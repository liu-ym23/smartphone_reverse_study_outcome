package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class OptionAction {
    public final ActionsManager a;
    public final Room b;
    public final Lazy c;
    public boolean d;

    public abstract void a(View r1);

    public void d(Function1<? super Map<String, ? extends Object>, Unit> r1) {
    }

    public void c() {
        ((CompositeDisposable) this.c.getValue()).clear();
    }

    public cz.c f() {
        return cz.c.r.c;
    }

    public OptionAction(ActionsManager r2) {
        Intrinsics.checkNotNullParameter(r2, "actionsManager");
        this.a = r2;
        this.b = r2.d;
        this.c = LazyKt.lazy(OptionAction$cd$2.INSTANCE);
    }

    public static /* synthetic */ void e(OptionAction r1) {
        r1.d(OptionAction$onShow$1.INSTANCE);
    }

    public void b(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        ILoginGuideService.Companion.getClass();
        ILoginGuideService r0 = ILoginGuideService.a.a();
        if (r0 != null) goto L5;
    L7:
        a(r4);
        com.bytedance.android.livesdk.dislike.m r5 = this.a.c;
        if (r5 == null) goto L11;
        r5.dismiss();
        return;
    L11:
        return;
    L5:
        if (r0.intercept(new q61.c(new q61.b.a(f()))) != true) goto L7;
    }
}
