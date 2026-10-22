package com.ss.android.lark.picker.doubao.organization;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.breadcrumb.UDBreadcrumb;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.entity.ChatterCustomInfo;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchDepartmentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ktb.b;
import mtb.c;
import mtb.i;
import mtb.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00014\b\u0000\u0018\u0000 S2\u00020\u0001:\u0002STB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0086\u0001\u00106\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020*2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0%2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020+0.J\u0006\u00109\u001a\u00020+J\u0006\u0010:\u001a\u00020*J\u0006\u0010;\u001a\u00020+J\u0006\u0010<\u001a\u00020+J\u0010\u0010=\u001a\u00020+2\b\u0010>\u001a\u0004\u0018\u00010?J\u0006\u0010@\u001a\u00020+J\u000e\u0010A\u001a\u00020+2\u0006\u00108\u001a\u00020*J\b\u0010B\u001a\u00020+H\u0002J\u0010\u0010C\u001a\u00020+2\u0006\u0010D\u001a\u00020\u000eH\u0002J\u0010\u0010E\u001a\u00020+2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u000200H\u0002J\b\u0010J\u001a\u00020+H\u0002J\b\u0010K\u001a\u00020+H\u0002J\u0010\u0010L\u001a\u00020+2\u0006\u00109\u001a\u00020*H\u0002J\u0010\u0010M\u001a\u00020+2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020'2\u0006\u0010N\u001a\u00020OH\u0002J\f\u0010Q\u001a\u00020&*\u00020OH\u0002J\f\u0010R\u001a\u00020!*\u00020OH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010(\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020+0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105¨\u0006U"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "breadcrumbView", "Lcom/larksuite/component/universe_design/breadcrumb/UDBreadcrumb;", "breadcrumbListView", "Landroidx/recyclerview/widget/RecyclerView;", "listView", "loadingView", "Landroid/view/View;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "emptyView", "Landroid/widget/TextView;", "adapter", "Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter;", "pageStack", "", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView$PageState;", "breadcrumbTextColors", "Landroid/content/res/ColorStateList;", "getBreadcrumbTextColors", "()Landroid/content/res/ColorStateList;", "breadcrumbTextColors$delegate", "Lkotlin/Lazy;", "repository", "Lcom/ss/android/lark/officesdk/contact/api/IContactOpenRepository;", "organizationTitle", "", "contactsTitle", "nextLevelTitle", "itemStateProvider", "Lkotlin/Function1;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "onItemSelected", "Lkotlin/Function2;", "", "", "onVisibilityChanged", "onListDrag", "Lkotlin/Function0;", "requestGeneration", "", "isShowing", "isSearchActive", "breadcrumbChildAttachListener", "com/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView$breadcrumbChildAttachListener$1", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView$breadcrumbChildAttachListener$1;", "bind", "isDepartmentSelectable", "isMultipleSelect", "show", "onBackPressed", "dismiss", "destroy", "updateSearchQuery", AppbrandHostConstants.Schema_RESERVED_FIELD.QUERY, "", "refreshSelection", "updateMultipleSelect", "updateVisibility", "applyBreadcrumbTextStyle", "view", "enterDepartment", "department", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "navigateToBreadcrumb", "index", "renderCurrentPage", "loadCurrentPage", "updateLoading", "toggleSelection", "item", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "resolveItemState", "toSearchInfo", "stableId", "Companion", "PageState", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoOrganizationPickerView extends FrameLayout {
    private static final float BREADCRUMB_TEXT_SIZE_SP = 17.0f;
    public static final Companion Companion = null;
    private static final int PAGE_SIZE = 100;
    private static final String ROOT_DEPARTMENT_ID = "0";
    private static final String TAG = "DoubaoOrganizationPicker";
    private final OrganizationAdapter adapter;
    private final DoubaoOrganizationPickerView$breadcrumbChildAttachListener$1 breadcrumbChildAttachListener;
    private final RecyclerView breadcrumbListView;
    private final Lazy breadcrumbTextColors$delegate;
    private final UDBreadcrumb breadcrumbView;
    private String contactsTitle;
    private final TextView emptyView;
    private boolean isSearchActive;
    private boolean isShowing;
    private Function1<? super SearchBaseInfo, DoubaoOrganizationItemState> itemStateProvider;
    private final RecyclerView listView;
    private final UDLoadingDrawable loadingDrawable;
    private final View loadingView;
    private String nextLevelTitle;
    private Function2<? super SearchBaseInfo, ? super Boolean, Unit> onItemSelected;
    private Function0<Unit> onListDrag;
    private Function1<? super Boolean, Unit> onVisibilityChanged;
    private String organizationTitle;
    private final List<PageState> pageStack;
    private b repository;
    private int requestGeneration;

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<c, DoubaoOrganizationItemState> {
        public AnonymousClass2(Object r8) {
            super(1, r8, DoubaoOrganizationPickerView.class, "resolveItemState", "resolveItemState(Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;)Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", 0);
        }

        public final DoubaoOrganizationItemState invoke(c r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            return DoubaoOrganizationPickerView.access$resolveItemState((DoubaoOrganizationPickerView) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((c) r1);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<c, Unit> {
        public AnonymousClass3(Object r8) {
            super(1, r8, DoubaoOrganizationPickerView.class, "toggleSelection", "toggleSelection(Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;)V", 0);
        }

        public final void invoke(c r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            DoubaoOrganizationPickerView.access$toggleSelection((DoubaoOrganizationPickerView) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((c) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<i, Unit> {
        public AnonymousClass4(Object r8) {
            super(1, r8, DoubaoOrganizationPickerView.class, "enterDepartment", "enterDepartment(Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;)V", 0);
        }

        public final void invoke(i r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            DoubaoOrganizationPickerView.access$enterDepartment((DoubaoOrganizationPickerView) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((i) r1);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView$Companion;", "", "<init>", "()V", "TAG", "", "ROOT_DEPARTMENT_ID", "PAGE_SIZE", "", "BREADCRUMB_TEXT_SIZE_SP", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0082\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003JQ\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001c\"\u0004\b\u001f\u0010\u001e¨\u0006+"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationPickerView$PageState;", "", "department", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "items", "", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "loadedItemIds", "", "", "nextOffset", "", "hasMore", "", "isLoading", "<init>", "(Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;Ljava/util/List;Ljava/util/Set;IZZ)V", "getDepartment", "()Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "getItems", "()Ljava/util/List;", "getLoadedItemIds", "()Ljava/util/Set;", "getNextOffset", "()I", "setNextOffset", "(I)V", "getHasMore", "()Z", "setHasMore", "(Z)V", "setLoading", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class PageState {
        private final i department;
        private boolean hasMore;
        private boolean isLoading;
        private final List<c> items;
        private final Set<String> loadedItemIds;
        private int nextOffset;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PageState copy$default(PageState r4, i r5, List r6, Set r7, int r8, boolean r9, boolean r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.department;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.items;
        L8:
            List r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.loadedItemIds;
        L11:
            Set r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.nextOffset;
        L14:
            int r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.hasMore;
        L17:
            boolean r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.isLoading;
        L20:
            i r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final i component1() {
            return this.department;
        }

        public final List<c> component2() {
            return this.items;
        }

        public final Set<String> component3() {
            return this.loadedItemIds;
        }

        public final int component4() {
            return this.nextOffset;
        }

        public final boolean component5() {
            return this.hasMore;
        }

        public final boolean component6() {
            return this.isLoading;
        }

        public final PageState copy(i r9, List<c> r10, Set<String> r11, int r12, boolean r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r9, "department");
            Intrinsics.checkNotNullParameter(r10, "items");
            Intrinsics.checkNotNullParameter(r11, "loadedItemIds");
            return new PageState(r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PageState) == true) goto L8;
            return false;
        L8:
            PageState r6 = (PageState) r5;
            if (Intrinsics.areEqual(this.department, r6.department) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.items, r6.items) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.loadedItemIds, r6.loadedItemIds) == true) goto L18;
            return false;
        L18:
            if (this.nextOffset == r6.nextOffset) goto L21;
            return false;
        L21:
            if (this.hasMore == r6.hasMore) goto L24;
            return false;
        L24:
            if (this.isLoading == r6.isLoading) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((this.department.hashCode() * 31) + this.items.hashCode()) * 31) + this.loadedItemIds.hashCode()) * 31) + this.nextOffset) * 31;
            int r2 = 1231;
            if (this.hasMore == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.isLoading == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public String toString() {
            return "PageState(department=" + this.department + ", items=" + this.items + ", loadedItemIds=" + this.loadedItemIds + ", nextOffset=" + this.nextOffset + ", hasMore=" + this.hasMore + ", isLoading=" + this.isLoading + ')';
        }

        public final i getDepartment() {
            return this.department;
        }

        public final boolean getHasMore() {
            return this.hasMore;
        }

        public final List<c> getItems() {
            return this.items;
        }

        public final Set<String> getLoadedItemIds() {
            return this.loadedItemIds;
        }

        public final int getNextOffset() {
            return this.nextOffset;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final void setHasMore(boolean r1) {
            this.hasMore = r1;
        }

        public final void setLoading(boolean r1) {
            this.isLoading = r1;
        }

        public final void setNextOffset(int r1) {
            this.nextOffset = r1;
        }

        public PageState(i r2, List<c> r3, Set<String> r4, int r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "department");
            Intrinsics.checkNotNullParameter(r3, "items");
            Intrinsics.checkNotNullParameter(r4, "loadedItemIds");
            this.department = r2;
            this.items = r3;
            this.loadedItemIds = r4;
            this.nextOffset = r5;
            this.hasMore = r6;
            this.isLoading = r7;
        }

        public /* synthetic */ PageState(i r8, List r9, Set r10, int r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
            if ((r14 & 2) == 0) goto L5;
            r9 = new ArrayList();
        L5:
            List r2 = r9;
            if ((r14 & 4) == 0) goto L8;
            r10 = new LinkedHashSet();
        L8:
            Set r3 = r10;
            if ((r14 & 8) == 0) goto L11;
            int r4 = 0;
        L13:
            if ((r14 & 16) == 0) goto L15;
            boolean r5 = true;
        L17:
            if ((r14 & 32) == 0) goto L19;
            boolean r6 = false;
        L20:
            this(r8, r2, r3, r4, r5, r6);
            return;
        L19:
            r6 = r13;
            goto L20
        L15:
            r5 = r12;
            goto L17
        L11:
            r4 = r11;
            goto L13
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DoubaoOrganizationPickerView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        AttributeSet r0 = null;
        this(r3, r0, 2, r0);
    }

    private final ColorStateList getBreadcrumbTextColors() {
        return (ColorStateList) this.breadcrumbTextColors$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView$loadCurrentPage$1] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void loadCurrentPage() {
        b r0 = this.repository;
        if (r0 != 0) goto L5;
        return;
    L5:
        final PageState r1 = (PageState) CollectionsKt.lastOrNull(this.pageStack);
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isLoading() == false) goto L11;
        return;
    L11:
        if (r1.getHasMore() == false) goto L16;
        r1.setLoading(true);
        updateLoading(r1.getItems().isEmpty());
        this.emptyView.setVisibility(8);
        final int r2 = this.requestGeneration;
        r0.a(r1.getDepartment().b, r1.getNextOffset(), new AnonymousClass1(this, r2, r1));
        return;
    }

    private final void renderCurrentPage() {
        PageState r0 = (PageState) CollectionsKt.lastOrNull(this.pageStack);
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        int r4 = 0;
        final List r2 = CollectionsKt.mutableListOf(new String[]{this.contactsTitle});
        List<PageState> r3 = this.pageStack;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r6 = r3.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        r5.add(((PageState) r6.next()).getDepartment().a);
        goto L7
    L9:
        r2.addAll(r5);
        this.breadcrumbView.setItems(r2);
        this.breadcrumbView.post(new RunnableC03682(this, r2));
        this.adapter.submit(r0.getItems());
        if (r0.isLoading() == true) goto L12;
    L14:
        r1 = false;
    L15:
        updateLoading(r1);
        TextView r7 = this.emptyView;
        if (r0.isLoading() == false) goto L18;
    L22:
        r4 = 8;
    L23:
        r7.setVisibility(r4);
        return;
    L18:
        if (r0.getItems().isEmpty() == false) goto L22;
        if (r0.getHasMore() == true) goto L22;
    L12:
        if (r0.getItems().isEmpty() == false) goto L14;
        goto L14
    }

    private final void updateVisibility() {
        if (this.isShowing == true) goto L5;
    L7:
        int r0 = 8;
    L8:
        setVisibility(r0);
        return;
    L5:
        if (this.isSearchActive == true) goto L7;
        r0 = 0;
        goto L8
    }

    public final void destroy() {
        RecyclerView r0 = this.breadcrumbListView;
        if (r0 == null) goto L5;
        r0.removeOnChildAttachStateChangeListener(this.breadcrumbChildAttachListener);
    L5:
        dismiss();
    }

    public final void dismiss() {
        if (this.isShowing == true) goto L5;
        return;
    L5:
        this.requestGeneration++;
        this.isShowing = false;
        updateLoading(false);
        setVisibility(8);
        this.pageStack.clear();
        this.onVisibilityChanged.invoke(Boolean.FALSE);
    }

    public final boolean onBackPressed() {
        if (this.isShowing == true) goto L5;
        return false;
    L5:
        this.requestGeneration++;
        if (this.pageStack.size() <= 1) goto L8;
        List<PageState> r0 = this.pageStack;
        ListProtector.remove(r0, CollectionsKt.getLastIndex(r0));
        renderCurrentPage();
        this.listView.scrollToPosition(0);
    L9:
        return true;
    L8:
        dismiss();
        goto L9
    }

    public final void refreshSelection() {
        if (this.isShowing == false) goto L6;
        OrganizationAdapter r0 = this.adapter;
        r0.notifyItemRangeChanged(0, r0.getItemCount());
        return;
    }

    public final void show() {
        this.requestGeneration++;
        this.isShowing = true;
        this.pageStack.clear();
        this.pageStack.add(new PageState(new i(this.organizationTitle, "0"), null, null, 0, false, false, 62, null));
        updateVisibility();
        bringToFront();
        this.onVisibilityChanged.invoke(Boolean.TRUE);
        renderCurrentPage();
        this.listView.scrollToPosition(0);
        loadCurrentPage();
    }

    public static final /* synthetic */ RecyclerView access$getBreadcrumbListView$p(DoubaoOrganizationPickerView r0) {
        return r0.breadcrumbListView;
    }

    public static final /* synthetic */ TextView access$getEmptyView$p(DoubaoOrganizationPickerView r0) {
        return r0.emptyView;
    }

    public static final /* synthetic */ Function0 access$getOnListDrag$p(DoubaoOrganizationPickerView r0) {
        return r0.onListDrag;
    }

    public static final /* synthetic */ List access$getPageStack$p(DoubaoOrganizationPickerView r0) {
        return r0.pageStack;
    }

    public static final /* synthetic */ int access$getRequestGeneration$p(DoubaoOrganizationPickerView r0) {
        return r0.requestGeneration;
    }

    public static final /* synthetic */ void access$loadCurrentPage(DoubaoOrganizationPickerView r0) {
        r0.loadCurrentPage();
    }

    public static final /* synthetic */ void access$renderCurrentPage(DoubaoOrganizationPickerView r0) {
        r0.renderCurrentPage();
    }

    private final void applyBreadcrumbTextStyle(View r3) {
        TextView r4 = (TextView) r3.findViewById(2131364564);
        if (r4 != null) goto L5;
        return;
    L5:
        r4.setTextColor(getBreadcrumbTextColors());
        r4.setTextSize(2, BREADCRUMB_TEXT_SIZE_SP);
    }

    private final void enterDepartment(i r12) {
        this.requestGeneration++;
        this.pageStack.add(new PageState(r12, null, null, 0, false, false, 62, null));
        renderCurrentPage();
        this.listView.scrollToPosition(0);
        loadCurrentPage();
    }

    private final void navigateToBreadcrumb(int r4) {
        if (r4 != 0) goto L5;
        dismiss();
        return;
    L5:
        int r5 = r4 - 1;
        if (r5 >= 0) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        if (r5 == CollectionsKt.getLastIndex(this.pageStack)) goto L18;
        this.requestGeneration++;
        List<PageState> r3 = this.pageStack;
        r3.subList(r5 + 1, r3.size()).clear();
        renderCurrentPage();
        this.listView.scrollToPosition(0);
        return;
    L18:
        return;
    L8:
        if (r5 >= this.pageStack.size()) goto L10;
        r2 = true;
        goto L11
    }

    private final DoubaoOrganizationItemState resolveItemState(c r2) {
        return (DoubaoOrganizationItemState) this.itemStateProvider.invoke(toSearchInfo(r2));
    }

    private final String stableId(c r3) {
        if ((r3 instanceof i) == false) goto L6;
        return "department:" + ((i) r3).b;
    L6:
        if ((r3 instanceof j) == false) goto L10;
        return "user:" + ((j) r3).b;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final SearchBaseInfo toSearchInfo(c r3) {
        if ((r3 instanceof i) == false) goto L6;
        SearchDepartmentInfo r0 = new SearchDepartmentInfo();
        i r4 = (i) r3;
        r0.setId(r4.b);
        r0.setTitle(r4.a);
        return r0;
    L6:
        if ((r3 instanceof j) == false) goto L10;
        ChatterCustomInfo r1 = new ChatterCustomInfo();
        j r5 = (j) r3;
        r1.setId(r5.b);
        r1.setType(1);
        r1.setAvatarKey(r5.c);
        r1.setName(r5.a);
        r1.setTitle(r5.a);
        return r1;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    private final void toggleSelection(c r3) {
        this.onItemSelected.invoke(toSearchInfo(r3), Boolean.valueOf(!resolveItemState(r3).isSelected()));
    }

    private final void updateLoading(boolean r3) {
        View r0 = this.loadingView;
        if (r3 == false) goto L5;
        int r1 = 0;
    L6:
        r0.setVisibility(r1);
        this.loadingDrawable.stop();
        if (r3 == false) goto L10;
        this.loadingDrawable.start();
        return;
    L10:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    public final void updateMultipleSelect(boolean r3) {
        if (this.adapter.isMultipleSelect() != r3) goto L5;
        return;
    L5:
        this.adapter.setMultipleSelect(r3);
        if (this.isShowing == false) goto L9;
        OrganizationAdapter r4 = this.adapter;
        r4.notifyItemRangeChanged(0, r4.getItemCount());
        return;
    }

    public final void updateSearchQuery(CharSequence r2) {
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        this.isSearchActive = !r3;
        updateVisibility();
        return;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r3 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r11v9, types: [androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener, com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView$breadcrumbChildAttachListener$1] */
    public DoubaoOrganizationPickerView(final Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        this.pageStack = new ArrayList();
        this.breadcrumbTextColors$delegate = LazyKt.lazy(new DoubaoOrganizationPickerView$breadcrumbTextColors$2(r10));
        this.organizationTitle = "";
        this.contactsTitle = "";
        this.nextLevelTitle = "";
        this.itemStateProvider = DoubaoOrganizationPickerView$itemStateProvider$1.INSTANCE;
        this.onItemSelected = DoubaoOrganizationPickerView$onItemSelected$1.INSTANCE;
        this.onVisibilityChanged = DoubaoOrganizationPickerView$onVisibilityChanged$1.INSTANCE;
        this.onListDrag = DoubaoOrganizationPickerView$onListDrag$1.INSTANCE;
        ?? r12 = new DoubaoOrganizationPickerView$breadcrumbChildAttachListener$1(this);
        this.breadcrumbChildAttachListener = r12;
        LayoutInflater.from(r10).inflate(2131568164, this, true);
        UDBreadcrumb r0 = findViewById(2131381655);
        this.breadcrumbView = r0;
        RecyclerView r3 = r0.getChildAt(0);
        if ((r3 instanceof RecyclerView) == false) goto L5;
        RecyclerView r4 = r3;
    L6:
        this.breadcrumbListView = r4;
        RecyclerView r5 = findViewById(2131381663);
        this.listView = r5;
        this.loadingView = findViewById(2131381664);
        Drawable r6 = new UDLoadingDrawable(r10);
        r6.setColorSchemeColors(new int[]{ContextCompat.getColor(r10, 2131105568)});
        this.loadingDrawable = r6;
        ((ImageView) findViewById(2131381665)).setImageDrawable(r6);
        TextView r1 = (TextView) findViewById(2131381658);
        this.emptyView = r1;
        OrganizationAdapter r2 = new OrganizationAdapter(new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass4(this));
        this.adapter = r2;
        r5.setLayoutManager(new LinearLayoutManager(r10));
        r5.setItemAnimator(null);
        r5.setAdapter(r2);
        r5.addOnScrollListener(new AnonymousClass5(this));
        r0.setOnItemClickListener(new AnonymousClass6(this));
        if (r4 == null) goto L9;
        r4.addOnChildAttachStateChangeListener(r12);
    L9:
        r1.setOnClickListener(new AnonymousClass7(this));
        setVisibility(8);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final /* synthetic */ void access$applyBreadcrumbTextStyle(DoubaoOrganizationPickerView r0, View r1) {
        r0.applyBreadcrumbTextStyle(r1);
    }

    public static final /* synthetic */ void access$enterDepartment(DoubaoOrganizationPickerView r0, i r1) {
        r0.enterDepartment(r1);
    }

    public static final /* synthetic */ void access$navigateToBreadcrumb(DoubaoOrganizationPickerView r0, int r1) {
        r0.navigateToBreadcrumb(r1);
    }

    public static final /* synthetic */ DoubaoOrganizationItemState access$resolveItemState(DoubaoOrganizationPickerView r0, c r1) {
        return r0.resolveItemState(r1);
    }

    public static final /* synthetic */ String access$stableId(DoubaoOrganizationPickerView r0, c r1) {
        return r0.stableId(r1);
    }

    public static final /* synthetic */ void access$toggleSelection(DoubaoOrganizationPickerView r0, c r1) {
        r0.toggleSelection(r1);
    }

    public static final /* synthetic */ void access$updateLoading(DoubaoOrganizationPickerView r0, boolean r1) {
        r0.updateLoading(r1);
    }

    public /* synthetic */ DoubaoOrganizationPickerView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public final void bind(b r2, String r3, String r4, String r5, boolean r6, boolean r7, Function1<? super SearchBaseInfo, DoubaoOrganizationItemState> r8, Function2<? super SearchBaseInfo, ? super Boolean, Unit> r9, Function1<? super Boolean, Unit> r10, Function0<Unit> r11) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "organizationTitle");
        Intrinsics.checkNotNullParameter(r4, "contactsTitle");
        Intrinsics.checkNotNullParameter(r5, "nextLevelTitle");
        Intrinsics.checkNotNullParameter(r8, "itemStateProvider");
        Intrinsics.checkNotNullParameter(r9, "onItemSelected");
        Intrinsics.checkNotNullParameter(r10, "onVisibilityChanged");
        Intrinsics.checkNotNullParameter(r11, "onListDrag");
        this.repository = r2;
        this.organizationTitle = r3;
        this.contactsTitle = r4;
        this.nextLevelTitle = r5;
        this.adapter.setNextLevelTitle(r5);
        this.adapter.setDepartmentSelectable(r6);
        this.adapter.setMultipleSelect(r7);
        this.itemStateProvider = r8;
        this.onItemSelected = r9;
        this.onVisibilityChanged = r10;
        this.onListDrag = r11;
    }
}
