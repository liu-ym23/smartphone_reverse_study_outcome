package com.larus.chat.gallery.impl.providers;

import android.content.Context;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.chat.gallery.api.IFindSimilarClickHandler;
import com.larus.gallery.api.t;
import com.larus.gallery.api.w;
import com.larus.im.bean.message.GuiContext;
import com.larus.im.bean.message.GuiView;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import zy8.s;
import zy8.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/chat/gallery/impl/providers/FindSimilarClickHandlerImpl;", "Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "<init>", "()V", "handleFindSimilarClick", "", "context", "Landroid/content/Context;", "imageUri", "", "messageId", "sendText", "sender", "Lcom/larus/chat/gallery/api/FindSimilarSender;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FindSimilarClickHandlerImpl implements IFindSimilarClickHandler {

    public static final class a {
    }

    static {
    }

    public FindSimilarClickHandlerImpl() {
    }

    @Override // com.larus.chat.gallery.api.IFindSimilarClickHandler
    public final boolean a(Context r26, String r27, String r28, String r29, h r30) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r30, "sender");
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("handleFindSimilarClick imageUri=");
        r3.append(r27);
        r3.append(", messageId=");
        r3.append(r28);
        r3.append(", hasServerSendText=");
        if (StringsKt.isBlank(r29) == false) goto L5;
        boolean r4 = true;
    L6:
        r3.append(!r4);
        r2.i("FindSimilarClickHandler", r3.toString());
        if (r27 != null) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == false) goto L16;
        r2.w("FindSimilarClickHandler", "send skipped: imageUri empty");
        return false;
    L16:
        ChatPageContext r5 = null;
        if ((!StringsKt.isBlank(r29)) == false) goto L19;
        String r1 = r29;
    L20:
        if (r1 != null) goto L23;
        r2.w("FindSimilarClickHandler", "send skipped: server sendText missing, no local fallback");
        return false;
    L23:
        i r6 = r30.a;
        f r7 = r30.b;
        com.larus.chat.gallery.api.h r8 = r30.c;
        Intrinsics.checkNotNullParameter(r1, ShareType.TEXT);
        w r9 = ((t) r6).e;
        if (r9 == null) goto L46;
        u r10 = (u) r9.AQ(Reflection.getOrCreateKotlinClass(u.class));
        if (r10 == null) goto L47;
        String r11 = r7.b;
        zy8.a r13 = new zy8.a("click_ecom_find_same_product", "album", "chat_upload", "chat", r11);
        zy8.t r12 = new zy8.t("click_ecom_find_same_product", "router_auto_send", "", "", r11);
        String r14 = r8.d;
        if (r14 == null) goto L45;
        if ((!StringsKt.isBlank(r14)) == false) goto L32;
        String r15 = r14;
    L33:
        if (r15 == null) goto L45;
        String r16 = r8.e;
        if (r16 == null) goto L45;
        if ((!StringsKt.isBlank(r16)) == true) goto L41;
        r16 = null;
    L41:
        if (r16 == null) goto L45;
        r5 = new ChatPageContext(null, null, null, CollectionsKt.listOf(new GuiContext(r15, null, new GuiView(r16), 2, null)), null, null, 55, null);
        goto L45
    L32:
        r15 = null;
    L45:
        return r10.b(r1, new s(r13, r12, r5));
    L47:
        return false;
    L46:
        return false;
    L19:
        r1 = null;
        goto L20
    L9:
        if (r27.length() == 0) goto L12;
        r0 = false;
        goto L13
    L5:
        r4 = false;
        goto L6
    }
}
