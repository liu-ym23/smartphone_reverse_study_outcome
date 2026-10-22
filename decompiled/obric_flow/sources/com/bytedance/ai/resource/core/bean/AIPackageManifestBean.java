package com.bytedance.ai.resource.core.bean;

import ai.j0;
import androidx.annotation.Keep;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.MainInitData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.ServiceInfo;
import com.bytedance.ai.utils.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kk.a;
import kn.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 >2\u00020\u0001:\u0004;<=>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u00010*j\n\u0012\u0004\u0012\u00020+\u0018\u0001`,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "", "<init>", "()V", "manifestVersion", "", "getManifestVersion", "()Ljava/lang/String;", "setManifestVersion", "(Ljava/lang/String;)V", "packageName", "getPackageName", "setPackageName", "versionCode", "", "getVersionCode", "()J", "setVersionCode", "(J)V", "versionName", "getVersionName", "setVersionName", "renderType", "getRenderType", "setRenderType", "applet", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "getApplet", "()Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "setApplet", "(Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;)V", "widgets", "", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$WidgetsBean;", "getWidgets", "()Ljava/util/List;", "setWidgets", "(Ljava/util/List;)V", "scmVersion", "getScmVersion", "setScmVersion", "pages", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Page;", "Lkotlin/collections/ArrayList;", "getPages", "()Ljava/util/ArrayList;", "setPages", "(Ljava/util/ArrayList;)V", "runtimeVersion", "getRuntimeVersion", "setRuntimeVersion", "permissions", "", "Lcom/bytedance/ai/model/objects/PermissionDetail;", "getPermissions", "()Ljava/util/Map;", "setPermissions", "(Ljava/util/Map;)V", "AppletBean", "AppSettingsBean", "WidgetsBean", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageManifestBean {
    public static final Companion Companion = null;
    private AppletBean applet;
    private String manifestVersion;
    private String packageName;
    private ArrayList<Page> pages;
    private Map<String, PermissionDetail> permissions;
    private String renderType;
    private String runtimeVersion;
    private String scmVersion;
    private long versionCode;
    private String versionName;
    private List<WidgetsBean> widgets;

    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppSettingsBean;", "", STGroup.DICT_KEY, "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AppSettingsBean {
        private String key;
        private String type;

        /* JADX WARN: Multi-variable type inference failed */
        public AppSettingsBean() {
            Object[] r5 = 0 == true ? 1 : 0;
            this(null, r5, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AppSettingsBean copy$default(AppSettingsBean r5, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.key;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.type;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.type;
        }

        public final AppSettingsBean copy(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
            Intrinsics.checkNotNullParameter(r10, "type");
            return new AppSettingsBean(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AppSettingsBean) == true) goto L8;
            return false;
        L8:
            AppSettingsBean r10 = (AppSettingsBean) r5;
            if (Intrinsics.areEqual(this.key, r10.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r10.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            int r5 = this.key.hashCode() * 31;
            return this.type.hashCode() + r5;
        }

        public final void setKey(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.key = r5;
        }

        public final void setType(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.type = r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("AppSettingsBean(key=");
            r5.append(this.key);
            r5.append(", type=");
            return j0.p(r5, this.type, ')');
        }

        public AppSettingsBean(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, STGroup.DICT_KEY);
            Intrinsics.checkNotNullParameter(r10, "type");
            this.key = r5;
            this.type = r10;
        }

        public /* synthetic */ AppSettingsBean(String r5, String r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = "";
        L6:
            if ((r11 & 2) == 0) goto L8;
            r10 = "";
        L8:
            this(r5, r10);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003J\u0011\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u001d\u0010U\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0003J\u001d\u0010V\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u001d\u0010]\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\u008b\u0002\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001J\u0013\u0010`\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020dHÖ\u0001J\t\u0010e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00106\"\u0004\b:\u00108R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00106\"\u0004\bJ\u00108R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"¨\u0006f"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "", "appletId", "", "botId", "name", Constant.DESCRIPTION, "digest", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "keywords", "", "permissions", "plugins", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Plugin;", "Lkotlin/collections/ArrayList;", "pages", "Lcom/bytedance/ai/model/objects/Page;", "prop", "recommend", "appGroup", "botDevMode", "appletEntry", "mainInit", "Lcom/bytedance/ai/model/objects/MainInitData;", "services", "Lcom/bytedance/ai/model/objects/ServiceInfo;", "appRuntimeEntry", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/MainInitData;Ljava/util/ArrayList;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "getBotId", "setBotId", "getName", "setName", "getDescription", "setDescription", "getDigest", "setDigest", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "setIcons", "(Lcom/bytedance/ai/model/objects/Icons;)V", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getPermissions", "setPermissions", "getPlugins", "()Ljava/util/ArrayList;", "setPlugins", "(Ljava/util/ArrayList;)V", "getPages", "setPages", "getProp", "setProp", "getRecommend", "setRecommend", "getAppGroup", "setAppGroup", "getBotDevMode", "setBotDevMode", "getAppletEntry", "setAppletEntry", "getMainInit", "()Lcom/bytedance/ai/model/objects/MainInitData;", "setMainInit", "(Lcom/bytedance/ai/model/objects/MainInitData;)V", "getServices", "setServices", "getAppRuntimeEntry", "setAppRuntimeEntry", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AppletBean {
        private String appGroup;
        private String appRuntimeEntry;
        private String appletEntry;
        private String appletId;
        private String botDevMode;
        private String botId;
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

        public AppletBean() {
            String r5 = null;
            String r10 = null;
            String r11 = null;
            String r12 = null;
            String r13 = null;
            Icons r14 = null;
            List r15 = null;
            List r16 = null;
            ArrayList r17 = null;
            ArrayList r18 = null;
            String r19 = null;
            String r110 = null;
            String r111 = null;
            String r112 = null;
            String r113 = null;
            MainInitData r114 = null;
            ArrayList r115 = null;
            String r116 = null;
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, 262143, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppletBean copy$default(AppletBean r17, String r18, String r19, String r20, String r21, String r22, Icons r23, List r24, List r25, ArrayList r26, ArrayList r27, String r28, String r29, String r30, String r31, String r32, MainInitData r33, ArrayList r34, String r35, int r36, Object r37) {
            if ((r36 & 1) == 0) goto L5;
            String r5 = r17.appletId;
        L7:
            if ((r36 & 2) == 0) goto L9;
            String r10 = r17.botId;
        L11:
            if ((r36 & 4) == 0) goto L13;
            String r11 = r17.name;
        L15:
            if ((r36 & 8) == 0) goto L17;
            String r12 = r17.description;
        L19:
            if ((r36 & 16) == 0) goto L21;
            String r13 = r17.digest;
        L23:
            if ((r36 & 32) == 0) goto L25;
            Icons r14 = r17.icons;
        L27:
            if ((r36 & 64) == 0) goto L29;
            List r15 = r17.keywords;
        L31:
            if ((r36 & 128) == 0) goto L33;
            List r16 = r17.permissions;
        L35:
            if ((r36 & 256) == 0) goto L37;
            ArrayList r110 = r17.plugins;
        L39:
            if ((r36 & 512) == 0) goto L41;
            ArrayList r111 = r17.pages;
        L43:
            if ((r36 & 1024) == 0) goto L45;
            String r112 = r17.prop;
        L47:
            if ((r36 & 2048) == 0) goto L49;
            String r113 = r17.recommend;
        L51:
            if ((r36 & 4096) == 0) goto L53;
            String r114 = r17.appGroup;
        L55:
            if ((r36 & 8192) == 0) goto L57;
            String r115 = r17.botDevMode;
        L58:
            String r38 = r115;
            if ((r36 & 16384) == 0) goto L61;
            String r116 = r17.appletEntry;
        L62:
            String r39 = r116;
            if ((r36 & 32768) == 0) goto L65;
            MainInitData r117 = r17.mainInit;
        L66:
            MainInitData r310 = r117;
            if ((r36 & 65536) == 0) goto L69;
            ArrayList r118 = r17.services;
        L71:
            if ((r36 & 131072) == 0) goto L73;
            String r40 = r17.appRuntimeEntry;
        L75:
            return r17.copy(r5, r10, r11, r12, r13, r14, r15, r16, r110, r111, r112, r113, r114, r38, r39, r310, r118, r40);
        L73:
            r40 = r35;
            goto L75
        L69:
            r118 = r34;
            goto L71
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
            r16 = r25;
            goto L35
        L29:
            r15 = r24;
            goto L31
        L25:
            r14 = r23;
            goto L27
        L21:
            r13 = r22;
            goto L23
        L17:
            r12 = r21;
            goto L19
        L13:
            r11 = r20;
            goto L15
        L9:
            r10 = r19;
            goto L11
        L5:
            r5 = r18;
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

        public final String component2() {
            return this.botId;
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

        public final AppletBean copy(String r21, String r22, String r23, String r24, String r25, Icons r26, List<String> r27, List<String> r28, ArrayList<Plugin> r29, ArrayList<Page> r30, String r31, String r32, String r33, String r34, String r35, MainInitData r36, ArrayList<ServiceInfo> r37, String r38) {
            Intrinsics.checkNotNullParameter(r21, "appletId");
            Intrinsics.checkNotNullParameter(r22, "botId");
            Intrinsics.checkNotNullParameter(r23, "name");
            Intrinsics.checkNotNullParameter(r24, Constant.DESCRIPTION);
            Intrinsics.checkNotNullParameter(r25, "digest");
            Intrinsics.checkNotNullParameter(r26, "icons");
            Intrinsics.checkNotNullParameter(r31, "prop");
            Intrinsics.checkNotNullParameter(r32, "recommend");
            Intrinsics.checkNotNullParameter(r33, "appGroup");
            Intrinsics.checkNotNullParameter(r34, "botDevMode");
            Intrinsics.checkNotNullParameter(r35, "appletEntry");
            Intrinsics.checkNotNullParameter(r38, "appRuntimeEntry");
            return new AppletBean(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AppletBean) == true) goto L8;
            return false;
        L8:
            AppletBean r10 = (AppletBean) r5;
            if (Intrinsics.areEqual(this.appletId, r10.appletId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.botId, r10.botId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.name, r10.name) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.description, r10.description) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.digest, r10.digest) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.icons, r10.icons) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.keywords, r10.keywords) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.permissions, r10.permissions) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.plugins, r10.plugins) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.pages, r10.pages) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.prop, r10.prop) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.recommend, r10.recommend) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.appGroup, r10.appGroup) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.botDevMode, r10.botDevMode) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.appletEntry, r10.appletEntry) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.mainInit, r10.mainInit) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.services, r10.services) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.appRuntimeEntry, r10.appRuntimeEntry) == true) goto L62;
            return false;
        L62:
            return true;
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

        public int hashCode() {
            int r5 = (this.icons.hashCode() + a.b(this.digest, a.b(this.description, a.b(this.name, a.b(this.botId, this.appletId.hashCode() * 31, 31), 31), 31), 31)) * 31;
            List<String> r10 = this.keywords;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r5 + r12) * 31;
            List<String> r14 = this.permissions;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            ArrayList<Plugin> r17 = this.plugins;
            if (r17 != null) goto L13;
            int r18 = 0;
        L14:
            int r19 = (r16 + r18) * 31;
            ArrayList<Page> r20 = this.pages;
            if (r20 != null) goto L17;
            int r21 = 0;
        L18:
            int r22 = a.b(this.appletEntry, a.b(this.botDevMode, a.b(this.appGroup, a.b(this.recommend, a.b(this.prop, (r19 + r21) * 31, 31), 31), 31), 31), 31);
            MainInitData r23 = this.mainInit;
            if (r23 != null) goto L21;
            int r24 = 0;
        L22:
            int r25 = (r22 + r24) * 31;
            ArrayList<ServiceInfo> r26 = this.services;
            if (r26 == null) goto L27;
            r11 = r26.hashCode();
        L27:
            return this.appRuntimeEntry.hashCode() + ((r25 + r11) * 31);
        L21:
            r24 = r23.hashCode();
            goto L22
        L17:
            r21 = r20.hashCode();
            goto L18
        L13:
            r18 = r17.hashCode();
            goto L14
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public final void setAppGroup(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.appGroup = r5;
        }

        public final void setAppRuntimeEntry(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.appRuntimeEntry = r5;
        }

        public final void setAppletEntry(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.appletEntry = r5;
        }

        public final void setAppletId(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.appletId = r5;
        }

        public final void setBotDevMode(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.botDevMode = r5;
        }

        public final void setBotId(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.botId = r5;
        }

        public final void setDescription(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.description = r5;
        }

        public final void setDigest(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.digest = r5;
        }

        public final void setIcons(Icons r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.icons = r5;
        }

        public final void setKeywords(List<String> r5) {
            this.keywords = r5;
        }

        public final void setMainInit(MainInitData r5) {
            this.mainInit = r5;
        }

        public final void setName(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.name = r5;
        }

        public final void setPages(ArrayList<Page> r5) {
            this.pages = r5;
        }

        public final void setPermissions(List<String> r5) {
            this.permissions = r5;
        }

        public final void setPlugins(ArrayList<Plugin> r5) {
            this.plugins = r5;
        }

        public final void setProp(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.prop = r5;
        }

        public final void setRecommend(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.recommend = r5;
        }

        public final void setServices(ArrayList<ServiceInfo> r5) {
            this.services = r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("AppletBean(appletId=");
            r5.append(this.appletId);
            r5.append(", botId=");
            r5.append(this.botId);
            r5.append(", name=");
            r5.append(this.name);
            r5.append(", description=");
            r5.append(this.description);
            r5.append(", digest=");
            r5.append(this.digest);
            r5.append(", icons=");
            r5.append(this.icons);
            r5.append(", keywords=");
            r5.append(this.keywords);
            r5.append(", permissions=");
            r5.append(this.permissions);
            r5.append(", plugins=");
            r5.append(this.plugins);
            r5.append(", pages=");
            r5.append(this.pages);
            r5.append(", prop=");
            r5.append(this.prop);
            r5.append(", recommend=");
            r5.append(this.recommend);
            r5.append(", appGroup=");
            r5.append(this.appGroup);
            r5.append(", botDevMode=");
            r5.append(this.botDevMode);
            r5.append(", appletEntry=");
            r5.append(this.appletEntry);
            r5.append(", mainInit=");
            r5.append(this.mainInit);
            r5.append(", services=");
            r5.append(this.services);
            r5.append(", appRuntimeEntry=");
            return j0.p(r5, this.appRuntimeEntry, ')');
        }

        public AppletBean(String r15, String r16, String r17, String r18, String r19, Icons r20, List<String> r21, List<String> r22, ArrayList<Plugin> r23, ArrayList<Page> r24, String r25, String r26, String r27, String r28, String r29, MainInitData r30, ArrayList<ServiceInfo> r31, String r32) {
            Intrinsics.checkNotNullParameter(r15, "appletId");
            Intrinsics.checkNotNullParameter(r16, "botId");
            Intrinsics.checkNotNullParameter(r17, "name");
            Intrinsics.checkNotNullParameter(r18, Constant.DESCRIPTION);
            Intrinsics.checkNotNullParameter(r19, "digest");
            Intrinsics.checkNotNullParameter(r20, "icons");
            Intrinsics.checkNotNullParameter(r25, "prop");
            Intrinsics.checkNotNullParameter(r26, "recommend");
            Intrinsics.checkNotNullParameter(r27, "appGroup");
            Intrinsics.checkNotNullParameter(r28, "botDevMode");
            Intrinsics.checkNotNullParameter(r29, "appletEntry");
            Intrinsics.checkNotNullParameter(r32, "appRuntimeEntry");
            this.appletId = r15;
            this.botId = r16;
            this.name = r17;
            this.description = r18;
            this.digest = r19;
            this.icons = r20;
            this.keywords = r21;
            this.permissions = r22;
            this.plugins = r23;
            this.pages = r24;
            this.prop = r25;
            this.recommend = r26;
            this.appGroup = r27;
            this.botDevMode = r28;
            this.appletEntry = r29;
            this.mainInit = r30;
            this.services = r31;
            this.appRuntimeEntry = r32;
        }

        public /* synthetic */ AppletBean(String r20, String r21, String r22, String r23, String r24, Icons r25, List r26, List r27, ArrayList r28, ArrayList r29, String r30, String r31, String r32, String r33, String r34, MainInitData r35, ArrayList r36, String r37, int r38, DefaultConstructorMarker r39) {
            if ((r38 & 1) == 0) goto L5;
            String r5 = "";
        L7:
            if ((r38 & 2) == 0) goto L9;
            String r10 = "";
        L11:
            if ((r38 & 4) == 0) goto L13;
            String r11 = "";
        L15:
            if ((r38 & 8) == 0) goto L17;
            String r12 = "";
        L19:
            if ((r38 & 16) == 0) goto L21;
            String r13 = "";
        L23:
            if ((r38 & 32) == 0) goto L25;
            Icons r14 = new Icons();
        L27:
            if ((r38 & 64) == 0) goto L29;
            List r15 = new ArrayList();
        L31:
            if ((r38 & 128) == 0) goto L33;
            List r16 = new ArrayList();
        L35:
            if ((r38 & 256) == 0) goto L37;
            ArrayList r17 = new ArrayList();
        L39:
            if ((r38 & 512) == 0) goto L41;
            ArrayList r18 = new ArrayList();
        L43:
            if ((r38 & 1024) == 0) goto L45;
            String r19 = "";
        L47:
            if ((r38 & 2048) == 0) goto L49;
            String r110 = "";
        L51:
            if ((r38 & 4096) == 0) goto L53;
            String r111 = "";
        L55:
            if ((r38 & 8192) == 0) goto L57;
            String r112 = "";
        L59:
            if ((r38 & 16384) == 0) goto L61;
            String r40 = "";
        L63:
            if ((r38 & 32768) == 0) goto L65;
            MainInitData r113 = null;
        L67:
            if ((r38 & 65536) == 0) goto L69;
            ArrayList r114 = new ArrayList();
        L71:
            if ((r38 & 131072) == 0) goto L73;
            String r41 = "";
        L74:
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r40, r113, r114, r41);
            return;
        L73:
            r41 = r37;
            goto L74
        L69:
            r114 = r36;
            goto L71
        L65:
            r113 = r35;
            goto L67
        L61:
            r40 = r34;
            goto L63
        L57:
            r112 = r33;
            goto L59
        L53:
            r111 = r32;
            goto L55
        L49:
            r110 = r31;
            goto L51
        L45:
            r19 = r30;
            goto L47
        L41:
            r18 = r29;
            goto L43
        L37:
            r17 = r28;
            goto L39
        L33:
            r16 = r27;
            goto L35
        L29:
            r15 = r26;
            goto L31
        L25:
            r14 = r25;
            goto L27
        L21:
            r13 = r24;
            goto L23
        L17:
            r12 = r23;
            goto L19
        L13:
            r11 = r22;
            goto L15
        L9:
            r10 = r21;
            goto L11
        L5:
            r5 = r20;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$Companion;", "", "", "json", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "parseManifestJson", "(Ljava/lang/String;)Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        @Keep
        public final AIPackageManifestBean parseManifestJson(String r5) {
            Intrinsics.checkNotNullParameter(r5, "json");
        L7:
            e = move-exception;
            String r10 = i.a.h(e, new StringBuilder("Failed to parse Manifest: "), "AIPackageManager");
            d r11 = c.f2846a;
            if (r11 == null) goto L16;
            r11.e("AIPackageManager", r10);
        L16:
            String r12 = com.lynx.tasm.behavior.utils.d.c("Failed to parse Manifest. content: ", r5, "AIPackageManager");
            d r13 = c.f2846a;
            if (r13 == null) goto L19;
            r13.e("AIPackageManager", r12);
        L19:
            return null;
        L4:
            if (r5.length() > 0) goto L6;
            Intrinsics.checkNotNullParameter("AIPackageManager", "tag");     // Catch: Exception -> L7
            d r14 = c.f2846a;     // Catch: Exception -> L7
            if (r14 == null) goto L12;
            r14.e("AIPackageManager", "Failed to parse Manifest: Read the Manifest as empty");     // Catch: Exception -> L7
        L12:
            return null;
        L6:
            return (AIPackageManifestBean) z0.a.a().fromJson(r5, AIPackageManifestBean.class);
        }
    }

    @Keep
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bL\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0011HÆ\u0003J\t\u0010Y\u001a\u00020\u0013HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00190\fHÆ\u0003J\t\u0010_\u001a\u00020\u0013HÆ\u0003Jß\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0013HÆ\u0001J\u0013\u0010a\u001a\u00020\u00112\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u0013HÖ\u0001J\t\u0010d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@¨\u0006e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$WidgetsBean;", "", "widgetId", "", "entry", "template", "name", Constant.DESCRIPTION, "digest", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "keywords", "", "permissions", "input", "output", "border", "", "boxType", "", "renderType", "prop", "recommend", "appGroup", "appSettings", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppSettingsBean;", "titleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getWidgetId", "()Ljava/lang/String;", "setWidgetId", "(Ljava/lang/String;)V", "getEntry", "setEntry", "getTemplate", "setTemplate", "getName", "setName", "getDescription", "setDescription", "getDigest", "setDigest", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "setIcons", "(Lcom/bytedance/ai/model/objects/Icons;)V", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getPermissions", "setPermissions", "getInput", "setInput", "getOutput", "setOutput", "getBorder", "()Z", "setBorder", "(Z)V", "getBoxType", "()I", "setBoxType", "(I)V", "getRenderType", "setRenderType", "getProp", "setProp", "getRecommend", "setRecommend", "getAppGroup", "setAppGroup", "getAppSettings", "setAppSettings", "getTitleType", "setTitleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
            String r5 = null;
            String r10 = null;
            String r11 = null;
            String r12 = null;
            String r13 = null;
            String r14 = null;
            Icons r15 = null;
            List r16 = null;
            List r17 = null;
            String r18 = null;
            String r19 = null;
            boolean r110 = false;
            int r111 = 0;
            String r112 = null;
            String r113 = null;
            String r114 = null;
            String r115 = null;
            List r116 = null;
            int r117 = 0;
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, 524287, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetsBean copy$default(WidgetsBean r17, String r18, String r19, String r20, String r21, String r22, String r23, Icons r24, List r25, List r26, String r27, String r28, boolean r29, int r30, String r31, String r32, String r33, String r34, List r35, int r36, int r37, Object r38) {
            if ((r37 & 1) == 0) goto L5;
            String r5 = r17.widgetId;
        L7:
            if ((r37 & 2) == 0) goto L9;
            String r10 = r17.entry;
        L11:
            if ((r37 & 4) == 0) goto L13;
            String r11 = r17.template;
        L15:
            if ((r37 & 8) == 0) goto L17;
            String r12 = r17.name;
        L19:
            if ((r37 & 16) == 0) goto L21;
            String r13 = r17.description;
        L23:
            if ((r37 & 32) == 0) goto L25;
            String r14 = r17.digest;
        L27:
            if ((r37 & 64) == 0) goto L29;
            Icons r15 = r17.icons;
        L31:
            if ((r37 & 128) == 0) goto L33;
            List r16 = r17.keywords;
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
            String r39 = r115;
            if ((r37 & 16384) == 0) goto L61;
            String r116 = r17.prop;
        L62:
            String r310 = r116;
            if ((r37 & 32768) == 0) goto L65;
            String r117 = r17.recommend;
        L66:
            String r311 = r117;
            if ((r37 & 65536) == 0) goto L69;
            String r118 = r17.appGroup;
        L70:
            String r312 = r118;
            if ((r37 & 131072) == 0) goto L73;
            List r119 = r17.appSettings;
        L75:
            if ((r37 & 262144) == 0) goto L77;
            int r40 = r17.titleType;
        L79:
            return r17.copy(r5, r10, r11, r12, r13, r14, r15, r16, r110, r111, r112, r113, r114, r39, r310, r311, r312, r119, r40);
        L77:
            r40 = r36;
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
            r16 = r25;
            goto L35
        L29:
            r15 = r24;
            goto L31
        L25:
            r14 = r23;
            goto L27
        L21:
            r13 = r22;
            goto L23
        L17:
            r12 = r21;
            goto L19
        L13:
            r11 = r20;
            goto L15
        L9:
            r10 = r19;
            goto L11
        L5:
            r5 = r18;
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

        public final WidgetsBean copy(String r22, String r23, String r24, String r25, String r26, String r27, Icons r28, List<String> r29, List<String> r30, String r31, String r32, boolean r33, int r34, String r35, String r36, String r37, String r38, List<AppSettingsBean> r39, int r40) {
            Intrinsics.checkNotNullParameter(r22, "widgetId");
            Intrinsics.checkNotNullParameter(r23, "entry");
            Intrinsics.checkNotNullParameter(r24, "template");
            Intrinsics.checkNotNullParameter(r25, "name");
            Intrinsics.checkNotNullParameter(r26, Constant.DESCRIPTION);
            Intrinsics.checkNotNullParameter(r27, "digest");
            Intrinsics.checkNotNullParameter(r31, "input");
            Intrinsics.checkNotNullParameter(r32, "output");
            Intrinsics.checkNotNullParameter(r35, "renderType");
            Intrinsics.checkNotNullParameter(r36, "prop");
            Intrinsics.checkNotNullParameter(r37, "recommend");
            Intrinsics.checkNotNullParameter(r38, "appGroup");
            Intrinsics.checkNotNullParameter(r39, "appSettings");
            return new WidgetsBean(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof WidgetsBean) == true) goto L8;
            return false;
        L8:
            WidgetsBean r10 = (WidgetsBean) r5;
            if (Intrinsics.areEqual(this.widgetId, r10.widgetId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entry, r10.entry) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.template, r10.template) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.name, r10.name) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.description, r10.description) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.digest, r10.digest) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.icons, r10.icons) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.keywords, r10.keywords) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.permissions, r10.permissions) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.input, r10.input) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.output, r10.output) == true) goto L42;
            return false;
        L42:
            if (this.border == r10.border) goto L45;
            return false;
        L45:
            if (this.boxType == r10.boxType) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.renderType, r10.renderType) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.prop, r10.prop) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.recommend, r10.recommend) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.appGroup, r10.appGroup) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.appSettings, r10.appSettings) == true) goto L63;
            return false;
        L63:
            if (this.titleType == r10.titleType) goto L65;
            return false;
        L65:
            return true;
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

        public int hashCode() {
            int r5 = a.b(this.digest, a.b(this.description, a.b(this.name, a.b(this.template, a.b(this.entry, this.widgetId.hashCode() * 31, 31), 31), 31), 31), 31);
            Icons r10 = this.icons;
            int r11 = 0;
            if (r10 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = (r5 + r12) * 31;
            List<String> r14 = this.keywords;
            if (r14 != null) goto L9;
            int r15 = 0;
        L10:
            int r16 = (r13 + r15) * 31;
            List<String> r17 = this.permissions;
            if (r17 == null) goto L15;
            r11 = r17.hashCode();
        L15:
            return Integer.hashCode(this.titleType) + androidx.constraintlayout.motion.widget.a.f(this.appSettings, a.b(this.appGroup, a.b(this.recommend, a.b(this.prop, a.b(this.renderType, k5.d.a(this.boxType, e.a(a.b(this.output, a.b(this.input, (r16 + r11) * 31, 31), 31), 31, this.border)), 31), 31), 31), 31), 31);
        L9:
            r15 = r14.hashCode();
            goto L10
        L5:
            r12 = r10.hashCode();
            goto L6
        }

        public final void setAppGroup(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.appGroup = r5;
        }

        public final void setAppSettings(List<AppSettingsBean> r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.appSettings = r5;
        }

        public final void setBorder(boolean r5) {
            this.border = r5;
        }

        public final void setBoxType(int r5) {
            this.boxType = r5;
        }

        public final void setDescription(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.description = r5;
        }

        public final void setDigest(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.digest = r5;
        }

        public final void setEntry(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.entry = r5;
        }

        public final void setIcons(Icons r5) {
            this.icons = r5;
        }

        public final void setInput(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.input = r5;
        }

        public final void setKeywords(List<String> r5) {
            this.keywords = r5;
        }

        public final void setName(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.name = r5;
        }

        public final void setOutput(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.output = r5;
        }

        public final void setPermissions(List<String> r5) {
            this.permissions = r5;
        }

        public final void setProp(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.prop = r5;
        }

        public final void setRecommend(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.recommend = r5;
        }

        public final void setRenderType(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.renderType = r5;
        }

        public final void setTemplate(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.template = r5;
        }

        public final void setTitleType(int r5) {
            this.titleType = r5;
        }

        public final void setWidgetId(String r5) {
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            this.widgetId = r5;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("WidgetsBean(widgetId=");
            r5.append(this.widgetId);
            r5.append(", entry=");
            r5.append(this.entry);
            r5.append(", template=");
            r5.append(this.template);
            r5.append(", name=");
            r5.append(this.name);
            r5.append(", description=");
            r5.append(this.description);
            r5.append(", digest=");
            r5.append(this.digest);
            r5.append(", icons=");
            r5.append(this.icons);
            r5.append(", keywords=");
            r5.append(this.keywords);
            r5.append(", permissions=");
            r5.append(this.permissions);
            r5.append(", input=");
            r5.append(this.input);
            r5.append(", output=");
            r5.append(this.output);
            r5.append(", border=");
            r5.append(this.border);
            r5.append(", boxType=");
            r5.append(this.boxType);
            r5.append(", renderType=");
            r5.append(this.renderType);
            r5.append(", prop=");
            r5.append(this.prop);
            r5.append(", recommend=");
            r5.append(this.recommend);
            r5.append(", appGroup=");
            r5.append(this.appGroup);
            r5.append(", appSettings=");
            r5.append(this.appSettings);
            r5.append(", titleType=");
            return j0.n(r5, this.titleType, ')');
        }

        public WidgetsBean(String r16, String r17, String r18, String r19, String r20, String r21, Icons r22, List<String> r23, List<String> r24, String r25, String r26, boolean r27, int r28, String r29, String r30, String r31, String r32, List<AppSettingsBean> r33, int r34) {
            Intrinsics.checkNotNullParameter(r16, "widgetId");
            Intrinsics.checkNotNullParameter(r17, "entry");
            Intrinsics.checkNotNullParameter(r18, "template");
            Intrinsics.checkNotNullParameter(r19, "name");
            Intrinsics.checkNotNullParameter(r20, Constant.DESCRIPTION);
            Intrinsics.checkNotNullParameter(r21, "digest");
            Intrinsics.checkNotNullParameter(r25, "input");
            Intrinsics.checkNotNullParameter(r26, "output");
            Intrinsics.checkNotNullParameter(r29, "renderType");
            Intrinsics.checkNotNullParameter(r30, "prop");
            Intrinsics.checkNotNullParameter(r31, "recommend");
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
            String r5 = "";
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
            int r42 = -1;
        L78:
            this(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r111, r110, r112, r20, r113, r114, r115, r42);
            return;
        L77:
            r42 = r39;
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
            r5 = r21;
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
        String r5 = null;
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        Icons r14 = null;
        List r15 = null;
        List r16 = null;
        ArrayList r17 = null;
        ArrayList r18 = null;
        String r19 = null;
        String r110 = null;
        String r111 = null;
        String r112 = null;
        MainInitData r113 = null;
        ArrayList r114 = null;
        String r20 = null;
        this.applet = new AppletBean(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r111, r112, r113, r114, r20, 262143, null);
        this.widgets = new ArrayList();
        this.scmVersion = "";
        this.pages = new ArrayList();
        this.runtimeVersion = "";
        this.permissions = new LinkedHashMap();
    }

    public final AppletBean getApplet() {
        return this.applet;
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

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final List<WidgetsBean> getWidgets() {
        return this.widgets;
    }

    public final void setApplet(AppletBean r5) {
        this.applet = r5;
    }

    public final void setManifestVersion(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.manifestVersion = r5;
    }

    public final void setPackageName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.packageName = r5;
    }

    public final void setPages(ArrayList<Page> r5) {
        this.pages = r5;
    }

    public final void setPermissions(Map<String, PermissionDetail> r5) {
        this.permissions = r5;
    }

    public final void setRenderType(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.renderType = r5;
    }

    public final void setRuntimeVersion(String r5) {
        this.runtimeVersion = r5;
    }

    public final void setScmVersion(String r5) {
        this.scmVersion = r5;
    }

    public final void setVersionCode(long r5) {
        this.versionCode = r5;
    }

    public final void setVersionName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.versionName = r5;
    }

    public final void setWidgets(List<WidgetsBean> r5) {
        this.widgets = r5;
    }
}
