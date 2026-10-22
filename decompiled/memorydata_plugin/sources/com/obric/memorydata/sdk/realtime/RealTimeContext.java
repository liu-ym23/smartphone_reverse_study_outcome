package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-BW\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003Jg\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0006\u0010 \u001a\u00020!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\nHÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006."}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "Landroid/os/Parcelable;", "screenMetaValue", "", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "appEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "referenceAppEntities", "referenceMetaValue", "curTopAppPackageName", "", "curTopAppName", "curTopActivityName", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreenMetaValue", "()Ljava/util/List;", "getAppEntities", "getReferenceAppEntities", "getReferenceMetaValue", "getCurTopAppPackageName", "()Ljava/lang/String;", "getCurTopAppName", "getCurTopActivityName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealTimeContext implements Parcelable {
    public static final Parcelable.Creator<RealTimeContext> CREATOR = null;
    public static final a Companion = null;
    private final List<AppEntity> appEntities;
    private final String curTopActivityName;
    private final String curTopAppName;
    private final String curTopAppPackageName;
    private final List<AppEntity> referenceAppEntities;
    private final List<MetaValue> referenceMetaValue;
    private final List<MetaValue> screenMetaValue;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/RealTimeContext$Companion;", "", "<init>", "()V", "dummy", "Lcom/obric/memorydata/sdk/realtime/RealTimeContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final RealTimeContext a() {
            return new RealTimeContext(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), "", "", "");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<RealTimeContext> {
        public b() {
        }

        public final RealTimeContext a(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            int r11 = r12.readInt();
            ArrayList r0 = new ArrayList(r11);
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 == r11) goto L5;
            r0.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r2 = r2 + 1;
            goto L3
        L5:
            List r4 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
            int r13 = r12.readInt();
            ArrayList r3 = new ArrayList(r13);
            int r5 = 0;
        L6:
            if (r5 == r13) goto L8;
            r3.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r5 = r5 + 1;
            goto L6
        L8:
            List r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
            int r14 = r12.readInt();
            ArrayList r7 = new ArrayList(r14);
            int r8 = 0;
        L9:
            if (r8 == r14) goto L11;
            r7.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r8 = r8 + 1;
            goto L9
        L11:
            List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
            int r15 = r12.readInt();
            ArrayList r10 = new ArrayList(r15);
        L12:
            if (r1 == r15) goto L15;
            r10.add(r12.readParcelable(RealTimeContext.class.getClassLoader()));
            r1 = r1 + 1;
            goto L12
        L15:
            return new RealTimeContext(r4, r6, r9, (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), r12.readString(), r12.readString(), r12.readString());
        }

        public final RealTimeContext[] a(int r1) {
            return new RealTimeContext[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RealTimeContext createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ RealTimeContext[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public RealTimeContext(List<? extends MetaValue> r3, List<? extends AppEntity> r4, List<? extends AppEntity> r5, List<? extends MetaValue> r6, String r7, String r8, String r9) {
        List<MetaValue> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<MetaValue> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "screenMetaValue");
        Intrinsics.checkNotNullParameter(r11, "appEntities");
        Intrinsics.checkNotNullParameter(r12, "referenceAppEntities");
        Intrinsics.checkNotNullParameter(r13, "referenceMetaValue");
        Intrinsics.checkNotNullParameter(r7, "curTopAppPackageName");
        Intrinsics.checkNotNullParameter(r8, "curTopAppName");
        Intrinsics.checkNotNullParameter(r9, "curTopActivityName");
        this.screenMetaValue = r10;
        this.appEntities = r11;
        this.referenceAppEntities = r12;
        this.referenceMetaValue = r13;
        this.curTopAppPackageName = r7;
        this.curTopAppName = r8;
        this.curTopActivityName = r9;
    }

    public static /* synthetic */ RealTimeContext copy$default(RealTimeContext r8, List r9, List r10, List r11, List r12, String r13, String r14, String r15, int r16, Object r17) {
        List<MetaValue> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List<AppEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List<MetaValue> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if ((r16 & 1) == 0) goto L6;
        r1 = r8.screenMetaValue;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r3 = r8.appEntities;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r4 = r8.referenceAppEntities;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r2 = r8.referenceMetaValue;
    L15:
        if ((r16 & 16) == 0) goto L17;
        String r5 = r8.curTopAppPackageName;
    L19:
        if ((r16 & 32) == 0) goto L21;
        String r6 = r8.curTopAppName;
    L23:
        if ((r16 & 64) == 0) goto L25;
        String r7 = r8.curTopActivityName;
    L27:
        return r8.copy(r1, r3, r4, r2, r5, r6, r7);
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    }

    public final List<MetaValue> component1() {
        return this.screenMetaValue;
    }

    public final List<AppEntity> component2() {
        return this.appEntities;
    }

    public final List<AppEntity> component3() {
        return this.referenceAppEntities;
    }

    public final List<MetaValue> component4() {
        return this.referenceMetaValue;
    }

    public final String component5() {
        return this.curTopAppPackageName;
    }

    public final String component6() {
        return this.curTopAppName;
    }

    public final String component7() {
        return this.curTopActivityName;
    }

    public final RealTimeContext copy(List<? extends MetaValue> r11, List<? extends AppEntity> r12, List<? extends AppEntity> r13, List<? extends MetaValue> r14, String r15, String r16, String r17) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "screenMetaValue");
        Intrinsics.checkNotNullParameter(r4, "appEntities");
        Intrinsics.checkNotNullParameter(r5, "referenceAppEntities");
        Intrinsics.checkNotNullParameter(r6, "referenceMetaValue");
        Intrinsics.checkNotNullParameter(r15, "curTopAppPackageName");
        Intrinsics.checkNotNullParameter(r16, "curTopAppName");
        Intrinsics.checkNotNullParameter(r17, "curTopActivityName");
        return new RealTimeContext(r3, r4, r5, r6, r15, r16, r17);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RealTimeContext.class) == true) goto L8;
        return false;
    L8:
        RealTimeContext r6 = (RealTimeContext) ZeusTransformUtils.preCheckCast(r5, RealTimeContext.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.screenMetaValue, r6.screenMetaValue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appEntities, r6.appEntities) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.referenceAppEntities, r6.referenceAppEntities) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceMetaValue, r6.referenceMetaValue) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.curTopAppPackageName, r6.curTopAppPackageName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.curTopAppName, r6.curTopAppName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.curTopActivityName, r6.curTopActivityName) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final List<AppEntity> getAppEntities() {
        return this.appEntities;
    }

    public final String getCurTopActivityName() {
        return this.curTopActivityName;
    }

    public final String getCurTopAppName() {
        return this.curTopAppName;
    }

    public final String getCurTopAppPackageName() {
        return this.curTopAppPackageName;
    }

    public final List<AppEntity> getReferenceAppEntities() {
        return this.referenceAppEntities;
    }

    public final List<MetaValue> getReferenceMetaValue() {
        return this.referenceMetaValue;
    }

    public final List<MetaValue> getScreenMetaValue() {
        return this.screenMetaValue;
    }

    public int hashCode() {
        return (((((((((((this.screenMetaValue.hashCode() * 31) + this.appEntities.hashCode()) * 31) + this.referenceAppEntities.hashCode()) * 31) + this.referenceMetaValue.hashCode()) * 31) + this.curTopAppPackageName.hashCode()) * 31) + this.curTopAppName.hashCode()) * 31) + this.curTopActivityName.hashCode();
    }

    public String toString() {
        return "RealTimeContext(screenMetaValue=" + this.screenMetaValue + ", appEntities=" + this.appEntities + ", referenceAppEntities=" + this.referenceAppEntities + ", referenceMetaValue=" + this.referenceMetaValue + ", curTopAppPackageName=" + this.curTopAppPackageName + ", curTopAppName=" + this.curTopAppName + ", curTopActivityName=" + this.curTopActivityName + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "dest");
        List<MetaValue> r0 = this.screenMetaValue;
        r5.writeInt(r0.size());
        Iterator<MetaValue> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1.next(), Parcelable.class, "com.obric.memorydata.plugin"), r6);
        goto L4
    L6:
        List<AppEntity> r2 = this.appEntities;
        r5.writeInt(r2.size());
        Iterator<AppEntity> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r3.next(), Parcelable.class, "com.obric.memorydata.plugin"), r6);
        goto L8
    L10:
        List<AppEntity> r4 = this.referenceAppEntities;
        r5.writeInt(r4.size());
        Iterator<AppEntity> r7 = r4.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r7.next(), Parcelable.class, "com.obric.memorydata.plugin"), r6);
        goto L12
    L14:
        List<MetaValue> r8 = this.referenceMetaValue;
        r5.writeInt(r8.size());
        Iterator<MetaValue> r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r9.next(), Parcelable.class, "com.obric.memorydata.plugin"), r6);
        goto L16
    L18:
        r5.writeString(this.curTopAppPackageName);
        r5.writeString(this.curTopAppName);
        r5.writeString(this.curTopActivityName);
    }
}
