package com.ss.android.lark.flow.chat.multi_select;

import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.extension.message.MultiSelectContext;
import com.ss.android.lark.biz.im.api.extension.message.i;
import com.ss.android.lark.biz.im.api.extension.message.k;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.flow.plugin.select.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements k {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.multi_select.b$b, reason: collision with other inner class name */
    public final class C0032b implements i {
        public final MultiSelectContext a;

        /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.multi_select.b$b$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MultiSelectContext.Page.values().length];
                r0[MultiSelectContext.Page.CHAT_WINDOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[MultiSelectContext.Page.THREAD_DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[MultiSelectContext.Page.REPLY_IN_THREAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[MultiSelectContext.Page.PRIVATE_THREAD_MERGE_FORWARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public final int getId() {
            return 10;
        }

        public final void onClick() {
            Chat r3 = this.a.getChat();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.Chat");
            if (y0.c(r3) == true) goto L6;
            y0.g(this.a.getContext());
            return;
        L6:
            List r0 = this.a.e();
            Log.i("MergeForwardMultiSelectProvider", "selectedMessageIds:" + r0.size());
            this.a.a();
            ArrayList r4 = new ArrayList();
            r4.addAll(r0);
            int r1 = a.a[this.a.getPage().ordinal()];
            if (r1 != 1) goto L9;
        L16:
            int r2 = FlowChatModule.d;
            FlowChatModule.a.a().a().getForwardDependency().a(this.a.getContext(), r3, r4, 9, new ContentListenerImpl());
            return;
        L9:
            if (r1 == 2) goto L16;
            if (r1 == 3) goto L16;
            if (r1 != 4) goto L16;
            int r5 = com.ss.android.lark.statistics.multiselect.a.a;
            Statistics.sendEvent("multiselect_forward_click", com.ss.android.lark.statistics.multiselect.a.a.a(false));
            goto L16
        }

        public C0032b(f r1, BaseFragment r2) {
            Intrinsics.checkNotNullParameter(r1, "multiSelectContext");
            this.a = r1;
        }
    }

    static {
    }

    public b() {
    }

    public final boolean b(f r2) {
        Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
        return true;
    }

    public final Collection<MultiSelectContext.Page> c() {
        return CollectionsKt.listOf(MultiSelectContext.Page.CHAT_WINDOW);
    }

    public final i a(f r2, BaseFragment r3) {
        Intrinsics.checkNotNullParameter(r2, "multiSelectContext");
        return new C0032b(r2, r3);
    }
}
