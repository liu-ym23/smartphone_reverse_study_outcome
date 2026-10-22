package cz8;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.b0;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.chat.job.impl.page.ChatJobFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements j {
    public e() {
    }

    @Override // cz8.j
    public final void onDestroyView() {
    }

    @Override // cz8.j
    public final void b(ChatJobFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    @Override // cz8.j
    public final void a(Fragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "root");
        if ((r3 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r4 = (ChatConstraintLayout) r3;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        boolean r0 = !b0.b(r2);
        r4.setDisableTopPadding(r0);
        r4.setDisableBottomPadding(r0);
        r4.k6(r2.requireActivity());
        return;
    L5:
        r4 = null;
        goto L6
    }
}
