package mlb;

import android.graphics.Bitmap;
import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public String a;
    public String b;
    public Bitmap c;
    public a d;

    public interface a {
        void a(ArrayList<QRCodeResultInfo> r1);

        void onError(String r1);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("from:");
        r0.append(this.a);
        r0.append(",path:");
        r0.append(this.b);
        r0.append(",bitmap is null:");
        boolean r2 = true;
        if (this.c != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(",callback is null:");
        if (this.d == null) goto L10;
        r2 = false;
    L10:
        r0.append(r2);
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public d() {
        this.a = LocationHitPoint$ResultType.DEFAULT;
    }
}
