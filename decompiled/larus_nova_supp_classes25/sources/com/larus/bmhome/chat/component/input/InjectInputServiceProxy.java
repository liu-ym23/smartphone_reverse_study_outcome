package com.larus.bmhome.chat.component.input;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class InjectInputServiceProxy<T extends Fragment> implements op8.i {
    public final Class<T> a;
    public final Function0<T> b;
    public final op8.f c;
    public Fragment d;

    public static final class a {
    }

    static {
    }

    public final void o8() {
        c(new s0());
    }

    public final void stopInput() {
        c(new u0());
    }

    public final void M2(final op8.i.a r2) {
        Intrinsics.checkNotNullParameter(r2, "inputType");
        c(new r0(r2));
    }

    public final void c(Function1<? super op8.e, Unit> r4) {
        Fragment r0 = this.d;
        if (r0 != null) goto L5;
    L14:
        FLogger.a.e("CameraInputServiceProxy", "[runInjectInputAbility] failed, cannot run before " + this.a.getSimpleName() + " attached");
        return;
    L5:
        if (r0.isAdded() == false) goto L14;
        if (r0.getActivity() == null) goto L14;
        op8.e r1 = s1a.a.g(r0).getAbility(op8.e.class);
        if (r1 == null) goto L12;
        r4.invoke(r1);
        return;
    L12:
        FLogger.a.e("CameraInputServiceProxy", "[runInjectInputAbility] failed, cannot get InjectInputAbility from ".concat(this.a.getSimpleName()));
    }

    public final void a(final View r2, final MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        c(new t0(r2, r3));
    }

    public InjectInputServiceProxy(Class r2, Function0 r3, op8.c r4) {
        Intrinsics.checkNotNullParameter(r2, "fragmentClass");
        Intrinsics.checkNotNullParameter(r3, "fragmentFactory");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final Fragment b(Boolean r20, String r21, Map<String, String> r22) {
        this.d = null;
        final Fragment r3 = (Fragment) this.b.invoke();     // Catch: Exception -> L99
        Bundle r17 = r3.getArguments();     // Catch: Exception -> L99
        if (r17 != null) goto L6;
        r17 = new Bundle();     // Catch: Exception -> L99
    L6:
        Bundle r1 = r17;
        if (r20 == null) goto L13;
        r1.putBoolean("inject_input", r20.booleanValue());     // Catch: Exception -> L10
    L10:
        e = e;
        final InjectInputServiceProxy<T> r2 = this;
    L101:
        FLogger.a.e("CameraInputServiceProxy", "Failed to create fragment instance of ".concat(r2.a.getSimpleName()), e);
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        r2.d = null;
        return null;
    L13:
        if (r21 == null) goto L15;
        r1.putString("inject_input_scene", r21);     // Catch: Exception -> L10
    L15:
        String r0 = r22.get("bot_id");     // Catch: Exception -> L10
        if (r0 == null) goto L18;
        r1.putString("bot_id", r0);     // Catch: Exception -> L10
    L18:
        String r4 = r22.get("conversation_id");     // Catch: Exception -> L10
        if (r4 == null) goto L21;
        r1.putString("conversation_id", r4);     // Catch: Exception -> L10
        r1.putString("argConversationId", r4);     // Catch: Exception -> L10
    L21:
        String r5 = r22.get("enter_method");     // Catch: Exception -> L10
        if (r5 == null) goto L24;
        r1.putString("enter_method", r5);     // Catch: Exception -> L10
    L24:
        String r6 = r22.get("current_page");     // Catch: Exception -> L10
        if (r6 == null) goto L27;
        r1.putString("current_page", r6);     // Catch: Exception -> L10
    L27:
        String r7 = r22.get("click_from");     // Catch: Exception -> L10
        if (r7 == null) goto L30;
        r1.putString("click_from", r7);     // Catch: Exception -> L10
    L30:
        String r8 = r22.get("suggested_action_provider");     // Catch: Exception -> L10
        if (r8 == null) goto L33;
        r1.putString("suggested_action_provider", r8);     // Catch: Exception -> L10
    L33:
        String r9 = r22.get("inject_input_initial_text");     // Catch: Exception -> L10
        if (r9 == null) goto L36;
        r1.putString("inject_input_initial_text", r9);     // Catch: Exception -> L10
    L36:
        String r10 = r22.get("inject_input_initial_attachment_snapshot_id");     // Catch: Exception -> L10
        if (r10 == null) goto L39;
        r1.putString("inject_input_initial_attachment_snapshot_id", r10);     // Catch: Exception -> L10
    L39:
        String r11 = r22.get("inject_input_mobile_preview_host_enabled");     // Catch: Exception -> L10
        if (r11 == null) goto L44;
        Boolean r12 = StringsKt.toBooleanStrictOrNull(r11);     // Catch: Exception -> L10
        if (r12 == null) goto L44;
        r1.putBoolean("inject_input_mobile_preview_host_enabled", r12.booleanValue());     // Catch: Exception -> L10
    L44:
        String r13 = r22.get("inject_input_album_node_id");     // Catch: Exception -> L10
        if (r13 == null) goto L47;
        r1.putString("inject_input_album_node_id", r13);     // Catch: Exception -> L10
    L47:
        String r14 = r22.get("inject_input_upstream_album_node_id");     // Catch: Exception -> L10
        if (r14 == null) goto L50;
        r1.putString("inject_input_upstream_album_node_id", r14);     // Catch: Exception -> L10
    L50:
        String r15 = r22.get("inject_input_hide_album_entrance");     // Catch: Exception -> L10
        if (r15 == null) goto L55;
        Boolean r16 = StringsKt.toBooleanStrictOrNull(r15);     // Catch: Exception -> L10
        if (r16 == null) goto L55;
        r1.putBoolean("inject_input_hide_album_entrance", r16.booleanValue());     // Catch: Exception -> L10
    L55:
        String r18 = r22.get("inject_input_initial_attachment_uris");     // Catch: Exception -> L10
        if (r18 != null) goto L59;
    L93:
        r3.setArguments(r1);     // Catch: Exception -> L10
        r2 = this;
        r3.getLifecycle().addObserver(new InjectInputServiceProxy$createInputFragment$2(r2, r3));     // Catch: Exception -> L97
        r2.d = r3;     // Catch: Exception -> L97
        return r3;
    L97:
        e = e;
        goto L101
    L59:
        if (r18.length() <= 0) goto L61;
        boolean r19 = true;
    L62:
        if (r19 == true) goto L65;
        r18 = null;
    L65:
        if (r18 == null) goto L93;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L80
        JSONArray r24 = new JSONArray(r18);     // Catch: Throwable -> L80
        ArrayList r25 = new ArrayList();     // Catch: Throwable -> L80
        int r26 = r24.length();     // Catch: Throwable -> L80
        int r27 = 0;
    L67:
        if (r27 >= r26) goto L78;
        String r28 = r24.optString(r27);     // Catch: Throwable -> L80
        if (r28.length() <= 0) goto L71;
        boolean r29 = true;
    L72:
        if (r29 == true) goto L75;
        r28 = null;
    L75:
        if (r28 == null) goto L77;
        r25.add(r28);     // Catch: Throwable -> L80
    L77:
        r27 = r27 + 1;     // Catch: Throwable -> L80
        goto L67
    L71:
        r29 = false;
        goto L72
    L78:
        Object r30 = Result.constructor-impl(r25);     // Catch: Throwable -> L80
    L83:
        if (Result.isFailure-impl(r30) == false) goto L85;
        r30 = null;
    L85:
        ArrayList<String> r31 = (ArrayList) r30;     // Catch: Exception -> L10
        if (r31 != null) goto L88;
    L90:
        r31 = null;
    L91:
        if (r31 == null) goto L93;
        r1.putStringArrayList("inject_input_initial_attachment_uris", r31);     // Catch: Exception -> L10
        goto L93
    L88:
        if ((!r31.isEmpty()) == false) goto L90;
    L80:
        th = move-exception;
        Result.Companion r32 = Result.Companion;     // Catch: Exception -> L10
        r30 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L10
        goto L83
    L61:
        r19 = false;
    L99:
        e = e;
        r2 = this;
        goto L101
    }
}
