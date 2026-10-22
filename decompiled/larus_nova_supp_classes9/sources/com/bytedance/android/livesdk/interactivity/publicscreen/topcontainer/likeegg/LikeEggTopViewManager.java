package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg;

import android.content.Context;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui.LikeEggView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.LikeEggHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vr1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LikeEggTopViewManager implements f52.d {
    public static final /* synthetic */ int h = 0;
    public f52.b a;
    public Disposable b;
    public final Lazy<LikeEggView> c;
    public final Lazy d;
    public final String e;
    public final Context f;
    public final DataCenter g;

    public static final class a {
    }

    static {
    }

    @Override // f52.d
    public final void onUnload() {
        LikeEggHelper.h.clear();
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (this.c.isInitialized() == false) goto L13;
        LikeEggView r1 = (LikeEggView) this.d.getValue();
        r1.f();
        HSImageView r2 = r1.b;
        if (r2 == null) goto L10;
        r2.setController(null);
    L10:
        HSImageView r3 = r1.c;
        if (r3 == null) goto L13;
        r3.setController(null);
    L13:
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggTopViewManager onUnload");
    }

    @Override // f52.d
    public final String getId() {
        return this.e;
    }

    @Override // f52.d
    public final void j(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils.c.a("LikeEggTopViewManager onLoad");
        this.a = r3;
        n r4 = r.k();
        if (r4 == null) goto L5;
        r4.d(this.g, new LikeEggTopViewManager$onLoad$1(this));
    L5:
        EasterEggAnimationDialog.i.getClass();
        EasterEggAnimationDialog.h.set(0);
    }

    public LikeEggTopViewManager(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.f = r2;
        this.g = r3;
        Lazy<LikeEggView> r4 = LazyKt.lazy(new LikeEggTopViewManager$likeEggViewLazy$1(this));
        this.c = r4;
        this.d = r4;
        this.e = "LikeEggTopViewManager";
    }
}
