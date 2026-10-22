package com.obric.assistant.window.component;

import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0000\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0003DEFB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0002J\u0012\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020\u0017H\u0002J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020!H\u0016J\u0018\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\"\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J \u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u0018\u00101\u001a\u00020\u00172\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020,H\u0002J2\u00104\u001a\u00020!2\b\u00105\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020,H\u0002J\n\u0010:\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010;\u001a\u00020!2\u0006\u0010/\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=H\u0002J\u001c\u0010>\u001a\u0004\u0018\u00010\u001a2\b\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010?\u001a\u00020!2\u0006\u0010/\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u001aH\u0002J\u0010\u0010@\u001a\u00020=2\u0006\u0010/\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020=2\u0006\u0010/\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020!H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/obric/assistant/window/component/ObricWindowChatListResizeComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "attachedList", "isWindowLifecycleListenerRegistered", "", "pendingOrientationChange", "pendingBottomAnchor", "Lcom/obric/assistant/window/component/ObricWindowChatListResizeComponent$BottomAnchor;", "cachedBottomAnchor", "lateLayoutChange", "Lcom/obric/assistant/window/component/ObricWindowChatListResizeComponent$LateLayoutChange;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onParentViewCreated", "", "onDestroy", "attachMessageList", "detachMessageList", "logWhenEmpty", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "onScreenRotationChanged", "previousRotation", "", "newRotation", "refreshMessageListLayoutCacheAfterRotation", "list", "notifyAdapterChangedAfterRotation", "isRotationAxisChanged", "isPortraitAxisRotation", "rotation", "cacheLateLayoutChangeIfNeeded", "anchor", "oldWidth", "oldHeight", "newWidth", "newHeight", "consumeValidLateLayoutChange", "updateCachedBottomAnchor", WindowEvent.Params.REASON, "", "captureBottomAnchor", "restoreBottomAnchor", "bottomStateDescription", "layoutManagerDescription", "registerWindowLifecycleListener", "unregisterWindowLifecycleListener", "Companion", "BottomAnchor", "LateLayoutChange", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowChatListResizeComponent extends ComponentFeature implements wga.b {
    public static final /* synthetic */ int r = 0;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public RecyclerView k;
    public boolean l;
    public boolean m;
    public a n;
    public a o;
    public c p;
    public final k q;

    public static final class a {
        public final int a;
        public final int b;
        public final int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            return "BottomAnchor(position=" + this.a + ", bottomOffset=" + this.b + ", adapterItemCount=" + this.c + ')';
        }

        public a(int r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    public static final class c {
        public final a a;
        public final long b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof c) == true) goto L8;
            return false;
        L8:
            c r9 = (c) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L18;
            return false;
        L18:
            if (this.d == r9.d) goto L21;
            return false;
        L21:
            if (this.e == r9.e) goto L24;
            return false;
        L24:
            if (this.f == r9.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return ((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "LateLayoutChange(anchor=" + this.a + ", uptimeMs=" + this.b + ", oldWidth=" + this.c + ", oldHeight=" + this.d + ", newWidth=" + this.e + ", newHeight=" + this.f + ')';
        }

        public c(a r2, long r3, int r5, int r6, int r7, int r8) {
            Intrinsics.checkNotNullParameter(r2, "anchor");
            this.a = r2;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    public static final class d implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    static {
    }

    public final void onWindowDismissed() {
    }

    public final void onWindowOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void onWindowPreStashed() {
    }

    public final void onWindowStashed() {
    }

    public final void B2() {
        FLogger r0 = FLogger.a;
        r0.i("ObricWindowChatListResizeComponent", "onParentViewCreated");
        if (IWindowContextKt.isWindowContext(getContext()) == true) goto L5;
        r0.i("ObricWindowChatListResizeComponent", "attachMessageList ignored, context is not window context");
        return;
    L5:
        com.larus.bmhome.chat.api.b0 r2 = (RecyclerView) this.j.getValue();
        if (r2 != null) goto L8;
        r0.w("ObricWindowChatListResizeComponent", "attachMessageList ignored, messageList is null");
        return;
    L8:
        L2();
        this.k = r2;
        int r3 = 0;
        this.m = false;
        Boolean r4 = null;
        this.n = null;
        this.o = null;
        this.p = null;
        r2.addOnLayoutChangeListener(this.q);
        if (this.l == true) goto L15;
        IAssistantChatWindow r5 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r5 == null) goto L14;
        r5.addWindowLifecycleListener(this);
        this.l = true;
        r0.i("ObricWindowChatListResizeComponent", "registerWindowLifecycleListener");
        goto L15
    L14:
        r0.w("ObricWindowChatListResizeComponent", "registerWindowLifecycleListener ignored, IAssistantChatWindow is null");
    L15:
        StringBuilder r6 = new StringBuilder("attachMessageList, list=");
        r6.append(r2.hashCode());
        r6.append(", ");
        LinearLayoutManager r8 = r2.getLayoutManager();
        if ((r8 instanceof LinearLayoutManager) == false) goto L18;
        LinearLayoutManager r9 = r8;
    L19:
        if (r9 != null) goto L25;
        StringBuilder r10 = new StringBuilder("layoutManager=");
        RecyclerView.LayoutManager r11 = r2.getLayoutManager();
        if (r11 == null) goto L23;
        String r12 = r11.getClass().getSimpleName();
    L24:
        r10.append(r12);
        String r13 = r10.toString();
    L26:
        r6.append(r13);
        r6.append(", ");
        StringBuilder r7 = new StringBuilder("canScrollToBottom=");
        r7.append(r2.canScrollVertically(1));
        r7.append(", isBottomReached=");
        if ((r2 instanceof com.larus.bmhome.chat.api.b0) == false) goto L29;
        com.larus.bmhome.chat.api.b0 r14 = r2;
    L30:
        if (r14 == null) goto L32;
        r4 = Boolean.valueOf(r14.i());
    L32:
        r7.append(r4);
        r7.append(", adapterItemCount=");
        RecyclerView.Adapter r15 = r2.getAdapter();
        if (r15 == null) goto L35;
        r3 = r15.getItemCount();
    L35:
        r7.append(r3);
        r6.append(r7.toString());
        r0.i("ObricWindowChatListResizeComponent", r6.toString());
        return;
    L29:
        r14 = null;
        goto L30
    L23:
        r12 = null;
        goto L24
    L25:
        r13 = "orientation=" + r9.getOrientation() + ", reverseLayout=" + r9.getReverseLayout() + ", stackFromEnd=" + r9.getStackFromEnd();
        goto L26
    L18:
        r9 = null;
        goto L19
    }

    public final void L2() {
        RecyclerView r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeOnLayoutChangeListener(this.q);
        if (this.l == false) goto L12;
        IAssistantChatWindow r1 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r1 == null) goto L11;
        r1.removeWindowLifecycleListener(this);
    L11:
        this.l = false;
        FLogger.a.i("ObricWindowChatListResizeComponent", "unregisterWindowLifecycleListener");
    L12:
        this.k = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = null;
        FLogger.a.i("ObricWindowChatListResizeComponent", "detachMessageList, list=" + r0.hashCode());
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.assistant.window.component.k] */
    public ObricWindowChatListResizeComponent() {
        this.h = LazyKt.lazy(new d(this));
        this.i = LazyKt.lazy(new i(this));
        this.j = LazyKt.lazy(new j(this));
        this.q = new k(this);
    }

    public final void onDestroy() {
        L2();
    }

    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public static a F2(RecyclerView r11, String r12) {
        a r0 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        LinearLayoutManager r1 = r11.getLayoutManager();
        if ((r1 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r2 = r1;
    L9:
        if (r2 != null) goto L11;
        return null;
    L11:
        int r3 = r11.getPaddingTop();
        int r4 = r11.getHeight() - r11.getPaddingBottom();
        int r5 = r11.getChildCount();
        int r6 = Integer.MIN_VALUE;
        int r7 = 0;
    L12:
        if (r7 >= r5) goto L30;
        View r8 = r11.getChildAt(r7);
        if (r8 == null) goto L29;
        int r9 = r11.getChildAdapterPosition(r8);
        if (r9 == (-1)) goto L29;
        int r10 = r2.getDecoratedTop(r8);
        int r13 = r2.getDecoratedBottom(r8);
        if (r13 <= r3) goto L29;
        if (r10 >= r4) goto L29;
        if (r13 <= r6) goto L29;
        int r14 = r4 - r13;
        RecyclerView.Adapter r15 = r11.getAdapter();
        if (r15 == null) goto L27;
        int r16 = r15.getItemCount();
    L28:
        r0 = new a(r9, r14, r16);
        r6 = r13;
        goto L29
    L27:
        r16 = 0;
    L29:
        r7 = r7 + 1;
        goto L12
    L30:
        FLogger.a.d("ObricWindowChatListResizeComponent", "captureBottomAnchor, reason=" + r12 + ", result=" + r0);
        return r0;
    L8:
        r2 = null;
        goto L9
    }

    public static void P2(RecyclerView r5, a r6) {
        LinearLayoutManager r0 = r5.getLayoutManager();
        if ((r0 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r1 = r0;
    L7:
        if (r1 != null) goto L10;
        FLogger.a.i("ObricWindowChatListResizeComponent", "restoreAnchor skipped, layoutManager is not LinearLayoutManager");
        return;
    L10:
        RecyclerView.Adapter r7 = r5.getAdapter();
        boolean r2 = false;
        if (r7 == null) goto L13;
        int r8 = r7.getItemCount();
    L14:
        int r3 = r6.a;
        if (r3 < 0) goto L19;
        if (r3 >= r8) goto L19;
        r2 = true;
    L19:
        if (r2 == true) goto L22;
        FLogger.a.i("ObricWindowChatListResizeComponent", "restoreAnchor skipped, anchor=" + r6 + ", currentItemCount=" + r8);
        return;
    L22:
        r1.scrollToPositionWithOffset(r3, r6.b);
        FLogger.a.i("ObricWindowChatListResizeComponent", "restoreAnchor, position=" + r6.a + ", bottomOffset=" + r6.b + ", oldItemCount=" + r6.c + ", currentItemCount=" + r8);
        return;
    L13:
        r8 = 0;
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    public final void onScreenRotationChanged(final int r14, final int r15) {
        if (r14 == 0) goto L7;
        if (r14 == 2) goto L7;
        boolean r3 = false;
    L8:
        if (r15 == 0) goto L12;
        if (r15 == 2) goto L12;
        boolean r0 = false;
    L13:
        if (r3 == r0) goto L15;
        boolean r1 = true;
    L17:
        if (r1 == true) goto L20;
        FLogger.a.i("ObricWindowChatListResizeComponent", "onScreenRotationChanged skip pending resize, rotation axis unchanged, previousRotation=" + r14 + ", newRotation=" + r15);
        return;
    L20:
        final RecyclerView r2 = this.k;
        if (r2 != null) goto L23;
        FLogger.a.i("ObricWindowChatListResizeComponent", "refreshMessageListLayoutCacheAfterRotation skipped, list is null, previousRotation=" + r14 + ", newRotation=" + r15);
    L24:
        c r5 = this.p;
        if (r5 == null) goto L30;
        this.p = null;
        long r7 = SystemClock.uptimeMillis() - r5.b;
        if (r7 <= 2000) goto L31;
        FLogger.a.i("ObricWindowChatListResizeComponent", "consumeLateLayoutChange skipped, expired ageMs=" + r7 + ", lateChange=" + r5);
        goto L30
    L31:
        FLogger.a.i("ObricWindowChatListResizeComponent", "consumeLateLayoutChange, ageMs=" + r7 + ", lateChange=" + r5);
        final a r6 = r5.a;
    L33:
        if (r6 == null) goto L37;
        if (r2 == null) goto L37;
        this.m = false;
        this.n = null;
        FLogger.a.i("ObricWindowChatListResizeComponent", "onScreenRotationChanged restore late layout, previousRotation=" + r14 + ", newRotation=" + r15 + ", bottomAnchor=" + r6);
        r2.post(new l(this, r2, r6));
        return;
    L37:
        a r4 = F2(r2, "onScreenRotationChanged");
        if (r4 != null) goto L40;
        r4 = this.o;
    L40:
        if (r4 != null) goto L43;
        FLogger.a.i("ObricWindowChatListResizeComponent", "onScreenRotationChanged skip pending resize, bottom anchor is null, previousRotation=" + r14 + ", newRotation=" + r15);
        return;
    L43:
        this.m = true;
        this.n = r4;
        FLogger.a.i("ObricWindowChatListResizeComponent", "onScreenRotationChanged pending resize, previousRotation=" + r14 + ", newRotation=" + r15 + ", bottomAnchor=" + r4);
        return;
    L30:
        r6 = null;
        goto L33
    L23:
        r2.getRecycledViewPool().clear();
        r2.requestLayout();
        r2.post(new m(this, r2, r14, r15));
        goto L24
    L15:
        r1 = false;
    L12:
        r0 = true;
    L7:
        r3 = true;
        goto L8
    }

    public final void N2(final RecyclerView r5, final int r6, final int r7) {
        RecyclerView.Adapter r0 = r5.getAdapter();
        if (r0 != null) goto L7;
        FLogger.a.i("ObricWindowChatListResizeComponent", "notifyAdapterChangedAfterRotation skipped, adapter is null");
        return;
    L7:
        if (r0.getItemCount() > 0) goto L11;
        FLogger.a.i("ObricWindowChatListResizeComponent", "notifyAdapterChangedAfterRotation skipped, itemCount=" + r0.getItemCount());
        return;
    L11:
        if (r5.isComputingLayout() == false) goto L14;
        r5.post(new o(this, r5, r6, r7));
        return;
    L14:
        FLogger.a.i("ObricWindowChatListResizeComponent", "notifyAdapterChangedAfterRotation, previousRotation=" + r6 + ", newRotation=" + r7 + ", itemCount=" + r0.getItemCount());
        r0.notifyDataSetChanged();
    }
}
