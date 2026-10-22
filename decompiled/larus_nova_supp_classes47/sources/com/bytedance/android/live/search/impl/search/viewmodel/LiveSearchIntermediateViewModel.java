package com.bytedance.android.live.search.impl.search.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/viewmodel/LiveSearchIntermediateViewModel;", "Landroidx/lifecycle/ViewModel;", "", "openSearchSquare", "", "keyword", "openSearchSug", "Lcom/bytedance/android/live/search/impl/search/model/LiveSearchResultParam;", "param", "openSearch", "hideIntermediate", "", "canDismissKeyboardOnActionDown", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "searchKeyword$delegate", "Lkotlin/Lazy;", "getSearchKeyword", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "searchKeyword", "", "intermediateState$delegate", "getIntermediateState", "intermediateState", "openSearchParam$delegate", "getOpenSearchParam", "openSearchParam", "dismissKeyboardOnActionDown$delegate", "getDismissKeyboardOnActionDown", "dismissKeyboardOnActionDown", "inputValue$delegate", "getInputValue", "inputValue", "<init>", "()V", "Companion", "a", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchIntermediateViewModel extends ViewModel {
    public static final String CROSS_PLATFORM_NOT_INIT = "cross_platform_not_init";
    public static final a Companion = null;
    public static final int INTERMEDIATE_STATE_HIDE = 0;
    public static final int INTERMEDIATE_STATE_SQUARE = 1;
    public static final int INTERMEDIATE_STATE_SUG = 2;
    private final Lazy dismissKeyboardOnActionDown$delegate;
    private final Lazy inputValue$delegate;
    private final Lazy intermediateState$delegate;
    private final Lazy openSearchParam$delegate;
    private final Lazy searchKeyword$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final NextLiveData<Boolean> getDismissKeyboardOnActionDown() {
        return (NextLiveData) this.dismissKeyboardOnActionDown$delegate.getValue();
    }

    public final NextLiveData<String> getInputValue() {
        return (NextLiveData) this.inputValue$delegate.getValue();
    }

    public final NextLiveData<Integer> getIntermediateState() {
        return (NextLiveData) this.intermediateState$delegate.getValue();
    }

    public final NextLiveData<LiveSearchResultParam> getOpenSearchParam() {
        return (NextLiveData) this.openSearchParam$delegate.getValue();
    }

    public final NextLiveData<String> getSearchKeyword() {
        return (NextLiveData) this.searchKeyword$delegate.getValue();
    }

    public LiveSearchIntermediateViewModel() {
        LiveSearchIntermediateViewModel$searchKeyword$2 r0 = LiveSearchIntermediateViewModel$searchKeyword$2.INSTANCE;
        LazyThreadSafetyMode r1 = LazyThreadSafetyMode.NONE;
        this.searchKeyword$delegate = LazyKt.lazy(r1, r0);
        this.intermediateState$delegate = LazyKt.lazy(r1, LiveSearchIntermediateViewModel$intermediateState$2.INSTANCE);
        this.openSearchParam$delegate = LazyKt.lazy(r1, LiveSearchIntermediateViewModel$openSearchParam$2.INSTANCE);
        this.dismissKeyboardOnActionDown$delegate = LazyKt.lazy(r1, LiveSearchIntermediateViewModel$dismissKeyboardOnActionDown$2.INSTANCE);
        this.inputValue$delegate = LazyKt.lazy(r1, LiveSearchIntermediateViewModel$inputValue$2.INSTANCE);
    }

    public final boolean canDismissKeyboardOnActionDown() {
        Boolean r0 = (Boolean) getDismissKeyboardOnActionDown().getValue();
        if (r0 != null) goto L7;
        return true;
    L7:
        return r0.booleanValue();
    }

    public final void hideIntermediate() {
        getIntermediateState().setValue(0);
    }

    public final void openSearchSquare() {
        getIntermediateState().setValue(1);
    }

    public final void openSearch(LiveSearchResultParam r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        if (TextUtils.isEmpty(r2.getKeyword()) == false) goto L5;
        return;
    L5:
        getOpenSearchParam().setValue(r2);
        hideIntermediate();
    }

    public final void openSearchSug(String r3) {
        Intrinsics.checkNotNullParameter(r3, "keyword");
        Integer r0 = (Integer) getIntermediateState().getValue();
        if (r0 != null) goto L6;
    L10:
        getSearchKeyword().setValue(r3);
        getIntermediateState().setValue(2);
        return;
    L6:
        if (r0.intValue() != 2) goto L10;
        if (TextUtils.equals(r3, (CharSequence) getSearchKeyword().getValue()) == false) goto L10;
    }
}
