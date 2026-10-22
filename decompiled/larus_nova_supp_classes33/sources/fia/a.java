package fia;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4) {
        JSONObject r0 = new JSONObject();
        if (r4 != null) goto L12;
        r4 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
    L12:
        r0.put("enter_method", r4);     // Catch: JSONException -> L8
    L10:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("obric_enter_full_screen");
        r1.a.merge(r5);
        r1.b();
        return;
    L8:
        e = move-exception;
        FLogger.a.i("WindowTrackHelper", "mobEnterFullScreen error: " + e);
        goto L10
    }

    public static void b(String r4) {
        JSONObject r0 = new JSONObject();
    L19:
        e = move-exception;
        FLogger.a.i("WindowTrackHelper", "mobSwipeUp error: " + e);
    L21:
        TrackParams r5 = new TrackParams().merge(r0);
        by7.a r1 = new by7.a("obric_swipeup_panel");
        r1.a.merge(r5);
        r1.b();
        return;
    L4:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L6;
        String r2 = "lock_screen";
    L7:
        r0.put("show_position", r2);     // Catch: JSONException -> L19
        ObricFloatChatPageData.Companion.getClass();     // Catch: JSONException -> L19
        if (Intrinsics.areEqual(r4, ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp()) == false) goto L11;
        String r6 = "global_small_window";
    L17:
        r0.put("obric_window_mode", r6);     // Catch: JSONException -> L19
        goto L21
    L11:
        if (Intrinsics.areEqual(r4, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L14;
        r6 = "global_quad_screen";
        goto L17
    L14:
        if (Intrinsics.areEqual(r4, ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp()) == false) goto L16;
        r6 = "full_screen";
        goto L17
    L16:
        r6 = IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER;
        goto L17
    L6:
        r2 = "unlock_screen";
        goto L7
    }
}
