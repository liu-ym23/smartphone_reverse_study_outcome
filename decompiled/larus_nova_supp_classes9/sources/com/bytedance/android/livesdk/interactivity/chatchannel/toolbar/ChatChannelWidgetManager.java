package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.gift.IGiftCoreService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.fk;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageType;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n62.h;
import n62.i;
import s22.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/toolbar/ChatChannelWidgetManager;", "Ls22/g;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatChannelWidgetManager implements g, Observer<KVData> {
    public RoomContext a;
    public DataCenter b;
    public s22.e c;
    public Context d;
    public CompositeDisposable e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ RoomContext a;
        public final /* synthetic */ DataCenter b;

        public a(RoomContext r1, DataCenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            if (e5.f(((Integer) r4).intValue()) == true) goto L22;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r5 = ChatChannelUtils.g(this.a);
            if (r5 == null) goto L11;
            m<com.bytedance.android.livesdk.interactivity.api.base.d> r6 = r5.getState();
            if (r6 == null) goto L11;
            com.bytedance.android.livesdk.interactivity.api.base.d r7 = (com.bytedance.android.livesdk.interactivity.api.base.d) r6.getValue();
            if (r7 == null) goto L11;
            PublicScreenAreaPageType r8 = r7.a;
        L13:
            if (r8 != PublicScreenAreaPageType.ChatChannel) goto L15;
            boolean r9 = true;
        L16:
            int r0 = q.a;
            q.a(r9, this.b, 5);
            if (r9 == false) goto L23;
            IGiftCoreService r10 = k.f(IGiftCoreService.class);
            if (r10 == null) goto L24;
            r10.setNeedShowGiftEffectSwitch(false);
            return;
        L24:
            return;
        L23:
            return;
        L15:
            r9 = false;
        L11:
            r8 = null;
            goto L13
        }
    }

    public ChatChannelWidgetManager() {
    }

    @Override // s22.g
    public final void a(s22.a r5) {
        Intrinsics.checkNotNullParameter(r5, "channel");
        DataCenter r0 = this.b;
        if (r0 == null) goto L6;
        r0.put("cmd_room_channel_show_invite_dialog", new f62.b(false, null, r5));
        return;
    }

    public final void onChanged(Object r15) {
        KVData r16 = (KVData) r15;
        Intrinsics.checkNotNullParameter(r16, "data");
        String r17 = r16.getKey();
        if (r17.hashCode() == (-1575056762)) goto L6;
        return;
    L6:
        if (r17.equals("cmd_p0_widget_loaded") == false) goto L70;
        Context r18 = this.d;
        if (r18 == null) goto L74;
        DataCenter r0 = this.b;
        if (r0 != null) goto L14;
    L24:
        DataCenter r8 = this.b;
        if (r8 != null) goto L28;
    L49:
        DataCenter r1 = this.b;
        if (r1 != null) goto L53;
        return;
    L53:
        if (z.m(r1, true) == false) goto L71;
        Boolean r2 = Boolean.FALSE;
        Boolean r3 = (Boolean) r1.get("data_pending_show_chat_channel_invite_panel", r2);
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L72;
        r1.put("data_pending_show_chat_channel_invite_panel", r2);
        RoomContext r5 = this.a;
        if (r5 == null) goto L76;
        s22.e r6 = this.c;
        if (r6 == null) goto L77;
        s22.a r7 = ChatChannelUtils.c(r5);
        if (r7 == null) goto L78;
        n62.e r19 = h.b(r18, r5, r1, r6);
        Intrinsics.checkNotNullParameter(r7, "channel");
        r19.e(r7, null);
        r1.put("match_scroll_to_chat_channel", r4);
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L72:
        return;
    L71:
        return;
    L28:
        if (z.m(r8, true) == false) goto L49;
        Boolean r9 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r8.get("data_pending_show_chat_channel_member_panel", r9), Boolean.TRUE) == false) goto L49;
        r8.put("data_pending_show_chat_channel_member_panel", r9);
        RoomContext r10 = this.a;
        if (r10 == null) goto L49;
        m r11 = r10.getRoom();
        if (r11 == null) goto L49;
        Room r13 = (Room) r11.getValue();
        if (r13 == null) goto L49;
        long r14 = r13.getRoomId();
        s22.e r20 = this.c;
        if (r20 == null) goto L49;
        s22.a r21 = ChatChannelUtils.c(this.a);
        if (r21 == null) goto L49;
        ChannelMemberManagerDialog r110 = new ChannelMemberManagerDialog(r18, r8, r14, r21, r20);
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L68;
        DialogLancet.handleBlockedDialogShow(r110);
    L48:
        r8.put("match_scroll_to_chat_channel", Boolean.TRUE);
        goto L49
    L68:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L67
    L47:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        goto L48
    L14:
        if (z.m(r0, true) == false) goto L24;
        Boolean r23 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r0.get("data_pending_show_create_chat_channel", r23), Boolean.TRUE) == false) goto L24;
        r0.put("data_pending_show_create_chat_channel", r23);
        RoomContext r24 = this.a;
        if (r24 == null) goto L24;
        s22.e r25 = this.c;
        if (r25 == null) goto L24;
        h.a(r18, r24, r0, r25, new i(true, 0, false, new com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e("landscape"))).c(this.e);
        goto L24
    L74:
        return;
    }

    public final void b(RoomContext r3, DataCenter r4, s22.e r5, Context r6) {
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "manager");
        Intrinsics.checkNotNullParameter(r6, "context");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = new CompositeDisposable();
        if (r5.getConfig().a != ContainerType.MultiTab) goto L8;
        f r7 = new f(this);
        s22.e r8 = this.c;
        if (r8 == null) goto L7;
        r8.addListener(r7);
    L7:
        RxUtilKt.c(Disposables.fromAction(new e(this, r7)), this.e);
    L29:
        if (((Boolean) fk.a.getValue()).booleanValue() == false) goto L31;
        RxUtilKt.c(r3.getReportScreenOrientation().a().subscribe(new a(r3, r4)), this.e);
    L31:
        r4.observe("cmd_p0_widget_loaded", this);
        return;
    L8:
        RoomContext r9 = this.a;
        if (r9 == null) goto L29;
        final DataCenter r10 = this.b;
        if (r10 == null) goto L29;
        s22.e r0 = this.c;
        if (r0 == null) goto L29;
        s22.e.b r1 = r0.getConfig();
        if (r1 == null) goto L29;
        if (r1.e != true) goto L29;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.a r11 = ChatChannelUtils.g(r9);
        if (r11 == null) goto L29;
        m<com.bytedance.android.livesdk.interactivity.api.base.d> r13 = r11.getState();
        if (r13 == null) goto L29;
        Disposable r14 = i80.a.a(r13, new ChatChannelWidgetManager$prepareForHideGiftAndEnterAnim$1(r10));
        if (r14 == null) goto L29;
        RxUtilKt.c(r14, this.e);
        goto L29
    }
}
