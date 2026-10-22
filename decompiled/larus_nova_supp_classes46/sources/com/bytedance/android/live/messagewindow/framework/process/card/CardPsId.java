package com.bytedance.android.live.messagewindow.framework.process.card;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/messagewindow/framework/process/card/CardPsId;", "", "ShowDebounce", "PrepareAbility", "InterceptShow", "Pk", "CardStart", "AttachContainer", "TransitionAnim", "MarkEnd", "DismissDebounce", "DetachContainer", "SuspendDebounce", "HideCard", "NotifyCardShow", "SuspendCard", "LogCardRecordsPs", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardPsId extends Enum<CardPsId> {
    public static final CardPsId AttachContainer = null;
    public static final CardPsId CardStart = null;
    public static final CardPsId DetachContainer = null;
    public static final CardPsId DismissDebounce = null;
    public static final CardPsId HideCard = null;
    public static final CardPsId InterceptShow = null;
    public static final CardPsId LogCardRecordsPs = null;
    public static final CardPsId MarkEnd = null;
    public static final CardPsId NotifyCardShow = null;
    public static final CardPsId Pk = null;
    public static final CardPsId PrepareAbility = null;
    public static final CardPsId ShowDebounce = null;
    public static final CardPsId SuspendCard = null;
    public static final CardPsId SuspendDebounce = null;
    public static final CardPsId TransitionAnim = null;
    public static final /* synthetic */ CardPsId[] a = null;

    public static CardPsId valueOf(String r1) {
        return (CardPsId) r27.a.a(CardPsId.class, r1);
    }

    public static CardPsId[] values() {
        return (CardPsId[]) a.clone();
    }

    static {
        CardPsId r1 = new CardPsId("ShowDebounce", 0);
        ShowDebounce = r1;
        CardPsId r2 = new CardPsId("PrepareAbility", 1);
        PrepareAbility = r2;
        CardPsId r3 = new CardPsId("InterceptShow", 2);
        InterceptShow = r3;
        CardPsId r4 = new CardPsId("Pk", 3);
        Pk = r4;
        CardPsId r5 = new CardPsId("CardStart", 4);
        CardStart = r5;
        CardPsId r6 = new CardPsId("AttachContainer", 5);
        AttachContainer = r6;
        CardPsId r7 = new CardPsId("TransitionAnim", 6);
        TransitionAnim = r7;
        CardPsId r8 = new CardPsId("MarkEnd", 7);
        MarkEnd = r8;
        CardPsId r9 = new CardPsId("DismissDebounce", 8);
        DismissDebounce = r9;
        CardPsId r10 = new CardPsId("DetachContainer", 9);
        DetachContainer = r10;
        CardPsId r11 = new CardPsId("SuspendDebounce", 10);
        SuspendDebounce = r11;
        CardPsId r12 = new CardPsId("HideCard", 11);
        HideCard = r12;
        CardPsId r13 = new CardPsId("NotifyCardShow", 12);
        NotifyCardShow = r13;
        CardPsId r14 = new CardPsId("SuspendCard", 13);
        SuspendCard = r14;
        CardPsId r15 = new CardPsId("LogCardRecordsPs", 14);
        LogCardRecordsPs = r15;
        a = new CardPsId[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15};
    }

    public CardPsId(String r1, int r2) {
        super(r1, r2);
    }
}
