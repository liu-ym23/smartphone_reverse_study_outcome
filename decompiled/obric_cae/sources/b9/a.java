package b9;

import android.os.Handler;
import android.os.Looper;
import androidx.work.t;
import com.bytedance.applog.priority.PriorityCallback;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements t, c4.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f3133c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3135b;

    public a(int r8) {
        this.f3134a = r8;
        if (r8 != 1) goto L5;
        this.f3135b = Handler.createAsync(Looper.getMainLooper());
        return;
    L5:
        if (r8 == 3) goto L8;
        this.f3135b = new ConcurrentHashMap();
        return;
    L8:
        this.f3135b = new Hashtable();
    }

    public static boolean b(char r8) {
        if (r8 > ' ') goto L5;
    L9:
        return false;
    L5:
        if (r8 >= 127) goto L9;
        if ("()<>@,;:/[]?=\\\"".indexOf(r8) >= 0) goto L9;
        return true;
    }

    public static int c(int r8, String r10) {
        int r11 = r10.length();
    L3:
        if (r8 >= r11) goto L7;
        if (Character.isWhitespace(r10.charAt(r8)) == false) goto L7;
        r8 = r8 + 1;
    L7:
        return r8;
    }

    @Override // c4.a
    public final void a(String r8, ge.a r10) {
        StringBuilder r11 = defpackage.b.h("Priority-", r8, ": ");
        r11.append((String) r10.f());
        String r12 = r11.toString();
        ((PriorityCallback) this.f3135b).printLog(2, r12);
    }

    public final String toString() {
        int r8 = this.f3134a;
        Object r10 = this.f3135b;
        switch(r8) {
            case 3: goto L8;
            case 4: goto L7;
            default: goto L5;
        };
    L8:
        StringBuffer r11 = new StringBuffer();
        Hashtable r12 = (Hashtable) r10;
        r11.ensureCapacity(r12.size() * 16);
        Enumeration r13 = r12.keys();
    L10:
        if (r13.hasMoreElements() == false) goto L26;
        String r14 = (String) r13.nextElement();
        r11.append("; ");
        r11.append(r14);
        r11.append('=');
        String r15 = (String) r12.get(r14);
        int r16 = r15.length();
        int r17 = 0;
        int r18 = 0;
        boolean r19 = false;
    L12:
        if (r18 >= r16) goto L15;
        if (r19 == true) goto L15;
        r19 = !b(r15.charAt(r18));
        r18 = r18 + 1;
    L15:
        if (r19 == false) goto L24;
        StringBuffer r20 = new StringBuffer();
        r20.ensureCapacity((int) (((double) r16) * 1.5d));
        r20.append('\"');
    L17:
        if (r17 >= r16) goto L23;
        char r21 = r15.charAt(r17);
        if (r21 == '\\') goto L21;
        if (r21 == '\"') goto L21;
    L22:
        r20.append(r21);
        r17 = r17 + 1;
    L21:
        r20.append('\\');
        goto L22
    L23:
        r20.append('\"');
        r15 = r20.toString();
    L24:
        r11.append(r15);
        goto L10
    L26:
        return r11.toString();
    L5:
        return super.toString();
    L7:
        return "<" + ((String) r10) + '>';
    }

    public a(String r12, int r13) {
        this.f3134a = r13;
        if (r13 == 4) goto L76;
        this.f3135b = new Hashtable();
        if (r12 == null) goto L101;
        int r14 = r12.length();
        if (r14 <= 0) goto L102;
        int r8 = c(0, r12);
    L11:
        if (r8 >= r14) goto L72;
        if (r12.charAt(r8) != ';') goto L72;
        int r10 = c(r8 + 1, r12);
        if (r10 >= r14) goto L103;
        int r11 = r10;
    L18:
        if (r11 >= r14) goto L22;
        if (b(r12.charAt(r11)) == false) goto L22;
        r11 = r11 + 1;
    L22:
        String r15 = r12.substring(r10, r11).toLowerCase(Locale.ENGLISH);
        int r16 = c(r11, r12);
        if (r16 >= r14) goto L71;
        if (r12.charAt(r16) != '=') goto L71;
        int r17 = c(r16 + 1, r12);
        if (r17 >= r14) goto L69;
        char r18 = r12.charAt(r17);
        if (r18 != '\"') goto L58;
        int r19 = r17 + 1;
        if (r19 >= r14) goto L56;
        int r20 = r19;
    L34:
        if (r20 >= r14) goto L41;
        r18 = r12.charAt(r20);
        if (r18 == '\"') goto L41;
        if (r18 != '\\') goto L40;
        r20 = r20 + 1;
    L40:
        r20 = r20 + 1;
    L41:
        if (r18 != '\"') goto L54;
        String r21 = r12.substring(r19, r20);
        int r22 = r21.length();
        StringBuffer r23 = new StringBuffer();
        r23.ensureCapacity(r22);
        int r24 = 0;
        boolean r25 = false;
    L43:
        if (r24 >= r22) goto L52;
        char r110 = r21.charAt(r24);
        if (r25 == true) goto L48;
        if (r110 == '\\') goto L48;
        r23.append(r110);
    L51:
        r24 = r24 + 1;
    L48:
        if (r25 == false) goto L50;
        r23.append(r110);
        r25 = false;
        goto L51
    L50:
        r25 = true;
        goto L51
    L52:
        String r26 = r23.toString();
        int r27 = r20 + 1;
    L65:
        ((Hashtable) this.f3135b).put(r15, r26);
        r8 = c(r27, r12);
        goto L11
    L54:
        throw new h7.b("Encountered unterminated quoted parameter value.");
    L56:
        throw new h7.b("Encountered unterminated quoted parameter value.");
    L58:
        if (b(r18) == false) goto L67;
        r27 = r17;
    L60:
        if (r27 >= r14) goto L64;
        if (b(r12.charAt(r27)) == false) goto L64;
        r27 = r27 + 1;
    L64:
        r26 = r12.substring(r17, r27);
        goto L65
    L67:
        throw new h7.b(defpackage.a.d("Unexpected character encountered at index ", r17));
    L69:
        throw new h7.b(defpackage.b.c("Couldn't find a value for parameter named ", r15));
    L71:
        throw new h7.b("Couldn't find the '=' that separates a parameter name from its value.");
    L103:
        return;
    L72:
        if (r8 < r14) goto L75;
        return;
    L75:
        throw new h7.b("More characters encountered in input than expected.");
    L102:
        return;
    L101:
        return;
    L76:
        this.f3135b = r12;
    }
}
