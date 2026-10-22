package dia;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.platform.api.g0;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.view.WindowChatTitleAlignLeftStyle;
import eia.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d extends r {

    public static final class a {
    }

    static {
    }

    @Override // eia.v
    public final void a() {
        FLogger.a.i("LandscapeTitleStrategy", "applyOrientationChange");
        ChatTitleAlignLeftStyle r0 = (g0) this.e.getValue();
        if ((r0 instanceof WindowChatTitleAlignLeftStyle) == false) goto L5;
        ChatTitleAlignLeftStyle r1 = (WindowChatTitleAlignLeftStyle) r0;
    L6:
        if (r1 == null) goto L11;
        View r2 = r1.findViewById(2131393304);
        if (r2 == null) goto L12;
        e1.o(r2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public d(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
