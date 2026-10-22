package com.ss.android.lark.picker.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.image.entity.b;
import com.ss.android.lark.image.entity.c;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.TagContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0007R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency;", "", "<init>", "()V", "commonModuleDependency", "Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency$IPickerCommonModuleDependency;", "getCommonModuleDependency", "()Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency$IPickerCommonModuleDependency;", "commonModuleDependency$delegate", "Lkotlin/Lazy;", "getDependency", "IPickerCommonModuleDependency", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PickerBaseModuleDependency {
    public static final PickerBaseModuleDependency INSTANCE = null;
    private static final Lazy commonModuleDependency$delegate = null;

    @Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H'J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H'J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H'J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH'J\u001c\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u001c\u0010\u001b\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 H'JJ\u0010\"\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH&J\u0012\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0007H&J4\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00072\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`32\b\u00104\u001a\u0004\u0018\u00010\u0007H&J\n\u00105\u001a\u0004\u0018\u000106H&J\u001a\u00107\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u00108\u001a\u00020\rH&J\u001a\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\rH&J\u001c\u0010<\u001a\u00020\u00162\b\u0010=\u001a\u0004\u0018\u00010\u00072\b\u0010>\u001a\u0004\u0018\u00010?H&J\u001a\u0010@\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020\rH&J\u001a\u0010A\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010B\u001a\u00020\rH&J\u001a\u0010C\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010D\u001a\u0004\u0018\u00010\u0007H&J*\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010G2\u0006\u0010I\u001a\u00020\u0003H&J\u0010\u0010J\u001a\u00020K2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020NH&J2\u0010O\u001a\u00020\u00162\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010G2\b\b\u0001\u0010V\u001a\u00020\rH&J4\u0010W\u001a\u00020\u00162\u0006\u0010R\u001a\u00020S2\b\u0010X\u001a\u0004\u0018\u00010Y2\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010G2\b\b\u0001\u0010V\u001a\u00020\rH&J>\u0010Z\u001a\u00020\u00162\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\\\u001a\u00020\r2\u0010\b\u0002\u0010]\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010G2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020^0 H&J\u0012\u0010_\u001a\u00020\u00032\b\u0010`\u001a\u0004\u0018\u00010\u0007H&JD\u0010a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\r2\u0006\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004¨\u0006g"}, d2 = {"Lcom/ss/android/lark/picker/base/PickerBaseModuleDependency$IPickerCommonModuleDependency;", "", "isSimpleTenant", "", "()Z", "isCustomer", "getLoginUserTenantId", "", "getLoginUserId", "getNameWithAnotherName", "chatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getDocIcon", "", "docType", "fileName", "getWikiIcon", "getFolderIcon", "isShareFolder", "getDocInlineBlueIcon", "getDocInlineGreyIcon", "startContactsProfileActivityByChatterId", "", "context", "Landroid/content/Context;", "chatterId", "tryMyAIOnBoarding", "startBotProfileActivityByBotId", "botId", "getChatById", "chatId", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "loadImage", "localPathOrUrl", "imageView", "Landroid/widget/ImageView;", "placeHolder", "Landroid/graphics/drawable/Drawable;", "errorHolder", "imageWidth", "imageHeight", "getUDIconByKey", "key", "findImageCache", "Lcom/ss/android/lark/image/entity/ImageCache;", "scene", "keyOrder", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/image/entity/FindKey;", "Lkotlin/collections/ArrayList;", "originKey", "getCachedLanguageSetting", "Ljava/util/Locale;", "openChat", "msgPosition", "openThread", "threadId", "threadPosition", "peakFeedCard", "feedId", "feedType", "Lcom/ss/android/lark/search/dto/constant/SearchCommonConstants$FeedType;", "openReplyInThread", "isJumpToReplyInThread", "messagePosition", "openSchema", "link", "getOpenedUserStatusDrawable", "userStatusList", "", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "isScale", "makeDynamicRender", "Lcom/ss/android/lark/search/dto/ISearchDynamicRender;", "registerModelBinder", "container", "Lcom/larksuite/component/ui/list/ICompositeComponent;", "addSearchHighLightedTag", "builder", "Landroid/text/SpannableStringBuilder;", "textView", "Landroid/widget/TextView;", "tagList", "Lcom/ss/android/lark/search/dto/info/TagContent;", "highLightColor", "bindHighLightTitle", "title", "", "fetchRecentListPage", "lastLabel", "length", "objTypeList", "Lcom/ss/android/lark/picker/base/RecentListPageResult;", "isSupportDocCover", "type", "loadDocCover", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "height", "width", "policy", "cornerRadius", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public interface IPickerCommonModuleDependency {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void fetchRecentListPage$default(IPickerCommonModuleDependency r1, String r2, int r3, List r4, IGetDataCallback r5, int r6, Object r7) {
                if (r7 != null) goto L15;
                if ((r6 & 1) == 0) goto L7;
                r2 = null;
            L7:
                if ((r6 & 2) == 0) goto L10;
                r3 = 20;
            L10:
                if ((r6 & 4) == 0) goto L12;
                r4 = null;
            L12:
                r1.fetchRecentListPage(r2, r3, r4, r5);
                return;
            L15:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchRecentListPage");
            }

            public static /* synthetic */ String loadDocCover$default(IPickerCommonModuleDependency r9, Context r10, ImageView r11, String r12, int r13, int r14, String r15, int r16, int r17, Object r18) {
                if (r18 != null) goto L10;
                if ((r17 & 64) == 0) goto L6;
                int r8 = 0;
            L8:
                return r9.loadDocCover(r10, r11, r12, r13, r14, r15, r8);
            L6:
                r8 = r16;
                goto L8
            L10:
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadDocCover");
            }
        }

        void addSearchHighLightedTag(SpannableStringBuilder r1, TextView r2, List<TagContent> r3, int r4);

        void bindHighLightTitle(TextView r1, CharSequence r2, List<TagContent> r3, int r4);

        void fetchRecentListPage(String r1, int r2, List<Integer> r3, IGetDataCallback<RecentListPageResult> r4);

        c findImageCache(String r1, ArrayList<b> r2, String r3);

        Locale getCachedLanguageSetting();

        void getChatById(String r1, IGetDataCallback<Chat> r2);

        int getDocIcon(int r1, String r2);

        int getDocInlineBlueIcon(int r1);

        int getDocInlineGreyIcon(int r1);

        int getFolderIcon(boolean r1);

        String getLoginUserId();

        String getLoginUserTenantId();

        String getNameWithAnotherName(Chatter r1);

        Drawable getOpenedUserStatusDrawable(Context r1, List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r2, boolean r3);

        int getUDIconByKey(String r1);

        int getWikiIcon(int r1, String r2);

        boolean isCustomer();

        boolean isJumpToReplyInThread(String r1, int r2);

        boolean isSimpleTenant();

        boolean isSupportDocCover(String r1);

        String loadDocCover(Context r1, ImageView r2, String r3, int r4, int r5, String r6, int r7);

        void loadImage(Context r1, String r2, ImageView r3, Drawable r4, Drawable r5, int r6, int r7);

        v3c.c makeDynamicRender(Context r1);

        void openChat(String r1, int r2);

        void openReplyInThread(String r1, int r2);

        void openSchema(Context r1, String r2);

        void openThread(String r1, int r2);

        void peakFeedCard(String r1, SearchCommonConstants.FeedType r2);

        void registerModelBinder(b08.c r1);

        void startBotProfileActivityByBotId(Context r1, String r2);

        void startContactsProfileActivityByChatterId(Context r1, String r2);

        boolean tryMyAIOnBoarding();
    }

    private PickerBaseModuleDependency() {
    }

    static {
        INSTANCE = new PickerBaseModuleDependency();
        commonModuleDependency$delegate = LazyKt.lazy(PickerBaseModuleDependency$commonModuleDependency$2.INSTANCE);
    }

    private final IPickerCommonModuleDependency getCommonModuleDependency() {
        return (IPickerCommonModuleDependency) commonModuleDependency$delegate.getValue();
    }

    @JvmStatic
    public static final IPickerCommonModuleDependency getDependency() {
        IPickerCommonModuleDependency r0 = INSTANCE.getCommonModuleDependency();
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
