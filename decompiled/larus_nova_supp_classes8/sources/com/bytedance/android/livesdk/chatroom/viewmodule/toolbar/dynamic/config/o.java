package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarComponentCheckManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarMultiCameraBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.GetStreamPullDataResponse;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.ToolbarBehaviorApi;
import com.bytedance.android.livesdk.config.ox0;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IPullData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.room.handler.toolbar.NewToolbarButtonConstants;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import r52.j1;
import r52.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0 {
    public final DataCenter f;

    public static final class a implements ToolbarComponentCheckInterface {
        public final /* synthetic */ o a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.config.o$a$a, reason: collision with other inner class name */
        public static final class C0070a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Function0 b;

            public C0070a(a r1, Function0 r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r7) {
                Response r8 = (Response) r7;
                ALogger.i("VR_Multi_Reopen", "getStreamPullData success");
                if (r8 == null) goto L9;
                GetStreamPullDataResponse r9 = (GetStreamPullDataResponse) ((BaseResponse) r8).data;
                if (r9 == null) goto L9;
                StreamUrl r10 = r9.streamUrl;
                if (r10 == null) goto L9;
                Map r11 = r10.getPullDatas();
            L10:
                if (r11 != null) goto L12;
                return;
            L12:
                if (r11.size() <= 0) goto L60;
                Iterator r12 = r11.entrySet().iterator();
            L15:
                if (r12.hasNext() == false) goto L43;
                Map.Entry r2 = (Map.Entry) r12.next();
                StreamUrl r3 = com.bytedance.android.live.core.utils.z.o(this.a.a.f).getStreamUrl();
                if (r3 == null) goto L23;
                Map r4 = r3.getPullDatas();
                if (r4 == null) goto L23;
                boolean r5 = true;
                if (r4.containsKey(r2.getKey()) != true) goto L23;
            L24:
                ALogger.i("VR_Multi_Reopen", "hasData = " + r5);
                if (com.bytedance.android.live.core.utils.z.o(this.a.a.f).getStreamUrl() == null) goto L15;
                StreamUrl r6 = com.bytedance.android.live.core.utils.z.o(this.a.a.f).getStreamUrl();
                if (r6 == null) goto L29;
                Map r13 = r6.getPullDatas();
            L30:
                if (r13 == null) goto L31;
                StreamUrl r14 = com.bytedance.android.live.core.utils.z.o(this.a.a.f).getStreamUrl();
                if (r14 == null) goto L37;
                Map r15 = r14.getPullDatas();
            L39:
                if (TypeIntrinsics.isMutableMap(r15) == true) goto L41;
                r15 = null;
            L41:
                if (r15 == null) goto L15;
                IPullData r16 = (IPullData) r15.put(r2.getKey(), r2.getValue());
                goto L15
            L37:
                r15 = null;
                goto L39
            L31:
                LinkedHashMap r17 = new LinkedHashMap();
                r17.put(r2.getKey(), r2.getValue());
                StreamUrl r18 = com.bytedance.android.live.core.utils.z.o(this.a.a.f).getStreamUrl();
                if (r18 == null) goto L15;
                r18.setPullDatas(r17);
                goto L15
            L29:
                r13 = null;
            L23:
                r5 = false;
                goto L24
            L43:
                com.bytedance.live.datacontext.j r19 = ChatChannelUtils.n(RoomContext.a.c(RoomContext.Companion, this.a.a.f, 0, 2));
                if (r19 == null) goto L61;
                r19.c(new MultiCameraEntranceConfig$1$checkThenLoad$1$2(this));
                return;
            L61:
                return;
            L60:
                return;
            L9:
                r11 = null;
                goto L10
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ Function1 a;

            public b(Function1 r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                this.a.invoke("");
                ALogger.e("VR_Multi_Reopen", "getStreamPullData error", (Throwable) r3);
            }
        }

        public a(o r1) {
            this.a = r1;
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r2, Function0<Unit> r3, Function1<? super String, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "model");
            Intrinsics.checkNotNullParameter(r3, "loadButton");
            Intrinsics.checkNotNullParameter(r4, "stopLoadCallback");
            if (r2.isFromMsg() == false) goto L13;
            ALogger.i("NewToolbarLog", "load room channel callback.");
            Observable<Response<GetStreamPullDataResponse>> r5 = ((ToolbarBehaviorApi) com.bytedance.android.live.network.c.b().e(ToolbarBehaviorApi.class)).getStreamPullData(com.bytedance.android.live.core.utils.z.o(this.a.f).getIdStr());
            if (r5 == null) goto L15;
            Observable r6 = r5.subscribeOn(Schedulers.io());
            if (r6 == null) goto L16;
            Observable r7 = r6.observeOn(AndroidSchedulers.mainThread());
            if (r7 == null) goto L17;
            r7.subscribe(new C0070a(this, r3), new b(r4));
            return true;
        L17:
            return true;
        L16:
            return true;
        L15:
            return true;
        L13:
            return false;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w j() {
        ToolbarButton r1 = ToolbarButton.MULTI_CAMERA;
        return new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.w(r1, r1, null, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final NewToolbarButtonConstants k() {
        return NewToolbarButtonConstants.ToolbarMultiCamera.INSTANCE;
    }

    public o(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(null, null, 7);
        this.f = r3;
        if (ox0.a.getValue().booleanValue() == false) goto L6;
        Lazy r0 = ToolbarComponentCheckManager.a;
        ToolbarComponentCheckManager.e(r3, NewToolbarButtonConstants.ToolbarMultiCamera.INSTANCE, new a(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final boolean c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "button");
        ym0.b r5 = (ym0.b) GsonProtectorUtils.fromJson(GsonHelper.get(), r2.d, ym0.b.class);
        if (r5 == null) goto L7;
        Integer r6 = r5.a();
        if (r6 == null) goto L7;
        int r7 = r6.intValue();
    L8:
        if (r4 == false) goto L10;
        return false;
    L10:
        if (((Boolean) j1.a.getValue()).booleanValue() == true) goto L12;
        return false;
    L12:
        if (r7 == 1) goto L14;
    L15:
        if (r7 != 0) goto L20;
    L16:
        return true;
    L20:
        return false;
    L14:
        if (((Boolean) k1.a.getValue()).booleanValue() == true) goto L16;
    L7:
        r7 = 0;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b g(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1, boolean r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "button");
        if (r3 == false) goto L7;
        return null;
    L7:
        return new ToolbarMultiCameraBehavior(this.f);
    }
}
