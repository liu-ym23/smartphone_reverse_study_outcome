package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0016J\"\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\rH\u0016J\u0018\u0010;\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\rH\u0016R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0013R\u001c\u0010+\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u00101\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "state", "", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "duration", "(Ljava/lang/String;JJLjava/lang/String;ILcom/obric/capabilitykit/entity/app/FileEntity;I)V", "getDuration", "()I", "setDuration", "(I)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "markers", "", "getMarkers", "()Ljava/util/List;", "setMarkers", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceAppPackage", "getSourceAppPackage", "setSourceAppPackage", "getState", "summary", "getSummary", "setSummary", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AuditoryRecordingEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private int duration;
    private FileEntity file;
    private List<Integer> markers;
    private String name;
    private String sourceAppName;
    private String sourceAppPackage;
    private final int state;
    private String summary;
    private List<String> todoList;
    private FileEntity transcript;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<AuditoryRecordingEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditoryRecordingEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AuditoryRecordingEntity");
            return (AuditoryRecordingEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditoryRecordingEntity[] newArray(int r1) {
            return new AuditoryRecordingEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AuditoryRecordingEntity(Parcel r12) {
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r2 = EntityExtKt.e(r12);
        long r3 = r12.readLong();
        long r5 = r12.readLong();
        String r7 = EntityExtKt.e(r12);
        int r8 = r12.readInt();
        Parcelable r0 = r12.readParcelable(FileEntity.class.getClassLoader());
        Intrinsics.checkNotNull(r0);
        this(r2, r3, r5, r7, r8, (FileEntity) r0, r12.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        int r1 = r12.readInt();
        this.transcript = (FileEntity) r12.readParcelable(FileEntity.class.getClassLoader());
        this.summary = r12.readString();
        ArrayList r4 = new ArrayList();
        r12.readList(r4, String.class.getClassLoader());
        this.todoList = r4;
        ArrayList r6 = new ArrayList();
        r12.readList(r6, Integer.TYPE.getClassLoader());
        this.markers = r6;
        this.sourceAppName = r12.readString();
        this.sourceAppPackage = r12.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 0, r1);
    }

    public AuditoryRecordingEntity(String r11, long r12, long r14, String r16, int r17, FileEntity r18, int r19) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r16, "name");
        Intrinsics.checkNotNullParameter(r18, "file");
        super(r11, r12, r14, EntityType.AUDITORY_RECORDING);
        this.name = r16;
        this.state = r17;
        this.file = r18;
        this.duration = r19;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final FileEntity getFile() {
        return this.file;
    }

    public final List<Integer> getMarkers() {
        return this.markers;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return this.file.getSharedUris();
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceAppPackage() {
        return this.sourceAppPackage;
    }

    public final int getState() {
        return this.state;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final FileEntity getTranscript() {
        return this.transcript;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setFile(FileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.file = r2;
    }

    public final void setMarkers(List<Integer> r1) {
        this.markers = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourceAppPackage(String r1) {
        this.sourceAppPackage = r1;
    }

    public final void setSummary(String r1) {
        this.summary = r1;
    }

    public final void setTodoList(List<String> r1) {
        this.todoList = r1;
    }

    public final void setTranscript(FileEntity r1) {
        this.transcript = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeInt(this.state);
        r2.writeParcelable(this.file, r3);
        r2.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(0);
        r2.writeParcelable(this.transcript, r3);
        r2.writeString(this.summary);
        r2.writeList(this.todoList);
        r2.writeList(this.markers);
        r2.writeString(this.sourceAppName);
        r2.writeString(this.sourceAppPackage);
    }
}
