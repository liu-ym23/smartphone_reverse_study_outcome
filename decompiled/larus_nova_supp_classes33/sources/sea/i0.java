package sea;

import android.app.Application;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.nova.NovaApplication;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.live.api.ObricLiveCardStrategy;
import com.obric.assistant.live.template.IObricTemplate;
import com.obric.assistant.live.template.ObricAINotificationDescription;
import com.obric.assistant.live.template.ObricAINotificationTemplate;
import com.obric.assistant.live.template.ObricAINotificationTemplateIcon;
import com.obric.assistant.live.template.ObricAINotificationTemplateText;
import com.obric.assistant.live.template.ObricCommonCollapsedTemplate;
import com.obric.assistant.live.template.ObricComplexTaskExpandedTemplate;
import com.obric.assistant.live.template.ObricComplexTaskNormalExpandedTemplate;
import com.obric.assistant.live.template.ObricComplexTaskOperatingCollapseTemplate;
import com.obric.assistant.live.template.ObricComplexTaskOperatingExpandedTemplate;
import com.obric.assistant.live.template.ObricExpandedDialogueActionButton;
import com.obric.assistant.live.template.ObricExpandedDialogueTemplate;
import com.obric.assistant.live.template.ObricExpandedDialogueTitle;
import com.obric.assistant.live.template.ObricExpandedTemplate;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.RuntimeState;
import com.obric.livecard.api.entity.Text;
import com.obric.livecard.api.entity.TextIconStyle;
import com.obric.livecard.api.utils.ResourceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricInteractionScene.values().length];
            r0[ObricInteractionScene.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L78:
            r0[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L88:
            r0[ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L58:
            r0[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L60:
            r0[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L12:
            a = r0;
            int[] r1 = new int[ObricIslandStateType.values().length];
            r1[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L50:
            r1[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L64:
            r1[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L74:
            r1[ObricIslandStateType.TTS_PLAYING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L80:
            r1[ObricIslandStateType.TTS_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L52:
            r1[ObricIslandStateType.COMPLEX_TASK_THINK_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L66:
            r1[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L86:
            r1[ObricIslandStateType.REALTIME_CALL_CONNECTING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L56:
            r1[ObricIslandStateType.REALTIME_CALL_PAUSED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L62:
            r1[ObricIslandStateType.REALTIME_CALL_WAITING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L44
        L76:
            r1[ObricIslandStateType.REALTIME_CALL_LISTENING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L45
        L54:
            r1[ObricIslandStateType.REALTIME_CALL_THINKING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L46
        L70:
            r1[ObricIslandStateType.REALTIME_CALL_SPEAKING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L47
        L72:
            r1[ObricIslandStateType.REALTIME_CALL_WAITING_HELLO.ordinal()] = 14;     // Catch: NoSuchFieldError -> L48
        L84:
            r1[ObricIslandStateType.COMPLEX_TASK_COMPLETED.ordinal()] = 15;     // Catch: NoSuchFieldError -> L49
        L28:
            b = r1;
        }
    }

    public static final IObricTemplate d(ObricState r22) {
        Intrinsics.checkNotNullParameter(r22, "<this>");
        ObricInteractionScene r0 = r22.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 5) goto L35;
        ObricLiveCardStrategy.a.getClass();
        if (ObricLiveCardStrategy.C() == false) goto L23;
        ObricIslandStateType r2 = r22.getCurrentIslandState();
        int r3 = a.b[r2.ordinal()];
        if (r3 == 4) goto L21;
        if (r3 == 5) goto L21;
        if (r3 == 6) goto L17;
        if (r3 == 7) goto L16;
        Icon r10 = h.t();
        return new ObricCommonCollapsedTemplate(null, j0.a(r22), r10, null, 9, null);
    L16:
        Icon r4 = h.t();
        return new ObricCommonCollapsedTemplate(j(r22), null, r4, null, 10, null);
    L17:
        ILiveCard r5 = ILiveCard.Companion.getInst();
        gd9.i r6 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r6);
        NovaApplication r7 = r6.getApplication();
        r7.getClass();
        if (r5.getVersion(r7) < 10) goto L20;
        Icon r8 = h.t();
        return new ObricCommonCollapsedTemplate(new Icon(20, 20, "lottie:auto_processing_overlay", null, null, null, null, false, null, null, null, 2040, null), null, r8, null, 10, null);
    L20:
        Icon r14 = h.t();
        return new ObricCommonCollapsedTemplate(null, j0.a(r22), r14, null, 9, null);
    L21:
        Icon r9 = h.u();
        return new ObricCommonCollapsedTemplate(h.b(r22), null, r9, null, 10, null);
    L23:
        ObricIslandStateType r11 = r22.getCurrentIslandState();
        int r12 = a.b[r11.ordinal()];
        if (r12 == 4) goto L34;
        if (r12 == 5) goto L34;
        if (r12 == 6) goto L30;
        if (r12 == 7) goto L29;
        Icon r13 = h.t();
        return new ObricCommonCollapsedTemplate(null, j0.a(r22), r13, null, 9, null);
    L29:
        Icon r15 = h.t();
        return new ObricComplexTaskOperatingCollapseTemplate(j(r22), null, r15, null, 10, null);
    L30:
        ILiveCard r16 = ILiveCard.Companion.getInst();
        gd9.i r17 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r17);
        NovaApplication r18 = r17.getApplication();
        r18.getClass();
        if (r16.getVersion(r18) < 10) goto L33;
        Icon r19 = h.t();
        return new ObricCommonCollapsedTemplate(new Icon(20, 20, "lottie:auto_processing_overlay", null, null, null, null, false, null, null, null, 2040, null), null, r19, null, 10, null);
    L33:
        Icon r110 = h.t();
        return new ObricCommonCollapsedTemplate(null, j0.a(r22), r110, null, 9, null);
    L34:
        Icon r20 = h.u();
        return new ObricCommonCollapsedTemplate(h.b(r22), null, r20, null, 10, null);
    L35:
        Icon r21 = h.b(r22);
        if (r21 != null) goto L49;
        Icon r23 = h.u();
        return new ObricCommonCollapsedTemplate(null, j0.b(r22), r23, null, 9, null);
    L49:
        return new ObricCommonCollapsedTemplate(r21, null, h.u(), null, 10, null);
    L5:
        r1 = a.a[r0.ordinal()];
        goto L7
    }

    public static final ObricExpandedDialogueTemplate e(ObricState r47) {
        Intrinsics.checkNotNullParameter(r47, "<this>");
        if (r47.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_CALL_USER) goto L5;
        ObricExpandedDialogueActionButton r0 = k(r47);
    L7:
        if (r47.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L12;
        if (j0.j(r47) == false) goto L12;
        r0 = k(r47);
    L12:
        if (r47.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L36;
        int r6 = 0;
        if (Intrinsics.areEqual(r47.getExt().get("is_call_for_me_ask_user"), "1") == false) goto L18;
        ResourceUtils r15 = ResourceUtils.INSTANCE;
        AppHost.Companion r17 = AppHost.a;
        List r2 = CollectionsKt.listOf(new ObricExpandedDialogueActionButton[]{new ObricExpandedDialogueActionButton("call_for_me_reply", new Icon(18, 18, r15.getDrawable(r17.getApplication().getApplicationContext(), 2131238012), null, null, null, null, false, null, null, null, 2040, null), new Text(r17.getApplication().getString(2131912057), 14, "#E5FFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), null, "#29ffffff", null, 32, null), new ObricExpandedDialogueActionButton("call_for_me_call", new Icon(18, 18, r15.getDrawable(r17.getApplication().getApplicationContext(), 2131238011), null, null, null, null, false, null, null, null, 2040, null), new Text(r17.getApplication().getString(2131912056), 14, "#E5FFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), null, "#29ffffff", null, 32, null)});
    L16:
        ObricExpandedDialogueActionButton r8 = r0;
        List r9 = r2;
    L37:
        AppHost.Companion r1 = AppHost.a;
        Application r3 = r1.getApplication();
        ObricIslandStateType r4 = r47.getCurrentIslandState();
        ObricIslandStateType r5 = ObricIslandStateType.COMPLEX_TASK_CALL_USER;
        if (r4 != r5) goto L41;
        int r7 = 2131912205;
    L46:
        String r11 = r3.getString(r7);
        if (r47.getCurrentIslandState() != r5) goto L50;
        Object r10 = r47.getExt().get("o_complex_call_user_content");
    L56:
        if (Intrinsics.areEqual(r47.getExt().get("o_block_decision_source"), "1") == false) goto L58;
        Text r12 = new Text(r1.getApplication().getString(2131912214), 12, "#8F9BB2", null, null, null, null, new ColorToken(2131103870, 2131103870), ApWakeEvent.WALKING_START, null);
    L60:
        return new ObricExpandedDialogueTemplate(new ObricExpandedDialogueTitle(new Icon(20, 20, ResourceUtils.INSTANCE.getDrawable(r1.getApplication().getApplicationContext(), 2131244354), null, null, null, null, false, null, null, null, 2040, null), new Text(r11, 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null)), r8, r9, new Text(String.valueOf(r10), 16, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), new Text("“" + r47.getExt().get("origin_query") + 8221, 14, "#A8FFFFFF", null, null, null, null, d.a(), ApWakeEvent.WALKING_START, null), r12);
    L58:
        r12 = null;
        goto L60
    L50:
        if (r47.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L52;
    L54:
        r10 = r47.getExt().get("clarify_message_content");
        goto L56
    L52:
        if (j0.j(r47) == false) goto L54;
        r10 = j0.c(r47);
        goto L56
    L41:
        if (r47.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L43;
    L45:
        r7 = 2131911902;
        goto L46
    L43:
        if (j0.j(r47) == false) goto L45;
        r7 = 2131912044;
        goto L46
    L18:
        if (r47.getExt().get("o_complex_clarify_candidate") == null) goto L35;
        Object r13 = r47.getExt().get("o_complex_clarify_candidate");
        if ((r13 instanceof Object[]) == false) goto L22;
        Object[] r14 = (Object[]) r13;
    L23:
        if (r14 == null) goto L28;
        ArrayList r16 = new ArrayList(r14.length);
        int r18 = r14.length;
        int r19 = 0;
    L25:
        if (r19 >= r18) goto L27;
        r16.add(String.valueOf(r14[r19]));
        r19 = r19 + 1;
        goto L25
    L27:
        String[] r20 = (String[]) r16.toArray(new String[0]);
    L29:
        if (r20 == null) goto L34;
        ArrayList r21 = new ArrayList(r20.length);
        int r22 = r20.length;
        int r23 = 0;
    L31:
        if (r6 >= r22) goto L33;
        r21.add(new ObricExpandedDialogueActionButton("gui_clarify_btn_" + r23, new Icon(18, 18, ResourceUtils.INSTANCE.getDrawable(AppHost.a.getApplication().getApplicationContext(), 2131238012), null, null, null, null, false, null, null, null, 2040, null), new Text(r20[r6], 14, "#E5FFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), null, "#29ffffff", null, 32, null));
        r6 = r6 + 1;
        r23 = r23 + 1;
        goto L31
    L33:
        r2 = CollectionsKt.toList(r21);
        goto L16
    L34:
        r0 = k(r47);
        goto L36
    L28:
        r20 = null;
        goto L29
    L22:
        r14 = null;
        goto L23
    L35:
        r0 = k(r47);
    L36:
        r8 = r0;
        r9 = null;
        goto L37
    L5:
        r0 = null;
        goto L7
    }

    public static final IObricTemplate f(ObricState r21) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        ObricLiveCardStrategy.a.getClass();
        if (ObricLiveCardStrategy.C() == false) goto L11;
        List<Button> r4 = h.g(r21);
        List<ButtonV2> r0 = h.f(r21);
        ObricExpandedDialogueTemplate r12 = e(r21);
        Icon r6 = h.q(r21);
        Text r7 = j0.i(r21);
        Text r5 = j0.h(r21);
        if ((!r0.isEmpty()) == false) goto L7;
        List<ButtonV2> r9 = r0;
    L9:
        return new ObricComplexTaskExpandedTemplate(r12, new ObricComplexTaskNormalExpandedTemplate(r4, r5, r6, r7, null, r9, 16, null), null, 4, null);
    L7:
        r9 = null;
        goto L9
    L11:
        if (a.b[r21.getCurrentIslandState().ordinal()] != 7) goto L17;
        List r8 = CollectionsKt.listOf(n(r21));
        List r1 = CollectionsKt.listOf(o(r21));
        Icon r10 = h.q(r21);
        Text r11 = j0.i(r21);
        Text r13 = j0.h(r21);
        if ((!r1.isEmpty()) == false) goto L15;
        List r14 = r1;
    L23:
        return new ObricComplexTaskOperatingExpandedTemplate(r8, r13, r10, r11, null, r14, 16, null);
    L15:
        r14 = null;
        goto L23
    L17:
        List<Button> r15 = h.g(r21);
        List<ButtonV2> r2 = h.f(r21);
        ObricExpandedDialogueTemplate r16 = e(r21);
        Icon r17 = h.q(r21);
        Text r18 = j0.i(r21);
        Text r19 = j0.h(r21);
        if ((!r2.isEmpty()) == false) goto L20;
        List<ButtonV2> r110 = r2;
    L22:
        return new ObricComplexTaskExpandedTemplate(r16, new ObricComplexTaskNormalExpandedTemplate(r15, r19, r17, r18, null, r110, 16, null), null, 4, null);
    L20:
        r110 = null;
        goto L22
    }

    public static final ObricAINotificationTemplate g(ObricState r30) {
        Intrinsics.checkNotNullParameter(r30, "<this>");
        Intrinsics.checkNotNullParameter(r30, "<this>");
        int r8 = -1;
        if (com.obric.assistant.live.api.b.a(r30) == false) goto L6;
        List r2 = CollectionsKt.emptyList();
    L5:
        List r15 = r2;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        if (com.obric.assistant.live.api.b.a(r30) == false) goto L29;
        List r3 = CollectionsKt.emptyList();
    L49:
        Intrinsics.checkNotNullParameter(r30, "<this>");
        ObricInteractionScene r4 = r30.getScene();
        if (r4 != null) goto L52;
        int r5 = -1;
    L53:
        if (r5 != 1) goto L55;
        Icon r6 = h.r();
    L56:
        Icon r11 = r6;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        ObricInteractionScene r7 = r30.getScene();
        if (r7 != null) goto L59;
        int r9 = -1;
    L61:
        if (r9 != 1) goto L81;
        int r10 = h.a.a[r30.getCurrentIslandState().ordinal()];
        if (r10 == 1) goto L81;
        if (r10 == 2) goto L81;
        if (r10 == 3) goto L81;
        if (r10 == 4) goto L81;
        if (r10 != 5) goto L70;
        ResourceUtils r12 = ResourceUtils.INSTANCE;
        Object r13 = r30.getExt().get("o_gui_package_name");
        if (r13 == null) goto L78;
        String r14 = r13.toString();
        if (r14 == null) goto L78;
    L79:
        ObricAINotificationTemplateIcon r16 = new ObricAINotificationTemplateIcon(36, 36, "lottie:auto_progress_overlay_ai", null, null, "svg:right_arrow", r12.getApplicationIcon(r14), true, null, Boolean.TRUE, 4, 280, null);
    L80:
        ObricAINotificationTemplateIcon r17 = r16;
    L82:
        int r18 = j0.a;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        ObricInteractionScene r19 = r30.getScene();
        if (r19 != null) goto L85;
        int r20 = -1;
    L86:
        if (r20 != 5) goto L91;
        String r110 = String.valueOf(r30.getExt().get("origin_query"));
        if (o0.d(r110) == false) goto L90;
        ObricAINotificationTemplateText r21 = new ObricAINotificationTemplateText(r110, FlowRuntime.a().getApplication().getString(2131912038), 14, "#FFFFFFFF", "#FF000000", "500", 1, d.c());
    L92:
        ObricAINotificationTemplateText r111 = r21;
        Intrinsics.checkNotNullParameter(r30, "<this>");
        if (com.obric.assistant.live.api.b.a(r30) == false) goto L95;
        ObricAINotificationTemplateText r0 = j0.f();
    L146:
        ObricAINotificationDescription r112 = new ObricAINotificationDescription(null, r0, 1, null);
        if ((!r3.isEmpty()) == false) goto L149;
        List r113 = r3;
    L151:
        return new ObricAINotificationTemplate(r11, r17, r111, r112, r15, r113);
    L149:
        r113 = null;
        goto L151
    L95:
        ObricInteractionScene r1 = r30.getScene();
        if (r1 == null) goto L99;
        r8 = j0.a.b[r1.ordinal()];
    L99:
        if (r8 != 5) goto L145;
        ObricIslandStateType r22 = r30.getCurrentIslandState();
        int[] r23 = j0.a.a;
        switch(r23[r22.ordinal()]) {
            case 4: goto L104;
            case 5: goto L104;
            case 6: goto L104;
            case 7: goto L104;
            case 8: goto L104;
            case 9: goto L104;
            case 10: goto L102;
            case 11: goto L104;
            default: goto L102;
        };
    L102:
        r0 = j0.f();
        goto L146
    L104:
        if (r30.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L106;
    L109:
        Object r24 = r30.getExt().get("o_task_current_step_detail");
        if (r24 == null) goto L118;
        String r25 = r24.toString();
        if (r25 == null) goto L118;
        if ((!StringsKt.isBlank(r25)) == true) goto L117;
        r25 = null;
    L117:
        if (r25 == null) goto L118;
    L108:
        String r114 = r25;
        if (o0.d(r114) == false) goto L144;
        int r26 = r23[r30.getCurrentIslandState().ordinal()];
        if (r26 != 6) goto L133;
        String r27 = FlowRuntime.a().getApplication().getString(2131912037);
        Intrinsics.checkNotNull(r27);
    L143:
        r0 = new ObricAINotificationTemplateText(r114, r27, 14, "#E6FFFFFF", "#E6000000", null, 3, d.b(), 32, null);
        goto L146
    L133:
        if (r26 != 8) goto L135;
        r27 = FlowRuntime.a().getApplication().getString(2131912036);
        Intrinsics.checkNotNull(r27);
        goto L143
    L135:
        if (r26 == 9) goto L138;
        r27 = FlowRuntime.a().getApplication().getString(2131912035);
        Intrinsics.checkNotNull(r27);
        goto L143
    L138:
        if (j0.j(r30) == false) goto L140;
        r27 = FlowRuntime.a().getApplication().getString(2131912034);
        Intrinsics.checkNotNull(r27);
        goto L143
    L140:
        r27 = FlowRuntime.a().getApplication().getString(2131912035);
        Intrinsics.checkNotNull(r27);
        goto L143
    L144:
        r0 = j0.f();
    L118:
        Object r28 = r30.getExt().get("o_task_current_step_description");
        if (r28 == null) goto L125;
        r25 = r28.toString();
        if (r25 == null) goto L125;
        if ((!StringsKt.isBlank(r25)) == false) goto L125;
    L126:
        if (r25 != null) goto L108;
        r25 = FlowRuntime.a().getApplication().getString(2131912050);
    L125:
        r25 = null;
        goto L126
    L106:
        if (j0.j(r30) == false) goto L109;
        r25 = j0.c(r30);
        goto L108
    L145:
        r0 = j0.f();
        goto L146
    L90:
        r21 = j0.f();
        goto L92
    L91:
        r21 = j0.f();
        goto L92
    L85:
        r20 = j0.a.b[r19.ordinal()];
    L78:
        r14 = "";
        goto L79
    L70:
        if (r30.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L72;
        Boolean r29 = Boolean.TRUE;
    L73:
        r16 = h.s(r29);
        goto L80
    L72:
        r29 = null;
    L81:
        r17 = null;
        goto L82
    L59:
        r9 = h.a.b[r7.ordinal()];
        goto L61
    L55:
        r6 = h.p();
        goto L56
    L52:
        r5 = h.a.b[r4.ordinal()];
        goto L53
    L29:
        ObricLiveCardStrategy.a.getClass();
        if (ObricLiveCardStrategy.C() == true) goto L32;
        r3 = CollectionsKt.emptyList();
        goto L49
    L32:
        ObricInteractionScene r31 = r30.getScene();
        if (r31 != null) goto L35;
        int r32 = -1;
    L36:
        if (r32 != 1) goto L48;
        int r33 = h.a.a[r30.getCurrentIslandState().ordinal()];
        if (r33 == 3) goto L47;
        if (r33 != 4) goto L41;
        r3 = CollectionsKt.listOf(new ButtonV2(null, new Text(AppHost.a.getApplication().getString(2131912230), 0, null, null, null, null, null, null, 254, null), 40, 308, "svg:reply", null, null, null, null, null, null, 1985, null));
        goto L49
    L41:
        if (r30.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L43;
    L45:
        r3 = CollectionsKt.emptyList();
        goto L49
    L43:
        if (j0.j(r30) == false) goto L45;
        r3 = CollectionsKt.listOf(new ButtonV2(null, new Text(AppHost.a.getApplication().getString(2131912213), 0, null, null, null, null, null, null, 254, null), 40, 308, "svg:right_arrow", Boolean.TRUE, null, null, null, null, null, 1985, null));
        goto L49
    L47:
        r3 = CollectionsKt.listOf(new ButtonV2(null, new Text(AppHost.a.getApplication().getString(2131912229), 0, null, null, null, null, null, null, 254, null), 40, 308, "svg:right_arrow", Boolean.TRUE, null, null, null, null, null, 1985, null));
        goto L49
    L48:
        r3 = CollectionsKt.emptyList();
        goto L49
    L35:
        r32 = h.a.b[r31.ordinal()];
        goto L36
    L6:
        ObricLiveCardStrategy.a.getClass();
        if (ObricLiveCardStrategy.C() == true) goto L9;
        r2 = CollectionsKt.emptyList();
        goto L5
    L9:
        ObricInteractionScene r34 = r30.getScene();
        if (r34 != null) goto L12;
        int r35 = -1;
    L13:
        if (r35 != 1) goto L25;
        int r36 = h.a.a[r30.getCurrentIslandState().ordinal()];
        if (r36 == 3) goto L24;
        if (r36 != 4) goto L18;
        r2 = CollectionsKt.listOf(new Button(40, 308, "", "svg:reply", null, new TextIconStyle("#0F000000", 14, "#FFFFFFFF", "#FF000000", null, 16, null), null, AppHost.a.getApplication().getString(2131912230), null, 320, null));
        goto L5
    L18:
        if (r30.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L20;
    L22:
        r2 = CollectionsKt.emptyList();
        goto L5
    L20:
        if (j0.j(r30) == false) goto L22;
        String r115 = AppHost.a.getApplication().getString(2131912213);
        r2 = CollectionsKt.listOf(new Button(40, 308, "", "svg:right_arrow", Boolean.TRUE, new TextIconStyle("#0F000000", 14, "#FFFFFFFF", "#FF000000", null, 16, null), null, r115, null, 320, null));
        goto L5
    L24:
        String r116 = AppHost.a.getApplication().getString(2131912229);
        r2 = CollectionsKt.listOf(new Button(40, 308, "", "svg:right_arrow", Boolean.TRUE, new TextIconStyle("#0F000000", 14, "#FFFFFFFF", "#FF000000", null, 16, null), null, r116, null, 320, null));
        goto L5
    L25:
        r2 = CollectionsKt.emptyList();
        goto L5
    L12:
        r35 = h.a.b[r34.ordinal()];
        goto L13
    }

    public static final ObricExpandedTemplate h(ObricState r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<Button> r2 = h.g(r10);
        List<ButtonV2> r0 = h.f(r10);
        Icon r4 = h.q(r10);
        Text r5 = j0.i(r10);
        Text r3 = j0.h(r10);
        if ((!r0.isEmpty()) == false) goto L5;
        List<ButtonV2> r7 = r0;
    L7:
        return new ObricExpandedTemplate(r2, r3, r4, r5, null, r7, 16, null);
    L5:
        r7 = null;
        goto L7
    }

    public static final String i(String r2) {
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("pkg", r2).appendQueryParameter("type", "app_icon").build().toString();
    }

    public static final Icon j(ObricState r15) {
        Object r16 = r15.getExt().get("o_gui_package_name");
        if (r16 == null) goto L8;
        String r17 = r16.toString();
        if (r17 != null) goto L7;
        return null;
    L7:
        return new Icon(20, 20, "lottie:auto_processing_overlay", null, null, null, i(r17), true, null, null, null, 1848, null);
    L8:
        return null;
    }

    public static final ObricExpandedDialogueActionButton k(ObricState r39) {
        ObricIslandStateType r0 = r39.getCurrentIslandState();
        int r1 = a.b[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L10;
        return null;
    L10:
        if (j0.j(r39) == true) goto L12;
        return null;
    L12:
        Icon r2 = new Icon(18, 18, "svg:button_hand", null, null, "svg:button_hand", null, false, null, null, null, 2008, null);
        gd9.i r3 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r3);
        return new ObricExpandedDialogueActionButton("actionBtn", r2, new Text(r3.getApplication().getString(2131912213), 14, "var:ai-gradient-a3", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), null, "var:ai-gradient-a3-lighter", null, 32, null);
    L17:
        return new ObricExpandedDialogueActionButton("actionBtn", new Icon(18, 18, "svg:reply_pink", null, null, "svg:reply_pink", null, false, null, null, null, 2008, null), new Text(AppHost.a.getApplication().getString(2131912058), 14, "var:ai-gradient-a3", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), null, "var:ai-gradient-a3-lighter", null, 32, null);
    L15:
        return new ObricExpandedDialogueActionButton("actionBtn", new Icon(18, 18, "svg:button_hand", null, null, "svg:button_hand", null, false, null, null, null, 2008, null), new Text(AppHost.a.getApplication().getString(2131911916), 14, "var:ai-gradient-a3", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null), null, "var:ai-gradient-a3-lighter", null, 32, null);
    }

    public static final RuntimeState l(ObricState r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ObricIslandStateType r0 = r2.getCurrentIslandState();
        int r1 = a.b[r0.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L13;
        if (r1 == 15) goto L19;
        return RuntimeState.PROCESSING;
    L19:
        return RuntimeState.FINISHED;
    L13:
        if (j0.j(r2) == false) goto L21;
        return RuntimeState.ANSWER;
    L21:
        return RuntimeState.PROCESSING;
    L17:
        return RuntimeState.ANSWER;
    }

    public static final String m(ObricState r3) {
        Intrinsics.checkNotNullParameter(r3, "obricState");
        if (r3.getScene() == ObricInteractionScene.COMPLEX_TASK_SCENE) goto L5;
        return null;
    L5:
        Object r4 = r3.getExt().get("o_last_reply_message_id");
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.toString();
    }

    public static final Button n(ObricState r13) {
        Intrinsics.checkNotNullParameter(r13, "obricState");
        Boolean r6 = Boolean.TRUE;
        Object r14 = r13.getExt().get("o_gui_package_name");
        if (r14 == null) goto L6;
        String r15 = r14.toString();
        if (r15 == null) goto L6;
    L8:
        return new Button(40, 40, "lottie:auto_processing_overlay", "svg:right_arrow", r6, null, i(r15), null, null, 416, null);
    L6:
        r15 = "";
        goto L8
    }

    public static final ButtonV2 o(ObricState r14) {
        Intrinsics.checkNotNullParameter(r14, "obricState");
        Object r15 = r14.getExt().get("o_gui_package_name");
        if (r15 == null) goto L6;
        String r16 = r15.toString();
        if (r16 == null) goto L6;
    L7:
        String r7 = i(r16);
        return new ButtonV2("lottie:auto_processing_overlay", null, 40, 40, "svg:right_arrow", Boolean.TRUE, r7, null, null, null, null, 1922, null);
    L6:
        r16 = "";
        goto L7
    }

    public static final long p(ObricInteractionScene r7) {
        if (r7 != null) goto L6;
        return 0;
    L6:
        if (r7 == ObricInteractionScene.REALTIME_CALL_SCENE) goto L8;
        return 256;
    L8:
        boolean r8 = com.obric.assistant.live.api.j.a.s(r7);
        FLogger.a.i("ObricLiveDelegate", "getRequestDismissKeyguardFlags, permission: " + r8);
        if (r8 == false) goto L12;
        return 0;
    L12:
        return 256;
    }

    public static final long q(ObricState r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ObricInteractionScene r0 = r5.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L41;
        if (r1 == 2) goto L44;
        if (r1 == 3) goto L44;
        if (r1 != 4) goto L15;
        long r2 = p(r5.getScene());
    L43:
        return r2 | 4096;
    L15:
        if (r1 != 5) goto L42;
        ObricIslandStateType r3 = r5.getCurrentIslandState();
        int r4 = a.b[r3.ordinal()];
        if (r4 == 1) goto L31;
        if (r4 == 2) goto L31;
        if (r4 == 3) goto L23;
        r2 = p(r5.getScene());
        goto L43
    L23:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L25;
    L29:
        r2 = p(r5.getScene());
        goto L43
    L25:
        if (j0.j(r5) == false) goto L29;
        gd9.i r6 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r6);
        if (r6.a().e == false) goto L29;
        long r7 = p(r5.getScene());
    L35:
        r2 = r7 | 8;
    L31:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == true) goto L36;
        gd9.i r8 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r8);
        if (r8.a().e == false) goto L36;
        r7 = p(r5.getScene());
    L36:
        r2 = p(r5.getScene());
        goto L43
    L42:
        return p(r5.getScene());
    L44:
        return p(r5.getScene());
    L41:
        return p(r5.getScene());
    L5:
        r1 = a.a[r0.ordinal()];
        goto L7
    }

    public static final void a(final ObricState r10, IslandWidget r11) {
        Intrinsics.checkNotNullParameter(r10, "obricState");
        Intrinsics.checkNotNullParameter(r11, "widget");
        r11.getOnClickCallback().clear();
        String[] r0 = null;
        r11.setOnCardClickCallback(null);
        r11.addOnViewClickCallback("svg:right_arrow", new j(r10));
        r11.addOnViewClickCallback("svg:stop_play", new m());
        final sea.a r1 = new sea.a(new n(r10));
        r11.addOnViewClickCallback("actionBtn", new o(r1));
        if (r10.getCurrentIslandState() == ObricIslandStateType.COMPLEX_TASK_ASK_USER) goto L5;
    L20:
        final sea.a r2 = new sea.a(new r());
        r11.addOnViewClickCallback("svg:reply", new s(r2));
        r11.addOnViewClickCallback("call_for_me_reply", new u(r1));
        final sea.a r3 = new sea.a(new v());
        r11.addOnViewClickCallback("call_for_me_call", new k(r3));
        r11.setOnCardClickCallback(new l(r10));
        return;
    L5:
        if (r10.getExt().get("o_complex_clarify_candidate") == null) goto L20;
        Object r4 = r10.getExt().get("o_complex_clarify_candidate");
        if ((r4 instanceof Object[]) == false) goto L9;
        Object[] r5 = (Object[]) r4;
    L10:
        int r6 = 0;
        if (r5 == null) goto L16;
        ArrayList r7 = new ArrayList(r5.length);
        int r8 = r5.length;
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L15;
        r7.add(String.valueOf(r5[r9]));
        r9 = r9 + 1;
        goto L13
    L15:
        r0 = (String[]) r7.toArray(new String[0]);
    L16:
        if (r0 == null) goto L20;
        int r12 = r0.length;
        final int r13 = 0;
    L18:
        if (r6 >= r12) goto L20;
        final String r14 = r0[r6];
        final sea.a r15 = new sea.a(new p(r13, r10, r14));
        FLogger.a.i("ObricStateIslandUtils", "clarify candidate addOnViewClickCallback " + r13);
        r11.addOnViewClickCallback("gui_clarify_btn_" + r13, new q(r15));
        r6 = r6 + 1;
        r13 = r13 + 1;
        goto L18
    L9:
        r5 = null;
        goto L10
    }

    public static final void b(final ObricState r2, IslandWidget r3) {
        Intrinsics.checkNotNullParameter(r2, "obricState");
        Intrinsics.checkNotNullParameter(r3, "widget");
        r3.getOnClickCallback().clear();
        r3.setOnCardClickCallback(null);
        r3.addOnViewClickCallback("svg:right_arrow", new c0(r2));
        final sea.a r0 = new sea.a(new d0());
        r3.addOnViewClickCallback("svg:reply", new e0(r0));
        r3.setOnCardClickCallback(new f0(r2));
    }

    public static final void c(String r5, ObricInteractionScene r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (r5 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        FLogger.a.i("ObricStateIslandUtils", "cachePendingComplexTaskTargetMessage skipped, scene=" + r6 + ", targetMessageId is empty");
        return;
    L13:
        String r1 = "live_service:" + r6.name().toLowerCase(Locale.ROOT);
        e.e(r5, r1);
        FLogger.a.i("ObricStateIslandUtils", "cachePendingComplexTaskTargetMessage success, scene=" + r6 + ", targetMessageId=" + r5 + ", source=" + r1);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r0 = false;
        goto L10
    }
}
