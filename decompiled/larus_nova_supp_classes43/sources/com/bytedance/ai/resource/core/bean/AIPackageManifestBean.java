package com.bytedance.ai.resource.core.bean;

import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.model.objects.ChatConfigStringAdapter;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.MainInitData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.ServiceInfo;
import com.bytedance.ai.utils.g;
import com.google.gson.annotations.JsonAdapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 W2\u00020\u0001:\u0005STUVWB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u00010*j\n\u0012\u0004\u0012\u00020+\u0018\u0001`,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001e\u0010D\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010J\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006X"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "", "<init>", "()V", "manifestVersion", "", "getManifestVersion", "()Ljava/lang/String;", "setManifestVersion", "(Ljava/lang/String;)V", "packageName", "getPackageName", "setPackageName", "versionCode", "", "getVersionCode", "()J", "setVersionCode", "(J)V", "versionName", "getVersionName", "setVersionName", "renderType", "getRenderType", "setRenderType", "applet", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "getApplet", "()Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "setApplet", "(Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;)V", "widgets", "", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$WidgetsBean;", "getWidgets", "()Ljava/util/List;", "setWidgets", "(Ljava/util/List;)V", "scmVersion", "getScmVersion", "setScmVersion", "pages", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Page;", "Lkotlin/collections/ArrayList;", "getPages", "()Ljava/util/ArrayList;", "setPages", "(Ljava/util/ArrayList;)V", "runtimeVersion", "getRuntimeVersion", "setRuntimeVersion", "permissions", "", "Lcom/bytedance/ai/model/objects/PermissionDetail;", "getPermissions", "()Ljava/util/Map;", "setPermissions", "(Ljava/util/Map;)V", "hasKeyStore", "", "getHasKeyStore", "()I", "setHasKeyStore", "(I)V", "verifySignature", "getVerifySignature", "setVerifySignature", "appType", "getAppType", "()Ljava/lang/Integer;", "setAppType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sourceType", "getSourceType", "setSourceType", "settings", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "getSettings", "()Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "setSettings", "(Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;)V", "SettingsBean", "AppletBean", "AppSettingsBean", "WidgetsBean", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageManifestBean {
    public static final Companion Companion = null;
    private Integer appType;
    private AppletBean applet;
    private int hasKeyStore;
    private String manifestVersion;
    private String packageName;
    private ArrayList<Page> pages;
    private Map<String, PermissionDetail> permissions;
    private String renderType;
    private String runtimeVersion;
    private String scmVersion;
    private SettingsBean settings;
    private Integer sourceType;
    private int verifySignature;
    private long versionCode;
    private String versionName;
    private List<WidgetsBean> widgets;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppSettingsBean;", "", "key", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppSettingsBean {
        private String key;
        private String type;

        public AppSettingsBean() {
            String r0 = null;
            this(r0, r0, 3, r0);
        }

        public static /* synthetic */ AppSettingsBean copy$default(AppSettingsBean r0, String r1, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r1 = r0.key;
        L6:
            if ((r11 & 2) == 0) goto L9;
            r10 = r0.type;
        L9:
            return r0.copy(r1, r10);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.type;
        }

        public final AppSettingsBean copy(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, "type");
            return new AppSettingsBean(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof AppSettingsBean) == true) goto L8;
            return false;
        L8:
            AppSettingsBean r11 = (AppSettingsBean) r10;
            if (Intrinsics.areEqual(this.key, r11.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r11.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            return "AppSettingsBean(key=" + this.key + ", type=" + this.type + ')';
        }

        public final String getKey() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }

        public final void setKey(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.key = r10;
        }

        public final void setType(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.type = r10;
        }

        public AppSettingsBean(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r11, "type");
            this.key = r10;
            this.type = r11;
        }

        public /* synthetic */ AppSettingsBean(String r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = "";
        L6:
            if ((r12 & 2) == 0) goto L8;
            r11 = "";
        L8:
            this(r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bT\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b!\u0010\"J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\u0011\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u001d\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0003J\u001d\u0010c\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u001d\u0010j\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010TJ\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J²\u0002\u0010o\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020\u001f2\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020tHÖ\u0001J\t\u0010u\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010$\"\u0004\bP\u0010&R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010$\"\u0004\bR\u0010&R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&¨\u0006v"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "", "appletId", "", "botId", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "description", "digest", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "keywords", "", "permissions", "plugins", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Plugin;", "Lkotlin/collections/ArrayList;", "pages", "Lcom/bytedance/ai/model/objects/Page;", "prop", com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB, "appGroup", "botDevMode", "appletEntry", "mainInit", "Lcom/bytedance/ai/model/objects/MainInitData;", "services", "Lcom/bytedance/ai/model/objects/ServiceInfo;", "appRuntimeEntry", "toolRuntimeEntry", "darkMode", "", "chat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/MainInitData;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "getBotId", "setBotId", "getName", "setName", "getDescription", "setDescription", "getDigest", "setDigest", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "setIcons", "(Lcom/bytedance/ai/model/objects/Icons;)V", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getPermissions", "setPermissions", "getPlugins", "()Ljava/util/ArrayList;", "setPlugins", "(Ljava/util/ArrayList;)V", "getPages", "setPages", "getProp", "setProp", "getRecommend", "setRecommend", "getAppGroup", "setAppGroup", "getBotDevMode", "setBotDevMode", "getAppletEntry", "setAppletEntry", "getMainInit", "()Lcom/bytedance/ai/model/objects/MainInitData;", "setMainInit", "(Lcom/bytedance/ai/model/objects/MainInitData;)V", "getServices", "setServices", "getAppRuntimeEntry", "setAppRuntimeEntry", "getToolRuntimeEntry", "setToolRuntimeEntry", "getDarkMode", "()Ljava/lang/Boolean;", "setDarkMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getChat", "setChat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/MainInitData;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppletBean {
        private String appGroup;
        private String appRuntimeEntry;
        private String appletEntry;
        private String appletId;
        private String botDevMode;
        private String botId;

        @JsonAdapter(ChatConfigStringAdapter.class)
        private String chat;
        private Boolean darkMode;
        private String description;
        private String digest;
        private Icons icons;
        private List<String> keywords;
        private MainInitData mainInit;
        private String name;
        private ArrayList<Page> pages;
        private List<String> permissions;
        private ArrayList<Plugin> plugins;
        private String prop;
        private String recommend;
        private ArrayList<ServiceInfo> services;
        private String toolRuntimeEntry;

        public AppletBean() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppletBean copy$default(AppletBean r17, String r18, String r19, String r20, String r21, String r22, Icons r23, List r24, List r25, ArrayList r26, ArrayList r27, String r28, String r29, String r30, String r31, String r32, MainInitData r33, ArrayList r34, String r35, String r36, Boolean r37, String r38, int r39, Object r40) {
            if ((r39 & 1) == 0) goto L5;
            String r10 = r17.appletId;
        L7:
            if ((r39 & 2) == 0) goto L9;
            String r11 = r17.botId;
        L11:
            if ((r39 & 4) == 0) goto L13;
            String r12 = r17.name;
        L15:
            if ((r39 & 8) == 0) goto L17;
            String r13 = r17.description;
        L19:
            if ((r39 & 16) == 0) goto L21;
            String r14 = r17.digest;
        L23:
            if ((r39 & 32) == 0) goto L25;
            Icons r15 = r17.icons;
        L27:
            if ((r39 & 64) == 0) goto L29;
            List r16 = r17.keywords;
        L31:
            if ((r39 & 128) == 0) goto L33;
            List r41 = r17.permissions;
        L35:
            if ((r39 & 256) == 0) goto L37;
            ArrayList r110 = r17.plugins;
        L39:
            if ((r39 & 512) == 0) goto L41;
            ArrayList r111 = r17.pages;
        L43:
            if ((r39 & 1024) == 0) goto L45;
            String r112 = r17.prop;
        L47:
            if ((r39 & 2048) == 0) goto L49;
            String r113 = r17.recommend;
        L51:
            if ((r39 & 4096) == 0) goto L53;
            String r114 = r17.appGroup;
        L55:
            if ((r39 & 8192) == 0) goto L57;
            String r115 = r17.botDevMode;
        L58:
            String r310 = r115;
            if ((r39 & 16384) == 0) goto L61;
            String r116 = r17.appletEntry;
        L62:
            String r311 = r116;
            if ((r39 & 32768) == 0) goto L65;
            MainInitData r117 = r17.mainInit;
        L66:
            MainInitData r312 = r117;
            if ((r39 & 65536) == 0) goto L69;
            ArrayList r118 = r17.services;
        L70:
            ArrayList r313 = r118;
            if ((r39 & 131072) == 0) goto L73;
            String r119 = r17.appRuntimeEntry;
        L74:
            String r314 = r119;
            if ((r39 & 262144) == 0) goto L77;
            String r120 = r17.toolRuntimeEntry;
        L78:
            String r315 = r120;
            if ((r39 & 524288) == 0) goto L81;
            Boolean r121 = r17.darkMode;
        L83:
            if ((r39 & 1048576) == 0) goto L85;
            String r1 = r17.chat;
        L87:
            return r17.copy(r10, r11, r12, r13, r14, r15, r16, r41, r110, r111, r112, r113, r114, r310, r311, r312, r313, r314, r315, r121, r1);
        L85:
            r1 = r38;
            goto L87
        L81:
            r121 = r37;
            goto L83
        L77:
            r120 = r36;
            goto L78
        L73:
            r119 = r35;
            goto L74
        L69:
            r118 = r34;
            goto L70
        L65:
            r117 = r33;
            goto L66
        L61:
            r116 = r32;
            goto L62
        L57:
            r115 = r31;
            goto L58
        L53:
            r114 = r30;
            goto L55
        L49:
            r113 = r29;
            goto L51
        L45:
            r112 = r28;
            goto L47
        L41:
            r111 = r27;
            goto L43
        L37:
            r110 = r26;
            goto L39
        L33:
            r41 = r25;
            goto L35
        L29:
            r16 = r24;
            goto L31
        L25:
            r15 = r23;
            goto L27
        L21:
            r14 = r22;
            goto L23
        L17:
            r13 = r21;
            goto L19
        L13:
            r12 = r20;
            goto L15
        L9:
            r11 = r19;
            goto L11
        L5:
            r10 = r18;
            goto L7
        }

        public final String component1() {
            return this.appletId;
        }

        public final ArrayList<Page> component10() {
            return this.pages;
        }

        public final String component11() {
            return this.prop;
        }

        public final String component12() {
            return this.recommend;
        }

        public final String component13() {
            return this.appGroup;
        }

        public final String component14() {
            return this.botDevMode;
        }

        public final String component15() {
            return this.appletEntry;
        }

        public final MainInitData component16() {
            return this.mainInit;
        }

        public final ArrayList<ServiceInfo> component17() {
            return this.services;
        }

        public final String component18() {
            return this.appRuntimeEntry;
        }

        public final String component19() {
            return this.toolRuntimeEntry;
        }

        public final String component2() {
            return this.botId;
        }

        public final Boolean component20() {
            return this.darkMode;
        }

        public final String component21() {
            return this.chat;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.description;
        }

        public final String component5() {
            return this.digest;
        }

        public final Icons component6() {
            return this.icons;
        }

        public final List<String> component7() {
            return this.keywords;
        }

        public final List<String> component8() {
            return this.permissions;
        }

        public final ArrayList<Plugin> component9() {
            return this.plugins;
        }

        public final AppletBean copy(String r25, String r26, String r27, String r28, String r29, Icons r30, List<String> r31, List<String> r32, ArrayList<Plugin> r33, ArrayList<Page> r34, String r35, String r36, String r37, String r38, String r39, MainInitData r40, ArrayList<ServiceInfo> r41, String r42, String r43, Boolean r44, String r45) {
            Intrinsics.checkNotNullParameter(r25, "appletId");
            Intrinsics.checkNotNullParameter(r26, "botId");
            Intrinsics.checkNotNullParameter(r27, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r28, "description");
            Intrinsics.checkNotNullParameter(r29, "digest");
            Intrinsics.checkNotNullParameter(r30, "icons");
            Intrinsics.checkNotNullParameter(r35, "prop");
            Intrinsics.checkNotNullParameter(r36, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
            Intrinsics.checkNotNullParameter(r37, "appGroup");
            Intrinsics.checkNotNullParameter(r38, "botDevMode");
            Intrinsics.checkNotNullParameter(r39, "appletEntry");
            Intrinsics.checkNotNullParameter(r42, "appRuntimeEntry");
            Intrinsics.checkNotNullParameter(r43, "toolRuntimeEntry");
            return new AppletBean(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof AppletBean) == true) goto L8;
            return false;
        L8:
            AppletBean r11 = (AppletBean) r10;
            if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.botId, r11.botId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.description, r11.description) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.digest, r11.digest) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.icons, r11.icons) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.keywords, r11.keywords) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.permissions, r11.permissions) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.plugins, r11.plugins) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.pages, r11.pages) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.prop, r11.prop) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.recommend, r11.recommend) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.appGroup, r11.appGroup) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.botDevMode, r11.botDevMode) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.appletEntry, r11.appletEntry) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.mainInit, r11.mainInit) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.services, r11.services) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.appRuntimeEntry, r11.appRuntimeEntry) == true) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.toolRuntimeEntry, r11.toolRuntimeEntry) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.darkMode, r11.darkMode) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.chat, r11.chat) == true) goto L71;
            return false;
        L71:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((this.appletId.hashCode() * 31) + this.botId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.digest.hashCode()) * 31) + this.icons.hashCode()) * 31;
            List<String> r1 = this.keywords;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            List<String> r13 = this.permissions;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            ArrayList<Plugin> r16 = this.plugins;
            if (r16 != null) goto L13;
            int r17 = 0;
        L14:
            int r18 = (r15 + r17) * 31;
            ArrayList<Page> r19 = this.pages;
            if (r19 != null) goto L17;
            int r20 = 0;
        L18:
            int r21 = (((((((((((r18 + r20) * 31) + this.prop.hashCode()) * 31) + this.recommend.hashCode()) * 31) + this.appGroup.hashCode()) * 31) + this.botDevMode.hashCode()) * 31) + this.appletEntry.hashCode()) * 31;
            MainInitData r22 = this.mainInit;
            if (r22 != null) goto L21;
            int r23 = 0;
        L22:
            int r24 = (r21 + r23) * 31;
            ArrayList<ServiceInfo> r25 = this.services;
            if (r25 != null) goto L25;
            int r26 = 0;
        L26:
            int r27 = (((((r24 + r26) * 31) + this.appRuntimeEntry.hashCode()) * 31) + this.toolRuntimeEntry.hashCode()) * 31;
            Boolean r28 = this.darkMode;
            if (r28 != null) goto L29;
            int r29 = 0;
        L30:
            int r30 = (r27 + r29) * 31;
            String r31 = this.chat;
            if (r31 == null) goto L35;
            r10 = r31.hashCode();
        L35:
            return r30 + r10;
        L29:
            r29 = r28.hashCode();
            goto L30
        L25:
            r26 = r25.hashCode();
            goto L26
        L21:
            r23 = r22.hashCode();
            goto L22
        L17:
            r20 = r19.hashCode();
            goto L18
        L13:
            r17 = r16.hashCode();
            goto L14
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "AppletBean(appletId=" + this.appletId + ", botId=" + this.botId + ", name=" + this.name + ", description=" + this.description + ", digest=" + this.digest + ", icons=" + this.icons + ", keywords=" + this.keywords + ", permissions=" + this.permissions + ", plugins=" + this.plugins + ", pages=" + this.pages + ", prop=" + this.prop + ", recommend=" + this.recommend + ", appGroup=" + this.appGroup + ", botDevMode=" + this.botDevMode + ", appletEntry=" + this.appletEntry + ", mainInit=" + this.mainInit + ", services=" + this.services + ", appRuntimeEntry=" + this.appRuntimeEntry + ", toolRuntimeEntry=" + this.toolRuntimeEntry + ", darkMode=" + this.darkMode + ", chat=" + this.chat + ')';
        }

        public final String getAppGroup() {
            return this.appGroup;
        }

        public final String getAppRuntimeEntry() {
            return this.appRuntimeEntry;
        }

        public final String getAppletEntry() {
            return this.appletEntry;
        }

        public final String getAppletId() {
            return this.appletId;
        }

        public final String getBotDevMode() {
            return this.botDevMode;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getChat() {
            return this.chat;
        }

        public final Boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getDigest() {
            return this.digest;
        }

        public final Icons getIcons() {
            return this.icons;
        }

        public final List<String> getKeywords() {
            return this.keywords;
        }

        public final MainInitData getMainInit() {
            return this.mainInit;
        }

        public final String getName() {
            return this.name;
        }

        public final ArrayList<Page> getPages() {
            return this.pages;
        }

        public final List<String> getPermissions() {
            return this.permissions;
        }

        public final ArrayList<Plugin> getPlugins() {
            return this.plugins;
        }

        public final String getProp() {
            return this.prop;
        }

        public final String getRecommend() {
            return this.recommend;
        }

        public final ArrayList<ServiceInfo> getServices() {
            return this.services;
        }

        public final String getToolRuntimeEntry() {
            return this.toolRuntimeEntry;
        }

        public final void setAppGroup(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appGroup = r10;
        }

        public final void setAppRuntimeEntry(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appRuntimeEntry = r10;
        }

        public final void setAppletEntry(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appletEntry = r10;
        }

        public final void setAppletId(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appletId = r10;
        }

        public final void setBotDevMode(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.botDevMode = r10;
        }

        public final void setBotId(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.botId = r10;
        }

        public final void setChat(String r1) {
            this.chat = r1;
        }

        public final void setDarkMode(Boolean r1) {
            this.darkMode = r1;
        }

        public final void setDescription(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.description = r10;
        }

        public final void setDigest(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.digest = r10;
        }

        public final void setIcons(Icons r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.icons = r10;
        }

        public final void setKeywords(List<String> r1) {
            this.keywords = r1;
        }

        public final void setMainInit(MainInitData r1) {
            this.mainInit = r1;
        }

        public final void setName(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.name = r10;
        }

        public final void setPages(ArrayList<Page> r1) {
            this.pages = r1;
        }

        public final void setPermissions(List<String> r1) {
            this.permissions = r1;
        }

        public final void setPlugins(ArrayList<Plugin> r1) {
            this.plugins = r1;
        }

        public final void setProp(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.prop = r10;
        }

        public final void setRecommend(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.recommend = r10;
        }

        public final void setServices(ArrayList<ServiceInfo> r1) {
            this.services = r1;
        }

        public final void setToolRuntimeEntry(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.toolRuntimeEntry = r10;
        }

        public AppletBean(String r16, String r17, String r18, String r19, String r20, Icons r21, List<String> r22, List<String> r23, ArrayList<Plugin> r24, ArrayList<Page> r25, String r26, String r27, String r28, String r29, String r30, MainInitData r31, ArrayList<ServiceInfo> r32, String r33, String r34, Boolean r35, String r36) {
            Intrinsics.checkNotNullParameter(r16, "appletId");
            Intrinsics.checkNotNullParameter(r17, "botId");
            Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r19, "description");
            Intrinsics.checkNotNullParameter(r20, "digest");
            Intrinsics.checkNotNullParameter(r21, "icons");
            Intrinsics.checkNotNullParameter(r26, "prop");
            Intrinsics.checkNotNullParameter(r27, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
            Intrinsics.checkNotNullParameter(r28, "appGroup");
            Intrinsics.checkNotNullParameter(r29, "botDevMode");
            Intrinsics.checkNotNullParameter(r30, "appletEntry");
            Intrinsics.checkNotNullParameter(r33, "appRuntimeEntry");
            Intrinsics.checkNotNullParameter(r34, "toolRuntimeEntry");
            this.appletId = r16;
            this.botId = r17;
            this.name = r18;
            this.description = r19;
            this.digest = r20;
            this.icons = r21;
            this.keywords = r22;
            this.permissions = r23;
            this.plugins = r24;
            this.pages = r25;
            this.prop = r26;
            this.recommend = r27;
            this.appGroup = r28;
            this.botDevMode = r29;
            this.appletEntry = r30;
            this.mainInit = r31;
            this.services = r32;
            this.appRuntimeEntry = r33;
            this.toolRuntimeEntry = r34;
            this.darkMode = r35;
            this.chat = r36;
        }

        public /* synthetic */ AppletBean(String r24, String r25, String r26, String r27, String r28, Icons r29, List r30, List r31, ArrayList r32, ArrayList r33, String r34, String r35, String r36, String r37, String r38, MainInitData r39, ArrayList r40, String r41, String r42, Boolean r43, String r44, int r45, DefaultConstructorMarker r46) {
            if ((r45 & 1) == 0) goto L5;
            String r1 = "";
        L7:
            if ((r45 & 2) == 0) goto L9;
            String r10 = "";
        L11:
            if ((r45 & 4) == 0) goto L13;
            String r11 = "";
        L15:
            if ((r45 & 8) == 0) goto L17;
            String r12 = "";
        L19:
            if ((r45 & 16) == 0) goto L21;
            String r13 = "";
        L23:
            if ((r45 & 32) == 0) goto L25;
            Icons r14 = new Icons();
        L27:
            if ((r45 & 64) == 0) goto L29;
            List r15 = new ArrayList();
        L31:
            if ((r45 & 128) == 0) goto L33;
            List r16 = new ArrayList();
        L35:
            if ((r45 & 256) == 0) goto L37;
            ArrayList r17 = new ArrayList();
        L39:
            if ((r45 & 512) == 0) goto L41;
            ArrayList r18 = new ArrayList();
        L43:
            if ((r45 & 1024) == 0) goto L45;
            String r19 = "";
        L47:
            if ((r45 & 2048) == 0) goto L49;
            String r110 = "";
        L51:
            if ((r45 & 4096) == 0) goto L53;
            String r111 = "";
        L55:
            if ((r45 & 8192) == 0) goto L57;
            String r112 = "";
        L59:
            if ((r45 & 16384) == 0) goto L61;
            String r20 = "";
        L62:
            String r113 = null;
            if ((r45 & 32768) == 0) goto L65;
            MainInitData r114 = null;
        L67:
            if ((r45 & 65536) == 0) goto L69;
            ArrayList r115 = new ArrayList();
        L71:
            if ((r45 & 131072) == 0) goto L73;
            String r116 = "";
        L75:
            if ((r45 & 262144) == 0) goto L77;
            String r21 = "";
        L79:
            if ((r45 & 524288) == 0) goto L81;
            Boolean r22 = Boolean.TRUE;
        L83:
            if ((r45 & 1048576) != 0) goto L86;
            r113 = r44;
        L86:
            this(r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r114, r115, r116, r21, r22, r113);
            return;
        L81:
            r22 = r43;
            goto L83
        L77:
            r21 = r42;
            goto L79
        L73:
            r116 = r41;
            goto L75
        L69:
            r115 = r40;
            goto L71
        L65:
            r114 = r39;
            goto L67
        L61:
            r20 = r38;
            goto L62
        L57:
            r112 = r37;
            goto L59
        L53:
            r111 = r36;
            goto L55
        L49:
            r110 = r35;
            goto L51
        L45:
            r19 = r34;
            goto L47
        L41:
            r18 = r33;
            goto L43
        L37:
            r17 = r32;
            goto L39
        L33:
            r16 = r31;
            goto L35
        L29:
            r15 = r30;
            goto L31
        L25:
            r14 = r29;
            goto L27
        L21:
            r13 = r28;
            goto L23
        L17:
            r12 = r27;
            goto L19
        L13:
            r11 = r26;
            goto L15
        L9:
            r10 = r25;
            goto L11
        L5:
            r1 = r24;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$Companion;", "", "<init>", "()V", "parseManifestJson", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "json", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public final AIPackageManifestBean parseManifestJson(String r10) {
            Intrinsics.checkNotNullParameter(r10, "json");
        L11:
            e = move-exception;
            g r11 = g.a;
            r11.e("AIPackageManager", "Failed to parse Manifest: " + ExceptionsKt.stackTraceToString(e));
            r11.e("AIPackageManager", "Failed to parse Manifest. content: " + r10);
        L13:
            return null;
        L4:
            if (r10.length() <= 0) goto L6;
            boolean r1 = true;
        L7:
            if (r1 == false) goto L9;
            Lazy r12 = e.a;     // Catch: Exception -> L11
            return (AIPackageManifestBean) e.a(r10, AIPackageManifestBean.class);
        L9:
            g.a.e("AIPackageManager", "Failed to parse Manifest: Read the Manifest as empty");     // Catch: Exception -> L11
            goto L13
        L6:
            r1 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "", "urlCheck", "", "<init>", "(Ljava/lang/Boolean;)V", "getUrlCheck", "()Ljava/lang/Boolean;", "setUrlCheck", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "equals", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SettingsBean {
        private Boolean urlCheck;

        public SettingsBean() {
            Boolean r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ SettingsBean copy$default(SettingsBean r0, Boolean r1, int r10, Object r11) {
            if ((r10 & 1) == 0) goto L6;
            r1 = r0.urlCheck;
        L6:
            return r0.copy(r1);
        }

        public final Boolean component1() {
            return this.urlCheck;
        }

        public final SettingsBean copy(Boolean r10) {
            return new SettingsBean(r10);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof SettingsBean) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.urlCheck, ((SettingsBean) r10).urlCheck) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.urlCheck;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "SettingsBean(urlCheck=" + this.urlCheck + ')';
        }

        public final Boolean getUrlCheck() {
            return this.urlCheck;
        }

        public SettingsBean(Boolean r1) {
            this.urlCheck = r1;
        }

        public final void setUrlCheck(Boolean r1) {
            this.urlCheck = r1;
        }

        public /* synthetic */ SettingsBean(Boolean r1, int r10, DefaultConstructorMarker r11) {
            if ((r10 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bL\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0011HÆ\u0003J\t\u0010Y\u001a\u00020\u0013HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00190\fHÆ\u0003J\t\u0010_\u001a\u00020\u0013HÆ\u0003Jß\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0013HÆ\u0001J\u0013\u0010a\u001a\u00020\u00112\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u0013HÖ\u0001J\t\u0010d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@¨\u0006e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$WidgetsBean;", "", "widgetId", "", "entry", "template", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "description", "digest", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "keywords", "", "permissions", "input", "output", "border", "", "boxType", "", "renderType", "prop", com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB, "appGroup", "appSettings", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppSettingsBean;", "titleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getWidgetId", "()Ljava/lang/String;", "setWidgetId", "(Ljava/lang/String;)V", "getEntry", "setEntry", "getTemplate", "setTemplate", "getName", "setName", "getDescription", "setDescription", "getDigest", "setDigest", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "setIcons", "(Lcom/bytedance/ai/model/objects/Icons;)V", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getPermissions", "setPermissions", "getInput", "setInput", "getOutput", "setOutput", "getBorder", "()Z", "setBorder", "(Z)V", "getBoxType", "()I", "setBoxType", "(I)V", "getRenderType", "setRenderType", "getProp", "setProp", "getRecommend", "setRecommend", "getAppGroup", "setAppGroup", "getAppSettings", "setAppSettings", "getTitleType", "setTitleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WidgetsBean {
        private String appGroup;
        private List<AppSettingsBean> appSettings;
        private boolean border;
        private int boxType;
        private String description;
        private String digest;
        private String entry;
        private Icons icons;
        private String input;
        private List<String> keywords;
        private String name;
        private String output;
        private List<String> permissions;
        private String prop;
        private String recommend;
        private String renderType;
        private String template;
        private int titleType;
        private String widgetId;

        public WidgetsBean() {
            this(null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, 0, 524287, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetsBean copy$default(WidgetsBean r17, String r18, String r19, String r20, String r21, String r22, String r23, Icons r24, List r25, List r26, String r27, String r28, boolean r29, int r30, String r31, String r32, String r33, String r34, List r35, int r36, int r37, Object r38) {
            if ((r37 & 1) == 0) goto L5;
            String r10 = r17.widgetId;
        L7:
            if ((r37 & 2) == 0) goto L9;
            String r11 = r17.entry;
        L11:
            if ((r37 & 4) == 0) goto L13;
            String r12 = r17.template;
        L15:
            if ((r37 & 8) == 0) goto L17;
            String r13 = r17.name;
        L19:
            if ((r37 & 16) == 0) goto L21;
            String r14 = r17.description;
        L23:
            if ((r37 & 32) == 0) goto L25;
            String r15 = r17.digest;
        L27:
            if ((r37 & 64) == 0) goto L29;
            Icons r16 = r17.icons;
        L31:
            if ((r37 & 128) == 0) goto L33;
            List r39 = r17.keywords;
        L35:
            if ((r37 & 256) == 0) goto L37;
            List r110 = r17.permissions;
        L39:
            if ((r37 & 512) == 0) goto L41;
            String r111 = r17.input;
        L43:
            if ((r37 & 1024) == 0) goto L45;
            String r112 = r17.output;
        L47:
            if ((r37 & 2048) == 0) goto L49;
            boolean r113 = r17.border;
        L51:
            if ((r37 & 4096) == 0) goto L53;
            int r114 = r17.boxType;
        L55:
            if ((r37 & 8192) == 0) goto L57;
            String r115 = r17.renderType;
        L58:
            String r310 = r115;
            if ((r37 & 16384) == 0) goto L61;
            String r116 = r17.prop;
        L62:
            String r311 = r116;
            if ((r37 & 32768) == 0) goto L65;
            String r117 = r17.recommend;
        L66:
            String r312 = r117;
            if ((r37 & 65536) == 0) goto L69;
            String r118 = r17.appGroup;
        L70:
            String r313 = r118;
            if ((r37 & 131072) == 0) goto L73;
            List r119 = r17.appSettings;
        L75:
            if ((r37 & 262144) == 0) goto L77;
            int r1 = r17.titleType;
        L79:
            return r17.copy(r10, r11, r12, r13, r14, r15, r16, r39, r110, r111, r112, r113, r114, r310, r311, r312, r313, r119, r1);
        L77:
            r1 = r36;
            goto L79
        L73:
            r119 = r35;
            goto L75
        L69:
            r118 = r34;
            goto L70
        L65:
            r117 = r33;
            goto L66
        L61:
            r116 = r32;
            goto L62
        L57:
            r115 = r31;
            goto L58
        L53:
            r114 = r30;
            goto L55
        L49:
            r113 = r29;
            goto L51
        L45:
            r112 = r28;
            goto L47
        L41:
            r111 = r27;
            goto L43
        L37:
            r110 = r26;
            goto L39
        L33:
            r39 = r25;
            goto L35
        L29:
            r16 = r24;
            goto L31
        L25:
            r15 = r23;
            goto L27
        L21:
            r14 = r22;
            goto L23
        L17:
            r13 = r21;
            goto L19
        L13:
            r12 = r20;
            goto L15
        L9:
            r11 = r19;
            goto L11
        L5:
            r10 = r18;
            goto L7
        }

        public final String component1() {
            return this.widgetId;
        }

        public final String component10() {
            return this.input;
        }

        public final String component11() {
            return this.output;
        }

        public final boolean component12() {
            return this.border;
        }

        public final int component13() {
            return this.boxType;
        }

        public final String component14() {
            return this.renderType;
        }

        public final String component15() {
            return this.prop;
        }

        public final String component16() {
            return this.recommend;
        }

        public final String component17() {
            return this.appGroup;
        }

        public final List<AppSettingsBean> component18() {
            return this.appSettings;
        }

        public final int component19() {
            return this.titleType;
        }

        public final String component2() {
            return this.entry;
        }

        public final String component3() {
            return this.template;
        }

        public final String component4() {
            return this.name;
        }

        public final String component5() {
            return this.description;
        }

        public final String component6() {
            return this.digest;
        }

        public final Icons component7() {
            return this.icons;
        }

        public final List<String> component8() {
            return this.keywords;
        }

        public final List<String> component9() {
            return this.permissions;
        }

        public final WidgetsBean copy(String r23, String r24, String r25, String r26, String r27, String r28, Icons r29, List<String> r30, List<String> r31, String r32, String r33, boolean r34, int r35, String r36, String r37, String r38, String r39, List<AppSettingsBean> r40, int r41) {
            Intrinsics.checkNotNullParameter(r23, "widgetId");
            Intrinsics.checkNotNullParameter(r24, "entry");
            Intrinsics.checkNotNullParameter(r25, "template");
            Intrinsics.checkNotNullParameter(r26, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r27, "description");
            Intrinsics.checkNotNullParameter(r28, "digest");
            Intrinsics.checkNotNullParameter(r32, "input");
            Intrinsics.checkNotNullParameter(r33, "output");
            Intrinsics.checkNotNullParameter(r36, "renderType");
            Intrinsics.checkNotNullParameter(r37, "prop");
            Intrinsics.checkNotNullParameter(r38, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
            Intrinsics.checkNotNullParameter(r39, "appGroup");
            Intrinsics.checkNotNullParameter(r40, "appSettings");
            return new WidgetsBean(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof WidgetsBean) == true) goto L8;
            return false;
        L8:
            WidgetsBean r11 = (WidgetsBean) r10;
            if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entry, r11.entry) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.template, r11.template) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.description, r11.description) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.digest, r11.digest) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.icons, r11.icons) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.keywords, r11.keywords) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.permissions, r11.permissions) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.input, r11.input) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.output, r11.output) == true) goto L42;
            return false;
        L42:
            if (this.border == r11.border) goto L45;
            return false;
        L45:
            if (this.boxType == r11.boxType) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.renderType, r11.renderType) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.prop, r11.prop) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.recommend, r11.recommend) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.appGroup, r11.appGroup) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.appSettings, r11.appSettings) == true) goto L63;
            return false;
        L63:
            if (this.titleType == r11.titleType) goto L65;
            return false;
        L65:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((this.widgetId.hashCode() * 31) + this.entry.hashCode()) * 31) + this.template.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.digest.hashCode()) * 31;
            Icons r1 = this.icons;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            List<String> r13 = this.keywords;
            if (r13 != null) goto L9;
            int r14 = 0;
        L10:
            int r15 = (r12 + r14) * 31;
            List<String> r16 = this.permissions;
            if (r16 == null) goto L14;
            r10 = r16.hashCode();
        L14:
            int r17 = (((((r15 + r10) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31;
            if (this.border == false) goto L17;
            int r18 = 1231;
        L19:
            return ((((((((((((((r17 + r18) * 31) + this.boxType) * 31) + this.renderType.hashCode()) * 31) + this.prop.hashCode()) * 31) + this.recommend.hashCode()) * 31) + this.appGroup.hashCode()) * 31) + this.appSettings.hashCode()) * 31) + this.titleType;
        L17:
            r18 = 1237;
            goto L19
        L9:
            r14 = r13.hashCode();
            goto L10
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "WidgetsBean(widgetId=" + this.widgetId + ", entry=" + this.entry + ", template=" + this.template + ", name=" + this.name + ", description=" + this.description + ", digest=" + this.digest + ", icons=" + this.icons + ", keywords=" + this.keywords + ", permissions=" + this.permissions + ", input=" + this.input + ", output=" + this.output + ", border=" + this.border + ", boxType=" + this.boxType + ", renderType=" + this.renderType + ", prop=" + this.prop + ", recommend=" + this.recommend + ", appGroup=" + this.appGroup + ", appSettings=" + this.appSettings + ", titleType=" + this.titleType + ')';
        }

        public final String getAppGroup() {
            return this.appGroup;
        }

        public final List<AppSettingsBean> getAppSettings() {
            return this.appSettings;
        }

        public final boolean getBorder() {
            return this.border;
        }

        public final int getBoxType() {
            return this.boxType;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getDigest() {
            return this.digest;
        }

        public final String getEntry() {
            return this.entry;
        }

        public final Icons getIcons() {
            return this.icons;
        }

        public final String getInput() {
            return this.input;
        }

        public final List<String> getKeywords() {
            return this.keywords;
        }

        public final String getName() {
            return this.name;
        }

        public final String getOutput() {
            return this.output;
        }

        public final List<String> getPermissions() {
            return this.permissions;
        }

        public final String getProp() {
            return this.prop;
        }

        public final String getRecommend() {
            return this.recommend;
        }

        public final String getRenderType() {
            return this.renderType;
        }

        public final String getTemplate() {
            return this.template;
        }

        public final int getTitleType() {
            return this.titleType;
        }

        public final String getWidgetId() {
            return this.widgetId;
        }

        public final void setAppGroup(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appGroup = r10;
        }

        public final void setAppSettings(List<AppSettingsBean> r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.appSettings = r10;
        }

        public final void setBorder(boolean r1) {
            this.border = r1;
        }

        public final void setBoxType(int r1) {
            this.boxType = r1;
        }

        public final void setDescription(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.description = r10;
        }

        public final void setDigest(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.digest = r10;
        }

        public final void setEntry(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.entry = r10;
        }

        public final void setIcons(Icons r1) {
            this.icons = r1;
        }

        public final void setInput(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.input = r10;
        }

        public final void setKeywords(List<String> r1) {
            this.keywords = r1;
        }

        public final void setName(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.name = r10;
        }

        public final void setOutput(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.output = r10;
        }

        public final void setPermissions(List<String> r1) {
            this.permissions = r1;
        }

        public final void setProp(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.prop = r10;
        }

        public final void setRecommend(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.recommend = r10;
        }

        public final void setRenderType(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.renderType = r10;
        }

        public final void setTemplate(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.template = r10;
        }

        public final void setTitleType(int r1) {
            this.titleType = r1;
        }

        public final void setWidgetId(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.widgetId = r10;
        }

        public WidgetsBean(String r16, String r17, String r18, String r19, String r20, String r21, Icons r22, List<String> r23, List<String> r24, String r25, String r26, boolean r27, int r28, String r29, String r30, String r31, String r32, List<AppSettingsBean> r33, int r34) {
            Intrinsics.checkNotNullParameter(r16, "widgetId");
            Intrinsics.checkNotNullParameter(r17, "entry");
            Intrinsics.checkNotNullParameter(r18, "template");
            Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
            Intrinsics.checkNotNullParameter(r20, "description");
            Intrinsics.checkNotNullParameter(r21, "digest");
            Intrinsics.checkNotNullParameter(r25, "input");
            Intrinsics.checkNotNullParameter(r26, "output");
            Intrinsics.checkNotNullParameter(r29, "renderType");
            Intrinsics.checkNotNullParameter(r30, "prop");
            Intrinsics.checkNotNullParameter(r31, com.bytedance.android.ec.core.event.a.VALUE_RECOMMEND_TAB);
            Intrinsics.checkNotNullParameter(r32, "appGroup");
            Intrinsics.checkNotNullParameter(r33, "appSettings");
            this.widgetId = r16;
            this.entry = r17;
            this.template = r18;
            this.name = r19;
            this.description = r20;
            this.digest = r21;
            this.icons = r22;
            this.keywords = r23;
            this.permissions = r24;
            this.input = r25;
            this.output = r26;
            this.border = r27;
            this.boxType = r28;
            this.renderType = r29;
            this.prop = r30;
            this.recommend = r31;
            this.appGroup = r32;
            this.appSettings = r33;
            this.titleType = r34;
        }

        public /* synthetic */ WidgetsBean(String r21, String r22, String r23, String r24, String r25, String r26, Icons r27, List r28, List r29, String r30, String r31, boolean r32, int r33, String r34, String r35, String r36, String r37, List r38, int r39, int r40, DefaultConstructorMarker r41) {
            if ((r40 & 1) == 0) goto L5;
            String r1 = "";
        L7:
            if ((r40 & 2) == 0) goto L9;
            String r10 = "";
        L11:
            if ((r40 & 4) == 0) goto L13;
            String r11 = "";
        L15:
            if ((r40 & 8) == 0) goto L17;
            String r12 = "";
        L19:
            if ((r40 & 16) == 0) goto L21;
            String r13 = "";
        L23:
            if ((r40 & 32) == 0) goto L25;
            String r14 = "";
        L27:
            if ((r40 & 64) == 0) goto L29;
            Icons r15 = new Icons();
        L31:
            if ((r40 & 128) == 0) goto L33;
            List r16 = new ArrayList();
        L35:
            if ((r40 & 256) == 0) goto L37;
            List r17 = new ArrayList();
        L39:
            if ((r40 & 512) == 0) goto L41;
            String r18 = "";
        L43:
            if ((r40 & 1024) == 0) goto L45;
            String r19 = "";
        L46:
            int r110 = 0;
            if ((r40 & 2048) == 0) goto L49;
            boolean r111 = false;
        L51:
            if ((r40 & 4096) != 0) goto L55;
            r110 = r33;
        L55:
            if ((r40 & 8192) == 0) goto L57;
            String r112 = "";
        L59:
            if ((r40 & 16384) == 0) goto L61;
            String r20 = "";
        L63:
            if ((r40 & 32768) == 0) goto L65;
            String r113 = "";
        L67:
            if ((r40 & 65536) == 0) goto L69;
            String r114 = "";
        L71:
            if ((r40 & 131072) == 0) goto L73;
            List r115 = new ArrayList();
        L75:
            if ((r40 & 262144) == 0) goto L77;
            int r0 = -1;
        L78:
            this(r1, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r111, r110, r112, r20, r113, r114, r115, r0);
            return;
        L77:
            r0 = r39;
            goto L78
        L73:
            r115 = r38;
            goto L75
        L69:
            r114 = r37;
            goto L71
        L65:
            r113 = r36;
            goto L67
        L61:
            r20 = r35;
            goto L63
        L57:
            r112 = r34;
            goto L59
        L49:
            r111 = r32;
            goto L51
        L45:
            r19 = r31;
            goto L46
        L41:
            r18 = r30;
            goto L43
        L37:
            r17 = r29;
            goto L39
        L33:
            r16 = r28;
            goto L35
        L29:
            r15 = r27;
            goto L31
        L25:
            r14 = r26;
            goto L27
        L21:
            r13 = r25;
            goto L23
        L17:
            r12 = r24;
            goto L19
        L13:
            r11 = r23;
            goto L15
        L9:
            r10 = r22;
            goto L11
        L5:
            r1 = r21;
            goto L7
        }
    }

    static {
        Companion = new Companion();
    }

    public AIPackageManifestBean() {
        this.manifestVersion = "";
        this.packageName = "";
        this.versionName = "";
        this.renderType = "";
        String r16 = null;
        this.applet = new AppletBean(null, null, null, null, null, null, null, null, null, null, null, null, r16, r16, null, null, null, null, null, null, null, 2097151, null);
        this.widgets = new ArrayList();
        this.scmVersion = "";
        this.pages = new ArrayList();
        this.runtimeVersion = "";
        this.permissions = new LinkedHashMap();
    }

    public final Integer getAppType() {
        return this.appType;
    }

    public final AppletBean getApplet() {
        return this.applet;
    }

    public final int getHasKeyStore() {
        return this.hasKeyStore;
    }

    public final String getManifestVersion() {
        return this.manifestVersion;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ArrayList<Page> getPages() {
        return this.pages;
    }

    public final Map<String, PermissionDetail> getPermissions() {
        return this.permissions;
    }

    public final String getRenderType() {
        return this.renderType;
    }

    public final String getRuntimeVersion() {
        return this.runtimeVersion;
    }

    public final String getScmVersion() {
        return this.scmVersion;
    }

    public final SettingsBean getSettings() {
        return this.settings;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final int getVerifySignature() {
        return this.verifySignature;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final List<WidgetsBean> getWidgets() {
        return this.widgets;
    }

    public final void setAppType(Integer r1) {
        this.appType = r1;
    }

    public final void setApplet(AppletBean r1) {
        this.applet = r1;
    }

    public final void setHasKeyStore(int r1) {
        this.hasKeyStore = r1;
    }

    public final void setManifestVersion(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.manifestVersion = r10;
    }

    public final void setPackageName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.packageName = r10;
    }

    public final void setPages(ArrayList<Page> r1) {
        this.pages = r1;
    }

    public final void setPermissions(Map<String, PermissionDetail> r1) {
        this.permissions = r1;
    }

    public final void setRenderType(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.renderType = r10;
    }

    public final void setRuntimeVersion(String r1) {
        this.runtimeVersion = r1;
    }

    public final void setScmVersion(String r1) {
        this.scmVersion = r1;
    }

    public final void setSettings(SettingsBean r1) {
        this.settings = r1;
    }

    public final void setSourceType(Integer r1) {
        this.sourceType = r1;
    }

    public final void setVerifySignature(int r1) {
        this.verifySignature = r1;
    }

    public final void setVersionCode(long r1) {
        this.versionCode = r1;
    }

    public final void setVersionName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.versionName = r10;
    }

    public final void setWidgets(List<WidgetsBean> r1) {
        this.widgets = r1;
    }
}
