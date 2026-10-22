package com.larus.bmhome.notification.viewmodel;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import bb8.m;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.banner.BannerApi;
import com.larus.bmhome.banner.BannerResponse;
import com.larus.network.http.a;
import com.larus.network.http.y;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/notification/viewmodel/BannerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "arguments", "Landroid/os/Bundle;", "refreshBannerEvent", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/banner/BannerResponse;", "getRefreshBannerEvent", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "", "refreshNotificationBanner", "", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "init", "isAggNotificationPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerViewModel extends ViewModel {
    private Bundle arguments;
    private boolean isRefreshing;
    private final MutableLiveData<BannerResponse> refreshBannerEvent;

    /* JADX INFO: renamed from: com.larus.bmhome.notification.viewmodel.BannerViewModel$refreshNotificationBanner$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.viewmodel.BannerViewModel$refreshNotificationBanner$1", f = "BannerViewModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        int label;
        final /* synthetic */ BannerViewModel this$0;

        public AnonymousClass1(DowngradeSource r1, BannerViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$downgradeSource = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$downgradeSource, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            y r7 = (a) r6;
            if ((r7 instanceof y) == false) goto L25;
            y r8 = r7;
            Long r2 = r8.g;
            if (r2 == null) goto L25;
            if (r2.longValue() != 0) goto L25;
            BannerResponse r9 = (BannerResponse) ((a) r8).b;
            if (r9 == null) goto L25;
            this.this$0.getRefreshBannerEvent().postValue(r9);
            HashMap r3 = m.a;
            List r10 = r9.getBanners();
            if (r10 == null) goto L23;
            List r11 = CollectionsKt.filterNotNull(r10);
        L24:
            m.b(r11);
            goto L25
        L23:
            r11 = null;
        L25:
            BannerViewModel.access$setRefreshing$p(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            BannerApi.a r12 = BannerApi.a;
            DowngradeSource r4 = this.$downgradeSource;
            this.label = 1;
            r12.getClass();
            r6 = BannerApi.a.a(1, r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    private final boolean isAggNotificationPage() {
        Bundle r0 = this.arguments;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getBoolean("is_agg_notification_page");
    }

    public BannerViewModel() {
        this.refreshBannerEvent = new MutableLiveData();
    }

    public final MutableLiveData<BannerResponse> getRefreshBannerEvent() {
        return this.refreshBannerEvent;
    }

    public final void init(Bundle r1) {
        this.arguments = r1;
    }

    public final void refreshNotificationBanner(DowngradeSource r8) {
        if (isAggNotificationPage() == false) goto L6;
        return;
    L6:
        if (this.isRefreshing == false) goto L8;
        return;
    L8:
        this.isRefreshing = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, null), 2, null);
    }

    public static final /* synthetic */ void access$setRefreshing$p(BannerViewModel r0, boolean r1) {
        r0.isRefreshing = r1;
    }

    public static /* synthetic */ void refreshNotificationBanner$default(BannerViewModel r0, DowngradeSource r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.refreshNotificationBanner(r1);
    }
}
