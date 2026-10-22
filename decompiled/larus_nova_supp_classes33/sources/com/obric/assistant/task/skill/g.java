package com.obric.assistant.task.skill;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.view.actionbar.api.IActionBarFilter;
import com.obric.assistant.util.r2;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements IActionBarFilter {
    public static final Set<String> c = null;
    public final IActionBarFilter.FilterMode a;
    public final int b;

    public static final class a {
    }

    public final String b() {
        return "obric_task_skill_mode_filter";
    }

    static {
        c = SetsKt.setOf(new String[]{ActionBarInstructionKey.COCO_DEEP_THINKING.getKey(), "obric_quick_instruction", "obric_all_instruction", "obric_omni_all_skills"});
    }

    public g() {
        this.a = IActionBarFilter.FilterMode.WHITELIST;
        this.b = 90;
    }

    public final IActionBarFilter.FilterMode getMode() {
        return this.a;
    }

    public final int getPriority() {
        return this.b;
    }

    public final boolean a(z0 r3, ss8.d r4) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "context");
        b r5 = r2.a();
        if (r5 == null) goto L9;
        y r6 = r5.getAbility(y.class);
        if (r6 == null) goto L9;
        String r7 = r6.Y1();
        if (r7 == null) goto L9;
        boolean r8 = com.larus.bmhome.utils.i.g(r7);
    L11:
        if (r8 == true) goto L13;
        return false;
    L13:
        String r9 = r3.b;
        if (CollectionsKt.contains(c, r9) == false) goto L16;
    L18:
        return false;
    L16:
        if (d.a(r9) == true) goto L18;
        return true;
    L9:
        r8 = true;
        goto L11
    }
}
