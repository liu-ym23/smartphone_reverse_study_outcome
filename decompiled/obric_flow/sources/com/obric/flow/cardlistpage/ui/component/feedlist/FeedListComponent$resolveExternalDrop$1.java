package com.obric.flow.cardlistpage.ui.component.feedlist;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.widget.Toast;
import com.obric.flow.cardlistpage.R$dimen;
import com.obric.flow.cardlistpage.R$string;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$resolveExternalDrop$1", f = "FeedListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFeedListComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FeedListComponent.kt\ncom/obric/flow/cardlistpage/ui/component/feedlist/FeedListComponent$resolveExternalDrop$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1384:1\n1#2:1385\n*E\n"})
final class FeedListComponent$resolveExternalDrop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $currentFakePosition;
    final /* synthetic */ Intent $dropIntent;
    int label;
    final /* synthetic */ s this$0;

    public FeedListComponent$resolveExternalDrop$1(int r5, Intent r10, s r11, Continuation<? super FeedListComponent$resolveExternalDrop$1> r12) {
        this.$currentFakePosition = r5;
        this.$dropIntent = r10;
        this.this$0 = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$resolveExternalDrop$1(this.$currentFakePosition, this.$dropIntent, this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L55;
        ResultKt.throwOnFailure(r14);
        Integer r10 = null;
        if (this.$currentFakePosition != (-1)) goto L12;
        String r15 = "resolveExternalDrop fallback: fake drag position is missing, dropIntent=" + this.$dropIntent;
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r15, "msg");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L10;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("FeedListComponent", r15);
        goto L12
    L10:
        throw new IllegalStateException("KoinApplication has not been started");
    L12:
        if (obric.flow.miniappwidget.g.b(this.$dropIntent) == false) goto L27;
        obric.flow.miniappwidget.f r11 = obric.flow.miniappwidget.g.d(this.$dropIntent);
        if (r11 != null) goto L21;
        String r16 = "resolveExternalDrop mini app input invalid: " + this.$dropIntent;
        Intrinsics.checkNotNullParameter("FeedListComponent", "tag");
        Intrinsics.checkNotNullParameter(r16, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L20;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("FeedListComponent", r16);
        Toast.makeText(this.this$0.d, R$string.widget_load_failed, 0).show();
        this.this$0.d(new x(this.$currentFakePosition, 0.0f, 0.0f));
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("KoinApplication has not been started");
    L21:
        s r17 = this.this$0;
        Integer r13 = Boxing.boxInt(this.$currentFakePosition);
        if (r13.intValue() < 0) goto L24;
        Integer r18 = r13;
    L25:
        r17.getClass();
        BuildersKt.launch$default((CoroutineScope) r17.f11532b, null, null, new FeedListComponent$addMiniAppWidget$1(r17, r11, r18, "drag_add_mini_app_widget", null), 3, null);
        return Unit.INSTANCE;
    L24:
        r18 = null;
        goto L25
    L27:
        int r19 = this.$dropIntent.getIntExtra("appWidgetId", 0);
        if (r19 != 0) goto L37;
        ComponentName r20 = (ComponentName) this.$dropIntent.getParcelableExtra("android.intent.extra.COMPONENT_NAME");
        if (r20 != null) goto L34;
        r20 = (ComponentName) this.$dropIntent.getParcelableExtra("appWidgetProvider");
        if (r20 != null) goto L34;
        r20 = this.$dropIntent.getComponent();
    L34:
        if (r20 == null) goto L37;
        r19 = this.this$0.f.allocateAppWidgetId();
        if (this.this$0.g.bindAppWidgetIdIfAllowed(r19, r20) == true) goto L37;
        this.this$0.f.deleteAppWidgetId(r19);
        Toast.makeText(this.this$0.d, R$string.widget_load_failed, 0).show();
        return Unit.INSTANCE;
    L37:
        int r21 = r19;
        if (r21 == 0) goto L53;
        AppWidgetProviderInfo r110 = this.this$0.g.getAppWidgetInfo(r21);
        if (r110 == null) goto L48;
        eq.b r22 = com.lynx.tasm.utils.k.r();
        JSONObject r23 = new JSONObject();
        String r111 = r110.label;
        if (r111 != null) goto L46;
        r111 = "";
    L47:
        r23.put("widget_name", r111);
        Unit r112 = Unit.INSTANCE;
        r22.a("drag_add_widget", r23);
        goto L48
    L46:
        Intrinsics.checkNotNull(r111);
    L48:
        int r24 = this.this$0.d.getResources().getDimensionPixelSize(R$dimen.normal_space_new);
        int r25 = this.this$0.d.getResources().getDimensionPixelSize(R$dimen.card_height);
        int r26 = ((this.this$0.d.getResources().getDisplayMetrics().widthPixels - (this.this$0.d.getResources().getDimensionPixelSize(R$dimen.card_list_page_left_space_new) * 2)) - (3 * r24)) / 4;
        s r113 = this.this$0;
        Integer r114 = Boxing.boxInt(this.$currentFakePosition);
        if (r114.intValue() < 0) goto L51;
        r10 = r114;
    L51:
        r113.getClass();
        BuildersKt.launch$default((CoroutineScope) r113.f11532b, null, null, new FeedListComponent$addCardFromPicker$1(r113, r21, r26, r25, r24, r10, null), 3, null);
    L53:
        return Unit.INSTANCE;
    L55:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((FeedListComponent$resolveExternalDrop$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
