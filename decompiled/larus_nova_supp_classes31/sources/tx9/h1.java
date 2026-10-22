package tx9;

import com.ixigua.lib.track.TrackParams;
import com.larus.trace.CopyContentTypeString;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class h1 {
    public static final String b(String r5) {
        if (r5 == null) goto L9;
        String r6 = StringsKt.trim(r5).toString();
        if (r6 == null) goto L9;
        String r7 = StringsKt.trimStart(r6, new char[]{'.'});
        if (r7 == null) goto L9;
        String r8 = r7.toLowerCase(Locale.ROOT);
    L10:
        if (r8 == null) goto L35;
        int r1 = r8.hashCode();
        if (r1 == 3479) goto L31;
        if (r1 == 103649) goto L27;
        if (r1 == 3213227) goto L24;
        if (r1 == 246938863) goto L21;
        return null;
    L21:
        if (r8.equals("markdown") == true) goto L34;
        return null;
    L34:
        return "md";
    L24:
        if (r8.equals("html") == true) goto L37;
        return null;
    L37:
        return "html";
    L27:
        if (r8.equals("htm") == true) goto L37;
        return null;
    L31:
        if (r8.equals("md") == true) goto L34;
        return null;
    L35:
        return null;
    L9:
        r8 = null;
        goto L10
    }

    public static final void a(String r3, String r4, String r5, String r6, String r7, by7.e r8) {
        String r9 = b(r7);
        if (r9 != null) goto L5;
        return;
    L5:
        by7.a r0 = new by7.a(r3);
        if (r8 == null) goto L8;
        r0.b = r8;
    L8:
        TrackParams r10 = new TrackParams();
        Intrinsics.checkNotNullParameter(r9, "contentSecType");
        JSONObject r11 = new JSONObject();
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r11.put("chat_id", r6);
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r11.put("message_id", r4);
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r11.put("conversation_id", r5);
        r11.put("content_sec_type", r9);
        r11.put("content_type", CopyContentTypeString.CODE);
        TrackParams r12 = r10.merge(r11);
        r0.a.merge(r12);
        r0.b();
    }
}
