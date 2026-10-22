package com.bytedance.android.live.room.navi.userinfo_p.widget.ecom;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IEcomData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.room.controller.RoomControllerKeyProvider;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.service.userinfo.ECUserInfo;
import com.bytedance.android.livesdkapi.service.userinfo.IECLiveRankInfoAbility;
import com.bytedance.android.livesdkapi.service.userinfo.IECUserInfoService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import g81.i;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/widget/ecom/ECLiveLynxRankEntrance;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdkapi/service/userinfo/IECLiveRankInfoAbility;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveLynxRankEntrance extends MiddlewareRoomRecyclableWidget implements IECLiveRankInfoAbility, Observer<KVData> {
    public final CompositeDisposable a;
    public IECUserInfoService b;
    public IExternalWidget c;
    public final BehaviorSubject<ECUserInfo> d;

    public static final class a<T> implements h80.a {
        public final /* synthetic */ ECLiveLynxRankEntrance a;

        public a(ECLiveLynxRankEntrance r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IRoom r3 = (IRoom) r2;
            ALogger.i("ECLiveLynxRankEntrance", "roomEntered");
            this.a.xq();
        }
    }

    public final int getLayoutId() {
        return 2131565831;
    }

    public final int supportClearScene() {
        return 282;
    }

    public final void onUnload() {
        ALogger.w("ECLiveLynxRankEntrance", "onUnload");
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.a.clear();
        View r1 = ((Widget) this).contentView;
        if ((r1 instanceof ViewGroup) == true) goto L8;
        r1 = null;
    L8:
        ViewGroup r2 = (ViewGroup) r1;
        if (r2 == null) goto L11;
        r2.removeAllViews();
    L11:
        IExternalWidget r3 = this.c;
        if (r3 == null) goto L14;
        r3.onUnload();
    L14:
        this.c = null;
        this.d.onNext(new ECUserInfo(null));
    }

    public final void wq() {
        if (this.c == null) goto L5;
        return;
    L5:
        IECUserInfoService r2 = null;
        IRoom r0 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r0 == null) goto L8;
        String r1 = String.valueOf(r0.getRoomId());
    L9:
        boolean r3 = false;
        Integer r4 = (Integer) ((Widget) this).dataCenter.get("room_controller_unique_key", 0);
        if (r1 != null) goto L12;
    L46:
        ALogger.w("ECLiveLynxRankEntrance", "initECLiveRankWidget, roomId is null");
        return;
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L46;
        String r5 = RoomControllerKeyProvider.generateKey(r1, r4.intValue());
        ALogger.i("ECLiveLynxRankEntrance", "initECLiveRankWidget, roomId: " + r1 + " roomUniqueKey: " + r5);
        if (this.b != null) goto L21;
        IHostCommerceServiceLive r6 = k.f(IHostCommerceServiceLive.class);
        if (r6 == null) goto L19;
        IECUserInfoService r7 = r6.getECUserInfoService();
    L20:
        this.b = r7;
        goto L21
    L19:
        r7 = null;
    L21:
        IECUserInfoService r8 = this.b;
        if (r8 == null) goto L32;
        IExternalWidget r9 = r8.getECRankWidget(((Widget) this).contentView.getContext(), r1, r5, this);
        if (r9 == null) goto L32;
        View r10 = ((Widget) this).contentView;
        if ((r10 instanceof ViewGroup) == true) goto L28;
        r10 = null;
    L28:
        ViewGroup r12 = (ViewGroup) r10;
        if (r12 == null) goto L31;
        r12.addView(r9.getView());
    L31:
        Unit r13 = Unit.INSTANCE;
    L33:
        this.c = r9;
        if (r9 != null) goto L48;
        StringBuilder r14 = new StringBuilder("initECLiveRankWidget, getECRankWidget return null userInfoService is null:");
        if (this.b != null) goto L42;
        IHostCommerceServiceLive r15 = k.f(IHostCommerceServiceLive.class);
        if (r15 == null) goto L40;
        r2 = r15.getECUserInfoService();
    L40:
        this.b = r2;
    L42:
        if (this.b != null) goto L44;
        r3 = true;
    L44:
        r14.append(r3);
        ALogger.e("ECLiveLynxRankEntrance", r14.toString());
        return;
    L48:
        return;
    L32:
        r9 = null;
        goto L33
    L8:
        r1 = null;
        goto L9
    }

    public final void xq() {
        String r3 = null;
        IRoom r1 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r1 == null) goto L7;
        IEcomData r2 = r1.getEcomData();
        if (r2 == null) goto L7;
        String r4 = r2.getShopAuthorHeader();
    L9:
        if (r4 != null) goto L11;
    L16:
        IRoom r5 = (IRoom) ((Widget) this).dataCenter.get("data_room_template_SNAPSHOT", null);
        if (r5 == null) goto L21;
        IEcomData r6 = r5.getEcomData();
        if (r6 == null) goto L21;
        r3 = r6.getShopAuthorHeader();
    L21:
        ALogger.e("ECLiveLynxRankEntrance", "room is not available use fallbackShopAuthorHeader: " + r3);
        r4 = r3;
    L22:
        this.d.onNext(new ECUserInfo(r4));
        return;
    L11:
        if (r4.length() <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        ALogger.i("ECLiveLynxRankEntrance", "EcomUserInfo shopAuthorHeader is not empty");
        ALogger.d("ECLiveLynxRankEntrance", "EcomUserInfo shopAuthorHeader is ".concat(r4));
        goto L22
    L13:
        r7 = false;
    L7:
        r4 = null;
        goto L9
    }

    public ECLiveLynxRankEntrance() {
        this.a = new CompositeDisposable();
        this.d = BehaviorSubject.create();
    }

    public final void onClear() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onClear();
        ALogger.w("ECLiveLynxRankEntrance", "onClear");
        this.d.onComplete();
    }

    public final Observable<ECUserInfo> getUserInfo() {
        return this.d;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (isViewValid() == false) goto L26;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L31;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == 294674590) goto L17;
        if (r1 == 1060055221) goto L14;
        return;
    L14:
        if (r0.equals("data_keyboard_status") == false) goto L28;
    L18:
        Boolean r6 = (Boolean) r5.getData();
        if (r6 == null) goto L30;
        View r2 = ((Widget) this).contentView;
        if (r6.booleanValue() == false) goto L23;
        int r7 = 8;
    L24:
        UIUtils.setViewVisibility(r2, r7);
        return;
    L23:
        r7 = 0;
        goto L24
    L30:
        return;
    L28:
        return;
    L17:
        if (r0.equals("data_keyboard_status_douyin") == true) goto L18;
        return;
    L31:
        return;
    }

    public final void onEnterClear(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4 != 8) goto L7;
    L10:
        r0.setVisibility(8);
        return;
    L7:
        if (r4 == 16) goto L10;
        if (r4 == 256) goto L10;
    }

    public final void onExitClear(int r3) {
        View r0 = ((Widget) this).contentView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 != 8) goto L7;
    L10:
        r0.setVisibility(0);
        return;
    L7:
        if (r3 == 16) goto L10;
        if (r3 == 256) goto L10;
    }

    public final void onInit(Object[] r2) {
        ALogger.w("ECLiveLynxRankEntrance", "onInit");
        if (((Boolean) i.a.getValue()).booleanValue() == true) goto L7;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L7;
        r3.observeForever("data_keyboard_status", this);
        r3.observeForever("data_keyboard_status_douyin", this);
    L7:
        wq();
    }

    public final void onLoad(Object[] r2) {
        ALogger.w("ECLiveLynxRankEntrance", "onLoad, widget=" + this);
        if (((Boolean) i.a.getValue()).booleanValue() == false) goto L7;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L7;
        r3.observeForever("data_keyboard_status", this);
        r3.observeForever("data_keyboard_status_douyin", this);
    L7:
        wq();
        IExternalWidget r4 = this.c;
        if (r4 == null) goto L10;
        r4.onLoad();
    L10:
        xq();
        runWithRoomEntered(new a(this));
    }
}
