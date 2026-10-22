package com.obric.assistant.card;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.DividerItemMarginDecoration;
import com.obric.assistant.card.layout.adapter.AppEntityListAdapter;
import com.obric.assistant.card.layout.bean.MessageExtraForViewHolder;
import com.obric.assistant.card.layout.viewholder.AlbumGridViewHolder;
import com.obric.assistant.card.manager.NetEaseMusicManager;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageObserverImpl;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.oui.bouncelayout.BounceEdgeEffect;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0019\u0018\u0000 A2\u00020\u0001:\u0003ABCB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u0016J\f\u0010\u001e\u001a\u00060\u0005R\u00020\u0000H\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u001e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0016\u0010-\u001a\u00020!2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020.0+H\u0002J\u0016\u0010/\u001a\u00020!2\f\u00100\u001a\b\u0012\u0004\u0012\u00020.0+H\u0002J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020!H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00104\u001a\u000205H\u0002J\u0014\u00109\u001a\u000208*\u0002052\u0006\u0010:\u001a\u00020\rH\u0002J\u001a\u0010;\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0<H\u0002J$\u0010=\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0018\u00010<2\u0006\u00104\u001a\u000205H\u0002J\u0018\u0010>\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\u0006\u00104\u001a\u000205H\u0002J\u0012\u0010?\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020@H\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006D"}, d2 = {"Lcom/obric/assistant/card/ShowAllDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "recyclerView", "Lcom/obric/assistant/card/ShowAllDialogFragment$ViewAllBounceRecyclerView;", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "currentMessageExtra", "Lcom/obric/assistant/card/layout/bean/MessageExtraForViewHolder;", "currentMessageId", NameKeys.UnloadStrategy_No_Strategy, "currentWidgetId", "currentMixtureCardId", "traceInfo", "Landroid/os/Bundle;", "listAdapter", "Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter;", "getListAdapter", "()Lcom/obric/assistant/card/layout/adapter/AppEntityListAdapter;", "listAdapter$delegate", "Lkotlin/Lazy;", "messageObserver", "com/obric/assistant/card/ShowAllDialogFragment$messageObserver$1", "Lcom/obric/assistant/card/ShowAllDialogFragment$messageObserver$1;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "buildRecyclerView", "resolveTitle", "onDismiss", NameKeys.UnloadStrategy_No_Strategy, "dialog", "Landroid/content/DialogInterface;", "onStop", "onDestroy", "loadInitialData", "safeDismiss", "renderData", "messageExtra", "dataList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/aiagent/assistant/idl/bean/AppIntentCardData;", "updateListContentPadding", NameKeys.UnloadStrategy_No_Strategy, "prefetchFirstScreenPhotos", "entities", "registerMessageObserver", "unregisterMessageObserver", "refreshFromMessageIfNeeded", "message", "Lcom/larus/im/bean/message/Message;", "refreshLatestMessage", "isTargetMessage", NameKeys.UnloadStrategy_No_Strategy, "matchesIdentifier", "identifier", "getInitialDataFromArguments", "Lkotlin/Pair;", "buildDataFromMessage", "buildWidgetDataFromMessage", "toCardDataList", "Lcom/obric/aiagent/assistant/idl/bean/AppIntentMessage;", "Companion", "ViewAllBounceRecyclerView", "ShowOnceOSheet", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowAllDialogFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int n = 0;
    public ViewAllBounceRecyclerView d;
    public b e;
    public DividerItemMarginDecoration f;
    public MessageExtraForViewHolder g;
    public String h;
    public String i;
    public String j;
    public Bundle k;
    public final Lazy l;
    public final d m;

    public final class ViewAllBounceRecyclerView extends RecyclerView {
        public BounceEdgeEffect a;
        public BounceEdgeEffect b;
        public boolean c;
        public final /* synthetic */ ShowAllDialogFragment d;

        /* JADX WARN: Multi-variable type inference failed */
        public final void r() {
            BounceEdgeEffect r0 = this.a;
            if (r0 == null) goto L5;
            r0.finish();
        L5:
            BounceEdgeEffect r1 = this.b;
            if (r1 == null) goto L8;
            r1.finish();
        L8:
            invalidate();
        }

        public final void onDetachedFromWindow() {
            r();
            super.onDetachedFromWindow();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean dispatchTouchEvent(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            if (r4.getActionMasked() != 0) goto L24;
            BounceEdgeEffect r0 = this.a;
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L20;
            BounceEdgeEffect r2 = this.b;
            if (r2 != null) goto L14;
        L16:
            boolean r3 = false;
        L17:
            if (r3 == true) goto L20;
            boolean r5 = false;
        L21:
            if (r5 == false) goto L24;
            this.c = true;
            r();
            goto L24
        L14:
            if (r2.isFinished() == true) goto L16;
            r3 = true;
        L20:
            r5 = true;
            goto L21
        L7:
            if (r0.isFinished() == true) goto L9;
            r1 = true;
        L24:
            if (this.c == false) goto L32;
            if (r4.getActionMasked() != 1) goto L28;
        L29:
            this.c = false;
        L30:
            return true;
        L28:
            if (r4.getActionMasked() != 3) goto L30;
        L32:
            return super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
        }

        public final void draw(Canvas r4) {
            Intrinsics.checkNotNullParameter(r4, "canvas");
            BounceEdgeEffect r0 = this.a;
            if (r0 == null) goto L5;
            float r1 = r0.f;
        L6:
            BounceEdgeEffect r2 = this.b;
            if (r2 == null) goto L9;
            float r3 = r2.f;
        L10:
            float r5 = r1 + r3;
            int r6 = r4.save();
            r4.translate(0.0f, r5);
            super.draw(r4);
            r4.restoreToCount(r6);
            return;
        L9:
            r3 = 0.0f;
            goto L10
        L5:
            r1 = 0.0f;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ViewAllBounceRecyclerView(ShowAllDialogFragment r2, final Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.d = r2;
            super(r3);
            setOverScrollMode(2);
            setEdgeEffectFactory(new AnonymousClass1(r3, this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onMeasure(int r3, int r4) {
            super.onMeasure(r3, r4);
            b r5 = this.d.e;
            boolean r6 = false;
            if (r5 == null) goto L13;
            OSheetBase.DefaultImpls.b(r5);
            Intrinsics.checkNotNullParameter(r5, "this");
            Integer r7 = Integer.valueOf(r5.getScaffoldController().j);
            if (r7.intValue() <= 0) goto L7;
            boolean r1 = true;
        L8:
            if (r1 == true) goto L11;
            r7 = null;
        L11:
            if (r7 == null) goto L13;
            int r8 = r7.intValue();
        L14:
            if (1 <= r8) goto L16;
        L18:
            if (r6 == false) goto L21;
            setMeasuredDimension(getMeasuredWidth(), r8);
            return;
        L21:
            return;
        L16:
            if (r8 >= getMeasuredHeight()) goto L18;
            r6 = true;
            goto L18
        L7:
            r1 = false;
        L13:
            int r9 = m0.a;
            r8 = m0.a(getContext()) - i5.h0();
            goto L14
        }

        public final void onSizeChanged(int r2, int r3, int r4, int r5) {
            super.onSizeChanged(r2, r3, r4, r5);
            Iterator r6 = CollectionsKt.listOfNotNull(new BounceEdgeEffect[]{this.a, this.b}).iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            BounceEdgeEffect r7 = (BounceEdgeEffect) r6.next();
            r7.c = r3;
            r7.setSize(r2, r3);
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
            super.onLayout(r1, r2, r3, r4, r5);
            int r6 = 0;
            boolean r7 = true;
            if (canScrollVertically(-1) == false) goto L5;
        L8:
            if (r7 == true) goto L10;
            r();
        L10:
            if (r7 == true) goto L13;
            r6 = 2;
        L13:
            setOverScrollMode(r6);
            return;
        L5:
            if (canScrollVertically(1) == true) goto L8;
            r7 = false;
            goto L8
        }
    }

    public static final class a {
        public static void a(FragmentManager r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "fragmentManager");
            Intrinsics.checkNotNullParameter(r3, "args");
            if (r2.isStateSaved() == false) goto L5;
            return;
        L5:
            if (r2.findFragmentByTag("ShowAllDialogFragment") != null) goto L17;
            ShowAllDialogFragment r1 = new ShowAllDialogFragment();
            r1.setArguments(r3);
            LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "ShowAllDialogFragment", r4);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r4) == true) goto L18;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
        L11:
            r1.show(r2, "ShowAllDialogFragment");
            return;
        L18:
            return;
        }
    }

    public static final class b extends OSheet {
        public boolean G;

        /* JADX WARN: Multi-variable type inference failed */
        public final void show() {
            if (this.G == false) goto L14;
            Window r0 = getWindow();
            if (r0 == null) goto L23;
            View r1 = r0.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L11;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r2 = ThreadMethodProxy.currentThread();
            if (r2 == com.larus.home.impl.utils.c.a) goto L11;
            com.larus.home.impl.utils.c.a(r2, "getDecorView");
        L11:
            if (r1 == null) goto L24;
            r1.setVisibility(0);
            return;
        L24:
            return;
        L23:
            return;
        L14:
            this.G = true;
            if (DialogLancet.shouldBlockDialogShow(this) == false) goto L21;
            DialogLancet.handleBlockedDialogShow(this);
            return;
        L21:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
        L18:
            DialogLancet.beforeDialogShow(this);
            super.show();
            DialogLancet.afterDialogShow(this);
        }

        public b(Context r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            super(r4, 0, true, 22);
        }
    }

    public static final class c implements pca.b {
        public final /* synthetic */ ShowAllDialogFragment a;

        public c(ShowAllDialogFragment r1) {
            this.a = r1;
        }

        @Override // pca.b
        public final void a(List<? extends Object> r5, Object r6, final int r7) {
            Intrinsics.checkNotNullParameter(r5, "entityGroup");
            Intrinsics.checkNotNullParameter(r6, "entity");
            if (com.obric.assistant.card.utils.b.b(r5, r6) == false) goto L6;
            return;
        L6:
            if ((r6 instanceof AppEntity) == false) goto L21;
            if ((r6 instanceof MusicEntity) == false) goto L19;
            NetEaseMusicManager r0 = NetEaseMusicManager.a;
            String r1 = this.a.g.e;
            MusicEntity r8 = (MusicEntity) r6;
            String r2 = r8.getId();
            r0.getClass();
            if (NetEaseMusicManager.d(r1, r2) == false) goto L12;
            NetEaseMusicManager.b(this.a.k, true, r7);
            return;
        L12:
            String r3 = this.a.g.e;
            ArrayList r4 = new ArrayList();
            Iterator<T> r9 = r5.iterator();
        L14:
            if (r9.hasNext() == false) goto L18;
            Object r10 = r9.next();
            if ((r10 instanceof MusicEntity) == false) goto L14;
            r4.add(r10);
            goto L14
        L18:
            MusicEntity[] r11 = (MusicEntity[]) r4.toArray(new MusicEntity[0]);
            final ShowAllDialogFragment r12 = this.a;
            NetEaseMusicManager.f(r3, r11, r8, new o(r12, r7));
            return;
        L19:
            com.obric.assistant.card.utils.b.c((AppEntity) r6);
            return;
        L21:
            if ((r6 instanceof mca.b) == false) goto L27;
            T r13 = ((mca.b) r6).a;
            if ((r13 instanceof AppEntity) == false) goto L25;
            com.obric.assistant.card.utils.b.c((AppEntity) r13);
            return;
        L25:
            FLogger.a.e("ShowAllDialogFragment", "onItemClick: entity is not AppEntity");
            return;
        L27:
            if ((r6 instanceof CardProvider) == false) goto L29;
            FLogger.a.i("ShowAllDialogFragment", "clicked remote card cardUri = " + ((CardProvider) r6).getCardUri());
            return;
        L29:
            FLogger.a.e("ShowAllDialogFragment", "onItemClick: entity is not AppEntity");
        }
    }

    public static final class d implements com.obric.assistant.chat.api.b {
        public final /* synthetic */ ShowAllDialogFragment a;

        public d(ShowAllDialogFragment r1) {
            this.a = r1;
        }

        public final void a(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            ShowAllDialogFragment.S90(this.a, r2);
        }

        public final void b(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void c(Message r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            ShowAllDialogFragment r0 = this.a;
            int r1 = ShowAllDialogFragment.n;
            if (ShowAllDialogFragment.V90(r4, r0.g.e) == false) goto L5;
        L8:
            boolean r5 = true;
        L9:
            if (r5 == false) goto L31;
            ShowAllDialogFragment r6 = this.a;
            r6.getClass();
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
            if (r6.isAdded() == true) goto L29;
        L19:
            Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        L23:
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L32;
            FLogger.a.w("ShowAllDialogFragment", "dismiss failed: " + r8.getMessage(), r8);
            return;
        L32:
            return;
        L29:
            r6.dismissAllowingStateLoss();     // Catch: Exception -> L15 Throwable -> L21
        L15:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L21
            Throwable r9 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L21
            if (r9 == null) goto L19;
            com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r7 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        L31:
            return;
        L5:
            if (ShowAllDialogFragment.V90(r4, r0.h) == true) goto L8;
            r5 = false;
            goto L9
        }

        public final void d(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            ShowAllDialogFragment.S90(this.a, r2);
        }

        public final void e(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            ShowAllDialogFragment.S90(this.a, r2);
        }
    }

    static {
    }

    public final void onDestroy() {
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 == null) goto L5;
        r0.l();
        MessageObserverImpl.a.g(this.m);
    L5:
        this.e = null;
        super/*androidx.fragment.app.Fragment*/.onDestroy();
    }

    public final void onStop() {
        ViewAllBounceRecyclerView r0 = this.d;
        if (r0 == null) goto L7;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L6:
        r0.r();
    L7:
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public ShowAllDialogFragment() {
        this.g = new MessageExtraForViewHolder(false, false, null, null, null, null, null, 127);
        this.h = NameKeys.UnloadStrategy_No_Strategy;
        this.i = NameKeys.UnloadStrategy_No_Strategy;
        this.j = NameKeys.UnloadStrategy_No_Strategy;
        this.k = new Bundle();
        this.l = LazyKt.lazy(new i(this));
        this.m = new d(this);
    }

    public static final void T90(ShowAllDialogFragment r9) {
        String r0 = r9.g.e;
        boolean r2 = false;
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0 = r9.h;
    L9:
        if (r0.length() != 0) goto L11;
        r2 = true;
    L11:
        if (r2 == true) goto L15;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new ShowAllDialogFragment$refreshLatestMessage$1(r9, r0, null), 3, null);
        return;
    L15:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static final void U90(ShowAllDialogFragment r3) {
        boolean r1 = true;
        if (r3.g.e.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        IObricChatService.a.getClass();
        IObricChatService r2 = IObricChatService.a.a();
        if (r2 == null) goto L17;
        r2.l();
        MessageObserverImpl.a.f(r3.m);
        return;
    L17:
        return;
    L8:
        if (r3.h.length() == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.obric.assistant.card.ShowAllDialogFragment$ViewAllBounceRecyclerView] */
    public final Dialog onCreateDialog(Bundle r15) {
        Context r16 = requireContext();
        Context r0 = requireContext();
        int r1 = getResources().getDimensionPixelSize(2131166264);
        int r2 = getResources().getDimensionPixelSize(2131166264);
        ?? r3 = new ViewAllBounceRecyclerView(this, r0);
        r3.setId(2131375799);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        boolean r4 = false;
        r3.setClipToPadding(false);
        r3.setPadding(r1, r2, r1, 0);
        r3.setLayoutManager(new LinearLayoutManager(r0, 1, false));
        r3.setAdapter((AppEntityListAdapter) this.l.getValue());
        this.d = r3;
        final OSheetBase r5 = new b(r16);
        this.e = r5;
        Intrinsics.checkNotNullParameter(r5, "this");
        ((OSheet) r5).r = true;
        r5.getScaffoldController().l = true;
        OSheet.Header r6 = OSheet.Header.MODAL;
        Bundle r17 = getArguments();
        if (r17 == null) goto L22;
        Integer r18 = Integer.valueOf(r17.getInt("title", 0));
        if (r18.intValue() == 0) goto L7;
        r4 = true;
    L7:
        if (r4 == true) goto L10;
        r18 = null;
    L10:
        if (r18 == null) goto L22;
        int r19 = r18.intValue();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        Object r110 = Result.constructor-impl(getString(r19));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r110) == false) goto L19;
        r110 = null;
    L19:
        String r111 = (String) r110;
        if (r111 == null) goto L22;
    L23:
        OSheetBase.DefaultImpls.o(r5, r6, null, r111, null, false, null, new j(r5), 16134);
        RecyclerView r112 = this.d;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r112 = null;
    L26:
        OSheetBase.DefaultImpls.j(r5, r112);
        Bundle r113 = getArguments();
        if (r113 == null) goto L29;
        String r114 = r113.getString("message_id");
    L30:
        String r8 = NameKeys.UnloadStrategy_No_Strategy;
        if (r114 != null) goto L33;
        r114 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        this.h = r114;
        Bundle r115 = getArguments();
        if (r115 == null) goto L36;
        String r116 = r115.getString("widget_id");
    L37:
        if (r116 != null) goto L39;
        r116 = NameKeys.UnloadStrategy_No_Strategy;
    L39:
        this.i = r116;
        Bundle r117 = getArguments();
        if (r117 == null) goto L42;
        String r118 = r117.getString("mixture_card_id");
    L43:
        if (r118 == null) goto L46;
        r8 = r118;
    L46:
        this.j = r8;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ShowAllDialogFragment$loadInitialData$1(this, null), 3, null);
        return r5;
    L42:
        r118 = null;
        goto L43
    L36:
        r116 = null;
        goto L37
    L29:
        r114 = null;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r110 = Result.constructor-impl(ResultKt.createFailure(th));
    L22:
        r111 = getString(2131912197);
        goto L23
    }

    public final void onDismiss(DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r3, "dialog");     // Catch: Throwable -> L8
        IObricChatService.a.getClass();     // Catch: Throwable -> L8
        IObricChatService r0 = IObricChatService.a.a();     // Catch: Throwable -> L8
        if (r0 == null) goto L5;
        r0.l();     // Catch: Throwable -> L8
        MessageObserverImpl.a.g(this.m);     // Catch: Throwable -> L8
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r3);     // Catch: Throwable -> L8
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L8:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public static final void S90(final ShowAllDialogFragment r17, Message r18) {
        boolean r3 = false;
        if (V90(r18, r17.g.e) == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        return;
    L12:
        if (r17.i.length() != 0) goto L14;
        boolean r4 = true;
    L15:
        Pair r5 = null;
        if (r4 == true) goto L18;
    L22:
        Intrinsics.checkNotNullParameter(r18, "<this>");
        List r6 = (List) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r.a(r18)), new k()), new l(r17)));
    L23:
        if (r6 == null) goto L28;
        String r7 = r18.getLocalMessageId();
        if (r7 != null) goto L27;
        r7 = NameKeys.UnloadStrategy_No_Strategy;
    L27:
        r5 = TuplesKt.to(new MessageExtraForViewHolder(false, false, null, null, r7, null, r18.getExt(), 47), r6);
    L48:
        if (r5 == null) goto L56;
        r17.W90((MessageExtraForViewHolder) r5.getFirst(), (List) r5.getSecond());
        return;
    L56:
        return;
    L28:
        xca.b.a.getClass();
        AppIntentMessage r8 = xca.b.a.a(r18);
        if (r8 == null) goto L48;
        List<Parcelable> r9 = com.obric.assistant.card.utils.c.d(r8);
        if (r9 != null) goto L33;
        r9 = CollectionsKt.emptyList();
    L33:
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L35:
        if (r11.hasNext() == false) goto L46;
        AppEntity r12 = (Parcelable) r11.next();
        if ((r12 instanceof AppIntentCardData) == false) goto L40;
        AppIntentCardData r13 = (AppIntentCardData) r12;
    L43:
        if (r13 == null) goto L35;
        r10.add(r13);
        goto L35
    L40:
        if ((r12 instanceof AppEntity) == false) goto L42;
        AppEntity r14 = r12;
        AppIntentCardData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r14, "appEntity");
        r13 = new AppIntentCardData(0, r14, null, false, false, 28, null);
        goto L43
    L42:
        r13 = null;
        goto L43
    L46:
        if ((!r10.isEmpty()) == false) goto L48;
        r5 = TuplesKt.to(com.obric.assistant.card.utils.c.a(r8, r18), r10);
        goto L48
    L18:
        if (r17.j.length() != 0) goto L20;
        r3 = true;
    L20:
        if (r3 == false) goto L22;
        r6 = null;
        goto L23
    L14:
        r4 = false;
        goto L15
    L5:
        if (V90(r18, r17.h) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static boolean V90(Message r3, String r4) {
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r3.getLocalMessageId(), r4) == false) goto L10;
    L11:
        return true;
    L10:
        if (Intrinsics.areEqual(r3.getMessageId(), r4) == true) goto L11;
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final void W90(MessageExtraForViewHolder r17, List<AppIntentCardData> r18) {
        ViewAllBounceRecyclerView r0 = this.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r0 = null;
    L5:
        r0.r();
        this.g = r17;
        ArrayList r11 = new ArrayList();
        Iterator<T> r1 = r18.iterator();
    L7:
        if (r1.hasNext() == false) goto L12;
        Object r2 = com.obric.assistant.card.utils.c.c((AppIntentCardData) r1.next());
        if (r2 == null) goto L7;
        r11.add(r2);
        goto L7
    L12:
        if ((!r11.isEmpty()) == true) goto L14;
    L25:
        boolean r3 = false;
    L26:
        int r4 = 2131166264;
        int r5 = getResources().getDimensionPixelSize(2131166264);
        Resources r6 = getResources();
        if (r3 == false) goto L29;
        r4 = 2131165846;
    L29:
        int r7 = r6.getDimensionPixelSize(r4);
        int r8 = getResources().getDimensionPixelSize(2131165925);
        b r9 = this.e;
        if (r9 == null) goto L32;
        ((OSheet) r9).v = r7;
    L32:
        if (r9 == null) goto L34;
        ((OSheet) r9).w = r8;
    L34:
        X90(r9, this, r5, r7, r8);
        if (r9 == null) goto L52;
        FrameLayout r10 = r9.getHeaderContainer();
        if (r10 == null) goto L52;
        if (r10.getMeasuredHeight() != 0) goto L41;
        boolean r12 = true;
    L42:
        if (r12 == false) goto L44;
        FrameLayout r15 = r10;
    L45:
        if (r15 == null) goto L52;
        if (r15.isLaidOut() == true) goto L49;
    L51:
        r15.addOnLayoutChangeListener(new p(r9, this, r5, r7, r8));
        goto L52
    L49:
        if (r15.isLayoutRequested() == true) goto L51;
        X90(r9, this, r5, r7, r8);
        goto L52
    L44:
        r15 = null;
        goto L45
    L41:
        r12 = false;
    L52:
        ((AppEntityListAdapter) this.l.getValue()).A2(r17, r18, Integer.MAX_VALUE);
        ((AppEntityListAdapter) this.l.getValue()).notifyDataSetChanged();
        boolean r13 = com.obric.assistant.card.utils.b.d(r11);
        if ((!r11.isEmpty()) == true) goto L55;
    L66:
        boolean r14 = false;
    L67:
        DividerItemMarginDecoration r16 = this.f;
        if (r16 == null) goto L74;
        ViewAllBounceRecyclerView r19 = this.d;
        if (r19 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r19 = null;
    L72:
        r19.removeItemDecoration(r16);
    L74:
        if (r11.isEmpty() == true) goto L82;
        Iterator r20 = r11.iterator();
    L78:
        if (r20.hasNext() == false) goto L82;
        if ((r20.next() instanceof MusicEntity) == false) goto L78;
        boolean r21 = true;
    L84:
        if (r21 == false) goto L95;
        RecyclerView r22 = this.d;
        if (r22 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r22 = null;
    L88:
        int r23 = r22.getContext().getResources().getDimensionPixelSize(2131165850);
        RecyclerView r24 = this.d;
        if (r24 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r24 = null;
    L91:
        int r25 = r24.getContext().getResources().getColor(2131103685);
        RecyclerView r26 = this.d;
        if (r26 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r26 = null;
    L94:
        DividerItemMarginDecoration r27 = new DividerItemMarginDecoration(r23, r25, r26.getContext().getResources().getDimensionPixelSize(2131166280), 0);
    L114:
        this.f = r27;
        ViewAllBounceRecyclerView r28 = this.d;
        if (r28 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r28 = null;
    L117:
        r28.addItemDecoration(r27);
        ArrayList r29 = new ArrayList();
        Iterator r30 = r11.iterator();
    L119:
        if (r30.hasNext() == false) goto L123;
        Object r31 = r30.next();
        if ((r31 instanceof PhotoEntity) == false) goto L119;
        r29.add(r31);
        goto L119
    L123:
        List r32 = CollectionsKt.take(r29, 12);
        if (r32.isEmpty() == true) goto L150;
        Context r33 = getContext();
        if (r33 == null) goto L151;
        AlbumGridViewHolder.Companion r34 = AlbumGridViewHolder.p;
        Intrinsics.checkNotNullParameter(r33, "context");
        Resources r35 = r33.getResources();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ShowAllDialogFragment$prefetchFirstScreenPhotos$1(RangesKt.coerceAtLeast(WindowDisplayMetricsOverride.apply(r35, r35.getDisplayMetrics()).widthPixels / 3, 1), r32, null), 3, null);
        return;
    L151:
        return;
    L150:
        return;
    L95:
        RecyclerView r36 = this.d;
        if (r36 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r36 = null;
    L98:
        int r37 = r36.getContext().getResources().getDimensionPixelSize(2131165850);
        RecyclerView r38 = this.d;
        if (r38 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r38 = null;
    L101:
        int r39 = r38.getContext().getResources().getColor(2131103685);
        RecyclerView r40 = this.d;
        if (r40 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r40 = null;
    L104:
        Resources r41 = r40.getContext().getResources();
        if (r13 == true) goto L109;
        if (r14 == true) goto L109;
        int r42 = 2131166241;
    L110:
        int r43 = r41.getDimensionPixelSize(r42);
        RecyclerView r44 = this.d;
        if (r44 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r44 = null;
    L113:
        r27 = new DividerItemMarginDecoration(r37, r39, r43, r44.getContext().getResources().getDimensionPixelSize(2131165925));
    L109:
        r42 = 2131165925;
    L82:
        r21 = false;
        goto L84
    L55:
        if (r11.isEmpty() == true) goto L63;
        Iterator r45 = r11.iterator();
    L59:
        if (r45.hasNext() == false) goto L63;
        if ((r45.next() instanceof CountdownEntity) == true) goto L59;
        boolean r46 = false;
    L64:
        if (r46 == false) goto L66;
        r14 = true;
    L63:
        r46 = true;
        goto L64
    L14:
        if (r11.isEmpty() == true) goto L22;
        Iterator r47 = r11.iterator();
    L18:
        if (r47.hasNext() == false) goto L22;
        if ((r47.next() instanceof AlarmEntity) == true) goto L18;
        boolean r48 = false;
    L23:
        if (r48 == false) goto L25;
        r3 = true;
    L22:
        r48 = true;
        goto L23
    }

    public static final void X90(OSheet r2, ShowAllDialogFragment r3, int r4, int r5, int r6) {
        int r0 = 0;
        if (r2 != null) goto L5;
    L9:
        RecyclerView r7 = r3.d;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r7 = null;
    L12:
        r7.setPadding(r4, r5 + r0, r4, r6);
        return;
    L5:
        if (r2.x == false) goto L9;
        if (r2.getHeaderContainer().getVisibility() != 0) goto L9;
        r0 = r2.getHeaderContainer().getMeasuredHeight();
        goto L9
    }
}
