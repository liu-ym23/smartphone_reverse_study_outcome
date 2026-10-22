package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0018HÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "album", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getAlbum", "()Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "setAlbum", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;)V", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhotos", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PhotoRemovePhotosFromAlbumParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> CREATOR = null;
    private AlbumEntity album;
    private PhotoEntity[] photos;

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoRemovePhotosFromAlbumParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoRemovePhotosFromAlbumParams copy$default(PhotoRemovePhotosFromAlbumParams r0, AlbumEntity r1, PhotoEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.album;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.photos;
    L9:
        return r0.copy(r1, r2);
    }

    public final AlbumEntity component1() {
        return this.album;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final PhotoRemovePhotosFromAlbumParams copy(AlbumEntity r2, PhotoEntity[] r3) {
        return new PhotoRemovePhotosFromAlbumParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L8;
        return false;
    L8:
        PhotoRemovePhotosFromAlbumParams r6 = (PhotoRemovePhotosFromAlbumParams) r5;
        if (Intrinsics.areEqual(this.album, r6.album) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photos, r6.photos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(new Object[]{this.album, this.photos});
    }

    public int hashCode() {
        AlbumEntity r0 = this.album;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity[] r4 = this.photos;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoRemovePhotosFromAlbumParams(album=" + this.album + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        int r0 = 0;
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeParcelable(this.album, r6);
        PhotoEntity[] r1 = this.photos;
        if (r1 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        int r2 = r1.length;
        r5.writeInt(r2);
    L6:
        if (r0 == r2) goto L10;
        r5.writeParcelable(r1[r0], r6);
        r0 = r0 + 1;
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.album == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final AlbumEntity getAlbum() {
        return this.album;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L5;
        return this;
    L5:
        AlbumEntity r0 = this.album;
        if (r0 != null) goto L8;
        r0 = ((PhotoRemovePhotosFromAlbumParams) r3).album;
    L8:
        PhotoEntity[] r1 = this.photos;
        if (r1 != null) goto L12;
        r1 = ((PhotoRemovePhotosFromAlbumParams) r3).photos;
    L12:
        return new PhotoRemovePhotosFromAlbumParams(r0, r1);
    }

    public final void setAlbum(AlbumEntity r1) {
        this.album = r1;
    }

    public final void setPhotos(PhotoEntity[] r1) {
        this.photos = r1;
    }

    public PhotoRemovePhotosFromAlbumParams(AlbumEntity r1, PhotoEntity[] r2) {
        this.album = r1;
        this.photos = r2;
    }

    public /* synthetic */ PhotoRemovePhotosFromAlbumParams(AlbumEntity r2, PhotoEntity[] r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
