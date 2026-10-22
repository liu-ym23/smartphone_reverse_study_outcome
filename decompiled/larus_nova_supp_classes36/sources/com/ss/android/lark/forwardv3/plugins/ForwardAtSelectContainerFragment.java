package com.ss.android.lark.forwardv3.plugins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0002¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectContainerFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "setOnBackPressedListener", "Companion", "ForwardTarget", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardAtSelectContainerFragment extends BaseFragment {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/forwardv3/plugins/ForwardAtSelectContainerFragment$ForwardTarget;", "Ljava/io/Serializable;", "chatId", "", "chatType", "Lcom/ss/android/lark/biz/im/api/bundle/ChatType;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/bundle/ChatType;)V", "getChatId", "()Ljava/lang/String;", "getChatType", "()Lcom/ss/android/lark/biz/im/api/bundle/ChatType;", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ForwardTarget implements Serializable {
        private final String chatId;
        private final ChatType chatType;

        public static /* synthetic */ ForwardTarget copy$default(ForwardTarget r0, String r1, ChatType r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.chatId;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.chatType;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.chatId;
        }

        public final ChatType component2() {
            return this.chatType;
        }

        public final ForwardTarget copy(String r2, ChatType r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r3, "chatType");
            return new ForwardTarget(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ForwardTarget) == true) goto L8;
            return false;
        L8:
            ForwardTarget r6 = (ForwardTarget) r5;
            if (Intrinsics.areEqual(this.chatId, r6.chatId) == true) goto L12;
            return false;
        L12:
            if (this.chatType == r6.chatType) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.chatId.hashCode() * 31) + this.chatType.hashCode();
        }

        public String toString() {
            return "ForwardTarget(chatId=" + this.chatId + ", chatType=" + this.chatType + ')';
        }

        public final String getChatId() {
            return this.chatId;
        }

        public final ChatType getChatType() {
            return this.chatType;
        }

        public ForwardTarget(String r2, ChatType r3) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r3, "chatType");
            this.chatId = r2;
            this.chatType = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public ForwardAtSelectContainerFragment() {
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        int r8 = ForwardAtSelectFragmentV2.n;
        ForwardAtSelectFragmentV2 r9 = ForwardAtSelectFragmentV2.a.a(getArguments());
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373226) == true) goto L6;
        r0.add(2131373226, r9);
    L6:
        r0.commitAllowingStateLoss();
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L12;
        OnBackPressedDispatcher r1 = r10.getOnBackPressedDispatcher();
        if (r1 == null) goto L13;
        OnBackPressedDispatcherKt.addCallback$default(r1, this, false, new ForwardAtSelectContainerFragment$setOnBackPressedListener$1(this), 2, null);
        return;
    L13:
        return;
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(2131561154, null);
    }
}
