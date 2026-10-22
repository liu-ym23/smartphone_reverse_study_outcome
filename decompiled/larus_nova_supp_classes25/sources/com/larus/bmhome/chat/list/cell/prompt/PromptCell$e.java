package com.larus.bmhome.chat.list.cell.prompt;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.auth.OnboardingActionCardItemData;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.common.apphost.AppHost;
import com.larus.extension.diversion.api.HostDiversionServiceDelegate;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class PromptCell$e implements Function3<Object, Integer, View, Unit> {
    public Message a;
    public final /* synthetic */ PromptCell b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PromptContent.TravelSuggestType.values().length];
            r0[PromptContent.TravelSuggestType.SEARCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PromptContent.TravelSuggestType.IMAGE4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PromptContent.TravelSuggestType.GREET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PromptContent.TravelSuggestType.CALL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public PromptCell$e(PromptCell r1) {
        this.b = r1;
    }

    public final Object invoke(Object r66, Object r67, Object r68) {
        int r2 = ((Number) r67).intValue();
        View r5 = (View) r68;
        Intrinsics.checkNotNullParameter(r66, "data");
        Intrinsics.checkNotNullParameter(r5, "view");
        Message r15 = this.a;
        if (r15 == null) goto L256;
        int r19 = -1;
        String r20 = null;
        if ((r66 instanceof PromptContent.SuggestItem) == false) goto L143;
        PromptContent.SuggestItem r25 = (PromptContent.SuggestItem) r66;
        Map<String, String> r1 = r25.getExtra();
        if (r1 == null) goto L12;
        String r3 = r1.get("type");
        if (r3 == null) goto L12;
        Integer r4 = StringsKt.toIntOrNull(r3);
    L13:
        PromptCell.L(this.b, r15, r5, null, null, null, null, null, null, null, r25.getSuggest(), r4, null, null, null, 14844);
        PromptContent.TravelSuggestType.a r6 = PromptContent.TravelSuggestType.Companion;
        Map<String, String> r7 = r25.getExtra();
        if (r7 == null) goto L18;
        String r8 = r7.get("type");
        if (r8 == null) goto L18;
        Integer r9 = StringsKt.toIntOrNull(r8);
    L19:
        r6.getClass();
        if (r9 != null) goto L22;
        int r14 = 1;
    L25:
        if (r9 != null) goto L27;
        int r13 = 2;
    L30:
        if (r9 != null) goto L33;
    L35:
        if (r9 != null) goto L38;
    L40:
        PromptContent.TravelSuggestType r10 = null;
    L41:
        if (r10 != null) goto L43;
        int r11 = -1;
    L45:
        if (r11 == r14) goto L116;
        if (r11 == r13) goto L116;
        if (r11 == 3) goto L116;
        if (r11 != 4) goto L256;
        if (z2.a.E1() == false) goto L58;
        HostDiversionServiceDelegate r12 = HostDiversionServiceDelegate.b;
        if (r12 == null) goto L256;
        Context r16 = lf8.a.getContext(this.b);
        if (r16 != null) goto L57;
        r16 = AppHost.a.getApplication().getApplicationContext();
    L57:
        Intrinsics.checkNotNull(r16);
        JSONObject r17 = new JSONObject();
        r17.put("open_window_from", "click_onboarding_call");
        Unit r18 = Unit.INSTANCE;
        r12.a(r16, r17);
        goto L256
    L58:
        com.larus.bmhome.chat.component.cvs.y r21 = this.b.z();
        if (r21 == null) goto L61;
        wc9.e r22 = r21.h();
    L62:
        com.larus.bmhome.chat.component.cvs.y r23 = this.b.z();
        if (r23 == null) goto L65;
        BotModel r31 = r23.j0();
    L66:
        Fragment r27 = lf8.a.d(this.b);
        if (r27 == null) goto L256;
        PromptCell r24 = this.b;
        if (r22 == null) goto L71;
        String r28 = r22.a;
    L72:
        if (r22 == null) goto L74;
        String r62 = r22.I;
    L75:
        if (r22 == null) goto L77;
        String r29 = r22.B;
    L78:
        if (r22 == null) goto L80;
        Long r30 = r22.q;
    L81:
        de8.c r26 = r24.y();
        if (r26 == null) goto L84;
        RecommendFrom r32 = r26.d;
    L85:
        int r33 = gx9.o.a;
        if (r22 == null) goto L88;
        Integer r34 = r22.j;
    L89:
        if (r31 == null) goto L91;
        Integer r35 = r31.getBotType();
    L92:
        if (r31 == null) goto L96;
        BotCreatorInfo r36 = r31.getBotCreatorInfo();
        if (r36 == null) goto L96;
        String r37 = r36.getId();
    L97:
        String r38 = IAIChatControlTraceService.a.g(r34, r35, Intrinsics.areEqual(r37, AccountService.a.getUserId()));
        de8.c r39 = r24.y();
        if (r39 == null) goto L100;
        SearchMobParam r310 = r39.e;
    L101:
        de8.c r40 = r24.y();
        if (r40 == null) goto L104;
        String r41 = r40.e();
    L105:
        de8.c r42 = r24.y();
        if (r42 == null) goto L108;
        String r43 = r42.d();
    L109:
        String r44 = r25.getSchema();
        if (r44 == null) goto L114;
        Uri r45 = UriProtector.parse(r44);
        if (r45 == null) goto L114;
        r20 = com.larus.utils.y0.f(r45, "track_params");
    L114:
        VoiceCallServiceDelegate.a.t(new b3a.c(r27, r28, r29, r30, r31, r32, r38, "chat", "onboarding_card", null, false, r310, null, null, r41, r43, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r20, null, r62, -51712, 59), false);
        goto L256
    L108:
        r43 = null;
        goto L109
    L104:
        r41 = null;
        goto L105
    L100:
        r310 = null;
    L96:
        r37 = null;
        goto L97
    L91:
        r35 = null;
        goto L92
    L88:
        r34 = null;
        goto L89
    L84:
        r32 = null;
        goto L85
    L80:
        r30 = null;
        goto L81
    L77:
        r29 = null;
        goto L78
    L74:
        r62 = null;
        goto L75
    L71:
        r28 = null;
        goto L72
    L65:
        r31 = null;
        goto L66
    L61:
        r22 = null;
    L116:
        if (r10 != PromptContent.TravelSuggestType.IMAGE4) goto L126;
        if (z2.a.I1() == false) goto L126;
        HostDiversionServiceDelegate r46 = HostDiversionServiceDelegate.b;
        if (r46 == null) goto L256;
        Context r47 = lf8.a.getContext(this.b);
        if (r47 != null) goto L124;
        r47 = AppHost.a.getApplication().getApplicationContext();
    L124:
        Intrinsics.checkNotNull(r47);
        JSONObject r48 = new JSONObject();
        r48.put("open_window_from", "click_onboarding_ai_generation");
        Unit r49 = Unit.INSTANCE;
        r46.a(r47, r48);
    L126:
        if (com.larus.utils.o0.d(r25.getSendingContent()) == false) goto L256;
        Message r50 = this.a;
        if (r50 == null) goto L256;
        PromptCell r51 = this.b;
        String r52 = r25.getSuggest();
        if (r52 != null) goto L132;
        String r210 = "";
    L133:
        String r53 = r25.getSendingContent();
        if (r53 != null) goto L136;
        String r211 = "";
    L137:
        PromptCell.P(r51, r50, null, r25, r210, r211, null, null, null, null, 480);
        com.larus.bmhome.chat.api.q0 r54 = lf8.a.b(r51);
        if (r54 == null) goto L256;
        ChatMessageList r55 = r54.B7();
        if (r55 == null) goto L256;
        b0$a.b(r55, false, 15);
        goto L256
    L136:
        r211 = r53;
        goto L137
    L132:
        r210 = r52;
        goto L133
    L43:
        r11 = a.a[r10.ordinal()];
        goto L45
    L38:
        if (r9.intValue() != 4) goto L40;
        r10 = PromptContent.TravelSuggestType.GREET;
        goto L41
    L33:
        if (r9.intValue() != 3) goto L35;
        r10 = PromptContent.TravelSuggestType.IMAGE4;
        goto L41
    L27:
        r13 = 2;
        if (r9.intValue() != 2) goto L30;
        r10 = PromptContent.TravelSuggestType.CALL;
        goto L41
    L22:
        r14 = 1;
        if (r9.intValue() != 1) goto L25;
        r10 = PromptContent.TravelSuggestType.SEARCH;
        r13 = 2;
    L18:
        r9 = null;
    L12:
        r4 = null;
        goto L13
    L143:
        if ((r66 instanceof OnboardingActionCardItemData) == false) goto L256;
        BaseMessageListCell r110 = this.b;
        OnboardingActionCardItemData r56 = (OnboardingActionCardItemData) r66;
        Keva r57 = PromptCell.Y;
        r110.getClass();
        PromptCell.L(r110, r15, r5, null, null, null, null, null, null, Integer.valueOf(r2), r56.d(), null, null, null, null, 15612);
        if (com.larus.utils.o0.d(String.valueOf(r56.k())) == false) goto L152;
        PromptCell.Y.storeBoolean("im_onboarding_is_show_new" + r56.k(), true);
        com.larus.bmhome.chat.api.q0 r58 = lf8.a.b(r110);
        if (r58 == null) goto L152;
        String r59 = r15.getMessageId();
        if (r59 != null) goto L151;
        r59 = "";
    L151:
        r58.x7(r59, r15.getContentType());
    L152:
        Pair[] r60 = new Pair[2];
        r60[0] = TuplesKt.to("scene", "onboarding_first_met");
        OnboardingActionCardData.CardType r61 = r56.e();
        if (r61 == null) goto L155;
        String r63 = Integer.valueOf(r61.getValue()).toString();
    L156:
        if (r63 != null) goto L158;
        r63 = "";
    L158:
        r60[1] = TuplesKt.to("onboarding_card_skill_type", r63);
        Map r111 = MapsKt.mutableMapOf(r60);
        String r64 = r56.a();
        if (r64 == null) goto L161;
        String r65 = (String) r111.put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r64);
    L161:
        OnboardingActionCardData.CardType r69 = r56.e();
        if (r69 == null) goto L166;
        r19 = PromptCell$b.a[r69.ordinal()];
    L166:
        switch(r19) {
            case 1: goto L234;
            case 2: goto L223;
            case 3: goto L223;
            case 4: goto L223;
            case 5: goto L223;
            case 6: goto L192;
            case 7: goto L192;
            case 8: goto L168;
            default: goto L167;
        };
    L167:
        BaseMessageListCell r70 = r110;
        EnsureManager.ensureNotReachHere("no support card type");
        FLogger.a.e("WcbSugPromptCell", "no support card type");
    L248:
        boolean r112 = true;
    L249:
        if (r112 == false) goto L256;
        com.larus.bmhome.chat.api.q0 r71 = lf8.a.b(r70);
        if (r71 == null) goto L256;
        ChatMessageList r72 = r71.B7();
        if (r72 == null) goto L256;
        b0$a.b(r72, false, 14);
        goto L256
    L168:
        ArrayList r73 = new ArrayList();
        String r74 = r56.d();
        Pair[] r75 = new Pair[2];
        r75[0] = TuplesKt.to("onboarding_card_id", String.valueOf(r56.k()));
        OnboardingActionCardData.CardType r76 = r56.e();
        if (r76 == null) goto L171;
        String r77 = r76.toTea();
    L172:
        if (r77 != null) goto L174;
        r77 = "";
    L174:
        r75[1] = TuplesKt.to("sec_scene", r77);
        Map r78 = com.larus.utils.h.c(r111, r75);
        if (com.larus.utils.o0.d(r56.c()) == false) goto L180;
        if (com.larus.utils.o0.d(r56.b()) == false) goto L180;
        r73.add(new ai8.d("", r56.b(), r56.c(), null, null, null, r78, null, r110.w(), 440));
    L180:
        if (com.larus.utils.o0.d(r74) == true) goto L182;
    L186:
        com.larus.bmhome.chat.component.cvs.y r79 = r110.z();
        if (r79 == null) goto L189;
        r20 = r79.h();
    L189:
        String r80 = r20;
        BaseMessageListCell r113 = r110;
        gd8.g r81 = (gd8.g) ((PromptCell) r113).j.getValue();
        if (r81 == null) goto L222;
        gd8.g.a.a(r81, r80, "onboarding_first_met", r73, null, null, null, 56);
    L222:
        r70 = r113;
        goto L248
    L182:
        if (r74 != null) goto L184;
        String r212 = "";
    L185:
        r73.add(new ai8.h(r212, null, null, null, r78, null, false, false, r110.w(), null, 750));
        goto L186
    L184:
        r212 = r74;
        goto L185
    L171:
        r77 = null;
        goto L172
    L192:
        r113 = r110;
        ArrayList r82 = new ArrayList();
        String r83 = r56.d();
        Pair[] r84 = new Pair[2];
        r84[0] = TuplesKt.to("onboarding_card_id", String.valueOf(r56.k()));
        OnboardingActionCardData.CardType r85 = r56.e();
        if (r85 == null) goto L195;
        String r86 = r85.toTea();
    L196:
        if (r86 != null) goto L198;
        r86 = "";
    L198:
        r84[1] = TuplesKt.to("sec_scene", r86);
        Map r87 = com.larus.utils.h.c(r111, r84);
        if (com.larus.utils.o0.d(r56.c()) == false) goto L210;
        String r213 = r56.c();
        Integer r88 = r56.g();
        if (r88 == null) goto L203;
        int r114 = r88.intValue();
    L204:
        Integer r214 = Integer.valueOf(r114);
        Integer r89 = r56.h();
        if (r89 == null) goto L207;
        int r115 = r89.intValue();
    L208:
        r82.add(new ai8.e("", r213, r214, Integer.valueOf(r115), null, null, null, null, r87, null, false, r113.w(), null, null, 28144));
        goto L210
    L207:
        r115 = 0;
        goto L208
    L203:
        r114 = 0;
    L210:
        if (com.larus.utils.o0.d(r83) == true) goto L212;
    L216:
        com.larus.bmhome.chat.component.cvs.y r90 = r113.z();
        if (r90 == null) goto L219;
        r20 = r90.h();
    L219:
        String r116 = r20;
        gd8.g r117 = (gd8.g) ((PromptCell) r113).j.getValue();
        if (r117 == null) goto L222;
        gd8.g.a.a(r117, r116, "onboarding_first_met", r82, null, null, null, 56);
        goto L222
    L212:
        if (r83 != null) goto L214;
        String r215 = "";
    L215:
        r82.add(new ai8.h(r215, null, null, null, r87, null, false, false, r113.w(), null, 750));
        goto L216
    L214:
        r215 = r83;
        goto L215
    L195:
        r86 = null;
        goto L196
    L223:
        String r91 = r56.d();
        if (r91 != null) goto L226;
        String r118 = "";
    L227:
        String r119 = String.valueOf(r56.k());
        OnboardingActionCardData.CardType r92 = r56.e();
        if (r92 == null) goto L230;
        r20 = r92.toTea();
    L230:
        if (r20 != null) goto L232;
        String r120 = "";
    L233:
        r70 = r110;
        PromptCell.P(r110, r15, null, null, r118, "", r119, r120, r111, null, 260);
        goto L248
    L232:
        r120 = r20;
        goto L233
    L226:
        r118 = r91;
        goto L227
    L234:
        r70 = r110;
        if (com.larus.utils.o0.d(r56.i()) == false) goto L237;
        SmartRouter.buildRoute(lf8.a.getContext(r70), r56.i()).d();
        r112 = false;
        goto L249
    L237:
        String r93 = r56.d();
        if (r93 != null) goto L240;
        String r121 = "";
    L241:
        String r122 = String.valueOf(r56.k());
        OnboardingActionCardData.CardType r94 = r56.e();
        if (r94 == null) goto L244;
        r20 = r94.toTea();
    L244:
        if (r20 != null) goto L246;
        String r123 = "";
    L247:
        PromptCell.P(r70, r15, null, null, r121, "", r122, r123, r111, null, 260);
        goto L248
    L246:
        r123 = r20;
        goto L247
    L240:
        r121 = r93;
        goto L241
    L155:
        r63 = null;
    L256:
        return Unit.INSTANCE;
    }
}
