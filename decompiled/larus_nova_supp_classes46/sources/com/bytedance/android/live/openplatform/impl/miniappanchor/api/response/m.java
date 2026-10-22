package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.PresetCardList")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/m;", "", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appName", "getAppName", "appIcon", "getAppIcon", "", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/l;", "presetCardList", "Ljava/util/List;", "getPresetCardList", "()Ljava/util/List;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class m implements vh7.h {

    @SerializedName("app_icon")
    protected String appIcon;

    @SerializedName("app_id")
    protected String appId;

    @SerializedName("app_name")
    protected String appName;

    @SerializedName("preset_card_list")
    protected List<l> presetCardList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L14;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.appName, r4.appName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.appIcon, r4.appIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.presetCardList, r4.presetCardList) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.appId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.appName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.appIcon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<l> r10 = this.presetCardList;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PresetCardList(appId=" + this.appId + ", appName=" + this.appName + ", appIcon=" + this.appIcon + ", presetCardList=" + this.presetCardList + ")";
    }

    public m() {
        this.appId = null;
        this.appName = null;
        this.appIcon = null;
        this.presetCardList = null;
    }

    public m(am3.g r5) {
        this.presetCardList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.appId = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.appName = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.appIcon = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.presetCardList.add(new l(r5));
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.appId != null) goto L22;
        this.appId = null;
    L22:
        if (this.appName != null) goto L25;
        this.appName = null;
    L25:
        if (this.appIcon != null) goto L28;
        this.appIcon = null;
    L28:
        if (this.presetCardList.isEmpty() == false) goto L46;
        this.presetCardList = null;
        return;
    }

    public final List<ShelfCardInfo> a(boolean r30) {
        ArrayList r0 = new ArrayList();
        List<l> r2 = this.presetCardList;
        if (r2 == null) goto L24;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L24;
        l r4 = (l) r3.next();
        String r10 = r4.sourcePath;
        String r5 = r4.schema;
        String r6 = r4.title;
        String r8 = null;
        ImageModel r7 = r4.image;
        if (r7 == null) goto L12;
        List r9 = r7.getUrls();
        if (r9 == null) goto L12;
        String r11 = (String) CollectionsKt.firstOrNull(r9);
    L13:
        boolean r12 = false;
        long r13 = 0;
        int r15 = ShelfCardInfo.Source.Phone.getValue();
        JSONObject r14 = new JSONObject();
        if (r30 == false) goto L16;
        String r16 = "in_live";
    L17:
        r14.put("adding_page_live_status", r16);
        Unit r17 = Unit.INSTANCE;
        String r18 = r14.toString();
        String r19 = null;
        ProductInfo r20 = r4.productInfo;
        String r110 = null;
        int r23 = 1;
        ImageModel r21 = r4.image;
        if (r21 == null) goto L22;
        List r22 = r21.getUrls();
        if (r22 == null) goto L22;
        String r27 = (String) CollectionsKt.firstOrNull(r22);
    L23:
        String r24 = r4.title;
        String r25 = null;
        String r26 = r11;
        String r111 = r27;
        r0.add(new ShelfCardInfo(r5, r6, r26, r8, r25, r10, r12, r13, r15, r18, r19, r20, r110, r111, null, r24, null, r23, 0, 528383459, 5));
    L22:
        r27 = null;
        goto L23
    L16:
        r16 = "before_live";
    L12:
        r11 = null;
    L24:
        return r0;
    }

    public final ShelfMicroAppInfo b(boolean r9) {
        String r1 = this.appId;
        String r2 = this.appName;
        String r4 = null;
        ImageModel r3 = new ImageModel(null, CollectionsKt.listOf(this.appIcon));
        SchemaInfo.a r0 = new SchemaInfo.a();
        String r5 = this.appId;
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.a(r5);
        SchemaInfo r6 = r0.c();
        if (r6 == null) goto L9;
        r4 = r6.h();
    L9:
        return new ShelfMicroAppInfo(r1, r2, r3, r4, r9 ? 1 : 0, 32);
    }
}
