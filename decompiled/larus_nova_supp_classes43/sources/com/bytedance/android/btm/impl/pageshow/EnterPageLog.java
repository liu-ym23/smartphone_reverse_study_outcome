package com.bytedance.android.btm.impl.pageshow;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.p;
import com.bytedance.android.btm.impl.page.lifecycle.ResumeFuncOrigin;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.startnode.StartNodeManager;
import com.bytedance.android.btm.impl.thread.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EnterPageLog {
    public static final EnterPageLog a = null;

    public static final class a implements com.bytedance.android.btm.impl.startnode.a {
        public final /* synthetic */ PageInfo a;
        public final /* synthetic */ ResumeFuncOrigin b;

        @Override // com.bytedance.android.btm.impl.startnode.a
        public final void a() {
            EnterPageLog r0 = EnterPageLog.a;
            EnterPageLog.b(this.a, this.b);
            StartNodeManager.h.remove(this);
        }

        public a(PageInfo r1, ResumeFuncOrigin r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public EnterPageLog() {
    }

    static {
        a = new EnterPageLog();
    }

    public static final /* synthetic */ String a(ResumeFuncOrigin r1, Boolean r10) {
        return a.getType(r1, r10);
    }

    public static void b(final PageInfo r10, final ResumeFuncOrigin r11) {
        ConcurrentHashMap<String, PageInfo> r0 = com.bytedance.android.btm.impl.pageshow.a.a;
        if (BtmSetting.d.c().b().H() != 1) goto L6;
        com.bytedance.android.btm.impl.pageshow.a.a.put(r10.getPageShowId(), r10);
    L6:
        b.e.a(new EnterPageLog$sendEnterPageEvent$1(r10, r11), false);
    }

    public static void c(final PageInfo r10, final ResumeFuncOrigin r11) {
        ALogger r0 = ALogger.d;
        r0.b("EnterPageLog_show", false, new EnterPageLog$show$1(r11, r10));
        String r1 = r10.getPageBtm();
        boolean r12 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        if (r13 == false) goto L12;
        return;
    L12:
        if (r10.getHasSendEnterPage() == false) goto L15;
        r0.b("EnterPageLog_show", false, EnterPageLog$show$2.INSTANCE);
        return;
    L15:
        r10.setHasSendEnterPage(true);
        PageInfo r14 = r10.copy();
        ConcurrentHashMap<String, PageInfo> r15 = com.bytedance.android.btm.impl.pageshow.a.a;
        BtmSetting r16 = BtmSetting.d;
        if (r16.c().b().H() != 2) goto L19;
        com.bytedance.android.btm.impl.pageshow.a.a.put(r14.getPageShowId(), r14);
    L19:
        p r17 = StartNodeManager.a;
        if (r17 != null) goto L22;
    L28:
        r12 = false;
    L29:
        if (r12 == true) goto L31;
    L33:
        b(r14, r11);
        return;
    L31:
        if (r16.c().c().r() == false) goto L33;
        r0.b("EnterPageLog_show", false, EnterPageLog$show$3.INSTANCE);
        a r18 = new a(r14, r11);
        StartNodeManager.h.add(r18);
        return;
    L22:
        if (r17.a == true) goto L28;
        if (StartNodeManager.c == null) goto L29;
        if (StartNodeManager.d != null) goto L28;
    L5:
        if (r1.length() == 0) goto L8;
        r13 = false;
        goto L9
    }

    private final String getType(ResumeFuncOrigin r10, Boolean r11) {
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == true) goto L5;
        return "default";
    L5:
        if (r10 != ResumeFuncOrigin.HybridRegister) goto L7;
        return "h5_init";
    L7:
        return "init";
    }
}
