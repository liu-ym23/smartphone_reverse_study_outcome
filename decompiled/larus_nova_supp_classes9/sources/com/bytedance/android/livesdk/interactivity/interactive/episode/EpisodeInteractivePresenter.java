package com.bytedance.android.livesdk.interactivity.interactive.episode;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.message.o5;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.interactive.EpisodeInteractiveContext;
import com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import jc1.h;
import kotlin.jvm.internal.Intrinsics;
import ku2.e;
import org.json.JSONObject;
import vr1.j;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EpisodeInteractivePresenter extends LiveInteractivePresenter {
    public final b j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ EpisodeInteractivePresenter a;

        public a(EpisodeInteractivePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            LiveInteractivePresenter.IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L9;
            if (r5 == null) goto L6;
            long r1 = r5.longValue();
        L7:
            r0.Nj(r1);
            return;
        L6:
            r1 = 0;
            goto L7
        }
    }

    public static final class b implements h {
        public final /* synthetic */ EpisodeInteractivePresenter a;

        public final void c(long r1) {
        }

        public final void d(long r1) {
        }

        public final void f(long r1) {
        }

        public final void g(boolean r1) {
        }

        public b(EpisodeInteractivePresenter r1) {
            this.a = r1;
        }

        public final void a(long r8) {
            ViewModel r1 = null;
            u r0 = r.u(((n) this.a).c, null, 2);
            if (r0 == null) goto L5;
            ViewModel r2 = r0.c();
        L7:
            if ((r2 instanceof EpisodeInteractiveContext) == true) goto L9;
            r2 = null;
        L9:
            EpisodeInteractiveContext r3 = (EpisodeInteractiveContext) r2;
            if (r3 == null) goto L16;
            m<Boolean> r4 = r3.getFirstShowHasFirstResume();
            if (r4 == null) goto L16;
            Boolean r5 = (Boolean) r4.getValue();
            if (r5 == null) goto L16;
            boolean r6 = r5.booleanValue();
        L17:
            if (r6 == false) goto L21;
            LiveInteractivePresenter.IView r7 = ((q46.b) this.a).a;
            if (r7 == null) goto L35;
            r7.b20("continue", r8, 1.0f, new JSONObject());
            return;
        L35:
            return;
        L21:
            u r9 = r.u(((n) this.a).c, null, 2);
            if (r9 == null) goto L24;
            ViewModel r10 = r9.c();
        L26:
            if ((r10 instanceof EpisodeInteractiveContext) == false) goto L29;
            r1 = r10;
        L29:
            EpisodeInteractiveContext r11 = (EpisodeInteractiveContext) r1;
            if (r11 == null) goto L37;
            m<Boolean> r13 = r11.getFirstShowHasFirstResume();
            if (r13 == null) goto L38;
            r13.setValue(Boolean.TRUE);
            return;
        L38:
            return;
        L37:
            return;
        L24:
            r10 = null;
        L16:
            r6 = false;
            goto L17
        L5:
            r2 = null;
            goto L7
        }

        public final void b(long r8) {
            LiveInteractivePresenter.IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.b20("pause", r8, 0.0f, new JSONObject());
            return;
        }

        public final void e(long r8) {
            LiveInteractivePresenter.IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.b20("seek", r8, 1.0f, new JSONObject());
            return;
        }

        public final void h(long r8) {
            LiveInteractivePresenter.IView r0 = ((q46.b) this.a).a;
            if (r0 == null) goto L6;
            r0.b20("recovery", r8, 1.0f, new JSONObject());
            return;
        }
    }

    public EpisodeInteractivePresenter() {
        this.j = new b(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter
    public final void detachView() {
        super.detachView();
        jc1.b.b(this.j);
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter
    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((LiveInteractivePresenter.IView) r1);
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter
    public final void g0(LiveInteractivePresenter.IView r5) {
        super.g0(r5);
        vlc.d r6 = ((n) this).d;
        if (r6 == null) goto L5;
        r6.addMessageListener(xq1.b.a(e.g), this);
        ((n) this).d.addMessageListener(xq1.b.a(e.h), this);
    L5:
        u r7 = r.u(((n) this).c, null, 2);
        if (r7 == null) goto L31;
        boolean r2 = true;
        if (r7.J() != true) goto L32;
        Disposable r8 = r.i().F(new EpisodeInteractivePresenter$attachView$disposable$1(this));
        this.f.add(r8);
        u r9 = r.u(((n) this).c, null, 2);
        if (r9 == null) goto L18;
        m r10 = r9.cameraId();
        if (r10 == null) goto L18;
        Observable r11 = r10.a();
        if (r11 == null) goto L18;
        Disposable r13 = r11.subscribe(new a(this));
        if (r13 == null) goto L18;
        this.f.add(r13);
    L18:
        DataCenter r14 = ((n) this).c;
        if (r14 == null) goto L27;
        j r0 = r.i();
        if (r0 == null) goto L27;
        m r15 = r0.g(r14);
        if (r15 == null) goto L27;
        if (((Boolean) r15.getValue()).booleanValue() != true) goto L27;
    L28:
        if (r2 == false) goto L33;
        jc1.b.a(this.j);
        return;
    L33:
        return;
    L27:
        r2 = false;
        goto L28
    L32:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractivePresenter
    public final void onMessage(tlc.d r10) {
        LinkedHashMap r2 = new LinkedHashMap();
        boolean r0 = r10 instanceof o5;
        String r1 = BuildConfig.FLAVOR;
        boolean r6 = false;
        if (r0 == false) goto L19;
        o82.h.b("receive vs interactive message");
        JsonObject r3 = ((o5) r10).extra();     // Catch: Exception -> L15
        if (r3 == null) goto L13;
        JsonElement r4 = r3.get("component_type");     // Catch: Exception -> L15
        if (r4 == null) goto L13;
        String r5 = r4.getAsString();     // Catch: Exception -> L15
        if (r5 == null) goto L13;
        r1 = r5;
    L13:
        r2.put("component_type", r1);     // Catch: Exception -> L15
    L16:
        r2.put("message_name", "WebcastVsInteractiveMessage");
        LiveInteractivePresenter.IView r7 = ((q46.b) this).a;
        if (r7 == null) goto L59;
        r7.ux((o5) r10);
    L59:
        if (r6 == true) goto L68;
        r.l().s("livesdk_client_receive_interact_message", r2, "live", "other", "live_detail");
        return;
    L68:
        return;
    L15:
        o82.h.b("receive vs interactive message component_type fail");
        goto L16
    L19:
        ku2.a r8 = null;
        if (r10 == null) goto L22;
        String r9 = r10.getMessageMethod();
    L24:
        if (Intrinsics.areEqual(r9, xq1.b.a(e.h)) == false) goto L59;
        if ((r10 instanceof vh7.c) == true) goto L28;
        r10 = null;
    L28:
        vh7.c r11 = (vh7.c) r10;
        if (r11 == null) goto L31;
        r8 = com.bytedance.android.live.base.model.m.a(r11, ku2.b.class);
    L31:
        ku2.b r13 = (ku2.b) r8;
        if (r13 == null) goto L59;
        int r14 = r13.getPosition();
        ku2.b.Companion.getClass();
        if (r14 != 6) goto L59;
        o82.h.b("receive in room banner message");
        JsonObject r15 = r13.extra();     // Catch: Exception -> L46
        if (r15 == null) goto L44;
        JsonElement r16 = r15.get("component_type");     // Catch: Exception -> L46
        if (r16 == null) goto L44;
        String r17 = r16.getAsString();     // Catch: Exception -> L46
        if (r17 == null) goto L44;
        r1 = r17;
    L44:
        r2.put("component_type", r1);     // Catch: Exception -> L46
    L47:
        r2.put("message_name", "WebcastInRoomBannerMessage");
        JsonObject r18 = r13.extra();     // Catch: Exception -> L55
        if (r18 == null) goto L54;
        JsonElement r19 = r18.get("dot_control");     // Catch: Exception -> L55
        if (r19 == null) goto L54;
        if (r19.getAsInt() != 1) goto L54;
    L56:
        LiveInteractivePresenter.IView r110 = ((q46.b) this).a;
        if (r110 == null) goto L59;
        r110.wz(r13);
    L54:
        r6 = true;
    L55:
        o82.h.b("receive vs interactive message dot_control fail");
    L46:
        o82.h.b("receive vs interactive message component_type fail");
        goto L47
    L22:
        r9 = null;
        goto L24
    }
}
