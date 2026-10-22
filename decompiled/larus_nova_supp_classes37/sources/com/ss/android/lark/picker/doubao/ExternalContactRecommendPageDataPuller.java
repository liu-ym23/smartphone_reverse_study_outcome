package com.ss.android.lark.picker.doubao;

import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.picker.base.entity.ChatterCustomInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ktb.b;
import ktb.c;
import mtb.d;
import y3c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/picker/doubao/ExternalContactRecommendPageDataPuller;", "Lcom/ss/android/lark/search/dto/recommend/IRecommendPageDataPuller;", "<init>", "()V", "loadData", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "needHeader", "", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class ExternalContactRecommendPageDataPuller implements a {
    public static final Companion Companion = null;
    private static final Lazy<c> contactOfficeApi$delegate = null;
    private static final Lazy<b> contactOpenRepository$delegate = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/doubao/ExternalContactRecommendPageDataPuller$Companion;", "", "<init>", "()V", "contactOfficeApi", "Lcom/ss/android/lark/officesdk/contact/api/IInnerContactOfficeApi;", "getContactOfficeApi", "()Lcom/ss/android/lark/officesdk/contact/api/IInnerContactOfficeApi;", "contactOfficeApi$delegate", "Lkotlin/Lazy;", "contactOpenRepository", "Lcom/ss/android/lark/officesdk/contact/api/IContactOpenRepository;", "getContactOpenRepository", "()Lcom/ss/android/lark/officesdk/contact/api/IContactOpenRepository;", "contactOpenRepository$delegate", "convertOfficeContactItemToSearchChatterInfo", "Lcom/ss/android/lark/picker/base/entity/ChatterCustomInfo;", "model", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final c getContactOfficeApi() {
            return (c) ExternalContactRecommendPageDataPuller.access$getContactOfficeApi$delegate$cp().getValue();
        }

        private final b getContactOpenRepository() {
            return (b) ExternalContactRecommendPageDataPuller.access$getContactOpenRepository$delegate$cp().getValue();
        }

        public static final /* synthetic */ c access$getContactOfficeApi(Companion r0) {
            return r0.getContactOfficeApi();
        }

        public static final /* synthetic */ b access$getContactOpenRepository(Companion r0) {
            return r0.getContactOpenRepository();
        }

        public final ChatterCustomInfo convertOfficeContactItemToSearchChatterInfo(d r4) {
            Intrinsics.checkNotNullParameter(r4, "model");
            ChatterCustomInfo r0 = new ChatterCustomInfo();
            r0.setId(String.valueOf(r4.a));
            boolean r1 = true;
            r0.setType(1);
            r0.setAvatarKey(r4.g);
            r0.setName(r4.c);
            if (r4.d.length() == 0) goto L6;
            r1 = false;
        L6:
            if (r1 == false) goto L8;
            String r5 = r4.c;
        L9:
            r0.setTitle(r5);
            return r0;
        L8:
            r5 = r4.d + 65288 + r4.c + 65289;
            goto L9
        }
    }

    public ExternalContactRecommendPageDataPuller() {
    }

    public boolean canLoadMore() {
        return false;
    }

    public boolean needHeader() {
        return false;
    }

    static {
        Companion = new Companion(null);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        contactOfficeApi$delegate = LazyKt.lazy(r0, ExternalContactRecommendPageDataPuller$Companion$contactOfficeApi$2.INSTANCE);
        contactOpenRepository$delegate = LazyKt.lazy(r0, ExternalContactRecommendPageDataPuller$Companion$contactOpenRepository$2.INSTANCE);
    }

    public static final /* synthetic */ Lazy access$getContactOfficeApi$delegate$cp() {
        return contactOfficeApi$delegate;
    }

    public static final /* synthetic */ Lazy access$getContactOpenRepository$delegate$cp() {
        return contactOpenRepository$delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.picker.doubao.ExternalContactRecommendPageDataPuller$loadData$2] */
    public void loadData(final IGetDataCallback<List<SearchBaseInfo>> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        b r0 = Companion.access$getContactOpenRepository(Companion);
        if (r0 != 0) goto L6;
        UICallbackExecutor.execute(new AnonymousClass1(r3));
        return;
    L6:
        r0.b(new AnonymousClass2(r3));
    }

    public void onLoadMore(IGetDataCallback<List<SearchBaseInfo>> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
    }
}
