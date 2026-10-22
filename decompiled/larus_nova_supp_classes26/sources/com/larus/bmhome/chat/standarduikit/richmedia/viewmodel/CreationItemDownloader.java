package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.view.View;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CreationItemDownloader implements z {
    public final Message a;
    public final String b;
    public final f0 c;
    public final Function1<fn8.c, Integer> d;
    public final Function1<fn8.c, Integer> e;

    @Override // com.larus.bmhome.chat.standarduikit.richmedia.viewmodel.z
    public final void a(fn8.c r17, View r18, Function0<Unit> r19) {
        Intrinsics.checkNotNullParameter(r17, "item");
        Intrinsics.checkNotNullParameter(r18, "anchor");
        Intrinsics.checkNotNullParameter(r19, "onCompleted");
        fn8.b r0 = r17.h;
        if ((r0 instanceof fn8.b.a) == false) goto L5;
        fn8.b.a r1 = (fn8.b.a) r0;
    L6:
        if (r1 == null) goto L20;
        CreationItem r4 = r1.a;
        if (r4 == null) goto L20;
        f0 r5 = this.c;
        if (r5 != null) goto L14;
        r19.invoke();
        return;
    L14:
        CoroutineScope r10 = r5.c();
        if (r10 != null) goto L18;
        r19.invoke();
        return;
    L18:
        BuildersKt.launch$default(r10, null, null, new CreationItemDownloader$download$1(r17, r18, this, r4, r5, r10, r19, null), 3, null);
        return;
    L20:
        r19.invoke();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public CreationItemDownloader(Message r2, String r3, f0 r4, e r5, l r6) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "findCardSubPosition");
        Intrinsics.checkNotNullParameter(r6, "findCreationPosition");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
