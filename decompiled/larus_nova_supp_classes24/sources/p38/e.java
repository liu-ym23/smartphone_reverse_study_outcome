package p38;

import com.larus.login.impl.s3;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import n38.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e extends va7.d {
    public final /* synthetic */ s a;

    public e(s3 r1) {
        this.a = r1;
    }

    public final void onSuccess(ua7.b r6) {
        xa7.e r7 = (xa7.e) r6;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getAvailableVerifyWays isHasOauth:");
        List<String> r2 = null;
        if (r7 == null) goto L5;
        Boolean r3 = Boolean.valueOf(r7.s);
    L6:
        r1.append(r3);
        r1.append(" oauthPlatforms:");
        if (r7 == null) goto L9;
        List r4 = r7.w;
    L10:
        r1.append(r4);
        r1.append(" token:");
        if (r7 == null) goto L13;
        String r5 = r7.x;
    L14:
        r1.append(r5);
        r0.i("ChangePhoneManager", r1.toString());
        boolean r8 = false;
        if (r7 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L34;
        if (r7 == null) goto L27;
        List r10 = r7.w;
        if (r10 == null) goto L27;
        int r11 = f.a;
        if (r10.contains("aweme_v2") != true) goto L27;
        r8 = true;
    L27:
        if (r8 == false) goto L34;
        s r12 = this.a;
        if (r7 == null) goto L31;
        r2 = r7.w;
    L31:
        if (r2 != null) goto L33;
        r2 = CollectionsKt.emptyList();
    L33:
        r12.onSuccess(r2);
        return;
    L34:
        this.a.onFailed();
        return;
    L17:
        if (r7.s != true) goto L19;
        r9 = true;
        goto L20
    L13:
        r5 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onError(ua7.b r4, int r5) {
        xa7.e r6 = (xa7.e) r4;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("getAvailableVerifyWays error:");
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
