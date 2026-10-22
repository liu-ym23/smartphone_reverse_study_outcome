package com.obric.assistant.data;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\u0004\u0018\u00010\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/obric/assistant/data/ObricFloatChatPageState;", "", "useAnim", "", "height", "", "onlyChangeState", "<init>", "(ZIZ)V", "getUseAnim", "()Z", "getHeight", "()I", "setHeight", "(I)V", "getOnlyChangeState", "setOnlyChangeState", "(Z)V", "stateTimeMS", "", "getStateTimeMS", "()J", "setStateTimeMS", "(J)V", "value", "previousState", "getPreviousState", "()Lcom/obric/assistant/data/ObricFloatChatPageState;", "setPreviousState", "(Lcom/obric/assistant/data/ObricFloatChatPageState;)V", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ObricFloatChatPageState {
    private int height;
    private boolean onlyChangeState;
    private ObricFloatChatPageState previousState;
    private long stateTimeMS;
    private final boolean useAnim;

    public ObricFloatChatPageState() {
        this(false, 0, false, 7, null);
    }

    public String toString() {
        return getClass().getSimpleName() + "-height:" + getHeight() + "-useAnim:" + getUseAnim() + "-onlyChangeState:" + getOnlyChangeState() + "-previousState:" + getPreviousState();
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getOnlyChangeState() {
        return this.onlyChangeState;
    }

    public ObricFloatChatPageState getPreviousState() {
        return this.previousState;
    }

    public final long getStateTimeMS() {
        return this.stateTimeMS;
    }

    public boolean getUseAnim() {
        return this.useAnim;
    }

    public void setHeight(int r1) {
        this.height = r1;
    }

    public void setOnlyChangeState(boolean r1) {
        this.onlyChangeState = r1;
    }

    public void setPreviousState(ObricFloatChatPageState r2) {
        if (r2 == null) goto L5;
        r2.setPreviousState(null);
    L6:
        this.previousState = r2;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void setStateTimeMS(long r1) {
        this.stateTimeMS = r1;
    }

    public ObricFloatChatPageState(boolean r1, int r2, boolean r3) {
        this.useAnim = r1;
        this.height = r2;
        this.onlyChangeState = r3;
        this.stateTimeMS = SystemClock.elapsedRealtime();
    }

    public /* synthetic */ ObricFloatChatPageState(boolean r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        this(r2, r3, r4);
    }
}
