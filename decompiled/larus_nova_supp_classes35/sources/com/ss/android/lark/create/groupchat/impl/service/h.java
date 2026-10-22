package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface h {
    void Da(Context r1, GroupCreateInfo r2, List<? extends SearchBaseInfo> r3, IGetDataCallback<Chat> r4, CreateGroupScene r5, IGetDataCallback<w5b.a> r6, Fragment r7, hab.b r8);
}
