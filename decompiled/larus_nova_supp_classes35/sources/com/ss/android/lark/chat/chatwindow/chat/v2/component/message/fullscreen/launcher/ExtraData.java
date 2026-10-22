package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.base.view.vo.ThreadMessageVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y6b.b;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/launcher/ExtraData;", "Ljava/io/Serializable;", "receiveAuthorizationState", "Lcom/ss/android/lark/chat/utils/MessagePermissionUtil$ReceiveAuthorizationState;", "validateIMFileResult", "Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/ValidateIMFileResult;", "hasPreviewPermission", BuildConfig.FLAVOR, "isThreadClosed", "isThreadDisplayMode", "senderTenantId", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/utils/MessagePermissionUtil$ReceiveAuthorizationState;Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/ValidateIMFileResult;ZZZLjava/lang/String;)V", "getReceiveAuthorizationState", "()Lcom/ss/android/lark/chat/utils/MessagePermissionUtil$ReceiveAuthorizationState;", "getValidateIMFileResult", "()Lcom/ss/android/lark/auditsdk/v2/receivecheck/entity/ValidateIMFileResult;", "getHasPreviewPermission", "()Z", "getSenderTenantId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtraData implements Serializable {
    public static final a Companion = null;
    private final boolean hasPreviewPermission;
    private final boolean isThreadClosed;
    private final boolean isThreadDisplayMode;
    private final MessagePermissionUtil.ReceiveAuthorizationState receiveAuthorizationState;
    private final String senderTenantId;
    private final ValidateIMFileResult validateIMFileResult;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.ExtraData$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0065a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[PageType.values().length];
                r0[PageType.THREAD_DETAIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[PageType.THREAD_WINDOW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public a() {
        }

        @JvmStatic
        public static ExtraData a(y6b.a r9, Chat r10, PageType r11) {
            Intrinsics.checkNotNullParameter(r9, "<this>");
            Intrinsics.checkNotNullParameter(r11, "pageType");
            ValidateIMFileResult r0 = r9.N();
            String r1 = null;
            if (r0 == null) goto L5;
            IMFileResult r2 = r0.getResultType();
        L6:
            MessagePermissionUtil.ReceiveAuthorizationState r3 = MessagePermissionUtil.h(r2);
            boolean r5 = MessagePermissionUtil.f(r9, r10, MessagePermissionUtil.b());
            ValidateIMFileResult r4 = r9.N();
            int r12 = C0065a.a[r11.ordinal()];
            if (r12 != 1) goto L9;
            boolean r6 = ((c) r9).V2;
        L14:
            boolean r7 = r9.d();
            b r13 = r9.a();
            if (r13 == null) goto L18;
            r1 = r13.w;
        L18:
            return new ExtraData(r3, r4, r5, r6, r7, r1);
        L9:
            if (r12 != 2) goto L12;
            ThreadMessageVO r14 = (ThreadMessageVO) r9;
        L12:
            r6 = false;
            goto L14
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ExtraData copy$default(ExtraData r4, MessagePermissionUtil.ReceiveAuthorizationState r5, ValidateIMFileResult r6, boolean r7, boolean r8, boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.receiveAuthorizationState;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.validateIMFileResult;
    L8:
        ValidateIMFileResult r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.hasPreviewPermission;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isThreadClosed;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.isThreadDisplayMode;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.senderTenantId;
    L20:
        MessagePermissionUtil.ReceiveAuthorizationState r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    @JvmStatic
    public static final ExtraData parseExtraData(y6b.a<?> r1, Chat r2, PageType r3) {
        Companion.getClass();
        return a.a(r1, r2, r3);
    }

    public final MessagePermissionUtil.ReceiveAuthorizationState component1() {
        return this.receiveAuthorizationState;
    }

    public final ValidateIMFileResult component2() {
        return this.validateIMFileResult;
    }

    public final boolean component3() {
        return this.hasPreviewPermission;
    }

    public final boolean component4() {
        return this.isThreadClosed;
    }

    public final boolean component5() {
        return this.isThreadDisplayMode;
    }

    public final String component6() {
        return this.senderTenantId;
    }

    public final ExtraData copy(MessagePermissionUtil.ReceiveAuthorizationState r9, ValidateIMFileResult r10, boolean r11, boolean r12, boolean r13, String r14) {
        return new ExtraData(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ExtraData) == true) goto L8;
        return false;
    L8:
        ExtraData r6 = (ExtraData) r5;
        if (this.receiveAuthorizationState == r6.receiveAuthorizationState) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.validateIMFileResult, r6.validateIMFileResult) == true) goto L15;
        return false;
    L15:
        if (this.hasPreviewPermission == r6.hasPreviewPermission) goto L18;
        return false;
    L18:
        if (this.isThreadClosed == r6.isThreadClosed) goto L21;
        return false;
    L21:
        if (this.isThreadDisplayMode == r6.isThreadDisplayMode) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.senderTenantId, r6.senderTenantId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        MessagePermissionUtil.ReceiveAuthorizationState r0 = this.receiveAuthorizationState;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ValidateIMFileResult r4 = this.validateIMFileResult;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        int r7 = 1231;
        if (this.hasPreviewPermission == false) goto L13;
        int r8 = 1231;
    L14:
        int r9 = (r6 + r8) * 31;
        if (this.isThreadClosed == false) goto L17;
        int r10 = 1231;
    L18:
        int r11 = (r9 + r10) * 31;
        if (this.isThreadDisplayMode == true) goto L22;
        r7 = 1237;
    L22:
        int r12 = (r11 + r7) * 31;
        String r13 = this.senderTenantId;
        if (r13 == null) goto L27;
        r1 = r13.hashCode();
    L27:
        return r12 + r1;
    L17:
        r10 = 1237;
        goto L18
    L13:
        r8 = 1237;
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ExtraData(receiveAuthorizationState=" + this.receiveAuthorizationState + ", validateIMFileResult=" + this.validateIMFileResult + ", hasPreviewPermission=" + this.hasPreviewPermission + ", isThreadClosed=" + this.isThreadClosed + ", isThreadDisplayMode=" + this.isThreadDisplayMode + ", senderTenantId=" + this.senderTenantId + ')';
    }

    public final boolean getHasPreviewPermission() {
        return this.hasPreviewPermission;
    }

    public final MessagePermissionUtil.ReceiveAuthorizationState getReceiveAuthorizationState() {
        return this.receiveAuthorizationState;
    }

    public final String getSenderTenantId() {
        return this.senderTenantId;
    }

    public final ValidateIMFileResult getValidateIMFileResult() {
        return this.validateIMFileResult;
    }

    public final boolean isThreadClosed() {
        return this.isThreadClosed;
    }

    public final boolean isThreadDisplayMode() {
        return this.isThreadDisplayMode;
    }

    public ExtraData(MessagePermissionUtil.ReceiveAuthorizationState r1, ValidateIMFileResult r2, boolean r3, boolean r4, boolean r5, String r6) {
        this.receiveAuthorizationState = r1;
        this.validateIMFileResult = r2;
        this.hasPreviewPermission = r3;
        this.isThreadClosed = r4;
        this.isThreadDisplayMode = r5;
        this.senderTenantId = r6;
    }
}
