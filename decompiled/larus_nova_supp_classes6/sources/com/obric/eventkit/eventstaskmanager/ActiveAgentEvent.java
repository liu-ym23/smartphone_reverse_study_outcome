package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001*Ba\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016R$\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R$\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R$\u0010\"\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011¨\u0006+"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "parcel", "readFromParcel", "", "toString", "query", "Ljava/lang/String;", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "", "openMic", "Z", "getOpenMic", "()Z", "setOpenMic", "(Z)V", "forceOmni", "getForceOmni", "setForceOmni", "expandState", "getExpandState", "setExpandState", "instructionType", "getInstructionType", "setInstructionType", "instructionEntry", "getInstructionEntry", "setInstructionEntry", "id", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", "a", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ActiveAgentEvent extends AppEvent {
    public static final a CREATOR = null;
    private String expandState;
    private boolean forceOmni;
    private String instructionEntry;
    private String instructionType;
    private boolean openMic;
    private String query;

    static {
        CREATOR = new a();
    }

    public ActiveAgentEvent() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    public ActiveAgentEvent(String r2, String r3, String r4, boolean r5, boolean r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "expandState");
        super(r2, r3, null);
        this.query = r4;
        this.openMic = r5;
        this.forceOmni = r6;
        this.expandState = r7;
        this.instructionType = r8;
        this.instructionEntry = r9;
    }

    public /* synthetic */ ActiveAgentEvent(String r10, String r11, String r12, boolean r13, boolean r14, String r15, String r16, String r17, int r18, DefaultConstructorMarker r19) {
        String r2 = null;
        if ((r18 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = null;
    L14:
        boolean r6 = false;
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r18 & 16) != 0) goto L23;
        r6 = r14;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = "half";
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r2 = r17;
    L34:
        this(r1, r3, r4, r5, r6, r7, r8, r2);
        return;
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L14
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final String getExpandState() {
        return this.expandState;
    }

    public final boolean getForceOmni() {
        return this.forceOmni;
    }

    public final String getInstructionEntry() {
        return this.instructionEntry;
    }

    public final String getInstructionType() {
        return this.instructionType;
    }

    public final boolean getOpenMic() {
        return this.openMic;
    }

    public final String getQuery() {
        return this.query;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public void readFromParcel(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        super.readFromParcel(r4);
        this.query = r4.readString();
        boolean r1 = true;
        if (r4.readInt() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.openMic = r0;
        if (r4.readInt() != 0) goto L10;
        r1 = false;
    L10:
        this.forceOmni = r1;
        String r2 = r4.readString();
        if (r2 != null) goto L13;
        r2 = "half";
    L13:
        this.expandState = r2;
        this.instructionType = r4.readString();
        this.instructionEntry = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setExpandState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.expandState = r2;
    }

    public final void setForceOmni(boolean r1) {
        this.forceOmni = r1;
    }

    public final void setInstructionEntry(String r1) {
        this.instructionEntry = r1;
    }

    public final void setInstructionType(String r1) {
        this.instructionType = r1;
    }

    public final void setOpenMic(boolean r1) {
        this.openMic = r1;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public String toString() {
        return "ActiveAgentEvent(id=" + getId() + ", content=" + getContent() + ", extra=" + getExtra() + ", createTime=" + getCreateTime() + ", lastModifiedTime=" + getLastModifiedTime() + ", source='" + getSource() + "', eventType='" + getEventType() + "', query='" + this.query + "', openMic=" + this.openMic + ", forceOmni=" + this.forceOmni + ", expandState='" + this.expandState + "'instructionType='" + this.instructionType + "', instructionEntry='" + this.instructionEntry + "')";
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        super.writeToParcel(r2, r3);
        r2.writeString(this.query);
        r2.writeInt(this.openMic ? 1 : 0);
        r2.writeInt(this.forceOmni ? 1 : 0);
        r2.writeString(this.expandState);
        r2.writeString(this.instructionType);
        r2.writeString(this.instructionEntry);
    }
}
