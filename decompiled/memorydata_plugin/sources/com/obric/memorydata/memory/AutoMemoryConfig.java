package com.obric.memorydata.memory;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003,-.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ(\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010(\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryConfig;", "", "<init>", "()V", "MODEL_CLOUD", "", "MODEL_CLIENT", "MODEL_CLOUD_CLIENT", "PACKAGE_ASSISTANT_HISTORY", "", "PACKAGE_OBRIC_BROWSER", "PACKAGE_MEITUAN", "PACKAGE_XHS", "PACKAGE_DIANPING", "PACKAGE_BAIDU_MAP", "PACKAGE_GAODE_MAP", "PACKAGE_TOUTIAO", "PACKAGE_DOUYIN", "PACKAGE_BILIBILI", "PACKAGE_QQ_BROWSER", "PACKAGE_UC_BROWSER", "PACKAGE_QUARK_BROWSER", "localizedTextResByPackageName", "", "Lcom/obric/memorydata/memory/AutoMemoryConfig$LocalizedTextRes;", "defaultSmartMemoryPackages", "", "Lcom/obric/memorydata/memory/AutoMemoryConfig$SmartMemoryPackage;", "getDefaultSmartMemoryPackages", "()Ljava/util/List;", "localizeSmartMemoryPackages", "packages", "createSmartMemoryPackage", ObricMemoryConstants.KEY_PACKAGE_NAME, "enable", "", "model", "noNeedA11y", "getString", "resId", "localConfig", "Lcom/obric/memorydata/memory/AutoMemoryConfig$AppAutoMemoryConfig;", "getLocalConfig", "()Lcom/obric/memorydata/memory/AutoMemoryConfig$AppAutoMemoryConfig;", "LocalizedTextRes", "AppAutoMemoryConfig", "SmartMemoryPackage", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AutoMemoryConfig f10038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, a> f10039b = null;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryConfig$AppAutoMemoryConfig;", "", "smartMemoryPackages", "", "Lcom/obric/memorydata/memory/AutoMemoryConfig$SmartMemoryPackage;", "rules", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", OaidModel.KEY_ID, "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getSmartMemoryPackages", "()Ljava/util/List;", "setSmartMemoryPackages", "(Ljava/util/List;)V", "getRules", "getId", "()Ljava/lang/String;", "isValid", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AppAutoMemoryConfig {

        @SerializedName(OaidModel.KEY_ID)
        private final String id;

        @SerializedName("rule_list")
        private final List<ScreenEventReaction> rules;

        @SerializedName("app_list")
        private List<SmartMemoryPackage> smartMemoryPackages;

        public AppAutoMemoryConfig() {
            this(null, null, null, 7, null);
        }

        public AppAutoMemoryConfig(List<SmartMemoryPackage> r3, List<ScreenEventReaction> r4, String r5) {
            List<SmartMemoryPackage> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            List<ScreenEventReaction> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "smartMemoryPackages");
            Intrinsics.checkNotNullParameter(r7, "rules");
            this.smartMemoryPackages = r6;
            this.rules = r7;
            this.id = r5;
        }

        public /* synthetic */ AppAutoMemoryConfig(List r2, List r3, String r4, int r5, DefaultConstructorMarker r6) {
            List<SmartMemoryPackage> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r7 = AutoMemoryConfig.f10038a.a();
        L6:
            if ((r5 & 2) == 0) goto L9;
            r8 = CollectionsKt.emptyList();
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = UUID.randomUUID().toString();
        L11:
            this(r7, r8, r4);
        }

        public static /* synthetic */ AppAutoMemoryConfig copy$default(AppAutoMemoryConfig r1, List r2, List r3, String r4, int r5, Object r6) {
            List<SmartMemoryPackage> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List<ScreenEventReaction> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            if ((r5 & 1) == 0) goto L6;
            r7 = r1.smartMemoryPackages;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r8 = r1.rules;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r1.id;
        L12:
            return r1.copy(r7, r8, r4);
        }

        public final List<SmartMemoryPackage> component1() {
            return this.smartMemoryPackages;
        }

        public final List<ScreenEventReaction> component2() {
            return this.rules;
        }

        public final String component3() {
            return this.id;
        }

        public final AppAutoMemoryConfig copy(List<SmartMemoryPackage> r2, List<ScreenEventReaction> r3, String r4) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "smartMemoryPackages");
            Intrinsics.checkNotNullParameter(r5, "rules");
            return new AppAutoMemoryConfig(r1, r5, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AppAutoMemoryConfig.class) == true) goto L8;
            return false;
        L8:
            AppAutoMemoryConfig r6 = (AppAutoMemoryConfig) ZeusTransformUtils.preCheckCast(r5, AppAutoMemoryConfig.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.smartMemoryPackages, r6.smartMemoryPackages) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rules, r6.rules) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.id, r6.id) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getId() {
            return this.id;
        }

        public final List<ScreenEventReaction> getRules() {
            return this.rules;
        }

        public final List<SmartMemoryPackage> getSmartMemoryPackages() {
            return this.smartMemoryPackages;
        }

        public int hashCode() {
            int r0 = ((this.smartMemoryPackages.hashCode() * 31) + this.rules.hashCode()) * 31;
            String r2 = this.id;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public final boolean isValid() {
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.smartMemoryPackages, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
            return true;
        L5:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.rules, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L10;
            return false;
        L10:
            return true;
        }

        public final void setSmartMemoryPackages(List<SmartMemoryPackage> r3) {
            List<SmartMemoryPackage> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            this.smartMemoryPackages = r4;
        }

        public String toString() {
            return "AppAutoMemoryConfig(smartMemoryPackages=" + this.smartMemoryPackages + ", rules=" + this.rules + ", id=" + this.id + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\tHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryConfig$SmartMemoryPackage;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "appName", "description", "enable", "", "model", "", "noNeedA11y", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZ)V", "getPackageName", "()Ljava/lang/String;", "getAppName", "getDescription", "getEnable", "()Z", "getModel", "()I", "getNoNeedA11y", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SmartMemoryPackage {
        private final String appName;
        private final String description;
        private final boolean enable;
        private final int model;
        private final boolean noNeedA11y;
        private final String packageName;

        public SmartMemoryPackage(String r2, String r3, String r4, boolean r5, int r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r3, "appName");
            Intrinsics.checkNotNullParameter(r4, "description");
            this.packageName = r2;
            this.appName = r3;
            this.description = r4;
            this.enable = r5;
            this.model = r6;
            this.noNeedA11y = r7;
        }

        public static /* synthetic */ SmartMemoryPackage copy$default(SmartMemoryPackage r4, String r5, String r6, String r7, boolean r8, int r9, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.packageName;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.appName;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.description;
        L11:
            String r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.enable;
        L14:
            boolean r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.model;
        L17:
            int r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.noNeedA11y;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return this.packageName;
        }

        public final String component2() {
            return this.appName;
        }

        public final String component3() {
            return this.description;
        }

        public final boolean component4() {
            return this.enable;
        }

        public final int component5() {
            return this.model;
        }

        public final boolean component6() {
            return this.noNeedA11y;
        }

        public final SmartMemoryPackage copy(String r8, String r9, String r10, boolean r11, int r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r9, "appName");
            Intrinsics.checkNotNullParameter(r10, "description");
            return new SmartMemoryPackage(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, SmartMemoryPackage.class) == true) goto L8;
            return false;
        L8:
            SmartMemoryPackage r6 = (SmartMemoryPackage) ZeusTransformUtils.preCheckCast(r5, SmartMemoryPackage.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.description, r6.description) == true) goto L18;
            return false;
        L18:
            if (this.enable == r6.enable) goto L21;
            return false;
        L21:
            if (this.model == r6.model) goto L24;
            return false;
        L24:
            if (this.noNeedA11y == r6.noNeedA11y) goto L26;
            return false;
        L26:
            return true;
        }

        public final String getAppName() {
            return this.appName;
        }

        public final String getDescription() {
            return this.description;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final int getModel() {
            return this.model;
        }

        public final boolean getNoNeedA11y() {
            return this.noNeedA11y;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public int hashCode() {
            return (((((((((this.packageName.hashCode() * 31) + this.appName.hashCode()) * 31) + this.description.hashCode()) * 31) + Boolean.hashCode(this.enable)) * 31) + Integer.hashCode(this.model)) * 31) + Boolean.hashCode(this.noNeedA11y);
        }

        public String toString() {
            return "SmartMemoryPackage(packageName=" + this.packageName + ", appName=" + this.appName + ", description=" + this.description + ", enable=" + this.enable + ", model=" + this.model + ", noNeedA11y=" + this.noNeedA11y + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemoryConfig$LocalizedTextRes;", "", "appNameResId", "", "descriptionResId", "<init>", "(II)V", "getAppNameResId", "()I", "getDescriptionResId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f10040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10041b;

        public a(int r1, int r2) {
            this.f10040a = r1;
            this.f10041b = r2;
        }

        public final int a() {
            return this.f10040a;
        }

        public final int b() {
            return this.f10041b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f10040a == r6.f10040a) goto L12;
            return false;
        L12:
            if (this.f10041b == r6.f10041b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f10040a) * 31) + Integer.hashCode(this.f10041b);
        }

        public String toString() {
            return "LocalizedTextRes(appNameResId=" + this.f10040a + ", descriptionResId=" + this.f10041b + ')';
        }
    }

    static {
        f10038a = new AutoMemoryConfig();
        f10039b = MapsKt.mapOf(new Pair[]{TuplesKt.to("assistant.history", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_doubao, TypedValues.Custom.S_STRING, "auto_memory_app_name_doubao"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_phone_preference, TypedValues.Custom.S_STRING, "auto_memory_desc_phone_preference"))), TuplesKt.to("com.obric.browser", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_browser, TypedValues.Custom.S_STRING, "auto_memory_app_name_browser"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_content_collection"))), TuplesKt.to("com.sankuai.meituan", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_meituan, TypedValues.Custom.S_STRING, "auto_memory_app_name_meituan"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_store_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_store_collection"))), TuplesKt.to("com.xingin.xhs", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_xhs, TypedValues.Custom.S_STRING, "auto_memory_app_name_xhs"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_favorite_content, TypedValues.Custom.S_STRING, "auto_memory_desc_favorite_content"))), TuplesKt.to("com.dianping.v1", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_dianping, TypedValues.Custom.S_STRING, "auto_memory_app_name_dianping"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_store_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_store_collection"))), TuplesKt.to("com.baidu.BaiduMap", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_baidu_map, TypedValues.Custom.S_STRING, "auto_memory_app_name_baidu_map"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_place_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_place_collection"))), TuplesKt.to("com.autonavi.minimap", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_gaode_map, TypedValues.Custom.S_STRING, "auto_memory_app_name_gaode_map"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_place_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_place_collection"))), TuplesKt.to("com.ss.android.article.news", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_toutiao, TypedValues.Custom.S_STRING, "auto_memory_app_name_toutiao"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_content_collection"))), TuplesKt.to("com.ss.android.ugc.aweme", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_douyin, TypedValues.Custom.S_STRING, "auto_memory_app_name_douyin"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_store_and_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_store_and_content_collection"))), TuplesKt.to("tv.danmaku.bili", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_bilibili, TypedValues.Custom.S_STRING, "auto_memory_app_name_bilibili"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_content_collection"))), TuplesKt.to("com.tencent.mtt", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_qq_browser, TypedValues.Custom.S_STRING, "auto_memory_app_name_qq_browser"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_content_collection"))), TuplesKt.to("com.UCMobile", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_uc_browser, TypedValues.Custom.S_STRING, "auto_memory_app_name_uc_browser"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_content_collection"))), TuplesKt.to("com.quark.browser", new a(ZeusTransformUtils.mapRes(R.string.auto_memory_app_name_quark_browser, TypedValues.Custom.S_STRING, "auto_memory_app_name_quark_browser"), ZeusTransformUtils.mapRes(R.string.auto_memory_desc_content_collection, TypedValues.Custom.S_STRING, "auto_memory_desc_content_collection")))});
    }

    private AutoMemoryConfig() {
    }

    private final SmartMemoryPackage a(String r10, boolean r11, int r12, boolean r13) {
        a r0 = f10039b.get(r10);
        if (r0 == null) goto L7;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        return new SmartMemoryPackage(r10, a(r1.a()), a(r1.b()), r11, r12, r13);
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final String a(int r3) {
        String r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r3);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(...)");
        return r2;
    }

    public final List<SmartMemoryPackage> a() {
        return CollectionsKt.listOf(new SmartMemoryPackage[]{a("assistant.history", true, 0, true), a("com.obric.browser", true, 0, false), a("com.sankuai.meituan", true, 2, false), a("com.xingin.xhs", true, 0, false), a("com.dianping.v1", true, 0, false), a("com.baidu.BaiduMap", true, 0, false), a("com.autonavi.minimap", true, 0, false), a("com.ss.android.article.news", true, 0, false), a("com.ss.android.ugc.aweme", true, 0, false), a("tv.danmaku.bili", true, 0, false), a("com.tencent.mtt", true, 0, false), a("com.UCMobile", true, 0, false), a("com.quark.browser", true, 0, false)});
    }

    public final AppAutoMemoryConfig b() {
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(w.f11586a.a(), Collection.class, "com.obric.memorydata.plugin");
        if (r6.isEmpty() == false) goto L6;
        r6 = f10038a.a();
    L6:
        return new AppAutoMemoryConfig((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), w.f11586a.b(), null, 4, null);
    }
}
