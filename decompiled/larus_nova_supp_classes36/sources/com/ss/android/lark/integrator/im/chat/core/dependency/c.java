package com.ss.android.lark.integrator.im.chat.core.dependency;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.lark.pb.basic.v1.RichText;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ShareGroupChatContentVO;
import com.ss.android.lark.chat.base.view.vo.message.StickerContentVO;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatwindow.view.burn.CountDownView;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.statistics.thread.ThreadTopicHitPointNew;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.table.entity.TableInfo;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements w4b.g {
    public c() {
    }

    public final void b(Context r2, ColumnsInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "columnsInfo");
    }

    public final void d(m2b.a r2, y6b.a<StickerContentVO> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "item");
    }

    public final void f() {
    }

    public final void h(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "fromSource");
    }

    public final void l() {
    }

    public final void n(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void o() {
    }

    public final void r() {
    }

    public final void u(FragmentActivity r2, String r3, String r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r4, "fromSource");
        Intrinsics.checkNotNullParameter(r5, "sourceFragment");
    }

    public final void v(yya.a r2, Message.DisabledAction.Action r3) {
        Intrinsics.checkNotNullParameter(r2, "actionContext");
        Intrinsics.checkNotNullParameter(r3, "actionType");
    }

    public final void y(Context r2, TableInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tableInfo");
    }

    public final boolean a() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(Boolean.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return ((Boolean) r1).booleanValue();
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L6:
        if (Intrinsics.areEqual(Boolean.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(Boolean.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(Boolean.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(Boolean.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(Boolean.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(Boolean.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(Boolean.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(Boolean.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(Boolean.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(Boolean.class);
        goto L33
    }

    public final int e() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(Integer.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return ((Integer) r1).intValue();
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L6:
        if (Intrinsics.areEqual(Integer.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(Integer.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(Integer.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(Integer.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(Integer.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(Integer.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(Integer.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(Integer.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(Integer.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(Integer.class);
        goto L33
    }

    public final s4b.a<CountDownView> q() {
        int r0 = nmb.b.a;
        if (Intrinsics.areEqual(s4b.a.class, Boolean.class) == false) goto L6;
        Object r1 = Boolean.FALSE;
    L33:
        if (r1 == null) goto L37;
        return (s4b.a) r1;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.secret.ICellInfoCollector<com.ss.android.lark.chatwindow.view.burn.CountDownView>");
    L6:
        if (Intrinsics.areEqual(s4b.a.class, Byte.class) == false) goto L9;
        r1 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(s4b.a.class, Short.class) == false) goto L12;
        r1 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(s4b.a.class, Integer.class) == false) goto L15;
        r1 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(s4b.a.class, Long.class) == false) goto L18;
        r1 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(s4b.a.class, Float.class) == false) goto L21;
        r1 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(s4b.a.class, Double.class) == false) goto L24;
        r1 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(s4b.a.class, Character.class) == false) goto L27;
        r1 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(s4b.a.class, ArrayList.class) == false) goto L30;
        r1 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(s4b.a.class, Unit.class) == false) goto L32;
        r1 = Unit.INSTANCE;
        goto L33
    L32:
        r1 = nmb.b.a(s4b.a.class);
        goto L33
    }

    public final void x() {
        fgb.b r0 = fgb.b.a;
    }

    public final RichText i(com.ss.android.lark.widget.richtext.RichText r2) {
        Intrinsics.checkNotNullParameter(r2, "richText");
        return g0.d(r2);
    }

    public final void m(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r4 = nmb.b.a;
        if (Intrinsics.areEqual(Unit.class, Boolean.class) == false) goto L6;
        Object r5 = Boolean.FALSE;
    L33:
        if (r5 == null) goto L37;
        Unit r6 = (Unit) r5;
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Unit");
    L6:
        if (Intrinsics.areEqual(Unit.class, Byte.class) == false) goto L9;
        r5 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(Unit.class, Short.class) == false) goto L12;
        r5 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(Unit.class, Integer.class) == false) goto L15;
        r5 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(Unit.class, Long.class) == false) goto L18;
        r5 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(Unit.class, Float.class) == false) goto L21;
        r5 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(Unit.class, Double.class) == false) goto L24;
        r5 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(Unit.class, Character.class) == false) goto L27;
        r5 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(Unit.class, ArrayList.class) == false) goto L30;
        r5 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(Unit.class, Unit.class) == false) goto L32;
        r5 = Unit.INSTANCE;
        goto L33
    L32:
        r5 = nmb.b.a(Unit.class);
        goto L33
    }

    public final View c(ViewGroup r2, MessageInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "parentContainer");
        Intrinsics.checkNotNullParameter(r3, "messageInfo");
        int r4 = nmb.b.a;
        if (Intrinsics.areEqual(View.class, Boolean.class) == false) goto L6;
        Object r5 = Boolean.FALSE;
    L34:
        return (View) r5;
    L6:
        if (Intrinsics.areEqual(View.class, Byte.class) == false) goto L9;
        r5 = (byte) 0;
        goto L34
    L9:
        if (Intrinsics.areEqual(View.class, Short.class) == false) goto L12;
        r5 = (short) 0;
        goto L34
    L12:
        if (Intrinsics.areEqual(View.class, Integer.class) == false) goto L15;
        r5 = 0;
        goto L34
    L15:
        if (Intrinsics.areEqual(View.class, Long.class) == false) goto L18;
        r5 = 0L;
        goto L34
    L18:
        if (Intrinsics.areEqual(View.class, Float.class) == false) goto L21;
        r5 = Float.valueOf(0.0f);
        goto L34
    L21:
        if (Intrinsics.areEqual(View.class, Double.class) == false) goto L24;
        r5 = Double.valueOf(0.0d);
        goto L34
    L24:
        if (Intrinsics.areEqual(View.class, Character.class) == false) goto L27;
        r5 = (char) 0;
        goto L34
    L27:
        if (Intrinsics.areEqual(View.class, ArrayList.class) == false) goto L30;
        r5 = CollectionsKt.emptyList();
        goto L34
    L30:
        if (Intrinsics.areEqual(View.class, Unit.class) == false) goto L32;
        r5 = Unit.INSTANCE;
        goto L34
    L32:
        r5 = nmb.b.a(View.class);
        goto L34
    }

    public final void j(Context r2, l1 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        whb.d.a(r2, r3);
    }

    public final void k(m2b.a r5, y6b.a<ShareGroupChatContentVO> r6) {
        Intrinsics.checkNotNullParameter(r5, "chatContext");
        Intrinsics.checkNotNullParameter(r6, "item");
        if (r5.q() == true) goto L5;
    L9:
        Lazy r0 = ChatHitPointNew.a;
        ChatHitPointNew.f(r5.getChat(), "shareGroupChat", ChatHitPointNew.c("shareGroupChat"), ChatHitPointNew.b(r5, r6, null, null, null));
        return;
    L5:
        if ((r5 instanceof a7c.a) == false) goto L9;
        a7c.a r7 = (a7c.a) r5;
        Lazy r8 = ThreadTopicHitPointNew.a;
        throw null;
    }

    public final void openChat(Context r3, ChatBundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatBundle");
        int r0 = FlowChatModule.d;
        FlowChatModule.a.a().e(r3, r4, null);
    }

    public final void s(m2b.a r5, y6b.a<MediaContentVO> r6) {
        Intrinsics.checkNotNullParameter(r5, "chatContext");
        Intrinsics.checkNotNullParameter(r6, "item");
        if (r5.q() == true) goto L5;
    L9:
        Lazy r0 = ChatHitPointNew.a;
        ChatHitPointNew.f(r5.getChat(), "media", ChatHitPointNew.c("media"), ChatHitPointNew.b(r5, r6, null, null, null));
        return;
    L5:
        if ((r5 instanceof a7c.a) == false) goto L9;
        a7c.a r7 = (a7c.a) r5;
        Lazy r8 = ThreadTopicHitPointNew.a;
        throw null;
    }

    public final void w(m2b.a r5, y6b.a<ImageContentVO> r6) {
        Intrinsics.checkNotNullParameter(r5, "chatContext");
        Intrinsics.checkNotNullParameter(r6, "item");
        if (r5.q() == true) goto L5;
    L9:
        Lazy r0 = ChatHitPointNew.a;
        ChatHitPointNew.f(r5.getChat(), LoadParams.ImageFormat.IMAGE, ChatHitPointNew.c(LoadParams.ImageFormat.IMAGE), ChatHitPointNew.b(r5, r6, null, null, null));
        return;
    L5:
        if ((r5 instanceof a7c.a) == false) goto L9;
        a7c.a r7 = (a7c.a) r5;
        Lazy r8 = ThreadTopicHitPointNew.a;
        throw null;
    }

    public final void g(Context r2, l1 r3, Fragment r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        Intrinsics.checkNotNullParameter(r4, "sourceFragment");
        whb.d.b(r2, r4, r3);
    }

    public final boolean p(View r2, MessageInfo r3, v4b.d r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "messageCellConfig");
        int r5 = nmb.b.a;
        if (Intrinsics.areEqual(Boolean.class, Boolean.class) == false) goto L6;
        Object r6 = Boolean.FALSE;
    L33:
        if (r6 == null) goto L37;
        return ((Boolean) r6).booleanValue();
    L37:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L6:
        if (Intrinsics.areEqual(Boolean.class, Byte.class) == false) goto L9;
        r6 = (byte) 0;
        goto L33
    L9:
        if (Intrinsics.areEqual(Boolean.class, Short.class) == false) goto L12;
        r6 = (short) 0;
        goto L33
    L12:
        if (Intrinsics.areEqual(Boolean.class, Integer.class) == false) goto L15;
        r6 = 0;
        goto L33
    L15:
        if (Intrinsics.areEqual(Boolean.class, Long.class) == false) goto L18;
        r6 = 0L;
        goto L33
    L18:
        if (Intrinsics.areEqual(Boolean.class, Float.class) == false) goto L21;
        r6 = Float.valueOf(0.0f);
        goto L33
    L21:
        if (Intrinsics.areEqual(Boolean.class, Double.class) == false) goto L24;
        r6 = Double.valueOf(0.0d);
        goto L33
    L24:
        if (Intrinsics.areEqual(Boolean.class, Character.class) == false) goto L27;
        r6 = (char) 0;
        goto L33
    L27:
        if (Intrinsics.areEqual(Boolean.class, ArrayList.class) == false) goto L30;
        r6 = CollectionsKt.emptyList();
        goto L33
    L30:
        if (Intrinsics.areEqual(Boolean.class, Unit.class) == false) goto L32;
        r6 = Unit.INSTANCE;
        goto L33
    L32:
        r6 = nmb.b.a(Boolean.class);
        goto L33
    }

    public final void t(Context r3, Fragment r4, ChatBundle r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "chatBundle");
        int r0 = FlowChatModule.d;
        FlowChatModule.a.a().d(r3, r4, r5, null);
    }
}
