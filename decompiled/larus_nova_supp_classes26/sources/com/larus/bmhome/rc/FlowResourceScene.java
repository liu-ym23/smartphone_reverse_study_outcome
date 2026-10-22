package com.larus.bmhome.rc;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/rc/FlowResourceScene;", "", "title", "", "sceneIDForDoubao", "sceneIDForCici", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getSceneIDForDoubao", "getSceneIDForCici", "Unknown", "FileUpload", "ImageVLM", "ImageOCR", "ImageEDU", "VideoUpload", "O_Server", "O_Mobile_Tmp", "O_ASSISTANT_FEEDBACK", "CreationUserVideo", "CreationUserVideoV2", "SpringMainVenue", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowResourceScene extends Enum<FlowResourceScene> {
    public static final a Companion = null;
    public static final FlowResourceScene CreationUserVideo = null;
    public static final FlowResourceScene CreationUserVideoV2 = null;
    public static final FlowResourceScene FileUpload = null;
    public static final FlowResourceScene ImageEDU = null;
    public static final FlowResourceScene ImageOCR = null;
    public static final FlowResourceScene ImageVLM = null;
    public static final FlowResourceScene O_ASSISTANT_FEEDBACK = null;
    public static final FlowResourceScene O_Mobile_Tmp = null;
    public static final FlowResourceScene O_Server = null;
    public static final FlowResourceScene SpringMainVenue = null;
    public static final FlowResourceScene Unknown = null;
    public static final FlowResourceScene VideoUpload = null;
    public static final /* synthetic */ FlowResourceScene[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String sceneIDForCici;
    private final String sceneIDForDoubao;
    private final String title;

    public static final class a {
        public a() {
        }

        public static FlowResourceScene a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            if (AppHost.a.isOversea() == false) goto L29;
            FlowResourceScene r0 = FlowResourceScene.FileUpload;
            if (Intrinsics.areEqual(r2, r0.getSceneIDForCici()) == true) goto L65;
            FlowResourceScene r1 = FlowResourceScene.ImageVLM;
            if (Intrinsics.areEqual(r2, r1.getSceneIDForCici()) == true) goto L66;
            FlowResourceScene r3 = FlowResourceScene.ImageOCR;
            if (Intrinsics.areEqual(r2, r3.getSceneIDForCici()) == true) goto L67;
            FlowResourceScene r4 = FlowResourceScene.ImageEDU;
            if (Intrinsics.areEqual(r2, r4.getSceneIDForCici()) == true) goto L68;
            FlowResourceScene r5 = FlowResourceScene.VideoUpload;
            if (Intrinsics.areEqual(r2, r5.getSceneIDForCici()) == true) goto L69;
            FlowResourceScene r6 = FlowResourceScene.O_ASSISTANT_FEEDBACK;
            if (Intrinsics.areEqual(r2, r6.getSceneIDForCici()) == true) goto L70;
            FlowResourceScene r7 = FlowResourceScene.CreationUserVideo;
            if (Intrinsics.areEqual(r2, r7.getSceneIDForCici()) == true) goto L71;
            FlowResourceScene r8 = FlowResourceScene.CreationUserVideoV2;
            if (Intrinsics.areEqual(r2, r8.getSceneIDForCici()) == false) goto L64;
            return r8;
        L64:
            return FlowResourceScene.Unknown;
        L71:
            return r7;
        L70:
            return r6;
        L69:
            return r5;
        L68:
            return r4;
        L67:
            return r3;
        L66:
            return r1;
        L65:
            return r0;
        L29:
            FlowResourceScene r9 = FlowResourceScene.FileUpload;
            if (Intrinsics.areEqual(r2, r9.getSceneIDForDoubao()) == true) goto L73;
            FlowResourceScene r10 = FlowResourceScene.ImageVLM;
            if (Intrinsics.areEqual(r2, r10.getSceneIDForDoubao()) == true) goto L74;
            FlowResourceScene r11 = FlowResourceScene.ImageOCR;
            if (Intrinsics.areEqual(r2, r11.getSceneIDForDoubao()) == true) goto L75;
            FlowResourceScene r12 = FlowResourceScene.ImageEDU;
            if (Intrinsics.areEqual(r2, r12.getSceneIDForDoubao()) == true) goto L76;
            FlowResourceScene r13 = FlowResourceScene.VideoUpload;
            if (Intrinsics.areEqual(r2, r13.getSceneIDForDoubao()) == true) goto L77;
            FlowResourceScene r14 = FlowResourceScene.O_Server;
            if (Intrinsics.areEqual(r2, r14.getSceneIDForDoubao()) == true) goto L78;
            FlowResourceScene r15 = FlowResourceScene.O_Mobile_Tmp;
            if (Intrinsics.areEqual(r2, r15.getSceneIDForDoubao()) == true) goto L79;
            FlowResourceScene r16 = FlowResourceScene.O_ASSISTANT_FEEDBACK;
            if (Intrinsics.areEqual(r2, r16.getSceneIDForDoubao()) == true) goto L80;
            FlowResourceScene r17 = FlowResourceScene.CreationUserVideo;
            if (Intrinsics.areEqual(r2, r17.getSceneIDForDoubao()) == true) goto L81;
            FlowResourceScene r18 = FlowResourceScene.CreationUserVideoV2;
            if (Intrinsics.areEqual(r2, r18.getSceneIDForDoubao()) == true) goto L82;
            FlowResourceScene r19 = FlowResourceScene.SpringMainVenue;
            if (Intrinsics.areEqual(r2, r19.getSceneIDForDoubao()) == false) goto L63;
            return r19;
        L63:
            return FlowResourceScene.Unknown;
        L82:
            return r18;
        L81:
            return r17;
        L80:
            return r16;
        L79:
            return r15;
        L78:
            return r14;
        L77:
            return r13;
        L76:
            return r12;
        L75:
            return r11;
        L74:
            return r10;
        L73:
            return r9;
        }

        public static String b(FlowResourceScene r1) {
            Intrinsics.checkNotNullParameter(r1, "scene");
            if (AppHost.a.isOversea() == false) goto L6;
            return r1.getSceneIDForCici();
        L6:
            return r1.getSceneIDForDoubao();
        }
    }

    public static EnumEntries<FlowResourceScene> getEntries() {
        return b;
    }

    static {
        FlowResourceScene r6 = new FlowResourceScene("Unknown", 0, "unknown", TriggerSendLoading.NO_LOADING, TriggerSendLoading.NO_LOADING);
        Unknown = r6;
        FlowResourceScene r0 = new FlowResourceScene("FileUpload", 1, "upload_file", "5", "4");
        FileUpload = r0;
        FlowResourceScene r1 = new FlowResourceScene("ImageVLM", 2, "vlm_image", "7", "5");
        ImageVLM = r1;
        FlowResourceScene r2 = new FlowResourceScene("ImageOCR", 3, "ocr_image", "8", "6");
        ImageOCR = r2;
        FlowResourceScene r3 = new FlowResourceScene("ImageEDU", 4, "edu_image", "9", "7");
        ImageEDU = r3;
        FlowResourceScene r4 = new FlowResourceScene("VideoUpload", 5, "video_upload", "21", "21");
        VideoUpload = r4;
        FlowResourceScene r5 = new FlowResourceScene("O_Server", 6, "o_server", "69", "69");
        O_Server = r5;
        FlowResourceScene r13 = new FlowResourceScene("O_Mobile_Tmp", 7, "o_mobile_tmp", "106", "106");
        O_Mobile_Tmp = r13;
        FlowResourceScene r7 = new FlowResourceScene("O_ASSISTANT_FEEDBACK", 8, "o_assistant_feedback", "136", "136");
        O_ASSISTANT_FEEDBACK = r7;
        FlowResourceScene r8 = new FlowResourceScene("CreationUserVideo", 9, "creation_user_video", "81", "26");
        CreationUserVideo = r8;
        FlowResourceScene r9 = new FlowResourceScene("CreationUserVideoV2", 10, "creation_user_video_v2", "133", "46");
        CreationUserVideoV2 = r9;
        FlowResourceScene r10 = new FlowResourceScene("SpringMainVenue", 11, "spring_main_venue", "83", "83");
        SpringMainVenue = r10;
        FlowResourceScene[] r11 = {r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new a();
    }

    public static FlowResourceScene[] values() {
        return (FlowResourceScene[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(super.toString());
        r0.append('(');
        Companion.getClass();
        r0.append(a.b(this));
        r0.append(')');
        return r0.toString();
    }

    public final String getSceneIDForCici() {
        return this.sceneIDForCici;
    }

    public final String getSceneIDForDoubao() {
        return this.sceneIDForDoubao;
    }

    public final String getTitle() {
        return this.title;
    }

    public static FlowResourceScene valueOf(String r1) {
        return (FlowResourceScene) r27.a.a(FlowResourceScene.class, r1);
    }

    public FlowResourceScene(String r1, int r2, String r3, String r4, String r5) {
        super(r1, r2);
        this.title = r3;
        this.sceneIDForDoubao = r4;
        this.sceneIDForCici = r5;
    }
}
