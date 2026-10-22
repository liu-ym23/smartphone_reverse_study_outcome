package com.ss.android.lark.integrator.ccm.dependency.di;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.integrator.ccm.dependency.forward.CCMForward;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public class i0 implements com.bytedance.ee.bear.lark.dependency.t {
    public boolean Qc() {
        return true;
    }

    public final boolean isDocSmartComposeEnabled() {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).isDocSmartComposeEnabled();
    }

    @Inject
    public i0() {
    }

    public final Map<String, Chatter> a0(List<String> r2) {
        return ((com.ss.android.lark.im.sdk.service.h) LarkContext.spiByDwarf(com.ss.android.lark.im.sdk.service.h.class)).a0(r2);
    }

    public final void getTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r2) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).getTranslateLanguages(r2);
    }

    public final Map<String, Chatter> l0(List<String> r2) {
        return ((com.ss.android.lark.im.sdk.service.h) LarkContext.spiByDwarf(com.ss.android.lark.im.sdk.service.h.class)).l0(r2);
    }

    public final void O(List r2, AssociatedPreviewService.requestUrlPreview.1.1.2 r3) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).chatPreviewApi().O(r2, r3);
    }

    public void V0(Context r2, DocShareTextData r3) {
        bd(r2, r3, -1);
    }

    public void aa(Context r1, DocImagesForwardData r2) {
        CCMForward.a(r1, r2);
    }

    public final void m7(Context r3, String r4) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 == null) goto L5;
        com.ss.android.lark.biz.im.api.l1.a r1 = new com.ss.android.lark.biz.im.api.l1.a();
        r1.e = r4;
        r0.openReplyInThread(r3, r1.a());
        return;
    L5:
        tt5.a.d("MessagingDependencyImpl", "openReplyInThread()... imApi is null!");
    }

    public final void n(Context r3, String r4) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        ChatBundle.a r1 = new ChatBundle.a();
        r1.a = r4;
        r1.f = 67108864;
        r0.openChat(r3, new ChatBundle(r1));
    }

    public void n3(FragmentActivity r2, ForwardTemplate r3) {
        com.ss.android.lark.forwardv2.e.c(r2, r3);
    }

    public final void sendMessage(com.ss.android.lark.biz.im.api.j1 r2, IGetDataCallback<String> r3) {
        ((IIMApi) ApiUtils.getApi(IIMApi.class)).sendMessage(r2, r3);
    }

    public void bd(Context r1, DocShareTextData r2, int r3) {
        CCMForward.b(r1, r2, r3);
    }

    public final void a6(String r3, String r4, RichText r5, IGetDataCallback r6) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        kya.a.a r1 = new kya.a.a();
        ((MessageParams.a) r1).c = r3;
        r1.D = true;
        r1.A = r4;
        r1.B = r5;
        r0.sendMessage(r1.b(), r6);
    }

    public final void K2(String r3, String r4, String r5, RichText r6, Message.PartialReplyInfo r7) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        com.ss.android.lark.biz.im.api.j1.a r1 = new com.ss.android.lark.biz.im.api.j1.a();
        ((MessageParams.a) r1).c = r3;
        ((MessageParams.a) r1).a = r4;
        ((MessageParams.a) r1).b = r5;
        ((MessageParams.a) r1).s = r7;
        r1.A = r6;
        r0.sendMessage(r1.b());
    }
}
