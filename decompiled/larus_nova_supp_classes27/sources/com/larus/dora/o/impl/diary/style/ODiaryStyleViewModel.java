package com.larus.dora.o.impl.diary.style;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.dora.o.impl.diary.DoraODiaryRepo;
import com.larus.dora.o.impl.diary.t0;
import com.larus.dora.o.impl.diary.u0;
import com.larus.dora.o.impl.diary.v0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0004)*+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\"\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018J*\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018J2\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\u0018J\"\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u0018J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001cJ\u001d\u0010\"\u001a\u00020\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020$0\u0018H\u0082\bJ\f\u0010%\u001a\u00020\u0011*\u00020&H\u0002J\u000e\u0010'\u001a\u00020\u0019*\u0004\u0018\u00010(H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_listState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$ListState;", "listState", "Lkotlinx/coroutines/flow/StateFlow;", "getListState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadingList", "", "loadStyles", "", "currentStyles", "", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$StyleUiItem;", "maxCustomCount", "", "customCount", "selectStyle", "item", "onResult", "Lkotlin/Function1;", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$OpResult;", "createCustomStyle", "title", "", "prompt", "updateCustomStyle", "deleteCustomStyle", "nextDefaultNameIndex", "prefix", "mutateContent", "block", "Lcom/larus/dora/o/impl/diary/style/ODiaryStyleViewModel$ListState$Content;", "toUiItem", "Lcom/larus/dora/o/impl/diary/ODiaryStyleInfo;", "toOpResult", "Lcom/larus/dora/o/impl/diary/ODiaryStyleOpData;", "Companion", "StyleUiItem", "ListState", "OpResult", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryStyleViewModel extends ViewModel {
    private static final String CREATE_STYLE_ID = "0";
    public static final a Companion = null;
    private static final int DEFAULT_MAX_COUNT = 30;
    private static final int STYLE_TYPE_CUSTOM = 1;
    private static final int STYLE_TYPE_PRESET = 0;
    private static final String TAG = "ODiaryStyleViewModel";
    private final z0<b> _listState;
    private final i1<b> listState;
    private boolean loadingList;

    public static final class a {
        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final List<d> a;
            public final int b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b;
            }

            public final String toString() {
                return "Content(styles=" + this.a + ", maxCount=" + this.b + ')';
            }

            public a(List<d> r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, "styles");
                this.a = r2;
                this.b = r3;
            }

            public static a a(a r1, List r2) {
                int r3 = r1.b;
                Intrinsics.checkNotNullParameter(r2, "styles");
                return new a(r2, r3);
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$b$b, reason: collision with other inner class name */
        public static final class C0095b extends b {
            public static final C0095b a = null;

            static {
                a = new C0095b();
            }

            public C0095b() {
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public b() {
        }
    }

    public static abstract class c {

        public static final class a extends c {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "Failed(tips=" + this.a + ')';
            }

            public a(String r1) {
                this.a = r1;
            }
        }

        public static final class b extends c {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public c() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$createCustomStyle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$createCustomStyle$1", f = "ODiaryStyleViewModel.kt", i = {0}, l = {118}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<c, Unit> $onResult;
        final /* synthetic */ String $prompt;
        final /* synthetic */ String $title;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryStyleViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$createCustomStyle$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$createCustomStyle$1$2", f = "ODiaryStyleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<c, Unit> $onResult;
            final /* synthetic */ c $result;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function1<? super c, Unit> r1, c r2, Continuation<? super AnonymousClass2> r3) {
                this.$onResult = r1;
                this.$result = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.$onResult, this.$result, r4);
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
                this.$onResult.invoke(this.$result);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String r1, String r2, ODiaryStyleViewModel r3, Function1<? super c, Unit> r4, Continuation<? super AnonymousClass1> r5) {
            this.$prompt = r1;
            this.$title = r2;
            this.this$0 = r3;
            this.$onResult = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$prompt, this.$title, this.this$0, this.$onResult, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r22);
            Object r4 = r22;
            CoroutineScope r5 = r3;
        L12:
            v0 r6 = (v0) r4;
            c r7 = ODiaryStyleViewModel.access$toOpResult(this.this$0, r6);
            if ((r7 instanceof c.b) == false) goto L33;
            if (r6 == null) goto L18;
            t0 r8 = r6.b();
            if (r8 == null) goto L18;
            d r9 = ODiaryStyleViewModel.access$toUiItem(this.this$0, r8);
        L19:
            if (r9 == null) goto L32;
            ODiaryStyleViewModel r10 = this.this$0;
            Object r11 = ODiaryStyleViewModel.access$get_listState$p(r10).getValue();
            if ((r11 instanceof b.a) == false) goto L23;
            b.a r13 = (b.a) r11;
        L24:
            if (r13 == null) goto L31;
            z0 r12 = ODiaryStyleViewModel.access$get_listState$p(r10);
            List<d> r14 = r13.a;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r16 = r14.iterator();
        L28:
            if (r16.hasNext() == false) goto L30;
            r15.add(d.a((d) r16.next(), null, null, false, false, 47));
            goto L28
        L30:
            r12.setValue(b.a.a(r13, CollectionsKt.plus(r15, d.a(r9, null, null, true, true, 15))));
        L31:
            FLogger.a.i(ODiaryStyleViewModel.TAG, "createCustomStyle success: " + r9.a);
        L34:
            BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AnonymousClass2(this.$onResult, r7, null), 2, null);
            return Unit.INSTANCE;
        L23:
            r13 = null;
            goto L24
        L32:
            this.this$0.loadStyles();
        L18:
            r9 = null;
            goto L19
        L33:
            FLogger.a.e(ODiaryStyleViewModel.TAG, "createCustomStyle failed");
            goto L34
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r22);
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            DoraODiaryRepo r18 = DoraODiaryRepo.a;
            t0 r110 = new t0(Boxing.boxInt(1), this.$prompt, this.$title, ODiaryStyleViewModel.CREATE_STYLE_ID, null, Boxing.boxBoolean(true));
            this.L$0 = r17;
            this.label = 1;
            r4 = r18.h(r110, this);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r5 = r17;
            goto L12
        }
    }

    public static final class d {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final boolean e;
        public final boolean f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            int r4 = 1231;
            if (this.e == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.f == true) goto L15;
            r4 = 1237;
        L15:
            return r6 + r4;
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "StyleUiItem(id=" + this.a + ", title=" + this.b + ", prompt=" + this.c + ", icon=" + this.d + ", isSelected=" + this.e + ", isCustom=" + this.f + ')';
        }

        public d(String r2, String r3, String r4, String r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "title");
            Intrinsics.checkNotNullParameter(r4, "prompt");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public static d a(d r9, String r10, String r11, boolean r12, boolean r13, int r14) {
            String r1 = null;
            if ((r14 & 1) == 0) goto L5;
            String r3 = r9.a;
        L7:
            if ((r14 & 2) == 0) goto L9;
            r10 = r9.b;
        L9:
            String r4 = r10;
            if ((r14 & 4) == 0) goto L12;
            r11 = r9.c;
        L12:
            String r5 = r11;
            if ((r14 & 8) == 0) goto L15;
            r1 = r9.d;
        L15:
            String r6 = r1;
            if ((r14 & 16) == 0) goto L18;
            r12 = r9.e;
        L18:
            boolean r7 = r12;
            if ((r14 & 32) == 0) goto L21;
            r13 = r9.f;
        L21:
            r9.getClass();
            Intrinsics.checkNotNullParameter(r3, "id");
            Intrinsics.checkNotNullParameter(r4, "title");
            Intrinsics.checkNotNullParameter(r5, "prompt");
            return new d(r3, r4, r5, r6, r7, r13);
        L5:
            r3 = null;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$deleteCustomStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$deleteCustomStyle$1", f = "ODiaryStyleViewModel.kt", i = {0}, l = {186}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C04471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $item;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryStyleViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$deleteCustomStyle$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$deleteCustomStyle$1$2", f = "ODiaryStyleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $onResult;
            final /* synthetic */ boolean $success;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function1<? super Boolean, Unit> r1, boolean r2, Continuation<? super AnonymousClass2> r3) {
                this.$onResult = r1;
                this.$success = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.$onResult, this.$success, r4);
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
                this.$onResult.invoke(Boxing.boxBoolean(this.$success));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C04471(d r1, ODiaryStyleViewModel r2, Function1<? super Boolean, Unit> r3, Continuation<? super C04471> r4) {
            this.$item = r1;
            this.this$0 = r2;
            this.$onResult = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C04471 r0 = new C04471(this.$item, this.this$0, this.$onResult, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r21) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r21);
            Object r4 = r21;
            CoroutineScope r5 = r3;
        L12:
            boolean r6 = ((Boolean) r4).booleanValue();
            if (r6 == false) goto L42;
            ODiaryStyleViewModel r7 = this.this$0;
            d r8 = this.$item;
            Object r9 = ODiaryStyleViewModel.access$get_listState$p(r7).getValue();
            if ((r9 instanceof b.a) == false) goto L17;
            b.a r10 = (b.a) r9;
        L18:
            if (r10 == null) goto L41;
            z0 r11 = ODiaryStyleViewModel.access$get_listState$p(r7);
            List<d> r12 = r10.a;
            ArrayList r13 = new ArrayList();
            Iterator<T> r14 = r12.iterator();
        L22:
            if (r14.hasNext() == false) goto L27;
            Object r15 = r14.next();
            if ((!Intrinsics.areEqual(((d) r15).a, r8.a)) == false) goto L22;
            r13.add(r15);
            goto L22
        L27:
            if (r8.e == false) goto L40;
            ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator r17 = r13.iterator();
            int r18 = 0;
        L30:
            if (r17.hasNext() == false) goto L39;
            Object r110 = r17.next();
            int r111 = r18 + 1;
            if (r18 >= 0) goto L34;
            CollectionsKt.throwIndexOverflow();
        L34:
            d r112 = (d) r110;
            if (r18 != 0) goto L37;
            boolean r113 = true;
        L38:
            r16.add(d.a(r112, null, null, r113, false, 47));
            r18 = r111;
            goto L30
        L37:
            r113 = false;
            goto L38
        L39:
            r13 = r16;
        L40:
            r11.setValue(b.a.a(r10, r13));
        L41:
            FLogger.a.i(ODiaryStyleViewModel.TAG, "deleteCustomStyle success: " + this.$item.a);
        L43:
            BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AnonymousClass2(this.$onResult, r6, null), 2, null);
            return Unit.INSTANCE;
        L17:
            r10 = null;
            goto L18
        L42:
            FLogger.a.e(ODiaryStyleViewModel.TAG, "deleteCustomStyle failed: " + this.$item.a);
            goto L43
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r21);
            CoroutineScope r20 = (CoroutineScope) this.L$0;
            DoraODiaryRepo r22 = DoraODiaryRepo.a;
            String r23 = this.$item.a;
            this.L$0 = r20;
            this.label = 1;
            r4 = r22.c(r23, this);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r5 = r20;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$loadStyles$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$loadStyles$1", f = "ODiaryStyleViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODiaryStyleViewModel this$0;

        public C04481(ODiaryStyleViewModel r1, Continuation<? super C04481> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04481(this.this$0, r3);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            u0 r7 = (u0) r6;
            ODiaryStyleViewModel.access$setLoadingList$p(this.this$0, false);
            if (r7 != null) goto L15;
            ODiaryStyleViewModel.access$get_listState$p(this.this$0).setValue(b.C0095b.a);
            FLogger.a.e(ODiaryStyleViewModel.TAG, "loadStyles failed");
            return Unit.INSTANCE;
        L15:
            List<t0> r2 = r7.b();
            if (r2 != null) goto L18;
            r2 = CollectionsKt.emptyList();
        L18:
            List r3 = CollectionsKt.filterNotNull(r2);
            ODiaryStyleViewModel r4 = this.this$0;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r8 = r3.iterator();
        L20:
            if (r8.hasNext() == false) goto L22;
            r5.add(ODiaryStyleViewModel.access$toUiItem(r4, (t0) r8.next()));
            goto L20
        L22:
            z0 r9 = ODiaryStyleViewModel.access$get_listState$p(this.this$0);
            Integer r10 = r7.a();
            if (r10 == null) goto L25;
            int r11 = r10.intValue();
        L26:
            r9.setValue(new b.a(r5, r11));
            FLogger.a.i(ODiaryStyleViewModel.TAG, "loadStyles success: " + r5.size() + " styles");
            return Unit.INSTANCE;
        L25:
            r11 = 30;
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            DoraODiaryRepo r12 = DoraODiaryRepo.a;
            this.label = 1;
            r6 = r12.g(this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$selectStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$selectStyle$1", f = "ODiaryStyleViewModel.kt", i = {0}, l = {92}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C04491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $item;
        final /* synthetic */ Function1<c, Unit> $onResult;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryStyleViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$selectStyle$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$selectStyle$1$2", f = "ODiaryStyleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<c, Unit> $onResult;
            final /* synthetic */ c $result;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function1<? super c, Unit> r1, c r2, Continuation<? super AnonymousClass2> r3) {
                this.$onResult = r1;
                this.$result = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.$onResult, this.$result, r4);
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
                this.$onResult.invoke(this.$result);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C04491(d r1, ODiaryStyleViewModel r2, Function1<? super c, Unit> r3, Continuation<? super C04491> r4) {
            this.$item = r1;
            this.this$0 = r2;
            this.$onResult = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C04491 r0 = new C04491(this.$item, this.this$0, this.$onResult, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r18);
            Object r4 = r18;
            CoroutineScope r5 = r3;
        L12:
            c r6 = ODiaryStyleViewModel.access$toOpResult(this.this$0, (v0) r4);
            if ((r6 instanceof c.b) == false) goto L26;
            ODiaryStyleViewModel r7 = this.this$0;
            d r8 = this.$item;
            Object r9 = ODiaryStyleViewModel.access$get_listState$p(r7).getValue();
            if ((r9 instanceof b.a) == false) goto L17;
            b.a r10 = (b.a) r9;
        L18:
            if (r10 == null) goto L25;
            z0 r11 = ODiaryStyleViewModel.access$get_listState$p(r7);
            List<d> r12 = r10.a;
            ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
            Iterator<T> r14 = r12.iterator();
        L22:
            if (r14.hasNext() == false) goto L24;
            d r15 = (d) r14.next();
            r13.add(d.a(r15, null, null, Intrinsics.areEqual(r15.a, r8.a), false, 47));
            goto L22
        L24:
            r11.setValue(b.a.a(r10, r13));
        L25:
            FLogger.a.i(ODiaryStyleViewModel.TAG, "selectStyle success: " + this.$item.a);
        L27:
            BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AnonymousClass2(this.$onResult, r6, null), 2, null);
            return Unit.INSTANCE;
        L17:
            r10 = null;
            goto L18
        L26:
            FLogger.a.e(ODiaryStyleViewModel.TAG, "selectStyle failed: " + this.$item.a);
            goto L27
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            CoroutineScope r16 = (CoroutineScope) this.L$0;
            DoraODiaryRepo r17 = DoraODiaryRepo.a;
            Integer r20 = Boxing.boxInt(this.$item.f ? 1 : 0);
            d r21 = this.$item;
            t0 r110 = new t0(r20, r21.c, r21.b, r21.a, r21.d, Boxing.boxBoolean(true));
            this.L$0 = r16;
            this.label = 1;
            r4 = r17.j(r110, this);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r5 = r16;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$updateCustomStyle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$updateCustomStyle$1", f = "ODiaryStyleViewModel.kt", i = {0}, l = {153}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C04501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ d $item;
        final /* synthetic */ Function1<c, Unit> $onResult;
        final /* synthetic */ String $prompt;
        final /* synthetic */ String $title;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryStyleViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$updateCustomStyle$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.o.impl.diary.style.ODiaryStyleViewModel$updateCustomStyle$1$2", f = "ODiaryStyleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<c, Unit> $onResult;
            final /* synthetic */ c $result;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function1<? super c, Unit> r1, c r2, Continuation<? super AnonymousClass2> r3) {
                this.$onResult = r1;
                this.$result = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.$onResult, this.$result, r4);
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
                this.$onResult.invoke(this.$result);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C04501(String r1, String r2, d r3, ODiaryStyleViewModel r4, Function1<? super c, Unit> r5, Continuation<? super C04501> r6) {
            this.$prompt = r1;
            this.$title = r2;
            this.$item = r3;
            this.this$0 = r4;
            this.$onResult = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            C04501 r7 = new C04501(this.$prompt, this.$title, this.$item, this.this$0, this.$onResult, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r110) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            Object r4 = r110;
            CoroutineScope r5 = r3;
        L12:
            v0 r6 = (v0) r4;
            c r7 = ODiaryStyleViewModel.access$toOpResult(this.this$0, r6);
            if ((r7 instanceof c.b) == false) goto L37;
            if (r6 == null) goto L20;
            t0 r8 = r6.b();
            if (r8 == null) goto L20;
            d r9 = ODiaryStyleViewModel.access$toUiItem(this.this$0, r8);
            if (r9 == null) goto L20;
            d r10 = d.a(r9, this.$title, this.$prompt, true, true, 9);
        L21:
            ODiaryStyleViewModel r11 = this.this$0;
            d r12 = this.$item;
            Object r13 = ODiaryStyleViewModel.access$get_listState$p(r11).getValue();
            if ((r13 instanceof b.a) == false) goto L24;
            b.a r14 = (b.a) r13;
        L25:
            if (r14 == null) goto L36;
            z0 r15 = ODiaryStyleViewModel.access$get_listState$p(r11);
            List<d> r16 = r14.a;
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator<T> r18 = r16.iterator();
        L29:
            if (r18.hasNext() == false) goto L35;
            d r111 = (d) r18.next();
            if (Intrinsics.areEqual(r111.a, r12.a) == false) goto L33;
            d r112 = r10;
        L34:
            r17.add(r112);
            goto L29
        L33:
            r112 = d.a(r111, null, null, false, false, 47);
            goto L34
        L35:
            r15.setValue(b.a.a(r14, r17));
        L36:
            FLogger.a.i(ODiaryStyleViewModel.TAG, "updateCustomStyle success: " + this.$item.a);
        L38:
            BuildersKt.launch$default(r5, Dispatchers.getMain(), null, new AnonymousClass2(this.$onResult, r7, null), 2, null);
            return Unit.INSTANCE;
        L24:
            r14 = null;
        L20:
            r10 = d.a(this.$item, this.$title, this.$prompt, true, false, 41);
            goto L21
        L37:
            FLogger.a.e(ODiaryStyleViewModel.TAG, "updateCustomStyle failed: " + this.$item.a);
            goto L38
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r20 = (CoroutineScope) this.L$0;
            DoraODiaryRepo r21 = DoraODiaryRepo.a;
            Integer r22 = Boxing.boxInt(1);
            String r23 = this.$prompt;
            String r24 = this.$title;
            d r25 = this.$item;
            t0 r113 = new t0(r22, r23, r24, r25.a, r25.d, Boxing.boxBoolean(true));
            this.L$0 = r20;
            this.label = 1;
            r4 = r21.j(r113, this);
            if (r4 != r1) goto L11;
            return r1;
        L11:
            r5 = r20;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    public final List<d> currentStyles() {
        Object r0 = this._listState.getValue();
        if ((r0 instanceof b.a) == false) goto L5;
        b.a r1 = (b.a) r0;
    L6:
        if (r1 == null) goto L10;
        List<d> r2 = r1.a;
        if (r2 == null) goto L10;
        return r2;
    L10:
        return CollectionsKt.emptyList();
    L5:
        r1 = null;
        goto L6
    }

    public final void loadStyles() {
        if (this.loadingList == false) goto L5;
        return;
    L5:
        this.loadingList = true;
        this._listState.setValue(b.c.a);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04481(this, null), 2, null);
    }

    public final int maxCustomCount() {
        Object r0 = this._listState.getValue();
        if ((r0 instanceof b.a) == false) goto L5;
        b.a r1 = (b.a) r0;
    L6:
        if (r1 != null) goto L10;
        return 30;
    L10:
        return r1.b;
    L5:
        r1 = null;
        goto L6
    }

    public ODiaryStyleViewModel() {
        StateFlowImpl r0 = j1.a(b.c.a);
        this._listState = r0;
        this.listState = r0;
    }

    public final int customCount() {
        List<d> r0 = currentStyles();
        int r2 = 0;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        if (((d) r1.next()).f == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        return r2;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final i1<b> getListState() {
        return this.listState;
    }

    public static final /* synthetic */ z0 access$get_listState$p(ODiaryStyleViewModel r0) {
        return r0._listState;
    }

    private final void mutateContent(Function1<? super b.a, b.a> r3) {
        Object r0 = access$get_listState$p(this).getValue();
        if ((r0 instanceof b.a) == false) goto L5;
        b.a r1 = (b.a) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        access$get_listState$p(this).setValue(r3.invoke(r1));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final c toOpResult(v0 r2) {
        if (r2 == null) goto L15;
        String r0 = r2.a();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        return new c.a(r2.a());
    L14:
        return c.b.a;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L15:
        return new c.a(null);
    }

    private final d toUiItem(t0 r9) {
        String r0 = r9.b();
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        String r1 = r9.d();
        if (r1 != null) goto L9;
        String r3 = "";
    L10:
        String r4 = r9.e();
        if (r4 != null) goto L13;
        String r5 = "";
    L14:
        String r6 = r9.a();
        boolean r7 = Intrinsics.areEqual(r9.f(), Boolean.TRUE);
        Integer r10 = r9.c();
        if (r10 != null) goto L18;
    L20:
        boolean r11 = false;
    L22:
        return new d(r2, r3, r5, r6, r7, r11);
    L18:
        if (r10.intValue() != 1) goto L20;
        r11 = true;
        goto L22
    L13:
        r5 = r4;
        goto L14
    L9:
        r3 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    public final int nextDefaultNameIndex(String r5) {
        Intrinsics.checkNotNullParameter(r5, "prefix");
        Regex r0 = new Regex("^" + Regex.Companion.escape(r5) + " (\\d+)$");
        List<d> r6 = currentStyles();
        ArrayList r1 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L15;
        MatchResult r2 = r0.matchEntire(StringsKt.trim(((d) r7.next()).b).toString());
        if (r2 == null) goto L12;
        List r3 = r2.getGroupValues();
        if (r3 == null) goto L12;
        String r4 = (String) CollectionsKt.getOrNull(r3, 1);
        if (r4 == null) goto L12;
        Integer r8 = StringsKt.toIntOrNull(r4);
    L13:
        if (r8 == null) goto L4;
        r1.add(r8);
    L12:
        r8 = null;
        goto L13
    L15:
        Integer r9 = (Integer) CollectionsKt.maxOrNull(r1);
        if (r9 == null) goto L18;
        int r10 = r9.intValue();
    L20:
        return r10 + 1;
    L18:
        r10 = 0;
        goto L20
    }

    public static final /* synthetic */ void access$setLoadingList$p(ODiaryStyleViewModel r0, boolean r1) {
        r0.loadingList = r1;
    }

    public static final /* synthetic */ c access$toOpResult(ODiaryStyleViewModel r0, v0 r1) {
        return r0.toOpResult(r1);
    }

    public static final /* synthetic */ d access$toUiItem(ODiaryStyleViewModel r0, t0 r1) {
        return r0.toUiItem(r1);
    }

    public final void deleteCustomStyle(d r8, Function1<? super Boolean, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04471(r8, this, r9, null), 2, null);
    }

    public final void selectStyle(d r8, Function1<? super c, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "item");
        Intrinsics.checkNotNullParameter(r9, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04491(r8, this, r9, null), 2, null);
    }

    public final void createCustomStyle(String r11, String r12, Function1<? super c, Unit> r13) {
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "prompt");
        Intrinsics.checkNotNullParameter(r13, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r12, r11, this, r13, null), 2, null);
    }

    public final void updateCustomStyle(d r12, String r13, String r14, Function1<? super c, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "item");
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r14, "prompt");
        Intrinsics.checkNotNullParameter(r15, "onResult");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04501(r14, r13, r12, this, r15, null), 2, null);
    }
}
