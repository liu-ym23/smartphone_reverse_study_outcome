package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import am2.x;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdk.interactivity.api.f;
import com.bytedance.android.livesdk.interactivity.api.g;
import com.bytedance.android.livesdk.interactivity.chatchannel.config.RoomChannelWidgetConfigProvider;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewBinder;
import com.bytedance.android.livesdk.interactivity.chatchannel.v2.view.ChannelTrayListViewV2;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChannelMemberManagerDialog;
import com.bytedance.android.livesdk.interactivity.service.messagelist.IMessageListManager;
import com.bytedance.android.livesdk.interactivity.service.messagelist.m;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.FansChannelCreateInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import i62.h;
import i62.i;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelWidgetV2;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/e;", "Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/widget/ChatChannelPresenter$IView;", "<init>", "()V", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ChatChannelWidgetV2 extends RoomRecyclableWidget implements com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e, ChatChannelPresenter.IView {
    public static final /* synthetic */ int v = 0;
    public com.bytedance.android.livesdk.interactivity.chatchannel.config.a a;
    public m b;
    public RelativeLayout c;
    public RecyclerView d;
    public ViewGroup e;
    public TextView f;
    public LinearLayout g;
    public NoMoreSpaceTextView h;
    public RelativeLayout i;
    public RecyclerView j;
    public TextView k;
    public MultiTypeAdapter l;
    public Disposable m;
    public boolean n;
    public ChannelTrayListViewV2 o;
    public CompositeDisposable p;
    public final CompositeDisposable q;
    public Disposable r;
    public ChatChannelPresenter s;
    public final c t;
    public final int u;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatChannelWidgetV2 a;

        public b(ChatChannelWidgetV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IMessageListManager.a r4 = (IMessageListManager.a) r3;
            if (r4.getType() != IMessageListManager.MessageChangeType.INSERT_BOTTOM) goto L10;
            MultiTypeAdapter r0 = this.a.l;
            if (r0 == null) goto L15;
            r0.notifyItemInserted(r4.b);
            int r5 = r0.getItemCount();
            RecyclerView r1 = this.a.j;
            if (r1 == null) goto L16;
            r1.smoothScrollToPosition(r5);
            return;
        L16:
            return;
        L15:
            return;
        L10:
            if (r4.getType() != IMessageListManager.MessageChangeType.REMOVE_RANGE) goto L18;
            MultiTypeAdapter r2 = this.a.l;
            if (r2 == null) goto L19;
            r2.notifyItemRangeRemoved(r4.c, r4.d);
            return;
        L19:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ChatChannelWidgetV2 a;

        public c(ChatChannelWidgetV2 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView r0 = this.a.d;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            UtilityKotlinExtentionsKt.w(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public int getLayoutId() {
        return 2131565306;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e
    public final void l2() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.e
    public final void z5() {
    }

    public void onUnload() {
        k.b("ChatChannelWidget unload");
        MainThreadPostUtils.d(this.t);
        this.p.dispose();
        Disposable r0 = this.r;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.q.clear();
        ChatChannelPresenter r1 = this.s;
        if (r1 == null) goto L9;
        r1.detachView();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void uS() {
        MainThreadPostUtils.d(this.t);
        RecyclerView r0 = this.d;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.u(r0);
    L5:
        MainThreadPostUtils.c(this.t, 50);
    }

    public ChatChannelWidgetV2() {
        this.p = new CompositeDisposable();
        this.q = new CompositeDisposable();
        this.t = new c(this);
        if (PadConfigUtils.c() == false) goto L5;
        int r0 = 0;
    L6:
        this.u = r0;
        return;
    L5:
        r0 = 20;
        goto L6
    }

    public final int supportClearScene() {
        if (isScreenPortrait() == true) goto L7;
        return 0;
    L7:
        return this.u;
    }

    public final s22.e yq() {
        RoomContext r0 = getRoomContext();
        if (r0 == null) goto L9;
        f r1 = g.a(r0);
        if (r1 == null) goto L9;
        j<s22.e> r2 = r1.getChatChannelManager();
        if (r2 == null) goto L9;
        return (s22.e) r2.getValue();
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void QU(DiffUtil.DiffResult r3) {
        Intrinsics.checkNotNullParameter(r3, "diff");
        ChannelTrayListViewV2 r0 = this.o;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "res");
        r3.dispatchUpdatesTo(r0.b);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void WP(int r2) {
        ChannelTrayListViewV2 r0 = this.o;
        if (r0 == null) goto L6;
        r0.b.notifyItemRemoved(r2);
        return;
    }

    public final void onEnterClear(int r3) {
        if ((this.u & r3) == 0) goto L8;
        k.b("onEnterClear scene=" + r3);
        UtilityKotlinExtentionsKt.t(((Widget) this).contentView);
        m r4 = this.b;
        if (r4 == null) goto L9;
        r4.b.j = false;
        return;
    L9:
        return;
    }

    public final void onExitClear(int r3) {
        if ((this.u & r3) == 0) goto L8;
        k.b("onExitClear scene=" + r3);
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
        m r4 = this.b;
        if (r4 == null) goto L9;
        r4.b.j = true;
        return;
    L9:
        return;
    }

    public void onInit(Object[] r2) {
        k.b("ChatChannelWidget init");
        this.o = (ChannelTrayListViewV2) ((Widget) this).contentView.findViewById(2131365480);
        this.c = (RelativeLayout) ((Widget) this).contentView.findViewById(2131384777);
        this.d = ((Widget) this).contentView.findViewById(2131384772);
        this.e = (ViewGroup) ((Widget) this).contentView.findViewById(2131384770);
        this.f = (TextView) ((Widget) this).contentView.findViewById(2131384771);
        this.g = (LinearLayout) ((Widget) this).contentView.findViewById(2131384769);
        this.h = ((Widget) this).contentView.findViewById(2131384768);
        this.i = (RelativeLayout) ((Widget) this).contentView.findViewById(2131384765);
        this.j = ((Widget) this).contentView.findViewById(2131371619);
        this.k = (TextView) ((Widget) this).contentView.findViewById(2131384766);
    }

    public void onLoad(Object[] r9) {
        this.t.run();
        k.b("ChatChannelWidget load");
        this.p = new CompositeDisposable();
        s22.e r10 = yq();
        if (r10 == null) goto L6;
        ChatChannelPresenter r0 = new ChatChannelPresenter(r10, this.p, getRoomContext(), ((Widget) this).dataCenter);
        this.s = r0;
        r0.i0(this);
    L6:
        if (((Widget) this).contentView.getVisibility() == 0) goto L8;
        UtilityKotlinExtentionsKt.w(((Widget) this).contentView);
    L8:
        RoomContext r11 = getRoomContext();
        int r1 = RoomChannelWidgetConfigProvider.a;
        if (r11 == null) goto L11;
        com.bytedance.android.livesdk.interactivity.chatchannel.config.a r2 = new RoomChannelWidgetConfigProvider.PublicScreenSyncConfig(r11);
    L12:
        this.a = r2;
        RoomContext r13 = getRoomContext();
        if (r13 == null) goto L19;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L19;
        Room r15 = (Room) r14.getValue();
        if (r15 == null) goto L19;
        final long r3 = r15.id;
    L20:
        final s22.e r16 = yq();
        if (r16 == null) goto L29;
        Function1<p62.a, Unit> r4 = new ChatChannelWidgetV2$initChannelLinkListView$trayClickCallback$1(this, r16, r3);
        ChannelTrayListViewV2 r17 = this.o;
        if (r17 == null) goto L26;
        r17.setTrayClickCallback(r4);
    L26:
        ConstraintLayout r18 = this.o;
        if (r18 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r18);
    L29:
        com.bytedance.android.livesdk.interactivity.chatchannel.config.a r19 = this.a;
        if (r19 == null) goto L50;
        RecyclerView r5 = this.d;
        if (r5 == null) goto L50;
        ViewGroup r6 = this.e;
        if (r6 == null) goto L50;
        TextView r7 = this.f;
        if (r7 == null) goto L50;
        r6.setMinimumHeight(r19.b());
        r6.setBackgroundResource(r19.d());
        r7.setTextColor(r19.c());
        r7.setTextSize(0, r19.e());
        m r8 = new m(r5, r6, r7, s1.f(8.0f), com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.o);
        r8.b(i.class, new i.b());
        r8.b(i62.b.class, new i62.b.C0238b());
        r8.b(i62.c.class, new i62.c.b());
        r8.b(i62.d.class, new i62.d.b());
        r8.b(i62.f.class, new i62.f.b());
        r8.b(h.class, new h.b());
        r8.b(i62.e.class, new i62.e.b(r19.a()));
        r8.b(hb2.a.class, new i62.g());
        r8.b.getClass();
        Unit r20 = Unit.INSTANCE;
        this.b = r8;
        s22.e r21 = yq();
        if (r21 == null) goto L48;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r23 = r21.getCurrentChannel();
        if (r23 == null) goto L48;
        Disposable r24 = p.a(r23, new ChatChannelWidgetV2$initChatChannelMessageList$2(this));
        if (r24 == null) goto L48;
        RxUtilKt.c(r24, this.p);
    L48:
        RxUtilKt.c(Disposables.fromAction(new com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.b(this)), this.p);
    L50:
        if (ChatChannelUtils.a(getRoomContext()) == ContainerType.PublicScreen) goto L52;
    L54:
        float r25 = s1.e(8.0f);
    L55:
        int r26 = (int) r25;
        ConstraintLayout r27 = this.o;
        ViewGroup.LayoutParams r28 = null;
        if (r27 == null) goto L58;
        ViewGroup.LayoutParams r29 = r27.getLayoutParams();
    L60:
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        r28 = r29;
    L63:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) r28;
        if (r30 == null) goto L68;
        r30.topMargin = r26;
        ConstraintLayout r31 = this.o;
        if (r31 == null) goto L68;
        r31.setLayoutParams(r30);
    L68:
        RxUtilKt.c(ChatChannelUtils.l(((Widget) this).dataCenter, new ChatChannelWidgetV2$observeChannelPageShowStateChanged$1(this)), this.p);
        return;
    L58:
        r29 = null;
        goto L60
    L52:
        if (ChatChannelUtils.j(getRoomContext()) == false) goto L54;
        r25 = s1.e(2.0f);
    L19:
        r3 = 0;
        goto L20
    L11:
        r2 = RoomChannelWidgetConfigProvider.a.b;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void xi(List<p62.a> r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        ChannelTrayListViewV2 r0 = this.o;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "list");
        MultiTypeAdapter r1 = r0.b;
        r1.a = r3;
        r1.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget.ChatChannelPresenter.IView
    public final void ie(int r7, int r8) {
        ChannelTrayListViewV2 r0 = this.o;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 != 5) goto L8;
        r0.b.notifyItemChanged(r7);
        return;
    L8:
        if (r7 != 0) goto L27;
        RecyclerView.ViewHolder r2 = r0.a.findViewHolderForAdapterPosition(0);
        Long r5 = null;
        if ((r2 instanceof ChannelTrayListViewBinder.ItemViewHolder) == true) goto L12;
        r2 = null;
    L12:
        ChannelTrayListViewBinder.ItemViewHolder r3 = (ChannelTrayListViewBinder.ItemViewHolder) r2;
        if (r3 != null) goto L15;
        r0.b.notifyItemChanged(r7);
        return;
    L15:
        if (r8 != 2) goto L23;
        TextView r9 = r3.f;
        Object r10 = ListProtector.get(r0.b.a, r7);
        if ((r10 instanceof p62.a) == true) goto L19;
        r10 = null;
    L19:
        p62.a r11 = (p62.a) r10;
        if (r11 == null) goto L22;
        r5 = Long.valueOf(r11.h);
    L22:
        r9.setText(String.valueOf(r5));
        return;
    L23:
        if (r8 == 6) goto L36;
        r0.b.notifyItemChanged(0);
        return;
    L36:
        return;
    L27:
        if (r8 == 3) goto L31;
        if (r8 == 6) goto L31;
        if (r8 == 7) goto L31;
        return;
    L31:
        r0.b.notifyItemChanged(r7);
    }

    public final void xq(s22.a r3, boolean r4, IMessageListManager r5) {
        ALogger.i("ChatChannelWidgetV2", "changeEncryptMessageSubscribeStatus:" + r4);
        if (r5 == null) goto L29;
        if (r4 == true) goto L7;
        Disposable r6 = this.m;
        if (r6 == null) goto L28;
        this.p.remove(r6);
        return;
    L28:
        return;
    L7:
        if (r3.x() == true) goto L9;
        return;
    L9:
        int r7 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.a;
        Intrinsics.checkNotNullParameter(r3, "chatChannel");
        HashMap r8 = new HashMap();
        r8.put("msg_show_type", "chat_channel_qualify_guide");
        r8.put("create_type", String.valueOf(r3.y()));
        FansChannelCreateInfo r0 = r3.C();
        if (r0 == null) goto L12;
        Long r1 = Long.valueOf(r0.getFansChannelType());
    L13:
        r8.put("sub_create_type", String.valueOf(r1));
        r8.put("channel_id", String.valueOf(r3.getChannelId()));
        r8.put("create_app_id", String.valueOf(r3.f()));
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j.l("livesdk_chat_channel_system_msg_show", r8);
        MultiTypeAdapter r9 = this.l;
        if (r9 == null) goto L16;
        r9.a = r5.getMessageList();
    L16:
        MultiTypeAdapter r10 = this.l;
        if (r10 == null) goto L19;
        r10.notifyDataSetChanged();
    L19:
        Disposable r11 = this.m;
        if (r11 == null) goto L22;
        this.p.remove(r11);
    L22:
        Disposable r13 = r5.a().subscribe(new b(this));
        RxUtilKt.c(r13, this.p);
        this.m = r13;
        return;
    L12:
        r1 = null;
        goto L13
    }

    public void zq(Context r9, long r10, s22.a r13, s22.e r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r13, "chatChannel");
        Intrinsics.checkNotNullParameter(r14, "chatManager");
        ChannelMemberManagerDialog r0 = new ChannelMemberManagerDialog(r9, ((Widget) this).dataCenter, r10, r13, r14);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }

    public static final void wq(ChatChannelWidgetV2 r4, boolean r5, boolean r6, String r7, boolean r8, String r9, String r10, boolean r11) {
        r4.getClass();
        if (r5 == false) goto L5;
        String r13 = "manage";
    L6:
        j0 r14 = j0.l();
        Pair[] r0 = new Pair[7];
        r0[0] = TuplesKt.to("click_result", r13);
        String r15 = "1";
        if (r6 == false) goto L9;
        Object r16 = "1";
    L10:
        r0[1] = TuplesKt.to("is_red", r16);
        r0[2] = TuplesKt.to("create_type", r7);
        if (r8 == false) goto L13;
        Object r17 = "1";
    L14:
        r0[3] = TuplesKt.to("is_creator", r17);
        r0[4] = TuplesKt.to("channel_id", r9);
        r0[5] = TuplesKt.to("create_app_id", r10);
        if (r11 == true) goto L18;
        r15 = "0";
    L18:
        r0[6] = TuplesKt.to("is_valid_click", r15);
        r14.sendLog("livesdk_live_message_private_chat_tab_click", MapsKt.mapOf(r0), new Object[]{x.class, IRoom.class});
        return;
    L13:
        r17 = "0";
        goto L14
    L9:
        r16 = "0";
        goto L10
    L5:
        r13 = "switch";
        goto L6
    }
}
