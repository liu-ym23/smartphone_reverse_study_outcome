package dl0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final String a(List<? extends LinkPlayerInfo> r6, List<? extends LinkPlayerInfo> r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "anchorUsers");
        Intrinsics.checkNotNullParameter(r7, "anchorOppoUsers");
        Intrinsics.checkNotNullParameter(r8, "anchorId");
        Intrinsics.checkNotNullParameter(r9, "guestAnchorId");
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L34
        JSONArray r2 = new JSONArray();     // Catch: JSONException -> L34
        boolean r4 = false;
        if (r8.length() <= 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L19;
        Iterator<T> r10 = r6.iterator();     // Catch: JSONException -> L34
    L10:
        if (r10.hasNext() == false) goto L17;
        IBaseUser r5 = ((LinkPlayerInfo) r10.next()).getUser();     // Catch: JSONException -> L34
        if (r5 == null) goto L15;
        String r11 = r5.getIdString();     // Catch: JSONException -> L34
        if (r11 == null) goto L15;
    L16:
        r2.put(r11);     // Catch: JSONException -> L34
    L15:
        r11 = "";
        goto L16
    L17:
        r1.put(r8, r2);     // Catch: JSONException -> L34
    L19:
        if (r9.length() <= 0) goto L21;
        r4 = true;
    L21:
        if (r4 == false) goto L32;
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L34
        Iterator<T> r13 = r7.iterator();     // Catch: JSONException -> L34
    L24:
        if (r13.hasNext() == false) goto L31;
        IBaseUser r14 = ((LinkPlayerInfo) r13.next()).getUser();     // Catch: JSONException -> L34
        if (r14 == null) goto L29;
        String r15 = r14.getIdString();     // Catch: JSONException -> L34
        if (r15 == null) goto L29;
    L30:
        r12.put(r15);     // Catch: JSONException -> L34
    L29:
        r15 = "";
        goto L30
    L31:
        r1.put(r9, r12);     // Catch: JSONException -> L34
    L32:
        return r1.toString();
    L6:
        r3 = false;
    L34:
        return "";
    }
}
