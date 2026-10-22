package androidx.room.jarjarred.kotlinx.metadata.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMethodSignature;", "Landroidx/room/jarjarred/kotlinx/metadata/jvm/JvmMemberSignature;", "name", "", "desc", "(Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getName", "asString", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata-jvm"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JvmMethodSignature extends JvmMemberSignature {
    private final String desc;
    private final String name;

    public JvmMethodSignature(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "desc");
        super(null);
        this.name = r5;
        this.desc = r10;
    }

    public static /* synthetic */ JvmMethodSignature copy$default(JvmMethodSignature r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.getName();
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.getDesc();
    L9:
        return r5.copy(r10, r11);
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMemberSignature
    public String asString() {
        return getName() + getDesc();
    }

    public final String component1() {
        return getName();
    }

    public final String component2() {
        return getDesc();
    }

    public final JvmMethodSignature copy(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "desc");
        return new JvmMethodSignature(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof JvmMethodSignature) == true) goto L8;
        return false;
    L8:
        JvmMethodSignature r10 = (JvmMethodSignature) r5;
        if (Intrinsics.areEqual(getName(), r10.getName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getDesc(), r10.getDesc()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMemberSignature
    public String getDesc() {
        return this.desc;
    }

    @Override // androidx.room.jarjarred.kotlinx.metadata.jvm.JvmMemberSignature
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int r5 = getName().hashCode() * 31;
        return getDesc().hashCode() + r5;
    }
}
