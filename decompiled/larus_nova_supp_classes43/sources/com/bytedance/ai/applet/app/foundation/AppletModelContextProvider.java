package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletModelContextProvider implements w, AppletChatInputController.b {
    public final AppletApplication a;
    public final ConcurrentHashMap<Long, PageContext> b;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ai/applet/app/foundation/AppletModelContextProvider$PageContext;", "", "bizTaskId", "", "appKey", "pagePath", "pageInfo", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getBizTaskId", "()Ljava/lang/String;", "getAppKey", "getPagePath", "getPageInfo", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PageContext {

        @SerializedName("app_key")
        private final String appKey;

        @SerializedName("biz_task_id")
        private final String bizTaskId;

        @SerializedName("page_info")
        private final Map<String, Object> pageInfo;

        @SerializedName("page_path")
        private final String pagePath;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageContext copy$default(PageContext r0, String r1, String r10, String r11, Map r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r1 = r0.bizTaskId;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r10 = r0.appKey;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r11 = r0.pagePath;
        L12:
            if ((r13 & 8) == 0) goto L15;
            r12 = r0.pageInfo;
        L15:
            return r0.copy(r1, r10, r11, r12);
        }

        public final String component1() {
            return this.bizTaskId;
        }

        public final String component2() {
            return this.appKey;
        }

        public final String component3() {
            return this.pagePath;
        }

        public final Map<String, Object> component4() {
            return this.pageInfo;
        }

        public final PageContext copy(String r10, String r11, String r12, Map<String, ? extends Object> r13) {
            Intrinsics.checkNotNullParameter(r10, "bizTaskId");
            Intrinsics.checkNotNullParameter(r11, "appKey");
            Intrinsics.checkNotNullParameter(r13, "pageInfo");
            return new PageContext(r10, r11, r12, r13);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof PageContext) == true) goto L8;
            return false;
        L8:
            PageContext r11 = (PageContext) r10;
            if (Intrinsics.areEqual(this.bizTaskId, r11.bizTaskId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.appKey, r11.appKey) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pagePath, r11.pagePath) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.pageInfo, r11.pageInfo) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.bizTaskId.hashCode() * 31) + this.appKey.hashCode()) * 31;
            String r1 = this.pagePath;
            if (r1 != null) goto L5;
            int r10 = 0;
        L7:
            return ((r0 + r10) * 31) + this.pageInfo.hashCode();
        L5:
            r10 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "PageContext(bizTaskId=" + this.bizTaskId + ", appKey=" + this.appKey + ", pagePath=" + this.pagePath + ", pageInfo=" + this.pageInfo + ')';
        }

        public final String getAppKey() {
            return this.appKey;
        }

        public final String getBizTaskId() {
            return this.bizTaskId;
        }

        public final Map<String, Object> getPageInfo() {
            return this.pageInfo;
        }

        public final String getPagePath() {
            return this.pagePath;
        }

        public PageContext(String r10, String r11, String r12, Map<String, ? extends Object> r13) {
            Intrinsics.checkNotNullParameter(r10, "bizTaskId");
            Intrinsics.checkNotNullParameter(r11, "appKey");
            Intrinsics.checkNotNullParameter(r13, "pageInfo");
            this.bizTaskId = r10;
            this.appKey = r11;
            this.pagePath = r12;
            this.pageInfo = r13;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final Integer getSource() {
        return 3;
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final String b() {
        AppletAppActivity r0 = this.a.d;
        if (r0 == null) goto L7;
        Long r1 = r0.C1();
        if (r1 == null) goto L7;
        PageContext r10 = this.b.get(r1);
    L8:
        if (r10 != null) goto L10;
        return null;
    L10:
        return r10.getBizTaskId();
    L7:
        r10 = null;
        goto L8
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final AppletChatInputController.e c() {
        AppletAppActivity r0 = this.a.d;
        String r1 = null;
        if (r0 == null) goto L7;
        Long r10 = r0.C1();
        if (r10 == null) goto L7;
        PageContext r11 = this.b.get(r10);
    L8:
        if (r11 != null) goto L10;
        return null;
    L10:
        String r12 = r11.getPagePath();
        if (r12 != null) goto L21;
        AppletAppActivity r13 = this.a.d;
        if (r13 == null) goto L22;
        r12 = r13.h;
        if (r12 == null) goto L22;
        if (r12.length() <= 0) goto L19;
        boolean r14 = true;
    L20:
        if (r14 == false) goto L22;
    L19:
        r14 = false;
    L22:
        Lazy r15 = com.bytedance.ai.applet.base.gson.e.a;
        return new AppletChatInputController.e("miniapp_page", this.a.j().b, new AppletChatInputController.f(com.bytedance.ai.applet.base.gson.e.c(PageContext.copy$default(r11, null, null, r1, null, 11, null))));
    L21:
        r1 = r12;
    L7:
        r11 = null;
        goto L8
    }

    @Override // com.bytedance.ai.applet.components.input.AppletChatInputController.b
    public final Map<String, String> getExtra() {
        return MapsKt.mapOf(TuplesKt.to("miniapp_appkey", this.a.getAppId()));
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        com.bytedance.ai.utils.g.a.i("AppletModelContextProvider", "onDestroy, clear " + this.b.size() + " page contexts");
        this.b.clear();
    }

    public AppletModelContextProvider(AppletApplication r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        this.a = r10;
        this.b = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }
}
