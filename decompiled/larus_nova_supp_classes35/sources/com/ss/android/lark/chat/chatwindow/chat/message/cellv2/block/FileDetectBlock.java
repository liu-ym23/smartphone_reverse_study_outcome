package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FileDetectBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {
    public final IMMessageKeys$Blocks g;

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public FileDetectBlock(com.ss.android.lark.blueprint.g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.g = IMMessageKeys$Blocks.FILE_DETECT;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r2, com.ss.android.lark.blueprint.q<y6b.a<?>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        g(r3, this.g, IMMessageKeys$Slots.BOTTOM);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<?>> r4, com.ss.android.lark.blueprint.q<y6b.a<?>> r5, y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "layout");
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        Object r7 = r6.b();
        boolean r1 = false;
        if ((r7 instanceof FileContentVO) == false) goto L14;
        ArrayList<String> r8 = ((FileContent) ((FileContentVO) r7).a).getRiskObjectKeys();
        if (r8 != null) goto L7;
    L10:
        boolean r9 = true;
    L11:
        if (r9 == false) goto L45;
    L46:
        boolean r10 = false;
    L48:
        if (r6.h() == true) goto L50;
    L52:
        boolean r11 = false;
    L53:
        if (r11 == true) goto L56;
        if (r10 == false) goto L56;
        r1 = true;
    L56:
        if (r1 == true) goto L59;
        g(r5, this.g, IMMessageKeys$Slots.BOTTOM);
        return;
    L59:
        r5.c(this.g, IMMessageKeys$Slots.BOTTOM, new AnonymousClass1(this));
        return;
    L50:
        if (MessageDLPState.BLOCK != r6.t()) goto L52;
        r11 = true;
    L45:
        r10 = true;
        goto L48
    L7:
        if (r8.isEmpty() == true) goto L10;
        r9 = false;
        goto L11
    L14:
        if ((r7 instanceof PostContentVO) == false) goto L25;
        ArrayList<String> r12 = ((PostContent) ((PostContentVO) r7).a).getRiskObjectKeys();
        if (r12 != null) goto L18;
    L21:
        boolean r13 = true;
    L22:
        if (r13 == true) goto L46;
    L18:
        if (r12.isEmpty() == true) goto L21;
        r13 = false;
        goto L22
    L25:
        if ((r7 instanceof MediaContentVO) == false) goto L36;
        ArrayList<String> r14 = ((MediaContent) ((MediaContentVO) r7).a).getRiskObjectKeys();
        if (r14 != null) goto L29;
    L32:
        boolean r15 = true;
    L33:
        if (r15 == true) goto L46;
    L29:
        if (r14.isEmpty() == true) goto L32;
        r15 = false;
        goto L33
    L36:
        if ((r7 instanceof ImageContentVO) == false) goto L46;
        ArrayList<String> r16 = ((ImageContent) ((ImageContentVO) r7).a).getRiskObjectKeys();
        if (r16 != null) goto L40;
    L43:
        boolean r17 = true;
    L44:
        if (r17 == true) goto L46;
    L40:
        if (r16.isEmpty() == true) goto L43;
        r17 = false;
        goto L44
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r1, com.ss.android.lark.blueprint.q<y6b.a<?>> r2, y6b.a<?> r3) {
        update2(r1, r2, r3);
    }
}
