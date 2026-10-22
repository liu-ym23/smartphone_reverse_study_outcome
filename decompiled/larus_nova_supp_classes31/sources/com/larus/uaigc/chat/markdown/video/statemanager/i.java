package com.larus.uaigc.chat.markdown.video.statemanager;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i implements ez9.c, com.larus.uaigc.chat.markdown.video.statemanager.a {
    public static final /* synthetic */ int n = 0;
    public final com.larus.uaigc.chat.markdown.video.statemanager.a a;
    public final int b;
    public CreationTask c;
    public Message d;
    public final Lazy e;
    public final Lazy f;
    public boolean g;
    public boolean h;
    public Job i;
    public Job j;
    public boolean k;
    public final l l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final ChatPageContext M1() {
        return this.a.M1();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final ISketchLoadingController a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final String b() {
        return this.a.b();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final CoroutineScope c() {
        return this.a.c();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final Boolean d() {
        return this.a.d();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
        return this.a.d0();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final q0.a f() {
        return this.a.f();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final String getBotId() {
        return this.a.getBotId();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final String getCurrentPage() {
        return this.a.getCurrentPage();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final View getHostView() {
        return this.a.getHostView();
    }

    @Override // com.larus.uaigc.chat.markdown.video.statemanager.a
    public final boolean l() {
        return this.a.l();
    }

    public final IVideoController i() {
        ps8.a r0 = IAIChatUgcAIGCService.a.L();
        int r1 = hz9.a.a;
        Message r2 = this.d;
        CreationTask r3 = this.c;
        if (r3 == null) goto L5;
        String r4 = r3.id;
    L7:
        return r0.a(hz9.a.b(r2, r4, true, 8), "ugc_video", "immersive_preview");
    L5:
        r4 = null;
        goto L7
    }

    public final IVideoController j() {
        ps8.a r0 = IAIChatUgcAIGCService.a.L();
        int r1 = hz9.a.a;
        Message r2 = this.d;
        CreationTask r3 = this.c;
        if (r3 == null) goto L5;
        String r4 = r3.id;
    L7:
        return r0.a(hz9.a.b(r2, r4, false, 12), "ugc_video", "message_card");
    L5:
        r4 = null;
        goto L7
    }

    public final kh8.a h() {
        q0.a r0 = f();
        if (r0 == null) goto L7;
        qd8.b r1 = r0.H9();
        if (r1 == null) goto L7;
        return r1.q3();
    L7:
        return null;
    }

    @Override // ez9.c
    public final int getLevel() {
        return this.b;
    }

    public i(com.larus.uaigc.chat.markdown.video.j.a r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
        this.b = 3;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.e = LazyKt.lazy(r3, new f(this));
        this.f = LazyKt.lazy(r3, new g(this));
        this.l = new l(this);
    }

    @Override // ez9.c
    public final void g(ez9.c r7) {
        Job r8 = this.i;
        String r1 = null;
        if (r8 == null) goto L5;
        Job.DefaultImpls.cancel$default(r8, null, 1, null);
    L5:
        this.i = null;
        Job r9 = this.j;
        if (r9 == null) goto L8;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L8:
        this.j = null;
        kh8.a r10 = h();
        if (r10 == null) goto L23;
        CreationTask r2 = this.c;
        if (r2 == null) goto L19;
        CreationAsset r3 = r2.asset;
        if (r3 == null) goto L19;
        ep8.a r4 = r3.videoContent;
        if (r4 == null) goto L19;
        AiGenVideoContentData r5 = r4.videoInfo;
        if (r5 == null) goto L19;
        String r6 = r5.getVid();
    L20:
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r10.c(r6);
    L19:
        r6 = null;
    L23:
        IAIChatUgcAIGCService.Companion r11 = IAIChatUgcAIGCService.a;
        ps8.a r12 = r11.L();
        int r13 = hz9.a.a;
        Message r14 = this.d;
        CreationTask r15 = this.c;
        if (r15 == null) goto L26;
        String r16 = r15.id;
    L27:
        r12.b(hz9.a.b(r14, r16, true, 8));
        ps8.a r17 = r11.L();
        Message r0 = this.d;
        CreationTask r18 = this.c;
        if (r18 == null) goto L30;
        r1 = r18.id;
    L30:
        r17.b(hz9.a.b(r0, r1, false, 12));
        this.m = false;
        return;
    L26:
        r16 = null;
        goto L27
    }

    @Override // ez9.c
    public final void e(String r23, final Message r24) {
        if (r23 != null) goto L6;
        if (r24 != null) goto L6;
        g(null);
    L6:
        boolean r4 = l();
        if (this.k == r4) goto L18;
        LarusWidgetMarkdownCreationSingleVideoBinding r5 = d0();
        if (r5 == null) goto L17;
        ImageView r6 = r5.d;
        if (r6 == null) goto L17;
        if ((!r4) == false) goto L15;
        int r8 = 0;
    L16:
        r6.setVisibility(r8);
        goto L17
    L15:
        r8 = 8;
    L17:
        this.k = r4;
    L18:
        CreationTask r7 = this.c;
        if (r7 == null) goto L21;
        String r9 = r7.id;
    L23:
        if (Intrinsics.areEqual(r9, r23) == false) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(a().isVisible(), Boolean.TRUE) == false) goto L43;
        LarusWidgetMarkdownCreationSingleVideoBinding r10 = d0();
        if (r10 == null) goto L32;
        VideoPlayView r11 = r10.i;
        if (r11 == null) goto L32;
        r11.setAlpha(0.0f);
    L32:
        LarusWidgetMarkdownCreationSingleVideoBinding r12 = d0();
        if (r12 == null) goto L37;
        ImageView r13 = r12.b;
        if (r13 == null) goto L37;
        r13.setAlpha(0.0f);
    L37:
        LarusWidgetMarkdownCreationSingleVideoBinding r14 = d0();
        if (r14 == null) goto L42;
        ImageView r15 = r14.d;
        if (r15 == null) goto L42;
        r15.setAlpha(0.0f);
    L42:
        BuildersKt.launch$default(c(), null, null, new VideoSuccessState$refreshStatus$1(this, null), 3, null);
    L43:
        this.d = r24;
        if (r24 == null) goto L52;
        CreationMsgContentData r16 = dp8.e.c(r24);
        if (r16 == null) goto L52;
        CreationInfo r17 = r16.creationInfo;
        if (r17 == null) goto L52;
        Map r18 = r17.taskInfo;
        if (r18 == null) goto L52;
        CreationTask r1 = (CreationTask) r18.get(r23);
    L53:
        this.c = r1;
        if (r1 == null) goto L188;
        CreationAsset r2 = r1.asset;
        if (r2 == null) goto L188;
        ep8.a r3 = r2.videoContent;
        if (r3 == null) goto L188;
        AiGenVideoContentData r19 = r3.videoInfo;
        if (r19 == null) goto L188;
        final nr9.g r20 = ff8.a.a(r19);
        Job r21 = this.i;
        if (r21 == null) goto L64;
        Job.DefaultImpls.cancel$default(r21, null, 1, null);
    L64:
        this.i = BuildersKt.launch$default(c(), null, null, new VideoSuccessState$bindObservers$1(this, r20, null), 3, null);
        Job r22 = this.j;
        if (r22 == null) goto L67;
        Job.DefaultImpls.cancel$default(r22, null, 1, null);
    L67:
        this.j = BuildersKt.launch$default(c(), null, null, new VideoSuccessState$bindObservers$2(this, r20, null), 3, null);
        LarusWidgetMarkdownCreationSingleVideoBinding r25 = d0();
        if (r25 == null) goto L116;
        VideoPlayView r26 = r25.i;
        if (r26 == null) goto L116;
        r26.setIsMuted(true);
        w0.e(r26, i5.r0());
        r26.setAlpha(1.0f);
        e1.x(r26);
        r26.setForceRefreshSurface(true);
        r26.setShowCoverWhenPause(true);
        r26.setBanInnerDismiss(true);
        r26.setIgnoreClick(true);
        r26.setBackgroundColor(ContextCompat.getColor(r26.getContext(), v19.c.b(2130972086, r26.getContext(), 2131103159)));
        r26.E();
        nr9.f r110 = r20.g;
        if (r110 == null) goto L74;
        String r111 = r110.a;
    L75:
        if (r110 == null) goto L77;
        String r112 = r110.b;
    L78:
        if (r110 == null) goto L80;
        String r113 = r110.c;
    L81:
        if (r110 == null) goto L83;
        Integer r114 = r110.d;
    L84:
        if (r110 == null) goto L86;
        Integer r115 = r110.e;
    L87:
        if (r110 == null) goto L89;
        Bitmap r116 = r110.f;
    L90:
        l r117 = this.l;
        Message r27 = this.d;
        if (r27 == null) goto L93;
        String r118 = r27.getMessageId();
    L94:
        r26.o(r111, r112, r113, r114, r115, r116, r117, r118);
        r26.i(false);
        FlowFileProtectionService r28 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r28 != null) goto L97;
    L99:
        boolean r29 = false;
    L100:
        IVideoController r119 = j();
        if (r119 == null) goto L103;
        r119.C(true);
        IVideoController r120 = r119;
    L104:
        String r121 = r20.b;
        if (r29 == true) goto L107;
        String r122 = r121;
    L108:
        String r123 = r20.c;
        if (r29 == false) goto L111;
        String r124 = r123;
    L112:
        if (r29 == false) goto L114;
        String r125 = "";
    L115:
        VideoPlayView.e(r26, r120, r122, null, r124, r125, null, 36);
        r26.d = new h(this, r20);
        BuildersKt.launch$default(c(), null, null, new VideoSuccessState$refreshVideoView$1$6(this, r20, null), 3, null);
        goto L116
    L114:
        r125 = null;
        goto L115
    L111:
        r124 = null;
        goto L112
    L107:
        r122 = null;
        goto L108
    L103:
        r120 = null;
        goto L104
    L97:
        if (r28.I0() != true) goto L99;
        r29 = true;
        goto L100
    L93:
        r118 = null;
        goto L94
    L89:
        r116 = null;
        goto L90
    L86:
        r115 = null;
        goto L87
    L83:
        r114 = null;
        goto L84
    L80:
        r113 = null;
        goto L81
    L77:
        r112 = null;
        goto L78
    L74:
        r111 = null;
    L116:
        String r30 = r19.getVid();
        if (r30 == null) goto L125;
        kh8.a r31 = h();
        if (r31 == null) goto L125;
        LarusWidgetMarkdownCreationSingleVideoBinding r32 = d0();
        if (r32 == null) goto L123;
        VideoPlayView r33 = r32.i;
    L124:
        r31.d(r30, r33);
        goto L125
    L123:
        r33 = null;
    L125:
        LarusWidgetMarkdownCreationSingleVideoBinding r34 = d0();
        if (r34 == null) goto L130;
        ImageView r35 = r34.b;
        if (r35 == null) goto L130;
        e1.x(r35);
    L130:
        LarusWidgetMarkdownCreationSingleVideoBinding r36 = d0();
        if (r36 == null) goto L139;
        ImageView r37 = r36.d;
        if (r37 == null) goto L139;
        if ((!r4) == false) goto L137;
        int r38 = 0;
    L138:
        r37.setVisibility(r38);
        goto L139
    L137:
        r38 = 8;
    L139:
        LarusWidgetMarkdownCreationSingleVideoBinding r39 = d0();
        if (r39 == null) goto L148;
        TextView r40 = r39.f;
        if (r40 == null) goto L148;
        if (z2.a.getCreationExtendVideoConfig().a() == false) goto L146;
        int r41 = 0;
    L147:
        r40.setVisibility(r41);
        goto L148
    L146:
        r41 = 8;
    L148:
        if (r24 == null) goto L150;
        CreationMsgContentData r42 = dp8.e.c(r24);
    L151:
        Map<String, CreationTask> r43 = DataConverterKt.g(r42);
        if (r43 == null) goto L170;
        LinkedHashMap r44 = new LinkedHashMap();
        Iterator<Map.Entry<String, CreationTask>> r45 = r43.entrySet().iterator();
    L155:
        if (r45.hasNext() == false) goto L167;
        Map.Entry<String, CreationTask> r46 = r45.next();
        CreationTask r47 = r46.getValue();
        if (r47 == null) goto L164;
        Integer r48 = r47.loadingAssetType;
        if (r48 == null) goto L164;
        if (r48.intValue() != 7) goto L164;
        boolean r49 = true;
    L165:
        if (r49 == false) goto L155;
        r44.put(r46.getKey(), r46.getValue());
    L164:
        r49 = false;
        goto L165
    L167:
        Collection r50 = r44.values();
        if (r50 == null) goto L170;
        final CreationTask r51 = (CreationTask) CollectionsKt.firstOrNull(r50);
    L171:
        LarusWidgetMarkdownCreationSingleVideoBinding r52 = d0();
        if (r52 == null) goto L176;
        TextView r53 = r52.f;
        if (r53 == null) goto L176;
        e1.d(r53, new c(r24, r51, r20, this));
    L176:
        LarusWidgetMarkdownCreationSingleVideoBinding r54 = d0();
        if (r54 == null) goto L181;
        ImageView r55 = r54.d;
        if (r55 == null) goto L181;
        e1.d(r55, new d(this, r24));
    L181:
        LarusWidgetMarkdownCreationSingleVideoBinding r56 = d0();
        if (r56 == null) goto L189;
        VideoPlayView r57 = r56.i;
        if (r57 == null) goto L189;
        e1.d(r57, new e(this, r24));
        if (r24 == null) goto L189;
        BuildersKt.launch$default(c(), Dispatchers.getMain(), null, new VideoSuccessState$initClickListener$3$2$1(r57, r24, this, null), 2, null);
    L189:
        hy9.d r58 = ICreationReportService.a.j();
        String r59 = AppHost.a.getApplication().getString(2131905605);
        LruCache r60 = ko8.a.a;
        hy9.d.a.b(r58, r59, null, null, "video_overview", "single_function", null, null, null, null, ko8.a.h(ko8.a.e), null, null, null, "chat", null, null, null, null, 1039846);
        return;
    L170:
        r51 = null;
        goto L171
    L150:
        r42 = null;
    L188:
        FLogger.a.e("VideoSuccessState", "videoContent is null");
    L52:
        r1 = null;
        goto L53
    L21:
        r9 = null;
        goto L23
    }
}
