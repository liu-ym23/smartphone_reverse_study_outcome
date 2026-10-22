package hob;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class c {
    public static final /* synthetic */ int k = 0;
    public final String a;
    public String b;
    public String c;
    public boolean d;
    public final boolean e;
    public boolean f;
    public RichTextElement.AtProperty g;
    public Map<String, String> h;
    public boolean i;
    public boolean j;

    public static final class a {
        @JvmStatic
        public static c a(RichTextElement.AtProperty r8) {
            Intrinsics.checkNotNullParameter(r8, "atProperty");
            String r1 = r8.getUserId();
            if (r1 != null) goto L5;
            String r3 = "";
        L6:
            String r2 = r8.getAtContent();
            if (r2 == null) goto L12;
            String r4 = r2.substring(1);
            if (r4 == null) goto L12;
            String r5 = r4;
        L13:
            String r6 = r8.getOriginUserName();
            if (r6 != null) goto L16;
            String r7 = "";
        L17:
            String r9 = r3;
            String r10 = r5;
            String r11 = r7;
            c r0 = new c(r9, r10, r11, r8.isOutChatUser(), r8.isAnonymous());
            r0.g = r8;
            r0.j = r8.isHighLight();
            return r0;
        L16:
            r7 = r6;
        L12:
            r5 = "";
            goto L13
        L5:
            r3 = r1;
            goto L6
        }
    }

    static {
    }

    public c(String r2, String r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "chatterName");
        Intrinsics.checkNotNullParameter(r4, "chatterOriginName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = true;
    }
}
