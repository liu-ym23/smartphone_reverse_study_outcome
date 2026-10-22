package com.ss.android.lark.officesdk.minutes.ui.service;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingUiProviders {
    public static final MmRecordingUiProviders h = null;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final MmRecordingUILaunchMode b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
        h = new MmRecordingUiProviders(null, MmRecordingUILaunchMode.UNKNOWN);
    }

    public final qub.e b() {
        return (qub.e) this.f.getValue();
    }

    public MmRecordingUiProviders(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2, MmRecordingUILaunchMode r3) {
        Intrinsics.checkNotNullParameter(r3, "uiLaunchMode");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new MmRecordingUiProviders$toast$2(this));
        this.d = LazyKt.lazy(new MmRecordingUiProviders$dialog$2(this));
        this.e = LazyKt.lazy(new MmRecordingUiProviders$loading$2(this));
        this.f = LazyKt.lazy(new MmRecordingUiProviders$panel$2(this));
        this.g = LazyKt.lazy(new MmRecordingUiProviders$bubble$2(this));
    }

    public final void a(Context r2, FragmentManager r3) {
        if (r2 == null) goto L4;
        ((qub.d) this.e.getValue()).t0(r2);
        ((qub.c) this.d.getValue()).B(r2);
    L4:
        if (r3 == null) goto L7;
        b().m0(r3);
        return;
    }
}
