package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import cc2.e;
import cc2.m;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.k;
import com.bytedance.android.livesdk.interactivity.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/plugin/featureplugin/ChatRoomAuthPlugin;", "Lcom/bytedance/android/livesdk/interactivity/api/k;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "a", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "getType", "()Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/plugin/FeaturePluginType;", "type", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatRoomAuthPlugin implements k, Observer<KVData> {
    public final FeaturePluginType a;
    public boolean b;
    public final CompositeDisposable c;
    public final c d;
    public final long e;
    public final b f;
    public final a g;
    public final PublicScreenContext h;
    public final DataCenter i;

    public static final class a implements j {
        public final /* synthetic */ ChatRoomAuthPlugin a;

        public a(ChatRoomAuthPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.j
        public final boolean a(f<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "textMessage");
            if (this.a.b == false) goto L5;
        L7:
            return false;
        L5:
            if (r2.B().booleanValue() == true) goto L7;
            return true;
        }
    }

    public static final class b implements s42.b {
        public final /* synthetic */ ChatRoomAuthPlugin a;

        @Override // s42.b
        public final void h(f<?> r1) {
        }

        @Override // s42.b
        public final void m(f<?> r1) {
        }

        @Override // s42.b
        public final void f() {
            ChatRoomAuthPlugin r0 = this.a;
            if (r0.b == true) goto L6;
            r0.b(false);
            return;
        }

        @Override // s42.b
        public final void g() {
            ChatRoomAuthPlugin r0 = this.a;
            if (r0.b == true) goto L6;
            i0.c().postDelayed(r0.d, r0.e);
            return;
        }

        public b(ChatRoomAuthPlugin r1) {
            this.a = r1;
        }

        @Override // s42.b
        public final void a(t r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        @Override // s42.b
        public final void i(f<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r2, "message");
        }

        @Override // s42.b
        public final void j(f<?> r3, ShowArea r4) {
            Intrinsics.checkNotNullParameter(r3, "message");
            Intrinsics.checkNotNullParameter(r4, "showArea");
            Intrinsics.checkNotNullParameter(r3, "message");
            Intrinsics.checkNotNullParameter(r4, "showArea");
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ChatRoomAuthPlugin a;

        public c(ChatRoomAuthPlugin r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // v42.a
    public final void onDestroy() {
        this.i.removeObserver(this);
        this.h.removeMessageListener(this.f);
        i0.c().removeCallbacks(this.d);
    }

    @Override // v42.a
    public final void onInit() {
        this.h.addMessageListener(this.f);
        this.i.observe("data_room_comment_status", this);
    }

    @Override // v42.a
    public final void onLoad() {
        Function1<IRoom, Unit> r0 = new AnonymousClass1(this);
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        IRoom r2 = null;
        if (r1 == null) goto L5;
        o r3 = IRoomContextService.a.a(r1, this.i, 0, 2);
    L6:
        if (r3 == null) goto L10;
        n r4 = r3.getInteractionDataPrepared();
        if (r4 == null) goto L10;
        r2 = (IRoom) r4.getValue();
    L10:
        if (r2 == null) goto L12;
        r0.invoke(r2);
        return;
    L12:
        if (r3 == null) goto L22;
        n r5 = r3.getInteractionDataPrepared();
        if (r5 == null) goto L23;
        Observable r6 = r5.a();
        if (r6 == null) goto L24;
        Disposable r7 = r6.subscribe(new com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin.c(r0));
        if (r7 == null) goto L25;
        com.bytedance.revenue.platform.api.core.rx.f.a(r7, this.c);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // v42.a
    public final void onUnload() {
        this.c.dispose();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.k, v42.a
    public FeaturePluginType getType() {
        return this.a;
    }

    public final void a(int r5) {
        e r0 = new e();
        m.b r2 = m.b.c;
        if (r5 != 8) goto L5;
        boolean r6 = true;
    L6:
        r0.a(m.class, r2, r6);
        this.i.put("cmd_change_interactivity_component_visibility", r0);
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void b(boolean r8) {
        Object r2 = null;
        Object r0 = this.i.get("data_room", null);
        if ((r0 instanceof IRoom) == true) goto L5;
        r0 = null;
    L5:
        IRoom r1 = (IRoom) r0;
        int r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.a;
        if (r1 == null) goto L8;
        long r4 = r1.getRoomId();
    L9:
        DataCenter r5 = this.i;
        Boolean r6 = Boolean.FALSE;
        if (r5 == null) goto L20;
        Object r7 = r5.get("data_is_anchor", null);
        if ((r7 instanceof Boolean) == false) goto L16;
        r2 = r7;
    L16:
        Boolean r9 = (Boolean) r2;
        if (r9 == null) goto L20;
        r6 = r9;
    L20:
        t r10 = com.bytedance.android.livesdk.interactivity.textmessage.utils.j.a(r4, r8, r6.booleanValue(), r1);
        r.d(r10, PSMessageAction.SYSTEM);
        l r11 = (l) this.h.getMessageLogicFacade().getValue();
        if (r11 == null) goto L24;
        r11.b(r10);
        return;
    L24:
        return;
    L8:
        r4 = 0;
        goto L9
    }

    public final void c(boolean r4) {
        if (r4 != this.b) goto L6;
        return;
    L6:
        if (r4 == false) goto L11;
        l r1 = (l) this.h.getMessageLogicFacade().getValue();
        if (r1 == null) goto L10;
        r1.x();
        r1.v(this.g);
    L10:
        this.b = true;
    L17:
        l r2 = (l) this.h.getMessageLogicFacade().getValue();
        if (r2 != null) goto L20;
        return;
    L20:
        if (r2.E() != true) goto L24;
        b(r4);
        return;
    L24:
        return;
    L11:
        this.b = false;
        l r3 = (l) this.h.getMessageLogicFacade().getValue();
        if (r3 == null) goto L14;
        r3.V(ChatRoomAuthPlugin$updateChatStatus$2.INSTANCE);
    L14:
        l r5 = (l) this.h.getMessageLogicFacade().getValue();
        if (r5 == null) goto L17;
        r5.Y(this.g);
        goto L17
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L31;
        String r0 = r6.getKey();
        if (r0.hashCode() == 1871873441) goto L9;
        return;
    L9:
        if (r0.equals("data_room_comment_status") == false) goto L26;
        Boolean r7 = (Boolean) r6.getData();
        if (r7 == null) goto L33;
        boolean r8 = r7.booleanValue();
        if (r8 == this.b) goto L27;
        com.bytedance.live.datacontext.j<l> r1 = this.h.getMessageLogicFacade();
        if (r1 == null) goto L28;
        l r2 = (l) r1.getValue();
        if (r2 != null) goto L20;
        return;
    L20:
        if (r2.q() == true) goto L30;
        if (r8 == false) goto L23;
        i0.c().removeCallbacks(this.d);
        a(0);
    L24:
        c(r8);
        return;
    L23:
        i0.c().postDelayed(this.d, this.e);
        goto L24
    L30:
        return;
    L28:
        return;
    L27:
        return;
    L33:
        return;
    L26:
        return;
    }

    public ChatRoomAuthPlugin(PublicScreenContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.h = r2;
        this.i = r3;
        this.a = FeaturePluginType.ChatRoomAuth;
        this.b = true;
        this.c = new CompositeDisposable();
        this.d = new c(this);
        this.e = 3000;
        this.f = new b(this);
        this.g = new a(this);
    }
}
