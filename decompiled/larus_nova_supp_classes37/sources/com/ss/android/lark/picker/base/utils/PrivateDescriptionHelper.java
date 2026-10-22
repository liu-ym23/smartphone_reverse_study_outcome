package com.ss.android.lark.picker.base.utils;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.GetUserPrivateDescriptionsRequest;
import com.bytedance.lark.pb.contact.v1.PrivateDescriptionItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSecretP2PChatInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u000f0\u0014J\u0080\u0001\u0010\u0015\u001a\u00020\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00110\u00112\u0006\u0010\u0018\u001a\u00020\b2\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\u001a2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00110\u001a2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002JP\u0010\u001e\u001a\u00020\u000f2\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\u001a2\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00110\u001a2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 0\u001aH\u0002J4\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0%0$H\u0002J4\u0010&\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0%0$H\u0002J0\u0010'\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\u000f0\u0014H\u0002J\u0010\u0010(\u001a\u0004\u0018\u00010)*\u0004\u0018\u00010 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\t\u0010\u000b¨\u0006*"}, d2 = {"Lcom/ss/android/lark/picker/base/utils/PrivateDescriptionHelper;", "", "<init>", "()V", "TAG", "", "FEATURE_PRIVATE_DESCRIPTION_VISIBLE", "MAX_BATCH_USER_COUNT", "", "isPrivateDescriptionEnabled", "", "()Z", "isPrivateDescriptionEnabled$delegate", "Lkotlin/Lazy;", "apply", "", "data", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "callback", "Lkotlin/Function1;", "requestPrivateDescriptions", "batches", "", "index", "chatterInfoMap", "", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "secretInfoMap", "Lcom/ss/android/lark/search/dto/info/SearchSecretP2PChatInfo;", "applyPrivateDescriptions", "privateDescriptions", "Lcom/bytedance/lark/pb/contact/v1/PrivateDescriptionItem;", "collectChatterInfo", "item", "currentUserId", "", "", "collectSecretInfo", "notifyReady", "toPrivateChatterDescription", "Lcom/ss/android/lark/chat/entity/chatter/ChatterDescription;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class PrivateDescriptionHelper {
    private static final String FEATURE_PRIVATE_DESCRIPTION_VISIBLE = "im.signature.visibility.view";
    public static final PrivateDescriptionHelper INSTANCE = null;
    private static final int MAX_BATCH_USER_COUNT = 20;
    private static final String TAG = "LarkSearch.Common.PrivateDescriptionHelper";
    private static final Lazy isPrivateDescriptionEnabled$delegate = null;

    private PrivateDescriptionHelper() {
    }

    static {
        INSTANCE = new PrivateDescriptionHelper();
        isPrivateDescriptionEnabled$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    private final boolean isPrivateDescriptionEnabled() {
        return ((Boolean) isPrivateDescriptionEnabled$delegate.getValue()).booleanValue();
    }

    private final ChatterDescription toPrivateChatterDescription(PrivateDescriptionItem r6) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (Intrinsics.areEqual(r6.is_deleted, Boolean.TRUE) == true) goto L16;
        String r0 = r6.content;
        if (r0 == null) goto L17;
        ChatterDescription.Type r2 = ChatterDescription.Type.DEFAULT;
        Long r7 = r6.description_id;
        if (r7 == null) goto L11;
        long r3 = r7.longValue();
    L13:
        return new ChatterDescription(r0, r2, r3);
    L11:
        r3 = 0;
        goto L13
    L17:
        return null;
    L16:
        return null;
    }

    private final void notifyReady(final List<? extends SearchBaseInfo> r2, final Function1<? super List<? extends SearchBaseInfo>, Unit> r3) {
        UICallbackExecutor.execute(new AnonymousClass1(r3, r2));
    }

    public final void apply(List<? extends SearchBaseInfo> r9, Function1<? super List<? extends SearchBaseInfo>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (isPrivateDescriptionEnabled() == true) goto L5;
    L22:
        notifyReady(r9, r10);
        return;
    L5:
        if (r9.isEmpty() == true) goto L22;
        String r0 = PickerBaseModuleDependency.getDependency().getLoginUserId();
        LinkedHashMap r4 = new LinkedHashMap();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<T> r1 = r9.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        SearchSecretP2PChatInfo r2 = (SearchBaseInfo) r1.next();
        if ((r2 instanceof SearchChatterInfo) == true) goto L12;
        if ((r2 instanceof SearchSecretP2PChatInfo) == false) goto L9;
        INSTANCE.collectSecretInfo(r2, r0, r5);
        goto L9
    L12:
        INSTANCE.collectChatterInfo((SearchChatterInfo) r2, r0, r4);
        goto L9
    L16:
        List r3 = CollectionsKt.distinct(SetsKt.plus(r4.keySet(), r5.keySet()));
        if (r3.isEmpty() == false) goto L20;
        notifyReady(r9, r10);
        return;
    L20:
        requestPrivateDescriptions(CollectionsKt.chunked(r3, 20), 0, r4, r5, r9, r10);
    }

    private final void applyPrivateDescriptions(Map<Long, ? extends List<? extends SearchChatterInfo>> r6, Map<Long, ? extends List<? extends SearchSecretP2PChatInfo>> r7, Map<Long, PrivateDescriptionItem> r8) {
        Iterator<Map.Entry<Long, PrivateDescriptionItem>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L20;
        Map.Entry<Long, PrivateDescriptionItem> r0 = r9.next();
        long r1 = r0.getKey().longValue();
        PrivateDescriptionItem r2 = r0.getValue();
        ChatterDescription r3 = INSTANCE.toPrivateChatterDescription(r2);
        if (r3 == null) goto L4;
        List<? extends SearchChatterInfo> r4 = r6.get(Long.valueOf(r1));
        if (r4 == null) goto L14;
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        ((SearchChatterInfo) r5.next()).setChatterDescription(r3);
    L14:
        List<? extends SearchSecretP2PChatInfo> r10 = r7.get(Long.valueOf(r1));
        if (r10 == null) goto L4;
        Iterator<T> r11 = r10.iterator();
    L18:
        if (r11.hasNext() == false) goto L4;
        ((SearchSecretP2PChatInfo) r11.next()).setChatterDescription(r3);
        goto L18
    }

    private final void collectChatterInfo(SearchChatterInfo r3, String r4, Map<Long, List<SearchChatterInfo>> r5) {
        if (r3.getChatterType() == Chatter.ChatterType.USER) goto L6;
        return;
    L6:
        if (r3.isP2pCryptoChat() == false) goto L16;
        String r0 = r3.getCryptoChatterId();
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        String r2 = r3.getCryptoChatterId();
    L18:
        if (Intrinsics.areEqual(r2, r4) == false) goto L20;
        return;
    L20:
        if (r2 == null) goto L28;
        Long r6 = StringsKt.toLongOrNull(r2);
        if (r6 == null) goto L29;
        Long r7 = Long.valueOf(r6.longValue());
        List<SearchChatterInfo> r8 = r5.get(r7);
        if (r8 != null) goto L26;
        r8 = new ArrayList();
        r5.put(r7, r8);
    L26:
        r8.add(r3);
        return;
    L29:
        return;
    L28:
        return;
    L10:
        if (StringsKt.isBlank(r0) == true) goto L13;
        r1 = false;
    L16:
        r2 = r3.getId();
        goto L18
    }

    private final void collectSecretInfo(SearchSecretP2PChatInfo r3, String r4, Map<Long, List<SearchSecretP2PChatInfo>> r5) {
        if (r3.getChatterType() == Chatter.ChatterType.USER) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.getChatterId(), r4) == true) goto L16;
        Long r6 = StringsKt.toLongOrNull(r3.getChatterId());
        if (r6 == null) goto L15;
        Long r7 = Long.valueOf(r6.longValue());
        List<SearchSecretP2PChatInfo> r0 = r5.get(r7);
        if (r0 != null) goto L12;
        r0 = new ArrayList();
        r5.put(r7, r0);
    L12:
        r0.add(r3);
        return;
    L15:
        return;
    }

    public static final /* synthetic */ void access$applyPrivateDescriptions(PrivateDescriptionHelper r0, Map r1, Map r2, Map r3) {
        r0.applyPrivateDescriptions(r1, r2, r3);
    }

    private final void requestPrivateDescriptions(final List<? extends List<Long>> r12, final int r13, final Map<Long, ? extends List<? extends SearchChatterInfo>> r14, final Map<Long, ? extends List<? extends SearchSecretP2PChatInfo>> r15, final List<? extends SearchBaseInfo> r16, final Function1<? super List<? extends SearchBaseInfo>, Unit> r17) {
        if (r13 < r12.size()) goto L6;
        notifyReady(r16, r17);
        return;
    L6:
        GetUserPrivateDescriptionsRequest.Builder r8 = new GetUserPrivateDescriptionsRequest.Builder().user_ids((List) ListProtector.get(r12, r13)).source(GetUserPrivateDescriptionsRequest.Source.PICKER).sync_data_strategy(SyncDataStrategy.TRY_LOCAL);
        SdkSender.asynSendRequestNonWrap(Command.GET_USER_PRIVATE_DESCRIPTIONS, r8, new C03261(r14, r15, r12, r13, r16, r17), C03272.INSTANCE);
    }

    public static final /* synthetic */ void access$requestPrivateDescriptions(PrivateDescriptionHelper r0, List r1, int r2, Map r3, Map r4, List r5, Function1 r6) {
        r0.requestPrivateDescriptions(r1, r2, r3, r4, r5, r6);
    }
}
