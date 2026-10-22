package cz8;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.chat.job.impl.page.ChatJobFragment;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements j {
    public ICoreInputAbility a;

    public d() {
    }

    @Override // cz8.j
    public final void onDestroyView() {
        ICoreInputAbility r0 = this.a;
        if (r0 == null) goto L5;
        r0.Uu(null, true);
    L5:
        this.a = null;
    }

    @Override // cz8.j
    public final void b(ChatJobFragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        ICoreInputAbility r4 = s1a.a.g(r3).getAbility(ICoreInputAbility.class);
        if (r4 == null) goto L11;
        this.a = r4;
        int r0 = gz8.f.a;
        if (AppHost.a.isOversea() == false) goto L8;
        String r1 = "scheduledTasks_inputBox_placeholder_setTask_global";
    L9:
        r4.Uu(gz8.f.b(r1), false);
        return;
    L8:
        r1 = "scheduledTasks_inputBox_placeholder_setTask_cn";
        goto L9
    }

    @Override // cz8.j
    public final void a(Fragment r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "root");
    }
}
