package com.larus.bmhome.view.actionbar.custom.router;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements b {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "schemaUrl");
        return StringsKt.contains$default(r5, "sslocal://flow/realtime_chat", false, 2, null);
    }

    @Override // com.larus.bmhome.view.actionbar.custom.router.b
    public final boolean a(BaseContentWidget r20, String r21, Bundle r22) {
        Intrinsics.checkNotNullParameter(r21, "schemaUrl");
        Intrinsics.checkNotNullParameter(r22, "commonArgs");
        Uri r1 = UriProtector.parse(r21);
        String r2 = y0.f(r1, "target_scene");
        if (r2 == null) goto L5;
        int r11 = CastIntegerProtector.parseInt(r2);
    L7:
        if (r20 == null) goto L9;
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Fragment r3 = com.larus.ui.arch.component.internal.attach.a.b(r20, r20);
    L11:
        if ((r3 instanceof ChatFragment) == false) goto L13;
        ChatFragment r4 = (ChatFragment) r3;
    L14:
        if (r4 != null) goto L17;
        return false;
    L17:
        ChatParam r5 = r4.m;
        y r0 = s1a.d.a(r20).getAbility(y.class);
        if (r0 == null) goto L20;
        wc9.e r6 = r0.h();
    L21:
        String r7 = y0.f(r1, MusicAppletPage.KEY_CONVERSATION_ID);
        if (r7 != null) goto L26;
        if (r6 == null) goto L25;
        r7 = r6.a;
        goto L26
    L25:
        String r8 = null;
    L27:
        String r9 = y0.f(r1, "last_section_id");
        if (r9 != null) goto L32;
        if (r6 == null) goto L31;
        r9 = r6.B;
        goto L32
    L31:
        String r10 = null;
    L33:
        String r12 = y0.f(r1, "last_message_id");
        if (r12 == null) goto L37;
        Long r13 = StringsKt.toLongOrNull(r12);
        if (r13 == null) goto L37;
    L39:
        Long r14 = r13;
    L41:
        String r15 = y0.f(r1, "bot_say_hello_text_key");
        String r16 = y0.f(r1, "trigger_hello");
        String r17 = y0.f(r1, "open_vlm");
        String r18 = y0.f(r1, "track_params");
        String r19 = y0.f(r1, "session_extra");
        LocalSubConvHelper r23 = LocalSubConvHelper.a;
        Map r24 = LocalSubConvHelper.d(r8);
        FLogger r25 = FLogger.a;
        StringBuilder r26 = new StringBuilder("yyytrack scheme start ");
        r26.append(r1);
        r26.append(" , enter_method ");
        r26.append(y0.f(r1, "enter_method"));
        r26.append(", botId ");
        r26.append(r5.b);
        r26.append(" , valid_track_params ");
        r26.append(!TextUtils.isEmpty(r18));
        r25.i("RealtimeCallRouterProcessor", r26.toString());
        LifecycleOwnerKt.getLifecycleScope(r4).launchWhenResumed(new RealtimeCallRouterProcessor$handleRoute$1(r5, r4, r6, r22, r24, r8, r10, r14, r11, r15, r16, r17, r18, r19, null));
        return true;
    L37:
        if (r6 == null) goto L40;
        r13 = r6.q;
        goto L39
    L40:
        r14 = null;
    L32:
        r10 = r9;
    L26:
        r8 = r7;
        goto L27
    L20:
        r6 = null;
        goto L21
    L13:
        r4 = null;
        goto L14
    L9:
        r3 = null;
        goto L11
    L5:
        r11 = -1;
        goto L7
    }
}
