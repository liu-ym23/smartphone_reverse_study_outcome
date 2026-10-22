package lo8;

import android.os.SystemClock;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.c;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final HashMap<String, C0116a> a = null;
    public static final Map<String, String> b = null;

    /* JADX INFO: renamed from: lo8.a$a, reason: collision with other inner class name */
    public static final class C0116a {
        public Long a;
        public Long b;

        public C0116a() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0116a) == true) goto L8;
            return false;
        L8:
            C0116a r6 = (C0116a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Long r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Long r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "DeepThinkData(thinkingFirstPackageTime=" + this.a + ", thinkingMainTextFirstPackageTime=" + this.b + ')';
        }

        public C0116a(int r1) {
            this.a = null;
            this.b = null;
        }
    }

    static {
        a = new HashMap();
        b = new LinkedHashMap();
    }

    public static void b(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        Map<String, String> r0 = b;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        if (r1.containsValue(r4.getReplyId()) == true) goto L5;
        return;
    L5:
        HashMap<String, C0116a> r2 = a;
        C0116a r3 = r2.get(r4.getMessageId());
        if (r3 == null) goto L8;
        Long r5 = r3.a;
    L9:
        if (r5 == null) goto L12;
        return;
    L12:
        if (r2.get(r4.getMessageId()) != null) goto L17;
        String r6 = r4.getMessageId();
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r2.put(r6, new C0116a(0));
    L17:
        C0116a r7 = r2.get(r4.getMessageId());
        if (r7 == null) goto L21;
        r7.a = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L21:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public static void c(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        if (((LinkedHashMap) b).containsValue(r5.getReplyId()) == true) goto L5;
        return;
    L5:
        HashMap<String, C0116a> r0 = a;
        C0116a r1 = r0.get(r5.getMessageId());
        if (r1 == null) goto L8;
        Long r2 = r1.b;
    L9:
        if (r2 == null) goto L11;
        return;
    L11:
        boolean r3 = true;
        if (CollectionsKt.listOf(new Integer[]{Integer.valueOf(GuideTipType.FORCE_SHOW), 1}).contains(Integer.valueOf(r5.getContentType())) == false) goto L22;
        String r4 = d.r(r5);
        if (r4 != null) goto L16;
    L19:
        if (r3 == false) goto L22;
        return;
    L16:
        if (r4.length() == 0) goto L19;
        r3 = false;
    L22:
        if (b0.f(r5) == false) goto L25;
        return;
    L25:
        if (r0.get(r5.getMessageId()) != null) goto L30;
        String r6 = r5.getMessageId();
        if (r6 != null) goto L29;
        r6 = "";
    L29:
        r0.put(r6, new C0116a(0));
    L30:
        C0116a r7 = r0.get(r5.getMessageId());
        if (r7 == null) goto L34;
        r7.b = Long.valueOf(SystemClock.elapsedRealtime());
        return;
    L34:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public static JSONObject a(Message r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "msg");
        LruCache<String, CommonParamManager.CommonParam> r0 = CommonParamManager.a;
        CommonParamManager.CommonParam r1 = CommonParamManager.c(r9.getReplyId());
        String r2 = null;
        if (r1 == null) goto L21;
        Long r3 = r1.getSendStartTime();
        if (r3 == null) goto L21;
        long r4 = r3.longValue();
        HashMap<String, C0116a> r5 = a;
        C0116a r6 = r5.get(r9.getMessageId());
        if (r6 == null) goto L21;
        Long r7 = r6.a;
        if (r7 == null) goto L21;
        long r8 = r7.longValue();
        if (r8 >= 0) goto L13;
        return null;
    L13:
        C0116a r11 = r5.get(r9.getMessageId());
        if (r11 == null) goto L16;
        r11.a = -1L;
    L16:
        long r12 = r8 - r4;
        long r13 = SystemClock.elapsedRealtime() - r4;
        JSONObject r14 = new JSONObject();
        r14.put(MusicAppletPage.KEY_MESSAGE_ID, r9.getMessageId());
        CommonParamManager.CommonParam r15 = CommonParamManager.c(r9.getReplyId());
        if (r15 == null) goto L19;
        r2 = r15.getChatType();
    L19:
        r14.put("chat_type", r2);
        r14.put("current_page", r10);
        r14.put("first_token_duration", r12);
        r14.put("total_duration", r13);
        o.a.reportEvent("thinking_progress_thinking_duration", r14);
        c.a("thinking_progress_thinking_duration", r14, true);
        return r14;
    L21:
        return null;
    }
}
