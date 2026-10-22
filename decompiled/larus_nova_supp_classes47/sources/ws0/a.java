package ws0;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import jc1.k;
import n56.c;
import n56.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c {
    public final WeakReference<Context> a;

    /* JADX INFO: renamed from: ws0.a$a, reason: collision with other inner class name */
    public static final class C0340a {
    }

    static {
    }

    public a(WeakReference r1) {
        this.a = r1;
    }

    public void call(f r18, JSONObject r19) {
        if (r18 == null) goto L53;
        if (r19 == null) goto L53;
        if (r18.d == null) goto L53;
        r19.put(Constants.OperatorKey.CODE, 0);
        JSONObject r0 = r18.d;
        String r5 = r0.optString("type");
        if (TextUtils.isEmpty(r5) == false) goto L13;
        r19.put(Constants.OperatorKey.CODE, 0);
        return;
    L13:
        if (r0.has("args") == false) goto L15;
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(r0, "args");
    L16:
        if (r5 == null) goto L54;
        if (r5.hashCode() != (-309425751)) goto L54;
        if (r5.equals("profile") == false) goto L54;
        if (r1 != null) goto L25;
        r1 = new JSONObject();
    L25:
        String r6 = r1.optString("user_id");
        if (TextUtils.isEmpty(r6) == false) goto L28;
        r19.put(Constants.OperatorKey.CODE, 0);
        goto L54
    L28:
        String r7 = r1.optString("sec_user_id");
        if (TextUtils.isEmpty(r7) == false) goto L31;
        r7 = r1.optString("sec_uid");
    L31:
        String r9 = r1.optString("source");
        String r12 = r1.optString("click_user_position");
        String r13 = r1.optString("vs_follow_position");
        String r15 = r1.optString("mystery_man");
        HashMap r8 = new HashMap();
        if (TextUtils.isEmpty(r7) == true) goto L35;
        r8.put("sec_user_id", r7);
    L35:
        if (TextUtils.isEmpty(r9) == true) goto L38;
        r8.put("source", r9);
    L38:
        if (TextUtils.isEmpty(r12) == true) goto L41;
        r8.put("click_user_position", r12);
    L41:
        if (TextUtils.isEmpty(r13) == true) goto L44;
        r8.put("vs_follow_position", r13);
    L44:
        if (TextUtils.isEmpty(r15) == true) goto L46;
        r8.put("mystery_man", r15);
    L46:
        IBaseLiveActionHandler r3 = k.n(IBaseLiveActionHandler.class);
        WeakReference<Context> r10 = this.a;
        if (r10 == null) goto L49;
        Context r14 = r10.get();
    L50:
        r19.put(Constants.OperatorKey.CODE, r3.showUserProfileExt(r14, r6, r1.optString("type"), r8) ? 1 : 0);
        return;
    L49:
        r14 = null;
    L54:
        return;
    L15:
        r1 = null;
    }
}
