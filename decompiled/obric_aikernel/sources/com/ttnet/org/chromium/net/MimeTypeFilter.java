package com.ttnet.org.chromium.net;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class MimeTypeFilter implements FileFilter {
    private boolean mAcceptAllMimeTypes;
    private boolean mAcceptDirectory;
    private HashSet<String> mExtensions;
    private HashSet<String> mMimeSupertypes;
    private MimeTypeMap mMimeTypeMap;
    private HashSet<String> mMimeTypes;

    public MimeTypeFilter(@NonNull List<String> r10, boolean r11) {
        this.mExtensions = new HashSet();
        this.mMimeTypes = new HashSet();
        this.mMimeSupertypes = new HashSet();
        Iterator<String> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        String r13 = r12.next().trim().toLowerCase(Locale.US);
        if (r13.startsWith(".") == true) goto L7;
        if (r13.equals("*/*") == false) goto L13;
        this.mAcceptAllMimeTypes = true;
        goto L4
    L13:
        if (r13.endsWith("/*") == true) goto L14;
        if (r13.contains("/") == false) goto L4;
        HashSet<String> r14 = this.mMimeTypes;
    L8:
        r14.add(r13);
        goto L4
    L14:
        r14 = this.mMimeSupertypes;
        r13 = r13.substring(0, r13.length() - 2);
        goto L8
    L7:
        r14 = this.mExtensions;
        r13 = r13.substring(1);
        goto L8
    L18:
        this.mMimeTypeMap = MimeTypeMap.getSingleton();
        this.mAcceptDirectory = r11;
    }

    @NonNull
    private static String getMimeSupertype(@NonNull String r10) {
        return r10.split("/", 2)[0];
    }

    private String getMimeTypeFromExtension(@NonNull String r10) {
        String r11 = this.mMimeTypeMap.getMimeTypeFromExtension(r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.toLowerCase(Locale.US);
    }

    public boolean accept(Uri r10, String r11) {
        if (r10 == null) goto L9;
        String r12 = MimeTypeMap.getFileExtensionFromUrl(r10.toString()).toLowerCase(Locale.US);
        if (this.mExtensions.contains(r12) == false) goto L7;
        return true;
    L7:
        if (r11 != null) goto L9;
        r11 = getMimeTypeFromExtension(r12);
    L9:
        if (r11 != null) goto L11;
        return false;
    L11:
        if (this.mAcceptAllMimeTypes == false) goto L13;
    L16:
        return true;
    L13:
        if (this.mMimeTypes.contains(r11) == true) goto L16;
        if (this.mMimeSupertypes.contains(getMimeSupertype(r11)) == true) goto L16;
        return false;
    }

    @Override // java.io.FileFilter
    public boolean accept(@NonNull File r10) {
        if (r10.isDirectory() == false) goto L7;
        return this.mAcceptDirectory;
    L7:
        return accept(Uri.fromFile(r10), null);
    }
}
