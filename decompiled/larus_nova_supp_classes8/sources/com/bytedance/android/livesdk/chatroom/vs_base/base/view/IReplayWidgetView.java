package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/view/IReplayWidgetView;", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "getContext", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IReplayWidgetView extends LifecycleOwner {
    Context getContext();

    DataCenter getDataCenter();
}
