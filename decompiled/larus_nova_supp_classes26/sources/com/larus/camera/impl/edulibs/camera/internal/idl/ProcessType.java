package com.larus.camera.impl.edulibs.camera.internal.idl;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/ProcessType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Orientation", "Detection", "RemoveHandwriting", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProcessType extends Enum<ProcessType> {
    public static final a Companion = null;

    @SerializedName("2")
    public static final ProcessType Detection = null;

    @SerializedName("1")
    public static final ProcessType Orientation = null;

    @SerializedName("3")
    public static final ProcessType RemoveHandwriting = null;

    @SerializedName(TriggerSendLoading.NO_LOADING)
    public static final ProcessType Unknown = null;
    public static final /* synthetic */ ProcessType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ProcessType> getEntries() {
        return b;
    }

    static {
        ProcessType r0 = new ProcessType("Unknown", 0, 0);
        Unknown = r0;
        ProcessType r1 = new ProcessType("Orientation", 1, 1);
        Orientation = r1;
        ProcessType r3 = new ProcessType("Detection", 2, 2);
        Detection = r3;
        ProcessType r5 = new ProcessType("RemoveHandwriting", 3, 3);
        RemoveHandwriting = r5;
        ProcessType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static ProcessType[] values() {
        return (ProcessType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ProcessType findByValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L17;
        return null;
    L17:
        return RemoveHandwriting;
    L18:
        return Detection;
    L19:
        return Orientation;
    L15:
        return Unknown;
    }

    public static ProcessType valueOf(String r1) {
        return (ProcessType) r27.a.a(ProcessType.class, r1);
    }

    public ProcessType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
