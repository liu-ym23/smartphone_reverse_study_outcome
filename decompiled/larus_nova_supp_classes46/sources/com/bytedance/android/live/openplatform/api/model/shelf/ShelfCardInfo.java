package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.d90;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.config.vc1;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.data.ShelfCardInfo")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001[R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0016\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000eR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000eR\u001a\u0010%\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0019R\u001a\u0010*\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u0007R\u001c\u0010.\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b/\u0010\u000eR\u001a\u00100\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010'R\u001c\u00102\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b2\u0010\f\u001a\u0004\b3\u0010\u000eR\u001c\u00104\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010'R\u001c\u00108\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b8\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b:\u0010\u000eR\u001c\u0010;\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b;\u0010\f\u001a\u0004\b<\u0010\u000eR\"\u0010>\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\u001c8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b>\u0010\u001f\u001a\u0004\b?\u0010!R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bE\u0010\u0010\u001a\u0004\bF\u0010'R\u001a\u0010G\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bH\u0010'R\u001a\u0010I\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bI\u0010\u0010\u001a\u0004\bJ\u0010'R\u001a\u0010K\u001a\u00020\u00158\u0016X\u0097\u0004¢\u0006\f\n\u0004\bK\u0010\u0017\u001a\u0004\bL\u0010\u0019R\u001c\u0010M\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bN\u0010\u000eR\u001c\u0010O\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bO\u0010\f\u001a\u0004\bP\u0010\u000eR\u001c\u0010Q\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bQ\u0010\f\u001a\u0004\bR\u0010\u000eR\u001c\u0010S\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bS\u0010\f\u001a\u0004\bT\u0010\u000eR\u001c\u0010U\u001a\u0004\u0018\u00010\n8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bU\u0010\f\u001a\u0004\bV\u0010\u000eR\u001a\u0010W\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bW\u0010\u0010\u001a\u0004\bX\u0010'R\u001a\u0010Y\u001a\u00020$8\u0016X\u0097\u0004¢\u0006\f\n\u0004\bY\u0010\u0010\u001a\u0004\bZ\u0010'¨\u0006\\"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "Landroid/os/Parcelable;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/a;", "", "cardId", "J", "getCardId", "()J", "localCardId", "O", "", "schema", "Ljava/lang/String;", "a0", "()Ljava/lang/String;", "defaultTitle", "I", "defaultCoverUrl", "F", "customizedTitle", "E", "", "isTitleChanged", "Z", "I0", "()Z", "customizedCoverUrl", "D", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Ljava/util/List;", "L", "()Ljava/util/List;", "sourcePage", "i0", "", "reviewStatus", "getReviewStatus", "()I", "fromReview", "K", "canModifyCover", "r", "status", "getStatus", "logExtra", "R", "cardSource", "s", "createInfo", "t", "reviewResultReason", "Y", "reviewTitleStatus", "getReviewTitleStatus", "reviewingTitle", "lastPassTitle", "N", "lastPassCoverUrl", "M", "Lcom/bytedance/android/live/openplatform/api/model/shelf/AuditInfo;", "auditInfoList", "q", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "productInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "getProductInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "priority", "U", "topReason", "p0", "showDuration", "f0", "isLeadsComponent", "C0", "sellingPoint", "b", "presetCardUrl", "S", "textPosterUrl", "o0", "textPosterTitle", "j0", "screenshotUrl", "b0", "selectedCoverType", "c0", "customizedCoverType", "z", "Source", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfCardInfo implements Parcelable, com.bytedance.android.live.openplatform.api.model.shelf.a, h {
    public static final Parcelable.Creator<ShelfCardInfo> CREATOR = null;
    public JSONObject a;

    @SerializedName("audit_info_list")
    protected List<AuditInfo> auditInfoList;

    @SerializedName("can_modify_cover")
    protected boolean canModifyCover;

    @SerializedName("card_id")
    protected long cardId;

    @SerializedName("card_source")
    protected int cardSource;

    @SerializedName("create_info")
    protected String createInfo;

    @SerializedName("customized_cover_type")
    protected int customizedCoverType;

    @SerializedName("customized_cover_url")
    protected String customizedCoverUrl;

    @SerializedName("customized_title")
    protected String customizedTitle;

    @SerializedName("default_cover_url")
    protected String defaultCoverUrl;

    @SerializedName("default_title")
    protected String defaultTitle;

    @SerializedName("from_review")
    protected boolean fromReview;

    @SerializedName("image")
    protected List<ImageModel> image;

    @SerializedName("is_leads_component")
    protected boolean isLeadsComponent;

    @IgnoreProtoFieldCheck
    @SerializedName("is_title_changed")
    private final boolean isTitleChanged;

    @SerializedName("last_pass_img")
    protected String lastPassCoverUrl;

    @SerializedName("last_pass_title")
    protected String lastPassTitle;

    @IgnoreProtoFieldCheck
    @SerializedName("local_card_id")
    private final long localCardId;

    @SerializedName("log_extra")
    protected String logExtra;

    @SerializedName("pre_set_card_url")
    protected String presetCardUrl;

    @SerializedName("priority")
    protected int priority;

    @SerializedName("product_info")
    protected ProductInfo productInfo;

    @SerializedName("review_result_reason")
    protected String reviewResultReason;

    @SerializedName("review_status")
    protected int reviewStatus;

    @SerializedName("review_title_status")
    protected int reviewTitleStatus;

    @SerializedName("reviewing_title")
    protected String reviewingTitle;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("screen_shot_url")
    protected String screenshotUrl;

    @SerializedName("select_cover_type")
    protected int selectedCoverType;

    @SerializedName("selling_point")
    protected String sellingPoint;

    @SerializedName("show_duration")
    protected int showDuration;

    @SerializedName("source_page")
    protected String sourcePage;

    @SerializedName("status")
    protected long status;

    @SerializedName("text_poster_title")
    protected String textPosterTitle;

    @SerializedName("text_poster_url")
    protected String textPosterUrl;

    @SerializedName("top_reason")
    protected int topReason;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo$Source;", "", "", "value", "I", "getValue", "()I", "Phone", "PC", "Saas", "Other", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Source extends Enum<Source> {
        public static final Source Other = null;
        public static final Source PC = null;
        public static final Source Phone = null;
        public static final Source Saas = null;
        public static final /* synthetic */ Source[] a = null;
        private final int value;

        static {
            Source r1 = new Source("Phone", 0, 0);
            Phone = r1;
            Source r2 = new Source("PC", 1, 1);
            PC = r2;
            Source r3 = new Source("Saas", 2, 2);
            Saas = r3;
            Source r4 = new Source("Other", 3, 99);
            Other = r4;
            a = new Source[]{r1, r2, r3, r4};
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a implements Parcelable.Creator<ShelfCardInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfCardInfo createFromParcel(Parcel r47) {
            Intrinsics.checkNotNullParameter(r47, "in");
            long r3 = r47.readLong();
            long r5 = r47.readLong();
            String r7 = r47.readString();
            String r8 = r47.readString();
            String r9 = r47.readString();
            String r10 = r47.readString();
            if (r47.readInt() == 0) goto L5;
            boolean r13 = true;
        L6:
            String r14 = r47.readString();
            if (r47.readInt() == 0) goto L12;
            int r2 = r47.readInt();
            ArrayList r11 = new ArrayList(r2);
        L9:
            if (r2 == 0) goto L11;
            r11.add(r47.readParcelable(ShelfCardInfo.class.getClassLoader()));
            r2 = r2 - 1;
            goto L9
        L11:
            ArrayList r17 = r11;
        L13:
            String r19 = r47.readString();
            int r20 = r47.readInt();
            if (r47.readInt() == 0) goto L16;
            boolean r21 = true;
        L18:
            if (r47.readInt() == 0) goto L20;
            boolean r22 = true;
        L21:
            long r23 = r47.readLong();
            String r25 = r47.readString();
            int r26 = r47.readInt();
            String r27 = r47.readString();
            String r28 = r47.readString();
            int r29 = r47.readInt();
            String r30 = r47.readString();
            String r31 = r47.readString();
            String r32 = r47.readString();
            if (r47.readInt() == 0) goto L27;
            int r4 = r47.readInt();
            ArrayList r12 = new ArrayList(r4);
        L24:
            if (r4 == 0) goto L26;
            r12.add(AuditInfo.CREATOR.createFromParcel(r47));
            r4 = r4 - 1;
            goto L24
        L26:
            ArrayList r33 = r12;
        L29:
            if (r47.readInt() == 0) goto L31;
            ProductInfo r41 = ProductInfo.CREATOR.createFromParcel(r47);
        L32:
            int r42 = r47.readInt();
            int r43 = r47.readInt();
            int r44 = r47.readInt();
            if (r47.readInt() == 0) goto L35;
            boolean r45 = true;
        L37:
            return new ShelfCardInfo(r3, r5, r7, r8, r9, r10, r13, r14, r17, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33, r41, r42, r43, r44, r45, r47.readString(), r47.readString(), r47.readString(), r47.readString(), r47.readString(), r47.readInt(), r47.readInt());
        L35:
            r45 = false;
            goto L37
        L31:
            r41 = null;
            goto L32
        L27:
            r33 = null;
            goto L29
        L20:
            r22 = false;
            goto L21
        L16:
            r21 = false;
            goto L18
        L12:
            r17 = null;
            goto L13
        L5:
            r13 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ShelfCardInfo[] newArray(int r1) {
            return new ShelfCardInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public ShelfCardInfo(long r4, long r6, String r8, String r9, String r10, String r11, boolean r12, String r13, List<? extends ImageModel> r14, String r15, int r16, boolean r17, boolean r18, long r19, String r21, int r22, String r23, String r24, int r25, String r26, String r27, String r28, List<AuditInfo> r29, ProductInfo r30, int r31, int r32, int r33, boolean r34, String r35, String r36, String r37, String r38, String r39, int r40, int r41) {
        this.cardId = r4;
        this.localCardId = r6;
        this.schema = r8;
        this.defaultTitle = r9;
        this.defaultCoverUrl = r10;
        this.customizedTitle = r11;
        this.isTitleChanged = r12;
        this.customizedCoverUrl = r13;
        this.image = r14;
        this.sourcePage = r15;
        this.reviewStatus = r16;
        this.fromReview = r17;
        this.canModifyCover = r18;
        this.status = r19;
        this.logExtra = r21;
        this.cardSource = r22;
        this.createInfo = r23;
        this.reviewResultReason = r24;
        this.reviewTitleStatus = r25;
        this.reviewingTitle = r26;
        this.lastPassTitle = r27;
        this.lastPassCoverUrl = r28;
        this.auditInfoList = r29;
        this.productInfo = r30;
        this.priority = r31;
        this.topReason = r32;
        this.showDuration = r33;
        this.isLeadsComponent = r34;
        this.sellingPoint = r35;
        this.presetCardUrl = r36;
        this.textPosterUrl = r37;
        this.textPosterTitle = r38;
        this.screenshotUrl = r39;
        this.selectedCoverType = r40;
        this.customizedCoverType = r41;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean w0() {
        if (this.a != null) goto L9;
        String r2 = this.createInfo;     // Catch: JSONException -> L18
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.a = new JSONObject(r2);     // Catch: JSONException -> L18
    L9:
        JSONObject r1 = this.a;     // Catch: JSONException -> L18
        if (r1 == null) goto L21;
        JSONObject r3 = r1.optJSONObject("extra");     // Catch: JSONException -> L18
        if (r3 == null) goto L22;
        if (r3.optInt("is_default_cover_from_cache", 0) != 1) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L24:
        return false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        r6.writeLong(this.cardId);
        r6.writeLong(this.localCardId);
        r6.writeString(this.schema);
        r6.writeString(this.defaultTitle);
        r6.writeString(this.defaultCoverUrl);
        r6.writeString(this.customizedTitle);
        r6.writeInt(this.isTitleChanged ? 1 : 0);
        r6.writeString(this.customizedCoverUrl);
        List<ImageModel> r0 = this.image;
        if (r0 == null) goto L8;
        r6.writeInt(1);
        r6.writeInt(r0.size());
        Iterator<ImageModel> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r6.writeParcelable(r1.next(), r7);
    L9:
        r6.writeString(this.sourcePage);
        r6.writeInt(this.reviewStatus);
        r6.writeInt(this.fromReview ? 1 : 0);
        r6.writeInt(this.canModifyCover ? 1 : 0);
        r6.writeLong(this.status);
        r6.writeString(this.logExtra);
        r6.writeInt(this.cardSource);
        r6.writeString(this.createInfo);
        r6.writeString(this.reviewResultReason);
        r6.writeInt(this.reviewTitleStatus);
        r6.writeString(this.reviewingTitle);
        r6.writeString(this.lastPassTitle);
        r6.writeString(this.lastPassCoverUrl);
        List<AuditInfo> r8 = this.auditInfoList;
        if (r8 == null) goto L15;
        r6.writeInt(1);
        r6.writeInt(r8.size());
        Iterator<AuditInfo> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L16;
        r9.next().writeToParcel(r6, 0);
    L16:
        ProductInfo r10 = this.productInfo;
        if (r10 == null) goto L19;
        r6.writeInt(1);
        r10.writeToParcel(r6, 0);
    L20:
        r6.writeInt(this.priority);
        r6.writeInt(this.topReason);
        r6.writeInt(this.showDuration);
        r6.writeInt(this.isLeadsComponent ? 1 : 0);
        r6.writeString(this.sellingPoint);
        r6.writeString(this.presetCardUrl);
        r6.writeString(this.textPosterUrl);
        r6.writeString(this.textPosterTitle);
        r6.writeString(this.screenshotUrl);
        r6.writeInt(this.selectedCoverType);
        r6.writeInt(this.customizedCoverType);
        return;
    L19:
        r6.writeInt(0);
        goto L20
    L15:
        r6.writeInt(0);
        goto L16
    L8:
        r6.writeInt(0);
        goto L9
    }

    public final boolean y0() {
        if (this.a != null) goto L9;
        String r2 = this.createInfo;     // Catch: JSONException -> L18
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.a = new JSONObject(r2);     // Catch: JSONException -> L18
    L9:
        JSONObject r1 = this.a;     // Catch: JSONException -> L18
        if (r1 == null) goto L21;
        JSONObject r3 = r1.optJSONObject("extra");     // Catch: JSONException -> L18
        if (r3 == null) goto L22;
        if (r3.optInt("is_default_title_from_cache", 0) != 1) goto L23;
        return true;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L24:
        return false;
    }

    public final boolean J0() {
        List<AuditInfo> r0 = this.auditInfoList;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        return !r1;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final String h() {
        com.bytedance.android.live.openplatform.api.utils.a r0 = com.bytedance.android.live.openplatform.api.utils.a.a;
        String r2 = null;
        boolean r3 = false;
        if (com.bytedance.android.live.openplatform.api.utils.a.a.c() == false) goto L22;
        ProductInfo r1 = this.productInfo;
        if (r1 == null) goto L7;
        String r4 = r1.imgUrl;
    L8:
        if (r4 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L22;
        ProductInfo r6 = this.productInfo;
        if (r6 == null) goto L61;
        String r7 = r6.imgUrl;
        if (r7 != null) goto L21;
        return "";
    L21:
        return r7;
    L61:
        return "";
    L10:
        if (StringsKt.isBlank(r4) == true) goto L13;
        r5 = false;
        goto L14
    L7:
        r4 = null;
    L22:
        int r8 = this.selectedCoverType;
        if (r8 != 1) goto L25;
        r2 = this.presetCardUrl;
    L35:
        if (r2 != null) goto L37;
    L40:
        boolean r9 = true;
    L41:
        if (r9 == false) goto L43;
        r2 = this.customizedCoverUrl;
    L43:
        if (r2 != null) goto L45;
    L48:
        boolean r10 = true;
    L49:
        if (r10 == false) goto L51;
        r2 = this.lastPassCoverUrl;
    L51:
        if (r2 != null) goto L53;
    L54:
        r3 = true;
    L55:
        if (r3 == false) goto L57;
        r2 = this.defaultCoverUrl;
    L57:
        if (r2 != null) goto L60;
        return "";
    L60:
        return r2;
    L53:
        if (StringsKt.isBlank(r2) == false) goto L55;
    L45:
        if (StringsKt.isBlank(r2) == true) goto L48;
        r10 = false;
        goto L49
    L37:
        if (StringsKt.isBlank(r2) == true) goto L40;
        r9 = false;
        goto L41
    L25:
        if (r8 != 2) goto L27;
        r2 = this.textPosterUrl;
        goto L35
    L27:
        if (r8 != 3) goto L29;
        r2 = this.screenshotUrl;
        goto L35
    L29:
        if (r8 != 4) goto L35;
        r2 = this.customizedCoverUrl;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v100 */
    /* JADX WARN: Type inference failed for: r0v101 */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v90 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r0 = this.cardId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.localCardId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r4 = this.schema;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.defaultTitle;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.defaultCoverUrl;
        if (r11 == null) goto L13;
        int r12 = r11.hashCode();
    L14:
        int r13 = (r10 + r12) * 31;
        String r14 = this.customizedTitle;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (r13 + r15) * 31;
        boolean r17 = this.isTitleChanged;
        ?? r18 = 1;
        ?? r19 = r17;
        if (r17 == false) goto L21;
        r19 = 1;
    L21:
        int r20 = (r16 + r19) * 31;
        String r21 = this.customizedCoverUrl;
        if (r21 == null) goto L24;
        int r22 = r21.hashCode();
    L25:
        int r23 = (r20 + r22) * 31;
        List<ImageModel> r24 = this.image;
        if (r24 == null) goto L28;
        int r25 = r24.hashCode();
    L29:
        int r26 = (r23 + r25) * 31;
        String r27 = this.sourcePage;
        if (r27 == null) goto L32;
        int r28 = r27.hashCode();
    L33:
        int r29 = (((r26 + r28) * 31) + this.reviewStatus) * 31;
        boolean r30 = this.fromReview;
        ?? r31 = r30;
        if (r30 == false) goto L36;
        r31 = 1;
    L36:
        int r32 = (r29 + r31) * 31;
        boolean r33 = this.canModifyCover;
        ?? r34 = r33;
        if (r33 == false) goto L39;
        r34 = 1;
    L39:
        long r35 = this.status;
        int r36 = (((r32 + r34) * 31) + ((int) (r35 ^ (r35 >>> 32)))) * 31;
        String r37 = this.logExtra;
        if (r37 == null) goto L42;
        int r38 = r37.hashCode();
    L43:
        int r39 = (((r36 + r38) * 31) + this.cardSource) * 31;
        String r40 = this.createInfo;
        if (r40 == null) goto L46;
        int r41 = r40.hashCode();
    L47:
        int r42 = (r39 + r41) * 31;
        String r43 = this.reviewResultReason;
        if (r43 == null) goto L50;
        int r44 = r43.hashCode();
    L51:
        int r45 = (((r42 + r44) * 31) + this.reviewTitleStatus) * 31;
        String r46 = this.reviewingTitle;
        if (r46 == null) goto L54;
        int r47 = r46.hashCode();
    L55:
        int r48 = (r45 + r47) * 31;
        String r49 = this.lastPassTitle;
        if (r49 == null) goto L58;
        int r50 = r49.hashCode();
    L59:
        int r51 = (r48 + r50) * 31;
        String r52 = this.lastPassCoverUrl;
        if (r52 == null) goto L62;
        int r53 = r52.hashCode();
    L63:
        int r54 = (r51 + r53) * 31;
        List<AuditInfo> r55 = this.auditInfoList;
        if (r55 == null) goto L66;
        int r56 = r55.hashCode();
    L67:
        int r57 = (r54 + r56) * 31;
        ProductInfo r58 = this.productInfo;
        if (r58 == null) goto L70;
        int r59 = r58.hashCode();
    L71:
        int r60 = (((((((r57 + r59) * 31) + this.priority) * 31) + this.topReason) * 31) + this.showDuration) * 31;
        boolean r61 = this.isLeadsComponent;
        if (r61 == true) goto L75;
        r18 = r61;
    L75:
        int r62 = (r60 + r18) * 31;
        String r63 = this.sellingPoint;
        if (r63 == null) goto L78;
        int r65 = r63.hashCode();
    L79:
        int r66 = (r62 + r65) * 31;
        String r67 = this.presetCardUrl;
        if (r67 == null) goto L82;
        int r68 = r67.hashCode();
    L83:
        int r69 = (r66 + r68) * 31;
        String r70 = this.textPosterUrl;
        if (r70 == null) goto L86;
        int r71 = r70.hashCode();
    L87:
        int r72 = (r69 + r71) * 31;
        String r73 = this.textPosterTitle;
        if (r73 == null) goto L90;
        int r74 = r73.hashCode();
    L91:
        int r75 = (r72 + r74) * 31;
        String r76 = this.screenshotUrl;
        if (r76 == null) goto L95;
        r5 = r76.hashCode();
    L95:
        return ((((r75 + r5) * 31) + this.selectedCoverType) * 31) + this.customizedCoverType;
    L90:
        r74 = 0;
        goto L91
    L86:
        r71 = 0;
        goto L87
    L82:
        r68 = 0;
        goto L83
    L78:
        r65 = 0;
        goto L79
    L70:
        r59 = 0;
        goto L71
    L66:
        r56 = 0;
        goto L67
    L62:
        r53 = 0;
        goto L63
    L58:
        r50 = 0;
        goto L59
    L54:
        r47 = 0;
        goto L55
    L50:
        r44 = 0;
        goto L51
    L46:
        r41 = 0;
        goto L47
    L42:
        r38 = 0;
        goto L43
    L32:
        r28 = 0;
        goto L33
    L28:
        r25 = 0;
        goto L29
    L24:
        r22 = 0;
        goto L25
    L17:
        r15 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "ShelfCardInfo(cardId=" + this.cardId + ", localCardId=" + this.localCardId + ", schema=" + this.schema + ", defaultTitle=" + this.defaultTitle + ", defaultCoverUrl=" + this.defaultCoverUrl + ", customizedTitle=" + this.customizedTitle + ", isTitleChanged=" + this.isTitleChanged + ", customizedCoverUrl=" + this.customizedCoverUrl + ", image=" + this.image + ", sourcePage=" + this.sourcePage + ", reviewStatus=" + this.reviewStatus + ", fromReview=" + this.fromReview + ", canModifyCover=" + this.canModifyCover + ", status=" + this.status + ", logExtra=" + this.logExtra + ", cardSource=" + this.cardSource + ", createInfo=" + this.createInfo + ", reviewResultReason=" + this.reviewResultReason + ", reviewTitleStatus=" + this.reviewTitleStatus + ", reviewingTitle=" + this.reviewingTitle + ", lastPassTitle=" + this.lastPassTitle + ", lastPassCoverUrl=" + this.lastPassCoverUrl + ", auditInfoList=" + this.auditInfoList + ", productInfo=" + this.productInfo + ", priority=" + this.priority + ", topReason=" + this.topReason + ", showDuration=" + this.showDuration + ", isLeadsComponent=" + this.isLeadsComponent + ", sellingPoint=" + this.sellingPoint + ", presetCardUrl=" + this.presetCardUrl + ", textPosterUrl=" + this.textPosterUrl + ", textPosterTitle=" + this.textPosterTitle + ", screenshotUrl=" + this.screenshotUrl + ", selectedCoverType=" + this.selectedCoverType + ", customizedCoverType=" + this.customizedCoverType + ")";
    }

    public final boolean v0() {
        ProductInfo r0 = this.productInfo;
        if (r0 == null) goto L5;
        String r2 = r0.productId;
    L7:
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if ((!r3) == true) goto L17;
        r0 = null;
    L17:
        if (r0 == null) goto L20;
        return true;
    L20:
        return false;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    public ShelfCardInfo() {
        this.cardId = 0;
        this.schema = null;
        this.defaultTitle = null;
        this.defaultCoverUrl = null;
        this.customizedTitle = null;
        this.customizedCoverUrl = null;
        this.image = null;
        this.sourcePage = null;
        this.reviewStatus = 0;
        this.fromReview = false;
        this.canModifyCover = true;
        this.status = 0;
        this.logExtra = null;
        this.cardSource = Source.Phone.getValue();
        this.createInfo = null;
        this.reviewResultReason = null;
        this.reviewTitleStatus = 0;
        this.reviewingTitle = null;
        this.lastPassTitle = null;
        this.lastPassCoverUrl = null;
        this.auditInfoList = null;
        this.productInfo = null;
        this.priority = 0;
        this.topReason = 0;
        this.showDuration = 0;
        this.isLeadsComponent = false;
        this.sellingPoint = null;
        this.presetCardUrl = null;
        this.textPosterUrl = null;
        this.textPosterTitle = null;
        this.screenshotUrl = null;
        this.selectedCoverType = 0;
        this.customizedCoverType = 0;
    }

    public final boolean F0() {
        if (J0() == false) goto L6;
        return d(1, 1);
    L6:
        return e(1, 1);
    }

    public final String W() {
        if (J0() == false) goto L24;
        StringBuilder r0 = new StringBuilder();
        List<AuditInfo> r1 = this.auditInfoList;
        if (r1 == null) goto L23;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L23;
        AuditInfo r4 = (AuditInfo) r2.next();
        if (r4.auditStatus != 2) goto L8;
        String r5 = r4.rejectReason;
        if (r2.a(r5) == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L8;
        if (r0.length() <= 0) goto L19;
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
        r0.append("，");
    L22:
        r0.append(r5);
        goto L8
    L19:
        r6 = false;
    L23:
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        return String.format(s1.B(2131921049), Arrays.copyOf(new Object[]{r0.toString()}, 1));
    L24:
        String r7 = this.reviewResultReason;
        if (r7 != null) goto L36;
        return "";
    L36:
        return r7;
    }

    public final boolean C0() {
        return this.isLeadsComponent;
    }

    public final String D() {
        return this.customizedCoverUrl;
    }

    public final String E() {
        return this.customizedTitle;
    }

    public final String F() {
        return this.defaultCoverUrl;
    }

    public final String I() {
        return this.defaultTitle;
    }

    public final boolean I0() {
        return this.isTitleChanged;
    }

    public final boolean K() {
        return this.fromReview;
    }

    public final List<ImageModel> L() {
        return this.image;
    }

    public final String M() {
        return this.lastPassCoverUrl;
    }

    public final String N() {
        return this.lastPassTitle;
    }

    public final long O() {
        return this.localCardId;
    }

    public final String R() {
        return this.logExtra;
    }

    public final String S() {
        return this.presetCardUrl;
    }

    public final int U() {
        return this.priority;
    }

    public final String Y() {
        return this.reviewResultReason;
    }

    public final String Z() {
        return this.reviewingTitle;
    }

    public final String a0() {
        return this.schema;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final String b() {
        return this.sellingPoint;
    }

    public final String b0() {
        return this.screenshotUrl;
    }

    public final int c0() {
        return this.selectedCoverType;
    }

    public final int f0() {
        return this.showDuration;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getCardId() {
        return this.cardId;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final ProductInfo getProductInfo() {
        return this.productInfo;
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final long getStatus() {
        return this.status;
    }

    public final String i0() {
        return this.sourcePage;
    }

    public final String j0() {
        return this.textPosterTitle;
    }

    public final String o0() {
        return this.textPosterUrl;
    }

    public final int p0() {
        return this.topReason;
    }

    public final List<AuditInfo> q() {
        return this.auditInfoList;
    }

    public final boolean r() {
        return this.canModifyCover;
    }

    public final int s() {
        return this.cardSource;
    }

    public final String t() {
        return this.createInfo;
    }

    public final int z() {
        return this.customizedCoverType;
    }

    public ShelfCardInfo(am3.g r7) {
        this.image = new ArrayList();
        this.auditInfoList = new ArrayList();
        long r0 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L46;
        if (r4 == 95) goto L45;
        if (r4 != 96) goto L9;
        this.logExtra = am3.h.c(r7);
        goto L3
    L9:
        switch(r4) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            case 14: goto L29;
            case 15: goto L28;
            case 16: goto L27;
            case 17: goto L26;
            case 18: goto L25;
            case 19: goto L24;
            case 20: goto L23;
            case 21: goto L22;
            case 22: goto L21;
            case 23: goto L20;
            case 24: goto L19;
            default: goto L10;
        };
    L19:
        this.isLeadsComponent = am3.h.a(r7);
        r3 = r3 | 1024;
        goto L3
    L20:
        this.showDuration = r7.i();
        r3 = r3 | 512;
        goto L3
    L21:
        this.topReason = r7.i();
        r3 = r3 | 256;
        goto L3
    L22:
        this.priority = r7.i();
        r3 = r3 | 128;
        goto L3
    L23:
        this.productInfo = new ProductInfo(r7);
        goto L3
    L24:
        this.lastPassCoverUrl = am3.h.c(r7);
        goto L3
    L25:
        this.lastPassTitle = am3.h.c(r7);
        goto L3
    L26:
        this.reviewingTitle = am3.h.c(r7);
        goto L3
    L27:
        this.reviewTitleStatus = r7.i();
        r3 = r3 | 64;
        goto L3
    L28:
        this.reviewResultReason = am3.h.c(r7);
        goto L3
    L29:
        this.createInfo = am3.h.c(r7);
        goto L3
    L30:
        this.cardSource = r7.i();
        r3 = r3 | 32;
        goto L3
    L31:
        this.status = r7.j();
        r3 = r3 | 16;
        goto L3
    L32:
        this.canModifyCover = am3.h.a(r7);
        r3 = r3 | 8;
        goto L3
    L33:
        this.fromReview = am3.h.a(r7);
        r3 = r3 | 4;
        goto L3
    L34:
        this.reviewStatus = r7.i();
        r3 = r3 | 2;
        goto L3
    L35:
        this.sourcePage = am3.h.c(r7);
        goto L3
    L36:
        List<ImageModel> r5 = this.image;
        ImageModel r6 = x.a(r7);
    L37:
        r5.add(r6);
        goto L3
    L38:
        this.customizedCoverUrl = am3.h.c(r7);
        goto L3
    L39:
        this.customizedTitle = am3.h.c(r7);
        goto L3
    L40:
        this.defaultCoverUrl = am3.h.c(r7);
        goto L3
    L41:
        this.defaultTitle = am3.h.c(r7);
        goto L3
    L42:
        this.schema = am3.h.c(r7);
        goto L3
    L43:
        this.cardId = r7.j();
        r3 = r3 | 1;
        goto L3
    L10:
        switch(r4) {
            case 26: goto L18;
            case 27: goto L17;
            case 28: goto L16;
            case 29: goto L15;
            case 30: goto L14;
            case 31: goto L13;
            case 32: goto L12;
            default: goto L11;
        };
    L12:
        this.selectedCoverType = r7.i();
        r3 = r3 | 2048;
        goto L3
    L13:
        this.customizedCoverType = r7.i();
        r3 = r3 | 4096;
        goto L3
    L14:
        this.presetCardUrl = am3.h.c(r7);
        goto L3
    L15:
        this.screenshotUrl = am3.h.c(r7);
        goto L3
    L16:
        this.textPosterTitle = am3.h.c(r7);
        goto L3
    L17:
        this.textPosterUrl = am3.h.c(r7);
        goto L3
    L18:
        this.sellingPoint = am3.h.c(r7);
        goto L3
    L11:
        am3.h.e(r7);
        goto L3
    L45:
        r5 = this.auditInfoList;
        r6 = new AuditInfo(r7);
        goto L37
    L46:
        r7.d(r0);
        if ((r3 & 1) != 0) goto L50;
        this.cardId = 0;
    L50:
        if (this.schema != null) goto L53;
        this.schema = null;
    L53:
        if (this.defaultTitle != null) goto L56;
        this.defaultTitle = null;
    L56:
        if (this.defaultCoverUrl != null) goto L59;
        this.defaultCoverUrl = null;
    L59:
        if (this.customizedTitle != null) goto L62;
        this.customizedTitle = null;
    L62:
        if (this.customizedCoverUrl != null) goto L65;
        this.customizedCoverUrl = null;
    L65:
        if (this.image.isEmpty() == false) goto L68;
        this.image = null;
    L68:
        if (this.sourcePage != null) goto L71;
        this.sourcePage = null;
    L71:
        if ((r3 & 2) != 0) goto L74;
        this.reviewStatus = 0;
    L74:
        if ((r3 & 4) != 0) goto L77;
        this.fromReview = false;
    L77:
        if ((r3 & 8) != 0) goto L80;
        this.canModifyCover = true;
    L80:
        if ((r3 & 16) != 0) goto L83;
        this.status = 0;
    L83:
        if (this.logExtra != null) goto L86;
        this.logExtra = null;
    L86:
        if ((r3 & 32) != 0) goto L89;
        this.cardSource = Source.Phone.getValue();
    L89:
        if (this.createInfo != null) goto L92;
        this.createInfo = null;
    L92:
        if (this.reviewResultReason != null) goto L95;
        this.reviewResultReason = null;
    L95:
        if ((r3 & 64) != 0) goto L98;
        this.reviewTitleStatus = 0;
    L98:
        if (this.reviewingTitle != null) goto L101;
        this.reviewingTitle = null;
    L101:
        if (this.lastPassTitle != null) goto L104;
        this.lastPassTitle = null;
    L104:
        if (this.lastPassCoverUrl != null) goto L107;
        this.lastPassCoverUrl = null;
    L107:
        if (this.auditInfoList.isEmpty() == false) goto L110;
        this.auditInfoList = null;
    L110:
        if (this.productInfo != null) goto L113;
        this.productInfo = null;
    L113:
        if ((r3 & 128) != 0) goto L116;
        this.priority = 0;
    L116:
        if ((r3 & 256) != 0) goto L119;
        this.topReason = 0;
    L119:
        if ((r3 & 512) != 0) goto L122;
        this.showDuration = 0;
    L122:
        if ((r3 & 1024) != 0) goto L125;
        this.isLeadsComponent = false;
    L125:
        if (this.sellingPoint != null) goto L128;
        this.sellingPoint = null;
    L128:
        if (this.presetCardUrl != null) goto L131;
        this.presetCardUrl = null;
    L131:
        if (this.textPosterUrl != null) goto L134;
        this.textPosterUrl = null;
    L134:
        if (this.textPosterTitle != null) goto L137;
        this.textPosterTitle = null;
    L137:
        if (this.screenshotUrl != null) goto L140;
        this.screenshotUrl = null;
    L140:
        if ((r3 & 2048) != 0) goto L143;
        this.selectedCoverType = 0;
    L143:
        if ((r3 & 4096) != 0) goto L217;
        this.customizedCoverType = 0;
        return;
    }

    public final boolean G0(int r3) {
        if (J0() == false) goto L6;
        return d(r3, 2);
    L6:
        return e(r3, 2);
    }

    public final boolean H0(int r2) {
        if (J0() == false) goto L6;
        return d(r2, 3);
    L6:
        return e(r2, 5);
    }

    public final Pair<Integer, String> J(String r3) {
        String r0 = this.customizedTitle;
        if (r0 != null) goto L5;
    L8:
        String r1 = this.defaultTitle;
        if (r1 == null) goto L12;
        r3 = r1;
    L12:
        if (r3 != null) goto L15;
        r3 = "小程序";
    L15:
        return TuplesKt.to(1, r3);
    L5:
        if ((!StringsKt.isBlank(r0)) != true) goto L8;
        return TuplesKt.to(2, this.customizedTitle);
    }

    @Override // com.bytedance.android.live.openplatform.api.model.shelf.a
    public final Pair<Integer, String> a(String r2) {
        com.bytedance.android.live.openplatform.api.utils.b r0 = com.bytedance.android.live.openplatform.api.utils.b.b;
        if (com.bytedance.android.live.openplatform.api.utils.b.b.f() == false) goto L22;
        ProductInfo r1 = this.productInfo;
        if (r1 == null) goto L7;
        String r3 = r1.title;
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L22;
        ProductInfo r5 = this.productInfo;
        if (r5 == null) goto L19;
        String r6 = r5.title;
        if (r6 == null) goto L19;
    L23:
        return TuplesKt.to(4, r6);
    L19:
        r6 = "";
        goto L23
    L10:
        if (StringsKt.isBlank(r3) == true) goto L13;
        r4 = false;
        goto L14
    L7:
        r3 = null;
    L22:
        return J(r2);
    }

    public final boolean c(boolean r3) {
        String r0 = this.sellingPoint;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        if (r3 == false) goto L14;
        return ((uc1) ee0.a.getValue()).s();
    L14:
        return ((uc1) ee0.a.getValue()).e();
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof ShelfCardInfo) == false) goto L76;
        ShelfCardInfo r7 = (ShelfCardInfo) r6;
        if (this.cardId == r7.cardId) goto L8;
        return false;
    L8:
        if (this.localCardId == r7.localCardId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r7.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultTitle, r7.defaultTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.defaultCoverUrl, r7.defaultCoverUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.customizedTitle, r7.customizedTitle) == true) goto L18;
        return false;
    L18:
        if (this.isTitleChanged == r7.isTitleChanged) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.customizedCoverUrl, r7.customizedCoverUrl) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.image, r7.image) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sourcePage, r7.sourcePage) == true) goto L26;
        return false;
    L26:
        if (this.reviewStatus == r7.reviewStatus) goto L28;
        return false;
    L28:
        if (this.fromReview == r7.fromReview) goto L30;
        return false;
    L30:
        if (this.canModifyCover == r7.canModifyCover) goto L32;
        return false;
    L32:
        if (this.status == r7.status) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.logExtra, r7.logExtra) == true) goto L36;
        return false;
    L36:
        if (this.cardSource == r7.cardSource) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.createInfo, r7.createInfo) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.reviewResultReason, r7.reviewResultReason) == true) goto L42;
        return false;
    L42:
        if (this.reviewTitleStatus == r7.reviewTitleStatus) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.reviewingTitle, r7.reviewingTitle) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.lastPassTitle, r7.lastPassTitle) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.lastPassCoverUrl, r7.lastPassCoverUrl) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.auditInfoList, r7.auditInfoList) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.productInfo, r7.productInfo) == true) goto L54;
        return false;
    L54:
        if (this.priority == r7.priority) goto L56;
        return false;
    L56:
        if (this.topReason == r7.topReason) goto L58;
        return false;
    L58:
        if (this.showDuration == r7.showDuration) goto L60;
        return false;
    L60:
        if (this.isLeadsComponent == r7.isLeadsComponent) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.sellingPoint, r7.sellingPoint) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.presetCardUrl, r7.presetCardUrl) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.textPosterUrl, r7.textPosterUrl) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.textPosterTitle, r7.textPosterTitle) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.screenshotUrl, r7.screenshotUrl) == true) goto L72;
        return false;
    L72:
        if (this.selectedCoverType == r7.selectedCoverType) goto L74;
        return false;
    L74:
        if (this.customizedCoverType == r7.customizedCoverType) goto L115;
        return false;
    L115:
        return true;
    L76:
        return false;
    }

    public final String i(String r4) {
        com.bytedance.android.live.openplatform.api.utils.a r0 = com.bytedance.android.live.openplatform.api.utils.a.a;
        boolean r1 = false;
        if (com.bytedance.android.live.openplatform.api.utils.a.a.f() == false) goto L20;
        ProductInfo r2 = this.productInfo;
        if (r2 == null) goto L7;
        String r3 = r2.title;
    L8:
        if (r3 != null) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == true) goto L20;
        ProductInfo r6 = this.productInfo;
        if (r6 == null) goto L19;
        String r7 = r6.title;
        if (r7 == null) goto L19;
        return r7;
    L19:
        return "";
    L10:
        if (StringsKt.isBlank(r3) == true) goto L13;
        r5 = false;
        goto L14
    L7:
        r3 = null;
    L20:
        String r8 = this.reviewingTitle;
        if (r8 != null) goto L23;
    L24:
        r1 = true;
    L25:
        if (r1 == true) goto L30;
        if (this.reviewTitleStatus != 5) goto L30;
        return this.reviewingTitle;
    L30:
        return (String) J(r4).getSecond();
    L23:
        if (StringsKt.isBlank(r8) == false) goto L25;
        goto L24
    }

    public final String j(boolean r1) {
        String r2 = (String) o(r1).getSecond();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public final String k(String r1) {
        return (String) a(r1).getSecond();
    }

    public final Pair<Integer, String> o(boolean r8) {
        String r2 = null;
        if (com.bytedance.android.live.openplatform.api.utils.b.b.c() == false) goto L22;
        ProductInfo r0 = this.productInfo;
        if (r0 == null) goto L7;
        String r1 = r0.imgUrl;
    L8:
        if (r1 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L22;
        ProductInfo r4 = this.productInfo;
        if (r4 == null) goto L19;
        String r5 = r4.imgUrl;
        if (r5 == null) goto L19;
    L21:
        return TuplesKt.to(-1, r5);
    L19:
        r5 = "";
        goto L21
    L10:
        if (StringsKt.isBlank(r1) == true) goto L13;
        r3 = false;
        goto L14
    L7:
        r1 = null;
    L22:
        int r6 = this.selectedCoverType;
        if (r6 != 1) goto L25;
        Pair<Integer, String> r9 = TuplesKt.to(1, this.presetCardUrl);
    L48:
        if (r9 != null) goto L50;
    L54:
        List<ImageModel> r7 = this.image;
        if (r7 == null) goto L62;
        ImageModel r10 = (ImageModel) CollectionsKt.firstOrNull(r7);
        if (r10 == null) goto L62;
        List r11 = r10.getUrls();
        if (r11 == null) goto L62;
        r2 = (String) CollectionsKt.firstOrNull(r11);
    L62:
        return TuplesKt.to(0, r2);
    L50:
        if (r2.a((String) r9.getSecond()) == true) goto L53;
        r9 = null;
    L53:
        if (r9 == null) goto L54;
        return r9;
    L25:
        if (r6 == 2) goto L36;
        if (r6 != 3) goto L28;
        r9 = TuplesKt.to(3, this.screenshotUrl);
        goto L48
    L28:
        if (r6 == 4) goto L31;
        r9 = null;
        goto L48
    L31:
        if (F0() == false) goto L33;
        String r12 = this.customizedCoverUrl;
    L34:
        r9 = TuplesKt.to(4, r12);
        goto L48
    L33:
        r12 = this.lastPassCoverUrl;
        goto L34
    L36:
        if (r8 == true) goto L38;
    L39:
        if (r8 == true) goto L44;
        if (((vc1) d90.a.getValue()).b() != 1) goto L44;
    L42:
        r9 = TuplesKt.to(2, this.textPosterUrl);
    L44:
        if (r2.a(this.presetCardUrl) == false) goto L46;
        r9 = TuplesKt.to(1, this.presetCardUrl);
        goto L48
    L46:
        r9 = TuplesKt.to(3, this.screenshotUrl);
        goto L48
    L38:
        if (((uc1) ee0.a.getValue()).h() == true) goto L42;
        goto L39
    }

    public final boolean d(int r7, int r8) {
        Object r1 = null;
        if (r7 != (-1)) goto L18;
        List<AuditInfo> r9 = this.auditInfoList;
        if (r9 == null) goto L16;
        Iterator<T> r10 = r9.iterator();
    L8:
        if (r10.hasNext() == false) goto L15;
        Object r0 = r10.next();
        if (((AuditInfo) r0).auditStatus != r8) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
        r1 = r0;
        goto L15
    L12:
        r4 = false;
    L15:
        r1 = (AuditInfo) r1;
    L16:
        if (r1 != null) goto L46;
    L34:
        return false;
    L46:
        return true;
    L18:
        List<AuditInfo> r2 = this.auditInfoList;
        if (r2 == null) goto L34;
        Iterator<T> r3 = r2.iterator();
    L22:
        if (r3.hasNext() == false) goto L29;
        Object r5 = r3.next();
        if (((AuditInfo) r5).auditType != r7) goto L26;
        boolean r6 = true;
    L27:
        if (r6 == false) goto L22;
        r1 = r5;
        goto L29
    L26:
        r6 = false;
    L29:
        AuditInfo r11 = (AuditInfo) r1;
        if (r11 == null) goto L34;
        if (r11.auditStatus != r8) goto L34;
        return true;
    }

    public final boolean e(int r4, int r5) {
        if (r4 == (-1)) goto L5;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L14;
        return false;
    L14:
        if (this.reviewTitleStatus != r5) goto L21;
    L8:
        return true;
    L21:
        return false;
    L17:
        if (this.reviewStatus == r5) goto L8;
        return false;
    L5:
        if (this.reviewStatus == r5) goto L8;
        if (this.reviewTitleStatus == r5) goto L8;
        return false;
    }

    public /* synthetic */ ShelfCardInfo(String r44, String r45, String r46, String r47, String r48, String r49, boolean r50, long r51, int r53, String r54, String r55, ProductInfo r56, String r57, String r58, String r59, String r60, String r61, int r62, int r63, int r65, int r66) {
        if ((r65 & 2) == 0) goto L5;
        long r6 = d.a.getAndIncrement();
    L7:
        if ((r65 & 4) == 0) goto L9;
        String r9 = null;
    L11:
        if ((r65 & 8) == 0) goto L13;
        String r10 = null;
    L15:
        if ((r65 & 16) == 0) goto L17;
        String r11 = null;
    L19:
        if ((r65 & 32) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r65 & 128) == 0) goto L25;
        String r14 = null;
    L27:
        if ((r65 & 512) == 0) goto L29;
        String r16 = null;
    L31:
        if ((r65 & 4096) == 0) goto L33;
        boolean r19 = true;
    L35:
        if ((r65 & 8192) == 0) goto L37;
        long r20 = 0;
    L39:
        if ((32768 & r65) == 0) goto L41;
        int r23 = Source.Phone.getValue();
    L43:
        if ((65536 & r65) == 0) goto L45;
        String r24 = null;
    L47:
        if ((2097152 & r65) == 0) goto L49;
        String r29 = null;
    L51:
        if ((8388608 & r65) == 0) goto L53;
        ProductInfo r31 = null;
    L55:
        if ((268435456 & r65) == 0) goto L57;
        String r36 = null;
    L59:
        if ((536870912 & r65) == 0) goto L61;
        String r37 = null;
    L63:
        if ((1073741824 & r65) == 0) goto L65;
        String r38 = null;
    L67:
        if ((r65 & ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION) == 0) goto L69;
        String r39 = null;
    L71:
        if ((r66 & 1) == 0) goto L73;
        String r40 = null;
    L75:
        if ((r66 & 2) == 0) goto L77;
        int r41 = 0;
    L79:
        if ((r66 & 4) == 0) goto L81;
        int r42 = 0;
    L82:
        this(0, r6, r9, r10, r11, r12, false, r14, null, r16, 0, false, r19, r20, null, r23, r24, null, 0, null, null, r29, null, r31, 0, 0, 0, false, r36, r37, r38, r39, r40, r41, r42);
        return;
    L81:
        r42 = r63;
        goto L82
    L77:
        r41 = r62;
        goto L79
    L73:
        r40 = r61;
        goto L75
    L69:
        r39 = r60;
        goto L71
    L65:
        r38 = r59;
        goto L67
    L61:
        r37 = r58;
        goto L63
    L57:
        r36 = r57;
        goto L59
    L53:
        r31 = r56;
        goto L55
    L49:
        r29 = r55;
        goto L51
    L45:
        r24 = r54;
        goto L47
    L41:
        r23 = r53;
        goto L43
    L37:
        r20 = r51;
        goto L39
    L33:
        r19 = r50;
        goto L35
    L29:
        r16 = r49;
        goto L31
    L25:
        r14 = r48;
        goto L27
    L21:
        r12 = r47;
        goto L23
    L17:
        r11 = r46;
        goto L19
    L13:
        r10 = r45;
        goto L15
    L9:
        r9 = r44;
        goto L11
    L5:
        r6 = 0;
        goto L7
    }

    public static ShelfCardInfo g(ShelfCardInfo r46, String r47, String r48, String r49, String r50, boolean r51, String r52, long r53, int r55, String r56, List r57, ProductInfo r58, int r59, String r60, String r61, String r62, String r63, String r65, int r66, int r67, int r68, int r69) {
        long r3 = 0;
        if ((r68 & 1) == 0) goto L5;
        long r8 = r46.cardId;
    L7:
        if ((r68 & 2) == 0) goto L9;
        r3 = r46.localCardId;
    L9:
        long r10 = r3;
        if ((r68 & 4) == 0) goto L12;
        String r12 = r46.schema;
    L14:
        if ((r68 & 8) == 0) goto L16;
        String r13 = r46.defaultTitle;
    L18:
        if ((r68 & 16) == 0) goto L20;
        String r14 = r46.defaultCoverUrl;
    L22:
        if ((r68 & 32) == 0) goto L24;
        String r15 = r46.customizedTitle;
    L26:
        if ((r68 & 64) == 0) goto L28;
        boolean r16 = r46.isTitleChanged;
    L30:
        if ((r68 & 128) == 0) goto L32;
        String r17 = r46.customizedCoverUrl;
    L34:
        if ((r68 & 256) == 0) goto L36;
        List<ImageModel> r18 = r46.image;
    L38:
        if ((r68 & 512) == 0) goto L40;
        String r19 = r46.sourcePage;
    L42:
        if ((r68 & 1024) == 0) goto L44;
        int r20 = r46.reviewStatus;
    L46:
        if ((r68 & 2048) == 0) goto L48;
        boolean r21 = r46.fromReview;
    L50:
        if ((r68 & 4096) == 0) goto L52;
        boolean r22 = r46.canModifyCover;
    L54:
        if ((r68 & 8192) == 0) goto L56;
        long r23 = r46.status;
    L58:
        if ((r68 & 16384) == 0) goto L60;
        String r25 = r46.logExtra;
    L62:
        if ((32768 & r68) == 0) goto L64;
        int r26 = r46.cardSource;
    L66:
        if ((65536 & r68) == 0) goto L68;
        String r27 = r46.createInfo;
    L70:
        if ((131072 & r68) == 0) goto L72;
        String r28 = r46.reviewResultReason;
    L74:
        if ((262144 & r68) == 0) goto L76;
        int r29 = r46.reviewTitleStatus;
    L78:
        if ((524288 & r68) == 0) goto L80;
        String r30 = r46.reviewingTitle;
    L82:
        if ((1048576 & r68) == 0) goto L84;
        String r31 = r46.lastPassTitle;
    L86:
        if ((2097152 & r68) == 0) goto L88;
        String r32 = r46.lastPassCoverUrl;
    L90:
        if ((4194304 & r68) == 0) goto L92;
        List r33 = r46.auditInfoList;
    L94:
        if ((8388608 & r68) == 0) goto L96;
        ProductInfo r34 = r46.productInfo;
    L98:
        if ((16777216 & r68) == 0) goto L100;
        int r35 = r46.priority;
    L102:
        if ((33554432 & r68) == 0) goto L104;
        int r36 = r46.topReason;
    L106:
        if ((67108864 & r68) == 0) goto L108;
        int r37 = r46.showDuration;
    L110:
        if ((134217728 & r68) == 0) goto L112;
        boolean r38 = r46.isLeadsComponent;
    L114:
        if ((268435456 & r68) == 0) goto L116;
        String r39 = r46.sellingPoint;
    L118:
        if ((536870912 & r68) == 0) goto L120;
        String r40 = r46.presetCardUrl;
    L122:
        if ((1073741824 & r68) == 0) goto L124;
        String r41 = r46.textPosterUrl;
    L126:
        if ((r68 & ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION) == 0) goto L128;
        String r42 = r46.textPosterTitle;
    L130:
        if ((r69 & 1) == 0) goto L132;
        String r43 = r46.screenshotUrl;
    L134:
        if ((r69 & 2) == 0) goto L136;
        int r44 = r46.selectedCoverType;
    L138:
        if ((r69 & 4) == 0) goto L140;
        int r45 = r46.customizedCoverType;
    L141:
        r46.getClass();
        return new ShelfCardInfo(r8, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45);
    L140:
        r45 = r67;
        goto L141
    L136:
        r44 = r66;
        goto L138
    L132:
        r43 = r65;
        goto L134
    L128:
        r42 = r63;
        goto L130
    L124:
        r41 = r62;
        goto L126
    L120:
        r40 = r61;
        goto L122
    L116:
        r39 = r60;
        goto L118
    L112:
        r38 = false;
        goto L114
    L108:
        r37 = 0;
        goto L110
    L104:
        r36 = r59;
        goto L106
    L100:
        r35 = 0;
        goto L102
    L96:
        r34 = r58;
        goto L98
    L92:
        r33 = r57;
        goto L94
    L88:
        r32 = null;
        goto L90
    L84:
        r31 = null;
        goto L86
    L80:
        r30 = null;
        goto L82
    L76:
        r29 = 0;
        goto L78
    L72:
        r28 = null;
        goto L74
    L68:
        r27 = r56;
        goto L70
    L64:
        r26 = r55;
        goto L66
    L60:
        r25 = null;
        goto L62
    L56:
        r23 = r53;
        goto L58
    L52:
        r22 = false;
        goto L54
    L48:
        r21 = false;
        goto L50
    L44:
        r20 = 0;
        goto L46
    L40:
        r19 = null;
        goto L42
    L36:
        r18 = null;
        goto L38
    L32:
        r17 = r52;
        goto L34
    L28:
        r16 = r51;
        goto L30
    L24:
        r15 = r50;
        goto L26
    L20:
        r14 = r49;
        goto L22
    L16:
        r13 = r48;
        goto L18
    L12:
        r12 = r47;
        goto L14
    L5:
        r8 = 0;
        goto L7
    }
}
