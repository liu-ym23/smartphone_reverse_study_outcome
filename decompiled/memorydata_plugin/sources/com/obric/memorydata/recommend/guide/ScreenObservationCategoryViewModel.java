package com.obric.memorydata.recommend.guide;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.icu.text.AlphabeticIndex;
import android.os.IBinder;
import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.obric.memorydata.recommend.context.task.PendingAppTypeCheckTask;
import com.obric.memorydata.recommend.settings.h;
import com.obric.memorydata.recommend.settings.i;
import com.obric.memorydata.recommend.settings.k;
import com.obric.memorydata.recommend.settings.r;
import com.obric.memorydata.recommend.settings.s;
import com.obric.memorydata.recommend.settings.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\u001e\u0010 \u001a\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\u0006\u0010*\u001a\u00020\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "<init>", "()V", "titleBarHeight", "Landroidx/lifecycle/MutableLiveData;", "", "getTitleBarHeight", "()Landroidx/lifecycle/MutableLiveData;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/recommend/settings/RecommendSettingsState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "processIntent", "", MemorySourceLinkType.INTENT, "Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsIntent;", "updateNewMemorySetting", "setting", "updateEnableCategories", "categoryCode", "isAdd", "", "initializeMemorySettingsState", "oldState", "updateAppSettingAndCategories", "updateRecommend", "enable", "updateAppSetting", "packageNames", "", "", "enabled", ObricMemoryConstants.KEY_PACKAGE_NAME, "updateCellular", "getAllCategoryInfo", "", "Lcom/obric/memorydata/recommend/settings/CategoryInfo;", "refresh", "Companion", "AppCategory", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationCategoryViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final b Companion = null;
    private static final String TAG = "ScreenObservationCategoryViewModel";
    private static List<i> categoryItemsCache;
    private final ae<k> _state;
    private final ar<k> state;
    private final MutableLiveData<Integer> titleBarHeight;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "enabled", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$1", f = "ScreenObservationCategoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ ScreenObservationCategoryViewModel this$0;

        AnonymousClass1(ScreenObservationCategoryViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
            r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
            return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r10);
            boolean r11 = this.Z$0;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationCategoryViewModel.TAG, "External state change detected: " + r11, false, 4, null);
            ae r9 = ScreenObservationCategoryViewModel.access$get_state$p(this.this$0);
        L5:
            Object r0 = r9.c();
            k r1 = s.a((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin"), r11);
            b.a(ScreenObservationCategoryViewModel.Companion, r1.d());
            if (r9.a(r0, r1) == false) goto L5;
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "enabled", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$2", f = "ScreenObservationCategoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ ScreenObservationCategoryViewModel this$0;

        AnonymousClass2(ScreenObservationCategoryViewModel r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r5);
            r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
            return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r14);
            boolean r15 = this.Z$0;
            ae r13 = ScreenObservationCategoryViewModel.access$get_state$p(this.this$0);
        L5:
            Object r0 = r13.c();
            if (r13.a(r0, k.a((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin"), false, false, r15, null, 0, null, null, 0, 251, null)) == false) goto L5;
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel$AppCategory;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "categoryCode", "", "<init>", "(Ljava/lang/String;I)V", "getPackageName", "()Ljava/lang/String;", "getCategoryCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12509b;

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
            this.f12508a = r2;
            this.f12509b = r3;
        }

        public final String a() {
            return this.f12508a;
        }

        public final int b() {
            return this.f12509b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12508a, r6.f12508a) == true) goto L12;
            return false;
        L12:
            if (this.f12509b == r6.f12509b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12508a.hashCode() * 31) + Integer.hashCode(this.f12509b);
        }

        public String toString() {
            return "AppCategory(packageName=" + this.f12508a + ", categoryCode=" + this.f12509b + ')';
        }
    }

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\rJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007J,\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u00110\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0018\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001b0\u0007J\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00070\rJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\"\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010#J\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel$Companion;", "", "<init>", "()V", "TAG", "", "categoryItemsCache", "", "Lcom/obric/memorydata/recommend/settings/CategoryItem;", "queryAppType", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel$AppCategory;", "packageNames", "getClassificationMappingInfo", "", "", "getAllCategoryCode", "getCategory", "Lkotlin/Triple;", "setCategoryItemsCache", "", "items", "getLauncherApps", "Lcom/obric/memorydata/recommend/settings/AppInfo;", "context", "Landroid/content/Context;", "getLauncherCategory", "names", "Lkotlin/Pair;", "getAppsWithCategory", "Lcom/obric/memorydata/recommend/settings/AppSettingItem;", "getCategoryItems", "refreshCategoryItemsCache", "isFirstStart", "", "callBack", "Lkotlin/Function0;", "clearCategoryItemsCache", "hasCategoryItemsCache", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r2, T r3) {
                i r1 = (i) ZeusTransformUtils.preCheckCast(r2, i.class, "com.obric.memorydata.plugin");
                Comparable r4 = (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.memorydata.recommend.settings.a.f12594a.b(r1.c())), Comparable.class, "com.obric.memorydata.plugin");
                i r5 = (i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin");
                return ComparisonsKt.compareValues(r4, (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(com.obric.memorydata.recommend.settings.a.f12594a.b(r5.c())), Comparable.class, "com.obric.memorydata.plugin"));
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private static final int a(AlphabeticIndex r4, com.obric.memorydata.recommend.settings.c r5, com.obric.memorydata.recommend.settings.c r6) {
            int r0 = r4.getBucketIndex((CharSequence) ZeusTransformUtils.preCheckCast(r5.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            int r7 = r4.getBucketIndex((CharSequence) ZeusTransformUtils.preCheckCast(r6.a(), CharSequence.class, "com.obric.memorydata.plugin"));
            if (r0 == r7) goto L6;
            return Intrinsics.compare(r0, r7);
        L6:
            return r5.a().compareTo(r6.a());
        }

        private static final int a(Function2 r2, Object r3, Object r4) {
            return ((Number) ZeusTransformUtils.preCheckCast(((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        private final List<com.obric.memorydata.recommend.settings.b> a(Context r11) {
            PackageManager r12 = ((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin")).getPackageManager();
            Intent r0 = new Intent("android.intent.action.MAIN");
            r0.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> r1 = r12.queryIntentActivities(r0, 0);
            Intrinsics.checkNotNullExpressionValue(r1, "queryIntentActivities(...)");
            Set r3 = (Set) ZeusTransformUtils.preCheckCast(t.f12630a.c().c(), Set.class, "com.obric.memorydata.plugin");
            Set<String> r4 = t.f12630a.r();
            Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L13;
            Object r8 = r7.next();
            ResolveInfo r9 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r8, ResolveInfo.class, "com.obric.memorydata.plugin");
            if (r3.contains(r9.activityInfo.packageName) == false) goto L8;
        L10:
            boolean r10 = false;
        L11:
            if (r10 == false) goto L4;
            r6.add(r8);
            goto L4
        L8:
            if (r4.contains(r9.activityInfo.packageName) == true) goto L10;
            r10 = true;
            goto L11
        L13:
            Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r14 = r2.iterator();
        L15:
            if (r14.hasNext() == false) goto L17;
            ResolveInfo r15 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r14.next(), ResolveInfo.class, "com.obric.memorydata.plugin");
            r13.add(TuplesKt.to(r15.activityInfo.applicationInfo.loadLabel(r12).toString(), r15.activityInfo.packageName));
            goto L15
        L17:
            Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            HashSet r17 = new HashSet();
            ArrayList r18 = new ArrayList();
            Iterator r19 = r16.iterator();
        L19:
            if (r19.hasNext() == false) goto L23;
            Object r20 = r19.next();
            if (r17.add((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r20, Pair.class, "com.obric.memorydata.plugin")).getSecond(), String.class, "com.obric.memorydata.plugin")) == false) goto L19;
            r18.add(r20);
            goto L19
        L23:
            List<Pair<String, String>> r110 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin");
            o r21 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, o.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.middleware.api.logging.e r22 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            if (AppContext.INSTANCE.isDebug() == false) goto L27;
            String r23 = "应用列表加载完成，桌面应用数量=" + r1.size() + "，可见应用数量=" + r110.size();
            g r24 = new g();
            Unit r25 = Unit.INSTANCE;
            r21.a(r23, r22, r24.a());
        L27:
            return c(r110);
        }

        public static final /* synthetic */ List a(b r0) {
            return r0.f();
        }

        public static final /* synthetic */ List a(b r2, Context r3) {
            return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ void a(b r2, List r3) {
            r2.d((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ void a(b r1, boolean r2, Function0 r3, int r4, Object r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r6 = null;
        L8:
            r1.a(r2, r6);
        }

        private final void d(List<i> r2) {
            ScreenObservationCategoryViewModel.access$setCategoryItemsCache$cp((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"));
        }

        private final List<i> f() {
            Map<String, List<com.obric.memorydata.recommend.settings.c>> r12 = c();
            List<i> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator<Map.Entry<String, List<com.obric.memorydata.recommend.settings.c>>> r1 = r12.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L7;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.memorydata.plugin");
            List<com.obric.memorydata.recommend.settings.c> r4 = r12.get(r7);
            Intrinsics.checkNotNull(r4);
            r0.add(new i(r6, r7, ((com.obric.memorydata.recommend.settings.c) ZeusTransformUtils.preCheckCast(((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin")).get(0), com.obric.memorydata.recommend.settings.c.class, "com.obric.memorydata.plugin")).f(), null, 8, null));
            goto L4
        L7:
            if (r0.size() <= 1) goto L9;
            CollectionsKt.sortWith(r0, (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.memorydata.plugin"));
        L9:
            return r0;
        }

        /* JADX INFO: renamed from: lambda$I8-rUeBkzamlCPp5ZBWbjiN0AhE, reason: not valid java name */
        public static /* synthetic */ int m1114lambda$I8rUeBkzamlCPp5ZBWbjiN0AhE(Function2 r0, Object r1, Object r2) {
            return a(r0, r1, r2);
        }

        public static /* synthetic */ int lambda$NCl52hpbFjzlOIeG3XC4a2XaDCA(AlphabeticIndex r0, com.obric.memorydata.recommend.settings.c r1, com.obric.memorydata.recommend.settings.c r2) {
            return a(r0, r1, r2);
        }

        public final List<a> a(List<String> r15) {
            List<String> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r14, "packageNames");
            List<a> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Parcel r1 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r1, "obtain(...)");
            Parcel r3 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r3, "obtain(...)");
            boolean r4 = false;
            Object r5 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"apprecord_service"});     // Catch: Throwable -> L11 Exception -> L13
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.os.IBinder");     // Catch: Throwable -> L11 Exception -> L13
            IBinder r6 = (IBinder) ZeusTransformUtils.preCheckCast(r5, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13
            r1.setDataPosition(0);     // Catch: Throwable -> L11 Exception -> L13
            r1.writeInterfaceToken("android.app.IAppRecordManager");     // Catch: Throwable -> L11 Exception -> L13
            r1.writeStringList(r14);     // Catch: Throwable -> L11 Exception -> L13
            r6.transact(8888, r1, r3, 0);     // Catch: Throwable -> L11 Exception -> L13
            r3.readException();     // Catch: Throwable -> L11 Exception -> L13
            ArrayList r7 = new ArrayList();     // Catch: Throwable -> L11 Exception -> L13
            r3.readStringList((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11 Exception -> L13
            o r8 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13
            com.obric.memorydata.middleware.api.logging.e r13 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);     // Catch: Throwable -> L11 Exception -> L13
            if (AppContext.INSTANCE.isDebug() == false) goto L6;
            String r9 = "应用分类查询完成，结果数量=" + r7.size();     // Catch: Throwable -> L11 Exception -> L13
            g r10 = new g();     // Catch: Throwable -> L11 Exception -> L13
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L11 Exception -> L13
            r8.a(r9, r13, r10.a());     // Catch: Throwable -> L11 Exception -> L13
        L6:
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11 Exception -> L13
        L7:
            if (r12.hasNext() == false) goto L19;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11 Exception -> L13
            Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L11 Exception -> L13
            List r18 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null);     // Catch: Throwable -> L11 Exception -> L13
            r16.add(new a((String) ZeusTransformUtils.preCheckCast(r18.get(0), String.class, "com.obric.memorydata.plugin"), Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r18.get(1), String.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L11 Exception -> L13
        L19:
            r3.recycle();
            r1.recycle();
            Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L35
        L21:
            boolean r2 = false;
        L36:
        L28:
            r4 = r2;
            goto L29
        L23:
            if (r19.hasNext() == false) goto L30;
            a r20 = (a) ZeusTransformUtils.preCheckCast(r19.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
            if (t.f12630a.a(r20.a(), r20.b()) == true) goto L27;
            if (r2 == false) goto L21;
        L27:
            r2 = true;
        L30:
            if (r2 == false) goto L32;
            PendingAppTypeCheckTask.Companion.a();
        L32:
            return r16;
        L29:
            r2 = r4;
            goto L30
        L13:
            e = move-exception;
            r16.clear();     // Catch: Throwable -> L11
            Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11
        L16:
            if (r110.hasNext() == false) goto L18;
            r16.add(new a((String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin"), 0));     // Catch: Throwable -> L11
            goto L16
        L18:
            e.printStackTrace();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            r3.recycle();
            r1.recycle();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Map<Integer, String> a() {
            Map<Integer, String> r15 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Parcel r0 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r0, "obtain(...)");
            Parcel r3 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r3, "obtain(...)");
            Object r2 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"apprecord_service"});     // Catch: Throwable -> L9 Exception -> L11
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.os.IBinder");     // Catch: Throwable -> L9 Exception -> L11
            IBinder r4 = (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 Exception -> L11
            r0.setDataPosition(0);     // Catch: Throwable -> L9 Exception -> L11
            r0.writeInterfaceToken("android.app.IAppRecordManager");     // Catch: Throwable -> L9 Exception -> L11
            r4.transact(8889, r0, r3, 0);     // Catch: Throwable -> L9 Exception -> L11
            r3.readException();     // Catch: Throwable -> L9 Exception -> L11
            ArrayList r5 = new ArrayList();     // Catch: Throwable -> L9 Exception -> L11
            r3.readStringList((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9 Exception -> L11
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationCategoryViewModel.TAG, "getClassificationMappingInfo, result: " + r5, false, 4, null);     // Catch: Throwable -> L9 Exception -> L11
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L9 Exception -> L11
        L5:
            if (r6.hasNext() == false) goto L7;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 Exception -> L11
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L9 Exception -> L11
            List r8 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null);     // Catch: Throwable -> L9 Exception -> L11
            r15.put(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r8.get(0), String.class, "com.obric.memorydata.plugin"))), r8.get(1));     // Catch: Throwable -> L9 Exception -> L11
            goto L5
        L7:
            r15.put(0, IRecommendSettings.ProfileTag.OTHER);     // Catch: Throwable -> L9 Exception -> L11
        L13:
            r3.recycle();
            r0.recycle();
            return r15;
        L9:
            th = move-exception;
            r3.recycle();
            r0.recycle();
            throw th;
        L11:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L9
            goto L13
        }

        public final void a(boolean r13, Function0<Unit> r14) {
            Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationCategoryViewModel.TAG, "refreshCategoryItemsCache, isFirstStart: " + r13, false, 4, null);
            kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenObservationCategoryViewModel$Companion$refreshCategoryItemsCache$1(r13, r3, System.currentTimeMillis(), null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }

        public final List<Integer> b() {
            List<Integer> r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Parcel r0 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r0, "obtain(...)");
            Parcel r3 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r3, "obtain(...)");
            Object r2 = ZeusTransformUtils.forName("android.os.ServiceManager", "com.obric.memorydata.plugin").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"apprecord_service"});     // Catch: Throwable -> L9 Exception -> L11
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.os.IBinder");     // Catch: Throwable -> L9 Exception -> L11
            IBinder r4 = (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 Exception -> L11
            r0.setDataPosition(0);     // Catch: Throwable -> L9 Exception -> L11
            r0.writeInterfaceToken("android.app.IAppRecordManager");     // Catch: Throwable -> L9 Exception -> L11
            r4.transact(8890, r0, r3, 0);     // Catch: Throwable -> L9 Exception -> L11
            r3.readException();     // Catch: Throwable -> L9 Exception -> L11
            ArrayList r5 = new ArrayList();     // Catch: Throwable -> L9 Exception -> L11
            r3.readStringList((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9 Exception -> L11
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationCategoryViewModel.TAG, "getAllCategoryInfo, result: " + r5, false, 4, null);     // Catch: Throwable -> L9 Exception -> L11
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L9 Exception -> L11
        L5:
            if (r6.hasNext() == false) goto L7;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9 Exception -> L11
            Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L9 Exception -> L11
            r15.add(Integer.valueOf(Integer.parseInt((String) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{"|"}, false, 0, 6, null).get(0), String.class, "com.obric.memorydata.plugin"))));     // Catch: Throwable -> L9 Exception -> L11
            goto L5
        L7:
            r15.add(0);     // Catch: Throwable -> L9 Exception -> L11
        L13:
            r3.recycle();
            r0.recycle();
            return r15;
        L11:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            r3.recycle();
            r0.recycle();
            throw th;
        }

        public final List<Triple<String, String, Integer>> b(List<String> r9) {
            List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "packageNames");
            List<a> r11 = a(r10);
            Map<Integer, String> r8 = a();
            List<Triple<String, String, Integer>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r3 = 0;
        L4:
            if (r12.hasNext() == false) goto L13;
            Object r4 = r12.next();
            int r5 = r3 + 1;
            if (r3 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
            if (r8.containsKey(Integer.valueOf(r6.b())) == false) goto L11;
            String r7 = r6.a();
            String r13 = r8.get(Integer.valueOf(r6.b()));
            Intrinsics.checkNotNull(r13);
            Triple<String, String, Integer> r14 = new Triple(r7, r13, Integer.valueOf(r6.b()));
        L12:
            r0.add(r14);
            r3 = r5;
            goto L4
        L11:
            r14 = new Triple(r6.a(), IRecommendSettings.ProfileTag.OTHER, 0);
            goto L12
        L13:
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final List<com.obric.memorydata.recommend.settings.b> c(List<Pair<String, String>> r11) {
            List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "names");
            if (r12.isEmpty() == true) goto L5;
            List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            List r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            Iterator r13 = r12.iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r13.next(), Pair.class, "com.obric.memorydata.plugin");
            r0.add(r3.getFirst());
            r2.add(r3.getSecond());
            goto L8
        L10:
            List<Triple<String, String, Integer>> r10 = b(r2);
            List<com.obric.memorydata.recommend.settings.b> r14 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            int r4 = 0;
            int r5 = ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).size();
        L11:
            if (r4 >= r5) goto L16;
            if (r4 >= r0.size()) goto L15;
            r14.add(new com.obric.memorydata.recommend.settings.b((String) ZeusTransformUtils.preCheckCast(r0.get(r4), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r10.get(r4), Triple.class, "com.obric.memorydata.plugin")).getFirst(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r10.get(r4), Triple.class, "com.obric.memorydata.plugin")).getSecond(), String.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(((Triple) ZeusTransformUtils.preCheckCast(r10.get(r4), Triple.class, "com.obric.memorydata.plugin")).getThird(), Number.class, "com.obric.memorydata.plugin")).intValue()));
        L15:
            r4 = r4 + 1;
            goto L11
        L16:
            return r14;
        L5:
            return CollectionsKt.emptyList();
        }

        public final Map<String, List<com.obric.memorydata.recommend.settings.c>> c() {
            Set<String> r0 = t.f12630a.d();
            boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
            Map<String, List<com.obric.memorydata.recommend.settings.c>> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            final AlphabeticIndex r4 = new AlphabeticIndex(Locale.getDefault()).addLabels(new Locale[]{Locale.ENGLISH}).addLabels(new Locale[]{Locale.CHINESE});
            Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            com.obric.memorydata.recommend.settings.b r5 = (com.obric.memorydata.recommend.settings.b) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.recommend.settings.b.class, "com.obric.memorydata.plugin");
            List<com.obric.memorydata.recommend.settings.c> r6 = (List) ZeusTransformUtils.preCheckCast(r2.getOrDefault(r5.c(), (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
            r6.add(new com.obric.memorydata.recommend.settings.c(r5, r1, r0.contains(r5.b())));
            r2.put(r5.c(), r6);
            goto L4
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ScreenObservationCategoryViewModel.TAG, "screenObservationMemoryEnabled: " + ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), false, 4, null);
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r2.keySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r12.hasNext() == false) goto L10;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
            List<com.obric.memorydata.recommend.settings.c> r7 = r2.get(r3);
            Intrinsics.checkNotNull(r7);
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
            final Function2 r9 = new $$Lambda$ScreenObservationCategoryViewModel$b$NCl52hpbFjzlOIeG3XC4a2XaDCA(r4);
            r2.put(r3, CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith(r8, new $$Lambda$ScreenObservationCategoryViewModel$b$I8rUeBkzamlCPp5ZBWbjiN0AhE(r9)), Collection.class, "com.obric.memorydata.plugin")));
            goto L8
        L10:
            return r2;
        }

        public final void d() {
            ScreenObservationCategoryViewModel.access$setCategoryItemsCache$cp(null);
        }

        public final boolean e() {
            if (ScreenObservationCategoryViewModel.access$getCategoryItemsCache$cp() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$updateAppSettingAndCategories$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel$updateAppSettingAndCategories$1", f = "ScreenObservationCategoryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C12191 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationCategoryViewModel this$0;

        C12191(ScreenObservationCategoryViewModel r3, Continuation<? super C12191> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12191(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12191) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12191.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r19);
            Set<String> r1 = t.f12630a.d();
            o r2 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, o.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.middleware.api.logging.e r3 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
            if (AppContext.INSTANCE.isDebug() == false) goto L7;
            String r5 = "初始化应用设置，已启用应用数量=" + r1.size();
            g r6 = new g();
            Unit r7 = Unit.INSTANCE;
            r2.a(r5, r3, r6.a());
        L7:
            ArrayList r4 = new ArrayList();
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(b.a(ScreenObservationCategoryViewModel.Companion, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L9:
            if (r8.hasNext() == false) goto L11;
            com.obric.memorydata.recommend.settings.b r9 = (com.obric.memorydata.recommend.settings.b) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.recommend.settings.b.class, "com.obric.memorydata.plugin");
            r4.add(new com.obric.memorydata.recommend.settings.c(r9, ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), r1.contains(r9.b())));
            goto L9
        L11:
            List r10 = b.a(ScreenObservationCategoryViewModel.Companion);
            ae r0 = ScreenObservationCategoryViewModel.access$get_state$p(this.this$0);
        L12:
            Object r11 = r0.c();
            k r17 = (k) ZeusTransformUtils.preCheckCast(r11, k.class, "com.obric.memorydata.plugin");
            k r12 = s.a(k.a(r17, false, false, false, (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), 0, r10, null, 0, 215, null), r17.a());
            b.a(ScreenObservationCategoryViewModel.Companion, r12.d());
            if (r0.a(r11, r12) == false) goto L12;
            return Unit.INSTANCE;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new b(null);
    }

    public ScreenObservationCategoryViewModel() {
        this.titleBarHeight = new MutableLiveData(0);
        ae<k> r1 = at.a(initializeMemorySettingsState(null));
        this._state = r1;
        this.state = kotlinx.coroutines.flow.k.a(r1);
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.a(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin")), ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")));
        kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.f((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(t.f12630a.o(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin")), ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")));
        updateAppSettingAndCategories();
    }

    public static final /* synthetic */ List access$getCategoryItemsCache$cp() {
        return categoryItemsCache;
    }

    public static final /* synthetic */ ae access$get_state$p(ScreenObservationCategoryViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ void access$setCategoryItemsCache$cp(List r2) {
        categoryItemsCache = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    private final k initializeMemorySettingsState(k r15) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "initializeMemorySettingsState", false, 4, null);
        List<i> r14 = categoryItemsCache;
        if (r14 != null) goto L5;
        r14 = CollectionsKt.emptyList();
    L5:
        boolean r0 = ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        boolean r3 = t.f12630a.k();
        boolean r4 = t.f12630a.n();
        if (r15 == null) goto L9;
        List<com.obric.memorydata.recommend.settings.c> r1 = r15.b();
        if (r1 == null) goto L9;
    L10:
        List<com.obric.memorydata.recommend.settings.c> r5 = r1;
        int r6 = t.f12630a.i();
        if (r15 == null) goto L16;
        List<i> r16 = r15.d();
        if (r16 == null) goto L16;
        List<i> r7 = r16;
    L18:
        return s.a(new k(r0, r3, r4, r5, r6, r7, t.f12630a.j(), 0, 128, null), r0);
    L16:
        r7 = r14;
    L9:
        r1 = CollectionsKt.emptyList();
        goto L10
    }

    private final void updateAppSetting(String r1, boolean r2) {
        updateAppSetting(SetsKt.setOf(r1), r2);
    }

    private final void updateAppSetting(Set<String> r32, boolean r33) {
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r32, Set.class, "com.obric.memorydata.plugin");
        ae<k> r12 = this._state;
    L3:
        k r13 = r12.c();
        k r14 = (k) ZeusTransformUtils.preCheckCast(r13, k.class, "com.obric.memorydata.plugin");
        List r15 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r14.b(), Collection.class, "com.obric.memorydata.plugin"));
        List r8 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r14.d(), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L5:
        if (r16.hasNext() == false) goto L49;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        Iterator r0 = r15.iterator();
        int r1 = 0;
    L8:
        if (r0.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((com.obric.memorydata.recommend.settings.c) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.memorydata.recommend.settings.c.class, "com.obric.memorydata.plugin")).b(), r7) == true) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        int r5 = r1;
    L14:
        if (r5 == (-1)) goto L17;
        r15.set(r5, com.obric.memorydata.recommend.settings.c.a((com.obric.memorydata.recommend.settings.c) ZeusTransformUtils.preCheckCast(r15.get(r5), com.obric.memorydata.recommend.settings.c.class, "com.obric.memorydata.plugin"), null, null, false, r33, null, 0, 55, null));
    L17:
        Iterator r2 = r8.iterator();
        int r6 = 0;
    L19:
        if (r2.hasNext() == false) goto L36;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((i) ZeusTransformUtils.preCheckCast(r2.next(), i.class, "com.obric.memorydata.plugin")).a(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L23;
    L25:
        Iterator r4 = r3.iterator();
    L27:
        if (r4.hasNext() == false) goto L32;
        String r9 = r7;
        if (Intrinsics.areEqual(((com.obric.memorydata.recommend.settings.c) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.recommend.settings.c.class, "com.obric.memorydata.plugin")).b(), r9) == true) goto L30;
        r7 = r9;
        goto L27
    L30:
        boolean r10 = true;
    L33:
        if (r10 == true) goto L34;
        r6 = r6 + 1;
        r7 = r9;
        goto L19
    L34:
        int r17 = r6;
        int r18 = -1;
    L37:
        if (r17 == r18) goto L47;
        List r19 = r8;
        i r110 = (i) ZeusTransformUtils.preCheckCast(r19.get(r17), i.class, "com.obric.memorydata.plugin");
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r110.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r20.iterator();
    L40:
        if (r111.hasNext() == false) goto L46;
        com.obric.memorydata.recommend.settings.c r22 = (com.obric.memorydata.recommend.settings.c) ZeusTransformUtils.preCheckCast(r111.next(), com.obric.memorydata.recommend.settings.c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r22.b(), r9) == false) goto L44;
        r22 = com.obric.memorydata.recommend.settings.c.a(r22, null, null, false, r33, null, 0, 55, null);
        Collection r23 = r21;
    L45:
        r23.add(r22);
        r21 = r23;
        r19 = r19;
        r9 = r9;
        r17 = r17;
        r15 = r15;
        goto L40
    L44:
        r23 = r21;
        goto L45
    L46:
        List r31 = r15;
        List r112 = r19;
        r112.set(r17, i.a(r110, (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null));
    L48:
        r8 = r112;
        r15 = r31;
        goto L5
    L47:
        List r30 = r15;
        r112 = r8;
        r31 = r30;
        goto L48
    L32:
        r9 = r7;
        r10 = false;
        goto L33
    L23:
        if (((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L25;
        r10 = false;
        r9 = r7;
        goto L33
    L36:
        r9 = r7;
        r18 = -1;
        r17 = -1;
        goto L37
    L13:
        r5 = -1;
        goto L14
    L49:
        List r34 = r15;
        List r113 = r8;
        o r24 = (o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r25 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L52;
        String r26 = "更新应用设置，应用数量=" + r11.size() + "，启用状态=" + r33;
        g r27 = new g();
        Unit r28 = Unit.INSTANCE;
        r24.a(r26, r25, r27.a());
    L52:
        t.f12630a.a(r11, r33);
        b.a(Companion, r113);
        if (r12.a(r13, k.a(r14, false, false, false, r34, 0, r113, null, 0, 215, null)) == false) goto L3;
    }

    private final void updateAppSettingAndCategories() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C12191(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    private final void updateCellular(boolean r1) {
        t.f12630a.b(r1);
    }

    private final void updateEnableCategories(int r13, boolean r14) {
        t.f12630a.a(r13, r14);
        ae<k> r12 = this._state;
    L3:
        k r15 = r12.c();
        if (r12.a(r15, k.a((k) ZeusTransformUtils.preCheckCast(r15, k.class, "com.obric.memorydata.plugin"), false, false, false, null, 0, null, t.f12630a.j(), 0, 191, null)) == false) goto L3;
    }

    private final void updateNewMemorySetting(int r15) {
        t.f12630a.a(r15);
        ae<k> r14 = this._state;
    L3:
        k r0 = r14.c();
        if (r14.a(r0, k.a((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin"), false, false, false, null, r15, null, null, 0, 239, null)) == false) goto L3;
    }

    private final void updateRecommend(boolean r5) {
        com.obric.memorydata.recommend.feature.a r0 = com.obric.memorydata.recommend.feature.a.f12505a;
        if (r5 == false) goto L5;
        r0.c();
    L6:
        ae<k> r4 = this._state;
    L7:
        k r1 = r4.c();
        k r2 = s.a((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.memorydata.plugin"), r5);
        b.a(Companion, r2.d());
        if (r4.a(r1, r2) == false) goto L7;
        return;
    L5:
        r0.d();
        goto L6
    }

    public final List<h> getAllCategoryInfo() {
        b r8 = Companion;
        List<Integer> r0 = r8.b();
        Map<Integer, String> r9 = r8.a();
        Set<String> r1 = t.f12630a.j();
        List<h> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r9.containsKey(Integer.valueOf(r4)) == true) goto L7;
        r2.add(new h(IRecommendSettings.ProfileTag.OTHER, 0, r1.contains("0")));
        goto L4
    L7:
        String r5 = r9.get(Integer.valueOf(r4));
        Intrinsics.checkNotNull(r5);
        r2.add(new h((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin"), r4, r1.contains(String.valueOf(r4))));
        goto L4
    L9:
        return r2;
    }

    public final ar<k> getState() {
        return this.state;
    }

    public final MutableLiveData<Integer> getTitleBarHeight() {
        return this.titleBarHeight;
    }

    public final void processIntent(r r4) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        if (ZeusTransformUtils.instanceOf(r4, r.f.class) == false) goto L6;
        updateRecommend(((r.f) ZeusTransformUtils.preCheckCast(r4, r.f.class, "com.obric.memorydata.plugin")).a());
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, r.b.class) == false) goto L9;
        updateAppSetting(((r.b) ZeusTransformUtils.preCheckCast(r4, r.b.class, "com.obric.memorydata.plugin")).a(), ((r.b) ZeusTransformUtils.preCheckCast(r4, r.b.class, "com.obric.memorydata.plugin")).b());
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, r.a.class) == false) goto L12;
        updateAppSetting(((r.a) ZeusTransformUtils.preCheckCast(r4, r.a.class, "com.obric.memorydata.plugin")).a(), ((r.a) ZeusTransformUtils.preCheckCast(r4, r.a.class, "com.obric.memorydata.plugin")).b());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r4, r.c.class) == false) goto L15;
        updateCellular(((r.c) ZeusTransformUtils.preCheckCast(r4, r.c.class, "com.obric.memorydata.plugin")).a());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r4, r.e.class) == false) goto L18;
        updateNewMemorySetting(((r.e) ZeusTransformUtils.preCheckCast(r4, r.e.class, "com.obric.memorydata.plugin")).a());
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r4, r.d.class) == false) goto L22;
        updateEnableCategories(((r.d) ZeusTransformUtils.preCheckCast(r4, r.d.class, "com.obric.memorydata.plugin")).a(), ((r.d) ZeusTransformUtils.preCheckCast(r4, r.d.class, "com.obric.memorydata.plugin")).b());
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }

    public final void refresh() {
        k r0 = (k) ZeusTransformUtils.preCheckCast(this._state.c(), k.class, "com.obric.memorydata.plugin");
        k r1 = k.a(initializeMemorySettingsState(r0), false, false, false, null, 0, null, null, r0.e() + 1, 127, null);
        updateAppSettingAndCategories();
        RunLog.INSTANCE.debug(TAG, "旧对象 == 新对象？" + Intrinsics.areEqual(r0, r1));
        RunLog r2 = RunLog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append("旧对象 === 新对象？");
        if (r0 != r1) goto L5;
        boolean r4 = true;
    L6:
        r2.debug(TAG, r3.append(r4).toString());
        this._state.b(r1);
        return;
    L5:
        r4 = false;
        goto L6
    }
}
