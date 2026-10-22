package ds8;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.larus.bmhome.top.ChatTopFloatingButtonComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j extends ViewOutlineProvider {
    public final /* synthetic */ ChatTopFloatingButtonComponent a;

    public j(ChatTopFloatingButtonComponent r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r4, Outline r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "outline");
        r5.setRect(0, r4.getHeight() - this.a.r, r4.getWidth(), r4.getHeight());
    }
}
