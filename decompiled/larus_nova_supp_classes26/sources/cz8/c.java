package cz8;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.chat.job.impl.page.ChatJobFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import kotlin.jvm.internal.Intrinsics;
import va8.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c implements j {
    public t1a.b a;

    public c() {
    }

    @Override // cz8.j
    public final void onDestroyView() {
        t1a.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.b(m.class);
    L5:
        this.a = null;
    }

    @Override // cz8.j
    public final void b(ChatJobFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    @Override // cz8.j
    public final void a(Fragment r24, View r25) {
        Intrinsics.checkNotNullParameter(r24, "fragment");
        Intrinsics.checkNotNullParameter(r25, "root");
        s1a.a.g(r24).n(new de8.c(r24.getArguments(), r24.getArguments(), true, null, null, false, null, null, null, null, false, false, null, 0, 16376), de8.c.class);
        s1a.a.g(r24).n(new ChatParam(null, null, null, "chat_job", null, 247), ChatParam.class);
        if ((r25 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r1 = (ChatConstraintLayout) r25;
    L6:
        if (r1 == null) goto L9;
        t1a.b r2 = s1a.a.g(r24);
        r2.c(new b(r1, r24), m.class);
        this.a = r2;
    L9:
        FragmentAttachExtKt.b(r24, ContainerFilter.CHAT_JOB_MANAGEMENT);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
