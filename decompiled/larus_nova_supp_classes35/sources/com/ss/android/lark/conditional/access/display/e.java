package com.ss.android.lark.conditional.access.display;

import android.util.Base64;
import com.bytedance.lark.pb.security.v1.CustomDisplayConfig;
import com.ss.android.lark.conditional.access.utils.FileAuthMonitor;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class e implements i {
    public final com.ss.android.lark.storage.kv.repo.a a;

    public static final class a {
    }

    static {
    }

    @Inject
    public e(com.ss.android.lark.storage.kv.storage.a r4) {
        Intrinsics.checkNotNullParameter(r4, "kvStorage");
        com.ss.android.lark.storage.a r0 = com.ss.android.lark.security.compliance.infra.storage.d.a;
        Intrinsics.checkNotNullParameter(r4, "user");
        Intrinsics.checkNotNullParameter("CustomDisplayStorage", IPortraitService.NAME);
        this.a = LarkKVStorage.d(LarkKVStorage.a, r4, com.ss.android.lark.security.compliance.infra.storage.d.a, "CustomDisplayStorage");
    }

    @Override // com.ss.android.lark.conditional.access.display.i
    public final void a(String r8, List<CustomDisplayModel> r9) {
        Intrinsics.checkNotNullParameter(r8, "locale");
        Intrinsics.checkNotNullParameter(r9, "models");
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        CustomDisplayModel r0 = (CustomDisplayModel) r10.next();
        StringBuilder r1 = new StringBuilder();
        r1.append(r8);
        CustomDisplayConfig r2 = r0.getConfig();
        String r3 = BuildConfig.FLAVOR;
        if (r2 == null) goto L9;
        String r4 = r2.id;
        if (r4 == null) goto L9;
    L10:
        r1.append(r4);
        String r5 = r1.toString();
        com.ss.android.lark.storage.kv.repo.a r6 = this.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        CustomDisplayConfig r7 = r0.getConfig();     // Catch: Exception -> L18
        if (r7 == null) goto L15;
        byte[] r11 = r7.encode();     // Catch: Exception -> L18
        if (r11 == null) goto L15;
    L16:
        r0.setConfigString(new String(Base64.encode(r11, 0), Charsets.UTF_8));     // Catch: Exception -> L18
    L24:
        r6.putString(r5, com.ss.android.lark.security.compliance.infra.util.f.c(r0));
    L15:
        r11 = new byte[0];     // Catch: Exception -> L18
    L18:
        e = move-exception;
        int r12 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomDisplayModel", "serialize error, msg is " + e.getMessage() + ", stackTrace is " + ExceptionsKt.stackTraceToString(e));
        FileAuthMonitor.UpdateTrigger[] r13 = FileAuthMonitor.a;
        String r14 = e.getMessage();
        if (r14 == null) goto L23;
        r3 = r14;
    L23:
        FileAuthMonitor.e(201, r3);
    L9:
        r4 = BuildConfig.FLAVOR;
        goto L10
    }

    @Override // com.ss.android.lark.conditional.access.display.i
    public final CustomDisplayModel b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "locale");
        Intrinsics.checkNotNullParameter(r5, "id");
        String r6 = this.a.getString(r4 + r5, null);
        if (r6 == null) goto L15;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        CustomDisplayModel r7 = (CustomDisplayModel) com.ss.android.lark.security.compliance.infra.util.f.a(r6, CustomDisplayModel.class);     // Catch: Exception -> L7
        r7.setConfig((CustomDisplayConfig) CustomDisplayConfig.ADAPTER.decode(Base64.decode(r7.getConfigString().getBytes(Charsets.UTF_8), 0)));     // Catch: Exception -> L7
        return r7;
    L7:
        e = move-exception;
        int r8 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_CustomDisplayModel", "deserialize error, msg is " + e.getMessage() + ", stackTrace is " + ExceptionsKt.stackTraceToString(e));
        FileAuthMonitor.UpdateTrigger[] r9 = FileAuthMonitor.a;
        String r10 = e.getMessage();
        if (r10 != null) goto L11;
        r10 = BuildConfig.FLAVOR;
    L11:
        FileAuthMonitor.e(202, r10);
        return null;
    L15:
        return null;
    }
}
