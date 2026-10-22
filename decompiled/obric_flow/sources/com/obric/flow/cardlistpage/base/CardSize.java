package com.obric.flow.cardlistpage.base;

import dq.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/obric/flow/cardlistpage/base/CardSize;", "", "", "spanX", "I", "getSpanX", "()I", "spanY", "getSpanY", "Companion", "dq/a", "SQUARE_SMALL", "WIDE", "SQUARE_LARGE", "CardListPage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CardSize extends Enum<CardSize> {
    public static final a Companion = null;
    public static final CardSize SQUARE_LARGE = null;
    public static final CardSize SQUARE_SMALL = null;
    public static final CardSize WIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardSize[] f11458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f11459b = null;
    private final int spanX;
    private final int spanY;

    static {
        CardSize r5 = new CardSize("SQUARE_SMALL", 0, 2, 2);
        SQUARE_SMALL = r5;
        CardSize r10 = new CardSize("WIDE", 1, 4, 2);
        WIDE = r10;
        CardSize r11 = new CardSize("SQUARE_LARGE", 2, 4, 4);
        SQUARE_LARGE = r11;
        CardSize[] r12 = {r5, r10, r11};
        f11458a = r12;
        f11459b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public CardSize(String r5, int r10, int r11, int r12) {
        super(r5, r10);
        this.spanX = r11;
        this.spanY = r12;
    }

    public static EnumEntries<CardSize> getEntries() {
        return f11459b;
    }

    public static CardSize valueOf(String r5) {
        return (CardSize) Enum.valueOf(CardSize.class, r5);
    }

    public static CardSize[] values() {
        return (CardSize[]) f11458a.clone();
    }

    public final int getSpanX() {
        return this.spanX;
    }

    public final int getSpanY() {
        return this.spanY;
    }
}
