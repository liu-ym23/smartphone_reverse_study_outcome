package iqb;

import android.graphics.Bitmap;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location_ui.picklocation.LocationView;
import com.ss.android.lark.location_ui.picklocation.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements IPickLocationMap.c {
    public final /* synthetic */ POIInfo a;
    public final /* synthetic */ LocationView b;

    @Override // com.ss.android.lark.location.service.IPickLocationMap.c
    public final void onMapScreenShot(Bitmap r6) {
        LocationView r0 = this.b;
        POIInfo r1 = this.a;
        String[] r2 = LocationView.y;
        r0.k.J3(r0.b, r6, new q(r0, r1));
    }

    public n(LocationView r1, POIInfo r2) {
        this.b = r1;
        this.a = r2;
    }
}
