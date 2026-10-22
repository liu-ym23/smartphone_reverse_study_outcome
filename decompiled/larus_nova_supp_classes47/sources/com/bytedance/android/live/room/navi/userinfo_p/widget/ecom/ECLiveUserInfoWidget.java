package com.bytedance.android.live.room.navi.userinfo_p.widget.ecom;

import am2.x;
import android.animation.Animator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.f0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.room.navi.userinfo_p.element.UserInfoEntranceElement;
import com.bytedance.android.live.room.navi.userinfo_p.element.base.BaseElement;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import com.bytedance.android.live.room.y;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.common.h;
import com.bytedance.android.livesdk.common.i;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.performance.p;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IEcomData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.android.livesdkapi.room.controller.RoomControllerKeyProvider;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.android.livesdkapi.service.userinfo.ECUserInfo;
import com.bytedance.android.livesdkapi.service.userinfo.IECLiveUserInfoAbility;
import com.bytedance.android.livesdkapi.service.userinfo.IECUserInfoService;
import com.bytedance.android.livesdkapi.service.userinfo.IEntranceDataSource;
import com.bytedance.android.livesdkapi.service.userinfo.IUserInfoWidget;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z91.l;
import zg1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u00020\u00042\u00020\u0005:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/widget/ecom/ECLiveUserInfoWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/common/i;", "Lcom/bytedance/android/livesdkapi/service/userinfo/IECLiveUserInfoAbility;", "Lzg1/f;", "event", "", "onEvent", "<init>", "()V", "a", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveUserInfoWidget extends MiddlewareRoomRecyclableWidget implements Observer<KVData>, i, IECLiveUserInfoAbility {
    public static final /* synthetic */ int i = 0;
    public IECUserInfoService a;
    public IUserInfoWidget b;
    public ECUserInfoElementManager c;
    public Boolean d;
    public final CompositeDisposable e;
    public final BehaviorSubject<ECUserInfo> f;
    public o g;
    public final Lazy h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECLiveUserInfoWidget a;

        public b(ECLiveUserInfoWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ALogger.i("ECLiveUserInfoWidget", "RoomVisible");     // Catch: Throwable -> L6
            IUserInfoWidget r0 = this.a.b;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onEvent("roomVisible", new JSONObject());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c extends com.bytedance.android.live.core.tetris.task.a {
        public final /* synthetic */ ECLiveUserInfoWidget c;

        public final void run() {
            ECLiveUserInfoWidget r0 = this.c;
            int r1 = ECLiveUserInfoWidget.i;
            r0.prepareViewOnLoad();
            b(true);
        }

        public c(ECLiveUserInfoWidget r1) {
            this.c = r1;
            super("live_room_user_info_widget");
        }
    }

    public static final class d<T> implements h80.a {
        public final /* synthetic */ ECLiveUserInfoWidget a;

        public d(ECLiveUserInfoWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            IRoom r5 = (IRoom) r4;
            ALogger.i("ECLiveUserInfoWidget", "roomEntered");
            ECLiveUserInfoWidget r0 = this.a;
            int r1 = ECLiveUserInfoWidget.i;
            r0.zq();
            ECUserInfoElementManager r2 = this.a.c;
            if (r2 == null) goto L15;
            ALogger.d("ECUserInfoElementManager", "onWidgetRoomEntered");
            Iterator r3 = ((ArrayList) r2.a).iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            ((BaseElement) r3.next()).l(r5);
            goto L6
        L8:
            DataCenter r6 = ((Widget) r2.h).dataCenter;
            if (r6 == null) goto L16;
            o81.a r7 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r6);
            if (r7 == null) goto L17;
            r7.notifyWidgetRoomEnter(r5);
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    static {
    }

    public final /* synthetic */ String Lg() {
        return h.b(this);
    }

    public final /* synthetic */ String cg() {
        return h.c(this);
    }

    public final IEntranceDataSource getEntranceDataSource() {
        return (IEntranceDataSource) this.h.getValue();
    }

    public final int getLayoutId() {
        return 2131566973;
    }

    public final String getSpm() {
        return "a100.a100.a126";
    }

    public final String nc() {
        return "ECLiveUserInfoWidget";
    }

    public final /* synthetic */ boolean nq() {
        return h.a();
    }

    public final Animator startShowAnimation() {
        return null;
    }

    public final int supportClearScene() {
        return 282;
    }

    public final Observable<IFollowPair> getFollowStateChanged() {
        IMiddlewareUserService r0 = k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        e r1 = r0.user();
        if (r1 == null) goto L9;
        Observable<IFollowPair> r2 = r1.followStateChanged();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return null;
    }

    public final Function1<Map<String, String>, Unit> getShowAnchorProfile() {
        return new ECLiveUserInfoWidget$showAnchorProfile$1(this);
    }

    public final ECUserInfo getUserInfo() {
        return (ECUserInfo) this.f.getValue();
    }

    public final void onUnload() {
        ALogger.i("ECLiveUserInfoWidget", "onUnload");
        this.e.clear();
        this.d = Boolean.FALSE;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        ECUserInfoElementManager r1 = this.c;
        if (r1 == null) goto L23;
        ALogger.d("ECUserInfoElementManager", "onWidgetUnload");
        Iterator r2 = ((ArrayList) r1.a).iterator();
    L9:
        if (r2.hasNext() == false) goto L11;
        ((BaseElement) r2.next()).j();
        goto L9
    L11:
        DataCenter r3 = ((Widget) r1.h).dataCenter;
        if (r3 == null) goto L16;
        o81.a r4 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r3);
        if (r4 == null) goto L16;
        r4.notifyWidgetUnload();
    L16:
        UserInfoDataSource r5 = r1.c;
        if (r5 == null) goto L19;
        r5.b.clear();
        r5.d = false;
        r5.f = false;
        r5.h.getDataCenter().removeObserver(r5);
    L19:
        r1.e = null;
        Disposable r6 = r1.d;
        if (r6 == null) goto L22;
        r6.dispose();
    L22:
        r1.d = null;
    L23:
        View r7 = ((Widget) this).contentView;
        if ((r7 instanceof ViewGroup) == true) goto L26;
        r7 = null;
    L26:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L29;
        r8.removeAllViews();
    L29:
        IUserInfoWidget r9 = this.b;
        if (r9 == null) goto L32;
        r9.onUnload();
    L32:
        this.b = null;
        this.f.onNext(new ECUserInfo(null));
        this.g = null;
    }

    public final void prepareViewOnLoad() {
        ALogger.i("ECLiveUserInfoWidget", "prepareViewOnLoad");
        zq();
        ECUserInfoElementManager r0 = this.c;
        if (r0 == null) goto L13;
        ALogger.d("ECUserInfoElementManager", "onWidgetPrepareViewOnLoad");
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((BaseElement) r1.next()).k();
        goto L6
    L8:
        DataCenter r2 = ((Widget) r0.h).dataCenter;
        if (r2 == null) goto L13;
        o81.a r3 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r2);
        if (r3 == null) goto L13;
        r3.notifyWidgetViewPrepared();
    L13:
        ((Widget) this).dataCenter.put("cmd_userinfo_widget_show", Boolean.TRUE);
        runWithRoomEntered(new d(this));
    }

    public final IECUserInfoService wq() {
        if (this.a != null) goto L10;
        IHostCommerceServiceLive r0 = k.f(IHostCommerceServiceLive.class);
        if (r0 == null) goto L7;
        IECUserInfoService r1 = r0.getECUserInfoService();
    L8:
        this.a = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        if (this.a != null) goto L13;
        ALogger.e("ECLiveUserInfoWidget", "userInfoService is null");
    L13:
        return this.a;
    }

    public final void xq() {
        if (this.b == null) goto L5;
        return;
    L5:
        IUserInfoWidget r2 = null;
        IRoom r0 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r0 == null) goto L8;
        String r1 = String.valueOf(r0.getRoomId());
    L9:
        boolean r3 = false;
        Integer r4 = (Integer) ((Widget) this).dataCenter.get("room_controller_unique_key", 0);
        if (r1 != null) goto L12;
    L36:
        ALogger.w("ECLiveUserInfoWidget", "initECUserInfoWidget, roomId is null");
        return;
    L12:
        if (TextUtils.isEmpty(r1) == true) goto L36;
        String r5 = RoomControllerKeyProvider.generateKey(r1, r4.intValue());
        ALogger.i("ECLiveUserInfoWidget", "initECUserInfoWidget, roomId: " + r1 + " roomUniqueKey: " + r5);
        IECUserInfoService r6 = wq();
        if (r6 == null) goto L29;
        IUserInfoWidget r7 = r6.getUserInfoWidget(((Widget) this).contentView.getContext(), r1, r5, this);
        if (r7 == null) goto L29;
        IUserInfoWidget r8 = ((Widget) this).contentView;
        if ((r8 instanceof ViewGroup) == false) goto L22;
        r2 = r8;
    L22:
        ViewGroup r9 = (ViewGroup) r2;
        if (r9 == null) goto L25;
        r9.addView(r7.getView());
    L25:
        View r10 = ((Widget) this).contentView;
        if ((r10 instanceof ViewGroup) == true) goto L28;
        ALogger.e("ECLiveUserInfoWidget", "initECUserInfoWidget contentView is not ViewGroup: ".concat(r10.getClass().getName()));
    L28:
        Unit r12 = Unit.INSTANCE;
        r2 = r7;
    L29:
        this.b = r2;
        if (r2 != null) goto L38;
        StringBuilder r13 = new StringBuilder("initECUserInfoWidget, getUserInfoWidget return null userInfoService is null:");
        if (wq() != null) goto L34;
        r3 = true;
    L34:
        r13.append(r3);
        ALogger.e("ECLiveUserInfoWidget", r13.toString());
        return;
    L38:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void yq() {
        IUserInfoWidget r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.getTargetView(IUserInfoWidget.Target.ENTRANCE_CONTAINER);
    L6:
        boolean r3 = r2 instanceof ViewGroup;
        if (r3 == true) goto L9;
        View r4 = null;
    L10:
        ViewGroup r5 = (ViewGroup) r4;
        if (r5 == null) goto L16;
        ECUserInfoElementManager r6 = new ECUserInfoElementManager(this, r5);
        ALogger.d("ECUserInfoElementManager", "onWidgetInit");
        MiddlewareRoomRecyclableWidget r7 = r6.h;
        Fragment r8 = ((Widget) r7).widgetCallback.getWidgetManager().parentFragment;
        MiddlewareRoomRecyclableWidget r9 = r6.h;
        m91.d r10 = new m91.d(r7, r8, ((Widget) r9).dataCenter, r9.getRoomContext(), r6.a(), ((Widget) r6.h).isViewValid);
        List<BaseElement> r12 = r6.a;
        ArrayList r13 = new ArrayList();
        r13.add(new UserInfoEntranceElement(r10, r6.i));
        ((ArrayList) r12).addAll(r13);
        Unit r14 = Unit.INSTANCE;
        r6.b = r10;
        r6.b();
        m91.d r15 = r6.b;
        Intrinsics.checkNotNull(r15);
        r6.c = new UserInfoDataSource(r15);
        Iterator r16 = ((ArrayList) r6.a).iterator();
    L14:
        if (r16.hasNext() == false) goto L17;
        ((BaseElement) r16.next()).h();
    L17:
        this.c = r6;
        if (r6 != null) goto L29;
        StringBuilder r17 = new StringBuilder("initElementManager is null;entranceContainer is null: ");
        if (r2 != null) goto L22;
        boolean r18 = true;
    L23:
        r17.append(r18);
        r17.append(" entranceContainer type: ");
        if (r2 == null) goto L26;
        r1 = r2.getClass().getName();
    L26:
        r17.append(r1);
        r17.append("entranceContainer is ViewGroup: ");
        r17.append(r3);
        ALogger.e("ECLiveUserInfoWidget", r17.toString());
        return;
    L22:
        r18 = false;
        goto L23
    L29:
        return;
    L16:
        r6 = null;
        goto L17
    L9:
        r4 = r2;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void zq() {
        Integer r3 = null;
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
        r4 = r6.getShopAuthorHeader();
    L22:
        StringBuilder r7 = new StringBuilder("room is not available use fallbackShopAuthorHeader: ");
        r7.append(r4);
        r7.append(' ');
        IRoom r8 = (IRoom) ((Widget) this).dataCenter.get("data_room", null);
        if (r8 == null) goto L25;
        String r9 = r8.getLog_pb();
    L26:
        r7.append(r9);
        ALogger.e("ECLiveUserInfoWidget", r7.toString());
    L27:
        ECUserInfo r0 = new ECUserInfo(r4);
        this.f.onNext(r0);
        String r10 = r0.getEcomUserInfo();
        if (r2.a(r10) == false) goto L33;
        JSONObject r12 = new JSONObject(r10);     // Catch: Exception -> L32
    L34:
        if (r12 == null) goto L36;
        JSONObject r13 = r12.optJSONObject("mask_info");
    L37:
        if (r13 == null) goto L39;
        Integer r14 = Integer.valueOf(r13.optInt("type"));
    L40:
        if (r14 != null) goto L43;
    L45:
        if (r14 != null) goto L48;
    L50:
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L53;
        r15.put("data_ec_room_user_info_background", r3);
    L53:
        ALogger.i("ECLiveUserInfoWidget", "updateShadow maskInfoType is " + r14);
        return;
    L48:
        if (r14.intValue() != 2) goto L50;
        r3 = 2131234305;
        goto L50
    L43:
        if (r14.intValue() != 1) goto L45;
        r3 = 2131234304;
        goto L50
    L39:
        r14 = null;
        goto L40
    L36:
        r13 = null;
    L33:
        r12 = null;
        goto L34
    L25:
        r9 = null;
    L21:
        r4 = null;
        goto L22
    L11:
        if (r4.length() <= 0) goto L13;
        boolean r16 = true;
    L14:
        if (r16 == false) goto L16;
        ALogger.i("ECLiveUserInfoWidget", "EcomUserInfo shopAuthorHeader is not empty");
        ALogger.d("ECLiveUserInfoWidget", "EcomUserInfo shopAuthorHeader is ".concat(r4));
        goto L27
    L13:
        r16 = false;
    L7:
        r4 = null;
        goto L9
    }

    public ECLiveUserInfoWidget() {
        this.d = Boolean.FALSE;
        this.e = new CompositeDisposable();
        this.f = BehaviorSubject.create();
        this.h = LazyKt.lazy(new ECLiveUserInfoWidget$entranceDataSource$2(this));
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget*/.onDestroy();
        ALogger.i("ECLiveUserInfoWidget", "onDestroy isInitialized: " + isInitialized());
        if (isInitialized() == true) goto L14;
        ECUserInfoElementManager r0 = this.c;
        if (r0 == null) goto L11;
        ALogger.d("ECUserInfoElementManager", "clearElements");
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((BaseElement) r1.next()).f();
        goto L8
    L10:
        ((ArrayList) r0.a).clear();
    L11:
        this.c = null;
        this.f.onComplete();
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        if (r3.l(((Widget) this).context) == false) goto L10;
        IUserInfoWidget r0 = this.b;
        if (r0 == null) goto L7;
        View r1 = r0.getView();
    L8:
        r3.p(r1);
        return;
    L7:
        r1 = null;
        goto L8
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    public final Boolean uk() {
        return this.d;
    }

    /* JADX INFO: renamed from: getUserInfo, reason: collision with other method in class */
    public final Observable<ECUserInfo> m1103getUserInfo() {
        return this.f;
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
        ViewGroup r2 = ((Widget) this).containerView;
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
        if (r0 == null) goto L12;
        if (r4 != 8) goto L7;
    L10:
        r0.setVisibility(8);
        goto L12
    L7:
        if (r4 == 16) goto L10;
        if (r4 == 256) goto L10;
    L12:
        if (p.a() == true) goto L14;
        return;
    L14:
        View r1 = ((Widget) this).contentView;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r4 == 2) goto L19;
        return;
    L19:
        if (2 == r1.getLayerType()) goto L24;
        ((Widget) this).contentView.setLayerType(2, null);
        ALogger.i("ttlive_widget", "ECLiveUserInfoWidget Set LAYER_TYPE_HARDWARE");
        return;
    }

    public final void onEvent(f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        ALogger.i("ECLiveUserInfoWidget", "onEvent AnchorWidgetTranslationEvent leftSpace: " + r5.a + ", isExtend: " + r5.b);
        IUserInfoWidget r0 = this.b;
        if (r0 == null) goto L6;
        JSONObject r1 = new JSONObject();
        r1.put("left_space", r5.a);
        r1.put("is_extend", r5.b);
        Unit r6 = Unit.INSTANCE;
        r0.onEvent("AnchorWidgetTranslationEvent", r1);
        return;
    }

    public final void onExitClear(int r4) {
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L12;
        if (r4 != 8) goto L7;
    L10:
        r0.setVisibility(0);
        goto L12
    L7:
        if (r4 == 16) goto L10;
        if (r4 == 256) goto L10;
    L12:
        if (p.a() == true) goto L14;
        return;
    L14:
        View r1 = ((Widget) this).contentView;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r4 == 2) goto L19;
        return;
    L19:
        if (2 != r1.getLayerType()) goto L24;
        ((Widget) this).contentView.setLayerType(0, null);
        ALogger.i("ttlive_widget", "ECLiveUserInfoWidget Set LAYER_TYPE_NONE");
        return;
    }

    public final void onInit(Object[] r2) {
        ALogger.i("ECLiveUserInfoWidget", "onInit");
        zq();
        xq();
        yq();
    }

    public final void onLoad(Object[] r12) {
        ALogger.i("ECLiveUserInfoWidget", "onLoad");
        zq();
        if (MultiRoomConfig.INSTANCE.enableRev(Boolean.valueOf(z.e(((Widget) this).dataCenter, false))) == false) goto L5;
        int r0 = y.a;
        y.a(((Widget) this).dataCenter, this.e, "ECLiveUserInfoWidget#onLoad", new com.bytedance.android.live.room.navi.userinfo_p.widget.ecom.a(this));
    L7:
        if (this.g != null) goto L9;
        ALogger.e("ECLiveUserInfoWidget", "initFansClubContext, mFansClubContext is null");
    L9:
        xq();
        if (this.b != null) goto L22;
        ALogger.w("ECLiveUserInfoWidget", "checkWidgetUseFallback, ecLiveUserInfoWidget is null, use fallback");
        j0.l().sendLog("livesdk_ec_user_info_fallback", new LinkedHashMap(), new Object[]{x.class, IRoom.class});
        ba1.a r1 = new ba1.a(((Widget) this).contentView.getContext(), ((Widget) this).dataCenter, this);
        View r2 = ((Widget) this).contentView;
        if ((r2 instanceof ViewGroup) == true) goto L15;
        r2 = null;
    L15:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L18;
        r3.addView(r1.a);
    L18:
        View r4 = ((Widget) this).contentView;
        if ((r4 instanceof ViewGroup) == true) goto L21;
        ALogger.e("ECLiveUserInfoWidget", "checkWidgetUseFallback contentView is not ViewGroup: ".concat(r4.getClass().getName()));
    L21:
        Unit r5 = Unit.INSTANCE;
        this.b = r1;
    L22:
        yq();
        IUserInfoWidget r6 = this.b;
        if (r6 == null) goto L25;
        r6.onLoad();
    L25:
        ECUserInfoElementManager r7 = this.c;
        if (r7 == null) goto L49;
        ALogger.d("ECUserInfoElementManager", "onWidgetLoad");
        if (r7.b != null) goto L30;
        MiddlewareRoomRecyclableWidget r8 = r7.h;
        Fragment r9 = ((Widget) r8).widgetCallback.getWidgetManager().parentFragment;
        MiddlewareRoomRecyclableWidget r10 = r7.h;
        m91.d r13 = new m91.d(r8, r9, ((Widget) r10).dataCenter, r10.getRoomContext(), r7.a(), ((Widget) r7.h).isViewValid);
        List<BaseElement> r14 = r7.a;
        ArrayList r15 = new ArrayList();
        r15.add(new UserInfoEntranceElement(r13, r7.i));
        ((ArrayList) r14).addAll(r15);
        Unit r16 = Unit.INSTANCE;
        r7.b = r13;
    L30:
        m91.d r17 = r7.b;
        Intrinsics.checkNotNull(r17);
        if (Intrinsics.areEqual(r17.c, ((Widget) r7.h).dataCenter) == false) goto L33;
        ALogger.d("ECUserInfoElementManager", "widgetAbility!!.dataCenter == widget.dataCenter");
    L34:
        m91.d r18 = r7.b;
        if (r18 == null) goto L37;
        MiddlewareRoomRecyclableWidget r19 = r7.h;
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.a = r19;
        Fragment r20 = ((Widget) r7.h).widgetCallback.getWidgetManager().parentFragment;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r18.b = r20;
        DataCenter r22 = ((Widget) r7.h).dataCenter;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r18.c = r22;
        r18.d = r7.h.getRoomContext();
        aa1.a r23 = r7.a();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r18.e = r23;
    L37:
        r7.b();
        UserInfoDataSource r24 = r7.c;
        if (r24 == null) goto L40;
        int r25 = y.a;
        y.a(r24.h.getDataCenter(), r24.b, "UserInfoDataSource", new l(r24));
    L40:
        Iterator r26 = ((ArrayList) r7.a).iterator();
    L42:
        if (r26.hasNext() == false) goto L44;
        ((BaseElement) r26.next()).i();
        goto L42
    L44:
        DataCenter r27 = ((Widget) r7.h).dataCenter;
        if (r27 == null) goto L49;
        o81.a r28 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(r27);
        if (r28 == null) goto L49;
        r28.notifyWidgetLoad();
        goto L49
    L33:
        ALogger.d("ECUserInfoElementManager", "not equal");
    L49:
        ((Widget) this).dataCenter.observeForever("data_keyboard_status", this).observeForever("data_keyboard_status_douyin", this);
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(f.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.navi.userinfo_p.widget.ecom.b(new ECLiveUserInfoWidget$initEvents$1(this))), this.e);
        if (((Boolean) f0.a.getValue()).booleanValue() == false) goto L56;
        final c r29 = new c(this);
        com.bytedance.android.livesdk.chatroom.o r30 = z51.a.h(((Widget) this).dataCenter, 2);
        if (r30 == null) goto L57;
        j r32 = r30.B2();
        if (r32 == null) goto L57;
        r32.c(new AnonymousClass1(this, r29));
    L57:
        runWithRoomVisible(new b(this));
        ALogger.d("ECLiveUserInfoWidget", "ECLiveUserInfoWidget = " + System.currentTimeMillis());
        return;
    L56:
        prepareViewOnLoad();
        goto L57
    L5:
        this.g = yt0.c.c();
        goto L7
    }

    public final void qo(Boolean r1) {
        this.d = r1;
    }
}
