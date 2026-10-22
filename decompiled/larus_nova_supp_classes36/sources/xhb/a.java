package xhb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.u;
import com.ss.android.lark.blueprint.v;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.f;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wza.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends com.ss.android.lark.blueprint.a<y6b.a<?>> implements c, f {
    public TextView f;

    /* JADX INFO: renamed from: xhb.a$a, reason: collision with other inner class name */
    public static final class C0344a implements d<y6b.a<?>> {
        public final IMMessageKeys.Layouts a;

        public C0344a() {
            this.a = IMMessageKeys.Layouts.REPLY_AUTH;
        }

        public u getType() {
            return this.a;
        }

        public final q a(g r2, BlueprintCell r3) {
            Intrinsics.checkNotNullParameter(r2, "ctx");
            Intrinsics.checkNotNullParameter(r3, "cell");
            return new a(r2, r3);
        }
    }

    public final void d(boolean r1) {
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
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131563324, r4, false);
        this.f = (TextView) r5.findViewById(2131363569);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public void update(y6b.a<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        TextView r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof y6b.c) == false) goto L7;
        y6b.c r5 = (y6b.c) r4;
    L8:
        boolean r1 = false;
        if (r5 != null) goto L11;
    L13:
        if (r1 == false) goto L15;
        int r6 = 2131890203;
    L16:
        r0.setText(r6);
        return;
    L15:
        r6 = 2131890830;
        goto L16
    L11:
        if (r5.V2 != true) goto L13;
        r1 = true;
        goto L13
    L7:
        r5 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ void update(Object r1) {
        update((y6b.a) r1);
    }

    public a(g r2, BlueprintCell r3) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "cell");
        super(r2, r3);
    }
}
