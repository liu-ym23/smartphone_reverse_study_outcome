package yd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements td8.c {
    public final td8.d a;

    /* JADX INFO: renamed from: yd8.a$a, reason: collision with other inner class name */
    public static final class C0097a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public a(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r54, xc8.b r55, xc8.b r56, List<xc8.b> r57) {
        Intrinsics.checkNotNullParameter(r56, "current");
        Intrinsics.checkNotNullParameter(r57, "input");
        if (this.a.Pa() == true) goto L6;
        FLogger.a.i("ForceLoadingWhenStreamingTask", "ForceLoadingWhenStreamingTask: disabled by task context");
        return r57;
    L6:
        FloatChatWindowState r2 = this.a.h();
        if (r2 != null) goto L10;
        return r57;
    L10:
        if (r2 != FloatChatWindowState.Expanded) goto L12;
        return r57;
    L12:
        Iterator<T> r3 = r57.iterator();
    L13:
        String r5 = null;
        if (r3.hasNext() == false) goto L50;
        Object r4 = r3.next();
        xc8.b r8 = (xc8.b) r4;
        Message r9 = r8.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r9) == false) goto L21;
        if (com.larus.bmhome.chat.bean.d.w(r9) == true) goto L21;
    L40:
        boolean r10 = false;
    L41:
        if (r10 == true) goto L43;
    L47:
        boolean r11 = false;
    L48:
        if (r11 == false) goto L13;
    L51:
        xc8.b r6 = (xc8.b) r4;
        if (r6 == null) goto L54;
        Message r12 = r6.getMessage();
    L55:
        if (r12 != null) goto L57;
        FLogger.a.i("ForceLoadingWhenStreamingTask", "ForceLoadingWhenStreamingTask: latestStreamingMessage is null");
    L57:
        if (r12 != null) goto L60;
        return r57;
    L60:
        if (com.larus.bmhome.chat.bean.d.I0(r12) == false) goto L62;
    L100:
        FLogger.a.i("ForceLoadingWhenStreamingTask", "ForceLoadingWhenStreamingTask: lastBlock is loading or thinking");
        return r57;
    L62:
        if (com.larus.bmhome.chat.bean.d.f0(r12) == true) goto L100;
        Iterator<xc8.b> r7 = r57.iterator();
        int r13 = 0;
    L66:
        if (r7.hasNext() == false) goto L71;
        if (Intrinsics.areEqual(r7.next().getMessage(), r12) == true) goto L72;
        r13 = r13 + 1;
    L72:
        if (r13 >= 0) goto L74;
        return r57;
    L74:
        e0 r14 = (e0) AuthModelDelegate.b.e().getValue();
        if (r14 == null) goto L83;
        LaunchInfo r15 = r14.a;
        if (r15 == null) goto L83;
        String r16 = r15.c();
        if (r16 == null) goto L83;
        if ((!StringsKt.isBlank(r16)) == false) goto L83;
    L84:
        if (r16 != null) goto L86;
        r16 = "";
    L86:
        String r18 = r16;
        Map r17 = r12.getBusinessExt();
        if (r17 == null) goto L90;
        String r19 = (String) r17.get("loading_reply_id");
        if (r19 == null) goto L90;
    L91:
        String r40 = r19;
        MessageStatus r110 = MessageStatus.MessageStatus_AVAILABLE;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Map r20 = r12.getBusinessExt();
        if (r20 == null) goto L95;
        r5 = (String) r20.get("waiting_error");
    L95:
        if (Intrinsics.areEqual(r5, "true") == false) goto L97;
        int r111 = 22;
    L98:
        ListProtector.set(r57, r13, xc8.f.f(b0.j(Message.copy$default(r12, null, null, "", 0, r111, r110, 1, false, null, r18, null, null, null, null, null, null, 0, 0, false, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_mock_receiving", "1"), TuplesKt.to("has_custom_loading_text", "1"), TuplesKt.to("key_error_code", "-1"), TuplesKt.to("err_msg", "first pkg timeout err"), TuplesKt.to("key_is_business_error", "0")}), null, null, 0, false, 0, r40, null, false, null, null, 0, null, null, null, -272630389, 31, null), 0)));
        return r57;
    L97:
        r111 = 0;
    L90:
        r19 = r12.getLocalMessageId();
    L83:
        r16 = null;
        goto L84
    L71:
        r13 = -1;
        goto L72
    L54:
        r12 = null;
        goto L55
    L43:
        if (b0.f(r8.getMessage()) == true) goto L47;
        if (com.larus.bmhome.chat.bean.d.Q0(r8.getMessage()) == false) goto L47;
        r11 = true;
    L21:
        if (com.larus.bmhome.chat.bean.d.T(r9) == true) goto L40;
        if (com.larus.bmhome.chat.bean.d.p0(r9) == true) goto L40;
        if (com.larus.bmhome.chat.bean.d.C0(r9) == true) goto L28;
    L30:
        MessageStatus r112 = r9.getMessageStatus();
        if (r112 != null) goto L33;
    L35:
        boolean r113 = false;
    L36:
        if (r113 == false) goto L38;
    L39:
        r10 = true;
        goto L41
    L38:
        if (b0.f(r9) == false) goto L40;
    L33:
        if (r112.isVisible() != true) goto L35;
        r113 = true;
        goto L36
    L28:
        if (r9.getRegenVisible() == true) goto L30;
    L50:
        r4 = null;
        goto L51
    }
}
