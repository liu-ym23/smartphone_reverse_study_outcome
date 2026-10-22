package com.ss.android.lark.contact.base.contact_myqrcode;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v2.GetContactTokenResponse;
import com.bytedance.lark.pb.settings.v1.PushWayToAddMeSetting;
import com.bytedance.lark.pb.settings.v1.WayToAddMeSetting;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.base.service.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\u00182\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/contact/base/contact_myqrcode/InviteExternalViewModelV2;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_loadState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/base/contact_myqrcode/InviteExternalLoadState;", "loadState", "Landroidx/lifecycle/LiveData;", "getLoadState", "()Landroidx/lifecycle/LiveData;", "_invitationInfoGroup", "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfoGroup;", "invitationInfoGroup", "getInvitationInfoGroup", "_canAddWithToken", BuildConfig.FLAVOR, "canAddWithToken", "getCanAddWithToken", "channel", "Lkotlinx/coroutines/channels/Channel;", BuildConfig.FLAVOR, "isLocalSuccess", "onCleared", BuildConfig.FLAVOR, "fetchInvitationInfo", "from", "realFetchInvitationInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchInvitationInfoRequest", "Lcom/ss/android/lark/contact/base/contact_myqrcode/Response;", "fromServer", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", ChameleonOpenTracker.ParamKey.RESULT, "(Lcom/ss/android/lark/contact/base/contact_myqrcode/Response;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerPush", "unregisterPush", "Companion", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteExternalViewModelV2 extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "InviteExternalViewModelV2";
    private final MutableLiveData<Boolean> _canAddWithToken;
    private final MutableLiveData<z8b.a> _invitationInfoGroup;
    private final MutableLiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> _loadState;
    private final LiveData<Boolean> canAddWithToken;
    private final Channel<String> channel;
    private final LiveData<z8b.a> invitationInfoGroup;
    private volatile boolean isLocalSuccess;
    private final LiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> loadState;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$1", f = "InviteExternalViewModelV2.kt", i = {}, l = {49, 50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public AnonymousClass1(InviteExternalViewModelV2 r1, Continuation<? super AnonymousClass1> r2) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0060 -> B:12:0x0036). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ChannelIterator r2 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r8);
            ChannelIterator r9 = r2;
        L11:
            AnonymousClass1 r3 = this;
        L12:
            r3.L$0 = r9;
            r3.label = 1;
            Object r4 = r9.hasNext(r3);
            if (r4 != r0) goto L15;
            return r0;
        L15:
            AnonymousClass1 r6 = r3;
            ChannelIterator r5 = r9;
            r8 = r4;
            AnonymousClass1 r7 = r6;
        L17:
            if (((Boolean) r8).booleanValue() == false) goto L23;
            String r10 = (String) r5.next();
            InviteExternalViewModelV2 r11 = r7.this$0;
            r7.L$0 = r5;
            r7.label = 2;
            if (InviteExternalViewModelV2.access$realFetchInvitationInfo(r11, r10, r7) != r0) goto L21;
            return r0;
        L21:
            r9 = r5;
            r3 = r7;
            goto L12
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r5 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r8);
            r7 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r8);
            r9 = InviteExternalViewModelV2.access$getChannel$p(this.this$0).iterator();
            goto L11
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements g.b {
        public final /* synthetic */ InviteExternalViewModelV2 a;

        public b(InviteExternalViewModelV2 r1) {
            this.a = r1;
        }

        public final void a(byte[] r10) {
            WayToAddMeSetting r11 = ((PushWayToAddMeSetting) PushWayToAddMeSetting.ADAPTER.decode(r10)).add_me_setting;     // Catch: IOException -> L9
            if (r11 == null) goto L6;
            Boolean r12 = r11.contact_token_setting;     // Catch: IOException -> L9
        L7:
            Log.i(InviteExternalViewModelV2.TAG, "on PUSH_WAY_TO_ADD_ME_SETTING, contactTokenSetting: " + r12);     // Catch: IOException -> L9
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.a), null, null, new InviteExternalViewModelV2$registerPush$1$1(this.a, r12, null), 3, null);     // Catch: IOException -> L9
            return;
        L6:
            r12 = null;
        L9:
            e = move-exception;
            Log.e(InviteExternalViewModelV2.TAG, "PUSH_WAY_TO_ADD_ME_SETTING error", e);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$fetchInvitationInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$fetchInvitationInfo$1", f = "InviteExternalViewModelV2.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $from;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public C04321(InviteExternalViewModelV2 r1, String r2, Continuation<? super C04321> r3) {
            this.this$0 = r1;
            this.$from = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04321(this.this$0, this.$from, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Channel r5 = InviteExternalViewModelV2.access$getChannel$p(this.this$0);
            String r2 = this.$from;
            this.label = 1;
            if (r5.send(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$realFetchInvitationInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2", f = "InviteExternalViewModelV2.kt", i = {0, 1, 2, 3, 4}, l = {75, 79, 80, 82, 83}, m = "realFetchInvitationInfo", n = {"from", "from", "from", "from", "from"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
    public static final class C04331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public C04331(InviteExternalViewModelV2 r1, Continuation<? super C04331> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return InviteExternalViewModelV2.access$realFetchInvitationInfo(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$realFetchInvitationInfo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$realFetchInvitationInfo$2", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        public AnonymousClass2(InviteExternalViewModelV2 r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            InviteExternalViewModelV2.access$get_loadState$p(this.this$0).setValue(com.ss.android.lark.contact.base.contact_myqrcode.a.b.a);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$2", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.contact.base.contact_myqrcode.b<z8b.a> $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public C04342(InviteExternalViewModelV2 r1, com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a> r2, Continuation<? super C04342> r3) {
            this.this$0 = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C04342 r0 = new C04342(this.this$0, this.$result, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r3);
            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
            InviteExternalViewModelV2.access$get_loadState$p(this.this$0).setValue(com.ss.android.lark.contact.base.contact_myqrcode.a.c.a);
            InviteExternalViewModelV2.access$get_invitationInfoGroup$p(this.this$0).setValue(((com.ss.android.lark.contact.base.contact_myqrcode.b.C0164b) this.$result).a);
            MutableLiveData r4 = InviteExternalViewModelV2.access$get_canAddWithToken$p(this.this$0);
            z8b.a r0 = (z8b.a) ((com.ss.android.lark.contact.base.contact_myqrcode.b.C0164b) this.$result).a;
            r0.getClass();
            if (TextUtils.equals("qr_code", "qr_code") == false) goto L11;
            InvitationInfo r1 = r0.a;
        L12:
            if (r1 == null) goto L14;
            Boolean r2 = Boxing.boxBoolean(r1.canSearchWithToken);
        L15:
            r4.setValue(r2);
            return Unit.INSTANCE;
        L14:
            r2 = Boxing.boxBoolean(true);
            goto L15
        L11:
            r1 = r0.b;
            goto L12
        L7:
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$updateData$3", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.ss.android.lark.contact.base.contact_myqrcode.b<z8b.a> $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ InviteExternalViewModelV2 this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(InviteExternalViewModelV2 r1, com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a> r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$result, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r3);
            if (CoroutineScopeKt.isActive((CoroutineScope) this.L$0) == false) goto L7;
            MutableLiveData r4 = InviteExternalViewModelV2.access$get_loadState$p(this.this$0);
            String r1 = ((com.ss.android.lark.contact.base.contact_myqrcode.b.a) this.$result).a.getDisplayMsg();
            if (r1 != null) goto L11;
            r1 = BuildConfig.FLAVOR;
        L11:
            r4.setValue(new com.ss.android.lark.contact.base.contact_myqrcode.a.C0163a(r1));
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final void registerPush() {
        g.e.a.b(Command.PUSH_WAY_TO_ADD_ME_SETTING, new b(this));
    }

    private final void unregisterPush() {
        g.e.a.c(Command.PUSH_WAY_TO_ADD_ME_SETTING);
    }

    public InviteExternalViewModelV2() {
        MutableLiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> r0 = new MutableLiveData(com.ss.android.lark.contact.base.contact_myqrcode.a.b.a);
        this._loadState = r0;
        this.loadState = r0;
        MutableLiveData<z8b.a> r1 = new MutableLiveData();
        this._invitationInfoGroup = r1;
        this.invitationInfoGroup = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._canAddWithToken = r2;
        this.canAddWithToken = r2;
        this.channel = ChannelKt.Channel$default(0, null, null, 6, null);
        registerPush();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public void onCleared() {
        super.onCleared();
        unregisterPush();
    }

    public final LiveData<Boolean> getCanAddWithToken() {
        return this.canAddWithToken;
    }

    public final LiveData<z8b.a> getInvitationInfoGroup() {
        return this.invitationInfoGroup;
    }

    public final LiveData<com.ss.android.lark.contact.base.contact_myqrcode.a> getLoadState() {
        return this.loadState;
    }

    public static final /* synthetic */ Channel access$getChannel$p(InviteExternalViewModelV2 r0) {
        return r0.channel;
    }

    public static final /* synthetic */ MutableLiveData access$get_canAddWithToken$p(InviteExternalViewModelV2 r0) {
        return r0._canAddWithToken;
    }

    public static final /* synthetic */ MutableLiveData access$get_invitationInfoGroup$p(InviteExternalViewModelV2 r0) {
        return r0._invitationInfoGroup;
    }

    public static final /* synthetic */ MutableLiveData access$get_loadState$p(InviteExternalViewModelV2 r0) {
        return r0._loadState;
    }

    public final void fetchInvitationInfo(String r9) {
        Intrinsics.checkNotNullParameter(r9, "from");
        Log.i(TAG, "[" + r9 + "]fetchInvitationInfo");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04321(this, r9, null), 3, null);
    }

    private final Object realFetchInvitationInfo(String r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof C04331) == false) goto L7;
        C04331 r0 = (C04331) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L17;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L41:
        Log.i(TAG, "[" + r13 + "]realFetchInvitationInfo finish");
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L38:
        r0.L$0 = r13;
        r0.label = 5;
        if (updateData((com.ss.android.lark.contact.base.contact_myqrcode.b) r15, true, r0) != r2) goto L41;
        return r2;
    L19:
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L35:
        r0.L$0 = r13;
        r0.label = 4;
        r15 = fetchInvitationInfoRequest(r13, true, r0);
        if (r15 != r2) goto L38;
        return r2;
    L20:
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L32:
        r0.L$0 = r13;
        r0.label = 3;
        if (updateData((com.ss.android.lark.contact.base.contact_myqrcode.b) r15, false, r0) != r2) goto L35;
        return r2;
    L21:
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L29:
        r0.L$0 = r13;
        r0.label = 2;
        r15 = fetchInvitationInfoRequest(r13, false, r0);
        if (r15 != r2) goto L32;
        return r2;
    L22:
        ResultKt.throwOnFailure(r15);
        Log.i(TAG, "[" + r13 + "]realFetchInvitationInfo start");
        if (Intrinsics.areEqual(this._loadState.getValue(), com.ss.android.lark.contact.base.contact_myqrcode.a.c.a) == false) goto L26;
        Log.i(TAG, "[" + r13 + "]realFetchInvitationInfo cancel cause has success");
        return Unit.INSTANCE;
    L26:
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(this, null);
        r0.L$0 = r13;
        r0.label = 1;
        if (BuildersKt.withContext(r16, r4, r0) != r2) goto L29;
        return r2;
    L7:
        r0 = new C04331(this, r14);
        goto L8
    }

    public static final /* synthetic */ Object access$realFetchInvitationInfo(InviteExternalViewModelV2 r0, String r1, Continuation r2) {
        return r0.realFetchInvitationInfo(r1, r2);
    }

    private final Object fetchInvitationInfoRequest(final String r4, final boolean r5, Continuation<? super com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a>> r6) {
        final j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        Log.i(TAG, "[" + r4 + "]fetchInvitationInfoRequest start, fromServer: " + r5);
        IGetDataCallback<GetContactTokenResponse> r1 = new InviteExternalViewModelV2$fetchInvitationInfoRequest$2$callback$1(r4, r5, r0);
        if (r5 == false) goto L5;
        d.b(r1);
    L6:
        Object r7 = r0.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L9:
        return r7;
    L5:
        d.a(r1);
        goto L6
    }

    private final Object updateData(com.ss.android.lark.contact.base.contact_myqrcode.b<? extends z8b.a> r3, boolean r4, Continuation<? super Unit> r5) {
        if (r4 == true) goto L5;
        this.isLocalSuccess = r3 instanceof com.ss.android.lark.contact.base.contact_myqrcode.b.C0164b;
    L5:
        if ((r3 instanceof com.ss.android.lark.contact.base.contact_myqrcode.b.C0164b) == false) goto L12;
        Object r6 = BuildersKt.withContext(Dispatchers.getMain(), new C04342(this, r3, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r6;
    L10:
        return Unit.INSTANCE;
    L12:
        if ((r3 instanceof com.ss.android.lark.contact.base.contact_myqrcode.b.a) == false) goto L22;
        if (r4 == false) goto L22;
        if (this.isLocalSuccess == true) goto L22;
        Object r7 = BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this, r3, null), r5);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r7;
    L20:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$fetchInvitationInfoRequest(InviteExternalViewModelV2 r0, String r1, boolean r2, Continuation r3) {
        return r0.fetchInvitationInfoRequest(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$updateData(InviteExternalViewModelV2 r0, com.ss.android.lark.contact.base.contact_myqrcode.b r1, boolean r2, Continuation r3) {
        return r0.updateData(r1, r2, r3);
    }
}
