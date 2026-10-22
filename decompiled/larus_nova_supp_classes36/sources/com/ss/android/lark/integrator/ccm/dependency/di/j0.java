package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j0 extends c0c.b implements com.bytedance.ee.bear.lark.dependency.t {
    public final /* synthetic */ com.bytedance.ee.bear.lark.dependency.t b;
    public final com.ss.android.lark.passportc.internal.v c;
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.t> d;

    public static final class a {
    }

    static {
    }

    public final void K2(String r7, String r8, String r9, RichText r10, Message.PartialReplyInfo r11) {
        this.b.K2(r7, r8, r9, r10, r11);
    }

    public final void O(List r2, AssociatedPreviewService.requestUrlPreview.1.1.2 r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        this.b.O(r2, r3);
    }

    public final boolean Qc() {
        return this.b.Qc();
    }

    public final void V0(Context r2, DocShareTextData r3) {
        this.b.V0(r2, r3);
    }

    public final Map<String, Chatter> a0(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return this.b.a0(r2);
    }

    public final void a6(String r2, String r3, RichText r4, IGetDataCallback r5) {
        this.b.a6(r2, r3, r4, r5);
    }

    public final void aa(Context r2, DocImagesForwardData r3) {
        this.b.aa(r2, r3);
    }

    public final void bd(Context r2, DocShareTextData r3, int r4) {
        this.b.bd(r2, r3, r4);
    }

    public final void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        this.b.getTranslateLanguages(r2);
    }

    public final boolean isDocSmartComposeEnabled() {
        return this.b.isDocSmartComposeEnabled();
    }

    public final Map<String, Chatter> l0(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return this.b.l0(r2);
    }

    public final void m7(Context r2, String r3) {
        this.b.m7(r2, r3);
    }

    public final void n(Context r2, String r3) {
        this.b.n(r2, r3);
    }

    public final void n3(FragmentActivity r2, ForwardTemplate r3) {
        this.b.n3(r2, r3);
    }

    public final void sendMessage(com.ss.android.lark.biz.im.api.j1 r2, IGetDataCallback<String> r3) {
        this.b.sendMessage(r2, r3);
    }

    public final void lf(f0c.b r4) {
        Intrinsics.checkNotNullParameter(r4, "toState");
        tt5.a.h("MessagingDependencyProxy", "destroy");
        Intrinsics.checkNotNullParameter(r4, "toState");
    }

    public j0(com.ss.android.lark.passportc.api.j r4, com.ss.android.lark.passportc.internal.v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.bear.lark.dependency.t> r0 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r5.c(r1), com.bytedance.ee.bear.lark.dependency.t.class), com.bytedance.ee.bear.lark.dependency.t.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (com.bytedance.ee.bear.lark.dependency.t) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r2, f0c.g r3) {
        tt5.a.h("MessagingDependencyProxy", "preparing");
        com.ss.android.lark.passportc.internal.v r4 = this.c;
        if (r3 == null) goto L6;
        UserSession r5 = r3.b;
        if (r5 == null) goto L6;
    L7:
        com.bytedance.ee.bear.lark.dependency.t r6 = (com.bytedance.ee.bear.lark.dependency.t) e0c.k.b(r4.c(r5), com.bytedance.ee.bear.lark.dependency.t.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
