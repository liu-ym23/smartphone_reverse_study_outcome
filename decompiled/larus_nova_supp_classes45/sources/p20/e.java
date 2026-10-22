package p20;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.bmf_mods_lite_api.exception.BmfException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static String a;
    public static final List<a> b = null;
    public static final List<Object> c = null;

    public static final class a {
        public final String a;
        public final int b;
        public final String c;
        public final String d;
        public final String e;

        public a() {
            this(null, null, null, null, 31);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L16;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.b) * 31;
            String r4 = this.c;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.d;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r11 = this.e;
            if (r11 == null) goto L18;
            r1 = r11.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "DebugJsbInfo(jsbMethodName=" + this.a + ", statueCode=" + this.b + ", callBackId=" + this.c + ", jsbRequestParam=" + this.d + ", jsbCallBackInfo=" + this.e + ")";
        }

        public /* synthetic */ a(String r9, String r11, String r12, String r13, int r14) {
            if ((r14 & 1) == 0) goto L5;
            String r3 = "";
        L7:
            if ((r14 & 2) == 0) goto L9;
            int r4 = BmfException.INPUT_PARAM_INVALID;
        L11:
            if ((r14 & 4) == 0) goto L13;
            r11 = "-1";
        L13:
            String r5 = r11;
            if ((r14 & 8) == 0) goto L16;
            String r6 = "";
        L18:
            if ((r14 & 16) == 0) goto L20;
            String r7 = "";
        L21:
            this(r3, r4, r5, r6, r7);
            return;
        L20:
            r7 = r13;
            goto L21
        L16:
            r6 = r12;
            goto L18
        L9:
            r4 = 0;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public a(String r2, int r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "callBackId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
        a = "";
        b = new ArrayList();
        c = new ArrayList();
        if (v.a() == false) goto L7;
        Observable.create(f.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(g.a, h.a);
        return;
    }

    public static boolean a() {
        if (v.a() == true) goto L5;
    L7:
        return false;
    L5:
        if ((!Intrinsics.areEqual(a, "")) == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final void b(String r9) {
        Intrinsics.checkNotNullParameter(r9, LiveSlardarConstants.EXTRA_KEY_URL);
        if (v.a() == false) goto L5;
    L42:
        int r1 = r9.length();     // Catch: Exception -> L39
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L17;
        if (r9.charAt(r3) != '{') goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L18;
        r3 = r3 + 1;     // Catch: Exception -> L39
    L18:
        int r2 = r9.length() - 1;     // Catch: Exception -> L39
    L19:
        if (r2 < 0) goto L27;
        if (r9.charAt(r2) != '}') goto L23;
        boolean r7 = true;
    L24:
        if (r7 == true) goto L28;
        r2 = r2 - 1;     // Catch: Exception -> L39
    L28:
        if (r3 == (-1)) goto L38;
        if (r2 == (-1)) goto L48;
        JSONObject r4 = new JSONObject(r9.substring(r3, r2 + 1));     // Catch: Exception -> L39
        String r5 = r4.optString("__callback_id");     // Catch: Exception -> L39
        JSONObject r8 = r4.optJSONObject("__params");     // Catch: Exception -> L39
        if (Intrinsics.areEqual(r4.optString("__msg_type"), "callback") == false) goto L49;
        ALogger.i("DebugHybridTools", "getResultFromLoadUrl-> jsbInfo=" + r8 + " ， url" + r9);     // Catch: Exception -> L39
        a r11 = new a(null, r5, null, r8.toString(), 11);     // Catch: Exception -> L39
        Intrinsics.checkNotNullParameter(r11, "jsbInfo");     // Catch: Exception -> L39
        if (a() == false) goto L50;
        ALogger.i("DebugHybridTools", "addResultJsbCallInfo-> jsbInfo=" + r11);     // Catch: Exception -> L39
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L38:
        return;
    L23:
        r7 = false;
        goto L24
    L27:
        r2 = -1;
        goto L28
    L13:
        r6 = false;
        goto L14
    L17:
        r3 = -1;
    L39:
        e = move-exception;
        ALogger.e("DebugHybridTools", e);
        return;
    L5:
        if (StringsKt.startsWith$default(r9, "javascript:", false, 2, null) == true) goto L42;
    }
}
