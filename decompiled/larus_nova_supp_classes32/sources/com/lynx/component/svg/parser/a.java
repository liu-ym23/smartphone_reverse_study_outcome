package com.lynx.component.svg.parser;

import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends SVGParser.c {
    public a(String r3) {
        super(r3.replaceAll("(?s)/\\*.*?\\*/", NameKeys.UnloadStrategy_No_Strategy));
    }
}
