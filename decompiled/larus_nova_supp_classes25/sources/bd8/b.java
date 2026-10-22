package bd8;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.layout.item.g;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.bmhome.chat.list.cell.text.BaseCompositeTextCell;
import com.larus.im.bean.message.Message;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class b {
    public final boolean a;
    public final int b;
    public Fragment c;
    public i d;
    public q0 e;
    public BaseCompositeTextCell<?> f;
    public Context g;
    public com.larus.bmhome.chat.list.cell.text.cells.base.c h;
    public final Lazy i;
    public boolean j;
    public List<? extends View> k;

    public void A() {
    }

    public void B() {
    }

    public void C() {
    }

    public void D() {
    }

    public void E() {
    }

    public void F(boolean r1) {
    }

    public boolean G(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        return true;
    }

    public boolean H(xc8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return true;
    }

    public void v(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public void w(Message r1, int r2, ec8.b r3) {
        Intrinsics.checkNotNullParameter(r1, "message");
    }

    public void z() {
    }

    public final View I() {
        BaseCompositeTextCell<?> r0 = this.f;
        if (r0 == null) goto L7;
        g r1 = r0.g;
        if (r1 == null) goto L7;
        ViewParent r2 = r1.getParent();
    L9:
        if ((r2 instanceof View) == true) goto L11;
        return null;
    L11:
        return (View) r2;
    L7:
        r2 = null;
        goto L9
    }

    public Map<String, Object> u() {
        return new LinkedHashMap();
    }

    public final Context getContext() {
        return this.g;
    }

    public final void y(int r8) {
        Context r2 = this.g;
        if (r2 != null) goto L6;
        CollectionsKt.emptyList();
        return;
    L6:
        this.k = x(r8, r2, this.f, this.d, this.e, this.c);
        this.j = true;
    }

    public b(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
        new LinkedHashMap();
        this.i = LazyKt.lazy(new a(this));
        this.k = CollectionsKt.emptyList();
    }

    public List<View> x(int r1, Context r2, BaseMessageListCell<?> r3, i r4, q0 r5, Fragment r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return CollectionsKt.emptyList();
    }
}
