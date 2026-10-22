package com.ss.android.lark.framework.assembly.utils;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@AppConfig(key = "android_pad_config")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/framework/assembly/utils/PadSettingValue;", "", "whiteList", "", "", "blockList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getWhiteList", "()Ljava/util/List;", "getBlockList", "utils-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PadSettingValue {

    @SerializedName("pad_model_block_list")
    private final List<String> blockList;

    @SerializedName("pad_model_white_list")
    private final List<String> whiteList;

    public PadSettingValue() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    public final List<String> getBlockList() {
        return this.blockList;
    }

    public final List<String> getWhiteList() {
        return this.whiteList;
    }

    public PadSettingValue(List<String> r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "whiteList");
        Intrinsics.checkNotNullParameter(r3, "blockList");
        this.whiteList = r2;
        this.blockList = r3;
    }

    public /* synthetic */ PadSettingValue(List r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
