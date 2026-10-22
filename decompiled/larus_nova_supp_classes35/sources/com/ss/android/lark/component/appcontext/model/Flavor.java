package com.ss.android.lark.component.appcontext.model;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/Flavor;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REGION_CHINA", "REGION_US", "ENV_DEVELOPMENT", "ENV_PRODUCTION", "Companion", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Flavor extends Enum<Flavor> {
    public static final a Companion = null;
    public static final Flavor ENV_DEVELOPMENT = null;
    public static final Flavor ENV_PRODUCTION = null;
    public static final Flavor REGION_CHINA = null;
    public static final Flavor REGION_US = null;
    public static final Map<String, Flavor> a = null;
    public static final /* synthetic */ Flavor[] b = null;
    public static final /* synthetic */ EnumEntries c = null;
    private final String value;

    public static EnumEntries<Flavor> getEntries() {
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.component.appcontext.model.Flavor$a] */
    static {
        int r2 = 0;
        Flavor r0 = new Flavor("REGION_CHINA", 0, "china");
        REGION_CHINA = r0;
        Flavor r1 = new Flavor("REGION_US", 1, "us");
        REGION_US = r1;
        Flavor r3 = new Flavor("ENV_DEVELOPMENT", 2, "development");
        ENV_DEVELOPMENT = r3;
        Flavor r5 = new Flavor("ENV_PRODUCTION", 3, "production");
        ENV_PRODUCTION = r5;
        Flavor[] r7 = {r0, r1, r3, r5};
        b = r7;
        c = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
        Flavor[] r4 = values();
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r4.length), 16));
        int r8 = r4.length;
    L3:
        if (r2 >= r8) goto L5;
        Flavor r9 = r4[r2];
        r6.put(r9.value, r9);
        r2 = r2 + 1;
        goto L3
    L5:
        a = r6;
    }

    public static Flavor[] values() {
        return (Flavor[]) b.clone();
    }

    public static final /* synthetic */ Map access$getValuesMap$cp() {
        return a;
    }

    public final String getValue() {
        return this.value;
    }

    public static Flavor valueOf(String r1) {
        return (Flavor) r27.a.a(Flavor.class, r1);
    }

    public Flavor(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
