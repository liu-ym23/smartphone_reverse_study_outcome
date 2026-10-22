package com.larus.doc.sdk.impl.v2.plugins.state;

import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.KeyBoardUtils;
import com.larus.doc.sdk.api.model.DocMode;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.doc.sdk.impl.v2.plugins.rewrite.PartialRewritePluginV2;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "docMode", "Lcom/larus/doc/sdk/api/model/DocMode;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.sdk.impl.v2.plugins.state.DocStatePluginV2$onAttachToUIContainer$1$1", f = "DocStatePluginV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocStatePluginV2$onAttachToUIContainer$1$1 extends SuspendLambda implements Function2<DocMode, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonPluginHost $host;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DocStatePluginV2 this$0;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DocMode.values().length];
            r0[DocMode.READ_ONLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DocMode.NORMAL_EDIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DocMode.AI_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DocStatePluginV2$onAttachToUIContainer$1$1(ChameleonPluginHost r1, DocStatePluginV2 r2, Continuation<? super DocStatePluginV2$onAttachToUIContainer$1$1> r3) {
        this.$host = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DocStatePluginV2$onAttachToUIContainer$1$1 r0 = new DocStatePluginV2$onAttachToUIContainer$1$1(this.$host, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(DocMode r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DocMode) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r7);
        DocMode r8 = (DocMode) this.L$0;
        PartialRewritePluginV2 r0 = this.$host.findPlugin(PartialRewritePluginV2.class);
        if (r0 == null) goto L7;
        r0.setCurrentDocMode(r8);
    L7:
        int r1 = WhenMappings.$EnumSwitchMapping$0[r8.ordinal()];
        if (r1 != 1) goto L10;
        FLogger.a.i("CML_TAG_AbsChameleonPlugin", "switchToReadOnlyMode");
        n39.c.a.a(DocStatePluginV2.access$getChatService(this.this$0), "CML_TAG_AbsChameleonPlugin", true, false, 12);
    L18:
        String r2 = x.a(this.$host);
        if (r2 != null) goto L21;
        r2 = "";
    L21:
        ServiceManager.INSTANCE.getDocModeService(r2).onDocModeChanged(r8);
        return Unit.INSTANCE;
    L10:
        if (r1 != 2) goto L12;
        FLogger.a.i("CML_TAG_AbsChameleonPlugin", "switchToNormalEditMode");
        KeyBoardUtils.showKeyboard(this.$host.getWeb().getWebView());
        n39.c.a.a(DocStatePluginV2.access$getChatService(this.this$0), "CML_TAG_AbsChameleonPlugin", false, false, 12);
        goto L18
    L12:
        if (r1 != 3) goto L15;
        FLogger.a.i("CML_TAG_AbsChameleonPlugin", "switchToAiEditMode");
        DocStatePluginV2.access$getChatService(this.this$0).setToAiEdit();
        DocStatePluginV2.access$getChatService(this.this$0).selectCurrentSentenceOrParagraph();
        n39.c.a.a(DocStatePluginV2.access$getChatService(this.this$0), "CML_TAG_AbsChameleonPlugin", true, true, 8);
        goto L18
    L15:
        throw new NoWhenBranchMatchedException();
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
