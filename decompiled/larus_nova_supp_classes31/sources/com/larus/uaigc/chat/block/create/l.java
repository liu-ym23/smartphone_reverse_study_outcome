package com.larus.uaigc.chat.block.create;

import android.view.View;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.chat.block.create.j;
import com.larus.uaigc.chat.markdown.helper.LocalCreationChatItemClickHelper;
import com.larus.uaigc.helper.h0;
import kc8.c0;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class l<T extends j> extends BaseCreationHolder<T> {
    public l() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.uaigc.chat.block.create.k] */
    @Override // com.larus.uaigc.chat.block.create.BaseCreationHolder
    public final Object k(cz9.b r8, View r9, Message r10, final kc8.q r11, Continuation<? super Unit> r12) {
        LocalCreationChatItemClickHelper r13 = LocalCreationChatItemClickHelper.a;
        ?? r0 = new k(r11);
        CreationItem r14 = r8.a();
        if (r14 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r15 == true) goto L10;
        Unit r16 = Unit.INSTANCE;
    L33:
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L36;
        return r16;
    L36:
        return Unit.INSTANCE;
    L10:
        if (r10 != null) goto L12;
        r16 = Unit.INSTANCE;
        goto L33
    L12:
        CreationItem r17 = r8.a();
        if (r17 != null) goto L15;
        r16 = Unit.INSTANCE;
        goto L33
    L15:
        JSONObject r6 = new JSONObject();
        r6.putOpt("position", Boxing.boxInt(r8.b() + 1));
        r6.putOpt("creation_task_id", r17.id);
        if ((r8 instanceof cz9.m) == false) goto L22;
        ImageInfo r3 = bz9.c.o(r17);
        if (r3 != null) goto L20;
        r16 = Unit.INSTANCE;
        goto L33
    L20:
        r0.invoke(r9, r10, r3, Boxing.boxInt(((cz9.m) r8).f), null, r6);
    L31:
        r16 = Unit.INSTANCE;
        goto L33
    L22:
        if ((r8 instanceof cz9.n) == false) goto L31;
        nr9.g r18 = bz9.c.p(r17);
        if (r18 != null) goto L26;
        r16 = Unit.INSTANCE;
        goto L33
    L26:
        r6.putOpt("is_upload_video", "1");
        h0.a(r6, new JSONObject());
        Unit r19 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r9, "bindView");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r18, "videoPlayData");
        if (r11 == null) goto L31;
        c0 r110 = r11.j;
        if (r110 == null) goto L31;
        r110.a(r9, r10, r18, r6);
        goto L31
    L5:
        if (bz9.c.e(r14) != true) goto L7;
        r15 = true;
        goto L8
    }
}
