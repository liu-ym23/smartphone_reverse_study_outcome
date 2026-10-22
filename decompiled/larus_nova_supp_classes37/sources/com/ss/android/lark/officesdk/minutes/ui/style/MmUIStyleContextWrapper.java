package com.ss.android.lark.officesdk.minutes.ui.style;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmUIStyleContextWrapper extends ContextWrapper {
    public final MmRecordingUILaunchMode a;
    public final Lazy b;

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String r2) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        if (Intrinsics.areEqual(r2, "layout_inflater") == false) goto L7;
        return (LayoutInflater) this.b.getValue();
    L7:
        return super.getSystemService(r2);
    }

    public MmUIStyleContextWrapper(Context r2, MmRecordingUILaunchMode r3) {
        Intrinsics.checkNotNullParameter(r2, "base");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchMode");
        super(r2);
        this.a = r3;
        this.b = LazyKt.lazy(new MmUIStyleContextWrapper$layoutInflater$2(this));
    }
}
