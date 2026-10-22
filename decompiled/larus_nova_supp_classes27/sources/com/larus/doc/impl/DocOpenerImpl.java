package com.larus.doc.impl;

import android.content.Context;
import android.os.Bundle;
import com.larus.office.base.preview.IOfficePreviewOpener;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/doc/impl/DocOpenerImpl;", "Lcom/larus/office/base/preview/IOfficePreviewOpener;", "<init>", "()V", "supportedPreviewTypes", "", "", "open", "", "request", "Lcom/larus/office/base/preview/OfficePreviewOpenRequest;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocOpenerImpl implements IOfficePreviewOpener {

    public static final class a {
    }

    static {
    }

    public DocOpenerImpl() {
    }

    public final Set<Integer> b() {
        return SetsKt.setOf(22);
    }

    public final boolean a(com.larus.office.base.preview.b r9) {
        Intrinsics.checkNotNullParameter(r9, "request");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("open: token=");
        int r2 = com.larus.office.base.utils.f.a;
        r1.append(com.larus.office.base.utils.f.b(r9.c));
        r1.append(", enterMethod=");
        r1.append(r9.d);
        r1.append(", page=");
        r1.append(r9.e);
        r1.append(", restDocsSize=");
        r1.append(r9.f.size());
        r0.i("DocOpenerImpl", r1.toString());
        IFlowSdkDepend r3 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r3 == null) goto L5;
        r3.N();
        com.larus.home.impl.sdk.n1 r4 = com.larus.home.impl.sdk.n1.a;
    L7:
        if (r4 != null) goto L10;
        r0.w("DocOpenerImpl", "open: sdkDocService is null");
        return false;
    L10:
        Context r5 = r9.getContext();
        Pair[] r6 = new Pair[7];
        r6[0] = TuplesKt.to("key_doc_id", r9.c);
        String r7 = r9.d;
        if (r7 != null) goto L13;
        r7 = "url_jump";
    L13:
        r6[1] = TuplesKt.to("key_doc_enter_from", r7);
        r6[2] = TuplesKt.to("resource_type", 10);
        r6[3] = TuplesKt.to("key_doc_list_to_apply_permission", r9.f);
        r6[4] = TuplesKt.to("key_apply_permission_message_id", r9.g);
        r6[5] = TuplesKt.to("key_apply_permission_conversation_id", r9.h);
        r6[6] = TuplesKt.to("key_source_url_for_params", r9.i);
        Bundle r8 = com.larus.utils.f.c(r6);
        r8.putAll(r9.j);
        Unit r10 = Unit.INSTANCE;
        String r11 = r9.e;
        if (r11 != null) goto L16;
        r11 = "chat";
    L16:
        r4.x(r5, r8, r11);
        r0.i("DocOpenerImpl", "openDocDetailPage invoked: token=" + com.larus.office.base.utils.f.b(r9.c));
        return true;
    L5:
        r4 = null;
        goto L7
    }
}
