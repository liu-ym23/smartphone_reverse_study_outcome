package com.larus.camera.impl.edulibs.camera.internal.idl;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/DetectionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "SingleQuestion", "MultiQuestion", "Correct", "MetalCalc", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DetectionType extends Enum<DetectionType> {
    public static final a Companion = null;

    @SerializedName("3")
    public static final DetectionType Correct = null;

    @SerializedName("4")
    public static final DetectionType MetalCalc = null;

    @SerializedName("2")
    public static final DetectionType MultiQuestion = null;

    @SerializedName("1")
    public static final DetectionType SingleQuestion = null;

    @SerializedName(TriggerSendLoading.NO_LOADING)
    public static final DetectionType Unknown = null;
    public static final /* synthetic */ DetectionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DetectionType> getEntries() {
        return b;
    }

    static {
        DetectionType r0 = new DetectionType("Unknown", 0, 0);
        Unknown = r0;
        DetectionType r1 = new DetectionType("SingleQuestion", 1, 1);
        SingleQuestion = r1;
        DetectionType r3 = new DetectionType("MultiQuestion", 2, 2);
        MultiQuestion = r3;
        DetectionType r5 = new DetectionType("Correct", 3, 3);
        Correct = r5;
        DetectionType r7 = new DetectionType("MetalCalc", 4, 4);
        MetalCalc = r7;
        DetectionType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static DetectionType[] values() {
        return (DetectionType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final DetectionType findByValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L21;
        if (r1 == 4) goto L20;
        return null;
    L20:
        return MetalCalc;
    L21:
        return Correct;
    L22:
        return MultiQuestion;
    L23:
        return SingleQuestion;
    L18:
        return Unknown;
    }

    public static DetectionType valueOf(String r1) {
        return (DetectionType) r27.a.a(DetectionType.class, r1);
    }

    public DetectionType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
