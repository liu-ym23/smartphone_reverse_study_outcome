package com.bytedance.ai.resource.core.bean;

import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletList;", "", "appletList", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "<init>", "(Ljava/util/List;)V", "getAppletList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OpenPlatformAppletList {

    @SerializedName("applet_list")
    private final List<OpenPlatformAppletItem> appletList;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPlatformAppletList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformAppletList copy$default(OpenPlatformAppletList r5, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.appletList;
    L6:
        return r5.copy(r10);
    }

    public final List<OpenPlatformAppletItem> component1() {
        return this.appletList;
    }

    public final OpenPlatformAppletList copy(List<OpenPlatformAppletItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "appletList");
        return new OpenPlatformAppletList(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OpenPlatformAppletList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.appletList, ((OpenPlatformAppletList) r5).appletList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<OpenPlatformAppletItem> getAppletList() {
        return this.appletList;
    }

    public int hashCode() {
        return this.appletList.hashCode();
    }

    public String toString() {
        return a.v(new StringBuilder("OpenPlatformAppletList(appletList="), this.appletList, ')');
    }

    public OpenPlatformAppletList(List<OpenPlatformAppletItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "appletList");
        this.appletList = r5;
    }

    public /* synthetic */ OpenPlatformAppletList(List r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = new ArrayList();
    L5:
        this(r5);
    }
}
