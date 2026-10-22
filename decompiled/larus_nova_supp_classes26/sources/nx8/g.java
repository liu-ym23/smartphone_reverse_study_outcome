package nx8;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000bHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jª\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0003HÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b#\u0010\u001cR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b%\u0010\u001cR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019¨\u0006;"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/EduImageMessageExt;", "", "os", "", "sdkVersion", "", "picSource", "detectionType", "detectionId", "", "userChangeBoxes", "", "", "essayScene", "searchContent", "Lcom/larus/camera/impl/edulibs/cameraapi/EduImageSearchContent;", "selectIndex", "detectionSceneType", "requestId", "eduExtraParam", "<init>", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getOs", "()I", "getSdkVersion", "()Ljava/lang/String;", "getPicSource", "getDetectionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDetectionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUserChangeBoxes", "()Ljava/util/List;", "getEssayScene", "getSearchContent", "getSelectIndex", "getDetectionSceneType", "getRequestId", "getEduExtraParam", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ILjava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/camera/impl/edulibs/cameraapi/EduImageMessageExt;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {
    public final transient String a;

    @SerializedName("detection_id")
    private final Long detectionId;

    @SerializedName("detection_scene_type")
    private final Integer detectionSceneType;

    @SerializedName("detection_type")
    private final Integer detectionType;

    @SerializedName("essay_scene")
    private final Integer essayScene;

    @SerializedName("os")
    private final int os;

    @SerializedName("picture_source")
    private final int picSource;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("edu_camera_sdk_version")
    private final String sdkVersion;

    @SerializedName("search_content")
    private final List<j> searchContent;

    @SerializedName("search_index")
    private final Integer selectIndex;

    @SerializedName("user_change_boxes")
    private final List<Boolean> userChangeBoxes;

    public g() {
        this(null, null, null, null, null, null, null, null, null, null, 4095);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.os == r6.os) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sdkVersion, r6.sdkVersion) == true) goto L15;
        return false;
    L15:
        if (this.picSource == r6.picSource) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detectionType, r6.detectionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.detectionId, r6.detectionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userChangeBoxes, r6.userChangeBoxes) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.essayScene, r6.essayScene) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.searchContent, r6.searchContent) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.selectIndex, r6.selectIndex) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.detectionSceneType, r6.detectionSceneType) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = this.os * 31;
        String r1 = this.sdkVersion;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.picSource) * 31;
        Integer r5 = this.detectionType;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.detectionId;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        List<Boolean> r11 = this.userChangeBoxes;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        Integer r14 = this.essayScene;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        List<j> r17 = this.searchContent;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.selectIndex;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.detectionSceneType;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.requestId;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.a;
        if (r29 == null) goto L43;
        r2 = r29.hashCode();
    L43:
        return r28 + r2;
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
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "EduImageMessageExt(os=" + this.os + ", sdkVersion=" + this.sdkVersion + ", picSource=" + this.picSource + ", detectionType=" + this.detectionType + ", detectionId=" + this.detectionId + ", userChangeBoxes=" + this.userChangeBoxes + ", essayScene=" + this.essayScene + ", searchContent=" + this.searchContent + ", selectIndex=" + this.selectIndex + ", detectionSceneType=" + this.detectionSceneType + ", requestId=" + this.requestId + ", eduExtraParam=" + this.a + ')';
    }

    public g(String r5, Integer r6, Long r7, List r8, Integer r9, List r10, Integer r11, Integer r12, String r13, String r14, int r15) {
        int r1 = 0;
        if ((r15 & 1) == 0) goto L5;
        int r0 = 2;
    L7:
        if ((r15 & 2) == 0) goto L10;
        r5 = "";
    L10:
        if ((r15 & 4) == 0) goto L13;
        r1 = 1;
    L13:
        if ((r15 & 8) == 0) goto L16;
        r6 = null;
    L16:
        if ((r15 & 16) == 0) goto L19;
        r7 = null;
    L19:
        if ((r15 & 32) == 0) goto L22;
        r8 = null;
    L22:
        if ((r15 & 64) == 0) goto L25;
        r9 = null;
    L25:
        if ((r15 & 128) == 0) goto L28;
        r10 = null;
    L28:
        if ((r15 & 256) == 0) goto L31;
        r11 = null;
    L31:
        if ((r15 & 512) == 0) goto L34;
        r12 = null;
    L34:
        if ((r15 & 1024) == 0) goto L37;
        r13 = null;
    L37:
        if ((r15 & 2048) == 0) goto L39;
        r14 = null;
    L39:
        this.os = r0;
        this.sdkVersion = r5;
        this.picSource = r1;
        this.detectionType = r6;
        this.detectionId = r7;
        this.userChangeBoxes = r8;
        this.essayScene = r9;
        this.searchContent = r10;
        this.selectIndex = r11;
        this.detectionSceneType = r12;
        this.requestId = r13;
        this.a = r14;
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
