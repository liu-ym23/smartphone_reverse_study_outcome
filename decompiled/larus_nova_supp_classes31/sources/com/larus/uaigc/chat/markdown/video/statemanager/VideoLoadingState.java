package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoLoadingState implements ez9.c {
    public final CoroutineScope a;
    public final Lazy<i1<MessageLoadingUIState>> b;
    public final ISketchLoadingController c;
    public final int d;
    public Job e;
    public String f;

    public static final class a {
    }

    static {
    }

    @Override // ez9.c
    public final int getLevel() {
        return this.d;
    }

    @Override // ez9.c
    public final void g(ez9.c r8) {
        FLogger.a.d("VideoLoadingState", "onLeave, loadingId: " + this.f);
        this.f = null;
        if ((r8 instanceof i) == false) goto L5;
        BuildersKt.launch$default(this.a, null, null, new VideoLoadingState$onLeave$1(this, null), 3, null);
    L6:
        Job r9 = this.e;
        if (r9 == null) goto L9;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L9:
        this.e = null;
        return;
    L5:
        this.c.hide();
        goto L6
    }

    @Override // ez9.c
    public final void e(String r8, Message r9) {
        if (r8 != null) goto L6;
        if (r9 != null) goto L6;
        g(null);
    L6:
        if (r9 == null) goto L8;
        String r10 = r9.getLocalMessageId();
    L9:
        String r11 = DataConverterKt.a(r10, r8);
        if (o0.d(r8) == true) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(this.f, r11) == true) goto L19;
        this.f = r11;
        ISketchLoadingController.a.b(this.c, false, null, 2, 3);
        Job r12 = this.e;
        if (r12 == null) goto L16;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L16:
        this.e = BuildersKt.launch$default(this.a, null, null, new VideoLoadingState$observeProgress$1(this, null), 3, null);
        return;
    L19:
        return;
    L8:
        r10 = null;
        goto L9
    }

    public VideoLoadingState(CoroutineScope r2, Lazy<? extends i1<MessageLoadingUIState>> r3, ISketchLoadingController r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "loadingProgressState");
        Intrinsics.checkNotNullParameter(r4, "loadingController");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = 2;
    }
}
