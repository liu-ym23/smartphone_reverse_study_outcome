package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/ASROutput;", "Landroid/os/Parcelable;", "asrResult", "", "asrName", "asrChatterEntity", "", "Lcom/ss/android/lark/intent/export/entity/output/AsrChatterEntity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAsrResult", "()Ljava/lang/String;", "getAsrName", "getAsrChatterEntity", "()Ljava/util/List;", "setAsrChatterEntity", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ASROutput implements Parcelable {
    public static final Parcelable.Creator<ASROutput> CREATOR = null;
    private List<? extends List<AsrChatterEntity>> asrChatterEntity;
    private final String asrName;
    private final String asrResult;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Creator implements Parcelable.Creator<ASROutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASROutput createFromParcel(Parcel r11) {
            Intrinsics.checkNotNullParameter(r11, "parcel");
            String r0 = r11.readString();
            String r1 = r11.readString();
            int r2 = r11.readInt();
            ArrayList r3 = new ArrayList(r2);
            int r5 = 0;
        L3:
            if (r5 == r2) goto L9;
            int r6 = r11.readInt();
            ArrayList r7 = new ArrayList(r6);
            int r8 = 0;
        L5:
            if (r8 == r6) goto L7;
            r7.add(AsrChatterEntity.CREATOR.createFromParcel(r11));
            r8 = r8 + 1;
            goto L5
        L7:
            r3.add(r7);
            r5 = r5 + 1;
            goto L3
        L9:
            return new ASROutput(r0, r1, r3);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASROutput createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ASROutput[] newArray(int r1) {
            return new ASROutput[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ASROutput[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ASROutput copy$default(ASROutput r0, String r1, String r2, List r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.asrResult;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.asrName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.asrChatterEntity;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.asrResult;
    }

    public final String component2() {
        return this.asrName;
    }

    public final List<List<AsrChatterEntity>> component3() {
        return this.asrChatterEntity;
    }

    public final ASROutput copy(String r2, String r3, List<? extends List<AsrChatterEntity>> r4) {
        Intrinsics.checkNotNullParameter(r4, "asrChatterEntity");
        return new ASROutput(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ASROutput) == true) goto L8;
        return false;
    L8:
        ASROutput r6 = (ASROutput) r5;
        if (Intrinsics.areEqual(this.asrResult, r6.asrResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrName, r6.asrName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asrChatterEntity, r6.asrChatterEntity) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.asrResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.asrName;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.asrChatterEntity.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ASROutput(asrResult=" + this.asrResult + ", asrName=" + this.asrName + ", asrChatterEntity=" + this.asrChatterEntity + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "dest");
        r4.writeString(this.asrResult);
        r4.writeString(this.asrName);
        List<? extends List<AsrChatterEntity>> r0 = this.asrChatterEntity;
        r4.writeInt(r0.size());
        Iterator<? extends List<AsrChatterEntity>> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        List<AsrChatterEntity> r2 = r1.next();
        r4.writeInt(r2.size());
        Iterator<AsrChatterEntity> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        r3.next().writeToParcel(r4, r5);
        goto L7
    }

    public final List<List<AsrChatterEntity>> getAsrChatterEntity() {
        return this.asrChatterEntity;
    }

    public final String getAsrName() {
        return this.asrName;
    }

    public final String getAsrResult() {
        return this.asrResult;
    }

    public final void setAsrChatterEntity(List<? extends List<AsrChatterEntity>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.asrChatterEntity = r2;
    }

    public ASROutput(String r2, String r3, List<? extends List<AsrChatterEntity>> r4) {
        Intrinsics.checkNotNullParameter(r4, "asrChatterEntity");
        this.asrResult = r2;
        this.asrName = r3;
        this.asrChatterEntity = r4;
    }
}
