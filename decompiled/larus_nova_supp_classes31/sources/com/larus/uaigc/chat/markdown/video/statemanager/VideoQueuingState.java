package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.creative.loading.CreationQueuingTaskUIState;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoQueuingState implements ez9.c {
    public final CoroutineScope a;
    public final ISketchLoadingController b;
    public final Lazy<i1<CreationQueuingTaskUIState>> c;
    public final Function0<q0.a> d;
    public final int e;
    public Job f;
    public String g;
    public String h;
    public Message i;

    public static final class a {
    }

    static {
    }

    @Override // ez9.c
    public final int getLevel() {
        return this.e;
    }

    @Override // ez9.c
    public final void g(ez9.c r9) {
        FLogger.a.i("VideoQueuingState", "onLeave, curTaskId: " + this.h);
        if ((r9 instanceof VideoLoadingState) == false) goto L5;
    L8:
        this.g = null;
        Job r10 = this.f;
        if (r10 == null) goto L11;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L11:
        this.f = null;
        q0.a r11 = (q0.a) this.d.invoke();
        if (r11 == null) goto L16;
        zd8.b r12 = r11.P9();
        if (r12 == null) goto L16;
        r12.B8(false, this.i, this.h);
    L16:
        this.i = null;
        this.h = null;
        return;
    L5:
        if ((r9 instanceof i) == false) goto L7;
        BuildersKt.launch$default(this.a, null, null, new VideoQueuingState$onLeave$1(this, null), 3, null);
        goto L8
    L7:
        this.b.hide();
        goto L8
    }

    @Override // ez9.c
    public final void e(String r10, Message r11) {
        if (r10 != null) goto L6;
        if (r11 != null) goto L6;
        g(null);
    L6:
        if (r11 == null) goto L8;
        String r1 = r11.getLocalMessageId();
    L9:
        String r2 = DataConverterKt.a(r1, r10);
        if (o0.d(r10) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.g, r2) == true) goto L23;
        this.h = r10;
        this.i = r11;
        this.g = r2;
        ISketchLoadingController.a.b(this.b, false, null, 2, 3);
        Job r3 = this.f;
        if (r3 == null) goto L16;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L16:
        this.f = BuildersKt.launch$default(this.a, null, null, new VideoQueuingState$observeQueuingUIStateChange$1(this, null), 3, null);
        q0.a r0 = (q0.a) this.d.invoke();
        if (r0 == null) goto L24;
        zd8.b r4 = r0.P9();
        if (r4 == null) goto L25;
        r4.B8(true, r11, r10);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public VideoQueuingState(CoroutineScope r2, ISketchLoadingController r3, Lazy r4, com.larus.uaigc.chat.markdown.video.h r5) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "loadingController");
        Intrinsics.checkNotNullParameter(r4, "queuingUIState");
        Intrinsics.checkNotNullParameter(r5, "modelProviderGetter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = 1;
    }
}
