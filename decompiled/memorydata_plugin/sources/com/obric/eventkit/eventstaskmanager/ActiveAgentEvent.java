package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0003H\u0016J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "Lcom/obric/eventkit/eventstaskmanager/AppEvent;", OaidModel.KEY_ID, "", Params.CONTENT, ChatMessage.TYPE_QUERY, "openMic", "", "forceOmni", "expandState", "instructionType", "instructionEntry", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExpandState", "()Ljava/lang/String;", "setExpandState", "(Ljava/lang/String;)V", "getForceOmni", "()Z", "setForceOmni", "(Z)V", "getInstructionEntry", "setInstructionEntry", "getInstructionType", "setInstructionType", "getOpenMic", "setOpenMic", "getQuery", "setQuery", "readFromParcel", "", "parcel", "Landroid/os/Parcel;", "toString", "writeToParcel", "dest", "flags", "", "CREATOR", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ActiveAgentEvent extends AppEvent {
    public static final a CREATOR = null;
    private String expandState;
    private boolean forceOmni;
    private String instructionEntry;
    private String instructionType;
    private boolean openMic;
    private String query;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "()V", "createFromParcel", AILabCheckPermissionTask.KEY_SOURCE, "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/eventkit/eventstaskmanager/ActiveAgentEvent;", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<ActiveAgentEvent> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public ActiveAgentEvent a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
            return (ActiveAgentEvent) ZeusTransformUtils.preCheckCast(AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r2), ActiveAgentEvent.class, "com.obric.memorydata.plugin");
        }

        public ActiveAgentEvent[] a(int r1) {
            return new ActiveAgentEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ActiveAgentEvent createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ActiveAgentEvent[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
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

    public /* synthetic */ ActiveAgentEvent(String r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = false;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = "half";
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = null;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r10);
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
        StringBuilder r0 = new StringBuilder();
        r0.append("ActiveAgentEvent(id=").append(getId()).append(", content=").append(getContent()).append(", extra=").append(getExtra()).append(", createTime=").append(getCreateTime()).append(", lastModifiedTime=").append(getLastModifiedTime()).append(", source='").append(getSource()).append("', eventType='").append(getEventType()).append("', query='").append(this.query).append("', openMic=").append(this.openMic).append(", forceOmni=").append(this.forceOmni).append(", expandState='").append(this.expandState).append("'instructionType='");
        r0.append(this.instructionType).append("', instructionEntry='").append(this.instructionEntry).append("')");
        return r0.toString();
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
