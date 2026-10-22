package com.bytedance.ai.core.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends i {
    public boolean e;

    @Override // com.bytedance.ai.core.base.i
    public final boolean a() {
        if (this.e == false) goto L5;
    L8:
        return true;
    L5:
        if (super.a() == true) goto L8;
        return false;
    }

    public a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        super(r10, SessionType.CHATUI);
        this.e = true;
    }

    public final void b(boolean r10) {
        this.e = r10;
        com.bytedance.ai.utils.g.a.d("Session", "Session(" + this.a + ") is Active --> " + this.e);
    }
}
