package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.auditsdk.v2.receivecheck.ImFileAuthorityChecker;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chatbase.view.ChatImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.security.compliance.api.model.filepolicy.EntityDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.security.compliance.api.model.filepolicy.IMFileEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.PolicyModel;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.utils.ImageUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessagePermissionUtil {
    public static final w4b.u a = null;
    public static final Lazy b = null;
    public static final com.ss.android.lark.auditsdk.v2.d c = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/utils/MessagePermissionUtil$ReceiveAuthorizationState;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MIDDLE_AUTHORIZATION_STATE", "FINAL_AUTHORIZATION_STATE_PASS", "FINAL_AUTHORIZATION_STATE_DENY", "NORMAL_STATE", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReceiveAuthorizationState extends Enum<ReceiveAuthorizationState> {
        public static final a Companion = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_DENY = null;
        public static final ReceiveAuthorizationState FINAL_AUTHORIZATION_STATE_PASS = null;
        public static final ReceiveAuthorizationState MIDDLE_AUTHORIZATION_STATE = null;
        public static final ReceiveAuthorizationState NORMAL_STATE = null;
        public static final ReceiveAuthorizationState UNKNOWN = null;
        public static final /* synthetic */ ReceiveAuthorizationState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            @JvmStatic
            public static ReceiveAuthorizationState a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return ReceiveAuthorizationState.UNKNOWN;
            L19:
                return ReceiveAuthorizationState.NORMAL_STATE;
            L20:
                return ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY;
            L21:
                return ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS;
            L22:
                return ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE;
            L17:
                return ReceiveAuthorizationState.UNKNOWN;
            }
        }

        @JvmStatic
        public static final ReceiveAuthorizationState fromValue(int r1) {
            Companion.getClass();
            return a.a(r1);
        }

        public static EnumEntries<ReceiveAuthorizationState> getEntries() {
            return b;
        }

        static {
            ReceiveAuthorizationState r0 = new ReceiveAuthorizationState("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ReceiveAuthorizationState r1 = new ReceiveAuthorizationState("MIDDLE_AUTHORIZATION_STATE", 1, 1);
            MIDDLE_AUTHORIZATION_STATE = r1;
            ReceiveAuthorizationState r3 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_PASS", 2, 2);
            FINAL_AUTHORIZATION_STATE_PASS = r3;
            ReceiveAuthorizationState r5 = new ReceiveAuthorizationState("FINAL_AUTHORIZATION_STATE_DENY", 3, 3);
            FINAL_AUTHORIZATION_STATE_DENY = r5;
            ReceiveAuthorizationState r7 = new ReceiveAuthorizationState("NORMAL_STATE", 4, 4);
            NORMAL_STATE = r7;
            ReceiveAuthorizationState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new a();
        }

        public static ReceiveAuthorizationState[] values() {
            return (ReceiveAuthorizationState[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ReceiveAuthorizationState valueOf(String r1) {
            return (ReceiveAuthorizationState) r27.a.a(ReceiveAuthorizationState.class, r1);
        }

        public ReceiveAuthorizationState(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReceiveAuthorizationState.values().length];
            r0[ReceiveAuthorizationState.NORMAL_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_PASS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[ReceiveAuthorizationState.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[ReceiveAuthorizationState.MIDDLE_AUTHORIZATION_STATE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ReceiveAuthorizationState.FINAL_AUTHORIZATION_STATE_DENY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
        a = ChatCoreModule.a().getLoginDependency();
        b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, MessagePermissionUtil$passportDependency$2.INSTANCE);
        c = ChatCoreModule.a().getAuditDependency().g();
    }

    @JvmStatic
    public static final PolicyModel a() {
        EntityDomain r2 = ImFileAuthorityChecker.f;
        FileBizDomain r8 = ImFileAuthorityChecker.g;
        Lazy r0 = b;
        String r1 = ((w4b.c.o) r0.getValue()).userId();
        if (r1 == null) goto L5;
        long r3 = CastLongProtector.parseLong(r1);
    L6:
        long r4 = CastLongProtector.parseLong(((w4b.c.o) r0.getValue()).fe());
        return new PolicyModel("PointKey_IM_MSG_FILE_READ", new IMFileEntity("IM_MSG_FILE", r2, "IM_MSG_FILE_READ", r4, r3, r8, null, null, null, null, null, null, null, null, null, 32704, null), null, 4, null);
    L5:
        r3 = 0;
        goto L6
    }

    @JvmStatic
    public static final ValidateResult b() {
        return c.c(true);
    }

    @JvmStatic
    public static final boolean e(ValidateResult r1) {
        Intrinsics.checkNotNullParameter(r1, "validateResult");
        return c.isAuthorizationPassed(r1);
    }

    @JvmStatic
    public static final boolean g(ReceiveAuthorizationState r2) {
        Intrinsics.checkNotNullParameter(r2, "receiveAuthorizationState");
        int r3 = a.a[r2.ordinal()];
        if (r3 != 1) goto L5;
    L15:
        return false;
    L5:
        if (r3 == 2) goto L15;
        if (r3 == 3) goto L15;
        if (r3 != 4) goto L11;
        return true;
    L11:
        if (r3 != 5) goto L14;
        return true;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final ReceiveAuthorizationState h(IMFileResult r1) {
        if (r1 == null) goto L6;
        int r2 = r1.getValue();
        ReceiveAuthorizationState.Companion.getClass();
        ReceiveAuthorizationState r3 = ReceiveAuthorizationState.a.a(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return ReceiveAuthorizationState.NORMAL_STATE;
    }

    @JvmStatic
    public static final void m(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        UDToast.show(r1, 2131891418);
    }

    @JvmStatic
    public static final boolean j(Message r3, String r4) {
        if (r3 != null) goto L6;
        Log.i("MessagePermissionUtil", "checking sendFromCurrentUser, given Message is null");
        return false;
    L6:
        String r1 = r3.getOriginalSenderId();
        if (TextUtils.isEmpty(r1) == false) goto L11;
        r1 = r3.getFromId();
    L11:
        if (Intrinsics.areEqual(r1, a.getUserId()) == false) goto L13;
    L14:
        return true;
    L13:
        if (Intrinsics.areEqual(r4, r3.getFromId()) == true) goto L14;
        return false;
    }

    @JvmStatic
    public static final boolean k(y6b.a<?> r3, String r4) {
        if (r3 != null) goto L7;
        Log.i("MessagePermissionUtil", "checking sendFromCurrentUser, given MessageVO is null");
        return false;
    L7:
        if ((r3 instanceof y6b.c) == false) goto L13;
        y6b.c r1 = (y6b.c) r3;
        if (TextUtils.isEmpty(r1.g1) == true) goto L11;
        String r2 = r1.g1;
    L17:
        if (Intrinsics.areEqual(r2, a.getUserId()) == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r4, r3.g()) == true) goto L20;
        return false;
    L11:
        r2 = r1.g;
        goto L17
    L13:
        if ((r3 instanceof ThreadMessageVO) == false) goto L15;
        ThreadMessageVO r5 = (ThreadMessageVO) r3;
        r2 = null;
        TextUtils.isEmpty(null);
        goto L17
    L15:
        r2 = BuildConfig.FLAVOR;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final Pair l(ChatImageView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        if (r3 != 2131891419) goto L5;
        String r4 = BuildConfig.FLAVOR;
    L6:
        int r0 = com.ss.android.lark.widget.span.nopreview.a.k;
        com.ss.android.lark.widget.span.nopreview.a.a r1 = com.ss.android.lark.widget.span.nopreview.a.b.a(r2.getContext());
        Intrinsics.checkNotNullParameter(r4, "text");
        r1.g = r4;
        com.ss.android.lark.widget.span.nopreview.a r5 = r1.a();
        r2.setImageDrawable(r5);
        return TuplesKt.to(Integer.valueOf(r5.b), Integer.valueOf(r5.c));
    L5:
        r4 = r2.getContext().getString(r3);
        goto L6
    }

    @JvmStatic
    public static final boolean c(Message r3, Chat r4, ValidateResult r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        return true;
    L9:
        if (r4 == null) goto L11;
        String r6 = r4.getAnonymousId();
    L13:
        return d(r3, r6, r5);
    L11:
        r6 = null;
        goto L13
    L5:
        if (r4.isSecret() != true) goto L7;
        r0 = true;
        goto L7
    }

    @JvmStatic
    public static final boolean d(Message r0, String r1, ValidateResult r2) {
        if (j(r0, r1) == false) goto L8;
        Lazy r3 = AuditUtilsV2.a;
        if (AuditUtilsV2.b() == true) goto L8;
        return true;
    L8:
        if (r2 != null) goto L11;
        r2 = b();
    L11:
        return e(r2);
    }

    @JvmStatic
    public static final boolean f(y6b.a<?> r2, Chat r3, ValidateResult r4) {
        if (r3 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return true;
    L10:
        if (r3 == null) goto L12;
        String r5 = r3.getAnonymousId();
    L14:
        if (k(r2, r5) == false) goto L18;
        Lazy r6 = AuditUtilsV2.a;
        if (AuditUtilsV2.b() == true) goto L18;
        return true;
    L18:
        if (r4 != null) goto L21;
        r4 = b();
    L21:
        return e(r4);
    L12:
        r5 = null;
        goto L14
    L5:
        if (r3.isSecret() != true) goto L7;
        r1 = true;
        goto L8
    }

    @JvmStatic
    public static final void n(Context r10, int r11, ValidateResult r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        com.ss.android.lark.auditsdk.v2.d r1 = c;
        if (r12 != null) goto L5;
        r12 = b();
    L5:
        com.ss.android.lark.auditsdk.v2.d.a.a(r1, r10, r12, Integer.valueOf(r11), null, 2131891417, r1.e(), null, 408);
    }

    @JvmStatic
    public static final Pair<Integer, Integer> i(Pair<Integer, Integer> r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int[] r11 = ImageUtils.g(((Number) r7.getFirst()).intValue(), ((Number) r7.getSecond()).intValue(), r8, r9, r10, r10);
        return TuplesKt.to(Integer.valueOf(r11[0]), Integer.valueOf(r11[1]));
    }
}
