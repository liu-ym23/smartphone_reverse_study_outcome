package p38;

import com.larus.login.impl.y3;
import com.larus.utils.logger.FLogger;
import n38.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends va7.b {
    public final /* synthetic */ o a;

    public a(y3 r1) {
        this.a = r1;
    }

    public final void onSuccess(ua7.b r5) {
        xa7.b r6 = (xa7.b) r5;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("checkOldPhoneUnusable isMnoSupport:");
        String r2 = null;
        if (r6 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r6.r);
    L6:
        r1.append(r3);
        r1.append(" isUnusable:");
        if (r6 == null) goto L9;
        Boolean r4 = Boolean.valueOf(r6.p);
    L10:
        r1.append(r4);
        r1.append(" isVerified:");
        if (r6 == null) goto L13;
        Boolean r7 = Boolean.valueOf(r6.q);
    L14:
        r1.append(r7);
        r1.append(" getTicket:");
        if (r6 == null) goto L17;
        String r8 = r6.s;
    L18:
        r1.append(r8);
        r0.i("ChangePhoneManager", r1.toString());
        o r9 = this.a;
        boolean r10 = false;
        if (r6 == null) goto L21;
        boolean r11 = r6.r;
    L22:
        if (r6 == null) goto L24;
        r10 = r6.p;
    L24:
        if (r6 == null) goto L26;
        r2 = r6.s;
    L26:
        r9.onSuccess(r11, r10, r2);
        return;
    L21:
        r11 = false;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onError(ua7.b r4, int r5) {
        xa7.b r6 = (xa7.b) r4;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("checkOldPhoneUnusable error:");
        r1.append(r5);
        r1.append(':');
        if (r6 == null) goto L5;
        String r7 = ((ua7.b) r6).i;
    L6:
        r1.append(r7);
        r0.w("ChangePhoneManager", r1.toString());
        this.a.onFailed();
        return;
    L5:
        r7 = null;
        goto L6
    }
}
