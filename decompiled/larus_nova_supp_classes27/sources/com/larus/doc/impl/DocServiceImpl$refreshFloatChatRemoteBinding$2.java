package com.larus.doc.impl;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.doc.impl.chat.data.DocArtifactInfo;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$refreshFloatChatRemoteBinding$2", f = "DocServiceImpl.kt", i = {0, 0, 1, 1}, l = {438, 443}, m = "invokeSuspend", n = {"docChatFragment", "remoteConvId", "docChatFragment", "remoteConvId"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class DocServiceImpl$refreshFloatChatRemoteBinding$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ String $docId;
    final /* synthetic */ int $resourceType;
    Object L$0;
    Object L$1;
    int label;

    public DocServiceImpl$refreshFloatChatRemoteBinding$2(Bundle r1, String r2, int r3, Continuation<? super DocServiceImpl$refreshFloatChatRemoteBinding$2> r4) {
        this.$bundle = r1;
        this.$docId = r2;
        this.$resourceType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DocServiceImpl$refreshFloatChatRemoteBinding$2(this.$bundle, this.$docId, this.$resourceType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r4 = "";
        String r6 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        String r3 = (String) this.L$1;
        Fragment r5 = (Fragment) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r7 = r17;
    L173:
        List r8 = (List) r7;
        if (r8 == null) goto L176;
        r6 = (String) CollectionsKt.firstOrNull(r8);
    L178:
        if (r5 == null) goto L189;
        t1a.b r9 = s1a.a.g(r5);
        if (r9 == null) goto L189;
        com.larus.bmhome.chat.component.cvs.y r10 = r9.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r10 == null) goto L189;
        if (r3 != null) goto L185;
        String r11 = "";
    L186:
        if (r6 != null) goto L188;
        r6 = "";
    L188:
        r10.updateConversationId(r11, r6);
        goto L189
    L185:
        r11 = r3;
    L189:
        if (r5 == null) goto L195;
        t1a.b r12 = s1a.a.g(r5);
        if (r12 == null) goto L195;
        va8.l0 r13 = r12.getAbility(va8.l0.class);
        if (r13 == null) goto L195;
        r13.setConversationId(r3);
    L195:
        if (r5 == null) goto L201;
        t1a.b r14 = s1a.a.g(r5);
        if (r14 == null) goto L201;
        va8.g0 r15 = r14.getAbility(va8.g0.class);
        if (r15 == null) goto L201;
        r15.setConversationId(r3);
    L201:
        String r16 = r3;
    L202:
        IDocSdkBaseService r18 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r18 == null) goto L209;
        if (r16 == null) goto L207;
        r4 = r16;
    L207:
        r18.setConversationId(r4);
    L209:
        return Unit.INSTANCE;
    L176:
        Fragment r20 = r5;
        r16 = r3;
    L177:
        r3 = r16;
        r5 = r20;
        goto L178
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r16 = (String) this.L$1;
        r20 = (Fragment) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r21 = r17;
    L159:
        wc9.e r22 = (wc9.e) r21;
        if (r22 == null) goto L202;
        Fragment r23 = com.larus.doc.impl.chat.a.b();
        if (r23 == null) goto L168;
        t1a.b r24 = s1a.a.g(r23);
        if (r24 == null) goto L168;
        j39.a r25 = (j39.a) r24.getAbility(j39.a.class);
        if (r25 == null) goto L168;
        r25.P1(r22);
    L168:
        if (r16 == null) goto L177;
        this.L$0 = r20;
        this.L$1 = r16;
        this.label = 2;
        r7 = ic8.n.b(r16, this);
        if (r7 != r1) goto L172;
        return r1;
    L172:
        r3 = r16;
        r5 = r20;
        goto L173
    L10:
        ResultKt.throwOnFailure(r17);
        Fragment r26 = com.larus.doc.impl.chat.a.a();
        if (r26 == null) goto L15;
        t1a.b r27 = s1a.a.g(r26);
        if (r27 == null) goto L15;
        g39.a r28 = (g39.a) r27.getAbility(g39.a.class);
    L16:
        if (r28 == null) goto L18;
        DocArtifactInfo r30 = r28.X4();
    L19:
        String r31 = this.$bundle.getString("argConversationId", null);
        if (r31 != null) goto L22;
    L29:
        if (r26 == null) goto L40;
        Bundle r32 = r26.getArguments();
        if (r32 == null) goto L40;
        r31 = r32.getString("argConversationId", null);
        if (r31 == null) goto L40;
        if (r31.length() <= 0) goto L37;
        boolean r110 = true;
    L38:
        if (r110 == false) goto L40;
    L41:
        String r111 = this.$bundle.getString("artifact_meta_id", null);
        if (r111 != null) goto L44;
    L51:
        if (r30 == null) goto L62;
        String r33 = r30.getArtifactMetaId();
        if (r33 == null) goto L62;
        if (r33.length() <= 0) goto L57;
        boolean r112 = true;
    L58:
        if (r112 == true) goto L61;
        r33 = null;
    L61:
        r111 = r33;
    L63:
        if (r111 != null) goto L76;
        if (r26 == null) goto L75;
        Bundle r34 = r26.getArguments();
        if (r34 == null) goto L75;
        r111 = r34.getString("artifact_meta_id", null);
        if (r111 == null) goto L75;
        if (r111.length() <= 0) goto L72;
        boolean r35 = true;
    L73:
        if (r35 == false) goto L75;
    L72:
        r35 = false;
    L75:
        r111 = null;
    L76:
        String r36 = this.$bundle.getString("key_artifact_version_id", null);
        if (r36 != null) goto L79;
    L86:
        if (r26 == null) goto L97;
        Bundle r37 = r26.getArguments();
        if (r37 == null) goto L97;
        r36 = r37.getString("key_artifact_version_id", null);
        if (r36 == null) goto L97;
        if (r36.length() <= 0) goto L94;
        boolean r113 = true;
    L95:
        if (r113 == false) goto L97;
    L98:
        String r114 = this.$bundle.getString("key_message_id", null);
        if (r114 != null) goto L101;
    L106:
        r114 = null;
    L107:
        if (r26 == null) goto L119;
        Bundle r115 = r26.getArguments();
        if (r115 == null) goto L119;
        r115.putString("key_doc_id", this.$docId);
        if (com.larus.utils.o0.d(r31) == false) goto L114;
        r115.putString("argConversationId", r31);
    L114:
        if (com.larus.utils.o0.d(r111) == false) goto L117;
        r115.putString("artifact_meta_id", r111);
    L117:
        if (com.larus.utils.o0.d(r36) == false) goto L119;
        r115.putString("key_artifact_version_id", r36);
    L119:
        if (r26 == null) goto L125;
        t1a.b r38 = s1a.a.g(r26);
        if (r38 == null) goto L125;
        va8.l0 r40 = r38.getAbility(va8.l0.class);
        if (r40 == null) goto L125;
        r40.setResourceId(this.$docId);
    L125:
        if (r28 == null) goto L128;
        r28.aT(new DocArtifactInfo(r111, this.$docId, this.$resourceType));
    L128:
        if (com.larus.utils.o0.d(r111) == false) goto L136;
        IDocSdkBaseService r41 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r41 == null) goto L136;
        if (r111 != null) goto L133;
        String r42 = "";
    L134:
        r41.setArtifactMetaId(r42);
        goto L136
    L133:
        r42 = r111;
    L136:
        if (com.larus.utils.o0.d(r36) == false) goto L146;
        if (r26 == null) goto L146;
        t1a.b r43 = s1a.a.g(r26);
        if (r43 == null) goto L146;
        va8.l0 r44 = r43.getAbility(va8.l0.class);
        if (r44 == null) goto L146;
        if (r36 != null) goto L144;
        String r45 = "";
    L145:
        r44.o9(r45);
        goto L146
    L144:
        r45 = r36;
    L146:
        Fragment r46 = com.larus.doc.impl.chat.a.b();
        if (r46 == null) goto L154;
        t1a.b r47 = s1a.a.g(r46);
        if (r47 == null) goto L154;
        g39.a r48 = r47.getAbility(g39.a.class);
        if (r48 == null) goto L154;
        r48.F8(r111, r36, r31, r114);
    L154:
        if (com.larus.utils.o0.d(r31) == false) goto L209;
        CoroutineDispatcher r50 = Dispatchers.getIO();
        DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1 r51 = new DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1(r31, null);
        this.L$0 = r26;
        this.L$1 = r31;
        this.label = 1;
        r21 = BuildersKt.withContext(r50, r51, this);
        if (r21 != r1) goto L158;
        return r1;
    L158:
        r20 = r26;
        r16 = r31;
        goto L159
    L101:
        if (r114.length() <= 0) goto L103;
        boolean r116 = true;
    L104:
        if (r116 == false) goto L106;
    L103:
        r116 = false;
        goto L104
    L94:
        r113 = false;
    L97:
        r36 = null;
        goto L98
    L79:
        if (r36.length() <= 0) goto L81;
        boolean r117 = true;
    L82:
        if (r117 == true) goto L85;
        r36 = null;
    L85:
        if (r36 != null) goto L98;
    L81:
        r117 = false;
        goto L82
    L57:
        r112 = false;
    L62:
        r111 = null;
        goto L63
    L44:
        if (r111.length() <= 0) goto L46;
        boolean r118 = true;
    L47:
        if (r118 == true) goto L50;
        r111 = null;
    L50:
        if (r111 != null) goto L76;
    L46:
        r118 = false;
        goto L47
    L37:
        r110 = false;
    L40:
        r31 = null;
        goto L41
    L22:
        if (r31.length() <= 0) goto L24;
        boolean r119 = true;
    L25:
        if (r119 == true) goto L28;
        r31 = null;
    L28:
        if (r31 != null) goto L41;
    L24:
        r119 = false;
        goto L25
    L18:
        r30 = null;
    L15:
        r28 = null;
        goto L16
    }
}
