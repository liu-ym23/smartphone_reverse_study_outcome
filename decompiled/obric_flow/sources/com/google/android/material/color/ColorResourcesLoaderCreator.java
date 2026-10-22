package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    @Nullable
    public static ResourcesLoader create(@NonNull Context r5, @NonNull Map<Integer, Integer> r10) {
        byte[] r11 = ColorResourcesTableCreator.create(r5, r10);     // Catch: Exception -> L12
        Log.i(TAG, "Table created, length: " + r11.length);     // Catch: Exception -> L12
        if (r11.length != 0) goto L47;
        return null;
    L47:
        FileDescriptor r12 = Os.memfd_create("temp.arsc", 0);     // Catch: Throwable -> L40
        if (r12 != null) goto L17;
        Log.w(TAG, "Cannot create memory file descriptor.");     // Catch: Throwable -> L15
        if (r12 == null) goto L14;
        Os.close(r12);     // Catch: Exception -> L12
    L14:
        return null;
    L17:
        FileOutputStream r13 = new FileOutputStream(r12);     // Catch: Throwable -> L15
        r13.write(r11);     // Catch: Throwable -> L23
        ParcelFileDescriptor r14 = ParcelFileDescriptor.dup(r12);     // Catch: Throwable -> L23
        ResourcesLoader r15 = new ResourcesLoader();     // Catch: Throwable -> L28
        r15.addProvider(ResourcesProvider.loadFromTable(r14, null));     // Catch: Throwable -> L28
        if (r14 == null) goto L25;
        r14.close();     // Catch: Throwable -> L23
    L25:
        r13.close();     // Catch: Throwable -> L15
        Os.close(r12);     // Catch: Exception -> L12
        return r15;
    L28:
        th = move-exception;
        if (r14 != null) goto L49;
    L34:
        throw th;     // Catch: Throwable -> L23
    L49:
        r14.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L37
    L39:
        throw th;     // Catch: Throwable -> L15
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
    L15:
        th = th;
    L42:
        if (r12 == null) goto L44;
        Os.close(r12);     // Catch: Exception -> L12
    L44:
        throw th;     // Catch: Exception -> L12
    L40:
        th = th;
        r12 = null;
    L12:
        e = move-exception;
        Log.e(TAG, "Failed to create the ColorResourcesTableCreator.", e);
        return null;
    }
}
