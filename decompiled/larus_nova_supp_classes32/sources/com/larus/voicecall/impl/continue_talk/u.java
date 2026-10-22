package com.larus.voicecall.impl.continue_talk;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.tips.GuideTipsDelegate;
import com.larus.bmhome.chat.tips.IGuideTipsService;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.edgeeffect.ScreenEdgeEffectGLView;
import com.larus.common_ui.edgeeffect.ScreenEdgeEffectView;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SceneModelList;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.api.g0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.b;
import com.larus.voicecall.impl.databinding.LarusLayoutContinuousBottomContainerBinding;
import com.larus.voicecall.impl.degrade.RealtimeCallDegradeManager;
import com.larus.voicecall.impl.ui.RealtimeCallFragment;
import com.larus.voicecall.impl.ui.RealtimeCallHelperKt;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import de8.c;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import u29.a;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class u implements Runnable {
    public final /* synthetic */ ChatContinuousTalkComponent a;
    public final /* synthetic */ xa8.e b;

    public /* synthetic */ u(ChatContinuousTalkComponent r1, xa8.e r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatContinuousTalkComponent r2 = this.a;
        xa8.e r3 = this.b;
        int r0 = ChatContinuousTalkComponent.M;
        if (b.a() == true) goto L42;
        h2 r1 = r2.h3();
        if (r1.e == false) goto L7;
        FLogger.a.i("ScreenEdgeEffectManager", "[tryShowScreenEdgeEffect]: screen edge effect is showing");
        goto L42
    L7:
        FLogger r8 = FLogger.a;
        r8.i("ScreenEdgeEffectManager", "[tryShowScreenEdgeEffect]: try show screen edge effect");
        r1.e = true;
        Activity r10 = r1.c;
        if (r1.d != null) goto L16;
        if (r10 == null) goto L16;
        if (Build.VERSION.SDK_INT < 33) goto L13;
        ScreenEdgeEffectView r11 = new ScreenEdgeEffectView(r10, null, 6, 0);
    L14:
        r1.d = r11;
        goto L16
    L13:
        r11 = new ScreenEdgeEffectGLView(r10, null);
    L16:
        if (r1.a == false) goto L18;
        r8.i("ScreenEdgeEffectManager", "[addSpecificOverlayView]: view is already added");
    L33:
        r1.b();
        d19.g r9 = r1.d;
        if (r9 == null) goto L36;
        r9.init();
    L36:
        d19.g r12 = r1.d;
        if (r12 == null) goto L39;
        boolean r13 = v19.h.a;
        r12.setDarkMode(v19.h.a(null));
    L39:
        d19.g r4 = r1.d;
        if (r4 == null) goto L42;
        r4.b(null, null);
        goto L42
    L18:
        Activity r14 = r1.c;
        if (r14 != null) goto L21;
    L32:
        r8.i("ScreenEdgeEffectManager", "[addSpecificOverlayView]: activity is null or in invalid state");
        goto L33
    L21:
        if (r14.isDestroyed() == true) goto L32;
        if (r14.isFinishing() == true) goto L32;
        View r15 = r1.d;
        if ((r15 instanceof View) == false) goto L28;
        View r16 = r15;
    L29:
        if (r16 != null) goto L31;
        r8.i("ScreenEdgeEffectManager", "[addSpecificOverlayView]: view is null");
        goto L33
    L31:
        r1.a = true;
        ViewGroup r17 = (ViewGroup) r14.findViewById(R.id.content);
        r1.b = r17;
        r17.addView(r16, new FrameLayout.LayoutParams(-1, -1));
        r8.i("ScreenEdgeEffectManager", "[addSpecificOverlayView]: view is added");
        goto L33
    L28:
        r16 = null;
    L42:
        com.larus.bmhome.chat.component.cvs.y r5 = r2.u0();
        if (r5 == null) goto L45;
        BotModel r18 = r5.j0();
    L46:
        com.larus.bmhome.chat.component.cvs.y r6 = r2.u0();
        if (r6 == null) goto L49;
        r6.h();
    L49:
        if (r18 == null) goto L53;
        BotIconImage r7 = r18.getIconImage();
        if (r7 == null) goto L53;
        String r19 = r7.getImg720();
    L55:
        if (com.larus.utils.o0.d(r19) == false) goto L60;
        if (r18 == null) goto L65;
        BotIconImage r20 = r18.getIconImage();
        if (r20 == null) goto L65;
        String r21 = r20.getImg720();
    L64:
        String r110 = r21;
    L66:
        Bundle r22 = r3.d;
        if (r22 != null) goto L69;
        r22 = BundleKt.bundleOf();
    L69:
        Bundle r111 = r22;
        String r23 = r3.c;
        if (r23.length() != 0) goto L72;
        boolean r112 = true;
    L73:
        String r113 = NameKeys.UnloadStrategy_No_Strategy;
        if (r112 == false) goto L80;
        Bundle r24 = ((c) r2.q.getValue()).b;
        if (r24 == null) goto L79;
        r23 = r24.getString("open_vlm", NameKeys.UnloadStrategy_No_Strategy);
        if (r23 != null) goto L80;
    L79:
        r23 = NameKeys.UnloadStrategy_No_Strategy;
    L80:
        boolean r114 = r3.e;
        RealtimeCallUtil.a.getClass();
        if (z2.a.v3().b() == false) goto L87;
        if (r114 == true) goto L86;
    L91:
        String r115 = r23;
    L93:
        if (StringsKt.isBlank(r23) == true) goto L95;
    L97:
        boolean r116 = false;
    L232:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L106
        String r26 = r111.getString("target_scene");     // Catch: Throwable -> L106
        if (r26 == null) goto L103;
        String r27 = StringsKt.trimEnd(r26).toString();     // Catch: Throwable -> L106
        if (r27 == null) goto L103;
        Integer r28 = Integer.valueOf(CastIntegerProtector.parseInt(r27));     // Catch: Throwable -> L106
    L104:
        Object r29 = Result.constructor-impl(r28);     // Catch: Throwable -> L106
    L108:
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L112;
        FLogger.a.e("ChatContinuousComponent", "[buildRealtimeFragmentArguments] bundle value:" + r111.getString("target_scene") + ", it:" + r30);
    L112:
        if (Result.isFailure-impl(r29) == false) goto L114;
        r29 = null;
    L114:
        Integer r31 = (Integer) r29;
        if (r31 == null) goto L117;
        int r32 = r31.intValue();
    L118:
        r111.putInt("target_scene", r32);
        com.larus.bmhome.chat.component.cvs.y r33 = r2.u0();
        if (r33 == null) goto L121;
        wc9.e r34 = r33.h();
    L122:
        if (r34 == null) goto L124;
        String r35 = r34.a;
    L125:
        ChatContinuousTalkComponent.z3(r111, "conversation_id", r35);
        if (r34 == null) goto L128;
        String r36 = r34.I;
    L129:
        ChatContinuousTalkComponent.z3(r111, "conversation_project_id", r36);
        com.larus.bmhome.chat.component.cvs.y r37 = r2.u0();
        if (r37 == null) goto L132;
        String r38 = r37.getBotId();
    L133:
        ChatContinuousTalkComponent.z3(r111, "bot_id", r38);
        ChatContinuousTalkComponent.z3(r111, "is_new_conversation", Boolean.FALSE);
        if (r18 == null) goto L138;
        SpeakerVoice r39 = r18.getVoiceType();
        if (r39 == null) goto L138;
        String r40 = RealtimeCallHelperKt.a(r39);
    L139:
        ChatContinuousTalkComponent.z3(r111, "style_name", r40);
        if (r18 == null) goto L144;
        SpeakerVoice r41 = r18.getVoiceType();
        if (r41 == null) goto L144;
        String r42 = r41.getName();
    L145:
        ChatContinuousTalkComponent.z3(r111, "speaker_name", r42);
        if (r18 == null) goto L150;
        SpeakerVoice r43 = r18.getVoiceType();
        if (r43 == null) goto L150;
        String r44 = r43.getId();
    L151:
        ChatContinuousTalkComponent.z3(r111, "voice_id", r44);
        if (r18 == null) goto L154;
        Integer r45 = r18.getBotType();
    L155:
        ChatContinuousTalkComponent.z3(r111, "bot_type", r45);
        if (r18 == null) goto L158;
        String r46 = r18.getName();
    L159:
        ChatContinuousTalkComponent.z3(r111, "bot_name", r46);
        ChatContinuousTalkComponent.z3(r111, "bot_avatar", r110);
        if (r18 == null) goto L162;
        SceneModelList r47 = r18.getSceneModelList();
    L163:
        ChatContinuousTalkComponent.z3(r111, "scene_model_list", r47);
        ChatContinuousTalkComponent.z3(r111, "bot_model", r18);
        if (r18 == null) goto L168;
        SpeakerVoice r48 = r18.getVoiceType();
        if (r48 == null) goto L168;
        String r49 = r48.getExtra();
    L169:
        ChatContinuousTalkComponent.z3(r111, "tts_extra", r49);
        ChatContinuousTalkComponent.z3(r111, "is_continuous_talk", Boolean.TRUE);
        ChatContinuousTalkComponent.z3(r111, "open_vlm", r115);
        ChatContinuousTalkComponent.z3(r111, "enter_method", r3.a);
        if (r34 == null) goto L172;
        String r50 = ic8.n.f(r34);
    L173:
        ChatContinuousTalkComponent.z3(r111, "chat_type", r50);
        ChatContinuousTalkComponent.z3(r111, "current_page", "chat");
        ChatContinuousTalkComponent.z3(r111, "call_id", r3.b);
        if (r116 == false) goto L176;
        ChatContinuousTalkComponent.z3(r111, "video_call_enter_method", "restore_last_status");
    L176:
        LocalSubConvHelper r51 = LocalSubConvHelper.a;
        if (r34 == null) goto L179;
        String r52 = r34.a;
    L180:
        String r53 = (String) LocalSubConvHelper.d(r52).get("sub_conv_firstmet_type");
        if (r53 != null) goto L183;
        r53 = NameKeys.UnloadStrategy_No_Strategy;
    L183:
        if (r34 == null) goto L185;
        String r54 = r34.a;
    L186:
        String r55 = (String) LocalSubConvHelper.d(r54).get("sub_conv_source_message");
        if (r55 == null) goto L190;
        r113 = r55;
    L190:
        ChatContinuousTalkComponent.z3(r111, "sub_conv_firstmet_type", r53);
        ChatContinuousTalkComponent.z3(r111, "sub_conv_source_message", r113);
        if (r18 != null) goto L193;
    L195:
        boolean r56 = false;
    L196:
        r111.putBoolean("is_continuous_talk", r56);
        FLogger r57 = FLogger.a;
        r57.w("ChatContinuousComponent", "buildRealtimeFragmentArguments, canUseContinue = " + r56);
        LarusLayoutContinuousBottomContainerBinding r58 = r2.n;
        if (r58 != null) goto L199;
    L230:
        r2.m3().setContinuousTalk(true);
        return;
    L199:
        if (r58.e == null) goto L230;
        RealtimeCallFragment r59 = new RealtimeCallFragment();
        r2.I = r59;
        r59.setArguments(r111);
        FragmentActivity r60 = r2.C3();
        if (r60 == null) goto L214;
        FragmentManager r61 = r60.getSupportFragmentManager();
        if (r61 == null) goto L214;
        FragmentTransaction r62 = r61.beginTransaction();
        if (r62 == null) goto L214;
        FragmentTransaction r63 = r62.setCustomAnimations(2130772380, 2130772384);
        if (r63 == null) goto L214;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r63, r59, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "continuous_talk_fragment_v2", 2131372830) == true) goto L212;
        r63 = r63.replace(2131372830, r59, "continuous_talk_fragment_v2");
    L212:
        if (r63 == null) goto L214;
        r63.commitAllowingStateLoss();
    L214:
        Lazy r64 = b.a;
        if (((Keva) r64.getValue()).getBoolean("show_continue_talk_toast", true) == true) goto L220;
        if (AppHost.a.isDebug() == true) goto L220;
        r57.w("ChatContinuousComponent", "tryShowToast shouldShowContinueTalkToast");
    L220:
        if (b.a() == false) goto L222;
        r57.w("ChatContinuousComponent", "tryShowToast forceFullScreenCall");
        goto L230
    L222:
        a r65 = (a) r2.B.getValue();
        if (r65 == null) goto L230;
        g0 r66 = r65.C5();
        if (r66 == null) goto L230;
        View r210 = r66.getTitleView();
        if (r210 == null) goto L230;
        ((Keva) r64.getValue()).storeBoolean("show_continue_talk_toast", false);
        GuideTipsDelegate r117 = GuideTipsDelegate.b;
        Context r118 = r2.getContext();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r67 = com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getString(2131901007);
        Intrinsics.checkNotNullParameter(r2, "<this>");
        IGuideTipsService.a.a(r117, r118, new com.larus.bmhome.chat.tips.a(9, r67, com.larus.ui.arch.component.internal.attach.a.b(r2, r2).getString(2131901006), 8000), r210, i5.h(), i5.h(), i5.o(), AutoOffsetPopupWindow.WindowGravity.BOTTOM, i5.h(), 0, new a0(), null, AppHost.a.isDebug(), Integer.valueOf(i5.P()), 260864);
        goto L230
    L193:
        if (c4a.g.a(r18) == true) goto L195;
        r56 = true;
        goto L196
    L185:
        r54 = null;
        goto L186
    L179:
        r52 = null;
        goto L180
    L172:
        r50 = null;
    L168:
        r49 = null;
        goto L169
    L162:
        r47 = null;
        goto L163
    L158:
        r46 = null;
        goto L159
    L154:
        r45 = null;
    L150:
        r44 = null;
    L144:
        r42 = null;
    L138:
        r40 = null;
        goto L139
    L132:
        r38 = null;
        goto L133
    L128:
        r36 = null;
        goto L129
    L124:
        r35 = null;
        goto L125
    L121:
        r34 = null;
        goto L122
    L117:
        r32 = -1;
    L103:
        r28 = null;
    L106:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r29 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L108
    L95:
        if ((!StringsKt.isBlank(r115)) == false) goto L97;
        r116 = true;
        goto L232
    L86:
        if (RealtimeCallDegradeManager.i("asr_slide") == true) goto L87;
        com.larus.voicecall.impl.util.t0.a.getClass();
        if (((Keva) com.larus.voicecall.impl.util.t0.b.getValue()).getBoolean("IS_VIDEO_MODEL_WHEN_EXIT_REALTIME", false) == false) goto L91;
        r115 = "1";
    L87:
        r115 = NameKeys.UnloadStrategy_No_Strategy;
        goto L93
    L72:
        r112 = false;
    L65:
        r110 = null;
        goto L66
    L60:
        if (r18 == null) goto L65;
        BotIconImage r68 = r18.getIconImage();
        if (r68 == null) goto L65;
        r21 = r68.getOriginUrl();
    L53:
        r19 = null;
        goto L55
    L45:
        r18 = null;
        goto L46
    }
}
