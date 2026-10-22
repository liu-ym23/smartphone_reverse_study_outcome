package sea;

import com.larus.common.apphost.AppHost;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.live.api.ObricLiveCardStrategy;
import com.obric.assistant.live.template.ObricAINotificationTemplateIcon;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.utils.ResourceUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricIslandStateType.values().length];
            r0[ObricIslandStateType.TTS_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L84:
            r0[ObricIslandStateType.TTS_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L94:
            r0[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L100:
            r0[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L104:
            r0[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L42
        L108:
            r0[ObricIslandStateType.CLICK_TALK_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L43
        L116:
            r0[ObricIslandStateType.CLICK_TALK_ASR_START.ordinal()] = 7;     // Catch: NoSuchFieldError -> L44
        L76:
            r0[ObricIslandStateType.MSG_START.ordinal()] = 8;     // Catch: NoSuchFieldError -> L45
        L86:
            r0[ObricIslandStateType.DEEP_THINK_START.ordinal()] = 9;     // Catch: NoSuchFieldError -> L46
        L88:
            r0[ObricIslandStateType.DEEP_THINK_END.ordinal()] = 10;     // Catch: NoSuchFieldError -> L47
        L96:
            r0[ObricIslandStateType.REALTIME_CALL_CONNECTING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L48
        L114:
            r0[ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR.ordinal()] = 12;     // Catch: NoSuchFieldError -> L49
        L120:
            r0[ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L50
        L66:
            r0[ObricIslandStateType.REALTIME_CALL_WAITING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L51
        L72:
            r0[ObricIslandStateType.REALTIME_CALL_LISTENING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L52
        L92:
            r0[ObricIslandStateType.REALTIME_CALL_THINKING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L53
        L98:
            r0[ObricIslandStateType.REALTIME_CALL_SPEAKING.ordinal()] = 17;     // Catch: NoSuchFieldError -> L54
        L102:
            r0[ObricIslandStateType.REALTIME_CALL_WAITING_HELLO.ordinal()] = 18;     // Catch: NoSuchFieldError -> L55
        L110:
            r0[ObricIslandStateType.REALTIME_CALL_PAUSED.ordinal()] = 19;     // Catch: NoSuchFieldError -> L56
        L70:
            r0[ObricIslandStateType.COMPLEX_TASK_THINK_START.ordinal()] = 20;     // Catch: NoSuchFieldError -> L57
        L80:
            r0[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 21;     // Catch: NoSuchFieldError -> L58
        L82:
            r0[ObricIslandStateType.COMPLEX_TASK_COMPLETED.ordinal()] = 22;     // Catch: NoSuchFieldError -> L59
        L90:
            r0[ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY.ordinal()] = 23;     // Catch: NoSuchFieldError -> L60
        L30:
            a = r0;
            int[] r1 = new int[ObricInteractionScene.values().length];
            r1[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L61
        L112:
            r1[ObricInteractionScene.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L62
        L118:
            r1[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L63
        L68:
            r1[ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L64
        L74:
            r1[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L65
        L36:
            b = r1;
        }
    }

    public static final Icon a() {
        return new Icon(20, 20, "lottie:audio_wave", null, null, null, null, false, null, null, null, 2040, null);
    }

    public static final Icon c() {
        if (ILiveCard.Companion.getInst().getVersion(AppHost.a.getApplication().getApplicationContext()) < 10) goto L5;
        String r0 = "svg:mic_off_without_bg_new";
    L7:
        return new Icon(20, 20, r0, null, null, null, null, false, null, null, null, 2040, null);
    L5:
        r0 = "svg:mic_off_without_bg";
        goto L7
    }

    public static final Icon d() {
        if (ILiveCard.Companion.getInst().getVersion(AppHost.a.getApplication().getApplicationContext()) < 10) goto L5;
        String r0 = "svg:mic_on_orange_new";
    L7:
        return new Icon(20, 20, r0, null, null, null, null, false, null, null, null, 2040, null);
    L5:
        r0 = "svg:mic_on_orange";
        goto L7
    }

    public static final Button h() {
        return new Button(40, 40, "svg:stop_play", "svg:stop_play", null, null, null, null, null, 496, null);
    }

    public static final ButtonV2 i() {
        return new ButtonV2("svg:stop_play", null, 40, 40, "svg:stop_play", null, null, null, null, null, null, 2018, null);
    }

    public static /* synthetic */ Button k() {
        return j(Boolean.valueOf(!ObricLiveServiceDelegate.b.a()));
    }

    public static final Button m() {
        return new Button(40, 40, "svg:mic_on", "svg:expand_mic_on", null, null, null, null, null, 496, null);
    }

    public static final ButtonV2 n() {
        return new ButtonV2("svg:mic_on_without_bg_new", null, 40, 40, "svg:expand_mic_on", null, null, null, new ColorToken(2131104347, 2131104347), d.e(), null, 1250, null);
    }

    public static final Icon o() {
        return new Icon(40, 40, ResourceUtils.INSTANCE.getDrawable(AppHost.a.getApplication().getApplicationContext(), 2131236091), null, null, null, null, false, null, null, null, 2040, null);
    }

    public static final Icon p() {
        return new Icon(40, 40, ResourceUtils.INSTANCE.getDrawable(AppHost.a.getApplication().getApplicationContext(), 2131244530), null, null, null, null, false, null, null, null, 1912, null);
    }

    public static final Icon r() {
        ResourceUtils r0 = ResourceUtils.INSTANCE;
        AppHost.Companion r3 = AppHost.a;
        return new Icon(36, 36, r0.getAssetsFile(r3.getApplication().getApplicationContext(), "ic_obric_live_island_complex_task_notification_left.svg", "svg"), null, null, null, null, false, r0.getAssetsFile(r3.getApplication().getApplicationContext(), "ic_obric_live_island_complex_task_notification_left.svg", "svg"), null, null, 1784, null);
    }

    public static final Icon t() {
        return new Icon(20, 20, ResourceUtils.INSTANCE.getDrawable(AppHost.a.getApplication().getApplicationContext(), 2131244354), null, null, null, null, false, null, null, null, 2040, null);
    }

    public static final Icon u() {
        return new Icon(24, 24, ResourceUtils.INSTANCE.getDrawable(AppHost.a.getApplication().getApplicationContext(), 2131244530), null, null, null, null, true, null, null, null, 1912, null);
    }

    public static final Icon b(ObricState r29) {
        Intrinsics.checkNotNullParameter(r29, "<this>");
        if (com.obric.assistant.live.api.b.a(r29) == false) goto L14;
        ObricIslandStateType r0 = r29.getCurrentIslandState();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L13;
        if (r1 == 6) goto L60;
        if (r1 == 7) goto L60;
        return null;
    L60:
        return d();
    L13:
        return a();
    L14:
        ObricInteractionScene r2 = r29.getScene();
        if (r2 != null) goto L17;
        int r3 = -1;
    L18:
        if (r3 == 1) goto L59;
        if (r3 != 2) goto L22;
        ObricIslandStateType r4 = r29.getCurrentIslandState();
        int r5 = a.a[r4.ordinal()];
        if (r5 == 1) goto L65;
        if (r5 == 2) goto L65;
        if (r5 == 8) goto L64;
        return null;
    L64:
        return new Icon(24, 24, "lottie:thinking", null, null, null, null, false, null, null, null, 2040, null);
    L65:
        return a();
    L22:
        if (r3 == 3) goto L63;
        if (r3 == 4) goto L63;
        if (r3 != 5) goto L66;
        ObricIslandStateType r6 = r29.getCurrentIslandState();
        switch(a.a[r6.ordinal()]) {
            case 11: goto L46;
            case 12: goto L46;
            case 13: goto L46;
            case 14: goto L39;
            case 15: goto L35;
            case 16: goto L33;
            case 17: goto L32;
            case 18: goto L32;
            case 19: goto L31;
            default: goto L48;
        };
    L31:
        Icon r7 = new Icon(20, 20, "svg:replay_pause", null, null, null, null, false, null, null, null, 2040, null);
    L62:
        return r7;
    L32:
        r7 = new Icon(20, 20, "lottie:replaying", null, null, null, null, false, null, null, null, 2040, null);
        goto L62
    L33:
        r7 = new Icon(20, 20, "svg:cloud_thinking", null, null, null, null, false, null, null, null, 2040, null);
        goto L62
    L46:
        r7 = new Icon(20, 20, "lottie:replaying", 0, 0, null, null, false, null, null, null, 2016, null);
        goto L62
    L48:
        r7 = new Icon(20, 20, "svg:mic_on_without_bg", null, null, null, null, false, null, null, null, 2040, null);
        goto L62
    L35:
        if (ObricLiveServiceDelegate.b.f() == false) goto L37;
        r7 = c();
        goto L62
    L37:
        r7 = d();
        goto L62
    L39:
        if (ObricLiveServiceDelegate.b.f() == false) goto L42;
        r7 = c();
        goto L62
    L42:
        if (ILiveCard.Companion.getInst().getVersion(AppHost.a.getApplication().getApplicationContext()) < 10) goto L44;
        String r8 = "svg:mic_on_without_bg_new";
    L45:
        r7 = new Icon(20, 20, r8, null, null, null, null, false, null, null, null, 2040, null);
        goto L62
    L44:
        r8 = "svg:mic_on_without_bg";
        goto L45
    L66:
        return null;
    L63:
        return e(r29);
    L59:
        return e(r29);
    L17:
        r3 = a.b[r2.ordinal()];
        goto L18
    }

    public static final Icon e(ObricState r29) {
        ObricIslandStateType r0 = r29.getCurrentIslandState();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L14;
        if (r1 == 9) goto L17;
        if (r1 == 10) goto L16;
        return null;
    L16:
        return new Icon(24, 24, "lottie:thinking_complete", 0, null, null, null, false, null, null, null, 2032, null);
    L17:
        return new Icon(24, 24, "lottie:thinking", null, null, null, null, false, null, null, null, 2040, null);
    L14:
        return a();
    }

    public static final List<ButtonV2> f(ObricState r35) {
        Intrinsics.checkNotNullParameter(r35, "<this>");
        if (com.obric.assistant.live.api.b.a(r35) == false) goto L16;
        int r0 = a.a[r35.getCurrentIslandState().ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L85;
        if (r0 == 6) goto L85;
        if (r0 == 7) goto L84;
        return CollectionsKt.emptyList();
    L84:
        return CollectionsKt.listOf(l(null));
    L85:
        return CollectionsKt.listOf(l(null));
    L15:
        return CollectionsKt.listOf(new ButtonV2[]{i(), l(null)});
    L16:
        ObricInteractionScene r1 = r35.getScene();
        if (r1 != null) goto L19;
        int r2 = -1;
    L21:
        if (r2 == 1) goto L66;
        if (r2 == 2) goto L61;
        if (r2 == 3) goto L51;
        if (r2 == 5) goto L27;
        return CollectionsKt.emptyList();
    L27:
        if (ObricLiveServiceDelegate.b.f() == false) goto L41;
        ButtonV2[] r3 = new ButtonV2[2];
        if (w(r35) == false) goto L31;
        String r5 = "svg:mic_off_with_bg";
    L32:
        String r12 = r5;
        if (w(r35) == false) goto L35;
        ColorToken r16 = new ColorToken(2131104373, 2131104373);
    L37:
        if (w(r35) == false) goto L39;
        ColorToken r4 = d.e();
    L40:
        r3[0] = new ButtonV2("svg:mic_off_without_bg_new", null, 40, 40, r12, null, null, null, r16, r4, null, 1250, null);
        r3[1] = new ButtonV2("svg:close_red", null, 40, 40, "svg:close_red", null, null, null, null, null, null, 2018, null);
        return CollectionsKt.listOf(r3);
    L39:
        r4 = new ColorToken(2131104351, 2131104351);
        goto L40
    L35:
        r16 = new ColorToken(2131104979, 2131104979);
        goto L37
    L31:
        r5 = "svg:expand_mic_off";
        goto L32
    L41:
        ButtonV2[] r6 = new ButtonV2[2];
        switch(a.a[r35.getCurrentIslandState().ordinal()]) {
            case 11: goto L49;
            case 12: goto L49;
            case 13: goto L49;
            case 14: goto L48;
            case 15: goto L47;
            case 16: goto L46;
            case 17: goto L45;
            case 18: goto L45;
            case 19: goto L44;
            default: goto L43;
        };
    L43:
        ButtonV2 r7 = n();
    L50:
        r6[0] = r7;
        r6[1] = new ButtonV2("svg:close_red", null, 40, 40, "svg:close_red", null, null, null, null, null, null, 2018, null);
        return CollectionsKt.listOf(r6);
    L44:
        r7 = new ButtonV2("svg:mic_on_without_bg_new", null, 40, 40, "svg:mic_on_with_bg_pause", null, null, null, new ColorToken(2131104373, 2131104373), d.e(), null, 1250, null);
        goto L50
    L45:
        r7 = n();
        goto L50
    L46:
        r7 = n();
        goto L50
    L47:
        r7 = new ButtonV2("svg:mic_on_without_bg_new", null, 40, 40, "svg:mic_on_orange_with_bg", null, null, null, new ColorToken(2131104915, 2131104915), d.e(), null, 1250, null);
        goto L50
    L48:
        r7 = n();
        goto L50
    L49:
        r7 = new ButtonV2("svg:mic_on_without_bg_new", null, 40, 40, "svg:mic_on_with_bg_pause", null, null, null, new ColorToken(2131104373, 2131104373), d.e(), null, 1250, null);
        goto L50
    L51:
        int r8 = a.a[r35.getCurrentIslandState().ordinal()];
        if (r8 == 1) goto L91;
        if (r8 == 2) goto L91;
        if (r8 == 9) goto L90;
        if (r8 == 10) goto L90;
        return CollectionsKt.emptyList();
    L90:
        return CollectionsKt.listOf(l(null));
    L91:
        return CollectionsKt.listOf(new ButtonV2[]{i(), l(null)});
    L61:
        int r9 = a.a[r35.getCurrentIslandState().ordinal()];
        if (r9 == 1) goto L93;
        if (r9 == 2) goto L93;
        return CollectionsKt.emptyList();
    L93:
        return CollectionsKt.listOf(new ButtonV2[]{i(), l(null)});
    L66:
        int r10 = a.a[r35.getCurrentIslandState().ordinal()];
        if (r10 == 1) goto L82;
        if (r10 == 2) goto L82;
        if (r10 == 3) goto L98;
        if (r10 == 4) goto L97;
        if (r10 == 5) goto L75;
        switch(r10) {
            case 20: goto L98;
            case 21: goto L98;
            case 22: goto L98;
            case 23: goto L98;
            default: goto L94;
        };
    L94:
        return CollectionsKt.emptyList();
    L75:
        ObricLiveCardStrategy.a.getClass();
        if (ObricLiveCardStrategy.C() == false) goto L96;
        return CollectionsKt.listOf(i0.o(r35));
    L96:
        return CollectionsKt.listOf(l(Boolean.valueOf(!ObricLiveServiceDelegate.b.a())));
    L97:
        return CollectionsKt.listOf(new ButtonV2("svg:reply", null, 40, 40, "svg:reply", null, null, null, null, null, null, 2018, null));
    L98:
        return CollectionsKt.listOf(l(Boolean.valueOf(!ObricLiveServiceDelegate.b.a())));
    L82:
        return CollectionsKt.listOf(new ButtonV2[]{i(), l(null)});
    L19:
        r2 = a.b[r1.ordinal()];
        goto L21
    }

    public static final List<Button> g(ObricState r30) {
        Intrinsics.checkNotNullParameter(r30, "<this>");
        if (com.obric.assistant.live.api.b.a(r30) == false) goto L16;
        int r0 = a.a[r30.getCurrentIslandState().ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L84;
        if (r0 == 6) goto L84;
        if (r0 == 7) goto L83;
        return CollectionsKt.emptyList();
    L83:
        return CollectionsKt.listOf(j(null));
    L84:
        return CollectionsKt.listOf(j(null));
    L15:
        return CollectionsKt.listOf(new Button[]{h(), j(null)});
    L16:
        ObricInteractionScene r1 = r30.getScene();
        if (r1 != null) goto L19;
        int r2 = -1;
    L21:
        if (r2 == 1) goto L66;
        if (r2 == 2) goto L58;
        if (r2 == 3) goto L48;
        if (r2 == 4) goto L48;
        if (r2 == 5) goto L28;
        return CollectionsKt.emptyList();
    L28:
        if (ObricLiveServiceDelegate.b.f() == false) goto L38;
        Button[] r3 = new Button[2];
        String r5 = "svg:mic_off_with_bg";
        if (w(r30) == false) goto L32;
        String r9 = "svg:mic_off_with_bg";
    L34:
        if (w(r30) == true) goto L37;
        r5 = "svg:expand_mic_off";
    L37:
        r3[0] = new Button(40, 40, r9, r5, null, null, null, null, null, 496, null);
        r3[1] = new Button(40, 40, "svg:close_red", "svg:close_red", null, null, null, null, null, 496, null);
        return CollectionsKt.listOf(r3);
    L32:
        r9 = "svg:mic_off";
        goto L34
    L38:
        Button[] r4 = new Button[2];
        switch(a.a[r30.getCurrentIslandState().ordinal()]) {
            case 11: goto L46;
            case 12: goto L46;
            case 13: goto L46;
            case 14: goto L45;
            case 15: goto L44;
            case 16: goto L43;
            case 17: goto L42;
            case 18: goto L42;
            case 19: goto L41;
            default: goto L40;
        };
    L40:
        Button r6 = m();
    L47:
        r4[0] = r6;
        r4[1] = new Button(40, 40, "svg:close_red", "svg:close_red", null, null, null, null, null, 496, null);
        return CollectionsKt.listOf(r4);
    L41:
        r6 = new Button(40, 40, "svg:mic_on_with_bg_pause", "svg:mic_on_with_bg_pause", null, null, null, null, null, 496, null);
        goto L47
    L42:
        r6 = m();
        goto L47
    L43:
        r6 = m();
        goto L47
    L44:
        r6 = new Button(40, 40, "svg:mic_on_orange_with_bg", "svg:mic_on_orange_with_bg", null, null, null, null, null, 496, null);
        goto L47
    L45:
        r6 = m();
        goto L47
    L46:
        r6 = new Button(40, 40, "svg:mic_on_with_bg_pause", "svg:mic_on_with_bg_pause", null, null, null, null, null, 496, null);
    L48:
        int r7 = a.a[r30.getCurrentIslandState().ordinal()];
        if (r7 == 1) goto L90;
        if (r7 == 2) goto L90;
        if (r7 == 9) goto L89;
        if (r7 == 10) goto L89;
        return CollectionsKt.emptyList();
    L89:
        return CollectionsKt.listOf(j(null));
    L90:
        return CollectionsKt.listOf(new Button[]{h(), j(null)});
    L58:
        int r8 = a.a[r30.getCurrentIslandState().ordinal()];
        if (r8 == 1) goto L93;
        if (r8 == 2) goto L93;
        if (r8 == 8) goto L92;
        return CollectionsKt.emptyList();
    L92:
        return CollectionsKt.listOf(k());
    L93:
        return CollectionsKt.listOf(new Button[]{h(), j(null)});
    L66:
        int r10 = a.a[r30.getCurrentIslandState().ordinal()];
        if (r10 == 1) goto L81;
        if (r10 == 2) goto L81;
        if (r10 == 3) goto L98;
        if (r10 == 4) goto L97;
        if (r10 == 5) goto L74;
        switch(r10) {
            case 20: goto L98;
            case 21: goto L98;
            case 22: goto L98;
            case 23: goto L98;
            default: goto L94;
        };
    L94:
        return CollectionsKt.emptyList();
    L74:
        ObricLiveCardStrategy.a.getClass();
        if (ObricLiveCardStrategy.C() == false) goto L96;
        return CollectionsKt.listOf(i0.n(r30));
    L96:
        return CollectionsKt.listOf(k());
    L97:
        return CollectionsKt.listOf(new Button(40, 40, "svg:reply", "svg:reply", null, null, null, null, null, 496, null));
    L98:
        return CollectionsKt.listOf(k());
    L81:
        return CollectionsKt.listOf(new Button[]{h(), j(null)});
    L19:
        r2 = a.b[r1.ordinal()];
        goto L21
    }

    public static final Button j(Boolean r13) {
        return new Button(40, 40, "svg:right_arrow", "svg:right_arrow", r13, null, null, null, null, 480, null);
    }

    public static final ButtonV2 l(Boolean r15) {
        return new ButtonV2("svg:right_arrow", null, 40, 40, "svg:right_arrow", r15, null, null, null, null, null, 1986, null);
    }

    public static final Icon q(ObricState r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ObricInteractionScene r0 = r2.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L15;
        ObricIslandStateType r3 = r2.getCurrentIslandState();
        int r4 = a.a[r3.ordinal()];
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L17;
        return o();
    L17:
        return p();
    L15:
        return p();
    L5:
        r1 = a.b[r0.ordinal()];
        goto L7
    }

    public static final ObricAINotificationTemplateIcon s(Boolean r19) {
        ResourceUtils r0 = ResourceUtils.INSTANCE;
        AppHost.Companion r1 = AppHost.a;
        return new ObricAINotificationTemplateIcon(36, 36, r0.getAssetsFile(r1.getApplication().getApplicationContext(), "obric_ic_island_notification_right_arrow.svg", "svg"), null, null, "svg:right_arrow", null, false, r0.getAssetsFile(r1.getApplication().getApplicationContext(), "obric_ic_island_notification_right_arrow_light.svg", "svg"), r19, null, 1240, null);
    }

    public static final String v(IslandSession r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return ResourceUtils.INSTANCE.getAssetsFile(AppHost.a.getApplication().getApplicationContext(), "ic_obric_live_island_complex_task_notification_left.svg", "svg");
    }

    public static final boolean w(ObricState r2) {
        if (r2.getCurrentIslandState() != ObricIslandStateType.REALTIME_CALL_PAUSED) goto L5;
    L12:
        return true;
    L5:
        if (r2.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_CONNECTING) goto L12;
        if (r2.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR) goto L12;
        if (r2.getCurrentIslandState() == ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY) goto L12;
        return false;
    }
}
