package com.larus.bmhome.instruction.core.model.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/widget/TranslatorSelectorType;", "", "<init>", "(Ljava/lang/String;I)V", "SOURCE", "TARGET", "VOICE", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TranslatorSelectorType extends Enum<TranslatorSelectorType> {
    public static final TranslatorSelectorType SOURCE = null;
    public static final TranslatorSelectorType TARGET = null;
    public static final TranslatorSelectorType VOICE = null;
    public static final /* synthetic */ TranslatorSelectorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<TranslatorSelectorType> getEntries() {
        return b;
    }

    static {
        TranslatorSelectorType r0 = new TranslatorSelectorType("SOURCE", 0);
        SOURCE = r0;
        TranslatorSelectorType r1 = new TranslatorSelectorType("TARGET", 1);
        TARGET = r1;
        TranslatorSelectorType r3 = new TranslatorSelectorType("VOICE", 2);
        VOICE = r3;
        TranslatorSelectorType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static TranslatorSelectorType[] values() {
        return (TranslatorSelectorType[]) a.clone();
    }

    public static TranslatorSelectorType valueOf(String r1) {
        return (TranslatorSelectorType) a.a(TranslatorSelectorType.class, r1);
    }

    public TranslatorSelectorType(String r1, int r2) {
        super(r1, r2);
    }
}
