package com.larus.sheet.impl.chat.component;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.Gson;
import com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.sheet.sdk.api.SheetSelection;
import com.larus.sheet.sdk.api.SheetSelectionChangeData;
import com.larus.sheet.sdk.api.SheetUserSelection;
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
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;
import va8.g0;
import va8.n0;
import va8.p;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0016J\u0016\u00101\u001a\u00020\u001f2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\u0012\u00105\u001a\u00020*2\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u00107\u001a\u00020*2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u00108\u001a\u00020*H\u0016J\u001c\u00109\u001a\u00020*2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010:\u001a\u00020*2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170<2\b\u0010=\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006C"}, d2 = {"Lcom/larus/sheet/impl/chat/component/SheetChatAbilityComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/ISheetChatCoreAbility;", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "<init>", "()V", "sceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "sceneAbility$delegate", "Lkotlin/Lazy;", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "chatFoldCoreAbility", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "getChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "chatFoldCoreAbility$delegate", "slidesToken", "", "artifactVersionId", "artifactMetaId", "resourceVersion", "", "referenceData", "queryId", "isLocalConversationWhenSendMessage", "", "isRefSelect", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/sheet/api/ISheetCotInfoListener;", "contentViewId", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "Landroid/view/View;", "onSendMessage", "msg", "Lcom/larus/im/bean/message/Message;", "onUpdateMessage", "isBlockListFinish", "blockList", "", "Lcom/larus/im/bean/message/block/Block;", "setReferenceData", "data", "refSelectStateChange", "clearQueryId", "refreshArtifactInfo", "putMessageExt", "ext", "", "actionBarKey", "mapSheetUserSelectionToJson", "Lorg/json/JSONObject;", "selection", "Lcom/larus/sheet/sdk/api/SheetUserSelection;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetChatAbilityComponent extends BaseContentWidget implements n0, te8.c {
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public boolean u;
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
        this.t = null;
    }

    public SheetChatAbilityComponent() {
        this.m = LazyKt.lazy(new b(this));
        this.n = LazyKt.lazy(new c(this));
        this.o = LazyKt.lazy(new d(this));
        this.r = "";
        new CopyOnWriteArraySet();
        this.w = 2131365588;
    }

    public final int U2() {
        return this.w;
    }

    public static JSONObject Y2(SheetUserSelection r7) {
        JSONObject r0 = new JSONObject();
        r0.put("active_sheet_id", r7.getActiveSheetId());
        r0.put("active_sheet_name", r7.getActiveSheetName());
        JSONArray r1 = new JSONArray();
        List<SheetSelection> r8 = r7.getSheets();
        if (r8 == null) goto L43;
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L43;
        SheetSelection r2 = (SheetSelection) r9.next();
        JSONObject r3 = new JSONObject();
        String r4 = "";
        if (r2 == null) goto L11;
        String r5 = r2.getSheetId();
        if (r5 == null) goto L11;
    L12:
        r3.put("sheet_id", r5);
        if (r2 == null) goto L18;
        String r6 = r2.getSheetName();
        if (r6 == null) goto L18;
        r4 = r6;
    L18:
        r3.put("sheet_name", r4);
        JSONArray r10 = new JSONArray();
        if (r2 == null) goto L26;
        List<String> r11 = r2.getRanges();
        if (r11 == null) goto L26;
        Iterator<T> r12 = r11.iterator();
    L24:
        if (r12.hasNext() == false) goto L26;
        r10.put((String) r12.next());
    L26:
        r3.put("ranges", r10);
        JSONArray r13 = new JSONArray();
        if (r2 == null) goto L34;
        List<String> r14 = r2.getCharts();
        if (r14 == null) goto L34;
        Iterator<T> r15 = r14.iterator();
    L32:
        if (r15.hasNext() == false) goto L34;
        r13.put((String) r15.next());
    L34:
        r3.put("charts", r13);
        JSONArray r16 = new JSONArray();
        if (r2 == null) goto L42;
        List<String> r17 = r2.getFloatImages();
        if (r17 == null) goto L42;
        Iterator<T> r18 = r17.iterator();
    L40:
        if (r18.hasNext() == false) goto L42;
        r16.put((String) r18.next());
    L42:
        r3.put("float_images", r16);
        r1.put(r3);
    L11:
        r5 = "";
    L43:
        r0.put("sheets", r1);
        return r0;
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        Intrinsics.checkNotNullParameter(r6, "msg");
        this.t = r6.getMessageId();
        String r0 = r6.getConversationId();
        boolean r1 = false;
        if (r0 == null) goto L5;
        r1 = StringsKt.contains$default(r0, "-sheets-detail", false, 2, null);
    L5:
        this.u = r1;
        FLogger.a.i("SheetChatAbilityComponent", "onSendMessage,cid = " + r6.getConversationId() + ", queryId=" + this.t + ", msgId = " + r6.getMessageId() + ", msgReplyId=" + r6.getReplyId() + ',');
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
        this.s = r1;
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
        String r1 = r0.getString("sheets_token", null);
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
        if (r7 == null) goto L22;
        r7.getInt("resource_version", -1);
    L22:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r11 == null) goto L28;
        String r12 = r11.getString("conversation_id");
        if (r12 == null) goto L29;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new SheetChatAbilityComponent$onViewCreated$1$1(r12, this, null), 2, null);
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
        if (Intrinsics.areEqual(r2, "aisheet_detail") == true) goto L13;
        FLogger.a.i("SheetChatAbilityComponent", "It is not in slides detail page, just return, curScene=" + r2);
        return;
    L13:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onUpdateMessage, cid = ");
        r4.append(r14.getConversationId());
        r4.append(", queryId = ");
        r4.append(this.t);
        r4.append(", msgId = ");
        r4.append(r14.getMessageId());
        r4.append(", msgReplyId=");
        r4.append(r14.getReplyId());
        r4.append(", office_tool_never_used = ");
        Map r5 = r14.getExt();
        if (r5 == null) goto L16;
        String r6 = (String) r5.get("office_tool_never_used");
    L17:
        r4.append(r6);
        r3.i("SheetChatAbilityComponent", r4.toString());
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
        if (o0.d(this.t) == false) goto L36;
        if (Intrinsics.areEqual(r14.getReplyId(), this.t) == false) goto L36;
    L37:
        Map r17 = r14.getExt();
        if (r17 == null) goto L41;
        r1 = (String) r17.get("office_tool_never_used");
    L41:
        if (Intrinsics.areEqual(r1, "1") == false) goto L55;
        FLogger.a.i("SheetChatAbilityComponent", "office_tool_never_used true expand and dismiss");
        g0 r18 = (g0) this.o.getValue();
        if (r18 == null) goto L45;
        r18.expand("onReceiveSlidesCommonMsg");
    L45:
        ISheetSdkProxyService r19 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r19 == null) goto L50;
        com.larus.office.base.service.c r110 = r19.b();
        if (r110 == null) goto L50;
        r110.onLoadingEnd(false);
    L50:
        t1a.b r111 = s1a.d.a(this);
        if (r111 == null) goto L86;
        mw9.a r112 = r111.getAbility(mw9.a.class);
        if (r112 == null) goto L87;
        r112.s(new t(false, null, null, null, null, 3, 31));
        return;
    L87:
        return;
    L86:
        return;
    L55:
        FLogger r20 = FLogger.a;
        r20.i("SheetChatAbilityComponent", "office_tool_never_used false");
        if ((!((ArrayList) r7).isEmpty()) == false) goto L68;
        r20.i("SheetChatAbilityComponent", "onUpdateMessage, blockList streaming");
        t1a.b r21 = s1a.d.a(this);
        if (r21 == null) goto L68;
        mw9.a r22 = r21.getAbility(mw9.a.class);
        if (r22 == null) goto L68;
        IDeepThinkHeaderService r23 = (IDeepThinkHeaderService) ServiceManager.get().getService(IDeepThinkHeaderService.class);
        if (r23 == null) goto L67;
        t r24 = r23.a(r14);
        if (r24 == null) goto L84;
        r22.s(r24);
        goto L68
    L84:
        return;
    L67:
        return;
    L68:
        r20.i("SheetChatAbilityComponent", "onUpdateMessage, isStreaming=" + com.larus.im.bean.message.a.w0(r14) + ", finish=" + com.larus.bmhome.chat.bean.d.j0(r14));
        if (com.larus.bmhome.chat.bean.d.j0(r14) == false) goto L89;
        r20.i("SheetChatAbilityComponent", "onUpdateMessage, notStreaming");
        t1a.b r113 = s1a.d.a(this);
        if (r113 == null) goto L90;
        mw9.a r114 = r113.getAbility(mw9.a.class);
        if (r114 == null) goto L91;
        r114.s(new t(false, null, null, null, null, 2, 31));
        return;
    L91:
        return;
    L90:
        return;
    L89:
        return;
    L36:
        if (this.u == true) goto L37;
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

    public final void D7(Map<String, String> r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "ext");
        r r0 = (r) this.m.getValue();
        if (r0 == null) goto L5;
        String r1 = r0.WE();
    L7:
        if (Intrinsics.areEqual(r1, "aisheet_detail") == true) goto L10;
        FLogger.a.i("SheetChatAbilityComponent", "It is not in sheet detail page, just return, curScene=" + r1);
        return;
    L10:
        FLogger r2 = FLogger.a;
        r2.i("SheetChatAbilityComponent", "putMessageExt, curScene = " + r1 + ", selectedText = " + this.s);
        if (o0.d(this.p) == false) goto L34;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L29
        r3.put("action", 0);     // Catch: Exception -> L29
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L29
        r4.put("artifact_meta_id", this.r);     // Catch: Exception -> L29
        r4.put("artifact_version_id", this.q);     // Catch: Exception -> L29
        if (o0.d(this.s) == false) goto L27;
        SheetSelectionChangeData r5 = (SheetSelectionChangeData) new Gson().fromJson(this.s, SheetSelectionChangeData.class);     // Catch: Exception -> L29
        if (this.v == false) goto L22;
        SheetUserSelection r6 = r5.getSelected();     // Catch: Exception -> L29
        if (r6 == null) goto L20;
        String r7 = r6.getPlainText();     // Catch: Exception -> L29
        if (r7 == null) goto L20;
    L21:
        r8.put("reference_text", r7);     // Catch: Exception -> L29
    L20:
        r7 = "";
    L22:
        r4.put("spreadsheet_token", r5.getSpreadsheetToken());     // Catch: Exception -> L29
        r4.put("spreadsheet_version", r5.getSpreadsheetVersion());     // Catch: Exception -> L29
        SheetUserSelection r10 = r5.getSelected();     // Catch: Exception -> L29
        if (r10 == null) goto L27;
        JSONObject r11 = Y2(r10);     // Catch: Exception -> L29
        r4.put("selected_sheets", r11);     // Catch: Exception -> L29
        if (this.v == false) goto L27;
        r4.put("ref_sheets", r11);     // Catch: Exception -> L29
    L27:
        r3.put("context", r4);     // Catch: Exception -> L29
        r8.put("office_sheet_ref_block_info", r3.toString());     // Catch: Exception -> L29
        r2.i("SheetChatAbilityComponent", "Ref block info: " + r3);     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        FLogger.a.e("SheetChatAbilityComponent", e.getMessage(), e);
        return;
    L34:
        return;
    L5:
        r1 = null;
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
