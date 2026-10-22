package com.obric.aiagent.ipc.idl;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FilePath;", "Landroid/os/Parcelable;", "baseDir", "", "relativePath", "", "isDirectory", "", "<init>", "(ILjava/lang/String;Z)V", "getBaseDir", "()I", "getRelativePath", "()Ljava/lang/String;", "()Z", "context", "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "toLocalFile", "Ljava/io/File;", "component1", "component2", "component3", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FilePath implements Parcelable {
    public static final Parcelable.Creator<FilePath> CREATOR = null;
    public final int a;
    public final String b;
    public final boolean c;

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FilePath) == true) goto L8;
        return false;
    L8:
        FilePath r6 = (FilePath) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "FilePath(baseDir=" + this.a + ", relativePath=" + this.b + ", isDirectory=" + this.c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeInt(this.c ? 1 : 0);
    }

    private final Application getContext() {
        return IAppContext.a.getApplication();
    }

    public final File a() {
        int r0 = this.a;
        if (r0 == 0) goto L21;
        if (r0 == 1) goto L29;
        if (r0 == 2) goto L28;
        switch(r0) {
            case 10: goto L15;
            case 11: goto L12;
            case 12: goto L23;
            default: goto L22;
        };
    L12:
        File r1 = getContext().getExternalCacheDir();
        if (r1 != null) goto L25;
        return null;
    L25:
        return new PolarisFileWrapper(r1, this.b);
    L15:
        File r2 = getContext().getObbDir();
        if (r2 != null) goto L27;
        return null;
    L27:
        return new PolarisFileWrapper(r2, this.b);
    L22:
        return getContext().getDir(this.b, 0);
    L23:
        return getContext().getExternalFilesDir(this.b);
    L28:
        return new PolarisFileWrapper(getContext().getFilesDir(), this.b);
    L29:
        return new PolarisFileWrapper(getContext().getCacheDir(), this.b);
    L21:
        return getContext().getDir(this.b, 0);
    }

    public FilePath(int r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "relativePath");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
