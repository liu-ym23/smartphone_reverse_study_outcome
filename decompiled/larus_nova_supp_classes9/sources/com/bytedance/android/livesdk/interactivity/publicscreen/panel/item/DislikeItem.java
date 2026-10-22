package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.api.ChatLikeApi;
import com.bytedance.android.livesdk.n0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DislikeItem extends com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b {
    public boolean f;
    public long g;
    public final int h;
    public final MiddlewareRoomContext i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ DislikeItem a;

        public a(DislikeItem r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a r3 = (com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a) ((BaseResponse) ((Response) r2)).data;
            if (r3 == null) goto L7;
            String r4 = r3.b();
            if (r4 == null) goto L7;
            f2.c(r4, 0);
        L7:
            v r5 = this.a.d;
            if (r5 == null) goto L11;
            r5.l20(false);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DislikeItem a;

        public b(DislikeItem r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = ga2.e.a((Throwable) r2);
            if (r3 == null) goto L5;
            f2.c(r3, 0);
        L5:
            v r4 = this.a.d;
            if (r4 == null) goto L9;
            r4.l20(false);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        if (((Boolean) n0.a.getValue()).booleanValue() == true) goto L5;
        return 2131565173;
    L5:
        if (this.e.getShowOutside() == false) goto L7;
        return 2131565173;
    L7:
        return 2131565174;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        if (d() == false) goto L5;
        return false;
    L5:
        t r0 = this.c;
        if ((r0 instanceof m4) == true) goto L8;
        r0 = null;
    L8:
        m4 r1 = (m4) r0;
        if (r1 != null) goto L11;
    L13:
        return true;
    L11:
        if (r1.isSecretChat() != true) goto L13;
        return false;
    }

    public DislikeItem(MiddlewareRoomContext r2) {
        super(AudiencePanelItemSymbol.DISLIKE);
        this.i = r2;
        this.h = 600;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r11) {
        long r0 = System.currentTimeMillis();
        if ((r0 - this.g) > this.h) goto L6;
        f2.b(2131915062, 0);
        return;
    L6:
        this.g = r0;
        MiddlewareRoomContext r13 = this.i;
        long r1 = 0;
        if (r13 == null) goto L13;
        m r14 = r13.getRoom();
        if (r14 == null) goto L13;
        Room r15 = (Room) r14.getValue();
        if (r15 == null) goto L13;
        long r5 = r15.getRoomId();
    L14:
        t r16 = this.c;
        if (r16 == null) goto L17;
        r1 = r16.getMessageId();
    L17:
        long r7 = r1;
        if (this.f == false) goto L20;
        int r9 = 4;
    L21:
        ChatLikeApi.a.getClass();
        ChatLikeApi r4 = (ChatLikeApi) com.bytedance.android.live.network.c.b().e(ChatLikeApi.class);
        if (r4 == null) goto L32;
        Observable<Response<com.bytedance.android.livesdk.interactivity.publicscreen.panel.model.a>> r17 = r4.ChatOption(r5, r7, r9);
        if (r17 == null) goto L32;
        Observable r18 = r17.subscribeOn(Schedulers.io());
        if (r18 == null) goto L32;
        Observable r19 = r18.observeOn(AndroidSchedulers.mainThread());
        if (r19 == null) goto L32;
        Disposable r110 = r19.subscribe(new a(this), new b(this));
        if (r110 == null) goto L32;
        RxUtilKt.c(r110, this.b);
    L32:
        boolean r111 = !this.f;
        this.f = r111;
        if (r111 == false) goto L35;
        String r112 = "on";
    L36:
        e(r112, "main", "default");
        return;
    L35:
        r112 = "off";
        goto L36
    L20:
        r9 = 3;
    L13:
        r5 = 0;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void b(t r2, v r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "bridge");
        super.b(r2, r3);
        l r4 = q.a();
        if (r4 == null) goto L5;
        PropertyOwner<com.bytedance.android.live.base.model.data.b> r5 = r4.d();
    L6:
        if (r5 == null) goto L11;
        Disposable r6 = p.a(r5, new DislikeItem$onShow$1(this));
        if (r6 == null) goto L12;
        RxUtilKt.c(r6, this.b);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
