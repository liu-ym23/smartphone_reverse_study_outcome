package com.ss.android.lark.officesdk.api.init;

import android.content.Context;
import com.ss.android.lark.officesdk.api.IOfficeSDKHostSessionProvider;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bF\b\u0086\b\u0018\u00002\u00020\u0001:\u0004fghiBÃ\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003J\t\u0010T\u001a\u00020\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0012HÆ\u0003J\t\u0010V\u001a\u00020\u0014HÆ\u0003J\t\u0010W\u001a\u00020\u0016HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010\\\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010$HÆ\u0003Jð\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0002\u0010aJ\u0013\u0010b\u001a\u00020\u00072\b\u0010c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010d\u001a\u00020\u000bHÖ\u0001J\t\u0010e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010+R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K¨\u0006j"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "", "context", "Landroid/content/Context;", "appName", "", "isDebug", "", "appId", "hostAppVersion", "env", "", "ttEnv", "journalPaths", "", "officeSDKLifeCycle", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "tokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "deviceInfoProvider", "Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "languageProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "hostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "bizConfigProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "requestTagBase", "enableNewTtnetLogReporter", "initStage", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "appBuildConfig", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "hostSessionProvider", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "userServiceInjector", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "<init>", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;)V", "getContext", "()Landroid/content/Context;", "getAppName", "()Ljava/lang/String;", "()Z", "getAppId", "getHostAppVersion", "getEnv", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTtEnv", "getJournalPaths", "()Ljava/util/List;", "getOfficeSDKLifeCycle", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "getTokenProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "getDeviceInfoProvider", "()Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "getLanguageProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "getHostAppHeaderProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "getBizConfigProvider", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "getRequestTagBase", "getEnableNewTtnetLogReporter", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getInitStage", "()Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "getAppBuildConfig", "()Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "getHostSessionProvider", "()Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "getUserServiceInjector", "()Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;)Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "equals", "other", "hashCode", "toString", "Builder", "RuntimeType", "InitStageConfig", "AppBuildConfig", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeSDKInitConfig {
    private final AppBuildConfig appBuildConfig;
    private final String appId;
    private final String appName;
    private final IOfficeSDKBizConfigProvider bizConfigProvider;
    private final Context context;
    private final IDeviceInfoProvider deviceInfoProvider;
    private final Boolean enableNewTtnetLogReporter;
    private final Integer env;
    private final IOfficeSDKHostAppHeaderProvider hostAppHeaderProvider;
    private final String hostAppVersion;
    private final IOfficeSDKHostSessionProvider hostSessionProvider;
    private final InitStageConfig initStage;
    private final boolean isDebug;
    private final List<String> journalPaths;
    private final IOfficeSdkLanguageProvider languageProvider;
    private final IOfficeSDKLifeCycle officeSDKLifeCycle;
    private final String requestTagBase;
    private final IOfficeSDKTokenProvider tokenProvider;
    private final String ttEnv;
    private final IOfficeSDKUserServiceInjector userServiceInjector;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "", "isDebug", "", "buildChannel", "", "isTestChannel", "<init>", "(ZLjava/lang/String;Z)V", "()Z", "getBuildChannel", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class AppBuildConfig {
        private final String buildChannel;
        private final boolean isDebug;
        private final boolean isTestChannel;

        public static /* synthetic */ AppBuildConfig copy$default(AppBuildConfig r0, boolean r1, String r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.isDebug;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.buildChannel;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.isTestChannel;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final boolean component1() {
            return this.isDebug;
        }

        public final String component2() {
            return this.buildChannel;
        }

        public final boolean component3() {
            return this.isTestChannel;
        }

        public final AppBuildConfig copy(boolean r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "buildChannel");
            return new AppBuildConfig(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AppBuildConfig) == true) goto L8;
            return false;
        L8:
            AppBuildConfig r6 = (AppBuildConfig) r5;
            if (this.isDebug == r6.isDebug) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.buildChannel, r6.buildChannel) == true) goto L15;
            return false;
        L15:
            if (this.isTestChannel == r6.isTestChannel) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r1 = 1231;
            if (this.isDebug == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = ((r0 * 31) + this.buildChannel.hashCode()) * 31;
            if (this.isTestChannel == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "AppBuildConfig(isDebug=" + this.isDebug + ", buildChannel=" + this.buildChannel + ", isTestChannel=" + this.isTestChannel + ')';
        }

        public final String getBuildChannel() {
            return this.buildChannel;
        }

        public final boolean isDebug() {
            return this.isDebug;
        }

        public final boolean isTestChannel() {
            return this.isTestChannel;
        }

        public AppBuildConfig(boolean r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "buildChannel");
            this.isDebug = r2;
            this.buildChannel = r3;
            this.isTestChannel = r4;
        }
    }

    @Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007J\u0015\u0010.\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007J\u0014\u00101\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u000e\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0013J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u00106\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u001bJ\u000e\u00108\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u00109\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010:\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007J\u0015\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010?\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010@\u001a\u00020\u00002\u0006\u00107\u001a\u00020&J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020(J\u0006\u0010C\u001a\u00020DR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$Builder;", "", "<init>", "()V", "context", "Landroid/content/Context;", "appName", "", "isDebug", "", "appId", "hostAppVersion", "env", "", "Ljava/lang/Integer;", "ttEnv", "journalPaths", "", "officeSDKLifeCycle", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "tokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "deviceInfoProvider", "Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "languageProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "hostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "bizConfigProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "requestTagBase", "enableNewTtnetLogReporter", "Ljava/lang/Boolean;", "initStage", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "appBuildConfig", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "hostSessionProvider", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "userServiceInjector", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "setContext", "setAppName", "setDebug", "setAppId", "setHostAppVersion", "setEnv", "(Ljava/lang/Integer;)Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$Builder;", "setTTEnv", "setJournalPaths", "setLifeCycle", "lifeCycle", "setTokenProvider", "setDeviceInfoProvider", "setHostAppHeaderProvider", "provider", "setLanguageProvider", "setBizConfigProvider", "setRequestTagBase", "setEnableNewTtnetLogReporter", "enable", "(Ljava/lang/Boolean;)Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$Builder;", "setInitStage", "setAppBuildConfig", "setHostSessionProvider", "setUserServiceInjector", "injector", "build", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Builder {
        private AppBuildConfig appBuildConfig;
        private String appId;
        private String appName;
        private IOfficeSDKBizConfigProvider bizConfigProvider;
        private Context context;
        private IDeviceInfoProvider deviceInfoProvider;
        private Boolean enableNewTtnetLogReporter;
        private Integer env;
        private IOfficeSDKHostAppHeaderProvider hostAppHeaderProvider;
        private String hostAppVersion;
        private IOfficeSDKHostSessionProvider hostSessionProvider;
        private InitStageConfig initStage;
        private boolean isDebug;
        private List<String> journalPaths;
        private IOfficeSdkLanguageProvider languageProvider;
        private IOfficeSDKLifeCycle officeSDKLifeCycle;
        private String requestTagBase;
        private IOfficeSDKTokenProvider tokenProvider;
        private String ttEnv;
        private IOfficeSDKUserServiceInjector userServiceInjector;

        public final OfficeSDKInitConfig build() {
            boolean r2 = true;
            if (this.appName.length() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L43;
            if (this.appId.length() <= 0) goto L10;
            boolean r3 = true;
        L11:
            if (r3 == false) goto L41;
            if (this.hostAppVersion.length() > 0) goto L16;
            r2 = false;
        L16:
            if (r2 == false) goto L39;
            if (this.officeSDKLifeCycle == null) goto L37;
            if (this.tokenProvider == null) goto L35;
            if (this.deviceInfoProvider == null) goto L33;
            Context r4 = this.context;
            if (r4 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("context");
            r4 = null;
        L26:
            Context r5 = r4;
            String r6 = this.appName;
            boolean r7 = this.isDebug;
            String r8 = this.appId;
            String r9 = this.hostAppVersion;
            Integer r10 = this.env;
            String r11 = this.ttEnv;
            List<String> r12 = this.journalPaths;
            IOfficeSDKLifeCycle r13 = this.officeSDKLifeCycle;
            Intrinsics.checkNotNull(r13);
            IOfficeSDKTokenProvider r14 = this.tokenProvider;
            Intrinsics.checkNotNull(r14);
            IDeviceInfoProvider r15 = this.deviceInfoProvider;
            Intrinsics.checkNotNull(r15);
            IOfficeSdkLanguageProvider r16 = this.languageProvider;
            if (r16 == null) goto L31;
            return new OfficeSDKInitConfig(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, this.hostAppHeaderProvider, this.bizConfigProvider, this.requestTagBase, this.enableNewTtnetLogReporter, this.initStage, this.appBuildConfig, this.hostSessionProvider, this.userServiceInjector, null);
        L31:
            throw new IllegalArgumentException("Required value was null.".toString());
        L33:
            throw new IllegalArgumentException("DeviceInfoProvider required".toString());
        L35:
            throw new IllegalArgumentException("TokenProvider required".toString());
        L37:
            throw new IllegalArgumentException("LifeCycle required".toString());
        L39:
            throw new IllegalArgumentException("HostAppVersion required".toString());
        L41:
            throw new IllegalArgumentException("AppId required".toString());
        L10:
            r3 = false;
            goto L11
        L43:
            throw new IllegalArgumentException("AppName required".toString());
        L5:
            r1 = false;
            goto L6
        }

        public Builder() {
            this.appName = "";
            this.appId = "";
            this.hostAppVersion = "";
            this.journalPaths = CollectionsKt.emptyList();
        }

        public final Builder setAppBuildConfig(AppBuildConfig r1) {
            this.appBuildConfig = r1;
            return this;
        }

        public final Builder setAppId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appId");
            this.appId = r2;
            return this;
        }

        public final Builder setAppName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            this.appName = r2;
            return this;
        }

        public final Builder setBizConfigProvider(IOfficeSDKBizConfigProvider r2) {
            Intrinsics.checkNotNullParameter(r2, "bizConfigProvider");
            this.bizConfigProvider = r2;
            return this;
        }

        public final Builder setContext(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.context = r2;
            return this;
        }

        public final Builder setDebug(boolean r1) {
            this.isDebug = r1;
            return this;
        }

        public final Builder setDeviceInfoProvider(IDeviceInfoProvider r2) {
            Intrinsics.checkNotNullParameter(r2, "deviceInfoProvider");
            this.deviceInfoProvider = r2;
            return this;
        }

        public final Builder setEnableNewTtnetLogReporter(Boolean r1) {
            this.enableNewTtnetLogReporter = r1;
            return this;
        }

        public final Builder setEnv(Integer r1) {
            this.env = r1;
            return this;
        }

        public final Builder setHostAppHeaderProvider(IOfficeSDKHostAppHeaderProvider r1) {
            this.hostAppHeaderProvider = r1;
            return this;
        }

        public final Builder setHostAppVersion(String r2) {
            Intrinsics.checkNotNullParameter(r2, "hostAppVersion");
            this.hostAppVersion = r2;
            return this;
        }

        public final Builder setHostSessionProvider(IOfficeSDKHostSessionProvider r2) {
            Intrinsics.checkNotNullParameter(r2, "provider");
            this.hostSessionProvider = r2;
            return this;
        }

        public final Builder setInitStage(InitStageConfig r1) {
            this.initStage = r1;
            return this;
        }

        public final Builder setJournalPaths(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "journalPaths");
            this.journalPaths = r2;
            return this;
        }

        public final Builder setLanguageProvider(IOfficeSdkLanguageProvider r2) {
            Intrinsics.checkNotNullParameter(r2, "languageProvider");
            this.languageProvider = r2;
            return this;
        }

        public final Builder setLifeCycle(IOfficeSDKLifeCycle r2) {
            Intrinsics.checkNotNullParameter(r2, "lifeCycle");
            this.officeSDKLifeCycle = r2;
            return this;
        }

        public final Builder setRequestTagBase(String r1) {
            this.requestTagBase = r1;
            return this;
        }

        public final Builder setTTEnv(String r1) {
            this.ttEnv = r1;
            return this;
        }

        public final Builder setTokenProvider(IOfficeSDKTokenProvider r2) {
            Intrinsics.checkNotNullParameter(r2, "tokenProvider");
            this.tokenProvider = r2;
            return this;
        }

        public final Builder setUserServiceInjector(IOfficeSDKUserServiceInjector r2) {
            Intrinsics.checkNotNullParameter(r2, "injector");
            this.userServiceInjector = r2;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$InitStageConfig;", "", "runtimeType", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "<init>", "(Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;)V", "getRuntimeType", "()Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class InitStageConfig {
        private final RuntimeType runtimeType;

        public static /* synthetic */ InitStageConfig copy$default(InitStageConfig r0, RuntimeType r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.runtimeType;
        L6:
            return r0.copy(r1);
        }

        public final RuntimeType component1() {
            return this.runtimeType;
        }

        public final InitStageConfig copy(RuntimeType r2) {
            return new InitStageConfig(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof InitStageConfig) == true) goto L9;
            return false;
        L9:
            if (this.runtimeType == ((InitStageConfig) r4).runtimeType) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            RuntimeType r0 = this.runtimeType;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "InitStageConfig(runtimeType=" + this.runtimeType + ')';
        }

        public final RuntimeType getRuntimeType() {
            return this.runtimeType;
        }

        public InitStageConfig(RuntimeType r1) {
            this.runtimeType = r1;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$RuntimeType;", "", "<init>", "(Ljava/lang/String;I)V", "ASYNC", "SYNC", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum RuntimeType extends Enum<RuntimeType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ RuntimeType[] $VALUES = null;
        public static final RuntimeType ASYNC = null;
        public static final RuntimeType SYNC = null;

        private static final /* synthetic */ RuntimeType[] $values() {
            return new RuntimeType[]{ASYNC, SYNC};
        }

        public static EnumEntries<RuntimeType> getEntries() {
            return $ENTRIES;
        }

        static {
            ASYNC = new RuntimeType("ASYNC", 0);
            SYNC = new RuntimeType("SYNC", 1);
            RuntimeType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static RuntimeType[] values() {
            return (RuntimeType[]) $VALUES.clone();
        }

        public static RuntimeType valueOf(String r1) {
            return (RuntimeType) a.a(RuntimeType.class, r1);
        }

        private RuntimeType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ OfficeSDKInitConfig(Context r1, String r2, boolean r3, String r4, String r5, Integer r6, String r7, List r8, IOfficeSDKLifeCycle r9, IOfficeSDKTokenProvider r10, IDeviceInfoProvider r11, IOfficeSdkLanguageProvider r12, IOfficeSDKHostAppHeaderProvider r13, IOfficeSDKBizConfigProvider r14, String r15, Boolean r16, InitStageConfig r17, AppBuildConfig r18, IOfficeSDKHostSessionProvider r19, IOfficeSDKUserServiceInjector r20, DefaultConstructorMarker r21) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfficeSDKInitConfig copy$default(OfficeSDKInitConfig r17, Context r18, String r19, boolean r20, String r21, String r22, Integer r23, String r24, List r25, IOfficeSDKLifeCycle r26, IOfficeSDKTokenProvider r27, IDeviceInfoProvider r28, IOfficeSdkLanguageProvider r29, IOfficeSDKHostAppHeaderProvider r30, IOfficeSDKBizConfigProvider r31, String r32, Boolean r33, InitStageConfig r34, AppBuildConfig r35, IOfficeSDKHostSessionProvider r36, IOfficeSDKUserServiceInjector r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        Context r2 = r17.context;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = r17.appName;
    L11:
        if ((r38 & 4) == 0) goto L13;
        boolean r4 = r17.isDebug;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = r17.appId;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r6 = r17.hostAppVersion;
    L23:
        if ((r38 & 32) == 0) goto L25;
        Integer r7 = r17.env;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = r17.ttEnv;
    L31:
        if ((r38 & 128) == 0) goto L33;
        List r9 = r17.journalPaths;
    L35:
        if ((r38 & 256) == 0) goto L37;
        IOfficeSDKLifeCycle r10 = r17.officeSDKLifeCycle;
    L39:
        if ((r38 & 512) == 0) goto L41;
        IOfficeSDKTokenProvider r11 = r17.tokenProvider;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        IDeviceInfoProvider r12 = r17.deviceInfoProvider;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        IOfficeSdkLanguageProvider r13 = r17.languageProvider;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        IOfficeSDKHostAppHeaderProvider r14 = r17.hostAppHeaderProvider;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        IOfficeSDKBizConfigProvider r15 = r17.bizConfigProvider;
    L58:
        IOfficeSDKBizConfigProvider r310 = r15;
        if ((r38 & 16384) == 0) goto L61;
        String r16 = r17.requestTagBase;
    L62:
        String r311 = r16;
        if ((r38 & 32768) == 0) goto L65;
        Boolean r110 = r17.enableNewTtnetLogReporter;
    L66:
        Boolean r312 = r110;
        if ((r38 & 65536) == 0) goto L69;
        InitStageConfig r111 = r17.initStage;
    L70:
        InitStageConfig r313 = r111;
        if ((r38 & 131072) == 0) goto L73;
        AppBuildConfig r112 = r17.appBuildConfig;
    L74:
        AppBuildConfig r314 = r112;
        if ((r38 & 262144) == 0) goto L77;
        IOfficeSDKHostSessionProvider r113 = r17.hostSessionProvider;
    L79:
        if ((r38 & 524288) == 0) goto L81;
        IOfficeSDKUserServiceInjector r1 = r17.userServiceInjector;
    L83:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r113, r1);
    L81:
        r1 = r37;
        goto L83
    L77:
        r113 = r36;
        goto L79
    L73:
        r112 = r35;
        goto L74
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Context component1() {
        return this.context;
    }

    public final IOfficeSDKTokenProvider component10() {
        return this.tokenProvider;
    }

    public final IDeviceInfoProvider component11() {
        return this.deviceInfoProvider;
    }

    public final IOfficeSdkLanguageProvider component12() {
        return this.languageProvider;
    }

    public final IOfficeSDKHostAppHeaderProvider component13() {
        return this.hostAppHeaderProvider;
    }

    public final IOfficeSDKBizConfigProvider component14() {
        return this.bizConfigProvider;
    }

    public final String component15() {
        return this.requestTagBase;
    }

    public final Boolean component16() {
        return this.enableNewTtnetLogReporter;
    }

    public final InitStageConfig component17() {
        return this.initStage;
    }

    public final AppBuildConfig component18() {
        return this.appBuildConfig;
    }

    public final IOfficeSDKHostSessionProvider component19() {
        return this.hostSessionProvider;
    }

    public final String component2() {
        return this.appName;
    }

    public final IOfficeSDKUserServiceInjector component20() {
        return this.userServiceInjector;
    }

    public final boolean component3() {
        return this.isDebug;
    }

    public final String component4() {
        return this.appId;
    }

    public final String component5() {
        return this.hostAppVersion;
    }

    public final Integer component6() {
        return this.env;
    }

    public final String component7() {
        return this.ttEnv;
    }

    public final List<String> component8() {
        return this.journalPaths;
    }

    public final IOfficeSDKLifeCycle component9() {
        return this.officeSDKLifeCycle;
    }

    public final OfficeSDKInitConfig copy(Context r24, String r25, boolean r26, String r27, String r28, Integer r29, String r30, List<String> r31, IOfficeSDKLifeCycle r32, IOfficeSDKTokenProvider r33, IDeviceInfoProvider r34, IOfficeSdkLanguageProvider r35, IOfficeSDKHostAppHeaderProvider r36, IOfficeSDKBizConfigProvider r37, String r38, Boolean r39, InitStageConfig r40, AppBuildConfig r41, IOfficeSDKHostSessionProvider r42, IOfficeSDKUserServiceInjector r43) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "appName");
        Intrinsics.checkNotNullParameter(r27, "appId");
        Intrinsics.checkNotNullParameter(r28, "hostAppVersion");
        Intrinsics.checkNotNullParameter(r31, "journalPaths");
        Intrinsics.checkNotNullParameter(r32, "officeSDKLifeCycle");
        Intrinsics.checkNotNullParameter(r33, "tokenProvider");
        Intrinsics.checkNotNullParameter(r34, "deviceInfoProvider");
        Intrinsics.checkNotNullParameter(r35, "languageProvider");
        return new OfficeSDKInitConfig(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeSDKInitConfig) == true) goto L8;
        return false;
    L8:
        OfficeSDKInitConfig r6 = (OfficeSDKInitConfig) r5;
        if (Intrinsics.areEqual(this.context, r6.context) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L15;
        return false;
    L15:
        if (this.isDebug == r6.isDebug) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appId, r6.appId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.hostAppVersion, r6.hostAppVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.env, r6.env) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ttEnv, r6.ttEnv) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.journalPaths, r6.journalPaths) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.officeSDKLifeCycle, r6.officeSDKLifeCycle) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.tokenProvider, r6.tokenProvider) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.deviceInfoProvider, r6.deviceInfoProvider) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.languageProvider, r6.languageProvider) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hostAppHeaderProvider, r6.hostAppHeaderProvider) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.bizConfigProvider, r6.bizConfigProvider) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.requestTagBase, r6.requestTagBase) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.enableNewTtnetLogReporter, r6.enableNewTtnetLogReporter) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.initStage, r6.initStage) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.appBuildConfig, r6.appBuildConfig) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.hostSessionProvider, r6.hostSessionProvider) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.userServiceInjector, r6.userServiceInjector) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.context.hashCode() * 31) + this.appName.hashCode()) * 31;
        if (this.isDebug == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((r0 + r1) * 31) + this.appId.hashCode()) * 31) + this.hostAppVersion.hashCode()) * 31;
        Integer r3 = this.env;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.ttEnv;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((((((((r6 + r8) * 31) + this.journalPaths.hashCode()) * 31) + this.officeSDKLifeCycle.hashCode()) * 31) + this.tokenProvider.hashCode()) * 31) + this.deviceInfoProvider.hashCode()) * 31) + this.languageProvider.hashCode()) * 31;
        IOfficeSDKHostAppHeaderProvider r10 = this.hostAppHeaderProvider;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        IOfficeSDKBizConfigProvider r13 = this.bizConfigProvider;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.requestTagBase;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.enableNewTtnetLogReporter;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        InitStageConfig r22 = this.initStage;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        AppBuildConfig r25 = this.appBuildConfig;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        IOfficeSDKHostSessionProvider r28 = this.hostSessionProvider;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        IOfficeSDKUserServiceInjector r31 = this.userServiceInjector;
        if (r31 == null) goto L47;
        r4 = r31.hashCode();
    L47:
        return r30 + r4;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "OfficeSDKInitConfig(context=" + this.context + ", appName=" + this.appName + ", isDebug=" + this.isDebug + ", appId=" + this.appId + ", hostAppVersion=" + this.hostAppVersion + ", env=" + this.env + ", ttEnv=" + this.ttEnv + ", journalPaths=" + this.journalPaths + ", officeSDKLifeCycle=" + this.officeSDKLifeCycle + ", tokenProvider=" + this.tokenProvider + ", deviceInfoProvider=" + this.deviceInfoProvider + ", languageProvider=" + this.languageProvider + ", hostAppHeaderProvider=" + this.hostAppHeaderProvider + ", bizConfigProvider=" + this.bizConfigProvider + ", requestTagBase=" + this.requestTagBase + ", enableNewTtnetLogReporter=" + this.enableNewTtnetLogReporter + ", initStage=" + this.initStage + ", appBuildConfig=" + this.appBuildConfig + ", hostSessionProvider=" + this.hostSessionProvider + ", userServiceInjector=" + this.userServiceInjector + ')';
    }

    public final AppBuildConfig getAppBuildConfig() {
        return this.appBuildConfig;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final IOfficeSDKBizConfigProvider getBizConfigProvider() {
        return this.bizConfigProvider;
    }

    public final Context getContext() {
        return this.context;
    }

    public final IDeviceInfoProvider getDeviceInfoProvider() {
        return this.deviceInfoProvider;
    }

    public final Boolean getEnableNewTtnetLogReporter() {
        return this.enableNewTtnetLogReporter;
    }

    public final Integer getEnv() {
        return this.env;
    }

    public final IOfficeSDKHostAppHeaderProvider getHostAppHeaderProvider() {
        return this.hostAppHeaderProvider;
    }

    public final String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public final IOfficeSDKHostSessionProvider getHostSessionProvider() {
        return this.hostSessionProvider;
    }

    public final InitStageConfig getInitStage() {
        return this.initStage;
    }

    public final List<String> getJournalPaths() {
        return this.journalPaths;
    }

    public final IOfficeSdkLanguageProvider getLanguageProvider() {
        return this.languageProvider;
    }

    public final IOfficeSDKLifeCycle getOfficeSDKLifeCycle() {
        return this.officeSDKLifeCycle;
    }

    public final String getRequestTagBase() {
        return this.requestTagBase;
    }

    public final IOfficeSDKTokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public final String getTtEnv() {
        return this.ttEnv;
    }

    public final IOfficeSDKUserServiceInjector getUserServiceInjector() {
        return this.userServiceInjector;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    private OfficeSDKInitConfig(Context r3, String r4, boolean r5, String r6, String r7, Integer r8, String r9, List<String> r10, IOfficeSDKLifeCycle r11, IOfficeSDKTokenProvider r12, IDeviceInfoProvider r13, IOfficeSdkLanguageProvider r14, IOfficeSDKHostAppHeaderProvider r15, IOfficeSDKBizConfigProvider r16, String r17, Boolean r18, InitStageConfig r19, AppBuildConfig r20, IOfficeSDKHostSessionProvider r21, IOfficeSDKUserServiceInjector r22) {
        this.context = r3;
        this.appName = r4;
        this.isDebug = r5;
        this.appId = r6;
        this.hostAppVersion = r7;
        this.env = r8;
        this.ttEnv = r9;
        this.journalPaths = r10;
        this.officeSDKLifeCycle = r11;
        this.tokenProvider = r12;
        this.deviceInfoProvider = r13;
        this.languageProvider = r14;
        this.hostAppHeaderProvider = r15;
        this.bizConfigProvider = r16;
        this.requestTagBase = r17;
        this.enableNewTtnetLogReporter = r18;
        this.initStage = r19;
        this.appBuildConfig = r20;
        this.hostSessionProvider = r21;
        this.userServiceInjector = r22;
    }
}
