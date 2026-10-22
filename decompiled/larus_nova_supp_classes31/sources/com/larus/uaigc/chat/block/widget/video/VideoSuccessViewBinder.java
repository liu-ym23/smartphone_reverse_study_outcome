package com.larus.uaigc.chat.block.widget.video;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoSuccessViewBinder implements cz9.g, b {
    public static final /* synthetic */ int n = 0;
    public final b a;
    public boolean b;
    public boolean c;
    public Job d;
    public Job e;
    public cz9.o f;
    public boolean g;
    public String h;
    public String i;
    public boolean j;
    public final Set<String> k;
    public final Map<String, Long> l;
    public final VideoSuccessViewBinder$appBackgroundListener$1 m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final Function2<cz9.b, View, Unit> a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final Function2<cz9.b, iy9.b, Unit> b() {
        return this.a.b();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final CoroutineScope c() {
        return this.a.c();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
        return this.a.d0();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.b
    public final kc8.q g() {
        return this.a.g();
    }

    @Override // cz9.g
    public final void updateSize(int r1, int r2) {
    }

    public final IVideoController e() {
        ps8.a r0 = IAIChatUgcAIGCService.a.L();
        int r1 = hz9.a.a;
        cz9.o r2 = this.f;
        String r3 = null;
        if (r2 == null) goto L5;
        Message r4 = r2.e;
    L6:
        if (r2 == null) goto L10;
        CreationItem r5 = r2.d;
        if (r5 == null) goto L10;
        String r6 = r5.id;
    L11:
        if (r2 == null) goto L14;
        r3 = Integer.valueOf(r2.f).toString();
    L14:
        return r0.a(hz9.a.a(r4, r6, true, r3), "ugc_video", "immersive_preview");
    L10:
        r6 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    @Override // cz9.g
    public final void f() {
        if (this.j == false) goto L5;
        AppHost.a.a().c(this.m);
        this.j = false;
    L5:
        Job r0 = this.d;
        String r3 = null;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.d = null;
        Job r1 = this.e;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        this.e = null;
        j();
        this.i = null;
        IAIChatUgcAIGCService.Companion r2 = IAIChatUgcAIGCService.a;
        ps8.a r4 = r2.L();
        int r5 = hz9.a.a;
        cz9.o r6 = this.f;
        if (r6 == null) goto L14;
        Message r7 = r6.e;
    L15:
        if (r6 == null) goto L19;
        CreationItem r8 = r6.d;
        if (r8 == null) goto L19;
        String r9 = r8.id;
    L20:
        if (r6 == null) goto L22;
        String r10 = Integer.valueOf(r6.f).toString();
    L23:
        r4.b(hz9.a.a(r7, r9, true, r10));
        ps8.a r11 = r2.L();
        cz9.o r12 = this.f;
        if (r12 == null) goto L26;
        Message r13 = r12.e;
    L27:
        if (r12 == null) goto L31;
        CreationItem r14 = r12.d;
        if (r14 == null) goto L31;
        String r15 = r14.id;
    L32:
        if (r12 == null) goto L34;
        r3 = Integer.valueOf(r12.f).toString();
    L34:
        r11.b(hz9.a.a(r13, r15, false, r3));
        this.g = false;
        return;
    L31:
        r15 = null;
        goto L32
    L26:
        r13 = null;
        goto L27
    L22:
        r10 = null;
    L19:
        r9 = null;
        goto L20
    L14:
        r7 = null;
        goto L15
    }

    public final IVideoController h() {
        ps8.a r0 = IAIChatUgcAIGCService.a.L();
        int r1 = hz9.a.a;
        cz9.o r2 = this.f;
        String r3 = null;
        if (r2 == null) goto L5;
        Message r4 = r2.e;
    L6:
        if (r2 == null) goto L10;
        CreationItem r5 = r2.d;
        if (r5 == null) goto L10;
        String r6 = r5.id;
    L11:
        if (r2 == null) goto L14;
        r3 = Integer.valueOf(r2.f).toString();
    L14:
        return r0.a(hz9.a.a(r4, r6, false, r3), "ugc_video", "message_card");
    L10:
        r6 = null;
        goto L11
    L5:
        r4 = null;
        goto L6
    }

    public final void j() {
        String r0 = this.h;
        if (r0 == null) goto L7;
        kh8.a r1 = d();
        if (r1 == null) goto L7;
        r1.c(r0);
    L7:
        this.h = null;
    }

    @Override // cz9.g
    public final View N0() {
        LarusWidgetMarkdownCreationSingleVideoBinding r0 = d0();
        if (r0 == null) goto L7;
        View r1 = r0.a;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new View(AppHost.a.getApplication());
    }

    public final kh8.a d() {
        kc8.q r0 = g();
        if (r0 == null) goto L7;
        rd8.b r1 = r0.g;
        if (r1 == null) goto L7;
        return r1.q3();
    L7:
        return null;
    }

    public final void i() {
        LarusWidgetMarkdownCreationSingleVideoBinding r0 = d0();
        if (r0 == null) goto L7;
        TextView r1 = r0.f;
        if (r1 == null) goto L7;
        e1.d(r1, new o(this));
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r2 = d0();
        if (r2 == null) goto L12;
        ImageView r3 = r2.c;
        if (r3 == null) goto L12;
        e1.d(r3, new p(this));
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r4 = d0();
        if (r4 == null) goto L17;
        ImageView r5 = r4.d;
        if (r5 == null) goto L17;
        e1.d(r5, new q(this));
    L17:
        LarusWidgetMarkdownCreationSingleVideoBinding r6 = d0();
        if (r6 == null) goto L25;
        VideoPlayView r7 = r6.i;
        if (r7 == null) goto L26;
        e1.d(r7, new r(this));
        cz9.o r8 = this.f;
        if (r8 == null) goto L27;
        a().invoke(r8, r7);
        return;
    L27:
        return;
    L26:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.uaigc.chat.block.widget.video.VideoSuccessViewBinder$appBackgroundListener$1] */
    public VideoSuccessViewBinder(VideoItemViewHolder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
        this.k = new LinkedHashSet();
        this.l = new LinkedHashMap();
        this.m = new VideoSuccessViewBinder$appBackgroundListener$1(this);
    }

    @Override // cz9.g
    public final void p2(cz9.b r29) {
        Intrinsics.checkNotNullParameter(r29, "data");
        VideoPlayView r2 = null;
        if ((r29 instanceof cz9.o) == false) goto L5;
        cz9.o r0 = (cz9.o) r29;
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        CreationItem r1 = r0.d;
        boolean r3 = true;
        int r4 = 0;
        if (r1 != null) goto L11;
    L13:
        boolean r5 = false;
    L14:
        if (r5 == true) goto L46;
        j();
        this.i = null;
        LarusWidgetMarkdownCreationSingleVideoBinding r6 = d0();
        if (r6 == null) goto L20;
        VideoPlayView r7 = r6.i;
        if (r7 == null) goto L20;
        e1.o(r7);
    L20:
        LarusWidgetMarkdownCreationSingleVideoBinding r8 = d0();
        if (r8 == null) goto L25;
        ImageView r9 = r8.d;
        if (r9 == null) goto L25;
        e1.o(r9);
    L25:
        LarusWidgetMarkdownCreationSingleVideoBinding r10 = d0();
        if (r10 == null) goto L30;
        ProgressBar r11 = r10.e;
        if (r11 == null) goto L30;
        e1.o(r11);
    L30:
        LarusWidgetMarkdownCreationSingleVideoBinding r12 = d0();
        if (r12 == null) goto L35;
        ImageView r13 = r12.b;
        if (r13 == null) goto L35;
        e1.o(r13);
    L35:
        LarusWidgetMarkdownCreationSingleVideoBinding r14 = d0();
        if (r14 == null) goto L40;
        ImageView r15 = r14.c;
        if (r15 == null) goto L40;
        e1.o(r15);
    L40:
        LarusWidgetMarkdownCreationSingleVideoBinding r16 = d0();
        if (r16 == null) goto L336;
        TextView r17 = r16.f;
        if (r17 == null) goto L337;
        e1.o(r17);
        return;
    L337:
        return;
    L336:
        return;
    L46:
        LarusWidgetMarkdownCreationSingleVideoBinding r18 = d0();
        if (r18 == null) goto L52;
        VideoPlayView r19 = r18.i;
        if (r19 == null) goto L52;
        e1.x(r19);
    L52:
        if (this.j == true) goto L54;
        AppHost.a.a().j(this.m);
        this.j = true;
    L54:
        CreationItem r20 = r0.d;
        VideoData r21 = r20.video;
        if (r21 != null) goto L58;
        FLogger.a.e("VideoSuccessViewBinder", "videoContent is null");
        return;
    L58:
        String r22 = r20.id;
        if (r22 != null) goto L61;
        r22 = "";
    L61:
        cz9.o r23 = this.f;
        if (r23 == null) goto L66;
        CreationItem r24 = r23.d;
        if (r24 == null) goto L66;
        String r25 = r24.id;
    L67:
        if (r25 != null) goto L70;
        r25 = "";
    L70:
        if (Intrinsics.areEqual(r22, r25) == false) goto L79;
        cz9.o r26 = this.f;
        if (r26 != null) goto L74;
    L76:
        boolean r27 = false;
    L77:
        if (r27 == false) goto L79;
        boolean r28 = true;
    L80:
        if (r28 == true) goto L82;
        this.g = false;
    L82:
        String r30 = r21.vid;
        if (this.g == true) goto L98;
        if (r30 == null) goto L98;
        if ((!StringsKt.isBlank(r30)) == true) goto L90;
        r30 = null;
    L90:
        if (r30 == null) goto L98;
        Long r31 = (Long) ((LinkedHashMap) this.l).get(r30);
        if (r31 != null) goto L95;
    L97:
        boolean r32 = CreationNoWatermarkManager.a.m0(r30);
    L100:
        if (r32 == false) goto L191;
        this.f = r0;
        this.i = null;
        CreationNoWatermarkManager r33 = CreationNoWatermarkManager.a;
        String r34 = r21.vid;
        nr9.g r35 = bz9.a.l(r21);
        Cover r110 = r21.cover;
        if (r110 == null) goto L104;
        String r111 = r110.key;
    L105:
        nr9.g r36 = r33.c0(r34, r35, r111);
        if (r36 != null) goto L108;
        r36 = bz9.a.l(r21);
    L108:
        Job r37 = this.d;
        if (r37 == null) goto L111;
        Job.DefaultImpls.cancel$default(r37, null, 1, null);
    L111:
        this.d = null;
        Job r38 = this.e;
        if (r38 == null) goto L114;
        Job.DefaultImpls.cancel$default(r38, null, 1, null);
    L114:
        this.e = null;
        j();
        this.g = false;
        LarusWidgetMarkdownCreationSingleVideoBinding r39 = d0();
        if (r39 == null) goto L144;
        VideoPlayView r40 = r39.i;
        if (r40 == null) goto L144;
        VideoPlayView.z(r40, 0, 2);
        r40.setIsMuted(true);
        w0.e(r40, i5.r0());
        r40.setAlpha(1.0f);
        e1.x(r40);
        r40.setForceRefreshSurface(true);
        r40.setShowCoverWhenPause(true);
        r40.setBanInnerDismiss(true);
        r40.setIgnoreClick(true);
        r40.setEnableCreationPreviewCoverLoadOpt(true);
        r40.setBackgroundColor(ContextCompat.getColor(r40.getContext(), v19.c.b(2130972086, r40.getContext(), 2131103159)));
        r40.E();
        nr9.f r41 = r36.g;
        if (r41 == null) goto L121;
        String r112 = r41.a;
    L122:
        if (r41 == null) goto L124;
        String r113 = r41.b;
    L125:
        if (r41 == null) goto L127;
        String r114 = r41.c;
    L128:
        if (r41 == null) goto L130;
        Integer r115 = r41.d;
    L131:
        if (r41 == null) goto L133;
        Integer r116 = r41.e;
    L134:
        if (r41 == null) goto L136;
        Bitmap r117 = r41.f;
    L137:
        cz9.o r42 = this.f;
        if (r42 == null) goto L142;
        Message r43 = r42.e;
        if (r43 == null) goto L142;
        String r210 = r43.getMessageId();
    L143:
        VideoPlayView.p(r40, r112, r113, r114, r115, r116, r117, null, r210, 64);
        r40.i(false);
    L142:
        r210 = null;
        goto L143
    L136:
        r117 = null;
        goto L137
    L133:
        r116 = null;
        goto L134
    L130:
        r115 = null;
        goto L131
    L127:
        r114 = null;
        goto L128
    L124:
        r113 = null;
        goto L125
    L121:
        r112 = null;
    L144:
        LarusWidgetMarkdownCreationSingleVideoBinding r44 = d0();
        if (r44 == null) goto L149;
        ImageView r45 = r44.b;
        if (r45 == null) goto L149;
        e1.o(r45);
    L149:
        LarusWidgetMarkdownCreationSingleVideoBinding r46 = d0();
        if (r46 == null) goto L154;
        ImageView r47 = r46.d;
        if (r47 == null) goto L154;
        e1.o(r47);
    L154:
        LarusWidgetMarkdownCreationSingleVideoBinding r48 = d0();
        if (r48 == null) goto L159;
        ProgressBar r49 = r48.e;
        if (r49 == null) goto L159;
        e1.o(r49);
    L159:
        LarusWidgetMarkdownCreationSingleVideoBinding r50 = d0();
        if (r50 == null) goto L164;
        ImageView r51 = r50.c;
        if (r51 == null) goto L164;
        e1.o(r51);
    L164:
        LarusWidgetMarkdownCreationSingleVideoBinding r52 = d0();
        if (r52 == null) goto L169;
        TextView r53 = r52.f;
        if (r53 == null) goto L169;
        e1.o(r53);
    L169:
        String r54 = r21.vid;
        if (r54 != null) goto L172;
    L189:
        i();
        return;
    L172:
        if ((true ^ StringsKt.isBlank(r54)) == false) goto L174;
        String r55 = r54;
    L175:
        if (r55 == null) goto L189;
        if (this.k.add(r55) == false) goto L189;
        Message r56 = r0.e;
        if (r56 == null) goto L183;
        String r57 = r56.getMessageId();
    L184:
        CreationItem r58 = r0.d;
        if (r58 == null) goto L187;
        String r59 = r58.id;
    L188:
        BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$requestNoWatermarkVideo$1(this, r55, r57, r59, r0.f, null), 3, null);
        goto L189
    L187:
        r59 = null;
        goto L188
    L183:
        r57 = null;
        goto L184
    L174:
        r55 = null;
        goto L175
    L104:
        r111 = null;
        goto L105
    L191:
        CreationNoWatermarkManager r60 = CreationNoWatermarkManager.a;
        String r118 = r21.vid;
        nr9.g r119 = bz9.a.l(r21);
        Cover r120 = r21.cover;
        if (r120 == null) goto L194;
        String r121 = r120.key;
    L195:
        final nr9.g r61 = r60.c0(r118, r119, r121);
        if (r61 != null) goto L198;
        r61 = bz9.a.l(r21);
    L198:
        Object[] r62 = new Object[9];
        r62[0] = r61.a;
        r62[1] = r61.b;
        r62[2] = r61.c;
        r62[3] = r61.d;
        nr9.f r122 = r61.g;
        if (r122 == null) goto L201;
        String r123 = r122.b;
    L202:
        r62[4] = r123;
        if (r122 == null) goto L205;
        String r124 = r122.a;
    L206:
        r62[5] = r124;
        if (r122 == null) goto L209;
        String r125 = r122.c;
    L210:
        r62[6] = r125;
        if (r122 == null) goto L213;
        Integer r126 = r122.e;
    L214:
        r62[7] = r126;
        if (r122 == null) goto L217;
        Integer r127 = r122.d;
    L218:
        r62[8] = r127;
        String r63 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r62), "|", null, null, 0, null, null, 62, null);
        if (r28 == true) goto L221;
    L223:
        this.f = r0;
        this.i = r63;
        Job r64 = this.d;
        if (r64 == null) goto L226;
        Job.DefaultImpls.cancel$default(r64, null, 1, null);
    L226:
        this.d = BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$bindObservers$1(this, r61, null), 3, null);
        Job r65 = this.e;
        if (r65 == null) goto L229;
        Job.DefaultImpls.cancel$default(r65, null, 1, null);
    L229:
        this.e = BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$bindObservers$2(this, r61, null), 3, null);
        LarusWidgetMarkdownCreationSingleVideoBinding r66 = d0();
        if (r66 == null) goto L280;
        final VideoPlayView r67 = r66.i;
        if (r67 == null) goto L280;
        r67.setIsMuted(true);
        w0.e(r67, i5.r0());
        r67.setAlpha(1.0f);
        e1.x(r67);
        r67.setForceRefreshSurface(true);
        r67.setShowCoverWhenPause(true);
        r67.setBanInnerDismiss(true);
        r67.setIgnoreClick(true);
        r67.setEnableCreationPreviewCoverLoadOpt(true);
        r67.setBackgroundColor(ContextCompat.getColor(r67.getContext(), v19.c.b(2130972086, r67.getContext(), 2131103159)));
        r67.E();
        nr9.f r68 = r61.g;
        if (r68 == null) goto L236;
        String r128 = r68.a;
    L237:
        if (r68 == null) goto L239;
        String r129 = r68.b;
    L240:
        if (r68 == null) goto L242;
        String r130 = r68.c;
    L243:
        if (r68 == null) goto L245;
        Integer r131 = r68.d;
    L246:
        if (r68 == null) goto L248;
        Integer r132 = r68.e;
    L249:
        if (r68 == null) goto L251;
        Bitmap r211 = r68.f;
    L252:
        cz9.o r69 = this.f;
        if (r69 == null) goto L257;
        Message r70 = r69.e;
        if (r70 == null) goto L257;
        String r212 = r70.getMessageId();
    L258:
        VideoPlayView.p(r67, r128, r129, r130, r131, r132, r211, null, r212, 64);
        r67.i(false);
        FlowFileProtectionService r71 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r71 != null) goto L261;
    L263:
        boolean r72 = false;
    L264:
        IVideoController r73 = h();
        if (r73 == null) goto L267;
        r73.C(true);
        IVideoController r133 = r73;
    L268:
        String r74 = r61.b;
        if (r72 == true) goto L271;
        String r134 = r74;
    L272:
        String r75 = r61.c;
        if (r72 == false) goto L275;
        String r135 = r75;
    L276:
        if (r72 == false) goto L278;
        String r136 = "";
    L279:
        VideoPlayView.e(r67, r133, r134, null, r135, r136, null, 36);
        r67.d = new s(this, r61, r67);
        BuildersKt.launch$default(c(), null, null, new VideoSuccessViewBinder$refreshVideoView$1$6(this, r61, null), 3, null);
        goto L280
    L278:
        r136 = null;
        goto L279
    L275:
        r135 = null;
        goto L276
    L271:
        r134 = null;
        goto L272
    L267:
        r133 = null;
        goto L268
    L261:
        if (r71.I0() != true) goto L263;
        r72 = true;
    L257:
        r212 = null;
        goto L258
    L251:
        r211 = null;
        goto L252
    L248:
        r132 = null;
        goto L249
    L245:
        r131 = null;
        goto L246
    L242:
        r130 = null;
        goto L243
    L239:
        r129 = null;
        goto L240
    L236:
        r128 = null;
    L280:
        String r76 = r61.a;
        if (r76 != null) goto L283;
    L297:
        LarusWidgetMarkdownCreationSingleVideoBinding r77 = d0();
        if (r77 == null) goto L302;
        ImageView r78 = r77.b;
        if (r78 == null) goto L302;
        e1.x(r78);
    L302:
        LarusWidgetMarkdownCreationSingleVideoBinding r79 = d0();
        if (r79 == null) goto L311;
        ImageView r80 = r79.d;
        if (r80 == null) goto L311;
        if (r0.g == false) goto L309;
        int r81 = 0;
    L310:
        r80.setVisibility(r81);
        goto L311
    L309:
        r81 = 8;
    L311:
        LarusWidgetMarkdownCreationSingleVideoBinding r82 = d0();
        if (r82 == null) goto L325;
        TextView r83 = r82.f;
        if (r83 == null) goto L325;
        if (r0.h == false) goto L318;
    L320:
        r3 = false;
    L321:
        if (r3 == false) goto L323;
        int r84 = 0;
    L324:
        r83.setVisibility(r84);
        goto L325
    L323:
        r84 = 8;
        goto L324
    L318:
        if (z2.a.getCreationExtendVideoConfig().a() == false) goto L320;
    L325:
        LarusWidgetMarkdownCreationSingleVideoBinding r85 = d0();
        if (r85 == null) goto L334;
        ImageView r86 = r85.c;
        if (r86 == null) goto L334;
        if (r0.h == true) goto L333;
        r4 = 8;
    L333:
        r86.setVisibility(r4);
    L334:
        i();
        hy9.d r87 = ICreationReportService.a.j();
        String r88 = AppHost.a.getApplication().getString(2131905605);
        LruCache r89 = ko8.a.a;
        hy9.d.a.b(r87, r88, null, null, "video_overview", "single_function", null, null, null, null, ko8.a.h(ko8.a.e), null, null, null, "chat", null, null, null, null, 1039846);
        return;
    L283:
        if ((!StringsKt.isBlank(r76)) == true) goto L286;
        r76 = null;
    L286:
        if (r76 == null) goto L297;
        if (Intrinsics.areEqual(this.h, r76) == true) goto L297;
        j();
        this.h = r76;
        kh8.a r90 = d();
        if (r90 == null) goto L297;
        LarusWidgetMarkdownCreationSingleVideoBinding r91 = d0();
        if (r91 == null) goto L296;
        r2 = r91.i;
    L296:
        r90.d(r76, r2);
        goto L297
    L221:
        if (Intrinsics.areEqual(r63, this.i) == false) goto L223;
        return;
    L217:
        r127 = null;
        goto L218
    L213:
        r126 = null;
        goto L214
    L209:
        r125 = null;
        goto L210
    L205:
        r124 = null;
        goto L206
    L201:
        r123 = null;
        goto L202
    L194:
        r121 = null;
        goto L195
    L95:
        if ((System.currentTimeMillis() - r31.longValue()) >= 10000) goto L97;
    L98:
        r32 = false;
        goto L100
    L74:
        if (r0.f != r26.f) goto L76;
        r27 = true;
    L79:
        r28 = false;
    L66:
        r25 = null;
        goto L67
    L11:
        if (bz9.a.f(r1) != true) goto L13;
        r5 = true;
        goto L14
    L5:
        r0 = null;
        goto L6
    }
}
