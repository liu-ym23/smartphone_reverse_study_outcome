package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u001a\u00103\u001a\u0004\u0018\u00010\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J\u0019\u00104\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u00105J\"\u00106\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020#H\u0016J\u0018\u0010;\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020#H\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R4\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010*\u001a\u0004\u0018\u00010#2\b\u0010!\u001a\u0004\u0018\u00010#@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", ActivityLifecycle.NAME, "startTime", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "closeInHoliday", "", "getCloseInHoliday", "()Z", "setCloseInHoliday", "(Z)V", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "isEnabled", "setEnabled", "isRinging", "()Ljava/lang/Boolean;", "setRinging", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "setName", EventBody.KEY_VALUE, "", "", "repeatDayOfWeek", "getRepeatDayOfWeek", "()Ljava/util/List;", "setRepeatDayOfWeek", "(Ljava/util/List;)V", "repeatDayOfWeekDesc", "repeatType", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "repeatTypeDesc", "getStartTime", "setStartTime", "generateRepeatDesc", "generateRepeatTypeDesc", "(Ljava/lang/Integer;)Ljava/lang/String;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlarmEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 4;
    private static final int RELATED_VERSION = 0;
    private boolean closeInHoliday;
    private String date;
    private boolean isEnabled;
    private Boolean isRinging;
    private String name;
    private List<Integer> repeatDayOfWeek;
    private String repeatDayOfWeekDesc;
    private Integer repeatType;
    private String repeatTypeDesc;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AlarmEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlarmEntity");
            return (AlarmEntity) ZeusTransformUtils.preCheckCast(r1, AlarmEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity[] newArray(int r1) {
            return new AlarmEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Integer, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<Integer, String> f7541a;

        public a(Map<Integer, String> r3) {
            this.f7541a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            super(1);
        }

        public final CharSequence a(int r2) {
            String r1 = (String) ZeusTransformUtils.preCheckCast(this.f7541a.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L7;
            return "";
        L7:
            return r1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CharSequence invoke(Integer r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue());
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlarmEntity(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this(EntityExtKt.readStringOrEmpty(r10), r10.readLong(), r10.readLong(), EntityExtKt.readStringOrEmpty(r10), EntityExtKt.readStringOrEmpty(r10));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r0 = r10.readInt();
        this.isEnabled = EntityExtKt.readBool(r10);
        ArrayList r1 = new ArrayList();
        r10.readList(r1, Integer.TYPE.getClassLoader());
        setRepeatDayOfWeek(r1);
        this.closeInHoliday = EntityExtKt.readBool(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 4, r0);
    }

    public AlarmEntity(String r9, long r10, long r12, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r15, "startTime");
        super(r9, r10, r12, 701);
        this.name = r14;
        this.startTime = r15;
    }

    public /* synthetic */ AlarmEntity(String r10, long r11, long r13, String r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        String r8 = "";
    L6:
        this(r10, r11, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    private final String generateRepeatDesc(List<Integer> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return null;
    L12:
        Map r12 = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "周一"), TuplesKt.to(2, "周二"), TuplesKt.to(3, "周三"), TuplesKt.to(4, "周四"), TuplesKt.to(5, "周五"), TuplesKt.to(6, "周六"), TuplesKt.to(7, "周日")});
        if (r10.containsAll(CollectionsKt.toList(new IntRange(1, 7))) == false) goto L16;
        return "每天";
    L16:
        return 27599 + CollectionsKt.joinToString$default(CollectionsKt.sorted(r10), "", null, null, 0, null, new a(r12), 30, null);
    L5:
        if (r10.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    private final String generateRepeatTypeDesc(Integer r1) {
        if (r1 == null) goto L16;
        int r0 = r1.intValue();
        if (r0 != 0) goto L6;
        return "不重复";
    L6:
        if (r0 != 1) goto L8;
        return "每天";
    L8:
        if (r0 != 2) goto L10;
        return "法定工作日";
    L10:
        if (r0 != 3) goto L16;
        return "法定节假日及周末";
    L16:
        return null;
    }

    public final boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final Integer getRepeatType() {
        return this.repeatType;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final Boolean isRinging() {
        return this.isRinging;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        if (r5 != 1) goto L5;
        this.date = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (r5 != 2) goto L7;
        this.isRinging = (Boolean) ZeusTransformUtils.preCheckCast(r3.readValue(r4), Boolean.class, "com.obric.memorydata.plugin");
        return;
    L7:
        if (r5 != 3) goto L9;
        setRepeatType((Integer) ZeusTransformUtils.preCheckCast(r3.readValue(r4), Integer.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (r5 != 4) goto L19;
        this.repeatTypeDesc = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void setCloseInHoliday(boolean r1) {
        this.closeInHoliday = r1;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final void setEnabled(boolean r1) {
        this.isEnabled = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setRepeatDayOfWeek(List<Integer> r3) {
        List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.repeatDayOfWeekDesc = generateRepeatDesc(r4);
        this.repeatDayOfWeek = r4;
    }

    public final void setRepeatType(Integer r2) {
        this.repeatTypeDesc = generateRepeatTypeDesc(r2);
        this.repeatType = r2;
    }

    public final void setRinging(Boolean r1) {
        this.isRinging = r1;
    }

    public final void setStartTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        r1.writeString(this.startTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(4);
        EntityExtKt.writeBool(r1, this.isEnabled);
        r1.writeList(this.repeatDayOfWeek);
        EntityExtKt.writeBool(r1, this.closeInHoliday);
        r1.writeValue(this.date);
        r1.writeValue(this.isRinging);
        r1.writeValue(this.repeatType);
        r1.writeValue(this.repeatTypeDesc);
    }
}
