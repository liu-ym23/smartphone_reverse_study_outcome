package com.larus.uaigc.chat.block.widget.video;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
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
public final class LocalVideoSuccessViewBinder implements cz9.g, com.larus.uaigc.chat.block.widget.video.a {
    public static final /* synthetic */ int l = 0;
    public final com.larus.uaigc.chat.block.widget.video.a a;
    public boolean b;
    public boolean c;
    public Job d;
    public Job e;
    public cz9.n f;
    public boolean g;
    public String h;
    public String i;
    public boolean j;
    public final LocalVideoSuccessViewBinder$appBackgroundListener$1 k;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final Function2<cz9.b, View, Unit> a() {
        return this.a.a();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final Function2<cz9.b, iy9.b, Unit> b() {
        return this.a.b();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final CoroutineScope c() {
        return this.a.c();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final LarusWidgetMarkdownCreationSingleVideoBinding d0() {
        return this.a.d0();
    }

    @Override // com.larus.uaigc.chat.block.widget.video.a
    public final kc8.q g() {
        return this.a.g();
    }

    @Override // cz9.g
    public final void updateSize(int r1, int r2) {
    }

    public final IVideoController e() {
        ps8.a r0 = IAIChatUgcAIGCService.a.L();
        int r1 = hz9.a.a;
        cz9.n r2 = this.f;
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
        AppHost.a.a().c(this.k);
        this.j = false;
    L5:
        Job r0 = this.d;
        String r2 = null;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.d = null;
        Job r1 = this.e;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        this.e = null;
        String r3 = this.h;
        if (r3 == null) goto L16;
        kh8.a r4 = d();
        if (r4 == null) goto L16;
        r4.c(r3);
    L16:
        this.h = null;
        this.i = null;
        IAIChatUgcAIGCService.Companion r5 = IAIChatUgcAIGCService.a;
        ps8.a r6 = r5.L();
        int r7 = hz9.a.a;
        cz9.n r8 = this.f;
        if (r8 == null) goto L19;
        Message r9 = r8.e;
    L20:
        if (r8 == null) goto L24;
        CreationItem r10 = r8.d;
        if (r10 == null) goto L24;
        String r11 = r10.id;
    L25:
        if (r8 == null) goto L27;
        String r12 = Integer.valueOf(r8.f).toString();
    L28:
        r6.b(hz9.a.a(r9, r11, true, r12));
        ps8.a r13 = r5.L();
        cz9.n r14 = this.f;
        if (r14 == null) goto L31;
        Message r15 = r14.e;
    L32:
        if (r14 == null) goto L36;
        CreationItem r16 = r14.d;
        if (r16 == null) goto L36;
        String r17 = r16.id;
    L37:
        if (r14 == null) goto L39;
        r2 = Integer.valueOf(r14.f).toString();
    L39:
        r13.b(hz9.a.a(r15, r17, false, r2));
        this.g = false;
        return;
    L36:
        r17 = null;
        goto L37
    L31:
        r15 = null;
        goto L32
    L27:
        r12 = null;
    L24:
        r11 = null;
        goto L25
    L19:
        r9 = null;
        goto L20
    }

    public final IVideoController h() {
        ps8.a r0 = IAIChatUgcAIGCService.a.L();
        int r1 = hz9.a.a;
        cz9.n r2 = this.f;
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

    public final boolean j() {
        cz9.n r0 = this.f;
        if (r0 == null) goto L16;
        CreationItem r1 = r0.d;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r2 = r1.type;
        if (r2 != null) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 != true) goto L18;
        return true;
    L18:
        return false;
    L10:
        if (r2.intValue() != 4) goto L12;
        r3 = true;
        goto L13
    L17:
        return false;
    L16:
        return false;
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
        ImageView r1 = r0.c;
        if (r1 == null) goto L7;
        e1.d(r1, new f(this));
    L7:
        LarusWidgetMarkdownCreationSingleVideoBinding r2 = d0();
        if (r2 == null) goto L12;
        ImageView r3 = r2.d;
        if (r3 == null) goto L12;
        e1.d(r3, new g(this));
    L12:
        LarusWidgetMarkdownCreationSingleVideoBinding r4 = d0();
        if (r4 == null) goto L20;
        VideoPlayView r5 = r4.i;
        if (r5 == null) goto L21;
        e1.d(r5, new h(this));
        cz9.n r6 = this.f;
        if (r6 == null) goto L22;
        a().invoke(r6, r5);
        return;
    L22:
        return;
    L21:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.uaigc.chat.block.widget.video.LocalVideoSuccessViewBinder$appBackgroundListener$1] */
    public LocalVideoSuccessViewBinder(LocalVideoItemViewHolder.a r2) {
        Intrinsics.checkNotNullParameter(r2, "depend");
        this.a = r2;
        this.k = new LocalVideoSuccessViewBinder$appBackgroundListener$1(this);
    }

    public final Job k(final nr9.g r14) {
        LarusWidgetMarkdownCreationSingleVideoBinding r0 = d0();
        if (r0 == null) goto L41;
        final VideoPlayView r1 = r0.i;
        if (r1 == null) goto L42;
        r1.setIsMuted(true);
        w0.e(r1, i5.r0());
        r1.setAlpha(1.0f);
        e1.x(r1);
        r1.setForceRefreshSurface(true);
        r1.setShowCoverWhenPause(true);
        r1.setBanInnerDismiss(true);
        r1.setIgnoreClick(true);
        r1.setEnableCreationPreviewCoverLoadOpt(true);
        r1.setBackgroundColor(ContextCompat.getColor(r1.getContext(), v19.c.b(2130972086, r1.getContext(), 2131103159)));
        r1.E();
        nr9.f r2 = r14.g;
        if (r2 == null) goto L9;
        String r3 = r2.a;
    L10:
        if (r2 == null) goto L12;
        String r4 = r2.b;
    L13:
        if (r2 == null) goto L15;
        String r5 = r2.c;
    L16:
        if (r2 == null) goto L18;
        Integer r6 = r2.d;
    L19:
        if (r2 == null) goto L21;
        Integer r7 = r2.e;
    L22:
        if (r2 == null) goto L24;
        Bitmap r8 = r2.f;
    L25:
        cz9.n r9 = this.f;
        if (r9 == null) goto L30;
        Message r10 = r9.e;
        if (r10 == null) goto L30;
        String r11 = r10.getMessageId();
    L31:
        VideoPlayView.p(r1, r3, r4, r5, r6, r7, r8, null, r11, 64);
        r1.i(false);
        IVideoController r12 = h();
        if (r12 == null) goto L34;
        r12.C(true);
        IVideoController r13 = r12;
    L35:
        String r15 = r14.b;
        String r16 = r14.h;
        if (j() == false) goto L38;
        String r17 = r16;
    L39:
        VideoPlayView.e(r1, r13, r15, r17, null, null, null, 56);
        r1.d = new e(this, r14, r1);
        return BuildersKt.launch$default(c(), null, null, new LocalVideoSuccessViewBinder$refreshVideoView$1$4(this, r14, null), 3, null);
    L38:
        r17 = null;
        goto L39
    L34:
        r13 = null;
    L30:
        r11 = null;
        goto L31
    L24:
        r8 = null;
        goto L25
    L21:
        r7 = null;
        goto L22
    L18:
        r6 = null;
        goto L19
    L15:
        r5 = null;
        goto L16
    L12:
        r4 = null;
        goto L13
    L9:
        r3 = null;
        goto L10
    L42:
        return null;
    L41:
        return null;
    }

    @Override // cz9.g
    public final void p2(cz9.b r20) {
        Intrinsics.checkNotNullParameter(r20, "data");
        VideoPlayView r3 = null;
        if ((r20 instanceof cz9.n) == false) goto L5;
        cz9.n r1 = (cz9.n) r20;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        CreationItem r2 = r1.d;
        int r5 = 0;
        if (r2 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L16;
        return;
    L16:
        LarusWidgetMarkdownCreationSingleVideoBinding r6 = d0();
        if (r6 == null) goto L22;
        VideoPlayView r7 = r6.i;
        if (r7 == null) goto L22;
        e1.x(r7);
    L22:
        if (this.j == true) goto L24;
        AppHost.a.a().j(this.k);
        this.j = true;
    L24:
        String r8 = r1.d.id;
        String r9 = "";
        if (r8 != null) goto L27;
        r8 = "";
    L27:
        cz9.n r10 = this.f;
        if (r10 == null) goto L32;
        CreationItem r11 = r10.d;
        if (r11 == null) goto L32;
        String r12 = r11.id;
    L33:
        if (r12 == null) goto L37;
        r9 = r12;
    L37:
        if (Intrinsics.areEqual(r8, r9) == false) goto L46;
        cz9.n r13 = this.f;
        if (r13 != null) goto L41;
    L43:
        boolean r14 = false;
    L44:
        if (r14 == false) goto L46;
        boolean r15 = true;
    L47:
        if (r15 == true) goto L49;
        this.g = false;
    L49:
        CreationItem r16 = r1.d;
        if (r16 == null) goto L159;
        nr9.g r17 = bz9.c.p(r16);
        if (r17 == null) goto L159;
        Object[] r18 = new Object[9];
        r18[0] = r17.a;
        r18[1] = r17.b;
        r18[2] = r17.c;
        r18[3] = r17.d;
        nr9.f r19 = r17.g;
        if (r19 == null) goto L57;
        String r21 = r19.b;
    L58:
        r18[4] = r21;
        if (r19 == null) goto L61;
        String r22 = r19.a;
    L62:
        r18[5] = r22;
        if (r19 == null) goto L65;
        String r23 = r19.c;
    L66:
        r18[6] = r23;
        if (r19 == null) goto L69;
        Integer r24 = r19.e;
    L70:
        r18[7] = r24;
        if (r19 == null) goto L73;
        Integer r25 = r19.d;
    L74:
        r18[8] = r25;
        String r26 = CollectionsKt.joinToString$default(CollectionsKt.listOf(r18), "|", null, null, 0, null, null, 62, null);
        if (r15 == true) goto L77;
    L102:
        this.f = r1;
        this.i = r26;
        Job r27 = this.d;
        if (r27 == null) goto L105;
        Job.DefaultImpls.cancel$default(r27, null, 1, null);
    L105:
        this.d = BuildersKt.launch$default(c(), null, null, new LocalVideoSuccessViewBinder$bindObservers$1(this, r17, null), 3, null);
        Job r28 = this.e;
        if (r28 == null) goto L108;
        Job.DefaultImpls.cancel$default(r28, null, 1, null);
    L108:
        this.e = BuildersKt.launch$default(c(), null, null, new LocalVideoSuccessViewBinder$bindObservers$2(this, r17, null), 3, null);
        k(r17);
        String r29 = r17.a;
        if (r29 != null) goto L111;
    L130:
        LarusWidgetMarkdownCreationSingleVideoBinding r30 = d0();
        if (r30 == null) goto L135;
        ImageView r31 = r30.b;
        if (r31 == null) goto L135;
        e1.x(r31);
    L135:
        LarusWidgetMarkdownCreationSingleVideoBinding r32 = d0();
        if (r32 == null) goto L144;
        ImageView r33 = r32.d;
        if (r33 == null) goto L144;
        if (r1.g == false) goto L142;
        int r34 = 0;
    L143:
        r33.setVisibility(r34);
        goto L144
    L142:
        r34 = 8;
    L144:
        LarusWidgetMarkdownCreationSingleVideoBinding r35 = d0();
        if (r35 == null) goto L149;
        TextView r36 = r35.f;
        if (r36 == null) goto L149;
        e1.o(r36);
    L149:
        LarusWidgetMarkdownCreationSingleVideoBinding r37 = d0();
        if (r37 == null) goto L158;
        ImageView r38 = r37.c;
        if (r38 == null) goto L158;
        if (r1.h == true) goto L157;
        r5 = 8;
    L157:
        r38.setVisibility(r5);
    L158:
        i();
        return;
    L111:
        if ((true ^ StringsKt.isBlank(r29)) == true) goto L114;
        r29 = null;
    L114:
        if (r29 == null) goto L130;
        if (Intrinsics.areEqual(this.h, r29) == true) goto L130;
        String r39 = this.h;
        if (r39 == null) goto L124;
        kh8.a r40 = d();
        if (r40 == null) goto L124;
        r40.c(r39);
    L124:
        this.h = r29;
        kh8.a r41 = d();
        if (r41 == null) goto L130;
        LarusWidgetMarkdownCreationSingleVideoBinding r42 = d0();
        if (r42 == null) goto L129;
        r3 = r42.i;
    L129:
        r41.d(r29, r3);
        goto L130
    L77:
        if (Intrinsics.areEqual(r26, this.i) == false) goto L102;
        this.f = r1;
        k(r17);
        LarusWidgetMarkdownCreationSingleVideoBinding r43 = d0();
        if (r43 == null) goto L83;
        ImageView r44 = r43.b;
        if (r44 == null) goto L83;
        e1.x(r44);
    L83:
        LarusWidgetMarkdownCreationSingleVideoBinding r45 = d0();
        if (r45 == null) goto L92;
        ImageView r46 = r45.d;
        if (r46 == null) goto L92;
        if (r1.g == false) goto L90;
        int r47 = 0;
    L91:
        r46.setVisibility(r47);
        goto L92
    L90:
        r47 = 8;
    L92:
        LarusWidgetMarkdownCreationSingleVideoBinding r48 = d0();
        if (r48 == null) goto L101;
        ImageView r49 = r48.c;
        if (r49 == null) goto L101;
        if (r1.h == true) goto L100;
        r5 = 8;
    L100:
        r49.setVisibility(r5);
    L101:
        i();
        return;
    L73:
        r25 = null;
        goto L74
    L69:
        r24 = null;
        goto L70
    L65:
        r23 = null;
        goto L66
    L61:
        r22 = null;
        goto L62
    L57:
        r21 = null;
    L159:
        FLogger.a.e("LocalVideoSuccessViewBinder", "local videoContent is null");
        return;
    L41:
        if (r1.f != r13.f) goto L43;
        r14 = true;
    L46:
        r15 = false;
    L32:
        r12 = null;
        goto L33
    L11:
        if (bz9.c.e(r2) != true) goto L13;
        r4 = true;
        goto L14
    L5:
        r1 = null;
        goto L6
    }
}
