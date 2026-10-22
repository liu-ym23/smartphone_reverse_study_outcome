package gz1;

import android.text.TextUtils;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.f;
import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.model.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final boolean c(n r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isUnlocked");
        if (r1.getLockInfo() == null) goto L10;
        CardLockInfo r2 = r1.getLockInfo();
        if (r2 != null) goto L7;
    L9:
        return false;
    L7:
        if (r2.getLockStatus() != CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L9;
    L10:
        return true;
    }

    public static final String a(p r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "$this$findCardName");
        if (r5 != null) goto L22;
        return null;
    L22:
        ArrayList<e3> r6 = c.d(new JSONArray(r5));     // Catch: JSONException -> L21
        Iterator<T> r1 = r4.getForceIndexCards().iterator();
    L8:
        if (r1.hasNext() == false) goto L13;
        n r2 = (n) r1.next();
        if (c.h(r6, c.g(r2)) == false) goto L8;
        return r2.getCardName();
    L13:
        Iterator<T> r7 = r4.getCards().iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        n r3 = (n) r7.next();
        if (c.h(r6, c.g(r3)) == false) goto L15;
        return r3.getCardName();
    L20:
        return null;
    }

    public static final boolean b(e r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$isMd5Matched");
        if (TextUtils.equals(r3, r2.getMD5()) == true) goto L31;
        f r0 = r2.castToOrNull(f.class);
        String r1 = null;
        if (r0 == null) goto L7;
        j r4 = r0.getH265ResourceModel();
    L8:
        if (r4 == null) goto L17;
        f r5 = r2.castToOrNull(f.class);
        if (r5 == null) goto L14;
        j r6 = r5.getH265ResourceModel();
        if (r6 == null) goto L14;
        String r7 = r6.getMd5();
    L16:
        if (TextUtils.equals(r3, r7) == true) goto L31;
    L14:
        r7 = null;
    L17:
        f r8 = r2.castToOrNull(f.class);
        if (r8 == null) goto L20;
        k r9 = r8.getH265SuperResourceModel();
    L21:
        if (r9 == null) goto L30;
        f r10 = r2.castToOrNull(f.class);
        if (r10 == null) goto L28;
        k r11 = r10.getH265SuperResourceModel();
        if (r11 == null) goto L28;
        r1 = r11.getMd5();
    L28:
        if (TextUtils.equals(r3, r1) == true) goto L31;
    L30:
        return false;
    L20:
        r9 = null;
        goto L21
    L7:
        r4 = null;
    L31:
        return true;
    }
}
