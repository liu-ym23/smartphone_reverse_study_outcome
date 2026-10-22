package com.google.gson.internal.bind;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public /* synthetic */ class NumberTypeAdapter$2 {
    static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

    static {
        int[] r0 = new int[JsonToken.values().length];
        $SwitchMap$com$google$gson$stream$JsonToken = r0;
        r0[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L10:
        $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L12:
        $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
        return;
    }
}
