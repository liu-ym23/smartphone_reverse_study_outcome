package ai0;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureState;
import com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements e {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
        new CompositeDisposable();
    }

    public final boolean c() {
        AdventureContext.Companion.getClass();
        return AdventureContext.a.a();
    }

    public final AdventureState a(DataCenter r3) {
        AdventureContext.Companion.getClass();
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L7;
        ih0.b r4 = r0.dynamicService(r3);
        if (r4 == null) goto L7;
        JsonObject r5 = r4.Nm();
    L8:
        if (r5 != null) goto L11;
        return null;
    L11:
        return (AdventureState) GsonProtectorUtils.fromJson(new Gson(), r5, AdventureState.class);
    L7:
        r5 = null;
        goto L8
    }

    public final boolean b(boolean r2) {
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r0 = g.a;
        if (g.f == false) goto L7;
        if (r2 == false) goto L7;
        f2.b(2131918682, 0);
    L7:
        return g.f;
    }

    public static void d(TextView r4, String r5) {
        r4.setTextColor(Color.parseColor("#FFFFFF"));     // Catch: Exception -> L5
    L15:
        int r0 = Color.parseColor(r5);     // Catch: Exception -> L11
        Drawable r2 = r4.getBackground();     // Catch: Exception -> L11
        if (r2 == null) goto L9;
        r2.setColorFilter(r0, PorterDuff.Mode.SRC);     // Catch: Exception -> L11
    L9:
        r4.setBackground(r2);     // Catch: Exception -> L11
        return;
    L11:
        ALogger.i("AdventureOutService", "text background color parse error: ".concat(r5));
        return;
    L5:
        ALogger.i("AdventureOutService", "text color parse error: #FFFFFF");
        goto L15
    }
}
