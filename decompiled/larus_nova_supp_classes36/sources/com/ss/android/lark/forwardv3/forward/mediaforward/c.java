package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.forwardv3.configuration.ConvertShareParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ConvertShareParamsHandler
public final class c implements com.ss.android.lark.forwardv3.configuration.h<MediaForwardContent> {
    public c() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.h, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 7;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.h
    public final Object b(IForwardContent r5) {
        MediaForwardContent r6 = (MediaForwardContent) r5;
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        r0.add(new pib.c(r6.d, r6.a, r6.c));
        return r0;
    }
}
