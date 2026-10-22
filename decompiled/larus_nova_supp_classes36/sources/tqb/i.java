package tqb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.host.ILarkLynxViewHolder;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends a implements ILarkLynxViewHolder {
    public final Context g;

    public final ILarkLynxContainer g() {
        ILarkLynxContainer r0 = this.e;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if ((!isDestroyed()) == false) goto L12;
        int r1 = b.a;
        ILarkLynxContainer r2 = b.a(this.g, this.a, this.b, null);
        e(r2);
        if (this.b.getRenderOnCreateView() == false) goto L10;
        load();
    L10:
        return r2;
    L12:
        throw new IllegalStateException("LynxViewHolder is destroyed".toString());
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void load() {
        if (isDestroyed() == false) goto L5;
        return;
    L5:
        g();
        super.load();
    }

    @Override // tqb.a, com.ss.android.lark.lynxkit.host.ILarkLynxHostHolder
    public final void destroy() {
        super.destroy();
    }

    @Override // com.ss.android.lark.lynxkit.host.ILarkLynxViewHolder
    public final View getView(boolean r3) {
        if (this.e != null) goto L5;
        boolean r0 = true;
    L6:
        ILarkLynxContainer r1 = g();
        if (r3 == false) goto L13;
        if (r0 == true) goto L10;
    L11:
        load();
        goto L13
    L10:
        if (this.b.getRenderOnCreateView() == false) goto L11;
    L13:
        return r1.getLynxView();
    L5:
        r0 = false;
        goto L6
    }

    public i(Context r2, LarkLynxHostParams r3, LarkLynxHostOptions r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "options");
        super(r3, r4);
        this.g = r2;
    }
}
