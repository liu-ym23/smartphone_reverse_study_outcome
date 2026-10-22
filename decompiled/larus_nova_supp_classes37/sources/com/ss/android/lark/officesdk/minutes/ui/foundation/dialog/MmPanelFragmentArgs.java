package com.ss.android.lark.officesdk.minutes.ui.foundation.dialog;

import android.os.Bundle;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006%"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/dialog/MmPanelFragmentArgs;", "Ljava/io/Serializable;", "registryTag", "", "heightConfig", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "isCancelable", "", "drawBehindNavigationBar", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;ZZ)V", "getRegistryTag", "()Ljava/lang/String;", "getHeightConfig", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "()Z", "getDrawBehindNavigationBar", "toBundle", "Landroid/os/Bundle;", "extraArgs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmPanelFragmentArgs implements Serializable {
    public static final a Companion = null;
    private final boolean drawBehindNavigationBar;
    private final MmPanelHeightConfig heightConfig;
    private final boolean isCancelable;
    private final String registryTag;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MmPanelFragmentArgs copy$default(MmPanelFragmentArgs r3, String r4, MmPanelHeightConfig r5, MmRecordingUILaunchMode r6, boolean r7, boolean r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.registryTag;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.heightConfig;
    L8:
        MmPanelHeightConfig r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.uiLaunchMode;
    L11:
        MmRecordingUILaunchMode r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isCancelable;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.drawBehindNavigationBar;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.registryTag;
    }

    public final MmPanelHeightConfig component2() {
        return this.heightConfig;
    }

    public final MmRecordingUILaunchMode component3() {
        return this.uiLaunchMode;
    }

    public final boolean component4() {
        return this.isCancelable;
    }

    public final boolean component5() {
        return this.drawBehindNavigationBar;
    }

    public final MmPanelFragmentArgs copy(String r8, MmPanelHeightConfig r9, MmRecordingUILaunchMode r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "registryTag");
        Intrinsics.checkNotNullParameter(r10, "uiLaunchMode");
        return new MmPanelFragmentArgs(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmPanelFragmentArgs) == true) goto L8;
        return false;
    L8:
        MmPanelFragmentArgs r6 = (MmPanelFragmentArgs) r5;
        if (Intrinsics.areEqual(this.registryTag, r6.registryTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.heightConfig, r6.heightConfig) == true) goto L15;
        return false;
    L15:
        if (this.uiLaunchMode == r6.uiLaunchMode) goto L18;
        return false;
    L18:
        if (this.isCancelable == r6.isCancelable) goto L21;
        return false;
    L21:
        if (this.drawBehindNavigationBar == r6.drawBehindNavigationBar) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.registryTag.hashCode() * 31;
        MmPanelHeightConfig r1 = this.heightConfig;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.uiLaunchMode.hashCode()) * 31;
        int r4 = 1231;
        if (this.isCancelable == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.drawBehindNavigationBar == true) goto L15;
        r4 = 1237;
    L15:
        return r6 + r4;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MmPanelFragmentArgs(registryTag=" + this.registryTag + ", heightConfig=" + this.heightConfig + ", uiLaunchMode=" + this.uiLaunchMode + ", isCancelable=" + this.isCancelable + ", drawBehindNavigationBar=" + this.drawBehindNavigationBar + ')';
    }

    public final boolean getDrawBehindNavigationBar() {
        return this.drawBehindNavigationBar;
    }

    public final MmPanelHeightConfig getHeightConfig() {
        return this.heightConfig;
    }

    public final String getRegistryTag() {
        return this.registryTag;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public final Bundle toBundle(Bundle r2) {
        if (r2 != null) goto L5;
        r2 = new Bundle();
    L5:
        Bundle r0 = new Bundle(r2);
        r0.putSerializable("key_mm_panel_fragment_args", this);
        return r0;
    }

    public static /* synthetic */ Bundle toBundle$default(MmPanelFragmentArgs r0, Bundle r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.toBundle(r1);
    }

    public MmPanelFragmentArgs(String r2, MmPanelHeightConfig r3, MmRecordingUILaunchMode r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "registryTag");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        this.registryTag = r2;
        this.heightConfig = r3;
        this.uiLaunchMode = r4;
        this.isCancelable = r5;
        this.drawBehindNavigationBar = r6;
    }

    public /* synthetic */ MmPanelFragmentArgs(String r7, MmPanelHeightConfig r8, MmRecordingUILaunchMode r9, boolean r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r8 = null;
    L5:
        MmPanelHeightConfig r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        r9 = MmRecordingUILaunchMode.UNKNOWN;
    L8:
        MmRecordingUILaunchMode r3 = r9;
        if ((r12 & 8) == 0) goto L11;
        boolean r4 = true;
    L13:
        if ((r12 & 16) == 0) goto L15;
        boolean r5 = false;
    L16:
        this(r7, r2, r3, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L11:
        r4 = r10;
        goto L13
    }
}
