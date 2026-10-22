package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\f\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/base/model/user/GroupInfo;", "", "", "groupType", "I", "getGroupType", "()I", "setGroupType", "(I)V", "Lcom/bytedance/android/live/base/model/user/GroupInfo$GroupHeaderInfo;", "groupHeaderInfo", "Lcom/bytedance/android/live/base/model/user/GroupInfo$GroupHeaderInfo;", "getGroupHeaderInfo", "()Lcom/bytedance/android/live/base/model/user/GroupInfo$GroupHeaderInfo;", "setGroupHeaderInfo", "(Lcom/bytedance/android/live/base/model/user/GroupInfo$GroupHeaderInfo;)V", "Lcom/bytedance/android/live/base/model/user/WallBg;", "groupWallBg", "Lcom/bytedance/android/live/base/model/user/WallBg;", "getGroupWallBg", "()Lcom/bytedance/android/live/base/model/user/WallBg;", "setGroupWallBg", "(Lcom/bytedance/android/live/base/model/user/WallBg;)V", "", "titleColor", "Ljava/lang/String;", "getTitleColor", "()Ljava/lang/String;", "setTitleColor", "(Ljava/lang/String;)V", "contentColor", "getContentColor", "setContentColor", "", "buryPoint", "Ljava/util/Map;", "getBuryPoint", "()Ljava/util/Map;", "setBuryPoint", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "GroupHeaderInfo", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupInfo implements vh7.h {
    public static final a Companion = null;
    public static final int GROUP_TYPE_EXPERT = 2;
    public static final int GROUP_TYPE_NO = 0;
    public static final int GROUP_TYPE_SHOP = 1;

    @SerializedName("bury_point")
    protected Map<String, String> buryPoint;

    @SerializedName("content_color")
    protected String contentColor;

    @SerializedName("group_header_info")
    protected GroupHeaderInfo groupHeaderInfo;

    @SerializedName("group_type")
    protected int groupType;

    @SerializedName("group_wall_bg")
    protected WallBg groupWallBg;

    @SerializedName("title_color")
    protected String titleColor;

    @ForMain
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/base/model/user/GroupInfo$GroupHeaderInfo;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "goods", "getGoods", "setGoods", "sale", "getSale", "setSale", LiveSlardarConstants.EXTRA_KEY_URL, "getUrl", "setUrl", "", "Lpy/k;", "icons", "Ljava/util/List;", "getIcons", "()Ljava/util/List;", "setIcons", "(Ljava/util/List;)V", "<init>", "()V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class GroupHeaderInfo implements vh7.h {

        @SerializedName("goods")
        protected String goods;

        @SerializedName("icons")
        protected List<? extends py.k> icons;

        @SerializedName("name")
        protected String name;

        @SerializedName("sale")
        protected String sale;

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        protected String url;

        public GroupHeaderInfo() {
        }

        public GroupHeaderInfo(am3.g r5) {
            this.icons = new ArrayList();
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L21;
            if (r2 != 1) goto L8;
            this.name = am3.h.c(r5);
            goto L3
        L8:
            if (r2 != 2) goto L10;
            this.goods = am3.h.c(r5);
            goto L3
        L10:
            if (r2 != 3) goto L12;
            this.sale = am3.h.c(r5);
            goto L3
        L12:
            if (r2 != 4) goto L14;
            this.url = am3.h.c(r5);
            goto L3
        L14:
            if (r2 != 5) goto L15;
            this.icons.add(vh7.f.a(r5, py.k.class));
            goto L3
        L15:
            am3.h.e(r5);
            goto L3
        L21:
            r5.d(r0);
        }

        public final String getGoods() {
            return this.goods;
        }

        public final List<py.k> getIcons() {
            return this.icons;
        }

        public final String getName() {
            return this.name;
        }

        public final String getSale() {
            return this.sale;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setGoods(String r1) {
            this.goods = r1;
        }

        public final void setIcons(List<? extends py.k> r1) {
            this.icons = r1;
        }

        public final void setName(String r1) {
            this.name = r1;
        }

        public final void setSale(String r1) {
            this.sale = r1;
        }

        public final void setUrl(String r1) {
            this.url = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public GroupInfo() {
    }

    public final Map<String, String> getBuryPoint() {
        return this.buryPoint;
    }

    public final String getContentColor() {
        return this.contentColor;
    }

    public final GroupHeaderInfo getGroupHeaderInfo() {
        return this.groupHeaderInfo;
    }

    public final int getGroupType() {
        return this.groupType;
    }

    public final WallBg getGroupWallBg() {
        return this.groupWallBg;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }

    public GroupInfo(am3.g r11) {
        this.buryPoint = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L30;
        switch(r2) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        long r4 = r11.c();
        String r3 = null;
        String r6 = null;
    L8:
        int r7 = r11.f();
        if (r7 == (-1)) goto L17;
        if (r7 != 1) goto L13;
        r3 = am3.h.c(r11);
        goto L8
    L13:
        if (r7 != 2) goto L14;
        r6 = am3.h.c(r11);
        goto L8
    L14:
        am3.h.e(r11);
        goto L8
    L17:
        r11.d(r4);
        Map<String, String> r5 = this.buryPoint;
        if (r3 == null) goto L24;
        if (r6 == null) goto L22;
        r5.put(r3, r6);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this.contentColor = am3.h.c(r11);
        goto L3
    L26:
        this.titleColor = am3.h.c(r11);
        goto L3
    L27:
        this.groupWallBg = new WallBg(r11);
        goto L3
    L28:
        this.groupHeaderInfo = new GroupHeaderInfo(r11);
        goto L3
    L29:
        this.groupType = r11.i();
        goto L3
    L6:
        am3.h.e(r11);
        goto L3
    L30:
        r11.d(r0);
    }

    public final void setBuryPoint(Map<String, String> r1) {
        this.buryPoint = r1;
    }

    public final void setContentColor(String r1) {
        this.contentColor = r1;
    }

    public final void setGroupHeaderInfo(GroupHeaderInfo r1) {
        this.groupHeaderInfo = r1;
    }

    public final void setGroupType(int r1) {
        this.groupType = r1;
    }

    public final void setGroupWallBg(WallBg r1) {
        this.groupWallBg = r1;
    }

    public final void setTitleColor(String r1) {
        this.titleColor = r1;
    }
}
