package pg8;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends bd8.b {
    public TextView l;

    public b() {
        super(true, 0);
    }

    @Override // bd8.b
    public final void C() {
        TextView r0 = this.l;
        if (r0 == null) goto L6;
        e1.o(r0);
        return;
    }

    @Override // bd8.b
    public final boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return Intrinsics.areEqual(r2.getBizContentType(), "deep_search_card");
    }

    @Override // bd8.b
    public final void w(Message r3, int r4, ec8.b r5) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r3, "message");
        if (Intrinsics.areEqual(r3.getBizContentType(), "deep_search_card") == true) goto L5;
    L12:
        TextView r6 = this.l;
        if (r6 == null) goto L16;
        r6.setVisibility(8);
    L16:
        if (Intrinsics.areEqual(r3.getBizContentType(), "deep_search_card") == false) goto L21;
        TextView r7 = this.l;
        if (r7 == null) goto L22;
        FLogger.a.i("updatePaddingRelative", "view:" + r7.getClass().getSimpleName() + ",source:,start:0,top:0,end:0,bottom:0");
        r7.setPaddingRelative(0, 0, 0, 0);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (TextUtils.isEmpty(com.larus.im.bean.message.a.Q(r3)) == true) goto L12;
        TextView r8 = this.l;
        if (r8 == null) goto L9;
        r8.setText(com.larus.im.bean.message.a.Q(r3));
    L9:
        TextView r9 = this.l;
        if (r9 == null) goto L16;
        r9.setVisibility(0);
        goto L16
    }

    @Override // bd8.b
    public final List<View> x(int r3, Context r4, BaseMessageListCell<?> r5, i r6, q0 r7, Fragment r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super.x(r3, r4, r5, r6, r7, r8);
        TextView r9 = new TextView(r4);
        r9.setVisibility(8);
        r9.setTextSize(24.0f);
        r9.setTypeface(Typeface.DEFAULT_BOLD);
        r9.setTextColor(ContextCompat.getColor(r4, c.b(2130972079, r4, 2131103136)));
        this.l = r9;
        if ((r6 instanceof LinearLayout) == true) goto L6;
        r6 = null;
    L6:
        if (r6 == null) goto L9;
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-2, -2);
        r10.setMargins(i5.e0(), i5.m(), i5.e0(), 0);
        Unit r11 = Unit.INSTANCE;
        r6.addView(r9, r3, r10);
    L9:
        return CollectionsKt.listOf(r9);
    }
}
