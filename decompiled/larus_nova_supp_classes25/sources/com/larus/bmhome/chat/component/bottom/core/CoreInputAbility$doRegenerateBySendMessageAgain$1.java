package com.larus.bmhome.chat.component.bottom.core;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ko8.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.CoreInputAbility$doRegenerateBySendMessageAgain$1", f = "CoreInputAbility.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {4154, 4174}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "content", "resourceMentionExt", "attachmentInfo", "msg", "hasResourceMention"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$6", "Z$0"})
final class CoreInputAbility$doRegenerateBySendMessageAgain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MultiAttachmentInfo $explicitMultiAttachment;
    final /* synthetic */ NestedFileContent $nestedFileContent;
    final /* synthetic */ AttachmentInfo $rebindAttachment;
    final /* synthetic */ long $sendClickTimestamp;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    final /* synthetic */ CoreInputAbility<ComponentFeature> this$0;

    public CoreInputAbility$doRegenerateBySendMessageAgain$1(CoreInputAbility<ComponentFeature> r1, NestedFileContent r2, AttachmentInfo r3, MultiAttachmentInfo r4, long r5, Continuation<? super CoreInputAbility$doRegenerateBySendMessageAgain$1> r7) {
        this.this$0 = r1;
        this.$nestedFileContent = r2;
        this.$rebindAttachment = r3;
        this.$explicitMultiAttachment = r4;
        this.$sendClickTimestamp = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CoreInputAbility$doRegenerateBySendMessageAgain$1 r8 = new CoreInputAbility$doRegenerateBySendMessageAgain$1(this.this$0, this.$nestedFileContent, this.$rebindAttachment, this.$explicitMultiAttachment, this.$sendClickTimestamp, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r61) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        long r3 = this.J$0;
        boolean r5 = this.Z$0;
        Message r8 = (Message) this.L$6;
        CoreInputAbility<ComponentFeature> r9 = (CoreInputAbility) this.L$5;
        AttachmentInfo r10 = (AttachmentInfo) this.L$4;
        Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$3;
        Map r12 = (Map) this.L$2;
        String r13 = (String) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r61);
        long r37 = r3;
        boolean r39 = r5;
        Object r4 = r61;
    L43:
        List r6 = (List) r4;
        Iterator r7 = r6.iterator();
    L44:
        Image r15 = null;
        if (r7.hasNext() == false) goto L52;
        Object r16 = r7.next();
        if (((Message) r16).getContentType() != 6) goto L49;
        boolean r17 = true;
    L50:
        if (r17 == false) goto L44;
    L53:
        Message r18 = (Message) r16;
        if (r18 != null) goto L56;
        Iterator r19 = r6.iterator();
    L82:
        if (r19.hasNext() == false) goto L86;
        Object r20 = r19.next();
        if (lr8.c.a((Message) r20) == false) goto L82;
    L87:
        Message r21 = (Message) r20;
        ArrayList r22 = new ArrayList();
        if (r21 == null) goto L103;
        NestedFileContent r26 = com.larus.bmhome.chat.bean.d.f(r21);
        int r23 = wf9.b.a;
        String r27 = com.flow.kmp.common.util.i.a();
        ReferenceInfo r29 = com.larus.bmhome.chat.bean.d.b1(r8);
        String r24 = CoreInputAbility.U;
        r22.add(new ai8.f(r26, r27, null, r29, r12, null, false, null, r9.r(null), null, 740));
        if (com.larus.utils.o0.d(r13) == false) goto L92;
        r22.add(new ai8.h(r13, com.flow.kmp.common.util.i.a(), null, com.larus.bmhome.chat.bean.d.b1(r8), r12, null, false, false, r9.r(null), null, 740));
    L92:
        gd8.g r25 = r9.A().h2();
        if (r25 == null) goto L95;
        gd8.g.a.a(r25, r9.h(), "edit", r22, "edit", null, Boxing.boxLong(r37), 16);
    L95:
        ICoreInputAbility.b.a(r9, 3);
        if (r9.f.Mb() == false) goto L98;
        String r28 = r6;
    L99:
        LruCache r30 = a.a;
        IAIChatControlTraceService.Companion r31 = IAIChatControlTraceService.a;
        com.larus.bmhome.chat.trace.m r32 = r31.getTraceInfo();
        r32.getClass();
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r32.b = r28;
        Object r33 = r9.f.ni();
        if ((r33 instanceof String) == false) goto L102;
        r15 = (String) r33;
    L102:
        r31.Fa(r8, r15, de8.d.a(r9.A().f1()));
    L104:
        CoreInputAbility<ComponentFeature> r34 = this.this$0;
        String r35 = CoreInputAbility.U;
        com.larus.bmhome.chat.component.list.u7 r36 = r34.A().u3();
        if (r36 == null) goto L108;
        r36.TP(false);
    L108:
        return Unit.INSTANCE;
    L98:
        r28 = r9.f.u7();
        goto L99
    L103:
        CoreInputAbility.t(r9, r13, false, null, null, "edit", com.larus.bmhome.chat.bean.d.b1(r8), null, null, null, null, false, r37, r39, 1992);
        ICoreInputAbility.b.a(r9, 3);
        goto L104
    L86:
        r20 = null;
        goto L87
    L56:
        if (r18.getContentType() != 6) goto L71;
        List r38 = com.larus.bmhome.chat.bean.d.g(r18).imageList;
        if (r38 == null) goto L60;
        r15 = (Image) CollectionsKt.firstOrNull(r38);
    L60:
        if (r15 == null) goto L71;
        String r40 = r15.key;
        if (r40 != null) goto L64;
        String r42 = "";
    L65:
        String r41 = r15.localResPath;
        if (r41 != null) goto L68;
        String r45 = r6;
    L69:
        r11.element = new AttachmentInfo(true, r42, null, null, r45, "", "edit", null, null, null, null, null, null, null, null, null, null, 130956, null);
        goto L71
    L68:
        r45 = r41;
        goto L69
    L64:
        r42 = r40;
    L71:
        if (r11.element != null) goto L79;
        String r43 = CoreInputAbility.U;
        com.larus.bmhome.instruction.g r44 = r9.A().vc();
        if (r44 == null) goto L78;
        AttachmentInfo r46 = r44.n4();
        if (r46 == null) goto L78;
        r10 = r46;
    L78:
        r11.element = r10;
    L79:
        CoreInputAbility.t(r9, r13, false, (AttachmentInfo) r11.element, null, "edit", com.larus.bmhome.chat.bean.d.b1(r8), null, null, null, null, false, r37, r39, 1992);
        ICoreInputAbility.b.a(r9, 3);
        goto L104
    L49:
        r17 = false;
        goto L50
    L52:
        r16 = null;
        goto L53
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r47 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r61);
        Object r48 = r61;
    L13:
        String r49 = (String) r48;
        if (r49 != null) goto L16;
        String r110 = "";
    L17:
        boolean r50 = this.this$0.f.yP();
        if (r50 == false) goto L20;
        Map r51 = MapsKt.mapOf(TuplesKt.to("resourcemention", "1"));
    L21:
        r12 = r51;
        r11 = new Ref.ObjectRef();
        Message r52 = this.this$0.F().getState().getModifyingMessage();
        if (r52 == null) goto L104;
        NestedFileContent r111 = this.$nestedFileContent;
        AttachmentInfo r112 = this.$rebindAttachment;
        CoreInputAbility<ComponentFeature> r113 = this.this$0;
        MultiAttachmentInfo r53 = this.$explicitMultiAttachment;
        long r54 = this.$sendClickTimestamp;
        if (r111 == null) goto L33;
        if (r112 != null) goto L33;
        Integer r114 = com.larus.platform.service.z2.a.attachmentEditConfig().getReeditWithAttachment();
        if (r114 == null) goto L33;
        if (r114.intValue() != 1) goto L33;
        CoreInputAbility.t(r113, r110, false, null, null, "edit", com.larus.bmhome.chat.bean.d.b1(r52), null, r53, null, null, false, r54, r50, 1868);
        ICoreInputAbility.b.a(r113, 3);
    L33:
        if (r110.length() != 0) goto L35;
        boolean r115 = true;
    L36:
        if (r115 == true) goto L38;
        IChatRepoService r116 = RepoDispatcherDelegate.b.e();
        this.L$0 = r47;
        this.L$1 = r110;
        this.L$2 = r12;
        this.L$3 = r11;
        this.L$4 = r112;
        this.L$5 = r113;
        this.L$6 = r52;
        this.Z$0 = r50;
        this.J$0 = r54;
        this.label = 2;
        r4 = r116.s1(r52, this);
        if (r4 != r1) goto L42;
        return r1;
    L42:
        r37 = r54;
        r39 = r50;
        r8 = r52;
        r13 = r110;
        r10 = r112;
        r9 = r113;
        goto L43
    L38:
        return Unit.INSTANCE;
    L35:
        r115 = false;
        goto L36
    L20:
        r51 = MapsKt.emptyMap();
        goto L21
    L16:
        r110 = r49;
        goto L17
    L10:
        ResultKt.throwOnFailure(r61);
        r47 = (CoroutineScope) this.L$0;
        a9 r55 = this.this$0.f;
        this.L$0 = r47;
        this.label = 1;
        r48 = r55.KD(this);
        if (r48 != r1) goto L13;
        return r1;
    }
}
