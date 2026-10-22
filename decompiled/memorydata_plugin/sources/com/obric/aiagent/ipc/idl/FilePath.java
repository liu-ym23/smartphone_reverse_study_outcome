package com.obric.aiagent.ipc.idl;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FilePath;", "Landroid/os/Parcelable;", "baseDir", "", "relativePath", "", "isDirectory", "", "<init>", "(ILjava/lang/String;Z)V", "getBaseDir", "()I", "getRelativePath", "()Ljava/lang/String;", "()Z", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "toLocalFile", "Ljava/io/File;", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilePath implements Parcelable {
    public static final Parcelable.Creator<FilePath> CREATOR = null;
    public static final a Companion = null;
    public static final int DIR_BASE = 0;
    public static final int DIR_CACHE = 1;
    public static final int DIR_EXTERNAL_CACHE = 11;
    public static final int DIR_EXTERNAL_FILES = 12;
    public static final int DIR_FILES = 2;
    public static final int DIR_OBB = 10;
    private final int baseDir;
    private final boolean isDirectory;
    private final String relativePath;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FilePath$Companion;", "", "<init>", "()V", "DIR_BASE", "", "DIR_CACHE", "DIR_FILES", "DIR_OBB", "DIR_EXTERNAL_CACHE", "DIR_EXTERNAL_FILES", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<FilePath> {
        public b() {
        }

        public final FilePath a(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            int r0 = r3.readInt();
            String r1 = r3.readString();
            if (r3.readInt() == 0) goto L5;
            boolean r4 = true;
        L7:
            return new FilePath(r0, r1, r4);
        L5:
            r4 = false;
            goto L7
        }

        public final FilePath[] a(int r1) {
            return new FilePath[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FilePath createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ FilePath[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public FilePath(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "relativePath");
        this.baseDir = r2;
        this.relativePath = r3;
        this.isDirectory = r4;
    }

    public /* synthetic */ FilePath(int r1, String r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ FilePath copy$default(FilePath r0, int r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.baseDir;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.relativePath;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.isDirectory;
    L12:
        return r0.copy(r1, r2, r3);
    }

    private final Application getContext() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.aiagent.platform.a.a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
    }

    public final int component1() {
        return this.baseDir;
    }

    public final String component2() {
        return this.relativePath;
    }

    public final boolean component3() {
        return this.isDirectory;
    }

    public final FilePath copy(int r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "relativePath");
        return new FilePath(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FilePath.class) == true) goto L8;
        return false;
    L8:
        FilePath r6 = (FilePath) ZeusTransformUtils.preCheckCast(r5, FilePath.class, "com.obric.memorydata.plugin");
        if (this.baseDir == r6.baseDir) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.relativePath, r6.relativePath) == true) goto L15;
        return false;
    L15:
        if (this.isDirectory == r6.isDirectory) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getBaseDir() {
        return this.baseDir;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.baseDir) * 31) + this.relativePath.hashCode()) * 31) + Boolean.hashCode(this.isDirectory);
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final File toLocalFile() {
        int r0 = this.baseDir;
        if (r0 == 0) goto L20;
        if (r0 == 1) goto L27;
        if (r0 == 2) goto L26;
        switch(r0) {
            case 10: goto L14;
            case 11: goto L11;
            case 12: goto L21;
            default: goto L20;
        };
    L11:
        File r1 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getExternalCacheDir();
        if (r1 != null) goto L23;
        return null;
    L23:
        return new File(r1, this.relativePath);
    L14:
        File r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getObbDir();
        if (r2 != null) goto L25;
        return null;
    L25:
        return new File(r2, this.relativePath);
    L21:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getExternalFilesDir(this.relativePath);
    L26:
        return new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getFilesDir(), this.relativePath);
    L27:
        return new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getCacheDir(), this.relativePath);
    L20:
        return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getDir(this.relativePath, 0);
    }

    public String toString() {
        return "FilePath(baseDir=" + this.baseDir + ", relativePath=" + this.relativePath + ", isDirectory=" + this.isDirectory + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.baseDir);
        r1.writeString(this.relativePath);
        r1.writeInt(this.isDirectory ? 1 : 0);
    }
}
