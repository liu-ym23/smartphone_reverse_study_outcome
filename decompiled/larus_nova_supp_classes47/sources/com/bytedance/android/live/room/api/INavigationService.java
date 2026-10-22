package com.bytedance.android.live.room.api;

import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h70.b;
import j70.h;
import java.util.Map;
import kotlin.Metadata;
import o81.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.navi.NavigationService")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u001a\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH&J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0014\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH&J\u001e\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\b0\u0010H&J\b\u0010\u0015\u001a\u00020\u0014H&J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/room/api/INavigationService;", "Lcom/bytedance/android/live/base/IService;", "Lj70/h;", "Lh70/b;", "getAnchorPortraitRoomNavigatorTetrisDescriptor", "getAudiencePortraitRoomNavigatorTetrisDescriptor", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getUserInfoWidget", "getECShadowWidget", "getLandscapeTopToolbarDescriptor", "getLandNaviTetrisDescriptor", "getLandscapeRoomNavigatorTetrisDescriptor", "getNewLiveRoomUserInfoWidgetClass", "", "", "Landroid/view/View;", "getPreTetrisLayout", "Lo81/a;", "createAnchorInfoWidgetLifeCycle", "Landroid/view/View$OnClickListener;", "getCloseClickListener", "getLandA11yInteractionShowDescritor", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface INavigationService extends IService {
    a createAnchorInfoWidgetLifeCycle();

    h<? extends b> getAnchorPortraitRoomNavigatorTetrisDescriptor();

    h<? extends b> getAudiencePortraitRoomNavigatorTetrisDescriptor();

    View.OnClickListener getCloseClickListener(DataCenter r1);

    Class<? extends LiveRecyclableWidget> getECShadowWidget();

    h<? extends b> getLandA11yInteractionShowDescritor();

    h<? extends b> getLandNaviTetrisDescriptor();

    h<? extends b> getLandscapeRoomNavigatorTetrisDescriptor();

    h<? extends b> getLandscapeTopToolbarDescriptor();

    Class<? extends LiveRecyclableWidget> getNewLiveRoomUserInfoWidgetClass();

    Map<Integer, Class<? extends View>> getPreTetrisLayout();

    Class<? extends LiveRecyclableWidget> getUserInfoWidget(DataCenter r1);
}
