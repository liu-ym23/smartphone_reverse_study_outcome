package com.larus.bmhome.chat.component.ext;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.h1;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final void a(ChatFragment r13, String r14, String r15, h1 r16, boolean r17) {
        Intrinsics.checkNotNullParameter(r13, "chatFragment");
        Intrinsics.checkNotNullParameter("ChatFragment", "tag");
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        WeakReference r3 = new WeakReference(r13);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r13.getViewLifecycleOwner()), null, null, new ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1(r15, "ChatFragment", r3, r4, r17, r16, r14, null), 3, null);
    }
}
