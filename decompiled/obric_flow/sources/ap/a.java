package ap;

import com.lynx.tasm.behavior.utils.d;
import com.obric.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements to.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f712a;

    public /* synthetic */ a(int r5) {
        this.f712a = r5;
    }

    @Override // to.a
    public final String a(Object r11) {
        switch(this.f712a) {
            case 0: goto L75;
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L27;
            case 4: goto L26;
            default: goto L4;
        };
    L4:
        StackTraceElement[] r12 = (StackTraceElement[]) r11;
        StringBuilder r10 = new StringBuilder(256);
        if (r12 != null) goto L7;
    L23:
        return null;
    L7:
        if (r12.length == 0) goto L23;
        int r5 = 0;
        if (r12.length == 1) goto L90;
        int r13 = r12.length;
    L13:
        if (r5 >= r13) goto L91;
        if (r5 != 0) goto L18;
        r10.append("\n");
    L18:
        if (r5 == (r13 - 1)) goto L20;
        r10.append("\t├ ");
        r10.append(r12[r5].toString());
        r10.append("\n");
    L21:
        r5 = r5 + 1;
        goto L13
    L20:
        r10.append("\t└ ");
        r10.append(r12[r5].toString());
        goto L21
    L91:
        return r10.toString();
    L90:
        return "\t─ " + r12[0].toString();
    L27:
        String r14 = (String) r11;
        if (r14 == null) goto L45;
        if (r14.trim().length() == 0) goto L45;
    L34:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:".concat(r14), e);
    L32:
        if (r14.startsWith("{") == false) goto L37;
        return new JSONObject(r14).toString(4);
    L37:
        if (r14.startsWith("[") == false) goto L41;
        return new JSONArray(r14).toString(4);
    L41:
        throw new FormatException("JSON should start with { or [, but found ".concat(r14));     // Catch: Exception -> L34
    L45:
        throw new FormatException("JSON empty.");
    L48:
        String[] r15 = (String[]) r11;
        if (r15 != null) goto L51;
        return "";
    L51:
        if (r15.length == 0) goto L94;
        String[] r16 = new String[r15.length];
        int r17 = r15.length;
        int r18 = 0;
        int r19 = 0;
    L54:
        if (r18 >= r17) goto L59;
        String r20 = r15[r18];
        if (r20 == null) goto L58;
        r16[r19] = r20;
        r19 = r19 + 1;
    L58:
        r18 = r18 + 1;
        goto L54
    L59:
        if (r19 == 0) goto L95;
        StringBuilder r110 = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════\n");
        int r111 = 0;
    L62:
        if (r111 >= r19) goto L74;
        String r21 = r16[r111];
        StringBuilder r22 = new StringBuilder(r21.length() + 10);
        String[] r23 = r21.split("\n");
        int r24 = r23.length;
        int r25 = 0;
    L64:
        if (r25 >= r24) goto L68;
        if (r25 == 0) goto L67;
        r22.append("\n");
    L67:
        String r26 = r23[r25];
        r22.append(9553);
        r22.append(r26);
        r25 = r25 + 1;
        goto L64
    L68:
        r110.append(r22.toString());
        if (r111 == (r19 - 1)) goto L71;
        r110.append("\n╟───────────────────────────────────────────────────────────────────────────────────────────────────\n");
    L72:
        r111 = r111 + 1;
        goto L62
    L71:
        r110.append("\n╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L72
    L74:
        return r110.toString();
    L95:
        return "";
    L94:
        return "";
    L75:
        StringBuffer r112 = new StringBuffer("Thread: ");
        r112.append(((Thread) r11).getName());
        return r112.toString();
    L26:
        return d.l((Throwable) r11);
    L47:
        return (String) r11;
    }
}
