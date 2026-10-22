package com.ss.android.lark.chameleon;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chat.constant.ChatFromType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\b\"\u00020\u0005¢\u0006\u0002\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "BASE", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "buildValue", "parts", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "([Ljava/lang/String;)Ljava/lang/String;", "getAllValue", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Domain", "BizSubDomain", "App", "Passport", "System", "UI", "Webview", "Widget", "Internal", "Biz", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKAPIModules {
    private static final String BASE = "LarkAPI.";
    public static final LKAPIModules INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$App;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetLarkletConfig", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum App extends Enum<App> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ App[] $VALUES = null;
        public static final App GetLarkletConfig = null;
        private final String value;

        private static final /* synthetic */ App[] $values() {
            return new App[]{GetLarkletConfig};
        }

        public static EnumEntries<App> getEntries() {
            return $ENTRIES;
        }

        static {
            GetLarkletConfig = new App("GetLarkletConfig", 0, "getLarkletConfig");
            App[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static App[] values() {
            return (App[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static App valueOf(String r1) {
            return (App) a.a(App.class, r1);
        }

        private App(String r3, int r4, String r5) {
            super(r3, r4);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.APP.getValue(), r5});
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\u0006\u0007\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "BIZ_DOMAIN", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "Chat", "Profile", "Todo", "Statistics", "Workplace", "Mail", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Biz {
        private static final String BIZ_DOMAIN = null;
        public static final Biz INSTANCE = null;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Chat;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SelectMessages", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Chat extends Enum<Chat> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Chat[] $VALUES = null;
            public static final Chat SelectMessages = null;
            private final String value;

            private static final /* synthetic */ Chat[] $values() {
                return new Chat[]{SelectMessages};
            }

            public static EnumEntries<Chat> getEntries() {
                return $ENTRIES;
            }

            static {
                SelectMessages = new Chat("SelectMessages", 0, "selectMessages");
                Chat[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Chat[] values() {
                return (Chat[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Chat valueOf(String r1) {
                return (Chat) a.a(Chat.class, r1);
            }

            private Chat(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.CHAT.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001d\b\u0002\u0012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\r\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Mail;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "path", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I[Ljava/lang/String;)V", "ChangeSize", "WebViewWindowClose", "JumpToSystemBrowser", "SetTapOutsideToDismiss", "OnDataReady", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Mail extends Enum<Mail> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Mail[] $VALUES = null;
            public static final Mail ChangeSize = null;
            public static final Mail JumpToSystemBrowser = null;
            public static final Mail OnDataReady = null;
            public static final Mail SetTapOutsideToDismiss = null;
            public static final Mail WebViewWindowClose = null;
            private final String value;

            private static final /* synthetic */ Mail[] $values() {
                return new Mail[]{ChangeSize, WebViewWindowClose, JumpToSystemBrowser, SetTapOutsideToDismiss, OnDataReady};
            }

            public static EnumEntries<Mail> getEntries() {
                return $ENTRIES;
            }

            static {
                ChangeSize = new Mail("ChangeSize", 0, new String[]{"changeSize"});
                WebViewWindowClose = new Mail("WebViewWindowClose", 1, new String[]{"webViewWindow", "close"});
                JumpToSystemBrowser = new Mail("JumpToSystemBrowser", 2, new String[]{"jump", "system_browser"});
                SetTapOutsideToDismiss = new Mail("SetTapOutsideToDismiss", 3, new String[]{"setTapOutsideToDismiss"});
                OnDataReady = new Mail("OnDataReady", 4, new String[]{"onDataReady"});
                Mail[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Mail[] values() {
                return (Mail[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Mail valueOf(String r1) {
                return (Mail) a.a(Mail.class, r1);
            }

            private Mail(String r2, int r3, String... r4) {
                super(r2, r3);
                LKAPIModules r5 = LKAPIModules.INSTANCE;
                SpreadBuilder r6 = new SpreadBuilder(3);
                r6.add(Biz.access$getBIZ_DOMAIN$p());
                r6.add(BizSubDomain.MAIL.getValue());
                r6.addSpread(r4);
                this.value = r5.buildValue((String[]) r6.toArray(new String[r6.size()]));
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Profile;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "OpenProfile", "NotifySelectDepartment", "NotifySubTabChange", "GetManageDepartmentList", "ShowManagedDepartmentPanel", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Profile extends Enum<Profile> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Profile[] $VALUES = null;
            public static final Profile GetManageDepartmentList = null;
            public static final Profile NotifySelectDepartment = null;
            public static final Profile NotifySubTabChange = null;
            public static final Profile OpenProfile = null;
            public static final Profile ShowManagedDepartmentPanel = null;
            private final String value;

            private static final /* synthetic */ Profile[] $values() {
                return new Profile[]{OpenProfile, NotifySelectDepartment, NotifySubTabChange, GetManageDepartmentList, ShowManagedDepartmentPanel};
            }

            public static EnumEntries<Profile> getEntries() {
                return $ENTRIES;
            }

            static {
                OpenProfile = new Profile("OpenProfile", 0, "openProfile");
                NotifySelectDepartment = new Profile("NotifySelectDepartment", 1, "notifySelectDepartment");
                NotifySubTabChange = new Profile("NotifySubTabChange", 2, "notifySubTabChange");
                GetManageDepartmentList = new Profile("GetManageDepartmentList", 3, "getManageDepartmentList");
                ShowManagedDepartmentPanel = new Profile("ShowManagedDepartmentPanel", 4, "showManagedDepartmentPanel");
                Profile[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Profile[] values() {
                return (Profile[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Profile valueOf(String r1) {
                return (Profile) a.a(Profile.class, r1);
            }

            private Profile(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.PROFILE.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Statistics;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SendEvent", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Statistics extends Enum<Statistics> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Statistics[] $VALUES = null;
            public static final Statistics SendEvent = null;
            private final String value;

            private static final /* synthetic */ Statistics[] $values() {
                return new Statistics[]{SendEvent};
            }

            public static EnumEntries<Statistics> getEntries() {
                return $ENTRIES;
            }

            static {
                SendEvent = new Statistics("SendEvent", 0, "sendEvent");
                Statistics[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Statistics[] values() {
                return (Statistics[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Statistics valueOf(String r1) {
                return (Statistics) a.a(Statistics.class, r1);
            }

            private Statistics(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.STATISTICS.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010&\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Todo;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "PreviewFile", "DownloadFile", "PreviewImage", "OpenChat", "OpenThread", "ShowContactPicker", "ShareTaskDetail", "ShareTaskList", "GetIs24HourStyle", "StartChooseRepeat", "GetParsedRRuleText", "GenerateMergeForwardInfo", "StartMergeMessagePage", "GetInitialRefResourceForChatCreating", "GetInitialRichSummaryForChatCreating", "ShareCreatedTaskToLark", "OpenTaskActivitiesPage", "OpenCommunicableNativeSubPage", "CommunicableSubPageTransData", "GetChatById", "WebCanGoBack", "ShowActionSheet", "ShowDialog", "GetZoomLevel", "GetEmojiEntity", "GetStatisticsInfo", "GetSafeArea", "UpdateBadge", "GetKeyboardStatus", "GetIsFoldDisplay", "GetAuthHeaders", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Todo extends Enum<Todo> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Todo[] $VALUES = null;
            public static final Todo CommunicableSubPageTransData = null;
            public static final Todo DownloadFile = null;
            public static final Todo GenerateMergeForwardInfo = null;
            public static final Todo GetAuthHeaders = null;
            public static final Todo GetChatById = null;
            public static final Todo GetEmojiEntity = null;
            public static final Todo GetInitialRefResourceForChatCreating = null;
            public static final Todo GetInitialRichSummaryForChatCreating = null;
            public static final Todo GetIs24HourStyle = null;
            public static final Todo GetIsFoldDisplay = null;
            public static final Todo GetKeyboardStatus = null;
            public static final Todo GetParsedRRuleText = null;
            public static final Todo GetSafeArea = null;
            public static final Todo GetStatisticsInfo = null;
            public static final Todo GetZoomLevel = null;
            public static final Todo OpenChat = null;
            public static final Todo OpenCommunicableNativeSubPage = null;
            public static final Todo OpenTaskActivitiesPage = null;
            public static final Todo OpenThread = null;
            public static final Todo PreviewFile = null;
            public static final Todo PreviewImage = null;
            public static final Todo ShareCreatedTaskToLark = null;
            public static final Todo ShareTaskDetail = null;
            public static final Todo ShareTaskList = null;
            public static final Todo ShowActionSheet = null;
            public static final Todo ShowContactPicker = null;
            public static final Todo ShowDialog = null;
            public static final Todo StartChooseRepeat = null;
            public static final Todo StartMergeMessagePage = null;
            public static final Todo UpdateBadge = null;
            public static final Todo WebCanGoBack = null;
            private final String value;

            private static final /* synthetic */ Todo[] $values() {
                return new Todo[]{PreviewFile, DownloadFile, PreviewImage, OpenChat, OpenThread, ShowContactPicker, ShareTaskDetail, ShareTaskList, GetIs24HourStyle, StartChooseRepeat, GetParsedRRuleText, GenerateMergeForwardInfo, StartMergeMessagePage, GetInitialRefResourceForChatCreating, GetInitialRichSummaryForChatCreating, ShareCreatedTaskToLark, OpenTaskActivitiesPage, OpenCommunicableNativeSubPage, CommunicableSubPageTransData, GetChatById, WebCanGoBack, ShowActionSheet, ShowDialog, GetZoomLevel, GetEmojiEntity, GetStatisticsInfo, GetSafeArea, UpdateBadge, GetKeyboardStatus, GetIsFoldDisplay, GetAuthHeaders};
            }

            public static EnumEntries<Todo> getEntries() {
                return $ENTRIES;
            }

            static {
                PreviewFile = new Todo("PreviewFile", 0, "previewFile");
                DownloadFile = new Todo("DownloadFile", 1, "downloadFile");
                PreviewImage = new Todo("PreviewImage", 2, "previewImage");
                OpenChat = new Todo("OpenChat", 3, "openChat");
                OpenThread = new Todo("OpenThread", 4, "openThread");
                ShowContactPicker = new Todo("ShowContactPicker", 5, "showContactPicker");
                ShareTaskDetail = new Todo("ShareTaskDetail", 6, "shareTaskDetail");
                ShareTaskList = new Todo("ShareTaskList", 7, "shareTaskList");
                GetIs24HourStyle = new Todo("GetIs24HourStyle", 8, "getIs24HourStyle");
                StartChooseRepeat = new Todo("StartChooseRepeat", 9, "startChooseRepeat");
                GetParsedRRuleText = new Todo("GetParsedRRuleText", 10, "getParsedRRuleText");
                GenerateMergeForwardInfo = new Todo("GenerateMergeForwardInfo", 11, "generateMergeForwardInfo");
                StartMergeMessagePage = new Todo("StartMergeMessagePage", 12, "startMergeMessagePage");
                GetInitialRefResourceForChatCreating = new Todo("GetInitialRefResourceForChatCreating", 13, "getInitialRefResourceForChatCreating");
                GetInitialRichSummaryForChatCreating = new Todo("GetInitialRichSummaryForChatCreating", 14, "getInitialRichSummaryForChatCreating");
                ShareCreatedTaskToLark = new Todo("ShareCreatedTaskToLark", 15, "shareCreatedTaskToLark");
                OpenTaskActivitiesPage = new Todo("OpenTaskActivitiesPage", 16, "openTaskActivitiesPage");
                OpenCommunicableNativeSubPage = new Todo("OpenCommunicableNativeSubPage", 17, "openCommunicableNativeSubPage");
                CommunicableSubPageTransData = new Todo("CommunicableSubPageTransData", 18, "communicableSubPageTransData");
                GetChatById = new Todo("GetChatById", 19, "getChatById");
                WebCanGoBack = new Todo("WebCanGoBack", 20, "webCanGoBack");
                ShowActionSheet = new Todo("ShowActionSheet", 21, "showActionSheet");
                ShowDialog = new Todo("ShowDialog", 22, "showDialog");
                GetZoomLevel = new Todo("GetZoomLevel", 23, "getZoomLevel");
                GetEmojiEntity = new Todo("GetEmojiEntity", 24, "getEmojiEntity");
                GetStatisticsInfo = new Todo("GetStatisticsInfo", 25, "getStatisticsInfo");
                GetSafeArea = new Todo("GetSafeArea", 26, "getSafeArea");
                UpdateBadge = new Todo("UpdateBadge", 27, "updateBadge");
                GetKeyboardStatus = new Todo("GetKeyboardStatus", 28, "getKeyboardStatus");
                GetIsFoldDisplay = new Todo("GetIsFoldDisplay", 29, "getIsFoldDisplay");
                GetAuthHeaders = new Todo("GetAuthHeaders", 30, "getAuthHeaders");
                Todo[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Todo[] values() {
                return (Todo[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Todo valueOf(String r1) {
                return (Todo) a.a(Todo.class, r1);
            }

            private Todo(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.TODO.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bj\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Biz$Workplace;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetCurrentTemplateId", "OnSwitchTemplate", "OnUpdateTemplate", "NavigateTo", "UpdateBadge", "GetInnerSize", "GetScreenMode", "PreloadSuccess", "ShowDialog", "SetTemplateList", "SetTplTitleButton", "Ready", "OpenApp", "ShowNotInterestedSelect", "HideNotInterestedSelect", "ShowItemMenu", "HideItemMenu", "ShowSortApp", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Workplace extends Enum<Workplace> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Workplace[] $VALUES = null;
            public static final Workplace GetCurrentTemplateId = null;
            public static final Workplace GetInnerSize = null;
            public static final Workplace GetScreenMode = null;
            public static final Workplace HideItemMenu = null;
            public static final Workplace HideNotInterestedSelect = null;
            public static final Workplace NavigateTo = null;
            public static final Workplace OnSwitchTemplate = null;
            public static final Workplace OnUpdateTemplate = null;
            public static final Workplace OpenApp = null;
            public static final Workplace PreloadSuccess = null;
            public static final Workplace Ready = null;
            public static final Workplace SetTemplateList = null;
            public static final Workplace SetTplTitleButton = null;
            public static final Workplace ShowDialog = null;
            public static final Workplace ShowItemMenu = null;
            public static final Workplace ShowNotInterestedSelect = null;
            public static final Workplace ShowSortApp = null;
            public static final Workplace UpdateBadge = null;
            private final String value;

            private static final /* synthetic */ Workplace[] $values() {
                return new Workplace[]{GetCurrentTemplateId, OnSwitchTemplate, OnUpdateTemplate, NavigateTo, UpdateBadge, GetInnerSize, GetScreenMode, PreloadSuccess, ShowDialog, SetTemplateList, SetTplTitleButton, Ready, OpenApp, ShowNotInterestedSelect, HideNotInterestedSelect, ShowItemMenu, HideItemMenu, ShowSortApp};
            }

            public static EnumEntries<Workplace> getEntries() {
                return $ENTRIES;
            }

            static {
                GetCurrentTemplateId = new Workplace("GetCurrentTemplateId", 0, "getCurrentTemplateId");
                OnSwitchTemplate = new Workplace("OnSwitchTemplate", 1, "onSwitchTemplate");
                OnUpdateTemplate = new Workplace("OnUpdateTemplate", 2, "onUpdateTemplate");
                NavigateTo = new Workplace("NavigateTo", 3, "navigateTo");
                UpdateBadge = new Workplace("UpdateBadge", 4, "updateBadge");
                GetInnerSize = new Workplace("GetInnerSize", 5, "getInnerSize");
                GetScreenMode = new Workplace("GetScreenMode", 6, "getScreenMode");
                PreloadSuccess = new Workplace("PreloadSuccess", 7, "preloadSuccess");
                ShowDialog = new Workplace("ShowDialog", 8, "showDialog");
                SetTemplateList = new Workplace("SetTemplateList", 9, "setTemplateList");
                SetTplTitleButton = new Workplace("SetTplTitleButton", 10, "setTplTitleButton");
                Ready = new Workplace("Ready", 11, "ready");
                OpenApp = new Workplace("OpenApp", 12, "openApp");
                ShowNotInterestedSelect = new Workplace("ShowNotInterestedSelect", 13, "showNotInterestedSelect");
                HideNotInterestedSelect = new Workplace("HideNotInterestedSelect", 14, "hideNotInterestedSelect");
                ShowItemMenu = new Workplace("ShowItemMenu", 15, "showItemMenu");
                HideItemMenu = new Workplace("HideItemMenu", 16, "hideItemMenu");
                ShowSortApp = new Workplace("ShowSortApp", 17, "showSortApp");
                Workplace[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Workplace[] values() {
                return (Workplace[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Workplace valueOf(String r1) {
                return (Workplace) a.a(Workplace.class, r1);
            }

            private Workplace(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Biz.access$getBIZ_DOMAIN$p(), BizSubDomain.WORKPLACE.getValue(), r5});
            }
        }

        private Biz() {
        }

        static {
            INSTANCE = new Biz();
            BIZ_DOMAIN = Domain.BIZ.getValue();
        }

        public static final /* synthetic */ String access$getBIZ_DOMAIN$p() {
            return BIZ_DOMAIN;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$BizSubDomain;", "Lcom/bytedance/ee/util/io/NonProguard;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "value", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "MAIL", "PROFILE", "TODO", "STATISTICS", "WORKPLACE", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BizSubDomain extends Enum<BizSubDomain> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ BizSubDomain[] $VALUES = null;
        public static final BizSubDomain CHAT = null;
        public static final BizSubDomain MAIL = null;
        public static final BizSubDomain PROFILE = null;
        public static final BizSubDomain STATISTICS = null;
        public static final BizSubDomain TODO = null;
        public static final BizSubDomain WORKPLACE = null;
        private final String value;

        private static final /* synthetic */ BizSubDomain[] $values() {
            return new BizSubDomain[]{CHAT, MAIL, PROFILE, TODO, STATISTICS, WORKPLACE};
        }

        public static EnumEntries<BizSubDomain> getEntries() {
            return $ENTRIES;
        }

        static {
            CHAT = new BizSubDomain("CHAT", 0, "chat");
            MAIL = new BizSubDomain("MAIL", 1, "mail");
            PROFILE = new BizSubDomain("PROFILE", 2, ChatFromType.PROFILE);
            TODO = new BizSubDomain("TODO", 3, "todo");
            STATISTICS = new BizSubDomain("STATISTICS", 4, "statistics");
            WORKPLACE = new BizSubDomain("WORKPLACE", 5, "workplace");
            BizSubDomain[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static BizSubDomain[] values() {
            return (BizSubDomain[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static BizSubDomain valueOf(String r1) {
            return (BizSubDomain) a.a(BizSubDomain.class, r1);
        }

        private BizSubDomain(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0082\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Domain;", "Lcom/bytedance/ee/util/io/NonProguard;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "value", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP", "APP_CONFIG", "LOG", "NET", "PASSPORT", "RESOURCE", "SLARDAR", "STORAGE", "SYSTEM", "TEA", "TRANSPORT", "UI", "WEBVIEW", "WIDGET", "INTERNAL", "BIZ", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Domain extends Enum<Domain> implements NonProguard {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Domain[] $VALUES = null;
        public static final Domain APP = null;
        public static final Domain APP_CONFIG = null;
        public static final Domain BIZ = null;
        public static final Domain INTERNAL = null;
        public static final Domain LOG = null;
        public static final Domain NET = null;
        public static final Domain PASSPORT = null;
        public static final Domain RESOURCE = null;
        public static final Domain SLARDAR = null;
        public static final Domain STORAGE = null;
        public static final Domain SYSTEM = null;
        public static final Domain TEA = null;
        public static final Domain TRANSPORT = null;
        public static final Domain UI = null;
        public static final Domain WEBVIEW = null;
        public static final Domain WIDGET = null;
        private final String value;

        private static final /* synthetic */ Domain[] $values() {
            return new Domain[]{APP, APP_CONFIG, LOG, NET, PASSPORT, RESOURCE, SLARDAR, STORAGE, SYSTEM, TEA, TRANSPORT, UI, WEBVIEW, WIDGET, INTERNAL, BIZ};
        }

        public static EnumEntries<Domain> getEntries() {
            return $ENTRIES;
        }

        static {
            APP = new Domain("APP", 0, "app");
            APP_CONFIG = new Domain("APP_CONFIG", 1, "appConfig");
            LOG = new Domain("LOG", 2, "log");
            NET = new Domain("NET", 3, "net");
            PASSPORT = new Domain("PASSPORT", 4, "passport");
            RESOURCE = new Domain("RESOURCE", 5, "resource");
            SLARDAR = new Domain("SLARDAR", 6, "slardar");
            STORAGE = new Domain("STORAGE", 7, "storage");
            SYSTEM = new Domain("SYSTEM", 8, "system");
            TEA = new Domain("TEA", 9, "tea");
            TRANSPORT = new Domain("TRANSPORT", 10, "transport");
            UI = new Domain("UI", 11, "ui");
            WEBVIEW = new Domain("WEBVIEW", 12, "webview");
            WIDGET = new Domain("WIDGET", 13, "widget");
            INTERNAL = new Domain("INTERNAL", 14, "internal");
            BIZ = new Domain("BIZ", 15, "biz");
            Domain[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Domain[] values() {
            return (Domain[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Domain valueOf(String r1) {
            return (Domain) a.a(Domain.class, r1);
        }

        private Domain(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u000b\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "()V", "INTERNAL_DOMAIN", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "AppConfig", "Log", "Net", "Resource", "Storage", "Slardar", "System", "Tea", "Transport", "Webview", "Widget", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Internal {
        public static final Internal INSTANCE = null;
        private static final String INTERNAL_DOMAIN = null;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$AppConfig;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetKeys", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum AppConfig extends Enum<AppConfig> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ AppConfig[] $VALUES = null;
            public static final AppConfig GetKeys = null;
            private final String value;

            private static final /* synthetic */ AppConfig[] $values() {
                return new AppConfig[]{GetKeys};
            }

            public static EnumEntries<AppConfig> getEntries() {
                return $ENTRIES;
            }

            static {
                GetKeys = new AppConfig("GetKeys", 0, "getKeys");
                AppConfig[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static AppConfig[] values() {
                return (AppConfig[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static AppConfig valueOf(String r1) {
                return (AppConfig) a.a(AppConfig.class, r1);
            }

            private AppConfig(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.APP_CONFIG.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Log;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LogNoReturn", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Log extends Enum<Log> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Log[] $VALUES = null;
            public static final Log LogNoReturn = null;
            private final String value;

            private static final /* synthetic */ Log[] $values() {
                return new Log[]{LogNoReturn};
            }

            public static EnumEntries<Log> getEntries() {
                return $ENTRIES;
            }

            static {
                LogNoReturn = new Log("LogNoReturn", 0, "logNoReturn");
                Log[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Log[] values() {
                return (Log[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Log valueOf(String r1) {
                return (Log) a.a(Log.class, r1);
            }

            private Log(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.LOG.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Net;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Fetch", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Net extends Enum<Net> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Net[] $VALUES = null;
            public static final Net Fetch = null;
            private final String value;

            private static final /* synthetic */ Net[] $values() {
                return new Net[]{Fetch};
            }

            public static EnumEntries<Net> getEntries() {
                return $ENTRIES;
            }

            static {
                Fetch = new Net("Fetch", 0, "fetch");
                Net[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Net[] values() {
                return (Net[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Net valueOf(String r1) {
                return (Net) a.a(Net.class, r1);
            }

            private Net(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.NET.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Resource;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Upload", "CancelUpload", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Resource extends Enum<Resource> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Resource[] $VALUES = null;
            public static final Resource CancelUpload = null;
            public static final Resource Upload = null;
            private final String value;

            private static final /* synthetic */ Resource[] $values() {
                return new Resource[]{Upload, CancelUpload};
            }

            public static EnumEntries<Resource> getEntries() {
                return $ENTRIES;
            }

            static {
                Upload = new Resource("Upload", 0, "upload");
                CancelUpload = new Resource("CancelUpload", 1, "cancelUpload");
                Resource[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Resource[] values() {
                return (Resource[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Resource valueOf(String r1) {
                return (Resource) a.a(Resource.class, r1);
            }

            private Resource(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.RESOURCE.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Slardar;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "SendEvents", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Slardar extends Enum<Slardar> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Slardar[] $VALUES = null;
            public static final Slardar SendEvents = null;
            private final String value;

            private static final /* synthetic */ Slardar[] $values() {
                return new Slardar[]{SendEvents};
            }

            public static EnumEntries<Slardar> getEntries() {
                return $ENTRIES;
            }

            static {
                SendEvents = new Slardar("SendEvents", 0, "sendEvents");
                Slardar[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Slardar[] values() {
                return (Slardar[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Slardar valueOf(String r1) {
                return (Slardar) a.a(Slardar.class, r1);
            }

            private Slardar(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.SLARDAR.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Storage;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CreatePersistentStorage", "GetPersistentStorageId", "GetPersistentKeys", "GetPersistentItems", "SetPersistentItems", "HasPersistentItems", "RemovePersistentItems", "ClearPersistentItems", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Storage extends Enum<Storage> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Storage[] $VALUES = null;
            public static final Storage ClearPersistentItems = null;
            public static final Storage CreatePersistentStorage = null;
            public static final Storage GetPersistentItems = null;
            public static final Storage GetPersistentKeys = null;
            public static final Storage GetPersistentStorageId = null;
            public static final Storage HasPersistentItems = null;
            public static final Storage RemovePersistentItems = null;
            public static final Storage SetPersistentItems = null;
            private final String value;

            private static final /* synthetic */ Storage[] $values() {
                return new Storage[]{CreatePersistentStorage, GetPersistentStorageId, GetPersistentKeys, GetPersistentItems, SetPersistentItems, HasPersistentItems, RemovePersistentItems, ClearPersistentItems};
            }

            public static EnumEntries<Storage> getEntries() {
                return $ENTRIES;
            }

            static {
                CreatePersistentStorage = new Storage("CreatePersistentStorage", 0, "createPersistentStorage");
                GetPersistentStorageId = new Storage("GetPersistentStorageId", 1, "getPersistentStorageId");
                GetPersistentKeys = new Storage("GetPersistentKeys", 2, "getPersistentKeys");
                GetPersistentItems = new Storage("GetPersistentItems", 3, "getPersistentItems");
                SetPersistentItems = new Storage("SetPersistentItems", 4, "setPersistentItems");
                HasPersistentItems = new Storage("HasPersistentItems", 5, "hasPersistentItems");
                RemovePersistentItems = new Storage("RemovePersistentItems", 6, "removePersistentItems");
                ClearPersistentItems = new Storage("ClearPersistentItems", 7, "clearPersistentItems");
                Storage[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Storage[] values() {
                return (Storage[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Storage valueOf(String r1) {
                return (Storage) a.a(Storage.class, r1);
            }

            private Storage(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.STORAGE.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$System;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetStatusBarHeight", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum System extends Enum<System> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ System[] $VALUES = null;
            public static final System GetStatusBarHeight = null;
            private final String value;

            private static final /* synthetic */ System[] $values() {
                return new System[]{GetStatusBarHeight};
            }

            public static EnumEntries<System> getEntries() {
                return $ENTRIES;
            }

            static {
                GetStatusBarHeight = new System("GetStatusBarHeight", 0, "getStatusBarHeight");
                System[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static System[] values() {
                return (System[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static System valueOf(String r1) {
                return (System) a.a(System.class, r1);
            }

            private System(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.SYSTEM.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Tea;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "TrackNoReturn", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Tea extends Enum<Tea> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Tea[] $VALUES = null;
            public static final Tea TrackNoReturn = null;
            private final String value;

            private static final /* synthetic */ Tea[] $values() {
                return new Tea[]{TrackNoReturn};
            }

            public static EnumEntries<Tea> getEntries() {
                return $ENTRIES;
            }

            static {
                TrackNoReturn = new Tea("TrackNoReturn", 0, "trackNoReturn");
                Tea[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Tea[] values() {
                return (Tea[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Tea valueOf(String r1) {
                return (Tea) a.a(Tea.class, r1);
            }

            private Tea(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.TEA.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Transport;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CallRustApi", "SubscribeRustPush", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Transport extends Enum<Transport> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Transport[] $VALUES = null;
            public static final Transport CallRustApi = null;
            public static final Transport SubscribeRustPush = null;
            private final String value;

            private static final /* synthetic */ Transport[] $values() {
                return new Transport[]{CallRustApi, SubscribeRustPush};
            }

            public static EnumEntries<Transport> getEntries() {
                return $ENTRIES;
            }

            static {
                CallRustApi = new Transport("CallRustApi", 0, "callRustApi");
                SubscribeRustPush = new Transport("SubscribeRustPush", 1, "subscribeRustPush");
                Transport[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Transport[] values() {
                return (Transport[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Transport valueOf(String r1) {
                return (Transport) a.a(Transport.class, r1);
            }

            private Transport(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.TRANSPORT.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Webview;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Close", "GetState", "GetRouterState", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Webview extends Enum<Webview> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Webview[] $VALUES = null;
            public static final Webview Close = null;
            public static final Webview GetRouterState = null;
            public static final Webview GetState = null;
            private final String value;

            private static final /* synthetic */ Webview[] $values() {
                return new Webview[]{Close, GetState, GetRouterState};
            }

            public static EnumEntries<Webview> getEntries() {
                return $ENTRIES;
            }

            static {
                Close = new Webview("Close", 0, "close");
                GetState = new Webview("GetState", 1, "getState");
                GetRouterState = new Webview("GetRouterState", 2, "getRouterState");
                Webview[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Webview[] values() {
                return (Webview[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Webview valueOf(String r1) {
                return (Webview) a.a(Webview.class, r1);
            }

            private Webview(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.WEBVIEW.getValue(), r5});
            }
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Internal$Widget;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ShowToast", "ShowConfirmDialog", "CloseConfirmDialog", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum Widget extends Enum<Widget> implements IAPIModule {
            private static final /* synthetic */ EnumEntries $ENTRIES = null;
            private static final /* synthetic */ Widget[] $VALUES = null;
            public static final Widget CloseConfirmDialog = null;
            public static final Widget ShowConfirmDialog = null;
            public static final Widget ShowToast = null;
            private final String value;

            private static final /* synthetic */ Widget[] $values() {
                return new Widget[]{ShowToast, ShowConfirmDialog, CloseConfirmDialog};
            }

            public static EnumEntries<Widget> getEntries() {
                return $ENTRIES;
            }

            static {
                ShowToast = new Widget("ShowToast", 0, "showToast");
                ShowConfirmDialog = new Widget("ShowConfirmDialog", 1, "showConfirmDialog");
                CloseConfirmDialog = new Widget("CloseConfirmDialog", 2, "closeConfirmDialog");
                Widget[] r0 = $values();
                $VALUES = r0;
                $ENTRIES = EnumEntriesKt.enumEntries(r0);
            }

            public static Widget[] values() {
                return (Widget[]) $VALUES.clone();
            }

            @Override // com.ss.android.lark.chameleon.IAPIModule
            public String getValue() {
                return this.value;
            }

            public static Widget valueOf(String r1) {
                return (Widget) a.a(Widget.class, r1);
            }

            private Widget(String r3, int r4, String r5) {
                super(r3, r4);
                this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Internal.access$getINTERNAL_DOMAIN$p(), Domain.WIDGET.getValue(), r5});
            }
        }

        private Internal() {
        }

        static {
            INSTANCE = new Internal();
            INTERNAL_DOMAIN = Domain.INTERNAL.getValue();
        }

        public static final /* synthetic */ String access$getINTERNAL_DOMAIN$p() {
            return INTERNAL_DOMAIN;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Passport;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetCurrentUserInfo", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Passport extends Enum<Passport> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Passport[] $VALUES = null;
        public static final Passport GetCurrentUserInfo = null;
        private final String value;

        private static final /* synthetic */ Passport[] $values() {
            return new Passport[]{GetCurrentUserInfo};
        }

        public static EnumEntries<Passport> getEntries() {
            return $ENTRIES;
        }

        static {
            GetCurrentUserInfo = new Passport("GetCurrentUserInfo", 0, "getCurrentUserInfo");
            Passport[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Passport[] values() {
            return (Passport[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static Passport valueOf(String r1) {
            return (Passport) a.a(Passport.class, r1);
        }

        private Passport(String r3, int r4, String r5) {
            super(r3, r4);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.PASSPORT.getValue(), r5});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$System;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DeviceVibrate", "GetInputDevice", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum System extends Enum<System> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ System[] $VALUES = null;
        public static final System DeviceVibrate = null;
        public static final System GetInputDevice = null;
        private final String value;

        private static final /* synthetic */ System[] $values() {
            return new System[]{DeviceVibrate, GetInputDevice};
        }

        public static EnumEntries<System> getEntries() {
            return $ENTRIES;
        }

        static {
            DeviceVibrate = new System("DeviceVibrate", 0, "deviceVibrate");
            GetInputDevice = new System("GetInputDevice", 1, "getInputDevice");
            System[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static System[] values() {
            return (System[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static System valueOf(String r1) {
            return (System) a.a(System.class, r1);
        }

        private System(String r3, int r4, String r5) {
            super(r3, r4);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.SYSTEM.getValue(), r5});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$UI;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "GetAppThemeInfo", "GetZoomLevel", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UI extends Enum<UI> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ UI[] $VALUES = null;
        public static final UI GetAppThemeInfo = null;
        public static final UI GetZoomLevel = null;
        private final String value;

        private static final /* synthetic */ UI[] $values() {
            return new UI[]{GetAppThemeInfo, GetZoomLevel};
        }

        public static EnumEntries<UI> getEntries() {
            return $ENTRIES;
        }

        static {
            GetAppThemeInfo = new UI("GetAppThemeInfo", 0, "getAppThemeInfo");
            GetZoomLevel = new UI("GetZoomLevel", 1, "getZoomLevel");
            UI[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static UI[] values() {
            return (UI[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static UI valueOf(String r1) {
            return (UI) a.a(UI.class, r1);
        }

        private UI(String r3, int r4, String r5) {
            super(r3, r4);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.UI.getValue(), r5});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Webview;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "LoadFinish", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Webview extends Enum<Webview> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Webview[] $VALUES = null;
        public static final Webview LoadFinish = null;
        private final String value;

        private static final /* synthetic */ Webview[] $values() {
            return new Webview[]{LoadFinish};
        }

        public static EnumEntries<Webview> getEntries() {
            return $ENTRIES;
        }

        static {
            LoadFinish = new Webview("LoadFinish", 0, "loadFinish");
            Webview[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Webview[] values() {
            return (Webview[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static Webview valueOf(String r1) {
            return (Webview) a.a(Webview.class, r1);
        }

        private Webview(String r3, int r4, String r5) {
            super(r3, r4);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.WEBVIEW.getValue(), r5});
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/LKAPIModules$Widget;", "Lcom/ss/android/lark/chameleon/IAPIModule;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "suffix", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ShowFilePicker", "ShowMediaPicker", "ShowPanel", "value", "getValue", "()Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Widget extends Enum<Widget> implements IAPIModule {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Widget[] $VALUES = null;
        public static final Widget ShowFilePicker = null;
        public static final Widget ShowMediaPicker = null;
        public static final Widget ShowPanel = null;
        private final String value;

        private static final /* synthetic */ Widget[] $values() {
            return new Widget[]{ShowFilePicker, ShowMediaPicker, ShowPanel};
        }

        public static EnumEntries<Widget> getEntries() {
            return $ENTRIES;
        }

        static {
            ShowFilePicker = new Widget("ShowFilePicker", 0, "showFilePicker");
            ShowMediaPicker = new Widget("ShowMediaPicker", 1, "showMediaPicker");
            ShowPanel = new Widget("ShowPanel", 2, "showPanel");
            Widget[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static Widget[] values() {
            return (Widget[]) $VALUES.clone();
        }

        @Override // com.ss.android.lark.chameleon.IAPIModule
        public String getValue() {
            return this.value;
        }

        public static Widget valueOf(String r1) {
            return (Widget) a.a(Widget.class, r1);
        }

        private Widget(String r3, int r4, String r5) {
            super(r3, r4);
            this.value = LKAPIModules.INSTANCE.buildValue(new String[]{Domain.WIDGET.getValue(), r5});
        }
    }

    static {
        INSTANCE = new LKAPIModules();
    }

    private LKAPIModules() {
    }

    public final List<String> getAllValue() {
        List[] r0 = new List[23];
        App[] r1 = App.values();
        ArrayList r2 = new ArrayList(r1.length);
        int r3 = r1.length;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        r2.add(r1[r5].getValue());
        r5 = r5 + 1;
        goto L3
    L5:
        r0[0] = r2;
        Passport[] r6 = Passport.values();
        ArrayList r7 = new ArrayList(r6.length);
        int r8 = r6.length;
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L8;
        r7.add(r6[r9].getValue());
        r9 = r9 + 1;
        goto L6
    L8:
        r0[1] = r7;
        System[] r10 = System.values();
        ArrayList r11 = new ArrayList(r10.length);
        int r12 = r10.length;
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L11;
        r11.add(r10[r13].getValue());
        r13 = r13 + 1;
        goto L9
    L11:
        r0[2] = r11;
        UI[] r14 = UI.values();
        ArrayList r15 = new ArrayList(r14.length);
        int r16 = r14.length;
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L14;
        r15.add(r14[r17].getValue());
        r17 = r17 + 1;
        goto L12
    L14:
        r0[3] = r15;
        Webview[] r18 = Webview.values();
        ArrayList r19 = new ArrayList(r18.length);
        int r20 = r18.length;
        int r21 = 0;
    L15:
        if (r21 >= r20) goto L17;
        r19.add(r18[r21].getValue());
        r21 = r21 + 1;
        goto L15
    L17:
        r0[4] = r19;
        Widget[] r22 = Widget.values();
        ArrayList r23 = new ArrayList(r22.length);
        int r24 = r22.length;
        int r25 = 0;
    L18:
        if (r25 >= r24) goto L20;
        r23.add(r22[r25].getValue());
        r25 = r25 + 1;
        goto L18
    L20:
        r0[5] = r23;
        Internal.AppConfig[] r26 = Internal.AppConfig.values();
        ArrayList r27 = new ArrayList(r26.length);
        int r28 = r26.length;
        int r29 = 0;
    L21:
        if (r29 >= r28) goto L23;
        r27.add(r26[r29].getValue());
        r29 = r29 + 1;
        goto L21
    L23:
        r0[6] = r27;
        Internal.Log[] r30 = Internal.Log.values();
        ArrayList r31 = new ArrayList(r30.length);
        int r32 = r30.length;
        int r33 = 0;
    L24:
        if (r33 >= r32) goto L26;
        r31.add(r30[r33].getValue());
        r33 = r33 + 1;
        goto L24
    L26:
        r0[7] = r31;
        Internal.Net[] r34 = Internal.Net.values();
        ArrayList r35 = new ArrayList(r34.length);
        int r36 = r34.length;
        int r37 = 0;
    L27:
        if (r37 >= r36) goto L29;
        r35.add(r34[r37].getValue());
        r37 = r37 + 1;
        goto L27
    L29:
        r0[8] = r35;
        Internal.Resource[] r38 = Internal.Resource.values();
        ArrayList r39 = new ArrayList(r38.length);
        int r40 = r38.length;
        int r41 = 0;
    L30:
        if (r41 >= r40) goto L32;
        r39.add(r38[r41].getValue());
        r41 = r41 + 1;
        goto L30
    L32:
        r0[9] = r39;
        Internal.Storage[] r42 = Internal.Storage.values();
        ArrayList r43 = new ArrayList(r42.length);
        int r44 = r42.length;
        int r45 = 0;
    L33:
        if (r45 >= r44) goto L35;
        r43.add(r42[r45].getValue());
        r45 = r45 + 1;
        goto L33
    L35:
        r0[10] = r43;
        Internal.Slardar[] r46 = Internal.Slardar.values();
        ArrayList r47 = new ArrayList(r46.length);
        int r48 = r46.length;
        int r49 = 0;
    L36:
        if (r49 >= r48) goto L38;
        r47.add(r46[r49].getValue());
        r49 = r49 + 1;
        goto L36
    L38:
        r0[11] = r47;
        Internal.System[] r50 = Internal.System.values();
        ArrayList r51 = new ArrayList(r50.length);
        int r52 = r50.length;
        int r53 = 0;
    L39:
        if (r53 >= r52) goto L41;
        r51.add(r50[r53].getValue());
        r53 = r53 + 1;
        goto L39
    L41:
        r0[12] = r51;
        Internal.Tea[] r54 = Internal.Tea.values();
        ArrayList r55 = new ArrayList(r54.length);
        int r56 = r54.length;
        int r57 = 0;
    L42:
        if (r57 >= r56) goto L44;
        r55.add(r54[r57].getValue());
        r57 = r57 + 1;
        goto L42
    L44:
        r0[13] = r55;
        Internal.Transport[] r58 = Internal.Transport.values();
        ArrayList r59 = new ArrayList(r58.length);
        int r60 = r58.length;
        int r61 = 0;
    L45:
        if (r61 >= r60) goto L47;
        r59.add(r58[r61].getValue());
        r61 = r61 + 1;
        goto L45
    L47:
        r0[14] = r59;
        Internal.Webview[] r62 = Internal.Webview.values();
        ArrayList r63 = new ArrayList(r62.length);
        int r64 = r62.length;
        int r65 = 0;
    L48:
        if (r65 >= r64) goto L50;
        r63.add(r62[r65].getValue());
        r65 = r65 + 1;
        goto L48
    L50:
        r0[15] = r63;
        Internal.Widget[] r66 = Internal.Widget.values();
        ArrayList r67 = new ArrayList(r66.length);
        int r68 = r66.length;
        int r69 = 0;
    L51:
        if (r69 >= r68) goto L53;
        r67.add(r66[r69].getValue());
        r69 = r69 + 1;
        goto L51
    L53:
        r0[16] = r67;
        Biz.Profile[] r70 = Biz.Profile.values();
        ArrayList r71 = new ArrayList(r70.length);
        int r72 = r70.length;
        int r73 = 0;
    L54:
        if (r73 >= r72) goto L56;
        r71.add(r70[r73].getValue());
        r73 = r73 + 1;
        goto L54
    L56:
        r0[17] = r71;
        Biz.Chat[] r74 = Biz.Chat.values();
        ArrayList r75 = new ArrayList(r74.length);
        int r76 = r74.length;
        int r77 = 0;
    L57:
        if (r77 >= r76) goto L59;
        r75.add(r74[r77].getValue());
        r77 = r77 + 1;
        goto L57
    L59:
        r0[18] = r75;
        Biz.Todo[] r78 = Biz.Todo.values();
        ArrayList r79 = new ArrayList(r78.length);
        int r80 = r78.length;
        int r81 = 0;
    L60:
        if (r81 >= r80) goto L62;
        r79.add(r78[r81].getValue());
        r81 = r81 + 1;
        goto L60
    L62:
        r0[19] = r79;
        Biz.Statistics[] r82 = Biz.Statistics.values();
        ArrayList r83 = new ArrayList(r82.length);
        int r84 = r82.length;
        int r85 = 0;
    L63:
        if (r85 >= r84) goto L65;
        r83.add(r82[r85].getValue());
        r85 = r85 + 1;
        goto L63
    L65:
        r0[20] = r83;
        Biz.Workplace[] r86 = Biz.Workplace.values();
        ArrayList r87 = new ArrayList(r86.length);
        int r88 = r86.length;
        int r89 = 0;
    L66:
        if (r89 >= r88) goto L68;
        r87.add(r86[r89].getValue());
        r89 = r89 + 1;
        goto L66
    L68:
        r0[21] = r87;
        Biz.Mail[] r90 = Biz.Mail.values();
        ArrayList r91 = new ArrayList(r90.length);
        int r92 = r90.length;
    L69:
        if (r4 >= r92) goto L71;
        r91.add(r90[r4].getValue());
        r4 = r4 + 1;
        goto L69
    L71:
        r0[22] = r91;
        return CollectionsKt.flatten(CollectionsKt.listOf(r0));
    }

    public final String buildValue(String... r12) {
        Intrinsics.checkNotNullParameter(r12, "parts");
        return BASE + ArraysKt.joinToString$default(r12, ".", null, null, 0, null, null, 62, null);
    }
}
