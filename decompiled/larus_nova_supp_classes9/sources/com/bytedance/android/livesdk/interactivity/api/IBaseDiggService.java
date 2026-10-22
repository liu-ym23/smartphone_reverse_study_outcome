package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.DiggService")
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H&J\u001e\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0012\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001a\u0018\u00010\u0019H&J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u001cH&J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u001fH&J\u0010\u0010$\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\"H&J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020%H&¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IBaseDiggService;", "Lcom/bytedance/android/live/base/IService;", BuildConfig.FLAVOR, "roomId", BuildConfig.FLAVOR, "diggTargetUid", "diggExtraInfo", "Lu32/j;", "provideDiggHandler", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", BuildConfig.FLAVOR, "needPerformHapticFeedback", "Landroid/content/Context;", "context", "Lv32/b;", "getLikeView", "Lv32/d;", "initializer", "Lv32/a;", "getDefaultTapController", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lu32/l;", "provideDoubleLikeManager", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "digAccessibilityWidget", "Lu32/d$a;", "Lu32/d;", "provideDiggCountFlipperLayoutController", "Lu32/a$a;", "Lu32/a;", "provideDiggAvatarAnimationController", "Lu32/h$a;", "Lu32/h;", "provideDiggHeartAnimationController", "Lu32/o$a;", "Lu32/o;", "provideDiggThankAnimationController", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBaseDiggService extends IService {
    Class<? extends LiveRecyclableWidget> digAccessibilityWidget();

    v32.a getDefaultTapController(Context r1, v32.d r2);

    v32.b getLikeView(Context r1, DataCenter r2);

    boolean needPerformHapticFeedback(DataCenter r1, long r2);

    u32.a provideDiggAvatarAnimationController(u32.a.InterfaceC0285a r1);

    u32.d provideDiggCountFlipperLayoutController(u32.d.a r1);

    u32.j provideDiggHandler(long r1, String r3, String r4);

    u32.h provideDiggHeartAnimationController(u32.h.a r1);

    u32.o provideDiggThankAnimationController(u32.o.a r1);

    u32.l provideDoubleLikeManager(MiddlewareRoomContext r1);
}
