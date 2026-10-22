package com.ss.android.lark.integrator.im.impl;

import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.preview.service.UrlSignPreviewsPush;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.core.keyboard.KeyboardBaseModuleDependencyImpl;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements com.ss.android.lark.biz.im.api.e {
    public static final c a = null;
    public static final CoroutineScope b = null;

    public c() {
    }

    static {
        a = new c();
        b = CoroutineScopeKt.MainScope();
    }

    public final void c(d7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((UrlSignPreviewsPush) UrlSignPreviewsPush.d.getValue()).a(r2);
    }

    public final void d(d7b.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        UrlSignPreviewsPush r0 = (UrlSignPreviewsPush) UrlSignPreviewsPush.d.getValue();
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r3, "listener");     // Catch: Throwable -> L12
        r0.a.remove(r3);     // Catch: Throwable -> L12
        if (r0.a.isEmpty() == false) goto L10;
        RucketJob r4 = r0.c;     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        r4.cancel();     // Catch: Throwable -> L12
    L9:
        r0.c = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void O(List r8, AssociatedPreviewService.requestUrlPreview.1.1.2 r9) {
        Intrinsics.checkNotNullParameter(r8, "hangPoints");
        Intrinsics.checkNotNullParameter(r9, "callback");
        w4b.f r0 = (w4b.f) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(w4b.f.class);
        BuildersKt.launch$default(b, null, null, new ChatPreviewApiImpl$getPreviewByHangPoints$1(r0, r8, r9, null), 3, null);
    }

    public final Map<String, RecogniseSpansResult> a(List<UrlPreViewEntries> r3, String r4, String r5, Long r6) {
        Intrinsics.checkNotNullParameter(r3, "data");
        String r1 = new String(w28.a.a(x28.a.a(r4)));
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r5);
        UserStatusParseUrlPreViewUtils.b r0 = new UserStatusParseUrlPreViewUtils.b(r4, r5, r1, r6);
        ArrayList r7 = new ArrayList();
        r7.add(r0);
        int r8 = UserStatusParseUrlPreViewUtils.a;
        return UserStatusParseUrlPreViewUtils.c(r3, r7, ChatHitPointExtraParams.UrlAnalysisScene.PROFILE_SIGN, ChatHitPointExtraParams.DataSource.FROM_SDK_PUSH);
    }

    public final void b(String r9, long r10, long r12, KeyboardBaseModuleDependencyImpl.getTempPreview.1 r14) {
        Intrinsics.checkNotNullParameter(r9, "url");
        Intrinsics.checkNotNullParameter(r14, "callback");
        ((w4b.f) ((DwarfSPIEntryPoint) EntryPoints.get(LarkContext.getApplication(), DwarfSPIEntryPoint.class)).dwarfSPI().get(w4b.f.class)).d(r9, r10, r12, r14);
    }
}
