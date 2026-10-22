package com.ss.android.lark.feed.shared.hitpoint;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.constant.ChatFromType;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedHitPointNew {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedClickSubType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Button", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedClickSubType extends Enum<FeedClickSubType> {
        public static final FeedClickSubType Button = null;
        public static final /* synthetic */ FeedClickSubType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<FeedClickSubType> getEntries() {
            return b;
        }

        static {
            FeedClickSubType r0 = new FeedClickSubType();
            Button = r0;
            FeedClickSubType[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
        }

        public FeedClickSubType() {
            super("Button", 0);
            this.value = "cta";
        }

        public static FeedClickSubType[] values() {
            return (FeedClickSubType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static FeedClickSubType valueOf(String r1) {
            return (FeedClickSubType) r27.a.a(FeedClickSubType.class, r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedDelayedPopupClickParam;", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, BuildConfig.FLAVOR, "target", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "ESC", "OPEN", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedDelayedPopupClickParam extends Enum<FeedDelayedPopupClickParam> {
        public static final FeedDelayedPopupClickParam ESC = null;
        public static final FeedDelayedPopupClickParam OPEN = null;
        public static final /* synthetic */ FeedDelayedPopupClickParam[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String action;
        private final String target;

        public static EnumEntries<FeedDelayedPopupClickParam> getEntries() {
            return b;
        }

        static {
            FeedDelayedPopupClickParam r0 = new FeedDelayedPopupClickParam("ESC", 0, "esc", "feed_main_view");
            ESC = r0;
            FeedDelayedPopupClickParam r1 = new FeedDelayedPopupClickParam("OPEN", 1, "open", "feed_grouping_edit_view");
            OPEN = r1;
            FeedDelayedPopupClickParam[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static FeedDelayedPopupClickParam[] values() {
            return (FeedDelayedPopupClickParam[]) a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static FeedDelayedPopupClickParam valueOf(String r1) {
            return (FeedDelayedPopupClickParam) r27.a.a(FeedDelayedPopupClickParam.class, r1);
        }

        public FeedDelayedPopupClickParam(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.action = r3;
            this.target = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedGroupingEditClickParam;", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, BuildConfig.FLAVOR, "target", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "FEED_GROUPING_EDIT_FILTER_TOGGLE", "FEED_GROUPING_EDIT_SAVE", "FEED_GROUPING_EDIT_CLOSE", "FEED_GROUPING_EDIT_MINUS", "FEED_GROUPING_EDIT_PLUS", "FEED_FILTER_TOGGLE", "FEED_MUTE_FILTER_TOGGLE", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedGroupingEditClickParam extends Enum<FeedGroupingEditClickParam> {
        public static final FeedGroupingEditClickParam FEED_FILTER_TOGGLE = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_CLOSE = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_FILTER_TOGGLE = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_MINUS = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_PLUS = null;
        public static final FeedGroupingEditClickParam FEED_GROUPING_EDIT_SAVE = null;
        public static final FeedGroupingEditClickParam FEED_MUTE_FILTER_TOGGLE = null;
        public static final /* synthetic */ FeedGroupingEditClickParam[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String action;
        private final String target;

        public static EnumEntries<FeedGroupingEditClickParam> getEntries() {
            return b;
        }

        static {
            FeedGroupingEditClickParam r0 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_FILTER_TOGGLE", 0, "feed_grouping_edit_filter_toggle");
            FEED_GROUPING_EDIT_FILTER_TOGGLE = r0;
            FeedGroupingEditClickParam r1 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_SAVE", 1, "feed_grouping_edit_save");
            FEED_GROUPING_EDIT_SAVE = r1;
            FeedGroupingEditClickParam r2 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_CLOSE", 2, "feed_grouping_edit_close");
            FEED_GROUPING_EDIT_CLOSE = r2;
            FeedGroupingEditClickParam r5 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_MINUS", 3, "feed_grouping_edit_minus");
            FEED_GROUPING_EDIT_MINUS = r5;
            FeedGroupingEditClickParam r7 = new FeedGroupingEditClickParam("FEED_GROUPING_EDIT_PLUS", 4, "feed_grouping_edit_plus");
            FEED_GROUPING_EDIT_PLUS = r7;
            FeedGroupingEditClickParam r9 = new FeedGroupingEditClickParam("FEED_FILTER_TOGGLE", 5, "efficiency_feed_grouping_edit_filter_toggle");
            FEED_FILTER_TOGGLE = r9;
            FeedGroupingEditClickParam r11 = new FeedGroupingEditClickParam("FEED_MUTE_FILTER_TOGGLE", 6, "efficiency_mute_toggle");
            FEED_MUTE_FILTER_TOGGLE = r11;
            FeedGroupingEditClickParam[] r13 = {r0, r1, r2, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
        }

        public static FeedGroupingEditClickParam[] values() {
            return (FeedGroupingEditClickParam[]) a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static FeedGroupingEditClickParam valueOf(String r1) {
            return (FeedGroupingEditClickParam) r27.a.a(FeedGroupingEditClickParam.class, r1);
        }

        public FeedGroupingEditClickParam(String r1, int r2, String r3) {
            super(r1, r2);
            this.action = r3;
            this.target = "none";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedMainClickParam;", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, BuildConfig.FLAVOR, "target", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "FEED_GROUPING_TAB", "FEED_MORE_TAB_MOBILE", "FEED_LEFTCLICK_CHAT", "FEED_LEFTCLICK_DOC", "FEED_LEFTCLICK_APP_FEED", "FEED_LEFTSLIDE", "FEED_RIGHTSLIDE", "FEED_DONE_MOBILE", "MESSAGE_SETTING", "FEED_MORE_TAB_TO_SETTING", "FEED_MORE_TAB_TO_EDIT", "FEED_MORE_TAB_TO_CANCEL", "MSG_LEFTCLICK", "MSG_PRESS", "FEED_PRESS", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedMainClickParam extends Enum<FeedMainClickParam> {
        public static final FeedMainClickParam FEED_DONE_MOBILE = null;
        public static final FeedMainClickParam FEED_GROUPING_TAB = null;
        public static final FeedMainClickParam FEED_LEFTCLICK_APP_FEED = null;
        public static final FeedMainClickParam FEED_LEFTCLICK_CHAT = null;
        public static final FeedMainClickParam FEED_LEFTCLICK_DOC = null;
        public static final FeedMainClickParam FEED_LEFTSLIDE = null;
        public static final FeedMainClickParam FEED_MORE_TAB_MOBILE = null;
        public static final FeedMainClickParam FEED_MORE_TAB_TO_CANCEL = null;
        public static final FeedMainClickParam FEED_MORE_TAB_TO_EDIT = null;
        public static final FeedMainClickParam FEED_MORE_TAB_TO_SETTING = null;
        public static final FeedMainClickParam FEED_PRESS = null;
        public static final FeedMainClickParam FEED_RIGHTSLIDE = null;
        public static final FeedMainClickParam MESSAGE_SETTING = null;
        public static final FeedMainClickParam MSG_LEFTCLICK = null;
        public static final FeedMainClickParam MSG_PRESS = null;
        public static final /* synthetic */ FeedMainClickParam[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String action;
        private final String target;

        public static EnumEntries<FeedMainClickParam> getEntries() {
            return b;
        }

        static {
            FeedMainClickParam r0 = new FeedMainClickParam("FEED_GROUPING_TAB", 0, "feed_grouping_tab", "none");
            FEED_GROUPING_TAB = r0;
            FeedMainClickParam r1 = new FeedMainClickParam("FEED_MORE_TAB_MOBILE", 1, "feed_more_tab_mobile", "feed_grouping_edit_view");
            FEED_MORE_TAB_MOBILE = r1;
            FeedMainClickParam r3 = new FeedMainClickParam("FEED_LEFTCLICK_CHAT", 2, "feed_leftclick_chat", "im_chat_main_view");
            FEED_LEFTCLICK_CHAT = r3;
            FeedMainClickParam r6 = new FeedMainClickParam("FEED_LEFTCLICK_DOC", 3, "feed_leftclick_doc", "ccm_docs_page_view");
            FEED_LEFTCLICK_DOC = r6;
            FeedMainClickParam r9 = new FeedMainClickParam("FEED_LEFTCLICK_APP_FEED", 4, "leftclick_app_feed_card", BuildConfig.FLAVOR);
            FEED_LEFTCLICK_APP_FEED = r9;
            FeedMainClickParam r11 = new FeedMainClickParam("FEED_LEFTSLIDE", 5, "feed_leftslide", "feed_leftslide_detail_view");
            FEED_LEFTSLIDE = r11;
            FeedMainClickParam r12 = new FeedMainClickParam("FEED_RIGHTSLIDE", 6, "feed_rightslide", "feed_rightslide_detail_view");
            FEED_RIGHTSLIDE = r12;
            FeedMainClickParam r8 = new FeedMainClickParam("FEED_DONE_MOBILE", 7, "feed_done_mobile", BuildConfig.FLAVOR);
            FEED_DONE_MOBILE = r8;
            FeedMainClickParam r13 = new FeedMainClickParam("MESSAGE_SETTING", 8, "message_setting", "setting_main_view");
            MESSAGE_SETTING = r13;
            FeedMainClickParam r5 = new FeedMainClickParam("FEED_MORE_TAB_TO_SETTING", 9, "grouping_setting", "setting_detail_view");
            FEED_MORE_TAB_TO_SETTING = r5;
            FeedMainClickParam r2 = new FeedMainClickParam("FEED_MORE_TAB_TO_EDIT", 10, "feed_grouping_edit", "feed_grouping_edit_view");
            FEED_MORE_TAB_TO_EDIT = r2;
            FeedMainClickParam r7 = new FeedMainClickParam("FEED_MORE_TAB_TO_CANCEL", 11, ChameleonOpenTracker.OpenResult.CANCEL, "none");
            FEED_MORE_TAB_TO_CANCEL = r7;
            FeedMainClickParam r4 = new FeedMainClickParam("MSG_LEFTCLICK", 12, "msg_leftclick", "im_chat_main_view");
            MSG_LEFTCLICK = r4;
            FeedMainClickParam r10 = new FeedMainClickParam("MSG_PRESS", 13, "msg_press", "feed_msg_press_view");
            MSG_PRESS = r10;
            FeedMainClickParam r14 = new FeedMainClickParam("FEED_PRESS", 14, "feed_press", "feed_press_view");
            FEED_PRESS = r14;
            FeedMainClickParam[] r15 = {r0, r1, r3, r6, r9, r11, r12, r8, r13, r5, r2, r7, r4, r10, r14};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
        }

        public static FeedMainClickParam[] values() {
            return (FeedMainClickParam[]) a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static FeedMainClickParam valueOf(String r1) {
            return (FeedMainClickParam) r27.a.a(FeedMainClickParam.class, r1);
        }

        public FeedMainClickParam(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.action = r3;
            this.target = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$FeedStatusUpdateType;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TITLE_UPDATE", "AVATAR_UPDATE", "BADGE_UPDATE", "DISPLAY_TIME_UPDATE", "RANK_TIME_UPDATE", "DONE", "CANCEL_DONE", "MUTE", "CANCEL_MUTE", "ON_TEMP_TOP", "CANCEL_TEMP_TOP", "BUTTON_UPDATE", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedStatusUpdateType extends Enum<FeedStatusUpdateType> {
        public static final FeedStatusUpdateType AVATAR_UPDATE = null;
        public static final FeedStatusUpdateType BADGE_UPDATE = null;
        public static final FeedStatusUpdateType BUTTON_UPDATE = null;
        public static final FeedStatusUpdateType CANCEL_DONE = null;
        public static final FeedStatusUpdateType CANCEL_MUTE = null;
        public static final FeedStatusUpdateType CANCEL_TEMP_TOP = null;
        public static final FeedStatusUpdateType DISPLAY_TIME_UPDATE = null;
        public static final FeedStatusUpdateType DONE = null;
        public static final FeedStatusUpdateType MUTE = null;
        public static final FeedStatusUpdateType ON_TEMP_TOP = null;
        public static final FeedStatusUpdateType RANK_TIME_UPDATE = null;
        public static final FeedStatusUpdateType TITLE_UPDATE = null;
        public static final /* synthetic */ FeedStatusUpdateType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<FeedStatusUpdateType> getEntries() {
            return b;
        }

        static {
            FeedStatusUpdateType r0 = new FeedStatusUpdateType("TITLE_UPDATE", 0, DocTabPayload.DocType.SHEET);
            TITLE_UPDATE = r0;
            FeedStatusUpdateType r1 = new FeedStatusUpdateType("AVATAR_UPDATE", 1, DocTabPayload.DocType.BITABLE);
            AVATAR_UPDATE = r1;
            FeedStatusUpdateType r2 = new FeedStatusUpdateType("BADGE_UPDATE", 2, DocTabPayload.DocType.FILE);
            BADGE_UPDATE = r2;
            FeedStatusUpdateType r4 = new FeedStatusUpdateType("DISPLAY_TIME_UPDATE", 3, DocTabPayload.DocType.SLIDE);
            DISPLAY_TIME_UPDATE = r4;
            FeedStatusUpdateType r6 = new FeedStatusUpdateType("RANK_TIME_UPDATE", 4, DocTabPayload.DocType.WIKI);
            RANK_TIME_UPDATE = r6;
            FeedStatusUpdateType r8 = new FeedStatusUpdateType("DONE", 5, DocTabPayload.DocType.DOCX);
            DONE = r8;
            FeedStatusUpdateType r10 = new FeedStatusUpdateType("CANCEL_DONE", 6, "9");
            CANCEL_DONE = r10;
            FeedStatusUpdateType r12 = new FeedStatusUpdateType("MUTE", 7, "10");
            MUTE = r12;
            FeedStatusUpdateType r14 = new FeedStatusUpdateType("CANCEL_MUTE", 8, DocTabPayload.DocType.SLIDES);
            CANCEL_MUTE = r14;
            FeedStatusUpdateType r13 = new FeedStatusUpdateType("ON_TEMP_TOP", 9, "12");
            ON_TEMP_TOP = r13;
            FeedStatusUpdateType r11 = new FeedStatusUpdateType("CANCEL_TEMP_TOP", 10, "13");
            CANCEL_TEMP_TOP = r11;
            FeedStatusUpdateType r9 = new FeedStatusUpdateType("BUTTON_UPDATE", 11, "14");
            BUTTON_UPDATE = r9;
            FeedStatusUpdateType[] r7 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static FeedStatusUpdateType[] values() {
            return (FeedStatusUpdateType[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static FeedStatusUpdateType valueOf(String r1) {
            return (FeedStatusUpdateType) r27.a.a(FeedStatusUpdateType.class, r1);
        }

        public FeedStatusUpdateType(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$NavigationTopClickParam;", BuildConfig.FLAVOR, Keys.API_PARAM_KEY_ACTION, BuildConfig.FLAVOR, "target", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "SEARCH", "FEED_PLUS", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NavigationTopClickParam extends Enum<NavigationTopClickParam> {
        public static final NavigationTopClickParam FEED_PLUS = null;
        public static final NavigationTopClickParam SEARCH = null;
        public static final /* synthetic */ NavigationTopClickParam[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String action;
        private final String target;

        public static EnumEntries<NavigationTopClickParam> getEntries() {
            return b;
        }

        static {
            NavigationTopClickParam r0 = new NavigationTopClickParam("SEARCH", 0, ChatFromType.SEARCH, "search_main_view");
            SEARCH = r0;
            NavigationTopClickParam r1 = new NavigationTopClickParam("FEED_PLUS", 1, "feed_plus", "feed_plus_view");
            FEED_PLUS = r1;
            NavigationTopClickParam[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static NavigationTopClickParam[] values() {
            return (NavigationTopClickParam[]) a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }

        public static NavigationTopClickParam valueOf(String r1) {
            return (NavigationTopClickParam) r27.a.a(NavigationTopClickParam.class, r1);
        }

        public NavigationTopClickParam(String r1, int r2, String r3, String r4) {
            super(r1, r2);
            this.action = r3;
            this.target = r4;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/feed/shared/hitpoint/FeedHitPointNew$SettingDetailType;", BuildConfig.FLAVOR, IPortraitService.TYPE, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "LEFT_OFF", "RECENT_UNREAD", "TOGGLE_ON", "TOGGLE_OFF", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SettingDetailType extends Enum<SettingDetailType> {
        public static final SettingDetailType LEFT_OFF = null;
        public static final SettingDetailType RECENT_UNREAD = null;
        public static final SettingDetailType TOGGLE_OFF = null;
        public static final SettingDetailType TOGGLE_ON = null;
        public static final /* synthetic */ SettingDetailType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String type;

        public static EnumEntries<SettingDetailType> getEntries() {
            return b;
        }

        static {
            SettingDetailType r0 = new SettingDetailType("LEFT_OFF", 0, "left_off");
            LEFT_OFF = r0;
            SettingDetailType r1 = new SettingDetailType("RECENT_UNREAD", 1, "most_recent_unread");
            RECENT_UNREAD = r1;
            SettingDetailType r2 = new SettingDetailType("TOGGLE_ON", 2, "on");
            TOGGLE_ON = r2;
            SettingDetailType r4 = new SettingDetailType("TOGGLE_OFF", 3, "off");
            TOGGLE_OFF = r4;
            SettingDetailType[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static SettingDetailType[] values() {
            return (SettingDetailType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public static SettingDetailType valueOf(String r1) {
            return (SettingDetailType) r27.a.a(SettingDetailType.class, r1);
        }

        public SettingDetailType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(FeedDelayedPopupClickParam r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        Statistics.sendEvent("feed_delayed_popup_click", new JSONObject().put("click", r3.getAction()).put("target", r3.getTarget()));
    }

    @JvmStatic
    public static final void b(FeedMainClickParam r4, Map<String, ? extends Object> r5, FeedFolder r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "param");
        if (r6 == null) goto L8;
        String r8 = r6.label();
        if (r8 == null) goto L8;
        String r9 = r8.toLowerCase(Locale.ROOT);
        if (r9 == null) goto L8;
    L9:
        peb.b r0 = heb.a.a;
        r0.getFeedDependency().getClass();
        FeedFolderCompat r1 = FeedFolderCompat.INSTANCE;
        if (r1.getMESSAGE_WITHOUT_DOUBAO().isSameFolderWith(r1.getEXPIRED_FOLD()) == false) goto L12;
        String r2 = "expired_fold";
    L14:
        if (r5 != null) goto L16;
        r5 = MapsKt.emptyMap();
    L16:
        Statistics.sendEvent("feed_main_click", new JSONObject(r5).put("click", r4.getAction()).put("belonged_tab", r2).put("target", r4.getTarget()).put("is_important_top", r7 ? 1 : 0).put("target_tab", r9));
        return;
    L12:
        r0.getFeedDependency().getClass();
        r2 = r1.getMESSAGE_WITHOUT_DOUBAO().label().toLowerCase(Locale.ROOT);
    L8:
        r9 = BuildConfig.FLAVOR;
        goto L9
    }

    public static void c(FeedMainClickParam r2, Map r3, boolean r4, int r5) {
        FeedFolder r1 = null;
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        heb.a.a.getFeedDependency().getClass();
        r1 = FeedFolderCompat.INSTANCE.getMESSAGE_WITHOUT_DOUBAO();
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = false;
    L11:
        b(r2, r3, r1, r4);
    }
}
