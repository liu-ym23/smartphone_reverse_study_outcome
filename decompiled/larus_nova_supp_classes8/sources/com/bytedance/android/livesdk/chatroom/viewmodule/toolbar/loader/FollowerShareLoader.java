package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.i0;
import com.bytedance.android.livesdk.dislike.recommendlive.RecommendLiveHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import ev1.m;
import ev1.n;
import io.reactivex.disposables.Disposable;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/FollowerShareLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FollowerShareLoader extends AbsDynamicLoader {
    public final i0 h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final boolean b() {
        return !z.e(this.a, false);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        if (((Boolean) n.a.getValue()).booleanValue() == false) goto L5;
        int r0 = RecommendLiveHelper.a;
        Room r1 = this.g;
        ILiveRecommendToFriendsService r2 = RecommendLiveHelper.d();
        if (r2 == null) goto L11;
        boolean r3 = r2.canShowItem(r1);
        boolean r4 = true;
        if (r3 != true) goto L11;
    L12:
        if (r4 == false) goto L19;
        if (k.n(IUserService.class).user().isLogin() == false) goto L19;
        return CollectionsKt.listOf(ToolbarButton.FollowerShare);
    L19:
        return CollectionsKt.emptyList();
    L11:
        r4 = false;
        goto L12
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        y3.f(this.a).p(ToolbarButton.FollowerShare.extended(), this.h);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        i0 r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) m.a.getValue()).booleanValue() == false) goto L17;
        Disposable r1 = r0.b;
        if (r1 != null) goto L9;
    L14:
        r0.b = null;
        r0.g.clear();
        return;
    L9:
        if ((!r1.isDisposed()) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L14;
        r1.dispose();
        goto L14
    }

    public FollowerShareLoader(e r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.h = new i0();
    }
}
