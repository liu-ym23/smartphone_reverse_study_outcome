package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.room.api.IMatchShareService;
import com.bytedance.android.livesdk.vs.model.MatchShareParam;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements com.bytedance.android.scope.o, vr1.q {
    public t() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.q
    public final Boolean allowQuickRecordShare() {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.allowQuickRecordShare());
    }

    @Override // vr1.q
    public final Boolean allowQuickShotShare() {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r0.allowQuickShotShare());
    }

    @Override // vr1.q
    public final void logQuickRecordShareDialogClick() {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickRecordShareDialogClick();
        return;
    }

    @Override // vr1.q
    public final void logQuickShotShareDialogClick() {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickShotShareDialogClick();
        return;
    }

    @Override // vr1.q
    public final void logQuickRecordAudioOpen(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickRecordAudioOpen(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickRecordBtnClick(long r2) {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickRecordBtnClick(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickRecordBtnShow(DataCenter r2) {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickRecordBtnShow(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickRecordTaskFinish(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickRecordTaskFinish(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickShotBtnClick(long r2) {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickShotBtnClick(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickShotBtnShow(DataCenter r2) {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickShotBtnShow(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickShotFinish(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickShotFinish(r2);
        return;
    }

    @Override // vr1.q
    public final void logQuickShotShareDialogShow(long r2) {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickShotShareDialogShow(r2);
        return;
    }

    @Override // vr1.q
    public final HashMap<String, String> generateShareLogParams(DataCenter r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterFromMerge");
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.generateShareLogParams(r2, r3);
    }

    @Override // vr1.q
    public final void logQuickRecordShareDialogShow(long r2, long r4) {
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.logQuickRecordShareDialogShow(r2, r4);
        return;
    }

    @Override // vr1.q
    public final void launchMatchShare(Context r2, boolean r3, MatchShareParam r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "shareParam");
        IMatchShareService r5 = jc1.k.f(IMatchShareService.class);
        if (r5 == null) goto L6;
        r5.launchMatchShare(r2, true, r4);
        return;
    }

    @Override // vr1.q
    public final void showShareDialog(FragmentActivity r2, MatchShareParam r3, CollectionItem r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "shareParam");
        Intrinsics.checkNotNullParameter(r4, "collectionItem");
        IMatchShareService r0 = jc1.k.f(IMatchShareService.class);
        if (r0 == null) goto L6;
        r0.showShareDialog(r2, r3, r4);
        return;
    }
}
