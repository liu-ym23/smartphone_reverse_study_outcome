package com.obric.flow.cardlistpage.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/flow/cardlistpage/base/CardType;", "", "WIDGET", "CUSTOM", "MINI_APP", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CardType extends Enum<CardType> {
    public static final CardType CUSTOM = null;
    public static final CardType MINI_APP = null;
    public static final CardType WIDGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardType[] f11460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f11461b = null;

    static {
        CardType r5 = new CardType("WIDGET", 0);
        WIDGET = r5;
        CardType r10 = new CardType("CUSTOM", 1);
        CUSTOM = r10;
        CardType r11 = new CardType("MINI_APP", 2);
        MINI_APP = r11;
        CardType[] r12 = {r5, r10, r11};
        f11460a = r12;
        f11461b = EnumEntriesKt.enumEntries(r12);
    }

    public static EnumEntries<CardType> getEntries() {
        return f11461b;
    }

    public static CardType valueOf(String r5) {
        return (CardType) Enum.valueOf(CardType.class, r5);
    }

    public static CardType[] values() {
        return (CardType[]) f11460a.clone();
    }
}
