package com.larus.bmhome.view.actionbar.edit.kmp;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import cq8.z0;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wa8.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Function0<Context> a;
    public final Fragment b;
    public final AttachReceiver c;
    public final wp8.c d;

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.kmp.a$a, reason: collision with other inner class name */
    public static final class C0048a {
    }

    static {
    }

    public final JSONObject a() {
        if (p.a(s1a.d.a(this.c)) == false) goto L5;
        Fragment r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L9;
        Bundle r2 = r0.getArguments();
    L10:
        JSONObject r3 = new JSONObject();
        r3.put("app_enter_method", "action_bar");
        if (r2 == null) goto L14;
        String r4 = r2.getString("from_entrance");
        if (r4 == null) goto L14;
    L15:
        r3.put("from_entrance", r4);
        if (r2 == null) goto L19;
        String r5 = r2.getString("app_key");
        if (r5 == null) goto L19;
    L20:
        r3.put("app_key", r5);
        if (r2 == null) goto L24;
        String r6 = r2.getString("app_name");
        if (r6 == null) goto L24;
    L25:
        r3.put("app_name", r6);
        if (r2 == null) goto L34;
        String r7 = r2.getString(MusicAppletPage.KEY_MESSAGE_ID);
        if (r7 == null) goto L34;
        if ((!StringsKt.isBlank(r7)) == false) goto L32;
        r1 = r7;
    L32:
        if (r1 == null) goto L34;
        r3.put("doubao_apps_message_id", r1);
    L34:
        return r3;
    L24:
        r6 = "AI 写歌";
    L19:
        r5 = MusicAppletPage.APP_ID;
    L14:
        r4 = "self";
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        return new JSONObject();
    }

    public final String b() {
        if (p.a(s1a.d.a(this.c)) == false) goto L5;
        return "template_page";
    L5:
        return "chat";
    }

    public final void c(dq8.a r45) {
        z0 r1 = r45.d;
        com.larus.bmhome.actionbar.model.a r0 = r45.b;
        Map r2 = c0.a;
        c0.a(r0.d, ActionBarItemLocation.DETAIL_PANEL, null);
        String r5 = r1.a;
        String r6 = r1.c;
        String r7 = r1.d;
        String r8 = r1.f;
        String r9 = r1.g;
        String r12 = r0.b;
        String r13 = String.valueOf(r0.a);
        Boolean r3 = r1.i;
        String r4 = r1.h;
        String r27 = b();
        tx9.b.e(r5, r6, r7, r8, r9, null, null, r12, r13, 0, 0, null, "select", null, null, null, a(), null, "chat", null, null, null, r27, r4, r3, null, null, null, null, null, null, null, null, null, null, null, null, -59316128, 127);
    }

    public a(j r2, Fragment r3, AttachReceiver r4, wp8.c r5) {
        Intrinsics.checkNotNullParameter(r2, "uiContext");
        Intrinsics.checkNotNullParameter(r4, "attachReceiver");
        Intrinsics.checkNotNullParameter(r5, "instructionCoreAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
