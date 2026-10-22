package q99;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011HÆ\u0003J\u009c\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\f8F¢\u0006\u0006\u001a\u0004\b'\u0010 ¨\u00069"}, d2 = {"Lcom/larus/feedback/api/model/FlowFeedbackContentResponse;", "", "feedbackScene", "", "feedbackSceneName", "", "needShow", "", "feedbackId", "placeholder", "showContent", "dislikeKeys", "", "Lcom/larus/feedback/api/model/FlowFeedbackDislikeKey;", "messageId", "sectionId", "extra", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getFeedbackScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackSceneName", "()Ljava/lang/String;", "getNeedShow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFeedbackId", "getPlaceholder", "getShowContent", "getDislikeKeys", "()Ljava/util/List;", "getMessageId", "getSectionId", "getExtra", "()Ljava/util/Map;", "dislikeOptions", "Lcom/larus/feedback/api/model/FlowDislikeOption;", "getDislikeOptions", "withResolvedContext", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/feedback/api/model/FlowFeedbackContentResponse;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("dislike_keys")
    private final List<f> dislikeKeys;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("feedback_id")
    private final String feedbackId;

    @SerializedName("feedback_scene")
    private final Integer feedbackScene;

    @SerializedName("feedback_scene_name")
    private final String feedbackSceneName;

    @SerializedName("message_id")
    private final String messageId;

    @SerializedName("need_show")
    private final Boolean needShow;

    @SerializedName("placeholder")
    private final String placeholder;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("show_content")
    private final String showContent;

    public d() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.feedbackScene, r6.feedbackScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackSceneName, r6.feedbackSceneName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.needShow, r6.needShow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedbackId, r6.feedbackId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.placeholder, r6.placeholder) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showContent, r6.showContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dislikeKeys, r6.dislikeKeys) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sectionId, r6.sectionId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.feedbackScene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.feedbackSceneName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.needShow;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.feedbackId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.placeholder;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.showContent;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<f> r20 = this.dislikeKeys;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        String r23 = this.messageId;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.sectionId;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        Map<String, String> r30 = this.extra;
        if (r30 == null) goto L43;
        r1 = r30.hashCode();
    L43:
        return r28 + r1;
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowFeedbackContentResponse(feedbackScene=" + this.feedbackScene + ", feedbackSceneName=" + this.feedbackSceneName + ", needShow=" + this.needShow + ", feedbackId=" + this.feedbackId + ", placeholder=" + this.placeholder + ", showContent=" + this.showContent + ", dislikeKeys=" + this.dislikeKeys + ", messageId=" + this.messageId + ", sectionId=" + this.sectionId + ", extra=" + this.extra + ')';
    }

    public final List<b> a() {
        List<f> r0 = this.dislikeKeys;
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        f r3 = (f) r2.next();
        if (r3 == null) goto L11;
        b r4 = r3.a();
    L12:
        if (r4 == null) goto L7;
        r1.add(r4);
        goto L7
    L11:
        r4 = null;
        goto L12
    L14:
        return r1;
    }

    public final String b() {
        return this.feedbackId;
    }

    public final Integer c() {
        return this.feedbackScene;
    }

    public final String d() {
        return this.feedbackSceneName;
    }

    public final String e() {
        return this.messageId;
    }

    public final Boolean f() {
        return this.needShow;
    }

    public final String g() {
        return this.placeholder;
    }

    public final String h() {
        return this.sectionId;
    }

    public final String i() {
        return this.showContent;
    }

    public final d j(String r13, String r14, Map<String, String> r15) {
        String r0 = this.messageId;
        if (r0 != null) goto L5;
        String r9 = r13;
    L6:
        String r16 = this.sectionId;
        if (r16 != null) goto L9;
        String r10 = r14;
    L10:
        Map<String, String> r17 = this.extra;
        if (r17 != null) goto L13;
        r17 = MapsKt.emptyMap();
    L13:
        if (r15 != null) goto L15;
        r15 = MapsKt.emptyMap();
    L15:
        Map r11 = MapsKt.plus(r17, r15);
        return new d(this.feedbackScene, this.feedbackSceneName, this.needShow, this.feedbackId, this.placeholder, this.showContent, this.dislikeKeys, r9, r10, r11);
    L9:
        r10 = r16;
        goto L10
    L5:
        r9 = r0;
        goto L6
    }

    public d(Integer r1, String r2, Boolean r3, String r4, String r5, String r6, List<f> r7, String r8, String r9, Map<String, String> r10) {
        this.feedbackScene = r1;
        this.feedbackSceneName = r2;
        this.needShow = r3;
        this.feedbackId = r4;
        this.placeholder = r5;
        this.showContent = r6;
        this.dislikeKeys = r7;
        this.messageId = r8;
        this.sectionId = r9;
        this.extra = r10;
    }
}
