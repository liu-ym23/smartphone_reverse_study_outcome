package com.larksuite.component.card.component.personlist.avatar;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends com.lynx.tasm.behavior.a {
    public final ShadowNode createShadowNode() {
        return new PersonAvatarGroupShadowNode();
    }

    public d() {
        super("universal-card-avatar-group");
    }

    public final LynxUI<PersonAvatarGroupView> createUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new PersonAvatarGroupLynxUI(r2);
    }
}
