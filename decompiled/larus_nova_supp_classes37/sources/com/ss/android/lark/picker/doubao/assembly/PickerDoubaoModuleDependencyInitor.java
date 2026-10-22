package com.ss.android.lark.picker.doubao.assembly;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.list.cover.CoverLoader;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.image.entity.b;
import com.ss.android.lark.image.entity.c;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.RecentListPageResult;
import com.ss.android.lark.picker.doubao.assembly.highlight.DoubaoHighlightUtils;
import com.ss.android.lark.picker.doubao.assembly.list.DoubaoRecentListFetcher;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.TagContent;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import w3c.a;
import w3c.d;
import w3c.g;
import w3c.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ClaymoreImpl(PickerBaseModuleDependency.IPickerCommonModuleDependency.class)
public class PickerDoubaoModuleDependencyInitor implements PickerBaseModuleDependency.IPickerCommonModuleDependency {

    public static final class DocCoverLoaderHolder {
        private static final CoverLoader INSTANCE = null;

        private DocCoverLoaderHolder() {
        }

        static {
            INSTANCE = new CoverLoader();
        }

        public static /* synthetic */ CoverLoader access$000() {
            return INSTANCE;
        }
    }

    public PickerDoubaoModuleDependencyInitor() {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public c findImageCache(String r1, ArrayList<b> r2, String r3) {
        return null;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public Locale getCachedLanguageSetting() {
        return null;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void getChatById(String r1, IGetDataCallback<Chat> r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public int getDocIcon(int r1, String r2) {
        return 0;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public int getDocInlineBlueIcon(int r1) {
        return 0;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public int getDocInlineGreyIcon(int r1) {
        return 0;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public int getFolderIcon(boolean r1) {
        return 0;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public String getLoginUserTenantId() {
        return "";
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public String getNameWithAnotherName(Chatter r1) {
        return "";
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public Drawable getOpenedUserStatusDrawable(Context r1, List<com.bytedance.lark.pb.basic.v1.Chatter.ChatterCustomStatus> r2, boolean r3) {
        return null;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public int getUDIconByKey(String r1) {
        return 0;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public int getWikiIcon(int r1, String r2) {
        return 0;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public boolean isCustomer() {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public boolean isJumpToReplyInThread(String r1, int r2) {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public boolean isSimpleTenant() {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void loadImage(Context r1, String r2, ImageView r3, Drawable r4, Drawable r5, int r6, int r7) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void openChat(String r1, int r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void openReplyInThread(String r1, int r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void openSchema(Context r1, String r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void openThread(String r1, int r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void peakFeedCard(String r1, SearchCommonConstants.FeedType r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void startBotProfileActivityByBotId(Context r1, String r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void startContactsProfileActivityByChatterId(Context r1, String r2) {
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public boolean tryMyAIOnBoarding() {
        return false;
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public String getLoginUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    private static CoverLoader getDocCoverLoader() {
        return DocCoverLoaderHolder.access$000();
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public boolean isSupportDocCover(String r3) {
        getDocCoverLoader().getClass();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        HashSet r0 = CoverLoader.c;
        if (r3 == null) goto L8;
        String r4 = r3.toLowerCase(Locale.ROOT);
    L10:
        return CollectionsKt.contains(r0, r4);
    L8:
        r4 = null;
        goto L10
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public v3c.c makeDynamicRender(Context r1) {
        return new AnonymousClass1(this);
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void registerModelBinder(b08.c r4) {
        r4.registerModelBinder(g.class, TextView.class, f4c.g.a);
        r4.registerModelBinder(h.class, EllipsizedEmojiconTextView.class, f4c.h.a);
        r4.registerModelBinder(a.class, TextView.class, f4c.a.a);
        r4.registerModelBinder(d.class, TextView.class, f4c.c.a);
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void addSearchHighLightedTag(SpannableStringBuilder r1, TextView r2, List<TagContent> r3, int r4) {
        DoubaoHighlightUtils.addSearchHighLightedTagInternal(r1, r2, r3, r4);
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void bindHighLightTitle(TextView r2, CharSequence r3, List<TagContent> r4, int r5) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        r2.setText("");
        return;
    L7:
        if (CollectionUtils.isEmpty(r4) == false) goto L10;
        r2.setText(r3);
        return;
    L10:
        DoubaoHighlightUtils.addSearchHighLightedTagInternal(new SpannableStringBuilder(r3), r2, r4, r5);
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public void fetchRecentListPage(String r1, int r2, List<Integer> r3, IGetDataCallback<RecentListPageResult> r4) {
        DoubaoRecentListFetcher.fetchRecentListPage(r1, r2, r3, r4);
    }

    @Override // com.ss.android.lark.picker.base.PickerBaseModuleDependency.IPickerCommonModuleDependency
    public String loadDocCover(Context r9, ImageView r10, String r11, int r12, int r13, String r14, int r15) {
        return getDocCoverLoader().b(r9, r10, r11, r12, r13, r14, r15);
    }
}
