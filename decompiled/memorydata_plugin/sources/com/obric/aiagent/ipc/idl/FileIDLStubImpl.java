package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import com.obric.aikernel.sdk.ext.Params;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FileIDLStubImpl;", "Lcom/obric/aiagent/ipc/idl/IFileIDLSPI;", "<init>", "()V", "openFile", "Landroid/os/ParcelFileDescriptor;", Params.FILE_PATH, "Lcom/obric/aiagent/ipc/idl/FilePath;", "mode", "", "deleteFile", "", "listDir", "", "listAllFile", "ipc-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileIDLStubImpl implements b {
    public FileIDLStubImpl() {
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return b.C0239b.a(this);
    }
}
