package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
final class ParcelFileDescriptorRewinder$InternalRewinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ParcelFileDescriptor f1418a;

    public ParcelFileDescriptorRewinder$InternalRewinder(ParcelFileDescriptor r5) {
        this.f1418a = r5;
    }

    public ParcelFileDescriptor rewind() throws IOException {
        ParcelFileDescriptor r5 = this.f1418a;
        Os.lseek(r5.getFileDescriptor(), 0, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L5
        return r5;
    L5:
        e = move-exception;
        throw new IOException(e);
    }
}
