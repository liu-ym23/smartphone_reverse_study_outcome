package com.larus.bot.impl.feature.botmaker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.bmhome.auth.BgImageAbParam;
import com.larus.bmhome.auth.BgImageConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bot.impl.feature.edit.BotCreateViewModel;
import com.larus.bot.impl.feature.edit.feature.accesspermission.BotPublicPermissionBSDialog;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.bot.BotMakerDataModel;
import com.larus.platform.service.m3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.c0;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f implements nq9.e {
    public static final /* synthetic */ int f = 0;
    public final Fragment a;
    public final Bundle b;
    public final by7.e c;
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(e r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final BotCreateViewModel e() {
        return (BotCreateViewModel) this.d.getValue();
    }

    public static void d(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void a(Message r18) {
        Intrinsics.checkNotNullParameter(r18, "data");
        e0 r1 = (e0) AuthModelDelegate.b.e().getValue();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.a == null) goto L43;
        nq9.c r2 = m3.a.i("chat", "bot_maker_card_edit");
        String r5 = null;
        if (r2 == null) goto L9;
        String r11 = r2.b;
    L10:
        dv8.b r6 = e().getBotCreateTrace();
        String r7 = "";
        if (r11 != null) goto L13;
        String r8 = "";
    L14:
        r6.u(r8);
        if (r2 == null) goto L17;
        String r12 = r2.a;
    L18:
        Bundle r3 = this.b;
        if (r3 == null) goto L21;
        String r13 = r3.getString("from_activity_name");
    L22:
        Bundle r4 = this.b;
        if (r4 == null) goto L25;
        r5 = r4.getString("from_activity_module");
    L25:
        String r14 = r5;
        Bundle r9 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat"), TuplesKt.to("enter_method", "bot_maker_card_edit")});
        String r10 = r18.getContent();
        if (r10 != null) goto L28;
        r10 = "";
    L28:
        r9.putString("bot_create_info", r10);
        String r15 = r18.getConversationId();
        if (r15 == null) goto L32;
        r7 = r15;
    L32:
        r9.putString("bot_create_cvs_id", r7);
        r9.putString("bot_create_msg_id", r18.getMessageId());
        r9.putInt("bot_create_msg_index", (int) r18.getLocalIndex());
        if (r11 == null) goto L35;
        r9.putString("create_way", r11);
    L35:
        r9.putString("creation_id", r12);
        if (r13 == null) goto L38;
        r9.putString("from_activity_name", r13);
    L38:
        if (r14 == null) goto L40;
        r9.putString("from_activity_module", r14);
    L40:
        by7.h.k(r9, this.c);
        com.bytedance.router.i r16 = SmartRouter.buildRoute(this.a.getContext(), m3.f);
        r16.c.putExtras(r9);
        r16.d = 2130772400;
        r16.e = 2130772399;
        r16.d();
        c0.l(null, null, null, "bot_maker_card_edit", r11, r12, r13, r14, this.c, 527);
        return;
    L21:
        r13 = null;
        goto L22
    L17:
        r12 = null;
        goto L18
    L13:
        r8 = r11;
        goto L14
    L9:
        r11 = null;
        goto L10
    }

    public final void b(Message r13) {
        Intrinsics.checkNotNullParameter(r13, "data");
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L36;
        String r6 = dv8.c.a("chat", "bot_maker_card_head");
        dv8.b r2 = e().getBotCreateTrace();
        String r3 = "";
        if (r6 != null) goto L9;
        String r4 = "";
    L10:
        r2.u(r4);
        int r5 = dv8.b.g;
        String r7 = dv8.b.a.a();
        Bundle r8 = this.b;
        if (r8 == null) goto L13;
        String r9 = r8.getString("from_activity_name");
    L14:
        Bundle r10 = this.b;
        if (r10 == null) goto L17;
        String r11 = r10.getString("from_activity_module");
    L18:
        Bundle r1 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat"), TuplesKt.to("enter_method", "bot_maker_card_head")});
        String r12 = r13.getContent();
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        r1.putString("bot_create_info", r12);
        String r14 = r13.getConversationId();
        if (r14 == null) goto L25;
        r3 = r14;
    L25:
        r1.putString("bot_create_cvs_id", r3);
        r1.putString("bot_create_msg_id", r13.getMessageId());
        r1.putInt("bot_create_msg_index", (int) r13.getLocalIndex());
        if (r6 == null) goto L28;
        r1.putString("create_way", r6);
    L28:
        r1.putString("creation_id", r7);
        if (r9 == null) goto L31;
        r1.putString("from_activity_name", r9);
    L31:
        if (r11 == null) goto L33;
        r1.putString("from_activity_module", r11);
    L33:
        by7.h.k(r1, this.c);
        com.bytedance.router.i r15 = SmartRouter.buildRoute(this.a.getContext(), m3.f);
        r15.c.putExtras(r1);
        r15.d = 2130772400;
        r15.e = 2130772399;
        r15.d();
        c0.l(null, null, null, "bot_maker_card_head", r6, r7, r9, r11, this.c, 527);
        return;
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r4 = r6;
        goto L10
    }

    public final void c(Message r50) {
        Intrinsics.checkNotNullParameter(r50, "data");
        k r1 = k.a;
        BotMakerDataModel r2 = k.d(r50.getContent());
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getNick_name();
    L7:
        if (o0.d(r4) == false) goto L10;
        if (r4 == null) goto L10;
        e().updateName(r4);
    L10:
        if (r2 == null) goto L12;
        String r5 = r2.getRole();
    L14:
        if (o0.d(r5) == false) goto L17;
        if (r5 == null) goto L17;
        e().updateDescription(r5);
    L17:
        if (r2 == null) goto L19;
        String r6 = r2.getIcon_url();
    L20:
        if (r2 == null) goto L22;
        String r7 = r2.getIcon_uri();
    L23:
        boolean r8 = false;
        if (o0.d(r6) == true) goto L26;
    L51:
        String r9 = r50.getMessageId();
        String r10 = "";
        if (r9 != null) goto L54;
        r9 = "";
    L54:
        Intrinsics.checkNotNullParameter(r9, "msgId");
        String r11 = (String) ((LinkedHashMap) k.k).get(r9);
        if (o0.d(r11) == true) goto L57;
    L126:
        FeatureKitDelegate r12 = FeatureKitDelegate.b;
        if (r12.b0().b() == false) goto L130;
        e().updateWebSearch(r12.b0().c());
    L130:
        if (r12.a0().b() == false) goto L132;
        e().updateGenPic(r12.a0().c());
    L132:
        dv8.b r13 = e().getBotCreateTrace();
        r13.getClass();
        Intrinsics.checkNotNullParameter("bot_maker", "<set-?>");
        r13.f = "bot_maker";
        String r14 = dv8.c.a("chat", "bot_maker_card_complete");
        dv8.b r15 = e().getBotCreateTrace();
        if (r14 != null) goto L135;
        r14 = "";
    L135:
        r15.u(r14);
        int r16 = dv8.b.g;
        String r17 = dv8.b.a.a();
        dv8.b r18 = e().getBotCreateTrace();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "value");
        if (Intrinsics.areEqual(r17, r18.d) == true) goto L138;
        r18.b.putString("creation_id", r17);
    L138:
        dv8.b r19 = e().getBotCreateTrace();
        r19.getClass();
        Intrinsics.checkNotNullParameter("bot_maker_card_complete", "value");
        if (Intrinsics.areEqual("bot_maker_card_complete", r19.e) == true) goto L141;
        r19.b.putString("enter_method", "bot_maker_card_complete");
    L141:
        dv8.b r20 = e().getBotCreateTrace();
        Bundle r110 = this.b;
        if (r110 == null) goto L144;
        String r111 = r110.getString("from_activity_name");
    L145:
        r20.getClass();
        if (Intrinsics.areEqual(r111, null) == true) goto L148;
        r20.b.putString("from_activity_name", r111);
    L148:
        dv8.b r21 = e().getBotCreateTrace();
        Bundle r112 = this.b;
        if (r112 == null) goto L151;
        String r113 = r112.getString("from_activity_module");
    L152:
        r21.getClass();
        if (Intrinsics.areEqual(r113, null) == true) goto L155;
        r21.b.putString("from_activity_module", r113);
    L155:
        String r114 = e().getBotCreateTrace().d();
        String r115 = e().getBotCreateTrace().c();
        String r116 = e().getBotCreateTrace().i();
        String r117 = e().getBotCreateTrace().h();
        Boolean r22 = e().getEditParam().getEnableWebSearch();
        Boolean r23 = e().getEditParam().getEnableGenPic();
        BgImage r24 = e().getEditParam().getBgImage();
        if (r24 == null) goto L162;
        BgImageInfo r25 = r24.bgImageInfo;
        if (r25 == null) goto L162;
        Boolean r26 = r25.getBgImgOpen();
        if (r26 == null) goto L162;
        boolean r27 = r26.booleanValue();
    L163:
        SpeakerVoice r118 = e().getEditParam().getVoice();
        if (r118 == null) goto L166;
        String r28 = r118.getId();
    L167:
        String r29 = l.a(e().getEditParam().getVoice());
        SpeakerVoice r119 = e().getEditParam().getVoice();
        if (r119 == null) goto L170;
        String r30 = r119.getStyleId();
    L171:
        SpeakerVoice r120 = e().getEditParam().getVoice();
        if (r120 == null) goto L174;
        String r31 = r120.getName();
    L176:
        if (StringsKt.isBlank(e().getEditParam().getDescription()) == false) goto L178;
        String r33 = "empty";
    L180:
        if (StringsKt.isBlank(e().getEditParam().getIconUri()) == false) goto L182;
        String r34 = "empty";
    L183:
        List r32 = CollectionsKt.listOf(new String[]{TriggerSendLoading.NO_LOADING, ""});
        SpeakerVoice r121 = e().getEditParam().getVoice();
        if (r121 == null) goto L186;
        r3 = r121.getId();
    L186:
        if (r3 == null) goto L190;
        r10 = r3;
    L190:
        if (r32.contains(r10) == false) goto L192;
        String r35 = "empty";
    L193:
        by7.e r36 = this.c;
        Boolean r122 = Boolean.FALSE;
        Boolean r210 = Boolean.TRUE;
        c0.j("bot_maker_card_complete", r114, null, r115, r116, r117, r122, r122, r122, 0, r210, r23, r22, r122, "ai_generate", "ai_generate", Boolean.valueOf(r27), r210, r28, r29, r30, r31, "auto_fill", r33, r34, r35, "empty", "empty", "empty", null, null, null, null, null, null, null, r36, -1073741815, 31);
        qu8.b.e("bot_create", "bot_create", false);
        if (e().getPrivateStatus() != 1) goto L204;
        BotPublicPermissionBSDialog r37 = new BotPublicPermissionBSDialog();
        Pair[] r38 = new Pair[2];
        r38[0] = TuplesKt.to("public_permission_scene_argument", 1);
        if (e().getPrivateStatus() != 1) goto L198;
        r8 = true;
    L198:
        r38[1] = TuplesKt.to("public_status_key", Boolean.valueOf(r8));
        r37.setArguments(com.larus.utils.f.c(r38));
        Function2<? super String, ? super Bundle, Unit> r39 = new com.larus.bot.impl.feature.botmaker.a(this);
        Intrinsics.checkNotNullParameter(r39, "resultCallback");
        r37.k = r39;
        FragmentManager r40 = this.a.getParentFragmentManager();
        LandscapeRestrictionOperation r41 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r37, "BotPublicPermissionBSDialog", r41);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r40, r37, r41) == false) goto L215;
    L203:
        r37.j = new com.larus.bot.impl.feature.botmaker.b(this);
        o3.a(e().getBotCreateTrace().f(), e().getBotCreateTrace().d(), null, e().getBotCreateTrace().c(), "status_permission", e().getBotCreateTrace().i(), e().getBotCreateTrace().h(), this.c, 265);
        return;
    L215:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L213
    L202:
        r37.show(r40, "BotPublicPermissionBSDialog");
        goto L203
    L204:
        l0 r42 = (l0) this.e.getValue();
        if (r42 != null) goto L207;
    L211:
        dv8.b r43 = e().getBotCreateTrace();
        r43.getClass();
        Intrinsics.checkNotNullParameter("bot_maker", "<set-?>");
        r43.f = "bot_maker";
        e().create();
        return;
    L207:
        if (DialogLancet.shouldBlockDialogShow(r42) == false) goto L217;
        DialogLancet.handleBlockedDialogShow(r42);
        goto L211
    L217:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L214
    L210:
        DialogLancet.beforeDialogShow(r42);
        r42.show();
        DialogLancet.afterDialogShow(r42);
        goto L211
    L192:
        r35 = "auto_fill";
        goto L193
    L182:
        r34 = "auto_fill";
        goto L183
    L178:
        r33 = "auto_fill";
        goto L180
    L174:
        r31 = null;
        goto L176
    L170:
        r30 = null;
        goto L171
    L166:
        r28 = null;
    L162:
        r27 = false;
        goto L163
    L151:
        r113 = null;
        goto L152
    L144:
        r111 = null;
        goto L145
    L57:
        if (FeatureKitDelegate.b.w0().b() == false) goto L61;
        AudioUserConfig r44 = (AudioUserConfig) AudioServiceDelegate.a.p().getValue();
        if (r44 == null) goto L66;
        List r45 = r44.getNewVoiceList();
    L67:
        List r46 = r45;
        if (r46 != null) goto L70;
    L73:
        boolean r47 = true;
    L75:
        if (r47 == false) goto L77;
        AudioServiceDelegate.a.J("BotMakerEventListener");
    L77:
        BotLanguage r48 = k.e();
        if (r45 == null) goto L95;
        Iterator r123 = r45.iterator();
    L81:
        if (r123.hasNext() == false) goto L93;
        Object r124 = r123.next();
        SpeakerVoice r125 = (SpeakerVoice) r124;
        if (Intrinsics.areEqual(r125.getId(), r11) == false) goto L90;
        if (r48 == null) goto L86;
        String r126 = r48.c();
    L88:
        if (Intrinsics.areEqual(r126, r125.getLanguageCode()) == false) goto L90;
        boolean r127 = true;
    L91:
        if (r127 == false) goto L81;
    L94:
        SpeakerVoice r128 = (SpeakerVoice) r124;
    L97:
        if (r128 == null) goto L99;
        FLogger.a.i("BotMakerEventListener", "ai gen voiceId=" + r11 + ", name=" + r128.getName() + ", matched launch voiceList");
        BotCreateViewModel.updateVoice$default(e(), r128, false, 2, null);
        goto L126
    L99:
        if (r45 == null) goto L116;
        Iterator r49 = r45.iterator();
    L102:
        if (r49.hasNext() == false) goto L114;
        Object r129 = r49.next();
        SpeakerVoice r130 = (SpeakerVoice) r129;
        if (Intrinsics.areEqual(r130.getId(), TriggerSendLoading.NO_LOADING) == true) goto L111;
        if (r48 == null) goto L107;
        String r131 = r48.c();
    L109:
        if (Intrinsics.areEqual(r131, r130.getLanguageCode()) == false) goto L111;
        boolean r132 = true;
    L112:
        if (r132 == false) goto L102;
    L115:
        SpeakerVoice r133 = (SpeakerVoice) r129;
    L117:
        BotCreateViewModel.updateVoice$default(e(), r133, false, 2, null);
        FLogger r51 = FLogger.a;
        StringBuilder r52 = new StringBuilder("ai gen voiceId=");
        r52.append(r11);
        r52.append(", not matched launch voiceList, result name=");
        if (r133 == null) goto L120;
        String r53 = r133.getName();
    L121:
        r52.append(r53);
        r52.append(", id=");
        if (r133 == null) goto L124;
        String r54 = r133.getId();
    L125:
        r52.append(r54);
        r51.w("BotMakerEventListener", r52.toString());
        goto L126
    L124:
        r54 = null;
        goto L125
    L120:
        r53 = null;
        goto L121
    L107:
        r131 = null;
    L111:
        r132 = false;
        goto L112
    L114:
        r129 = null;
        goto L115
    L116:
        r133 = null;
        goto L117
    L86:
        r126 = null;
    L90:
        r127 = false;
        goto L91
    L93:
        r124 = null;
        goto L94
    L95:
        r128 = null;
        goto L97
    L70:
        if (r46.isEmpty() == true) goto L73;
        r47 = false;
    L66:
        r45 = null;
        goto L67
    L61:
        e0 r55 = (e0) AuthModelDelegate.b.e().getValue();
        if (r55 == null) goto L66;
        LaunchInfo r56 = r55.a;
        if (r56 == null) goto L66;
        r45 = r56.T0();
        goto L67
    L26:
        if (Intrinsics.areEqual(r6, "placeholder") == true) goto L51;
        if (o0.d(r7) == false) goto L51;
        if (Intrinsics.areEqual(r7, "placeholder") == true) goto L51;
        if (r6 == null) goto L51;
        if (r7 == null) goto L51;
        e().updateIconUri(r6, r7);
        if (z2.a.chatImmerseEnable() == false) goto L51;
        LaunchInfo r57 = (LaunchInfo) AuthModelDelegate.b.x().getValue();
        if (r57 == null) goto L42;
        BgImageConfig r58 = r57.h();
        if (r58 == null) goto L42;
        BgImageAbParam r59 = r58.a();
        if (r59 == null) goto L42;
        boolean r60 = Intrinsics.areEqual(Boolean.TRUE, r59.b());
    L43:
        if (r60 == false) goto L51;
        BgImage r61 = r2.getBgImage();
        if (r61 == null) goto L51;
        if (o0.d(r61.bgImgUri) == false) goto L51;
        if (o0.d(r61.bgImgUrl) == false) goto L51;
        e().updateBgImage(r61);
    L42:
        r60 = false;
        goto L43
    L22:
        r7 = null;
        goto L23
    L19:
        r6 = null;
        goto L20
    L12:
        r5 = null;
        goto L14
    L5:
        r4 = null;
        goto L7
    }

    public f(Fragment r2, Bundle r3, by7.e r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "trackNode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new c(this));
        this.e = LazyKt.lazy(new d(this));
        com.larus.platform.model.chat.i r5 = com.larus.platform.exp.b.a;
        if (com.larus.platform.exp.b.a.a() == true) goto L6;
        e();
        return;
    }
}
