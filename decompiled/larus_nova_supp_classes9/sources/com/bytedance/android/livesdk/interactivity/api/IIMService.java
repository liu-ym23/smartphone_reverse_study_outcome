package com.bytedance.android.livesdk.interactivity.api;

import android.graphics.drawable.BitmapDrawable;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.IMService")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IIMService;", "Lcom/bytedance/android/live/base/IService;", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getIMServiceWidget", BuildConfig.FLAVOR, "initServiceProxy", "Landroid/graphics/drawable/BitmapDrawable;", "drawable", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "getImBehavior", "getImBehaviorInMore", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IIMService extends IService {
    Class<? extends LiveRecyclableWidget> getIMServiceWidget();

    c0.b getImBehavior(BitmapDrawable r1);

    c0.b getImBehaviorInMore(BitmapDrawable r1);

    void initServiceProxy();
}
