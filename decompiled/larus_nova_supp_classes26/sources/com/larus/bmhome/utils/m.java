package com.larus.bmhome.utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.databinding.LarusPageChatBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public static final LarusPageChatBinding a(LayoutInflater r1, ViewGroup r2, FragmentActivity r3, boolean r4, boolean r5, boolean r6) {
        LarusPageChatBinding r7 = LarusPageChatBinding.b(r1, r2);
        InputViewCreatorDelegate.b.b(r7.i);
        if (r3 == null) goto L6;
        if (r4 == true) goto L6;
        r7.g.setDisableTopPadding(r5);
        r7.g.setDisableBottomPadding(r6);
        r7.g.k6(r3);
    L6:
        return r7;
    }
}
