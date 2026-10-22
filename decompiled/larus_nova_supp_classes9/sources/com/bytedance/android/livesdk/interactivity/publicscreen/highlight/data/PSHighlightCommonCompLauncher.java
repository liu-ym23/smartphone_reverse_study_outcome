package com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommentTopicConfig;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommonConfig;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.PSHighlightCommonComp;
import com.bytedance.android.livesdk.message.model.RoomHighlightAreaContainerMessage;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lk1.c;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/data/PSHighlightCommonCompLauncher;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/b;", "Lvlc/l;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSHighlightCommonCompLauncher extends b implements l, Observer<KVData> {
    public final Map<String, PSHighlightCommonComp> e;
    public final List<PSHighlightCommonComp> f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PSHighlightCommonCompLauncher a;
        public final /* synthetic */ PSHighlightCommonComp b;

        public a(PSHighlightCommonCompLauncher r1, PSHighlightCommonComp r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            IPSHighlightCompLifecycle$State r7 = (IPSHighlightCompLifecycle$State) r6;
            if (r7 != null) goto L6;
            return;
        L6:
            if (com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data.a.a[r7.ordinal()] != 1) goto L18;
            Map<String, PSHighlightCommonComp> r8 = this.a.e;
            PSHighlightCommonComp r0 = this.b;
            if (r0 == null) goto L14;
            n r1 = r0.getType();
            if (r1 == null) goto L14;
            String r2 = r1.getType() + '_' + r1.getBizScene() + '_' + r0.e();
        L15:
            r8.remove(r2);
            o.c("common highlight comp is destroy, remove from curComps");
            return;
        L14:
            r2 = BuildConfig.FLAVOR;
            goto L15
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public final void a() {
        List<PSHighlightCommonComp> r0 = this.f;
        if ((!r0.isEmpty()) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L17;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        if ((!((PSHighlightCommonComp) r3).g()) == false) goto L9;
        r1.add(r3);
        goto L9
    L13:
        Iterator r4 = r1.iterator();
    L15:
        if (r4.hasNext() == false) goto L24;
        PSHighlightCommonComp r5 = (PSHighlightCommonComp) r4.next();
        r5.p("extra_key_reshow_from_rotate", Boolean.TRUE);
        r5.q();
        goto L15
    L24:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public final void b() {
        ((ArrayList) this.f).clear();
        Map<String, PSHighlightCommonComp> r0 = this.e;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        if ((!((PSHighlightCommonComp) r3.getValue()).g()) == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        ((ArrayList) this.f).addAll(r1.values());
    }

    public PSHighlightCommonCompLauncher() {
        this.e = new LinkedHashMap();
        this.f = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public final void onUnload() {
        super.onUnload();
        Map<String, PSHighlightCommonComp> r0 = this.e;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r2 = ((LinkedHashMap) r0).entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r2.next();
        if ((!((PSHighlightCommonComp) r3.getValue()).g()) == false) goto L4;
        r1.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        Iterator r4 = r1.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((PSHighlightCommonComp) ((Map.Entry) r4.next()).getValue()).b();
        goto L10
    L12:
        k r5 = this.b;
        if (r5 == null) goto L17;
        DataCenter r6 = r5.getDataCenter();
        if (r6 == null) goto L17;
        r6.removeObserver(this);
    L17:
        ((LinkedHashMap) this.e).clear();
        ((ArrayList) this.f).clear();
        j<d> r7 = this.c;
        if (r7 == null) goto L27;
        r7.c(new AnonymousClass3(this));
        return;
    }

    public static String d(b6 r3) {
        return r3.getType() + '_' + r3.a() + '_' + r3.f();
    }

    public static boolean e(b6 r14) {
        Map r0 = r14.c();
        Long r1 = null;
        if (r0 == null) goto L7;
        String r2 = (String) r0.get("end_time");
        if (r2 == null) goto L7;
        Long r3 = StringsKt.toLongOrNull(r2);
    L8:
        boolean r4 = true;
        if (r3 != null) goto L12;
        o.c("msg endTime is null, default show");
        return true;
    L12:
        long r5 = r3.longValue() * 1000;
        Map r15 = r14.c();
        if (r15 == null) goto L17;
        String r16 = (String) r15.get("end_time_left_ms");
        if (r16 == null) goto L17;
        r1 = StringsKt.toLongOrNull(r16);
    L17:
        long r6 = p6.b();
        if (r1 == null) goto L25;
        long r7 = p6.b();
        long r9 = r5 - r7;
        if (r9 >= r1.longValue()) goto L23;
        r4 = false;
    L23:
        int r17 = o.a;
        o.c("msg isInDisplayTime=" + r4 + ", endTime:" + r5 + ", now:" + r7 + ", canDisplayTime:" + r9 + ", endTimeLeftMs:" + r1);
    L29:
        return r4;
    L25:
        if (r6 <= r5) goto L28;
        r4 = false;
    L28:
        int r18 = o.a;
        o.c("msg isInDisplayTime=" + r4 + ", endTime:" + r5 + ", now:" + r6);
    L7:
        r3 = null;
        goto L8
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Intrinsics.checkNotNullParameter(r6, "kvData");
        String r0 = r6.getKey();
        if (r0.hashCode() == 62101746) goto L6;
        return;
    L6:
        if (r0.equals("live_highlight_common_comp_roomauth_change") == false) goto L35;
        Integer r7 = (Integer) r6.getData(Integer.valueOf((int) 0));
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.intValue() != ((int) 2)) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L37;
        o.c("receive room auth msg,the disable");
        Map<String, PSHighlightCommonComp> r8 = this.e;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r9 = ((LinkedHashMap) r8).entrySet().iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        Map.Entry r3 = (Map.Entry) r9.next();
        if ((!((PSHighlightCommonComp) r3.getValue()).g()) == false) goto L19;
        r2.put(r3.getKey(), r3.getValue());
        goto L19
    L23:
        Iterator r10 = r2.entrySet().iterator();
    L25:
        if (r10.hasNext() == false) goto L27;
        ((PSHighlightCommonComp) ((Map.Entry) r10.next()).getValue()).b();
        goto L25
    L27:
        ((LinkedHashMap) this.e).clear();
        return;
    L37:
        return;
    L12:
        r1 = false;
        goto L13
    }

    public final void onMessage(tlc.d r20) {
        if ((r20 instanceof RoomHighlightAreaContainerMessage) == false) goto L153;
        RoomHighlightAreaContainerMessage r1 = (RoomHighlightAreaContainerMessage) r20;
        Boolean r2 = null;
        if (r1 == null) goto L7;
        b6 r3 = r1.getHighlightAreaContainer();
    L8:
        if (r3 != null) goto L10;
        o.c("RoomHighlightAreaContainerMessage highlightAreaContainer is null");
        return;
    L10:
        k r4 = this.b;
        boolean r5 = true;
        if (r4 == null) goto L29;
        DataCenter r6 = r4.getDataCenter();
        if (r6 == null) goto L29;
        c.i2.getClass();
        mk1.a r7 = c.a.a(r6).getComponentStatus("room_auth_highlight_area_container");
        if (r7 == null) goto L29;
        if (r7.a != 3) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
    L25:
        boolean r9 = true;
    L26:
        if (r9 != true) goto L29;
        boolean r10 = false;
    L30:
        if (r10 == true) goto L32;
        o.c("room auth is disable, doesn't work");
        return;
    L32:
        Long r11 = r3.getType();
        if (r11 != null) goto L36;
    L38:
        boolean r13 = false;
    L39:
        boolean r14 = Intrinsics.areEqual(r3.a(), "comment_topic");
        PSHighlightCommentTopicConfig.a r15 = PSHighlightCommentTopicConfig.b;
        k r16 = this.b;
        if (r16 == null) goto L42;
        DataCenter r17 = r16.getDataCenter();
    L43:
        r15.getClass();
        if (r17 != null) goto L46;
    L47:
        if (r17 == null) goto L52;
        if (a0.j(r17) != true) goto L52;
    L59:
        boolean r18 = false;
    L68:
        k r19 = this.b;
        if (r19 != null) goto L71;
    L79:
        k r21 = this.b;
        if (r21 != null) goto L82;
    L84:
        boolean r23 = false;
    L85:
        if (r13 == false) goto L90;
        if (r14 == false) goto L90;
        if (r18 == false) goto L89;
        if (r23 == false) goto L90;
    L89:
        boolean r110 = true;
    L91:
        int r111 = o.a;
        o.c("disableTopicMsg, result=" + r110 + ",isTopicComp=" + r13 + ",isCommentTopicScene=" + r14 + ",enable=" + r18 + ",hasComp=" + r23);
        if (r110 == false) goto L94;
        o.c("interceptMsg");
        return;
    L94:
        Lazy r24 = PSHighlightType.CommonHighlightComp.f;
        HighlightAreaPriorityConfig r25 = r3.e();
        if (r25 == null) goto L104;
        Long r112 = r3.getType();
        if (r112 == null) goto L99;
        long r113 = r112.longValue();
    L100:
        String r114 = r3.a();
        if (r114 != null) goto L103;
        r114 = BuildConfig.FLAVOR;
    L103:
        PSHighlightType.CommonHighlightComp r26 = new PSHighlightType.CommonHighlightComp(r113, r114, r25.getShowPriority(), r25.getLocationPriority());
    L106:
        if (r26.getType() != (-1)) goto L116;
        String r27 = r26.c;
        if (r27 != null) goto L110;
    L113:
        boolean r28 = true;
    L114:
        if (r28 == false) goto L116;
    L117:
        if (r5 == false) goto L119;
        o.c("psHighlightType is invalid");
        return;
    L119:
        PSHighlightCommonConfig.b.getClass();
        if (((PSHighlightCommonConfig) PSHighlightCommonConfig.a.getValue()).c() == true) goto L130;
        PSHighlightCommonComp r29 = (PSHighlightCommonComp) ((LinkedHashMap) this.e).get(d(r3));
        if (r29 == null) goto L127;
        if (r29.g() == true) goto L127;
        r29.update(r1);
        o.c("commonComp is exit, update info");
        return;
    L127:
        if (e(r3) == true) goto L129;
        o.c("msg is not in display time");
        return;
    L129:
        PSHighlightCommonComp r30 = c(r1, r26);
        this.e.put(d(r3), r30);
        r30.q();
        return;
    L130:
        Long r31 = r3.d();
        if (r31 != null) goto L133;
    L143:
        PSHighlightCommonComp r33 = (PSHighlightCommonComp) ((LinkedHashMap) this.e).get(d(r3));
        if (r33 == null) goto L149;
        if (r33.g() == true) goto L149;
        r33.update(r1);
        o.c("commonComp is exit, update info");
        return;
    L149:
        if (e(r3) == true) goto L151;
        o.c("msg is not in display time");
        return;
    L151:
        PSHighlightCommonComp r34 = c(r1, r26);
        this.e.put(d(r3), r34);
        r34.q();
        return;
    L133:
        if (r31.longValue() == 0) goto L143;
        if (r31.longValue() != 1) goto L142;
        PSHighlightCommonComp r35 = (PSHighlightCommonComp) ((LinkedHashMap) this.e).get(d(r3));
        if (r35 != null) goto L140;
        return;
    L140:
        if (r35.g() == true) goto L162;
        r35.b();
        o.c("commonComp is exit and operate is dismiss, dismiss comp");
        return;
    L162:
        return;
    L142:
        o.c("operate is not support");
        return;
    L110:
        if (r27.length() == 0) goto L113;
        r28 = false;
    L116:
        r5 = false;
        goto L117
    L99:
        r113 = -1;
        goto L100
    L104:
        r26 = new PSHighlightType.CommonHighlightComp(0);
    L90:
        r110 = false;
        goto L91
    L82:
        if (r21.getHasComponentShow() != true) goto L84;
        r23 = true;
        goto L85
    L71:
        if (r19.getHasComponentShow() == true) goto L79;
        k r115 = this.b;
        if (r115 == null) goto L75;
        int r116 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a;
        r115.setHasComponentShow(com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a(r115.getDataCenter()));
    L75:
        int r117 = o.a;
        StringBuilder r118 = new StringBuilder("收到消息时挂载组件判断结果：");
        k r119 = this.b;
        if (r119 == null) goto L78;
        r2 = Boolean.valueOf(r119.getHasComponentShow());
    L78:
        r118.append(r2);
        o.c(r118.toString());
    L52:
        if (c1.b(r17) == false) goto L54;
    L57:
        boolean r120 = true;
    L58:
        if (r120 == true) goto L59;
        if (r17 != null) goto L62;
    L64:
        boolean r121 = false;
    L65:
        if (r121 == false) goto L67;
        r18 = ((PSHighlightCommentTopicConfig) PSHighlightCommentTopicConfig.a.getValue()).a();
        goto L68
    L67:
        r18 = ((PSHighlightCommentTopicConfig) PSHighlightCommentTopicConfig.a.getValue()).b();
        goto L68
    L62:
        if (a0.d(r17, false) != true) goto L64;
        r121 = true;
        goto L65
    L54:
        if (c1.c(r17) == true) goto L57;
        r120 = false;
        goto L58
    L46:
        if (a0.k(r17) == true) goto L59;
    L42:
        r17 = null;
        goto L43
    L36:
        if (r11.longValue() != 1) goto L38;
        r13 = true;
        goto L39
    L22:
        if (r7.b() == true) goto L25;
        r9 = false;
        goto L26
    L19:
        r8 = false;
    L29:
        r10 = true;
        goto L30
    L7:
        r3 = null;
        goto L8
    }

    public final PSHighlightCommonComp c(RoomHighlightAreaContainerMessage r4, PSHighlightType.CommonHighlightComp r5) {
        Context r1 = getContext();
        k r2 = this.b;
        if (r2 == null) goto L5;
        DataCenter r3 = r2.getDataCenter();
    L6:
        PSHighlightCommonComp r0 = new PSHighlightCommonComp(r4, r5, r1, r3);
        r0.p("extra_key_keep_show_when_rotation", Boolean.TRUE);
        RxUtilKt.c(r0.b.subscribe(new a(this, r0)), this.d);
        return r0;
    L5:
        r3 = null;
        goto L6
    }

    public final void f(Context r3, k r4) {
        Intrinsics.checkNotNullParameter(r4, "psHighlightContext");
        Intrinsics.checkNotNullParameter(r4, "psHighlightContext");
        this.a = r3;
        this.b = r4;
        MiddlewareRoomContext r5 = r4.getRoomContext();
        Long r0 = null;
        if (r5 == null) goto L5;
        j<d> r6 = r5.getMessageManager();
    L6:
        this.c = r6;
        if (r4.getHasComponentShow() == true) goto L14;
        int r7 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a;
        r4.setHasComponentShow(com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a(r4.getDataCenter()));
        int r8 = o.a;
        StringBuilder r9 = new StringBuilder("roomid：");
        DataCenter r1 = r4.getDataCenter();
        if (r1 == null) goto L13;
        Room r2 = z.o(r1);
        if (r2 == null) goto L13;
        r0 = Long.valueOf(r2.id);
    L13:
        r9.append(r0);
        r9.append(",onLoad时挂载组件判断结果：");
        r9.append(r4.getHasComponentShow());
        o.c(r9.toString());
    L14:
        j<d> r10 = this.c;
        if (r10 == null) goto L17;
        r10.c(new PSHighlightCommonCompLauncher$onLoad$1(this));
    L17:
        DataCenter r11 = r4.getDataCenter();
        if (r11 == null) goto L21;
        r11.observe("live_highlight_common_comp_roomauth_change", this);
        return;
    L21:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
