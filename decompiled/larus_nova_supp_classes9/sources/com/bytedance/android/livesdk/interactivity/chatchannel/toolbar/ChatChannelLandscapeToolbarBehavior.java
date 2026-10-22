package com.bytedance.android.livesdk.interactivity.chatchannel.toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.ChatChannelUtils;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelLandscapeDialog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.widget.TransparentCircleIconView;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChatChannelLandscapeToolbarBehavior implements c0.b {
    public static final /* synthetic */ int r = 0;
    public int a;
    public long b;
    public CompositeDisposable c;
    public CompositeDisposable d;
    public View e;
    public View f;
    public View g;
    public TransparentCircleIconView h;
    public TransparentCircleIconView i;
    public TransparentCircleIconView j;
    public ImageView k;
    public ImageView l;
    public TextView m;
    public final String n;
    public final RoomContext o;
    public final DataCenter p;
    public final s22.e q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ChatChannelLandscapeToolbarBehavior a;
        public final /* synthetic */ s22.a b;

        public b(ChatChannelLandscapeToolbarBehavior r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            this.a.c(this.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ChatChannelLandscapeToolbarBehavior a;
        public final /* synthetic */ s22.a b;

        public c(ChatChannelLandscapeToolbarBehavior r1, s22.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            this.a.c(this.b);
        }
    }

    public static final class d extends s22.e.a {
        public final /* synthetic */ ChatChannelLandscapeToolbarBehavior a;

        public d(ChatChannelLandscapeToolbarBehavior r1) {
            this.a = r1;
        }

        @Override // s22.e.a
        public final void b(long r1) {
            this.a.a();
        }

        @Override // s22.e.a
        public final void a(s22.a r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "chatChannel");
            this.a.a();
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ChatChannelLandscapeToolbarBehavior a;

        public e(ChatChannelLandscapeToolbarBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            this.a.a();
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a() {
        CompositeDisposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        final s22.a r1 = (s22.a) sh6.c.b((sh6.b) this.q.getCurrentChannel().getValue());
        boolean r2 = this.q.getConfig().c;
        boolean r3 = this.q.getConfig().b;
        if (r1 == null) goto L22;
        if (r2 == false) goto L22;
        this.a = 2;
        this.b = r1.getChannelId();
        this.c = new CompositeDisposable();
        RxUtilKt.c(p.a(r1.g(), new ChatChannelLandscapeToolbarBehavior$checkAndUpdateMode$1(this, r1)), this.c);
        PublishSubject r4 = r1.A().b();
        if (r4 == null) goto L13;
        Disposable r5 = r4.subscribe(new b(this, r1));
        if (r5 == null) goto L13;
        RxUtilKt.c(r5, this.c);
    L13:
        PublishSubject r6 = r1.A().e();
        if (r6 == null) goto L18;
        Disposable r7 = r6.subscribe(new c(this, r1));
        if (r7 == null) goto L18;
        RxUtilKt.c(r7, this.c);
    L18:
        p.a(r1.j(), new ChatChannelLandscapeToolbarBehavior$checkAndUpdateMode$4(this, r1));
        c(r1);
        View r8 = this.e;
        if (r8 == null) goto L43;
        r8.setImportantForAccessibility(1);
        return;
    L43:
        return;
    L22:
        if (r1 != null) goto L33;
        if (r3 == false) goto L33;
        this.a = 1;
        this.b = 0;
        View r9 = this.f;
        if (r9 == null) goto L27;
        r9.setVisibility(0);
    L27:
        View r10 = this.g;
        if (r10 == null) goto L30;
        r10.setVisibility(8);
    L30:
        y3.i(this.p).c(ToolbarButton.ROOM_CHANNEL_LANDSCAPE.extended());
        j.d(ChatChannelUtils.i(this.o), "landscape");
        View r11 = this.e;
        if (r11 == null) goto L45;
        r11.setImportantForAccessibility(1);
        return;
    L45:
        return;
    L33:
        this.a = 0;
        this.b = 0;
        View r13 = this.f;
        if (r13 == null) goto L36;
        r13.setVisibility(8);
    L36:
        View r14 = this.g;
        if (r14 == null) goto L39;
        r14.setVisibility(8);
    L39:
        y3.i(this.p).i(ToolbarButton.ROOM_CHANNEL_LANDSCAPE.extended());
        View r15 = this.e;
        if (r15 == null) goto L47;
        r15.setImportantForAccessibility(2);
        return;
    }

    public final void b(s22.a r5) {
        User r0 = (User) CollectionsKt.getOrNull((List) r5.g().a, 0);
        ImageModel r2 = null;
        if (r0 == null) goto L5;
        ImageModel r1 = r0.getAvatarThumb();
    L6:
        User r6 = (User) CollectionsKt.getOrNull((List) r5.g().a, 1);
        if (r6 == null) goto L10;
        r2 = r6.getAvatarThumb();
    L10:
        if (r1 == null) goto L21;
        if (r2 == null) goto L21;
        ImageLoader.bindImage(this.i, r1);
        ImageLoader.bindImage(this.j, r2);
        TransparentCircleIconView r3 = this.h;
        if (r3 == null) goto L15;
        r3.setVisibility(8);
    L15:
        TransparentCircleIconView r7 = this.i;
        if (r7 == null) goto L18;
        r7.setVisibility(0);
    L18:
        TransparentCircleIconView r8 = this.j;
        if (r8 == null) goto L35;
        r8.setVisibility(0);
        return;
    L35:
        return;
    L21:
        if (r1 == null) goto L23;
        ImageLoader.bindImage(this.h, r1);
    L25:
        TransparentCircleIconView r4 = this.h;
        if (r4 == null) goto L28;
        r4.setVisibility(0);
    L28:
        TransparentCircleIconView r9 = this.i;
        if (r9 == null) goto L31;
        r9.setVisibility(8);
    L31:
        TransparentCircleIconView r10 = this.j;
        if (r10 == null) goto L37;
        r10.setVisibility(8);
        return;
    L37:
        return;
    L23:
        if (r2 == null) goto L25;
        ImageLoader.bindImage(this.h, r2);
        goto L25
    L5:
        r1 = null;
        goto L6
    }

    public final void c(s22.a r3) {
        if (r3.A().d() < 0) goto L14;
        ImageView r4 = this.l;
        if (r4 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r4);
    L7:
        ImageView r5 = this.k;
        if (r5 == null) goto L10;
        UtilityKotlinExtentionsKt.t(r5);
    L10:
        TextView r6 = this.m;
        if (r6 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r6);
    L13:
        d(-1);
        return;
    L14:
        ImageView r0 = this.l;
        if (r0 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r0);
    L17:
        int r7 = r3.A().c();
        if (r7 <= 0) goto L26;
        TextView r1 = this.m;
        if (r1 == null) goto L22;
        UtilityKotlinExtentionsKt.w(r1);
    L22:
        ImageView r2 = this.k;
        if (r2 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r2);
    L25:
        d(r7);
        return;
    L26:
        ImageView r8 = this.k;
        if (r8 == null) goto L29;
        UtilityKotlinExtentionsKt.w(r8);
    L29:
        TextView r9 = this.m;
        if (r9 == null) goto L32;
        UtilityKotlinExtentionsKt.t(r9);
    L32:
        d(-1);
    }

    public final void d(int r4) {
        if (r4 >= 10) goto L22;
        if (r4 <= 0) goto L8;
        TextView r0 = this.m;
        if (r0 == null) goto L8;
        r0.setWidth(UtilityKotlinExtentionsKt.i(12));
        r0.setText(String.valueOf(r4));
        a1.n(r0, UtilityKotlinExtentionsKt.i(4));
    L8:
        TransparentCircleIconView r5 = this.h;
        if (r5 != null) goto L11;
    L15:
        TransparentCircleIconView r6 = this.i;
        if (r6 == null) goto L18;
        r6.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$3.INSTANCE);
    L18:
        TransparentCircleIconView r7 = this.j;
        if (r7 == null) goto L58;
        r7.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$4.INSTANCE);
        return;
    L58:
        return;
    L11:
        if (r5.getVisibility() != 0) goto L15;
        TransparentCircleIconView r8 = this.h;
        if (r8 == null) goto L56;
        r8.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$2.INSTANCE);
        return;
    L56:
        return;
    L22:
        if (r4 > 99) goto L39;
        TextView r1 = this.m;
        if (r1 == null) goto L26;
        r1.setWidth(UtilityKotlinExtentionsKt.i(18));
        r1.setText(String.valueOf(r4));
        a1.n(r1, 0);
    L26:
        TransparentCircleIconView r9 = this.h;
        if (r9 != null) goto L29;
    L33:
        TransparentCircleIconView r10 = this.i;
        if (r10 == null) goto L36;
        r10.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$7.INSTANCE);
    L36:
        TransparentCircleIconView r11 = this.j;
        if (r11 == null) goto L62;
        r11.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$8.INSTANCE);
        return;
    L62:
        return;
    L29:
        if (r9.getVisibility() != 0) goto L33;
        TransparentCircleIconView r13 = this.h;
        if (r13 == null) goto L60;
        r13.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$6.INSTANCE);
        return;
    L60:
        return;
    L39:
        TextView r14 = this.m;
        if (r14 == null) goto L42;
        r14.setWidth(UtilityKotlinExtentionsKt.i(24));
        r14.setText("99+");
        a1.n(r14, 0);
    L42:
        TransparentCircleIconView r15 = this.h;
        if (r15 != null) goto L45;
    L49:
        TransparentCircleIconView r16 = this.i;
        if (r16 == null) goto L52;
        r16.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$11.INSTANCE);
    L52:
        TransparentCircleIconView r17 = this.j;
        if (r17 == null) goto L66;
        r17.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$12.INSTANCE);
        return;
    L66:
        return;
    L45:
        if (r15.getVisibility() != 0) goto L49;
        TransparentCircleIconView r18 = this.h;
        if (r18 == null) goto L64;
        r18.setDrawAction(ChatChannelLandscapeToolbarBehavior$updateUnreadCountViewAndAvatarView$10.INSTANCE);
        return;
    }

    public final void onClick(View r7) {
        int r0 = this.a;
        if (r0 != 2) goto L20;
        if (r7 == null) goto L23;
        FragmentActivity r8 = r7.getContext();
        if (r8 == null) goto L26;
        int r1 = ChatChannelLandscapeDialog.h;
        RoomContext r2 = this.o;
        DataCenter r3 = this.p;
        long r4 = this.b;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if ((r8 instanceof FragmentActivity) == false) goto L24;
        FragmentManager r9 = r8.getSupportFragmentManager();
        if ((r9.findFragmentByTag("ChatChannelLandscapeDialog") instanceof ChatChannelLandscapeDialog) == false) goto L17;
        ChatChannelLandscapeDialog r5 = r9.findFragmentByTag("ChatChannelLandscapeDialog");
        if (r5 == null) goto L16;
        ChatChannelLandscapeDialog r6 = r5;
        r6.setAnimationType("right");
        r6.f = r2;
        r6.e = r3;
        r6.g = r4;
        ChatChannelLandscapeDialog.a.a(r6, r9);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.interactivity.chatchannel.widget.ChatChannelLandscapeDialog");
    L17:
        ChatChannelLandscapeDialog r10 = new ChatChannelLandscapeDialog();
        r10.f = r2;
        r10.e = r3;
        r10.g = r4;
        ChatChannelLandscapeDialog.a.a(r10, r9);
        return;
    L24:
        return;
    L26:
        return;
    L23:
        return;
    L20:
        if (r0 != 1) goto L27;
        j.c(new com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e("landscape"));
        int r11 = e62.d.a;
        HorizontalPlayEvent r13 = new HorizontalPlayEvent(1, "source_for_chat_channel_create_request_landscape");
        r13.rotationType = 1;
        xs2.b.a().post(r13);
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        CompositeDisposable r4 = this.c;
        if (r4 == null) goto L5;
        r4.dispose();
    L5:
        CompositeDisposable r5 = this.d;
        if (r5 == null) goto L9;
        r5.dispose();
        return;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e = r2;
        this.f = r2.findViewById(2131368177);
        this.g = r2.findViewById(2131365522);
        this.h = r2.findViewById(2131376087);
        this.i = r2.findViewById(2131376088);
        this.j = r2.findViewById(2131376091);
        this.k = (ImageView) r2.findViewById(2131376090);
        this.l = (ImageView) r2.findViewById(2131376089);
        this.m = (TextView) r2.findViewById(2131390296);
        this.d = new CompositeDisposable();
        this.q.addListener(new d(this));
        this.q.getCurrentChannel().subscribe(new e(this));
        a();
        View r4 = this.e;
        if (r4 == null) goto L5;
        r4.setFocusable(true);
    L5:
        r3.e(this.e, new ChatChannelLandscapeToolbarBehavior$accessiblityCompat$1(this));
    }

    public ChatChannelLandscapeToolbarBehavior(RoomContext r2, DataCenter r3, s22.e r4) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "channelManager");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        IUserService r5 = k.f(IUserService.class);
        if (r5 == null) goto L7;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L7;
        String r7 = r6.n();
    L8:
        this.n = r7;
        return;
    L7:
        r7 = null;
        goto L8
    }
}
