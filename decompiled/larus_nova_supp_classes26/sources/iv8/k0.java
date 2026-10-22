package iv8;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.browsertakeover.cdp.BrowserCdpClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class k0 implements Function1 {
    public final /* synthetic */ BrowserCdpClient a;
    public final /* synthetic */ BrowserCdpClient.h b;
    public final /* synthetic */ Integer c;

    public /* synthetic */ k0(BrowserCdpClient r1, BrowserCdpClient.h r2, Integer r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r12) {
        final BrowserCdpClient r0 = this.a;
        final BrowserCdpClient.h r1 = this.b;
        Integer r2 = this.c;
        JSONObject r13 = (JSONObject) r12;
        Intrinsics.checkNotNullParameter(r13, "response");
        boolean r4 = true;
        Integer r6 = null;
        if (r13.has("error") == true) goto L48;
        JSONObject r14 = r13.optJSONObject("result");
        r0.getClass();
        if (r14 == null) goto L48;
        JSONArray r3 = r14.optJSONArray("entries");
        if (r3 == null) goto L48;
        Integer r15 = BrowserCdpClient.F(r14, "currentIndex");
        if (r15 == null) goto L48;
        int r16 = r15.intValue();
        if (r16 >= r3.length()) goto L48;
        JSONObject r7 = r3.optJSONObject(r16);
        if (r7 == null) goto L48;
        Integer r9 = BrowserCdpClient.F(r7, "id");
        if (r9 == null) goto L48;
        r9.intValue();
        if (r16 <= 0) goto L26;
        JSONObject r10 = r3.optJSONObject(r16 - 1);
        if (r10 == null) goto L26;
        Integer r11 = BrowserCdpClient.F(r10, "id");
    L27:
        int r17 = r16 + 1;
        if (r17 >= r3.length()) goto L32;
        JSONObject r18 = r3.optJSONObject(r17);
        if (r18 == null) goto L32;
        Integer r19 = BrowserCdpClient.F(r18, "id");
    L33:
        Object r5 = r7.opt(ShareType.URL);
        if ((r5 instanceof String) == false) goto L36;
        String r8 = (String) r5;
    L37:
        if (r8 != null) goto L39;
    L46:
        r8 = null;
    L47:
        BrowserCdpClient.g r20 = new BrowserCdpClient.g(r11, r19, r8);
    L49:
        if (r20 != null) goto L51;
        r0.L(new BrowserCdpClient.i(false, false));
        r0.O(r1);
        return Unit.INSTANCE;
    L51:
        String r110 = r20.c;
        if (r110 == null) goto L54;
        r0.I(r110, r1.a.a, r0.y, Integer.valueOf(r1.b));
    L54:
        if (r2 != null) goto L57;
    L60:
        if (r2 == null) goto L64;
        if (r6 == null) goto L64;
        r0.Z(r1, "Page.navigateToHistoryEntry", new JSONObject().put("entryId", r6.intValue()), new q0(r0, r1));
    L76:
        return Unit.INSTANCE;
    L64:
        if (r20.a == null) goto L66;
        boolean r21 = true;
    L68:
        if (r20.b != null) goto L71;
        r4 = false;
    L71:
        r0.L(new BrowserCdpClient.i(r21, r4));
        if (r20.c != null) goto L74;
        r0.O(r1);
        goto L76
    L74:
        r0.l(r1, false);
        goto L76
    L66:
        r21 = false;
        goto L68
    L57:
        if (r2.intValue() >= 0) goto L59;
        r6 = r20.a;
        goto L60
    L59:
        r6 = r20.b;
        goto L60
    L39:
        if ((!StringsKt.isBlank(r8)) == true) goto L41;
    L43:
        boolean r22 = false;
    L44:
        if (r22 == false) goto L46;
    L41:
        if (r8.length() > 8192) goto L43;
        r22 = true;
        goto L44
    L36:
        r8 = null;
    L32:
        r19 = null;
    L26:
        r11 = null;
    L48:
        r20 = null;
        goto L49
    }
}
