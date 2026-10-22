package com.bytedance.android.live.base.model.banner;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.Item;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.feed.Banner.Item")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001a\b\u0007\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b1\u00102R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u0018\u0010*\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010\u000bR$\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\"\u0010.\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 ¨\u00064"}, d2 = {"Lcom/bytedance/android/live/base/model/banner/a;", "Lcom/bytedance/android/live/base/model/Item;", "", "_id", "J", "get_id", "()J", "set_id", "(J)V", "", "title", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "", "urlList", "Ljava/util/List;", "g", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "uri", "getUri", "setUri", "", "height", "I", "b", "()I", "setHeight", "(I)V", "width", "h", "setWidth", "schemaUrl", "d", "setSchemaUrl", "text", "e", "setText", "_extra", "avgColor", "getAvgColor", "setAvgColor", "bannerType", "getBannerType", "setBannerType", "<init>", "()V", "a", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements Item, h {

    @IgnoreProtoFieldCheck
    @SerializedName("extra")
    private String _extra;

    @SerializedName("id")
    protected long _id;
    public ImageModel a;

    @SerializedName("avg_color")
    protected String avgColor;

    @SerializedName("banner_type")
    protected int bannerType;

    @SerializedName("height")
    protected int height;

    @SerializedName("schema_url")
    protected String schemaUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("text")
    private String text;

    @SerializedName("title")
    protected String title;

    @SerializedName("uri")
    protected String uri;

    @SerializedName("url_list")
    protected List<String> urlList;

    @SerializedName("width")
    protected int width;

    /* JADX INFO: renamed from: com.bytedance.android.live.base.model.banner.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final IUser author() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final List<Object> getDislikeReason() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String subtitle() {
        return null;
    }

    public final ImageModel c() {
        if (this.a != null) goto L10;
        if (this.urlList == null) goto L10;
        if (this.uri == null) goto L10;
        this.a = new ImageModel(this.uri, this.urlList);
    L10:
        return this.a;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String getMixId() {
        return String.valueOf(this._id);
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final ImageModel cover() {
        return c();
    }

    public final int b() {
        return this.height;
    }

    public final String d() {
        return this.schemaUrl;
    }

    public final String e() {
        return this.text;
    }

    public final String f() {
        return this.title;
    }

    public final List<String> g() {
        return this.urlList;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final long getId() {
        return this._id;
    }

    public final int h() {
        return this.width;
    }

    @Override // com.bytedance.android.live.base.model.Item
    public final String title() {
        return this.title;
    }

    public a(g r5) {
        this.urlList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L6;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.bannerType = (int) r5.j();
        goto L3
    L8:
        this.schemaUrl = am3.h.c(r5);
        goto L3
    L9:
        this._id = r5.j();
        goto L3
    L10:
        this.width = (int) r5.j();
        goto L3
    L11:
        this.height = (int) r5.j();
        goto L3
    L12:
        this.uri = am3.h.c(r5);
        goto L3
    L13:
        this.urlList.add(am3.h.c(r5));
        goto L3
    L14:
        this.title = am3.h.c(r5);
        goto L3
    L15:
        this.avgColor = am3.h.c(r5);
        goto L3
    L6:
        am3.h.e(r5);
        goto L3
    L16:
        r5.d(r0);
    }

    public final boolean a(a r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L9;
        return false;
    L9:
        if (this._id == r8._id) goto L12;
        return false;
    L12:
        if (StringUtils.equal(this.title, r8.title) == true) goto L15;
        return false;
    L15:
        if (StringUtils.equal(this.uri, r8.uri) == true) goto L18;
        return false;
    L18:
        if (StringUtils.equal(this.schemaUrl, r8.schemaUrl) == true) goto L21;
        return false;
    L21:
        if (StringUtils.equal(this.text, r8.text) == true) goto L24;
        return false;
    L24:
        if (this.width == r8.width) goto L27;
        return false;
    L27:
        if (this.height == r8.height) goto L29;
        return false;
    L29:
        List<String> r2 = this.urlList;
        if (r2 == null) goto L32;
    L34:
        if (r2 != null) goto L36;
    L38:
        if (r2 == null) goto L40;
    L42:
        Intrinsics.checkNotNull(r2);
        int r0 = r2.size();
        List<String> r3 = r8.urlList;
        Intrinsics.checkNotNull(r3);
        if (r0 == r3.size()) goto L45;
        return false;
    L45:
        List<String> r1 = this.urlList;
        Intrinsics.checkNotNull(r1);
        int r4 = r1.size();
        int r5 = 0;
    L46:
        if (r5 >= r4) goto L52;
        List<String> r6 = this.urlList;
        Intrinsics.checkNotNull(r6);
        String r7 = (String) ListProtector.get(r6, r5);
        List<String> r9 = r8.urlList;
        Intrinsics.checkNotNull(r9);
        if (StringUtils.equal(r7, (String) ListProtector.get(r9, r5)) == false) goto L49;
        r5 = r5 + 1;
        goto L46
    L49:
        return false;
    L52:
        return StringUtils.equal(this._extra, r8._extra);
    L40:
        if (r8.urlList != null) goto L42;
        return true;
    L36:
        if (r8.urlList != null) goto L38;
        return false;
    L32:
        if (r8.urlList == null) goto L34;
        return false;
    }
}
