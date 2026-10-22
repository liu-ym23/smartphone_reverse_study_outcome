package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a0 implements Function2 {
    public final /* synthetic */ ChatShareBottomComponent a;
    public final /* synthetic */ SaveMessageShareInfo b;
    public final /* synthetic */ Context c;

    public /* synthetic */ a0(ChatShareBottomComponent r1, SaveMessageShareInfo r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r14, Object r15) {
        ChatShareBottomComponent r6 = this.a;
        SaveMessageShareInfo r3 = this.b;
        Context r4 = this.c;
        int r16 = ((Integer) r14).intValue();
        Bitmap r2 = (Bitmap) r15;
        int r17 = ChatShareBottomComponent.R;
        if (r16 != 0) goto L6;
        if (r2 == null) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), null, null, new ChatShareBottomComponent$shareSelectedMessagesAsLongImage$1$1(r6, r2, r3, r4, null), 3, null);
    L10:
        u7 r18 = r6.Z3();
        if (r18 == null) goto L14;
        r18.dismissLoading();
    L14:
        return Unit.INSTANCE;
    L6:
        t19.s.a.g(s1a.a.c(r6).getContext(), 2131900870, false);
        DialogFragment r19 = r6.p;
        if (r19 == null) goto L9;
        ChatShareBottomComponent.Y2(r19);
    L9:
        r6.e4().exitSelectMode();
        goto L10
    }
}
