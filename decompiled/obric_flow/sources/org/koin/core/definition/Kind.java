package org.koin.core.definition;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lorg/koin/core/definition/Kind;", "", "Singleton", "Factory", "Scoped", "koin-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum Kind extends Enum<Kind> {
    public static final Kind Factory = null;
    public static final Kind Scoped = null;
    public static final Kind Singleton = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Kind[] f21004a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f21005b = null;

    static {
        Kind r5 = new Kind("Singleton", 0);
        Singleton = r5;
        Kind r10 = new Kind("Factory", 1);
        Factory = r10;
        Kind r11 = new Kind("Scoped", 2);
        Scoped = r11;
        Kind[] r12 = {r5, r10, r11};
        f21004a = r12;
        f21005b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<Kind> getEntries() {
        return f21005b;
    }

    public static Kind valueOf(String r5) {
        return (Kind) Enum.valueOf(Kind.class, r5);
    }

    public static Kind[] values() {
        return (Kind[]) f21004a.clone();
    }
}
