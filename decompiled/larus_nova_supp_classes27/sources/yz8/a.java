package yz8;

import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.account.phone.PhoneLogin;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;
import wb7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends yb7.f {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ PhoneLogin b;
    public final /* synthetic */ String c;
    public final /* synthetic */ LoginPlatform d;

    public final void b(ua7.e<j> r4) {
        if (r4 == null) goto L10;
        j r5 = r4.p;
        if (r5 == null) goto L10;
        com.ss.android.account.d r6 = r5.e;
        if (r6 == null) goto L10;
        boolean r0 = true;
        if (((sc7.a) r6).g != true) goto L10;
    L11:
        n38.h r7 = this.a;
        this.b.getClass();
        r7.b(LoginPlatform.PHONE, this.c, Boolean.valueOf(r0));
        return;
    L10:
        r0 = false;
        goto L11
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public final void a(ua7.e<j> r13, int r14) {
        String r0 = null;
        if (r13 == null) goto L7;
        JSONObject r1 = ((ua7.b) r13).m;
        if (r1 == null) goto L7;
        Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("raw_data", r1.toString())});
    L8:
        n38.h r2 = this.a;
        LoginPlatform r3 = this.d;
        if (r13 == null) goto L12;
        String r4 = ((ua7.b) r13).i;
        if (r4 == null) goto L12;
    L13:
        String r5 = r4;
        String r6 = this.c;
        Integer r8 = Integer.valueOf(r14);
        if (r13 == null) goto L16;
        r0 = ((ua7.b) r13).i;
    L16:
        n38.h.a.a(r2, r3, r14, r5, r6, null, r8, r0, r10, 32);
        return;
    L12:
        r4 = "";
    L7:
        r10 = null;
        goto L8
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }

    public a(LoginServiceImpl.d r1, PhoneLogin r2, String r3, LoginPlatform r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
