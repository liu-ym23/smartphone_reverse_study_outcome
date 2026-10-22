package com.ss.android.lark.forwardv3;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.bundle.ChatForsetiBundle;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements Runnable {
    public final /* synthetic */ ForwardNewFragment a;
    public final /* synthetic */ rib.d b;
    public final /* synthetic */ List<SearchBaseInfo> c;

    public i(ForwardNewFragment r1, rib.d r2, List<? extends SearchBaseInfo> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        KeyboardUtils.hideKeyboard(this.a.requireContext());
        rib.d r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L26;
        ForwardV3ViewModel r3 = null;
        if (this.a.j == true) goto L12;
    L16:
        ForwardNewFragment r2 = this.a;
        ForwardV3ViewModel r4 = r2.f;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L20:
        Integer r5 = r3.getResultCode();
        if (r5 == null) goto L23;
        int r6 = r5.intValue();
    L24:
        r2.X90(Integer.valueOf(r6), new Bundle());
        return;
    L23:
        r6 = -1;
        goto L24
    L19:
        r3 = r4;
        goto L20
    L12:
        if (CollectionUtils.isEmpty(this.c) == true) goto L16;
        if ((ListProtector.get(this.c, 0) instanceof SearchChatInfo) == false) goto L16;
        Bundle r7 = new Bundle();
        r7.putSerializable("key_forseti_bundle", new ChatForsetiBundle(true, false, 2, null));
        ForwardModuleV3.a().go2Chat(this.a.requireContext(), ((SearchBaseInfo) ListProtector.get(this.c, 0)).getId(), r7);
        goto L16
    L26:
        return;
    L5:
        if (r0.a != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
