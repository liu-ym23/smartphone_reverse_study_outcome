package ct0;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.ExtraInfo;
import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.profile.standard.honour.items.StandardHonourCardView;
import com.bytedance.android.live.profile.standard.honour.items.standardv3.StandardHonourCardViewV3;
import com.bytedance.android.live.profile.ui.base.h;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class a implements bt0.a {
    public h a;

    /* JADX INFO: renamed from: ct0.a$a, reason: collision with other inner class name */
    public static final class C0227a {
    }

    static {
    }

    public a() {
    }

    @Override // bt0.a
    public bt0.b i() {
        return null;
    }

    @Override // bt0.a
    public final void m() {
    }

    @Override // bt0.a
    public final void b(HonorWallElement r2) {
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
    }

    @Override // bt0.a
    public void j(HonorWallElement r4) {
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        ExtraInfo r0 = r4.getExtraInfo();
        if (r0 == null) goto L18;
        String r1 = r0.getShowEvent();
        if (r1 == null) goto L20;
        ExtraInfo r5 = r4.getExtraInfo();
        if (r5 == null) goto L10;
        Map r6 = r5.getShowEventParams();
    L11:
        LinkedHashMap r2 = new LinkedHashMap();
        if (r6 == null) goto L14;
        r2.putAll(r6);
    L14:
        h r7 = this.a;
        if (r7 == null) goto L19;
        r7.sendLog(r1, r2, new Object[0]);
        return;
    L19:
        return;
    L10:
        r6 = null;
        goto L11
    L20:
        return;
    }

    @Override // bt0.a
    public final void k(HonorWallElement r2) {
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
    }

    @Override // com.bytedance.android.live.profile.profilecontext.c
    public final void setProfileContext(h r1) {
        this.a = r1;
    }

    public static void r(a r2, HonorWallElement r3) {
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "elementInfo");
        ExtraInfo r0 = r3.getExtraInfo();
        if (r0 == null) goto L18;
        String r1 = r0.getClickEvent();
        if (r1 == null) goto L20;
        ExtraInfo r4 = r3.getExtraInfo();
        if (r4 == null) goto L10;
        Map r5 = r4.getClickEventParams();
    L11:
        LinkedHashMap r6 = new LinkedHashMap();
        if (r5 == null) goto L14;
        r6.putAll(r5);
    L14:
        h r7 = r2.a;
        if (r7 == null) goto L19;
        r7.sendLog(r1, r6, new Object[0]);
        return;
    L19:
        return;
    L10:
        r5 = null;
        goto L11
    L20:
        return;
    }

    @Override // bt0.a
    public View e(h r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r4.getTargetUser().useStandardHonorWallV3() == false) goto L6;
        return new StandardHonourCardViewV3(r5, null, 6, 0);
    L6:
        return new StandardHonourCardView(r5, null, 6, 0);
    }

    @Override // bt0.a
    public final boolean o(HonorWallElement r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
        Intrinsics.checkNotNullParameter(r3, "profileContext");
        ExtraInfo r4 = r2.getExtraInfo();
        if (r4 != null) goto L7;
        return true;
    L7:
        return r4.isDismissAfterClick();
    }

    @Override // bt0.a
    public final boolean n(HonorWallElement r2, NewProfileUser r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "elementInfo");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "profileContext");
        ExtraInfo r5 = r2.getExtraInfo();
        if (r5 != null) goto L7;
        return false;
    L7:
        return r5.isCanClick();
    }

    @Override // bt0.a
    public void d(Fragment r2, View r3, HonorWallElement r4, NewProfileUser r5, h r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "honourCardView");
        Intrinsics.checkNotNullParameter(r4, "elementInfo");
        Intrinsics.checkNotNullParameter(r5, "user");
        Intrinsics.checkNotNullParameter(r6, "profileContext");
        r(this, r4);     // Catch: Exception -> L13
        ExtraInfo r7 = r4.getExtraInfo();     // Catch: Exception -> L13
        if (r7 == null) goto L12;
        String r8 = r7.getScheme();     // Catch: Exception -> L13
        if (r8 == null) goto L22;
        IBaseLiveActionHandler r9 = k.f(IBaseLiveActionHandler.class);     // Catch: Exception -> L13
        if (r9 == null) goto L23;
        r9.handle(r3.getContext(), r8);     // Catch: Exception -> L13
        return;
    L23:
        return;
    L22:
        return;
    L12:
        return;
    L13:
        e = move-exception;
        StringBuilder r10 = new StringBuilder("handle schame: ");
        ExtraInfo r12 = r4.getExtraInfo();
        if (r12 == null) goto L17;
        String r13 = r12.getScheme();
    L18:
        r10.append(r13);
        r10.append(", error: ");
        r10.append(e.getMessage());
        ALogger.e("StandardHonourCardItem", r10.toString());
        SafetyGuard.a(null, e, null);
        return;
    L17:
        r13 = null;
        goto L18
    }
}
