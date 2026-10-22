package com.ss.android.lark.chat.configurator;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowMessageList;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AutoScrollBottomHandler implements ChatWindowMessageList.a {
    public final IMessageListComponent a;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.biz.im.api.extension.scroll.b {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ AutoScrollBottomHandler b;
        public final /* synthetic */ RecyclerView c;
        public final /* synthetic */ RecyclerView.LayoutManager d;

        public final void a(String r3, ScrollEvent r4) {
            Intrinsics.checkNotNullParameter(r3, "taskId");
            Intrinsics.checkNotNullParameter(r4, "event");
            Ref.BooleanRef r5 = this.a;
            r5.element = AutoScrollBottomHandler.c(this.b, this.c, this.d);
        }

        public final void b(String r1, ScrollEvent r2) {
            com.ss.android.lark.biz.im.api.extension.scroll.b.a.c(r1, r2);
        }

        public final void c(String r2, ScrollEvent r3) {
            Intrinsics.checkNotNullParameter(r2, "taskId");
            Intrinsics.checkNotNullParameter(r3, "event");
        }

        public final void d(String r1, ScrollEvent r2) {
            com.ss.android.lark.biz.im.api.extension.scroll.b.a.b(r1, r2);
        }

        public final void e(String r1, ScrollEvent r2) {
            com.ss.android.lark.biz.im.api.extension.scroll.b.a.a(r1, r2);
        }

        public b(Ref.BooleanRef r1, AutoScrollBottomHandler r2, RecyclerView r3, RecyclerView.LayoutManager r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final void b() {
    }

    public final void a() {
        final SceneCoordinateRecyclerView r5 = this.a.Et();
        if (r5 != null) goto L6;
        Log.e("AutoScrollBottomHandler", "recyclerView == null");
        return;
    L6:
        final StableLinearLayoutManager r3 = r5.getLayoutManager();
        if ((r3 instanceof StableLinearLayoutManager) == true) goto L14;
        StringBuilder r1 = new StringBuilder("unsupported layoutManager:");
        if (r3 == null) goto L11;
        String r2 = r3.getClass().getName();
    L12:
        r1.append(r2);
        Log.e("AutoScrollBottomHandler", r1.toString());
        return;
    L11:
        r2 = null;
        goto L12
    L14:
        final com.ss.android.lark.biz.im.api.extension.scroll.c r4 = this.a.Ar();
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        r5.addOnScrollListener(new AutoScrollBottomHandler$onMessageListPrepared$1(r6, this, r3));
        r4.e(new b(r6, this, r5, r3));
        com.larksuite.framework.ui.b r7 = new AutoScrollBottomHandler$onMessageListPrepared$3(r6, r3, r4, r5, this);
        r3.b = r7;
    }

    public AutoScrollBottomHandler(IMessageListComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.a = r2;
    }

    public static final boolean c(AutoScrollBottomHandler r6, RecyclerView r7, StableLinearLayoutManager r8) {
        r6.getClass();
        RecyclerView.Adapter r9 = r7.getAdapter();
        boolean r0 = true;
        if (r9 != null) goto L5;
        Log.i("AutoScrollBottomHandler", "shouldScrollWhenNextLayout adapter == null");
        return true;
    L5:
        int r10 = r9.getItemCount();
        if (r10 != 0) goto L8;
        Log.d("AutoScrollBottomHandler", "shouldScrollWhenNextLayout itemCount == 0");
        return true;
    L8:
        View r2 = (View) SequencesKt.lastOrNull(ViewGroupKt.getChildren(r7));
        if (r2 != null) goto L11;
        Log.d("AutoScrollBottomHandler", "shouldScrollWhenNextLayout lastChild == null");
        return true;
    L11:
        int r3 = r7.getChildAdapterPosition(r2);
        if ((r3 + 1) == r10) goto L14;
        Log.d("AutoScrollBottomHandler", "shouldScrollWhenNextLayout invalid position:" + r3 + ",count:" + r10);
        return false;
    L14:
        int r11 = r7.getHeight() - r7.getPaddingBottom();
        int r12 = r8.getDecoratedBottom(r2);
        if (r12 >= r11) goto L17;
    L19:
        r0 = false;
    L20:
        Log.d("AutoScrollBottomHandler", "shouldScrollWhenNextLayout shouldScroll:" + r0 + ",childBottom:" + r2.getBottom() + ",decoratedBottom:" + r12 + ",rv:" + r7.getHeight() + "," + r7.getPaddingBottom());
        return r0;
    L17:
        if (r12 >= (r11 + 10)) goto L19;
        goto L19
    }
}
