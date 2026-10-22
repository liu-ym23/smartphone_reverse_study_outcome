package com.bytedance.android.anniex.pitaya;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/anniex/pitaya/StrategyError$Domain", "", "Lcom/bytedance/android/anniex/pitaya/StrategyError$Domain;", "", "domain", "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "BDP", "SERVER", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum StrategyError$Domain extends Enum<StrategyError$Domain> {
    public static final StrategyError$Domain BDP = null;
    public static final StrategyError$Domain SERVER = null;
    public static final /* synthetic */ StrategyError$Domain[] a = null;
    private final String domain;

    public static StrategyError$Domain valueOf(String r1) {
        return (StrategyError$Domain) a.a(StrategyError$Domain.class, r1);
    }

    public static StrategyError$Domain[] values() {
        return (StrategyError$Domain[]) a.clone();
    }

    static {
        StrategyError$Domain r0 = new StrategyError$Domain("BDP", 0, "bdp");
        BDP = r0;
        StrategyError$Domain r1 = new StrategyError$Domain("SERVER", 1, "server");
        SERVER = r1;
        a = new StrategyError$Domain[]{r0, r1};
    }

    public final String getDomain() {
        return this.domain;
    }

    public StrategyError$Domain(String r1, int r10, String r11) {
        super(r1, r10);
        this.domain = r11;
    }
}
