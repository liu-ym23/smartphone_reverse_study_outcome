package gh0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final String c() {
        return k.n(IMiddlewareUserService.class).user().n();
    }

    public static final boolean d() {
        Boolean r0 = m.i().isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public static final boolean e(List<? extends LinkmicPositionItem> r11, List<? extends LinkmicPositionItem> r12) {
        if (r11 == null) goto L5;
        int r1 = r11.size();
    L6:
        if (r12 == null) goto L8;
        int r2 = r12.size();
    L9:
        if (r1 == r2) goto L11;
        return false;
    L11:
        if (r11 == null) goto L13;
        int r3 = r11.size();
    L15:
        if (r3 != 0) goto L17;
        return true;
    L17:
        if (r11 == null) goto L40;
        if (r12 == null) goto L40;
        int r4 = r11.size();
        int r5 = 0;
    L20:
        if (r5 >= r4) goto L40;
        LinkmicPositionItem r6 = (LinkmicPositionItem) ListProtector.get(r11, r5);
        LinkmicPositionItem r7 = (LinkmicPositionItem) ListProtector.get(r12, r5);
        Intrinsics.checkNotNullParameter(r6, "$this$isChange");
        if (r7 != null) goto L25;
    L35:
        boolean r8 = false;
    L37:
        if (r8 == true) goto L38;
        r5 = r5 + 1;
        goto L20
    L38:
        return false;
    L25:
        if (r6.getPosition() == r7.getPosition()) goto L27;
    L36:
        r8 = true;
        goto L37
    L27:
        if (r6.getPositionType() != r7.getPositionType()) goto L36;
        if (r6.getStatus() != r7.getStatus()) goto L36;
        if (r6.getVerifyStatus() != r7.getVerifyStatus()) goto L36;
        if (TextUtils.equals(r6.getActiveName(), r7.getActiveName()) == true) goto L35;
    L40:
        return true;
    L13:
        r3 = 0;
        goto L15
    L8:
        r2 = 0;
        goto L9
    L5:
        r1 = 0;
        goto L6
    }

    public static final boolean f(List<ILinkPlayerInfoBridge> r6, List<ILinkPlayerInfoBridge> r7) {
        if (r6 == null) goto L5;
        int r1 = r6.size();
    L6:
        if (r7 == null) goto L8;
        int r2 = r7.size();
    L9:
        if (r1 == r2) goto L11;
        return false;
    L11:
        if (r6 == null) goto L13;
        int r3 = r6.size();
    L15:
        if (r3 != 0) goto L17;
        return true;
    L17:
        if (r6 != null) goto L20;
        if (r7 != null) goto L20;
        return true;
    L20:
        if (r6 == null) goto L28;
        if (r7 == null) goto L28;
        int r4 = r6.size();
        int r5 = 0;
    L23:
        if (r5 >= r4) goto L28;
        if (((ILinkPlayerInfoBridge) ListProtector.get(r6, r5)).isEqual((ILinkPlayerInfoBridge) ListProtector.get(r7, r5)) == false) goto L26;
        r5 = r5 + 1;
        goto L23
    L26:
        return false;
    L28:
        return true;
    L13:
        r3 = 0;
        goto L15
    L8:
        r2 = 0;
        goto L9
    L5:
        r1 = 0;
        goto L6
    }

    public static final void a(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "content");
        if (r1 != null) goto L5;
        String r4 = "LinkDataMerge";
    L6:
        if (r3 == false) goto L8;
        ALogger.d(r4, r2);
        return;
    L8:
        ALogger.i(r4, r2);
        return;
    L5:
        r4 = "LinkDataMerge#".concat(r1);
        goto L6
    }

    public static /* synthetic */ void b(String r0, String r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r0 = null;
    L5:
        a(r0, r1, false);
    }
}
