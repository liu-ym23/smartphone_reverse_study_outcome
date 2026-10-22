package com.larus.camera.impl.edulibs.camera.internal.idl;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/Orientation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Angle_0", "Angle_90", "Angle_180", "Angle_270", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Orientation extends Enum<Orientation> {

    @SerializedName(TriggerSendLoading.NO_LOADING)
    public static final Orientation Angle_0 = null;

    @SerializedName("2")
    public static final Orientation Angle_180 = null;

    @SerializedName("3")
    public static final Orientation Angle_270 = null;

    @SerializedName("1")
    public static final Orientation Angle_90 = null;
    public static final a Companion = null;
    public static final /* synthetic */ Orientation[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Orientation> getEntries() {
        return b;
    }

    static {
        Orientation r0 = new Orientation("Angle_0", 0, 0);
        Angle_0 = r0;
        Orientation r1 = new Orientation("Angle_90", 1, 1);
        Angle_90 = r1;
        Orientation r3 = new Orientation("Angle_180", 2, 2);
        Angle_180 = r3;
        Orientation r5 = new Orientation("Angle_270", 3, 3);
        Angle_270 = r5;
        Orientation[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static Orientation[] values() {
        return (Orientation[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final Orientation findByValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return Angle_270;
    L18:
        return Angle_180;
    L19:
        return Angle_90;
    L15:
        return Angle_0;
    }

    public static Orientation valueOf(String r1) {
        return (Orientation) r27.a.a(Orientation.class, r1);
    }

    public Orientation(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
