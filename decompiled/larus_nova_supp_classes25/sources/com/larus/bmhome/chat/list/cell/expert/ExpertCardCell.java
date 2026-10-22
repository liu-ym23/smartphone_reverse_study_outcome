package com.larus.bmhome.chat.list.cell.expert;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.h0;
import com.larus.bmhome.chat.api.j0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.helper.b1;
import com.larus.bmhome.chat.layout.holder.helper.o;
import com.larus.bmhome.chat.layout.item.ExpertCardBox;
import com.larus.bmhome.chat.layout.item.x;
import com.larus.bmhome.chat.layout.item.y;
import com.larus.bmhome.chat.layout.item.z;
import com.larus.bmhome.chat.list.cell.search.SearchListCell$b;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.chat.search.LruSet;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.o0;
import ic8.n;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import oi8.f;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/list/cell/expert/ExpertCardCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/expert/ExpertCardCellState;", "<init>", "()V", "expertCardBox", "Lcom/larus/bmhome/chat/layout/item/ExpertCardBox;", "onCreateBoxView", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "setHolderFullVisibleStatus", "fullVisible", "", "lifecycleListener", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/bmhome/chat/list/cell/search/SearchListCell$ViewLifecycleListener;", "addViewLifecycleListener", "listener", "removeLifecycleListener", "clearLifecycleListener", "onViewRecycled", "onViewAttachedToWindow", "onViewDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ExpertCardCell extends BaseMessageListCell<a> {
    public ExpertCardBox e;
    public final CopyOnWriteArrayList<SearchListCell$b> f;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.expert.ExpertCardCell$onBindView$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.expert.ExpertCardCell$onBindView$1", f = "ExpertCardCell.kt", i = {}, l = {35, MessageCellStateTransformerType.EDU_CONTINUE_SHOT}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<BotModel> $bot;
        final /* synthetic */ Message $data;
        int label;
        final /* synthetic */ ExpertCardCell this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.expert.ExpertCardCell$onBindView$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
        @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.expert.ExpertCardCell$onBindView$1$1", f = "ExpertCardCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<BotModel> $bot;
            final /* synthetic */ Message $data;
            int label;
            final /* synthetic */ ExpertCardCell this$0;

            public C00651(ExpertCardCell r1, Message r2, Ref.ObjectRef<BotModel> r3, Continuation<? super C00651> r4) {
                this.this$0 = r1;
                this.$data = r2;
                this.$bot = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00651(this.this$0, this.$data, this.$bot, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r28) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L118;
                ResultKt.throwOnFailure(r28);
                ExpertCardCell r1 = this.this$0;
                final ExpertCardBox r8 = r1.e;
                if (r8 == null) goto L116;
                final Message r15 = this.$data;
                final BotModel r14 = (BotModel) this.$bot.element;
                final q0 r2 = lf8.a.b(r1);
                Intrinsics.checkNotNullParameter(r15, "message");
                Intrinsics.checkNotNullParameter(r14, "bot");
                int r3 = ExpertCardBox.b.b;
                ExpertCardBox.b r4 = ExpertCardBox.b.a.a(r15.getContent());
                if (r4 != null) goto L9;
                r4 = new ExpertCardBox.b(null);
            L9:
                ExpertCardBox.b r5 = r8.p;
                if (r5 == null) goto L12;
                Boolean r6 = Boolean.valueOf(r5.a);
            L13:
                ExpertCardBox.b r7 = r8.p;
                if (r7 == null) goto L18;
                List<ExpertCardBox.c> r9 = r7.a();
                if (r9 == null) goto L18;
                int r10 = r9.size();
            L19:
                r8.p = r4;
                boolean r11 = Intrinsics.areEqual(r8.q, r15.getMessageId());
                r8.q = r15.getMessageId();
                final ExpertCardBox.b r12 = r8.p;
                if (r12 == null) goto L116;
                if (r15.getMessageStatusLocal() != 22) goto L24;
            L29:
                boolean r24 = true;
            L30:
                if (r24 == true) goto L42;
                List<ExpertCardBox.c> r13 = r12.a();
                if (r13 == null) goto L36;
                ExpertCardBox.c r16 = (ExpertCardBox.c) CollectionsKt.lastOrNull(r13);
                if (r16 == null) goto L36;
                boolean r17 = Intrinsics.areEqual(r16.k(), Boolean.TRUE);
            L37:
                if (r17 == true) goto L42;
                CoroutineScope r18 = ExpertSwitchManager.a;
                if (FeatureKitDelegate.b.e0().b() == true) goto L42;
                boolean r19 = false;
            L43:
                r12.a = r19;
                boolean r20 = r4.a;
                List<ExpertCardBox.c> r21 = r4.a();
                if (r21 == null) goto L46;
                int r22 = r21.size();
            L48:
                if (Intrinsics.areEqual(r6, Boolean.FALSE) == false) goto L51;
                if (r20 != true) goto L51;
                boolean r23 = true;
            L52:
                if (r22 <= r10) goto L54;
                boolean r25 = true;
            L55:
                if (r11 == false) goto L58;
                if (r23 == false) goto L58;
                boolean r26 = true;
            L59:
                if (r11 == false) goto L62;
                if (r25 == false) goto L62;
                boolean r110 = true;
            L63:
                RecyclerView r27 = r8.r.e;
                r27.setLayoutManager(new LinearLayoutManager(r27.getContext(), 1, false));
                if (r27.getAdapter() == null) goto L66;
                if (r11 == false) goto L66;
            L68:
                if (r12.a == false) goto L75;
                if (r26 == true) goto L75;
                if (r8.r.d.getLayoutParams().height == 0) goto L73;
                r8.r.d.getLayoutParams().height = 0;
                e1.o(r8.r.d);
            L73:
                r8.o(true);
            L78:
                if (r26 == false) goto L80;
                r8.postDelayed(new x(r8, r2, r15), 800);
            L80:
                TextView r29 = r8.r.f;
                if (r24 == false) goto L83;
                r29.setText(2131900841);
            L88:
                LinearLayout r30 = r8.r.c;
                e1.d(r30, new y(r2, r12, r14, r15, r8));
                if (r2 == null) goto L91;
                q0.a r31 = r2.getProvider();
            L92:
                final boolean r111 = r110;
                o r32 = new o(r15, r2, r31, null, null, null, null, 120);
                Intrinsics.checkNotNull(r30);
                b1.a(r32, r30);
                int r33 = f.a;
                if (r2 == null) goto L95;
                LruSet<String> r34 = r2.E7();
            L96:
                if (r2 == null) goto L98;
                ChatParam r112 = r2.getChatParam();
            L99:
                String r35 = r14.getBotId();
                if (r35 != null) goto L102;
                r35 = "";
            L102:
                String r113 = r35;
                if (r12.a == false) goto L105;
                String r36 = "folded";
            L106:
                f.k(r34, r15, r112, 0, 0, null, null, "expert", r113, r36, "expert", 0, 0, null, 14432);
                List<ExpertCardBox.c> r114 = r12.a();
                if (r114 == null) goto L113;
                ExpertCardBox.c r37 = (ExpertCardBox.c) CollectionsKt.lastOrNull(r114);
                if (r37 == null) goto L114;
                if (r24 == false) goto L112;
                r37.b = true;
                goto L114
            L112:
                r37.a = true ^ Intrinsics.areEqual(r37.k(), Boolean.TRUE);
            L114:
                ExpertCardBox.StepAdapter r38 = r8.r.e.getAdapter();
                Intrinsics.checkNotNull(r38, "null cannot be cast to non-null type com.larus.bmhome.chat.layout.item.ExpertCardBox.StepAdapter");
                r38.submitList(r114, new z(r111, r2, r8));
                goto L116
            L113:
                r114 = null;
                goto L114
            L105:
                r36 = "unfolded";
                goto L106
            L98:
                r112 = null;
                goto L99
            L95:
                r34 = null;
                goto L96
            L91:
                r31 = null;
                goto L92
            L83:
                List<ExpertCardBox.c> r39 = r12.a();
                if (r39 == null) goto L86;
                int r40 = r39.size();
            L87:
                r29.setText(r29.getContext().getResources().getQuantityString(2131755153, r40, new Object[]{String.valueOf(r40)}));
                goto L88
            L86:
                r40 = 1;
            L75:
                if (r8.r.d.getLayoutParams().height == (-2)) goto L77;
                r8.r.d.getLayoutParams().height = -2;
                r8.r.d.requestLayout();
                e1.x(r8.r.d);
            L77:
                r8.o(false);
            L66:
                r27.setAdapter(new ExpertCardBox.StepAdapter(r2, r15, r14));
            L62:
                r110 = false;
            L58:
                r26 = false;
                goto L59
            L54:
                r25 = false;
            L51:
                r23 = false;
                goto L52
            L46:
                r22 = 0;
            L36:
                r17 = false;
            L42:
                r19 = true;
                goto L43
            L24:
                if (r15.getMessageStatusLocal() == 13) goto L29;
                if (r15.getMessageStatusLocal() == 23) goto L29;
                r24 = false;
            L18:
                r10 = 0;
                goto L19
            L12:
                r6 = null;
            L116:
                return Unit.INSTANCE;
            L118:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(Ref.ObjectRef<BotModel> r1, ExpertCardCell r2, Message r3, Continuation<? super AnonymousClass1> r4) {
            this.$bot = r1;
            this.this$0 = r2;
            this.$data = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$bot, this.this$0, this.$data, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r75) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r75);
        L35:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r75);
            Object r3 = r75;
        L22:
            List r4 = (List) r3;
            if (r4 == null) goto L25;
            String r5 = (String) CollectionsKt.firstOrNull(r4);
        L26:
            if (r5 != null) goto L28;
            r5 = "";
        L28:
            String r7 = r5;
            if (o0.d(r7) == false) goto L31;
            Ref.ObjectRef<BotModel> r6 = this.$bot;
            r6.element = BotModel.copy$default((BotModel) r6.element, r7, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        L31:
            MainCoroutineDispatcher r8 = Dispatchers.getMain();
            C00651 r9 = new C00651(this.this$0, this.$data, this.$bot, null);
            this.label = 2;
            if (BuildersKt.withContext(r8, r9, this) != r1) goto L35;
            return r1;
        L25:
            r5 = null;
            goto L26
        L10:
            ResultKt.throwOnFailure(r75);
            if (Intrinsics.areEqual(((BotModel) this.$bot.element).getBotId(), "unknown") == false) goto L31;
            q0 r10 = lf8.a.b(this.this$0);
            if (r10 == null) goto L17;
            h0 r11 = r10.A7();
            if (r11 == null) goto L17;
            e r12 = (e) r11.invoke();
        L18:
            if (r12 == null) goto L25;
            this.label = 1;
            r3 = n.c(r12, this);
            if (r3 != r1) goto L22;
            return r1;
        L17:
            r12 = null;
            goto L18
        }
    }

    public final void onViewAttachedToWindow() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SearchListCell$b) r0.next()).getClass();
        goto L4
    }

    public final void onViewDetachedFromWindow() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SearchListCell$b) r0.next()).a();
        goto L4
    }

    public final void onViewRecycled() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((SearchListCell$b) r0.next()).getClass();
        goto L4
    L6:
        this.f.clear();
    }

    public ExpertCardCell() {
        this.f = new CopyOnWriteArrayList();
    }

    public final View m(Context r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        ExpertCardBox r4 = new ExpertCardBox(r1);
        r4.setBoxType(r3);
        this.e = r4;
        return r4;
    }

    public final void onBindView(View r72, ei9.f r73, int r74) {
        a r0 = (a) r73;
        Intrinsics.checkNotNullParameter(r72, "view");
        Intrinsics.checkNotNullParameter(r0, "state");
        Message r1 = r0.a;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        q0 r3 = lf8.a.b(this);
        if (r3 == null) goto L10;
        q0.a r4 = r3.getProvider();
        if (r4 == null) goto L10;
        com.larus.bmhome.chat.component.cvs.y r5 = r4.u0();
        if (r5 == null) goto L10;
        BotModel r6 = r5.j0();
        if (r6 == null) goto L10;
    L11:
        r2.element = r6;
        q0 r7 = lf8.a.b(this);
        if (r7 == null) goto L19;
        j0 r8 = r7.y7();
        if (r8 == null) goto L19;
        CoroutineScope r9 = (CoroutineScope) r8.invoke();
        if (r9 == null) goto L19;
        BuildersKt.launch$default(r9, null, null, new AnonymousClass1(r2, this, r1, null), 3, null);
        return;
    L19:
        return;
    L10:
        r6 = new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
        goto L11
    }
}
