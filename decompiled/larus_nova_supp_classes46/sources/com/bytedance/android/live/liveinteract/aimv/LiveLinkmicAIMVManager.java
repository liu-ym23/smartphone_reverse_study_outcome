package com.bytedance.android.live.liveinteract.aimv;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.plantform.multiroom.e;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.bt0;
import com.bytedance.android.livesdk.config.ja;
import com.bytedance.android.livesdk.config.ls0;
import com.bytedance.android.livesdk.config.ms0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.mv.opus.OpusServiceImpl;
import com.bytedance.android.livesdk.message.model.LinkmicRoomSongMessage;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingInfoV2;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveLinkmicAIMVManager {
    public FrameLayout a;
    public TextureView b;
    public View c;
    public View d;
    public RoomSongInfo e;
    public com.bytedance.android.livesdk.ktvapi.model.mv.c f;
    public final CompositeDisposable g;
    public String h;
    public Boolean i;
    public boolean j;
    public TextView k;
    public com.example.myapplication.a l;
    public final Boolean m;
    public boolean n;
    public final String o;
    public Long p;
    public Long q;
    public final Context r;
    public final DataCenter s;
    public final j1 t;

    public static final class a implements TextureView.SurfaceTextureListener {
        public final /* synthetic */ LiveLinkmicAIMVManager a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
            Intrinsics.checkNotNullParameter(r2, "surface");
        }

        public a(LiveLinkmicAIMVManager r1) {
            this.a = r1;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "surface");
            com.bytedance.android.livesdk.ktvapi.model.mv.c r4 = this.a.f;
            if (r4 == null) goto L6;
            r4.c(new Surface(r1));
            return;
        }
    }

    public static String e() {
        return "MV-ID: " + com.bytedance.android.live.liveinteract.utils.a.m + "\n是否降级: " + com.bytedance.android.live.liveinteract.utils.a.o + "\n歌曲ID: " + com.bytedance.android.live.liveinteract.utils.a.b + "\n是否高危: " + com.bytedance.android.live.liveinteract.utils.a.g + "\n歌曲名称: " + com.bytedance.android.live.liveinteract.utils.a.d + "\n相似度: " + com.bytedance.android.live.liveinteract.utils.a.c + "\n是否有歌词：" + com.bytedance.android.live.liveinteract.utils.a.k + "\n字体: " + com.bytedance.android.live.liveinteract.utils.a.l + "\n是否在副歌：" + com.bytedance.android.live.liveinteract.utils.a.h + "\n是否纯音乐： " + com.bytedance.android.live.liveinteract.utils.a.i + "\n曲风标签：" + com.bytedance.android.live.liveinteract.utils.a.j + "\n副歌：" + GsonProtectorUtils.toJson(GsonHelper.get(), com.bytedance.android.live.liveinteract.utils.a.e) + "\n进度：" + com.bytedance.android.live.liveinteract.utils.a.f + "\n歌曲识别结果：" + com.bytedance.android.live.liveinteract.utils.a.n + '\n';
    }

    public final void d() {
        if (d.o() == false) goto L7;
        com.bytedance.android.livesdk.ktvapi.model.mv.c r0 = this.f;
        if (r0 == null) goto L7;
        r0.release();
    L7:
        this.e = null;
        this.g.dispose();
        String r1 = this.h;
        int r2 = 0;
        if (r1 == null) goto L14;
        IInteractService r3 = (IInteractService) k.f(IInteractService.class);
        if (r3 == null) goto L14;
        com.bytedance.android.live.liveinteract.plantform.performance.a r4 = r3.getMultiLinkPerfAbilityManager(false);
        if (r4 == null) goto L14;
        r4.c("multilink_base_degrade", r1);
    L14:
        this.h = null;
        this.j = false;
        RoomSongInfo r5 = this.e;
        if (r5 == null) goto L19;
        IMVBaseInfo r6 = r5.getMvBaseInfo();
        if (r6 == null) goto L19;
        r2 = f(r6);
    L19:
        Long r7 = this.p;
        if (r7 == null) goto L34;
        long r8 = r7.longValue();
        RoomSongInfo r9 = this.e;
        if (r9 == null) goto L27;
        IMVBaseInfo r10 = r9.getMvBaseInfo();
        if (r10 == null) goto L27;
        String r11 = r10.getVid();
        if (r11 == null) goto L27;
    L28:
        String r12 = r11;
        RoomSongInfo r13 = this.e;
        if (r13 == null) goto L31;
        Long r14 = Long.valueOf(r13.getSongId());
    L32:
        InteractiveSongLoggerKt.f("", r12, false, String.valueOf(r14), "cut", System.currentTimeMillis() - r8, Integer.valueOf(r2), "ai_stage_effect");
        this.p = null;
        goto L34
    L31:
        r14 = null;
    L27:
        r11 = "";
    L34:
        if (je0.d.r() == true) goto L40;
        Long r15 = this.q;
        if (r15 == null) goto L38;
        InteractiveSongLoggerKt.d(System.currentTimeMillis() - r15.longValue());
    L38:
        this.q = null;
        return;
    }

    public final void a(final FrameLayout r17) {
        if (d.o() == false) goto L15;
        com.bytedance.android.livesdk.ktvapi.model.mv.d r2 = k.n(IKtvService.class).createOpusMvService();
        if (r2 == null) goto L9;
        HashMap r5 = new HashMap();
        r5.put(199, 1);
        Unit r6 = Unit.INSTANCE;
        com.bytedance.android.livesdk.ktvimpl.mv.opus.d r3 = r2.a(r5);
        if (r3 == null) goto L9;
        OpusServiceImpl r4 = r3.build(this.r);
    L10:
        this.f = r4;
        InteractiveSongContext r7 = InteractiveSongContext.Companion.getContext();
        if (r7 == null) goto L15;
        n<com.bytedance.android.livesdk.ktvapi.model.mv.c> r8 = r7.getAiMVPlayService();
        if (r8 == null) goto L15;
        r8.setValue(this.f);
    L9:
        r4 = null;
    L15:
        Pair r9 = com.bytedance.live.datacontext.d.a(LiveLinkmicAIMVManager$attach$pair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((LiveLinkmicAIMVContext) r9.getFirst(), com.bytedance.android.live.liveinteract.aimv.a.class);
        this.g.add((Disposable) r9.getSecond());
        this.l = new com.example.myapplication.a(this.r);
        if (r17 == null) goto L18;
        r17.setVisibility(8);
    L18:
        this.c = new View(this.r);
        View r10 = new View(this.r);
        r10.setBackgroundColor(s1.h(2131107691));
        r10.setAlpha(0.15f);
        r10.setVisibility(8);
        Unit r11 = Unit.INSTANCE;
        this.d = r10;
        this.b = new TextureView(this.r);
        final FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-1, -1);
        if (r17 == null) goto L42;
        r17.removeAllViews();
        r17.setEnabled(false);
        r17.setClickable(false);
        r17.setFocusableInTouchMode(false);
        int r13 = s1.y();
        ViewGroup.LayoutParams r14 = new FrameLayout.LayoutParams(r13, (int) ((r13 * 4) / 3.0f));
        AlphaMaskFrameLayout r15 = new AlphaMaskFrameLayout(r17.getContext(), null);
        ArrayList r16 = new ArrayList();
        r16.add(new Pair(Float.valueOf(0.0f), Float.valueOf(1.0f)));
        r16.add(new Pair(Float.valueOf(0.15f), Float.valueOf(0.6f)));
        r16.add(new Pair(Float.valueOf(0.45f), Float.valueOf(0.8f)));
        r16.add(new Pair(Float.valueOf(0.9f), Float.valueOf(0.1f)));
        r16.add(new Pair(Float.valueOf(1.0f), Float.valueOf(0.0f)));
        r15.setAlphaMask(r16);
        r15.addView(this.b, r12);
        View r18 = this.c;
        if (r18 == null) goto L23;
        r18.setVisibility(8);
    L23:
        View r19 = this.d;
        if (r19 == null) goto L26;
        r19.setVisibility(8);
    L26:
        boolean r20 = MultiLinkLoadWidgetUtils.g();
        int r21 = vd0.a.g;
        vd0.a r22 = vd0.a.C0284a.a(this.s);
        if (r20 == false) goto L29;
        FrameLayout r23 = new FrameLayout(r17.getContext());
        this.a = r23;
        r23.addView(this.c, r12);
        r23.addView(r15, r14);
        r23.addView(this.d, r12);
        r22.b(1000, 1001, new zd0.c(r23));
        zd0.a r24 = new zd0.a();
        Intrinsics.checkNotNullParameter(r24, "bgView");
        ((ArrayList) r22.b.a).add(r24);
    L31:
        if (v.a() == false) goto L42;
        if (((Boolean) ls0.a.getValue()).booleanValue() == false) goto L42;
        Activity r25 = com.bytedance.android.live.core.utils.a.d();
        if (r25 == null) goto L42;
        FrameLayout r26 = (FrameLayout) r25.findViewById(R.id.content);
        if (r26 == null) goto L42;
        if (((Boolean) ms0.a.getValue()).booleanValue() == false) goto L41;
        final EditText r27 = new EditText(this.r);
        r27.setHint("输入要识别的歌曲(上传到tos,比如上传文件名为yxdcb.mp3,输入yxdcb)");
        r27.setTextSize(14.0f);
        r27.setTextColor(-65536);
        r27.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(-2, -2);
        r28.topMargin = (int) UtilityKotlinExtentionsKt.h(250);
        r27.setLayoutParams(r28);
        r26.addView(r27);
        Button r29 = new Button(this.r);
        r29.setText("start");
        FrameLayout.LayoutParams r110 = new FrameLayout.LayoutParams(-2, -2);
        r110.topMargin = (int) UtilityKotlinExtentionsKt.h(300);
        r29.setLayoutParams(r110);
        r26.addView(r29);
        r29.setOnClickListener(new LiveLinkmicAIMVManager$mockBtn$1(this, r27));
        Button r30 = new Button(this.r);
        r30.setText("stop");
        FrameLayout.LayoutParams r31 = new FrameLayout.LayoutParams(-2, -2);
        r31.topMargin = (int) UtilityKotlinExtentionsKt.h(350);
        r30.setLayoutParams(r31);
        r26.addView(r30);
        r30.setOnClickListener(new c(this));
    L41:
        TextView r32 = new TextView(r17.getContext());
        r32.setTextSize(14.0f);
        r32.setTextColor(-65536);
        r32.setText(e());
        r32.setFocusableInTouchMode(false);
        r32.setClickable(false);
        r32.setFocusable(false);
        this.k = r32;
        FrameLayout.LayoutParams r33 = new FrameLayout.LayoutParams(-2, -2);
        r33.topMargin = (int) UtilityKotlinExtentionsKt.h(400);
        r26.addView(this.k, r33);
        Long r34 = com.bytedance.android.live.liveinteract.utils.a.a;
        com.bytedance.android.live.liveinteract.utils.a.p = new LiveLinkmicAIMVManager$attach$$inlined$apply$lambda$1(r17, this, r12, r17);
        goto L42
    L29:
        this.a = r17;
        r17.addView(this.c, r12);
        r17.addView(r15, r14);
        r17.addView(this.d, r12);
    L42:
        TextureView r1 = this.b;
        if (r1 == null) goto L45;
        r1.setSurfaceTextureListener(new a(this));
    L45:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r35 = this.f;
        if (r35 == null) goto L52;
        Drawable r36 = r35.b();
        if (r36 == null) goto L52;
        View r37 = this.c;
        if (r37 == null) goto L52;
        r37.setBackground(r36);
    L52:
        IInteractService r38 = (IInteractService) k.f(IInteractService.class);
        if (r38 == null) goto L57;
        com.bytedance.android.live.liveinteract.plantform.performance.a r39 = r38.getMultiLinkPerfAbilityManager(true);
        if (r39 == null) goto L57;
        boolean r40 = r39.a("multilink_base_degrade");
    L58:
        Long r41 = com.bytedance.android.live.liveinteract.utils.a.a;
        com.bytedance.android.live.liveinteract.utils.a.f(Boolean.valueOf(!r40));
        IInteractService r42 = (IInteractService) k.f(IInteractService.class);
        if (r42 == null) goto L63;
        com.bytedance.android.live.liveinteract.plantform.performance.a r43 = r42.getMultiLinkPerfAbilityManager(true);
        if (r43 == null) goto L63;
        String r44 = r43.b("multilink_base_degrade", new LiveLinkmicAIMVManager$attach$6(this));
    L64:
        this.h = r44;
        return;
    L63:
        r44 = null;
    L57:
        r40 = true;
        goto L58
    }

    public final void b(final IOrderSingInfoV2 r10) {
        if (r10 == null) goto L45;
        RoomSongInfo r0 = r10.getRoomSongInfo();
        if (r0 == null) goto L46;
        FrameLayout r1 = this.a;
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        View r2 = this.c;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        View r3 = this.d;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
    L14:
        Long r4 = com.bytedance.android.live.liveinteract.utils.a.a;
        IMVBaseInfo r5 = r0.getMvBaseInfo();
        if (r5 == null) goto L17;
        String r6 = r5.getVid();
    L18:
        com.bytedance.android.live.liveinteract.utils.a.e(r6);
        this.e = r10.getRoomSongInfo();
        com.bytedance.android.livesdk.ktvapi.model.mv.c r7 = this.f;
        if (r7 == null) goto L21;
        r7.i(r0, new LiveLinkmicAIMVManager$consumePlayModeInfo$$inlined$let$lambda$1(this, r10), new LiveLinkmicAIMVManager$consumePlayModeInfo$$inlined$let$lambda$2(this, r10));
    L21:
        IMVBaseInfo r11 = r0.getMvBaseInfo();
        if (r11 == null) goto L24;
        int r8 = f(r11);
    L25:
        IMVBaseInfo r12 = r0.getMvBaseInfo();
        String r9 = "";
        if (r12 == null) goto L31;
        String r13 = r12.getVid();
        if (r13 == null) goto L31;
        String r14 = r13;
    L32:
        InteractiveSongLoggerKt.g("", r14, false, "", "ai_stage_effect", r8);
        this.p = Long.valueOf(System.currentTimeMillis());
        if (je0.d.r() == true) goto L42;
        IMVBaseInfo r15 = r0.getMvBaseInfo();
        if (r15 == null) goto L40;
        String r16 = r15.getVid();
        if (r16 == null) goto L40;
        r9 = r16;
    L40:
        InteractiveSongLoggerKt.c(r9, false);
    L42:
        if (this.q != null) goto L47;
        this.q = Long.valueOf(System.currentTimeMillis());
        return;
    L47:
        return;
    L31:
        r14 = "";
        goto L32
    L24:
        r8 = 0;
        goto L25
    L17:
        r6 = null;
        goto L18
    L46:
        return;
    }

    public final void c(final LinkmicRoomSongMessage r18) {
        Intrinsics.checkNotNullParameter(r18, "syncData");
        String r3 = "";
        Long r4 = null;
        int r5 = 0;
        if (r18.isMvPlayingTranslate() == false) goto L62;
        FrameLayout r2 = this.a;
        if (r2 == null) goto L7;
        r2.setVisibility(0);
    L7:
        View r6 = this.c;
        if (r6 == null) goto L10;
        r6.setVisibility(0);
    L10:
        View r7 = this.d;
        if (r7 == null) goto L13;
        r7.setVisibility(0);
    L13:
        RoomSongInfo r8 = r18.getRoomSongInfo();
        if (r8 == null) goto L107;
        RoomSongInfo r9 = this.e;
        if (r9 != null) goto L18;
    L19:
        Long r10 = com.bytedance.android.live.liveinteract.utils.a.a;
        IMVBaseInfo r11 = r8.getMvBaseInfo();
        if (r11 == null) goto L22;
        String r12 = r11.getVid();
    L23:
        com.bytedance.android.live.liveinteract.utils.a.e(r12);
        this.e = r18.getRoomSongInfo();
        com.bytedance.android.livesdk.ktvapi.model.mv.c r13 = this.f;
        if (r13 == null) goto L26;
        r13.i(r8, new LiveLinkmicAIMVManager$consumeWRDS$$inlined$let$lambda$1(this, r18), new LiveLinkmicAIMVManager$consumeWRDS$$inlined$let$lambda$2(this, r18));
    L26:
        IMVBaseInfo r1 = r8.getMvBaseInfo();
        if (r1 == null) goto L29;
        int r14 = f(r1);
    L30:
        IMVBaseInfo r15 = r8.getMvBaseInfo();
        if (r15 == null) goto L34;
        String r16 = r15.getVid();
        if (r16 == null) goto L34;
    L35:
        InteractiveSongLoggerKt.g("", r16, false, "", "ai_stage_effect", r14);
        if (this.e == null) goto L51;
        Long r17 = this.p;
        if (r17 == null) goto L51;
        long r19 = r17.longValue();
        RoomSongInfo r20 = this.e;
        if (r20 == null) goto L45;
        IMVBaseInfo r21 = r20.getMvBaseInfo();
        if (r21 == null) goto L45;
        String r22 = r21.getVid();
        if (r22 == null) goto L45;
    L46:
        RoomSongInfo r110 = this.e;
        if (r110 == null) goto L49;
        r4 = Long.valueOf(r110.getSongId());
    L49:
        InteractiveSongLoggerKt.f("", r22, false, String.valueOf(r4), "change", System.currentTimeMillis() - r19, Integer.valueOf(r14), "ai_stage_effect");
    L45:
        r22 = "";
    L51:
        if (je0.d.r() == true) goto L59;
        IMVBaseInfo r23 = r8.getMvBaseInfo();
        if (r23 == null) goto L58;
        String r24 = r23.getVid();
        if (r24 == null) goto L58;
        r3 = r24;
    L58:
        InteractiveSongLoggerKt.c(r3, false);
    L59:
        this.p = Long.valueOf(System.currentTimeMillis());
        if (this.q != null) goto L109;
        this.q = Long.valueOf(System.currentTimeMillis());
        return;
    L109:
        return;
    L34:
        r16 = "";
        goto L35
    L29:
        r14 = 0;
        goto L30
    L22:
        r12 = null;
        goto L23
    L18:
        if (r9.getSongId() != r8.getSongId()) goto L19;
        return;
    L107:
        return;
    L62:
        FrameLayout r25 = this.a;
        if (r25 == null) goto L65;
        r25.setVisibility(8);
    L65:
        com.bytedance.android.livesdk.ktvapi.model.mv.c r26 = this.f;
        if (r26 == null) goto L68;
        r26.stop();
    L68:
        LiveLinkmicAIMVContext r27 = LiveLinkmicAIMVContext.Companion.getContext();
        if (r27 == null) goto L73;
        m<Boolean> r28 = r27.isPlaying();
        if (r28 == null) goto L73;
        r28.setValue(Boolean.FALSE);
    L73:
        DataCenter r29 = this.s;
        if (r29 == null) goto L78;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r30 = e.c(r29);
        if (r30 == null) goto L78;
        r30.Bo(false);
    L78:
        this.j = false;
        RoomSongInfo r31 = this.e;
        if (r31 == null) goto L83;
        IMVBaseInfo r32 = r31.getMvBaseInfo();
        if (r32 == null) goto L83;
        r5 = f(r32);
    L83:
        Long r33 = this.p;
        if (r33 == null) goto L100;
        long r111 = System.currentTimeMillis() - r33.longValue();
        RoomSongInfo r34 = this.e;
        if (r34 == null) goto L93;
        IMVBaseInfo r35 = r34.getMvBaseInfo();
        if (r35 == null) goto L93;
        String r36 = r35.getVid();
        if (r36 == null) goto L93;
        String r37 = r36;
    L94:
        RoomSongInfo r38 = this.e;
        if (r38 == null) goto L97;
        Long r39 = Long.valueOf(r38.getSongId());
    L98:
        InteractiveSongLoggerKt.f("", r37, false, String.valueOf(r39), "cut", r111, Integer.valueOf(r5), "ai_stage_effect");
        this.p = null;
        goto L100
    L97:
        r39 = null;
    L93:
        r37 = "";
    L100:
        if (je0.d.r() == true) goto L105;
        Long r40 = this.q;
        if (r40 == null) goto L104;
        InteractiveSongLoggerKt.d(System.currentTimeMillis() - r40.longValue());
    L104:
        this.q = null;
    L105:
        this.e = null;
    }

    public final int f(IMVBaseInfo r2) {
        return Intrinsics.areEqual(r2.getVid(), this.o) ? 1 : 0;
    }

    public LiveLinkmicAIMVManager(Context r3, DataCenter r4, j1 r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.r = r3;
        this.s = r4;
        this.t = r5;
        this.g = new CompositeDisposable();
        this.m = (Boolean) bt0.a.getValue();
        this.o = (String) ja.a.getValue();
        if (d.o() == true) goto L16;
        com.bytedance.android.livesdk.ktvapi.model.mv.d r6 = k.n(IKtvService.class).createOpusMvService();
        if (r6 == null) goto L9;
        HashMap r7 = new HashMap();
        r7.put(199, 1);
        Unit r0 = Unit.INSTANCE;
        com.bytedance.android.livesdk.ktvimpl.mv.opus.d r8 = r6.a(r7);
        if (r8 == null) goto L9;
        OpusServiceImpl r9 = r8.build(r3);
    L10:
        this.f = r9;
        InteractiveSongContext r10 = InteractiveSongContext.Companion.getContext();
        if (r10 == null) goto L17;
        n<com.bytedance.android.livesdk.ktvapi.model.mv.c> r11 = r10.getAiMVPlayService();
        if (r11 == null) goto L18;
        r11.setValue(this.f);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r9 = null;
        goto L10
    }
}
