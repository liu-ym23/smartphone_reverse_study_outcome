package com.larus.uaigc.chat.block.widget.video;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.b0;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.VideoData;
import com.larus.uaigc.impl.databinding.LarusLayoutVideoGenerateFailedBinding;
import com.larus.utils.w0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class VideoFailedViewBinder implements cz9.g {
    public final ViewStub a;
    public final Lazy b;

    @Override // cz9.g
    public final void f() {
    }

    @Override // cz9.g
    public final void updateSize(int r1, int r2) {
    }

    @Override // cz9.g
    public final View N0() {
        LarusLayoutVideoGenerateFailedBinding r0 = (LarusLayoutVideoGenerateFailedBinding) ((b0) this.b.getValue()).c;
        if (r0 == null) goto L8;
        FrameLayout r1 = r0.a;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return new View(AppHost.a.getApplication());
    }

    public VideoFailedViewBinder(ViewStub r2) {
        this.a = r2;
        this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new k(this));
    }

    @Override // cz9.g
    public final void p2(cz9.b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        CreationItem r3 = r2.a();
        if (r3 == null) goto L12;
        VideoData r4 = r3.video;
        if (r4 == null) goto L12;
        Integer r5 = r4.status;
        if (r5 == null) goto L12;
        if (r5.intValue() != 4) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L19;
        ((b0) this.b.getValue()).b();
        LarusLayoutVideoGenerateFailedBinding r7 = (LarusLayoutVideoGenerateFailedBinding) ((b0) this.b.getValue()).c;
        if (r7 == null) goto L21;
        FrameLayout r8 = r7.a;
        if (r8 == null) goto L22;
        w0.e(r8, i5.r0());
        return;
    L22:
        return;
    L21:
        return;
    L19:
        ((b0) this.b.getValue()).a();
        return;
    L12:
        r6 = false;
        goto L13
    }
}
