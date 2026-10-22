package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.m3;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.m4;
import com.bytedance.android.livesdkapi.depend.model.live.AIPublicScreenContainer;
import com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer;
import com.bytedance.android.livesdkapi.depend.model.live.IPSSelectedMessageInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/presenter/SelectedMsgViewManager;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lfa2/a;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectedMsgViewManager implements l, Observer<KVData>, fa2.a {
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> m = null;
    public final Lazy a;
    public IRoom b;
    public boolean c;
    public final CompositeDisposable d;
    public boolean e;
    public long f;
    public long g;
    public AIPublicScreenContainer h;
    public final DataCenter i;
    public final ViewGroup j;
    public final e52.a k;
    public final fa2.d l;

    public static final class a {
    }

    public final ha2.a d() {
        return (ha2.a) this.a.getValue();
    }

    static {
        m = new com.bytedance.android.livesdk.sharedpref.e("anchor_change_public_screen_height_when_open", Boolean.FALSE);
    }

    @Override // fa2.a
    public final boolean c() {
        if (this.f != 1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // fa2.a
    public final boolean a() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g != 1) goto L7;
        return true;
    }

    @Override // fa2.a
    public final boolean b() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.g != 2) goto L7;
        return true;
    }

    @Override // fa2.a
    public final AIPublicScreenContainer getAiPublicScreenContainer() {
        return this.h;
    }

    public final void e(IRoom r7) {
        Intrinsics.checkNotNullParameter(r7, "room");
        this.b = r7;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(this.i).b(o42.b.class).subscribe(new e(this)), this.d);
        RxUtilKt.c(xs2.b.a().b(o42.d.class).subscribe(new f(this)), this.d);
        vlc.d r8 = (vlc.d) this.i.get("data_message_manager");
        if (r8 == null) goto L5;
        r8.addMessageListener("WebcastFeaturedPublicScreenSettingMessage", this);
        r8.addMessageListener("WebcastFeaturedAIMessage", this);
    L5:
        this.i.observe("data_link_state", this);
        IInteractivityInjectService r9 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r9 == null) goto L8;
        r9.subscribeVideoTalkRoomSubScene(this.i, this.d, new g(this));
    L8:
        MiddlewareRoomContext r10 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.i, 0, 2);
        if (r10 == null) goto L13;
        j r11 = r10.getVoiceTalkRoomSubScene();
        if (r11 == null) goto L13;
        r11.c(new SelectedMsgViewManager$initEvents$5(this));
    L13:
        IPSSelectedMessageInfo r2 = null;
        if (SelectedMsgABHelper.c(this.i) == false) goto L26;
        IRoom r13 = this.b;
        if (r13 == null) goto L26;
        IPSSelectedMessageInfo r14 = r13.getPSSelectedMessageInfo();
        if (r14 == null) goto L26;
        if (r14.getStatus() != 1) goto L26;
        this.e = true;
        IRoom r15 = this.b;
        if (r15 == null) goto L24;
        IPSSelectedMessageInfo r16 = r15.getPSSelectedMessageInfo();
    L25:
        g(r16);
        d().b(true, null, "live_take_show", "new_open");
        return;
    L24:
        r16 = null;
    L26:
        IRoom r17 = this.b;
        if (r17 == null) goto L38;
        IPSSelectedMessageInfo r18 = r17.getPSSelectedMessageInfo();
        if (r18 != null) goto L31;
        return;
    L31:
        if (r18.getStatus() != 1) goto L40;
        this.e = true;
        IRoom r19 = this.b;
        if (r19 == null) goto L35;
        r2 = r19.getPSSelectedMessageInfo();
    L35:
        g(r2);
        return;
    L40:
        return;
    }

    public final void f(m3 r3) {
        this.f = r3.getMode();
        AIPublicScreenContainer r0 = r3.getAiPublicScreenContainer();
        if (r0 == null) goto L5;
        long r1 = r0.getRole();
    L6:
        this.g = r1;
        this.h = r3.getAiPublicScreenContainer();
        int r2 = ga2.d.a;
        ga2.d.a("saveModeInfo message, info: " + r3);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public final void g(IPSSelectedMessageInfo r5) {
        long r0 = 0;
        if (r5 == null) goto L5;
        long r2 = r5.getMode();
    L6:
        this.f = r2;
        if (r5 == null) goto L11;
        IAIPublicScreenContainer r3 = r5.getAiPublicScreenContainer();
        if (r3 == null) goto L11;
        r0 = r3.getRole();
    L11:
        this.g = r0;
        IAIPublicScreenContainer r1 = null;
        if (r5 == null) goto L14;
        IAIPublicScreenContainer r4 = r5.getAiPublicScreenContainer();
    L16:
        if ((r4 instanceof AIPublicScreenContainer) == false) goto L19;
        r1 = r4;
    L19:
        this.h = (AIPublicScreenContainer) r1;
        int r6 = ga2.d.a;
        ga2.d.a("saveModeInfo enterRoom, info: " + r5);
        return;
    L14:
        r4 = null;
        goto L16
    L5:
        r2 = 0;
        goto L6
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L33;
        String r0 = r6.getKey();
        if (r0.hashCode() == 872172481) goto L9;
        return;
    L9:
        if (r0.equals("data_link_state") == true) goto L11;
        return;
    L11:
        if (this.e == true) goto L13;
    L15:
        boolean r1 = false;
    L17:
        if (this.c == true) goto L20;
        if (r1 == true) goto L20;
        return;
    L20:
        Integer r7 = (Integer) r6.getData(0);
        if (r7 != null) goto L23;
        r7 = 0;
    L23:
        int r8 = r7.intValue();
        if (SelectedMsgABHelper.f(this.i, Integer.valueOf(r8)) == false) goto L27;
        d().a(true, null, r1);
        return;
    L27:
        if (this.c == false) goto L36;
        d().a(false, s1.B(2131922406), false);
        return;
    L36:
        return;
    L13:
        if (this.c == true) goto L15;
        r1 = true;
        goto L17
    }

    public final void onMessage(tlc.d r13) {
        boolean r0 = r13 instanceof m3;
        boolean r3 = false;
        if (r0 == false) goto L41;
        if (r0 == true) goto L6;
        r13 = null;
    L6:
        m3 r14 = (m3) r13;
        if (r14 != null) goto L9;
        return;
    L9:
        long r5 = r14.getStatus();
        if (r5 != 1) goto L13;
        this.e = true;
        f(r14);
        d().b(true, r14.getToast(), r14.getSettingSource(), "new_open");
    L39:
        int r1 = ga2.d.a;
        Intrinsics.checkNotNullParameter(r14, "msg");
        ALogger.i("PSSelectedMessage", "receive setting message. msg id: " + r14.getMessageId() + ", status: " + r14.getStatus() + ", source: " + r14.getSource());
        return;
    L13:
        if (r5 != 2) goto L19;
        this.e = false;
        if (this.c == true) goto L17;
        return;
    L17:
        ha2.a.C0234a.a(d(), false, r14.getToast(), 12);
        goto L39
    L19:
        if (r5 != 3) goto L39;
        this.e = true;
        long r2 = this.f;
        f(r14);
        if (r2 == this.f) goto L23;
        r3 = true;
    L23:
        d().f(r14.getToast(), r3);
        if (r3 == false) goto L39;
        if (d().d() == false) goto L39;
        ha2.a r4 = d();
        String r6 = r14.getSettingSource();
        long r7 = this.f;
        if (r2 != 2) goto L33;
        if (r7 != 1) goto L33;
        String r8 = "mode_change#1";
    L38:
        r4.g(r6, r8);
    L33:
        if (r2 == 1) goto L35;
    L37:
        r8 = BuildConfig.FLAVOR;
        goto L38
    L35:
        if (r7 != 2) goto L37;
        r8 = "mode_change#2";
        goto L38
    L41:
        if ((r13 instanceof m4) == true) goto L43;
        return;
    L43:
        if (this.c == false) goto L59;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9 = this.l.f((t) r13);
        if (r9 == null) goto L47;
        d().getMessageHandler().s(r9);
    L47:
        Long r15 = ((m4) r13).aiMsgType;
        if (r15 != null) goto L51;
    L53:
        boolean r16 = false;
    L54:
        if (r16 == false) goto L60;
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("event_page", "live_take_detail");
        r17.put("module_name", "ai_mode_notice");
        r17.put("msg_show_area", "selected_msg");
        j0.l().sendLog("livesdk_public_screen_message_module_show", r17, new Object[]{Room.class});
        return;
    L60:
        return;
    L51:
        if (r15.longValue() != 3) goto L53;
        r16 = true;
        goto L54
    }

    public SelectedMsgViewManager(DataCenter r2, ViewGroup r3, q92.a r4, aa2.a r5) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r5, "msgSource");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.a = LazyKt.lazy(new SelectedMsgViewManager$selectedMsgView$2(this));
        this.d = new CompositeDisposable();
    }
}
