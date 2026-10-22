package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TranslateSource extends Enum<TranslateSource> implements WireEnum {
    private static final /* synthetic */ TranslateSource[] $VALUES = null;
    public static final ProtoAdapter<TranslateSource> ADAPTER = null;
    public static final TranslateSource AUTO_TRANSLATE = null;
    public static final TranslateSource MANUAL_TRANSLATE = null;
    public static final TranslateSource UNKNOWN_TRANSLATE_SOURCE = null;
    private final int value;

    static {
        TranslateSource r0 = new TranslateSource("UNKNOWN_TRANSLATE_SOURCE", 0, 0);
        UNKNOWN_TRANSLATE_SOURCE = r0;
        TranslateSource r1 = new TranslateSource("MANUAL_TRANSLATE", 1, 1);
        MANUAL_TRANSLATE = r1;
        TranslateSource r3 = new TranslateSource("AUTO_TRANSLATE", 2, 2);
        AUTO_TRANSLATE = r3;
        $VALUES = new TranslateSource[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(TranslateSource.class);
    }

    public static TranslateSource[] values() {
        return (TranslateSource[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TranslateSource fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return AUTO_TRANSLATE;
    L12:
        return MANUAL_TRANSLATE;
    L14:
        return UNKNOWN_TRANSLATE_SOURCE;
    }

    public static TranslateSource valueOf(String r1) {
        return (TranslateSource) a.a(TranslateSource.class, r1);
    }

    private TranslateSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
