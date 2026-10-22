package com.obric.assistant.settings.lockeduse;

import android.app.KeyguardManager;
import android.os.Build;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.account.base.api.ILoginService;
import com.obric.assistant.settings.LockedUseAuthSettingItem;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J/\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u000fH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/assistant/settings/lockeduse/ObricLockedUseManagementViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "onSwitchChanged", "enabled", "", "onPermissionSwitchChanged", "id", "", "isDeviceSecure", "buildState", "buildRows", "", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseRow;", "storedEnabled", "permissionRow", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseRow$Item;", "titleRes", "", "subtitleRes", "(Ljava/lang/String;ILjava/lang/Integer;Z)Lcom/obric/assistant/settings/lockeduse/ObricLockedUseRow$Item;", "isEnterpriseAccount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLockedUseManagementViewModel extends ViewModel {
    private final z0<m> _uiState;
    private final i1<m> uiState;

    /* JADX INFO: renamed from: com.obric.assistant.settings.lockeduse.ObricLockedUseManagementViewModel$refresh$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.settings.lockeduse.ObricLockedUseManagementViewModel$refresh$1", f = "ObricLockedUseManagementViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ObricLockedUseManagementViewModel this$0;

        /* JADX INFO: renamed from: com.obric.assistant.settings.lockeduse.ObricLockedUseManagementViewModel$refresh$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/settings/lockeduse/ObricLockedUseUiState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.settings.lockeduse.ObricLockedUseManagementViewModel$refresh$1$1", f = "ObricLockedUseManagementViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super m>, Object> {
            int label;
            final /* synthetic */ ObricLockedUseManagementViewModel this$0;

            public C00191(ObricLockedUseManagementViewModel r1, Continuation<? super C00191> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00191(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super m> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return ObricLockedUseManagementViewModel.access$buildState(this.this$0);
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ObricLockedUseManagementViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            z0 r2 = (z0) this.L$0;
            ResultKt.throwOnFailure(r7);
        L12:
            r2.setValue(r7);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            z0 r8 = ObricLockedUseManagementViewModel.access$get_uiState$p(this.this$0);
            CoroutineDispatcher r3 = Dispatchers.getIO();
            C00191 r4 = new C00191(this.this$0, null);
            this.L$0 = r8;
            this.label = 1;
            Object r5 = BuildersKt.withContext(r3, r4, this);
            if (r5 != r0) goto L11;
            return r0;
        L11:
            r2 = r8;
            r7 = r5;
            goto L12
        }
    }

    private final m buildState() {
        boolean r0 = t1.a.i();
        return new m(r0, buildRows(r0, isDeviceSecure()));
    }

    private final boolean isDeviceSecure() {
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        Object r1 = r0.getApplication().getSystemService("keyguard");
        if ((r1 instanceof KeyguardManager) == false) goto L5;
        KeyguardManager r2 = (KeyguardManager) r1;
    L6:
        if (r2 != null) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        return r2.isDeviceSecure();
    L13:
        return r2.isKeyguardSecure();
    L5:
        r2 = null;
        goto L6
    }

    private final boolean isEnterpriseAccount() {
        ILoginService r0 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r0 == null) goto L10;
        q38.a r1 = r0.getAccountInfo();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.g != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public ObricLockedUseManagementViewModel() {
        StateFlowImpl r0 = j1.a(new m(0));
        this._uiState = r0;
        this.uiState = r0;
        refresh();
    }

    public final void refresh() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final i1<m> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ m access$buildState(ObricLockedUseManagementViewModel r0) {
        return r0.buildState();
    }

    public static final /* synthetic */ z0 access$get_uiState$p(ObricLockedUseManagementViewModel r0) {
        return r0._uiState;
    }

    public final void onSwitchChanged(boolean r2) {
        t1.a.R0(r2);
        refresh();
    }

    private final List<l> buildRows(boolean r10, boolean r11) {
        ArrayList r0 = new ArrayList();
        boolean r1 = isEnterpriseAccount();
        if (t9a.b.a().b() == true) goto L5;
        int r3 = 2131912567;
    L7:
        if (t9a.b.a().b() == true) goto L9;
        int r4 = 2131912570;
    L10:
        r0.add(new l.d(r3, r4, r10, r11, 2131912537));
        if (r1 == false) goto L16;
        if (r11 == true) goto L14;
        r0.add(new l.a(2131912535));
    L14:
        return r0;
    L16:
        if (t9a.b.a().b() == true) goto L18;
        return r0;
    L18:
        if (r11 == true) goto L21;
        r0.add(new l.a(2131912535));
        return r0;
    L21:
        if (r10 == true) goto L23;
        return r0;
    L23:
        r0.add(new l.c());
        LockedUseAuthSettingItem r12 = LockedUseAuthSettingItem.CHAT_AND_ONLINE_QA;
        r0.add(permissionRow(r12.getSettingKey(), 2131912526, 2131912525, r12.isEnabled()));
        LockedUseAuthSettingItem r13 = LockedUseAuthSettingItem.SIMPLE_COMMAND;
        r0.add(permissionRow(r13.getSettingKey(), 2131912539, 2131912538, r13.isEnabled()));
        LockedUseAuthSettingItem r14 = LockedUseAuthSettingItem.LOCAL_APP_DATA;
        r0.add(permissionRow(r14.getSettingKey(), 2131912534, 2131912533, r14.isEnabled()));
        LockedUseAuthSettingItem r15 = LockedUseAuthSettingItem.AUTO_GUI;
        r0.add(permissionRow(r15.getSettingKey(), 2131912524, null, r15.isEnabled()));
        LockedUseAuthSettingItem r16 = LockedUseAuthSettingItem.CHAT_HISTORY;
        r0.add(permissionRow(r16.getSettingKey(), 2131912527, null, r16.isEnabled()));
        r0.add(new l.a(2131912540));
        return r0;
    L9:
        r4 = 2131912569;
        goto L10
    L5:
        r3 = 2131912564;
        goto L7
    }

    public final void onPermissionSwitchChanged(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "id");
        LockedUseAuthSettingItem.Companion.getClass();
        Intrinsics.checkNotNullParameter(r4, "settingKey");
        Iterator r0 = LockedUseAuthSettingItem.getEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((LockedUseAuthSettingItem) r1).getSettingKey(), r4) == false) goto L4;
    L9:
        LockedUseAuthSettingItem r2 = (LockedUseAuthSettingItem) r1;
        if (r2 == null) goto L12;
        r2.saveEnabled(r5);
    L12:
        refresh();
        return;
    L8:
        r1 = null;
        goto L9
    }

    private final l.b permissionRow(String r2, int r3, Integer r4, boolean r5) {
        return new l.b(r2, r3, r4, r5);
    }
}
