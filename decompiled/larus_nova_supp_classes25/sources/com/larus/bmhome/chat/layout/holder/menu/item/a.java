package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class a {
    public a a;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.menu.item.a$a, reason: collision with other inner class name */
    public static final class C0061a {
        public final y a;
        public a b;

        public C0061a() {
            y r0 = new y();
            this.a = r0;
            this.b = r0;
        }

        public final void a(a r2) {
            Intrinsics.checkNotNullParameter(r2, "handler");
            this.b.a = r2;
            this.b = r2;
        }
    }

    public a() {
    }

    public boolean a(int r1) {
        return false;
    }

    public abstract boolean c(ot8.a r1, View r2, ef8.b r3);

    public static void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "who");
        String r4 = r3.concat(" in MenuContext is null, check!");
        FLogger.a.e("MenuActionHandler_".concat(r2), r4);
        if (AppHost.a.isDebug() == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r2 + ", " + r4);
    }

    public final boolean b(ot8.a r2, View r3, ef8.b r4) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "menuContext");
        if (a(r2.getId()) == true) goto L5;
    L8:
        a r0 = this.a;
        if (r0 != null) goto L11;
        return false;
    L11:
        return r0.b(r2, r3, r4);
    L5:
        if (c(r2, r3, r4) == false) goto L8;
        return true;
    }
}
