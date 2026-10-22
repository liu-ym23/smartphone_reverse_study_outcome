package com.larksuite.component.card.component.audio.service;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity;", "Ljava/io/Serializable;", "state", "Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "position", "", "duration", "<init>", "(Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;II)V", "getState", "()Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "setState", "(Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;)V", "getPosition", "()I", "setPosition", "(I)V", "getDuration", "setDuration", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "CardAudioStateEnum", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardAudioStateEntity implements Serializable {
    private int duration;
    private int position;
    private CardAudioStateEnum state;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "", "value", "", "isLocalState", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getValue", "()Ljava/lang/String;", "()Z", "STOPPED", "PREPARING", "PLAYING", "PAUSED", "ERROR", "STARTING", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum CardAudioStateEnum extends Enum<CardAudioStateEnum> {
        public static final CardAudioStateEnum ERROR = null;
        public static final CardAudioStateEnum PAUSED = null;
        public static final CardAudioStateEnum PLAYING = null;
        public static final CardAudioStateEnum PREPARING = null;
        public static final CardAudioStateEnum STARTING = null;
        public static final CardAudioStateEnum STOPPED = null;
        public static final /* synthetic */ CardAudioStateEnum[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final boolean isLocalState;
        private final String value;

        public static EnumEntries<CardAudioStateEnum> getEntries() {
            return b;
        }

        static {
            CardAudioStateEnum r7 = new CardAudioStateEnum("STOPPED", 0, "stopped", false, 2, null);
            STOPPED = r7;
            boolean r12 = false;
            int r13 = 2;
            DefaultConstructorMarker r14 = null;
            CardAudioStateEnum r0 = new CardAudioStateEnum("PREPARING", 1, "preparing", r12, r13, r14);
            PREPARING = r0;
            boolean r19 = false;
            int r20 = 2;
            DefaultConstructorMarker r21 = null;
            CardAudioStateEnum r1 = new CardAudioStateEnum("PLAYING", 2, "playing", r19, r20, r21);
            PLAYING = r1;
            CardAudioStateEnum r2 = new CardAudioStateEnum("PAUSED", 3, "paused", r12, r13, r14);
            PAUSED = r2;
            CardAudioStateEnum r3 = new CardAudioStateEnum("ERROR", 4, "error", r19, r20, r21);
            ERROR = r3;
            CardAudioStateEnum r4 = new CardAudioStateEnum("STARTING", 5, "starting", true);
            STARTING = r4;
            CardAudioStateEnum[] r5 = {r7, r0, r1, r2, r3, r4};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static CardAudioStateEnum[] values() {
            return (CardAudioStateEnum[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean isLocalState() {
            return this.isLocalState;
        }

        public static CardAudioStateEnum valueOf(String r1) {
            return (CardAudioStateEnum) r27.a.a(CardAudioStateEnum.class, r1);
        }

        public CardAudioStateEnum(String r1, int r2, String r3, boolean r4) {
            super(r1, r2);
            this.value = r3;
            this.isLocalState = r4;
        }

        public /* synthetic */ CardAudioStateEnum(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L5;
            r4 = false;
        L5:
            this(r1, r2, r3, r4);
        }
    }

    public CardAudioStateEntity() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ CardAudioStateEntity copy$default(CardAudioStateEntity r0, CardAudioStateEnum r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.position;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.duration;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final CardAudioStateEnum component1() {
        return this.state;
    }

    public final int component2() {
        return this.position;
    }

    public final int component3() {
        return this.duration;
    }

    public final CardAudioStateEntity copy(CardAudioStateEnum r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        return new CardAudioStateEntity(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardAudioStateEntity) == true) goto L8;
        return false;
    L8:
        CardAudioStateEntity r6 = (CardAudioStateEntity) r5;
        if (this.state == r6.state) goto L12;
        return false;
    L12:
        if (this.position == r6.position) goto L15;
        return false;
    L15:
        if (this.duration == r6.duration) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.state.hashCode() * 31) + this.position) * 31) + this.duration;
    }

    public String toString() {
        return "CardAudioStateEntity(state=" + this.state + ", position=" + this.position + ", duration=" + this.duration + ')';
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getPosition() {
        return this.position;
    }

    public final CardAudioStateEnum getState() {
        return this.state;
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setPosition(int r1) {
        this.position = r1;
    }

    public final void setState(CardAudioStateEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.state = r2;
    }

    public CardAudioStateEntity(CardAudioStateEnum r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.state = r2;
        this.position = r3;
        this.duration = r4;
    }

    public /* synthetic */ CardAudioStateEntity(CardAudioStateEnum r2, int r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = CardAudioStateEnum.STOPPED;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
