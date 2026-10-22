package com.larus.suggest.impl.popup;

import kotlin.collections.SetsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w {
    public static final w a = null;
    public static final Regex b = null;

    public w() {
    }

    static {
        a = new w();
        b = new Regex("(?<!!)\\[[^\\]\\r\\n]+]\\((https?://[^\\s)]+)\\)", SetsKt.setOf(RegexOption.IGNORE_CASE));
    }
}
