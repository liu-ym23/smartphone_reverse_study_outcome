package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 extends IMMarkdownParsePlugin {
    public static final a0 b = null;

    static {
        b = new a0();
    }

    @Override // com.ss.android.lark.coremd.facade.plugins.IMMarkdownParsePlugin, com.ss.android.lark.coremd.base.parse.h
    public final List<com.ss.android.lark.coremd.base.parse.g> e() {
        List<com.ss.android.lark.coremd.base.parse.g> r0 = this.a;
        Map r1 = com.ss.android.lark.im.base.d.a;
        List r2 = com.ss.android.lark.im.base.d.b(ImExtensionType.MESSAGE_RICH_TEXT_PARSER, com.ss.android.lark.biz.im.api.extension.message.h.class);
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        CollectionsKt.addAll(r3, ((com.ss.android.lark.biz.im.api.extension.message.h) r4.next()).a());
        goto L4
    L7:
        return CollectionsKt.plus(r0, r3);
    }

    public a0() {
    }
}
