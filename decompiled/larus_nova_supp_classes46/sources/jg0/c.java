package jg0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class c<T> implements f<T> {
    public ViewGroup a;
    public final MicSeatScene b;
    public final xg0.a c;

    @Override // jg0.f
    public void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public int o() {
        return 0;
    }

    @Override // jg0.f
    public void onDetach() {
    }

    @Override // jg0.f
    public final View l() {
        ViewGroup r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L5:
        return r0;
    }

    public final int n() {
        xg0.a r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getFeedType();
    }

    public final ViewGroup q() {
        ViewGroup r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L5:
        return r0;
    }

    public String p() {
        return getClass().getSimpleName();
    }

    @Override // jg0.f
    public void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        View r6 = VerticalNitaInflate.a(p(), o(), r5, null, false);
        if (r6 == null) goto L7;
        this.a = (ViewGroup) r6;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final View m(int r3) {
        ViewGroup r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L6:
        return r0.findViewById(r3);
    }

    public c(MicSeatScene r2, xg0.a r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.b = r2;
        this.c = r3;
    }
}
