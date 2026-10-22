package com.bytedance.android.live.room.api.messagewindow.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/state/CardAction;", "", "REFRESH", "HIDE", "DESTROY", "DESTROY_WITHOUT_DESTROY", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardAction extends Enum<CardAction> {
    public static final CardAction DESTROY = null;
    public static final CardAction DESTROY_WITHOUT_DESTROY = null;
    public static final CardAction HIDE = null;
    public static final CardAction REFRESH = null;
    public static final /* synthetic */ CardAction[] a = null;

    static {
        CardAction r1 = new CardAction("REFRESH", 0);
        REFRESH = r1;
        CardAction r2 = new CardAction("HIDE", 1);
        HIDE = r2;
        CardAction r3 = new CardAction("DESTROY", 2);
        DESTROY = r3;
        CardAction r4 = new CardAction("DESTROY_WITHOUT_DESTROY", 3);
        DESTROY_WITHOUT_DESTROY = r4;
        a = new CardAction[]{r1, r2, r3, r4};
    }

    public static CardAction valueOf(String r1) {
        return (CardAction) a.a(CardAction.class, r1);
    }

    public static CardAction[] values() {
        return (CardAction[]) a.clone();
    }

    public CardAction(String r1, int r2) {
        super(r1, r2);
    }
}
