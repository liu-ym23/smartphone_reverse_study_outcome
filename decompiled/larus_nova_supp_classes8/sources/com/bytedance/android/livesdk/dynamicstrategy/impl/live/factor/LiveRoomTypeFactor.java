package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.android.livesdkapi.toolbar.ToolbarBehaviorData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveRoomTypeFactor;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomTypeFactor extends DynamicFactor<Integer> implements Observer<KVData> {
    public Disposable b;
    public boolean c;
    public final DataCenter d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveRoomTypeFactor a;

        public b(LiveRoomTypeFactor r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IRoomCart r3 = ((IRoom) r2).getRoomCart();
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getShowCartExt() != 1) goto L9;
            this.a.update(2);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_room_type";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return Integer.valueOf(f(com.bytedance.android.live.core.utils.a0.o(this.d)));
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.d.observe("cmd_specific_behavior_loaded", this).observe("cmd_specific_behavior_un_loaded", this);
        if (com.bytedance.android.live.core.utils.a0.n(this.d).getRoomCart() != null) goto L15;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L13;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, this.d, 0, 2);
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L13;
        Observable r3 = r2.a();
        if (r3 == null) goto L13;
        Disposable r4 = r3.subscribe(new b(this));
    L14:
        this.b = r4;
    L13:
        r4 = null;
    L15:
        this.d.observe("data_room", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d.removeObserver(this);
    }

    public LiveRoomTypeFactor(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.d = r2;
    }

    public static int f(IRoom r3) {
        if (r3 != null) goto L5;
    L7:
        if (r3 == null) goto L13;
        IRoomCart r1 = r3.getRoomCart();
        if (r1 == null) goto L13;
        if (r1.getShowCartExt() != 1) goto L13;
        return 2;
    L13:
        if (r3 != null) goto L15;
    L17:
        if (r3 == null) goto L23;
        Map r2 = r3.getLinkMap();
        if (r2 == null) goto L23;
        if (r2.containsKey(String.valueOf(9)) != true) goto L23;
        return 4;
    L23:
        if (r3 != null) goto L25;
    L27:
        if (r3 != null) goto L29;
    L31:
        if (r3 != null) goto L33;
    L35:
        if (r3 == null) goto L43;
        IRoomOthersData r4 = r3.getRoomOthers();
        if (r4 == null) goto L43;
        IGroupLiveData r5 = r4.getGroupData();
        if (r5 == null) goto L43;
        if (r5.isGroupLive() != 1) goto L43;
        return 8;
    L43:
        return 0;
    L33:
        if (r3.isGameRoom() != 1) goto L35;
        return 7;
    L29:
        if (r3.isMediaRoom() != true) goto L31;
        return 6;
    L25:
        if (r3.isLifeLocal() != true) goto L27;
        return 5;
    L15:
        if (r3.isGameCPRoom() != true) goto L17;
        return 3;
    L5:
        if (r3.isMergeVSRoom() != true) goto L7;
        return 1;
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.getKey()) == true) goto L48;
        String r0 = r6.getKey();
        int r1 = r0.hashCode();
        Object r3 = null;
        if (r1 == (-435307162)) goto L25;
        if (r1 == (-363428784)) goto L18;
        if (r1 == 1995521258) goto L15;
        return;
    L15:
        if (r0.equals("cmd_specific_behavior_loaded") == true) goto L27;
        return;
    L27:
        if (((ToolbarBehaviorData) r6.getData(null)) == null) goto L44;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r7 = y3.m(this.d);
        ToolbarButton r2 = ToolbarButton.COMMERCE;
        if (r7.n(r2) == false) goto L34;
        if (this.c == true) goto L34;
        this.c = true;
        update(2);
        return;
    L34:
        if (y3.m(this.d).n(r2) == false) goto L36;
        return;
    L36:
        if (this.c == false) goto L47;
        this.c = false;
        update(0);
        return;
    L47:
        return;
    L44:
        return;
    L18:
        if (r0.equals("data_room") == false) goto L41;
        Object r8 = r6.getData();
        if ((r8 instanceof IRoom) == false) goto L23;
        r3 = r8;
    L23:
        update(Integer.valueOf(f((IRoom) r3)));
        return;
    L41:
        return;
    L25:
        if (r0.equals("cmd_specific_behavior_un_loaded") == true) goto L27;
        return;
    }
}
