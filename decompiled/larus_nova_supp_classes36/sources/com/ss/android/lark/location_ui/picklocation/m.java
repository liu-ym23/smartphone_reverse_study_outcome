package com.ss.android.lark.location_ui.picklocation;

import androidx.appcompat.content.res.AppCompatResources;
import com.ss.android.lark.location.service.IPickLocationMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements IPickLocationMap.d {
    public final /* synthetic */ LocationView a;

    public final void a() {
        LocationView r0 = this.a;
        r0.c = true;
        r0.mIvLocatePosition.setImageDrawable(AppCompatResources.getDrawable(r0.b, 2131243878));
    }

    public m(LocationView r1) {
        this.a = r1;
    }
}
