package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdatePanelGiftSearch;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h1;", "searchResult", "Ljava/util/List;", "getSearchResult", "()Ljava/util/List;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "eventTrack", "Ljava/util/Map;", "getEventTrack", "()Ljava/util/Map;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdatePanelGiftSearch extends GiftRepoAction {
    private final Map<String, String> eventTrack;
    private final List<h1> searchResult;

    public final Map<String, String> getEventTrack() {
        return this.eventTrack;
    }

    public final List<h1> getSearchResult() {
        return this.searchResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UpdatePanelGiftSearch(List<? extends h1> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "searchResult");
        super("UpdatePanelGiftSearch");
        this.searchResult = r2;
        this.eventTrack = r3;
    }
}
