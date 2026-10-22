package com.larus.doc.impl.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.larus.common.apphost.AppHost;
import com.larus.doc.impl.DocActivity;
import com.larus.doc.impl.DocFragment;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Fragment a() {
        AppCompatActivity r1 = AppHost.a.a().getCurrentActivity();     // Catch: Exception -> L26
        if ((r1 instanceof AppCompatActivity) == false) goto L6;
        AppCompatActivity r2 = r1;     // Catch: Exception -> L26
    L8:
        if ((r2 instanceof DocActivity) == false) goto L31;
        DocFragment r3 = ((DocActivity) r2).getSupportFragmentManager().findFragmentByTag("tag_doc_fragment");     // Catch: Exception -> L26
        if ((r3 instanceof DocFragment) == false) goto L32;
        Fragment r4 = r3.h;     // Catch: Exception -> L26
        boolean r5 = true;
        if (r4 != null) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L33;
        if (r4 == null) goto L22;
        if (r4.isDetached() == true) goto L22;
    L23:
        if (r5 == true) goto L25;
        return null;
    L25:
        return r4;
    L22:
        r5 = false;
        goto L23
    L33:
        return null;
    L14:
        if (r4.isAdded() != true) goto L16;
        r6 = true;
        goto L17
    L32:
        return null;
    L31:
        return null;
    L6:
        r2 = null;
    L26:
        e = move-exception;
        FLogger.a.e("getDocChatFragment", "getDocChatFragment error: " + e.getMessage());
        return null;
    }

    public static final Fragment b() {
        AppCompatActivity r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r1 = r0;
    L7:
        if ((r1 instanceof DocActivity) == true) goto L9;
        return null;
    L9:
        return ((DocActivity) r1).getSupportFragmentManager().findFragmentByTag("tag_doc_fragment");
    L5:
        r1 = null;
        goto L7
    }
}
