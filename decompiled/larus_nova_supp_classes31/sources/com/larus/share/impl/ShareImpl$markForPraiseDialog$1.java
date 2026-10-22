package com.larus.share.impl;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"com/larus/share/impl/ShareImpl$markForPraiseDialog$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "hasPaused", "", "onResume", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onPause", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ShareImpl$markForPraiseDialog$1 implements DefaultLifecycleObserver {
    public boolean a;

    public ShareImpl$markForPraiseDialog$1() {
    }

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onDestroy(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onDestroy(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public final void onPause(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        DefaultLifecycleObserver.-CC.$default$onPause(this, r2);
        this.a = true;
    }

    public final void onResume(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        DefaultLifecycleObserver.-CC.$default$onResume(this, r3);
        if (this.a == true) goto L5;
        return;
    L5:
        IAiChatPraiseTriggerService r0 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r0 == null) goto L8;
        r0.d();
    L8:
        r3.getLifecycle().removeObserver(this);
    }
}
