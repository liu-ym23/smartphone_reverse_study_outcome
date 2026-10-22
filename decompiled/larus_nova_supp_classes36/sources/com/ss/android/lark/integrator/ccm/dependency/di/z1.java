package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.ee.bear.more.itemv2.ShortcutItemV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.Shortcut;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z1 implements yj5.a {
    public z1() {
    }

    public final boolean i(String r3) {
        tt5.a.h("ShortcutAgentImpl", "isFeedCardShortcut()... feedId = " + r3);
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).isShortcut(r3);
    }

    public final void s(boolean r3, String r4, final ShortcutItemV2.a r5) {
        tt5.a.h("ShortcutAgentImpl", "markFeedCardShortcut()...isAdd = " + r3 + ",channelType = 0 , feedId = " + r4);
        final IGetDataCallback<Boolean> r0 = new ShortcutAgentImpl$1(this, r5);
        if (r3 == false) goto L5;
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).putShortcuts(new Shortcut(Channel.Type.DOC, r4), new ShortcutAgentImpl$2(this, r0), 1);
        return;
    L5:
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).deleteShortcuts(new Shortcut(Channel.Type.DOC, r4), new ShortcutAgentImpl$3(this, r0), 1);
    }
}
