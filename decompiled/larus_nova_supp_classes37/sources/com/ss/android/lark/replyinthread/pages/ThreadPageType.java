package com.ss.android.lark.replyinthread.pages;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/replyinthread/pages/ThreadPageType;", "", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public @interface ThreadPageType {
    public static final int CARD_VISITOR_THREAD = 1;
    public static final a Companion = null;
    public static final int MERGE_FORWARD_VISITOR_THREAD = 2;
    public static final int NORMAL = 0;
    public static final int PREVIEW_VISITOR_THREAD = 3;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
