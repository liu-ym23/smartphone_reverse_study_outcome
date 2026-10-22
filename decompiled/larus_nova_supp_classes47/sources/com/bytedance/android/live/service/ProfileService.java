package com.bytedance.android.live.service;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.profile.api.IProfileService;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.profile.servicewidget.ProfileServiceWidget;
import com.bytedance.android.live.profile.servicewidget.f;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateUtil;
import com.bytedance.android.live.service.preinflate.ProfilePreInflateViewInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Single;
import j70.h;
import java.util.ArrayList;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J0\u0010\u001c\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/service/ProfileService;", "Lcom/bytedance/android/live/profile/api/IProfileService;", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "Lns0/a;", "createProfileOuterContext", "Lj70/h;", "Lh70/b;", "getProfileServiceWidgetDescriptor", "Lcom/bytedance/android/livesdkapi/jsb/IJsMethodsProvideService$IFactory;", "getLiveProfileJsFactory", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getProfileServiceWidget", "Landroidx/fragment/app/FragmentActivity;", "context", "", "onWidgetLoaded", "", "openStatus", "isBeforeLive", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/base/model/user/r0;", "uploadAnchorStickerStatus", "", "anchorId", "anchorSecUid", "scene", "queryAnchorStickerStatus", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ProfileService implements IProfileService {
    @Override // com.bytedance.android.live.profile.api.IProfileService
    public IJsMethodsProvideService.IFactory getLiveProfileJsFactory() {
        return new ws0.b();
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public Widget getProfileServiceWidget() {
        return new ProfileServiceWidget();
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public h<? extends h70.b> getProfileServiceWidgetDescriptor() {
        return new f();
    }

    public ProfileService() {
        k.l(IProfileService.class, this);
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public ns0.a createProfileOuterContext(o r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        return new ProfileOuterContext(r2);
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public void onWidgetLoaded(FragmentActivity r7) {
        if (ProfilePreInflateUtil.a() == true) goto L6;
        return;
    L6:
        if (r7 != null) goto L9;
        ALogger.e("NewUserProfile_PreLayout", "ProfileService onWidgetLoaded context is null");
        return;
    L9:
        m0 r1 = m0.a;
        Integer r2 = (Integer) r1.getValue();
        boolean r3 = true;
        int r4 = 0;
        if (r2 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L18;
        ALogger.i("NewUserProfile_PreLayout", "ProfileService onWidgetLoaded isFullPreInflate");
        ProfilePreInflateUtil.d(r7, ArraysKt.toList(ProfilePreInflateViewInfo.values()));
        return;
    L18:
        Integer r6 = (Integer) r1.getValue();
        if (r6 != null) goto L22;
    L24:
        r3 = false;
    L25:
        if (r3 == false) goto L38;
        ALogger.i("NewUserProfile_PreLayout", "ProfileService onWidgetLoaded isLazyPreInflate");
        ProfilePreInflateViewInfo[] r0 = ProfilePreInflateViewInfo.values();
        ArrayList r8 = new ArrayList();
        int r9 = r0.length;
    L27:
        if (r4 >= r9) goto L32;
        ProfilePreInflateViewInfo r10 = r0[r4];
        if (r10.getUsed() == false) goto L31;
        r8.add(r10);
    L31:
        r4 = r4 + 1;
        goto L27
    L32:
        ProfilePreInflateUtil.d(r7, r8);
        return;
    L38:
        return;
    L22:
        if (r6.intValue() != 2) goto L24;
    L13:
        if (r2.intValue() != 1) goto L15;
        r5 = true;
        goto L16
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public Single<e<r0>> uploadAnchorStickerStatus(boolean r10, boolean r12) {
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L20;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L21;
        String r3 = r1.n();
        if (r3 == null) goto L23;
        if (r10 == false) goto L11;
        long r4 = 1;
    L12:
        long r6 = r4;
        if (r12 == false) goto L15;
        String r8 = "start_live";
    L16:
        NewProfileApi r2 = (NewProfileApi) c.b().e(NewProfileApi.class);
        if (r2 != null) goto L19;
        return null;
    L19:
        return r2.uploadAnchorStickerStatusForSaas(r3, 1, r6, r8);
    L15:
        r8 = null;
        goto L16
    L11:
        r4 = 2;
        goto L12
    L23:
        return null;
    L21:
        return null;
    L20:
        return null;
    }

    @Override // com.bytedance.android.live.profile.api.IProfileService
    public Single<e<r0>> queryAnchorStickerStatus(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "anchorSecUid");
        NewProfileApi r5 = (NewProfileApi) c.b().e(NewProfileApi.class);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.queryAnchorStickerStatusForSaas(r2, r2, r4);
    }
}
