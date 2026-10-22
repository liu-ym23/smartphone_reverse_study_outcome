package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.jsbauth.BridgeAuthType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements xwb.f<String, OfficeWebView> {
    public final /* synthetic */ MmEndWindowWebHelper a;

    @Override // xwb.f
    public final /* synthetic */ boolean shouldRunInUIThread() {
        return true;
    }

    @Override // xwb.f
    public final BridgeAuthType authType() {
        return BridgeAuthType.Public;
    }

    public n(MmEndWindowWebHelper r1) {
        this.a = r1;
    }

    @Override // xwb.f
    public final void a(Object r9, xwb.d r10, String r11, OfficeWebView r12) {
        String r13 = (String) r9;
        Intrinsics.checkNotNullParameter(r10, "callback");
        int r14 = bwb.b.a;
        MmUiLogScene r15 = MmUiLogScene.WEB;
        bwb.b.f(r15, "showImageViewer", "data=" + r13 + ", extraStr=" + r11, this.a.f());
        MmEndWindowWebHelper r16 = this.a;
        r16.getClass();
        boolean r17 = true;
        if (r13 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L62;
        bwb.b.d(r15, "showImageViewer", "data is empty", r16.f());
        return;
    L62:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L56
        JSONObject r19 = new JSONObject(r13);     // Catch: Throwable -> L56
        Context r20 = r16.d.getContext();     // Catch: Throwable -> L56
    L12:
        Integer r3 = null;
        if ((r20 instanceof FragmentActivity) == true) goto L14;
        if ((r20 instanceof ContextWrapper) == false) goto L18;
        r20 = ((ContextWrapper) r20).getBaseContext();     // Catch: Throwable -> L56
        goto L12
    L18:
        FragmentActivity r21 = null;
    L19:
        if (r21 != null) goto L21;
        int r22 = bwb.b.a;     // Catch: Throwable -> L56
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "activity is null", r16.f());     // Catch: Throwable -> L56
        return;
    L21:
        com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.d r4 = com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.d.a;     // Catch: Throwable -> L56
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g> r5 = r16.k(r19.optJSONArray("images"));     // Catch: Throwable -> L56
        r4.getClass();     // Catch: Throwable -> L56
        List r6 = com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.d.a(r21, r5);     // Catch: Throwable -> L56
        ArrayList r7 = (ArrayList) r6;     // Catch: Throwable -> L56
        if (r7.isEmpty() == false) goto L24;
        int r23 = bwb.b.a;     // Catch: Throwable -> L56
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "images is empty", r16.f());     // Catch: Throwable -> L56
        return;
    L24:
        int r110 = r19.optInt("currentIndex", r19.optInt("currentlndex", 0));     // Catch: Throwable -> L56
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L56
        int r24 = 0;
    L26:
        if (r8.hasNext() == false) goto L34;
        if (((Number) ((Pair) r8.next()).getFirst()).intValue() != r110) goto L30;
        boolean r25 = true;
    L31:
        if (r25 == true) goto L35;
        r24 = r24 + 1;     // Catch: Throwable -> L56
    L35:
        Integer r26 = Integer.valueOf(r24);     // Catch: Throwable -> L56
        if (r26.intValue() >= 0) goto L39;
        r17 = false;
    L39:
        if (r17 == false) goto L41;
        r3 = r26;
    L41:
        if (r3 == null) goto L43;
        int r111 = r3.intValue();     // Catch: Throwable -> L56
    L44:
        String r112 = OfficeSDKManager.getCurrentUid();     // Catch: Throwable -> L56
        if (r112 != null) goto L47;
        r112 = "";
    L47:
        com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b r113 = (com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b) OfficeSDKManager.getHostUserService(r112, com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b.class);     // Catch: Throwable -> L56
        if (r113 != null) goto L50;
        int r27 = bwb.b.a;     // Catch: Throwable -> L56
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "gallery preview dependency is null", r16.f());     // Catch: Throwable -> L56
        return;
    L50:
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));     // Catch: Throwable -> L56
        Iterator r28 = ((ArrayList) r6).iterator();     // Catch: Throwable -> L56
    L52:
        if (r28.hasNext() == false) goto L54;
        r1.add((com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.d) ((Pair) r28.next()).getSecond());     // Catch: Throwable -> L56
        goto L52
    L54:
        r113.R1(new com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.e(r1, r111), r21);     // Catch: Throwable -> L56
        int r29 = bwb.b.a;     // Catch: Throwable -> L56
        bwb.b.f(MmUiLogScene.WEB, "showImageViewer", "open gallery preview, index=" + r111 + ", size=" + r7.size(), r16.f());     // Catch: Throwable -> L56
        Object r30 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L58:
        Throwable r31 = Result.exceptionOrNull-impl(r30);
        if (r31 == null) goto L72;
        int r114 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "error=" + r31.getMessage(), r16.f());
        return;
    L72:
        return;
    L43:
        r111 = RangesKt.coerceIn(r110, 0, CollectionsKt.getLastIndex(r6));     // Catch: Throwable -> L56
        goto L44
    L30:
        r25 = false;
        goto L31
    L34:
        r24 = -1;
        goto L35
    L14:
        r21 = (FragmentActivity) r20;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L5:
        if (StringsKt.isBlank(r13) == true) goto L8;
        r2 = false;
        goto L9
    }
}
