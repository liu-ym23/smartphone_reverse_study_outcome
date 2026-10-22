package com.ss.android.lark.compose.chat_member_list;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.RequestTagTypeEnum;
import com.lark.kmp.pb.basic.v1.ResponseTagTypeEnum;
import com.lark.kmp.pb.basic.v1.StatusEffectiveInterval;
import com.lark.kmp.pb.basic.v1.TagData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatMemberStatusTag_androidKt {
    public static final a b(Chatter r11) {
        Intrinsics.checkNotNullParameter(r11, "chatter");
        long r0 = cac.b.a.a.a(30000) / 1000;
        List r2 = r11.getStatus();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        List r3 = r2;
        boolean r4 = true;
        if ((r3 instanceof Collection) == true) goto L8;
    L10:
        Iterator r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L9;
        Chatter.ChatterCustomStatus r6 = (Chatter.ChatterCustomStatus) r5.next();
        StatusEffectiveInterval r7 = r6.getEffective_interval();
        if (r7 != null) goto L16;
    L15:
        boolean r8 = false;
    L30:
        if (r8 == false) goto L12;
        boolean r1 = true;
    L32:
        TagData r9 = r11.getTag_info();
        ResponseTagTypeEnum r10 = null;
        if (r9 == null) goto L50;
        List r12 = r9.getTag_data_items();
        if (r12 == null) goto L50;
        Iterator r13 = r12.iterator();
    L38:
        if (r13.hasNext() == false) goto L45;
        Object r14 = r13.next();
        if (((TagData.TagDataItem) r14).getReq_tag_type() != RequestTagTypeEnum.RELATION_TAG) goto L42;
        boolean r15 = true;
    L43:
        if (r15 == false) goto L38;
    L46:
        TagData.TagDataItem r16 = (TagData.TagDataItem) r14;
        if (r16 == null) goto L50;
        r10 = r16.getResp_tag_type();
        goto L50
    L42:
        r15 = false;
        goto L43
    L45:
        r14 = null;
    L50:
        if (r10 != ResponseTagTypeEnum.RELATION_TAG_EXTERNAL) goto L52;
        boolean r17 = true;
    L54:
        if (r11.getType() != Chatter.Type.BOT) goto L56;
    L59:
        boolean r18 = true;
    L60:
        Boolean r19 = r11.is_frozen();
        Boolean r20 = Boolean.TRUE;
        boolean r21 = Intrinsics.areEqual(r19, r20);
        if (r18 == false) goto L63;
    L65:
        r4 = false;
    L67:
        return new a(r1, r17, r21, r4);
    L63:
        if (Intrinsics.areEqual(r11.is_resigned(), r20) == false) goto L65;
    L56:
        if (r11.getType() == Chatter.Type.AI) goto L59;
        r18 = false;
        goto L60
    L52:
        r17 = false;
        goto L54
    L16:
        Long r22 = r7.getStart_time();
        if (r22 == null) goto L15;
        long r23 = r22.longValue();
        Long r24 = r7.getEnd_time();
        if (r24 == null) goto L15;
        long r25 = r24.longValue();
        if (Intrinsics.areEqual(r6.getIcon_key(), "GeneralVacation") == false) goto L15;
        if (r23 <= r0) goto L25;
    L27:
        boolean r26 = false;
    L28:
        if (r26 == false) goto L15;
        r8 = true;
        goto L30
    L25:
        if (r0 > r25) goto L27;
        r26 = true;
    L9:
        r1 = false;
        goto L32
    L8:
        if (r3.isEmpty() == false) goto L10;
        goto L9
    }

    public static final void a(final a r7, final Modifier r8, Composer r9, final int r10, final int r11) {
        Intrinsics.checkNotNullParameter(r7, "state");
        Composer r12 = r9.startRestartGroup(-192837851);
        if ((r11 & 1) == 0) goto L6;
        int r1 = r10 | 6;
    L13:
        int r3 = r11 & 2;
        if (r3 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r1 & 19) == 18) goto L26;
    L29:
        if (r3 == 0) goto L32;
        r8 = Modifier.Companion;
    L32:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-192837851, r1, -1, "com.ss.android.lark.compose.chat_member_list.ChatMemberStatusTag (ChatMemberStatusTag.android.kt:43)");
    L34:
        r12.startReplaceGroup(1849434622);
        Object r0 = r12.rememberedValue();
        Composer.Companion r4 = Composer.Companion;
        if (r0 != r4.getEmpty()) goto L37;
        r0 = ChatMemberStatusTag_androidKt$ChatMemberStatusTag$1$1.INSTANCE;
        r12.updateRememberedValue(r0);
    L37:
        Function1 r2 = (Function1) r0;
        r12.endReplaceGroup();
        r12.startReplaceGroup(5004770);
        if ((r1 & 14) != 4) goto L40;
        boolean r5 = true;
    L41:
        Object r6 = r12.rememberedValue();
        if (r5 == false) goto L44;
    L45:
        r6 = new ChatMemberStatusTag_androidKt$ChatMemberStatusTag$2$1(r7);
        r12.updateRememberedValue(r6);
    L46:
        r12.endReplaceGroup();
        Modifier r13 = r8;
        AndroidView_androidKt.AndroidView(r2, r13, (Function1) r6, r12, (r1 & 112) | 6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        ScopeUpdateScope r14 = r12.endRestartGroup();
        if (r14 == null) goto L53;
        r14.updateScope(new ChatMemberStatusTag_androidKt$ChatMemberStatusTag$3(r7, r8, r10, r11));
        return;
    L53:
        return;
    L44:
        if (r6 != r4.getEmpty()) goto L46;
    L40:
        r5 = false;
        goto L41
    L26:
        if (r12.getSkipping() == false) goto L29;
        r12.skipToGroupEnd();
        goto L49
    L17:
        if ((r10 & 48) != 0) goto L24;
        if (r12.changed(r8) == false) goto L21;
        int r15 = 32;
    L22:
        r1 = r1 | r15;
        goto L24
    L21:
        r15 = 16;
        goto L22
    L6:
        if ((r10 & 6) == 0) goto L8;
        r1 = r10;
        goto L13
    L8:
        if (r12.changed(r7) == false) goto L10;
        int r16 = 4;
    L11:
        r1 = r16 | r10;
        goto L13
    L10:
        r16 = 2;
        goto L11
    }
}
