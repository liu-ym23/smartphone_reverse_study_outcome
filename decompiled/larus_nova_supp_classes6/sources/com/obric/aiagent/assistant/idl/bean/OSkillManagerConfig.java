package com.obric.aiagent.assistant.idl.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u0002H\t¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u000bHÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/OSkillManagerConfig;", "Landroid/os/Parcelable;", "values", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "getValues", "()Landroid/os/Bundle;", "getValue", "T", "key", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OSkillManagerConfig implements Parcelable {
    public static final Parcelable.Creator<OSkillManagerConfig> CREATOR = null;
    public static final a Companion = null;
    public static final boolean DEFAULT_SKILL_EXTENSION_ENABLED = true;
    public static final String KEY_SKILL_EXTENSION_ENABLED = "skill_extension_enabled";
    private final Bundle values;

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public OSkillManagerConfig() {
        Bundle r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ OSkillManagerConfig copy$default(OSkillManagerConfig r0, Bundle r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.values;
    L6:
        return r0.copy(r1);
    }

    public final Bundle component1() {
        return this.values;
    }

    public final OSkillManagerConfig copy(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "values");
        return new OSkillManagerConfig(r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof OSkillManagerConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.values, ((OSkillManagerConfig) r4).values) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public String toString() {
        return "OSkillManagerConfig(values=" + this.values + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeBundle(this.values);
    }

    public final Bundle getValues() {
        return this.values;
    }

    public OSkillManagerConfig(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "values");
        this.values = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T getValue(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Object r5 = this.values.get(r3);
        if (r5 != null) goto L5;
        return r4;
    L5:
        Object r1 = null;
        Boolean r2 = null;
        Integer r6 = null;
        Long r7 = null;
        Double r8 = null;
        if ((r4 instanceof Boolean) == false) goto L15;
        if ((r5 instanceof Boolean) == false) goto L10;
        r2 = (Boolean) r5;
    L10:
        if (r2 == null) goto L12;
        boolean r9 = r2.booleanValue();
    L50:
        return (T) Boolean.valueOf(r9);
    L12:
        r9 = ((Boolean) r4).booleanValue();
        goto L50
    L15:
        if ((r4 instanceof Integer) == false) goto L24;
        if ((r5 instanceof Integer) == false) goto L19;
        r6 = (Integer) r5;
    L19:
        if (r6 == null) goto L21;
        int r10 = r6.intValue();
    L51:
        return (T) Integer.valueOf(r10);
    L21:
        r10 = ((Number) r4).intValue();
        goto L51
    L24:
        if ((r4 instanceof Long) == false) goto L33;
        if ((r5 instanceof Long) == false) goto L28;
        r7 = (Long) r5;
    L28:
        if (r7 == null) goto L30;
        long r11 = r7.longValue();
    L52:
        return (T) Long.valueOf(r11);
    L30:
        r11 = ((Number) r4).longValue();
        goto L52
    L33:
        if ((r4 instanceof Double) == false) goto L42;
        if ((r5 instanceof Double) == false) goto L37;
        r8 = (Double) r5;
    L37:
        if (r8 == null) goto L39;
        double r12 = r8.doubleValue();
    L53:
        return (T) Double.valueOf(r12);
    L39:
        r12 = ((Number) r4).doubleValue();
        goto L53
    L42:
        if ((r4 instanceof String) == true) goto L44;
        return r4;
    L44:
        if ((r5 instanceof String) == false) goto L46;
        r1 = (String) r5;
    L46:
        if (r1 != null) goto L49;
        return (T) ((String) r4);
    L49:
        return (T) r1;
    }

    public /* synthetic */ OSkillManagerConfig(Bundle r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new Bundle();
    L5:
        this(r1);
    }
}
