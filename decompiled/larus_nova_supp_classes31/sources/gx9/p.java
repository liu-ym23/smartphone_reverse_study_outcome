package gx9;

import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.tencent.open.log.TraceLevel;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class p {
    public static final Type a = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/suggest/impl/utils/WcbMessageUtilsKt$WCB_SUGGEST_ITEM_LIST_TYPE$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/bean/PromptContent$SuggestItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<List<? extends PromptContent.SuggestItem>> {
        public a() {
        }
    }

    static {
        a = new a().getType();
    }

    public static final boolean a(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r0 = r4.getBusinessExt();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("transient_wcb_loading_session_id");
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L15;
        return false;
    L15:
        String r3 = (String) com.larus.bmhome.chat.bean.d.x(r4).get("next_pulse_type");
        if (com.larus.bmhome.chat.bean.d.W0(r4) == false) goto L35;
        if (r3 != null) goto L19;
    L22:
        boolean r5 = true;
    L23:
        if (r5 == true) goto L27;
        if (Intrinsics.areEqual(r3, "1") == false) goto L35;
    L27:
        if (com.larus.bmhome.chat.bean.d.X(r4) == true) goto L35;
        if (com.larus.bmhome.chat.bean.d.W(r4) == true) goto L35;
        if (com.larus.bmhome.chat.bean.d.Y0(r4) == true) goto L35;
        if (com.larus.bmhome.chat.bean.d.X0(r4) == true) goto L35;
        return true;
    L19:
        if (r3.length() == 0) goto L22;
        r5 = false;
    L35:
        return false;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public static final String b(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        StringBuilder r0 = new StringBuilder("(");
        r0.append(r5.getMessageId());
        r0.append('_');
        r0.append(r5.getLocalMessageId());
        r0.append('_');
        r0.append(r5.getMessageStatus());
        r0.append('_');
        r0.append(r5.getMessageStatusLocal());
        r0.append('_');
        r0.append(r5.getContentType());
        r0.append('_');
        boolean r3 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r5) == false) goto L8;
        if (com.larus.bmhome.chat.bean.d.w(r5) == true) goto L8;
    L27:
        r0.append(r3);
        r0.append('_');
        r0.append(r5.getTags());
        r0.append('_');
        r0.append(com.larus.bmhome.chat.bean.d.x(r5).getNextPulseType());
        r0.append(')');
        return r0.toString();
    L8:
        if (com.larus.bmhome.chat.bean.d.T(r5) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.p0(r5) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.C0(r5) == true) goto L15;
    L17:
        MessageStatus r2 = r5.getMessageStatus();
        if (r2 != null) goto L20;
    L22:
        boolean r4 = false;
    L23:
        if (r4 == false) goto L25;
    L26:
        r3 = true;
        goto L27
    L25:
        if (b0.f(r5) == false) goto L27;
    L20:
        if (r2.isVisible() != true) goto L22;
        r4 = true;
        goto L23
    L15:
        if (r5.getRegenVisible() == true) goto L17;
        goto L17
    }
}
