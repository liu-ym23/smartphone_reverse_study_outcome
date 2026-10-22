package com.larus.bmhome.chat.component.showcase;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements View.OnClickListener {
    public final /* synthetic */ ChatCaseMessageComponent a;

    public /* synthetic */ b(ChatCaseMessageComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        ChatCaseMessageComponent r11 = this.a;
        int r0 = ChatCaseMessageComponent.z;
        r11.getClass();
        e r1 = (e) AuthModelDelegate.b.y().getValue();
        if (r1 == null) goto L10;
        String r2 = r1.a;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Fragment r3 = com.larus.ui.arch.component.internal.attach.a.b(r11, r11);
        if (r3 == null) goto L11;
        LifecycleCoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(r3);
        if (r4 == null) goto L12;
        BuildersKt.launch$default(r4, null, null, new ChatCaseMessageComponent$startCreateConversation$1$1$1(r2, r11, r1, null), 3, null);
        return;
    L12:
        return;
    L11:
        return;
    }
}
