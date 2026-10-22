package kqb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.f;
import com.ss.android.lark.location_ui.picklocation.LocationFragment;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.p;
import com.ss.android.lark.location_ui.picklocation.q;
import com.ss.android.lark.ui.IActionTitlebar;
import com.ss.android.lark.utils.UIHelper;
import iqb.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class b extends IActionTitlebar.TextAction {
    public long a;

    public b(String r3) {
        super(r3, 2131103554);
        this.a = 0;
    }

    public final void performAction(View r8) {
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.a) <= 1000) goto L37;
        p r9 = (p) this;
        KeyboardUtils.hideKeyboard(r9.b.b);
        iqb.a r2 = r9.b.l;
        if (r2 == null) goto L15;
        List<POIInfo> r3 = r2.b;
        if (r3 == null) goto L15;
        Iterator<POIInfo> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L15;
        POIInfo r5 = r4.next();
        if (r5.getIsCurrent() == false) goto L11;
    L16:
        if (r5 == null) goto L32;
        r9.b.n.getVendor();
        r5.setVendor("gaode");
        r5.setZoomLevel(r9.b.n.getZoomLevel());
        if (TextUtils.isEmpty(r5.getLocationAddress()) == false) goto L21;
        r5.setLocationAddress(r5.getLocationName());
    L21:
        if (r9.b.g.isSnapshot() == false) goto L31;
        LocationView r10 = r9.b;
        r10.getClass();
        if (d.a() == true) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == false) goto L30;
        int r7 = UIHelper.dp2px(100.0f);
        int r11 = UIHelper.getColor(2131100545);
        Bitmap r12 = Bitmap.createBitmap(r7, r7, Bitmap.Config.RGB_565);
        new Canvas(r12).drawColor(r11);
        r10.k.J3(r10.b, r12, new q(r10, r5));
        goto L32
    L30:
        r10.n.n(new n(r10, r5));
        goto L32
    L25:
        if (f.a().isGmsEnabled() == true) goto L27;
        r6 = true;
        goto L28
    L31:
        ((LocationFragment.a) r9.b.a).a(r5);
    L32:
        this.a = r0;
        return;
    L15:
        r5 = null;
        goto L16
    }
}
