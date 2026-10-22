package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.message.a6;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.ChatLikeLinkedHashMap;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.api.ChatLikeApi;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.view.PSGradientTextView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAudiencePanelConfig;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LikeItem extends com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b {
    public final long f;
    public boolean g;
    public boolean h;
    public long i;
    public long j;
    public final int k;
    public final long l;
    public LinearLayout m;
    public LinearLayout n;
    public PSGradientTextView o;
    public TextView p;
    public final ChatLikeLinkedHashMap q;
    public final a r;
    public final MiddlewareRoomContext s;

    public static final class a implements Runnable {
        public final /* synthetic */ LikeItem a;

        public a(LikeItem r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            v r0 = this.a.d;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.l20(false);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LikeItem a;
        public final /* synthetic */ long b;

        public b(LikeItem r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r10) {
            Response r11 = (Response) r10;
            if (r11 == null) goto L34;
            com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a r2 = (com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a) ((BaseResponse) r11).data;
            if (r2 == null) goto L34;
            com.bytedance.android.live.base.model.data.b r3 = r2.a();
            if (r3 == null) goto L34;
            ChatLikeLinkedHashMap r4 = this.a.q;
            if (r4 != null) goto L11;
        L16:
            ChatLikeLinkedHashMap r5 = this.a.q;
            if (r5 == null) goto L19;
            r5.put(Long.valueOf(r3.b()), r3);
        L19:
            LikeItem r6 = this.a;
            ChatLikeLinkedHashMap r7 = r6.q;
            if (r7 == null) goto L26;
            com.bytedance.android.live.base.model.data.b r8 = (com.bytedance.android.live.base.model.data.b) r7.get(Long.valueOf(r3.b()));
            if (r8 == null) goto L26;
            if (r8.e() != true) goto L26;
            boolean r9 = true;
        L27:
            r6.g = r9;
            LikeItem r13 = this.a;
            ChatLikeLinkedHashMap r14 = r13.q;
            if (r14 == null) goto L32;
            com.bytedance.android.live.base.model.data.b r15 = (com.bytedance.android.live.base.model.data.b) r14.get(Long.valueOf(r3.b()));
            if (r15 == null) goto L32;
            long r16 = r15.a();
        L33:
            r13.i = r16;
            LikeItem.g(this.a, Long.valueOf(r3.b()));
            LikeItem r17 = this.a;
            r17.i(r17.i);
            LikeItem r18 = this.a;
            r18.h(r18.g);
        L32:
            r16 = 0;
        L26:
            r9 = false;
            goto L27
        L11:
            if (r4.containsKey(Long.valueOf(r3.b())) != true) goto L16;
            com.bytedance.android.live.base.model.data.b r19 = (com.bytedance.android.live.base.model.data.b) this.a.q.get(Long.valueOf(r3.b()));
            if (r19 == null) goto L15;
            r19.f(r3.e());
        L15:
            ChatLikeLinkedHashMap r20 = this.a.q;
            long r21 = this.b;
            a6 r23 = new a6();
            r23.c(Long.valueOf(r3.a()));
            r23.d(Long.valueOf(r3.c()));
            Unit r24 = Unit.INSTANCE;
            r20.putLikeCount(r21, r23);
        L34:
            com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a r110 = (com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a) ((BaseResponse) r11).data;
            if (r110 == null) goto L39;
            String r111 = r110.b();
            if (r111 == null) goto L39;
            f2.c(r111, 0);
        L39:
            this.a.h = true;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LikeItem a;

        public c(LikeItem r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = ga2.e.a((Throwable) r2);
            if (r3 == null) goto L5;
            f2.c(r3, 0);
        L5:
            this.a.h = true;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        return 2131565175;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        t r0 = this.c;
        if ((r0 instanceof m4) == true) goto L5;
        r0 = null;
    L5:
        m4 r1 = (m4) r0;
        if (r1 != null) goto L8;
        return true;
    L8:
        if (r1.isSecretChat() != true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onDestroyView() {
        super.onDestroyView();
        MainThreadPostUtils.d(this.r);
    }

    public LikeItem(MiddlewareRoomContext r3) {
        super(AudiencePanelItemSymbol.LIKE);
        this.s = r3;
        com.bytedance.android.livesdk.m4 r4 = com.bytedance.android.livesdk.m4.a;
        this.f = ((LiveAudiencePanelConfig) r4.getValue()).getPanelShowThreshold();
        this.h = true;
        this.k = 600;
        this.l = ((LiveAudiencePanelConfig) r4.getValue()).getLikeDismissDuration();
        ChatLikeLinkedHashMap r5 = null;
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r0 == null) goto L7;
        j<l> r1 = r0.getPublicScreenContext();
        if (r1 == null) goto L7;
        l r2 = (l) r1.getValue();
    L9:
        if ((r2 instanceof PublicScreenContext) == true) goto L11;
        r2 = null;
    L11:
        PublicScreenContext r6 = (PublicScreenContext) r2;
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.i<ChatLikeLinkedHashMap> r7 = r6.getLocalLikeStatusInfoMap();
        if (r7 == null) goto L16;
        r5 = (ChatLikeLinkedHashMap) r7.getValue();
    L16:
        this.q = r5;
        this.r = new a(this);
        return;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        AppCompatTextView r0 = this.o;
        if (r0 == null) goto L5;
        r0.setText(r2);
    L5:
        TextView r1 = this.p;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    }

    public final void h(boolean r1) {
        if (r1 == false) goto L9;
        LinearLayout r2 = this.m;
        if (r2 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r2);
    L6:
        LinearLayout r3 = this.n;
        if (r3 == null) goto L16;
        UtilityKotlinExtentionsKt.t(r3);
        return;
    L16:
        return;
    L9:
        LinearLayout r4 = this.n;
        if (r4 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r4);
    L12:
        LinearLayout r5 = this.m;
        if (r5 == null) goto L18;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    }

    public final void i(long r4) {
        this.i = r4;
        if (r4 <= 0) goto L10;
        if (d() == false) goto L7;
    L8:
        f(String.valueOf(this.i));
        return;
    L7:
        if (this.i >= this.f) goto L8;
    L10:
        if (this.g == false) goto L12;
        f("已" + ((String) ListProtector.get(this.e.getOutsideName(), 0)));
        return;
    L12:
        f((String) ListProtector.get(this.e.getOutsideName(), 0));
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r13) {
        if (this.h == true) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        if ((r0 - this.j) > this.k) goto L9;
        f2.b(2131915062, 0);
        return;
    L9:
        this.j = r0;
        MainThreadPostUtils.d(this.r);
        MiddlewareRoomContext r1 = this.s;
        long r2 = 0;
        if (r1 == null) goto L16;
        m r3 = r1.getRoom();
        if (r3 == null) goto L16;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L16;
        long r6 = r4.getRoomId();
    L17:
        t r5 = this.c;
        if (r5 == null) goto L21;
        r2 = r5.getMessageId();
    L21:
        if (this.g == false) goto L23;
        int r10 = 2;
    L24:
        ChatLikeApi.a.getClass();
        ChatLikeApi r7 = (ChatLikeApi) com.bytedance.android.live.network.c.b().e(ChatLikeApi.class);
        if (r7 == null) goto L35;
        Observable<Response<com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a>> r8 = r7.ChatOption(r6, r2, r10);
        if (r8 == null) goto L35;
        Observable r9 = r8.subscribeOn(Schedulers.io());
        if (r9 == null) goto L35;
        Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L35;
        Disposable r14 = r11.subscribe(new b(this, r2), new c(this));
        if (r14 == null) goto L35;
        RxUtilKt.c(r14, this.b);
    L35:
        boolean r15 = this.g;
        long r16 = this.i;
        if (r15 == false) goto L38;
        long r17 = r16 - 1;
    L39:
        this.i = r17;
        boolean r18 = !r15;
        this.g = r18;
        if (r18 == false) goto L42;
        String r19 = "on";
    L43:
        e(r19, "main", String.valueOf(r17));
        i(this.i);
        h(this.g);
        this.h = false;
        MainThreadPostUtils.c(this.r, this.l);
        return;
    L42:
        r19 = "off";
        goto L43
    L38:
        r17 = r16 + 1;
        goto L39
    L23:
        r10 = 1;
    L16:
        r6 = 0;
        goto L17
    }

    public static final void g(final LikeItem r3, final Long r4) {
        r3.getClass();
        l r0 = q.i();
        if ((r0 instanceof PublicScreenContext) == true) goto L5;
        r0 = null;
    L5:
        PublicScreenContext r1 = (PublicScreenContext) r0;
        if (r1 == null) goto L13;
        j<com.bytedance.android.livesdk.interactivity.api.l> r2 = r1.getMessageLogicFacade();
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.interactivity.api.l r5 = (com.bytedance.android.livesdk.interactivity.api.l) r2.getValue();
        if (r5 == null) goto L15;
        r5.l(new LikeItem$updatePublicScreen$$inlined$also$lambda$1(r3, r4), new LikeItem$updatePublicScreen$$inlined$also$lambda$2(r3, r4));
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void b(t r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "bridge");
        super.b(r3, r4);
        View r5 = this.a;
        PropertyOwner<com.bytedance.android.live.base.model.data.b> r6 = null;
        if (r5 == null) goto L5;
        LinearLayout r7 = (LinearLayout) r5.findViewById(2131377872);
    L6:
        this.m = r7;
        View r8 = this.a;
        if (r8 == null) goto L9;
        LinearLayout r9 = (LinearLayout) r8.findViewById(2131391879);
    L10:
        this.n = r9;
        View r10 = this.a;
        if (r10 == null) goto L13;
        PSGradientTextView r11 = (PSGradientTextView) r10.findViewById(2131375730);
    L14:
        this.o = r11;
        View r13 = this.a;
        if (r13 == null) goto L17;
        TextView r14 = (TextView) r13.findViewById(2131375732);
    L18:
        this.p = r14;
        h(this.g);
        i(this.i);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r15 = q.a();
        if (r15 == null) goto L21;
        r6 = r15.d();
    L21:
        if (r6 == null) goto L26;
        Disposable r16 = p.a(r6, new LikeItem$onShow$1(this));
        if (r16 == null) goto L27;
        RxUtilKt.c(r16, this.b);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        r14 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
