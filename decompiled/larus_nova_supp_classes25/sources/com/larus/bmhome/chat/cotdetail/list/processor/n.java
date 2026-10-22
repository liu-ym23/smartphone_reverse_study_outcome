package com.larus.bmhome.chat.cotdetail.list.processor;

import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.d0;
import com.larus.bmhome.chat.api.z;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SelectTextAction;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public n() {
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.bmhome.chat.cotdetail.list.processor.m] */
    public static boolean a(final Fragment r109, RecyclerView r110, final CustomMarkdownTextView r111, Message r112, BotModel r113, String r114, int r115, boolean r116, d0 r117, String r118, Function0 r119, int r120) {
        BotModel r1 = r113;
        if ((r120 & 64) == 0) goto L5;
        int r12 = 2;
    L7:
        if ((r120 & 128) == 0) goto L9;
        boolean r13 = false;
    L10:
        fe8.a r4 = null;
        if ((r120 & 256) == 0) goto L13;
        d0 r15 = null;
    L15:
        if ((r120 & 512) == 0) goto L17;
        String r14 = ChatDraftItem.TYPE_TEXT;
    L19:
        if ((r120 & 1024) == 0) goto L21;
        final Function0 r2 = new l();
    L22:
        Intrinsics.checkNotNullParameter(r112, "message");
        Intrinsics.checkNotNullParameter(r114, "clickFrom");
        Intrinsics.checkNotNullParameter(r14, "contentType");
        Intrinsics.checkNotNullParameter(r2, "isCurrentMessage");
        int r3 = f.f;
        f r19 = f.a.a(r109, r112, r1);
        if (r19 != null) goto L26;
        return false;
    L26:
        if ((r109 instanceof fe8.a) == false) goto L28;
        r4 = (fe8.a) r109;
    L28:
        fe8.a r18 = r4;
        if (r18 != null) goto L32;
        return false;
    L32:
        if (r109 == null) goto L43;
        if (r111 == null) goto L43;
        if (r110 == null) goto L43;
        if (r111.isAttachedToWindow() == false) goto L43;
        ?? r9 = new m(r111, r109, r2);
        List r40 = CollectionsKt.listOf(new SelectTextAction(null, "tts", null, null, 13, null));
        z r0 = ILegacyChatUiServiceDelegate.b.F8();
        if (r0 == null) goto L43;
        if (r1 != null) goto L42;
        r1 = new BotModel(null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, Integer.MAX_VALUE, null);
    L42:
        BotModel r5 = BotModel.copy$default(r1, null, null, null, 0, null, null, null, null, null, r40, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -513, Integer.MAX_VALUE, null);
        LruCache r6 = ko8.a.a;
        z.a.a(r0, r19, r5, "default", ko8.a.g(), r111, r112, r114, null, r110, SetsKt.setOf(new Integer[]{21, 22, 23}).contains(Integer.valueOf(r112.getMessageStatusLocal())), r12, r13, r14, r15, true, null, r18.K(), r9, 32896);
    L43:
        return true;
    L21:
        r2 = r119;
        goto L22
    L17:
        r14 = r118;
        goto L19
    L13:
        r15 = r117;
        goto L15
    L9:
        r13 = r116;
        goto L10
    L5:
        r12 = r115;
        goto L7
    }
}
