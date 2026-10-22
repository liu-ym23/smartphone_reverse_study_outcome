package sea;

import android.app.Application;
import com.larus.im.FlowRuntime;
import com.larus.utils.o0;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.live.template.ObricAINotificationTemplateText;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.livecard.api.entity.Text;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j0 {
    public static final int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricIslandStateType.values().length];
            r0[ObricIslandStateType.TTS_END.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L84:
            r0[ObricIslandStateType.CLICK_TALK_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L94:
            r0[ObricIslandStateType.CLICK_TALK_ASR_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L100:
            r0[ObricIslandStateType.COMPLEX_TASK_THINK_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L41
        L104:
            r0[ObricIslandStateType.COMPLEX_TASK_COMPLETED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L42
        L108:
            r0[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L43
        L116:
            r0[ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L44
        L76:
            r0[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L45
        L86:
            r0[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L46
        L88:
            r0[ObricIslandStateType.TTS_PLAYING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L47
        L96:
            r0[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 11;     // Catch: NoSuchFieldError -> L48
        L114:
            r0[ObricIslandStateType.MSG_START.ordinal()] = 12;     // Catch: NoSuchFieldError -> L49
        L120:
            r0[ObricIslandStateType.DEEP_THINK_START.ordinal()] = 13;     // Catch: NoSuchFieldError -> L50
        L66:
            r0[ObricIslandStateType.DEEP_THINK_END.ordinal()] = 14;     // Catch: NoSuchFieldError -> L51
        L72:
            r0[ObricIslandStateType.REALTIME_CALL_SPEAKING.ordinal()] = 15;     // Catch: NoSuchFieldError -> L52
        L92:
            r0[ObricIslandStateType.REALTIME_CALL_WAITING_HELLO.ordinal()] = 16;     // Catch: NoSuchFieldError -> L53
        L98:
            r0[ObricIslandStateType.REALTIME_CALL_THINKING.ordinal()] = 17;     // Catch: NoSuchFieldError -> L54
        L102:
            r0[ObricIslandStateType.REALTIME_CALL_PAUSED.ordinal()] = 18;     // Catch: NoSuchFieldError -> L55
        L110:
            r0[ObricIslandStateType.REALTIME_CALL_CONNECTING.ordinal()] = 19;     // Catch: NoSuchFieldError -> L56
        L70:
            r0[ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR.ordinal()] = 20;     // Catch: NoSuchFieldError -> L57
        L80:
            r0[ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY.ordinal()] = 21;     // Catch: NoSuchFieldError -> L58
        L82:
            r0[ObricIslandStateType.REALTIME_CALL_WAITING.ordinal()] = 22;     // Catch: NoSuchFieldError -> L59
        L90:
            r0[ObricIslandStateType.REALTIME_CALL_LISTENING.ordinal()] = 23;     // Catch: NoSuchFieldError -> L60
        L30:
            a = r0;
            int[] r1 = new int[ObricInteractionScene.values().length];
            r1[ObricInteractionScene.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L61
        L112:
            r1[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L62
        L118:
            r1[ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L63
        L68:
            r1[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L64
        L74:
            r1[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L65
        L36:
            b = r1;
        }
    }

    public static final Text d() {
        return new Text(FlowRuntime.a().getApplication().getString(2131912217), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    }

    public static final Text e() {
        return new Text(FlowRuntime.a().getApplication().getString(2131912218), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    }

    public static final ObricAINotificationTemplateText f() {
        return new ObricAINotificationTemplateText("", null, a, "#FFFFFFFF", null, null, null, d.d(), 114, null);
    }

    public static final Text g() {
        return new Text("", a, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    }

    static {
        a = i5.e0();
    }

    public static final Text a(ObricState r23) {
        Intrinsics.checkNotNullParameter(r23, "<this>");
        ObricIslandStateType r0 = r23.getCurrentIslandState();
        switch(a.a[r0.ordinal()]) {
            case 4: goto L15;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L5;
            default: goto L16;
        };
    L5:
        Application r2 = FlowRuntime.a().getApplication();
        if (j(r23) == false) goto L8;
        int r1 = 2131912044;
    L17:
        return new Text(r2.getString(r1), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L8:
        r1 = 2131912049;
        goto L17
    L16:
        return new Text("", 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L18:
        return new Text(FlowRuntime.a().getApplication().getString(2131912207), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L19:
        return new Text(FlowRuntime.a().getApplication().getString(2131912208), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L20:
        return new Text(FlowRuntime.a().getApplication().getString(2131912206), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L21:
        return new Text(FlowRuntime.a().getApplication().getString(2131912209), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L15:
        return new Text(FlowRuntime.a().getApplication().getString(2131912210), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    }

    public static final Text b(ObricState r23) {
        Intrinsics.checkNotNullParameter(r23, "<this>");
        ObricIslandStateType r0 = r23.getCurrentIslandState();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L13;
        return g();
    L13:
        return new Text(FlowRuntime.a().getApplication().getString(2131912196), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L11:
        return new Text(FlowRuntime.a().getApplication().getString(2131912195), 14, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    }

    public static final String c(ObricState r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Object r5 = r4.getExt().get("take_over_reason");
        if (r5 == null) goto L21;
        String r6 = r5.toString();
        if (r6 == null) goto L21;
        String r3 = null;
        if (StringsKt.startsWith$default(r6, "occupy_", false, 2, null) == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L17;
        String r7 = StringsKt.removePrefix(r6, "occupy_");
        if (r7 == null) goto L17;
        if ((!StringsKt.isBlank(r7)) == false) goto L17;
        r3 = r7;
    L17:
        if (r3 == null) goto L21;
        String r8 = String.format(FlowRuntime.a().getApplication().getString(2131912046), Arrays.copyOf(new Object[]{r3}, 1));
        if (r8 == null) goto L21;
        return r8;
    L21:
        return FlowRuntime.a().getApplication().getString(2131912045);
    }

    public static final Text h(ObricState r23) {
        Intrinsics.checkNotNullParameter(r23, "<this>");
        if (com.obric.assistant.live.api.b.a(r23) == false) goto L13;
        ObricIslandStateType r0 = r23.getCurrentIslandState();
        int r1 = a.a[r0.ordinal()];
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L12;
        if (r1 == 10) goto L84;
        return g();
    L84:
        return new Text(FlowRuntime.a().getApplication().getString(2131912220), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L12:
        return new Text(FlowRuntime.a().getApplication().getString(2131912196), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L13:
        ObricInteractionScene r2 = r23.getScene();
        if (r2 != null) goto L16;
        int r3 = -1;
    L17:
        if (r3 != 1) goto L19;
        ObricIslandStateType r4 = r23.getCurrentIslandState();
        int r5 = a.a[r4.ordinal()];
        if (r5 == 1) goto L82;
        if (r5 == 10) goto L101;
        if (r5 == 12) goto L100;
        return g();
    L100:
        return new Text(FlowRuntime.a().getApplication().getString(2131912228), a, "#FFFFFFFF", null, null, null, null, null, 248, null);
    L101:
        return new Text(FlowRuntime.a().getApplication().getString(2131912220), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L82:
        return new Text(FlowRuntime.a().getApplication().getString(2131912219), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L19:
        if (r3 == 2) goto L63;
        if (r3 != 3) goto L22;
        ObricIslandStateType r6 = r23.getCurrentIslandState();
        int r7 = a.a[r6.ordinal()];
        if (r7 == 13) goto L61;
        if (r7 != 14) goto L92;
        int r8 = 2131912202;
    L93:
        return new Text(FlowRuntime.a().getApplication().getString(r8), a, "#FFFFFFFF", null, null, null, null, null, 248, null);
    L92:
        return g();
    L61:
        r8 = 2131912203;
        goto L93
    L22:
        if (r3 != 4) goto L24;
        ObricIslandStateType r9 = r23.getCurrentIslandState();
        if (ObricLiveServiceDelegate.b.f() == false) goto L46;
        switch(a.a[r9.ordinal()]) {
            case 15: goto L44;
            case 16: goto L44;
            case 17: goto L43;
            case 18: goto L42;
            case 19: goto L41;
            case 20: goto L41;
            case 21: goto L41;
            default: goto L40;
        };
    L40:
        String r10 = FlowRuntime.a().getApplication().getString(2131912223);
        Intrinsics.checkNotNull(r10);
    L91:
        return new Text(r10, a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L41:
        r10 = FlowRuntime.a().getApplication().getString(2131912221);
        Intrinsics.checkNotNull(r10);
        goto L91
    L42:
        r10 = FlowRuntime.a().getApplication().getString(2131912225);
        Intrinsics.checkNotNull(r10);
        goto L91
    L43:
        r10 = FlowRuntime.a().getApplication().getString(2131912226);
        Intrinsics.checkNotNull(r10);
        goto L91
    L44:
        r10 = FlowRuntime.a().getApplication().getString(2131912224);
        Intrinsics.checkNotNull(r10);
        goto L91
    L46:
        switch(a.a[r9.ordinal()]) {
            case 15: goto L54;
            case 16: goto L54;
            case 17: goto L53;
            case 18: goto L52;
            case 19: goto L51;
            case 20: goto L50;
            case 21: goto L50;
            case 22: goto L49;
            case 23: goto L48;
            default: goto L47;
        };
    L47:
        r10 = "";
        goto L91
    L48:
        r10 = FlowRuntime.a().getApplication().getString(2131912222);
        Intrinsics.checkNotNull(r10);
        goto L91
    L49:
        r10 = FlowRuntime.a().getApplication().getString(2131912227);
        Intrinsics.checkNotNull(r10);
        goto L91
    L50:
        r10 = FlowRuntime.a().getApplication().getString(2131912221);
        Intrinsics.checkNotNull(r10);
        goto L91
    L51:
        r10 = FlowRuntime.a().getApplication().getString(2131912221);
        Intrinsics.checkNotNull(r10);
        goto L91
    L52:
        r10 = FlowRuntime.a().getApplication().getString(2131912225);
        Intrinsics.checkNotNull(r10);
        goto L91
    L53:
        r10 = FlowRuntime.a().getApplication().getString(2131912226);
        Intrinsics.checkNotNull(r10);
        goto L91
    L54:
        r10 = FlowRuntime.a().getApplication().getString(2131912224);
        Intrinsics.checkNotNull(r10);
        goto L91
    L24:
        if (r3 != 5) goto L85;
        ObricIslandStateType r11 = r23.getCurrentIslandState();
        int r12 = a.a[r11.ordinal()];
        if (r12 == 1) goto L90;
        switch(r12) {
            case 4: goto L31;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L87;
            case 11: goto L31;
            default: goto L86;
        };
    L31:
        String r13 = String.valueOf(r23.getExt().get("origin_query"));
        if (o0.d(r13) == false) goto L89;
        return new Text(r13, 13, "#E0FFFFFF", "#E6000000", null, null, null, d.a(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L89:
        return g();
    L86:
        return g();
    L87:
        return e();
    L90:
        return d();
    L85:
        return g();
    L63:
        ObricIslandStateType r14 = r23.getCurrentIslandState();
        int r15 = a.a[r14.ordinal()];
        if (r15 == 1) goto L98;
        if (r15 == 10) goto L97;
        if (r15 == 13) goto L96;
        if (r15 == 14) goto L95;
        return g();
    L95:
        return new Text(FlowRuntime.a().getApplication().getString(2131912215), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L96:
        return new Text(FlowRuntime.a().getApplication().getString(2131912216), a, "#FFFFFFFF", null, null, null, null, d.d(), ApWakeEvent.WALKING_START, null);
    L97:
        return e();
    L98:
        return d();
    L16:
        r3 = a.b[r2.ordinal()];
        goto L17
    }

    public static final Text i(ObricState r25) {
        Intrinsics.checkNotNullParameter(r25, "<this>");
        ObricInteractionScene r0 = r25.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 == 1) goto L40;
        if (r1 == 2) goto L52;
        if (r1 == 3) goto L52;
        if (r1 == 4) goto L51;
        if (r1 != 5) goto L41;
        ObricIslandStateType r2 = r25.getCurrentIslandState();
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L50;
        switch(r3) {
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            case 9: goto L22;
            case 10: goto L50;
            case 11: goto L43;
            default: goto L42;
        };
    L22:
        Application r4 = FlowRuntime.a().getApplication();
        if (j(r25) == false) goto L25;
        int r5 = 2131912044;
    L26:
        String r15 = r4.getString(r5);
        if (j(r25) == false) goto L29;
        int r16 = 16;
    L44:
        return new Text(r15, r16, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L29:
        r16 = 14;
        goto L44
    L25:
        r5 = 2131912049;
        goto L26
    L42:
        return g();
    L43:
        return new Text(FlowRuntime.a().getApplication().getString(2131912212), 14, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L45:
        return new Text(FlowRuntime.a().getApplication().getString(2131912207), 16, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L46:
        return new Text(FlowRuntime.a().getApplication().getString(2131912208), 16, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L47:
        return new Text(FlowRuntime.a().getApplication().getString(2131912211), 16, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L48:
        return new Text(FlowRuntime.a().getApplication().getString(2131912209), 16, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L49:
        return new Text(FlowRuntime.a().getApplication().getString(2131912210), 16, "#FFFFFFFF", "#E6000000", null, null, null, d.d(), ErrorCode.DEVICE_LOCK_ERROR, null);
    L50:
        return g();
    L41:
        return g();
    L51:
        return g();
    L52:
        return g();
    L40:
        return g();
    L5:
        r1 = a.b[r0.ordinal()];
        goto L7
    }

    public static final boolean j(ObricState r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L17;
        Object r6 = r5.getExt().get("take_over_reason");
        if (r6 == null) goto L7;
        String r7 = r6.toString();
    L9:
        if (r7 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (StringsKt.startsWith$default(r7, "occupy_", false, 2, null) != true) goto L13;
        r8 = true;
        goto L14
    L7:
        r7 = null;
        goto L9
    L17:
        return false;
    }
}
