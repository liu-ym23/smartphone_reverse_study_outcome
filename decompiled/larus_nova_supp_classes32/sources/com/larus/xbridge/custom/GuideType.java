package com.larus.xbridge.custom;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/xbridge/custom/GuideType;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_DIALOG", "WALLET", "CASH_OUT", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum GuideType extends Enum<GuideType> {
    public static final GuideType CASH_OUT = null;
    public static final a Companion = null;
    public static final GuideType NO_DIALOG = null;
    public static final GuideType WALLET = null;
    public static final /* synthetic */ GuideType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GuideType> getEntries() {
        return b;
    }

    static {
        GuideType r0 = new GuideType("NO_DIALOG", 0, 0);
        NO_DIALOG = r0;
        GuideType r1 = new GuideType("WALLET", 1, 1);
        WALLET = r1;
        GuideType r3 = new GuideType("CASH_OUT", 2, 2);
        CASH_OUT = r3;
        GuideType[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static GuideType[] values() {
        return (GuideType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GuideType valueOf(String r1) {
        return (GuideType) r27.a.a(GuideType.class, r1);
    }

    public GuideType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
