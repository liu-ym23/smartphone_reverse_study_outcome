package com.bytedance.android.live.profile.api;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.ies.sdk.widgets.Widget;
import h70.b;
import io.reactivex.Single;
import j70.h;
import kotlin.Metadata;
import ns0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.service.ProfileService")
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J&\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H&J0\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profile/api/IProfileService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "Lns0/a;", "createProfileOuterContext", "Lj70/h;", "Lh70/b;", "getProfileServiceWidgetDescriptor", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "getLiveProfileJsFactory", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getProfileServiceWidget", "Landroidx/fragment/app/FragmentActivity;", "context", "", "onWidgetLoaded", "", "openStatus", "isBeforeLive", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/base/model/user/r0;", "uploadAnchorStickerStatus", "", "anchorId", "anchorSecUid", "scene", "queryAnchorStickerStatus", "live-profile-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IProfileService extends IService {
    a createProfileOuterContext(o r1);

    IJsMethodsProvideService.IFactory getLiveProfileJsFactory();

    Widget getProfileServiceWidget();

    h<? extends b> getProfileServiceWidgetDescriptor();

    void onWidgetLoaded(FragmentActivity r1);

    Single<e<r0>> queryAnchorStickerStatus(String r1, String r2, String r3);

    Single<e<r0>> uploadAnchorStickerStatus(boolean r1, boolean r2);
}
