package com.google.common.io;

import java.nio.file.FileSystemException;

/* JADX INFO: loaded from: classes2.dex */
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(String r5) {
        super(r5, null, "unable to guarantee security of recursive delete");
    }
}
