package com.larus.bmhome.chat.component.bottom.core;

import androidx.collection.LruCache;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.c4;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import ko8.a;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b1 implements Function5 {
    public final /* synthetic */ CoreInputAbility a;

    public /* synthetic */ b1(CoreInputAbility r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r2v20, types: [com.larus.bmhome.chat.component.bottom.core.t1] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.bmhome.chat.component.bottom.core.s1] */
    public final Object invoke(Object r63, Object r64, Object r65, Object r66, Object r67) {
        final CoreInputAbility r10 = this.a;
        final MessageModifyMode r5 = (MessageModifyMode) r63;
        String r1 = (String) r64;
        final AttachmentInfo r6 = (AttachmentInfo) r65;
        final NestedFileContent r11 = (NestedFileContent) r66;
        final String r12 = (String) r67;
        Intrinsics.checkNotNullParameter(r1, "content");
        long r7 = System.currentTimeMillis();
        boolean r13 = true;
        String r15 = null;
        if (r5 != MessageModifyMode.MODIFY_TO_REGENERATE) goto L35;
        FLogger.a.i("CoreInputAbility", "doSendMessage to complete modify when is MODIFY_TO_REGENERATE");
        if (r10.f.Mb() == true) goto L147;
        if (r1.length() != 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        if (r11 != null) goto L14;
        ICoreInputAbility.b.a(r10, 3);
    L14:
        if (r12 == null) goto L32;
        if (r11 != null) goto L17;
    L19:
        r13 = false;
    L20:
        if (r13 == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L32;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r3 = r10.A().f70();
        if (r3 == null) goto L27;
        String r4 = r3.ZO();
    L28:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r8 = r10.A().f70();
        if (r8 == null) goto L31;
        r15 = r8.aj();
    L31:
        MultiAttachmentInfo r9 = new MultiAttachmentInfo(r12, r4, r15);
    L33:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10.g), null, null, new CoreInputAbility$doRegenerateBySendMessageAgain$1(r10, r11, r6, r9, r7, null), 3, null);
        goto L147
    L27:
        r4 = null;
        goto L28
    L17:
        if ((!StringsKt.isBlank(r12)) == false) goto L19;
    L32:
        r9 = null;
        goto L33
    L10:
        r2 = false;
    L147:
        return Unit.INSTANCE;
    L35:
        final Long r16 = Long.valueOf(r7);
        com.larus.bmhome.instruction.g r14 = r10.A().vc();
        if (r14 != null) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == true) goto L43;
        String r18 = StringsKt.trim(r1).toString();
    L56:
        final String r19 = r18;
    L57:
        com.larus.bmhome.chat.component.list.u7 r20 = r10.A().u3();
        if (r20 == null) goto L146;
        MessageAdapter r21 = r20.MF();
        if (r21 == null) goto L146;
        Message r110 = r21.I2();
        if (r110 == null) goto L146;
        ILegacyChatUiServiceDelegate r22 = ILegacyChatUiServiceDelegate.b;
        com.larus.bmhome.chat.component.list.u7 r23 = r10.A().u3();
        if (r23 == null) goto L67;
        MessageAdapter r24 = r23.MF();
    L68:
        boolean r25 = r22.C8(r24);
        Map r26 = r110.getExt();
        if (r26 == null) goto L79;
        Map r27 = MapsKt.toMutableMap(r26);
        if (r27 == null) goto L79;
        if (r25 == false) goto L75;
        r22.stopRecording();
    L77:
        String r28 = "1";
    L78:
        r27.put("record_status", r28);
    L80:
        if (r27 == null) goto L82;
        String r29 = (String) r27.remove("audio_data_tos_uri");
    L82:
        if (r27 == null) goto L85;
        String r30 = (String) r27.remove("audio_event_resp");
    L85:
        if (r10.f.yP() == false) goto L87;
        Map r31 = MapsKt.mapOf(TuplesKt.to("resourcemention", "1"));
    L88:
        Map r32 = r31;
        if ((!r32.isEmpty()) == false) goto L93;
        if (r27 != null) goto L92;
        r27 = new LinkedHashMap();
    L92:
        r27.putAll(r32);
    L93:
        final Message r33 = Message.copy$default(r110, null, null, null, 0, 0, null, 0, false, null, null, null, null, null, r27, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8193, 31, null);
        FLogger.a.i("CoreInputAbility", "onModifySend modifyMessage status:" + r33.getMessageStatusLocal());
        if (ArraysKt.contains(new Integer[]{10, 12}, Integer.valueOf(r33.getMessageStatusLocal())) == false) goto L102;
        LifecycleOwner r34 = (LifecycleOwner) r10.g.getViewLifecycleOwnerLiveData().getValue();
        if (r34 == null) goto L101;
        LifecycleCoroutineScope r111 = LifecycleOwnerKt.getLifecycleScope(r34);
        if (r111 == null) goto L101;
        BuildersKt.launch$default(r111, null, null, new CoreInputAbility$modifySendMessage$2(r10, r33, r19, r32, r16, null), 3, null);
    L101:
        Message r112 = r33;
        int r113 = 3;
    L125:
        if (r11 == null) goto L136;
        if (r12 != null) goto L128;
    L131:
        boolean r35 = true;
    L132:
        if (r35 == true) goto L136;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r36 = r10.A().f70();
        if (r36 == null) goto L136;
        r36.W0();
        goto L136
    L128:
        if (r12.length() == 0) goto L131;
        r35 = false;
    L136:
        ICoreInputAbility.b.a(r10, r113);
        if (r10.f.Mb() == false) goto L139;
        String r37 = "";
    L140:
        LruCache r38 = a.a;
        IAIChatControlTraceService.Companion r39 = IAIChatControlTraceService.a;
        com.larus.bmhome.chat.trace.m r40 = r39.getTraceInfo();
        r40.getClass();
        Intrinsics.checkNotNullParameter(r37, "<set-?>");
        r40.b = r37;
        Object r41 = r10.f.ni();
        if ((r41 instanceof String) == false) goto L143;
        String r114 = (String) r41;
    L144:
        r39.Fa(r112, r114, de8.d.a(r10.A().f1()));
        goto L146
    L143:
        r114 = null;
        goto L144
    L139:
        r37 = r10.f.u7();
        goto L140
    L102:
        com.larus.bmhome.instruction.g r42 = r10.A().vc();
        if (r42 != null) goto L105;
    L107:
        boolean r43 = false;
    L108:
        if (r43 == false) goto L119;
        com.larus.bmhome.instruction.g r44 = r10.A().vc();
        if (r44 == null) goto L116;
        String r45 = r44.Qh(null);
        if (r45 == null) goto L116;
        if (TypeIntrinsics.isMutableMap(r33.getExt()) == false) goto L116;
        Map r46 = r33.getExt();
        Intrinsics.checkNotNull(r46, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
        TypeIntrinsics.asMutableMap(r46).put(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION, r45);
    L116:
        com.larus.bmhome.instruction.g r47 = r10.A().vc();
        if (r47 == null) goto L119;
        r47.PL(r33.getExt());
    L119:
        r112 = r33;
        r113 = 3;
        final ?? r48 = new s1(r10, r33, r19, r5, r6, r11, r12, r16);
        if (r10.w() == true) goto L122;
    L124:
        Unit r49 = (Unit) r48.invoke();
        goto L125
    L122:
        if (c4.a(r10.g) == true) goto L124;
        r10.f.ct(new t1(r48));
        goto L125
    L105:
        if (r42.z0() != true) goto L107;
        r43 = true;
        goto L108
    L87:
        r31 = MapsKt.emptyMap();
        goto L88
    L75:
        if (r22.isRecording() == false) goto L77;
        r28 = "2";
    L79:
        r27 = null;
        goto L80
    L67:
        r24 = null;
    L146:
        return Unit.INSTANCE;
    L43:
        if (StringsKt.trim(r1).toString().length() != 0) goto L45;
        boolean r50 = true;
    L46:
        if (r50 == false) goto L48;
        ICoreInputAbility.b.a(r10, 3);
        goto L146
    L48:
        com.larus.bmhome.instruction.g r51 = r10.A().vc();
        if (r51 == null) goto L54;
        String r52 = r51.kb(StringsKt.trim(r1).toString());
        if (r52 == null) goto L54;
        r19 = r52;
    L54:
        r18 = StringsKt.trim(r1).toString();
        goto L56
    L45:
        r50 = false;
        goto L46
    L38:
        if (r14.z0() != true) goto L40;
        r17 = true;
        goto L41
    }
}
