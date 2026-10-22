package com.bytedance.android.live.service;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.network.c;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.arch.data.TbDataFromType;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.sq;
import com.bytedance.android.livesdk.toolbarservice.api.IToolbarPlatformService;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.LiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomCart;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J<\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u00040\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/service/ToolbarPlatformService;", "Lcom/bytedance/android/livesdk/toolbarservice/api/IToolbarPlatformService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "checkPreloadView", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/ILiveToolbarData;", "toolbarData", "updateToolbarDataInRoom", "it", "updateCommerceData", "Lot2/b;", "getBottomToolbarLogImpl", "", "isPreload", "Lkotlin/Function2;", "", "onSuccess", "doubleCheckToolbarData", "onInitToolbarData", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/z;", "checkManager", "registerPlaceHold", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ToolbarPlatformService implements IToolbarPlatformService {

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ToolbarPlatformService a;
        public final /* synthetic */ DataCenter b;
        public final /* synthetic */ IRoom c;
        public final /* synthetic */ Function2 d;

        public a(ToolbarPlatformService r1, DataCenter r2, IRoom r3, Function2 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r5) {
            Response r6 = (Response) r5;
            if (r6 == null) goto L8;
            Room r7 = (Room) ((BaseResponse) r6).data;
            if (r7 == null) goto L9;
            ToolbarPlatformService.access$updateCommerceData(this.a, r7, this.b);
            ToolbarPlatformService.access$updateToolbarDataInRoom(this.a, this.c, this.b, r7.getToolbarData());
            this.b.put("cmd_new_toolbar_double_check", "commerce");
            this.d.invoke(TbDataFromType.DoubleCheckSuccess.getDesc(), r7.getToolbarData());
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ IRoom b;

        public b(Function2 r1, IRoom r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ALogger.i("NewToolbarLogV2", "Double Check Toolbar Data Error: " + ((Throwable) r3));
            this.a.invoke(TbDataFromType.DoubleCheckFail.getDesc(), this.b.getToolbarData());
        }
    }

    public ToolbarPlatformService() {
    }

    public void onInitToolbarData(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
    }

    public ot2.b getBottomToolbarLogImpl() {
        return com.bytedance.android.live.utils.a.e;
    }

    private final void checkPreloadView(DataCenter r5) {
        ArrayList r0 = CollectionsKt.arrayListOf(new ExtendedToolbarButton[]{ToolbarButton.COMMERCE.extended(), ToolbarButton.GAME_PROMOTE_AUDIENCE.extended()});
        c0 r6 = y3.m(r5);
        if ((r6 instanceof x3) == true) goto L5;
        r6 = null;
    L5:
        x3 r7 = (x3) r6;
        if (r7 == null) goto L23;
        Map r1 = r7.c;
        if (r1 == null) goto L35;
        Set r2 = ((HashMap) r1).keySet();
        if (r2 == null) goto L36;
        Iterator r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L37;
        ExtendedToolbarButton r4 = (ExtendedToolbarButton) r3.next();
        if (r0.contains(r4) == false) goto L13;
        if (r7.s(r4) != null) goto L13;
        Map r8 = r7.c;
        if (r8 == null) goto L13;
        View r9 = (View) ((HashMap) r8).get(r4);
        if (r9 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r9);
        goto L13
    L37:
        return;
    L36:
        return;
    L35:
        return;
    }

    private final void updateCommerceData(IRoom r6, DataCenter r7) {
        IRoomCart r0 = r6.getRoomCart();
        if (r0 != null) goto L5;
    L17:
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r7, 0, 2);
        if (r8 == null) goto L25;
        m r9 = r8.getRoom();
        if (r9 == null) goto L26;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L27;
        r10.setHasCommerceGoods(r6.isHasCommerceGoods());
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L5:
        if ((r0 instanceof RoomCart) == true) goto L8;
        r0 = null;
    L8:
        RoomCart r1 = (RoomCart) r0;
        if (r1 == null) goto L17;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, r7, 0, 2);
        if (r4 == null) goto L17;
        m r5 = r4.getRoom();
        if (r5 == null) goto L17;
        Room r12 = (Room) r5.getValue();
        if (r12 == null) goto L17;
        r12.setRoomCart(r1);
        goto L17
    }

    public void registerPlaceHold(DataCenter r2, z r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "checkManager");
        if (com.bytedance.android.live.core.utils.z.e(r2, false) == true) goto L5;
        r3.h(NewToolbarButtonConstants.CommerceCart.INSTANCE);
        r3.h(NewToolbarButtonConstants.ToolbarCommerceIM.INSTANCE);
        r3.h(NewToolbarButtonConstants.TransformWidget.INSTANCE);
        r3.h(NewToolbarButtonConstants.MiniGame.INSTANCE);
        r3.h(NewToolbarButtonConstants.ToolbarShare.INSTANCE);
        r3.h(NewToolbarButtonConstants.ToolbarIM.INSTANCE);
        r3.h(NewToolbarButtonConstants.LifeGroupon.INSTANCE);
    L5:
        r3.h(NewToolbarButtonConstants.LittleGame.INSTANCE);
        r3.h(NewToolbarButtonConstants.GamePromote.INSTANCE);
        r3.h(NewToolbarButtonConstants.MiniApp.INSTANCE);
    }

    public static final /* synthetic */ void access$updateCommerceData(ToolbarPlatformService r0, IRoom r1, DataCenter r2) {
        r0.updateCommerceData(r1, r2);
    }

    private final void updateToolbarDataInRoom(IRoom r4, DataCenter r5, ILiveToolbarData r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if ((r6 instanceof LiveToolbarData) == true) goto L7;
        r6 = null;
    L7:
        LiveToolbarData r7 = (LiveToolbarData) r6;
        if (r7 == null) goto L26;
        if (r4 != null) goto L11;
    L17:
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r8 == null) goto L27;
        m r9 = r8.getRoom();
        if (r9 == null) goto L28;
        Room r10 = (Room) r9.getValue();
        if (r10 == null) goto L29;
        r10.setToolbarData(r7);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L11:
        if ((r4 instanceof Room) == true) goto L14;
        r4 = null;
    L14:
        Room r12 = (Room) r4;
        if (r12 == null) goto L17;
        r12.setToolbarData(r7);
        goto L17
    }

    public static final /* synthetic */ void access$updateToolbarDataInRoom(ToolbarPlatformService r0, IRoom r1, DataCenter r2, ILiveToolbarData r3) {
        r0.updateToolbarDataInRoom(r1, r2, r3);
    }

    public void doubleCheckToolbarData(boolean r6, IRoom r7, DataCenter r8, Function2<? super String, ? super ILiveToolbarData, Unit> r9) {
        Intrinsics.checkNotNullParameter(r7, "room");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        Intrinsics.checkNotNullParameter(r9, "onSuccess");
        Boolean r10 = (Boolean) r8.get("data_current_is_preview", Boolean.FALSE);
        boolean r1 = true;
        boolean r2 = false;
        if (r7.getRoomCart() == null) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = r7.isHasCommerceGoods();
        boolean r4 = com.bytedance.android.live.core.utils.z.e(r8, false);
        if (r0 == true) goto L10;
        if (r3 == false) goto L10;
    L12:
        if (((Boolean) sq.a.getValue()).booleanValue() == false) goto L16;
        if (r4 == false) goto L16;
        r1 = false;
    L16:
        if (r10.booleanValue() == true) goto L19;
        r2 = r1;
    L19:
        if (r2 == false) goto L39;
        c r12 = c.b();
        if (r12 == null) goto L41;
        RoomRetrofitApi r13 = (RoomRetrofitApi) r12.e(RoomRetrofitApi.class);
        if (r13 == null) goto L42;
        Observable r14 = r13.getRoomInfoByScene(IRoomKtKt.getId((IRoomBase) r7), "check_toolbar");
        if (r14 == null) goto L43;
        Observable r15 = r14.observeOn(AndroidSchedulers.mainThread());
        if (r15 == null) goto L44;
        Observable r16 = r15.subscribeOn(Schedulers.io());
        if (r16 == null) goto L45;
        Disposable r17 = r16.subscribe(new a(this, r8, r7, r9), new b(r9, r7));
        if (r17 == null) goto L46;
        RoomContext r18 = RoomContext.a.c(RoomContext.Companion, r8, 0, 2);
        if (r18 == null) goto L47;
        i r19 = r18.getCompositeDisposable();
        if (r19 == null) goto L48;
        CompositeDisposable r20 = (CompositeDisposable) r19.getValue();
        if (r20 == null) goto L49;
        r20.add(r17);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L39:
        r9.invoke(TbDataFromType.Direct.getDesc(), r7.getToolbarData());
        return;
    L10:
        r1 = false;
        goto L12
    L5:
        r0 = false;
        goto L6
    }
}
