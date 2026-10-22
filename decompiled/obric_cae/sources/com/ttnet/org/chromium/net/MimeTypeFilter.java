package com.ttnet.org.chromium.net;

import android.net.Uri;
import android.webkit.MimeTypeMap;
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

    public MimeTypeFilter(List<String> r8, boolean r10) {
        this.mExtensions = new HashSet();
        this.mMimeTypes = new HashSet();
        this.mMimeSupertypes = new HashSet();
        Iterator<String> r11 = r8.iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        String r12 = r11.next().trim().toLowerCase(Locale.US);
        if (r12.startsWith(".") == true) goto L7;
        if (r12.equals("*/*") == false) goto L13;
        this.mAcceptAllMimeTypes = true;
        goto L4
    L13:
        if (r12.endsWith("/*") == true) goto L14;
        if (r12.contains("/") == false) goto L4;
        HashSet<String> r13 = this.mMimeTypes;
    L8:
        r13.add(r12);
        goto L4
    L14:
        r13 = this.mMimeSupertypes;
        r12 = r12.substring(0, r12.length() - 2);
        goto L8
    L7:
        r13 = this.mExtensions;
        r12 = r12.substring(1);
        goto L8
    L18:
        this.mMimeTypeMap = MimeTypeMap.getSingleton();
        this.mAcceptDirectory = r10;
    }

    private static String getMimeSupertype(String r8) {
        return r8.split("/", 2)[0];
    }

    private String getMimeTypeFromExtension(String r8) {
        String r10 = this.mMimeTypeMap.getMimeTypeFromExtension(r8);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toLowerCase(Locale.US);
    }

    public boolean accept(Uri r8, String r10) {
        if (r8 == null) goto L9;
        String r11 = MimeTypeMap.getFileExtensionFromUrl(r8.toString()).toLowerCase(Locale.US);
        if (this.mExtensions.contains(r11) == false) goto L7;
        return true;
    L7:
        if (r10 != null) goto L9;
        r10 = getMimeTypeFromExtension(r11);
    L9:
        if (r10 != null) goto L11;
        return false;
    L11:
        if (this.mAcceptAllMimeTypes == false) goto L13;
    L16:
        return true;
    L13:
        if (this.mMimeTypes.contains(r10) == true) goto L16;
        if (this.mMimeSupertypes.contains(getMimeSupertype(r10)) == true) goto L16;
        return false;
    }

    @Override // java.io.FileFilter
    public boolean accept(File r8) {
        if (r8.isDirectory() == false) goto L7;
        return this.mAcceptDirectory;
    L7:
        return accept(Uri.fromFile(r8), null);
    }
}
