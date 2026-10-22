package com.larus.camera.impl.edulibs.cameraapi;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/SceneType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "Doubao_Education_Camera_Qa", "Doubao_General_Camera_Tab_Qa", "Doubao_General_Camera_Intent_Recognition_Education_Qa", "Doubao_Education_Camera_Essay_Correction", "Doubao_Education_Camera_Mental_Calculations", "Doubao_General_Camera_Intent_Recognition_Education_Correction", "Doubao_Education_Camera_Homework_Correction", "Hippo_Photo_Qa", "Hippo_Record_Error", "Hippo_Homework_Correction", "Hippo_Essay_Correction", "Hippo_Chinese_Essay_Writing", "Doubao_Live_Tutor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SceneType extends Enum<SceneType> {
    public static final a Companion = null;

    @SerializedName(TriggerSendLoading.NO_LOADING)
    public static final SceneType Default = null;

    @SerializedName("104")
    public static final SceneType Doubao_Education_Camera_Essay_Correction = null;

    @SerializedName("109")
    public static final SceneType Doubao_Education_Camera_Homework_Correction = null;

    @SerializedName("105")
    public static final SceneType Doubao_Education_Camera_Mental_Calculations = null;

    @SerializedName("101")
    public static final SceneType Doubao_Education_Camera_Qa = null;

    @SerializedName("108")
    public static final SceneType Doubao_General_Camera_Intent_Recognition_Education_Correction = null;

    @SerializedName("103")
    public static final SceneType Doubao_General_Camera_Intent_Recognition_Education_Qa = null;

    @SerializedName("102")
    public static final SceneType Doubao_General_Camera_Tab_Qa = null;

    @SerializedName("209")
    public static final SceneType Doubao_Live_Tutor = null;

    @SerializedName("205")
    public static final SceneType Hippo_Chinese_Essay_Writing = null;

    @SerializedName("204")
    public static final SceneType Hippo_Essay_Correction = null;

    @SerializedName("203")
    public static final SceneType Hippo_Homework_Correction = null;

    @SerializedName("201")
    public static final SceneType Hippo_Photo_Qa = null;

    @SerializedName("202")
    public static final SceneType Hippo_Record_Error = null;
    public static final /* synthetic */ SceneType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SceneType> getEntries() {
        return b;
    }

    static {
        SceneType r0 = new SceneType("Default", 0, 0);
        Default = r0;
        SceneType r1 = new SceneType("Doubao_Education_Camera_Qa", 1, 101);
        Doubao_Education_Camera_Qa = r1;
        SceneType r3 = new SceneType("Doubao_General_Camera_Tab_Qa", 2, 102);
        Doubao_General_Camera_Tab_Qa = r3;
        SceneType r5 = new SceneType("Doubao_General_Camera_Intent_Recognition_Education_Qa", 3, 103);
        Doubao_General_Camera_Intent_Recognition_Education_Qa = r5;
        SceneType r7 = new SceneType("Doubao_Education_Camera_Essay_Correction", 4, 104);
        Doubao_Education_Camera_Essay_Correction = r7;
        SceneType r9 = new SceneType("Doubao_Education_Camera_Mental_Calculations", 5, 105);
        Doubao_Education_Camera_Mental_Calculations = r9;
        SceneType r11 = new SceneType("Doubao_General_Camera_Intent_Recognition_Education_Correction", 6, 108);
        Doubao_General_Camera_Intent_Recognition_Education_Correction = r11;
        SceneType r13 = new SceneType("Doubao_Education_Camera_Homework_Correction", 7, 109);
        Doubao_Education_Camera_Homework_Correction = r13;
        SceneType r12 = new SceneType("Hippo_Photo_Qa", 8, 201);
        Hippo_Photo_Qa = r12;
        SceneType r10 = new SceneType("Hippo_Record_Error", 9, 202);
        Hippo_Record_Error = r10;
        SceneType r8 = new SceneType("Hippo_Homework_Correction", 10, 203);
        Hippo_Homework_Correction = r8;
        SceneType r6 = new SceneType("Hippo_Essay_Correction", 11, 204);
        Hippo_Essay_Correction = r6;
        SceneType r4 = new SceneType("Hippo_Chinese_Essay_Writing", 12, 205);
        Hippo_Chinese_Essay_Writing = r4;
        SceneType r2 = new SceneType("Doubao_Live_Tutor", 13, 209);
        Doubao_Live_Tutor = r2;
        SceneType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r4, r2};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
        Companion = new a();
    }

    public static SceneType[] values() {
        return (SceneType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final SceneType findByValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L24;
        if (r1 == 108) goto L37;
        if (r1 == 109) goto L36;
        switch(r1) {
            case 101: goto L30;
            case 102: goto L29;
            case 103: goto L28;
            case 104: goto L27;
            case 105: goto L26;
            default: goto L9;
        };
    L9:
        switch(r1) {
            case 201: goto L35;
            case 202: goto L34;
            case 203: goto L33;
            case 204: goto L32;
            case 205: goto L31;
            default: goto L10;
        };
    L10:
        return null;
    L31:
        return Hippo_Chinese_Essay_Writing;
    L32:
        return Hippo_Essay_Correction;
    L33:
        return Hippo_Homework_Correction;
    L34:
        return Hippo_Record_Error;
    L35:
        return Hippo_Photo_Qa;
    L26:
        return Doubao_Education_Camera_Mental_Calculations;
    L27:
        return Doubao_Education_Camera_Essay_Correction;
    L28:
        return Doubao_General_Camera_Intent_Recognition_Education_Qa;
    L29:
        return Doubao_General_Camera_Tab_Qa;
    L30:
        return Doubao_Education_Camera_Qa;
    L36:
        return Doubao_Education_Camera_Homework_Correction;
    L37:
        return Doubao_General_Camera_Intent_Recognition_Education_Correction;
    L24:
        return Default;
    }

    public static SceneType valueOf(String r1) {
        return (SceneType) r27.a.a(SceneType.class, r1);
    }

    public SceneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
