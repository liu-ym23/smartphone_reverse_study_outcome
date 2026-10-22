package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AlarmMessage;", "Landroid/os/Parcelable;", "dataSource", "Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "isEnable", NameKeys.UnloadStrategy_No_Strategy, "needConfirm", LynxResourceModule.DATA_KEY, "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;ZZLjava/util/ArrayList;)V", "getDataSource", "()Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "setDataSource", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;)V", "()Z", "getNeedConfirm", "getData", "()Ljava/util/ArrayList;", "component1", "component2", "component3", "component4", "copy", "describeContents", NameKeys.UnloadStrategy_No_Strategy, "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "writeToParcel", NameKeys.UnloadStrategy_No_Strategy, "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmMessage implements Parcelable {
    public static final Parcelable.Creator<AlarmMessage> CREATOR = null;
    private final ArrayList<AlarmEntity> data;
    private DataSource dataSource;
    private final boolean isEnable;
    private final boolean needConfirm;

    public static final class a implements Parcelable.Creator<AlarmMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AlarmMessage createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            DataSource r0 = (DataSource) DataSource.CREATOR.createFromParcel(r8);
            int r2 = 0;
            boolean r3 = true;
            if (r8.readInt() == 0) goto L5;
            boolean r1 = true;
        L7:
            if (r8.readInt() != 0) goto L10;
            r3 = false;
        L10:
            int r4 = r8.readInt();
            ArrayList r5 = new ArrayList(r4);
        L11:
            if (r2 == r4) goto L14;
            r5.add(r8.readParcelable(AlarmMessage.class.getClassLoader()));
            r2 = r2 + 1;
            goto L11
        L14:
            return new AlarmMessage(r0, r1, r3, r5);
        L5:
            r1 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AlarmMessage[] newArray(int r1) {
            return new AlarmMessage[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlarmMessage copy$default(AlarmMessage r0, DataSource r1, boolean r2, boolean r3, ArrayList r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.dataSource;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.isEnable;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.needConfirm;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.data;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final ArrayList<AlarmEntity> component4() {
        return this.data;
    }

    public final AlarmMessage copy(DataSource r2, boolean r3, boolean r4, ArrayList<AlarmEntity> r5) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        return new AlarmMessage(r2, r3, r4, r5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AlarmMessage) == true) goto L8;
        return false;
    L8:
        AlarmMessage r6 = (AlarmMessage) r5;
        if (Intrinsics.areEqual(this.dataSource, r6.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r6.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r6.needConfirm) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.dataSource.hashCode() * 31;
        int r2 = 1231;
        if (this.isEnable == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.needConfirm == true) goto L11;
        r2 = 1237;
    L11:
        return ((r3 + r2) * 31) + this.data.hashCode();
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "AlarmMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", data=" + this.data + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        this.dataSource.writeToParcel(r3, r4);
        r3.writeInt(this.isEnable ? 1 : 0);
        r3.writeInt(this.needConfirm ? 1 : 0);
        ArrayList<AlarmEntity> r0 = this.data;
        r3.writeInt(r0.size());
        Iterator<AlarmEntity> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r3.writeParcelable((Parcelable) r1.next(), r4);
        goto L4
    }

    public final ArrayList<AlarmEntity> getData() {
        return this.data;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setDataSource(DataSource r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dataSource = r2;
    }

    public AlarmMessage(DataSource r2, boolean r3, boolean r4, ArrayList<AlarmEntity> r5) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        this.dataSource = r2;
        this.isEnable = r3;
        this.needConfirm = r4;
        this.data = r5;
    }
}
