package com.larksuite.component.card.component.personlist;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends com.lynx.tasm.behavior.a {
    public c() {
        super("msg-card-person-list");
    }

    public final ShadowNode createShadowNode() {
        PersonListShadowNode r0 = new PersonListShadowNode();
        PersonListLynxUI.b r1 = new PersonListLynxUI.b(r0, null);
        Intrinsics.checkNotNullParameter(r1, "clickPersonListener");
        r0.y = r1;
        PersonListLynxUI.a r2 = new PersonListLynxUI.a();
        Intrinsics.checkNotNullParameter(r2, "clickMoreListener");
        r0.z = r2;
        return r0;
    }

    public final LynxUI<PersonListTextView> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new PersonListLynxUI(r2);
    }
}
