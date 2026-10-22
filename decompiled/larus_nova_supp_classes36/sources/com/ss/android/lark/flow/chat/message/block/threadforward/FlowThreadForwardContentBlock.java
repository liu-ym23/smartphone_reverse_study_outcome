package com.ss.android.lark.flow.chat.message.block.threadforward;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.i;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.chat.base.view.vo.message.ThreadForwardContentVOV2;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.FolderContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ImageContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.MediaContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.PostContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ShareGroupChatContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall.RecalledContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.OpenCellContentBlock;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.w;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.flow.chat.message.block.FlowFileContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowHideContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowProfileContentBlock;
import com.ss.android.lark.flow.chat.message.block.FlowUnknownContentBlock;
import com.ss.android.lark.flow.chat.message.block.audio.FlowAudioContentBlock;
import com.ss.android.lark.flow.chat.message.mergeforward.FlowMergeForwardContentBlock;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vza.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadForwardContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<ThreadForwardContentVOV2>, ThreadForwardContentVOV2> {
    public static final /* synthetic */ int y = 0;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public OpenCellContentBlock u;
    public final Lazy v;
    public final Map<j, OpenCellContentBlock> w;
    public final List<IMMessageKeys.Blocks> x;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r0[Message.Type.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r0[Message.Type.POST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[Message.Type.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r0[Message.Type.FILE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r0[Message.Type.FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r0[Message.Type.MERGE_FORWARD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[Message.Type.AUDIO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[Message.Type.SHARE_USER_CARD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r0[Message.Type.CARD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            a = r0;
        }
    }

    static {
    }

    public FlowThreadForwardContentBlock(final g r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        super(r3);
        IMMessageKeys.Blocks r0 = IMMessageKeys.Blocks.UNKNOWN_CONTENT;
        this.g = LazyKt.lazy(new FlowThreadForwardContentBlock$headerBlock$2(r3));
        this.h = LazyKt.lazy(new FlowThreadForwardContentBlock$recalledContentBlock$2(r3));
        this.i = LazyKt.lazy(new FlowThreadForwardContentBlock$textContentBlock$2(r3));
        this.j = LazyKt.lazy(new FlowThreadForwardContentBlock$imageContentBlock$2(r3));
        this.k = LazyKt.lazy(new FlowThreadForwardContentBlock$postContentBlock$2(r3));
        this.l = LazyKt.lazy(new FlowThreadForwardContentBlock$mediaContentBlock$2(r3));
        this.m = LazyKt.lazy(new FlowThreadForwardContentBlock$shareGroupChatContentBlock$2(r3));
        this.n = LazyKt.lazy(new FlowThreadForwardContentBlock$flowFileContentBlock$2(r3));
        this.o = LazyKt.lazy(new FlowThreadForwardContentBlock$folderContentBlock$2(r3));
        this.p = LazyKt.lazy(new FlowThreadForwardContentBlock$flowMergeForwardContentBlock$2(r3));
        this.q = LazyKt.lazy(new FlowThreadForwardContentBlock$flowAudioContentBlock$2(r3));
        this.r = LazyKt.lazy(new FlowThreadForwardContentBlock$flowProfileContentBlock$2(r3));
        this.s = LazyKt.lazy(new FlowThreadForwardContentBlock$flowUnknownContentBlock$2(r3));
        this.t = LazyKt.lazy(new FlowThreadForwardContentBlock$flowHideContentBlock$2(r3));
        this.v = LazyKt.lazy(new FlowThreadForwardContentBlock$openCellAdapters$2(this));
        this.w = new LinkedHashMap();
        this.x = CollectionsKt.listOf(new IMMessageKeys.Blocks[]{IMMessageKeys.Blocks.TEXT_CONTENT, IMMessageKeys.Blocks.IMAGE_CONTENT, IMMessageKeys.Blocks.POST_CONTENT, IMMessageKeys.Blocks.MEDIA_CONTENT, IMMessageKeys.Blocks.SHARE_GROUP_CHAT_CONTENT, IMMessageKeys.Blocks.FILE_CONTENT, IMMessageKeys.Blocks.FOLDER_CONTENT, IMMessageKeys.Blocks.MERGE_FORWARD_CONTENT, IMMessageKeys.Blocks.AUDIO_CONTENT, IMMessageKeys.Blocks.FLOW_PROFILE_CONTENT, IMMessageKeys.Blocks.FLOW_UNKNOWN_CONTENT, IMMessageKeys.Blocks.RECALLED_CONTENT, IMMessageKeys.Blocks.HIDE_CONTENT});
    }

    public final void a(m<y6b.a<ThreadForwardContentVOV2>> r2, q<y6b.a<ThreadForwardContentVOV2>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        i(r2, r3);
    }

    public final void i(m<?> r4, q<?> r5) {
        Iterator<T> r0 = this.x.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        g(r5, (IMMessageKeys.Blocks) r0.next(), IMMessageKeys.Slots.CONTENT);
        goto L4
    L6:
        OpenCellContentBlock r1 = this.u;
        if (r1 == null) goto L18;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.blueprint.ICell<T of com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardContentBlock.invokeRecycleMethod>");     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.blueprint.ILayout<T of com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardContentBlock.invokeRecycleMethod>");     // Catch: Exception -> L11
        r1.a(r4, r5);     // Catch: Exception -> L11
    L13:
        g(r5, r1.g, IMMessageKeys.Slots.CONTENT);
        g(r5, OpenCellContentBlock.j, IMMessageKeys.Slots.ROOF);
        this.u = null;
        return;
    L11:
        e = move-exception;
        Log.e("FlowThreadForwardContentBlock", "Failed to call IBlock.onRecycled()", e);
        goto L13
    }

    public void update(m<y6b.a<ThreadForwardContentVOV2>> r10, q<y6b.a<ThreadForwardContentVOV2>> r11, y6b.a<ThreadForwardContentVOV2> r12) {
        Intrinsics.checkNotNullParameter(r10, "cell");
        Intrinsics.checkNotNullParameter(r11, "layout");
        Intrinsics.checkNotNullParameter(r12, "data");
        i(r10, r11);
        h((FlowThreadForwardHeaderBlock) this.g.getValue(), r10, r11, r12);
        OpenCellContentBlock r2 = null;
        MessageInfo r0 = new MessageInfo(r12.b().h, null);
        y6b.c r1 = new u2b.c(w.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c), false, false, CollectionsKt.listOf(new y6b.d[]{new com.ss.android.lark.flow.chat.message.profile.a(), new jgb.a(), new jgb.b()})).e(r0, r0.getMessage(), r0.getMessage().getType()).g();
        r1.N2 = true;
        if (r1.j() == false) goto L5;
    L65:
        RecalledContentBlock r13 = (RecalledContentBlock) this.h.getValue();
        Intrinsics.checkNotNull(r1);
        h(r13, r10, r11, r1);
        return;
    L5:
        if (r1.j == true) goto L65;
        if (r1.Y == true) goto L65;
        Message.Type r14 = r12.b().h.getType();
        if (r14 != null) goto L12;
        int r15 = -1;
    L13:
        switch(r15) {
            case 1: goto L62;
            case 2: goto L61;
            case 3: goto L60;
            case 4: goto L59;
            case 5: goto L58;
            case 6: goto L57;
            case 7: goto L56;
            case 8: goto L53;
            case 9: goto L51;
            case 10: goto L50;
            case 11: goto L15;
            default: goto L63;
        };
    L15:
        Intrinsics.checkNotNull(r1);
        if (r1.getType() != Message.Type.CARD) goto L47;
        int r16 = com.ss.android.lark.flow.chat.message.b.a;
        if (com.ss.android.lark.flow.chat.message.b.a(w.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c).C()) == false) goto L47;
        Iterator r17 = ((List) this.v.getValue()).iterator();
    L23:
        if (r17.hasNext() == false) goto L27;
        Object r3 = r17.next();
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a) r3).a(r1) == false) goto L23;
    L28:
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a r4 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.open.a) r3;
        if (r4 == null) goto L47;
        j r18 = r4.c;
        if (r18 == null) goto L47;
        OpenCellContentBlock r5 = (OpenCellContentBlock) ((LinkedHashMap) this.w).get(r18);
        if (r5 == null) goto L36;
    L35:
        r2 = r5;
        goto L47
    L36:
        e r6 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r18, TabAppInfo.IMAGE_JSON_KEY);
        wza.b r7 = (wza.b) ((LinkedHashMap) r6.c).get(r18);
        if (r7 == null) goto L39;
        i r8 = r7.a(((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).a);
    L41:
        if ((r8 instanceof OpenCellContentBlock) == false) goto L43;
        r5 = (OpenCellContentBlock) r8;
    L44:
        if (r5 == null) goto L47;
        this.w.put(r18, r5);
        goto L35
    L43:
        r5 = null;
        goto L44
    L39:
        r8 = null;
        goto L41
    L27:
        r3 = null;
    L47:
        if (r2 == null) goto L49;
        this.u = r2;
    L64:
        Intrinsics.checkNotNull(r1);
        h(r2, r10, r11, r1);
        return;
    L49:
        r2 = (FlowUnknownContentBlock) this.s.getValue();
        goto L64
    L50:
        r2 = (FlowProfileContentBlock) this.r.getValue();
        goto L64
    L51:
        r2 = (FlowAudioContentBlock) this.q.getValue();
        goto L64
    L56:
        r2 = (FolderContentBlock) this.o.getValue();
        goto L64
    L57:
        r2 = (FlowFileContentBlock) this.n.getValue();
        goto L64
    L58:
        r2 = (ShareGroupChatContentBlock) this.m.getValue();
        goto L64
    L59:
        r2 = (MediaContentBlock) this.l.getValue();
        goto L64
    L60:
        r2 = (PostContentBlock) this.k.getValue();
        goto L64
    L61:
        r2 = (ImageContentBlock) this.j.getValue();
        goto L64
    L62:
        r2 = (igb.a) this.i.getValue();
        goto L64
    L63:
        r2 = (FlowUnknownContentBlock) this.s.getValue();
        goto L64
    L53:
        if ((r1.o instanceof ThreadForwardContentVOV2) == false) goto L55;
        r2 = (FlowHideContentBlock) this.t.getValue();
        goto L64
    L55:
        r2 = (FlowMergeForwardContentBlock) this.p.getValue();
        goto L64
    L12:
        r15 = b.a[r14.ordinal()];
        goto L13
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public static void h(i r1, m r2, q r3, Object r4) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.blueprint.ICell<T of com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardContentBlock.invokeUpdateMethod>");     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.blueprint.ILayout<T of com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardContentBlock.invokeUpdateMethod>");     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type T of com.ss.android.lark.flow.chat.message.block.threadforward.FlowThreadForwardContentBlock.invokeUpdateMethod");     // Catch: Exception -> L4
        r1.update(r2, r3, r4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("FlowThreadForwardContentBlock", "Failed to call IBlock.update()", e);
    }
}
