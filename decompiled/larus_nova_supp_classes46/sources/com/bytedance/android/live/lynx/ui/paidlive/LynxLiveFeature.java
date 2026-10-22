package com.bytedance.android.live.lynx.ui.paidlive;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ListResponse;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.live.api.RoomStatApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.paidlive.IPaidLivePresenter;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.xelement.live.LynxLiveLight;
import com.bytedance.ies.xelement.live.impl.j;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/lynx/ui/paidlive/LynxLiveFeature;", "Lcom/bytedance/ies/xelement/live/LynxLiveLight;", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "", "play", "stop", "", "roomJson", "setRoom", "", "mute", "setVolume", "(Ljava/lang/Boolean;)V", "enable", "setEnableEnterRoom", "logParams", "setExtraLogParams", "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LynxLiveFeature extends LynxLiveLight {
    public static final /* synthetic */ int p = 0;
    public IPaidLivePresenter i;
    public Room j;
    public boolean k;
    public HashMap<String, Object> l;
    public boolean m;
    public final h n;
    public final f o;

    public static final class a implements com.bytedance.ies.xelement.live.a {
        public final /* synthetic */ LynxLiveFeature a;
        public final /* synthetic */ LynxContext b;

        public final void d() {
        }

        public final void isShared() {
        }

        public final void a(IXLivePlayerView r2) {
            Intrinsics.checkNotNullParameter(r2, "player");
            Intrinsics.checkNotNullParameter(r2, "player");
        }

        public final void b(HashMap r12) {
            Intrinsics.checkNotNullParameter(r12, "params");
            String r0 = (String) r12.get("room_id");
            String r2 = (String) r12.get("enter_from_merge");
            String r13 = (String) r12.get("enter_method");
            Context r4 = null;
            if (r0 == null) goto L6;
            Long r1 = a36.b.f(r0);
            if (r1 == null) goto L6;
        L10:
            if (r1 == null) goto L12;
            long r5 = r1.longValue();
        L13:
            Room r3 = this.a.j;
            if (r3 == null) goto L16;
            String r6 = r3.getMultiStreamData();
        L17:
            this.a.getClass();
            Bundle r7 = new Bundle();
            r7.putLong("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME", System.currentTimeMillis());
            r7.putString("enter_from_merge", r2);
            r7.putString("live.intent.extra.EXTRA_USER_ACTION_ENTER_ROOM_TYPE", "type_no_feed");
            r7.putString("enter_method", r13);
            r7.putString("live.intent.extra.ENTER_TYPE", "click");
            r7.putString("live.intent.extra.PULL_STREAM_DATA", r6);
            Bundle r8 = new Bundle();
            r8.putString("enter_method", r13);
            r8.putString("enter_from_merge", r2);
            Unit r14 = Unit.INSTANCE;
            m0.e(r7, r8);
            IHostAction r15 = k.n(IHostAction.class);
            LynxContext r9 = this.b;
            if (r9 == null) goto L20;
            r4 = r9.getContext();
        L20:
            r15.startLive(r4, r5, r7);
            return;
        L16:
            r6 = null;
            goto L17
        L12:
            r5 = 0;
        L6:
            Room r10 = this.a.j;
            if (r10 == null) goto L9;
            r1 = Long.valueOf(r10.id);
            goto L10
        L9:
            r1 = null;
            goto L10
        }

        public a(LynxLiveFeature r1, LynxContext r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void c(IXLivePlayerView r3, com.bytedance.ies.xelement.live.impl.i r4) {
            Intrinsics.checkNotNullParameter(r3, "player");
            Intrinsics.checkNotNullParameter(r4, "observer");
            Intrinsics.checkNotNullParameter(r3, "player");
            Intrinsics.checkNotNullParameter(r4, "observer");
        }

        public final void e(IXLivePlayerView r3, Observer<ILivePlayerScene> r4) {
            Intrinsics.checkNotNullParameter(r3, "player");
            Intrinsics.checkNotNullParameter(r4, "observer");
            Intrinsics.checkNotNullParameter(r3, "player");
            Intrinsics.checkNotNullParameter(r4, "observer");
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LynxLiveFeature a;

        public c(LynxLiveFeature r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            List<T> r11 = ((ListResponse) r10).data;
            Long r2 = null;
            if (r11 == null) goto L19;
            Iterator<T> r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L17;
            T r3 = r12.next();
            long r4 = ((ng2.f) r3).roomId;
            Room r6 = this.a.j;
            if (r6 == null) goto L10;
            long r7 = r6.id;
        L12:
            if (r4 != r7) goto L14;
            boolean r5 = true;
        L15:
            if (r5 == false) goto L6;
        L18:
            ng2.f r8 = (ng2.f) r3;
        L20:
            if (r8 != null) goto L22;
        L24:
            boolean r13 = false;
        L25:
            if (r13 == true) goto L36;
            LynxLiveFeature r14 = this.a;
            Pair[] r0 = new Pair[1];
            Room r9 = r14.j;
            if (r9 == null) goto L29;
            r2 = Long.valueOf(r9.id);
        L29:
            r0[0] = TuplesKt.to("room_id", String.valueOf(r2));
            LynxLiveFeature.Q(r14, "liveEnd", MapsKt.mutableMapOf(r0));
            return;
        L36:
            return;
        L22:
            if (r8.alive != true) goto L24;
            r13 = true;
            goto L25
        L14:
            r5 = false;
            goto L15
        L10:
            r7 = 0;
            goto L12
        L17:
            r3 = null;
            goto L18
        L19:
            r8 = null;
            goto L20
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r1) {
            Logger.e(((Throwable) r1).getMessage());
        }
    }

    public static final class e extends BDNetworkTagContextProviderAdapter {
        public final int triggerType() {
            return 0;
        }

        public e() {
        }
    }

    public static final class f<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ LynxLiveFeature a;

        public f(LynxLiveFeature r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L10;
            StringBuilder r4 = new StringBuilder("first frame: room id=");
            Room r0 = this.a.j;
            if (r0 == null) goto L7;
            Long r1 = Long.valueOf(r0.id);
        L8:
            r4.append(r1);
            ALogger.i("LynxLiveFeature", r4.toString());
            return;
        L7:
            r1 = null;
            goto L8
        }
    }

    public static final class g implements Callback {
        public final /* synthetic */ LynxLiveFeature a;
        public final /* synthetic */ Callback b;

        public g(LynxLiveFeature r1, Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void invoke(Object[] r9) {
            StringBuilder r0 = new StringBuilder("receive play callback, args[0]=");
            r0.append(r9[0]);
            r0.append(", roomId=");
            Room r2 = this.a.j;
            if (r2 == null) goto L5;
            Long r3 = Long.valueOf(r2.id);
        L6:
            r0.append(r3);
            ALogger.i("LynxLiveFeature", r0.toString());
            if (Intrinsics.areEqual(r9[0], 0) == false) goto L26;
            LynxLiveFeature r1 = this.a;
            com.bytedance.ies.xelement.live.c r5 = ((LynxLiveLight) r1).f;
            if (r5 == null) goto L11;
            IXLivePlayerView r6 = r5.b();
        L13:
            if ((r6 instanceof IXLivePlayerView) == true) goto L15;
            r6 = null;
        L15:
            if (r6 == null) goto L17;
            ILivePlayerClient r7 = r6.client();
        L18:
            ALogger.i("LynxLiveFeature", "startPlay: client=" + r7 + ", messageManager=null, isMute=" + r1.k);
            if (r7 == null) goto L26;
            IRoomEventHub r4 = r7.getEventHub();
            r4.getPlayComplete().observeForever(r1.n);
            r4.getFirstFrame().observeForever(r1.o);
            IPaidLivePresenter r8 = r1.i;
            if (r8 == null) goto L23;
            r8.autoChangeMuteStatus(!r1.k);
        L23:
            IPaidLivePresenter r10 = r1.i;
            if (r10 == null) goto L26;
            IPaidLivePresenter.DefaultImpls.onLiveStart$default(r10, r7, null, 2, null);
            goto L26
        L17:
            r7 = null;
            goto L18
        L11:
            r6 = null;
        L26:
            Callback r11 = this.b;
            if (r11 == null) goto L30;
            r11.invoke(new Object[]{r9[0]});
            return;
        L30:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class h<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ LynxLiveFeature a;

        public h(LynxLiveFeature r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            LynxLiveFeature r3 = this.a;
            int r0 = LynxLiveFeature.p;
            r3.R();
            return;
        }
    }

    public static final class i implements Callback {
        public final /* synthetic */ LynxLiveFeature a;
        public final /* synthetic */ Callback b;

        public i(LynxLiveFeature r1, Callback r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void invoke(Object[] r5) {
            StringBuilder r0 = new StringBuilder("receive stop callback, args[0]=");
            r0.append(r5[0]);
            r0.append(", roomId=");
            Room r2 = this.a.j;
            if (r2 == null) goto L5;
            Long r3 = Long.valueOf(r2.id);
        L6:
            r0.append(r3);
            ALogger.i("LynxLiveFeature", r0.toString());
            if (Intrinsics.areEqual(r5[0], 0) == false) goto L12;
            LynxLiveFeature r1 = this.a;
            IPaidLivePresenter r4 = r1.i;
            if (r4 == null) goto L11;
            r4.onStopPreview();
        L11:
            r1.S();
        L12:
            Callback r6 = this.b;
            if (r6 == null) goto L16;
            r6.invoke(new Object[]{r5[0]});
            return;
        L16:
            return;
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
    }

    public final void R() {
        if (this.j != null) goto L5;
        return;
    L5:
        e r0 = new e();
        String r1 = (String) BDNetworkTagManager.getInstance().buildBDNetworkTag(r0).second;
        RoomStatApi r2 = (RoomStatApi) com.bytedance.android.live.network.c.b().e(RoomStatApi.class);
        Room r3 = this.j;
        if (r3 == null) goto L8;
        Long r4 = Long.valueOf(r3.id);
    L9:
        r2.checkRoom(r1, String.valueOf(r4)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public final void S() {
        com.bytedance.ies.xelement.live.c r0 = ((LynxLiveLight) this).f;
        IRoomEventHub r1 = null;
        if (r0 == null) goto L5;
        IXLivePlayerView r2 = r0.b();
    L7:
        if ((r2 instanceof IXLivePlayerView) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        ILivePlayerClient r3 = r2.client();
    L12:
        if (r3 == null) goto L14;
        r1 = r3.getEventHub();
    L14:
        if (r1 == null) goto L18;
        MutableLiveData r4 = r1.getPlayComplete();
        if (r4 == null) goto L18;
        r4.removeObserver(this.n);
    L18:
        if (r1 == null) goto L23;
        MutableLiveData r5 = r1.getFirstFrame();
        if (r5 == null) goto L24;
        r5.removeObserver(this.o);
        return;
    L24:
        return;
    L23:
        return;
    L11:
        r3 = null;
        goto L12
    L5:
        r2 = null;
        goto L7
    }

    public final void destroy() {
        super.destroy();
        IPaidLivePresenter r0 = this.i;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.i = null;
    }

    public final void onDetach() {
        super.onDetach();
        IPaidLivePresenter r0 = this.i;
        if (r0 == null) goto L5;
        r0.onStopPreview();
    L5:
        S();
    }

    public LynxLiveFeature(LynxContext r2) {
        super(r2, null);
        this.m = true;
        this.n = new h(this);
        this.o = new f(this);
        a r0 = new a(this, r2);
        ((LynxLiveLight) this).a = r0;
        j r3 = ((LynxLiveLight) this).f;
        if (r3 == null) goto L9;
        r3.f = r0;
        View r4 = getView();
        if (r4 == null) goto L10;
        r4.setOnClickListener(new ul0.a(this));
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xelement.live.impl.LynxLiveLightPlayerDefaultImpl");
    }

    @LynxProp(name = "enablelynxenterroom")
    public final void setEnableEnterRoom(Boolean r2) {
        this.m = Intrinsics.areEqual(r2, Boolean.TRUE);
    }

    @LynxProp(name = "extralogparams")
    public final void setExtraLogParams(ReadableMap r1) {
        if (r1 == null) goto L4;
        HashMap<String, Object> r2 = r1.toHashMap();
    L5:
        this.l = r2;
        return;
    L4:
        r2 = null;
        goto L5
    }

    @LynxProp(name = "roomdata")
    public final void setRoom(String r3) {
        this.j = (Room) GsonHelper.get().fromJson(r3, Room.class);     // Catch: Exception -> L4
    L6:
        Room r4 = this.j;
        Long r0 = null;
        if (r4 == null) goto L9;
        String r5 = r4.getMultiStreamData();
    L10:
        super.setStreamData(r5);
        Room r6 = this.j;
        if (r6 == null) goto L13;
        r0 = Long.valueOf(r6.id);
    L13:
        super.setRoomId(String.valueOf(r0));
        HashMap r7 = new HashMap();
        List r1 = com.ss.ugc.live.sdk.platform.a.a;
        Intrinsics.checkNotNullParameter(r7, "customParams");
        throw new RuntimeException("message platform has not init");
    L9:
        r5 = null;
    L4:
        e = move-exception;
        ALogger.e("LynxLiveFeature", "episode parse error: " + e.getMessage());
        goto L6
    }

    @LynxProp(name = "mute")
    public void setVolume(Boolean r3) {
        super.setVolume(r3);
        ALogger.i("LynxLiveFeature", "set volume: mute=" + r3 + ", paidLivePresenter=" + this.i);
        boolean r4 = Intrinsics.areEqual(r3, Boolean.TRUE);
        this.k = r4;
        IPaidLivePresenter r0 = this.i;
        if (r0 == null) goto L6;
        r0.autoChangeMuteStatus(!r4);
        return;
    }

    @LynxUIMethod
    public void play(ReadableMap r2, Callback r3) {
        R();
        super.play(r2, new g(this, r3));
    }

    @LynxUIMethod
    public void stop(ReadableMap r2, Callback r3) {
        super.stop(r2, new i(this, r3));
    }

    public static final void Q(LynxLiveFeature r3, String r4, Map r5) {
        EventEmitter r0 = r3.getLynxContext().getEventEmitter();
        m7a.a r1 = new m7a.a(r3.getSign(), r4);
        Iterator r6 = r5.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r7 = (String) r6.next();
        r1.a(r7, r5.get(r7));
        goto L4
    L6:
        Unit r8 = Unit.INSTANCE;
        r0.sendCustomEvent(r1);
    }
}
