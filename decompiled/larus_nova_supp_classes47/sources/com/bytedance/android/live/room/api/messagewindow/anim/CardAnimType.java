package com.bytedance.android.live.room.api.messagewindow.anim;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/anim/CardAnimType;", "", "ENTER", "UPDATE", "EXIT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardAnimType extends Enum<CardAnimType> {
    public static final CardAnimType ENTER = null;
    public static final CardAnimType EXIT = null;
    public static final CardAnimType UPDATE = null;
    public static final /* synthetic */ CardAnimType[] a = null;

    static {
        CardAnimType r1 = new CardAnimType("ENTER", 0);
        ENTER = r1;
        CardAnimType r2 = new CardAnimType("UPDATE", 1);
        UPDATE = r2;
        CardAnimType r3 = new CardAnimType("EXIT", 2);
        EXIT = r3;
        a = new CardAnimType[]{r1, r2, r3};
    }

    public static CardAnimType valueOf(String r1) {
        return (CardAnimType) a.a(CardAnimType.class, r1);
    }

    public static CardAnimType[] values() {
        return (CardAnimType[]) a.clone();
    }

    public CardAnimType(String r1, int r2) {
        super(r1, r2);
    }
}
