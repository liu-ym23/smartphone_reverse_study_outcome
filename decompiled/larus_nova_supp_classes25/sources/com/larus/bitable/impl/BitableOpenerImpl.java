package com.larus.bitable.impl;

import android.content.Context;
import android.os.Bundle;
import com.larus.bitable.api.IBitableService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.office.base.preview.IOfficePreviewOpener;
import com.larus.office.base.preview.b;
import com.larus.office.base.utils.f;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/larus/bitable/impl/BitableOpenerImpl;", "Lcom/larus/office/base/preview/IOfficePreviewOpener;", "<init>", "()V", "supportedPreviewTypes", "", "", "open", "", "request", "Lcom/larus/office/base/preview/OfficePreviewOpenRequest;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BitableOpenerImpl implements IOfficePreviewOpener {

    public static final class a {
    }

    static {
    }

    public BitableOpenerImpl() {
    }

    public final Set<Integer> b() {
        return SetsKt.setOf(8);
    }

    public final boolean a(b r10) {
        Intrinsics.checkNotNullParameter(r10, "request");
        if (StringsKt.isBlank(r10.c) == false) goto L6;
        FLogger.a.w("BitableOpenerImpl", "open skipped, token is empty");
        return false;
    L6:
        int r0 = bq9.b.a;
        if (bq9.b.b(r10.i) == false) goto L11;
        FLogger.a.i("BitableOpenerImpl", "open skipped, BaseApp temporarily uses H5");
        return false;
    L11:
        if (z2.a.getLarkBitableConfig().a() == true) goto L14;
        FLogger r1 = FLogger.a;
        StringBuilder r3 = new StringBuilder("open skipped, enableBitable=false, token=");
        int r4 = f.a;
        r3.append(f.b(r10.c));
        r1.i("BitableOpenerImpl", r3.toString());
        return false;
    L14:
        IBitableService r2 = (IBitableService) ServiceManager.get().getService(IBitableService.class);
        if (r2 != null) goto L18;
        FLogger.a.w("BitableOpenerImpl", "open skipped, bitableService is null");
        return false;
    L18:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("open: token=");
        int r7 = f.a;
        r6.append(f.b(r10.c));
        r6.append(", enterMethod=");
        r6.append(r10.d);
        r6.append(", page=");
        r6.append(r10.e);
        r6.append(", restDocsSize=");
        r6.append(r10.f.size());
        r5.i("BitableOpenerImpl", r6.toString());
        Context r8 = r10.getContext();
        Pair[] r9 = new Pair[10];
        r9[0] = TuplesKt.to("base_token", r10.c);
        r9[1] = TuplesKt.to("resource_id", r10.c);
        r9[2] = TuplesKt.to("resource_type", 15);
        String r11 = r10.d;
        String r12 = "url_jump";
        if (r11 != null) goto L21;
        r11 = "url_jump";
    L21:
        r9[3] = TuplesKt.to("enter_from", r11);
        String r13 = r10.d;
        if (r13 == null) goto L25;
        r12 = r13;
    L25:
        r9[4] = TuplesKt.to("enter_method", r12);
        r9[5] = TuplesKt.to("click_timestamp", Long.valueOf(System.currentTimeMillis()));
        r9[6] = TuplesKt.to("key_source_url_for_params", r10.i);
        r9[7] = TuplesKt.to("doc_list_to_apply_permission", r10.f);
        r9[8] = TuplesKt.to("apply_permission_message_id", r10.g);
        r9[9] = TuplesKt.to("apply_permission_conversation_id", r10.h);
        Bundle r14 = com.larus.utils.f.c(r9);
        r14.putAll(r10.j);
        Unit r15 = Unit.INSTANCE;
        String r16 = r10.e;
        if (r16 != null) goto L28;
        r16 = "base_detail";
    L28:
        r2.d(r8, r14, r16);
        r5.i("BitableOpenerImpl", "openBitable invoked: token=" + f.b(r10.c));
        return true;
    }
}
