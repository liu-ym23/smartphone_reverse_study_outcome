package d5;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
import x4.j0;
import x4.x0;

/* JADX INFO: loaded from: classes.dex */
public final class r extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f6824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j0 f6825f;

    public r(Context r8, j0 r10) {
        super(true, true);
        this.f6824e = r8;
        this.f6825f = r10;
    }

    @Override // d5.d
    public final boolean a(JSONObject r8) {
        x0.h(r8, "language", this.f6824e.getResources().getConfiguration().locale.getLanguage());
        int r10 = TimeZone.getDefault().getRawOffset() / 3600000;
        if (r10 >= (-12)) goto L6;
        r10 = -12;
    L6:
        if (r10 <= 12) goto L8;
        r10 = 12;
    L8:
        r8.put("timezone", r10);
        k5.k.a r11 = k5.k.f8943a;
        this.f6825f.H.getClass();
        x0.h(r8, "region", Locale.getDefault().getCountry());
        TimeZone r12 = Calendar.getInstance().getTimeZone();
        x0.h(r8, "tz_name", r12.getID());
        r8.put("tz_offset", r12.getOffset(System.currentTimeMillis()) / 1000);
        return true;
    }
}
