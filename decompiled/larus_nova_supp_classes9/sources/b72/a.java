package b72;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.cert.token.TokenCert;
import ec2.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final TokenCert a = null;
    public static final TokenCert b = null;
    public static final TokenCert c = null;
    public static final TokenCert d = null;
    public static final TokenCert e = null;
    public static final Integer f = null;

    static {
        TokenCert.Companion r0 = TokenCert.Companion;
        a = r0.with("bpea-live_audiocomment_check_permssion_v1");
        b = r0.with("bpea-live_audiocomment_req_permssion");
        c = r0.with("bpea-live_audio_comment_record");
        d = r0.with("bpea-live_audio_comment_record_stop");
        e = r0.with("bpea-live_audio_comment_record_release");
        f = (Integer) s.a.getValue();
    }

    public static boolean b(Activity r4) {
        if (k.n(IMiddlewareUserService.class).user().isLogin() == true) goto L10;
        if (r4 != null) goto L7;
        f2.b(2131915986, 0);
        return false;
    L7:
        com.bytedance.android.livesdk.user.e r0 = k.n(IMiddlewareUserService.class).user();
        l.a r2 = new l.a();
        r2.a = s1.B(2131920126);
        r2.d = "comment_live";
        r2.c = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        r0.login(r4, new l(r2)).subscribe(new com.bytedance.android.livesdk.user.h());
        return false;
    L10:
        if (k.n(IMiddlewareUserService.class).user().g(LiveInteractFunction.COMMENT) == false) goto L13;
        i40.h.a("v3 send click error, user intercepted");
        return false;
    L13:
        return true;
    }

    public static int d(boolean r0) {
        if (r0 == false) goto L5;
        return 15;
    L5:
        return f.intValue();
    }

    public static void e(boolean r3) {
        if (r3 == false) goto L5;
        String r4 = s1.B(2131917602);
    L6:
        f2.c(r4, 1);
        return;
    L5:
        r4 = s1.C(2131917443, new Object[]{f});
        goto L6
    }

    public static int c(GradientEditText r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "editText");
        Intrinsics.checkNotNullParameter(r8, "editText");
        Editable r0 = r8.getText();
        if (r0 == null) goto L5;
        CharSequence r1 = r0;
    L6:
        int r2 = TextUtils.getTrimmedLength(r1);
        int r3 = d(r9);
        c.a r4 = c.a(r0, r3);
        if (r4 == null) goto L9;
        int r5 = r4.a;
        r2 = r4.b;
        int r6 = r5;
    L10:
        if (r2 <= r3) goto L12;
        r8.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(r1.length())});
    L13:
        if (r2 <= r3) goto L40;
        e(r9);
        int r10 = r1.length();
        if (r6 == 0) goto L17;
        r3 = Math.min(r6, r10);
    L25:
        r8.setText(r1.subSequence(0, r3));
        r8.setSelection(r8.getText().length());     // Catch: Exception -> L28
    L31:
        return r3;
    L28:
        e = move-exception;
        b0 r11 = b0.o();
        StackTraceElement[] r13 = e.getStackTrace();
        r11.getClass();
        com.bytedance.android.live.core.log.g.m(6, r13);
        goto L31
    L17:
        Iterator r14 = ((ArrayList) ab2.a.d(r1)).iterator();
    L19:
        if (r14.hasNext() == false) goto L25;
        db2.a r7 = (db2.a) r14.next();
        if (r7.c <= r3) goto L19;
        int r15 = r7.b;
        if (r3 < r15) goto L19;
        r3 = r15;
        goto L25
    L40:
        return r2;
    L12:
        r8.setFilters(new InputFilter[0]);
        goto L13
    L9:
        r6 = 0;
        goto L10
    L5:
        r1 = BuildConfig.FLAVOR;
        goto L6
    }

    public static void a(List r3, int r4, List r5, StringBuilder r6) {
        Intrinsics.checkNotNullParameter(r3, "originList");
        Intrinsics.checkNotNullParameter(r5, "result");
        Intrinsics.checkNotNullParameter(r6, "sb");
        if (r4 != r3.size()) goto L9;
        Iterator r7 = r3.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        r6.append((String) r7.next());
        goto L6
    L8:
        ArrayList r8 = (ArrayList) r5;
        r8.add(r6.toString());
        StringsKt.clear(r6);
        return;
    L9:
        int r0 = r3.size();
        int r1 = r4;
    L10:
        if (r1 >= r0) goto L15;
        Collections.swap(r3, r1, r4);
        a(r3, r4 + 1, r5, r6);
        Collections.swap(r3, r1, r4);
        r1 = r1 + 1;
        goto L10
    }
}
