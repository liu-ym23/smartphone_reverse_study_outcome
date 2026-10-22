package com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp;

import ak6.g;
import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.config.cl0;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.api.comment.keyboard.HintType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.TriggerKey;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.q;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.ComponentShowTrigger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.TopicDismissTrigger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.u;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommonConfig;
import com.bytedance.android.livesdk.interactivity.j;
import com.bytedance.android.livesdk.interactivity.service.richcontent.LiveRichContentEngine;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.RoomHighlightAreaContainerMessage;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tb2.e;
import tb2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PSHighlightCommonComp extends AbsPSHighlightComp implements m.a {
    public View f;
    public TextView g;
    public Disposable h;
    public final CompositeDisposable i;
    public final Map<b6.b, List<m>> j;
    public RoomHighlightAreaContainerMessage k;
    public final PSHighlightType l;
    public final Context m;

    public static final class a implements PSHighlightRenderHelper.a {
        public final /* synthetic */ PSHighlightCommonComp a;

        public a(PSHighlightCommonComp r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper.a
        public final void a(View r5) {
            Intrinsics.checkNotNullParameter(r5, "view");
            b6 r6 = this.a.u();
            if (r6 == null) goto L5;
            String r7 = r6.g();
        L6:
            xs2.b.a().post(new q42.a(this.a));
            if (TextUtils.isEmpty(r7) == true) goto L14;
            IBaseLiveActionHandler r1 = k.f(IBaseLiveActionHandler.class);
            if (r1 != null) goto L11;
            return;
        L11:
            if (r1.handle(ContextUtil.contextToActivity(this.a.m), r7) != true) goto L16;
            this.a.v("default", null);
            return;
        L16:
            return;
        L14:
            return;
        L5:
            r7 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightRenderHelper.a
        public final boolean b(View r4, ek6.c r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            Intrinsics.checkNotNullParameter(r5, "action");
            int r6 = PSHighlightRenderHelper.a;
            String r0 = null;
            if ((r5 instanceof ib2.a) == true) goto L5;
            r5 = null;
        L5:
            ib2.a r7 = (ib2.a) r5;
            if (r7 == null) goto L8;
            tb2.b r8 = r7.a;
        L10:
            if ((r8 instanceof e) == true) goto L12;
            r8 = null;
        L12:
            e r9 = (e) r8;
            if (r9 != null) goto L15;
            return false;
        L15:
            if (f.a(r9) == false) goto L33;
            xs2.b.a().post(new q42.a(this.a));
            String r10 = r9.a().a;
            if (r10 != null) goto L19;
            return true;
        L19:
            if (Intrinsics.areEqual(r10, "main_btn") == false) goto L26;
            PSHighlightCommonComp r11 = this.a;
            b6 r1 = r11.k.getHighlightAreaContainer();
            if (r1 == null) goto L25;
            Map r2 = r1.c();
            if (r2 == null) goto L25;
            r0 = (String) r2.get("main_btn_txt");
        L25:
            r11.v(r10, r0);
            return true;
        L26:
            this.a.v(r10, null);
            return true;
        L33:
            return false;
        L8:
            r8 = null;
            goto L10
        }
    }

    public static final class b implements ak6.e {
        public final /* synthetic */ PSHighlightCommonComp a;

        public b(PSHighlightCommonComp r1) {
            this.a = r1;
        }

        public final void a(g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            Intrinsics.checkNotNullParameter(r2, "rendResult");
        }

        public final void b(g r2) {
            Intrinsics.checkNotNullParameter(r2, "rendResult");
            TextView r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.setText(r2.a);
        L5:
            PSHighlightCommonComp r3 = this.a;
            if (PSHighlightCommonComp.r(r3, r3.k) == false) goto L12;
            TextView r4 = this.a.g;
            if (r4 == null) goto L13;
            r4.post(new d(r4));
            return;
        L13:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void b() {
        Disposable r0 = this.h;
        if (r0 != null) goto L5;
    L10:
        this.h = null;
        super.b();
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final String e() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getType().getType());
        r0.append('_');
        r0.append(getType().getBizScene());
        r0.append('_');
        b6 r1 = u();
        if (r1 == null) goto L5;
        Long r2 = r1.f();
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void j() {
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.h = null;
        this.i.clear();
        Iterator r1 = ((LinkedHashMap) this.j).values().iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        Iterator r2 = ((List) r1.next()).iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        ((m) r2.next()).release();
        goto L10
    L12:
        ((LinkedHashMap) this.j).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void k() {
        InteractivityPlatformContext r0 = j.a(this.e);
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.j<t22.g> r1 = r0.getTopicTipManager();
        if (r1 == null) goto L13;
        t22.g r2 = (t22.g) r1.getValue();
        if (r2 == null) goto L14;
        r2.c(false);
        Disposable r3 = r2.c;
        if (r3 == null) goto L15;
        r3.dispose();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void l() {
        Boolean r1 = (Boolean) c("extra_key_reshow_from_rotate");
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == true) goto L15;
        Disposable r3 = this.h;
        if (r3 == null) goto L8;
        r3.dispose();
    L8:
        b6 r4 = u();
        if (r4 == null) goto L13;
        Long r5 = r4.h();
        if (r5 == null) goto L13;
        long r6 = r5.longValue();
    L14:
        int r7 = o.a;
        o.c("highlight common comp show duration is " + r6);
        this.h = RxUtilKt.h(Observable.timer(r6, TimeUnit.MILLISECONDS)).subscribe(new com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.b(this));
    L13:
        PSHighlightCommonConfig.b.getClass();
        r6 = ((PSHighlightCommonConfig) PSHighlightCommonConfig.a.getValue()).a();
    L15:
        update(this.k);
        s(true, PSHighlightCommonComp$onShow$1.INSTANCE);
        boolean r8 = Intrinsics.areEqual((Boolean) c("extra_key_reshow_from_rotate"), r2);
        String r9 = null;
        if (r8 == true) goto L49;
        Pair[] r10 = new Pair[1];
        b6 r11 = u();
        if (r11 == null) goto L21;
        Long r13 = r11.f();
    L22:
        r10[0] = TuplesKt.to("interaction_theme_id", String.valueOf(r13));
        Map r14 = MapsKt.mutableMapOf(r10);
        b6 r15 = u();
        if (r15 == null) goto L27;
        Map r16 = r15.c();
        if (r16 == null) goto L27;
        String r17 = (String) r16.get("interaction_theme_long_text");
    L28:
        if (r17 == null) goto L30;
        r14.put("interaction_theme_long_text", r17);
    L30:
        b6 r18 = u();
        if (r18 == null) goto L35;
        Map r19 = r18.c();
        if (r19 == null) goto L35;
        String r20 = (String) r19.get("interaction_theme_type");
    L36:
        if (r20 == null) goto L38;
        r14.put("interaction_theme_type", r20);
    L38:
        int r21 = o.a;
        DataCenter r23 = this.e;
        String r24 = getType().getBizScene();
        boolean r25 = z.e(this.e, false);
        DataCenter r26 = this.e;
        if (r26 == null) goto L43;
        Room r27 = z.o(r26);
        if (r27 == null) goto L43;
        Long r28 = Long.valueOf(r27.id);
    L44:
        String r29 = String.valueOf(r28);
        Intrinsics.checkNotNullParameter(r24, "msgShowType");
        Intrinsics.checkNotNullParameter(r29, "roomId");
        Intrinsics.checkNotNullParameter(r14, "extra");
        LinkedHashMap r30 = new LinkedHashMap();
        r30.put("msg_show_type", r24);
        r30.put("live_type", o.b(r23));
        if (r25 == false) goto L47;
        String r31 = "1";
    L48:
        r30.put("is_anchor", r31);
        r30.put("room_id", r29);
        r30.put("live_sub_type", o.a(r23));
        r30.putAll(r14);
        j0.l().sendLog("livesdk_public_screen_emphasize_msg_show", r30, new Object[]{x.class, IRoom.class});
        goto L49
    L47:
        r31 = "0";
    L43:
        r28 = null;
    L35:
        r20 = null;
    L27:
        r17 = null;
        goto L28
    L21:
        r13 = null;
    L49:
        InteractivityPlatformContext r33 = j.a(this.e);
        if (r33 == null) goto L79;
        com.bytedance.live.datacontext.j<t22.g> r34 = r33.getTopicTipManager();
        if (r34 == null) goto L79;
        t22.g r35 = (t22.g) r34.getValue();
        if (r35 == null) goto L79;
        RoomHighlightAreaContainerMessage r36 = this.k;
        Intrinsics.checkNotNullParameter(r36, "message");
        if (r35.a < r35.g.getFrequency()) goto L58;
        ALogger.i(r35.f, "超出展示次数，不展示底纹词");
        goto L79
    L58:
        b6 r37 = r36.getHighlightAreaContainer();
        if (r37 == null) goto L61;
        r9 = r37.a();
    L61:
        if (r9 == null) goto L74;
        int r38 = r9.hashCode();
        if (r38 == (-1105290417)) goto L72;
        if (r38 != 1917655083) goto L74;
        if (r9.equals("anchor_custom_topic") == false) goto L74;
        HintType r39 = HintType.ANCHOR_CUSTOM_TOPIC;
    L75:
        r35.e = r39;
        r35.c(true);
        r35.a++;
        Disposable r40 = r35.c;
        if (r40 == null) goto L78;
        r40.dispose();
    L78:
        Observable r41 = Observable.timer(r35.g.getDuration(), TimeUnit.SECONDS);
        int r43 = p.a;
        r35.c = r41.observeOn(AndroidSchedulers.mainThread()).subscribe(new t22.e(r35), new t22.f(r35));
        goto L79
    L72:
        if (r9.equals("comment_topic") == false) goto L74;
        r39 = HintType.COMMENT_TOPIC;
    L74:
        r39 = HintType.NORMAL;
    L79:
        Intrinsics.checkNotNullParameter("extra_key_reshow_from_rotate", "key");
        ((Map) this.a.getValue()).remove("extra_key_reshow_from_rotate");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.ArrayList] */
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void o() {
        TextView r0 = this.g;
        if (r0 == null) goto L6;
        a r2 = new a(this);
        int r3 = PSHighlightRenderHelper.a;
        Intrinsics.checkNotNullParameter(r2, "listener");
        r r4 = new r(r2);
        r0.setMovementMethod(new u());
        r0.setHighlightColor(0);
        r0.setOnClickListener(new q(r4));
    L6:
        if (Intrinsics.areEqual((Boolean) c("extra_key_reshow_from_rotate"), Boolean.TRUE) == true) goto L39;
        ((LinkedHashMap) this.j).clear();
        b6 r1 = this.k.getHighlightAreaContainer();
        if (r1 == null) goto L32;
        List r5 = r1.i();
        if (r5 == null) goto L32;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L32;
        b6.b r7 = (b6.b) r6.next();
        Map<b6.b, List<m>> r8 = this.j;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k r9 = d();
        if (r9 == null) goto L28;
        m.c r10 = r9.getTriggerMapper();
        if (r10 == null) goto L28;
        DataCenter r11 = this.e;
        if (r7 == null) goto L27;
        List<m.b> r13 = r10.a;
        ?? r14 = new ArrayList();
        Iterator r15 = ((ArrayList) r13).iterator();
    L23:
        if (r15.hasNext() == false) goto L29;
        TopicDismissTrigger r16 = ((m.b) r15.next()).a(r11, r7);
        if (r16 == null) goto L23;
        r14.add(r16);
    L29:
        if (r14 != 0) goto L31;
        r14 = CollectionsKt.emptyList();
    L31:
        r8.put(r7, (List<m>) r14);
        goto L14
    L27:
        r14 = CollectionsKt.emptyList();
    L28:
        r14 = 0;
    L32:
        Map<b6.b, List<m>> r17 = this.j;
        b6.b r18 = new b6.b();
        r18.c(2L);
        Unit r19 = Unit.INSTANCE;
        r17.put(r18, CollectionsKt.listOf(new ComponentShowTrigger(this.e)));
        Iterator r20 = ((LinkedHashMap) this.j).entrySet().iterator();
    L34:
        if (r20.hasNext() == false) goto L39;
        Map.Entry r21 = (Map.Entry) r20.next();
        b6.b r23 = (b6.b) r21.getKey();
        Iterator r24 = ((Iterable) r21.getValue()).iterator();
    L37:
        if (r24.hasNext() == false) goto L34;
        m r25 = (m) r24.next();
        r25.a(this);
        r25.b(r23);
    L39:
        DataCenter r26 = this.e;
        if (r26 != null) goto L42;
        return;
    L42:
        if (z.e(r26, false) != true) goto L57;
        RxUtilKt.c(RxBusAbility.INSTANCE.getRxBus(this.e).b(o42.b.class).subscribe(new c(this)), this.i);
        return;
    }

    public final View t() {
        View r0 = this.f;
        TextView r1 = null;
        if (r0 != null) goto L5;
        r0 = View.inflate(this.m, 2131567217, null);
        this.f = r0;
    L5:
        View r2 = this.f;
        if (r2 == null) goto L8;
        r1 = (TextView) r2.findViewById(2131390021);
    L8:
        this.g = r1;
        PSHighlightRenderHelper.b(this.e, r1);
        return r0;
    }

    public final b6 u() {
        return this.k.getHighlightAreaContainer();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public /* bridge */ /* synthetic */ n getType() {
        return getType();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public final View getView() {
        return t();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp
    public final void i() {
        t();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.AbsPSHighlightComp, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.g
    public PSHighlightType getType() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.m.a
    public final void a(TriggerKey r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        int r3 = com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.a.a[r2.ordinal()];
        if (r3 == 1) goto L8;
        if (r3 == 2) goto L8;
        return;
    L8:
        if (g() == false) goto L10;
        return;
    L10:
        s(false, new PSHighlightCommonComp$onTrigger$1(this));
    }

    public final void update(RoomHighlightAreaContainerMessage r5) {
        Intrinsics.checkNotNullParameter(r5, "areaContainerMessage");
        int r0 = PSHighlightRenderHelper.a;
        TextView r1 = this.g;
        if (r1 == null) goto L5;
        int r2 = PSHighlightRenderHelper.b;
        int r3 = PSHighlightRenderHelper.c;
        r1.setPadding(r2, r3, PSHighlightRenderHelper.d, r3);
    L5:
        this.k = r5;
        b6 r6 = u();
        if (r6 == null) goto L11;
        a5 r7 = r6.b();
        if (r7 == null) goto L12;
        int r4 = mb2.d.a;
        Intrinsics.checkNotNullParameter(r7, "text");
        ek6.e r8 = mb2.d.a(r7, null, 1.0f);
        LiveRichContentEngine.a().a().c(r8, (com.bytedance.android.livesdk.interactivity.service.richcontent.config.b) PSHighlightRenderHelper.e.getValue(), new b(this));
        return;
    L12:
        return;
    }

    public static final boolean r(PSHighlightCommonComp r1, RoomHighlightAreaContainerMessage r2) {
        r1.getClass();
        if (((Boolean) cl0.a.getValue()).booleanValue() == false) goto L13;
        PublicAreaCommon r3 = r2.getPublicAreaCommon();
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.getHasTailButton() != true) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public final void s(boolean r3, final Function0<Unit> r4) {
        Function0<Unit> r0 = new PSHighlightCommonComp$doAnim$internalEnd$1(r4);
        PSHighlightRenderHelper.c(this.f, r3, PSHighlightRenderHelper.AnimType.VerticalFadeSlide, r0).c();
    }

    public final void v(String r11, String r13) {
        Pair[] r1 = new Pair[1];
        b6 r2 = u();
        Long r3 = null;
        if (r2 == null) goto L5;
        Long r4 = r2.f();
    L6:
        r1[0] = TuplesKt.to("interaction_theme_id", String.valueOf(r4));
        Map r5 = MapsKt.mutableMapOf(r1);
        b6 r6 = u();
        if (r6 == null) goto L11;
        Map r7 = r6.c();
        if (r7 == null) goto L11;
        String r8 = (String) r7.get("interaction_theme_long_text");
    L12:
        if (r8 == null) goto L14;
        r5.put("interaction_theme_long_text", r8);
    L14:
        b6 r9 = u();
        if (r9 == null) goto L19;
        Map r10 = r9.c();
        if (r10 == null) goto L19;
        String r14 = (String) r10.get("interaction_theme_type");
    L20:
        if (r14 == null) goto L22;
        r5.put("interaction_theme_type", r14);
    L22:
        r5.put("live_type", o.b(this.e));
        r5.put("live_sub_type", o.a(this.e));
        if (r13 == null) goto L25;
        r5.put("btn_text", r13);
    L25:
        DataCenter r15 = this.e;
        String r16 = getType().getBizScene();
        boolean r17 = z.e(this.e, false);
        DataCenter r18 = this.e;
        if (r18 == null) goto L30;
        Room r19 = z.o(r18);
        if (r19 == null) goto L30;
        r3 = Long.valueOf(r19.id);
    L30:
        String r20 = String.valueOf(r3);
        Intrinsics.checkNotNullParameter(r16, "msgShowType");
        Intrinsics.checkNotNullParameter(r11, "clickArea");
        Intrinsics.checkNotNullParameter(r20, "roomId");
        Intrinsics.checkNotNullParameter(r5, "extra");
        LinkedHashMap r21 = new LinkedHashMap();
        r21.put("msg_show_type", r16);
        r21.put("live_type", o.b(r15));
        r21.put("live_sub_type", o.a(r15));
        if (r17 == false) goto L33;
        String r110 = "1";
    L34:
        r21.put("is_anchor", r110);
        r21.put("room_id", r20);
        r21.put("click_area", r11);
        r21.putAll(r5);
        j0.l().sendLog("livesdk_public_screen_emphasize_msg_click", r21, new Object[]{x.class, IRoom.class});
        return;
    L33:
        r110 = "0";
    L19:
        r14 = null;
    L11:
        r8 = null;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public PSHighlightCommonComp(RoomHighlightAreaContainerMessage r2, PSHighlightType r3, Context r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r2, "containerMessage");
        Intrinsics.checkNotNullParameter(r3, "type");
        b6 r0 = r2.getHighlightAreaContainer();
        if (r0 == null) goto L5;
        Long r1 = r0.f();
    L6:
        super(String.valueOf(r1), r3, r5);
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.i = new CompositeDisposable();
        this.j = new LinkedHashMap();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
