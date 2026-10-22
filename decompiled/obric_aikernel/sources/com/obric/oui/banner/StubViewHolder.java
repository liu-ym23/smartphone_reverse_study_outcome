package com.obric.oui.banner;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/oui/banner/StubViewHolder;", "Lcom/obric/oui/banner/BannerViewHolder;", "Lcom/obric/oui/banner/a;", "data", "", "onBind", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Companion", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class StubViewHolder extends BannerViewHolder {
    public static final a Companion = null;

    public static final class a implements c {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        @Override // com.obric.oui.banner.c
        public BannerViewHolder a(ViewGroup r10) {
            Intrinsics.checkNotNullParameter(r10, "parent");
            View r11 = new View(r10.getContext());
            r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Unit r12 = Unit.INSTANCE;
            return new StubViewHolder(r11);
        }

        @Override // com.obric.oui.banner.c
        public String getKey() {
            return "_stub";
        }
    }

    static {
        Companion = new a(null);
    }

    public StubViewHolder(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super(r10);
    }

    @Override // com.obric.oui.banner.BannerViewHolder
    public void onBind(com.obric.oui.banner.a r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
    }
}
