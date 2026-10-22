package com.larus.slides.impl.chat.component;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.slides.sdk.api.ISlidesSdkProxyService;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import ic8.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import va8.g0;
import va8.k0;
import va8.p;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\u0018\u0000 :2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001:B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016J\u0016\u0010-\u001a\u00020\u001f2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u0012\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u00103\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020&H\u0016J\u001c\u00105\u001a\u00020&2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J&\u00106\u001a\u00020&2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017082\b\u00109\u001a\u0004\u0018\u00010\u0017H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006;"}, d2 = {"Lcom/larus/slides/impl/chat/component/SlidesChatAbilityComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IOfficeChatCoreAbility;", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "<init>", "()V", "sceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "sceneAbility$delegate", "Lkotlin/Lazy;", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "chatFoldCoreAbility", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "getChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "chatFoldCoreAbility$delegate", "slidesToken", "", "artifactVersionId", "artifactMetaId", "resourceVersion", "", "referenceData", "queryId", "isRefSelect", "", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "Landroid/view/View;", "onSendMessage", "msg", "Lcom/larus/im/bean/message/Message;", "onUpdateMessage", "isBlockListFinish", "blockList", "", "Lcom/larus/im/bean/message/block/Block;", "setReferenceData", "data", "refSelectStateChange", "clearQueryId", "refreshArtifactInfo", "putMessageExt", "ext", "", "actionBarKey", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesChatAbilityComponent extends BaseContentWidget implements k0, te8.c {
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public String p;
    public String q;
    public String r;
    public int s;
    public String t;
    public String u;
    public boolean v;
    public int w;

    public static final class a {
    }

    public static final class b implements Function0<r> {
        public final /* synthetic */ AttachReceiver a;

        public b(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(r.class));
        }
    }

    public static final class c implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p.class));
        }
    }

    public static final class d implements Function0<g0> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g0.class));
        }
    }

    static {
    }

    public final void KI() {
        this.u = null;
    }

    public SlidesChatAbilityComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
        this.r = "";
        this.w = 2131365588;
    }

    public final int U2() {
        return this.w;
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r3, "msg");
        this.u = r3.getMessageId();
        FLogger.a.i("SlidesChatAbilityComponent", "onSendMessage, id=" + this.u);
    }

    public final void N0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void P(boolean r1) {
        this.v = r1;
    }

    public final void Q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void X2(int r1) {
        this.w = r1;
    }

    public final void a6(String r1) {
        this.t = r1;
        this.v = false;
    }

    public final void onViewCreated(View r9) {
        Intrinsics.checkNotNullParameter(r9, "view");
        p r10 = (p) this.n.getValue();
        if (r10 == null) goto L5;
        r10.hy(this);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 == null) goto L8;
        String r1 = r0.getString("slides_token", null);
    L9:
        this.p = r1;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r2 == null) goto L12;
        String r3 = r2.getString("artifact_version_id", null);
    L13:
        this.q = r3;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r4 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        String r5 = "";
        if (r4 == null) goto L19;
        String r6 = r4.getString("artifact_meta_id", "");
        if (r6 == null) goto L19;
        r5 = r6;
    L19:
        this.r = r5;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        int r8 = 0;
        if (r7 == null) goto L22;
        r8 = r7.getInt("resource_version", 0);
    L22:
        this.s = r8;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r11 == null) goto L28;
        String r12 = r11.getString("conversation_id");
        if (r12 == null) goto L29;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SlidesChatAbilityComponent$onViewCreated$1$1(r12, this, null), 2, null);
        return;
    L29:
        return;
    L28:
        return;
    L12:
        r3 = null;
        goto L13
    L8:
        r1 = null;
        goto L9
    }

    public final void p(Message r14) {
        Intrinsics.checkNotNullParameter(r14, "msg");
        Intrinsics.checkNotNullParameter(r14, "msg");
        if (com.larus.bmhome.chat.bean.d.G0(r14) == false) goto L5;
        return;
    L5:
        r r0 = (r) this.m.getValue();
        String r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.WE();
    L10:
        if (Intrinsics.areEqual(r2, "aippt_new_detail") == true) goto L13;
        FLogger.a.i("SlidesChatAbilityComponent", "It is not in slides detail page, just return, curScene=" + r2);
        return;
    L13:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onUpdateMessage, queryId = ");
        r4.append(this.u);
        r4.append(", msgReplyId=");
        r4.append(r14.getReplyId());
        r4.append(", office_tool_never_used = ");
        Map r5 = r14.getExt();
        if (r5 == null) goto L16;
        String r6 = (String) r5.get("office_tool_never_used");
    L17:
        r4.append(r6);
        r3.i("SlidesChatAbilityComponent", r4.toString());
        List r7 = com.larus.im.bean.message.a.m(r14);
        Intrinsics.checkNotNullParameter(r14, "<this>");
        List r8 = vd9.r.a(r14);
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L18:
        boolean r11 = true;
        if (r10.hasNext() == false) goto L32;
        Object r12 = r10.next();
        Block r13 = (Block) r12;
        ArrayList r15 = (ArrayList) r7;
        if (r15.isEmpty() == true) goto L29;
        Iterator r16 = r15.iterator();
    L25:
        if (r16.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((Block) r16.next()).getBlockId(), r13.getBlockId()) == false) goto L25;
        r11 = false;
    L29:
        if (r11 == false) goto L18;
        r9.add(r12);
        goto L18
    L32:
        if (o0.d(this.u) == true) goto L34;
        return;
    L34:
        if (Intrinsics.areEqual(r14.getReplyId(), this.u) == false) goto L84;
        Map r17 = r14.getExt();
        if (r17 == null) goto L39;
        r1 = (String) r17.get("office_tool_never_used");
    L39:
        if (Intrinsics.areEqual(r1, "1") == false) goto L53;
        FLogger.a.i("SlidesChatAbilityComponent", "office_tool_never_used true expand and dismiss");
        g0 r18 = (g0) this.o.getValue();
        if (r18 == null) goto L43;
        r18.expand("onReceiveSlidesCommonMsg");
    L43:
        ISlidesSdkProxyService r19 = (ISlidesSdkProxyService) ServiceManager.get().getService(ISlidesSdkProxyService.class);
        if (r19 == null) goto L48;
        com.larus.office.base.service.c r110 = r19.b();
        if (r110 == null) goto L48;
        r110.onLoadingEnd(false);
    L48:
        t1a.b r111 = s1a.d.a(this);
        if (r111 == null) goto L85;
        vw9.a r112 = r111.getAbility(vw9.a.class);
        if (r112 == null) goto L86;
        r112.s(new t(false, null, null, null, null, 3, 31));
        return;
    L86:
        return;
    L85:
        return;
    L53:
        FLogger r20 = FLogger.a;
        r20.i("SlidesChatAbilityComponent", "office_tool_never_used false");
        if ((!((ArrayList) r7).isEmpty()) == false) goto L66;
        r20.i("SlidesChatAbilityComponent", "onUpdateMessage, blockList streaming");
        t1a.b r21 = s1a.d.a(this);
        if (r21 == null) goto L66;
        vw9.a r22 = r21.getAbility(vw9.a.class);
        if (r22 == null) goto L66;
        IDeepThinkHeaderService r23 = (IDeepThinkHeaderService) ServiceManager.get().getService(IDeepThinkHeaderService.class);
        if (r23 == null) goto L65;
        t r24 = r23.a(r14);
        if (r24 == null) goto L82;
        r22.s(r24);
        goto L66
    L82:
        return;
    L65:
        return;
    L66:
        r20.i("SlidesChatAbilityComponent", "onUpdateMessage, isStreaming=" + com.larus.im.bean.message.a.w0(r14) + ", finish=" + com.larus.bmhome.chat.bean.d.j0(r14));
        if (com.larus.bmhome.chat.bean.d.j0(r14) == false) goto L88;
        r20.i("SlidesChatAbilityComponent", "onUpdateMessage, notStreaming");
        t1a.b r113 = s1a.d.a(this);
        if (r113 == null) goto L89;
        vw9.a r114 = r113.getAbility(vw9.a.class);
        if (r114 == null) goto L90;
        r114.s(new t(false, null, null, null, null, 2, 31));
        return;
    L90:
        return;
    L89:
        return;
    L88:
        return;
    L84:
        return;
    L16:
        r6 = null;
        goto L17
    L8:
        r2 = null;
        goto L10
    }

    public final void v(List<Message> r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
    }

    public final void v1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void y0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }

    /* JADX WARN: Not found block with instruction: 0x00b0: MOVE (r11v2 ?? I:??[OBJECT, ARRAY]) A[DONT_GENERATE, REMOVE] (LINE:33554608) */
    public final void D7(Map<String, String> r20, String r21) {
        String r9 = "Ref block info: ";
        Intrinsics.checkNotNullParameter(r20, "ext");
        r r10 = (r) this.m.getValue();
        if (r10 == null) goto L5;
        String r11 = r10.WE();
    L7:
        if (Intrinsics.areEqual(r11, "aippt_new_detail") == true) goto L10;
        FLogger.a.i("SlidesChatAbilityComponent", "It is not in slides detail page, just return, curScene=" + r11);
        return;
    L10:
        FLogger r12 = FLogger.a;
        r12.i("SlidesChatAbilityComponent", "putMessageExt, curScene = " + r11 + ", selectedText = " + this.t);
        if (o0.d(this.p) == false) goto L61;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L51
        r13.put("action", 0);     // Catch: Exception -> L51
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L51
        r14.put("presentation_id", this.p);     // Catch: Exception -> L51
        r14.put("artifact_version_id", this.q);     // Catch: Exception -> L51
        if (o0.d(this.t) == false) goto L42;
        JSONObject r15 = new JSONObject(this.t);     // Catch: Exception -> L51
        if (o0.d(r15.optString("text")) == false) goto L17;
        r20.put("reference_text", r15.optString("text"));     // Catch: Exception -> L51
    L17:
        String r22 = "SlidesChatAbilityComponent";
    L49:
        e = e;
        String r3 = r22;
    L53:
        FLogger.a.e(r3, e.getMessage(), e);
        return;
    L20:
        if (r15.optLong("structureVersion", -1) > 0) goto L22;
        r14.put("structure_version", this.s);     // Catch: Exception -> L49
    L24:
        JSONObject r7 = new JSONObject();     // Catch: Exception -> L49
        if (r15.optString("slideBlockId") == null) goto L28;
        r7.put("slide_block_id", r15.optString("slideBlockId"));     // Catch: Exception -> L49
    L28:
        if (r15.optString("elementBlockId") == null) goto L31;
        r7.put("element_block_id", r15.optString("elementBlockId"));     // Catch: Exception -> L49
    L31:
        if (o0.d(r15.optString("pageId")) == false) goto L34;
        r7.put("page_id", r15.optString("pageId"));     // Catch: Exception -> L49
    L34:
        if (r15.optInt("startOffset", -1) < 0) goto L37;
        r7.put("start_offset", r15.optInt("startOffset", -1));     // Catch: Exception -> L49
    L37:
        if (r15.optInt("endOffset", -1) < 0) goto L39;
        r7.put("end_offset", r15.optInt("endOffset", -1));     // Catch: Exception -> L49
    L39:
        JSONArray r2 = new JSONArray();     // Catch: Exception -> L49
        r2.put(r7);     // Catch: Exception -> L49
        r14.put("select_positions", r2);     // Catch: Exception -> L49
        if (this.v == false) goto L43;
        r14.put("ref_positions", r2);     // Catch: Exception -> L49
    L43:
        r13.put("context", r14);     // Catch: Exception -> L49
        r20.put("office_ref_block_info", r13.toString());     // Catch: Exception -> L49
        r3 = r22;
        r12.i(r3, r9 + r13);     // Catch: Exception -> L47
        return;
    L47:
        e = e;
        goto L53
    L22:
        r14.put("structure_version", r15.optLong("structureVersion", -1));     // Catch: Exception -> L49
        goto L24
    L42:
        r22 = "SlidesChatAbilityComponent";
        r9 = "Ref block info: ";
    L51:
        e = e;
        r3 = "SlidesChatAbilityComponent";
        goto L53
    L61:
        return;
    L5:
        r11 = null;
        goto L7
    }

    public final void D8(String r1, String r2) {
        if (r1 == null) goto L4;
        this.r = r1;
    L4:
        if (r2 == null) goto L7;
        this.q = r2;
        return;
    }
}
