package com.larus.photopicker.v2.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\r\u001a\u00020(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u000e0\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\tR\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u000e0\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR)\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u000e0\u001a0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\tR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\tR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR\u001f\u0010&\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u000e0\u000e0\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\t¨\u0006,"}, d2 = {"Lcom/larus/photopicker/v2/impl/viewmodel/BottomSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "lastSlide", "", "onSlide", "Landroidx/lifecycle/MutableLiveData;", "getOnSlide", "()Landroidx/lifecycle/MutableLiveData;", "bottomSheetOnStateChanged", "", "getBottomSheetOnStateChanged", "closeBottomSheet", "", "getCloseBottomSheet", "disallowIntercept", "kotlin.jvm.PlatformType", "getDisallowIntercept", "selectedResult", "", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "getSelectedResult", "selectedResultFromConfirmButton", "getSelectedResultFromConfirmButton", "selectionMultiConfirmed", "Lkotlin/Pair;", "getSelectionMultiConfirmed", "guideClickCallback", "getGuideClickCallback", "navigationBarColor", "getNavigationBarColor", "onBackPressed", "getOnBackPressed", "onBackPressedNeedHandle", "getOnBackPressedNeedHandle", "clickPermission", "getClickPermission", "isOriginalImageChecked", "toggleOriginalImageChecked", "", "calculateBottomSheetSlide", "slideOffset", "requestDisallowInterceptTouchEvent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BottomSheetViewModel extends ViewModel {
    private final MutableLiveData<Integer> bottomSheetOnStateChanged;
    private final MutableLiveData<Boolean> clickPermission;
    private final MutableLiveData<Boolean> closeBottomSheet;
    private final MutableLiveData<Boolean> disallowIntercept;
    private final MutableLiveData<Boolean> guideClickCallback;
    private final MutableLiveData<Boolean> isOriginalImageChecked;
    private float lastSlide;
    private final MutableLiveData<Integer> navigationBarColor;
    private final MutableLiveData<Boolean> onBackPressed;
    private final MutableLiveData<Boolean> onBackPressedNeedHandle;
    private final MutableLiveData<Float> onSlide;
    private final MutableLiveData<List<op9.d>> selectedResult;
    private final MutableLiveData<Boolean> selectedResultFromConfirmButton;
    private final MutableLiveData<Pair<List<op9.d>, Boolean>> selectionMultiConfirmed;

    public final void closeBottomSheet() {
        this.closeBottomSheet.setValue(Boolean.TRUE);
    }

    public final void toggleOriginalImageChecked() {
        Boolean r0 = (Boolean) this.isOriginalImageChecked.getValue();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        this.isOriginalImageChecked.setValue(Boolean.valueOf(!r1));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public BottomSheetViewModel() {
        this.lastSlide = -1.0f;
        this.onSlide = new MutableLiveData();
        this.bottomSheetOnStateChanged = new MutableLiveData();
        this.closeBottomSheet = new MutableLiveData();
        Boolean r1 = Boolean.FALSE;
        this.disallowIntercept = new MutableLiveData(r1);
        this.selectedResult = new MutableLiveData();
        this.selectedResultFromConfirmButton = new MutableLiveData(r1);
        this.selectionMultiConfirmed = new MutableLiveData();
        this.guideClickCallback = new MutableLiveData();
        this.navigationBarColor = new MutableLiveData();
        this.onBackPressed = new MutableLiveData();
        this.onBackPressedNeedHandle = new MutableLiveData();
        this.clickPermission = new MutableLiveData();
        this.isOriginalImageChecked = new MutableLiveData(r1);
    }

    public final MutableLiveData<Integer> getBottomSheetOnStateChanged() {
        return this.bottomSheetOnStateChanged;
    }

    public final MutableLiveData<Boolean> getClickPermission() {
        return this.clickPermission;
    }

    public final MutableLiveData<Boolean> getCloseBottomSheet() {
        return this.closeBottomSheet;
    }

    public final MutableLiveData<Boolean> getDisallowIntercept() {
        return this.disallowIntercept;
    }

    public final MutableLiveData<Boolean> getGuideClickCallback() {
        return this.guideClickCallback;
    }

    public final MutableLiveData<Integer> getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final MutableLiveData<Boolean> getOnBackPressed() {
        return this.onBackPressed;
    }

    public final MutableLiveData<Boolean> getOnBackPressedNeedHandle() {
        return this.onBackPressedNeedHandle;
    }

    public final MutableLiveData<Float> getOnSlide() {
        return this.onSlide;
    }

    public final MutableLiveData<List<op9.d>> getSelectedResult() {
        return this.selectedResult;
    }

    public final MutableLiveData<Boolean> getSelectedResultFromConfirmButton() {
        return this.selectedResultFromConfirmButton;
    }

    public final MutableLiveData<Pair<List<op9.d>, Boolean>> getSelectionMultiConfirmed() {
        return this.selectionMultiConfirmed;
    }

    public final MutableLiveData<Boolean> isOriginalImageChecked() {
        return this.isOriginalImageChecked;
    }

    public final void calculateBottomSheetSlide(float r5) {
        float r0 = this.lastSlide;
        boolean r2 = true;
        if (r0 != (-1.0f)) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
    L15:
        this.lastSlide = r5;
        return;
    L8:
        if (r0 == r5) goto L11;
        r2 = false;
    L11:
        if (r2 == true) goto L15;
        this.lastSlide = r5;
        this.onSlide.setValue(Float.valueOf(r5));
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void requestDisallowInterceptTouchEvent(boolean r2) {
        this.disallowIntercept.setValue(Boolean.valueOf(r2));
    }
}
