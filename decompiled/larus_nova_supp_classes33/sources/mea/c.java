package mea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.live.receiver.GRIslandReceiver;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricIslandStateType;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pea.h;
import pea.i;
import sea.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ObricIslandStateType.values().length];
            r0[ObricIslandStateType.TTS_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L75:
            r0[ObricIslandStateType.TTS_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L83:
            r0[ObricIslandStateType.CLICK_TALK_START.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L91:
            r0[ObricIslandStateType.CLICK_TALK_ASR_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L95:
            r0[ObricIslandStateType.DEEP_THINK_START.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L101:
            r0[ObricIslandStateType.DEEP_THINK_END.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L109:
            r0[ObricIslandStateType.REALTIME_CALL_CONNECTING.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L67:
            r0[ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L77:
            r0[ObricIslandStateType.REALTIME_CALL_NETWORK_ERROR_RETRY_DIRECTLY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L79:
            r0[ObricIslandStateType.REALTIME_CALL_WAITING.ordinal()] = 10;     // Catch: NoSuchFieldError -> L44
        L87:
            r0[ObricIslandStateType.REALTIME_CALL_LISTENING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L45
        L105:
            r0[ObricIslandStateType.REALTIME_CALL_THINKING.ordinal()] = 12;     // Catch: NoSuchFieldError -> L46
        L111:
            r0[ObricIslandStateType.REALTIME_CALL_SPEAKING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L47
        L61:
            r0[ObricIslandStateType.REALTIME_CALL_WAITING_HELLO.ordinal()] = 14;     // Catch: NoSuchFieldError -> L48
        L65:
            r0[ObricIslandStateType.REALTIME_CALL_PAUSED.ordinal()] = 15;     // Catch: NoSuchFieldError -> L49
        L81:
            r0[ObricIslandStateType.COMPLEX_TASK_THINK_START.ordinal()] = 16;     // Catch: NoSuchFieldError -> L50
        L89:
            r0[ObricIslandStateType.COMPLEX_TASK_TAKING_OVER.ordinal()] = 17;     // Catch: NoSuchFieldError -> L51
        L93:
            r0[ObricIslandStateType.COMPLEX_TASK_COMPLETED.ordinal()] = 18;     // Catch: NoSuchFieldError -> L52
        L103:
            r0[ObricIslandStateType.COMPLEX_TASK_CALL_USER.ordinal()] = 19;     // Catch: NoSuchFieldError -> L53
        L63:
            r0[ObricIslandStateType.COMPLEX_TASK_RECEIVE_USER_CLARIFY.ordinal()] = 20;     // Catch: NoSuchFieldError -> L54
        L71:
            r0[ObricIslandStateType.COMPLEX_TASK_OPERATING_VIRTUAL_SCREEN.ordinal()] = 21;     // Catch: NoSuchFieldError -> L55
        L73:
            r0[ObricIslandStateType.COMPLEX_TASK_ASK_USER.ordinal()] = 22;     // Catch: NoSuchFieldError -> L56
        L28:
            a = r0;
            int[] r1 = new int[ObricInteractionScene.values().length];
            r1[ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L57
        L97:
            r1[ObricInteractionScene.DEFAULT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L58
        L99:
            r1[ObricInteractionScene.DEEP_THINK_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L59
        L107:
            r1[ObricInteractionScene.REALTIME_CALL_SCENE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L60
        L33:
            b = r1;
        }
    }

    public static final h c() {
        return new h("miui.focus.action_close_red", true, "miui.focus.pic_close_red", 2131244418, "miui.focus.pic_close_red_dark", 2131244419, 32265);
    }

    public static final h d() {
        return new h("miui.focus.action_stop_play", false, "miui.focus.pic_stop_play", 2131244426, "miui.focus.pic_stop_play_dark", 2131244427, 32281);
    }

    public static final h e() {
        return new h("miui.focus.action_right_arrow", true, "miui.focus.pic_right_arrow", 2131244416, "miui.focus.pic_right_arrow_dark", 2131244417, 32265);
    }

    public static final void a(List<h> r5) {
        if (r5.size() >= 2) goto L6;
        return;
    L6:
        if (r5.size() != 2) goto L22;
        Intent r1 = ((h) ListProtector.get(r5, 0)).d;
        if (r1 == null) goto L10;
        r1.setAction("com.obric.assistant.obric.gr.island.pending.action");
    L10:
        Intent r2 = ((h) ListProtector.get(r5, 1)).d;
        if (r2 == null) goto L13;
        r2.setAction("com.obric.assistant.obric.gr.island.pending.action2");
    L13:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("adjustActionForActions() set action: ");
        Intent r0 = ((h) ListProtector.get(r5, 0)).d;
        String r6 = null;
        if (r0 == null) goto L16;
        String r7 = r0.getAction();
    L17:
        r4.append(r7);
        r4.append(", ");
        Intent r8 = ((h) ListProtector.get(r5, 1)).d;
        if (r8 == null) goto L20;
        r6 = r8.getAction();
    L20:
        r4.append(r6);
        r3.d("GRIslandImpl", r4.toString());
        return;
    L16:
        r7 = null;
        goto L17
    }

    public static final i b(ObricState r3) {
        ObricIslandStateType r4 = r3.getCurrentIslandState();
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L5;
    L13:
        i r6 = new i("miui.focus.pic_audio_wave", 2131244412, null);
    L15:
        return r6;
    L5:
        if (r5 == 2) goto L13;
        if (r5 != 5) goto L9;
        r6 = new i("miui.focus.pic_thinking", 2131244405, null);
        goto L15
    L9:
        if (r5 != 6) goto L16;
        r6 = new i("miui.focus.pic_thinking_complete", 2131244411, null);
        goto L15
    L16:
        return null;
    }

    public static final h f(boolean r9) {
        if (r9 == false) goto L4;
        int r5 = 2131244428;
    L5:
        if (r9 == false) goto L7;
        int r10 = 2131244429;
    L9:
        return new h("miui.focus.action_expand_mic_on", false, "miui.focus.pic_expand_unmute", r5, "miui.focus.pic_expand_unmute_dark", Integer.valueOf(r10), 32281);
    L7:
        r10 = 2131244423;
        goto L9
    L4:
        r5 = 2131244422;
        goto L5
    }

    public static final i g(ObricState r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (com.obric.assistant.live.api.b.a(r10) == false) goto L13;
        ObricIslandStateType r11 = r10.getCurrentIslandState();
        int r12 = a.a[r11.ordinal()];
        if (r12 == 1) goto L10;
        if (r12 == 3) goto L9;
        if (r12 == 4) goto L9;
        return null;
    L9:
        i r13 = new i("miui.focus.pic_mic_on_orange", 2131244409, null);
    L12:
        return r13;
    L10:
        r13 = new i("miui.focus.pic_audio_wave", 2131244412, null);
        goto L12
    L13:
        ObricInteractionScene r0 = r10.getScene();
        if (r0 != null) goto L16;
        int r1 = -1;
    L17:
        if (r1 == 1) goto L47;
        if (r1 == 2) goto L40;
        if (r1 == 3) goto L49;
        if (r1 != 4) goto L51;
        ObricIslandStateType r14 = r10.getCurrentIslandState();
        switch(a.a[r14.ordinal()]) {
            case 7: goto L37;
            case 8: goto L37;
            case 9: goto L37;
            case 10: goto L34;
            case 11: goto L30;
            case 12: goto L28;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L26;
            default: goto L38;
        };
    L26:
        i r15 = new i("miui.focus.pic_replay_pause", 2131244408, null);
    L50:
        return r15;
    L27:
        r15 = new i("miui.focus.pic_replaying", 2131244412, null);
        goto L50
    L28:
        r15 = new i("miui.focus.pic_cloud_thinking", 2131244410, null);
        goto L50
    L37:
        r15 = new i("miui.focus.pic_replaying", 2131244404, null);
        goto L50
    L38:
        r15 = new i("miui.focus.pic_mic_on_without_bg", 2131244406, null);
        goto L50
    L30:
        if (ObricLiveServiceDelegate.b.f() == false) goto L32;
        r15 = new i("miui.focus.pic_mic_off_without_bg", 2131244407, null);
        goto L50
    L32:
        r15 = new i("miui.focus.pic_mic_on_orange", 2131244409, null);
        goto L50
    L34:
        if (ObricLiveServiceDelegate.b.f() == false) goto L36;
        r15 = new i("miui.focus.pic_mic_off_without_bg", 2131244407, null);
        goto L50
    L36:
        r15 = new i("miui.focus.pic_mic_on_without_bg", 2131244406, null);
        goto L50
    L51:
        return null;
    L49:
        return b(r10);
    L40:
        ObricIslandStateType r16 = r10.getCurrentIslandState();
        int r17 = a.a[r16.ordinal()];
        if (r17 == 1) goto L44;
        if (r17 == 2) goto L44;
        return null;
    L44:
        r15 = new i("miui.focus.pic_audio_wave", 2131244412, null);
        goto L50
    L47:
        return b(r10);
    L16:
        r1 = a.b[r0.ordinal()];
        goto L17
    }

    public static final List<h> h(ObricState r28) {
        Intrinsics.checkNotNullParameter(r28, "<this>");
        if (com.obric.assistant.live.api.b.a(r28) == false) goto L24;
        Intrinsics.checkNotNullParameter(r28, "obricState");
        int r1 = a.a[r28.getCurrentIslandState().ordinal()];
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L10;
        List<h> r2 = CollectionsKt.emptyList();
    L13:
        Iterator<T> r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L22;
        h r4 = (h) r3.next();
        if (Intrinsics.areEqual(r4.c, "miui.focus.action_stop_play") == true) goto L18;
        if (Intrinsics.areEqual(r4.c, "miui.focus.action_right_arrow") == false) goto L15;
        b r5 = b.a;
        Context r8 = AppHost.a.getApplication().getApplicationContext();
        r5.getClass();
        r4.d = b.d(r8, r28);
        r4.n = 2;
        goto L15
    L18:
        b r6 = b.a;
        Context r9 = AppHost.a.getApplication().getApplicationContext();
        r6.getClass();
        r4.d = b.a(r9);
        r4.n = 2;
        goto L15
    L22:
        a(r2);
        return r2;
    L10:
        r2 = CollectionsKt.listOf(e());
    L11:
        r2 = CollectionsKt.listOf(e());
        goto L13
    L12:
        r2 = CollectionsKt.listOf(new h[]{d(), e()});
        goto L13
    L24:
        ObricInteractionScene r7 = r28.getScene();
        if (r7 != null) goto L27;
        int r10 = -1;
    L28:
        String r15 = "context";
        if (r10 != 1) goto L31;
        int r11 = a.a[r28.getCurrentIslandState().ordinal()];
        if (r11 == 1) goto L132;
        if (r11 == 2) goto L132;
        switch(r11) {
            case 16: goto L131;
            case 17: goto L131;
            case 18: goto L131;
            case 19: goto L131;
            case 20: goto L131;
            case 21: goto L131;
            case 22: goto L130;
            default: goto L129;
        };
    L129:
        List<h> r12 = CollectionsKt.emptyList();
    L133:
        Iterator r13 = r12.iterator();
    L135:
        if (r13.hasNext() == false) goto L170;
        h r14 = (h) r13.next();
        String r16 = r14.c;
        if (r16 == null) goto L135;
        int r17 = r16.hashCode();
        if (r17 != (-725686667)) goto L141;
        if (r16.equals("miui.focus.action_reply") == false) goto L135;
        b r18 = b.a;
        Context r19 = AppHost.a.getApplication().getApplicationContext();
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "context");
        Intent r20 = new Intent(r19, GRIslandReceiver.class);
        r20.setPackage(r19.getPackageName());
        r20.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r20.putExtra("live_state", -1008);
        FLogger.a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r20 + ", extras: " + r20.getExtras());
        r14.d = r20;
        goto L135
    L141:
        if (r17 != 1863734129) goto L143;
        if (r16.equals("miui.focus.action_right_arrow") == false) goto L135;
        int r21 = a.a[r28.getCurrentIslandState().ordinal()];
        if (r21 == 17) goto L161;
        if (r21 != 19) goto L157;
        b r22 = b.a;
        Context r23 = AppHost.a.getApplication().getApplicationContext();
        sea.b.a.getClass();
        Bundle r24 = sea.b.b(r28);
        r22.getClass();
        r14.d = b.f(r23, true, r24);
        goto L135
    L157:
        if (r21 == 21) goto L161;
        b r25 = b.a;
        Context r26 = AppHost.a.getApplication().getApplicationContext();
        r25.getClass();
        r14.d = b.d(r26, r28);
    L161:
        if (r28.getCurrentIslandState() != ObricIslandStateType.COMPLEX_TASK_TAKING_OVER) goto L165;
        g.a.getClass();
        if (g.d(r28) == false) goto L165;
        b r27 = b.a;
        Context r29 = AppHost.a.getApplication().getApplicationContext();
        r27.getClass();
        r14.d = b.c(r29, r28);
    L165:
        b r30 = b.a;
        Context r31 = AppHost.a.getApplication().getApplicationContext();
        sea.b.a.getClass();
        Bundle r32 = sea.b.b(r28);
        r30.getClass();
        r14.d = b.f(r31, false, r32);
        goto L135
    L143:
        if (r17 != 1886782300) goto L135;
        if (r16.equals("miui.focus.action_stop_play") == false) goto L135;
        b r33 = b.a;
        Context r34 = AppHost.a.getApplication().getApplicationContext();
        r33.getClass();
        r14.d = b.a(r34);
        goto L135
    L170:
        a(r12);
    L172:
        return r12;
    L130:
        r12 = CollectionsKt.listOf(new h("miui.focus.action_reply", false, "miui.focus.pic_reply", 2131244428, "miui.focus.pic_reply_dark", 2131244429, 32281));
        goto L133
    L131:
        r12 = CollectionsKt.listOf(e());
    L132:
        r12 = CollectionsKt.listOf(new h[]{d(), e()});
        goto L133
    L31:
        if (r10 == 2) goto L110;
        if (r10 == 3) goto L90;
        if (r10 != 4) goto L231;
        FLogger.a.d("GRIslandImpl", "getRealtimeCallExpandIslandRightIconList() currentIslandState: " + r28.getCurrentIslandState());
        int r35 = 2131244421;
        if (ObricLiveServiceDelegate.b.f() == false) goto L50;
        h[] r36 = new h[2];
        if (j(r28) == false) goto L40;
        int r210 = 2131244420;
    L42:
        if (j(r28) == true) goto L46;
        r35 = 2131244425;
    L46:
        if (j(r28) == false) goto L48;
        String r110 = "miui.focus.action_mic_off_with_bg";
    L49:
        r36[0] = new h(r110, false, "miui.focus.pic_expand_mute", r210, "miui.focus.pic_expand_mute_dark", Integer.valueOf(r35), 32281);
        r36[1] = c();
        List<h> r37 = CollectionsKt.listOf(r36);
    L63:
        Iterator r38 = r37.iterator();
    L65:
        if (r38.hasNext() == false) goto L89;
        h r39 = (h) r38.next();
        FLogger r40 = FLogger.a;
        Iterator r111 = r38;
        r40.d("GRIslandImpl", "createRealtimeCallExpandLiveCard()  start bind action: " + r39.c);
        if (Intrinsics.areEqual(r39.c, "miui.focus.action_close_red") == false) goto L69;
        b r41 = b.a;
        List<h> r112 = r37;
        Context r42 = AppHost.a.getApplication().getApplicationContext();
        r41.getClass();
        Intrinsics.checkNotNullParameter(r42, r15);
        String r113 = r15;
        Intent r43 = new Intent(r42, GRIslandReceiver.class);
        r43.setPackage(r42.getPackageName());
        r43.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r43.putExtra("live_state", -103);
        r40.e("GRStateActionUtils", "getContentPendingIntent with intent " + r43 + ", extras: " + r43.getExtras());
        r39.d = r43;
        r40.d("GRIslandImpl", "GRStateIslandUtils.createRealtimeCallExpandLiveCard() bind action: " + r39.c + ", actionIntent: " + r39.o + " success");
    L73:
        switch(a.a[r28.getCurrentIslandState().ordinal()]) {
            case 10: goto L76;
            case 11: goto L76;
            case 12: goto L76;
            case 13: goto L76;
            case 14: goto L76;
            default: goto L88;
        };
    L76:
        if (ObricLiveServiceDelegate.b.f() == false) goto L82;
        if (Intrinsics.areEqual(r39.c, "miui.focus.action_expand_mic_off") == false) goto L80;
        b r44 = b.a;
        Context r114 = AppHost.a.getApplication().getApplicationContext();
        r44.getClass();
        r39.d = b.g(r114);
    L80:
        r40.d("GRIslandImpl", "addMuteOrUnmuteClickEvent() set action " + r39.c + " success, actionIntent: " + r39.o);
        goto L88
    L82:
        if (Intrinsics.areEqual(r39.c, "miui.focus.action_expand_mic_on") == false) goto L84;
        b r45 = b.a;
        Context r115 = AppHost.a.getApplication().getApplicationContext();
        r45.getClass();
        r39.d = b.e(r115);
    L84:
        r40.d("GRIslandImpl", "addMuteOrUnmuteClickEvent() set action " + r39.c + " success, actionIntent: " + r39.o);
        if (Intrinsics.areEqual(r39.c, "miui.focus.action_mic_on_orange") == false) goto L87;
        b r46 = b.a;
        Context r116 = AppHost.a.getApplication().getApplicationContext();
        r46.getClass();
        r39.d = b.e(r116);
    L87:
        r40.d("GRIslandImpl", "addMuteOrUnmuteClickEvent() set action " + r39.c + " success, actionIntent: " + r39.o);
    L88:
        r38 = r111;
        r37 = r112;
        r15 = r113;
        goto L65
    L69:
        r112 = r37;
        r113 = r15;
        if (Intrinsics.areEqual(r39.c, "miui.focus.action_right_arrow") == false) goto L73;
        b r47 = b.a;
        Context r48 = AppHost.a.getApplication().getApplicationContext();
        r47.getClass();
        r39.d = b.d(r48, r28);
        r40.d("GRIslandImpl", "GRStateIslandUtils.createRealtimeCallExpandLiveCard() bind action: " + r39.c + " success");
        goto L73
    L89:
        List<h> r117 = r37;
        a(r117);
        return r117;
    L48:
        r110 = "miui.focus.action_expand_mic_off";
        goto L49
    L40:
        r210 = 2131244424;
        goto L42
    L50:
        h[] r49 = new h[2];
        switch(a.a[r28.getCurrentIslandState().ordinal()]) {
            case 7: goto L59;
            case 8: goto L59;
            case 9: goto L59;
            case 10: goto L57;
            case 11: goto L56;
            case 12: goto L55;
            case 13: goto L54;
            case 14: goto L54;
            case 15: goto L53;
            default: goto L52;
        };
    L52:
        char r50 = 0;
        h r51 = f(false);
    L62:
        r49[r50] = r51;
        r49[1] = c();
        r37 = CollectionsKt.listOf(r49);
        goto L63
    L53:
        h r52 = new h("miui.focus.action_mic_on_with_bg_pause", false, "miui.focus.pic_mic_on_with_bg_pause", 2131244420, "miui.focus.pic_mic_on_with_bg_pause_dark", 2131244421, 32281);
    L60:
        r51 = r52;
        r50 = 0;
        goto L62
    L54:
        h r53 = f(true);
    L58:
        r52 = r53;
        goto L60
    L55:
        r53 = f(false);
        goto L58
    L56:
        r52 = new h("miui.focus.action_mic_on_orange_with_bg", false, "miui.focus.pic_mic_on_orange_with_bg", 2131244428, "miui.focus.pic_mic_on_orange_with_bg_dark", 2131244423, 32281);
        goto L60
    L57:
        r53 = f(false);
        goto L58
    L59:
        r52 = new h("miui.focus.action_mic_on_with_bg_pause", false, "miui.focus.pic_mic_on_with_bg_pause", 2131244420, "miui.focus.pic_mic_on_with_bg_pause_dark", 2131244421, 32281);
        goto L60
    L231:
        return CollectionsKt.emptyList();
    L90:
        int r54 = a.a[r28.getCurrentIslandState().ordinal()];
        if (r54 == 1) goto L99;
        if (r54 == 2) goto L99;
        if (r54 != 5) goto L96;
    L98:
        r12 = CollectionsKt.listOf(e());
    L100:
        Iterator<T> r55 = r12.iterator();
    L102:
        if (r55.hasNext() == false) goto L109;
        h r56 = (h) r55.next();
        FLogger r57 = FLogger.a;
        r57.d("GRIslandImpl", "getDeepThinkExpandIslandRightIconList() bind action: " + r56.c);
        if (Intrinsics.areEqual(r56.c, "miui.focus.action_stop_play") == true) goto L105;
        if (Intrinsics.areEqual(r56.c, "miui.focus.action_right_arrow") == false) goto L102;
        b r118 = b.a;
        Context r119 = AppHost.a.getApplication().getApplicationContext();
        r118.getClass();
        r56.d = b.d(r119, r28);
        r56.n = 2;
        r57.d("GRIslandImpl", "getDeepThinkExpandIslandRightIconList() bind action: " + r56.c + " success");
        goto L102
    L105:
        b r120 = b.a;
        Context r121 = AppHost.a.getApplication().getApplicationContext();
        r120.getClass();
        r56.d = b.a(r121);
        r56.n = 2;
        r57.d("GRIslandImpl", "getDeepThinkExpandIslandRightIconList() bind action: " + r56.c + " success");
        goto L102
    L109:
        a(r12);
        goto L172
    L96:
        if (r54 == 6) goto L98;
        r12 = CollectionsKt.emptyList();
    L99:
        r12 = CollectionsKt.listOf(new h[]{d(), e()});
        goto L100
    L110:
        int r58 = a.a[r28.getCurrentIslandState().ordinal()];
        if (r58 == 1) goto L114;
        if (r58 == 2) goto L114;
        r12 = CollectionsKt.emptyList();
    L115:
        Iterator<T> r59 = r12.iterator();
    L117:
        if (r59.hasNext() == false) goto L124;
        h r60 = (h) r59.next();
        FLogger r61 = FLogger.a;
        r61.d("GRIslandImpl", "createDefaultExpandLiveCard() start bind action: " + r60.c);
        if (Intrinsics.areEqual(r60.c, "miui.focus.action_stop_play") == true) goto L120;
        if (Intrinsics.areEqual(r60.c, "miui.focus.action_right_arrow") == false) goto L117;
        b r122 = b.a;
        Context r123 = AppHost.a.getApplication().getApplicationContext();
        r122.getClass();
        r60.d = b.d(r123, r28);
        r60.n = 2;
        r61.d("GRIslandImpl", "createDefaultExpandLiveCard() bind action: " + r60.c + " success");
        goto L117
    L120:
        b r124 = b.a;
        Context r125 = AppHost.a.getApplication().getApplicationContext();
        r124.getClass();
        r60.d = b.a(r125);
        r60.n = 2;
        r61.d("GRIslandImpl", "createDefaultExpandLiveCard() bind action: " + r60.c + " success");
        goto L117
    L124:
        a(r12);
    L114:
        r12 = CollectionsKt.listOf(new h[]{d(), e()});
        goto L115
    L27:
        r10 = a.b[r7.ordinal()];
        goto L28
    }

    public static final i i(ObricState r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ObricInteractionScene r0 = r5.getScene();
        if (r0 != null) goto L5;
        int r1 = -1;
    L7:
        if (r1 != 1) goto L15;
        ObricIslandStateType r6 = r5.getCurrentIslandState();
        int r7 = a.a[r6.ordinal()];
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L17;
        return new i("miui.focus.pic_complex_task_expand_left", 2131244414, null);
    L17:
        return new i("miui.focus.pic_doubao_icon", 2131244415, null);
    L15:
        return new i("miui.focus.pic_doubao_icon", 2131244415, null);
    L5:
        r1 = a.b[r0.ordinal()];
        goto L7
    }

    public static final boolean j(ObricState r2) {
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
