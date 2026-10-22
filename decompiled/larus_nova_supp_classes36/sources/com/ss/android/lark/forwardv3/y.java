package com.ss.android.lark.forwardv3;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.forwardv3.configuration.listener.OnForwardContentListener;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements z {
    public final ForwardV3ViewModel a;
    public final a b;
    public final OnForwardContentListener c;
    public List<? extends SearchBaseInfo> d;

    public interface a {
        void a(ErrorResult r1);

        void b(rib.d r1, List<? extends SearchBaseInfo> r2);

        void onError(ErrorResult r1);
    }

    public static final OnForwardContentListener b(y r1) {
        if (d(r1.d) == false) goto L5;
        return null;
    L5:
        OnForwardContentListener r0 = r1.c;
        if (r0 != null) goto L9;
        return r1.a.getForwardContentListener();
    L9:
        return r0;
    }

    public static final oib.d c(y r1) {
        if (d(r1.d) == false) goto L6;
        return null;
    L6:
        return r1.a.getForwardNoteListener();
    }

    public static boolean d(List r4) {
        boolean r0 = com.ss.android.lark.forwardv3.utils.b.a("core.forward.to_knowledge_ai", false);
        Log.i("FGUtils", "FG key: core.forward.to_knowledge_ai: " + r0);
        if (r0 == true) goto L5;
        return false;
    L5:
        if (r4 == null) goto L23;
        List r5 = r4;
        if ((r5 instanceof Collection) == true) goto L9;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L20;
        if (((SearchBaseInfo) r6.next()).getType() != 26) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L13;
        boolean r7 = true;
    L21:
        if (r7 != true) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == false) goto L33;
        return true;
    L33:
        return false;
    L17:
        r2 = false;
    L20:
        r7 = false;
        goto L21
    L9:
        if (r5.isEmpty() == false) goto L11;
    L23:
        r8 = false;
        goto L24
    }

    public y(ForwardV3ViewModel r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
    }

    public y(ForwardV3ViewModel r2, b r3, ExternalForwardSendHelper$MixedSendAggregator$createForwardContentListener$1 r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this(r2, r3);
        this.c = r4;
    }

    @Override // com.ss.android.lark.forwardv3.z
    public final void a(LifecycleCoroutineScope r14, Context r15, List r16, String r17, RichText r18) {
        Intrinsics.checkNotNullParameter(r14, "scope");
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "items");
        Intrinsics.checkNotNullParameter(r17, "note");
        Intrinsics.checkNotNullParameter(r18, "richText");
        a r1 = this.b;
        this.d = r16;
        BuildersKt.launch$default(r14, null, null, new ForwardSendHelper$launchInternalForwardTask$1(r1, this, r16, r15, r18, r17, null), 3, null);
    }
}
