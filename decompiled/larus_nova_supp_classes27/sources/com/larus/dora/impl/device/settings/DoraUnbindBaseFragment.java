package com.larus.dora.impl.device.settings;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.dora.impl.device.DoraBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "mBroadcastReceiver", "com/larus/dora/impl/device/settings/DoraUnbindBaseFragment$mBroadcastReceiver$1", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment$mBroadcastReceiver$1;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraUnbindBaseFragment extends DoraBaseFragment {
    public final DoraUnbindBaseFragment$mBroadcastReceiver$1 f;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.impl.device.settings.DoraUnbindBaseFragment$mBroadcastReceiver$1] */
    public DoraUnbindBaseFragment() {
        this.f = new DoraUnbindBaseFragment$mBroadcastReceiver$1(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Context r0 = getContext();
        if (r0 == null) goto L6;
        LocalBroadcastManager.getInstance(r0).unregisterReceiver(this.f);
        return;
    }

    public void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        Context r5 = getContext();
        if (r5 == null) goto L6;
        LocalBroadcastManager.getInstance(r5).registerReceiver(this.f, new IntentFilter("action.DEVICE_UNBIND"));
        return;
    }
}
