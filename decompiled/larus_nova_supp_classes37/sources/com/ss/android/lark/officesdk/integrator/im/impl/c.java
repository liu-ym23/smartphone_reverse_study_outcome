package com.ss.android.lark.officesdk.integrator.im.impl;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class c implements pmb.c {
    @Inject
    public c() {
    }

    public final void pickGroupMember(Activity r9, String r10, List<String> r11, boolean r12, String r13, IGetDataCallback<List<ChatChatter>> r14) {
        IIMApi r1 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r1 == null) goto L6;
        r1.pickGroupMember(r9, r10, r11, r12, r13, r14);
        return;
    }

    public final void pickTargetMember(Activity r9, List<String> r10, List<String> r11, boolean r12, String r13, IGetDataCallback<List<ChatChatter>> r14) {
        IIMApi r1 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r1 == null) goto L6;
        r1.pickTargetMember(r9, r10, r11, r12, r13, r14);
        return;
    }
}
