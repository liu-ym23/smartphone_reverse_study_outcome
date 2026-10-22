package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility;

import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.j;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageVisibleManager {
    public final RecyclerView a;
    public final MessageVisibleHintPointParams b;
    public final b c;
    public final HashMap<String, Long> d;
    public y6b.c<?> e;
    public final MessageVisibleManager$1$1 f;
    public com.ss.android.lark.chat.chatwindow.chat.a g;
    public MessageVisibleEntity h;
    public final LinkedList<Pair<y6b.c<?>, Long>> i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/MessageVisibleManager$CalculateExposeTimeScene;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "MESSAGE_LIST_UPDATE", "SCROLL_STATE_IDLE", "ON_START", "ON_STOP", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CalculateExposeTimeScene extends Enum<CalculateExposeTimeScene> {
        public static final CalculateExposeTimeScene MESSAGE_LIST_UPDATE = null;
        public static final CalculateExposeTimeScene ON_START = null;
        public static final CalculateExposeTimeScene ON_STOP = null;
        public static final CalculateExposeTimeScene SCROLL_STATE_IDLE = null;
        public static final /* synthetic */ CalculateExposeTimeScene[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CalculateExposeTimeScene> getEntries() {
            return b;
        }

        static {
            CalculateExposeTimeScene r0 = new CalculateExposeTimeScene("MESSAGE_LIST_UPDATE", 0);
            MESSAGE_LIST_UPDATE = r0;
            CalculateExposeTimeScene r1 = new CalculateExposeTimeScene("SCROLL_STATE_IDLE", 1);
            SCROLL_STATE_IDLE = r1;
            CalculateExposeTimeScene r3 = new CalculateExposeTimeScene("ON_START", 2);
            ON_START = r3;
            CalculateExposeTimeScene r5 = new CalculateExposeTimeScene("ON_STOP", 3);
            ON_STOP = r5;
            CalculateExposeTimeScene[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static CalculateExposeTimeScene[] values() {
            return (CalculateExposeTimeScene[]) a.clone();
        }

        public static CalculateExposeTimeScene valueOf(String r1) {
            return (CalculateExposeTimeScene) r27.a.a(CalculateExposeTimeScene.class, r1);
        }

        public CalculateExposeTimeScene(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(MessageVisibleEntity r1);

        void b(y6b.c<?> r1, MessageVisibleHintPointParams r2);
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CalculateExposeTimeScene.values().length];
            r0[CalculateExposeTimeScene.ON_STOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    public final com.ss.android.lark.chat.chatwindow.chat.a b() {
        com.ss.android.lark.chat.chatwindow.chat.a r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        RecyclerView r1 = this.a;
        if (r1 == null) goto L8;
        RecyclerView.Adapter r2 = r1.getAdapter();
    L10:
        if ((r2 instanceof ConcatAdapter) == false) goto L12;
        ConcatAdapter r3 = (ConcatAdapter) r2;
    L13:
        if (r3 == null) goto L15;
        List r4 = r3.getAdapters();
    L16:
        int r5 = 0;
        if (r4 == null) goto L19;
        int r6 = r4.size();
    L20:
        if (r5 >= r6) goto L29;
        if (r4 == null) goto L23;
        RecyclerView.Adapter r7 = (RecyclerView.Adapter) ListProtector.get(r4, r5);
    L25:
        if ((r7 instanceof com.ss.android.lark.chat.chatwindow.chat.a) == true) goto L26;
        r5 = r5 + 1;
        goto L20
    L26:
        Log.i("MessageVisibleManager", "current adapter is IChatAdapter.");
        com.ss.android.lark.chat.chatwindow.chat.a r8 = (com.ss.android.lark.chat.chatwindow.chat.a) r7;
        this.g = r8;
        return r8;
    L23:
        r7 = null;
        goto L25
    L29:
        return null;
    L19:
        r6 = 0;
        goto L20
    L15:
        r4 = null;
        goto L16
    L12:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L10
    }

    public final void a(CalculateExposeTimeScene r12) {
        Intrinsics.checkNotNullParameter(r12, "calculateExposeTimeScene");
        RecyclerView r0 = this.a;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
    L6:
        if (r1 != null) goto L8;
    L10:
        int r2 = -1;
        int r3 = -1;
    L11:
        com.ss.android.lark.chat.chatwindow.chat.a r4 = b();
        if (r4 == null) goto L16;
        List<y6b.c<?>> r5 = r4.h();
        if (r5 == null) goto L16;
        int r6 = r5.size();
    L18:
        if (this.h != null) goto L20;
        this.h = new MessageVisibleEntity();
    L20:
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L45;
        boolean r8 = true;
        if (c.a[r12.ordinal()] != 1) goto L25;
        c(r7);
    L44:
        r7 = r7 + 1;
        goto L21
    L25:
        if (r2 > r7) goto L28;
        if (r7 > r3) goto L28;
    L29:
        if (r8 == false) goto L43;
        com.ss.android.lark.chat.chatwindow.chat.a r9 = b();
        if (r9 == null) goto L33;
        y6b.c<?> r10 = (y6b.c) r9.getItem(r7);
    L34:
        this.e = r10;
        if (r10 == null) goto L37;
        this.c.b(r10, this.b);
    L37:
        y6b.c<?> r11 = this.e;
        if (r11 == null) goto L41;
        String r13 = r11.c;
        if (r13 == null) goto L41;
    L42:
        long r14 = System.currentTimeMillis();
        this.d.put(r13, Long.valueOf(r14));
        Log.i("MessageVisibleManager", "visibleMsgStartTimeStamp key: " + r13 + ", value: " + r14 + " ms.");
    L41:
        r13 = BuildConfig.FLAVOR;
        goto L42
    L33:
        r10 = null;
        goto L34
    L43:
        c(r7);
    L28:
        r8 = false;
        goto L29
    L45:
        MessageVisibleEntity r15 = this.h;
        if (r15 == null) goto L48;
        r15.setMessageVisibleHintPointParams(this.b);
    L48:
        this.c.a(this.h);
        LinkedList<Pair<y6b.c<?>, Long>> r16 = this.i;
        if (r16 == null) goto L56;
        r16.clear();
        return;
    L56:
        return;
    L16:
        r6 = 0;
        goto L18
    L8:
        if ((r1 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r17 = (LinearLayoutManager) r1;
        r2 = r17.findFirstVisibleItemPosition();
        r3 = r17.findLastVisibleItemPosition();
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    public final void c(int r7) {
        long r0 = System.currentTimeMillis();
        com.ss.android.lark.chat.chatwindow.chat.a r2 = b();
        if (r2 == null) goto L5;
        y6b.c r3 = (y6b.c) r2.getItem(r7);
    L6:
        HashMap<String, Long> r4 = this.d;
        if (r3 == null) goto L10;
        String r5 = r3.c;
        if (r5 == null) goto L10;
    L11:
        Long r6 = r4.remove(r5);
        if (r6 == null) goto L36;
        if (r3 == null) goto L16;
        Message.Type r8 = r3.getType();
        if (r8 == null) goto L16;
    L17:
        MessageVisibleHintPointParams r9 = this.b;
        if (r9 == null) goto L24;
        LinkedList<Message.Type> r10 = r9.getUnTrackedMessageTypes();
        if (r10 == null) goto L24;
        boolean r11 = r10.contains(r8);
        boolean r12 = true;
        if (r11 != true) goto L24;
    L25:
        if (r12 == false) goto L27;
        return;
    L27:
        long r1 = r0 - r6.longValue();
        Log.i("MessageVisibleManager", "pos: " + r7 + ", exposure time: " + r1 + " ms.");
        if (r3 == null) goto L37;
        Pair<y6b.c<?>, Long> r13 = TuplesKt.to(r3, Long.valueOf(r1));
        LinkedList<Pair<y6b.c<?>, Long>> r14 = this.i;
        if (r14 == null) goto L32;
        r14.add(r13);
    L32:
        MessageVisibleEntity r15 = this.h;
        if (r15 == null) goto L38;
        r15.setVisibleMessageWithDurationPairs(this.i);
        return;
    L38:
        return;
    L37:
        return;
    L24:
        r12 = false;
    L16:
        r8 = Message.Type.UNKNOWN;
        goto L17
    L36:
        return;
    L10:
        r5 = BuildConfig.FLAVOR;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleManager$1$1, java.lang.Object] */
    public MessageVisibleManager(SceneCoordinateRecyclerView r2, MessageVisibleHintPointParams r3, j r4) {
        Intrinsics.checkNotNullParameter(r4, "mMessageVisibleWatcher");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new HashMap();
        this.i = new LinkedList();
        if (r2 != null) goto L6;
        Log.e("MessageVisibleManager", "recyclerView list is null.");
    L6:
        if ((r2 instanceof SceneCoordinateRecyclerView) == false) goto L8;
        SceneCoordinateRecyclerView r5 = r2;
    L9:
        if (r5 == null) goto L12;
        a(CalculateExposeTimeScene.MESSAGE_LIST_UPDATE);
        ?? r6 = new MessageVisibleManager$1$1(this);
        this.f = r6;
        r5.setViewLifecycleInterface(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.a(this, r5));
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.OnScrollListener");
        r2.addOnScrollListener(r6);
        return;
    L12:
        return;
    L8:
        r5 = null;
        goto L9
    }
}
