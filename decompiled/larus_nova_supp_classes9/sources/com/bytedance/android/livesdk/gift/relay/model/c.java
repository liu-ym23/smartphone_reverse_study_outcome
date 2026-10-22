package com.bytedance.android.livesdk.gift.relay.model;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.FreeCellInfoItem")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/gift/relay/model/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mDetailUrl", "Ljava/lang/String;", "getMDetailUrl", "()Ljava/lang/String;", "setMDetailUrl", "(Ljava/lang/String;)V", "mRankListUrl", "getMRankListUrl", "setMRankListUrl", BuildConfig.FLAVOR, "mGiftId", "J", "getMGiftId", "()J", "setMGiftId", "(J)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/relay/model/c$a;", "mRules", "Ljava/util/List;", "getMRules", "()Ljava/util/List;", "setMRules", "(Ljava/util/List;)V", "mText", "getMText", "setMText", "<init>", "()V", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("detail_url")
    protected String mDetailUrl;

    @SerializedName("gift_id")
    protected long mGiftId;

    @SerializedName("rank_list_url")
    protected String mRankListUrl;

    @SerializedName("rules")
    protected List<a> mRules;

    @SerializedName("text")
    protected String mText;

    @ProtoMessage("webcast.api.gift.FreeCellRuleItem")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/gift/relay/model/c$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mGapDesc", "Ljava/lang/String;", "getMGapDesc", "()Ljava/lang/String;", "setMGapDesc", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "mGroup", "I", "getMGroup", "()I", "setMGroup", "(I)V", "mId", "getMId", "setMId", "Lcom/bytedance/android/live/base/model/ImageModel;", "mGiftIcon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getMGiftIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setMGiftIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "mDescIcon", "getMDescIcon", "setMDescIcon", "mGiftLabelIcon", "getMGiftLabelIcon", "setMGiftLabelIcon", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a implements h {

        @SerializedName("desc_icon")
        protected ImageModel mDescIcon;

        @SerializedName("gap_desc")
        protected String mGapDesc;

        @SerializedName("image")
        protected ImageModel mGiftIcon;

        @SerializedName("gift_label_icon")
        protected ImageModel mGiftLabelIcon;

        @SerializedName("group")
        protected int mGroup;

        @SerializedName("id")
        protected int mId;

        public a() {
        }

        public a(g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L13;
            switch(r2) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            this.mGiftLabelIcon = x.a(r5);
            goto L3
        L8:
            this.mGroup = (int) r5.j();
            goto L3
        L9:
            this.mDescIcon = x.a(r5);
            goto L3
        L10:
            this.mGapDesc = am3.h.c(r5);
            goto L3
        L11:
            this.mGiftIcon = x.a(r5);
            goto L3
        L12:
            this.mId = (int) r5.j();
            goto L3
        L6:
            am3.h.e(r5);
            goto L3
        L13:
            r5.d(r0);
        }
    }

    public c() {
    }

    public c(g r5) {
        this.mRules = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.mGiftId = r5.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.mRules.add(new a(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.mText = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 6) goto L14;
        this.mDetailUrl = am3.h.c(r5);
        goto L3
    L14:
        if (r2 != 7) goto L15;
        this.mRankListUrl = am3.h.c(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
    }
}
