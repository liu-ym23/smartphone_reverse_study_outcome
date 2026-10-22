package at;

import com.ss.android.agilelogger.formatter.FormatException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ys.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f720a;

    public /* synthetic */ a(int r5) {
        this.f720a = r5;
    }

    @Override // ys.a
    public final String a(Object r11) {
        switch(this.f720a) {
            case 0: goto L76;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L33;
            case 4: goto L31;
            default: goto L4;
        };
    L4:
        String[] r12 = (String[]) r11;
        if (r12 != null) goto L7;
        return "";
    L7:
        if (r12.length == 0) goto L91;
        String[] r5 = new String[r12.length];
        int r10 = r12.length;
        int r13 = 0;
        int r14 = 0;
    L10:
        if (r13 >= r10) goto L15;
        String r15 = r12[r13];
        if (r15 == null) goto L14;
        r5[r14] = r15;
        r14 = r14 + 1;
    L14:
        r13 = r13 + 1;
        goto L10
    L15:
        if (r14 == 0) goto L92;
        StringBuilder r16 = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════\n");
        int r17 = 0;
    L18:
        if (r17 >= r14) goto L30;
        String r18 = r5[r17];
        StringBuilder r19 = new StringBuilder(r18.length() + 10);
        String[] r20 = r18.split("\n");
        int r21 = r20.length;
        int r22 = 0;
    L20:
        if (r22 >= r21) goto L24;
        if (r22 == 0) goto L23;
        r19.append("\n");
    L23:
        String r23 = r20[r22];
        r19.append(9553);
        r19.append(r23);
        r22 = r22 + 1;
        goto L20
    L24:
        r16.append(r19.toString());
        if (r17 == (r14 - 1)) goto L27;
        r16.append("\n╟───────────────────────────────────────────────────────────────────────────────────────────────────\n");
    L28:
        r17 = r17 + 1;
        goto L18
    L27:
        r16.append("\n╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L28
    L30:
        return r16.toString();
    L92:
        return "";
    L91:
        return "";
    L31:
        StringBuffer r110 = new StringBuffer("Thread: ");
        r110.append(((Thread) r11).getName());
        return r110.toString();
    L33:
        StackTraceElement[] r111 = (StackTraceElement[]) r11;
        StringBuilder r112 = new StringBuilder(256);
        if (r111 != null) goto L36;
    L52:
        return null;
    L36:
        if (r111.length == 0) goto L52;
        int r24 = 0;
        if (r111.length == 1) goto L93;
        int r25 = r111.length;
    L42:
        if (r24 >= r25) goto L94;
        if (r24 != 0) goto L47;
        r112.append("\n");
    L47:
        if (r24 == (r25 - 1)) goto L49;
        r112.append("\t├ ");
        r112.append(r111[r24].toString());
        r112.append("\n");
    L50:
        r24 = r24 + 1;
        goto L42
    L49:
        r112.append("\t└ ");
        r112.append(r111[r24].toString());
        goto L50
    L94:
        return r112.toString();
    L93:
        return "\t─ " + r111[0].toString();
    L56:
        String r113 = (String) r11;
        if (r113 == null) goto L74;
        if (r113.trim().length() == 0) goto L74;
    L63:
        e = move-exception;
        throw new FormatException("Parse JSON error. JSON string:".concat(r113), e);
    L61:
        if (r113.startsWith("{") == false) goto L66;
        return new JSONObject(r113).toString(4);
    L66:
        if (r113.startsWith("[") == false) goto L70;
        return new JSONArray(r113).toString(4);
    L70:
        throw new FormatException("JSON should start with { or [, but found ".concat(r113));     // Catch: Exception -> L63
    L74:
        throw new FormatException("JSON empty.");
    L55:
        return sk.a.h((Throwable) r11);
    L76:
        return (String) r11;
    }
}
