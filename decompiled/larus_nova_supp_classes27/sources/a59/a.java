package a59;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public a() {
    }

    public static ItemGroup a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        ItemGroup r0 = new ItemGroup(r2.getContext());
        r0.setBackgroundResource(2131238744);
        r2.addView(r0);
        ViewGroup.LayoutParams r3 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r4 = (LinearLayout.LayoutParams) r3;
        r4.width = -1;
        r4.height = -1;
        return r0;
    }

    public static ItemTextArrow b(ItemGroup r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "group");
        Intrinsics.checkNotNullParameter(r3, "text");
        ItemTextArrow r0 = new ItemTextArrow(r2.getContext());
        r0.setText(r3);
        r0.setTextFontWeight(500);
        r2.addView(r0);
        ViewGroup.LayoutParams r4 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) r4;
        r5.width = -1;
        r5.height = -2;
        return r0;
    }
}
