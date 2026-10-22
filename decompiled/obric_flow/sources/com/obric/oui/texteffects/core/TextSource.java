package com.obric.oui.texteffects.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/texteffects/core/TextSource;", "", "Current", "Old", "New", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum TextSource extends Enum<TextSource> {
    public static final TextSource Current = null;
    public static final TextSource New = null;
    public static final TextSource Old = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextSource[] f14734a = null;

    static {
        TextSource r5 = new TextSource("Current", 0);
        Current = r5;
        TextSource r10 = new TextSource("Old", 1);
        Old = r10;
        TextSource r11 = new TextSource("New", 2);
        New = r11;
        f14734a = new TextSource[]{r5, r10, r11};
    }

    public static TextSource valueOf(String r5) {
        return (TextSource) Enum.valueOf(TextSource.class, r5);
    }

    public static TextSource[] values() {
        return (TextSource[]) f14734a.clone();
    }
}
