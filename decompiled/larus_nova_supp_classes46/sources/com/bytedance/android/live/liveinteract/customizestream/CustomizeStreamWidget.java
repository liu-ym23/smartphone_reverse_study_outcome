package com.bytedance.android.live.liveinteract.customizestream;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.model.message.s;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.g9;
import com.bytedance.android.livesdk.message.model.wj;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hg6.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import je0.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import nh0.f;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/customizestream/CustomizeStreamWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lcom/bytedance/android/live/liveinteract/customizestream/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomizeStreamWidget extends PlatformMultiLinkWidget implements com.bytedance.android.live.liveinteract.customizestream.b, Observer<KVData>, l {
    public final CompositeDisposable a;
    public CustomizeStreamContext b;
    public i<ILinkPlayerInfoBridge> c;
    public boolean d;
    public String e;
    public String f;
    public wj.b g;
    public Handler h;
    public final c i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CustomizeStreamWidget a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ com.bytedance.android.live.ui.c c;

        public b(CustomizeStreamWidget r1, boolean r2, com.bytedance.android.live.ui.c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            this.a.d = true;
            com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "onSeiUpdated hide audio bg");
            if (this.b == false) goto L5;
            int r0 = vd0.a.g;
            vd0.a.C0284a.a(((Widget) this.a).dataCenter).d(true);
        L14:
            CustomizeStreamContext r1 = CustomizeStreamContext.Companion.getContext();
            if (r1 == null) goto L20;
            m<Boolean> r2 = r1.getNeedHideAudioBg();
            if (r2 == null) goto L21;
            r2.setValue(Boolean.TRUE);
            return;
        L21:
            return;
        L20:
            return;
        L5:
            IInteractService r3 = (IInteractService) k.f(IInteractService.class);
            IVoiceLiveTheme r4 = null;
            if (r3 == null) goto L8;
            x00.a r5 = r3.getThemeManager(d.r(), ((Widget) this.a).dataCenter);
        L9:
            if (r5 == null) goto L11;
            r4 = r5.q(2);
        L11:
            com.bytedance.android.live.ui.c r6 = this.c;
            if (r6 == null) goto L14;
            r6.c(r4);
            goto L14
        L8:
            r5 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c extends i.a<ILinkPlayerInfoBridge> {
        @Override // com.bytedance.android.live.liveinteract.plantform.base.i.b
        public final void onOnlineListChanged(List<ILinkPlayerInfoBridge> r1) {
        }

        public c() {
        }
    }

    static {
    }

    public final boolean wq() {
        cg6.a r0 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r0 == null) goto L7;
        g r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        return r1.A();
    L7:
        return false;
    }

    public CustomizeStreamWidget() {
        this.a = new CompositeDisposable();
        this.e = "0";
        this.f = "0";
        this.h = new Handler(Looper.getMainLooper());
        this.i = new c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return d.f();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "onCreate");
        Pair r0 = com.bytedance.live.datacontext.d.a(CustomizeStreamWidget$intiDataContext$1.INSTANCE);
        CustomizeStreamContext r2 = (CustomizeStreamContext) r0.component1();
        Disposable r1 = (Disposable) r0.component2();
        this.b = r2;
        r2.getService().d(this);
        com.bytedance.live.datacontext.b.a(r2, CustomizeStreamContext.KEY_CUSTOMIZE_STREAM_DATA);
        this.a.add(r1);
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L5;
        r3.observe("data_multi_link_dynamic_layout_info_change", this);
    L5:
        xs2.b.a().post(new jd0.a("onCreate"));
        IInteractService r4 = (IInteractService) k.f(IInteractService.class);
        f r5 = null;
        if (r4 == null) goto L8;
        i<ILinkPlayerInfoBridge> r6 = r4.getLinkUserInfoCenter();
    L9:
        this.c = r6;
        if (r6 == null) goto L12;
        r6.Q4(this.i);
    L12:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L15;
        r5 = (f) r7.get("data_multi_link_dynamic_layout_info_change", new f(null, null, null, null, null, null, false, 255));
    L15:
        if (r5 == null) goto L19;
        sf0.b r8 = r5.e;
        if (r8 == null) goto L19;
        zq(r8, "initIsInCustomizeStream");
    L19:
        o r9 = o3.g(this);
        if (r9 == null) goto L32;
        m r10 = r9.getRoom();
        if (r10 == null) goto L32;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L32;
        z5 r12 = r11.getLinkerDetail();
        if (r12 == null) goto L32;
        List r13 = r12.getFeatureList();
        if (r13 == null) goto L32;
        if (r13.contains(4L) != true) goto L32;
        yq(true, "init by linker detail");
    L32:
        t r14 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r14 == null) goto L38;
        j r15 = r14.getMessageManager();
        if (r15 == null) goto L39;
        r15.c(new AnonymousClass1(this));
        return;
    L39:
        return;
    L38:
        return;
    L8:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "onDestroy");
        this.b = null;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L5;
        r1.removeObserver("data_multi_link_dynamic_layout_info_change", this);
    L5:
        this.a.dispose();
        i<ILinkPlayerInfoBridge> r2 = this.c;
        if (r2 == null) goto L8;
        r2.T4(this.i);
    L8:
        t r3 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r3 == null) goto L14;
        j r4 = r3.getMessageManager();
        if (r4 == null) goto L14;
        r4.c(new C03021(this));
    L14:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L16;
        int r5 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).d(false);
    L16:
        Handler r6 = this.h;
        if (r6 == null) goto L19;
        r6.removeCallbacksAndMessages(null);
    L19:
        this.h = null;
    }

    @Override // com.bytedance.android.live.liveinteract.customizestream.b
    public final String B5() {
        return this.e;
    }

    @Override // com.bytedance.android.live.liveinteract.customizestream.b
    public final String m8() {
        return this.f;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L5;
        String r0 = r4.getKey();
    L7:
        if (Intrinsics.areEqual(r0, "data_multi_link_dynamic_layout_info_change") == false) goto L16;
        f r5 = (f) r4.getData();
        if (r5 == null) goto L18;
        sf0.b r6 = r5.e;
        if (r6 == null) goto L15;
        zq(r6, "layoutInfoChange");
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.linkbase.DynamicFrameInfo");
    L18:
        return;
    L16:
        return;
    L5:
        r0 = null;
        goto L7
    }

    public final void onMessage(tlc.d r18) {
        boolean r4 = true;
        String r6 = "";
        String r9 = null;
        if ((r18 instanceof g9) == false) goto L120;
        StringBuilder r2 = new StringBuilder("onMessage ");
        g9 r1 = (g9) r18;
        r2.append(r1.getMsg_type());
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", r2.toString());
        if (r1.getMsg_type() == 102) goto L8;
        return;
    L8:
        if (r1.getAudioShowMediaContent() != null) goto L10;
        return;
    L10:
        s r3 = r1.getAudioShowMediaContent();
        if (r3 != null) goto L13;
    L15:
        r4 = false;
    L16:
        StringBuilder r5 = new StringBuilder("onMessage isEnable ");
        r5.append(r4);
        r5.append(" lastStatus ");
        CustomizeStreamContext r7 = this.b;
        if (r7 == null) goto L21;
        m<Boolean> r8 = r7.getCustomizeStreamStarted();
        if (r8 == null) goto L21;
        Boolean r10 = (Boolean) r8.getValue();
    L22:
        r5.append(r10);
        r5.append(" new pusher ");
        s r11 = r1.getAudioShowMediaContent();
        if (r11 == null) goto L25;
        String r12 = r11.getShowUserId();
    L26:
        r5.append(r12);
        r5.append(" lastPusherUid ");
        r5.append(this.e);
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", r5.toString());
        String r13 = "0";
        if (r4 == false) goto L107;
        int r14 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        s r15 = r1.getAudioShowMediaContent();
        if (r15 == null) goto L31;
        String r16 = r15.getShowUserId();
    L33:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r16) == false) goto L62;
        s r17 = r1.getAudioShowMediaContent();
        if (r17 == null) goto L37;
        String r19 = r17.getShowUserId();
    L38:
        wj.b r110 = this.g;
        if (r110 == null) goto L41;
        String r111 = r110.c();
    L43:
        if (Intrinsics.areEqual(r19, r111) == false) goto L62;
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "customizeStreamType change to DIGITAL_HUMAN");
        CustomizeStreamContext r20 = this.b;
        if (r20 == null) goto L49;
        m<Integer> r21 = r20.getCustomizeStreamType();
        if (r21 == null) goto L49;
        r21.setValue(2);
    L49:
        CustomizeStreamContext r22 = this.b;
        if (r22 == null) goto L62;
        m<String> r23 = r22.getCustomizeWTNStreamID();
        if (r23 == null) goto L62;
        wj.b r24 = this.g;
        if (r24 == null) goto L61;
        wj.c r25 = r24.a();
        if (r25 == null) goto L61;
        String r26 = r25.a();
        if (r26 == null) goto L61;
        r6 = r26;
    L61:
        r23.setValue(r6);
        goto L62
    L41:
        r111 = null;
        goto L43
    L37:
        r19 = null;
    L62:
        CustomizeStreamContext r27 = this.b;
        if (r27 == null) goto L95;
        m<Boolean> r28 = r27.getCustomizeStreamStarted();
        if (r28 == null) goto L95;
        if (((Boolean) r28.getValue()).booleanValue() != r4) goto L95;
        String r29 = this.e;
        s r30 = r1.getAudioShowMediaContent();
        if (r30 == null) goto L72;
        r9 = r30.getShowUserId();
    L72:
        if (Intrinsics.areEqual(r29, r9) == true) goto L95;
        CustomizeStreamContext r31 = this.b;
        if (r31 == null) goto L79;
        m<Boolean> r32 = r31.getCustomizeStreamStarted();
        if (r32 == null) goto L79;
        r32.setValue(Boolean.FALSE);
    L79:
        s r33 = r1.getAudioShowMediaContent();
        if (r33 == null) goto L83;
        String r34 = r33.getShowUserId();
        if (r34 == null) goto L83;
    L84:
        this.e = r34;
        s r35 = r1.getAudioShowMediaContent();
        if (r35 == null) goto L90;
        String r36 = r35.getLinkMicID();
        if (r36 == null) goto L90;
        r13 = r36;
    L90:
        this.f = r13;
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "update customizeStreamStarted by force");
        CustomizeStreamContext r37 = this.b;
        if (r37 == null) goto L220;
        m<Boolean> r38 = r37.getCustomizeStreamStarted();
        if (r38 == null) goto L221;
        r38.setValue(Boolean.valueOf(r4));
        return;
    L221:
        return;
    L220:
        return;
    L83:
        r34 = "0";
    L95:
        s r39 = r1.getAudioShowMediaContent();
        if (r39 == null) goto L99;
        String r40 = r39.getShowUserId();
        if (r40 == null) goto L99;
    L100:
        this.e = r40;
        s r41 = r1.getAudioShowMediaContent();
        if (r41 == null) goto L106;
        String r42 = r41.getLinkMicID();
        if (r42 == null) goto L106;
        r13 = r42;
    L106:
        this.f = r13;
        yq(r4, "onMessage normal");
        return;
    L99:
        r40 = "0";
        goto L100
    L31:
        r16 = null;
        goto L33
    L107:
        s r43 = r1.getAudioShowMediaContent();
        if (r43 == null) goto L110;
        String r44 = r43.getShowUserId();
    L112:
        if (Intrinsics.areEqual(r44, this.e) == true) goto L118;
        s r45 = r1.getAudioShowMediaContent();
        if (r45 == null) goto L117;
        r9 = r45.getShowUserId();
    L117:
        if (Intrinsics.areEqual(r9, "0") == true) goto L118;
        return;
    L118:
        this.e = "0";
        this.f = "0";
        yq(r4, "onMessage normal");
        return;
    L110:
        r44 = null;
        goto L112
    L25:
        r12 = null;
    L21:
        r10 = null;
        goto L22
    L13:
        if (((int) r3.getStatus()) != 1) goto L15;
    L120:
        if ((r18 instanceof wj) == false) goto L226;
        StringBuilder r46 = new StringBuilder("onMessage RoomDigitalHumanMessage size ");
        wj r47 = (wj) r18;
        List r112 = r47.E();
        if (r112 == null) goto L124;
        Integer r113 = Integer.valueOf(r112.size());
    L125:
        r46.append(r113);
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", r46.toString());
        List r48 = r47.E();
        if (r48 != null) goto L128;
    L131:
        boolean r49 = true;
    L132:
        if (r49 == true) goto L203;
        List r50 = r47.E();
        if (r50 == null) goto L152;
        ArrayList r51 = new ArrayList();
        Iterator r52 = r50.iterator();
    L137:
        if (r52.hasNext() == false) goto L153;
        Object r114 = r52.next();
        wj.b r115 = (wj.b) r114;
        if (r115.b() != 1) goto L141;
    L142:
        int r116 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        wj.c r117 = r115.a();
        if (r117 == null) goto L145;
        String r118 = r117.a();
    L147:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r118) == false) goto L149;
        boolean r119 = true;
    L150:
        if (r119 == false) goto L137;
        r51.add(r114);
    L149:
        r119 = false;
        goto L150
    L145:
        r118 = null;
        goto L147
    L141:
        if (r115.b() != 2) goto L149;
    L153:
        if (r51 != null) goto L155;
    L158:
        boolean r53 = true;
    L159:
        if (r53 == true) goto L193;
        StringBuilder r54 = new StringBuilder("usingInfo ");
        if (r51 == null) goto L163;
        Integer r55 = Integer.valueOf(r51.size());
    L164:
        r54.append(r55.intValue());
        r54.append("  ");
        if (r51 == null) goto L169;
        wj.b r56 = (wj.b) ListProtector.get(r51, 0);
        if (r56 == null) goto L169;
        r9 = r56.c();
    L169:
        r54.append(r9);
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", r54.toString());
        this.g = (wj.b) ListProtector.get(r51, 0);
        CustomizeStreamContext r57 = this.b;
        if (r57 == null) goto L227;
        m<Boolean> r58 = r57.getCustomizeStreamStarted();
        if (r58 != null) goto L174;
        return;
    L174:
        if (((Boolean) r58.getValue()).booleanValue() != true) goto L229;
        CustomizeStreamContext r59 = this.b;
        if (r59 == null) goto L180;
        m<Integer> r60 = r59.getCustomizeStreamType();
        if (r60 == null) goto L180;
        r60.setValue(2);
    L180:
        CustomizeStreamContext r61 = this.b;
        if (r61 == null) goto L230;
        m<String> r62 = r61.getCustomizeWTNStreamID();
        if (r62 == null) goto L231;
        wj.b r63 = this.g;
        if (r63 == null) goto L192;
        wj.c r65 = r63.a();
        if (r65 == null) goto L192;
        String r66 = r65.a();
        if (r66 == null) goto L192;
        r6 = r66;
    L192:
        r62.setValue(r6);
        return;
    L231:
        return;
    L230:
        return;
    L229:
        return;
    L227:
        return;
    L163:
        r55 = null;
        goto L164
    L193:
        CustomizeStreamContext r67 = this.b;
        if (r67 == null) goto L198;
        m<Integer> r68 = r67.getCustomizeStreamType();
        if (r68 == null) goto L198;
        r68.setValue(1);
    L198:
        CustomizeStreamContext r69 = this.b;
        if (r69 == null) goto L233;
        m<String> r70 = r69.getCustomizeWTNStreamID();
        if (r70 == null) goto L234;
        r70.setValue("");
        return;
    L234:
        return;
    L233:
        return;
    L155:
        if (r51.isEmpty() == true) goto L158;
        r53 = false;
        goto L159
    L152:
        r51 = null;
        goto L153
    L203:
        CustomizeStreamContext r71 = this.b;
        if (r71 == null) goto L208;
        m<Integer> r72 = r71.getCustomizeStreamType();
        if (r72 == null) goto L208;
        r72.setValue(1);
    L208:
        CustomizeStreamContext r73 = this.b;
        if (r73 == null) goto L213;
        m<String> r74 = r73.getCustomizeWTNStreamID();
        if (r74 == null) goto L213;
        r74.setValue("");
    L213:
        this.g = null;
        return;
    L128:
        if (r48.isEmpty() == true) goto L131;
        r49 = false;
        goto L132
    L124:
        r113 = null;
        goto L125
    }

    public final void xq(SeiAppData r6) {
        Intrinsics.checkNotNullParameter(r6, "sei");
        int r7 = r6.getHideAudioBg();
        IVoiceLiveTheme r1 = null;
        boolean r2 = false;
        if (r7 == 1) goto L30;
        if (r7 != 2) goto L58;
        boolean r8 = MultiLinkLoadWidgetUtils.g();
        if (vm2.d.S0() == false) goto L10;
        if (r8 == true) goto L10;
        boolean r0 = true;
    L11:
        com.bytedance.android.live.liveinteract.plantform.base.g r4 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r4 == null) goto L14;
        com.bytedance.android.live.ui.c r5 = r4.y4();
    L15:
        if (r0 == false) goto L22;
        if (r5 == null) goto L24;
        if (r5.h == null) goto L20;
        boolean r3 = true;
    L21:
        if (r3 != true) goto L24;
    L20:
        r3 = false;
    L24:
        if (wq() == true) goto L51;
        if (r2 == false) goto L52;
        Handler r9 = this.h;
        if (r9 == null) goto L53;
        r9.postDelayed(new b(this, r8, r5), ((Number) vm2.d.o2.getValue(null, vm2.d.a[168(0xa8, float:2.35E-43)])).longValue());
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L22:
        r2 = true;
        goto L24
    L14:
        r5 = null;
    L10:
        r0 = false;
        goto L11
    L58:
        return;
    L30:
        if (this.d == false) goto L55;
        this.d = false;
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "onSeiUpdated show audio bg");
        if (MultiLinkLoadWidgetUtils.g() == false) goto L34;
        int r10 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).d(false);
    L45:
        CustomizeStreamContext r11 = CustomizeStreamContext.Companion.getContext();
        if (r11 == null) goto L56;
        m<Boolean> r12 = r11.getNeedHideAudioBg();
        if (r12 == null) goto L57;
        r12.setValue(Boolean.FALSE);
        return;
    L57:
        return;
    L56:
        return;
    L34:
        IInteractService r13 = (IInteractService) k.f(IInteractService.class);
        if (r13 == null) goto L37;
        x00.a r14 = r13.getThemeManager(d.r(), ((Widget) this).dataCenter);
    L38:
        if (r14 == null) goto L40;
        r1 = r14.q(2);
    L40:
        com.bytedance.android.live.liveinteract.plantform.base.g r15 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r15 == null) goto L45;
        com.bytedance.android.live.ui.c r16 = r15.y4();
        if (r16 == null) goto L45;
        r16.b(r1);
        goto L45
    L37:
        r14 = null;
        goto L38
    }

    public final void yq(boolean r3, String r4) {
        CustomizeStreamContext r0 = this.b;
        if (r0 == null) goto L8;
        m<Boolean> r1 = r0.getCustomizeStreamStarted();
        if (r1 == null) goto L8;
        if (r3 != ((Boolean) r1.getValue()).booleanValue()) goto L8;
        return;
    L8:
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "updateCustomizeStreamStatus " + r3 + " source " + r4);
        CustomizeStreamContext r5 = this.b;
        if (r5 == null) goto L14;
        m<Boolean> r6 = r5.getCustomizeStreamStarted();
        if (r6 == null) goto L14;
        r6.setValue(Boolean.valueOf(r3));
    L14:
        if (wq() == false) goto L28;
        if (r3 == false) goto L28;
        cg6.a r7 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r7 == null) goto L28;
        g r8 = r7.getRtcManager();
        if (r8 == null) goto L28;
        ei6.a r9 = r8.V0();
        if (r9 == null) goto L28;
        xi6.c r10 = r9.t();
        if (r10 == null) goto L28;
        com.bytedance.live.livelink.kmp.impl.core.video.c r11 = r10.d();
        if (r11 == null) goto L28;
        r11.o(false);
    L28:
        if (vm2.d.S0() == false) goto L30;
        boolean r12 = wq();
    L32:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L37;
        if (r12 == false) goto L38;
        int r13 = vd0.a.g;
        vd0.a.C0284a.a(((Widget) this).dataCenter).d(r3);
        return;
    L38:
        return;
    L37:
        return;
    L30:
        r12 = true;
        goto L32
    }

    public final void zq(sf0.b r5, String r6) {
        StringBuilder r0 = new StringBuilder("onChanged ");
        List<Integer> r2 = r5.b;
        Boolean r3 = null;
        if (r2 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r2.contains(8));
    L6:
        r0.append(r4.booleanValue());
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", r0.toString());
        List<Integer> r7 = r5.b;
        if (r7 == null) goto L9;
        r3 = Boolean.valueOf(r7.contains(8));
    L9:
        boolean r8 = r3.booleanValue();
        CustomizeStreamContext.a r1 = CustomizeStreamContext.Companion;
        CustomizeStreamContext r9 = r1.getContext();
        if (r9 == null) goto L15;
        m<Boolean> r10 = r9.getGuestInCustomizeStreamLayout();
        if (r10 == null) goto L15;
        if (r8 != ((Boolean) r10.getValue()).booleanValue()) goto L15;
        return;
    L15:
        com.bytedance.android.live.liveinteract.customizestream.a.a("CustomizeStreamWidget", "source=" + r6 + ", notify  guestInCustomizeStreamLayout " + r8);
        CustomizeStreamContext r11 = r1.getContext();
        if (r11 == null) goto L20;
        m<Boolean> r12 = r11.getGuestInCustomizeStreamLayout();
        if (r12 == null) goto L20;
        r12.setValue(Boolean.valueOf(r8));
    L20:
        DataCenter r13 = ((Widget) this).dataCenter;
        if (r13 == null) goto L25;
        r13.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "cutomize_stream"));
        return;
    L25:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
