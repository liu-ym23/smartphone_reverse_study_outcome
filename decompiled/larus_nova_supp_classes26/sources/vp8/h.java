package vp8;

import com.larus.bmhome.actionbar.model.r;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h extends g {
    public final ComponentFeature h;

    public h(ComponentFeature r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        super(r2);
        this.h = r2;
    }

    @Override // vp8.g
    public final boolean q(r r11) {
        Integer r12 = r11.a;
        if (r12 != null) goto L6;
    L8:
        boolean r13 = false;
    L9:
        if (r13 == false) goto L14;
        StateFlowImpl r14 = ce8.c.a;
        t1a.b r15 = s1a.d.a(this.h);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        String r1 = UUID.randomUUID().toString();
        ce8.c.b = r1;
        ce8.c.c = "continuous_chat_action_bar";
        ce8.c.b("continuous_chat_action_bar", r1, r15);
        xa8.e r16 = new xa8.e("continuous_chat_action_bar", ce8.c.b, null, null, false, 28);
        xa8.b r2 = s1a.d.a(this.h).getAbility(xa8.b.class);
        if (r2 == null) goto L13;
        r2.fk(r16);
    L13:
        return true;
    L14:
        return false;
    L6:
        if (r12.intValue() != 19) goto L8;
        r13 = true;
        goto L9
    }
}
