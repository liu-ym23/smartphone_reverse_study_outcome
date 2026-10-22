package org.apache.commons.io.monitor;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public interface FileAlterationListener {
    void onDirectoryChange(File r1);

    void onDirectoryCreate(File r1);

    void onDirectoryDelete(File r1);

    void onFileChange(File r1);

    void onFileCreate(File r1);

    void onFileDelete(File r1);

    void onStart(FileAlterationObserver r1);

    void onStop(FileAlterationObserver r1);
}
