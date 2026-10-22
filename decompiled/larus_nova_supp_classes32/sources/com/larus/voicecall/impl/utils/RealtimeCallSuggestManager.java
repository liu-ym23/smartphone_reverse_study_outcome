package com.larus.voicecall.impl.utils;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.Observer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.obric.aivoice.core.data.NameKeys;
import java.io.Serializable;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class RealtimeCallSuggestManager {
    public final CoroutineScope a;
    public final e3a.a b;
    public final com.larus.voicecall.impl.component.scene.a c;
    public final Lazy d;
    public final Lazy e;
    public Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> f;
    public boolean g;

    public static final class Repository {
        public final e3a.a a;
        public final com.larus.voicecall.impl.component.scene.a b;
        public boolean c;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ,\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$Repository$SuggestionData;", "Ljava/io/Serializable;", "suggestList", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "inExperiment", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getSuggestList", "()Ljava/util/List;", "getInExperiment", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$Repository$SuggestionData;", "equals", "other", NameKeys.UnloadStrategy_No_Strategy, "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SuggestionData implements Serializable {

            @SerializedName("hit_suggest")
            private final Boolean inExperiment;

            @SerializedName("suggestions")
            @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
            private final List<String> suggestList;

            /* JADX WARN: Multi-variable type inference failed */
            public SuggestionData() {
                Object[] r0 = 0 == true ? 1 : 0;
                this(null, r0, 3, 0 == true ? 1 : 0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SuggestionData copy$default(SuggestionData r0, List r1, Boolean r2, int r3, Object r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = r0.suggestList;
            L6:
                if ((r3 & 2) == 0) goto L9;
                r2 = r0.inExperiment;
            L9:
                return r0.copy(r1, r2);
            }

            public final List<String> component1() {
                return this.suggestList;
            }

            public final Boolean component2() {
                return this.inExperiment;
            }

            public final SuggestionData copy(List<String> r2, Boolean r3) {
                return new SuggestionData(r2, r3);
            }

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof SuggestionData) == true) goto L8;
                return false;
            L8:
                SuggestionData r6 = (SuggestionData) r5;
                if (Intrinsics.areEqual(this.suggestList, r6.suggestList) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.inExperiment, r6.inExperiment) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                List<String> r0 = this.suggestList;
                int r1 = 0;
                if (r0 != null) goto L5;
                int r2 = 0;
            L6:
                int r3 = r2 * 31;
                Boolean r4 = this.inExperiment;
                if (r4 == null) goto L11;
                r1 = r4.hashCode();
            L11:
                return r3 + r1;
            L5:
                r2 = r0.hashCode();
                goto L6
            }

            public String toString() {
                return "SuggestionData(suggestList=" + this.suggestList + ", inExperiment=" + this.inExperiment + ')';
            }

            public final Boolean getInExperiment() {
                return this.inExperiment;
            }

            public final List<String> getSuggestList() {
                return this.suggestList;
            }

            public SuggestionData(List<String> r1, Boolean r2) {
                this.suggestList = r1;
                this.inExperiment = r2;
            }

            public /* synthetic */ SuggestionData(List r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
                if ((r3 & 1) == 0) goto L6;
                r1 = CollectionsKt.emptyList();
            L6:
                if ((r3 & 2) == 0) goto L8;
                r2 = null;
            L8:
                this(r1, r2);
            }
        }

        public static final class a {
        }

        static {
        }

        public final Object a(Continuation<? super List<String>> r6) {
            if ((r6 instanceof RealtimeCallSuggestManager$Repository$getSuggestList$1) == false) goto L7;
            RealtimeCallSuggestManager$Repository$getSuggestList$1 r0 = (RealtimeCallSuggestManager$Repository$getSuggestList$1) r6;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r7 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r7);
        L21:
            SuggestionData r8 = (SuggestionData) r7;
            if (r8 != null) goto L26;
            return CollectionsKt.emptyList();
        L26:
            if (r8.getInExperiment() == null) goto L28;
            this.c = r8.getInExperiment().booleanValue();
        L28:
            List<String> r9 = r8.getSuggestList();
            if (r9 == null) goto L31;
            return r9;
        L31:
            return CollectionsKt.emptyList();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r7);
            if (this.c == false) goto L17;
            CoroutineDispatcher r10 = Dispatchers.getIO();
            RealtimeCallSuggestManager$Repository$getSuggestList$response$1 r4 = new RealtimeCallSuggestManager$Repository$getSuggestList$response$1(this, null);
            r0.label = 1;
            r7 = BuildersKt.withContext(r10, r4, r0);
            if (r7 != r2) goto L21;
            return r2;
        L17:
            return CollectionsKt.emptyList();
        L7:
            r0 = new RealtimeCallSuggestManager$Repository$getSuggestList$1(this, r6);
            goto L8
        }

        public Repository(e3a.a r2, com.larus.voicecall.impl.component.scene.a r3) {
            Intrinsics.checkNotNullParameter(r2, "argument");
            this.a = r2;
            this.b = r3;
            this.c = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/voicecall/impl/utils/RealtimeCallSuggestManager$ShowFrom;", NameKeys.UnloadStrategy_No_Strategy, "value", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CALL_DIRECT", "CALL_SILENCE_POPUP", "RECONNECTION", "CHOOSE_CALL_SCENE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShowFrom extends Enum<ShowFrom> {
        public static final ShowFrom CALL_DIRECT = null;
        public static final ShowFrom CALL_SILENCE_POPUP = null;
        public static final ShowFrom CHOOSE_CALL_SCENE = null;
        public static final ShowFrom RECONNECTION = null;
        public static final /* synthetic */ ShowFrom[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String value;

        public static EnumEntries<ShowFrom> getEntries() {
            return b;
        }

        static {
            ShowFrom r0 = new ShowFrom("CALL_DIRECT", 0, "call_direct");
            CALL_DIRECT = r0;
            ShowFrom r1 = new ShowFrom("CALL_SILENCE_POPUP", 1, "call_silence_popup");
            CALL_SILENCE_POPUP = r1;
            ShowFrom r2 = new ShowFrom("RECONNECTION", 2, "reconnection");
            RECONNECTION = r2;
            ShowFrom r4 = new ShowFrom("CHOOSE_CALL_SCENE", 3, "choose_call_scene");
            CHOOSE_CALL_SCENE = r4;
            ShowFrom[] r6 = {r0, r1, r2, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
        }

        public static ShowFrom[] values() {
            return (ShowFrom[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ShowFrom valueOf(String r1) {
            return (ShowFrom) r27.a.a(ShowFrom.class, r1);
        }

        public ShowFrom(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Timer {
        public final CoroutineScope a;
        public Function1<? super Continuation<? super Unit>, ? extends Object> b;
        public final Lazy c;

        public Timer(CoroutineScope r2, final long r3) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            this.a = r2;
            this.b = new RealtimeCallSuggestManager$Timer$onTimerFinish$1(null);
            this.c = LazyKt.lazy(new n(r3, this));
        }
    }

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(o r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public RealtimeCallSuggestManager(LifecycleCoroutineScope r2, e3a.a r3, com.larus.voicecall.impl.component.scene.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "argument");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = LazyKt.lazy(new l(this));
        this.e = LazyKt.lazy(new m(this));
        this.f = new RealtimeCallSuggestManager$updateListener$1(null);
        this.g = true;
    }
}
