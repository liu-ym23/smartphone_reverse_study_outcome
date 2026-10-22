package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.viewmodel;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.AudienceMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.d;
import com.bytedance.android.live.openplatform.api.model.shelf.e;
import com.bytedance.android.live.openplatform.api.model.shelf.f;
import com.bytedance.android.live.openplatform.api.model.shelf.g;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.inject.Inject;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108J$\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eR*\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0006@GX\u0086.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappaudience/shelf/viewmodel/AudienceShelfDisplayViewModel;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/shelf/viewmodel/CommonShelfDisplayViewModel;", "Lrq0/c;", "", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfCardInfo;", "newCardInfoList", "Lcom/bytedance/android/live/openplatform/api/model/shelf/f;", "newSupplementInfoMap", "", "updateDisplayItemInfoList", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "newShelfInfo", "", "isCardListHasChanged", "initData", "shelfInfo", "notifyShelfInfoChange", "source", "", "", "buildDisplayItemInfoList", "shelfCardInfo", "isPinCard", "openLinkCastPage", "", "getLinkCastTips", "Landroid/content/Context;", "context", "schema", "openSchema", "Llo0/a;", "privateMsgEntranceInfo", "reportMpImAuthPushEntryShow", "reportMpImAuthPushEntryClick", "Lto0/a;", "<set-?>", "miniAppAudienceService", "Lto0/a;", "getMiniAppAudienceService", "()Lto0/a;", "setMiniAppAudienceService", "(Lto0/a;)V", "hasCoexistComponent", "Z", "Landroidx/lifecycle/MutableLiveData;", "cardListChanged", "Landroidx/lifecycle/MutableLiveData;", "getCardListChanged", "()Landroidx/lifecycle/MutableLiveData;", "privateMsgData", "Llo0/a;", "getPrivateMsgData", "()Llo0/a;", "setPrivateMsgData", "(Llo0/a;)V", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceShelfDisplayViewModel extends CommonShelfDisplayViewModel<rq0.c> {
    private final MutableLiveData<Boolean> cardListChanged;
    private boolean hasCoexistComponent;
    public to0.a miniAppAudienceService;
    private lo0.a privateMsgData;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3.a();
        }
    }

    public static final class b<T, R> implements Function {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (f) sh6.c.b(r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AudienceShelfDisplayViewModel a;

        public c(AudienceShelfDisplayViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            AudienceShelfDisplayViewModel r0 = this.a;
            AudienceShelfDisplayViewModel.updateDisplayItemInfoList$default(r0, null, (f) r4, 1, null);
        }
    }

    public final to0.a getMiniAppAudienceService() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAudienceService");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public void initData() {
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r0 = AudienceMiniAppDataContext.a.a();
        if (r0 == null) goto L7;
        n<lo0.a> r1 = r0.getPrivateMsgEntranceInfo();
        if (r1 == null) goto L7;
        lo0.a r2 = (lo0.a) r1.getValue();
    L8:
        this.privateMsgData = r2;
        super.initData();
        AudienceMiniAppDataContext r3 = AudienceMiniAppDataContext.a.a();
        if (r3 == null) goto L22;
        n<f> r4 = r3.getShelfCardSupplementInfoMap();
        if (r4 == null) goto L23;
        Observable r5 = r4.a();
        if (r5 == null) goto L24;
        Observable r6 = r5.filter(a.a);
        if (r6 == null) goto L25;
        Observable r7 = r6.map(b.a);
        if (r7 == null) goto L26;
        Disposable r8 = r7.subscribe(new c(this));
        if (r8 == null) goto L27;
        autoDispose(r8);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public void openLinkCastPage() {
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAudienceService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AudienceLaunchContextService r2 = (AudienceLaunchContextService) r1.getService(AudienceLaunchContextService.class);
        if (r2 == null) goto L12;
        AudienceLaunchContextService.openMiniApp$default(r2, MountedMiniAppSource.ShelfPageLinkCast, null, 2, null);
        return;
    L12:
        return;
    }

    public AudienceShelfDisplayViewModel() {
        this.cardListChanged = new MutableLiveData();
        OpenPlatformAudienceServiceImpl.Companion.getClass();
        po0.a.b r0 = (po0.a.b) OpenPlatformAudienceServiceImpl.access$getDiComponent$cp();
        r0.getClass();
        setMiniAppAudienceService((to0.a) r0.a.d.get());
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public String getLinkCastTips() {
        return s1.B(2131920881);
    }

    public final MutableLiveData<Boolean> getCardListChanged() {
        return this.cardListChanged;
    }

    public final lo0.a getPrivateMsgData() {
        return this.privateMsgData;
    }

    public List<Object> buildDisplayItemInfoList(rq0.c r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        ArrayList r0 = new ArrayList();
        lo0.a r1 = this.privateMsgData;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        r0.addAll(super.buildDisplayItemInfoList(r9));
        List<ShelfCardInfo> r2 = r9.a;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L15;
        ShelfCardInfo r5 = (ShelfCardInfo) r4.next();
        f r6 = r9.b;
        if (r6 == null) goto L13;
        Map<Long, e> r7 = r6.a();
        if (r7 == null) goto L13;
        e r8 = r7.get(Long.valueOf(r5.getCardId()));
    L14:
        r3.add(new rq0.a(r5, r8));
    L13:
        r8 = null;
        goto L14
    L15:
        r0.addAll(r3);
        return r0;
    }

    public final boolean isPinCard(ShelfCardInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "shelfCardInfo");
        if (r7.getStatus() != 1) goto L25;
        MiniAppDataContext.Companion.getClass();
        MiniAppDataContext r0 = MiniAppDataContext.a.a();
        if (r0 == null) goto L13;
        n<ShelfInfo> r1 = r0.m618getShelfInfo();
        if (r1 == null) goto L13;
        ShelfInfo r2 = (ShelfInfo) r1.getValue();
        if (r2 == null) goto L13;
        List<ShelfCardInfo> r3 = r2.cardInfoList;
        if (r3 == null) goto L13;
        int r4 = r3.size();
    L15:
        if (r4 > 1) goto L17;
        return false;
    L17:
        if (d.a(r7.getCardId()) == 1) goto L27;
        List r5 = (List) getShelfCardInfoList().getValue();
        if (r5 == null) goto L21;
        ShelfCardInfo r6 = (ShelfCardInfo) ListProtector.get(r5, 0);
    L22:
        if (r6 != r7) goto L28;
        return true;
    L28:
        return false;
    L21:
        r6 = null;
        goto L22
    L27:
        return false;
    L13:
        r4 = 0;
        goto L15
    L25:
        return false;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public void notifyShelfInfoChange(ShelfInfo r33) {
        if (r33 == null) goto L28;
        List<ShelfCardInfo> r3 = r33.cardInfoList;
        if (r3 == null) goto L28;
        ArrayList r4 = new ArrayList();
        r4.addAll(r3);
        if (r3.size() <= 1) goto L29;
        ListIterator<ShelfCardInfo> r5 = r3.listIterator(r3.size());
    L10:
        if (r5.hasPrevious() == false) goto L19;
        ShelfCardInfo r7 = r5.previous();
        ShelfCardInfo r9 = r7;
        if (r9.getStatus() == 1) goto L14;
    L16:
        boolean r10 = false;
    L17:
        if (r10 == false) goto L10;
    L20:
        ShelfCardInfo r8 = r7;
        if (r8 == null) goto L29;
        ListProtector.add(r4, 0, ShelfCardInfo.g(r8, null, null, null, null, false, null, 0, 0, null, null, null, 0, null, null, null, null, null, 0, 0, -1, 7));
        Iterator r6 = r4.iterator();
    L24:
        if (r6.hasNext() == false) goto L29;
        if (((ShelfCardInfo) r6.next()) != r8) goto L24;
        r6.remove();
        goto L24
    L14:
        if (r3.indexOf(r9) == 0) goto L16;
        r10 = true;
        goto L17
    L19:
        r7 = null;
    L29:
        MutableLiveData<Boolean> r11 = this.cardListChanged;
        if (r4 != null) goto L32;
        List<ShelfCardInfo> r12 = CollectionsKt.emptyList();
    L33:
        r11.setValue(Boolean.valueOf(isCardListHasChanged(r33, r12)));
        this.hasCoexistComponent = g.c(r33);
        getShelfCardInfoList().setValue(r4);
        List r13 = r4;
        if (r4 != null) goto L36;
        r13 = CollectionsKt.emptyList();
    L36:
        updateDisplayItemInfoList$default(this, r13, null, 2, null);
        return;
    L32:
        r12 = r4;
    L28:
        r4 = null;
        goto L29
    }

    public final void reportMpImAuthPushEntryClick(lo0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "privateMsgEntranceInfo");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAudienceService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AudienceMiniAppAppLogContextService r2 = (AudienceMiniAppAppLogContextService) r1.getService(AudienceMiniAppAppLogContextService.class);
        if (r2 == null) goto L12;
        r2.reportMpImAuthPushEntryClick(r3);
        return;
    L12:
        return;
    }

    public final void reportMpImAuthPushEntryShow(lo0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "privateMsgEntranceInfo");
        to0.a r0 = this.miniAppAudienceService;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAudienceService");
    L5:
        OpenPlatformContext r1 = r0.a();
        if (r1 == null) goto L11;
        AudienceMiniAppAppLogContextService r2 = (AudienceMiniAppAppLogContextService) r1.getService(AudienceMiniAppAppLogContextService.class);
        if (r2 == null) goto L12;
        r2.reportMpImAuthPushEntryShow(r3);
        return;
    L12:
        return;
    }

    @Inject
    public final void setMiniAppAudienceService(to0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.miniAppAudienceService = r2;
    }

    public final void setPrivateMsgData(lo0.a r1) {
        this.privateMsgData = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.CommonShelfDisplayViewModel
    public /* bridge */ /* synthetic */ List buildDisplayItemInfoList(com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.viewmodel.a r1) {
        return buildDisplayItemInfoList((rq0.c) r1);
    }

    private final boolean isCardListHasChanged(ShelfInfo r11, List<ShelfCardInfo> r12) {
        List r0 = (List) getShelfCardInfoList().getValue();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L7:
        if (r1 > 1) goto L9;
    L13:
        List r13 = (List) getShelfCardInfoList().getValue();
        if (r13 == null) goto L16;
        int r2 = r13.size();
    L18:
        if (r2 == r12.size()) goto L20;
        return true;
    L20:
        if (r13 == null) goto L40;
        Iterator r14 = r13.iterator();
        int r3 = 0;
    L23:
        if (r14.hasNext() == false) goto L40;
        Object r4 = r14.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L27;
        CollectionsKt.throwIndexOverflow();
    L27:
        ShelfCardInfo r6 = (ShelfCardInfo) r4;
        ShelfCardInfo r7 = (ShelfCardInfo) CollectionsKt.getOrNull(r12, r3);
        if (r7 == null) goto L39;
        if ((!Intrinsics.areEqual(r6.j(true), r7.j(true))) == true) goto L39;
        if ((!Intrinsics.areEqual(r6.k(null), r7.k(null))) == true) goto L39;
        if (r6.getStatus() != r7.getStatus()) goto L39;
        if (r6.getCardId() != r7.getCardId()) goto L39;
        r3 = r5;
    L39:
        return true;
    L40:
        return false;
    L16:
        r2 = 0;
        goto L18
    L9:
        if (this.hasCoexistComponent == true) goto L13;
        if (g.c(r11) == false) goto L13;
        return true;
    L5:
        r1 = 0;
        goto L7
    }

    private final void updateDisplayItemInfoList(List<ShelfCardInfo> r3, f r4) {
        if (r3.isEmpty() == false) goto L5;
        return;
    L5:
        getDisplayItemInfoList().setValue(buildDisplayItemInfoList(new rq0.c(r3, r4)));
    }

    public final void openSchema(Context r2, String r3) {
        k.n(IRoomService.class).actionHandler().handle(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateDisplayItemInfoList$default(AudienceShelfDisplayViewModel r0, List r1, f r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L8;
        r1 = (List) r0.getShelfCardInfoList().getValue();
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        if ((r3 & 2) == 0) goto L15;
        AudienceMiniAppDataContext.Companion.getClass();
        AudienceMiniAppDataContext r5 = AudienceMiniAppDataContext.a.a();
        if (r5 == null) goto L14;
        n<f> r6 = r5.getShelfCardSupplementInfoMap();
        if (r6 == null) goto L14;
        r2 = (f) r6.getValue();
    L14:
        r2 = null;
    L15:
        r0.updateDisplayItemInfoList(r1, r2);
    }
}
