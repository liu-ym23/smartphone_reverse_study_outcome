package com.obric.memorydata.migration.sdk.internal.file;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/migration/sdk/internal/file/FileUriMapper;", "", "toBackupRelativePath", "", "uriString", "resolveRestoreFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "relativePath", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface b {
    File a(Context r1, String r2);

    String a(String r1);
}
