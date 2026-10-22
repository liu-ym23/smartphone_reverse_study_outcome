package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.d2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 extends d2 {
    public final /* synthetic */ TalkRoomSearchFragment a;

    public m0(TalkRoomSearchFragment r1) {
        this.a = r1;
    }

    public final void afterTextChanged(Editable r2) {
        EditText r3 = this.a.k;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("searchEt");
    L6:
        if (TextUtils.isEmpty(r3.getText()) == false) goto L11;
        View r4 = this.a.l;
        if (r4 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("clearBtn");
    L10:
        UtilityKotlinExtentionsKt.t(r4);
        return;
    L11:
        View r5 = this.a.l;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("clearBtn");
    L14:
        UtilityKotlinExtentionsKt.w(r5);
    }
}
