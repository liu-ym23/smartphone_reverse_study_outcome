package m62;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.event.a0;
import com.bytedance.android.livesdk.event.c0;
import com.bytedance.android.livesdk.event.q;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentBusinessType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentContentType;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentEntry;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentFlowContext;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentInputConfig;
import com.bytedance.android.livesdk.interactivity.api.comment.plugin.CommentScene;
import com.bytedance.android.livesdk.interactivity.comment.CommentPresenter;
import com.bytedance.android.livesdk.interactivity.comment.CommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.i;
import com.bytedance.android.livesdk.interactivity.comment.m;
import com.bytedance.android.livesdk.interactivity.comment.n;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;
import sh6.c;
import y22.d;
import y22.e;
import y22.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e {
    public final CommentInputConfig a;
    public final String b;
    public final RoomContext c;
    public final d d;
    public final DataCenter e;

    @Override // y22.e
    public final void destroy() {
    }

    public final s22.e g() {
        return ChatChannelUtils.b(this.c);
    }

    @Override // y22.e
    public final String getName() {
        return this.b;
    }

    @Override // y22.e
    public final CommentInputConfig a(CommentFlowContext r2) {
        Intrinsics.checkNotNullParameter(r2, "commentContext");
        return this.a;
    }

    @Override // y22.e
    public final void c(CommentFlowContext r23) {
        Intrinsics.checkNotNullParameter(r23, "commentContext");
        Object r1 = r23.i;
        Object r3 = null;
        if ((r1 instanceof y32.a) == true) goto L5;
        r1 = null;
    L5:
        y32.a r2 = (y32.a) r1;
        if (r2 == null) goto L10;
        s22.e r4 = g();
        if (r4 == null) goto L10;
        r4.insertLocalMessage(r2);
    L10:
        long r5 = r23.l;
        f r6 = r23.g;
        String r7 = BuildConfig.FLAVOR;
        if (r6 == null) goto L16;
        String r8 = r6.a;
        if (r8 == null) goto L16;
        String r9 = r8;
    L17:
        c0 r10 = r23.h;
        long r11 = 0;
        if (r10 == null) goto L20;
        long r13 = r10.a;
    L21:
        k.d(r5, r9, r13, BuildConfig.FLAVOR);
        int r14 = j.a;
        f r15 = r23.g;
        if (r15 == null) goto L27;
        String r16 = r15.a;
        if (r16 == null) goto L27;
        String r17 = r16;
    L28:
        CommentContentType r18 = r23.e;
        CommentContentType r19 = CommentContentType.Image;
        String r20 = "emoji";
        if (r18 != r19) goto L31;
        String r110 = "emoji";
    L32:
        c0 r21 = r23.h;
        if (r21 == null) goto L35;
        long r111 = r21.a;
    L36:
        String r112 = String.valueOf(r23.l);
        s22.e r24 = g();
        if (r24 == null) goto L45;
        s22.a r25 = r24.getChannel(r23.l);
        if (r25 == null) goto L45;
        PropertyOwner r26 = r25.v();
        if (r26 == null) goto L45;
        Boolean r27 = (Boolean) r26.a;
        if (r27 == null) goto L45;
        boolean r113 = r27.booleanValue();
    L46:
        s22.e r28 = g();
        if (r28 == null) goto L51;
        s22.a r29 = r28.getChannel(r23.l);
        if (r29 == null) goto L51;
        r11 = r29.y();
    L51:
        long r114 = r11;
        s22.e r30 = g();
        if (r30 == null) goto L59;
        s22.a r31 = r30.getChannel(r23.l);
        if (r31 == null) goto L59;
        String r33 = String.valueOf(r31.f());
        if (r33 == null) goto L59;
        String r210 = r33;
    L60:
        f r34 = r23.g;
        if (r34 == null) goto L68;
        Map<String, Object> r35 = r34.b;
        if (r35 == null) goto L68;
        Object r36 = r35.get("paste_edit_method");
        if (r36 == null) goto L68;
        String r37 = r36.toString();
        if (r37 == null) goto L68;
    L69:
        j.k(r17, r110, r111, r114, r113, r112, r210, r37);
        int r38 = g.a;
        s22.e r39 = g();
        if (r39 == null) goto L72;
        s22.a r40 = r39.getChannel(r23.l);
    L74:
        if (r23.e == r19) goto L77;
        r20 = "word";
    L77:
        Object r41 = r23.i;
        if ((r41 instanceof tlc.d) == false) goto L81;
        r3 = r41;
    L81:
        tlc.d r43 = (tlc.d) r3;
        if (r43 == null) goto L87;
        String r44 = String.valueOf(r43.getMessageId());
        if (r44 == null) goto L87;
        r7 = r44;
    L87:
        g.b(r40, r20, r7, r23.k);
        return;
    L72:
        r40 = null;
    L68:
        r37 = "non_paste";
    L59:
        r210 = BuildConfig.FLAVOR;
    L45:
        r113 = false;
        goto L46
    L35:
        r111 = 0;
        goto L36
    L31:
        r110 = "word";
    L27:
        r17 = BuildConfig.FLAVOR;
        goto L28
    L20:
        r13 = 0;
    L16:
        r9 = BuildConfig.FLAVOR;
        goto L17
    }

    @Override // y22.e
    public final void d(CommentFlowContext r9) {
        Intrinsics.checkNotNullParameter(r9, "commentContext");
        long r1 = r9.l;
        f r0 = r9.g;
        if (r0 == null) goto L6;
        String r2 = r0.a;
        if (r2 == null) goto L6;
    L7:
        String r3 = r2;
        c0 r4 = r9.h;
        if (r4 == null) goto L10;
        long r5 = r4.a;
    L11:
        k.c(r1, r3, r5, BuildConfig.FLAVOR, r9.j);
        int r6 = g.a;
        s22.e r7 = g();
        if (r7 == null) goto L14;
        s22.a r8 = r7.getChannel(r9.l);
    L16:
        if (r9.e != CommentContentType.Image) goto L18;
        String r10 = "emoji";
    L19:
        g.a(r8, r10, r9.j, r9.k);
        return;
    L18:
        r10 = "word";
        goto L19
    L14:
        r8 = null;
        goto L16
    L10:
        r5 = 0;
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // y22.e
    public final boolean e(CommentFlowContext r5) {
        Intrinsics.checkNotNullParameter(r5, "commentContext");
        if (r5.c == CommentScene.ChatChannel) goto L5;
        return false;
    L5:
        int r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.a;
        IInteractivityInjectService r7 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r7 == null) goto L8;
        long r2 = r7.getCurrentChatChannelId();
    L9:
        IInteractivityInjectService r8 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r8 == null) goto L12;
        Pair<Boolean, String> r9 = r8.getChannelValidStatus(r2);
    L13:
        if (r9 != null) goto L16;
        return false;
    L16:
        if (((Boolean) r9.getFirst()).booleanValue() == true) goto L22;
        String r10 = (String) r9.getSecond();
        if (r10 == null) goto L23;
        f2.c(r10, 0);
        return true;
    L23:
        return true;
    L22:
        return false;
    L12:
        r9 = null;
        goto L13
    L8:
        r2 = -1;
        goto L9
    }

    @Override // y22.e
    public final void f(final CommentFlowContext r31) {
        Intrinsics.checkNotNullParameter(r31, "commentContext");
        if (r31.f != CommentBusinessType.Normal) goto L76;
        CommentContentType r1 = r31.e;
        CommentContentType r2 = CommentContentType.Image;
        if (r1 != r2) goto L7;
    L12:
        final CommentPresenter r11 = ((CommentWidget) this.d).y;
        if (r11 == null) goto L84;
        final long r7 = r31.l;
        if (r1 != r2) goto L40;
        c0 r3 = r31.h;
        if (r3 == null) goto L20;
        long r4 = r3.a;
    L21:
        final long r24 = r4;
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("room_channel_comment");
        if (r11.m != null) goto L24;
        return;
    L24:
        if (r11.f == true) goto L26;
        return;
    L26:
        if (r11.h == null) goto L85;
        r11.f = false;
        final long r26 = System.currentTimeMillis();
        int r5 = x22.f.a;
        f r6 = r31.g;
        if (r6 == null) goto L38;
        Map<String, Object> r8 = r6.b;
        if (r8 == null) goto L38;
        Object r9 = r8.get("paste_edit_method");
        if (r9 == null) goto L38;
        String r10 = r9.toString();
        if (r10 == null) goto L38;
        String r23 = r10;
    L39:
        Disposable r13 = ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).channelChat(r11.h.getId(), r7, BuildConfig.FLAVOR, 1, r24, BuildConfig.FLAVOR, BuildConfig.FLAVOR, r23).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r11, r7, r24, r26, r31), new com.bytedance.android.livesdk.interactivity.comment.j(r11, r7, r24, r31));
        r11.m.add(r13);
        return;
    L38:
        r23 = CardLockInfo.sUNKNOWN;
        goto L39
    L85:
        return;
    L20:
        r4 = 0;
        goto L21
    L40:
        f r14 = r31.g;
        if (r14 == null) goto L46;
        String r15 = r14.a;
        if (r15 == null) goto L46;
        String r16 = r15;
    L47:
        com.bytedance.android.livesdk.interactivity.api.monitor.a.c("room_channel_comment");
        if (r11.m != null) goto L50;
        return;
    L50:
        if (r11.f == true) goto L52;
        return;
    L52:
        if (r11.h == null) goto L86;
        r11.f = false;
        final long r17 = System.currentTimeMillis();
        f r18 = r31.g;
        if (r18 == null) goto L59;
        q r19 = r18.c;
        if (r19 == null) goto L59;
        String r20 = new a0(null, r19.a).a();
    L60:
        if (r20 != null) goto L62;
        String r25 = BuildConfig.FLAVOR;
    L63:
        int r21 = x22.f.a;
        f r27 = r31.g;
        if (r27 == null) goto L73;
        Map<String, Object> r28 = r27.b;
        if (r28 == null) goto L73;
        Object r29 = r28.get("paste_edit_method");
        if (r29 == null) goto L73;
        String r30 = r29.toString();
        if (r30 == null) goto L73;
        String r210 = r30;
    L74:
        Observable r33 = ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).channelChat(r11.h.getId(), r7, r16, 0, 0, BuildConfig.FLAVOR, r25, r210).compose(RxUtil.rxSchedulerHelper());
        Consumer r110 = new m(r11, r7, r17, r31);
        final String r34 = r16;
        Disposable r35 = r33.subscribe(r110, new n(r11, r7, r34, r31));
        r11.m.add(r35);
        return;
    L73:
        r210 = CardLockInfo.sUNKNOWN;
        goto L74
    L62:
        r25 = r20;
    L59:
        r20 = BuildConfig.FLAVOR;
        goto L60
    L86:
        return;
    L46:
        r16 = BuildConfig.FLAVOR;
        goto L47
    L84:
        return;
    L7:
        if (r1 == CommentContentType.Text) goto L12;
        if (r1 == CommentContentType.RichText) goto L11;
        return;
    L11:
        if (this.a.s == true) goto L12;
        return;
    }

    @Override // y22.e
    public final CommentFlowContext b(CommentEntry r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "entry");
        s22.e r0 = g();
        if (r0 == null) goto L11;
        com.bytedance.android.live.core.arch.mvvm.d<b<s22.a>> r1 = r0.getCurrentChannel();
        if (r1 == null) goto L11;
        b r2 = (b) r1.getValue();
        if (r2 == null) goto L11;
        s22.a r3 = (s22.a) c.b(r2);
        if (r3 == null) goto L11;
        long r4 = r3.getChannelId();
    L12:
        long r6 = r4;
        if (r6 >= 0) goto L16;
        return null;
    L16:
        if (ChatChannelUtils.a(this.c) != ContainerType.MultiTab) goto L18;
        boolean r5 = true;
    L19:
        boolean r7 = ChatChannelUtils.j(this.c);
        boolean r8 = ChatChannelUtils.k(this.c, this.e);
        if (r5 == false) goto L32;
        if (r10 == CommentEntry.ChatChannelWannaEvent) goto L24;
        if (r7 == false) goto L43;
        if (r8 == true) goto L28;
        return null;
    L28:
        if (r10 == CommentEntry.WannaSendAtEvent) goto L30;
        return null;
    L30:
        return new CommentFlowContext(this, r10, CommentScene.ChatChannel, r6, r11);
    L43:
        return null;
    L24:
        return new CommentFlowContext(this, r10, CommentScene.ChatChannel, r6, r11);
    L32:
        if (r10 == CommentEntry.ChatChannelWannaEvent) goto L34;
        if (r7 == false) goto L46;
        if (r8 == true) goto L38;
        return null;
    L38:
        if (r10 == CommentEntry.Click) goto L42;
        if (r10 == CommentEntry.WannaSendAtEvent) goto L42;
        return null;
    L42:
        return new CommentFlowContext(this, r10, CommentScene.ChatChannel, r6, r11);
    L46:
        return null;
    L34:
        return new CommentFlowContext(this, r10, CommentScene.ChatChannel, r6, r11);
    L18:
        r5 = false;
    L11:
        r4 = -1;
        goto L12
    }

    public a(RoomContext r28, d r29, DataCenter r30) {
        Intrinsics.checkNotNullParameter(r28, "roomContext");
        Intrinsics.checkNotNullParameter(r29, "sender");
        Intrinsics.checkNotNullParameter(r30, "dataCenter");
        this.c = r28;
        this.d = r29;
        this.e = r30;
        CommentInputConfig.State r11 = CommentInputConfig.State.ForeClose;
        this.a = new CommentInputConfig(r11, CommentInputConfig.State.ForceOpen, r11, r11, r11, r11, r11, r11, r11, r11, true, true, true, true, r11, s1.B(2131915703), com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.d, r11, r11, r11, 2099208);
        this.b = "ChatChannelCommentFlowPlugin";
    }
}
