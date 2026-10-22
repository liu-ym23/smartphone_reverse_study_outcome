package dia;

import android.content.Context;
import com.larus.bmhome.chat.layout.item.i;
import com.larus.utils.logger.FLogger;
import eia.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g extends o {

    public static final class a {
    }

    static {
    }

    @Override // eia.o
    public final void c(i r4) {
        Intrinsics.checkNotNullParameter(r4, "box");
        FLogger.a.i("PortraitMessageListStrategy", "updateMessageBoxWidth, box: " + r4);
    }

    public g(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
