package qf0;

import ai0.e;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongWidget;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.message.MicrophoneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jc1.k;
import je0.d;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final Property<String> a = null;

    static {
        a = new Property("js_kv_methods_20191113", "ktv_request_song_list_last_select", "false");
    }

    public static final InteractiveSongWidget a() {
        MultiRevenueDataContext.Companion.getClass();
        MultiRevenueDataContext r0 = MultiRevenueDataContext.a.e();
        if (r0 == null) goto L7;
        i r1 = MultiRevenueDataContext.access$getInteractiveSongService$p(r0);
        if (r1 == null) goto L7;
        of0.a r2 = (of0.a) r1.getValue();
    L8:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.b();
    L7:
        r2 = null;
        goto L8
    }

    public static final boolean e() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L5;
        kj0.b r1 = r0.getSelfDisciplineService();
    L7:
        if (r1 == null) goto L13;
        if (r1.isSelfDisciplineOn() != true) goto L13;
        f2.b(2131919960, 0);
        return true;
    L13:
        if (ThemedCompetitionContext.Companion.g() == false) goto L17;
        f2.b(2131920016, 0);
        return true;
    L17:
        if (d.y() == false) goto L20;
        f2.b(2131918854, 0);
        return true;
    L20:
        m r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r2 == null) goto L30;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L30;
        if (r3.isLiveTypeAudio() != true) goto L30;
        if (d.f() != 0) goto L30;
        f2.b(2131918855, 0);
        return true;
    L30:
        cj0.c r4 = PaidLinkMicContext.Companion.a();
        if (r4 != null) goto L33;
    L38:
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L46;
        e r6 = r5.getAdventureService();
        if (r6 == null) goto L46;
        if (((ai0.c) r6).c() != true) goto L46;
        f2.b(2131922186, 0);
        return true;
    L46:
        return false;
    L33:
        if (r4.isPaidLinkOn() != true) goto L38;
        if (InteractiveSongContext.Companion.f() == true) goto L38;
        f2.b(2131919595, 0);
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public static final boolean c() {
        j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L10;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L10;
        if (r2.a != 8) goto L10;
    L26:
        return true;
    L10:
        j r3 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r3 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
        if (r5 == null) goto L18;
        if (r5.a == 12) goto L26;
    L18:
        j r6 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r6 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r7 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r6.getValue();
        if (r7 == null) goto L27;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r8 = r7.t();
        if (r8 == null) goto L27;
        if (r8.a == 11) goto L26;
    L27:
        return false;
    }

    public static final IMicrophoneItem b(List<? extends IMicrophoneItem> r4) {
        Object r0 = null;
        if (r4 == null) goto L20;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L14;
        Object r1 = r5.next();
        if (((IMicrophoneItem) r1).getMicrophoneType() != MicrophoneType.Golden.ordinal()) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L6;
        r0 = r1;
        goto L14
    L10:
        r2 = false;
    L14:
        return (IMicrophoneItem) r0;
    L20:
        return null;
    }

    public static final void d(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "source");
        ReadOnlyProperty r1 = vm2.d.G7;
        KProperty[] r2 = vm2.d.a;
        Pair r3 = TuplesKt.to((String) r1.getValue(null, r2[445(0x1bd, float:6.24E-43)]), (String) vm2.d.H7.getValue(null, r2[446(0x1be, float:6.25E-43)]));
        String r4 = (String) r3.component1();
        String r5 = (String) r3.component2();
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("order_sing_v3", "2");
        i r7 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveMode();
        if (r7 == null) goto L5;
        LiveMode r8 = (LiveMode) r7.getValue();
    L7:
        if (r8 == null) goto L13;
        int r9 = a.a[r8.ordinal()];
        if (r9 != 1) goto L12;
        String r12 = "voice_live";
    L16:
        r6.put("live_type", r12);
        InteractiveSongContext.a r13 = InteractiveSongContext.Companion;
        if (r13.f() == false) goto L76;
        InteractiveSongContext r14 = r13.getContext();
        if (r14 == null) goto L24;
        m<List<Long>> r15 = r14.getCurrentGiftIdList();
        if (r15 == null) goto L24;
        Iterable r16 = (List) r15.getValue();
        if (r16 == null) goto L24;
    L25:
        r6.put("request_song_gift_id", TextUtils.join(",", r16));
        InteractiveSongContext r17 = r13.getContext();
        if (r17 == null) goto L31;
        m<List<Long>> r18 = r17.getCurrentGiftNumList();
        if (r18 == null) goto L31;
        Iterable r19 = (List) r18.getValue();
        if (r19 == null) goto L31;
    L32:
        r6.put("request_song_gift_money", TextUtils.join(",", r19));
        InteractiveSongContext r20 = r13.getContext();
        int r21 = 0;
        if (r20 == null) goto L39;
        m<List<Long>> r22 = r20.getCurrentGiftIdList();
        if (r22 == null) goto L39;
        List r23 = (List) r22.getValue();
        if (r23 == null) goto L39;
        int r24 = r23.size();
    L40:
        r6.put("request_song_gift_cnt", String.valueOf(r24));
        if (s0.g(null) == false) goto L72;
        InteractiveSongContext r25 = r13.getContext();
        if (r25 == null) goto L48;
        m<List<Long>> r26 = r25.getCurrentTestGiftIdList();
        if (r26 == null) goto L48;
        Iterable r27 = (List) r26.getValue();
        if (r27 == null) goto L48;
    L49:
        r6.put("test_song_gift_id", TextUtils.join(",", r27));
        InteractiveSongContext r28 = r13.getContext();
        if (r28 == null) goto L55;
        m<List<Long>> r29 = r28.getCurrentTestGiftNumList();
        if (r29 == null) goto L55;
        Iterable r30 = (List) r29.getValue();
        if (r30 == null) goto L55;
    L56:
        r6.put("test_song_gift_money", TextUtils.join(",", r30));
        InteractiveSongContext r31 = r13.getContext();
        if (r31 == null) goto L63;
        m<List<Long>> r32 = r31.getCurrentTestGiftIdList();
        if (r32 == null) goto L63;
        List r33 = (List) r32.getValue();
        if (r33 == null) goto L63;
        r21 = r33.size();
    L63:
        r6.put("test_song_gift_cnt", String.valueOf(r21));
        InteractiveSongContext r34 = r13.getContext();
        if (r34 == null) goto L70;
        m<Boolean> r35 = r34.getShowGiftInfo();
        if (r35 == null) goto L70;
        if (((Boolean) r35.getValue()).booleanValue() != true) goto L70;
        String r36 = "1";
    L71:
        r6.put("is_rule_show", r36);
    L70:
        r36 = "0";
    L55:
        r30 = new ArrayList();
    L48:
        r27 = new ArrayList();
    L72:
        r6.put("source", r11);
        r6.put("request_page", "order_list");
        String r110 = com.bytedance.android.live.liveinteract.linkpanel.util.m.v(Integer.valueOf(o.d()), d.d());
        if (r110 != null) goto L75;
        r110 = "normal";
    L75:
        r6.put("layout_type", r110);
        String r111 = y0.b(r5, r6);
    L77:
        Uri r112 = UriProtector.parse(r111);
        if (k.f(IBaseBrowserService.class) == null) goto L82;
        if (r10 == null) goto L83;
        IBaseBrowserService.b.a(k.n(IBaseBrowserService.class), r10, r112);
        return;
    L83:
        return;
    L82:
        return;
    L39:
        r24 = 0;
    L31:
        r19 = new ArrayList();
    L24:
        r16 = new ArrayList();
        goto L25
    L76:
        r6.put("source", r11);
        r111 = y0.b(r4, r6);
        goto L77
    L12:
        if (r9 != 2) goto L13;
        r12 = "video_live";
    L13:
        r12 = PbRequest.SwitchType.OTHER;
        goto L16
    L5:
        r8 = null;
        goto L7
    }
}
