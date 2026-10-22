package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements ForwardCreateGroupChatPlugin.a {
    public final /* synthetic */ ForwardNewFragment a;

    @Override // com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin.a
    public final void onBack() {
        tib.e r0 = this.a.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r0 = null;
    L5:
        r0.i(false);
    }

    public j(ForwardNewFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatPlugin.a
    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "chatId");
        ForwardNewFragment r0 = this.a;
        int r1 = ForwardNewFragment.t;
        r0.getClass();
        SearchChatInfo r5 = ForwardDataUtils.c(r4);
        if (r5 == null) goto L6;
        Log.i("NewForward", "show confirm forward dialog from: create group chat");
        r0.ca0(Collections.singletonList(r5), "from_create_group_chat");
    L6:
        tib.e r6 = this.a.e;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r6 = null;
    L9:
        r6.i(false);
    }
}
