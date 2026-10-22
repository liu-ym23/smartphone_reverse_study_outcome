package com.bytedance.android.live.room.navi;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IMiddlewareMicRoomService;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.tetris.desc.A11yInteractionShowDescriptor;
import com.bytedance.android.live.room.navi.tetris.desc.c;
import com.bytedance.android.live.room.navi.tetris.desc.d;
import com.bytedance.android.live.room.navi.tetris.desc.e;
import com.bytedance.android.live.room.navi.tetris.j;
import com.bytedance.android.live.room.navi.tetris.k;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.AnchorInfoWidgetLifecycleContext;
import com.bytedance.android.live.room.navi.userinfo_p.widget.ECShadowWidget;
import com.bytedance.android.live.room.navi.userinfo_p.widget.LiveRoomUserInfoPlatformWidget;
import com.bytedance.android.live.room.navi.userinfo_p.widget.NewLiveRoomUserInfoPlatformWidget;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import h70.b;
import j70.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import o81.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0014\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016J\u001e\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u00060\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/room/navi/NavigationService;", "Lcom/bytedance/android/live/room/api/INavigationService;", "Lj70/h;", "Lh70/b;", "getAnchorPortraitRoomNavigatorTetrisDescriptor", "getAudiencePortraitRoomNavigatorTetrisDescriptor", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "getNewLiveRoomUserInfoWidgetClass", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "getUserInfoWidget", "getECShadowWidget", "getLandscapeTopToolbarDescriptor", "getLandNaviTetrisDescriptor", "getLandscapeRoomNavigatorTetrisDescriptor", "", "", "Landroid/view/View;", "getPreTetrisLayout", "Lo81/a;", "createAnchorInfoWidgetLifeCycle", "Landroid/view/View$OnClickListener;", "getCloseClickListener", "getLandA11yInteractionShowDescritor", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class NavigationService implements INavigationService {
    private final String TAG;

    @Override // com.bytedance.android.live.room.api.INavigationService
    public Map<Integer, Class<? extends View>> getPreTetrisLayout() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(2131567158, null), TuplesKt.to(2131567156, null)});
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public a createAnchorInfoWidgetLifeCycle() {
        return new AnchorInfoWidgetLifecycleContext();
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public h<? extends b> getAnchorPortraitRoomNavigatorTetrisDescriptor() {
        return new com.bytedance.android.live.room.navi.tetris.desc.a();
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public h<? extends b> getAudiencePortraitRoomNavigatorTetrisDescriptor() {
        return new com.bytedance.android.live.room.navi.tetris.desc.b();
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public h<? extends b> getLandA11yInteractionShowDescritor() {
        return new A11yInteractionShowDescriptor();
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public h<? extends b> getLandNaviTetrisDescriptor() {
        return new c();
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public h<? extends b> getLandscapeRoomNavigatorTetrisDescriptor() {
        return new d();
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public h<? extends b> getLandscapeTopToolbarDescriptor() {
        return new e();
    }

    public NavigationService() {
        this.TAG = "NavigationService";
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public Class<? extends LiveRecyclableWidget> getECShadowWidget() {
        return ECShadowWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public Class<? extends LiveRecyclableWidget> getNewLiveRoomUserInfoWidgetClass() {
        return NewLiveRoomUserInfoPlatformWidget.class;
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public View.OnClickListener getCloseClickListener(DataCenter r2) {
        int r0 = k.a;
        return new j(r2);
    }

    @Override // com.bytedance.android.live.room.api.INavigationService
    public Class<? extends LiveRecyclableWidget> getUserInfoWidget(DataCenter r4) {
        o r1 = z51.a.h(r4, 2);
        if (r1 == null) goto L9;
        n r2 = r1.getTemplateContext();
        if (r2 == null) goto L9;
        z70.b r3 = (z70.b) r2.getValue();
        if (r3 == null) goto L9;
        boolean r5 = r3.j("anchor_avatar");
    L10:
        if (r5 == true) goto L12;
        return LiveRoomUserInfoPlatformWidget.class;
    L12:
        if (((Boolean) com.bytedance.android.live.misc.h.a.getValue()).booleanValue() == false) goto L30;
        IMiddlewareMicRoomService r6 = (IMiddlewareMicRoomService) jc1.k.f(IMiddlewareMicRoomService.class);
        o r7 = z51.a.h(r4, 2);
        Class<? extends LiveRecyclableWidget> r0 = null;
        if (r7 == null) goto L16;
        m r8 = r7.getRoom();
    L17:
        INavigationProxyService r9 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r9 == null) goto L22;
        l81.o r10 = r9.getMicRoomService();
        if (r10 == null) goto L22;
        r0 = r10.getMicRoomOfficialInfoWidget();
    L22:
        if (r8 != null) goto L24;
        return NewLiveRoomUserInfoPlatformWidget.class;
    L24:
        if (r8.getValue() == null) goto L35;
        if (r6 != null) goto L27;
        return NewLiveRoomUserInfoPlatformWidget.class;
    L27:
        if (r6.isMicRoom((IRoom) r8.getValue()) != true) goto L37;
        if (r0 == null) goto L38;
        return r0;
    L38:
        return NewLiveRoomUserInfoPlatformWidget.class;
    L37:
        return NewLiveRoomUserInfoPlatformWidget.class;
    L35:
        return NewLiveRoomUserInfoPlatformWidget.class;
    L16:
        r8 = null;
        goto L17
    L30:
        return NewLiveRoomUserInfoPlatformWidget.class;
    L9:
        r5 = false;
        goto L10
    }
}
