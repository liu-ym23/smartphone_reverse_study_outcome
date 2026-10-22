package com.larus.dora.impl.device.settings.lab.headcontrol;

import com.larus.utils.j0;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000f"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlActionOption;", "", "titleRes", "", "<init>", "(Ljava/lang/String;II)V", "getTitleRes", "()I", "NONE", "ACCEPT_CONFIRM", "REJECT_CLOSE", "title", "", "getTitle", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HeadControlActionOption extends Enum<HeadControlActionOption> {
    public static final HeadControlActionOption ACCEPT_CONFIRM = null;
    public static final HeadControlActionOption NONE = null;
    public static final HeadControlActionOption REJECT_CLOSE = null;
    public static final /* synthetic */ HeadControlActionOption[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int titleRes;

    public static EnumEntries<HeadControlActionOption> getEntries() {
        return b;
    }

    static {
        HeadControlActionOption r0 = new HeadControlActionOption("NONE", 0, 2131902769);
        NONE = r0;
        HeadControlActionOption r1 = new HeadControlActionOption("ACCEPT_CONFIRM", 1, 2131902595);
        ACCEPT_CONFIRM = r1;
        HeadControlActionOption r2 = new HeadControlActionOption("REJECT_CLOSE", 2, 2131902956);
        REJECT_CLOSE = r2;
        HeadControlActionOption[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static HeadControlActionOption[] values() {
        return (HeadControlActionOption[]) a.clone();
    }

    public final String getTitle() {
        int r0 = j0.a;
        return j0.d(this.titleRes);
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public static HeadControlActionOption valueOf(String r1) {
        return (HeadControlActionOption) a.a(HeadControlActionOption.class, r1);
    }

    public HeadControlActionOption(String r1, int r2, int r3) {
        super(r1, r2);
        this.titleRes = r3;
    }
}
