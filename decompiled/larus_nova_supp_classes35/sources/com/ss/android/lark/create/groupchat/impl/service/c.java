package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface c {
    boolean a(Context r1, CreateGroupScene r2, ErrorResult r3, Function1<? super Boolean, Unit> r4, Fragment r5, CreateGroupService.c r6);
}
