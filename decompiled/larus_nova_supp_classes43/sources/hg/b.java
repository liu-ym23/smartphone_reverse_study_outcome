package hg;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lhg/b;", "", "", "scene", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "sceneId", "e", "action", "a", "ruleId", "c", "", "switchOn", "Z", "f", "()Z", "setSwitchOn", "(Z)V", "", "closeDuration", "I", "b", "()I", "setCloseDuration", "(I)V", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {
    public long a;

    @SerializedName("action")
    private final String action;

    @SerializedName("close_duration")
    private int closeDuration;

    @SerializedName("rule_id")
    private final String ruleId;

    @SerializedName("scene")
    private final String scene;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCENE_ID)
    private final String sceneId;

    @SerializedName("switch_on")
    private boolean switchOn;

    public b() {
    }

    public final int hashCode() {
        String r0 = this.scene;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.sceneId;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.action;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.ruleId;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "ServerSwitchData(timestamp=" + this.a + ", scene=" + this.scene + ", sceneId=" + this.sceneId + ", action=" + this.action + ", ruleId=" + this.ruleId + ", switchOn=" + this.switchOn + ", closeDuration=" + this.closeDuration + ')';
    }

    public final String a() {
        return this.action;
    }

    public final int b() {
        return this.closeDuration;
    }

    public final String c() {
        return this.ruleId;
    }

    public final String d() {
        return this.scene;
    }

    public final String e() {
        return this.sceneId;
    }

    public final boolean f() {
        return this.switchOn;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 == null) goto L8;
        Class<?> r11 = r10.getClass();
    L10:
        if ((!Intrinsics.areEqual(b.class, r11)) == false) goto L12;
        return false;
    L12:
        if (r10 == null) goto L27;
        b r12 = (b) r10;
        if ((!Intrinsics.areEqual(this.scene, r12.scene)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.sceneId, r12.sceneId)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.action, r12.action)) == false) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.ruleId, r12.ruleId)) == false) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.usertracker.ecmarketing.model.ServerSwitchData");
    L8:
        r11 = null;
        goto L10
    }
}
