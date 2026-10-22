package com.obric.flow.cardlistpage.ui;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import com.obric.feature.miniapp.widget.MiniAppWidgetProviderInfo;
import com.obric.flow.cardlistpage.data.CardDatabase;
import com.obric.flow.cardlistpage.data.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Landroid/appwidget/AppWidgetProviderInfo;", "Lkotlin/collections/ArrayList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.WidgetPickerCoordinator$loadAddedWidgets$2", f = "WidgetPickerCoordinator.kt", i = {0, 0, 1, 1}, l = {211, 224}, m = "invokeSuspend", n = {"addedWidgets", "addedProviders", "addedWidgets", "addedProviders"}, s = {"L$0", "L$1", "L$0", "L$1"})
@SourceDebugExtension({"SMAP\nWidgetPickerCoordinator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WidgetPickerCoordinator.kt\ncom/obric/flow/cardlistpage/ui/WidgetPickerCoordinator$loadAddedWidgets$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,265:1\n1863#2,2:266\n1863#2:268\n1864#2:270\n1#3:269\n*S KotlinDebug\n*F\n+ 1 WidgetPickerCoordinator.kt\ncom/obric/flow/cardlistpage/ui/WidgetPickerCoordinator$loadAddedWidgets$2\n*L\n213#1:266,2\n225#1:268\n225#1:270\n*E\n"})
final class WidgetPickerCoordinator$loadAddedWidgets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArrayList<AppWidgetProviderInfo>>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ l this$0;

    public WidgetPickerCoordinator$loadAddedWidgets$2(l r5, Continuation<? super WidgetPickerCoordinator$loadAddedWidgets$2> r10) {
        this.this$0 = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new WidgetPickerCoordinator$loadAddedWidgets$2(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super ArrayList<AppWidgetProviderInfo>> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.util.ArrayList] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r10 = this.label;
        if (r10 == 0) goto L18;
        if (r10 == 1) goto L13;
        if (r10 != 2) goto L12;
        HashSet r11 = (HashSet) this.L$1;
        ArrayList r12 = (ArrayList) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L9
        Object r13 = r20;
        r10 = r12;
    L47:
        l r14 = this.this$0;     // Catch: Throwable -> L9
        Iterator r15 = ((List) r13).iterator();     // Catch: Throwable -> L9
    L48:
        if (r15.hasNext() == false) goto L91;
        com.obric.flow.cardlistpage.data.j r16 = (com.obric.flow.cardlistpage.data.j) r15.next();     // Catch: Throwable -> L9
        String r17 = r16.f11491m;     // Catch: Throwable -> L9
        int r18 = r16.g;
        int r19 = r16.f;
        if (r17 == null) goto L48;
        if (StringsKt.isBlank(r17) == true) goto L56;
        String r110 = r17;
    L57:
        if (r110 == null) goto L48;
        String r21 = r16.f11492n;     // Catch: Throwable -> L9
        if (r21 == null) goto L48;
        if (StringsKt.isBlank(r21) == true) goto L64;
        String r111 = r21;
    L65:
        if (r111 == null) goto L48;
        MiniAppWidgetProviderInfo.Companion r112 = MiniAppWidgetProviderInfo.Companion;     // Catch: Throwable -> L9
        Context r113 = r14.f11782a;     // Catch: Throwable -> L9
        String r22 = r16.f11493o;     // Catch: Throwable -> L9
        if (r22 != null) goto L70;
        String r114 = null;
    L75:
        MiniAppWidgetProviderInfo r23 = r112.create(r113, r110, r111, r114, r16.f, r16.g);     // Catch: Throwable -> L9
        if (r23 == null) goto L48;
        String r24 = r16.d;     // Catch: Throwable -> L9
        if (Boxing.boxBoolean(!StringsKt.isBlank(r24)).booleanValue() == true) goto L81;
        r24 = null;
    L81:
        ((AppWidgetProviderInfo) r23).label = r24;     // Catch: Throwable -> L9
        r23.setSpanX(r19);     // Catch: Throwable -> L9
        r23.setSpanY(r18);     // Catch: Throwable -> L9
        r23.setMinSpanX(r19);     // Catch: Throwable -> L9
        r23.setMinSpanY(r18);     // Catch: Throwable -> L9
        ComponentName r25 = ((AppWidgetProviderInfo) r23).provider;     // Catch: Throwable -> L9
        if (r25 == null) goto L48;
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L9
        if (r11.add(r25) == false) goto L48;
        r10.add(r23);     // Catch: Throwable -> L9
        goto L48
    L70:
        if (StringsKt.isBlank(r22) == false) goto L73;
        r22 = null;
    L73:
        r114 = r22;
        goto L75
    L64:
        r111 = null;
        goto L65
    L56:
        r110 = null;
    L91:
        return r10;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        HashSet r26 = (HashSet) this.L$1;
        ArrayList r27 = (ArrayList) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L16
        Object r28 = r20;
    L26:
        l r29 = this.this$0;     // Catch: Throwable -> L16
        Iterator r30 = ((List) r28).iterator();     // Catch: Throwable -> L16
    L28:
        if (r30.hasNext() == false) goto L40;
        Integer r115 = StringsKt.toIntOrNull(((com.obric.flow.cardlistpage.data.j) r30.next()).f11484b);     // Catch: Throwable -> L16
        if (r115 == null) goto L28;
        AppWidgetProviderInfo r116 = r29.f11784c.getAppWidgetInfo(r115.intValue());     // Catch: Throwable -> L16
        if (r116 == null) goto L28;
        Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L16
        ComponentName r117 = r116.provider;     // Catch: Throwable -> L16
        if (r117 == null) goto L28;
        Intrinsics.checkNotNull(r117);     // Catch: Throwable -> L16
        if (r26.add(r117) == false) goto L28;
        r27.add(r116);     // Catch: Throwable -> L16
        goto L28
    L40:
        CardDatabase r31 = n.f11500a;     // Catch: Throwable -> L16
        if (r31 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("db");     // Catch: Throwable -> L16
        r31 = null;
    L43:
        kotlinx.coroutines.flow.g r32 = r31.a().b("MINI_APP");     // Catch: Throwable -> L16
        this.L$0 = r27;     // Catch: Throwable -> L16
        this.L$1 = r26;     // Catch: Throwable -> L16
        this.label = 2;     // Catch: Throwable -> L16
        r13 = kotlinx.coroutines.flow.i.k(r32, this);     // Catch: Throwable -> L16
        if (r13 != r5) goto L46;
        return r5;
    L46:
        r11 = r26;
        r10 = r27;
    L16:
        th = th;
        r10 = r27;
    L88:
        Intrinsics.checkNotNullParameter("WidgetPickerCoordinator", "tag");
        Intrinsics.checkNotNullParameter("loadAddedWidgets failed", "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r33 = su.a.f22013b;
        if (r33 == null) goto L93;
        ((ju.b) r33.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("WidgetPickerCoordinator", "loadAddedWidgets failed", th);
        goto L91
    L93:
        throw new IllegalStateException("KoinApplication has not been started");
    L18:
        ResultKt.throwOnFailure(r20);
        ArrayList r34 = new ArrayList();
        HashSet r35 = new HashSet();     // Catch: Throwable -> L9
        CardDatabase r36 = n.f11500a;     // Catch: Throwable -> L9
        if (r36 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("db");     // Catch: Throwable -> L9
        r36 = null;
    L22:
        kotlinx.coroutines.flow.g r37 = r36.a().b("WIDGET");     // Catch: Throwable -> L9
        this.L$0 = r34;     // Catch: Throwable -> L9
        this.L$1 = r35;     // Catch: Throwable -> L9
        this.label = 1;     // Catch: Throwable -> L9
        r28 = kotlinx.coroutines.flow.i.k(r37, this);     // Catch: Throwable -> L9
        if (r28 != r5) goto L25;
        return r5;
    L25:
        r27 = r34;
        r26 = r35;
    L9:
        th = th;
        goto L88
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super ArrayList<AppWidgetProviderInfo>> r10) {
        return ((WidgetPickerCoordinator$loadAddedWidgets$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
