package eia;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class v {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public final boolean b() {
        laa.d r0 = (laa.d) this.a.getValue();
        ObricFloatChatPageState r1 = null;
        if (r0 == null) goto L5;
        ObricFloatChatPageState r2 = r0.getPageState();
    L7:
        if (r2 == null) goto L14;
        FLogger.a.i("BaseViewStrategy", "isLandscapeToPortrait: " + r2);
        ObricFloatChatPageData.a r6 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r7 = r2.getPreviousState();
        r6.getClass();
        if ((r7 instanceof vda.f) == false) goto L14;
        if ((r2 instanceof vda.f) == true) goto L14;
        boolean r3 = true;
    L15:
        FLogger r8 = FLogger.a;
        r8.i("BaseViewStrategy", "isLandscapeToPortrait: " + r3);
        if (r3 == true) goto L31;
        laa.d r4 = (laa.d) this.a.getValue();
        if (r4 == null) goto L21;
        r1 = r4.getPageState();
    L21:
        if (r1 == null) goto L28;
        r8.i("BaseViewStrategy", "isPortraitToLandscape: " + r1);
        ObricFloatChatPageData.a r5 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r9 = r1.getPreviousState();
        r5.getClass();
        if ((r9 instanceof vda.f) == true) goto L28;
        if ((r1 instanceof vda.f) == false) goto L28;
        boolean r10 = true;
    L29:
        r8.i("BaseViewStrategy", "isPortraitToLandscape: " + r10);
        if (r10 == true) goto L31;
        return false;
    L28:
        r10 = false;
    L31:
        return true;
    L14:
        r3 = false;
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    public v(Context r2, final t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        this.a = LazyKt.lazy(new s(r3));
        this.b = LazyKt.lazy(new t(r3));
        this.c = LazyKt.lazy(new u(this));
    }
}
