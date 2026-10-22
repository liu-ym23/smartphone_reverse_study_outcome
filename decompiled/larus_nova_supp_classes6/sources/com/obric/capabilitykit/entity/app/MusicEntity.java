package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BY\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0002\u0010\u0013J\b\u0010(\u001a\u00020)H\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00101\u001a\u00020/H\u0016R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MusicEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "artists", "", "Lcom/obric/capabilitykit/entity/app/Artist;", "cover", "Lcom/obric/capabilitykit/entity/app/Cover;", "preview", "Lcom/obric/capabilitykit/entity/app/Preview;", "duration", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;Lcom/obric/capabilitykit/entity/app/Cover;Lcom/obric/capabilitykit/entity/app/Preview;J)V", "getArtists", "()Ljava/util/List;", "setArtists", "(Ljava/util/List;)V", "getCover", "()Lcom/obric/capabilitykit/entity/app/Cover;", "setCover", "(Lcom/obric/capabilitykit/entity/app/Cover;)V", "getDuration", "()J", "setDuration", "(J)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPreview", "()Lcom/obric/capabilitykit/entity/app/Preview;", "setPreview", "(Lcom/obric/capabilitykit/entity/app/Preview;)V", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MusicEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private List<Artist> artists;
    private Cover cover;
    private long duration;
    private String name;
    private Preview preview;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MusicEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/MusicEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/MusicEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<MusicEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MusicEntity");
            return (MusicEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MusicEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicEntity[] newArray(int r1) {
            return new MusicEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MusicEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/entity/app/Artist;", "it", "", "invoke", "(Lcom/obric/capabilitykit/entity/app/Artist;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function1<Artist, CharSequence> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(Artist r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return r2.getName();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Artist) r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MusicEntity(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        this(EntityExtKt.e(r14), r14.readLong(), r14.readLong(), EntityExtKt.e(r14), r14.createTypedArrayList(Artist.CREATOR), (Cover) r14.readParcelable(Cover.class.getClassLoader()), (Preview) r14.readParcelable(Preview.class.getClassLoader()), r14.readLong());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    public MusicEntity(String r10, long r11, long r13, String r15, List<Artist> r16, Cover r17, Preview r18, long r19) {
        Intrinsics.checkNotNullParameter(r10, "id");
        Intrinsics.checkNotNullParameter(r15, "name");
        super(r10, r11, r13, EntityType.MUSIC);
        this.name = r15;
        this.artists = r16;
        this.cover = r17;
        this.preview = r18;
        this.duration = r19;
    }

    public /* synthetic */ MusicEntity(String r16, long r17, long r19, String r21, List r22, Cover r23, Preview r24, long r25, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 16) == 0) goto L5;
        List r10 = null;
    L7:
        if ((r27 & 32) == 0) goto L9;
        Cover r11 = null;
    L11:
        if ((r27 & 64) == 0) goto L13;
        Preview r12 = null;
    L15:
        if ((r27 & 128) == 0) goto L17;
        long r13 = 0;
    L18:
        this(r16, r17, r19, r21, r10, r11, r12, r13);
        return;
    L17:
        r13 = r25;
        goto L18
    L13:
        r12 = r24;
        goto L15
    L9:
        r11 = r23;
        goto L11
    L5:
        r10 = r22;
        goto L7
    }

    public final List<Artist> getArtists() {
        return this.artists;
    }

    public final Cover getCover() {
        return this.cover;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<Artist> r0 = this.artists;
        if (r0 == null) goto L5;
        String r1 = CollectionsKt.joinToString$default(r0, ", ", null, null, 0, null, a.a, 30, null);
    L6:
        String r3 = this.name;
        return new DisplayRepresentation(null, r3, r1, getLastModifiedTime());
    L5:
        r1 = null;
        goto L6
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final Preview getPreview() {
        return this.preview;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setArtists(List<Artist> r1) {
        this.artists = r1;
    }

    public final void setCover(Cover r1) {
        this.cover = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setPreview(Preview r1) {
        this.preview = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeString(this.name);
        r3.writeTypedList(this.artists);
        r3.writeParcelable(this.cover, r4);
        r3.writeParcelable(this.preview, r4);
        r3.writeLong(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeInt(0);
    }
}
