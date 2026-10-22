package org.apache.poi.poifs.filesystem;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentFactoryHelper {
    public static InputStream getDecryptedStream(DirectoryNode r4, String r5) {
        if (r4.hasEntry("Package") == true) goto L5;
        Decryptor r0 = Decryptor.getInstance(new EncryptionInfo(r4));
        boolean r1 = false;
        boolean r2 = true;
        if (r5 != null) goto L28;
    L13:
        if (r1 == false) goto L15;
    L17:
        r2 = r1;
    L18:
        if (r2 == true) goto L20;
        if (r5 == null) goto L25;
        throw new EncryptedDocumentException("Password incorrect");     // Catch: GeneralSecurityException -> L11
    L25:
        throw new EncryptedDocumentException("The supplied spreadsheet is protected, but no password was supplied");     // Catch: GeneralSecurityException -> L11
    L20:
        return r0.getDataStream(r4);
    L15:
        if (r0.verifyPassword("VelvetSweatshop") == false) goto L17;
    L28:
    L11:
        e = move-exception;
        throw new IOException(e);
    L9:
        if (r0.verifyPassword(r5) == false) goto L13;
        r1 = true;
        goto L13
    L5:
        return r4.createDocumentInputStream("Package");
    }

    public static InputStream getDecryptedStream(final POIFSFileSystem r2, String r3) {
        final InputStream r4 = getDecryptedStream(r2.getRoot(), r3);
        return new AnonymousClass1(r4, r2);
    }
}
