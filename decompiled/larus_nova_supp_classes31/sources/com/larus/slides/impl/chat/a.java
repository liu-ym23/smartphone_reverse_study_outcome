package com.larus.slides.impl.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.slides.impl.SlidesActivity;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final Fragment a() {
        AppCompatActivity r1 = AppHost.a.a().getCurrentActivity();     // Catch: Exception -> L30
        if ((r1 instanceof AppCompatActivity) == false) goto L6;
        AppCompatActivity r2 = r1;     // Catch: Exception -> L30
    L8:
        if ((r2 instanceof SlidesActivity) == false) goto L35;
        Fragment r3 = ((SlidesActivity) r2).getSupportFragmentManager().findFragmentByTag("aippt_new_detail");     // Catch: Exception -> L30
        if (r3 == null) goto L14;
        FragmentManager r4 = r3.getChildFragmentManager();     // Catch: Exception -> L30
        if (r4 == null) goto L14;
        Fragment r5 = r4.findFragmentByTag("tag_office_detail_chat_fragment");     // Catch: Exception -> L30
    L15:
        boolean r6 = true;
        if (r5 != null) goto L18;
    L20:
        boolean r7 = false;
    L21:
        if (r7 == false) goto L36;
        if (r5 == null) goto L26;
        if (r5.isDetached() == true) goto L26;
    L27:
        if (r6 == true) goto L29;
        return null;
    L29:
        return r5;
    L26:
        r6 = false;
        goto L27
    L36:
        return null;
    L18:
        if (r5.isAdded() != true) goto L20;
        r7 = true;
    L14:
        r5 = null;
        goto L15
    L35:
        return null;
    L6:
        r2 = null;
    L30:
        e = move-exception;
        FLogger.a.e("getDocChatFragment", "getDocChatFragment error: " + e.getMessage());
        return null;
    }
}
