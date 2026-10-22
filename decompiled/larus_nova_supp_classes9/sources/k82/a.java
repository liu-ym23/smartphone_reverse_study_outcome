package k82;

import am2.a0;
import am2.b0;
import am2.x;
import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import j82.e;
import j82.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;
import vr1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements j82.a, j82.d, j82.c, j82.b, e, f {
    public EditText a;
    public final /* synthetic */ j82.a b;
    public final /* synthetic */ j82.d c;
    public final /* synthetic */ j82.c d;
    public final /* synthetic */ j82.b e;
    public final /* synthetic */ e f;
    public final /* synthetic */ f g;

    public abstract void A();

    public abstract void B();

    public abstract void C(String r1);

    public abstract void D(String r1);

    @Override // j82.b
    public final void a(EditText r2) {
        this.e.a(r2);
    }

    @Override // j82.b
    public final void b(BaseEmoji r2, String r3, EditText r4) {
        this.e.b(r2, r3, r4);
    }

    @Override // j82.a
    public final void c() {
        this.b.c();
    }

    @Override // j82.c
    public final void d(boolean r2) {
        this.d.d(r2);
    }

    @Override // j82.a
    public final int e() {
        return this.b.e();
    }

    @Override // j82.a
    public final void f(SkinSelection r2) {
        this.b.f(r2);
    }

    @Override // j82.b
    public final void g(boolean r2) {
        this.e.g(r2);
    }

    public abstract Activity getActivity();

    public abstract Context getContext();

    @Override // j82.f
    public final void h(SkinSelection r2) {
        this.g.h(r2);
    }

    @Override // j82.e
    public final void i() {
        this.f.i();
    }

    @Override // j82.e
    public final void j(boolean r2) {
        this.f.j(r2);
    }

    @Override // j82.c
    public final void k() {
        this.d.k();
    }

    @Override // j82.f
    public final void l(VSInputSectionType r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        this.g.l(r2);
    }

    @Override // j82.d
    public final boolean m() {
        return this.c.m();
    }

    @Override // j82.c
    public final void n(SkinSelection r2) {
        this.d.n(r2);
    }

    public abstract void p();

    public abstract VSInputSectionType q();

    public abstract DataCenter r();

    public abstract t9 s();

    @Override // j82.e
    public final void scrollToTop(boolean r2) {
        this.f.scrollToTop(r2);
    }

    public abstract int t();

    public abstract boolean u();

    public abstract void v();

    public abstract void w(boolean r1);

    public abstract void x();

    public abstract void y(o r1);

    public abstract void z();

    public final Map<String, String> o() {
        LinkedHashMap r0 = new LinkedHashMap();
        t9 r1 = s();
        String r2 = BuildConfig.FLAVOR;
        if (r1 == null) goto L6;
        String r3 = r1.d;
        if (r3 == null) goto L6;
    L7:
        r0.put("show_type", r3);
        t9 r4 = s();
        if (r4 == null) goto L11;
        String r5 = r4.f;
        if (r5 == null) goto L11;
    L12:
        r0.put("tab_name", r5);
        nm1.e r6 = pm1.f.c();
        com.bytedance.android.livesdk.log.filter.o r7 = null;
        if (r6 == null) goto L17;
        ReplayDataContext r8 = r6.h(null);
        if (r8 == null) goto L17;
        j r9 = r8.getVsMsgBoardDataContext();
    L19:
        if ((r9 instanceof j) == true) goto L21;
        r9 = null;
    L21:
        if (r9 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.msgboard.a r10 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r9.getValue();
        if (r10 == null) goto L24;
    L31:
        nm1.e r11 = pm1.f.c();
        if (r11 == null) goto L36;
        ReplayDataContext r13 = r11.h(null);
        if (r13 == null) goto L36;
        j r14 = r13.getVsMsgBoardDataContext();
    L38:
        if (r14 == null) goto L66;
        DataCenter r15 = r();
        if (r15 == null) goto L57;
        h r16 = pm1.f.f();
        if (r16 == null) goto L49;
        Map r17 = r16.d(r15, a0.class);
        if (r17 == null) goto L49;
        Iterator r18 = r17.entrySet().iterator();
    L47:
        if (r18.hasNext() == false) goto L49;
        Map.Entry r19 = (Map.Entry) r18.next();
        r0.put(r19.getKey(), r19.getValue());
    L49:
        h r20 = pm1.f.f();
        if (r20 == null) goto L57;
        Map r21 = r20.d(r15, b0.class);
        if (r21 == null) goto L57;
        Iterator r23 = r21.entrySet().iterator();
    L55:
        if (r23.hasNext() == false) goto L57;
        Map.Entry r24 = (Map.Entry) r23.next();
        r0.put(r24.getKey(), r24.getValue());
    L57:
        r0.put("is_replay", "1");
        r0.put("from_content_type", "replay");
        if (r10 == null) goto L65;
        Episode r25 = r10.getEpisode();
        if (r25 == null) goto L65;
        String r26 = r25.idStr;
        if (r26 == null) goto L65;
        r2 = r26;
    L65:
        r0.put("vs_from_episode_id", r2);
    L92:
        return r0;
    L66:
        com.bytedance.android.livesdk.log.filter.o r27 = r.l().j(x.class);
        if ((r27 instanceof com.bytedance.android.livesdk.log.filter.o) == true) goto L69;
        r27 = null;
    L69:
        if (r27 == null) goto L73;
        Map r28 = r27.getMap();
        if (r28 == null) goto L73;
        r0.putAll(r28);
    L73:
        com.bytedance.android.livesdk.log.filter.o r29 = r.l().j(IRoom.class);
        if ((r29 instanceof com.bytedance.android.livesdk.log.filter.o) == false) goto L77;
        r7 = r29;
    L77:
        if (r7 == null) goto L81;
        Map r30 = r7.getMap();
        if (r30 == null) goto L81;
        r0.putAll(r30);
    L81:
        r0.put("is_replay", "0");
        r0.put("from_content_type", "live");
        if (r10 == null) goto L91;
        IRoom r31 = r10.getRoom();
        if (r31 == null) goto L91;
        IEpisodeExtraInfo r33 = r31.getEpisodeExtra();
        if (r33 == null) goto L91;
        String r34 = String.valueOf(r33.getId());
        if (r34 == null) goto L91;
        r2 = r34;
    L91:
        r0.put("vs_from_episode_id", r2);
    L36:
        r14 = null;
    L24:
        u r35 = r.u(r(), null, 2);
        if (r35 == null) goto L27;
        r10 = r35.L0();
    L29:
        if ((r10 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L31;
        r10 = null;
        goto L31
    L27:
        r10 = null;
    L17:
        r9 = null;
    L11:
        r5 = BuildConfig.FLAVOR;
    L6:
        r3 = BuildConfig.FLAVOR;
        goto L7
    }

    public a(j82.a r2, j82.d r3, j82.b r4, j82.c r5, e r6, f r7) {
        Intrinsics.checkNotNullParameter(r2, "contentSectionBridge");
        Intrinsics.checkNotNullParameter(r3, "publishSectionBridge");
        Intrinsics.checkNotNullParameter(r4, "emojiSectionBridge");
        Intrinsics.checkNotNullParameter(r5, "portraitControlSectionBridge");
        Intrinsics.checkNotNullParameter(r6, "skinSectionBridge");
        Intrinsics.checkNotNullParameter(r7, "bottomTipSectionBridge");
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r4;
        this.f = r6;
        this.g = r7;
    }
}
