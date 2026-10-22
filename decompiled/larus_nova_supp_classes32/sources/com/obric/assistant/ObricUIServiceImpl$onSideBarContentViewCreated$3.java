package com.obric.assistant;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/assistant/ObricUIServiceImpl$onSideBarContentViewCreated$3", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onResume", NameKeys.UnloadStrategy_No_Strategy, "owner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUIServiceImpl$onSideBarContentViewCreated$3 implements DefaultLifecycleObserver {
    public final /* synthetic */ View a;

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    public ObricUIServiceImpl$onSideBarContentViewCreated$3(ConstraintLayout r1) {
        this.a = r1;
    }

    public final void onDestroy(LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        ViewCompat.setOnApplyWindowInsetsListener(this.a, null);
        r3.getLifecycle().removeObserver(this);
    }

    public final void onResume(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        ViewCompat.requestApplyInsets(this.a);
    }
}
