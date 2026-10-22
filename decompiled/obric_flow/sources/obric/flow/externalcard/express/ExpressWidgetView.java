package obric.flow.externalcard.express;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.flow.cardlistpage.ui.component.feedlist.p;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.ExpressCard;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.internal.c;
import ku.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lobric/flow/externalcard/express/ExpressWidgetView;", "Landroid/widget/FrameLayout;", "Lku/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ExternalCard_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ExpressWidgetView extends FrameLayout implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f20444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExpressCard f20445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20446c;

    /* JADX INFO: renamed from: obric.flow.externalcard.express.ExpressWidgetView$onAttachedToWindow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "obric.flow.externalcard.express.ExpressWidgetView$onAttachedToWindow$1", f = "ExpressWidgetView.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ExpressWidgetView this$0;

        public AnonymousClass1(ExpressWidgetView r5, Continuation<? super AnonymousClass1> r10) {
            this.this$0 = r5;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            return new AnonymousClass1(this.this$0, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L6;
            ResultKt.throwOnFailure(r10);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            i2 r12 = obric.flow.externalcard.a.f20437a;
            p r13 = new p(this.this$0, 3);
            this.label = 1;
            r12.getClass();
            if (i2.k(r12, r13, this) != r5) goto L12;
            return r5;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @JvmOverloads
    public ExpressWidgetView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        c r5 = h0.b();
        this.f20444a = r5;
        BuildersKt.launch$default(r5, null, null, new AnonymousClass1(this, null), 3, null);
        super.onAttachedToWindow();
    }

    @Override // ku.a
    public final void onDestroy() {
        ExpressCard r5 = this.f20445b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
        r5 = null;
    L5:
        r5.onDestroy();
        c r10 = this.f20444a;
        if (r10 == null) goto L8;
        h0.c(r10, null);
    L8:
        this.f20444a = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        c r5 = this.f20444a;
        if (r5 == null) goto L5;
        h0.c(r5, null);
    L5:
        this.f20444a = null;
        super.onDetachedFromWindow();
    }

    @JvmOverloads
    public ExpressWidgetView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ ExpressWidgetView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public ExpressWidgetView(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        View r12 = LayoutInflater.from(r5).inflate(R.layout.miboard_card_express, this, false);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.zte.miboard.cards.express.ExpressCard");
        ExpressCard r13 = (ExpressCard) r12;
        this.f20445b = r13;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("travelView");
        r13 = null;
    L5:
        addView(r13);
    }
}
