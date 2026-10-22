package com.ss.android.lark.passport.flow.auth_type;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.ss.android.lark.flow.passport.mfa.databinding.SigninSdkActivityAuthTypeBinding;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.auth_type.viewmodel.AuthTypeViewModel;
import com.ss.android.lark.passport.flow.core.model.ButtonInfo;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import uzb.l;
import uzb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/ss/android/lark/passport/flow/auth_type/viewmodel/AuthTypeViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.auth_type.AuthTypeActivity$observeViewModel$1", f = "AuthTypeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AuthTypeActivity$observeViewModel$1 extends SuspendLambda implements Function2<AuthTypeViewModel.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AuthTypeActivity this$0;

    public AuthTypeActivity$observeViewModel$1(AuthTypeActivity r1, Continuation<? super AuthTypeActivity$observeViewModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AuthTypeActivity$observeViewModel$1 r0 = new AuthTypeActivity$observeViewModel$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(AuthTypeViewModel.d r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AuthTypeViewModel.d) r1, (Continuation) r2);
    }

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
    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L137;
        ResultKt.throwOnFailure(r15);
        AuthTypeViewModel.d r16 = (AuthTypeViewModel.d) this.L$0;
        if (Intrinsics.areEqual(r16, AuthTypeViewModel.d.b.a) == true) goto L135;
        if ((r16 instanceof AuthTypeViewModel.d.a) == false) goto L133;
        FragmentActivity r0 = this.this$0;
        AuthTypeStepInfo r17 = ((AuthTypeViewModel.d.a) r16).a;
        int r1 = AuthTypeActivity.f;
        r0.getClass();
        ArrayList<ButtonInfo> r2 = r17.authTypeList;
        if (r2 != null) goto L11;
        PassportLog.b("AuthTypeActivity", "choose auth type StepInfo == null");
        goto L135
    L11:
        SigninSdkActivityAuthTypeBinding r3 = r0.d;
        SigninSdkActivityAuthTypeBinding r5 = null;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L14:
        r3.f.setText(r17.title);
        SigninSdkActivityAuthTypeBinding r4 = r0.d;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L17:
        r4.e.setText(r17.subTitle);
        SigninSdkActivityAuthTypeBinding r6 = r0.d;
        if (r6 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L20:
        r6.b.removeAllViews();
        Iterator<T> r7 = r2.iterator();
    L22:
        if (r7.hasNext() == false) goto L86;
        ButtonInfo r8 = (ButtonInfo) r7.next();
        String r9 = r17.targetTenantIcon;
        if (r8 != null) goto L26;
        PassportLog.b("AuthTypeActivity", "AuthTypeStepInfo.VerifyTypeData data == null");
        RelativeLayout r10 = null;
    L79:
        if (r10 == null) goto L22;
        SigninSdkActivityAuthTypeBinding r11 = r0.d;
        if (r11 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L83:
        r11.b.addView(r10);
        goto L22
    L26:
        LayoutInflater r12 = LayoutInflater.from(r0);
        SigninSdkActivityAuthTypeBinding r13 = r0.d;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L29:
        View r14 = r12.inflate(2131564877, r13.b, false);
        int r18 = 2131375994;
        if (ViewBindings.findChildViewById(r14, 2131375994) == null) goto L85;
        r18 = 2131376706;
        AppCompatImageView r19 = ViewBindings.findChildViewById(r14, 2131376706);
        if (r19 == null) goto L85;
        r18 = 2131390479;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r14, 2131390479);
        if (r110 == null) goto L85;
        r18 = 2131391652;
        TextView r111 = (TextView) ViewBindings.findChildViewById(r14, 2131391652);
        if (r111 == null) goto L85;
        r10 = (RelativeLayout) r14;
        r111.setText(r8.text);
        if (TextUtils.isEmpty(r8.desc) == true) goto L40;
        r110.setVisibility(0);
        r110.setText(r8.desc);
    L41:
        int r20 = r8.actionType;
        if (r20 != ButtonType.VERIFY_PHONE.getValue()) goto L45;
        r19.setImageDrawable(r0.A1(DisplayTypeEnum.PHONE.getIconRes(), 2131105548));
    L78:
        m.a(r10, new a(r0, r8));
        goto L79
    L45:
        if (r20 != ButtonType.VERIFY_EMAIL.getValue()) goto L48;
        r19.setImageDrawable(r0.A1(DisplayTypeEnum.MAIL.getIconRes(), 2131101117));
        goto L78
    L48:
        if (r20 != ButtonType.VERIFY_GOOGLE.getValue()) goto L51;
        r19.setImageResource(DisplayTypeEnum.GOOGLE.getIconRes());
        goto L78
    L51:
        if (r20 != ButtonType.VERIFY_APPLE_ID.getValue()) goto L54;
        r19.setImageResource(DisplayTypeEnum.APPLE.getIconRes());
        goto L78
    L54:
        if (r20 != ButtonType.VERIFY_B_IDP.getValue()) goto L60;
        if (TextUtils.isEmpty(r9) == false) goto L58;
        r19.setImageResource(DisplayTypeEnum.IDP.getIconRes());
        goto L78
    L58:
        Glide.with(r0).load(r9).override(l.a(r0, 30.0f), l.a(r0, 30.0f)).centerCrop().error(2131255098).diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(r19);
        goto L78
    L60:
        if (r20 != ButtonType.VERIFY_PASSWORD.getValue()) goto L63;
        r19.setImageDrawable(r0.A1(DisplayTypeEnum.PASSWORD.getIconRes(), 2131108856));
        goto L78
    L63:
        if (r20 != ButtonType.VERIFY_SPARE.getValue()) goto L66;
        r19.setImageDrawable(r0.A1(DisplayTypeEnum.SPARE.getIconRes(), 2131101113));
        goto L78
    L66:
        if (r20 != ButtonType.VERIFY_OTP.getValue()) goto L69;
        r19.setImageResource(DisplayTypeEnum.OTP.getIconRes());
        goto L78
    L69:
        if (r20 != ButtonType.VERIFY_FIDO.getValue()) goto L72;
        r19.setImageResource(2131235913);
        goto L78
    L72:
        if (r20 != ButtonType.QR_LOGIN_SHOW.getValue()) goto L75;
        r19.setImageDrawable(r0.A1(DisplayTypeEnum.QR.getIconRes(), 2131101114));
        goto L78
    L75:
        if (r20 != ButtonType.VERIFY_DOUBAO.getValue()) goto L77;
        r19.setImageDrawable(l.getResources(r0).getDrawable(2131237813));
        goto L78
    L77:
        r19.setImageResource(DisplayTypeEnum.OTHERS.getIconRes());
        goto L78
    L40:
        r110.setVisibility(8);
    L85:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r18)));
    L86:
        SigninSdkActivityAuthTypeBinding r21 = r0.d;
        if (r21 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L89:
        int r22 = r21.b.getChildCount();
        int r23 = 0;
    L90:
        if (r23 >= r22) goto L109;
        SigninSdkActivityAuthTypeBinding r24 = r0.d;
        if (r24 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L94:
        View r25 = r24.b.getChildAt(r23);
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if ((r26 instanceof LinearLayout.LayoutParams) == false) goto L97;
        LinearLayout.LayoutParams r27 = (LinearLayout.LayoutParams) r26;
    L98:
        if (r27 == null) goto L108;
        SigninSdkActivityAuthTypeBinding r28 = r0.d;
        if (r28 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L104:
        if (r23 != (r28.b.getChildCount() - 1)) goto L106;
        int r29 = 0;
    L107:
        r27.bottomMargin = r29;
        r25.setLayoutParams(r27);
        goto L108
    L106:
        r29 = l.a(r0, r0.getResources().getDimension(2131168215));
    L108:
        r23 = r23 + 1;
        goto L90
    L97:
        r27 = null;
        goto L98
    L109:
        ButtonInfo r112 = r17.bottomButton;
        if (r112 != null) goto L112;
    L127:
        SigninSdkActivityAuthTypeBinding r113 = r0.d;
        if (r113 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L131:
        r5.d.setVisibility(8);
        goto L135
    L130:
        r5 = r113;
        goto L131
    L112:
        if (TextUtils.isEmpty(r112.text) == true) goto L127;
        if (r112.next == null) goto L127;
        SigninSdkActivityAuthTypeBinding r30 = r0.d;
        if (r30 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L119:
        r30.d.setVisibility(0);
        SigninSdkActivityAuthTypeBinding r31 = r0.d;
        if (r31 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L122:
        r31.d.setText(r112.text);
        SigninSdkActivityAuthTypeBinding r32 = r0.d;
        if (r32 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L126:
        m.a(r5.d, new c(r0, r112));
        goto L135
    L125:
        r5 = r32;
        goto L126
    L133:
        throw new NoWhenBranchMatchedException();
    L135:
        return Unit.INSTANCE;
    L137:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
