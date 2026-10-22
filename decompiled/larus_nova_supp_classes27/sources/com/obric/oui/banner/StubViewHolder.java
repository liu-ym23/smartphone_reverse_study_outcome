package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/banner/StubViewHolder;", "Lcom/obric/oui/banner/BannerViewHolder;", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class StubViewHolder extends BannerViewHolder {
    public static final a g = null;

    public static final class a implements e {
        public a() {
        }

        @Override // com.obric.oui.banner.e
        public final StubViewHolder a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            View r0 = new View(r3.getContext());
            r0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            return new StubViewHolder(r0);
        }
    }

    static {
        g = new a();
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public final void U3(b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public StubViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }
}
