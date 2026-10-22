package com.ss.android.lark.maintab.export;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.NavigationAppInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u0000 J2\u00020\u0001:\bCDEFGHIJB\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010/\u001a\u00020\u0000J\u0013\u00100\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u000203H\u0016J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u0015\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u000eHÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u009b\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0003HÆ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010%R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010%R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001b¨\u0006K"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo;", "", TabAppInfo.IMAGE_JSON_KEY, "", "uniqueId", "tabAppType", "Lcom/ss/android/lark/maintab/export/TabAppType;", "logo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "name", "", "extra", "Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;", "isPrimaryOnly", "", "isUnmovable", "tabSite", "Lcom/ss/android/lark/maintab/export/TabSite;", "isErasable", "openMode", "Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "source", "Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;", "subTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppType;Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;Ljava/util/Map;Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;ZZLcom/ss/android/lark/maintab/export/TabSite;ZLcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getUniqueId", "getTabAppType", "()Lcom/ss/android/lark/maintab/export/TabAppType;", "getLogo", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "getName", "()Ljava/util/Map;", "getExtra", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;", "()Z", "getTabSite", "()Lcom/ss/android/lark/maintab/export/TabSite;", "setTabSite", "(Lcom/ss/android/lark/maintab/export/TabSite;)V", "getOpenMode", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "getSource", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;", "getSubTitle", "deepCopy", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "toString", "Logo", "CustomNavigationAppLogo", "CustomNavigationAppLogoType", "Extra", "BizType", "NavigationOpenMode", "NavigationSource", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class TabAppInfo {
    public static final a Companion = null;
    public static final String IMAGE_JSON_KEY = "key";
    public static final String TAG = "TabModule_TabAppInfo";
    private final Extra extra;
    private final boolean isErasable;
    private final boolean isPrimaryOnly;
    private final boolean isUnmovable;
    private final String key;
    private final Logo logo;
    private final Map<String, String> name;
    private final NavigationOpenMode openMode;
    private final NavigationSource source;
    private final String subTitle;
    private final TabAppType tabAppType;

    @Expose
    private TabSite tabSite;
    private final String uniqueId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_TYPE", "CCM", "MINI_APP", "WEB_APP", "MEEGO", "WEB", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum BizType extends Enum<BizType> {
        public static final BizType CCM = null;
        public static final a Companion = null;
        public static final BizType MEEGO = null;
        public static final BizType MINI_APP = null;
        public static final BizType UNKNOWN_TYPE = null;
        public static final BizType WEB = null;
        public static final BizType WEB_APP = null;
        public static final /* synthetic */ BizType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BizType> getEntries() {
            return b;
        }

        static {
            BizType r0 = new BizType("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r0;
            BizType r1 = new BizType("CCM", 1, 1);
            CCM = r1;
            BizType r3 = new BizType("MINI_APP", 2, 2);
            MINI_APP = r3;
            BizType r5 = new BizType("WEB_APP", 3, 3);
            WEB_APP = r5;
            BizType r7 = new BizType("MEEGO", 4, 4);
            MEEGO = r7;
            BizType r9 = new BizType("WEB", 5, 5);
            WEB = r9;
            BizType[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new a();
        }

        public static BizType[] values() {
            return (BizType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BizType valueOf(String r1) {
            return (BizType) r27.a.a(BizType.class, r1);
        }

        public BizType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "APP_LOGO_TYPE_UNKNOWN", "APP_LOGO_TYPE_UD_TOKEN", "APP_LOGO_TYPE_URL", "APP_LOGO_TYPE_IMAGE_KEY", "APP_LOGO_TYPE_CCM_ICON", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum CustomNavigationAppLogoType extends Enum<CustomNavigationAppLogoType> {
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_CCM_ICON = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_IMAGE_KEY = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_UD_TOKEN = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_UNKNOWN = null;
        public static final CustomNavigationAppLogoType APP_LOGO_TYPE_URL = null;
        public static final a Companion = null;
        public static final /* synthetic */ CustomNavigationAppLogoType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<CustomNavigationAppLogoType> getEntries() {
            return b;
        }

        static {
            CustomNavigationAppLogoType r0 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_UNKNOWN", 0, 0);
            APP_LOGO_TYPE_UNKNOWN = r0;
            CustomNavigationAppLogoType r1 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_UD_TOKEN", 1, 1);
            APP_LOGO_TYPE_UD_TOKEN = r1;
            CustomNavigationAppLogoType r3 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_URL", 2, 2);
            APP_LOGO_TYPE_URL = r3;
            CustomNavigationAppLogoType r5 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_IMAGE_KEY", 3, 3);
            APP_LOGO_TYPE_IMAGE_KEY = r5;
            CustomNavigationAppLogoType r7 = new CustomNavigationAppLogoType("APP_LOGO_TYPE_CCM_ICON", 4, 4);
            APP_LOGO_TYPE_CCM_ICON = r7;
            CustomNavigationAppLogoType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static CustomNavigationAppLogoType[] values() {
            return (CustomNavigationAppLogoType[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CustomNavigationAppLogoType valueOf(String r1) {
            return (CustomNavigationAppLogoType) r27.a.a(CustomNavigationAppLogoType.class, r1);
        }

        public CustomNavigationAppLogoType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\u0000J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jc\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$Extra;", "", "appID", "", "url", "bizType", "Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;", "bizId", "uniqueId", "docSubType", "hardwareBinding", "webUseFullURLMatch", "useCustomNaviAppbarAppearance", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppID", "()Ljava/lang/String;", "getUrl", "getBizType", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$BizType;", "getBizId", "getUniqueId", "getDocSubType", "getHardwareBinding", "getWebUseFullURLMatch", "getUseCustomNaviAppbarAppearance", "deepCopy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Extra {

        @SerializedName("app_id")
        private final String appID;

        @SerializedName("biz_id")
        private final String bizId;

        @SerializedName("biz_type")
        private final BizType bizType;

        @SerializedName("doc_sub_type")
        private final String docSubType;

        @SerializedName("hardware_binding")
        private final String hardwareBinding;

        @SerializedName("unique_id")
        private final String uniqueId;

        @SerializedName("mobile_url")
        private final String url;

        @SerializedName("use_custom_navi_appbar_appearance")
        private final String useCustomNaviAppbarAppearance;

        @SerializedName("webUseFullURLMatch")
        private final String webUseFullURLMatch;

        public Extra() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Extra copy$default(Extra r10, String r11, String r12, BizType r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            String r2 = r10.appID;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = r10.url;
        L11:
            if ((r20 & 4) == 0) goto L13;
            BizType r4 = r10.bizType;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = r10.bizId;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = r10.uniqueId;
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = r10.docSubType;
        L27:
            if ((r20 & 64) == 0) goto L29;
            String r8 = r10.hardwareBinding;
        L31:
            if ((r20 & 128) == 0) goto L33;
            String r9 = r10.webUseFullURLMatch;
        L35:
            if ((r20 & 256) == 0) goto L37;
            String r1 = r10.useCustomNaviAppbarAppearance;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final String component1() {
            return this.appID;
        }

        public final String component2() {
            return this.url;
        }

        public final BizType component3() {
            return this.bizType;
        }

        public final String component4() {
            return this.bizId;
        }

        public final String component5() {
            return this.uniqueId;
        }

        public final String component6() {
            return this.docSubType;
        }

        public final String component7() {
            return this.hardwareBinding;
        }

        public final String component8() {
            return this.webUseFullURLMatch;
        }

        public final String component9() {
            return this.useCustomNaviAppbarAppearance;
        }

        public final Extra copy(String r12, String r13, BizType r14, String r15, String r16, String r17, String r18, String r19, String r20) {
            Intrinsics.checkNotNullParameter(r12, "appID");
            Intrinsics.checkNotNullParameter(r13, "url");
            Intrinsics.checkNotNullParameter(r14, "bizType");
            Intrinsics.checkNotNullParameter(r15, "bizId");
            Intrinsics.checkNotNullParameter(r16, "uniqueId");
            Intrinsics.checkNotNullParameter(r17, "docSubType");
            Intrinsics.checkNotNullParameter(r18, "hardwareBinding");
            Intrinsics.checkNotNullParameter(r19, "webUseFullURLMatch");
            Intrinsics.checkNotNullParameter(r20, "useCustomNaviAppbarAppearance");
            return new Extra(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public final Extra deepCopy() {
            return copy$default(this, null, null, null, null, null, null, null, null, null, 511, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Extra) == true) goto L8;
            return false;
        L8:
            Extra r6 = (Extra) r5;
            if (Intrinsics.areEqual(this.appID, r6.appID) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r6.url) == true) goto L15;
            return false;
        L15:
            if (this.bizType == r6.bizType) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.bizId, r6.bizId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.uniqueId, r6.uniqueId) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.docSubType, r6.docSubType) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.hardwareBinding, r6.hardwareBinding) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.webUseFullURLMatch, r6.webUseFullURLMatch) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.useCustomNaviAppbarAppearance, r6.useCustomNaviAppbarAppearance) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((this.appID.hashCode() * 31) + this.url.hashCode()) * 31) + this.bizType.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.uniqueId.hashCode()) * 31) + this.docSubType.hashCode()) * 31) + this.hardwareBinding.hashCode()) * 31) + this.webUseFullURLMatch.hashCode()) * 31) + this.useCustomNaviAppbarAppearance.hashCode();
        }

        public String toString() {
            return "Extra(appID=" + this.appID + ", url=" + this.url + ", bizType=" + this.bizType + ", bizId=" + this.bizId + ", uniqueId=" + this.uniqueId + ", docSubType=" + this.docSubType + ", hardwareBinding=" + this.hardwareBinding + ", webUseFullURLMatch=" + this.webUseFullURLMatch + ", useCustomNaviAppbarAppearance=" + this.useCustomNaviAppbarAppearance + ')';
        }

        public final String getAppID() {
            return this.appID;
        }

        public final String getBizId() {
            return this.bizId;
        }

        public final BizType getBizType() {
            return this.bizType;
        }

        public final String getDocSubType() {
            return this.docSubType;
        }

        public final String getHardwareBinding() {
            return this.hardwareBinding;
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getUseCustomNaviAppbarAppearance() {
            return this.useCustomNaviAppbarAppearance;
        }

        public final String getWebUseFullURLMatch() {
            return this.webUseFullURLMatch;
        }

        public Extra(String r2, String r3, BizType r4, String r5, String r6, String r7, String r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r2, "appID");
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "bizType");
            Intrinsics.checkNotNullParameter(r5, "bizId");
            Intrinsics.checkNotNullParameter(r6, "uniqueId");
            Intrinsics.checkNotNullParameter(r7, "docSubType");
            Intrinsics.checkNotNullParameter(r8, "hardwareBinding");
            Intrinsics.checkNotNullParameter(r9, "webUseFullURLMatch");
            Intrinsics.checkNotNullParameter(r10, "useCustomNaviAppbarAppearance");
            this.appID = r2;
            this.url = r3;
            this.bizType = r4;
            this.bizId = r5;
            this.uniqueId = r6;
            this.docSubType = r7;
            this.hardwareBinding = r8;
            this.webUseFullURLMatch = r9;
            this.useCustomNaviAppbarAppearance = r10;
        }

        public /* synthetic */ Extra(String r11, String r12, BizType r13, String r14, String r15, String r16, String r17, String r18, String r19, int r20, DefaultConstructorMarker r21) {
            String r2 = "";
            if ((r20 & 1) == 0) goto L5;
            String r1 = "";
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = "";
        L11:
            if ((r20 & 4) == 0) goto L13;
            BizType r4 = BizType.UNKNOWN_TYPE;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = "";
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = "";
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = "";
        L27:
            if ((r20 & 64) == 0) goto L29;
            String r8 = "0";
        L31:
            if ((r20 & 128) == 0) goto L33;
            String r9 = "";
        L35:
            if ((r20 & 256) != 0) goto L38;
            r2 = r19;
        L38:
            this(r1, r3, r4, r5, r6, r7, r8, r9, r2);
            return;
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001e\u001a\u00020\u0000J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003Jg\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006/"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$Logo;", "", "primaryDefault", "", "primarySelected", "shortcutDefault", "primaryDefaultSvg", "primaryColorPng", "mobilePrimaryDefaultPng", "mobilePrimarySelectedPng", "customNavigationAppLogo", "Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;", "logoStyle", "Lcom/bytedance/lark/pb/basic/v1/NavigationAppInfo$Logo$LogoStyle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;Lcom/bytedance/lark/pb/basic/v1/NavigationAppInfo$Logo$LogoStyle;)V", "getPrimaryDefault", "()Ljava/lang/String;", "getPrimarySelected", "getShortcutDefault", "getPrimaryDefaultSvg", "getPrimaryColorPng", "getMobilePrimaryDefaultPng", "getMobilePrimarySelectedPng", "getCustomNavigationAppLogo", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;", "getLogoStyle", "()Lcom/bytedance/lark/pb/basic/v1/NavigationAppInfo$Logo$LogoStyle;", "remotePng", "getRemotePng", "deepCopy", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Logo {

        @SerializedName("custom_navigation_app_logo")
        private final b customNavigationAppLogo;

        @SerializedName("logo_style")
        private final NavigationAppInfo.Logo.LogoStyle logoStyle;

        @SerializedName("mobile_primary_default_png")
        private final String mobilePrimaryDefaultPng;

        @SerializedName("mobile_primary_selected_png")
        private final String mobilePrimarySelectedPng;

        @SerializedName("primary_color_png")
        private final String primaryColorPng;

        @SerializedName("primary_default")
        private final String primaryDefault;

        @SerializedName("primary_default_svg")
        private final String primaryDefaultSvg;

        @SerializedName("primary_selected")
        private final String primarySelected;

        @SerializedName("shortcut_default")
        private final String shortcutDefault;

        public Logo() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Logo copy$default(Logo r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, b r18, NavigationAppInfo.Logo.LogoStyle r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            String r2 = r10.primaryDefault;
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = r10.primarySelected;
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r4 = r10.shortcutDefault;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = r10.primaryDefaultSvg;
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = r10.primaryColorPng;
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = r10.mobilePrimaryDefaultPng;
        L27:
            if ((r20 & 64) == 0) goto L29;
            String r8 = r10.mobilePrimarySelectedPng;
        L31:
            if ((r20 & 128) == 0) goto L33;
            b r9 = r10.customNavigationAppLogo;
        L35:
            if ((r20 & 256) == 0) goto L37;
            NavigationAppInfo.Logo.LogoStyle r1 = r10.logoStyle;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final String component1() {
            return this.primaryDefault;
        }

        public final String component2() {
            return this.primarySelected;
        }

        public final String component3() {
            return this.shortcutDefault;
        }

        public final String component4() {
            return this.primaryDefaultSvg;
        }

        public final String component5() {
            return this.primaryColorPng;
        }

        public final String component6() {
            return this.mobilePrimaryDefaultPng;
        }

        public final String component7() {
            return this.mobilePrimarySelectedPng;
        }

        public final b component8() {
            return this.customNavigationAppLogo;
        }

        public final NavigationAppInfo.Logo.LogoStyle component9() {
            return this.logoStyle;
        }

        public final Logo copy(String r12, String r13, String r14, String r15, String r16, String r17, String r18, b r19, NavigationAppInfo.Logo.LogoStyle r20) {
            Intrinsics.checkNotNullParameter(r12, "primaryDefault");
            Intrinsics.checkNotNullParameter(r13, "primarySelected");
            Intrinsics.checkNotNullParameter(r14, "shortcutDefault");
            Intrinsics.checkNotNullParameter(r15, "primaryDefaultSvg");
            Intrinsics.checkNotNullParameter(r16, "primaryColorPng");
            Intrinsics.checkNotNullParameter(r17, "mobilePrimaryDefaultPng");
            Intrinsics.checkNotNullParameter(r18, "mobilePrimarySelectedPng");
            return new Logo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public final Logo deepCopy() {
            b r0 = this.customNavigationAppLogo;
            if (r0 == null) goto L5;
            b r1 = r0.a();
        L7:
            return copy$default(this, null, null, null, null, null, null, null, r1, null, 383, null);
        L5:
            r1 = null;
            goto L7
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Logo) == true) goto L8;
            return false;
        L8:
            Logo r6 = (Logo) r5;
            if (Intrinsics.areEqual(this.primaryDefault, r6.primaryDefault) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.primarySelected, r6.primarySelected) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.shortcutDefault, r6.shortcutDefault) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.primaryDefaultSvg, r6.primaryDefaultSvg) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.primaryColorPng, r6.primaryColorPng) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.mobilePrimaryDefaultPng, r6.mobilePrimaryDefaultPng) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.mobilePrimarySelectedPng, r6.mobilePrimarySelectedPng) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.customNavigationAppLogo, r6.customNavigationAppLogo) == true) goto L33;
            return false;
        L33:
            if (this.logoStyle == r6.logoStyle) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((((this.primaryDefault.hashCode() * 31) + this.primarySelected.hashCode()) * 31) + this.shortcutDefault.hashCode()) * 31) + this.primaryDefaultSvg.hashCode()) * 31) + this.primaryColorPng.hashCode()) * 31) + this.mobilePrimaryDefaultPng.hashCode()) * 31) + this.mobilePrimarySelectedPng.hashCode()) * 31;
            b r1 = this.customNavigationAppLogo;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            NavigationAppInfo.Logo.LogoStyle r5 = this.logoStyle;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Logo(primaryDefault=" + this.primaryDefault + ", primarySelected=" + this.primarySelected + ", shortcutDefault=" + this.shortcutDefault + ", primaryDefaultSvg=" + this.primaryDefaultSvg + ", primaryColorPng=" + this.primaryColorPng + ", mobilePrimaryDefaultPng=" + this.mobilePrimaryDefaultPng + ", mobilePrimarySelectedPng=" + this.mobilePrimarySelectedPng + ", customNavigationAppLogo=" + this.customNavigationAppLogo + ", logoStyle=" + this.logoStyle + ')';
        }

        public final String getRemotePng() {
            if (TextUtils.isEmpty(this.mobilePrimarySelectedPng) == true) goto L7;
            return this.mobilePrimarySelectedPng;
        L7:
            if (TextUtils.isEmpty(this.primaryColorPng) == true) goto L11;
            return this.primaryColorPng;
        L11:
            if (TextUtils.isEmpty(this.primarySelected) == true) goto L15;
            return this.primarySelected;
        L15:
            if (TextUtils.isEmpty(this.shortcutDefault) == false) goto L17;
            return "";
        L17:
            return this.shortcutDefault;
        }

        public final b getCustomNavigationAppLogo() {
            return this.customNavigationAppLogo;
        }

        public final NavigationAppInfo.Logo.LogoStyle getLogoStyle() {
            return this.logoStyle;
        }

        public final String getMobilePrimaryDefaultPng() {
            return this.mobilePrimaryDefaultPng;
        }

        public final String getMobilePrimarySelectedPng() {
            return this.mobilePrimarySelectedPng;
        }

        public final String getPrimaryColorPng() {
            return this.primaryColorPng;
        }

        public final String getPrimaryDefault() {
            return this.primaryDefault;
        }

        public final String getPrimaryDefaultSvg() {
            return this.primaryDefaultSvg;
        }

        public final String getPrimarySelected() {
            return this.primarySelected;
        }

        public final String getShortcutDefault() {
            return this.shortcutDefault;
        }

        public Logo(String r2, String r3, String r4, String r5, String r6, String r7, String r8, b r9, NavigationAppInfo.Logo.LogoStyle r10) {
            Intrinsics.checkNotNullParameter(r2, "primaryDefault");
            Intrinsics.checkNotNullParameter(r3, "primarySelected");
            Intrinsics.checkNotNullParameter(r4, "shortcutDefault");
            Intrinsics.checkNotNullParameter(r5, "primaryDefaultSvg");
            Intrinsics.checkNotNullParameter(r6, "primaryColorPng");
            Intrinsics.checkNotNullParameter(r7, "mobilePrimaryDefaultPng");
            Intrinsics.checkNotNullParameter(r8, "mobilePrimarySelectedPng");
            this.primaryDefault = r2;
            this.primarySelected = r3;
            this.shortcutDefault = r4;
            this.primaryDefaultSvg = r5;
            this.primaryColorPng = r6;
            this.mobilePrimaryDefaultPng = r7;
            this.mobilePrimarySelectedPng = r8;
            this.customNavigationAppLogo = r9;
            this.logoStyle = r10;
        }

        public /* synthetic */ Logo(String r11, String r12, String r13, String r14, String r15, String r16, String r17, b r18, NavigationAppInfo.Logo.LogoStyle r19, int r20, DefaultConstructorMarker r21) {
            String r2 = "";
            if ((r20 & 1) == 0) goto L5;
            String r1 = "";
        L7:
            if ((r20 & 2) == 0) goto L9;
            String r3 = "";
        L11:
            if ((r20 & 4) == 0) goto L13;
            String r4 = "";
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r5 = "";
        L19:
            if ((r20 & 16) == 0) goto L21;
            String r6 = "";
        L23:
            if ((r20 & 32) == 0) goto L25;
            String r7 = "";
        L27:
            if ((r20 & 64) != 0) goto L30;
            r2 = r17;
        L30:
            NavigationAppInfo.Logo.LogoStyle r9 = null;
            if ((r20 & 128) == 0) goto L33;
            b r8 = null;
        L35:
            if ((r20 & 256) != 0) goto L38;
            r9 = r19;
        L38:
            this(r1, r3, r4, r5, r6, r7, r2, r8, r9);
            return;
        L33:
            r8 = r18;
            goto L35
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationOpenMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_MODE", "SWITCH_MODE", "PUSH_MODE", "RUNTIME_MODE", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum NavigationOpenMode extends Enum<NavigationOpenMode> {
        public static final a Companion = null;
        public static final NavigationOpenMode PUSH_MODE = null;
        public static final NavigationOpenMode RUNTIME_MODE = null;
        public static final NavigationOpenMode SWITCH_MODE = null;
        public static final NavigationOpenMode UNKNOWN_MODE = null;
        public static final /* synthetic */ NavigationOpenMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<NavigationOpenMode> getEntries() {
            return b;
        }

        static {
            NavigationOpenMode r0 = new NavigationOpenMode("UNKNOWN_MODE", 0, 0);
            UNKNOWN_MODE = r0;
            NavigationOpenMode r1 = new NavigationOpenMode("SWITCH_MODE", 1, 1);
            SWITCH_MODE = r1;
            NavigationOpenMode r3 = new NavigationOpenMode("PUSH_MODE", 2, 2);
            PUSH_MODE = r3;
            NavigationOpenMode r5 = new NavigationOpenMode("RUNTIME_MODE", 3, 100);
            RUNTIME_MODE = r5;
            NavigationOpenMode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new a();
        }

        public static NavigationOpenMode[] values() {
            return (NavigationOpenMode[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NavigationOpenMode valueOf(String r1) {
            return (NavigationOpenMode) r27.a.a(NavigationOpenMode.class, r1);
        }

        public NavigationOpenMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$NavigationSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SOURCE_UNKNOWN", "TENANT_SOURCE", "USER_SOURCE", "Companion", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum NavigationSource extends Enum<NavigationSource> {
        public static final a Companion = null;
        public static final NavigationSource SOURCE_UNKNOWN = null;
        public static final NavigationSource TENANT_SOURCE = null;
        public static final NavigationSource USER_SOURCE = null;
        public static final /* synthetic */ NavigationSource[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<NavigationSource> getEntries() {
            return b;
        }

        static {
            NavigationSource r0 = new NavigationSource("SOURCE_UNKNOWN", 0, 0);
            SOURCE_UNKNOWN = r0;
            NavigationSource r1 = new NavigationSource("TENANT_SOURCE", 1, 1);
            TENANT_SOURCE = r1;
            NavigationSource r3 = new NavigationSource("USER_SOURCE", 2, 2);
            USER_SOURCE = r3;
            NavigationSource[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new a();
        }

        public static NavigationSource[] values() {
            return (NavigationSource[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static NavigationSource valueOf(String r1) {
            return (NavigationSource) r27.a.a(NavigationSource.class, r1);
        }

        public NavigationSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0000J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogo;", "", "content", "", "type", "Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;)V", "getContent", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/maintab/export/TabAppInfo$CustomNavigationAppLogoType;", "deepCopy", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "main-tab-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class b {

        @SerializedName("content")
        private final String content;

        @SerializedName("type")
        private final CustomNavigationAppLogoType type;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.content, r6.content) == true) goto L12;
            return false;
        L12:
            if (this.type == r6.type) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.content.hashCode() * 31;
            CustomNavigationAppLogoType r1 = this.type;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "CustomNavigationAppLogo(content=" + this.content + ", type=" + this.type + ')';
        }

        public b() {
            this("", CustomNavigationAppLogoType.APP_LOGO_TYPE_UNKNOWN);
        }

        public final b a() {
            String r0 = this.content;
            CustomNavigationAppLogoType r1 = this.type;
            Intrinsics.checkNotNullParameter(r0, "content");
            return new b(r0, r1);
        }

        public final CustomNavigationAppLogoType getType() {
            return this.type;
        }

        public b(String r2, CustomNavigationAppLogoType r3) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.content = r2;
            this.type = r3;
        }
    }

    static {
        Companion = new a();
    }

    public TabAppInfo() {
        this(null, null, null, null, null, null, false, false, null, false, null, null, null, 8191, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TabAppInfo copy$default(TabAppInfo r14, String r15, String r16, TabAppType r17, Logo r18, Map r19, Extra r20, boolean r21, boolean r22, TabSite r23, boolean r24, NavigationOpenMode r25, NavigationSource r26, String r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = r14.key;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r3 = r14.uniqueId;
    L11:
        if ((r28 & 4) == 0) goto L13;
        TabAppType r4 = r14.tabAppType;
    L15:
        if ((r28 & 8) == 0) goto L17;
        Logo r5 = r14.logo;
    L19:
        if ((r28 & 16) == 0) goto L21;
        Map r6 = r14.name;
    L23:
        if ((r28 & 32) == 0) goto L25;
        Extra r7 = r14.extra;
    L27:
        if ((r28 & 64) == 0) goto L29;
        boolean r8 = r14.isPrimaryOnly;
    L31:
        if ((r28 & 128) == 0) goto L33;
        boolean r9 = r14.isUnmovable;
    L35:
        if ((r28 & 256) == 0) goto L37;
        TabSite r10 = r14.tabSite;
    L39:
        if ((r28 & 512) == 0) goto L41;
        boolean r11 = r14.isErasable;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        NavigationOpenMode r12 = r14.openMode;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        NavigationSource r13 = r14.source;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        String r1 = r14.subTitle;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component10() {
        return this.isErasable;
    }

    public final NavigationOpenMode component11() {
        return this.openMode;
    }

    public final NavigationSource component12() {
        return this.source;
    }

    public final String component13() {
        return this.subTitle;
    }

    public final String component2() {
        return this.uniqueId;
    }

    public final TabAppType component3() {
        return this.tabAppType;
    }

    public final Logo component4() {
        return this.logo;
    }

    public final Map<String, String> component5() {
        return this.name;
    }

    public final Extra component6() {
        return this.extra;
    }

    public final boolean component7() {
        return this.isPrimaryOnly;
    }

    public final boolean component8() {
        return this.isUnmovable;
    }

    public final TabSite component9() {
        return this.tabSite;
    }

    public final TabAppInfo copy(String r16, String r17, TabAppType r18, Logo r19, Map<String, String> r20, Extra r21, boolean r22, boolean r23, TabSite r24, boolean r25, NavigationOpenMode r26, NavigationSource r27, String r28) {
        Intrinsics.checkNotNullParameter(r16, IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r17, "uniqueId");
        Intrinsics.checkNotNullParameter(r18, "tabAppType");
        Intrinsics.checkNotNullParameter(r19, "logo");
        Intrinsics.checkNotNullParameter(r20, "name");
        Intrinsics.checkNotNullParameter(r21, "extra");
        Intrinsics.checkNotNullParameter(r24, "tabSite");
        Intrinsics.checkNotNullParameter(r28, "subTitle");
        return new TabAppInfo(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.tabAppType});
    }

    public String toString() {
        return "TabAppInfo(key=" + this.key + ", uniqueId=" + this.uniqueId + ", tabAppType=" + this.tabAppType + ", logo=" + this.logo + ", name=" + this.name + ", extra=" + this.extra + ", isPrimaryOnly=" + this.isPrimaryOnly + ", isUnmovable=" + this.isUnmovable + ", tabSite=" + this.tabSite + ", isErasable=" + this.isErasable + ", openMode=" + this.openMode + ", source=" + this.source + ", subTitle=" + this.subTitle + ')';
    }

    public final TabAppInfo deepCopy() {
        Logo r4 = this.logo.deepCopy();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.putAll(this.name);
        Unit r0 = Unit.INSTANCE;
        return copy$default(this, null, null, null, r4, r5, this.extra.deepCopy(), false, false, null, false, null, null, null, 8135, null);
    }

    public final Extra getExtra() {
        return this.extra;
    }

    public final String getKey() {
        return this.key;
    }

    public final Logo getLogo() {
        return this.logo;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final NavigationOpenMode getOpenMode() {
        return this.openMode;
    }

    public final NavigationSource getSource() {
        return this.source;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final TabAppType getTabAppType() {
        return this.tabAppType;
    }

    public final TabSite getTabSite() {
        return this.tabSite;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final boolean isErasable() {
        return this.isErasable;
    }

    public final boolean isPrimaryOnly() {
        return this.isPrimaryOnly;
    }

    public final boolean isUnmovable() {
        return this.isUnmovable;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TabAppInfo) == true) goto L8;
        return false;
    L8:
        TabAppInfo r6 = (TabAppInfo) r5;
        if (Intrinsics.areEqual(this.key, r6.key) == true) goto L11;
    L15:
        return false;
    L11:
        if (this.tabAppType != r6.tabAppType) goto L15;
        if (Intrinsics.areEqual(this.name, r6.name) == false) goto L15;
        return true;
    }

    public final void setTabSite(TabSite r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.tabSite = r2;
    }

    public TabAppInfo(String r2, String r3, TabAppType r4, Logo r5, Map<String, String> r6, Extra r7, boolean r8, boolean r9, TabSite r10, boolean r11, NavigationOpenMode r12, NavigationSource r13, String r14) {
        Intrinsics.checkNotNullParameter(r2, IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r3, "uniqueId");
        Intrinsics.checkNotNullParameter(r4, "tabAppType");
        Intrinsics.checkNotNullParameter(r5, "logo");
        Intrinsics.checkNotNullParameter(r6, "name");
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r10, "tabSite");
        Intrinsics.checkNotNullParameter(r14, "subTitle");
        this.key = r2;
        this.uniqueId = r3;
        this.tabAppType = r4;
        this.logo = r5;
        this.name = r6;
        this.extra = r7;
        this.isPrimaryOnly = r8;
        this.isUnmovable = r9;
        this.tabSite = r10;
        this.isErasable = r11;
        this.openMode = r12;
        this.source = r13;
        this.subTitle = r14;
    }

    public /* synthetic */ TabAppInfo(String r21, String r22, TabAppType r23, Logo r24, Map r25, Extra r26, boolean r27, boolean r28, TabSite r29, boolean r30, NavigationOpenMode r31, NavigationSource r32, String r33, int r34, DefaultConstructorMarker r35) {
        String r2 = "";
        if ((r34 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r34 & 4) == 0) goto L13;
        TabAppType r4 = TabAppType.APP_TYPE_NATIVE;
    L15:
        if ((r34 & 8) == 0) goto L17;
        Logo r5 = new Logo(null, null, null, null, null, null, null, null, null, 511, null);
    L19:
        if ((r34 & 16) == 0) goto L21;
        Map r6 = new HashMap();
    L23:
        if ((r34 & 32) == 0) goto L25;
        Extra r7 = new Extra(null, null, null, null, null, null, null, null, null, 511, null);
    L26:
        boolean r9 = false;
        if ((r34 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r34 & 128) == 0) goto L33;
        boolean r10 = false;
    L35:
        if ((r34 & 256) == 0) goto L37;
        TabSite r11 = TabSite.OTHER;
    L39:
        if ((r34 & 512) != 0) goto L42;
        r9 = r30;
    L42:
        NavigationSource r13 = null;
        if ((r34 & 1024) == 0) goto L45;
        NavigationOpenMode r12 = null;
    L47:
        if ((r34 & 2048) != 0) goto L51;
        r13 = r32;
    L51:
        if ((r34 & 4096) != 0) goto L54;
        r2 = r33;
    L54:
        this(r1, r3, r4, r5, r6, r7, r8, r10, r11, r9, r12, r13, r2);
        return;
    L45:
        r12 = r31;
        goto L47
    L37:
        r11 = r29;
        goto L39
    L33:
        r10 = r28;
        goto L35
    L29:
        r8 = r27;
        goto L31
    L25:
        r7 = r26;
        goto L26
    L21:
        r6 = r25;
        goto L23
    L17:
        r5 = r24;
        goto L19
    L13:
        r4 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }
}
