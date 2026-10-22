package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\u001d\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0017\u00100\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014HÆ\u0003J\u0097\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014HÆ\u0001J\u0006\u00102\u001a\u000203J\u0013\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000203HÖ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001J\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u000203R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R0\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001f\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AppIntentMessage;", "Landroid/os/Parcelable;", "dataSource", "Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "isEnable", "", "needConfirm", "confirmNlg", "", "refuseNlg", "isPaused", "showRecentContact", "data", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lkotlin/collections/ArrayList;", "dataV2", "", "Lcom/obric/aiagent/assistant/idl/bean/AppIntentCardData;", "ext", "", "<init>", "(Lcom/obric/aiagent/assistant/idl/bean/DataSource;ZZLjava/lang/String;Ljava/lang/String;ZZLjava/util/ArrayList;Ljava/util/List;Ljava/util/Map;)V", "getDataSource", "()Lcom/obric/aiagent/assistant/idl/bean/DataSource;", "()Z", "getNeedConfirm", "getConfirmNlg", "()Ljava/lang/String;", "getRefuseNlg", "getShowRecentContact", "getData$annotations", "()V", "getData", "()Ljava/util/ArrayList;", "getDataV2", "()Ljava/util/List;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AppIntentMessage implements Parcelable {
    public static final Parcelable.Creator<AppIntentMessage> CREATOR = null;
    private final String confirmNlg;
    private final ArrayList<AppEntity> data;
    private final DataSource dataSource;
    private final List<AppIntentCardData> dataV2;
    private final Map<String, String> ext;
    private final boolean isEnable;
    private final boolean isPaused;
    private final boolean needConfirm;
    private final String refuseNlg;
    private final boolean showRecentContact;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppIntentMessage copy$default(AppIntentMessage r11, DataSource r12, boolean r13, boolean r14, String r15, String r16, boolean r17, boolean r18, ArrayList r19, List r20, Map r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        DataSource r2 = r11.dataSource;
    L7:
        if ((r22 & 2) == 0) goto L9;
        boolean r3 = r11.isEnable;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = r11.needConfirm;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.confirmNlg;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r6 = r11.refuseNlg;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r7 = r11.isPaused;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r8 = r11.showRecentContact;
    L31:
        if ((r22 & 128) == 0) goto L33;
        ArrayList r9 = r11.data;
    L35:
        if ((r22 & ISmModel.VERSION_0100) == 0) goto L37;
        List r10 = r11.dataV2;
    L39:
        if ((r22 & ISmModel.VERSION_0200) == 0) goto L41;
        Map r1 = r11.ext;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    @Deprecated(message = "use dataV2 instead")
    public static /* synthetic */ void getData$annotations() {
    }

    public final DataSource component1() {
        return this.dataSource;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final boolean component2() {
        return this.isEnable;
    }

    public final boolean component3() {
        return this.needConfirm;
    }

    public final String component4() {
        return this.confirmNlg;
    }

    public final String component5() {
        return this.refuseNlg;
    }

    public final boolean component6() {
        return this.isPaused;
    }

    public final boolean component7() {
        return this.showRecentContact;
    }

    public final ArrayList<AppEntity> component8() {
        return this.data;
    }

    public final List<AppIntentCardData> component9() {
        return this.dataV2;
    }

    public final AppIntentMessage copy(DataSource r13, boolean r14, boolean r15, String r16, String r17, boolean r18, boolean r19, ArrayList<AppEntity> r20, List<AppIntentCardData> r21, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r13, "dataSource");
        Intrinsics.checkNotNullParameter(r16, "confirmNlg");
        Intrinsics.checkNotNullParameter(r17, "refuseNlg");
        return new AppIntentMessage(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppIntentMessage) == true) goto L8;
        return false;
    L8:
        AppIntentMessage r6 = (AppIntentMessage) r5;
        if (Intrinsics.areEqual(this.dataSource, r6.dataSource) == true) goto L12;
        return false;
    L12:
        if (this.isEnable == r6.isEnable) goto L15;
        return false;
    L15:
        if (this.needConfirm == r6.needConfirm) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmNlg, r6.confirmNlg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.refuseNlg, r6.refuseNlg) == true) goto L24;
        return false;
    L24:
        if (this.isPaused == r6.isPaused) goto L27;
        return false;
    L27:
        if (this.showRecentContact == r6.showRecentContact) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.dataV2, r6.dataV2) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        int r0 = this.dataSource.hashCode() * 31;
        int r2 = 1231;
        if (this.isEnable == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.needConfirm == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((((r3 + r4) * 31) + this.confirmNlg.hashCode()) * 31) + this.refuseNlg.hashCode()) * 31;
        if (this.isPaused == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.showRecentContact == true) goto L18;
        r2 = 1237;
    L18:
        int r8 = (r7 + r2) * 31;
        ArrayList<AppEntity> r9 = this.data;
        int r10 = 0;
        if (r9 != null) goto L21;
        int r11 = 0;
    L22:
        int r12 = (r8 + r11) * 31;
        List<AppIntentCardData> r13 = this.dataV2;
        if (r13 != null) goto L25;
        int r14 = 0;
    L26:
        int r15 = (r12 + r14) * 31;
        Map<String, String> r16 = this.ext;
        if (r16 == null) goto L31;
        r10 = r16.hashCode();
    L31:
        return r15 + r10;
    L25:
        r14 = r13.hashCode();
        goto L26
    L21:
        r11 = r9.hashCode();
        goto L22
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "AppIntentMessage(dataSource=" + this.dataSource + ", isEnable=" + this.isEnable + ", needConfirm=" + this.needConfirm + ", confirmNlg=" + this.confirmNlg + ", refuseNlg=" + this.refuseNlg + ", isPaused=" + this.isPaused + ", showRecentContact=" + this.showRecentContact + ", data=" + this.data + ", dataV2=" + this.dataV2 + ", ext=" + this.ext + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        this.dataSource.writeToParcel(r5, r6);
        r5.writeInt(this.isEnable ? 1 : 0);
        r5.writeInt(this.needConfirm ? 1 : 0);
        r5.writeString(this.confirmNlg);
        r5.writeString(this.refuseNlg);
        r5.writeInt(this.isPaused ? 1 : 0);
        r5.writeInt(this.showRecentContact ? 1 : 0);
        ArrayList<AppEntity> r0 = this.data;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L9:
        List<AppIntentCardData> r1 = this.dataV2;
        if (r1 != null) goto L12;
        r5.writeInt(0);
    L16:
        Map<String, String> r7 = this.ext;
        if (r7 != null) goto L19;
        r5.writeInt(0);
        return;
    L19:
        r5.writeInt(1);
        r5.writeInt(r7.size());
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L21:
        if (r8.hasNext() == false) goto L27;
        Map.Entry<String, String> r2 = r8.next();
        r5.writeString(r2.getKey());
        r5.writeString(r2.getValue());
        goto L21
    L27:
        return;
    L12:
        r5.writeInt(1);
        r5.writeInt(r1.size());
        Iterator<AppIntentCardData> r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r3.next().writeToParcel(r5, r6);
        goto L14
    L5:
        r5.writeInt(1);
        r5.writeInt(r0.size());
        Iterator<AppEntity> r4 = r0.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r5.writeParcelable(r4.next(), r6);
        goto L7
    }

    public final String getConfirmNlg() {
        return this.confirmNlg;
    }

    public final ArrayList<AppEntity> getData() {
        return this.data;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final List<AppIntentCardData> getDataV2() {
        return this.dataV2;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final boolean getNeedConfirm() {
        return this.needConfirm;
    }

    public final String getRefuseNlg() {
        return this.refuseNlg;
    }

    public final boolean getShowRecentContact() {
        return this.showRecentContact;
    }

    public final boolean isEnable() {
        return this.isEnable;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public AppIntentMessage(DataSource r2, boolean r3, boolean r4, String r5, String r6, boolean r7, boolean r8, ArrayList<AppEntity> r9, List<AppIntentCardData> r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r5, "confirmNlg");
        Intrinsics.checkNotNullParameter(r6, "refuseNlg");
        this.dataSource = r2;
        this.isEnable = r3;
        this.needConfirm = r4;
        this.confirmNlg = r5;
        this.refuseNlg = r6;
        this.isPaused = r7;
        this.showRecentContact = r8;
        this.data = r9;
        this.dataV2 = r10;
        this.ext = r11;
    }

    public /* synthetic */ AppIntentMessage(DataSource r11, boolean r12, boolean r13, String r14, String r15, boolean r16, boolean r17, ArrayList r18, List r19, Map r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 2) == 0) goto L5;
        boolean r1 = true;
    L6:
        boolean r3 = false;
        if ((r21 & 4) == 0) goto L9;
        boolean r2 = false;
    L10:
        String r5 = "";
        if ((r21 & 8) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r21 & 16) != 0) goto L19;
        r5 = r15;
    L19:
        if ((r21 & 32) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r21 & 64) != 0) goto L26;
        r3 = r17;
    L26:
        Map r8 = null;
        if ((r21 & 128) == 0) goto L29;
        ArrayList r7 = null;
    L31:
        if ((r21 & ISmModel.VERSION_0100) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r21 & ISmModel.VERSION_0200) != 0) goto L38;
        r8 = r20;
    L38:
        this(r11, r1, r2, r4, r5, r6, r3, r7, r9, r8);
        return;
    L33:
        r9 = r19;
        goto L35
    L29:
        r7 = r18;
        goto L31
    L21:
        r6 = r16;
        goto L23
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L10
    L5:
        r1 = r12;
        goto L6
    }
}
