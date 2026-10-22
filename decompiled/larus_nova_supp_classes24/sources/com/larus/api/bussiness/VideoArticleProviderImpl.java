package com.larus.api.bussiness;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.awemeopen.awemesdk.se.Aos;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.platform.model.video.business.IVideoArticleProvider;
import com.larus.platform.uimodel.ArticleParam;
import com.larus.platform.uimodel.VideoParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/api/bussiness/VideoArticleProviderImpl;", "Lcom/larus/platform/model/video/business/IVideoArticleProvider;", "<init>", "()V", "openArticleFragment", "Lcom/larus/platform/model/video/sdkwrapper/feed/IArticleFragmentHolder;", "context", "Landroid/content/Context;", "articleParam", "Lcom/larus/platform/uimodel/ArticleParam;", "ArticleFragmentHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VideoArticleProviderImpl implements IVideoArticleProvider {

    public static final class a implements pr9.f {
        public final n54.a a;

        public final Fragment f() {
            n54.a r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.f();
        }

        public final Boolean onBackPressed() {
            n54.a r0 = this.a;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.onBackPressed();
        }

        public a(Context r5, ArticleParam r6) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "articleParam");
            AosPictureDetailConfig r0 = new AosPictureDetailConfig();
            r0.setEnterAid(r6.getEnterAid());
            JSONObject r1 = new JSONObject();
            r1.put("host_is_article", true);
            r1.put("host_enter_from_group_id", r6.getEnterAid());
            r1.put("host_enter_from", r6.getEnterFrom());
            r1.put("host_rank", r6.getRank());
            r1.put("host_last_message_id", r6.getLastMessageId());
            r1.put("host_impr_index", r6.getImprIndex());
            r1.put("host_req_id", r6.getReqId());
            r1.put("host_slidemode", r6.getSlideMode());
            r1.put("host_card_position", r6.getCardPosition());
            r1.put("host_card_sub_position", r6.getCardSubPosition());
            r1.put("host_rich_media_type", r6.getRichMediaType());
            r1.put("host_module_source", r6.getModuleSource());
            r1.put("host_module_position", r6.getModulePosition());
            r1.put("host_message_id", r6.getMessageId());
            r1.put("host_bot_id", r6.getBotId());
            r1.put("host_section_id", r6.getSectionId());
            VideoParam.RecommendType r2 = r6.getRecommendType();
            if (r2 == null) goto L7;
            String r3 = r2.name();
            if (r3 == null) goto L7;
            r1.put("host_recommend_type", r3);
        L7:
            String r4 = r6.getReplyId();
            if (r4 == null) goto L10;
            r1.put("host_reply_id", r4);
        L10:
            String r7 = r6.getSearchId();
            if (r7 == null) goto L13;
            r1.put("host_key_search_id", r7);
        L13:
            r0.setHostCommonParams(r1);
            this.a = Aos.INSTANCE.getController().createPictureDetailFragment(r5, r0);
        }
    }

    public VideoArticleProviderImpl() {
    }

    public final pr9.f a(Context r2, ArticleParam r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "articleParam");
        return new a(r2, r3);
    }
}
