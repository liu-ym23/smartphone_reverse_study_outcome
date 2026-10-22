package com.obric.assistant.settings;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/ObricSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_settingItems", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/obric/assistant/settings/GroupUiModel;", "settingItems", "Landroidx/lifecycle/LiveData;", "getSettingItems", "()Landroidx/lifecycle/LiveData;", "refreshSettings", "", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ObricSettingViewModel";
    private final MutableLiveData<List<j>> _settingItems;
    private final LiveData<List<j>> settingItems;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.settings.ObricSettingViewModel$refreshSettings$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.ObricSettingViewModel$refreshSettings$1", f = "ObricSettingViewModel.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {32, 45}, m = "invokeSuspend", n = {"allGroups", "destination$iv$iv", "itemsByGroup", "destination$iv$iv", "id", "groups", "destination$iv$iv", "element$iv$iv", "primaryGroup"}, s = {"L$0", "L$2", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.obric.assistant.settings.spi.b $host;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        final /* synthetic */ ObricSettingViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.ObricSettingViewModel$refreshSettings$1$a */
        public static final class a<T> implements Comparator {
            public a() {
            }

            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((com.obric.assistant.settings.spi.c) ((Pair) r2).getFirst()).a()), Integer.valueOf(((com.obric.assistant.settings.spi.c) ((Pair) r1).getFirst()).a()));
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.settings.ObricSettingViewModel$refreshSettings$1$b */
        public static final class b<T> implements Comparator {
            public b() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((com.obric.assistant.settings.spi.e) r2).d), Integer.valueOf(((com.obric.assistant.settings.spi.e) r1).d));
            }
        }

        public AnonymousClass1(ObricSettingViewModel r1, com.obric.assistant.settings.spi.b r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$host = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$host, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00e4 -> B:20:0x00e7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0225 -> B:63:0x0230). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r31) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            Collection r3 = (Collection) this.L$9;
            com.obric.assistant.settings.spi.c r7 = (com.obric.assistant.settings.spi.c) this.L$8;
            Object r8 = this.L$7;
            Iterator r9 = (Iterator) this.L$6;
            Collection r10 = (Collection) this.L$5;
            List r11 = (List) this.L$4;
            String r12 = (String) this.L$3;
            Iterator r13 = (Iterator) this.L$2;
            Collection r14 = (Collection) this.L$1;
            Map r15 = (Map) this.L$0;
            ResultKt.throwOnFailure(r31);
            Object r6 = r31;
            Collection r5 = r14;
            com.obric.assistant.settings.spi.c r16 = r7;
            Iterator r17 = r13;
            List r18 = r11;
            Collection r19 = r10;
            Iterator r110 = r9;
            Collection r20 = r3;
            Map r4 = r15;
            String r111 = r12;
            AnonymousClass1 r112 = this;
        L64:
            if (((Boolean) r6).booleanValue() == false) goto L66;
            r19.add(r8);
        L66:
            Collection r21 = r20;
            Iterator r22 = r110;
            Collection r113 = r19;
            AnonymousClass1 r114 = r112;
            List r115 = r18;
            com.obric.assistant.settings.spi.c r116 = r16;
            String r117 = r111;
        L58:
            if (r22.hasNext() == false) goto L67;
            Object r118 = r22.next();
            r114.L$0 = r4;
            r114.L$1 = r5;
            r114.L$2 = r17;
            r114.L$3 = r117;
            r114.L$4 = r115;
            r114.L$5 = r113;
            r114.L$6 = r22;
            r114.L$7 = r118;
            r114.L$8 = r116;
            r114.L$9 = r21;
            r114.label = 2;
            r6 = ((com.obric.assistant.settings.spi.e) r118).a(r114);
            if (r6 != r1) goto L62;
            return r1;
        L62:
            Iterator r29 = r22;
            r20 = r21;
            r8 = r118;
            r111 = r117;
            r16 = r116;
            r18 = r115;
            r112 = r114;
            r19 = r113;
            r110 = r29;
            goto L64
        L67:
            List r23 = CollectionsKt.sortedWith((List) r113, new b());
            List r119 = r115;
            boolean r120 = false;
            if ((r119 instanceof Collection) == true) goto L70;
        L72:
            Iterator r24 = r119.iterator();
        L74:
            if (r24.hasNext() == false) goto L71;
            if (((Boolean) ((com.obric.assistant.settings.spi.c) r24.next()).b.invoke()).booleanValue() == false) goto L74;
            boolean r25 = true;
        L78:
            if (r25 == true) goto L80;
        L82:
            FLogger.a.d(ObricSettingViewModel.TAG, "Group " + r117 + " is visible: " + r120 + ", has " + r23.size() + " visible items");
            if (r120 == false) goto L85;
            Pair r26 = new Pair(r116, r23);
        L86:
            r21.add(r26);
            r21 = r5;
            AnonymousClass1 r121 = r114;
        L37:
            if (r17.hasNext() == false) goto L87;
            Map.Entry r27 = (Map.Entry) r17.next();
            String r122 = (String) r27.getKey();
            List r28 = (List) r27.getValue();
            Iterator r123 = r28.iterator();
            if (r123.hasNext() == true) goto L41;
            Object r124 = null;
        L50:
            r116 = (com.obric.assistant.settings.spi.c) r124;
            if (r116 != null) goto L53;
            r116 = (com.obric.assistant.settings.spi.c) CollectionsKt.first(r28);
        L53:
            List r30 = (List) r4.get(r122);
            if (r30 != null) goto L56;
            r117 = r122;
            r114 = r121;
            r113 = new ArrayList();
            r115 = r28;
            r22 = r30.iterator();
            r5 = r21;
            goto L58
        L56:
            List r32 = CollectionsKt.emptyList();
            r117 = r122;
            r114 = r121;
            r113 = new ArrayList();
            r115 = r28;
            r22 = r32.iterator();
            r5 = r21;
            goto L58
        L41:
            r124 = r123.next();
            if (r123.hasNext() == false) goto L50;
            int r125 = ((com.obric.assistant.settings.spi.c) r124).a();
        L45:
            Object r126 = r123.next();
            int r33 = ((com.obric.assistant.settings.spi.c) r126).a();
            if (r125 >= r33) goto L49;
            r125 = r33;
            r124 = r126;
        L49:
            if (r123.hasNext() == true) goto L45;
        L87:
            List r34 = CollectionsKt.sortedWith(CollectionsKt.filterNotNull((List) r21), new a());
            ArrayList r35 = new ArrayList();
            Iterator r36 = r34.iterator();
        L89:
            if (r36.hasNext() == false) goto L115;
            Pair r37 = (Pair) r36.next();
            com.obric.assistant.settings.spi.c r38 = (com.obric.assistant.settings.spi.c) r37.component1();
            List r39 = (List) r37.component2();
            ArrayList r40 = new ArrayList();
            Iterator r41 = r39.iterator();
        L92:
            if (r41.hasNext() == false) goto L111;
            com.obric.assistant.settings.spi.e r42 = (com.obric.assistant.settings.spi.e) r41.next();
            if ((r42 instanceof com.obric.assistant.settings.spi.f) == false) goto L96;
            String r43 = r42.b;
            CharSequence r127 = r42.c;
            com.obric.assistant.settings.spi.f r44 = (com.obric.assistant.settings.spi.f) r42;
            Iterator r310 = r36;
            q0 r45 = new g1(r43, r127, r44.g, ((Boolean) r44.e.invoke()).booleanValue(), r44.f, ((Boolean) r44.i.invoke()).booleanValue(), r44.j, r44.k, r44.l, ((Boolean) r44.m.invoke()).booleanValue(), r44.n);
        L108:
            if (r45 == null) goto L110;
            r40.add(r45);
        L110:
            r36 = r310;
            goto L92
        L96:
            r310 = r36;
            if ((r42 instanceof com.obric.assistant.settings.spi.a) == false) goto L107;
            String r0 = r42.b;
            CharSequence r46 = r42.c;
            com.obric.assistant.settings.spi.a r47 = (com.obric.assistant.settings.spi.a) r42;
            Function0<String> r48 = r47.f;
            if (r48 == null) goto L101;
            String r210 = (String) r48.invoke();
        L102:
            Function1<View, Unit> r49 = r47.e;
            boolean r211 = ((Boolean) r47.i.invoke()).booleanValue();
            Function0<String> r128 = r47.g;
            if (r128 == null) goto L105;
            String r212 = (String) r128.invoke();
        L106:
            r45 = new com.obric.assistant.settings.a(r0, r46, r210, r49, r211, r212, r47.j, ((Boolean) r47.k.invoke()).booleanValue(), r47.l);
            goto L108
        L105:
            r212 = null;
            goto L106
        L101:
            r210 = null;
            goto L102
        L107:
            r45 = null;
            goto L108
        L111:
            Iterator r311 = r36;
            if ((!r40.isEmpty()) == false) goto L114;
            r35.add(new j(r38.a, r40));
        L114:
            r36 = r311;
            goto L89
        L115:
            FLogger.a.d(ObricSettingViewModel.TAG, "Total " + r35.size() + " groups to display");
            ObricSettingViewModel.access$get_settingItems$p(r121.this$0).postValue(r35);
            return Unit.INSTANCE;
        L85:
            r26 = null;
            goto L86
        L80:
            if ((!r23.isEmpty()) == false) goto L82;
            r120 = true;
        L71:
            r25 = false;
            goto L78
        L70:
            if (r119.isEmpty() == false) goto L72;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Iterator r50 = (Iterator) this.L$3;
            Collection r51 = (Collection) this.L$2;
            com.obric.assistant.settings.spi.b r52 = (com.obric.assistant.settings.spi.b) this.L$1;
            List r53 = (List) this.L$0;
            ResultKt.throwOnFailure(r31);
            Object r129 = r31;
            r121 = this;
        L20:
            CollectionsKt.addAll(r51, (Iterable) r129);
        L16:
            if (r50.hasNext() == false) goto L21;
            IObricSettingProvider r130 = (IObricSettingProvider) r50.next();
            r121.L$0 = r53;
            r121.L$1 = r52;
            r121.L$2 = r51;
            r121.L$3 = r50;
            r121.label = 1;
            r129 = r130.b(r52, r121);
            if (r129 != r1) goto L20;
            return r1;
        L21:
            List r54 = (List) r51;
            FLogger.a.d(ObricSettingViewModel.TAG, "Loaded " + r53.size() + " groups and " + r54.size() + " items");
            r4 = new LinkedHashMap();
            Iterator r55 = r54.iterator();
        L23:
            if (r55.hasNext() == false) goto L28;
            Object r56 = r55.next();
            String r131 = ((com.obric.assistant.settings.spi.e) r56).a;
            Object r132 = r4.get(r131);
            if (r132 != null) goto L27;
            r132 = new ArrayList();
            r4.put(r131, r132);
        L27:
            ((List) r132).add(r56);
            goto L23
        L28:
            LinkedHashMap r57 = new LinkedHashMap();
            Iterator r58 = r53.iterator();
        L30:
            if (r58.hasNext() == false) goto L35;
            Object r59 = r58.next();
            String r133 = ((com.obric.assistant.settings.spi.c) r59).a;
            Object r134 = r57.get(r133);
            if (r134 != null) goto L34;
            r134 = new ArrayList();
            r57.put(r133, r134);
        L34:
            ((List) r134).add(r59);
            goto L30
        L35:
            r21 = new ArrayList(r57.size());
            r17 = r57.entrySet().iterator();
            goto L37
        L10:
            ResultKt.throwOnFailure(r31);
            Set r60 = ServiceManager.get().getServices(IObricSettingProvider.class, true);
            FLogger.a.d(ObricSettingViewModel.TAG, "Found " + r60.size() + " setting providers");
            Intrinsics.checkNotNull(r60);
            Set r61 = r60;
            com.obric.assistant.settings.spi.b r62 = this.$host;
            ArrayList r63 = new ArrayList();
            Iterator r64 = r61.iterator();
        L12:
            if (r64.hasNext() == false) goto L14;
            CollectionsKt.addAll(r63, ((IObricSettingProvider) r64.next()).a(r62));
            goto L12
        L14:
            com.obric.assistant.settings.spi.b r65 = this.$host;
            ArrayList r66 = new ArrayList();
            r50 = r61.iterator();
            r121 = this;
            r52 = r65;
            r51 = r66;
            r53 = r63;
            goto L16
        }
    }

    static {
        Companion = new a();
    }

    public ObricSettingViewModel() {
        MutableLiveData<List<j>> r0 = new MutableLiveData();
        this._settingItems = r0;
        this.settingItems = r0;
    }

    public final LiveData<List<j>> getSettingItems() {
        return this.settingItems;
    }

    public static final /* synthetic */ MutableLiveData access$get_settingItems$p(ObricSettingViewModel r0) {
        return r0._settingItems;
    }

    public final void refreshSettings(com.obric.assistant.settings.spi.b r8) {
        Intrinsics.checkNotNullParameter(r8, "host");
        if (r8.getHostContext() != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new AnonymousClass1(this, r8, null), 2, null);
    }
}
