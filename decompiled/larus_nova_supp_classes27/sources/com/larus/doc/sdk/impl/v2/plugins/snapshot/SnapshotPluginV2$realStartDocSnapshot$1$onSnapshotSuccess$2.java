package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n39.h;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/larus/doc/sdk/impl/v2/plugins/snapshot/SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2", "Lcom/ss/android/lark/watermark/core/IGetWaterMarkResourceCallback;", "onGetSuccess", "", "waterMarkImgPath", "", "bytes", "Lokio/ByteString;", "onGetFailed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2 implements IGetWaterMarkResourceCallback {
    final /* synthetic */ h $listener;
    final /* synthetic */ SnapshotPluginV2 this$0;

    public static /* synthetic */ void a(SnapshotPluginV2 r0, h r1) {
        onGetFailed$lambda$1(r0, r1);
    }

    public static /* synthetic */ void b(SnapshotPluginV2 r0, String r1, h r2) {
        onGetSuccess$lambda$0(r0, r1, r2);
    }

    public void onGetFailed() {
        SoftReference r0 = y.a;
        final SnapshotPluginV2 r1 = this.this$0;
        final h r2 = this.$listener;
        y.c(new e(r1, r2));
    }

    public static void INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(DocShotFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2(SnapshotPluginV2 r1, h r2) {
        this.this$0 = r1;
        this.$listener = r2;
    }

    private static final void onGetFailed$lambda$1(SnapshotPluginV2 r0, h r1) {
        DocShotFragment r2 = SnapshotPluginV2.access$getMFragment$p(r0);
        if (r2 == null) goto L5;
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r2);
    L5:
        if (r1 == null) goto L8;
        r1.onSnapshotFail("save doc bitmap failed");
        return;
    }

    public void onGetSuccess(final String r3, ByteString r4) {
        Intrinsics.checkNotNullParameter(r4, "bytes");
        SoftReference r5 = y.a;
        final SnapshotPluginV2 r6 = this.this$0;
        final h r0 = this.$listener;
        y.c(new f(r6, r3, r0));
    }

    private static final void onGetSuccess$lambda$0(SnapshotPluginV2 r0, String r1, h r2) {
        DocShotFragment r3 = SnapshotPluginV2.access$getMFragment$p(r0);
        if (r3 == null) goto L5;
        INVOKEVIRTUAL_com_larus_doc_sdk_impl_v2_plugins_snapshot_SnapshotPluginV2$realStartDocSnapshot$1$onSnapshotSuccess$2_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r3);
    L5:
        if (r1 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        if (r2 == null) goto L17;
        r2.onSnapshotFail("save doc bitmap failed. watermark path is empty");
        return;
    L17:
        return;
    L14:
        if (r2 == null) goto L19;
        r2.onSnapshotSuccess(r1);
        return;
    L19:
        return;
    L7:
        if (r1.length() == 0) goto L10;
        r4 = false;
        goto L11
    }
}
