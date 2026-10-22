package com.bytedance.android.ec.core.event.eventdumper.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/core/event/eventdumper/model/DumpedClassInfo;", "Ljava/io/Serializable;", "()V", "eventClassInfo", "Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "getEventClassInfo", "()Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;", "setEventClassInfo", "(Lcom/bytedance/android/ec/core/event/eventdumper/model/ClassInfo;)V", "postLocationClassInfo", "getPostLocationClassInfo", "setPostLocationClassInfo", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DumpedClassInfo implements Serializable {

    @SerializedName("event_class_info")
    private ClassInfo eventClassInfo;

    @SerializedName("post_location_class_info")
    private ClassInfo postLocationClassInfo;

    public DumpedClassInfo() {
    }

    public final ClassInfo getEventClassInfo() {
        return this.eventClassInfo;
    }

    public final ClassInfo getPostLocationClassInfo() {
        return this.postLocationClassInfo;
    }

    public final void setEventClassInfo(ClassInfo r1) {
        this.eventClassInfo = r1;
    }

    public final void setPostLocationClassInfo(ClassInfo r1) {
        this.postLocationClassInfo = r1;
    }
}
