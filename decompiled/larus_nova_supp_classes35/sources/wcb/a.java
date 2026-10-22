package wcb;

import android.graphics.RectF;
import android.view.View;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.export.empty.EmptyProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.tangram.base.style.TCStyle;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import vcb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends e<BaseProperty, LKUIRoundableLayout, r6c.a> {
    public final String i() {
        return "com.larksuite.component.ui.layout.LKUIRoundableLayout";
    }

    public final boolean j() {
        return false;
    }

    public final View a(RectF r5) {
        Intrinsics.checkNotNullParameter(r5, "size");
        r6c.a r1 = ((q6c.a) this).a;
        if (r1 == null) goto L6;
        LKUIRoundableLayout r6 = new LKUIRoundableLayout(r1.getContext(), null, 6, 0);
        r6.setTag(2131392636, ((q6c.a) this).b);
        return r6;
    L6:
        Intrinsics.checkNotNullParameter(r5, "size");
        return null;
    }

    public void update(LKUIRoundableLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (r4.getId() != 2131382951) goto L5;
        r4.setBackground(null);
        r4.setBackgroundColor(UDColorUtils.getColor(r4.getContext(), 2131100557));
    L5:
        r4.setOnClickListener(null);
        r4.setClickable(false);
    }

    public /* bridge */ /* synthetic */ void update(View r1) {
        update((LKUIRoundableLayout) r1);
    }

    public a(EmptyProperty r2, TCStyle r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "props");
        Intrinsics.checkNotNullParameter(r4, "dependency");
        super(r2, r3, r4);
    }
}
