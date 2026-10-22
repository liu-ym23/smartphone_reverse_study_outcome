package com.ss.android.lark.compose.chatterselector;

import androidx.lifecycle.ViewModelKt;
import com.ss.android.lark.compose.chat_member_list.ChatMembersViewModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.v0;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0010R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorViewModel;", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersViewModel;", "chatId", BuildConfig.FLAVOR, "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "initiallySelectedIds", BuildConfig.FLAVOR, "maxSelectedCount", BuildConfig.FLAVOR, "onMaxSelectedReached", "Lkotlin/Function0;", BuildConfig.FLAVOR, "singleSelect", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;Ljava/util/Set;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Z)V", "Ljava/lang/Integer;", "selectedIdsFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "toggleSelected", "chatterId", "selected", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterSelectorViewModel extends ChatMembersViewModel {
    public static final int $stable = 8;
    private final Integer maxSelectedCount;
    private final Function0<Unit> onMaxSelectedReached;
    private final z0<Set<String>> selectedIdsFlow;
    private final boolean singleSelect;
    private final i1<b> uiState;

    public final i1<b> getUiState() {
        return this.uiState;
    }

    public final void toggleSelected(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "chatterId");
        z0<Set<String>> r0 = this.selectedIdsFlow;
    L3:
        Object r1 = r0.getValue();
        Set r2 = (Set) r1;
        if (this.singleSelect == false) goto L8;
        if (r7 == false) goto L7;
        r2 = SetsKt.setOf(r6);
    L23:
        if (r0.compareAndSet(r1, r2) == false) goto L3;
        return;
    L7:
        r2 = SetsKt.emptySet();
        goto L23
    L8:
        if (r7 == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L15;
    L19:
        if (r7 == false) goto L21;
        r2 = SetsKt.plus(r2, r6);
        goto L23
    L21:
        r2 = SetsKt.minus(r2, r6);
        goto L23
    L15:
        if (this.maxSelectedCount == null) goto L19;
        if (r2.size() < this.maxSelectedCount.intValue()) goto L19;
        this.onMaxSelectedReached.invoke();
        goto L23
    L10:
        if (r2.contains(r6) == true) goto L12;
        r3 = true;
        goto L13
    }

    public ChatterSelectorViewModel(String r9, com.lark.kmp.rustclient.api.d r10, com.ss.android.lark.compose.chatsetting.common.platform.b r11, Set<String> r12, Integer r13, Function0<Unit> r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r10, "rustClient");
        Intrinsics.checkNotNullParameter(r11, "platformEffects");
        Intrinsics.checkNotNullParameter(r12, "initiallySelectedIds");
        Intrinsics.checkNotNullParameter(r14, "onMaxSelectedReached");
        super(r9, r10, r11, null, 8, null);
        this.maxSelectedCount = r13;
        this.onMaxSelectedReached = r14;
        this.singleSelect = r15;
        StateFlowImpl r16 = j1.a(r12);
        this.selectedIdsFlow = r16;
        v0 r17 = new v0(getMembersUiState(), r16, new ChatterSelectorViewModel$uiState$1(null));
        CoroutineScope r18 = ViewModelKt.getViewModelScope(this);
        g1.a.getClass();
        this.uiState = e.F(r17, r18, g1.a.b, new b(r12, 123));
    }

    public /* synthetic */ ChatterSelectorViewModel(String r10, com.lark.kmp.rustclient.api.d r11, com.ss.android.lark.compose.chatsetting.common.platform.b r12, Set r13, Integer r14, Function0 r15, boolean r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 8) == 0) goto L5;
        Set r5 = SetsKt.emptySet();
    L7:
        if ((r17 & 16) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r17 & 32) == 0) goto L13;
        Function0 r7 = AnonymousClass1.INSTANCE;
    L15:
        if ((r17 & 64) == 0) goto L17;
        boolean r8 = false;
    L18:
        this(r10, r11, r12, r5, r6, r7, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }
}
