package com.larus.bmhome.instruction.core.impl.controller;

import cq8.a0;
import cq8.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u extends s {
    @Override // com.larus.bmhome.instruction.core.impl.controller.s, com.larus.bmhome.instruction.core.impl.base.b, com.larus.bmhome.instruction.core.impl.base.e
    public int getType() {
        return 13;
    }

    public u() {
        super("UserMessageSenderController");
    }

    @Override // com.larus.bmhome.instruction.core.impl.controller.s, com.larus.bmhome.instruction.core.impl.base.b
    public final a0 d() {
        return new x0(getWidgetId(), this.o, this.p, this.q);
    }
}
