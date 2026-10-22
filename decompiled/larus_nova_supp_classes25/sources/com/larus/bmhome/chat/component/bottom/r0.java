package com.larus.bmhome.chat.component.bottom;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class r0 implements Function2 {
    public final /* synthetic */ ChatBottomComponent a;
    public final /* synthetic */ ChatBottomComponent$b b;

    public /* synthetic */ r0(ChatBottomComponent r1, ChatBottomComponent$b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r6, Object r7) {
        ChatBottomComponent r0 = this.a;
        ChatBottomComponent$b r1 = this.b;
        ResourceBarConfig r8 = (ResourceBarConfig) r6;
        ViewGroup r9 = (ViewGroup) r7;
        int r2 = ChatBottomComponent.L0;
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "parent");
        FrameLayout r3 = new FrameLayout(r9.getContext());
        r3.setLayoutParams(new RecyclerView.LayoutParams(i5.y(), i5.f()));
        return new ChatBottomComponent$buildHumanMergeForwardResourceRender$1$1(r8, r0, r1, r3);
    }
}
