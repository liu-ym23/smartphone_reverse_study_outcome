package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.im.base.browser.IImBrowserService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements BrowserDependency {
    public b() {
    }

    public final void openUrl(Context r4, String r5) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent(IImBrowserService.LINK_SCENE_MESSENGER, IImBrowserService.LINK_LOCATION_CHAT);
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).openUrl(r4, r5);
    }

    public final void a(Context r2, String r3, int r4) {
        b(r2, r3, r4, null);
    }

    public final void c(Context r8, String r9, int r10) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent(IImBrowserService.LINK_SCENE_MESSENGER, IImBrowserService.LINK_LOCATION_CHAT);
        IImBrowserService r1 = (IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class);
        if (r10 != 1) goto L5;
        int r4 = 6;
    L9:
        r1.openUrl(r8, r9, r4, null, nmb.a.a().getCCMDependency().getDocArgsMessage());
        return;
    L5:
        if (r10 == 2) goto L7;
        r4 = 5;
        goto L9
    L7:
        r4 = 7;
        goto L9
    }

    public final void b(Context r9, String r10, int r11, Bundle r12) {
        d(r9, r10, r11, "inline", r12, null, null);
    }

    public final void d(Context r10, String r11, int r12, String r13, Bundle r14, Fragment r15, String r16) {
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).sendLinkClickEvent(IImBrowserService.LINK_SCENE_MESSENGER, IImBrowserService.LINK_LOCATION_CHAT);
        Map<String, String> r5 = nmb.a.a().getCCMDependency().getDocArgsMessage();
        HashMap r6 = new HashMap();
        r6.putAll(r5);
        r6.put("url_click_type", r13);
        Bundle r4 = new Bundle();
        r4.putString(IImBrowserService.KEY_FROM_SCENE, "chat");
        if (r12 != 0) goto L5;
        int r7 = IImBrowserService.SCENE_FROM_CHAT_SINGLE;
    L6:
        r4.putInt(IImBrowserService.KEY_WEB_SCENE, r7);
        if (r14 == null) goto L10;
        r4.putAll(r14);
    L10:
        if (TextUtils.isEmpty(r16) == true) goto L13;
        r6.put(IImBrowserService.KEY_DOC_TITLE, r16);
    L13:
        if (r14 != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == true) goto L20;
    L24:
        IImBrowserService r2 = (IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class);
        if (r12 != 1) goto L27;
        int r3 = 6;
    L31:
        r2.openUrl(r10, r11, r3, r4, r5, r6, r15);
        return;
    L27:
        if (r12 == 2) goto L29;
        r3 = 5;
        goto L31
    L29:
        r3 = 7;
        goto L31
    L20:
        if (TextUtils.isEmpty(r16) == true) goto L24;
        if (TextUtils.equals(r11, r16) == true) goto L24;
        ((IImBrowserService) LarkContext.spiByDwarf(IImBrowserService.class)).createSecLinkHelper(r11, r16);
        Log.i("BrowserDependencyImpl", "secLinkHelper empty");
        goto L24
    L15:
        if (r14.getBoolean("custom_url_sec_link_check") == false) goto L17;
        r1 = true;
        goto L18
    L5:
        r7 = IImBrowserService.SCENE_FROM_CHAT_GROUP;
        goto L6
    }
}
