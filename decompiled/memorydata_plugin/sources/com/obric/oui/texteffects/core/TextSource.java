package com.obric.oui.texteffects.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/texteffects/core/TextSource;", "", "(Ljava/lang/String;I)V", "Current", "Old", "New", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum TextSource extends Enum<TextSource> {
    private static final /* synthetic */ TextSource[] $VALUES = null;
    public static final TextSource Current = null;
    public static final TextSource New = null;
    public static final TextSource Old = null;

    private static final /* synthetic */ TextSource[] $values() {
        return new TextSource[]{Current, Old, New};
    }

    static {
        Current = new TextSource("Current", 0);
        Old = new TextSource("Old", 1);
        New = new TextSource("New", 2);
        $VALUES = $values();
    }

    private TextSource(String r1, int r2) {
        super(r1, r2);
    }

    public static TextSource valueOf(String r2) {
        return (TextSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextSource.class, r2), TextSource.class, "com.obric.memorydata.plugin");
    }

    public static TextSource[] values() {
        return (TextSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextSource[].class, "com.obric.memorydata.plugin");
    }
}
