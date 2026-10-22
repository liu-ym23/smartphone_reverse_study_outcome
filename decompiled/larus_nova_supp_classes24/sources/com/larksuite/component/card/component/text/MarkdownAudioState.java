package com.larksuite.component.card.component.text;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0019B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/card/component/text/MarkdownAudioState;", "", "state", "", "position", "", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getState", "()Ljava/lang/String;", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDuration", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larksuite/component/card/component/text/MarkdownAudioState;", "equals", "", "other", "hashCode", "toString", "StateEnum", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MarkdownAudioState {
    private final Integer duration;
    private final Integer position;
    private final String state;

    public MarkdownAudioState() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MarkdownAudioState copy$default(MarkdownAudioState r0, String r1, Integer r2, Integer r3, int r4, Object r5) {
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

    public final String component1() {
        return this.state;
    }

    public final Integer component2() {
        return this.position;
    }

    public final Integer component3() {
        return this.duration;
    }

    public final MarkdownAudioState copy(String r2, Integer r3, Integer r4) {
        return new MarkdownAudioState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkdownAudioState) == true) goto L8;
        return false;
    L8:
        MarkdownAudioState r6 = (MarkdownAudioState) r5;
        if (Intrinsics.areEqual(this.state, r6.state) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.state;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.position;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.duration;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MarkdownAudioState(state=" + this.state + ", position=" + this.position + ", duration=" + this.duration + ')';
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getState() {
        return this.state;
    }

    public MarkdownAudioState(String r1, Integer r2, Integer r3) {
        this.state = r1;
        this.position = r2;
        this.duration = r3;
    }

    public /* synthetic */ MarkdownAudioState(String r2, Integer r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
