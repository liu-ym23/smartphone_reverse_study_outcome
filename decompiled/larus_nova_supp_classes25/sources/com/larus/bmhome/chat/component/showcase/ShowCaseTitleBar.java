package com.larus.bmhome.chat.component.showcase;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusCaseTitleLayoutBinding;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import o37.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u001dJ\b\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001dJ\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\u000e\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,J\u000e\u0010.\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/bmhome/chat/component/showcase/ShowCaseTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/bmhome/databinding/LarusCaseTitleLayoutBinding;", "binding", "getBinding", "()Lcom/larus/bmhome/databinding/LarusCaseTitleLayoutBinding;", "navigatorSimplify", "", "init", "", "initView", "setupSubTitle", "setBackIconRes", "iconResId", "setSubtitleVisible", "isVisible", "setTitle", "title", "", "setSubTitle", "subTitle", "generateBinding", "setupCreateCvs", "setAvatar", "iconUrl", "loadImg", "imgUrl", "builder", "Lcom/facebook/drawee/backends/pipeline/PipelineDraweeControllerBuilder;", "enableReplaceCall2Create", "adjustNavigatorSimplify", "setOnBackClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnSubClickListener", "setOnshareClickListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ShowCaseTitleBar extends ConstraintLayout {
    public static final /* synthetic */ int c = 0;
    public LarusCaseTitleLayoutBinding a;
    public final boolean b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1", f = "ShowCaseTitleBar.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $iconUrl;
        int label;
        final /* synthetic */ ShowCaseTitleBar this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar$setAvatar$1$1", f = "ShowCaseTitleBar.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PipelineDraweeControllerBuilder $builder;
            final /* synthetic */ String $iconUrl;
            int label;
            final /* synthetic */ ShowCaseTitleBar this$0;

            public C00591(ShowCaseTitleBar r1, String r2, PipelineDraweeControllerBuilder r3, Continuation<? super C00591> r4) {
                this.this$0 = r1;
                this.$iconUrl = r2;
                this.$builder = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00591(this.this$0, this.$iconUrl, this.$builder, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r4);
                ShowCaseTitleBar r5 = this.this$0;
                String r0 = this.$iconUrl;
                PipelineDraweeControllerBuilder r1 = this.$builder;
                Intrinsics.checkNotNull(r1);
                int r2 = ShowCaseTitleBar.c;
                r5.S5(r0, r1);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ShowCaseTitleBar r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$iconUrl = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$iconUrl, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            PipelineDraweeControllerBuilder r9 = Fresco.newDraweeControllerBuilder();
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00591 r3 = new C00591(this.this$0, this.$iconUrl, r9, null);
            this.label = 1;
            if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final LarusCaseTitleLayoutBinding getBinding() {
        LarusCaseTitleLayoutBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public ShowCaseTitleBar(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = z2.a.getChatNavigatorConfig().b;
        R5(r2, null);
    }

    private final void setSubtitleVisible(boolean r4) {
        TextView r0 = getBinding().h;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        if (r4 == false) goto L9;
        getBinding().i.setTextSize(0, i5.o());
        getBinding().i.setTypeface(Typeface.defaultFromStyle(0));
        return;
    L9:
        getBinding().i.setTextSize(0, i5.v());
        return;
    L5:
        r2 = 8;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setAvatar(String r8) {
        Intrinsics.checkNotNullParameter(r8, "iconUrl");
        if (this.b == false) goto L5;
        return;
    L5:
        getBinding().e.setVisibility(0);
        if (TextUtils.isEmpty(r8) == false) goto L9;
        getBinding().b.setActualImageResource(2131240119);
        return;
    L9:
        getBinding().b.getHierarchy().setFadeDuration(DoraCallStateCode.DORA_OB_USER_END);
        LifecycleOwner r0 = getContext();
        if ((r0 instanceof LifecycleOwner) == true) goto L12;
    L14:
        S5(r8, Fresco.newDraweeControllerBuilder());
        return;
    L12:
        if (z2.a.isLazyMainComponentEnable() == false) goto L14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final void setBackIconRes(int r2) {
        getBinding().c.setImageResource(r2);
    }

    public final void setOnBackClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().c, new z(r3));
    }

    public final void setOnSubClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().d, new b0(r3));
    }

    public final void setOnshareClickListener(final View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        e1.d(getBinding().g, new a0(r3));
    }

    public final void setSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitle");
        LarusCaseTitleLayoutBinding r0 = getBinding();
        if (r0 == null) goto L8;
        TextView r1 = r0.h;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    L9:
        return;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        LarusCaseTitleLayoutBinding r0 = getBinding();
        if (r0 == null) goto L8;
        TextView r1 = r0.i;
        if (r1 == null) goto L9;
        r1.setText(r2);
        return;
    L9:
        return;
    }

    public ShowCaseTitleBar(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = z2.a.getChatNavigatorConfig().b;
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r12, AttributeSet r13) {
        Context r14 = getContext();
        z2 r15 = z2.a;
        if (r15.enablePreloadChatPageView().b() == false) goto L7;
        c.e.getClass();
        if (c.f("chat_fragment_nita") == false) goto L7;
        boolean r16 = r14 instanceof Activity;
    L7:
        LayoutInflater.from(getContext()).inflate(2131561877, this);
        int r17 = 2131363623;
        TitleAvatarImageView r3 = ViewBindings.findChildViewById(this, 2131363623);
        if (r3 == null) goto L36;
        r17 = 2131363779;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131363779);
        if (r4 == null) goto L36;
        r17 = 2131368203;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(this, 2131368203);
        if (r5 == null) goto L36;
        r17 = 2131375139;
        ConstraintLayout r6 = ViewBindings.findChildViewById(this, 2131375139);
        if (r6 == null) goto L36;
        r17 = 2131379429;
        ConstraintLayout r7 = ViewBindings.findChildViewById(this, 2131379429);
        if (r7 == null) goto L36;
        r17 = 2131379431;
        if (ViewBindings.findChildViewById(this, 2131379431) == null) goto L36;
        r17 = 2131386047;
        AppCompatImageView r8 = ViewBindings.findChildViewById(this, 2131386047);
        if (r8 == null) goto L36;
        r17 = 2131387625;
        TextView r9 = (TextView) ViewBindings.findChildViewById(this, 2131387625);
        if (r9 == null) goto L36;
        r17 = 2131388772;
        TextView r10 = (TextView) ViewBindings.findChildViewById(this, 2131388772);
        if (r10 == null) goto L36;
        LarusCaseTitleLayoutBinding r18 = new LarusCaseTitleLayoutBinding(this, r3, r4, r5, r6, r7, r8, r9, r10);
        Intrinsics.checkNotNull(r18);
        this.a = r18;
        if (this.b == false) goto L29;
        ConstraintLayout r19 = getBinding().f;
        ViewGroup.LayoutParams r1 = r19.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) r1;
        r2.endToEnd = 0;
        r2.endToStart = -1;
        r2.horizontalBias = 0.5f;
        r2.setMarginStart(0);
        r19.setLayoutParams(r2);
        TextView r110 = getBinding().i;
        ViewGroup.LayoutParams r11 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r20 = (ConstraintLayout.LayoutParams) r11;
        ((ViewGroup.MarginLayoutParams) r20).width = -2;
        r20.setMarginStart(0);
        r20.setMarginEnd(0);
        r20.constrainedWidth = true;
        r20.horizontalChainStyle = 2;
        r20.horizontalBias = 0.5f;
        r20.startToStart = getBinding().f.getId();
        r110.setLayoutParams(r20);
        r110.setMaxWidth(com.larus.utils.i.d(getContext()) - (i5.d() * 2));
        TextView r111 = getBinding().h;
        ConstraintLayout.LayoutParams r21 = getBinding().h.getLayoutParams();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r22 = r21;
        ((ViewGroup.MarginLayoutParams) r22).width = -2;
        r22.horizontalBias = 0.5f;
        r22.setMarginStart(0);
        r111.setLayoutParams(r22);
    L29:
        if (r15.o0().a == false) goto L32;
        getBinding().d.setImageResource(com.larus.bmhome.utils.t.a());
        e1.x(getBinding().d);
    L32:
        if (r15.o0().c == false) goto L37;
        setSubtitleVisible(false);
        return;
    L37:
        return;
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r17)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(String r4, final PipelineDraweeControllerBuilder r5) {
        ImageLoaderKt.w(getBinding().b, r4, "chat.bot_avatar", new c0(r5), null);
        getBinding().b.setColorFilter(ContextCompat.getColor(getContext(), v19.c.b(2130972123, getContext(), 2131103203)));
    }

    public ShowCaseTitleBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = z2.a.getChatNavigatorConfig().b;
        R5(r2, r3);
    }
}
