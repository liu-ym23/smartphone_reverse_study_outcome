package com.obric.memorydata.memory.ui.address.edit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.databinding.ActivityAddressEditBinding;
import com.obric.memorydata.memory.ui.BaseMemoryActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.forms.OEditText;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.h;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0003J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0003J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressEditActivity;", "Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "<init>", "()V", "addressType", "", "binding", "Lcom/obric/memorydata/memory/databinding/ActivityAddressEditBinding;", "viewModel", "Lcom/obric/memorydata/memory/ui/address/edit/AddressEditViewModel;", "getViewModel", "()Lcom/obric/memorydata/memory/ui/address/edit/AddressEditViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addressAdapter", "Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter;", "getAddressAdapter", "()Lcom/obric/memorydata/memory/ui/address/edit/AddressAdapter;", "addressAdapter$delegate", "addressSearchAdapter", "Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter;", "getAddressSearchAdapter", "()Lcom/obric/memorydata/memory/ui/address/edit/AddressSearchAdapter;", "addressSearchAdapter$delegate", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "initView", "updateListTopPaddingAfterHeaderReady", "setupAddressHeaderCutOff", "initData", "initObserver", "closeIfAutoLearned", "hideKeyboard", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddressEditActivity extends BaseMemoryActivity {
    public static final String ADDRESS_TYPE_COMPANY = "公司";
    public static final String ADDRESS_TYPE_HOME = "家";
    public static final a Companion = null;
    private static final String EXTRA_ADDRESS_TYPE = "address_type";
    private static final String TAG = "AddressEditActivity";
    private final Lazy addressAdapter$delegate;
    private final Lazy addressSearchAdapter$delegate;
    private String addressType;
    private ActivityAddressEditBinding binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressEditActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_ADDRESS_TYPE", "ADDRESS_TYPE_HOME", "ADDRESS_TYPE_COMPANY", "startActivity", "", "context", "Landroid/content/Context;", "addressType", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void startActivity(Context r3, String r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "addressType");
            Intent r5 = new Intent(r2, AddressEditActivity.class);
            r5.putExtra(AddressEditActivity.EXTRA_ADDRESS_TYPE, r4);
            ZeusTransformUtils.startActivity(r2, r5, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/memorydata/memory/ui/address/edit/AddressEditActivity$initView$3", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddressEditActivity f10574a;

        b(AddressEditActivity r3) {
            this.f10574a = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r5) {
            Editable r6 = (Editable) ZeusTransformUtils.wrapperContextForParams(r5, Editable.class, "com.obric.memorydata.plugin");
            if (r6 != null) goto L5;
            return;
        L5:
            String r7 = r6.toString();
            ActivityAddressEditBinding r0 = AddressEditActivity.access$getBinding$p(this.f10574a);
            ActivityAddressEditBinding r2 = null;
            if (r0 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r0 = null;
        L9:
            if (r0.addressSearchResultRecyclerView.getItemAnimator() != null) goto L15;
            ActivityAddressEditBinding r1 = AddressEditActivity.access$getBinding$p(this.f10574a);
            if (r1 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L14:
            r2.addressSearchResultRecyclerView.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(new h(), RecyclerView.e.class, "com.obric.memorydata.plugin"));
            goto L15
        L13:
            r2 = r1;
        L15:
            RunLog.INSTANCE.debug(AddressEditActivity.TAG, "收到地址搜索输入");
            AddressEditActivity.access$getAddressSearchAdapter(this.f10574a).a(r7);
            AddressEditActivity.access$getViewModel(this.f10574a).searchAddress(r7);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$1", f = "AddressEditActivity.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "addresses", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$1$1", f = "AddressEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05191 extends SuspendLambda implements Function2<List<? extends AddressInfo>, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AddressEditActivity this$0;

            C05191(AddressEditActivity r3, Continuation<? super C05191> r4) {
                AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                C05191 r0 = new C05191(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(List<? extends AddressInfo> r3, Continuation<? super Unit> r4) {
                return invoke2((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(List<AddressInfo> r3, Continuation<? super Unit> r4) {
                return ((C05191) ZeusTransformUtils.preCheckCast(create((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05191.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L23;
                ResultKt.throwOnFailure(r6);
                List r7 = (List) ZeusTransformUtils.preCheckCast(this.L$0, List.class, "com.obric.memorydata.plugin");
                RunLog.INSTANCE.debug(AddressEditActivity.TAG, "地址搜索结果列表已更新，数量=" + r7.size());
                AddressEditActivity.access$getAddressSearchAdapter(this.this$0).b(r7);
                ActivityAddressEditBinding r0 = AddressEditActivity.access$getBinding$p(this.this$0);
                ActivityAddressEditBinding r2 = null;
                if (r0 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r0 = null;
            L7:
                OTextView r1 = r0.searchEmptyView;
                int r4 = 0;
                if (r7.isEmpty() == false) goto L19;
                ActivityAddressEditBinding r5 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r5 != null) goto L12;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L14:
                if (((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2.searchBar.getInputView().getText()), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L16;
                boolean r8 = true;
            L17:
                if (r8 == false) goto L19;
            L20:
                r1.setVisibility(r4);
                return Unit.INSTANCE;
            L16:
                r8 = false;
                goto L17
            L12:
                r2 = r5;
            L19:
                r4 = 8;
                goto L20
            L23:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(AddressEditActivity r3, Continuation<? super AnonymousClass1> r4) {
            AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(AddressEditActivity.access$getViewModel(this.this$0).getSearchAddressList(), i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05191(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$2", f = "AddressEditActivity.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "canShow", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$2$1", f = "AddressEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ AddressEditActivity this$0;

            AnonymousClass1(AddressEditActivity r3, Continuation<? super AnonymousClass1> r4) {
                AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
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
            public final Object invokeSuspend(Object r6) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L26;
                ResultKt.throwOnFailure(r6);
                if (this.Z$0 == false) goto L24;
                ActivityAddressEditBinding r7 = AddressEditActivity.access$getBinding$p(this.this$0);
                ActivityAddressEditBinding r0 = null;
                if (r7 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r7 = null;
            L9:
                OTextView r8 = r7.searchEmptyView;
                int r3 = 0;
                if (((List) ZeusTransformUtils.preCheckCast(AddressEditActivity.access$getViewModel(this.this$0).getSearchAddressList().c(), List.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L21;
                ActivityAddressEditBinding r5 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r5 != null) goto L14;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L16:
                if (((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r0.searchBar.getInputView().getText()), CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L18;
                boolean r9 = true;
            L19:
                if (r9 == false) goto L21;
            L22:
                r8.setVisibility(r3);
                goto L24
            L18:
                r9 = false;
                goto L19
            L14:
                r0 = r5;
            L21:
                r3 = 8;
            L24:
                return Unit.INSTANCE;
            L26:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass2(AddressEditActivity r3, Continuation<? super AnonymousClass2> r4) {
            AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(AddressEditActivity.access$getViewModel(this.this$0).getCanShowEmptyView(), i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$3", f = "AddressEditActivity.kt", i = {}, l = {231}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditActivity this$0;

        AnonymousClass3(AddressEditActivity r3, Continuation<? super AnonymousClass3> r4) {
            AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<List<AddressInfo>> r7 = AddressEditActivity.access$getViewModel(this.this$0).getAddressList();
            final AddressEditActivity r3 = this.this$0;
            j<? super List<AddressInfo>> r2 = (j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$4", f = "AddressEditActivity.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "changedAddressType", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$4$1", f = "AddressEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AddressEditActivity this$0;

            AnonymousClass1(AddressEditActivity r3, Continuation<? super AnonymousClass1> r4) {
                AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r5);
                r0.L$0 = r3;
                return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(String r3, Continuation<? super Unit> r4) {
                return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(String r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r3);
                if (Intrinsics.areEqual((String) ZeusTransformUtils.preCheckCast(this.L$0, String.class, "com.obric.memorydata.plugin"), AddressEditActivity.access$getAddressType$p(this.this$0)) == false) goto L8;
                AddressEditActivity.access$getViewModel(this.this$0).refreshAddressList();
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass4(AddressEditActivity r3, Continuation<? super AnonymousClass4> r4) {
            AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass4) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass4.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(AddressManager.INSTANCE.getAddressChangedFlow(), i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$5", f = "AddressEditActivity.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$5$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$5$1", f = "AddressEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AddressEditActivity this$0;

            AnonymousClass1(AddressEditActivity r3, Continuation<? super AnonymousClass1> r4) {
                AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(Unit r3, Continuation<? super Unit> r4) {
                return invoke2((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Unit r3, Continuation<? super Unit> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                AddressEditActivity.access$closeIfAutoLearned(this.this$0);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass5(AddressEditActivity r3, Continuation<? super AnonymousClass5> r4) {
            AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.address.a.f10048a.a(), i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$6", f = "AddressEditActivity.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddressEditActivity this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$6$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isInSearchMode", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initObserver$6$1", f = "AddressEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ AddressEditActivity this$0;

            AnonymousClass1(AddressEditActivity r3, Continuation<? super AnonymousClass1> r4) {
                AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r5;
                super(2, r6);
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
            public final Object invokeSuspend(Object r8) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L73;
                ResultKt.throwOnFailure(r8);
                int r0 = 8;
                ActivityAddressEditBinding r3 = null;
                if (this.Z$0 == true) goto L56;
                ActivityAddressEditBinding r9 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r9 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r9 = null;
            L9:
                FrameLayout r10 = r9.searchContainer;
                Intrinsics.checkNotNullExpressionValue(r10, "searchContainer");
                if (((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L12;
                boolean r11 = true;
            L13:
                if (r11 == true) goto L19;
                ActivityAddressEditBinding r12 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r12 != null) goto L18;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r12 = null;
            L18:
                if (r12.searchBar.getInputView().hasFocus() == true) goto L19;
            L20:
                ActivityAddressEditBinding r13 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r13 != null) goto L23;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r13 = null;
            L23:
                r13.searchBar.getInputView().clearFocus();
                ActivityAddressEditBinding r14 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r14 != null) goto L26;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r14 = null;
            L26:
                Editable r15 = r14.searchBar.getInputView().getText();
                if (r15 == null) goto L29;
                r15.clear();
            L29:
                ActivityAddressEditBinding r16 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r16 != null) goto L32;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r16 = null;
            L32:
                r16.searchContainer.setVisibility(8);
                ActivityAddressEditBinding r17 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r17 != null) goto L35;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r17 = null;
            L35:
                r17.searchCancelButton.setVisibility(8);
                ActivityAddressEditBinding r18 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r18 != null) goto L38;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r18 = null;
            L38:
                r18.addressSearchResultRecyclerView.setItemAnimator(null);
                ActivityAddressEditBinding r19 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r19 != null) goto L41;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r19 = null;
            L41:
                RecyclerView r20 = r19.addressRecyclerView;
                if (((List) ZeusTransformUtils.preCheckCast(AddressEditActivity.access$getViewModel(this.this$0).getAddressList().c(), List.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L44;
                int r4 = 8;
            L45:
                r20.setVisibility(r4);
                ActivityAddressEditBinding r21 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r21 != null) goto L48;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r21 = null;
            L48:
                LinearLayout r22 = r21.addressEmptyView;
                if (((List) ZeusTransformUtils.preCheckCast(AddressEditActivity.access$getViewModel(this.this$0).getAddressList().c(), List.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L51;
                r0 = 0;
            L51:
                r22.setVisibility(r0);
                ActivityAddressEditBinding r7 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r7 != null) goto L54;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L55:
                r3.addressContainer.setVisibility(0);
            L71:
                return Unit.INSTANCE;
            L54:
                r3 = r7;
                goto L55
            L44:
                r4 = 0;
            L19:
                AddressEditActivity.access$hideKeyboard(this.this$0);
                goto L20
            L12:
                r11 = false;
                goto L13
            L56:
                ActivityAddressEditBinding r23 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r23 != null) goto L59;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r23 = null;
            L59:
                r23.addressContainer.setVisibility(8);
                ActivityAddressEditBinding r24 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r24 != null) goto L62;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r24 = null;
            L62:
                r24.searchCancelButton.setVisibility(0);
                ActivityAddressEditBinding r25 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r25 != null) goto L65;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r25 = null;
            L65:
                r25.searchContainer.setVisibility(0);
                ActivityAddressEditBinding r26 = AddressEditActivity.access$getBinding$p(this.this$0);
                if (r26 != null) goto L68;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            L69:
                r3.addressRecyclerView.getRecycledViewPool().a();
                goto L71
            L68:
                r3 = r26;
                goto L69
            L73:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass6(AddressEditActivity r3, Continuation<? super AnonymousClass6> r4) {
            AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass6) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass6.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            i r8 = (i) ZeusTransformUtils.preCheckCast(AddressEditActivity.access$getViewModel(this.this$0).isInSearchMode(), i.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (k.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressEditActivity$initView$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C11132 extends FunctionReferenceImpl implements Function0<Unit> {
        C11132(Object r8) {
            super(0, r8, AddressEditActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((AddressEditActivity) ZeusTransformUtils.preCheckCast(this.receiver, AddressEditActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    static {
        Companion = new a(null);
    }

    public AddressEditActivity() {
        this.addressType = "";
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = new $$Lambda$AddressEditActivity$_c1jfDZQAGextdB0xjKdBpxgLd4(this);
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AddressEditViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new AddressEditActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new AddressEditActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        this.addressAdapter$delegate = LazyKt.lazy($$Lambda$AddressEditActivity$L_99oElB1Jjn8AXDT9b1cVl6Jg.INSTANCE);
        this.addressSearchAdapter$delegate = LazyKt.lazy($$Lambda$AddressEditActivity$OiIqKq3VC2cr7nh2S2laSPupzM.INSTANCE);
    }

    public static final /* synthetic */ void access$closeIfAutoLearned(AddressEditActivity r2) {
        ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).closeIfAutoLearned();
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.address.edit.a access$getAddressAdapter(AddressEditActivity r2) {
        return ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).getAddressAdapter();
    }

    public static final /* synthetic */ com.obric.memorydata.memory.ui.address.edit.b access$getAddressSearchAdapter(AddressEditActivity r2) {
        return ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).getAddressSearchAdapter();
    }

    public static final /* synthetic */ String access$getAddressType$p(AddressEditActivity r2) {
        return ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).addressType;
    }

    public static final /* synthetic */ ActivityAddressEditBinding access$getBinding$p(AddressEditActivity r2) {
        return ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ AddressEditViewModel access$getViewModel(AddressEditActivity r2) {
        return ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$hideKeyboard(AddressEditActivity r2) {
        ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin")).hideKeyboard();
    }

    private static final com.obric.memorydata.memory.ui.address.edit.a addressAdapter_delegate$lambda$1() {
        return new com.obric.memorydata.memory.ui.address.edit.a();
    }

    private static final com.obric.memorydata.memory.ui.address.edit.b addressSearchAdapter_delegate$lambda$2() {
        return new com.obric.memorydata.memory.ui.address.edit.b();
    }

    private final void closeIfAutoLearned() {
        if (getViewModel().isEditingAllowed() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "finish address edit because " + this.addressType + " has been learned", false, 4, null);
        finish();
        return;
    }

    private final com.obric.memorydata.memory.ui.address.edit.a getAddressAdapter() {
        return (com.obric.memorydata.memory.ui.address.edit.a) ZeusTransformUtils.preCheckCast(this.addressAdapter$delegate.getValue(), com.obric.memorydata.memory.ui.address.edit.a.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.memory.ui.address.edit.b getAddressSearchAdapter() {
        return (com.obric.memorydata.memory.ui.address.edit.b) ZeusTransformUtils.preCheckCast(this.addressSearchAdapter$delegate.getValue(), com.obric.memorydata.memory.ui.address.edit.b.class, "com.obric.memorydata.plugin");
    }

    private final AddressEditViewModel getViewModel() {
        return (AddressEditViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), AddressEditViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void hideKeyboard() {
        ActivityAddressEditBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OEditText r1 = r0.searchBar.getInputView();
        boolean r8 = ((InputMethodManager) ZeusTransformUtils.preCheckCast(getSystemService(InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin")).hideSoftInputFromWindow(r1.getWindowToken(), 0);
        r1.clearFocus();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "hide keyboard: result=" + r8 + ", hasFocus=" + r1.hasFocus() + ", isAttached=" + r1.isAttachedToWindow(), false, 4, null);
    }

    private final void initData() {
        String r0 = getIntent().getStringExtra(EXTRA_ADDRESS_TYPE);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.addressType = r0;
        ActivityAddressEditBinding r1 = this.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        r1.titleBar.setCenterTitle(this.addressType);
        getViewModel().asyncRequestLocation();
    }

    private final void initObserver() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void initView() {
        ActivityAddressEditBinding r0 = this.binding;
        ActivityAddressEditBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar.a(r0.titleBar, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$AddressEditActivity$__7sOT6x0otOTvUy4pnDQ_P3O9g(this), 2, null);
        ActivityAddressEditBinding r2 = this.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        OFloatingTitleBar r3 = r2.titleBar;
        Intrinsics.checkNotNullExpressionValue(r3, "titleBar");
        com.obric.memorydata.ui.custom.a.a(r3, (Function0) ZeusTransformUtils.preCheckCast(new C11132(this), Function0.class, "com.obric.memorydata.plugin"));
        ActivityAddressEditBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        OFloatingTitleBar r5 = r4.titleBar;
        Intrinsics.checkNotNullExpressionValue(r5, "titleBar");
        registerFloatingTitleBar(r5);
        setupAddressHeaderCutOff();
        updateListTopPaddingAfterHeaderReady();
        ActivityAddressEditBinding r6 = this.binding;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L14:
        FrameLayout r7 = r6.searchContainer;
        Intrinsics.checkNotNullExpressionValue(r7, "searchContainer");
        ((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin")).setVisibility(8);
        ActivityAddressEditBinding r8 = this.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        r8.searchBar.getInputView().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new b(this), TextWatcher.class, "com.obric.memorydata.plugin"));
        ActivityAddressEditBinding r9 = this.binding;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L20:
        r9.searchBar.getInputView().setOnFocusChangeListener(new $$Lambda$AddressEditActivity$82qwFUiekqGzCwqzkoF1b8FfD0o(this));
        ActivityAddressEditBinding r10 = this.binding;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L23:
        final int r11 = r10.addressRecyclerView.getPaddingBottom();
        ActivityAddressEditBinding r12 = this.binding;
        if (r12 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L26:
        final int r13 = r12.addressSearchResultRecyclerView.getPaddingBottom();
        ActivityAddressEditBinding r14 = this.binding;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L29:
        ViewCompat.setOnApplyWindowInsetsListener((View) ZeusTransformUtils.preCheckCast(r14.getRoot(), View.class, "com.obric.memorydata.plugin"), new $$Lambda$AddressEditActivity$81h0qs8ZKEV0CoW2Ghpvr5b0ZkY(this, r11, r13));
        ActivityAddressEditBinding r15 = this.binding;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L32:
        r15.searchBar.getInputView().setImeOptions(1);
        ActivityAddressEditBinding r16 = this.binding;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L35:
        r16.searchCancelButton.setOnClickListener(new $$Lambda$AddressEditActivity$6_sUS4nfUTvxftAV5XmMnZDwlA(this));
        ActivityAddressEditBinding r17 = this.binding;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L38:
        r17.addressRecyclerView.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ActivityAddressEditBinding r18 = this.binding;
        if (r18 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L41:
        r18.addressRecyclerView.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(getAddressAdapter(), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ActivityAddressEditBinding r19 = this.binding;
        if (r19 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L44:
        r19.addressRecyclerView.setItemViewCacheSize(0);
        ActivityAddressEditBinding r20 = this.binding;
        if (r20 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L47:
        RecyclerView r21 = r20.addressRecyclerView;
        c r22 = new c();
        r22.c(300);
        r22.a(false);
        r21.setItemAnimator((RecyclerView.e) ZeusTransformUtils.preCheckCast(r22, RecyclerView.e.class, "com.obric.memorydata.plugin"));
        ActivityAddressEditBinding r23 = this.binding;
        if (r23 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L50:
        r23.addressSearchResultRecyclerView.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ActivityAddressEditBinding r24 = this.binding;
        if (r24 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L54:
        r1.addressSearchResultRecyclerView.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(getAddressSearchAdapter(), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        getAddressAdapter().a(new $$Lambda$AddressEditActivity$49OljFULE6zlhnByYTrgSxpZBNA(this));
        getAddressAdapter().b(new $$Lambda$AddressEditActivity$yXQOSslYUm6Yz09a0zIpwDmdRK8(this));
        getAddressSearchAdapter().a(new $$Lambda$AddressEditActivity$0BE9JLIccZoYJctWkR1E1t3UEAA(this));
        getAddressAdapter().b((List) ZeusTransformUtils.preCheckCast(getViewModel().getAddressList().c(), List.class, "com.obric.memorydata.plugin"));
        return;
    L53:
        r1 = r24;
        goto L54
    }

    private static final Unit initView$lambda$10(AddressEditActivity r2, AddressInfo r3) {
        AddressEditActivity r4 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.getViewModel().selectSearchAddress(r3);
        return Unit.INSTANCE;
    }

    private static final void initView$lambda$3(AddressEditActivity r1, View r2) {
        ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r1, AddressEditActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
    }

    private static final void initView$lambda$4(AddressEditActivity r2, View r3, boolean r4) {
        AddressEditActivity r5 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug(TAG, "ime focus change to " + r4);
        if (r4 == false) goto L6;
        r5.getViewModel().updateSearchState(true);
        return;
    }

    private static final WindowInsetsCompat initView$lambda$5(AddressEditActivity r11, int r12, int r13, View r14, WindowInsetsCompat r15) {
        AddressEditActivity r16 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r11, AddressEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "<unused var>");
        Intrinsics.checkNotNullParameter(r15, "insets");
        boolean r17 = r15.isVisible(WindowInsetsCompat.Type.ime());
        int r0 = r15.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        int r2 = r15.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        float r3 = r0;
        ActivityAddressEditBinding r4 = r16.binding;
        ActivityAddressEditBinding r5 = null;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        RunLog.INSTANCE.debug(TAG, "ime visible: " + r17 + ", height: " + r0 + ", " + (r3 / ZeusTransformUtils.getResources(r4.getRoot(), "com.obric.memorydata.plugin").getDisplayMetrics().density));
        ActivityAddressEditBinding r1 = r16.binding;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L8:
        RecyclerView r6 = r1.addressRecyclerView;
        ActivityAddressEditBinding r7 = r16.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        int r8 = r7.addressRecyclerView.getPaddingLeft();
        ActivityAddressEditBinding r9 = r16.binding;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L14:
        int r10 = r9.addressRecyclerView.getPaddingTop();
        ActivityAddressEditBinding r18 = r16.binding;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L17:
        float r19 = 16;
        r6.setPadding(r8, r10, r18.addressRecyclerView.getPaddingRight(), (r12 + r2) + MathKt.roundToInt(TypedValue.applyDimension(1, r19, Resources.getSystem().getDisplayMetrics())));
        ActivityAddressEditBinding r110 = r16.binding;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L20:
        RecyclerView r111 = r110.addressSearchResultRecyclerView;
        ActivityAddressEditBinding r20 = r16.binding;
        if (r20 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L23:
        int r21 = r20.addressSearchResultRecyclerView.getPaddingLeft();
        ActivityAddressEditBinding r22 = r16.binding;
        if (r22 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L26:
        int r23 = r22.addressSearchResultRecyclerView.getPaddingTop();
        ActivityAddressEditBinding r112 = r16.binding;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L30:
        int r113 = r5.addressSearchResultRecyclerView.getPaddingRight();
        int r24 = r2 + MathKt.roundToInt(TypedValue.applyDimension(1, r19, Resources.getSystem().getDisplayMetrics()));
        if (r17 == false) goto L33;
        int r25 = r0 + MathKt.roundToInt(TypedValue.applyDimension(1, 10, Resources.getSystem().getDisplayMetrics()));
    L34:
        r111.setPadding(r21, r23, r113, r13 + Math.max(r24, r25));
        return r15;
    L33:
        r25 = 0;
        goto L34
    L29:
        r5 = r112;
        goto L30
    }

    private static final void initView$lambda$6(AddressEditActivity r6, View r7) {
        AddressEditActivity r8 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r6, AddressEditActivity.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "search cancel clicked", false, 4, null);
        r8.hideKeyboard();
        r8.getViewModel().updateSearchState(false);
        r8.getViewModel().clearSearchAddress();
    }

    private static final Unit initView$lambda$8(AddressEditActivity r2, AddressInfo r3) {
        AddressEditActivity r4 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.getViewModel().selectAddress(r3);
        return Unit.INSTANCE;
    }

    private static final Unit initView$lambda$9(AddressEditActivity r2, AddressInfo r3) {
        AddressEditActivity r4 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        r4.getViewModel().deleteAddress(r3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$0BE9JLIccZoYJctWkR1E1t3UEAA(AddressEditActivity r0, AddressInfo r1) {
        return initView$lambda$10(r0, r1);
    }

    public static /* synthetic */ Unit lambda$49OljFULE6zlhnByYTrgSxpZBNA(AddressEditActivity r0, AddressInfo r1) {
        return initView$lambda$8(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$6_sUS4nfUTvxftAV5XmMnZDw-lA, reason: not valid java name */
    public static /* synthetic */ void m764lambda$6_sUS4nfUTvxftAV5XmMnZDwlA(AddressEditActivity r0, View r1) {
        initView$lambda$6(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$81h0qs8ZKEV0CoW2Ghpvr5b0ZkY(AddressEditActivity r0, int r1, int r2, View r3, WindowInsetsCompat r4) {
        return initView$lambda$5(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$82qwFUiekqGzCwqzkoF1b8FfD0o(AddressEditActivity r0, View r1, boolean r2) {
        initView$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$A4SpXttnxrwFxwKC2MtBZ5_njBA(AddressEditActivity r0, int r1) {
        return setupAddressHeaderCutOff$lambda$15(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$L_99oElB1Jjn8AXDT9b1cVl6-Jg, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.ui.address.edit.a m765lambda$L_99oElB1Jjn8AXDT9b1cVl6Jg() {
        return addressAdapter_delegate$lambda$1();
    }

    public static /* synthetic */ void lambda$OfRqHojZjo6qhuXUC6C0jf6qgGo(int r0, AddressEditActivity r1) {
        updateListTopPaddingAfterHeaderReady$lambda$12$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$OiIqKq3VC2cr7nh2S2laSPupz-M, reason: not valid java name */
    public static /* synthetic */ com.obric.memorydata.memory.ui.address.edit.b m766lambda$OiIqKq3VC2cr7nh2S2laSPupzM() {
        return addressSearchAdapter_delegate$lambda$2();
    }

    public static /* synthetic */ void lambda$__7sOT6x0otOTvUy4pnDQ_P3O9g(AddressEditActivity r0, View r1) {
        initView$lambda$3(r0, r1);
    }

    public static /* synthetic */ ViewModelProvider.Factory lambda$_c1jfDZQAGextdB0xjKdBpxgLd4(AddressEditActivity r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$ozybUZO8EZ5sl2KyaSTj_ZNIO2k(AddressEditActivity r0, int r1) {
        setupAddressHeaderCutOff$lambda$15$lambda$14(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$u-f5kykVbVT-_EZBteWHiVQi8RE, reason: not valid java name */
    public static /* synthetic */ Unit m767lambda$uf5kykVbVT_EZBteWHiVQi8RE(AddressEditActivity r0, int r1) {
        return updateListTopPaddingAfterHeaderReady$lambda$12(r0, r1);
    }

    public static /* synthetic */ Unit lambda$yXQOSslYUm6Yz09a0zIpwDmdRK8(AddressEditActivity r0, AddressInfo r1) {
        return initView$lambda$9(r0, r1);
    }

    private final void setupAddressHeaderCutOff() {
        ActivityAddressEditBinding r0 = this.binding;
        ActivityAddressEditBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        View r2 = r0.cutOff;
        Integer r3 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        if (r3 == null) goto L8;
        int r4 = r3.intValue();
    L9:
        r2.setBackgroundColor(r4);
        ActivityAddressEditBinding r5 = this.binding;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(r1.titleBar, View.class, "com.obric.memorydata.plugin"), new $$Lambda$AddressEditActivity$A4SpXttnxrwFxwKC2MtBZ5_njBA(this));
        return;
    L12:
        r1 = r5;
        goto L13
    L8:
        r4 = 0;
        goto L9
    }

    private static final Unit setupAddressHeaderCutOff$lambda$15(AddressEditActivity r2, final int r3) {
        final AddressEditActivity r4 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin");
        ActivityAddressEditBinding r0 = r4.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.searchBarContainer.post(new $$Lambda$AddressEditActivity$ozybUZO8EZ5sl2KyaSTj_ZNIO2k(r4, r3));
        return Unit.INSTANCE;
    }

    private static final void setupAddressHeaderCutOff$lambda$15$lambda$14(AddressEditActivity r5, int r6) {
        AddressEditActivity r7 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r5, AddressEditActivity.class, "com.obric.memorydata.plugin");
        ActivityAddressEditBinding r0 = r7.binding;
        ActivityAddressEditBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        View r2 = r0.cutOff;
        Intrinsics.checkNotNullExpressionValue(r2, "cutOff");
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        ActivityAddressEditBinding r4 = r7.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        int r8 = r6 + r4.searchBarContainer.getHeight();
        ActivityAddressEditBinding r9 = r7.binding;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r3.height = r8 + r1.addressHeaderMask.getPaddingBottom();
        r2.setLayoutParams(r3);
        return;
    L11:
        r1 = r9;
        goto L12
    }

    private final void updateListTopPaddingAfterHeaderReady() {
        ActivityAddressEditBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(r0.titleBar, View.class, "com.obric.memorydata.plugin"), new $$Lambda$AddressEditActivity$uf5kykVbVT_EZBteWHiVQi8RE(this));
    }

    private static final Unit updateListTopPaddingAfterHeaderReady$lambda$12(AddressEditActivity r2, final int r3) {
        final AddressEditActivity r4 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r2, AddressEditActivity.class, "com.obric.memorydata.plugin");
        ActivityAddressEditBinding r0 = r4.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.searchBarContainer.post(new $$Lambda$AddressEditActivity$OfRqHojZjo6qhuXUC6C0jf6qgGo(r3, r4));
        return Unit.INSTANCE;
    }

    private static final void updateListTopPaddingAfterHeaderReady$lambda$12$lambda$11(int r6, AddressEditActivity r7) {
        AddressEditActivity r8 = (AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r7, AddressEditActivity.class, "com.obric.memorydata.plugin");
        ActivityAddressEditBinding r0 = r8.binding;
        ActivityAddressEditBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        int r9 = r6 + r0.searchBarContainer.getHeight();
        ActivityAddressEditBinding r2 = r8.binding;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L8:
        int r10 = (r9 + r2.addressHeaderMask.getPaddingBottom()) + MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        ActivityAddressEditBinding r3 = r8.binding;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        RecyclerView r4 = r3.addressRecyclerView;
        ActivityAddressEditBinding r5 = r8.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        int r11 = r5.addressRecyclerView.getPaddingLeft();
        ActivityAddressEditBinding r12 = r8.binding;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L17:
        int r13 = r12.addressRecyclerView.getPaddingRight();
        ActivityAddressEditBinding r14 = r8.binding;
        if (r14 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L20:
        r4.setPadding(r11, r10, r13, r14.addressRecyclerView.getPaddingBottom());
        ActivityAddressEditBinding r15 = r8.binding;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L23:
        RecyclerView r16 = r15.addressSearchResultRecyclerView;
        ActivityAddressEditBinding r17 = r8.binding;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L26:
        int r18 = r17.addressSearchResultRecyclerView.getPaddingLeft();
        ActivityAddressEditBinding r19 = r8.binding;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L29:
        int r20 = r19.addressSearchResultRecyclerView.getPaddingRight();
        ActivityAddressEditBinding r21 = r8.binding;
        if (r21 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L33:
        r16.setPadding(r18, r10, r20, r1.addressSearchResultRecyclerView.getPaddingBottom());
        return;
    L32:
        r1 = r21;
        goto L33
    }

    private static final ViewModelProvider.Factory viewModel_delegate$lambda$0(AddressEditActivity r3) {
        String r4 = ((AddressEditActivity) ZeusTransformUtils.wrapperContextForParams(r3, AddressEditActivity.class, "com.obric.memorydata.plugin")).getIntent().getStringExtra(EXTRA_ADDRESS_TYPE);
        if (r4 != null) goto L6;
        r4 = "家";
    L6:
        return (ViewModelProvider.Factory) ZeusTransformUtils.preCheckCast(new AddressEditViewModelFactory(r4), ViewModelProvider.Factory.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r3) {
        prepareSystemBar();
        ActivityAddressEditBinding r4 = ActivityAddressEditBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.memory.address.a.f10048a.b();
        initData();
        initView();
        initObserver();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        closeIfAutoLearned();
    }
}
