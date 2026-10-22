package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.recommand.DefaultRecommendDataPuller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import y3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0014\u001a\u00020\u00152\u001b\b\u0002\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/picker/config/RecommendListConfig;", "Lcom/ss/android/lark/picker/config/BaseRecommendConfig;", "permissions", "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/config/Permissions;)V", "getPermissions", "()Lcom/ss/android/lark/picker/config/Permissions;", "recommendDataPuller", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "getRecommendDataPuller$picker_release", "()Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "setRecommendDataPuller$picker_release", "(Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;)V", "enableNoMoreFooter", "", "getEnableNoMoreFooter$picker_release", "()Z", "setEnableNoMoreFooter$picker_release", "(Z)V", "defaultPuller", "", "config", "Lkotlin/Function1;", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "Lkotlin/ExtensionFunctionType;", "customPuller", "puller", "enable", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class RecommendListConfig implements BaseRecommendConfig {
    private boolean enableNoMoreFooter;
    private final Permissions permissions;
    private a recommendDataPuller;

    public final boolean getEnableNoMoreFooter$picker_release() {
        return this.enableNoMoreFooter;
    }

    @Override // com.ss.android.lark.picker.config.BaseRecommendConfig
    public Permissions getPermissions() {
        return this.permissions;
    }

    public final a getRecommendDataPuller$picker_release() {
        return this.recommendDataPuller;
    }

    public RecommendListConfig(Permissions r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
        this.permissions = r2;
        this.recommendDataPuller = new DefaultRecommendDataPuller();
    }

    public final void customPuller(a r2) {
        Intrinsics.checkNotNullParameter(r2, "puller");
        this.recommendDataPuller = r2;
    }

    public final void defaultPuller(Function1<? super SearcherConfig, Unit> r3) {
        SearcherConfig r0 = new SearcherConfig(getPermissions());
        if (r3 == null) goto L5;
        r3.invoke(r0);
    L5:
        DefaultRecommendDataPuller r4 = new DefaultRecommendDataPuller();
        this.recommendDataPuller = r4;
        if ((r4 instanceof DefaultRecommendDataPuller) == false) goto L9;
        r4.setConfig(r0);
        return;
    }

    public final void enableNoMoreFooter(boolean r1) {
        this.enableNoMoreFooter = r1;
    }

    public final void setEnableNoMoreFooter$picker_release(boolean r1) {
        this.enableNoMoreFooter = r1;
    }

    public final void setRecommendDataPuller$picker_release(a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.recommendDataPuller = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void defaultPuller$default(RecommendListConfig r0, Function1 r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.defaultPuller(r1);
    }

    public static /* synthetic */ void enableNoMoreFooter$default(RecommendListConfig r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.enableNoMoreFooter(r1);
    }
}
