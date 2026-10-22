package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.api;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.LikeEggTopViewManager;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager.b;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager.c;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nu2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/api/VSLikeEggService;", "Lnu2/a;", "Lcom/bytedance/android/scope/o;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "getLikeEggTopViewManager", BuildConfig.FLAVOR, "canShow", "Landroid/view/ViewGroup;", "rootView", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/manager/a;", "guideTrayManager", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/manager/b;", "initLikeEggManager", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSLikeEggService implements a, o {
    public VSLikeEggService() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public boolean canShow() {
        int r0 = c.f;
        return com.bytedance.android.livesdk.chatroom.vs_base.base.util.a.a;
    }

    public Object getLikeEggTopViewManager(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        return new LikeEggTopViewManager(r2, r3);
    }

    public b initLikeEggManager(ViewGroup r2, DataCenter r3, com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.manager.a r4) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "guideTrayManager");
        return new c(r2, r3);
    }
}
