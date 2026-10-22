package d2;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ai.bridge.method.datamanager.StorageInputParam;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements StorageInputParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16584c;

    public a(String r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "groupId");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        this.f16582a = r5;
        this.f16583b = r10;
        this.f16584c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        String r11 = r10.f16582a;
        if (Intrinsics.areEqual(this.f16582a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16583b, r10.f16583b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16584c, r10.f16584c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final String getExtra() {
        return null;
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final String getGroupId() {
        return this.f16582a;
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final String getKey() {
        return this.f16583b;
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final String getStorageId() {
        return "default";
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final String getValue() {
        return this.f16584c;
    }

    public final int hashCode() {
        int r5 = this.f16582a.hashCode() * 31;
        int r10 = kk.a.b(this.f16583b, r5, 31);
        String r11 = this.f16584c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final boolean isPersist() {
        return true;
    }

    @Override // com.bytedance.ai.bridge.method.datamanager.StorageInputParam
    public final boolean isShared() {
        return true;
    }

    @Override // com.bytedance.ai.bridge.core.model.idl.BaseModel
    public final JsonObject toJson() {
        JsonObject r5 = new JsonObject();
        r5.addProperty("groupID", this.f16582a);
        r5.addProperty("storageID", "default");
        Boolean r10 = Boolean.TRUE;
        r5.addProperty("persistent", r10);
        r5.addProperty("shared", r10);
        r5.addProperty(STGroup.DICT_KEY, this.f16583b);
        String r11 = this.f16584c;
        if (r11 == null) goto L5;
        r5.addProperty("value", r11);
    L5:
        return r5;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("StorageInputParamImpl(groupId=");
        r5.append(this.f16582a);
        r5.append(", key=");
        r5.append(this.f16583b);
        r5.append(", value=");
        return j0.p(r5, this.f16584c, ')');
    }
}
