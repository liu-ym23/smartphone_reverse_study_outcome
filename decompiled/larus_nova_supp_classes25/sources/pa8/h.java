package pa8;

import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.location.dto.AddressComponent;
import com.ss.android.lark.location.dto.POIInfo;
import ew4.o;
import ew4.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h implements gqb.a {
    public final /* synthetic */ p a;
    public final /* synthetic */ g b;

    public final void b() {
        FLogger.a.i("FlowLocationHostService", "map location canceled or back pressed");
    }

    public h(p r1, g r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(FragmentActivity r19, POIInfo r20) {
        Intrinsics.checkNotNullParameter(r19, "activity");
        p r1 = this.a;
        String r2 = null;
        if (r20 == null) goto L27;
        this.b.getClass();
        double r5 = r20.getLatitude();
        double r7 = r20.getLongitude();
        String r9 = r20.getLocationName();
        String r10 = r20.getLocationAddress();
        AddressComponent r4 = r20.getAddressComponent();
        if (r4 == null) goto L7;
        String r11 = r4.getProvince();
    L8:
        AddressComponent r6 = r20.getAddressComponent();
        if (r6 == null) goto L11;
        String r12 = r6.getCity();
    L12:
        AddressComponent r8 = r20.getAddressComponent();
        if (r8 == null) goto L15;
        String r13 = r8.getDistrict();
    L16:
        AddressComponent r14 = r20.getAddressComponent();
        if (r14 == null) goto L19;
        r2 = r14.getTownship();
    L19:
        String r15 = r2;
        int r3 = r20.getErrorCode();
        if (r3 != 40100) goto L22;
        int r16 = 2;
    L26:
        r2 = new o(r5, r7, r9, r10, r11, r12, r13, r15, null, r16, r20.getErrorMsg());
        goto L27
    L22:
        if (r3 == 40400) goto L24;
        r16 = 0;
        goto L26
    L24:
        r16 = 3;
        goto L26
    L15:
        r13 = null;
        goto L16
    L11:
        r12 = null;
        goto L12
    L7:
        r11 = null;
    L27:
        r1.a(r2);
    }
}
