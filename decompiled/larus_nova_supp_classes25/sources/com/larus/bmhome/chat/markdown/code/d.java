package com.larus.bmhome.chat.markdown.code;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.keva.Keva;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import hq9.e3;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ ClickableMarkdownCodeView a;

    public /* synthetic */ d(ClickableMarkdownCodeView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClickableMarkdownCodeView r0 = this.a;
        List<String> r1 = ClickableMarkdownCodeView.H0;
        LifecycleOwner r2 = ViewTreeLifecycleOwner.get(r0);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0.a.b.hasObservers() == true) goto L7;
        r0.a.b.observe(r2, r0.W);
    L7:
        boolean r3 = v19.h.a;
        if (v19.h.b(r0.getContext()) == false) goto L10;
        String r4 = "dark";
    L11:
        String r8 = r4;
        e3 r5 = z2.a.getMarkdownCodeRenderConfig();
        if (e2.a.isPad() == false) goto L14;
        int r6 = r5.f;
        int r7 = r5.g;
    L15:
        boolean r9 = true;
        if (r0.o() == true) goto L18;
    L20:
        boolean r10 = false;
    L21:
        if (r10 == false) goto L23;
        r7 = (int) (r6 * 1.3333334f);
    L23:
        t0 r11 = r0.a;
        LifecycleCoroutineScope r12 = LifecycleOwnerKt.getLifecycleScope(r2);
        String r13 = r0.i;
        String r14 = r0.j;
        String r15 = r0.s;
        Integer r16 = Integer.valueOf(r6);
        Integer r17 = Integer.valueOf(r7);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "lifeCycleScope");
        Intrinsics.checkNotNullParameter(r8, "theme");
        Intrinsics.checkNotNullParameter(r13, "code");
        Intrinsics.checkNotNullParameter(r14, "language");
        if (r11.c == true) goto L40;
        r11.c = true;
        Lazy<Keva> r18 = t0.d;
        ih8.b r19 = t0.a.b(r15, r8);
        if (r19 == null) goto L36;
        String r110 = r19.b();
        if (r110 != null) goto L31;
    L34:
        if (r9 == true) goto L36;
        FLogger.a.d("MarkdownCodePreviewer", "Found cached image URL for cardId: " + r15 + ", theme: " + r8);
        r11.a.postValue(r19);
        r11.c = false;
        return;
    L31:
        if (r110.length() == 0) goto L34;
        r9 = false;
    L36:
        BuildersKt.launch$default(r12, Dispatchers.getIO(), null, new MarkdownCodePreviewer$requestCodeRenderImage$1(r16, r17, r11, r15, r8, r13, r14, null), 2, null);
        return;
    L40:
        return;
    L18:
        if (StringsKt.equals(r0.j, "html", true) == false) goto L20;
        r10 = true;
        goto L21
    L14:
        r6 = r5.d;
        r7 = r5.e;
        goto L15
    L10:
        r4 = "light";
        goto L11
    }
}
