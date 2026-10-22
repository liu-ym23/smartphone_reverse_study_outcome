package sz9;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import zo8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final String a(b r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        zo8.b r1 = r4.c;
    L6:
        if (r1 == null) goto L8;
        String r2 = qz9.a.a(r4.c);
    L20:
        StringBuilder r3 = new StringBuilder();
        if (r4 == null) goto L25;
        Message r5 = r4.a;
        if (r5 == null) goto L25;
        r0 = r5.getMessageId();
    L25:
        r3.append(r0);
        r3.append('_');
        r3.append(r2);
        String r6 = r3.toString();
        FLogger.a.i("CreationGalleryData", "generateCreationKey: " + r6);
        return r6;
    L8:
        boolean r7 = false;
        if (r4 != null) goto L11;
    L13:
        if (r7 == false) goto L19;
        e r8 = r4.d;
        if (r8 == null) goto L17;
        String r9 = r8.k;
    L18:
        r2 = String.valueOf(r9);
        goto L20
    L17:
        r9 = null;
        goto L18
    L19:
        r2 = "0";
        goto L20
    L11:
        if (r4.h != true) goto L13;
        r7 = true;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
