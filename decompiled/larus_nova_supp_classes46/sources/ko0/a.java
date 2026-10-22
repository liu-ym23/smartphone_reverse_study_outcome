package ko0;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductJumpSetting;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\n(,-./01234B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00065"}, d2 = {"Lko0/a;", "", "Lko0/a$b;", "snapshotImgData", "Lko0/a$b;", "getSnapshotImgData", "()Lko0/a$b;", "setSnapshotImgData", "(Lko0/a$b;)V", "customizedCover", "getCustomizedCover", "setCustomizedCover", "", "customizedTitle", "Ljava/lang/String;", "getCustomizedTitle", "()Ljava/lang/String;", "setCustomizedTitle", "(Ljava/lang/String;)V", "Lko0/a$j;", "mountParams", "Lko0/a$j;", "getMountParams", "()Lko0/a$j;", "setMountParams", "(Lko0/a$j;)V", "", "isIntroducing", "Z", "()Z", "setIntroducing", "(Z)V", "canModifyCover", "getCanModifyCover", "setCanModifyCover", "Lko0/a$i;", "shelfInfo", "Lko0/a$i;", "getShelfInfo", "()Lko0/a$i;", "a", "(Lko0/a$i;)V", "<init>", "()V", "b", "c", "d", "e", "f", "g", "h", "i", "j", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("canModifyCover")
    private boolean canModifyCover;

    @SerializedName("customizedCover")
    private b customizedCover;

    @SerializedName("customizedTitle")
    private String customizedTitle;

    @SerializedName("isIntroducing")
    private boolean isIntroducing;

    @SerializedName("mountParams")
    private j mountParams;

    @SerializedName("shelfInfo")
    private i shelfInfo;

    @SerializedName("snapshotImgData")
    private b snapshotImgData;

    /* JADX INFO: renamed from: ko0.a$a, reason: collision with other inner class name */
    public static final class C0228a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lko0/a$b;", "", "", "uri", "Ljava/lang/String;", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "url", "a", "setUrl", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("uri")
        private String uri;

        @SerializedName("url")
        private String url;

        public b() {
            this(0);
        }

        public final String a() {
            return this.url;
        }

        public b(int r1) {
            this.uri = "";
            this.url = "";
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lko0/a$c;", "", "", "productId", "Ljava/lang/String;", "title", "imgUrl", "", "Lko0/a$d;", "introductionList", "Ljava/util/List;", "Lko0/a$f;", "labelList", "Lko0/a$g;", "price", "Lko0/a$g;", "actionText", "", "isShow", "Z", "Lko0/a$e;", "jumpSetting", "Lko0/a$e;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("actionText")
        public final String actionText;

        @SerializedName("imgUrl")
        public final String imgUrl;

        @SerializedName("introductionList")
        public final List<d> introductionList;

        @SerializedName("isShow")
        public final boolean isShow;

        @SerializedName("jumpSetting")
        public final e jumpSetting;

        @SerializedName("labelList")
        public final List<f> labelList;

        @SerializedName("price")
        public final g price;

        @SerializedName("productId")
        public final String productId;

        @SerializedName("title")
        public final String title;

        public c() {
            this(null, null, null, null, null, null, null, false, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L24;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.productId, r4.productId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.title, r4.title) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.imgUrl, r4.imgUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.introductionList, r4.introductionList) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.labelList, r4.labelList) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.price, r4.price) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.actionText, r4.actionText) == true) goto L20;
            return false;
        L20:
            if (this.isShow == r4.isShow) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.jumpSetting, r4.jumpSetting) == true) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v28 */
        public final int hashCode() {
            String r0 = this.productId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.title;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.imgUrl;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            List<d> r10 = this.introductionList;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            List<f> r13 = this.labelList;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            g r16 = this.price;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.actionText;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            boolean r22 = this.isShow;
            ?? r23 = r22;
            if (r22 == false) goto L33;
            r23 = 1;
        L33:
            int r24 = (r21 + r23) * 31;
            e r25 = this.jumpSetting;
            if (r25 == null) goto L37;
            r1 = r25.hashCode();
        L37:
            return r24 + r1;
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
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
            return "MemoryProductInfo(productId=" + this.productId + ", title=" + this.title + ", imgUrl=" + this.imgUrl + ", introductionList=" + this.introductionList + ", labelList=" + this.labelList + ", price=" + this.price + ", actionText=" + this.actionText + ", isShow=" + this.isShow + ", jumpSetting=" + this.jumpSetting + ")";
        }

        public c(String r1, String r2, String r3, List<d> r4, List<f> r5, g r6, String r7, boolean r8, e r9) {
            this.productId = r1;
            this.title = r2;
            this.imgUrl = r3;
            this.introductionList = r4;
            this.labelList = r5;
            this.price = r6;
            this.actionText = r7;
            this.isShow = r8;
            this.jumpSetting = r9;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lko0/a$d;", "", "", "content", "Ljava/lang/String;", "", "fontSize", "I", "fontColor", "introductionType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("content")
        public final String content;

        @SerializedName("fontColor")
        public final String fontColor;

        @SerializedName("fontSize")
        public final int fontSize;

        @SerializedName("introductionType")
        public final int introductionType;

        public d() {
            this(null, 0, null, 0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L14;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.content, r4.content) == true) goto L8;
            return false;
        L8:
            if (this.fontSize == r4.fontSize) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.fontColor, r4.fontColor) == true) goto L12;
            return false;
        L12:
            if (this.introductionType == r4.introductionType) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.content;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = ((r2 * 31) + this.fontSize) * 31;
            String r4 = this.fontColor;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.introductionType;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MemoryProductIntroductionInfo(content=" + this.content + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", introductionType=" + this.introductionType + ")";
        }

        public d(String r1, int r2, String r3, int r4) {
            this.content = r1;
            this.fontSize = r2;
            this.fontColor = r3;
            this.introductionType = r4;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lko0/a$e;", "", "", "isJumpToOtherPage", "Z", "", "jumpToOtherPageAppId", "Ljava/lang/String;", "jumpToOtherPagePath", "", "jumpToOtherPageQuery", "Ljava/util/Map;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("isJumpToOtherPage")
        public boolean isJumpToOtherPage;

        @SerializedName("jumpToOtherPageAppId")
        public String jumpToOtherPageAppId;

        @SerializedName("jumpToOtherPagePath")
        public String jumpToOtherPagePath;

        @SerializedName("jumpToOtherPageQuery")
        public Map<String, String> jumpToOtherPageQuery;

        public e() {
            this(false, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof e) == false) goto L14;
            e r4 = (e) r3;
            if (this.isJumpToOtherPage == r4.isJumpToOtherPage) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.jumpToOtherPageAppId, r4.jumpToOtherPageAppId) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.jumpToOtherPagePath, r4.jumpToOtherPagePath) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.jumpToOtherPageQuery, r4.jumpToOtherPageQuery) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public final int hashCode() {
            boolean r0 = this.isJumpToOtherPage;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            String r3 = this.jumpToOtherPageAppId;
            int r4 = 0;
            if (r3 == null) goto L8;
            int r5 = r3.hashCode();
        L9:
            int r6 = (r2 + r5) * 31;
            String r7 = this.jumpToOtherPagePath;
            if (r7 == null) goto L12;
            int r8 = r7.hashCode();
        L13:
            int r9 = (r6 + r8) * 31;
            Map<String, String> r10 = this.jumpToOtherPageQuery;
            if (r10 == null) goto L17;
            r4 = r10.hashCode();
        L17:
            return r9 + r4;
        L12:
            r8 = 0;
            goto L13
        L8:
            r5 = 0;
            goto L9
        }

        public final String toString() {
            return "MemoryProductJumpSetting(isJumpToOtherPage=" + this.isJumpToOtherPage + ", jumpToOtherPageAppId=" + this.jumpToOtherPageAppId + ", jumpToOtherPagePath=" + this.jumpToOtherPagePath + ", jumpToOtherPageQuery=" + this.jumpToOtherPageQuery + ")";
        }

        public e(boolean r1, String r2, String r3, Map<String, String> r4) {
            this.isJumpToOtherPage = r1;
            this.jumpToOtherPageAppId = r2;
            this.jumpToOtherPagePath = r3;
            this.jumpToOtherPageQuery = r4;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lko0/a$f;", "", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "leftIconList", "Ljava/util/List;", "", "leftText", "Ljava/lang/String;", "rightText", "", "fontSize", "I", "fontColor", "borderColor", "", "dividingLine", "Z", "labelType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f {

        @SerializedName("borderColor")
        public final String borderColor;

        @SerializedName("dividingLine")
        public final boolean dividingLine;

        @SerializedName("fontColor")
        public final String fontColor;

        @SerializedName("fontSize")
        public final int fontSize;

        @SerializedName("labelType")
        public final int labelType;

        @SerializedName("leftIconList")
        public final List<ImageModel> leftIconList;

        @SerializedName("leftText")
        public final String leftText;

        @SerializedName("rightText")
        public final String rightText;

        public f() {
            this(null, null, null, 0, null, null, false, 0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L22;
            f r4 = (f) r3;
            if (Intrinsics.areEqual(this.leftIconList, r4.leftIconList) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.leftText, r4.leftText) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.rightText, r4.rightText) == true) goto L12;
            return false;
        L12:
            if (this.fontSize == r4.fontSize) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.fontColor, r4.fontColor) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.borderColor, r4.borderColor) == true) goto L18;
            return false;
        L18:
            if (this.dividingLine == r4.dividingLine) goto L20;
            return false;
        L20:
            if (this.labelType == r4.labelType) goto L34;
            return false;
        L34:
            return true;
        L22:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            List<ImageModel> r0 = this.leftIconList;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.leftText;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.rightText;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (((r6 + r8) * 31) + this.fontSize) * 31;
            String r10 = this.fontColor;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.borderColor;
            if (r13 == null) goto L21;
            r1 = r13.hashCode();
        L21:
            int r14 = (r12 + r1) * 31;
            boolean r15 = this.dividingLine;
            ?? r16 = r15;
            if (r15 == false) goto L25;
            r16 = 1;
        L25:
            return ((r14 + r16) * 31) + this.labelType;
        L17:
            r11 = 0;
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
            return "MemoryProductLabelInfo(leftIconList=" + this.leftIconList + ", leftText=" + this.leftText + ", rightText=" + this.rightText + ", fontSize=" + this.fontSize + ", fontColor=" + this.fontColor + ", borderColor=" + this.borderColor + ", dividingLine=" + this.dividingLine + ", labelType=" + this.labelType + ")";
        }

        public f(List<? extends ImageModel> r1, String r2, String r3, int r4, String r5, String r6, boolean r7, int r8) {
            this.leftIconList = r1;
            this.leftText = r2;
            this.rightText = r3;
            this.fontSize = r4;
            this.fontColor = r5;
            this.borderColor = r6;
            this.dividingLine = r7;
            this.labelType = r8;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lko0/a$g;", "", "", "originalPrice", "Ljava/lang/String;", "currentPrice", "currentPrefix", "currentSuffix", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class g {

        @SerializedName("currentPrefix")
        public final String currentPrefix;

        @SerializedName("currentPrice")
        public final String currentPrice;

        @SerializedName("currentSuffix")
        public final String currentSuffix;

        @SerializedName("originalPrice")
        public final String originalPrice;

        public g() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof g) == false) goto L14;
            g r4 = (g) r3;
            if (Intrinsics.areEqual(this.originalPrice, r4.originalPrice) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.currentPrice, r4.currentPrice) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.currentPrefix, r4.currentPrefix) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.currentSuffix, r4.currentSuffix) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.originalPrice;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.currentPrice;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.currentPrefix;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.currentSuffix;
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
            return "MemoryProductPriceInfo(originalPrice=" + this.originalPrice + ", currentPrice=" + this.currentPrice + ", currentPrefix=" + this.currentPrefix + ", currentSuffix=" + this.currentSuffix + ")";
        }

        public g(String r1, String r2, String r3, String r4) {
            this.originalPrice = r1;
            this.currentPrice = r2;
            this.currentPrefix = r3;
            this.currentSuffix = r4;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lko0/a$h;", "", "", "schema", "Ljava/lang/String;", "defaultTitle", "defaultCoverUrl", "customizedTitle", "customizedCoverUrl", "lastPassCoverUrl", "sourcePage", "", "status", "J", "createInfo", "Lko0/a$c;", "productInfo", "Lko0/a$c;", "sellingPoint", "presetCardUrl", "textPosterUrl", "textPosterTitle", "screenshotUrl", "", "customizedCoverType", "I", "selectedCoverType", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h {

        @SerializedName("createInfo")
        public final String createInfo;

        @SerializedName("customizedCoverType")
        public final int customizedCoverType;

        @SerializedName("customizedCoverURL")
        public final String customizedCoverUrl;

        @SerializedName("customizedTitle")
        public final String customizedTitle;

        @SerializedName("defaultCoverURL")
        public final String defaultCoverUrl;

        @SerializedName("defaultTitle")
        public final String defaultTitle;

        @SerializedName("lastPassImg")
        public final String lastPassCoverUrl;

        @SerializedName("preSetCardURL")
        public final String presetCardUrl;

        @SerializedName("productInfo")
        public final c productInfo;

        @SerializedName("schema")
        public final String schema;

        @SerializedName("screenShotURL")
        public final String screenshotUrl;

        @SerializedName("selectCoverType")
        public final int selectedCoverType;

        @SerializedName("sellingPoint")
        public final String sellingPoint;

        @SerializedName("sourcePage")
        public final String sourcePage;

        @SerializedName("status")
        public final long status;

        @SerializedName("textPosterTitle")
        public final String textPosterTitle;

        @SerializedName("textPosterURL")
        public final String textPosterUrl;

        public h() {
            this(null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, 0, 0);
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof h) == false) goto L40;
            h r7 = (h) r6;
            if (Intrinsics.areEqual(this.schema, r7.schema) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.defaultTitle, r7.defaultTitle) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.defaultCoverUrl, r7.defaultCoverUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.customizedTitle, r7.customizedTitle) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.customizedCoverUrl, r7.customizedCoverUrl) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.lastPassCoverUrl, r7.lastPassCoverUrl) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.sourcePage, r7.sourcePage) == true) goto L20;
            return false;
        L20:
            if (this.status == r7.status) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.createInfo, r7.createInfo) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.productInfo, r7.productInfo) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.sellingPoint, r7.sellingPoint) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.presetCardUrl, r7.presetCardUrl) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.textPosterUrl, r7.textPosterUrl) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.textPosterTitle, r7.textPosterTitle) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.screenshotUrl, r7.screenshotUrl) == true) goto L36;
            return false;
        L36:
            if (this.customizedCoverType == r7.customizedCoverType) goto L38;
            return false;
        L38:
            if (this.selectedCoverType == r7.selectedCoverType) goto L61;
            return false;
        L61:
            return true;
        L40:
            return false;
        }

        public final int hashCode() {
            String r0 = this.schema;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.defaultTitle;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.defaultCoverUrl;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.customizedTitle;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.customizedCoverUrl;
            if (r13 == null) goto L21;
            int r14 = r13.hashCode();
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.lastPassCoverUrl;
            if (r16 == null) goto L25;
            int r17 = r16.hashCode();
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.sourcePage;
            if (r19 == null) goto L29;
            int r20 = r19.hashCode();
        L30:
            int r21 = (r18 + r20) * 31;
            long r22 = this.status;
            int r23 = (r21 + ((int) (r22 ^ (r22 >>> 32)))) * 31;
            String r24 = this.createInfo;
            if (r24 == null) goto L33;
            int r25 = r24.hashCode();
        L34:
            int r26 = (r23 + r25) * 31;
            c r27 = this.productInfo;
            if (r27 == null) goto L37;
            int r28 = r27.hashCode();
        L38:
            int r29 = (r26 + r28) * 31;
            String r30 = this.sellingPoint;
            if (r30 == null) goto L41;
            int r31 = r30.hashCode();
        L42:
            int r32 = (r29 + r31) * 31;
            String r33 = this.presetCardUrl;
            if (r33 == null) goto L45;
            int r34 = r33.hashCode();
        L46:
            int r35 = (r32 + r34) * 31;
            String r36 = this.textPosterUrl;
            if (r36 == null) goto L49;
            int r37 = r36.hashCode();
        L50:
            int r38 = (r35 + r37) * 31;
            String r39 = this.textPosterTitle;
            if (r39 == null) goto L53;
            int r40 = r39.hashCode();
        L54:
            int r41 = (r38 + r40) * 31;
            String r42 = this.screenshotUrl;
            if (r42 == null) goto L58;
            r1 = r42.hashCode();
        L58:
            return ((((r41 + r1) * 31) + this.customizedCoverType) * 31) + this.selectedCoverType;
        L53:
            r40 = 0;
            goto L54
        L49:
            r37 = 0;
            goto L50
        L45:
            r34 = 0;
            goto L46
        L41:
            r31 = 0;
            goto L42
        L37:
            r28 = 0;
            goto L38
        L33:
            r25 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
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
            return "MemoryShelfCardInfo(schema=" + this.schema + ", defaultTitle=" + this.defaultTitle + ", defaultCoverUrl=" + this.defaultCoverUrl + ", customizedTitle=" + this.customizedTitle + ", customizedCoverUrl=" + this.customizedCoverUrl + ", lastPassCoverUrl=" + this.lastPassCoverUrl + ", sourcePage=" + this.sourcePage + ", status=" + this.status + ", createInfo=" + this.createInfo + ", productInfo=" + this.productInfo + ", sellingPoint=" + this.sellingPoint + ", presetCardUrl=" + this.presetCardUrl + ", textPosterUrl=" + this.textPosterUrl + ", textPosterTitle=" + this.textPosterTitle + ", screenshotUrl=" + this.screenshotUrl + ", customizedCoverType=" + this.customizedCoverType + ", selectedCoverType=" + this.selectedCoverType + ")";
        }

        public h(String r4, String r5, String r6, String r7, String r8, String r9, String r10, long r11, String r13, c r14, String r15, String r16, String r17, String r18, String r19, int r20, int r21) {
            this.schema = r4;
            this.defaultTitle = r5;
            this.defaultCoverUrl = r6;
            this.customizedTitle = r7;
            this.customizedCoverUrl = r8;
            this.lastPassCoverUrl = r9;
            this.sourcePage = r10;
            this.status = r11;
            this.createInfo = r13;
            this.productInfo = r14;
            this.sellingPoint = r15;
            this.presetCardUrl = r16;
            this.textPosterUrl = r17;
            this.textPosterTitle = r18;
            this.screenshotUrl = r19;
            this.customizedCoverType = r20;
            this.selectedCoverType = r21;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lko0/a$i;", "", "", "appId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "appName", "b", "iconURI", "e", "entryPagePath", "d", "", "Lko0/a$h;", "cardInfo", "Ljava/util/List;", "c", "()Ljava/util/List;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class i {

        @SerializedName("appId")
        private final String appId;

        @SerializedName("appName")
        private final String appName;

        @SerializedName("cardInfo")
        private final List<h> cardInfo;

        @SerializedName("entryPagePath")
        private final String entryPagePath;

        @SerializedName("iconURI")
        private final String iconURI;

        public i() {
            this(null, null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof i) == false) goto L16;
            i r4 = (i) r3;
            if (Intrinsics.areEqual(this.appId, r4.appId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.appName, r4.appName) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.iconURI, r4.iconURI) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entryPagePath, r4.entryPagePath) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.cardInfo, r4.cardInfo) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
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
            String r7 = this.iconURI;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.entryPagePath;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            List<h> r13 = this.cardInfo;
            if (r13 == null) goto L22;
            r1 = r13.hashCode();
        L22:
            return r12 + r1;
        L17:
            r11 = 0;
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
            return "MemoryShelfInfo(appId=" + this.appId + ", appName=" + this.appName + ", iconURI=" + this.iconURI + ", entryPagePath=" + this.entryPagePath + ", cardInfo=" + this.cardInfo + ")";
        }

        public final String a() {
            return this.appId;
        }

        public final String b() {
            return this.appName;
        }

        public final List<h> c() {
            return this.cardInfo;
        }

        public final String d() {
            return this.entryPagePath;
        }

        public final String e() {
            return this.iconURI;
        }

        public i(String r1, String r2, String r3, String r4, List<h> r5) {
            this.appId = r1;
            this.appName = r2;
            this.iconURI = r3;
            this.entryPagePath = r4;
            this.cardInfo = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lko0/a$j;", "", "", "appID", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setAppID", "(Ljava/lang/String;)V", "entryPagePath", "c", "setEntryPagePath", "startPageUrl", "f", "setStartPageUrl", "title", "g", "setTitle", "appName", "b", "setAppName", "schema", "e", "setSchema", "iconURI", "d", "setIconURI", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class j {

        @SerializedName("appID")
        private String appID;

        @SerializedName("appName")
        private String appName;

        @SerializedName("entryPagePath")
        private String entryPagePath;

        @SerializedName("iconURI")
        private String iconURI;

        @SerializedName("schema")
        private String schema;

        @SerializedName("startPageUrl")
        private String startPageUrl;

        @SerializedName("title")
        private String title;

        public j() {
            this(0);
        }

        public final String a() {
            return this.appID;
        }

        public final String b() {
            return this.appName;
        }

        public final String c() {
            return this.entryPagePath;
        }

        public final String d() {
            return this.iconURI;
        }

        public final String e() {
            return this.schema;
        }

        public final String f() {
            return this.startPageUrl;
        }

        public final String g() {
            return this.title;
        }

        public j(int r1) {
            this.appID = "";
            this.entryPagePath = "";
            this.startPageUrl = "";
            this.title = "";
            this.appName = "";
            this.schema = "";
            this.iconURI = "";
        }
    }

    static {
    }

    public final ShelfInfo b() {
        i r1 = this.shelfInfo;
        if (r1 == null) goto L46;
        String r4 = r1.a();
        String r5 = r1.b();
        ImageModel r6 = new ImageModel(null, CollectionsKt.listOf(r1.e()));
        SchemaInfo.a r3 = new SchemaInfo.a();
        String r7 = r1.a();
        if (r7 != null) goto L7;
        r7 = "";
    L7:
        r3.a(r7);
        SchemaInfo r8 = r3.c();
        if (r8 == null) goto L10;
        String r9 = r8.h();
    L11:
        ShelfMicroAppInfo r10 = new ShelfMicroAppInfo(r4, r5, r6, r9, 0, 48);
        ArrayList r11 = new ArrayList();
        List<h> r12 = r1.c();
        if (r12 == null) goto L45;
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L45;
        h r14 = (h) r13.next();
        String r15 = r14.schema;
        String r16 = r14.defaultTitle;
        String r17 = r14.defaultCoverUrl;
        String r18 = r14.customizedTitle;
        String r19 = r14.customizedCoverUrl;
        String r20 = r14.lastPassCoverUrl;
        String r21 = r14.sourcePage;
        Iterator r35 = r13;
        long r2 = r14.status;
        String r110 = r14.createInfo;
        c r111 = r14.productInfo;
        if (r111 == null) goto L43;
        String r0 = r111.productId;
        String r112 = r111.title;
        String r22 = r111.imgUrl;
        List<d> r23 = r111.introductionList;
        if (r23 == null) goto L25;
        List<d> r24 = r23;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L22:
        if (r26.hasNext() == false) goto L24;
        d r27 = (d) r26.next();
        r27.getClass();
        r25.add(new ProductIntroductionInfo(r27.content, r27.fontSize, r27.fontColor, r27.introductionType));
        r26 = r26;
        r21 = r21;
        r19 = r19;
        goto L22
    L24:
        String r41 = r19;
        String r40 = r21;
        ArrayList r28 = r25;
    L26:
        List<f> r29 = r111.labelList;
        if (r29 == null) goto L33;
        List<f> r30 = r29;
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10));
        Iterator r32 = r30.iterator();
    L30:
        if (r32.hasNext() == false) goto L32;
        f r33 = (f) r32.next();
        r33.getClass();
        r31.add(new ProductLabelInfo(r33.leftIconList, r33.leftText, r33.rightText, r33.fontSize, r33.fontColor, r33.borderColor, r33.dividingLine, r33.labelType));
        r32 = r32;
        r18 = r18;
        r17 = r17;
        r16 = r16;
        r15 = r15;
        goto L30
    L32:
        String r54 = r15;
        String r53 = r16;
        String r52 = r17;
        String r51 = r18;
        ArrayList r210 = r31;
    L34:
        g r34 = r111.price;
        if (r34 == null) goto L37;
        ProductPriceInfo r211 = new ProductPriceInfo(r34.originalPrice, r34.currentPrice, r34.currentPrefix, r34.currentSuffix);
    L38:
        String r36 = r111.actionText;
        boolean r37 = r111.isShow;
        e r38 = r111.jumpSetting;
        if (r38 == null) goto L41;
        ProductJumpSetting r39 = new ProductJumpSetting(r38.isJumpToOtherPage, r38.jumpToOtherPageAppId, r38.jumpToOtherPagePath, r38.jumpToOtherPageQuery);
    L42:
        ProductInfo r212 = new ProductInfo(r0, r112, r22, r28, r210, r211, r36, r37, r39);
    L44:
        String r113 = r54;
        String r114 = r53;
        String r115 = r52;
        String r116 = r51;
        String r117 = r41;
        String r118 = r40;
        ShelfCardInfo r42 = new ShelfCardInfo(r113, r114, r115, r116, r117, r118, false, r2, 0, r110, r20, r212, r14.sellingPoint, r14.presetCardUrl, r14.textPosterUrl, r14.textPosterTitle, r14.screenshotUrl, r14.selectedCoverType, r14.customizedCoverType, 257875267, 0);
        ArrayList r43 = r11;
        r43.add(r42);
        r11 = r43;
        r13 = r35;
        r10 = r10;
        r1 = r1;
        goto L15
    L41:
        r39 = null;
        goto L42
    L37:
        r211 = null;
        goto L38
    L33:
        r54 = r15;
        r53 = r16;
        r52 = r17;
        r51 = r18;
        r210 = null;
        goto L34
    L25:
        r41 = r19;
        r40 = r21;
        r28 = null;
        goto L26
    L43:
        r2 = r2;
        r41 = r19;
        r40 = r21;
        r54 = r15;
        r53 = r16;
        r52 = r17;
        r51 = r18;
        r212 = null;
    L45:
        i r310 = r1;
        ShelfMicroAppInfo r311 = r10;
        Unit r44 = Unit.INSTANCE;
        return new ShelfInfo(r311, r11, 0, null, r310.d(), "auto", 262140);
    L10:
        r9 = null;
        goto L11
    L46:
        j r45 = this.mountParams;
        if (r45 == null) goto L49;
        String r46 = r45.a();
    L50:
        j r47 = this.mountParams;
        if (r47 == null) goto L53;
        String r48 = r47.b();
    L54:
        j r49 = this.mountParams;
        if (r49 == null) goto L57;
        String r50 = r49.d();
    L58:
        ImageModel r55 = new ImageModel(null, CollectionsKt.listOf(r50));
        j r56 = this.mountParams;
        if (r56 == null) goto L61;
        String r57 = r56.e();
    L62:
        ShelfMicroAppInfo r119 = new ShelfMicroAppInfo(r46, r48, r55, r57, 0, 48);
        ShelfCardInfo[] r58 = new ShelfCardInfo[1];
        j r59 = this.mountParams;
        if (r59 == null) goto L65;
        String r120 = r59.e();
    L66:
        j r60 = this.mountParams;
        if (r60 == null) goto L69;
        String r121 = r60.g();
    L70:
        b r61 = this.snapshotImgData;
        if (r61 == null) goto L73;
        String r122 = r61.a();
    L74:
        String r62 = this.customizedTitle;
        b r63 = this.customizedCover;
        if (r63 == null) goto L77;
        String r123 = r63.a();
    L78:
        j r65 = this.mountParams;
        if (r65 == null) goto L81;
        String r124 = r65.f();
    L82:
        boolean r66 = this.canModifyCover;
        if (this.isIntroducing == false) goto L85;
        long r67 = 1;
    L86:
        r58[0] = new ShelfCardInfo(r120, r121, r122, r62, r123, r124, r66, r67, 0, null, null, null, null, null, null, null, null, 0, 0, -12989, 7);
        List r125 = CollectionsKt.mutableListOf(r58);
        j r68 = this.mountParams;
        if (r68 == null) goto L89;
        String r126 = r68.c();
    L91:
        return new ShelfInfo(r119, r125, 0, null, r126, "auto", 262140);
    L89:
        r126 = null;
        goto L91
    L85:
        r67 = 0;
        goto L86
    L81:
        r124 = null;
        goto L82
    L77:
        r123 = null;
        goto L78
    L73:
        r122 = null;
        goto L74
    L69:
        r121 = null;
        goto L70
    L65:
        r120 = null;
        goto L66
    L61:
        r57 = null;
        goto L62
    L57:
        r50 = null;
        goto L58
    L53:
        r48 = null;
        goto L54
    L49:
        r46 = null;
        goto L50
    }

    public a() {
        this.snapshotImgData = new b(0);
        this.customizedCover = new b(0);
        this.customizedTitle = "";
        this.mountParams = new j(0);
        this.canModifyCover = true;
    }

    public final void a(i r1) {
        this.shelfInfo = r1;
    }
}
