package com.bytedance.android.live.liveinteract.api.fulllink.revenue;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.fight.view.TeamFightPKProgressLayout;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
        MultiLinkEventModule r0 = MultiLinkEventModule.common;
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        PublishSubject.create();
        new CompositeDisposable();
    }

    public static void a(ConstraintLayout r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        int r0 = f.e;
        f.a.a(r1, TeamFightFullLinkMonitor$switchSceneSuccess$1.INSTANCE);
    }

    public static void b(TeamFightPKProgressLayout r1) {
        Intrinsics.checkNotNullParameter(r1, "view");
        int r0 = f.e;
        f.a.a(r1, TeamFightFullLinkMonitor$uiRenderEnd$1.INSTANCE);
    }
}
