package com.larus.slides.impl;

import android.content.Context;
import android.os.Bundle;
import com.larus.home.impl.sdk.SdkSlidesServiceImpl;
import com.larus.office.base.preview.IOfficePreviewOpener;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/slides/impl/SlidesOpenerImpl;", "Lcom/larus/office/base/preview/IOfficePreviewOpener;", "<init>", "()V", "supportedPreviewTypes", "", "", "open", "", "request", "Lcom/larus/office/base/preview/OfficePreviewOpenRequest;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesOpenerImpl implements IOfficePreviewOpener {

    public static final class a {
    }

    static {
    }

    public SlidesOpenerImpl() {
    }

    public final Set<Integer> b() {
        return SetsKt.setOf(30);
    }

    public final boolean a(com.larus.office.base.preview.b r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("open: token=");
        int r2 = com.larus.office.base.utils.f.a;
        r1.append(com.larus.office.base.utils.f.b(r10.c));
        r1.append(", enterMethod=");
        r1.append(r10.d);
        r1.append(", page=");
        r1.append(r10.e);
        r1.append(", restDocsSize=");
        r1.append(r10.f.size());
        r0.i("SlidesOpenerImpl", r1.toString());
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L5;
        r3.E0();
        SdkSlidesServiceImpl r4 = SdkSlidesServiceImpl.a;
    L7:
        if (r4 != null) goto L10;
        r0.w("SlidesOpenerImpl", "open: slidesService is null");
        return false;
    L10:
        Context r5 = r10.getContext();
        Pair[] r6 = new Pair[11];
        r6[0] = TuplesKt.to("slides_token", r10.c);
        r6[1] = TuplesKt.to("resource_version", 0);
        r6[2] = TuplesKt.to("resource_id", r10.c);
        r6[3] = TuplesKt.to("resource_type", 9);
        String r7 = r10.g;
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r6[4] = TuplesKt.to("message_id", r7);
        String r8 = r10.d;
        if (r8 != null) goto L16;
        r8 = "url_jump";
    L16:
        r6[5] = TuplesKt.to("key_doc_enter_from", r8);
        r6[6] = TuplesKt.to("click_timestamp", Long.valueOf(System.currentTimeMillis()));
        r6[7] = TuplesKt.to("key_doc_list_to_apply_permission", r10.f);
        r6[8] = TuplesKt.to("key_apply_permission_message_id", r10.g);
        r6[9] = TuplesKt.to("key_apply_permission_conversation_id", r10.h);
        r6[10] = TuplesKt.to("key_source_url_for_params", r10.i);
        Bundle r9 = com.larus.utils.f.c(r6);
        r9.putAll(r10.j);
        Unit r11 = Unit.INSTANCE;
        String r12 = r10.e;
        if (r12 != null) goto L19;
        r12 = "chat";
    L19:
        r4.l(r5, r9, r12);
        r0.i("SlidesOpenerImpl", "openSlides invoked: token=" + com.larus.office.base.utils.f.b(r10.c));
        return true;
    L5:
        r4 = null;
        goto L7
    }
}
