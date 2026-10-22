package com.obric.assistant.cocreationreview.modules.proactive;

import android.content.Context;
import com.obric.assistant.cocreationreview.e5;
import com.obric.assistant.cocreationreview.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j implements m5 {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // com.obric.assistant.cocreationreview.m5
    public final e5 a(Context r3) {
        return new g(new ProactiveAgentRepository(r3));
    }
}
