package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrNerStatisticV2;", "Ljava/io/Serializable;", "userInfoList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/UserInfoHitPoint;", "Lkotlin/collections/ArrayList;", "adoptionRate", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrAdoptionRate;", "<init>", "(Ljava/util/ArrayList;Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrAdoptionRate;)V", "getUserInfoList", "()Ljava/util/ArrayList;", "getAdoptionRate", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrAdoptionRate;", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class AsrNerStatisticV2 implements Serializable {
    private final AsrAdoptionRate adoptionRate;
    private final ArrayList<UserInfoHitPoint> userInfoList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AsrNerStatisticV2 copy$default(AsrNerStatisticV2 r0, ArrayList r1, AsrAdoptionRate r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.userInfoList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.adoptionRate;
    L9:
        return r0.copy(r1, r2);
    }

    public final ArrayList<UserInfoHitPoint> component1() {
        return this.userInfoList;
    }

    public final AsrAdoptionRate component2() {
        return this.adoptionRate;
    }

    public final AsrNerStatisticV2 copy(ArrayList<UserInfoHitPoint> r2, AsrAdoptionRate r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoList");
        Intrinsics.checkNotNullParameter(r3, "adoptionRate");
        return new AsrNerStatisticV2(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AsrNerStatisticV2) == true) goto L8;
        return false;
    L8:
        AsrNerStatisticV2 r6 = (AsrNerStatisticV2) r5;
        if (Intrinsics.areEqual(this.userInfoList, r6.userInfoList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.adoptionRate, r6.adoptionRate) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.userInfoList.hashCode() * 31) + this.adoptionRate.hashCode();
    }

    public String toString() {
        return "AsrNerStatisticV2(userInfoList=" + this.userInfoList + ", adoptionRate=" + this.adoptionRate + ')';
    }

    public final AsrAdoptionRate getAdoptionRate() {
        return this.adoptionRate;
    }

    public final ArrayList<UserInfoHitPoint> getUserInfoList() {
        return this.userInfoList;
    }

    public AsrNerStatisticV2(ArrayList<UserInfoHitPoint> r2, AsrAdoptionRate r3) {
        Intrinsics.checkNotNullParameter(r2, "userInfoList");
        Intrinsics.checkNotNullParameter(r3, "adoptionRate");
        this.userInfoList = r2;
        this.adoptionRate = r3;
    }
}
