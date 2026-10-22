package hz9;

import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static String a(Message r1, String r2, boolean r3, String r4) {
        StringBuilder r0 = new StringBuilder();
        if (r1 == null) goto L5;
        String r5 = r1.getMessageId();
    L6:
        r0.append(r5);
        r0.append('_');
        r0.append(r2);
        r0.append('_');
        r0.append(r3);
        r0.append('_');
        r0.append(r4);
        return r0.toString();
    L5:
        r5 = null;
        goto L6
    }

    public static /* synthetic */ String b(Message r0, String r1, boolean r2, int r3) {
        if ((r3 & 4) == 0) goto L6;
        r2 = false;
    L6:
        return a(r0, r1, r2, null);
    }
}
