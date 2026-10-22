package com.ss.android.lark.inline.ai.ui.selector.source;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.office_ai_inline.MentionRecommendRequest;
import com.ss.android.lark.pb.office_ai_inline.MentionRecommendResponse;
import com.ss.android.lark.pb.office_ai_inline.Scenario;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RecommendUserDataPuller implements y3c.a {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b<T> implements SdkSender.IParser {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object parse(byte[] r2) {
            return (MentionRecommendResponse) MentionRecommendResponse.ADAPTER.decode(r2);
        }
    }

    static {
    }

    public RecommendUserDataPuller() {
    }

    public final boolean canLoadMore() {
        return false;
    }

    public final boolean needHeader() {
        return false;
    }

    public final void loadData(final IGetDataCallback<List<SearchBaseInfo>> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        SdkSender.sendPassThroughRequest(Command.LARK_OFFICE_AI_INLINE_MENTION_RECOMMEND, new MentionRecommendRequest.Builder().scenario(Scenario.CALENDAR).obj_token("").content("").type("0"), new AnonymousClass1(r4, this), b.a);
    }

    public final void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }
}
