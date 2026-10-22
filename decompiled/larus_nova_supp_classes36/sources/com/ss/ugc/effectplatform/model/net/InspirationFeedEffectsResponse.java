package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.AuthorModel;
import com.ss.ugc.effectplatform.model.AuthorThumbModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.InspirationFeedEffectModel;
import com.ss.ugc.effectplatform.model.InspirationModel;
import com.ss.ugc.effectplatform.model.MaterialModel;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.model.VideoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0081\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0005¢\u0006\u0004\b/\u00100J\u001d\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0005HÂ\u0003J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u000f\u001a\u00020\nHÆ\u0003J\t\u0010\u0010\u001a\u00020\nHÆ\u0003JY\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0005HÆ\u0001J\t\u0010\u0017\u001a\u00020\bHÖ\u0001J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R*\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010.¨\u00061"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/InspirationFeedEffectsResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "", "Lcom/ss/ugc/effectplatform/model/Effect;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "component5", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "Lcom/ss/ugc/effectplatform/model/InspirationFeedEffectModel;", "component1", "component2", "component3", "component4", "inspiration_awemes", INotificationHitPoint.NoticeType.MESSAGE, "status_code", "has_more", "effectList", "copy", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "", "equals", "Ljava/util/List;", "getInspiration_awemes", "()Ljava/util/List;", "setInspiration_awemes", "(Ljava/util/List;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "getHas_more", "setHas_more", "Ljava/util/ArrayList;", "<init>", "(Ljava/util/List;Ljava/lang/String;IILjava/util/ArrayList;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class InspirationFeedEffectsResponse extends e<List<? extends Effect>> {
    private ArrayList<Effect> effectList;
    private int has_more;
    private List<InspirationFeedEffectModel> inspiration_awemes;
    private String message;
    private int status_code;

    public InspirationFeedEffectsResponse() {
        this(null, null, 0, 0, null, 31, null);
    }

    private final ArrayList<Effect> component5() {
        return this.effectList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InspirationFeedEffectsResponse copy$default(InspirationFeedEffectsResponse r3, List r4, String r5, int r6, int r7, ArrayList r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.inspiration_awemes;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.message;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.status_code;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.has_more;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.effectList;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<InspirationFeedEffectModel> component1() {
        return this.inspiration_awemes;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final int component4() {
        return this.has_more;
    }

    public final InspirationFeedEffectsResponse copy(List<InspirationFeedEffectModel> r8, String r9, int r10, int r11, ArrayList<Effect> r12) {
        return new InspirationFeedEffectsResponse(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof InspirationFeedEffectsResponse) == false) goto L16;
        InspirationFeedEffectsResponse r4 = (InspirationFeedEffectsResponse) r3;
        if (Intrinsics.areEqual(this.inspiration_awemes, r4.inspiration_awemes) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r4.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r4.status_code) goto L12;
        return false;
    L12:
        if (this.has_more == r4.has_more) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.effectList, r4.effectList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        List<InspirationFeedEffectModel> r0 = this.inspiration_awemes;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((((r3 + r5) * 31) + this.status_code) * 31) + this.has_more) * 31;
        ArrayList<Effect> r7 = this.effectList;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "InspirationFeedEffectsResponse(inspiration_awemes=" + this.inspiration_awemes + ", message=" + this.message + ", status_code=" + this.status_code + ", has_more=" + this.has_more + ", effectList=" + this.effectList + ")";
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public List<Effect> m1542getResponseData() {
        ArrayList<Effect> r0 = this.effectList;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        this.effectList = new ArrayList();
        List<InspirationFeedEffectModel> r2 = this.inspiration_awemes;
        if (r2 == null) goto L51;
        Iterator<T> r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L51;
        InspirationFeedEffectModel r4 = (InspirationFeedEffectModel) r3.next();
        List<MaterialModel> r5 = r4.getMaterials();
        if (r5 == null) goto L16;
        Iterator<T> r6 = r5.iterator();
    L21:
        if (r6.hasNext() == false) goto L16;
        MaterialModel r7 = (MaterialModel) r6.next();
        Effect r8 = r7.getSticker_data();
        if (r8 == null) goto L21;
        InspirationModel r9 = r4.getAweme();
        List r10 = null;
        if (r9 == null) goto L29;
        AuthorModel r11 = r9.getAuthor();
        if (r11 == null) goto L29;
        String r12 = r11.getNickname();
    L30:
        r8.setNickname(r12);
        InspirationModel r13 = r4.getAweme();
        if (r13 == null) goto L35;
        AuthorModel r14 = r13.getAuthor();
        if (r14 == null) goto L35;
        AuthorThumbModel r15 = r14.getAvatar_thumb();
    L36:
        r8.setAvatar_thumb(r15);
        Long r16 = r7.getUse_count();
        if (r16 == null) goto L39;
        long r17 = r16.longValue();
    L40:
        r8.setUse_number(r17);
        InspirationModel r18 = r4.getAweme();
        if (r18 == null) goto L47;
        VideoModel r19 = r18.getVideo();
        if (r19 == null) goto L47;
        UrlModel r20 = r19.getPlay_addr();
        if (r20 == null) goto L47;
        r10 = r20.getUrl_list();
    L47:
        r8.setVideoPlayURLs(r10);
        ArrayList<Effect> r21 = this.effectList;
        if (r21 == null) goto L21;
        r21.add(r8);
        goto L21
    L39:
        r17 = 0;
    L35:
        r15 = null;
    L29:
        r12 = null;
    L51:
        return this.effectList;
    L11:
        return this.effectList;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public final int getHas_more() {
        return this.has_more;
    }

    public final List<InspirationFeedEffectModel> getInspiration_awemes() {
        return this.inspiration_awemes;
    }

    public final String getMessage() {
        return this.message;
    }

    public String getResponseMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public /* bridge */ /* synthetic */ Object getResponseData() {
        return m1542getResponseData();
    }

    public final void setHas_more(int r1) {
        this.has_more = r1;
    }

    public final void setInspiration_awemes(List<InspirationFeedEffectModel> r1) {
        this.inspiration_awemes = r1;
    }

    public final void setMessage(String r1) {
        this.message = r1;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public InspirationFeedEffectsResponse(List<InspirationFeedEffectModel> r1, String r2, int r3, int r4, ArrayList<Effect> r5) {
        this.inspiration_awemes = r1;
        this.message = r2;
        this.status_code = r3;
        this.has_more = r4;
        this.effectList = r5;
    }

    public /* synthetic */ InspirationFeedEffectsResponse(List r5, String r6, int r7, int r8, ArrayList r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        List r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r10 & 8) == 0) goto L17;
        int r3 = 0;
    L19:
        if ((r10 & 16) == 0) goto L21;
        ArrayList r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
