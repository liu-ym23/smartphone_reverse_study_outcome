package com.larus.doc.impl.chat.component;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.doc.api.IDocService;
import com.larus.doc.impl.chat.data.PageTaskInfo;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.j;
import com.larus.im.service.d0;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.z;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import n39.l;
import org.json.JSONObject;
import va8.g0;
import va8.l0;
import va8.p;
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000b*\u0001*\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002NOB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000203H\u0016J\u0010\u00107\u001a\u0002032\u0006\u00108\u001a\u00020%H\u0016J\b\u00109\u001a\u00020'H\u0002J\u0010\u0010:\u001a\u0002032\u0006\u00108\u001a\u00020%H\u0016J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u001c2\b\u0010=\u001a\u0004\u0018\u00010\u001cH\u0002J\u0016\u0010>\u001a\u00020'2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0002J\u0016\u0010B\u001a\u00020\u001c2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0002J&\u0010C\u001a\u0002032\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0E2\b\u0010F\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010G\u001a\u000203H\u0016J\b\u0010H\u001a\u000203H\u0016J\b\u0010I\u001a\u00020'H\u0016J\u0012\u0010J\u001a\u0002032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010K\u001a\u0002032\b\u0010L\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010M\u001a\u0002032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+R\u001a\u0010,\u001a\u00020-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006P"}, d2 = {"Lcom/larus/doc/impl/chat/component/PageTaskInfoComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IPageTaskInfoCoreAbility;", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "<init>", "()V", "sceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "sceneAbility$delegate", "Lkotlin/Lazy;", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "floatChatFoldAbility", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "getFloatChatFoldAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "floatChatFoldAbility$delegate", "chatInputCoreAbility", "Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "getChatInputCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "chatInputCoreAbility$delegate", "resourceId", "", "docLogicKey", "artifactVersionId", "messageId", "conversationId", "localConversationId", "selectedText", "selectedWholeText", "lastStreamMsg", "Lcom/larus/im/bean/message/Message;", "isStreaming", "", "lastStreamText", "conversationChangeListener", "com/larus/doc/impl/chat/component/PageTaskInfoComponent$conversationChangeListener$1", "Lcom/larus/doc/impl/chat/component/PageTaskInfoComponent$conversationChangeListener$1;", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "onViewCreated", "", "view", "Landroid/view/View;", "onDestroy", "onUpdateMessage", "msg", "hasSelectionBlock", "onStreamEnd", "getNextStreamText", "curText", "prefix", "isBlockListFinish", "blockList", "", "Lcom/larus/im/bean/message/block/Block;", "connectBlockListText", "putMessageExt", "ext", "", "actionBarKey", "selectCurrentTextOrParagraph", "resetSelectedText", "hasSelectedText", "setArtifactVersionId", "setConversationId", "convId", "setResourceId", "Companion", "SelectedText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageTaskInfoComponent extends BaseContentWidget implements l0, te8.c {
    public static final /* synthetic */ int D = 0;
    public String A;
    public final c B;
    public int C;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public Message y;
    public boolean z;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/doc/impl/chat/component/PageTaskInfoComponent$SelectedText;", "", "text", "", "wholeText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getWholeText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("text")
        private final String text;

        @SerializedName("wholeText")
        private final String wholeText;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.wholeText, r6.wholeText) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.text;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.wholeText;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "SelectedText(text=" + this.text + ", wholeText=" + this.wholeText + ')';
        }

        public b() {
            this.text = null;
            this.wholeText = null;
        }
    }

    public static final class c implements d0<wc9.e> {
        public final /* synthetic */ PageTaskInfoComponent a;

        public c(PageTaskInfoComponent r1) {
            this.a = r1;
        }

        public final void c(Object r4) {
            wc9.e r5 = (wc9.e) r4;
            Intrinsics.checkNotNullParameter(r5, FlowProtocolAbility.FEATURE_CONVERSATION);
            FLogger.a.i("PageTaskInfoComponent", "On change conversation id: " + r5.a);
        }

        public final void a(wc9.e r5, wc9.e r6) {
            Intrinsics.checkNotNullParameter(r6, "new");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("On replace conversation targetId: ");
            String r2 = null;
            if (r5 == null) goto L5;
            String r3 = r5.a;
        L6:
            r1.append(r3);
            r1.append(", newId: ");
            r1.append(r6.a);
            r0.i("PageTaskInfoComponent", r1.toString());
            String r4 = this.a.u;
            if (r4 == null) goto L11;
            Lazy r7 = n.a;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            boolean r8 = true;
            if (j.f(r4) != true) goto L11;
        L12:
            if (r8 == false) goto L22;
            String r9 = this.a.u;
            if (r5 == null) goto L17;
            r2 = r5.a;
        L17:
            if (Intrinsics.areEqual(r9, r2) == false) goto L23;
            this.a.u = r6.a;
            IDocService r10 = (IDocService) ServiceManager.get().getService(IDocService.class);
            if (r10 == null) goto L24;
            r10.P1(r6);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L11:
            r8 = false;
            goto L12
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class d implements Function0<r> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<p> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<g0> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
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

    public static final class g implements Function0<va8.n> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.n.class));
        }
    }

    static {
    }

    public final void A90() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L4
        Result.constructor-impl(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new PageTaskInfoComponent$selectCurrentTextOrParagraph$1$1(null), 3, null));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final r h3() {
        return (r) this.m.getValue();
    }

    public final void hD() {
        FLogger.a.i("PageTaskInfoComponent", "resetSelectedText");
        this.w = "";
        this.x = "";
        IDocSdkBaseService r0 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r0 == null) goto L8;
        l r1 = r0.getPartialRewriteService();
        if (r1 == null) goto L9;
        l.a.a(r1);
        return;
    L9:
        return;
    }

    public final void onDestroy() {
        String r0 = this.v;
        if (r0 == null) goto L6;
        com.larus.im.d.c().unRegisterConversationChangeListener(r0, this.B);
        return;
    }

    public PageTaskInfoComponent() {
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new e(this));
        this.o = LazyKt.lazy(new f(this));
        this.p = LazyKt.lazy(new g(this));
        this.q = "";
        this.r = "default_doc_logic_key";
        this.A = "";
        this.B = new c(this);
        this.C = 2131365588;
    }

    public final int U2() {
        return this.C;
    }

    public static String Y2(List r9) {
        if (((ArrayList) r9).isEmpty() == false) goto L7;
        return "";
    L7:
        return CollectionsKt.joinToString$default(r9, "", null, null, 0, null, new com.larus.doc.impl.chat.component.e(), 30, null);
    }

    public final void A(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void F1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void N0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final void Q(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "answer");
    }

    public final void X2(int r1) {
        this.C = r1;
    }

    public final boolean m3(List<Block> r3) {
        if (r3.isEmpty() == true) goto L15;
        Iterator<T> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L16;
        if ((!((Block) r4.next()).isFinish()) == false) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }

    public final void o9(String r1) {
        this.s = r1;
    }

    public final void onViewCreated(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        p r7 = (p) this.n.getValue();
        if (r7 == null) goto L5;
        r7.hy(this);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        String r2 = null;
        if (r0 == null) goto L8;
        String r1 = r0.getString("key_doc_id", "");
    L9:
        this.q = r1;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        String r4 = "default_doc_logic_key";
        if (r3 == null) goto L15;
        String r5 = r3.getString("key_doc_logic_key", "default_doc_logic_key");
        if (r5 == null) goto L15;
        r4 = r5;
    L15:
        this.r = r4;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r8 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r8 == null) goto L18;
        String r9 = r8.getString("key_artifact_version_id", "");
    L19:
        this.s = r9;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r10 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r10 == null) goto L22;
        String r11 = r10.getString("key_message_id", "");
    L23:
        this.t = r11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r12 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r12 == null) goto L26;
        r2 = r12.getString("argConversationId", "");
    L26:
        this.u = r2;
        if (r2 == null) goto L32;
        FLogger.a.i("PageTaskInfoComponent", "Original conversation id: ".concat(r2));
        Lazy r13 = n.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (j.f(r2) == false) goto L33;
        this.v = r2;
        com.larus.im.d.c().registerConversationChangeListener(r2, this.B);
        return;
    L33:
        return;
    L32:
        return;
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = null;
        goto L19
    L8:
        r1 = null;
        goto L9
    }

    public final void p(Message r25) {
        Intrinsics.checkNotNullParameter(r25, "msg");
        Intrinsics.checkNotNullParameter(r25, "msg");
        if (com.larus.bmhome.chat.bean.d.G0(r25) == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("onUpdateMessage, msgId = ");
        r3.append(r25.getMessageId());
        r3.append(", msgStatus = ");
        r3.append(r25.getMessageStatusLocal());
        r3.append(", pageTaskInfo= ");
        Map r4 = r25.getExt();
        if (r4 == null) goto L8;
        String r5 = (String) r4.get("page_task_info");
    L9:
        r3.append(r5);
        r2.i("PageTaskInfoComponent", r3.toString());
        Message r6 = this.y;
        if (r6 != null) goto L12;
    L21:
        boolean r9 = true;
        if (this.z == false) goto L103;
        if (this.y == null) goto L103;
        StringBuilder r7 = new StringBuilder("msg isVisible = ");
        if (com.larus.bmhome.chat.bean.d.i0(r25) == false) goto L31;
        if (com.larus.bmhome.chat.bean.d.w(r25) == true) goto L31;
    L50:
        boolean r10 = false;
    L51:
        r7.append(r10);
        r7.append(", isDocMessageRollback = ");
        Map r11 = r25.getExt();
        if (r11 == null) goto L54;
        String r12 = (String) r11.get("risk_fake_item");
    L55:
        r7.append(r12);
        r2.i("PageTaskInfoComponent", r7.toString());
        if (com.larus.bmhome.chat.bean.d.i0(r25) == false) goto L61;
        if (com.larus.bmhome.chat.bean.d.w(r25) == true) goto L61;
    L80:
        boolean r8 = false;
    L81:
        if (r8 == false) goto L94;
        Map r13 = r25.getExt();
        if (r13 == null) goto L85;
        String r14 = (String) r13.get("risk_fake_item");
    L87:
        if (Intrinsics.areEqual(r14, "1") == true) goto L94;
        Map r15 = r25.getExt();
        if (r15 == null) goto L91;
        String r16 = (String) r15.get("has_err");
    L93:
        if (Intrinsics.areEqual(r16, "710022008") == false) goto L103;
    L91:
        r16 = null;
        goto L93
    L85:
        r14 = null;
    L94:
        IDocSdkBaseService r1 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r1 == null) goto L97;
        l r17 = r1.getPartialRewriteService();
    L98:
        if (r17 == null) goto L100;
        r17.endStreamEdit(true);
    L100:
        this.z = false;
        this.A = "";
        this.y = null;
        hD();
        return;
    L97:
        r17 = null;
    L61:
        if (com.larus.bmhome.chat.bean.d.T(r25) == true) goto L80;
        if (com.larus.bmhome.chat.bean.d.p0(r25) == true) goto L80;
        if (com.larus.bmhome.chat.bean.d.C0(r25) == true) goto L68;
    L70:
        MessageStatus r18 = r25.getMessageStatus();
        if (r18 != null) goto L73;
    L75:
        boolean r20 = false;
    L76:
        if (r20 == false) goto L78;
    L79:
        r8 = true;
        goto L81
    L78:
        if (b0.f(r25) == false) goto L80;
    L73:
        if (r18.isVisible() != true) goto L75;
        r20 = true;
        goto L76
    L68:
        if (r25.getRegenVisible() == true) goto L70;
    L54:
        r12 = null;
    L31:
        if (com.larus.bmhome.chat.bean.d.T(r25) == true) goto L50;
        if (com.larus.bmhome.chat.bean.d.p0(r25) == true) goto L50;
        if (com.larus.bmhome.chat.bean.d.C0(r25) == true) goto L38;
    L40:
        MessageStatus r110 = r25.getMessageStatus();
        if (r110 != null) goto L43;
    L45:
        boolean r111 = false;
    L46:
        if (r111 == false) goto L48;
    L49:
        r10 = true;
        goto L51
    L48:
        if (b0.f(r25) == false) goto L50;
    L43:
        if (r110.isVisible() != true) goto L45;
        r111 = true;
        goto L46
    L38:
        if (r25.getRegenVisible() == true) goto L40;
    L103:
        if (z2.a.getAiDocDdxmlConfig().a() == true) goto L119;
        ArtifactBlock r21 = com.larus.im.bean.message.a.n(r25);
        if (r21 == null) goto L107;
        String r22 = r21.getResourceId();
    L109:
        if (Intrinsics.areEqual(r22, this.q) == false) goto L119;
        r r23 = h3();
        if (r23 == null) goto L113;
        String r24 = r23.WE();
    L115:
        if (Intrinsics.areEqual(r24, "doc_ai_edit") == true) goto L119;
        g0 r26 = (g0) this.o.getValue();
        if (r26 == null) goto L119;
        r26.km("stream_edit");
        goto L119
    L113:
        r24 = null;
        goto L115
    L107:
        r22 = null;
    L119:
        Map r27 = r25.getExt();
        if (r27 == null) goto L122;
        String r28 = (String) r27.get("page_task_info");
    L124:
        if (o0.d(r28) == false) goto L263;
        Gson r30 = z.a;
        Map r31 = r25.getExt();
        if (r31 == null) goto L128;
        String r32 = (String) r31.get("page_task_info");
    L129:
        PageTaskInfo r33 = (PageTaskInfo) z.a(r32, PageTaskInfo.class);
        StringBuilder r34 = new StringBuilder("onUpdateMessage, curScene = ");
        r r112 = h3();
        if (r112 == null) goto L132;
        String r113 = r112.WE();
    L133:
        r34.append(r113);
        r34.append(", isStreaming = ");
        r34.append(this.z);
        r34.append(", contentType = ");
        r34.append(r25.getContentType());
        r34.append(", actionType = ");
        if (r33 == null) goto L136;
        String r114 = r33.getActionType();
    L137:
        r34.append(r114);
        r34.append(", selectedText = ");
        r34.append(this.w);
        r2.i("PageTaskInfoComponent", r34.toString());
        r r35 = h3();
        if (r35 == null) goto L140;
        String r36 = r35.WE();
    L142:
        if (Intrinsics.areEqual(r36, "doc_ai_edit") == true) goto L148;
        if (this.z == true) goto L148;
        if (o0.d(this.w) == true) goto L148;
    L250:
        if (com.larus.bmhome.chat.bean.d.G0(r25) == false) goto L252;
        return;
    L252:
        if (((ArrayList) com.larus.im.bean.message.a.R(r25)).isEmpty() == false) goto L377;
        if (r33 != null) goto L255;
        return;
    L255:
        if (this.z == false) goto L257;
        return;
    L257:
        if (o0.d(this.w) == false) goto L380;
        this.w = "";
        IDocSdkBaseService r37 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r37 == null) goto L381;
        l r38 = r37.getPartialRewriteService();
        if (r38 == null) goto L382;
        r38.leaveStreamEditMode(0, false);
        return;
    L382:
        return;
    L381:
        return;
    L380:
        return;
    L377:
        return;
    L148:
        if (com.larus.im.bean.message.a.b0(r25) == false) goto L250;
        if (r33 == null) goto L151;
        String r40 = r33.getActionType();
    L153:
        if (Intrinsics.areEqual(r40, "edit") == false) goto L250;
        List r41 = com.larus.im.bean.message.a.m(r25);
        Intrinsics.checkNotNullParameter(r25, "<this>");
        List r42 = vd9.r.a(r25);
        ArrayList r115 = new ArrayList();
        Iterator r116 = r42.iterator();
    L156:
        if (r116.hasNext() == false) goto L171;
        Object r117 = r116.next();
        Block r118 = (Block) r117;
        ArrayList r119 = (ArrayList) r41;
        if (r119.isEmpty() == true) goto L168;
        Iterator r120 = r119.iterator();
    L162:
        if (r120.hasNext() == false) goto L167;
        if (Intrinsics.areEqual(((Block) r120.next()).getBlockId(), r118.getBlockId()) == false) goto L162;
        r9 = false;
        goto L168
    L167:
        r9 = true;
    L168:
        if (r9 == false) goto L170;
        r115.add(r117);
    L170:
        r9 = true;
        goto L156
    L171:
        FLogger r43 = FLogger.a;
        r43.i("PageTaskInfoComponent", "onUpdateMessage, start\n\n allBlockList = " + r42 + " \n\n deepThinkBlockList = " + r41 + " \n\n blockList = " + r115 + " \n\n");
        IDocSdkBaseService r44 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r44 == null) goto L174;
        l r45 = r44.getPartialRewriteService();
    L176:
        if (r115.isEmpty() == false) goto L180;
        r43.i("PageTaskInfoComponent", "onUpdateMessage, blockList isEmpty");
        return;
    L180:
        if (this.z == true) goto L201;
        if (m3(r115) == false) goto L185;
        r43.i("PageTaskInfoComponent", "onUpdateMessage, notStreaming, blockList is finish");
        return;
    L185:
        r43.i("PageTaskInfoComponent", "onUpdateMessage, startStreamEdit");
        if (r45 == null) goto L189;
        r45.startStreamEdit();
    L189:
        if (z2.a.getAiDocDdxmlConfig().a() == true) goto L193;
        g0 r46 = (g0) this.o.getValue();
        if (r46 == null) goto L193;
        r46.km("stream_edit");
    L193:
        va8.n r47 = (va8.n) this.p.getValue();
        if (r47 == null) goto L196;
        r47.hideKeyboard();
    L196:
        this.A = "";
        this.y = null;
        this.z = true;
        IDocSdkBaseService r121 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r121 == null) goto L199;
        r121.setChatInputVisible("PageTaskInfoComponent", true, false, true, this.r);
    L199:
        this.w = "";
        this.x = "";
    L201:
        if (m3(r115) == true) goto L220;
        if (r25.getMessageStatusLocal() == 21) goto L220;
        String r48 = Y2(r115);
        int r50 = r48.length();
        String r51 = this.A;
        if (r51 == null) goto L207;
        int r52 = r51.length();
    L208:
        if (r50 <= r52) goto L213;
        String r53 = this.A;
        if (r53 != null) goto L212;
        r53 = "";
    L212:
        String r54 = StringsKt.removePrefix(r48, r53);
    L214:
        this.A = r48;
        this.y = r25;
        r43.i("PageTaskInfoComponent", "onUpdateMessage, streamEditTextContent \n\n curText = " + r48 + " \n\n newText = " + r54);
        if (r45 == null) goto L250;
        if (r54 != null) goto L218;
        r54 = "";
    L218:
        r45.streamEditTextContent(r54);
        goto L250
    L213:
        r54 = "";
        goto L214
    L207:
        r52 = 0;
    L220:
        if (this.z == false) goto L250;
        if (m3(r115) == false) goto L250;
        r43.i("PageTaskInfoComponent", "onStreamEnd \n\n allBlockList = " + r42 + " \n\n deepThinkBlockList = " + r41 + " \n\n blockList = " + r115 + " \n\n");
        this.z = false;
        String r55 = Y2(r115);
        String r56 = this.A;
        if (r56 != null) goto L226;
    L229:
        boolean r57 = true;
    L230:
        String r58 = r55;
        if (r57 == false) goto L234;
    L236:
        FLogger.a.i("PageTaskInfoComponent", "onStreamEnd, endStreamEdit \n\n curText = " + r55 + " \n\n newText = " + r58);
        IDocSdkBaseService r60 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r60 == null) goto L239;
        l r61 = r60.getPartialRewriteService();
    L240:
        if (r61 == null) goto L244;
        if (r58 != null) goto L243;
        r58 = "";
    L243:
        r61.streamEditTextContent(r58);
    L244:
        if (r61 == null) goto L246;
        r61.endStreamEdit(false);
    L246:
        if (r61 == null) goto L248;
        l.a.a(r61);
    L248:
        this.A = "";
        this.y = null;
        goto L250
    L239:
        r61 = null;
    L234:
        if (StringsKt.startsWith$default(r58, r56, false, 2, null) == false) goto L236;
        r58 = StringsKt.removePrefix(r55, r56);
        goto L234
    L226:
        if (r56.length() == 0) goto L229;
        r57 = false;
        goto L230
    L174:
        r45 = null;
        goto L176
    L151:
        r40 = null;
        goto L153
    L140:
        r36 = null;
        goto L142
    L136:
        r114 = null;
        goto L137
    L132:
        r113 = null;
        goto L133
    L128:
        r32 = null;
        goto L129
    L263:
        this.w = "";
        List r62 = com.larus.im.bean.message.a.m(r25);
        Intrinsics.checkNotNullParameter(r25, "<this>");
        List r63 = vd9.r.a(r25);
        ArrayList r64 = new ArrayList();
        Iterator r65 = r63.iterator();
    L265:
        if (r65.hasNext() == false) goto L278;
        Object r66 = r65.next();
        Block r67 = (Block) r66;
        ArrayList r122 = (ArrayList) r62;
        if (r122.isEmpty() == true) goto L275;
        Iterator r123 = r122.iterator();
    L271:
        if (r123.hasNext() == false) goto L275;
        if (Intrinsics.areEqual(((Block) r123.next()).getBlockId(), r67.getBlockId()) == false) goto L271;
        boolean r68 = false;
    L276:
        if (r68 == false) goto L265;
        r64.add(r66);
    L275:
        r68 = true;
        goto L276
    L278:
        IDocSdkBaseService r70 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r70 == null) goto L281;
        l r71 = r70.getPartialRewriteService();
    L283:
        if (r64.isEmpty() == false) goto L287;
        FLogger.a.i("PageTaskInfoComponent", "onUpdateMessage, blockList isEmpty, ddxml enabled");
        return;
    L287:
        if (m3(r64) == false) goto L290;
        FLogger.a.i("PageTaskInfoComponent", "onUpdateMessage, notStreaming, blockList is finish, ddxml enabled");
        return;
    L290:
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Iterator r72 = vd9.r.a(r25).iterator();
    L292:
        if (r72.hasNext() == false) goto L299;
        Object r73 = r72.next();
        if (((Block) r73).getBlockType() != BlockType.BLOCK_TYPE_ARTIFACT.getValue()) goto L296;
        boolean r74 = true;
    L297:
        if (r74 == false) goto L292;
    L300:
        Block r75 = (Block) r73;
        FLogger r76 = FLogger.a;
        StringBuilder r77 = new StringBuilder("Current scene: ");
        r r78 = h3();
        if (r78 == null) goto L303;
        String r80 = r78.WE();
    L304:
        r77.append(r80);
        r77.append(", hasSelectionBlock: ");
        IDocSdkBaseService r81 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r81 == null) goto L309;
        l r82 = r81.getPartialRewriteService();
        if (r82 == null) goto L309;
        String r83 = r82.getRefBlockInfo();
    L310:
        if (r83 != null) goto L312;
    L315:
        boolean r84 = true;
    L316:
        if (r84 == true) goto L323;
        JSONObject r85 = new JSONObject(r83);
        if (r85.optJSONObject("cursorPosition") == null) goto L321;
    L324:
        boolean r86 = true;
    L325:
        r77.append(r86);
        r77.append(",docBlock: ");
        r77.append(r75);
        r76.i("PageTaskInfoComponent", r77.toString());
        r r87 = h3();
        if (r87 == null) goto L328;
        String r88 = r87.WE();
    L330:
        if (Intrinsics.areEqual(r88, "doc_create_list") == true) goto L384;
        if (r75 == null) goto L337;
        BlockContent r90 = r75.getContent();
        if (r90 == null) goto L337;
        ArtifactBlock r91 = r90.getDocBlock();
        if (r91 == null) goto L337;
        String r92 = r91.getResourceId();
    L339:
        if (Intrinsics.areEqual(r92, this.q) == true) goto L341;
        return;
    L341:
        if (this.z == true) goto L386;
        r76.i("PageTaskInfoComponent", "onUpdateMessage, startStreamEdit");
        this.z = true;
        if (r71 == null) goto L346;
        r71.startStreamEdit();
    L346:
        if (z2.a.getAiDocDdxmlConfig().a() == true) goto L350;
        g0 r93 = (g0) this.o.getValue();
        if (r93 == null) goto L350;
        r93.km("stream_edit");
    L350:
        va8.n r94 = (va8.n) this.p.getValue();
        if (r94 == null) goto L353;
        r94.hideKeyboard();
    L353:
        IDocSdkBaseService r95 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r95 == null) goto L387;
        r95.setChatInputVisible("PageTaskInfoComponent", true, false, true, this.r);
        return;
    L387:
        return;
    L386:
        return;
    L337:
        r92 = null;
        goto L339
    L384:
        return;
    L328:
        r88 = null;
        goto L330
    L321:
        if (r85.optJSONObject("selectedContent") != null) goto L324;
    L323:
        r86 = false;
        goto L325
    L312:
        if (r83.length() == 0) goto L315;
        r84 = false;
    L309:
        r83 = null;
        goto L310
    L303:
        r80 = null;
        goto L304
    L296:
        r74 = false;
        goto L297
    L299:
        r73 = null;
        goto L300
    L281:
        r71 = null;
        goto L283
    L122:
        r28 = null;
        goto L124
    L12:
        if (Intrinsics.areEqual(r6.getMessageId(), r25.getMessageId()) == true) goto L21;
        r2.i("PageTaskInfoComponent", "onUpdateMessage, interruptStreamEdit");
        IDocSdkBaseService r96 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r96 == null) goto L16;
        l r97 = r96.getPartialRewriteService();
    L17:
        if (r97 == null) goto L19;
        r97.endStreamEdit(false);
    L19:
        this.z = false;
        this.A = "";
        this.y = null;
        hD();
        return;
    L16:
        r97 = null;
        goto L17
    L8:
        r5 = null;
        goto L9
    }

    public final void setConversationId(String r1) {
        this.u = r1;
    }

    public final void setResourceId(String r1) {
        this.q = r1;
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

    public final void D7(Map<String, String> r110, String r20) {
        Intrinsics.checkNotNullParameter(r110, "ext");
        r r2 = h3();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.WE();
    L7:
        if (Intrinsics.areEqual(r4, "doc_create_list") == false) goto L10;
        return;
    L10:
        if (r20 != null) goto L12;
    L15:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
    L22:
        FLogger r7 = FLogger.a;
        r7.i("PageTaskInfoComponent", "putMessageExt, curScene = " + r4 + ", selectedText = " + this.w + ", conversationId = " + this.u);
        String r5 = this.u;
        if (r5 != null) goto L25;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L30;
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        r10.put("notify_scene", 1);
        JSONObject r11 = new JSONObject();
        r11.put("message_id", this.t);
        r11.put("resource_id", this.q);
        Unit r12 = Unit.INSTANCE;
        r10.put("param", r11.toString());
        r9.put("sub_scene_notify", r10);
        r110.put("conversation_init_option", r9.toString());
    L30:
        String r13 = this.w;
        if (r13 != null) goto L33;
    L36:
        boolean r14 = true;
    L37:
        if (r14 == false) goto L51;
        IDocSdkBaseService r15 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r15 == null) goto L43;
        l r16 = r15.getPartialRewriteService();
        if (r16 == null) goto L43;
        Pair<String, String> r17 = r16.getSelectedText();
    L44:
        if (r17 == null) goto L46;
        String r18 = (String) r17.getFirst();
    L47:
        this.w = r18;
        if (r17 == null) goto L50;
        r3 = (String) r17.getSecond();
    L50:
        this.x = r3;
        r7.i("PageTaskInfoComponent", "putMessageExt, latest selectedText = " + this.w);
        goto L51
    L46:
        r18 = null;
    L43:
        r17 = null;
    L51:
        String r21 = this.w;
        String r22 = "";
        if (r21 != null) goto L54;
        r21 = "";
    L54:
        r110.put("reference_text", r21);
        String r23 = this.w;
        if (r23 != null) goto L57;
        String r111 = "";
    L58:
        String r24 = this.x;
        if (r24 != null) goto L61;
        String r112 = "";
    L62:
        String r25 = HttpExtKt.p(new PageTaskInfo(null, r111, r112, null, this.q, 8, null));
        if (r25 == null) goto L66;
        r22 = r25;
    L66:
        r110.put("page_task_info", r22);
        if (z2.a.getAiDocDdxmlConfig().a() == true) goto L69;
        return;
    L69:
        if (o0.d(this.q) == false) goto L94;
        JSONObject r26 = new JSONObject();
        JSONObject r27 = new JSONObject();
        r26.put("action", 1);
        if (o0.d(this.s) == false) goto L73;
        r27.put("artifact_key", this.s);
    L73:
        r27.put("page_token", this.q);
        r27.put("resource_type", 3);
        IDocSdkBaseService r28 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r28 == null) goto L91;
        l r30 = r28.getPartialRewriteService();
        if (r30 == null) goto L91;
        String r31 = r30.getRefBlockInfo();
        if (r31 == null) goto L91;
        JSONObject r32 = new JSONObject(r31);
        if (r32.optInt("type", 0) == 0) goto L83;
        r27.put("type", r32.optInt("type", 0));
    L83:
        if (r32.optJSONObject("cursorPosition") == null) goto L86;
        r27.put("cursor_position", r32.optJSONObject("cursorPosition"));
    L86:
        if (r32.optJSONObject("selectedContent") == null) goto L89;
        r27.put("selected_content", r32.optJSONObject("selectedContent"));
    L89:
        if (r32.optInt("docStructureVersion", -1) == (-1)) goto L91;
        r27.put("doc_structure_version", r32.optInt("docStructureVersion", -1));
    L91:
        r26.put("content_context", r27);
        r110.put("doc_ref_block_info", r26.toString());
        r7.i("PageTaskInfoComponent", "Ref block info: " + r26);
        return;
    L94:
        return;
    L61:
        r112 = r24;
        goto L62
    L57:
        r111 = r23;
        goto L58
    L33:
        if (r13.length() == 0) goto L36;
        r14 = false;
        goto L37
    L25:
        if (n.s(r5) != true) goto L27;
        r8 = true;
        goto L28
    L19:
        if (r110.containsKey("page_task_info") == false) goto L22;
        FLogger.a.i("PageTaskInfoComponent", "putMessageExt, already exist");
        return;
    L12:
        if (r20.length() == 0) goto L15;
        r6 = false;
        goto L17
    L5:
        r4 = null;
        goto L7
    }
}
