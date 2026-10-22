package com.facebook.common.util;

import ai.j0;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UriUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f7699a = null;

    static {
        f7699a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
    }

    public static boolean a(Uri r5) {
        if (r5 != null) goto L4;
        String r10 = null;
    L6:
        return "content".equals(r10);
    L4:
        r10 = r5.getScheme();
        goto L6
    }

    public static boolean b(Uri r5) {
        if (r5 != null) goto L4;
        String r10 = null;
    L6:
        if (IIvyAIPackageResourceService.SCHEMA.equals(r10) == false) goto L8;
        return true;
    L8:
        if ("http".equals(r10) == true) goto L14;
        return false;
    L14:
        return true;
    L4:
        r10 = r5.getScheme();
        goto L6
    }

    public static int a(Context r5, Uri r10) {
        List<String> r11 = r10.getPathSegments();
        if (r11.size() != 2) goto L9;
        String r12 = r10.getAuthority();
        if (TextUtils.isEmpty(r12) == false) goto L7;
        r12 = r5.getPackageName();
    L7:
        String r13 = r11.get(0);
        String r14 = r11.get(1);
        Integer r15 = Integer.valueOf(r5.getResources().getIdentifier(r14, r13, r12));
    L13:
        if (r15 == null) goto L21;
        if (r15.intValue() <= 0) goto L19;
        return r15.intValue();
    L19:
        throw new IllegalArgumentException(j0.i(r10, "Failed to obtain resource id for: "));
    L21:
        throw new IllegalArgumentException(j0.i(r10, "Unrecognized Uri format: "));
    L9:
        if (r11.size() == 1) goto L23;
    L12:
        r15 = null;
        goto L13
    L23:
        r15 = Integer.valueOf(r11.get(0));     // Catch: NumberFormatException -> L22
        goto L13
    }
}
