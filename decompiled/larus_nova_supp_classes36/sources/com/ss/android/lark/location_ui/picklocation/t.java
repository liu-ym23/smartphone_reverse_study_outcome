package com.ss.android.lark.location_ui.picklocation;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.content.res.AppCompatResources;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class t implements AdapterView.OnItemClickListener {
    public final /* synthetic */ LocationView a;

    public t(LocationView r1) {
        this.a = r1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        kqb.e.b(LocationHitPoint$ResultType.LIST);
        POIInfo r5 = this.a.l.a(r3);
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getLocationName()) == true) goto L9;
        LocationView r6 = this.a;
        r6.mIvLocatePosition.setImageDrawable(AppCompatResources.getDrawable(r6.b, 2131243878));
        LocationView.k(this.a, r5, !r5.getIsSelfDefine());
        LocationView.h(this.a, r3);
        return;
    }
}
