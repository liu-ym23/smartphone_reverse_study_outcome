package qha;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.y0;
import com.obric.assistant.common.spi.IObricUIService;
import com.obric.assistant.impl.databinding.ObricItemCustomActionbarNormalHolderBinding;
import com.obric.assistant.view.actionbar.custom.ObricActionBarSegmentCell;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class e implements ss8.e, ss8.f {
    public final t1a.b a;
    public final Context b;
    public final String c;

    public static final class a {
    }

    static {
    }

    public final boolean g() {
        return true;
    }

    public z0 j(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return r2;
    }

    public abstract String k();

    public abstract int m();

    public aq8.e n() {
        return null;
    }

    public com.larus.bmhome.actionbar.model.r o() {
        return null;
    }

    public abstract long p();

    public abstract int q();

    public abstract int r();

    public List a() {
        return i();
    }

    public final List<z0> i() {
        String r0 = y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r()));
        long r7 = p();
        String r11 = k();
        Resources r1 = getContext().getResources();
        if (r1 == null) goto L5;
        String r2 = r1.getString(q());
    L6:
        String r14 = r2;
        int r16 = m();
        g1 r3 = new g1(null, r0, null, null, 29);
        g1 r4 = new g1(null, r0, null, null, 29);
        com.larus.bmhome.actionbar.model.r r20 = o();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("KEY_FILE_OR_WEB_ADDRESS", l());
        return CollectionsKt.listOf(j(new z0(Long.valueOf(r7), r11, r3, r4, r14, null, Integer.valueOf(r16), null, null, null, r20, null, true, r5, null, 536805280, 13)));
    L5:
        r2 = null;
        goto L6
    }

    public final String toString() {
        return k();
    }

    public Context getContext() {
        return this.b;
    }

    public String l() {
        return this.c;
    }

    public boolean h(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return Intrinsics.areEqual(r2.b, k());
    }

    public List b(BotModel r2, wc9.e r3) {
        Intrinsics.checkNotNullParameter(r2, "bot");
        Intrinsics.checkNotNullParameter(r3, "conversation");
        return i();
    }

    public boolean d(z0 r2, z0 r3) {
        Intrinsics.checkNotNullParameter(r2, "old");
        Intrinsics.checkNotNullParameter(r3, "next");
        return false;
    }

    public e(t1a.b r2, Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "address");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public void e(BaseActionBarHolder r4, z0 r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "item");
        if ((r4 instanceof ObricActionBarSegmentCell) == false) goto L5;
        ObricActionBarSegmentCell r7 = (ObricActionBarSegmentCell) r4;
    L6:
        if (r7 == null) goto L18;
        String r0 = r5.e;
        String r1 = "";
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        g1 r2 = r5.c;
        if (r2 == null) goto L16;
        String r3 = r2.b;
        if (r3 == null) goto L16;
        r1 = r3;
    L16:
        r7.U3(r0, r1, r5, r6);
        return;
    L18:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public BaseActionBarHolder f(ViewGroup r6, t1 r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "defaultClickCallback");
        ObricItemCustomActionbarNormalHolderBinding r9 = ObricItemCustomActionbarNormalHolderBinding.a(LayoutInflater.from(r6.getContext()), r6);
        IObricUIService r1 = (IObricUIService) ServiceManager.get().getService(IObricUIService.class);
        if (r1 == null) goto L5;
        r1.na(new TextView[]{r9.d, r9.e});
    L5:
        Intrinsics.checkNotNullParameter(r9, "binding");
        Intrinsics.checkNotNullParameter(r7, "defaultClickCallback");
        return new ObricActionBarSegmentCell(r9, r7, r8, n());
    }
}
