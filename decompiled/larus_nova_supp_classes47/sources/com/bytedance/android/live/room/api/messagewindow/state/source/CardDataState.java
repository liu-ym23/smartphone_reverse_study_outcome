package com.bytedance.android.live.room.api.messagewindow.state.source;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/state/source/CardDataState;", "", "INIT", "SHOW", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardDataState extends Enum<CardDataState> {
    public static final CardDataState INIT = null;
    public static final CardDataState SHOW = null;
    public static final /* synthetic */ CardDataState[] a = null;

    static {
        CardDataState r1 = new CardDataState("INIT", 0);
        INIT = r1;
        CardDataState r2 = new CardDataState("SHOW", 1);
        SHOW = r2;
        a = new CardDataState[]{r1, r2};
    }

    public static CardDataState valueOf(String r1) {
        return (CardDataState) a.a(CardDataState.class, r1);
    }

    public static CardDataState[] values() {
        return (CardDataState[]) a.clone();
    }

    public CardDataState(String r1, int r2) {
        super(r1, r2);
    }
}
