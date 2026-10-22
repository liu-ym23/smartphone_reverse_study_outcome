package com.larus.dora.impl.device.settings.gesture;

import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class GestureSettingsTracker {
    public static final GestureSettingsTracker a = null;
    public static com.larus.dora.impl.network.z b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[GestureSettingsKey.values().length];
            r0[GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r0[GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r0[GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r0[GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            a = r0;
            int[] r1 = new int[GestureWakeupType.values().length];
            r1[GestureWakeupType.RADIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r1[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            b = r1;
        }
    }

    static {
        a = new GestureSettingsTracker();
    }

    public GestureSettingsTracker() {
    }

    public static String a(byte r1) {
        if (r1 != 16) goto L6;
        return "play_and_pause";
    L6:
        if (r1 != 19) goto L9;
        return "play_previous";
    L9:
        if (r1 != 20) goto L12;
        return "play_next";
    L12:
        if (r1 != 6) goto L15;
        return "volume_adjustment";
    L15:
        if (r1 != 2) goto L18;
        return "pickup";
    L18:
        if (r1 != 3) goto L21;
        return "hangup";
    L21:
        if (r1 != 1) goto L24;
        return "pickup_and_hangup";
    L24:
        if (r1 != 33) goto L27;
        return "toggle_live_ai";
    L27:
        if (r1 != 32) goto L30;
        return "start_continuous_dialog";
    L30:
        if (r1 != 34) goto L33;
        return "enter_exit_interpretation";
    L33:
        if (r1 != 35) goto L36;
        return "dora_radio";
    L36:
        if (r1 != 37) goto L39;
        return "enter_exit_audio_summary";
    L39:
        if (r1 != 38) goto L42;
        return "quick_note";
    L42:
        if (r1 != 40) goto L45;
        return "enter_exit_headphone_mode";
    L45:
        if (r1 != 39) goto L47;
        return "non_ai_recording";
    L47:
        return "none";
    }

    public static String b(byte r1) {
        if (r1 != 16) goto L6;
        return "play_and_pause";
    L6:
        if (r1 != 19) goto L9;
        return "play_previous";
    L9:
        if (r1 != 20) goto L12;
        return "play_next";
    L12:
        if (r1 != 6) goto L15;
        return "volume_adjustment";
    L15:
        if (r1 != 7) goto L18;
        return "take_image";
    L18:
        if (r1 != 1) goto L21;
        return "pickup_and_hangup";
    L21:
        if (r1 != 2) goto L24;
        return "pickup";
    L24:
        if (r1 != 4) goto L27;
        return "reject_call";
    L27:
        if (r1 != 3) goto L29;
        return "hangup";
    L29:
        if (r1 != 0) goto L32;
        return "none";
    L32:
        if (r1 != (-1)) goto L35;
        return "query_note_content";
    L35:
        if (r1 != 34) goto L37;
        return "start_interpretation";
    L37:
        return "";
    }

    public static String c(GestureWakeupType r1) {
        int r2 = a.b[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "long_press_single_round";
    L5:
        if (r2 != 2) goto L7;
        return "long_press_multi_round_mode";
    L7:
        if (r2 == 3) goto L9;
        return "none";
    L9:
        return "gesture_note";
    }

    public final Object e(Continuation<? super Unit> r12) {
        if ((r12 instanceof GestureSettingsTracker$traceGestureSettingsResult$1) == false) goto L7;
        GestureSettingsTracker$traceGestureSettingsResult$1 r0 = (GestureSettingsTracker$traceGestureSettingsResult$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$2;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r0.L$1;
        Map r6 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L23:
        com.larus.dora.impl.network.z r14 = (com.larus.dora.impl.network.z) r13;
        b = r14;
        if (r14 == null) goto L35;
        Object r7 = r5.element;
        GestureWakeupType r8 = GestureWakeupType.RADIO;
        if (r7 != r8) goto L31;
        if (o0.d(r14.c()) == false) goto L31;
        r5.element = GestureWakeupType.RADIO_RECORD;
    L31:
        if (r4.element != r8) goto L35;
        if (o0.d(r14.e()) == false) goto L35;
        r4.element = GestureWakeupType.RADIO_RECORD;
    L35:
        Pair[] r15 = new Pair[6];
        Byte r9 = (Byte) r6.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK);
        String r10 = null;
        String r11 = "none";
        if (r9 == null) goto L47;
        byte r16 = r9.byteValue();
        if (r16 != 0) goto L46;
        com.larus.dora.impl.network.z r17 = b;
        if (r17 == null) goto L42;
        String r18 = r17.b();
    L44:
        if (o0.d(r18) == false) goto L46;
        String r20 = b((byte) -1);
    L48:
        r15[0] = TuplesKt.to("med_double_click_left", r20);
        Byte r21 = (Byte) r6.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK);
        if (r21 == null) goto L59;
        byte r22 = r21.byteValue();
        if (r22 != 0) goto L58;
        com.larus.dora.impl.network.z r23 = b;
        if (r23 == null) goto L56;
        r10 = r23.d();
    L56:
        if (o0.d(r10) == false) goto L58;
        String r24 = b((byte) -1);
    L60:
        r15[1] = TuplesKt.to("med_double_click_right", r24);
        Byte r25 = (Byte) r6.get(GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK);
        if (r25 == null) goto L63;
        String r26 = b(r25.byteValue());
    L64:
        r15[2] = TuplesKt.to("call_double_click_left", r26);
        Byte r27 = (Byte) r6.get(GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK);
        if (r27 == null) goto L67;
        String r28 = b(r27.byteValue());
    L68:
        r15[3] = TuplesKt.to("call_double_click_right", r28);
        GestureWakeupType r30 = (GestureWakeupType) r5.element;
        if (r30 == null) goto L71;
        String r31 = c(r30);
    L72:
        r15[4] = TuplesKt.to("wakeup_longpress_left", r31);
        GestureWakeupType r32 = (GestureWakeupType) r4.element;
        if (r32 == null) goto L75;
        r11 = c(r32);
    L75:
        r15[5] = TuplesKt.to("wakeup_longpress_right", r11);
        DoraBuryPointManager.a.L("dora_gesture_settings_result", MapsKt.mapOf(r15));
        return Unit.INSTANCE;
    L71:
        r31 = "none";
        goto L72
    L67:
        r28 = "none";
        goto L68
    L63:
        r26 = "none";
    L58:
        r24 = b(r22);
        goto L60
    L59:
        r24 = "none";
        goto L60
    L42:
        r18 = null;
    L46:
        r20 = b(r16);
        goto L48
    L47:
        r20 = "none";
        goto L48
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r13);
    L19:
        Map r110 = (Map) r13;
        r5 = new Ref.ObjectRef();
        r5.element = DoraAdapterExtKt.o(kj4.a.g());
        Ref.ObjectRef r33 = new Ref.ObjectRef();
        r33.element = r5.element;
        QuickNoteRepo r34 = QuickNoteRepo.a;
        r0.L$0 = r110;
        r0.L$1 = r5;
        r0.L$2 = r33;
        r0.label = 2;
        Object r35 = r34.c(r0);
        if (r35 != r2) goto L22;
        return r2;
    L22:
        r4 = r33;
        r6 = r110;
        r13 = r35;
        goto L23
    L16:
        ResultKt.throwOnFailure(r13);
        kj4.a r111 = kj4.a.g();
        r0.label = 1;
        r13 = DoraAdapterExtKt.n(r111);
        if (r13 != r2) goto L19;
        return r2;
    L7:
        r0 = new GestureSettingsTracker$traceGestureSettingsResult$1(this, r12);
        goto L8
    }

    public static void f(GestureSettingsKey r13, byte r14) {
        Intrinsics.checkNotNullParameter(r13, "key");
        int r15 = a.a[r13.ordinal()];
        if (r15 != 1) goto L5;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "media"), TuplesKt.to("gesture", "double_click_left_ear"), TuplesKt.to("gesture_effect", b(r14)), TuplesKt.to("status", "save")});
        return;
    L5:
        if (r15 != 2) goto L7;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "media"), TuplesKt.to("gesture", "double_click_right_ear"), TuplesKt.to("gesture_effect", b(r14)), TuplesKt.to("status", "save")});
        return;
    L7:
        if (r15 == 3) goto L11;
        if (r15 == 4) goto L10;
        return;
    L10:
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "call"), TuplesKt.to("gesture", "double_click_right_ear"), TuplesKt.to("gesture_effect", b(r14)), TuplesKt.to("status", "save")});
        return;
    L11:
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "call"), TuplesKt.to("gesture", "double_click_left_ear"), TuplesKt.to("gesture_effect", b(r14)), TuplesKt.to("status", "save")});
    }

    public static void d(DoraGGestureSettings r8, DoraGGestureSettings r9, int r10, boolean r11, long r12) {
        Intrinsics.checkNotNullParameter(r9, "settings");
        byte r0 = r9.b;
        if (r0 != 6) goto L5;
        String r1 = "quickControl";
    L10:
        byte r3 = r9.c;
        if (r3 != 1) goto L13;
        String r4 = "single_click";
    L21:
        if (r8 == null) goto L23;
        String r13 = a(r8.d);
    L24:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_gesture_settings_dm", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("gesture_scene", r1), TuplesKt.to("gesture", r4), TuplesKt.to("gesture_effect", a(r9.d)), TuplesKt.to("error_code", Integer.valueOf(r10)), TuplesKt.to("is_success", String.valueOf(r11 ? 1 : 0)), TuplesKt.to("from_gesture_effect", r13), TuplesKt.to("duration", Long.valueOf(r12))}), true, 4);
        return;
    L23:
        r13 = "none";
        goto L24
    L13:
        if (r3 != 2) goto L15;
        r4 = "double_click";
        goto L21
    L15:
        if (r3 != 3) goto L18;
        r4 = "triple_click";
        goto L21
    L18:
        if (r3 != 16) goto L20;
        r4 = "swipe";
        goto L21
    L20:
        r4 = "long_press";
        goto L21
    L5:
        if (r0 != 0) goto L7;
        r1 = "media";
        goto L10
    L7:
        if (r0 != 1) goto L9;
        r1 = "call";
        goto L10
    L9:
        r1 = "doubao";
        goto L10
    }
}
