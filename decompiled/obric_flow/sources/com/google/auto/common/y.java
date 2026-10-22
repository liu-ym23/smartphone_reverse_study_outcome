package com.google.auto.common;

import java.util.Optional;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y {
    public static Optional a(Elements r5, SourceVersion r10) {
        if (r10.compareTo(SourceVersion.RELEASE_8) <= 0) goto L5;
        String r11 = "javax.annotation.processing.Generated";
    L7:
        return Optional.ofNullable(r5.getTypeElement(r11));
    L5:
        r11 = "javax.annotation.Generated";
        goto L7
    }
}
