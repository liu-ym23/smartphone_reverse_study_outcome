package com.ss.android.lark.chat.utils;

import android.net.Uri;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.dto.draft.ScheduleDraftInfo;
import com.ss.android.lark.keyboard.base.ChatAttachmentEntity;
import com.ss.android.lark.keyboard.base.ChatAttachmentUploadState;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x {
    public static final Set<RichTextElement.RichTextTag> a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = SetsKt.setOf(new RichTextElement.RichTextTag[]{RichTextElement.RichTextTag.CODE_BLOCK_V2, RichTextElement.RichTextTag.UL, RichTextElement.RichTextTag.OL, RichTextElement.RichTextTag.MARKDOWN});
    }

    public static List a(List r26) {
        Intrinsics.checkNotNullParameter(r26, "attachments");
        ArrayList r1 = new ArrayList();
        Iterator r2 = r26.iterator();
    L4:
        if (r2.hasNext() == false) goto L70;
        File r3 = (File) r2.next();
        String r0 = r3.key;
        String r6 = null;
        if (r0 != null) goto L8;
    L13:
        String r14 = null;
    L14:
        String r4 = r3.path;
        if (r4 != null) goto L17;
        r4 = BuildConfig.FLAVOR;
    L17:
        String r7 = r4;
        if (StringsKt.startsWith$default(r7, "content:", false, 2, null) == false) goto L20;
    L71:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L24
        Object r8 = Result.constructor-impl(UriProtector.parse(r7));     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r8) == false) goto L29;
        r8 = null;
    L29:
        Uri r23 = (Uri) r8;
    L31:
        if (r7.length() <= 0) goto L33;
        boolean r9 = true;
    L34:
        if (r9 == false) goto L37;
        if (r23 != null) goto L37;
        boolean r10 = true;
    L38:
        if (r10 == false) goto L40;
        String r13 = r7;
    L41:
        if (r14 != null) goto L50;
        if (r13 != null) goto L49;
        if (r23 == null) goto L45;
        String r11 = r23.toString();
    L46:
        if (r11 == null) goto L68;
        String r12 = r11;
    L51:
        String r15 = r3.name;
        if (r15 != null) goto L54;
    L59:
        String r16 = r12;
    L60:
        Long r17 = r3.size;
        String r18 = r3.mime;
        if (r14 == null) goto L63;
        int r19 = 100;
    L64:
        if (r14 == null) goto L66;
        ChatAttachmentUploadState r20 = ChatAttachmentUploadState.SUCCESS;
    L67:
        r6 = new ChatAttachmentEntity(r12, r16, r17, r18, r13, r14, null, null, null, 0, r19, r20, false, Intrinsics.areEqual(r3.is_folder, Boolean.TRUE), r23, 5056, null);
        goto L68
    L66:
        r20 = ChatAttachmentUploadState.DEFAULT;
        goto L67
    L63:
        r19 = 0;
        goto L64
    L54:
        if ((true ^ StringsKt.isBlank(r15)) == false) goto L56;
        r6 = r15;
    L56:
        if (r6 == null) goto L59;
        r16 = r6;
    L68:
        if (r6 == null) goto L4;
        r1.add(r6);
        goto L4
    L45:
        r11 = null;
        goto L46
    L49:
        r12 = r13;
        goto L51
    L50:
        r12 = r14;
        goto L51
    L40:
        r13 = null;
    L37:
        r10 = false;
        goto L38
    L33:
        r9 = false;
    L24:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L20:
        if (StringsKt.startsWith$default(r7, "file:", false, 2, null) == true) goto L71;
        r23 = null;
        goto L31
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r22 = true;
    L11:
        if (r22 == false) goto L13;
        r14 = r0;
        goto L14
    L10:
        r22 = false;
        goto L11
    L70:
        return r1;
    }

    public static cya.h c(a7b.a r18) {
        Intrinsics.checkNotNullParameter(r18, "draft");
        com.ss.android.lark.keyboard.base.n r1 = new com.ss.android.lark.keyboard.base.n();
        String r2 = r18.f;
        boolean r3 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        boolean r5 = !r4;
        String r7 = BuildConfig.FLAVOR;
        if (r5 == false) goto L24;
        Log.i("KeyboardEditUtils", "parseInputStateFromDraft: is Reply draft");
        String r8 = r18.f;
        if (r8 != null) goto L14;
        String r9 = BuildConfig.FLAVOR;
    L15:
        String r10 = r18.g;
        if (r10 != null) goto L18;
        String r11 = BuildConfig.FLAVOR;
    L19:
        CharSequence r12 = r18.h;
        if (r12 != null) goto L22;
        CharSequence r13 = BuildConfig.FLAVOR;
    L23:
        r1.b(cya.i.h, new cya.i(r9, r11, r13, false, r18.k, 48));
        char r6 = 2;
    L25:
        String r14 = r18.d;
        if (r14 != null) goto L28;
    L31:
        boolean r15 = true;
    L33:
        if ((!r15) == false) goto L40;
        Log.i("KeyboardEditUtils", "parseInputStateFromDraft: is reEdit draft ");
        ReEditInfo.a r16 = ReEditInfo.Companion;
        String r17 = r18.d;
        if (r17 != null) goto L37;
        String r19 = BuildConfig.FLAVOR;
    L38:
        r1.b(r16, new ReEditInfo(r19, r18.e, false, 4, null));
        r6 = 4;
        goto L40
    L37:
        r19 = r17;
    L40:
        if (r18.i != null) goto L42;
    L44:
        boolean r20 = false;
    L46:
        if (r20 == false) goto L64;
        Log.i("KeyboardEditUtils", "parseInputStateFromDraft: is schedule send draft ");
        ScheduleDraftInfo r21 = r18.i;
        if (r21 == null) goto L50;
        long r110 = r21.getScheduleSendTime();
    L51:
        long r111 = r110;
        ChatCoreModule.a().getTimeFormatDependency().a();
        com.ss.android.lark.keyboard.base.p r112 = r18.j;
        ScheduleDraftInfo r22 = r18.i;
        if (r22 == null) goto L57;
        String r23 = r22.getScheduleMessageId();
        if (r23 == null) goto L57;
        String r113 = r23;
    L58:
        ScheduleDraftInfo r24 = r18.i;
        if (r24 == null) goto L61;
        boolean r114 = r24.isPreScheduleMessage();
    L62:
        r1.b(com.ss.android.lark.keyboard.base.o.f, new com.ss.android.lark.keyboard.base.o(r111, true, r112, r113, r114));
        r6 = '\b';
        goto L64
    L61:
        r114 = false;
    L57:
        r113 = BuildConfig.FLAVOR;
        goto L58
    L50:
        r110 = 0;
    L64:
        if (com.ss.android.lark.widget.richtext.i.l(r18.a) == true) goto L67;
        RichText r25 = r18.a;
    L70:
        Intrinsics.checkNotNull(r25);
        String r115 = r18.c;
        if (r115 == null) goto L74;
        r7 = r115;
    L74:
        cya.a r116 = new cya.a(r25, r7);
        StringBuilder r26 = new StringBuilder("parseInputStateFromDraft: edit info is empty?: ");
        if (com.ss.android.lark.widget.richtext.i.l(r25) == true) goto L77;
    L82:
        boolean r27 = false;
    L83:
        r26.append(r27);
        Log.i("KeyboardEditUtils", r26.toString());
        r1.b(cya.a.c, r116);
        QueryStatusInfo r28 = r18.l;
        if (r28 != null) goto L86;
    L88:
        if (r3 == false) goto L90;
        r1.b(QueryStatusInfo.Companion, r18.l);
    L90:
        r1.b(com.ss.android.lark.keyboard.base.a.b, new com.ss.android.lark.keyboard.base.a(r18.m));
        if (r6 == 2) goto L97;
        if (r6 == 4) goto L96;
        if (r6 == '\b') goto L95;
        cya.b r29 = new cya.b();
    L98:
        r1.b(cya.h.e, Boolean.valueOf(r18.n));
        r1.b(cya.h.f, Integer.valueOf(r18.o.a));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        ((cya.h) r29).a = r1;
        return r29;
    L95:
        r29 = new com.ss.android.lark.keyboard.inputstate.d();
        goto L98
    L96:
        r29 = new com.ss.android.lark.keyboard.inputstate.b();
        goto L98
    L97:
        r29 = new com.ss.android.lark.keyboard.inputstate.c();
        goto L98
    L86:
        if (r28.isQueryStatus() != true) goto L88;
        r3 = true;
        goto L88
    L77:
        if (r116.b.length() != 0) goto L79;
        boolean r30 = true;
    L80:
        if (r30 == false) goto L82;
        r27 = true;
        goto L83
    L79:
        r30 = false;
        goto L80
    L67:
        if (com.ss.android.lark.widget.richtext.i.l(r18.b) == true) goto L69;
        r25 = r18.b;
        goto L70
    L69:
        r25 = com.ss.android.lark.widget.richtext.c.a();
        goto L70
    L42:
        if (r18.j == null) goto L44;
        r20 = true;
        goto L46
    L28:
        if (r14.length() == 0) goto L31;
        r15 = false;
        goto L33
    L22:
        r13 = r12;
        goto L23
    L18:
        r11 = r10;
        goto L19
    L14:
        r9 = r8;
        goto L15
    L24:
        r6 = 1;
        goto L25
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean b(RichText r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "richText");
        Intrinsics.checkNotNullParameter(r7, "title");
        if (r6.getRichTextVersion() != 0) goto L5;
        return false;
    L5:
        boolean r0 = !r6.getImageIds().isEmpty();
        boolean r3 = !r6.getMediaIds().isEmpty();
        Collection r8 = r6.getElements().getDictionary().values();
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L9;
        if (a.contains(((RichTextElement) r9.next()).getTag()) == false) goto L12;
        boolean r10 = true;
    L17:
        if (r7.length() <= 0) goto L19;
        boolean r11 = true;
    L20:
        if (r0 == true) goto L29;
        if (r3 == true) goto L30;
        if (r11 == true) goto L31;
        if (r10 == true) goto L32;
        return true;
    L32:
        return false;
    L31:
        return false;
    L30:
        return false;
    L29:
        return false;
    L19:
        r11 = false;
    L9:
        r10 = false;
        goto L17
    L8:
        if (r8.isEmpty() == false) goto L10;
        goto L9
    }
}
