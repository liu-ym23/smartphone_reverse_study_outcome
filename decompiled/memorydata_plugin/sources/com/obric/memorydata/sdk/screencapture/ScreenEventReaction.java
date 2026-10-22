package com.obric.memorydata.sdk.screencapture;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.sdk.screencapture.rule.ScreenEventRule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J'\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010 \u001a\u00020\u0017J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015¨\u0006'"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "Landroid/os/Parcelable;", OaidModel.KEY_ID, "", "rule", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "taskOptions", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;Lcom/obric/memorydata/sdk/screencapture/TaskOptions;)V", "getId", "()Ljava/lang/String;", "getRule", "()Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "getTaskOptions", "()Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "sourcePackage", "getSourcePackage$annotations", "()V", "getSourcePackage", "setSourcePackage", "(Ljava/lang/String;)V", "hashCode", "", "equals", "", "other", "", "component1", "component2", "component3", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenEventReaction implements Parcelable {
    public static final Parcelable.Creator<ScreenEventReaction> CREATOR = null;
    private final String id;
    private final ScreenEventRule rule;
    private transient String sourcePackage;
    private final TaskOptions taskOptions;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ScreenEventReaction> {
        public a() {
        }

        public final ScreenEventReaction a(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "parcel");
            return new ScreenEventReaction(r5.readString(), (ScreenEventRule) ZeusTransformUtils.preCheckCast(r5.readParcelable(ScreenEventReaction.class.getClassLoader()), ScreenEventRule.class, "com.obric.memorydata.plugin"), (TaskOptions) ZeusTransformUtils.preCheckCast(TaskOptions.CREATOR.createFromParcel(r5), TaskOptions.class, "com.obric.memorydata.plugin"));
        }

        public final ScreenEventReaction[] a(int r1) {
            return new ScreenEventReaction[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenEventReaction createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenEventReaction[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ScreenEventReaction(String r2, ScreenEventRule r3, TaskOptions r4) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, "rule");
        Intrinsics.checkNotNullParameter(r4, "taskOptions");
        this.id = r2;
        this.rule = r3;
        this.taskOptions = r4;
    }

    public /* synthetic */ ScreenEventReaction(String r1, ScreenEventRule r2, TaskOptions r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = UUID.randomUUID().toString();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = new TaskOptions(null, null, 3, null);
    L8:
        this(r1, r2, r3);
    }

    public static /* synthetic */ ScreenEventReaction copy$default(ScreenEventReaction r0, String r1, ScreenEventRule r2, TaskOptions r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.rule;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.taskOptions;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getSourcePackage$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final ScreenEventRule component2() {
        return this.rule;
    }

    public final TaskOptions component3() {
        return this.taskOptions;
    }

    public final ScreenEventReaction copy(String r1, ScreenEventRule r2, TaskOptions r3) {
        Intrinsics.checkNotNullParameter(r1, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r2, "rule");
        Intrinsics.checkNotNullParameter(r3, "taskOptions");
        return new ScreenEventReaction(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ScreenEventReaction.class) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(this.id, ((ScreenEventReaction) ZeusTransformUtils.preCheckCast(r3, ScreenEventReaction.class, "com.obric.memorydata.plugin")).id);
    }

    public final String getId() {
        return this.id;
    }

    public final ScreenEventRule getRule() {
        return this.rule;
    }

    public final String getSourcePackage() {
        return this.sourcePackage;
    }

    public final TaskOptions getTaskOptions() {
        return this.taskOptions;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final void setSourcePackage(String r1) {
        this.sourcePackage = r1;
    }

    public String toString() {
        return "ScreenEventReaction(id=" + this.id + ", rule=" + this.rule + ", taskOptions=" + this.taskOptions + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.id);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.rule, Parcelable.class, "com.obric.memorydata.plugin"), r5);
        this.taskOptions.writeToParcel(r4, r5);
    }
}
