package com.bytedance.android.live.broadcast.api;

import android.app.Dialog;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.viewmodel.dialog.BroadcastDialogManager")
@ServiceDummyLookup("com.bytedance.android.live.broadcast.api.dummy.BroadcastDialogManagerDummy")
public interface IBroadcastDialogManager extends IService {
    void addDialogToMananger(Dialog r1);

    void addToShow(int r1, LifecycleOwner r2, Observer<Integer> r3);

    void promoteTasks();
}
