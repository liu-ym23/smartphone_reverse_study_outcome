package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\"\u0010[\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`H\u0016J\u0018\u0010a\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010b\u001a\u00020`H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001e\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R\u001a\u0010:\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u001e\u0010<\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R\u001c\u0010A\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\u001c\u0010D\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R\u001c\u0010G\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012R\u001c\u0010J\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R\u001c\u0010M\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010\u0012R\u001c\u0010P\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012R\u001e\u0010U\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bV\u00100\"\u0004\bW\u00102R\u001c\u0010X\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012¨\u0006d"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", ActivityLifecycle.NAME, "startTime", "endTime", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", MemoryKeyInfoEntity.KEY_ADDRESS, "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "allDay", "", "getAllDay", "()Z", "setAllDay", "(Z)V", "attendees", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getAttendees", "()Ljava/util/List;", "setAttendees", "(Ljava/util/List;)V", "calendarType", "Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "getCalendarType", "()Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "setCalendarType", "(Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;)V", "completed", "getCompleted", "()Ljava/lang/Boolean;", "setCompleted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndTime", "setEndTime", "endTimestamp", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "iCalendarText", "getICalendarText", "setICalendarText", "icsId", "getIcsId", "setIcsId", "isFavorite", "setFavorite", "jumpCalendarPageStartTimeStamp", "getJumpCalendarPageStartTimeStamp", "setJumpCalendarPageStartTimeStamp", "getName", "setName", "note", "getNote", "setNote", "rawRrule", "getRawRrule", "setRawRrule", "recurrenceId", "getRecurrenceId", "setRecurrenceId", "reminderDesc", "getReminderDesc", "setReminderDesc", "repeatDescription", "getRepeatDescription", "setRepeatDescription", "rruleDescription", "getRruleDescription", "setRruleDescription", "getStartTime", "setStartTime", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "timeDescription", "getTimeDescription", "setTimeDescription", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScheduleEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 15;
    private static final int RELATED_VERSION = 2;
    private String address;
    private boolean allDay;
    private List<ContactEntity> attendees;
    private CalendarTypeEnum calendarType;
    private Boolean completed;
    private String endTime;
    private Long endTimestamp;
    private String iCalendarText;
    private String icsId;
    private boolean isFavorite;
    private Long jumpCalendarPageStartTimeStamp;
    private String name;
    private String note;
    private String rawRrule;
    private String recurrenceId;
    private String reminderDesc;
    private String repeatDescription;
    private String rruleDescription;
    private String startTime;
    private Long startTimestamp;
    private String timeDescription;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ScheduleEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ScheduleEntity");
            return (ScheduleEntity) ZeusTransformUtils.preCheckCast(r1, ScheduleEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 17;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleEntity[] newArray(int r1) {
            return new ScheduleEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ScheduleEntity(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        this(EntityExtKt.readStringOrEmpty(r11), r11.readLong(), r11.readLong(), EntityExtKt.readStringOrEmpty(r11), EntityExtKt.readStringOrEmpty(r11), EntityExtKt.readStringOrEmpty(r11));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r0 = r11.readInt();
        this.address = r11.readString();
        this.attendees = r11.createTypedArrayList(ContactEntity.CREATOR);
        this.repeatDescription = r11.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 15, r0);
    }

    public ScheduleEntity(String r12, long r13, long r15, String r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r12, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r17, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r18, "startTime");
        Intrinsics.checkNotNullParameter(r19, "endTime");
        super(r12, r13, r15, 401);
        this.name = r17;
        this.startTime = r18;
        this.endTime = r19;
        this.startTimestamp = StringsKt.toLongOrNull(r18);
        this.endTimestamp = StringsKt.toLongOrNull(this.endTime);
    }

    public final String getAddress() {
        return this.address;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    public final List<ContactEntity> getAttendees() {
        return this.attendees;
    }

    public final CalendarTypeEnum getCalendarType() {
        return this.calendarType;
    }

    public final Boolean getCompleted() {
        return this.completed;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final String getICalendarText() {
        return this.iCalendarText;
    }

    public final String getIcsId() {
        return this.icsId;
    }

    public final Long getJumpCalendarPageStartTimeStamp() {
        return this.jumpCalendarPageStartTimeStamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getRawRrule() {
        return this.rawRrule;
    }

    public final String getRecurrenceId() {
        return this.recurrenceId;
    }

    public final String getReminderDesc() {
        return this.reminderDesc;
    }

    public final String getRepeatDescription() {
        return this.repeatDescription;
    }

    public final String getRruleDescription() {
        return this.rruleDescription;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTimeDescription() {
        return this.timeDescription;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r4, ClassLoader r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        Boolean r0 = null;
        CalendarTypeEnum r1 = null;
        switch(r6) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L41;
        };
    L5:
        this.rawRrule = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L6:
        this.jumpCalendarPageStartTimeStamp = (Long) ZeusTransformUtils.preCheckCast(r4.readValue(r5), Long.class, "com.obric.memorydata.plugin");
        return;
    L7:
        this.iCalendarText = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L8:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        r1 = CalendarTypeEnum.Companion.from(r7);
    L11:
        this.calendarType = r1;
        return;
    L12:
        this.recurrenceId = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L13:
        this.icsId = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L14:
        this.rruleDescription = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L15:
        this.timeDescription = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L16:
        this.reminderDesc = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L17:
        Object r8 = r4.readValue(r5);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");
        this.isFavorite = ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return;
    L18:
        Object r9 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r9, Boolean.class) == false) goto L21;
        r0 = (Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin");
    L21:
        this.completed = r0;
        return;
    L22:
        this.note = (String) ZeusTransformUtils.preCheckCast(r4.readValue(r5), String.class, "com.obric.memorydata.plugin");
        return;
    L23:
        Object r10 = r4.readValue(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Boolean");
        this.allDay = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return;
    L24:
        this.endTimestamp = (Long) ZeusTransformUtils.preCheckCast(r4.readValue(r5), Long.class, "com.obric.memorydata.plugin");
        return;
    L25:
        this.startTimestamp = (Long) ZeusTransformUtils.preCheckCast(r4.readValue(r5), Long.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public final void setAllDay(boolean r1) {
        this.allDay = r1;
    }

    public final void setAttendees(List<ContactEntity> r3) {
        this.attendees = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setCalendarType(CalendarTypeEnum r1) {
        this.calendarType = r1;
    }

    public final void setCompleted(Boolean r1) {
        this.completed = r1;
    }

    public final void setEndTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.endTime = r2;
    }

    public final void setEndTimestamp(Long r1) {
        this.endTimestamp = r1;
    }

    public final void setFavorite(boolean r1) {
        this.isFavorite = r1;
    }

    public final void setICalendarText(String r1) {
        this.iCalendarText = r1;
    }

    public final void setIcsId(String r1) {
        this.icsId = r1;
    }

    public final void setJumpCalendarPageStartTimeStamp(Long r1) {
        this.jumpCalendarPageStartTimeStamp = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNote(String r1) {
        this.note = r1;
    }

    public final void setRawRrule(String r1) {
        this.rawRrule = r1;
    }

    public final void setRecurrenceId(String r1) {
        this.recurrenceId = r1;
    }

    public final void setReminderDesc(String r1) {
        this.reminderDesc = r1;
    }

    public final void setRepeatDescription(String r1) {
        this.repeatDescription = r1;
    }

    public final void setRruleDescription(String r1) {
        this.rruleDescription = r1;
    }

    public final void setStartTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startTime = r2;
    }

    public final void setStartTimestamp(Long r1) {
        this.startTimestamp = r1;
    }

    public final void setTimeDescription(String r1) {
        this.timeDescription = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(15);
        r1.writeString(this.address);
        r1.writeTypedList(this.attendees);
        r1.writeString(this.repeatDescription);
        r1.writeValue(this.startTimestamp);
        r1.writeValue(this.endTimestamp);
        r1.writeValue(Boolean.valueOf(this.allDay));
        r1.writeValue(this.note);
        r1.writeValue(this.completed);
        r1.writeValue(Boolean.valueOf(this.isFavorite));
        r1.writeValue(this.reminderDesc);
        r1.writeValue(this.timeDescription);
        r1.writeValue(this.rruleDescription);
        r1.writeValue(this.icsId);
        r1.writeValue(this.recurrenceId);
        CalendarTypeEnum r3 = this.calendarType;
        if (r3 == null) goto L5;
        String r4 = r3.name();
    L6:
        r1.writeValue(r4);
        r1.writeValue(this.iCalendarText);
        r1.writeValue(this.jumpCalendarPageStartTimeStamp);
        r1.writeValue(this.rawRrule);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
