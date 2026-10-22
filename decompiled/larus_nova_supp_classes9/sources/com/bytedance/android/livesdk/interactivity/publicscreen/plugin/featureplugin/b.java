package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import com.bytedance.android.live.base.model.message.a6;
import com.bytedance.android.live.base.model.message.l6;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.panel.ChatLikeLinkedHashMap;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements k, l, s42.b {
    public final FeaturePluginType a;
    public vlc.d b;
    public CompositeDisposable c;
    public final ChatLikeLinkedHashMap d;
    public final PublicScreenContext e;
    public final DataCenter f;

    @Override // s42.b
    public final void f() {
    }

    @Override // s42.b
    public final void g() {
    }

    @Override // v42.a
    public final void onLoad() {
    }

    @Override // v42.a
    public final void onUnload() {
    }

    @Override // v42.a
    public final void onDestroy() {
        vlc.d r0 = this.b;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.e.removeMessageListener(this);
        CompositeDisposable r1 = this.c;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.c = null;
    }

    @Override // v42.a
    public final void onInit() {
        vlc.d r0 = (vlc.d) this.f.get("data_message_manager");
        this.b = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.CHAT_LIKE.getIntType(), this);
    L5:
        vlc.d r1 = this.b;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.REALTIME_CHAT_LIKE.getIntType(), this);
    L8:
        this.e.addMessageListener(this);
        this.c = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.k, v42.a
    public FeaturePluginType getType() {
        return this.a;
    }

    @Override // s42.b
    public final void a(t r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // s42.b
    public final void h(f<?> r5) {
        m4 r0 = null;
        if (r5 == null) goto L5;
        Object r1 = r5.b;
    L7:
        if ((r1 instanceof m4) == false) goto L18;
        com.bytedance.android.live.base.model.data.b r2 = (com.bytedance.android.live.base.model.data.b) this.d.get(Long.valueOf(r5.o()));
        if (r2 == null) goto L19;
        m4 r6 = r5.b;
        if ((r6 instanceof m4) == false) goto L14;
        r0 = r6;
    L14:
        m4 r3 = r0;
        if (r3 == null) goto L20;
        r3.setStatusInfo(r2);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // s42.b
    public final void i(f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // s42.b
    public final void m(f<?> r8) {
        if ((r8 instanceof m4) == true) goto L6;
        return;
    L6:
        if (this.d.containsKey(Long.valueOf(r8.o())) == false) goto L18;
        com.bytedance.android.live.base.model.data.b r0 = r8.l();
        long r1 = 0;
        if (r0 == null) goto L10;
        long r3 = r0.c();
    L11:
        com.bytedance.android.live.base.model.data.b r2 = (com.bytedance.android.live.base.model.data.b) this.d.get(Long.valueOf(r8.o()));
        if (r2 == null) goto L15;
        r1 = r2.c();
    L15:
        if (r3 >= r1) goto L19;
        r8.F = null;
        return;
    L19:
        return;
    L10:
        r3 = 0;
        goto L11
    }

    public final void onMessage(tlc.d r8) {
        PropertyOwner<com.bytedance.android.live.base.model.data.b> r1 = null;
        if ((r8 instanceof com.bytedance.android.live.base.model.message.c) == false) goto L13;
        com.bytedance.android.live.base.model.message.c r9 = (com.bytedance.android.live.base.model.message.c) r8;
        Map r0 = r9.E();
        if (r0 != null) goto L7;
    L15:
        Map r10 = null;
    L16:
        if (r10 != null) goto L18;
        return;
    L18:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.l r2 = q.a();
        if (r2 == null) goto L21;
        r1 = r2.d();
    L21:
        Iterator r3 = r10.entrySet().iterator();
    L23:
        if (r3.hasNext() == false) goto L33;
        Map.Entry r4 = (Map.Entry) r3.next();
        long r5 = ((Number) r4.getKey()).longValue();
        a6 r6 = (a6) r4.getValue();
        if (r6 == null) goto L27;
        this.d.putLikeCount(r5, r6);
    L27:
        if (r1 == null) goto L23;
        if (Long.valueOf(((com.bytedance.android.live.base.model.data.b) r1.a).b()).equals(r4.getKey()) == false) goto L23;
        com.bytedance.android.live.base.model.data.b r7 = (com.bytedance.android.live.base.model.data.b) this.d.get(r4.getKey());
        if (r7 == null) goto L23;
        r1.a(r7);
        goto L23
    L33:
        final Set r11 = r10.keySet();
        if (r11.isEmpty() == true) goto L50;
        com.bytedance.android.livesdk.interactivity.api.l r13 = (com.bytedance.android.livesdk.interactivity.api.l) this.e.getMessageLogicFacade().getValue();
        if (r13 == null) goto L49;
        r13.c(new ChatLikePlugin$updateSpecificMessage$$inlined$let$lambda$1(this, r11), new ChatLikePlugin$updateSpecificMessage$$inlined$let$lambda$2(this, r11));
        return;
    L49:
        return;
    L50:
        return;
    L7:
        if ((!r0.isEmpty()) != true) goto L15;
        vlc.d r14 = this.b;
        if (r14 == null) goto L11;
        r14.removeMessageListener(MessageType.CHAT_LIKE.getIntType(), this);
    L11:
        r10 = r9.E();
        goto L16
    L13:
        if ((r8 instanceof l6) == false) goto L15;
        r10 = ((l6) r8).E();
        goto L16
    }

    public b(PublicScreenContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "dc");
        this.e = r2;
        this.f = r3;
        this.a = FeaturePluginType.ChatLike;
        this.d = (ChatLikeLinkedHashMap) r2.getLocalLikeStatusInfoMap().getValue();
    }

    @Override // s42.b
    public final void j(f<?> r3, ShowArea r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "showArea");
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "showArea");
    }
}
