package com.larus.dora.obric.device_management.setting.earbuds;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import c59.d0;
import c59.e0;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eJ=\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u001b2\b\u0010&\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010'J\u0014\u0010(\u001a\u0004\u0018\u00010\u00172\b\u0010&\u001a\u0004\u0018\u00010\u001bH\u0002J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010*\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u0017H\u0002J\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0013J\u0006\u0010/\u001a\u00020 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "_cards", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "cards", "Lkotlinx/coroutines/flow/StateFlow;", "getCards", "()Lkotlinx/coroutines/flow/StateFlow;", "_cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "cardContext", "getCardContext", "_connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "connectionState", "getConnectionState", "currentDevice", "Lcom/larus/dora/impl/device_v2/entity/DoraSimpleDeviceV2;", "currentPageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "targetDeviceMac", "", "currentDeviceMac", "hasLoadedPageInfo", "", "loadData", "", "vendorId", "", "productId", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "pageKey", "mac", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "resolveDevice", "extractSettingsCards", "pageInfo", "updateCardContext", "device", "updateConnectionState", "state", "refreshConnectionState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsDSLSettingsViewModel extends ViewModel {
    private static final int CONNECTED_SUBPAGE_INDEX = 0;
    public static final a Companion = null;
    private static final int DISCONNECTED_SUBPAGE_INDEX = 1;
    private static final int H_PRODUCT_ID = -1;
    private static final int SETTING_TAB_INDEX = 1;
    public static final String TAG = "DoraObricEarbudsDSLSettingsVM";
    private final z0<d59.b> _cardContext;
    private final z0<List<c59.i>> _cards;
    private final z0<e59.b> _connectionState;
    private final i1<d59.b> cardContext;
    private final i1<List<c59.i>> cards;
    private final i1<e59.b> connectionState;
    private z49.b currentDevice;
    private c59.m currentPageInfo;
    private final com.larus.dora.impl.dynamic.loader.d dataLoader;
    private String targetDeviceMac;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.larus.dora.impl.dynamic.loader.d.b {
        public int a;
        public final /* synthetic */ DoraObricEarbudsDSLSettingsViewModel b;
        public final /* synthetic */ z49.b c;

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void a() {
            g49.d.d(DoraObricEarbudsDSLSettingsViewModel.TAG, "dsl data source invalid: page data is invalid");
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void b(c59.z r6) {
            Intrinsics.checkNotNullParameter(r6, "pageNode");
            this.a++;
            List<c59.z> r1 = r6.c();
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.size();
        L22:
            List<c59.z> r4 = r6.c();     // Catch: Exception -> L19
            if (r4 == null) goto L13;
            c59.z r5 = (c59.z) CollectionsKt.getOrNull(r4, 0);     // Catch: Exception -> L19
            if (r5 == null) goto L13;
            List<c59.z> r7 = r5.c();     // Catch: Exception -> L19
            if (r7 == null) goto L13;
            r2 = r7.size();     // Catch: Exception -> L19
        L13:
            g49.d.d(DoraObricEarbudsDSLSettingsViewModel.TAG, "dsl data source success call=" + this.a + ", subpages=" + r3 + ", tabs=" + r2);
            c59.m r8 = c59.a0.b(r6);     // Catch: Exception -> L16
            DoraObricEarbudsDSLSettingsViewModel.access$setCurrentPageInfo$p(this.b, r8);     // Catch: Exception -> L16
            DoraObricEarbudsDSLSettingsViewModel r9 = this.b;     // Catch: Exception -> L16
            List r10 = DoraObricEarbudsDSLSettingsViewModel.access$extractSettingsCards(r9, r8, (e59.b) DoraObricEarbudsDSLSettingsViewModel.access$get_connectionState$p(r9).getValue());     // Catch: Exception -> L16
            g49.d.d(DoraObricEarbudsDSLSettingsViewModel.TAG, "dsl data source extracted " + r10.size() + " setting cards");     // Catch: Exception -> L16
            DoraObricEarbudsDSLSettingsViewModel.access$get_cards$p(this.b).setValue(r10);     // Catch: Exception -> L16
            DoraObricEarbudsDSLSettingsViewModel.access$updateCardContext(this.b, this.c);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            g49.d.b(DoraObricEarbudsDSLSettingsViewModel.TAG, "onSuccess error: " + e.getMessage());
            return;
        L5:
            r3 = 0;
            goto L22
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void onFail(String r3) {
            g49.d.b(DoraObricEarbudsDSLSettingsViewModel.TAG, "dsl data source failed: " + r3);
        }

        public b(DoraObricEarbudsDSLSettingsViewModel r1, z49.b r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    static {
        Companion = new a();
    }

    public final boolean hasLoadedPageInfo() {
        if (this.currentPageInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void refreshConnectionState() {
        String r0 = this.targetDeviceMac;
        if (r0 != null) goto L6;
        return;
    L6:
        if (n1.h(r0) == false) goto L8;
        e59.b r1 = new e59.b.a(r0);
    L9:
        updateConnectionState(r1);
        return;
    L8:
        r1 = new e59.b.c(r0);
        goto L9
    }

    public DoraObricEarbudsDSLSettingsViewModel() {
        this.dataLoader = new com.larus.dora.impl.dynamic.loader.d();
        StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        this._cards = r0;
        this.cards = kotlinx.coroutines.flow.e.b(r0);
        StateFlowImpl r1 = j1.a(null);
        this._cardContext = r1;
        this.cardContext = kotlinx.coroutines.flow.e.b(r1);
        StateFlowImpl r2 = j1.a(e59.b.d.a);
        this._connectionState = r2;
        this.connectionState = kotlinx.coroutines.flow.e.b(r2);
    }

    public final String currentDeviceMac() {
        return this.targetDeviceMac;
    }

    public final i1<d59.b> getCardContext() {
        return this.cardContext;
    }

    public final i1<List<c59.i>> getCards() {
        return this.cards;
    }

    public final i1<e59.b> getConnectionState() {
        return this.connectionState;
    }

    public static final /* synthetic */ z0 access$get_cards$p(DoraObricEarbudsDSLSettingsViewModel r0) {
        return r0._cards;
    }

    public static final /* synthetic */ z0 access$get_connectionState$p(DoraObricEarbudsDSLSettingsViewModel r0) {
        return r0._connectionState;
    }

    private final z49.b resolveDevice(String r5) {
        if (r5 != null) goto L5;
    L10:
        r5 = null;
    L11:
        if (r5 != null) goto L13;
        return null;
    L13:
        kj4.a r1 = kj4.a.g();
        Intrinsics.checkNotNull(r1);
        DoraDevice r2 = DoraAdapterExtKt.h(r1);
        if (r2 != null) goto L16;
    L21:
        Iterator r3 = DoraAdapterExtKt.k(r1).iterator();
    L23:
        if (r3.hasNext() == false) goto L27;
        Object r4 = r3.next();
        if (Intrinsics.areEqual(((DoraDevice) r4).mac, r5) == false) goto L23;
    L28:
        r2 = (DoraDevice) r4;
    L29:
        if (r2 != null) goto L31;
        return null;
    L31:
        return n1.b(r2);
    L27:
        r4 = null;
        goto L28
    L16:
        if (Intrinsics.areEqual(r2.mac, r5) == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L21;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
    L7:
        r6 = false;
        goto L8
    }

    private final void updateCardContext(z49.b r6) {
        this._cardContext.setValue(new d59.b(r6, DoraAdapterExtKt.k(kj4.a.g()), d0.a(), ""));
    }

    public final void updateConnectionState(e59.b r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        this._connectionState.setValue(r3);
        c59.m r0 = this.currentPageInfo;
        if (r0 == null) goto L6;
        this._cards.setValue(extractSettingsCards(r0, r3));
        return;
    }

    public static final /* synthetic */ void access$setCurrentPageInfo$p(DoraObricEarbudsDSLSettingsViewModel r0, c59.m r1) {
        r0.currentPageInfo = r1;
    }

    public static final /* synthetic */ void access$updateCardContext(DoraObricEarbudsDSLSettingsViewModel r0, z49.b r1) {
        r0.updateCardContext(r1);
    }

    private final List<c59.i> extractSettingsCards(c59.m r4, e59.b r5) {
        int r1 = 0;
        if ((r5 instanceof e59.b.a) == false) goto L15;
        String r0 = this.targetDeviceMac;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L15;
        if (Intrinsics.areEqual(((e59.b.a) r5).a, this.targetDeviceMac) == false) goto L15;
        r1 = 1;
        goto L15
    L7:
        if (r0.length() == 0) goto L10;
        r2 = false;
    L15:
        List<c59.n> r6 = r4.b;
        c59.n r7 = (c59.n) CollectionsKt.getOrNull(r6, r1 ^ 1);
        if (r7 == null) goto L25;
        List<e0> r8 = r7.b;
        if (r8 == null) goto L25;
        e0 r9 = (e0) CollectionsKt.getOrNull(r8, 1);
        if (r9 == null) goto L25;
        List<c59.i> r10 = r9.b;
        if (r10 == null) goto L25;
        return r10;
    L25:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ List access$extractSettingsCards(DoraObricEarbudsDSLSettingsViewModel r0, c59.m r1, e59.b r2) {
        return r0.extractSettingsCards(r1, r2);
    }

    public final void loadData(Integer r9, Integer r10, String r11, String r12, String r13) {
        int r14 = 1;
        if (r13 != null) goto L5;
    L10:
        r13 = null;
    L12:
        if (this.targetDeviceMac != null) goto L15;
        this.targetDeviceMac = r13;
    L15:
        if (Intrinsics.areEqual(r13, this.targetDeviceMac) == true) goto L18;
        g49.d.e(TAG, "loadData ignored: request mac does not match target device");
        return;
    L18:
        z49.b r15 = resolveDevice(r13);
        if (r15 != null) goto L22;
        g49.d.b(TAG, "loadData: target device is null");
        return;
    L22:
        this.currentDevice = r15;
        boolean r1 = n1.h(r13);
        z0<e59.b> r2 = this._connectionState;
        if (r1 == false) goto L25;
        Object r3 = new e59.b.a(r13);
    L26:
        r2.setValue(r3);
        DoraDevice r4 = r15.a;
        if (r4 == null) goto L29;
        r14 = r4.vendorId;
    L32:
        if (r14 != 4096) goto L34;
        int r16 = -1;
    L35:
        String r5 = r15.d();
        g49.d.d(TAG, "loadData: vendorId=" + r14 + ", productId=" + r16 + ", model=" + r5 + ", pageKey=" + r12 + ", mac=" + r13);
        com.larus.dora.impl.dynamic.loader.d.b(this.dataLoader, ViewModelKt.getViewModelScope(this), Integer.valueOf(r14), Integer.valueOf(r16), r5, r12, new b(this, r15));
        return;
    L34:
        r16 = n1.d(r15);
        goto L35
    L29:
        if (r9 == null) goto L32;
        r14 = r9.intValue();
        goto L32
    L25:
        r3 = new e59.b.c(r13);
        goto L26
    L5:
        if (r13.length() <= 0) goto L7;
        boolean r17 = true;
    L8:
        if (r17 == false) goto L10;
    L7:
        r17 = false;
        goto L8
    }
}
