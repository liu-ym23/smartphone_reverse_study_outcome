package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.IImageTemplateApplyCallback;
import com.bytedance.android.livesdk.chatroom.likeegg.LikeEggSyncDataModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VSInjectLiveEggService implements vr1.n, com.bytedance.android.scope.o {

    public static final class a implements IImageTemplateApplyCallback {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Function0 b;

        public final void onLoadFailed() {
            this.b.invoke();
        }

        public final void onLoadSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "path");
            this.a.invoke(r2);
        }

        public a(Function1 r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public VSInjectLiveEggService() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.n
    public final void preloadTemplateResource(String r2) {
        jc1.k.n(IHostBusiness.class).preloadTemplateResource(r2);
    }

    @Override // vr1.n
    public final void d(DataCenter r2, final Function1<? super LikeEggSyncDataModel, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "action");
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(r2);
        if (r4 == null) goto L6;
        r4.c(new VSInjectLiveEggService$getPublicScreenContext$1(r3));
        return;
    }

    @Override // vr1.n
    public final Map<String, String> a(com.bytedance.android.livesdk.chatroom.likeegg.a r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        Intrinsics.checkNotNullParameter(r7, "photoType");
        LinkedHashMap r0 = new LinkedHashMap();
        com.bytedance.android.livesdk.chatroom.likeegg.a.b r8 = r5.jumpDetail;
        if (r8 == null) goto L23;
        com.bytedance.android.live.base.model.data.n r9 = r8.templatePhotoJumpDetail;
        if (r9 == null) goto L23;
        List r10 = r9.a();
        if (r10 == null) goto L23;
        com.bytedance.android.live.base.model.data.n.a r11 = (com.bytedance.android.live.base.model.data.n.a) CollectionsKt.getOrNull(r10, r6);
        if (r11 == null) goto L23;
        String r1 = r11.templateTitle;
        String r2 = "";
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        r0.put("template_title", r1);
        r0.put("template_number", String.valueOf(r6 + 1));
        py.k r12 = r11.templatePhoto;
        if (r12 == null) goto L22;
        List r13 = r12.getUrls();
        if (r13 == null) goto L22;
        String r14 = (String) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L22;
        r2 = r14;
    L22:
        r0.put("template_url", r2);
        r0.put("photo_type", r7);
    L23:
        return r0;
    }

    @Override // vr1.n
    public final void getQrCodeInfo(int r2, String r3, final Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "action");
        jc1.k.n(ILiveShareService.class).getQrCodeInfo(5, r3, new AnonymousClass1(r4));
    }

    @Override // vr1.n
    public final void c(String r3, String r4, Map<String, String> r5, Function1<? super String, Unit> r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r3, "templateId");
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r6, "onSuccess");
        Intrinsics.checkNotNullParameter(r7, "onFail");
        jc1.k.n(IHostBusiness.class).applyImageTemplateToLocal(r3, r4, r5, new a(r6, r7));
    }
}
