package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.l;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import tf0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/GiftIconElementInfo;", "Ltf0/d;", "", "score", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "", "targetScore", "J", "getTargetScore", "()J", "iconUrl", "getIconUrl", "backgroundColor", "getBackgroundColor", "", "styleType", "I", "getStyleType", "()I", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "quickInteract", "Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "g", "()Lcom/bytedance/android/live/liveinteract/plantform/model/l;", "setQuickInteract", "(Lcom/bytedance/android/live/liveinteract/plantform/model/l;)V", "StyleType", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftIconElementInfo extends d {

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("quick_interact")
    private l quickInteract;

    @SerializedName("score")
    private final String score;

    @SerializedName("style_type")
    private final int styleType;

    @SerializedName("target_score")
    private final long targetScore;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/GiftIconElementInfo$StyleType;", "", "Companion", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface StyleType {
        public static final a Companion = null;
        public static final int STYLE_TYPE_GUEST_BATTLE = 1;
        public static final int STYLE_TYPE_NORMAL = 0;
        public static final int STYLE_TYPE_NO_ICON = 3;
        public static final int STYLE_TYPE_ORDER_SONG_AVATAR = 4;
        public static final int STYLE_TYPE_STAR_WISH = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            public a() {
            }

            static {
                a = new a();
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Override // tf0.d
    public final String toString() {
        return super.toString() + ", score = " + this.score + ", iconUrl = " + this.iconUrl + ", backgroundColor = " + this.backgroundColor + ", styleType = " + this.styleType;
    }

    public final l g() {
        return this.quickInteract;
    }

    public final String h() {
        return this.score;
    }

    @Override // tf0.d
    public final boolean e(d r9) {
        if (super.e(r9) == true) goto L6;
        return false;
    L6:
        if (this != r9) goto L8;
        return true;
    L8:
        if (r9 != null) goto L10;
        return false;
    L10:
        if ((!Intrinsics.areEqual(GiftIconElementInfo.class, r9.getClass())) == true) goto L80;
        GiftIconElementInfo r10 = (GiftIconElementInfo) r9;
        l r2 = this.quickInteract;
        String r3 = null;
        if (r2 == null) goto L17;
        IBaseUser r4 = r2.getSendGiftUser();
        if (r4 == null) goto L17;
        String r5 = r4.getIdString();
    L18:
        l r6 = r10.quickInteract;
        if (r6 == null) goto L23;
        IBaseUser r7 = r6.getSendGiftUser();
        if (r7 == null) goto L23;
        String r8 = r7.getIdString();
    L25:
        if (Intrinsics.areEqual(r5, r8) == false) goto L56;
        l r11 = this.quickInteract;
        if (r11 == null) goto L29;
        Long r12 = Long.valueOf(r11.getInteractCarouselDuration());
    L30:
        l r13 = r10.quickInteract;
        if (r13 == null) goto L33;
        Long r14 = Long.valueOf(r13.getInteractCarouselDuration());
    L35:
        if (Intrinsics.areEqual(r12, r14) == false) goto L56;
        l r15 = this.quickInteract;
        if (r15 == null) goto L39;
        CharSequence r16 = r15.getInteractContent();
    L40:
        l r17 = r10.quickInteract;
        if (r17 == null) goto L43;
        CharSequence r18 = r17.getInteractContent();
    L45:
        if (Intrinsics.areEqual(r16, r18) == false) goto L56;
        l r19 = this.quickInteract;
        if (r19 == null) goto L49;
        String r20 = r19.getToUsedID();
    L50:
        l r21 = r10.quickInteract;
        if (r21 == null) goto L54;
        r3 = r21.getToUsedID();
    L54:
        if (Intrinsics.areEqual(r20, r3) == false) goto L56;
        boolean r22 = true;
    L58:
        if (Intrinsics.areEqual(this.score, r10.score) == true) goto L60;
        return false;
    L60:
        if (this.targetScore == r10.targetScore) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.iconUrl, r10.iconUrl) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.backgroundColor, r10.backgroundColor) == true) goto L66;
        return false;
    L66:
        if (this.styleType == r10.styleType) goto L68;
        return false;
    L68:
        if (this.targetScore != r10.targetScore) goto L78;
        if (r22 == false) goto L79;
        return true;
    L79:
        return false;
    L78:
        return false;
    L49:
        r20 = null;
        goto L50
    L43:
        r18 = null;
        goto L45
    L39:
        r16 = null;
        goto L40
    L33:
        r14 = null;
        goto L35
    L29:
        r12 = null;
    L56:
        r22 = false;
    L23:
        r8 = null;
    L17:
        r5 = null;
        goto L18
    L80:
        return false;
    }
}
