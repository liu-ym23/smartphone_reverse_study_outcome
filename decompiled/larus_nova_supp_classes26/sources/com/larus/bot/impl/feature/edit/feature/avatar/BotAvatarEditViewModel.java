package com.larus.bot.impl.feature.edit.feature.avatar;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.im.bean.bot.BgImage;
import com.larus.image.loader.b0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class BotAvatarEditViewModel implements v, t, s {
    public static final /* synthetic */ int h = 0;
    public final /* synthetic */ s a;
    public final CoroutineScope b;
    public final StateFlowImpl c;
    public final b1 d;
    public final MutableSharedFlow<b> e;
    public final a1 f;
    public final BotImageUploadViewModel g;

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

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final int getScene() {
        return this.a.getScene();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void h(String r2) {
        this.a.h(r2);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void k(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ShareType.URL);
        Intrinsics.checkNotNullParameter(r3, "uri");
        this.a.k(r2, r3);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void m(String r2) {
        this.a.m(r2);
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
    public final void d(boolean r4) {
        FLogger.a.i("BotAvatarViewModel", "refreshAvatarLoading, isGenerating: " + r4);
        q(this, null, false, r4, 3);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.avatar.a r14) {
        com.larus.bot.impl.feature.edit.feature.avatar.a r15 = r14;
        Intrinsics.checkNotNullParameter(r15, "uiAction");
        boolean r2 = true;
        String r4 = null;
        Uri r5 = null;
        if ((r15 instanceof com.larus.bot.impl.feature.edit.feature.avatar.a.b) == false) goto L28;
        ActivityResult r16 = ((com.larus.bot.impl.feature.edit.feature.avatar.a.b) r15).a;
        if (r16.getResultCode() != (-1)) goto L13;
        Intent r17 = r16.getData();
        if (r17 == null) goto L81;
        Uri r18 = (Uri) r17.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        if (r18 == null) goto L11;
        b(true);
        qu8.b.e("file_handle_upload_avatar", "bot_create/avatar/manual", false);
        this.g.upload(r18, 6, Intrinsics.areEqual(r18.getScheme(), ShareType.FILE));
        return;
    L11:
        r(new b.d(new TextRes.StringResId(2131900249)));
        qu8.b.d("bot_create/avatar/manual", -2);
        qu8.b.d("bot_create/avatar_setting", 1002);
        return;
    L81:
        return;
    L13:
        if (r16.getResultCode() != 96) goto L84;
        Intent r19 = r16.getData();
        if (r19 == null) goto L85;
        Throwable r110 = (Throwable) r19.getSerializableExtra("com.yalantis.ucrop.Error");
        FLogger.a.e("BotAvatarViewModel", "onActivityResult: called, cropError = " + r110);
        if (r110 == null) goto L23;
        String r111 = r110.getMessage();
        if (r111 == null) goto L23;
        if (StringsKt.contains$default(r111, "Failed to recognize format", false, 2, null) != true) goto L23;
    L24:
        if (r2 == false) goto L26;
        r(new b.d(new TextRes.StringResId(2131910878)));
        qu8.b.d("bot_create/avatar_setting", 1002);
        qu8.b.d("bot_create/avatar/manual", 10023);
        return;
    L26:
        r(new b.d(new TextRes.StringResId(2131900249)));
        qu8.b.d("bot_create/avatar_setting", 1002);
        qu8.b.d("bot_create/avatar/manual", -2);
        return;
    L23:
        r2 = false;
        goto L24
    L85:
        return;
    L84:
        return;
    L28:
        if ((r15 instanceof com.larus.bot.impl.feature.edit.feature.avatar.a.f) == false) goto L31;
        com.larus.bot.impl.feature.edit.feature.avatar.a.f r112 = (com.larus.bot.impl.feature.edit.feature.avatar.a.f) r15;
        c(true);
        return;
    L31:
        if ((r15 instanceof com.larus.bot.impl.feature.edit.feature.avatar.a.c) == false) goto L47;
        BotAvatarIconData r113 = ((com.larus.bot.impl.feature.edit.feature.avatar.a.c) r15).a;
        if (r113 != null) goto L36;
        return;
    L36:
        if (o0.d(r113.getIconUrl()) == false) goto L38;
        r5 = b0.a(r113.getIconUrl(), "bot_create.avatar_upload", false, false, 6);
    L38:
        q(this, r5, true, false, 4);
        String r0 = r113.getIconUrl();
        String r1 = "";
        if (r0 != null) goto L41;
        r0 = "";
    L41:
        String r3 = r113.getIconUri();
        if (r3 == null) goto L45;
        r1 = r3;
    L45:
        k(r0, r1);
        h(r113.getPrompt());
        c(false);
        qu8.b.c(0, new String[]{"bot_create/avatar/ai", "bot_create/avatar_setting"});
        return;
    L47:
        if (Intrinsics.areEqual(r15, com.larus.bot.impl.feature.edit.feature.avatar.a.d.a) == false) goto L53;
        if (z2.a.createBotAutoFillEnable() == false) goto L51;
        r(new b.c(a().getAvatarPrompt(), "click_button"));
        return;
    L51:
        r(new b.C0056b("click_button"));
        return;
    L53:
        if (Intrinsics.areEqual(r15, com.larus.bot.impl.feature.edit.feature.avatar.a.e.a) == false) goto L72;
        if (((c) this.d.getValue()).c == true) goto L68;
        Uri r114 = ((c) this.d.getValue()).a;
        if (r114 == null) goto L59;
        r4 = r114.toString();
    L59:
        if (r4 != null) goto L61;
    L64:
        if (r2 == true) goto L68;
        r(new b.a(String.valueOf(((c) this.d.getValue()).a), a().getAvatarPrompt()));
        return;
    L61:
        if (StringsKt.isBlank(r4) == true) goto L64;
        r2 = false;
    L68:
        if (z2.a.createBotAutoFillEnable() == false) goto L70;
        r(new b.c(a().getAvatarPrompt(), "click_empty_head"));
        return;
    L70:
        r(new b.C0056b("click_empty_head"));
        return;
    L72:
        if (Intrinsics.areEqual(r15, com.larus.bot.impl.feature.edit.feature.avatar.a.C0055a.a) == false) goto L80;
        if (getScene() == 1) goto L76;
        return;
    L76:
        if ((!StringsKt.isBlank(a().getIconUrl())) == false) goto L96;
        Uri r115 = UriProtector.parse(a().getIconUrl());
        StateFlowImpl r6 = this.c;
        ((c) this.d.getValue()).getClass();
        r6.setValue(new c(r115, true, false));
        return;
    L96:
        return;
    L80:
        throw new NoWhenBranchMatchedException();
    }

    public final void r(b r7) {
        BuildersKt.launch$default(this.b, null, null, new BotAvatarEditViewModel$sendUIEvent$1(this, r7, null), 3, null);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void o(String r3, BgImage r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (o0.d(r3) == false) goto L6;
        Uri r5 = b0.a(r3, "bot_create.avatar_upload", false, false, 6);
    L7:
        q(this, r5, false, false, 6);
        return;
    L6:
        r5 = null;
        goto L7
    }

    public BotAvatarEditViewModel(Application r7, CoroutineScope r8, s r9) {
        Intrinsics.checkNotNullParameter(r7, "application");
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r9, "dependency");
        this.a = r9;
        this.b = r8;
        boolean r3 = true;
        if (getScene() == 1) goto L5;
    L7:
        Uri r0 = null;
    L9:
        if (getScene() == 1) goto L12;
        r3 = false;
    L12:
        StateFlowImpl r10 = j1.a(new c(r0, r3, false));
        this.c = r10;
        this.d = kotlinx.coroutines.flow.e.b(r10);
        MutableSharedFlow<b> r11 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.e = r11;
        this.f = kotlinx.coroutines.flow.e.a(r11);
        BotImageUploadViewModel r12 = new BotImageUploadViewModel(r7);
        this.g = r12;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(FlowLiveDataConversions.asFlow(r12.getUpload().c), new BotAvatarEditViewModel$bindObservers$1(this, null)), r8);
        return;
    L5:
        if (o0.d(a().getIconUrl()) == false) goto L7;
        r0 = b0.a(a().getIconUrl(), "bot_update.avatar_default", false, false, 6);
        goto L9
    }

    public static void q(BotAvatarEditViewModel r1, Uri r2, boolean r3, boolean r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r2 = ((c) r1.d.getValue()).a;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = ((c) r1.d.getValue()).b;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = ((c) r1.d.getValue()).c;
    L11:
        StateFlowImpl r6 = r1.c;
        ((c) r1.d.getValue()).getClass();
        r6.setValue(new c(r2, r3, r4));
    }
}
