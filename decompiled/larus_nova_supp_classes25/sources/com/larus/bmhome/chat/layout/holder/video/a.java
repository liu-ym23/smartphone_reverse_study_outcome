package com.larus.bmhome.chat.layout.holder.video;

import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ GenerateVideoBox a;
    public final /* synthetic */ CreationTask b;
    public final /* synthetic */ AiGenVideoContentData c;

    public /* synthetic */ a(GenerateVideoBox r1, CreationTask r2, AiGenVideoContentData r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r10) {
        GenerateVideoBox r0 = this.a;
        CreationTask r1 = this.b;
        AiGenVideoContentData r2 = this.c;
        Intrinsics.checkNotNullParameter((TextView) r10, "it");
        LifecycleOwner r11 = ViewTreeLifecycleOwner.get(r0);
        if (r11 == null) goto L8;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r11);
        if (r3 == null) goto L8;
        BuildersKt.launch$default(r3, Dispatchers.getIO(), null, new GenerateVideoBox$initClickListener$1$1(r0, r1, r2, null), 2, null);
    L8:
        return Unit.INSTANCE;
    }
}
