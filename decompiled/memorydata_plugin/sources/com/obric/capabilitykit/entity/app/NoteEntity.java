package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BO\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010-\u001a\u00020.H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0014H\u0016J\"\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u000206H\u0016R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "title", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "formatMode", "Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", "noteFolder", "isFavorite", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;Ljava/lang/String;Z)V", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getFiles", "()Ljava/util/List;", "setFiles", "(Ljava/util/List;)V", "getFormatMode", "()Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", "setFormatMode", "(Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;)V", "()Z", "setFavorite", "(Z)V", "getNoteFolder", "()Ljava/lang/String;", "setNoteFolder", "(Ljava/lang/String;)V", "recordings", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "getRecordings", "setRecordings", "getText", "setText", "getTitle", "setTitle", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NoteEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 5;
    private List<FileEntity> files;
    private FormatModeEnum formatMode;
    private boolean isFavorite;
    private String noteFolder;
    private List<RecordingEntity> recordings;
    private String text;
    private String title;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/NoteEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<NoteEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.NoteEntity");
            return (NoteEntity) ZeusTransformUtils.preCheckCast(r1, NoteEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NoteEntity[] newArray(int r1) {
            return new NoteEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public NoteEntity(Parcel r13) {
        Intrinsics.checkNotNullParameter(r13, "parcel");
        this(EntityExtKt.readStringOrEmpty(r13), r13.readLong(), r13.readLong(), EntityExtKt.readStringOrEmpty(r13), EntityExtKt.readStringOrEmpty(r13), FormatModeEnum.Companion.from(r13.readString()), r13.readString(), EntityExtKt.readBool(r13));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        int r0 = r13.readInt();
        this.files = r13.createTypedArrayList(FileEntity.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 1, r0);
    }

    public NoteEntity(String r11, long r12, long r14, String r16, String r17, FormatModeEnum r18, String r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        super(r11, r12, r14, 601);
        this.title = r16;
        this.text = r17;
        this.formatMode = r18;
        this.noteFolder = r19;
        this.isFavorite = r20;
    }

    public /* synthetic */ NoteEntity(String r15, long r16, long r18, String r20, String r21, FormatModeEnum r22, String r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 32) == 0) goto L5;
        FormatModeEnum r11 = null;
    L7:
        if ((r25 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r25 & 128) == 0) goto L13;
        boolean r13 = false;
    L14:
        this(r15, r16, r18, r20, r21, r11, r12, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r12 = r23;
        goto L11
    L5:
        r11 = r22;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.title, null, getLastModifiedTime(), 5, null);
    }

    public final List<FileEntity> getFiles() {
        return this.files;
    }

    public final FormatModeEnum getFormatMode() {
        return this.formatMode;
    }

    public final String getNoteFolder() {
        return this.noteFolder;
    }

    public final List<RecordingEntity> getRecordings() {
        return this.recordings;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        List<FileEntity> r4 = this.files;
        if (r4 == null) goto L9;
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L11;
        CollectionsKt.addAll(r0, ((FileEntity) ZeusTransformUtils.preCheckCast(r5.next(), FileEntity.class, "com.obric.memorydata.plugin")).getSharedUris());
        goto L6
    L11:
        return r0;
    L9:
        return CollectionsKt.emptyList();
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L6;
        this.recordings = (List) ZeusTransformUtils.preCheckCast(r2.readValue(r3), List.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void setFavorite(boolean r1) {
        this.isFavorite = r1;
    }

    public final void setFiles(List<FileEntity> r3) {
        this.files = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setFormatMode(FormatModeEnum r1) {
        this.formatMode = r1;
    }

    public final void setNoteFolder(String r1) {
        this.noteFolder = r1;
    }

    public final void setRecordings(List<RecordingEntity> r3) {
        this.recordings = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.title);
        r1.writeString(this.text);
        FormatModeEnum r3 = this.formatMode;
        if (r3 == null) goto L5;
        String r4 = r3.name();
    L6:
        r1.writeString(r4);
        r1.writeString(this.noteFolder);
        EntityExtKt.writeBool(r1, this.isFavorite);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(1);
        r1.writeTypedList(this.files);
        r1.writeValue(this.recordings);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
