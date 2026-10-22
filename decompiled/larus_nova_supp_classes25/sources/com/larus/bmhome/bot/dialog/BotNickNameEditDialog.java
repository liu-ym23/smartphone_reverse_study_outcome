package com.larus.bmhome.bot.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.databinding.LarusDialogNicknameInputBottomBinding;
import com.larus.bmhome.utils.x1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotSourceType;
import com.larus.im.bean.conversation.BotConversationType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 ?2\u00020\u0001:\u0005?@ABCB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\b\u0010(\u001a\u00020\u001aH\u0002J+\u0010)\u001a\u00020\r2\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u000f2\u0006\u0010,\u001a\u00020\u0007¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u001aH\u0002J\u0012\u0010/\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u00101\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u00104\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\rH\u0002J \u0010<\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusDialogNicknameInputBottomBinding;", "mCheckInputNull", "", "Ljava/lang/Boolean;", "mTitle", "", "mSubTitle", "mText", "", "mMaxInputLength", "", "mBotId", "mConversationId", "isLoading", "mHintText", "mNickNameEditResultListener", "Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$NickNameEditResultListener;", "imeManager", "Lcom/larus/bmhome/utils/ImeManager;", "mCurrentPage", "onResume", "", "onStop", "hideKeyboard", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "getTheme", "trackShowEvent", "getChatType", "botConversationType", "botType", "isOwnBot", "(Ljava/lang/Integer;Ljava/lang/Integer;Z)Ljava/lang/String;", "setupView", "checkTextInputEnable", ChatDraftItem.TYPE_TEXT, "updateHintText", "botId", "conversationId", "updateContent", "setupNickNameEditTitle", "input", "isShowLoadingView", "show", "tryUpdateNickName", "nickName", "updateSelfProfile", "trackChangeUserNickName", "overallChange", "isSuccess", "Companion", "ImeStatus", "NickNameEditResponse", "Builder", "NickNameEditResultListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotNickNameEditDialog extends DialogFragment {
    public static final /* synthetic */ int n = 0;
    public LarusDialogNicknameInputBottomBinding d;
    public Boolean e;
    public String f;
    public int g;
    public String h;
    public String i;
    public Boolean j;
    public c k;
    public x1 l;
    public String m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$ImeStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SHOW", "HIDE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum ImeStatus extends Enum<ImeStatus> {
        public static final ImeStatus HIDE = null;
        public static final ImeStatus NONE = null;
        public static final ImeStatus SHOW = null;
        public static final /* synthetic */ ImeStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ImeStatus> getEntries() {
            return b;
        }

        static {
            ImeStatus r0 = new ImeStatus("NONE", 0);
            NONE = r0;
            ImeStatus r1 = new ImeStatus("SHOW", 1);
            SHOW = r1;
            ImeStatus r3 = new ImeStatus("HIDE", 2);
            HIDE = r3;
            ImeStatus[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ImeStatus[] values() {
            return (ImeStatus[]) a.clone();
        }

        public static ImeStatus valueOf(String r1) {
            return (ImeStatus) r27.a.a(ImeStatus.class, r1);
        }

        public ImeStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$NickNameEditResponse;", "", "firstMessage", "", "isUpdateProfile", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getFirstMessage", "()Ljava/lang/String;", "setFirstMessage", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setUpdateProfile", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/bot/dialog/BotNickNameEditDialog$NickNameEditResponse;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b {

        @SerializedName("first_message")
        private String firstMessage;

        @SerializedName("is_update_profile_name")
        private Boolean isUpdateProfile;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.firstMessage, r6.firstMessage) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isUpdateProfile, r6.isUpdateProfile) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.firstMessage;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.isUpdateProfile;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "NickNameEditResponse(firstMessage=" + this.firstMessage + ", isUpdateProfile=" + this.isUpdateProfile + ')';
        }

        public b() {
            Boolean r0 = Boolean.FALSE;
            this.firstMessage = null;
            this.isUpdateProfile = r0;
        }

        public final String a() {
            return this.firstMessage;
        }

        public final Boolean b() {
            return this.isUpdateProfile;
        }
    }

    public interface c {
        void a(String r1, String r2);

        void onCancel();
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2", f = "BotNickNameEditDialog.kt", i = {}, l = {91, 92}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BotNickNameEditDialog this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.bot.dialog.BotNickNameEditDialog$onResume$2$1", f = "BotNickNameEditDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BotNickNameEditDialog this$0;

            public AnonymousClass1(BotNickNameEditDialog r1, Continuation<? super AnonymousClass1> r2) {
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

            public static void INVOKEVIRTUAL_com_larus_bmhome_bot_dialog_BotNickNameEditDialog$onResume$2$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(BotNickNameEditDialog r1) {
                r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
                return;
            L4:
                e = move-exception;
                com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
                Throwable r2 = DialogFragmentLancet.sLastShowStack;
                if (r2 == null) goto L11;
                com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
                return;
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r3);
                LarusDialogNicknameInputBottomBinding r4 = this.this$0.d;
                if (r4 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                r4 = null;
            L7:
                ViewTreeObserver r5 = r4.a.getViewTreeObserver();
                if (r5 == null) goto L11;
                final BotNickNameEditDialog r0 = this.this$0;
                r5.addOnGlobalLayoutListener(new k(r0));
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(BotNickNameEditDialog r1, Continuation<? super AnonymousClass2> r2) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L13:
            MainCoroutineDispatcher r7 = Dispatchers.getMain();
            AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r7, r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(500, this) != r0) goto L13;
            return r0;
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131954350;
    }

    public BotNickNameEditDialog() {
        Boolean r0 = Boolean.FALSE;
        this.e = r0;
        this.f = "";
        this.j = r0;
    }

    public final void hideKeyboard() {
        FragmentActivity r0 = getActivity();
        LarusDialogNicknameInputBottomBinding r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L7:
        if ((r2 instanceof InputMethodManager) == false) goto L9;
        InputMethodManager r3 = (InputMethodManager) r2;
    L10:
        if (r3 == null) goto L23;
        LarusDialogNicknameInputBottomBinding r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r3.hideSoftInputFromWindow(r1.e.getWindowToken(), 0);
        goto L23
    L14:
        r1 = r4;
    L23:
        dismissAllowingStateLoss();     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L25;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L25:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        r2.width = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels;
        r1.setAttributes(r2);
    L7:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnonymousClass2(this, null), 2, null);
    }

    public final void onStop() {
        super.onStop();
        hideKeyboard();
        c r0 = this.k;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public final void T90(CharSequence r6) {
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        LarusDialogNicknameInputBottomBinding r3 = null;
        if (r2 == false) goto L12;
    L22:
        LarusDialogNicknameInputBottomBinding r7 = this.d;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L25:
        r7.d.setAlpha(0.3f);
        LarusDialogNicknameInputBottomBinding r8 = this.d;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L29:
        r3.d.setEnabled(false);
        return;
    L28:
        r3 = r8;
        goto L29
    L12:
        if (r6.length() < 2) goto L22;
        LarusDialogNicknameInputBottomBinding r9 = this.d;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L17:
        r9.d.setAlpha(1.0f);
        LarusDialogNicknameInputBottomBinding r10 = this.d;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r3.d.setEnabled(true);
        return;
    L20:
        r3 = r10;
        goto L21
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void V90(boolean r5) {
        LarusDialogNicknameInputBottomBinding r2 = null;
        if (r5 == false) goto L12;
        this.j = Boolean.TRUE;
        LarusDialogNicknameInputBottomBinding r6 = this.d;
        if (r6 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L7:
        r6.h.setVisibility(0);
        LarusDialogNicknameInputBottomBinding r7 = this.d;
        if (r7 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L11:
        r2.d.setVisibility(4);
        return;
    L10:
        r2 = r7;
        goto L11
    L12:
        this.j = Boolean.FALSE;
        LarusDialogNicknameInputBottomBinding r8 = this.d;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L15:
        r8.d.setVisibility(0);
        LarusDialogNicknameInputBottomBinding r9 = this.d;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L19:
        r2.h.setVisibility(4);
        return;
    L18:
        r2 = r9;
        goto L19
    }

    public final void W90(String r8) {
        if (Intrinsics.areEqual(this.j, Boolean.TRUE) == false) goto L5;
        return;
    L5:
        V90(true);
        AppHost.a.getApplication();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new BotNickNameEditDialog$tryUpdateNickName$1(this, r8, null), 3, null);
    }

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        if (Intrinsics.areEqual(this.e, Boolean.TRUE) == false) goto L15;
        LarusDialogNicknameInputBottomBinding r11 = this.d;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L7:
        T90(r11.e.getText());
        LarusDialogNicknameInputBottomBinding r12 = this.d;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L10:
        r12.e.addTextChangedListener(new l(this));
        LarusDialogNicknameInputBottomBinding r13 = this.d;
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L13:
        r13.e.setOnEditorActionListener(new m(this));
    L15:
        if (this.g <= 0) goto L20;
        LarusDialogNicknameInputBottomBinding r14 = this.d;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L19:
        r14.e.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.g)});
    L20:
        LarusDialogNicknameInputBottomBinding r15 = this.d;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L23:
        r15.e.requestFocus();
        LarusDialogNicknameInputBottomBinding r16 = this.d;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L26:
        r16.d.setOnClickListener(new h(this));
        LarusDialogNicknameInputBottomBinding r17 = this.d;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L29:
        r17.c.setOnClickListener(new i(this));
        LarusDialogNicknameInputBottomBinding r18 = this.d;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L32:
        r18.b.setOnClickListener(new j(this));
        String r19 = this.h;
        if (r19 == null) goto L36;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BotNickNameEditDialog$updateContent$1(r19, this, null), 2, null);
    L36:
        String r20 = this.h;
        String r0 = this.i;
        if (r20 == null) goto L42;
        if (r0 == null) goto L42;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BotNickNameEditDialog$updateHintText$1(r0, r20, this, null), 2, null);
    L42:
        Dialog r21 = getDialog();
        if (r21 == null) goto L45;
        r21.setCanceledOnTouchOutside(true);
    L45:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BotNickNameEditDialog$trackShowEvent$1(this, null), 2, null);
    }

    public static String U90(@BotConversationType Integer r2, @BotSourceType Integer r3, boolean r4) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r3 != null) goto L15;
    L19:
        return "other_default";
    L15:
        if (r3.intValue() != 0) goto L19;
        if (r4 == false) goto L18;
        return "self_created";
    L18:
        return "others_created";
    L10:
        if (r2.intValue() != 3) goto L12;
        return "default_new";
    L5:
        if (r2.intValue() != 1) goto L7;
        return "default";
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131562086, r12, false);
        int r15 = 2131363806;
        View r3 = ViewBindings.findChildViewById(r14, 2131363806);
        if (r3 == null) goto L27;
        r15 = 2131365114;
        AppCompatImageView r4 = ViewBindings.findChildViewById(r14, 2131365114);
        if (r4 == null) goto L27;
        r15 = 2131367639;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r14, 2131367639);
        if (r5 == null) goto L27;
        r15 = 2131368970;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r14, 2131368970);
        if (r6 == null) goto L27;
        r15 = 2131368980;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, 2131368980);
        if (r7 == null) goto L27;
        r15 = 2131368982;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, 2131368982);
        if (r8 == null) goto L27;
        r15 = 2131379091;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r14, 2131379091);
        if (r9 == null) goto L27;
        LarusDialogNicknameInputBottomBinding r16 = new LarusDialogNicknameInputBottomBinding((RelativeLayout) r14, r3, r4, r5, r6, r7, r8, r9);
        this.d = r16;
        this.l = new x1(r16.e);
        Dialog r17 = getDialog();
        if (r17 == null) goto L21;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L21;
        r18.setGravity(80);
        r18.setBackgroundDrawable(new ColorDrawable(0));
    L21:
        LarusDialogNicknameInputBottomBinding r19 = this.d;
        if (r19 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L25:
        return r19.a;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }

    public static final void S90(BotNickNameEditDialog r10, String r11, boolean r12, boolean r13) {
        r10.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), Dispatchers.getIO(), null, new BotNickNameEditDialog$trackChangeUserNickName$1(r10, r11, r12, r13, null), 2, null);
    }
}
