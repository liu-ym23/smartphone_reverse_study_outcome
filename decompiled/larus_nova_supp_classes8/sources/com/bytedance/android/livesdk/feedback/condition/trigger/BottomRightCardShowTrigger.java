package com.bytedance.android.livesdk.feedback.condition.trigger;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.livesdk.config.os;
import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import com.bytedance.android.livesdk.model.i0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import zg1.f3;
import zg1.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/feedback/condition/trigger/BottomRightCardShowTrigger;", "Lfx1/c;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomRightCardShowTrigger extends fx1.c<Boolean> implements Observer<KVData> {
    public final TriggerId d;
    public final DataCenter e;
    public final List<Object> f;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ BottomRightCardShowTrigger a;

        public a(BottomRightCardShowTrigger r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            r71.e r5 = (r71.e) r4;
            if (r5.a.getPosition() == MsgWindowPosition.BOTTOM_RIGHT) goto L6;
            return;
        L6:
            if (r5.b != ICardLifecycle.State.Showed) goto L19;
            List<Object> r0 = this.a.f;
            if (r0 != null) goto L10;
        L11:
            BottomRightCardShowTrigger r1 = this.a;
            Pair<String, ? extends Object>[] r2 = new Pair[1];
            v61.a r6 = r5.a;
            if (r6 == null) goto L16;
            Object r7 = r6.j;
            if (r7 == null) goto L16;
            String r8 = r7.toString();
        L17:
            r2[0] = TuplesKt.to("the show card is ", r8);
            r1.d("on action：右下角有其他元素要展示", r2);
            this.a.e(Boolean.TRUE);
            return;
        L16:
            r8 = null;
            goto L17
        L10:
            if (r0.contains(r5.a.j) != true) goto L11;
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            SafetyGuard.a(null, (Throwable) r2, null);
        }
    }

    public BottomRightCardShowTrigger() {
        throw null;
    }

    public final boolean g() {
        List r0 = CollectionsKt.listOf(new Boolean[]{Boolean.valueOf(h("data_live_interactive_component_show", null)), Boolean.valueOf(h("data_promotion_right_card_container_show", null)), Boolean.valueOf(h("data_paid_live_ticket_card_show", null)), Boolean.valueOf(h("data_is_blind_box_banner_present", null)), Boolean.valueOf(h("data_right_bottom_banner_container_show", null)), Boolean.valueOf(h("cmd_interact_player_view_change", BottomRightCardShowTrigger$checkAnyOtherCardShowing$1.INSTANCE)), Boolean.valueOf(h("data_bottom_right_state", BottomRightCardShowTrigger$checkAnyOtherCardShowing$2.INSTANCE)), Boolean.valueOf(h("cmd_video_talkroom_state_change", BottomRightCardShowTrigger$checkAnyOtherCardShowing$3.INSTANCE)), Boolean.valueOf(h("paid_live_show_share_ticket_panel", BottomRightCardShowTrigger$checkAnyOtherCardShowing$4.INSTANCE))});
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        if (((Boolean) r1.next()).booleanValue() == false) goto L9;
        boolean r2 = true;
    L13:
        if (r2 == true) goto L38;
        DataCenter r3 = this.e;
        IMsgWindowService r4 = k.f(IMsgWindowService.class);
        if (r4 == null) goto L36;
        d71.c r5 = r4.cardRecorder();
        if (r5 == null) goto L36;
        if (r5.b(r3, MsgWindowPosition.BOTTOM_RIGHT) == false) goto L36;
        List<Object> r6 = this.f;
        if (r6 == null) goto L35;
        List<Object> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r8 = r7.iterator();
    L29:
        if (r8.hasNext() == false) goto L33;
        if (r5.a(r3, r8.next(), MsgWindowPosition.BOTTOM_RIGHT) == false) goto L29;
        boolean r9 = true;
    L34:
        if (r9 == true) goto L36;
    L33:
        r9 = false;
        goto L34
    L25:
        if (r7.isEmpty() == false) goto L27;
    L35:
        boolean r10 = true;
    L37:
        if (r10 == true) goto L38;
        return false;
    L36:
        r10 = false;
    L38:
        return true;
    L6:
        r2 = false;
        goto L13
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L6
    }

    @Override // fx1.c, fx1.e
    public final void a() {
        super.a();
        DataCenter r0 = this.e;
        if (r0 == null) goto L23;
        r0.observe("cmd_interact_player_view_change", this);
        r0.observe("data_live_interactive_component_show", this);
        r0.observe("data_promotion_right_card_container_show", this);
        r0.observe("data_paid_live_ticket_card_show", this);
        r0.observe("data_bottom_right_state", this);
        r0.observe("cmd_video_talkroom_state_change", this);
        r0.observe("data_is_blind_box_banner_present", this);
        os r1 = os.a;
        Integer r2 = r1.getValue();
        if (r2 != null) goto L8;
    L10:
        Integer r3 = r1.getValue();
        if (r3 != null) goto L14;
    L16:
        r0.observe("paid_live_show_share_ticket_panel", this);
        Pair<String, ? extends Object>[] r4 = new Pair[1];
        DataCenter r5 = this.e;
        if (r5 == null) goto L21;
        Room r6 = z.o(r5);
        if (r6 == null) goto L21;
        String r7 = r6.getIdStr();
    L22:
        r4[0] = TuplesKt.to("roomId", r7);
        d("startObserve", r4);
    L21:
        r7 = null;
        goto L22
    L14:
        if (r3.intValue() != 0) goto L16;
        r0.observe("data_right_bottom_banner_show", this);
        goto L16
    L8:
        if (r2.intValue() != 1) goto L10;
        r0.observe("data_right_bottom_banner_container_show", this);
    L23:
        IMsgWindowService r8 = k.f(IMsgWindowService.class);
        if (r8 == null) goto L37;
        q71.a r9 = r8.cardStateDispatcher(this.e);
        if (r9 == null) goto L38;
        q71.d r10 = r9.a();
        if (r10 == null) goto L39;
        Observable r11 = ((q71.e) r10).b;
        if (r11 == null) goto L40;
        Observable r12 = r11.observeOn(AndroidSchedulers.mainThread());
        if (r12 == null) goto L41;
        Disposable r13 = r12.subscribe(new a(this), b.a);
        if (r13 == null) goto L42;
        c(r13);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    }

    @Override // fx1.e
    public final TriggerId getId() {
        return this.d;
    }

    public BottomRightCardShowTrigger(DataCenter r1) {
        this.e = r1;
        this.f = null;
        this.d = TriggerId.BOTTOM_RIGHT_CARD_SHOW;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L78;
        String r0 = r7.getKey();
        Boolean r4 = null;
        switch(r0.hashCode()) {
            case -1595752242: goto L60;
            case -1518101862: goto L57;
            case -1385258445: goto L49;
            case -1381247050: goto L46;
            case -1130046128: goto L38;
            case -261927283: goto L26;
            case 297505362: goto L23;
            case 985679695: goto L15;
            case 1324747558: goto L12;
            case 1446063636: goto L9;
            default: goto L68;
        };
    L68:
        Boolean r1 = Boolean.FALSE;
    L69:
        if (r1 != null) goto L71;
        return;
    L71:
        if (r1.booleanValue() == false) goto L73;
        r4 = r1;
    L73:
        if (r4 == null) goto L77;
        r4.booleanValue();
        d("on action：右下角有其他元素要展示", new Pair[]{TuplesKt.to("receive change key", r7.getKey())});
        e(Boolean.TRUE);
        return;
    L77:
        return;
    L9:
        if (r0.equals("data_right_bottom_banner_show") == false) goto L68;
    L61:
        Object r2 = r7.getData();
        if ((r2 instanceof Boolean) == true) goto L64;
        r2 = null;
    L64:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L67;
        r1 = Boolean.valueOf(r3.booleanValue());
    L67:
        r1 = null;
        goto L69
    L12:
        if (r0.equals("data_is_blind_box_banner_present") == false) goto L68;
    L15:
        if (r0.equals("data_bottom_right_state") == false) goto L68;
        Object r5 = r7.getData();
        if ((r5 instanceof f3) == true) goto L19;
        r5 = null;
    L19:
        f3 r8 = (f3) r5;
        if (r8 == null) goto L67;
        r1 = Boolean.valueOf(r8.a);
        goto L69
    L23:
        if (r0.equals("data_right_bottom_banner_container_show") == false) goto L68;
    L26:
        if (r0.equals("cmd_video_talkroom_state_change") == false) goto L68;
        Object r9 = r7.getData();
        if ((r9 instanceof l3) == true) goto L30;
        r9 = null;
    L30:
        l3 r10 = (l3) r9;
        if (r10 == null) goto L67;
        if (r10.a != 0) goto L35;
        boolean r11 = true;
    L36:
        r1 = Boolean.valueOf(r11);
        goto L69
    L35:
        r11 = false;
        goto L36
    L38:
        if (r0.equals("cmd_interact_player_view_change") == false) goto L68;
        Object r12 = r7.getData();
        if ((r12 instanceof kd0.a) == true) goto L42;
        r12 = null;
    L42:
        kd0.a r13 = (kd0.a) r12;
        if (r13 == null) goto L67;
        r1 = Boolean.valueOf(r13.a);
        goto L69
    L46:
        if (r0.equals("data_promotion_right_card_container_show") == false) goto L68;
    L49:
        if (r0.equals("paid_live_show_share_ticket_panel") == false) goto L68;
        Object r14 = r7.getData();
        if ((r14 instanceof i0) == true) goto L53;
        r14 = null;
    L53:
        i0 r15 = (i0) r14;
        if (r15 == null) goto L67;
        r1 = Boolean.valueOf(r15.b);
        goto L69
    L57:
        if (r0.equals("data_live_interactive_component_show") == false) goto L68;
    L60:
        if (r0.equals("data_paid_live_ticket_card_show") == false) goto L68;
    }

    public final <T> boolean h(String r4, Function1<? super T, Boolean> r5) {
        DataCenter r0 = this.e;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Object r6 = r0.get(r4, null);
    L7:
        if (r6 != null) goto L10;
        return false;
    L10:
        if ((r6 instanceof Boolean) == true) goto L12;
        if (r5 == null) goto L15;
        r1 = (Boolean) r5.invoke(r6);
    L15:
        if (r1 != null) goto L17;
        return false;
    L17:
        return r1.booleanValue();
    L12:
        return ((Boolean) r6).booleanValue();
    L5:
        r6 = null;
        goto L7
    }
}
