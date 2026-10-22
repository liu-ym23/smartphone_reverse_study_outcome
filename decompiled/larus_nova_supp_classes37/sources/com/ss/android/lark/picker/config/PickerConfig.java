package com.ss.android.lark.picker.config;

import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@PickerMaker
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010-\u001a\u00020\u000b2\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1J\u001f\u00102\u001a\u0002002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1J\u001f\u00103\u001a\u0002002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1J\u001f\u00104\u001a\u0002002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1J\b\u00105\u001a\u0004\u0018\u00010\u0017J\u001f\u00106\u001a\u0002002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1J\u001f\u0010\"\u001a\u0002002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1J\u001f\u00107\u001a\u0002002\u0017\u0010.\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002000/¢\u0006\u0002\b1R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010*\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u00069"}, d2 = {"Lcom/ss/android/lark/picker/config/PickerConfig;", "", "dependency", "Lcom/ss/android/lark/picker/Dependency;", "permissions", "Lcom/ss/android/lark/picker/config/Permissions;", "<init>", "(Lcom/ss/android/lark/picker/Dependency;Lcom/ss/android/lark/picker/config/Permissions;)V", "getDependency$picker_release", "()Lcom/ss/android/lark/picker/Dependency;", "searcherConfig", "Lcom/ss/android/lark/picker/config/SearcherConfig;", "getSearcherConfig$picker_release", "()Lcom/ss/android/lark/picker/config/SearcherConfig;", "setSearcherConfig$picker_release", "(Lcom/ss/android/lark/picker/config/SearcherConfig;)V", "recommendListConfig", "Lcom/ss/android/lark/picker/config/RecommendListConfig;", "getRecommendListConfig$picker_release", "()Lcom/ss/android/lark/picker/config/RecommendListConfig;", "setRecommendListConfig$picker_release", "(Lcom/ss/android/lark/picker/config/RecommendListConfig;)V", "addressBookConfig", "Lcom/ss/android/lark/picker/config/AddressBookConfig;", "getAddressBookConfig$picker_release", "()Lcom/ss/android/lark/picker/config/AddressBookConfig;", "setAddressBookConfig$picker_release", "(Lcom/ss/android/lark/picker/config/AddressBookConfig;)V", "scenarioConfig", "Lcom/ss/android/lark/picker/config/ScenarioConfig;", "getScenarioConfig$picker_release", "()Lcom/ss/android/lark/picker/config/ScenarioConfig;", "setScenarioConfig$picker_release", "(Lcom/ss/android/lark/picker/config/ScenarioConfig;)V", "extra", "Lcom/ss/android/lark/picker/config/PickerExtra;", "getExtra$picker_release", "()Lcom/ss/android/lark/picker/config/PickerExtra;", "setExtra$picker_release", "(Lcom/ss/android/lark/picker/config/PickerExtra;)V", "value", "Lcom/ss/android/lark/picker/config/DoubaoConfig;", "doubaoConfig", "getDoubaoConfig", "()Lcom/ss/android/lark/picker/config/DoubaoConfig;", "searcher", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "recommendList", "addressBook", "doubao", "consumeAddressBookConfig", "scenario", "searcherExtra", "Lcom/ss/android/lark/picker/config/TopExtra;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public class PickerConfig {
    private AddressBookConfig addressBookConfig;
    private final transient Dependency dependency;
    private DoubaoConfig doubaoConfig;
    private PickerExtra extra;
    private final Permissions permissions;
    private RecommendListConfig recommendListConfig;
    private ScenarioConfig scenarioConfig;
    private SearcherConfig searcherConfig;

    public final AddressBookConfig consumeAddressBookConfig() {
        AddressBookConfig r0 = this.addressBookConfig;
        this.addressBookConfig = null;
        return r0;
    }

    public final AddressBookConfig getAddressBookConfig$picker_release() {
        return this.addressBookConfig;
    }

    public final Dependency getDependency$picker_release() {
        return this.dependency;
    }

    public final DoubaoConfig getDoubaoConfig() {
        return this.doubaoConfig;
    }

    public final PickerExtra getExtra$picker_release() {
        return this.extra;
    }

    public final RecommendListConfig getRecommendListConfig$picker_release() {
        return this.recommendListConfig;
    }

    public final ScenarioConfig getScenarioConfig$picker_release() {
        return this.scenarioConfig;
    }

    public final SearcherConfig getSearcherConfig$picker_release() {
        return this.searcherConfig;
    }

    public final void addressBook(Function1<? super AddressBookConfig, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (this.addressBookConfig != null) goto L5;
        this.addressBookConfig = new AddressBookConfig(this.permissions);
    L5:
        AddressBookConfig r0 = this.addressBookConfig;
        if (r0 == null) goto L9;
        r3.invoke(r0);
        return;
    }

    public final void doubao(Function1<? super DoubaoConfig, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        if (this.doubaoConfig != null) goto L5;
        this.doubaoConfig = new DoubaoConfig();
    L5:
        DoubaoConfig r0 = this.doubaoConfig;
        if (r0 == null) goto L9;
        r2.invoke(r0);
        return;
    }

    public final void extra(Function1<? super PickerExtra, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        r2.invoke(this.extra);
    }

    public final void recommendList(Function1<? super RecommendListConfig, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (this.recommendListConfig != null) goto L5;
        this.recommendListConfig = new RecommendListConfig(this.permissions);
    L5:
        RecommendListConfig r0 = this.recommendListConfig;
        if (r0 == null) goto L9;
        r3.invoke(r0);
        return;
    }

    public final void scenario(Function1<? super ScenarioConfig, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        if (this.scenarioConfig != null) goto L5;
        this.scenarioConfig = new ScenarioConfig(this.permissions);
    L5:
        ScenarioConfig r0 = this.scenarioConfig;
        if (r0 == null) goto L9;
        r3.invoke(r0);
        return;
    }

    public final SearcherConfig searcher(Function1<? super SearcherConfig, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "init");
        SearcherConfig r0 = new SearcherConfig(this.permissions);
        this.searcherConfig = r0;
        r3.invoke(r0);
        return r0;
    }

    public final void searcherExtra(Function1<? super TopExtra, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "init");
        SearcherConfig r0 = this.searcherConfig;
        if (r0 == null) goto L8;
        TopExtra r1 = r0.getExtra();
        if (r1 == null) goto L9;
        r2.invoke(r1);
        return;
    L9:
        return;
    }

    public final void setAddressBookConfig$picker_release(AddressBookConfig r1) {
        this.addressBookConfig = r1;
    }

    public final void setExtra$picker_release(PickerExtra r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.extra = r2;
    }

    public final void setRecommendListConfig$picker_release(RecommendListConfig r1) {
        this.recommendListConfig = r1;
    }

    public final void setScenarioConfig$picker_release(ScenarioConfig r1) {
        this.scenarioConfig = r1;
    }

    public final void setSearcherConfig$picker_release(SearcherConfig r1) {
        this.searcherConfig = r1;
    }

    public PickerConfig(Dependency r2, Permissions r3) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        Intrinsics.checkNotNullParameter(r3, "permissions");
        this.dependency = r2;
        this.permissions = r3;
        this.extra = new PickerExtra();
    }
}
