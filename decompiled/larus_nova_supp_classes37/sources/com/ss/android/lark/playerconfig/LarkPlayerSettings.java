package com.ss.android.lark.playerconfig;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class LarkPlayerSettings {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R2\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006'"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;", "", "enableDebugLog", "", "nonStandard", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "tags", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$TagItem;", "<init>", "(ZLcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getEnableDebugLog", "()Z", "setEnableDebugLog", "(Z)V", "getNonStandard", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;", "setNonStandard", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "getTags", "setTags", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class EngineSetting {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName("enable_debug_log")
        private boolean enableDebugLog;

        @SerializedName("non_standard")
        private NonStandardEngineSetting nonStandard;

        @SerializedName("tags")
        private ArrayList<TagItem> tags;

        public EngineSetting() {
            this(false, null, null, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EngineSetting copy$default(EngineSetting r0, boolean r1, NonStandardEngineSetting r2, ArrayList r3, ArrayList r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.enableDebugLog;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.nonStandard;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.base;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.tags;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final boolean component1() {
            return this.enableDebugLog;
        }

        public final NonStandardEngineSetting component2() {
            return this.nonStandard;
        }

        public final ArrayList<SettingItem> component3() {
            return this.base;
        }

        public final ArrayList<TagItem> component4() {
            return this.tags;
        }

        public final EngineSetting copy(boolean r2, NonStandardEngineSetting r3, ArrayList<SettingItem> r4, ArrayList<TagItem> r5) {
            Intrinsics.checkNotNullParameter(r3, "nonStandard");
            return new EngineSetting(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof EngineSetting) == true) goto L8;
            return false;
        L8:
            EngineSetting r6 = (EngineSetting) r5;
            if (this.enableDebugLog == r6.enableDebugLog) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.nonStandard, r6.nonStandard) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.base, r6.base) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.tags, r6.tags) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            if (this.enableDebugLog == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.nonStandard.hashCode()) * 31;
            ArrayList<SettingItem> r2 = this.base;
            int r3 = 0;
            if (r2 != null) goto L9;
            int r4 = 0;
        L10:
            int r5 = (r1 + r4) * 31;
            ArrayList<TagItem> r6 = this.tags;
            if (r6 == null) goto L15;
            r3 = r6.hashCode();
        L15:
            return r5 + r3;
        L9:
            r4 = r2.hashCode();
            goto L10
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "EngineSetting(enableDebugLog=" + this.enableDebugLog + ", nonStandard=" + this.nonStandard + ", base=" + this.base + ", tags=" + this.tags + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final boolean getEnableDebugLog() {
            return this.enableDebugLog;
        }

        public final NonStandardEngineSetting getNonStandard() {
            return this.nonStandard;
        }

        public final ArrayList<TagItem> getTags() {
            return this.tags;
        }

        public final void setBase(ArrayList<SettingItem> r1) {
            this.base = r1;
        }

        public final void setEnableDebugLog(boolean r1) {
            this.enableDebugLog = r1;
        }

        public final void setNonStandard(NonStandardEngineSetting r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.nonStandard = r2;
        }

        public final void setTags(ArrayList<TagItem> r1) {
            this.tags = r1;
        }

        public EngineSetting(boolean r2, NonStandardEngineSetting r3, ArrayList<SettingItem> r4, ArrayList<TagItem> r5) {
            Intrinsics.checkNotNullParameter(r3, "nonStandard");
            this.enableDebugLog = r2;
            this.nonStandard = r3;
            this.base = r4;
            this.tags = r5;
        }

        public /* synthetic */ EngineSetting(boolean r8, NonStandardEngineSetting r9, ArrayList r10, ArrayList r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L6;
            r8 = false;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r9 = new NonStandardEngineSetting(0, 0, 0, 0, 15, null);
        L9:
            if ((r12 & 4) == 0) goto L12;
            r10 = null;
        L12:
            if ((r12 & 8) == 0) goto L14;
            r11 = null;
        L14:
            this(r8, r9, r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$LarkPlayerConfig;", "", "mdl", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;", "engine", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;", "<init>", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;)V", "getMdl", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;", "setMdl", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;)V", "getEngine", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;", "setEngine", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$EngineSetting;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class LarkPlayerConfig {

        @SerializedName("engine")
        private EngineSetting engine;

        @SerializedName("mdl")
        private MDLSetting mdl;

        /* JADX WARN: Multi-variable type inference failed */
        public LarkPlayerConfig() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ LarkPlayerConfig copy$default(LarkPlayerConfig r0, MDLSetting r1, EngineSetting r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.mdl;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.engine;
        L9:
            return r0.copy(r1, r2);
        }

        public final MDLSetting component1() {
            return this.mdl;
        }

        public final EngineSetting component2() {
            return this.engine;
        }

        public final LarkPlayerConfig copy(MDLSetting r2, EngineSetting r3) {
            Intrinsics.checkNotNullParameter(r2, "mdl");
            Intrinsics.checkNotNullParameter(r3, "engine");
            return new LarkPlayerConfig(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof LarkPlayerConfig) == true) goto L8;
            return false;
        L8:
            LarkPlayerConfig r6 = (LarkPlayerConfig) r5;
            if (Intrinsics.areEqual(this.mdl, r6.mdl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.engine, r6.engine) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.mdl.hashCode() * 31) + this.engine.hashCode();
        }

        public String toString() {
            return "LarkPlayerConfig(mdl=" + this.mdl + ", engine=" + this.engine + ')';
        }

        public final EngineSetting getEngine() {
            return this.engine;
        }

        public final MDLSetting getMdl() {
            return this.mdl;
        }

        public final void setEngine(EngineSetting r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.engine = r2;
        }

        public final void setMdl(MDLSetting r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mdl = r2;
        }

        public LarkPlayerConfig(MDLSetting r2, EngineSetting r3) {
            Intrinsics.checkNotNullParameter(r2, "mdl");
            Intrinsics.checkNotNullParameter(r3, "engine");
            this.mdl = r2;
            this.engine = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ LarkPlayerConfig(MDLSetting r8, EngineSetting r9, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L6;
            NonStandardMDLSetting r0 = null;
            Object[] r1 = 0 == true ? 1 : 0;
            r8 = new MDLSetting(r0, r1, 3, 0 == true ? 1 : 0);
        L6:
            if ((r10 & 2) == 0) goto L8;
            r9 = new EngineSetting(false, null, null, null, 15, null);
        L8:
            this(r8, r9);
        }
    }

    @AppConfig(key = "lark_player_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$LarkPlayerSetting;", "", "<init>", "()V", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class LarkPlayerSetting {
        public LarkPlayerSetting() {
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$MDLSetting;", "", "nonStandard", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;Ljava/util/ArrayList;)V", "getNonStandard", "()Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;", "setNonStandard", "(Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class MDLSetting {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName("non_standard")
        private NonStandardMDLSetting nonStandard;

        /* JADX WARN: Multi-variable type inference failed */
        public MDLSetting() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MDLSetting copy$default(MDLSetting r0, NonStandardMDLSetting r1, ArrayList r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.nonStandard;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.base;
        L9:
            return r0.copy(r1, r2);
        }

        public final NonStandardMDLSetting component1() {
            return this.nonStandard;
        }

        public final ArrayList<SettingItem> component2() {
            return this.base;
        }

        public final MDLSetting copy(NonStandardMDLSetting r2, ArrayList<SettingItem> r3) {
            Intrinsics.checkNotNullParameter(r2, "nonStandard");
            return new MDLSetting(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof MDLSetting) == true) goto L8;
            return false;
        L8:
            MDLSetting r6 = (MDLSetting) r5;
            if (Intrinsics.areEqual(this.nonStandard, r6.nonStandard) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.base, r6.base) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.nonStandard.hashCode() * 31;
            ArrayList<SettingItem> r1 = this.base;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "MDLSetting(nonStandard=" + this.nonStandard + ", base=" + this.base + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final NonStandardMDLSetting getNonStandard() {
            return this.nonStandard;
        }

        public final void setBase(ArrayList<SettingItem> r1) {
            this.base = r1;
        }

        public final void setNonStandard(NonStandardMDLSetting r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.nonStandard = r2;
        }

        public MDLSetting(NonStandardMDLSetting r2, ArrayList<SettingItem> r3) {
            Intrinsics.checkNotNullParameter(r2, "nonStandard");
            this.nonStandard = r2;
            this.base = r3;
        }

        public /* synthetic */ MDLSetting(NonStandardMDLSetting r1, ArrayList r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = new NonStandardMDLSetting();
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardEngineSetting;", "", "engineType", "", "enableLooper", "setCacheControlEnabled", "codecID", "<init>", "(IIII)V", "getEngineType", "()I", "setEngineType", "(I)V", "getEnableLooper", "setEnableLooper", "getSetCacheControlEnabled", "setSetCacheControlEnabled", "getCodecID", "setCodecID", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NonStandardEngineSetting {

        @SerializedName("ASYNC_INIT_CODEC_ID")
        private int codecID;

        @SerializedName("ENGINE_PARAM_KEY_ENABLE_LOOPER")
        private int enableLooper;

        @SerializedName("ENGINE_TYPE")
        private int engineType;

        @SerializedName("SET_CACHE_CONTROL_ENABLED")
        private int setCacheControlEnabled;

        public NonStandardEngineSetting() {
            this(0, 0, 0, 0, 15, null);
        }

        public static /* synthetic */ NonStandardEngineSetting copy$default(NonStandardEngineSetting r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.engineType;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.enableLooper;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.setCacheControlEnabled;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.codecID;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.engineType;
        }

        public final int component2() {
            return this.enableLooper;
        }

        public final int component3() {
            return this.setCacheControlEnabled;
        }

        public final int component4() {
            return this.codecID;
        }

        public final NonStandardEngineSetting copy(int r2, int r3, int r4, int r5) {
            return new NonStandardEngineSetting(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof NonStandardEngineSetting) == true) goto L8;
            return false;
        L8:
            NonStandardEngineSetting r6 = (NonStandardEngineSetting) r5;
            if (this.engineType == r6.engineType) goto L12;
            return false;
        L12:
            if (this.enableLooper == r6.enableLooper) goto L15;
            return false;
        L15:
            if (this.setCacheControlEnabled == r6.setCacheControlEnabled) goto L18;
            return false;
        L18:
            if (this.codecID == r6.codecID) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.engineType * 31) + this.enableLooper) * 31) + this.setCacheControlEnabled) * 31) + this.codecID;
        }

        public String toString() {
            return "NonStandardEngineSetting(engineType=" + this.engineType + ", enableLooper=" + this.enableLooper + ", setCacheControlEnabled=" + this.setCacheControlEnabled + ", codecID=" + this.codecID + ')';
        }

        public final int getCodecID() {
            return this.codecID;
        }

        public final int getEnableLooper() {
            return this.enableLooper;
        }

        public final int getEngineType() {
            return this.engineType;
        }

        public final int getSetCacheControlEnabled() {
            return this.setCacheControlEnabled;
        }

        public final void setCodecID(int r1) {
            this.codecID = r1;
        }

        public final void setEnableLooper(int r1) {
            this.enableLooper = r1;
        }

        public final void setEngineType(int r1) {
            this.engineType = r1;
        }

        public final void setSetCacheControlEnabled(int r1) {
            this.setCacheControlEnabled = r1;
        }

        public NonStandardEngineSetting(int r1, int r2, int r3, int r4) {
            this.engineType = r1;
            this.enableLooper = r2;
            this.setCacheControlEnabled = r3;
            this.codecID = r4;
        }

        public /* synthetic */ NonStandardEngineSetting(int r3, int r4, int r5, int r6, int r7, DefaultConstructorMarker r8) {
            if ((r7 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = 1;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = 1;
        L12:
            if ((r7 & 8) == 0) goto L14;
            r6 = 0;
        L14:
            this(r3, r4, r5, r6);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$NonStandardMDLSetting;", "", "<init>", "()V", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class NonStandardMDLSetting {
        public NonStandardMDLSetting() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "", "key", "", "value", "type", "", "desc", "<init>", "(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()I", "setKey", "(I)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "getDesc", "setDesc", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class SettingItem {

        @SerializedName("desc")
        private String desc;

        @SerializedName("key")
        private int key;

        @SerializedName("type")
        private String type;

        @SerializedName("value")
        private Object value;

        public SettingItem() {
            this(0, null, null, null, 15, null);
        }

        public static /* synthetic */ SettingItem copy$default(SettingItem r0, int r1, Object r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.key;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.value;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.type;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.desc;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.key;
        }

        public final Object component2() {
            return this.value;
        }

        public final String component3() {
            return this.type;
        }

        public final String component4() {
            return this.desc;
        }

        public final SettingItem copy(int r2, Object r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "desc");
            return new SettingItem(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SettingItem) == true) goto L8;
            return false;
        L8:
            SettingItem r6 = (SettingItem) r5;
            if (this.key == r6.key) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.value, r6.value) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.type, r6.type) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.desc, r6.desc) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = this.key * 31;
            Object r1 = this.value;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((r0 + r2) * 31) + this.type.hashCode()) * 31) + this.desc.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "SettingItem(key=" + this.key + ", value=" + this.value + ", type=" + this.type + ", desc=" + this.desc + ')';
        }

        public final String getDesc() {
            return this.desc;
        }

        public final int getKey() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }

        public final Object getValue() {
            return this.value;
        }

        public final void setDesc(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.desc = r2;
        }

        public final void setKey(int r1) {
            this.key = r1;
        }

        public final void setType(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.type = r2;
        }

        public final void setValue(Object r1) {
            this.value = r1;
        }

        public SettingItem(int r2, Object r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "type");
            Intrinsics.checkNotNullParameter(r5, "desc");
            this.key = r2;
            this.value = r3;
            this.type = r4;
            this.desc = r5;
        }

        public /* synthetic */ SettingItem(int r2, Object r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = Integer.MAX_VALUE;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r6 & 4) == 0) goto L12;
            r4 = "";
        L12:
            if ((r6 & 8) == 0) goto L14;
            r5 = "";
        L14:
            this(r2, r3, r4, r5);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SubTagItem;", "", AppbrandHostConstants.Schema_Meta.NAME, "", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class SubTagItem {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName(AppbrandHostConstants.Schema_Meta.NAME)
        private String name;

        /* JADX WARN: Multi-variable type inference failed */
        public SubTagItem() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubTagItem copy$default(SubTagItem r0, String r1, ArrayList r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.name;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.base;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.name;
        }

        public final ArrayList<SettingItem> component2() {
            return this.base;
        }

        public final SubTagItem copy(String r2, ArrayList<SettingItem> r3) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
            return new SubTagItem(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SubTagItem) == true) goto L8;
            return false;
        L8:
            SubTagItem r6 = (SubTagItem) r5;
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.base, r6.base) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.name.hashCode() * 31;
            ArrayList<SettingItem> r1 = this.base;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "SubTagItem(name=" + this.name + ", base=" + this.base + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final String getName() {
            return this.name;
        }

        public final void setBase(ArrayList<SettingItem> r1) {
            this.base = r1;
        }

        public final void setName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.name = r2;
        }

        public SubTagItem(String r2, ArrayList<SettingItem> r3) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
            this.name = r2;
            this.base = r3;
        }

        public /* synthetic */ SubTagItem(String r1, ArrayList r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = "";
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = null;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR2\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$TagItem;", "", AppbrandHostConstants.Schema_Meta.NAME, "", "base", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SettingItem;", "Lkotlin/collections/ArrayList;", "subTags", "Lcom/ss/android/lark/playerconfig/LarkPlayerSettings$SubTagItem;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getBase", "()Ljava/util/ArrayList;", "setBase", "(Ljava/util/ArrayList;)V", "getSubTags", "setSubTags", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "playerconfig_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class TagItem {

        @SerializedName("base")
        private ArrayList<SettingItem> base;

        @SerializedName(AppbrandHostConstants.Schema_Meta.NAME)
        private String name;

        @SerializedName("subtags")
        private ArrayList<SubTagItem> subTags;

        public TagItem() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TagItem copy$default(TagItem r0, String r1, ArrayList r2, ArrayList r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.name;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.base;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.subTags;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.name;
        }

        public final ArrayList<SettingItem> component2() {
            return this.base;
        }

        public final ArrayList<SubTagItem> component3() {
            return this.subTags;
        }

        public final TagItem copy(String r2, ArrayList<SettingItem> r3, ArrayList<SubTagItem> r4) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
            return new TagItem(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TagItem) == true) goto L8;
            return false;
        L8:
            TagItem r6 = (TagItem) r5;
            if (Intrinsics.areEqual(this.name, r6.name) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.base, r6.base) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.subTags, r6.subTags) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.name.hashCode() * 31;
            ArrayList<SettingItem> r1 = this.base;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ArrayList<SubTagItem> r5 = this.subTags;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "TagItem(name=" + this.name + ", base=" + this.base + ", subTags=" + this.subTags + ')';
        }

        public final ArrayList<SettingItem> getBase() {
            return this.base;
        }

        public final String getName() {
            return this.name;
        }

        public final ArrayList<SubTagItem> getSubTags() {
            return this.subTags;
        }

        public final void setBase(ArrayList<SettingItem> r1) {
            this.base = r1;
        }

        public final void setName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.name = r2;
        }

        public final void setSubTags(ArrayList<SubTagItem> r1) {
            this.subTags = r1;
        }

        public TagItem(String r2, ArrayList<SettingItem> r3, ArrayList<SubTagItem> r4) {
            Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
            this.name = r2;
            this.base = r3;
            this.subTags = r4;
        }

        public /* synthetic */ TagItem(String r2, ArrayList r3, ArrayList r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }
    }

    public LarkPlayerSettings() {
    }

    static {
        a = LazyKt.lazy(LarkPlayerSettings$remoteSetting$2.INSTANCE);
        b = LazyKt.lazy(LarkPlayerSettings$switchConfig$2.INSTANCE);
        c = LazyKt.lazy(LarkPlayerSettings$mdl$2.INSTANCE);
        d = LazyKt.lazy(LarkPlayerSettings$engine$2.INSTANCE);
    }
}
