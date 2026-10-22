package com.obric.aiproactive.api;

import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/obric/aiproactive/api/DoubaoGlassesConnectionSnapshot;", "", "connected", "", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "wearing", "environmentMemoryEnabled", "everConnected", "<init>", "(ZJZZZ)V", "(ZJZ)V", "getConnected", "()Z", "getGeneration", "()J", "getWearing", "getEnvironmentMemoryEnabled", "getEverConnected", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DoubaoGlassesConnectionSnapshot {
    private final boolean connected;
    private final boolean environmentMemoryEnabled;
    private final boolean everConnected;
    private final long generation;
    private final boolean wearing;

    public DoubaoGlassesConnectionSnapshot(boolean r8, long r9, boolean r11) {
        this(r8, r9, r11, true, r8);
    }

    public /* synthetic */ DoubaoGlassesConnectionSnapshot(boolean r1, long r2, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r4);
    }

    public DoubaoGlassesConnectionSnapshot(boolean r1, long r2, boolean r4, boolean r5, boolean r6) {
        this.connected = r1;
        this.generation = r2;
        this.wearing = r4;
        this.environmentMemoryEnabled = r5;
        this.everConnected = r6;
    }

    public static /* synthetic */ DoubaoGlassesConnectionSnapshot copy$default(DoubaoGlassesConnectionSnapshot r4, boolean r5, long r6, boolean r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.connected;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.generation;
    L8:
        long r0 = r6;
        if ((r11 & 4) == 0) goto L11;
        r8 = r4.wearing;
    L11:
        boolean r13 = r8;
        if ((r11 & 8) == 0) goto L14;
        r9 = r4.environmentMemoryEnabled;
    L14:
        boolean r2 = r9;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.everConnected;
    L17:
        boolean r7 = r5;
        return r4.copy(r7, r0, r13, r2, r10);
    }

    public final boolean component1() {
        return this.connected;
    }

    public final long component2() {
        return this.generation;
    }

    public final boolean component3() {
        return this.wearing;
    }

    public final boolean component4() {
        return this.environmentMemoryEnabled;
    }

    public final boolean component5() {
        return this.everConnected;
    }

    public final DoubaoGlassesConnectionSnapshot copy(boolean r8, long r9, boolean r11, boolean r12, boolean r13) {
        return new DoubaoGlassesConnectionSnapshot(r8, r9, r11, r12, r13);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, DoubaoGlassesConnectionSnapshot.class) == true) goto L8;
        return false;
    L8:
        DoubaoGlassesConnectionSnapshot r10 = (DoubaoGlassesConnectionSnapshot) ZeusTransformUtils.preCheckCast(r9, DoubaoGlassesConnectionSnapshot.class, "com.obric.memorydata.plugin");
        if (this.connected == r10.connected) goto L12;
        return false;
    L12:
        if (this.generation == r10.generation) goto L15;
        return false;
    L15:
        if (this.wearing == r10.wearing) goto L18;
        return false;
    L18:
        if (this.environmentMemoryEnabled == r10.environmentMemoryEnabled) goto L21;
        return false;
    L21:
        if (this.everConnected == r10.everConnected) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final boolean getEnvironmentMemoryEnabled() {
        return this.environmentMemoryEnabled;
    }

    public final boolean getEverConnected() {
        return this.everConnected;
    }

    public final long getGeneration() {
        return this.generation;
    }

    public final boolean getWearing() {
        return this.wearing;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.connected) * 31) + Long.hashCode(this.generation)) * 31) + Boolean.hashCode(this.wearing)) * 31) + Boolean.hashCode(this.environmentMemoryEnabled)) * 31) + Boolean.hashCode(this.everConnected);
    }

    public String toString() {
        return "DoubaoGlassesConnectionSnapshot(connected=" + this.connected + ", generation=" + this.generation + ", wearing=" + this.wearing + ", environmentMemoryEnabled=" + this.environmentMemoryEnabled + ", everConnected=" + this.everConnected + ')';
    }
}
