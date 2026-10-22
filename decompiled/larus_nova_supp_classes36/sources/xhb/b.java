package xhb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.e;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wza.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.android.lark.blueprint.a<y6b.a<?>> implements e, c, f {
    public TextView f;

    public static final class a implements d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public a() {
            this.a = IMMessageKeys.Layouts.REPLY_ZONE;
        }

        public u getType() {
            return this.a;
        }

        public final q a(g r2, BlueprintCell r3) {
            Intrinsics.checkNotNullParameter(r2, "ctx");
            Intrinsics.checkNotNullParameter(r3, "cell");
            return new b(r2, r3);
        }
    }

    public final void d(boolean r1) {
    }

    public final void e() {
    }

    public final void h() {
    }

    public final ViewGroup k() {
        return null;
    }

    public final void setSelected(boolean r1) {
    }

    public final Map<v, Integer> t() {
        return MapsKt.emptyMap();
    }

    public final View u(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563325, r4, false);
        this.f = (TextView) r5.findViewById(2131384349);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public void update(y6b.a<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if ((r5 instanceof y6b.c) == false) goto L25;
        y6b.c r6 = (y6b.c) r5;
        if (r6.T1 > 0) goto L15;
        TextView r7 = this.f;
        if (r7 == null) goto L9;
        r7.setText(UIUtils.getString(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131891385));
    L9:
        TextView r8 = this.f;
        if (r8 == null) goto L12;
        r8.setTextColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131102042));
    L12:
        TextView r9 = this.f;
        if (r9 == null) goto L26;
        int r0 = h18.e.a;
        r9.setTypeface(h18.e.b(((com.ss.android.lark.blueprint.a) this).a.getContext(), 0));
        return;
    L26:
        return;
    L15:
        TextView r1 = this.f;
        if (r1 == null) goto L18;
        r1.setText(ICUUtils.icuFormat(UIUtils.getQuantityString(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131755047, r6.T1), "num", Long.valueOf(r6.T1)));
    L18:
        TextView r10 = this.f;
        if (r10 == null) goto L21;
        r10.setTextColor(UIUtils.getColor(((com.ss.android.lark.blueprint.a) this).a.getContext(), 2131102040));
    L21:
        TextView r11 = this.f;
        if (r11 == null) goto L28;
        int r2 = h18.e.a;
        r11.setTypeface(h18.e.b(((com.ss.android.lark.blueprint.a) this).a.getContext(), 1));
        return;
    L28:
        return;
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((y6b.a) r1);
    }

    public b(g r2, BlueprintCell r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3);
    }
}
