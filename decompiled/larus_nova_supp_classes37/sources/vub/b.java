package vub;

import android.content.Context;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@OfficeSDKUserScope
public final class b implements com.ss.android.lark.officesdk.minutes.api.hardware.a {
    @Inject
    public b() {
    }

    public final void a(Context r2, MmRecordingUILaunchMode r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchMode");
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.hardware.a
    public final void Kc(Context r2, MmRecordingUILaunchMode r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uiLaunchMode");
        a(r2, r3);
    }
}
