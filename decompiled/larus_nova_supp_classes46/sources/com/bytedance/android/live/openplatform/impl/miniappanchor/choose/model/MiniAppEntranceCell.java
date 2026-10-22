package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappInteractEntranceCell")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/MiniAppEntranceCell;", "", "", "title", "Ljava/lang/String;", "desc", "Lcom/bytedance/android/live/base/model/ImageModel;", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "", "groupId", "J", "appId", "schema", "", "serverScenes", "Ljava/util/List;", "extendExtra", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppEntranceCell implements h {
    public final Lazy a;

    @SerializedName("appid")
    public String appId;

    @SerializedName("desc")
    public String desc;

    @SerializedName("extend_extra")
    public String extendExtra;

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("icon")
    public ImageModel icon;

    @SerializedName("schema")
    public String schema;

    @SerializedName("call_server_scenes")
    public List<String> serverScenes;

    @SerializedName("title")
    public String title;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof MiniAppEntranceCell) == false) goto L22;
        MiniAppEntranceCell r7 = (MiniAppEntranceCell) r6;
        if (Intrinsics.areEqual(this.title, r7.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.desc, r7.desc) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r7.icon) == true) goto L12;
        return false;
    L12:
        if (this.groupId == r7.groupId) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.appId, r7.appId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.schema, r7.schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serverScenes, r7.serverScenes) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.extendExtra, r7.extendExtra) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.desc;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ImageModel r7 = this.icon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        long r10 = this.groupId;
        int r11 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        String r12 = this.appId;
        if (r12 == null) goto L17;
        int r13 = r12.hashCode();
    L18:
        int r14 = (r11 + r13) * 31;
        String r15 = this.schema;
        if (r15 == null) goto L21;
        int r16 = r15.hashCode();
    L22:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.serverScenes;
        if (r18 == null) goto L25;
        int r19 = r18.hashCode();
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.extendExtra;
        if (r21 == null) goto L30;
        r1 = r21.hashCode();
    L30:
        return r20 + r1;
    L25:
        r19 = 0;
        goto L26
    L21:
        r16 = 0;
        goto L22
    L17:
        r13 = 0;
        goto L18
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
        return "MiniAppEntranceCell(title=" + this.title + ", desc=" + this.desc + ", icon=" + this.icon + ", groupId=" + this.groupId + ", appId=" + this.appId + ", schema=" + this.schema + ", serverScenes=" + this.serverScenes + ", extendExtra=" + this.extendExtra + ")";
    }

    public final String a() {
        return ((JSONObject) this.a.getValue()).optString("recommend_reason", "");
    }

    public MiniAppEntranceCell() {
        this.a = LazyKt.lazy(new MiniAppEntranceCell$extendExtraJson$2(this));
        this.title = null;
        this.desc = null;
        this.icon = null;
        this.groupId = 0;
        this.appId = null;
        this.schema = null;
        this.serverScenes = new ArrayList();
        this.extendExtra = null;
    }

    public MiniAppEntranceCell(g r6) {
        this.serverScenes = new ArrayList();
        this.a = LazyKt.lazy(new MiniAppEntranceCell$extendExtraJson$2(this));
        long r0 = r6.c();
        boolean r2 = false;
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L17;
        if (r3 != 101) goto L7;
        this.extendExtra = am3.h.c(r6);
        goto L3
    L7:
        switch(r3) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.serverScenes.add(am3.h.c(r6));
        goto L3
    L10:
        this.schema = am3.h.c(r6);
        goto L3
    L11:
        this.appId = am3.h.c(r6);
        goto L3
    L12:
        this.groupId = r6.i();
        r2 = r2 | true;
        goto L3
    L13:
        this.icon = x.a(r6);
        goto L3
    L14:
        this.desc = am3.h.c(r6);
        goto L3
    L15:
        this.title = am3.h.c(r6);
        goto L3
    L8:
        am3.h.e(r6);
        goto L3
    L17:
        r6.d(r0);
        if (this.title != null) goto L21;
        this.title = null;
    L21:
        if (this.desc != null) goto L24;
        this.desc = null;
    L24:
        if (this.icon != null) goto L27;
        this.icon = null;
    L27:
        if ((r2 & true) == true) goto L30;
        this.groupId = 0;
    L30:
        if (this.appId != null) goto L33;
        this.appId = null;
    L33:
        if (this.schema != null) goto L36;
        this.schema = null;
    L36:
        if (this.serverScenes.isEmpty() == false) goto L39;
        this.serverScenes = new ArrayList();
    L39:
        if (this.extendExtra != null) goto L63;
        this.extendExtra = null;
        return;
    }

    public MiniAppEntranceCell(String r1, String r2, ImageModel r3, long r4, String r6, String r7, List<String> r8, String r9) {
        this.title = r1;
        this.desc = r2;
        this.icon = r3;
        this.groupId = r4;
        this.appId = r6;
        this.schema = r7;
        this.serverScenes = r8;
        this.extendExtra = r9;
        this.a = LazyKt.lazy(new MiniAppEntranceCell$extendExtraJson$2(this));
    }
}
