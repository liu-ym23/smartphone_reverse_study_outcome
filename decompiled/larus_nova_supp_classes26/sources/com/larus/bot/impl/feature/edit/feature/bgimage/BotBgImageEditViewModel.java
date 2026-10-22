package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.image.loader.b0;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class BotBgImageEditViewModel implements t, u, s {
    public static final /* synthetic */ int j = 0;
    public final /* synthetic */ s a;
    public final CoroutineScope b;
    public final StateFlowImpl c;
    public final b1 d;
    public final MutableSharedFlow<b> e;
    public final a1 f;
    public Bundle g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final BotEditParam a() {
        return this.a.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void b(boolean r2) {
        this.a.b(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void c(boolean r2) {
        this.a.c(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a.e(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void f(String r2) {
        this.a.f(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final Map<String, List<String>> g() {
        return this.a.g();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final int getScene() {
        return this.a.getScene();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void h(String r2) {
        this.a.h(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void j(String r2) {
        this.a.j(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void k(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        Intrinsics.checkNotNullParameter(r3, "uri");
        this.a.k(r2, r3);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void l(String r2) {
        Intrinsics.checkNotNullParameter(r2, "gender");
        this.a.l(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void m(String r2) {
        this.a.m(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void n(BgImage r2) {
        Intrinsics.checkNotNullParameter(r2, "bgImage");
        this.a.n(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void p(String r2) {
        this.a.p(r2);
    }

    public final Pair<String, String> s() {
        Map<String, List<String>> r0 = g();
        List<String> r1 = r0.get(ContentType.NAME.getValue());
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = (String) CollectionsKt.firstOrNull(r1);
    L7:
        if (Intrinsics.areEqual(r3, a().getName()) == false) goto L9;
        String r4 = null;
    L10:
        List<String> r5 = r0.get(ContentType.DESC.getValue());
        if (r5 == null) goto L13;
        String r6 = (String) CollectionsKt.firstOrNull(r5);
    L15:
        if (Intrinsics.areEqual(r6, a().getDescription()) == true) goto L19;
        r2 = a().getDescription();
    L19:
        return TuplesKt.to(r4, r2);
    L13:
        r6 = null;
        goto L15
    L9:
        r4 = a().getName();
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    @Override // uu8.b
    public final d1<b> getUiEvent() {
        return this.f;
    }

    @Override // uu8.b
    public final i1<c> getUiState() {
        return this.d;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void d(boolean r10) {
        FLogger.a.i("BotBgImageEditViewModel", "refreshIsGenerating, isGenerating: " + r10);
        u(this, null, false, false, r10, 7);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bgimage.a r38) {
        com.larus.bot.impl.feature.edit.feature.bgimage.a r0 = r38;
        Intrinsics.checkNotNullParameter(r0, "uiAction");
        boolean r2 = true;
        boolean r7 = false;
        String r3 = null;
        if ((r0 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.e) == false) goto L24;
        String r15 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.e) r0).a;
        Pair<String, String> r1 = s();
        if (((c) this.d.getValue()).f == true) goto L22;
        Uri r4 = ((c) this.d.getValue()).a;
        if (r4 == null) goto L9;
        String r5 = r4.toString();
    L10:
        if (r5 != null) goto L12;
    L15:
        if (r2 == true) goto L22;
        if (o0.d(a().getIconUri()) == true) goto L20;
        return;
    L20:
        if (o0.d(a().getIconUrl()) == false) goto L138;
        v(new b.d(new BotAvatarIconData(a().getIconUri(), a().getIconUrl(), a().getAvatarPromptForEnrich(), null, null, 24, null), a().getBgImage(), (String) r1.getFirst(), (String) r1.getSecond(), a().getUserBotGenderStarlingKey(), a().getUserBotTypeStarlingKey(), r15, a().getOriginalUserImgUri(), Boolean.TRUE, a().getOriginalAvatarImgUri(), true, a().getOriginalBackgroundImgUri()));
        return;
    L138:
        return;
    L12:
        if (StringsKt.isBlank(r5) == true) goto L15;
        r2 = false;
        goto L15
    L9:
        r5 = null;
    L22:
        BuildersKt.launch$default(this.b, null, null, new BotBgImageEditViewModel$onClickImageArea$1(this, r1, r15, null), 3, null);
        return;
    L24:
        if (Intrinsics.areEqual(r0, com.larus.bot.impl.feature.edit.feature.bgimage.a.d.a) == false) goto L27;
        qu8.b.e("bot_create/bg_setting", "bot_create", false);
        qu8.b.e("bot_create/bg_setting/ai", "bot_create/bg_setting", false);
        BuildersKt.launch$default(this.b, null, null, new BotBgImageEditViewModel$onClickBottomBtn$1(this, null), 3, null);
        return;
    L27:
        if ((r0 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.g) == true) goto L29;
        String r8 = "";
        if ((r0 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.c) == false) goto L54;
        BotAvatarIconData r9 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.c) r0).a;
        if (r9 != null) goto L42;
        return;
    L42:
        if (o0.d(r9.getIconUrl()) == false) goto L44;
        Uri r6 = b0.a(r9.getIconUrl(), "bot_create.avatar_ai", false, false, 6);
    L45:
        u(this, r6, true, false, false, 12);
        String r10 = r9.getIconUrl();
        if (r10 != null) goto L48;
        r10 = "";
    L48:
        String r11 = r9.getIconUri();
        if (r11 == null) goto L52;
        r8 = r11;
    L52:
        k(r10, r8);
        h(r9.getPrompt());
        c(false);
        return;
    L44:
        r6 = null;
        goto L45
    L54:
        if ((r0 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.f) == false) goto L83;
        com.larus.bot.impl.feature.edit.feature.bgimage.a.f r12 = (com.larus.bot.impl.feature.edit.feature.bgimage.a.f) r0;
        boolean r13 = r12.a;
        Intent r14 = r12.b;
        if (r13 == false) goto L68;
        if (r14 == null) goto L68;
        Uri r16 = (Uri) r14.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        if (r16 == null) goto L68;
        Pair<String, String> r17 = s();
        BotAvatarIconData r18 = new BotAvatarIconData("", r16.toString(), null, null, null, 24, null);
        BgImage r19 = new BgImage(null, r16.toString(), null, new BgImageInfo(null, null, null, null, Boolean.valueOf(av8.b.b(Boolean.FALSE, null)), null, null, null, null, null, null, 2031, null), 4, null);
        String r110 = (String) r17.getFirst();
        String r111 = (String) r17.getSecond();
        String r112 = a().getUserBotGenderStarlingKey();
        String r113 = a().getUserBotTypeStarlingKey();
        String r114 = r16.toString();
        Uri r20 = (Uri) r14.getParcelableExtra("com.yalantis.ucrop.InputUri");
        if (r20 == null) goto L63;
        String r115 = r20.toString();
    L64:
        boolean r116 = o0.d(a().getIconUrl());
        Uri r21 = (Uri) r14.getParcelableExtra("com.yalantis.ucrop.InputUri");
        if (r21 == null) goto L67;
        r3 = r21.toString();
    L67:
        v(new b.d(r18, r19, r110, r111, r112, r113, "click_create_preview", r114, null, r115, r116, r3));
        return;
    L63:
        r115 = null;
    L68:
        FLogger r22 = FLogger.a;
        r22.e("BotBgImageEditViewModel", "crop fail");
        if (r14 == null) goto L81;
        Throwable r23 = (Throwable) r14.getSerializableExtra("com.yalantis.ucrop.Error");
        if (r23 == null) goto L77;
        String r24 = r23.getMessage();
        if (r24 == null) goto L77;
        if (StringsKt.contains$default(r24, "Failed to recognize format", false, 2, null) != true) goto L77;
    L78:
        if (r2 == false) goto L80;
        r22.e("BotBgImageEditViewModel", "Failed to recognize format");
        qu8.b.d("bot_create/bg_setting/manual", 10023);
        qu8.b.d("bot_create/avatar_setting", 1002);
        v(new b.h(new TextRes.StringResId(2131910878)));
        return;
    L80:
        qu8.b.d("bot_create/bg_setting/manual", -2);
        qu8.b.d("bot_create/avatar_setting", 1002);
        v(new b.h(new TextRes.StringResId(2131900249)));
        return;
    L77:
        r2 = false;
        goto L78
    L81:
        qu8.b.d("bot_create/bg_setting/manual", -2);
        qu8.b.d("bot_create/avatar_setting", 1002);
        v(new b.h(new TextRes.StringResId(2131900249)));
        return;
    L83:
        if ((r0 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.b) == false) goto L120;
        Bundle r25 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.b) r0).a;
        this.g = r25;
        if (getScene() != 1) goto L104;
        BgImage r26 = a().getBgImage();
        if (r26 == null) goto L89;
        String r27 = r26.bgImgUrl;
    L91:
        if (o0.d(r27) == false) goto L102;
        if (r(a().getBgImage()) == false) goto L102;
        BgImage r28 = a().getBgImage();
        if (r28 == null) goto L97;
        r3 = r28.bgImgUrl;
    L97:
        if (r3 == null) goto L100;
        r8 = r3;
    L100:
        u(this, UriProtector.parse(r8), true, false, false, 8);
        return;
    L102:
        if ((!StringsKt.isBlank(a().getIconUrl())) == false) goto L149;
        u(this, UriProtector.parse(a().getIconUrl()), true, true, false, 8);
        return;
    L149:
        return;
    L89:
        r27 = null;
        goto L91
    L104:
        if (r25 == null) goto L106;
        String r29 = r25.getString("user_bot_gender");
    L107:
        if (r25 == null) goto L110;
        r3 = r25.getString("user_bot_type");
    L110:
        if (o0.d(r29) == false) goto L115;
        if (r29 == null) goto L114;
        r8 = r29;
    L114:
        l(r8);
        return;
    L115:
        if (r3 == null) goto L118;
        r8 = r3;
    L118:
        e(r8);
        return;
    L106:
        r29 = null;
        goto L107
    L120:
        if ((r0 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.C0057a) == false) goto L136;
        String r30 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.C0057a) r0).a.getString("bg_image_new_user_guide_click_btn");
        if (Intrinsics.areEqual(r30, "ai_gen") == false) goto L132;
        String r31 = a().getUserBotGenderStarlingKey();
        if (r31 != null) goto L126;
        r31 = "";
    L126:
        String r32 = a().getUserBotTypeStarlingKey();
        if (r32 == null) goto L130;
        r8 = r32;
    L130:
        v(new b.c(r31, r8));
        return;
    L132:
        if (Intrinsics.areEqual(r30, "select_album") == false) goto L154;
        v(new b.e());
        return;
    L154:
        return;
    L136:
        throw new NoWhenBranchMatchedException();
    L29:
        if (((com.larus.bot.impl.feature.edit.feature.bgimage.a.g) r0).a == false) goto L31;
    L35:
        c(true);
        return;
    L31:
        if (String.valueOf(((c) this.d.getValue()).a).length() <= 0) goto L33;
        r7 = true;
    L33:
        if (r7 == false) goto L35;
        v(b.g.a);
        goto L35
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.t
    public final Object i(Continuation<? super Boolean> r11) {
        if ((r11 instanceof BotBgImageEditViewModel$interceptCreateProcess$1) == false) goto L7;
        BotBgImageEditViewModel$interceptCreateProcess$1 r0 = (BotBgImageEditViewModel$interceptCreateProcess$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        BotBgImageEditViewModel$interceptCreateProcess$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L29:
        y r13 = (com.larus.network.http.a) r12;
        if ((r13 instanceof y) == false) goto L37;
        ImageUploadResult r14 = (ImageUploadResult) ((com.larus.network.http.a) r13).b;
        if (r14 == null) goto L34;
        String r15 = r14.getUploadUri();
    L35:
        j(r15);
        goto L37
    L34:
        r15 = null;
    L37:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (o0.d(a().getOriginalUserImgUri()) == false) goto L37;
        String r16 = a().getOriginalUserImgUri();
        if (r16 == null) goto L21;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Uri r17 = UriProtector.parse(r16);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        if (Intrinsics.areEqual(r17.getScheme(), ShareType.FILE) != true) goto L21;
        boolean r18 = true;
    L22:
        if (r18 == false) goto L37;
        BotImageUploadViewModel r4 = (BotImageUploadViewModel) this.i.getValue();
        String r19 = a().getOriginalUserImgUri();
        if (r19 != null) goto L26;
        r19 = "";
    L26:
        Uri r110 = UriProtector.parse(r19);
        r6.label = 1;
        r12 = BotImageUploadViewModel.syncUpload$default(r4, r110, 0, null, false, r6, 14, null);
        if (r12 != r2) goto L29;
        return r2;
    L21:
        r18 = false;
    L7:
        r0 = new BotBgImageEditViewModel$interceptCreateProcess$1(this, r11);
        goto L8
    }

    public final boolean r(BgImage r3) {
        if (getScene() != 0) goto L6;
        if (r3 != null) goto L13;
        return false;
    L13:
        return Intrinsics.areEqual(r3.getBgImgOpen(), Boolean.TRUE);
    L6:
        if (r3 == null) goto L8;
        boolean r4 = Intrinsics.areEqual(r3.getBgImgOpen(), Boolean.FALSE);
    L9:
        if (r4 == true) goto L14;
        return true;
    L14:
        return false;
    L8:
        r4 = false;
        goto L9
    }

    public final void v(b r7) {
        BuildersKt.launch$default(this.b, null, null, new BotBgImageEditViewModel$sendUIEvent$1(this, r7, null), 3, null);
    }

    public BotBgImageEditViewModel(CoroutineScope r9, s r10) {
        Intrinsics.checkNotNullParameter(r9, "scope");
        Intrinsics.checkNotNullParameter(r10, "dependency");
        this.a = r10;
        this.b = r9;
        StateFlowImpl r11 = j1.a(new c(null, false, true, new TextRes.StringResId(2131897423), true, false));
        this.c = r11;
        this.d = kotlinx.coroutines.flow.e.b(r11);
        MutableSharedFlow<b> r12 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r12;
        this.f = kotlinx.coroutines.flow.e.a(r12);
        this.h = LazyKt.lazy(new q());
        this.i = LazyKt.lazy(new r());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.b, new BotBgImageEditViewModel$bindObservers$1(this, null)), r9);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void o(String r14, BgImage r15) {
        String r0 = null;
        if (r15 == null) goto L5;
        String r1 = r15.bgImgUrl;
    L7:
        if (o0.d(r1) == true) goto L9;
    L15:
        if (r14 == null) goto L17;
        u(this, UriProtector.parse(r14), true, true, false, 8);
        return;
    L17:
        u(this, null, false, true, false, 8);
        return;
    L9:
        if (r(r15) == false) goto L15;
        if (r15 == null) goto L12;
        r0 = r15.bgImgUrl;
    L12:
        if (r0 != null) goto L14;
        r0 = "";
    L14:
        u(this, UriProtector.parse(r0), true, false, false, 8);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static final Object q(BotBgImageEditViewModel r18, String r19, String r20, Continuation r21) {
        r18.getClass();
        if ((r21 instanceof BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1) == false) goto L7;
        BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1 r2 = (BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1 r7 = r2;
        Object r1 = r7.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        boolean r9 = false;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Job r6 = (Job) r7.L$0;
        ResultKt.throwOnFailure(r1);
    L24:
        com.larus.network.http.f r8 = (com.larus.network.http.a) r1;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
        r18.b(false);
        if ((r8 instanceof com.larus.network.http.f) == false) goto L37;
        FLogger.a.e("BotBgImageEditViewModel", "interceptShowGenActionSheetToBotInfoReview");
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L29;
        qu8.b.c(20016, new String[]{"bot_create/bg_setting/ai", "bot_create/bg_setting"});
        r18.v(new b.h(new TextRes.StringResId(2131908080)));
    L35:
        r9 = true;
        goto L37
    L29:
        com.larus.network.http.f r10 = r8;
        qu8.b.c(r10.d.getCode(), new String[]{"bot_create/bg_setting/ai", "bot_create/bg_setting"});
        int r11 = lm9.e.a;
        String r12 = lm9.e.a(r10.d, "");
        if (r12.length() != 0) goto L32;
        r9 = true;
    L32:
        if (r9 == false) goto L34;
        r18.v(new b.h(new TextRes.StringResId(2131901611)));
        goto L35
    L34:
        r18.v(new b.h(new TextRes.PlainText(r12)));
    L37:
        return Boxing.boxBoolean(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (o0.d(r19) == false) goto L17;
    L20:
        Job r13 = BuildersKt.launch$default(r18.b, null, null, new BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$delayShowLoadingJob$1(r18, null), 3, null);
        AIGenBgImageRepository r14 = (AIGenBgImageRepository) r18.h.getValue();
        r7.L$0 = r13;
        r7.label = 1;
        Object r15 = AIGenBgImageRepository.d(r14, r19, r20, null, r7, 4);
        if (r15 == r4) goto L39;
        r6 = r13;
        r1 = r15;
        goto L24
    L39:
        return r4;
    L17:
        if (o0.d(r20) == true) goto L20;
        return Boxing.boxBoolean(false);
    L7:
        r2 = new BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1(r18, r21);
        goto L8
    }

    public final void t(Uri r10, boolean r11, boolean r12, boolean r13) {
        if (r10 != null) goto L4;
        TextRes.StringResId r6 = new TextRes.StringResId(2131897423);
        boolean r7 = true;
    L5:
        StateFlowImpl r0 = this.c;
        ((c) this.d.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r6, "btnStr");
        r0.setValue(new c(r10, r11, r12, r6, r7, r13));
        return;
    L4:
        r6 = new TextRes.StringResId(2131905466);
        r7 = false;
        goto L5
    }

    public static void u(BotBgImageEditViewModel r1, Uri r2, boolean r3, boolean r4, boolean r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = ((c) r1.d.getValue()).a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = ((c) r1.d.getValue()).b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = ((c) r1.d.getValue()).c;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = ((c) r1.d.getValue()).f;
    L14:
        r1.t(r2, r3, r4, r5);
    }
}
