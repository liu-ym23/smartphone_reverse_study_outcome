package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ComplexTaskCaseFromPCConfig;
import com.obric.assistant.settings.ObricAppListMode;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class PanelInstructionLoader {
    public static final Lazy<Gson> i = null;
    public final Function0<ComplexTaskCaseFromPCConfig> a;
    public List<PanelInstructionItem> b;
    public List<PanelInstructionItem> c;
    public List<PanelInstructionItem> d;
    public com.obric.assistant.settings.d e;
    public List<PanelInstructionItem> f;
    public boolean g;
    public final CoroutineScope h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricAppListMode.values().length];
            r0[ObricAppListMode.BLACK_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ObricAppListMode.WHITE_LIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public PanelInstructionLoader() {
        this(null);
    }

    static {
        i = LazyKt.lazy(new c());
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.obric.assistant.special_input.instruction.a, java.lang.Object, kotlin.jvm.functions.Function0<com.obric.assistant.ComplexTaskCaseFromPCConfig>] */
    public PanelInstructionLoader(Object r3) {
        ?? r4 = new com.obric.assistant.special_input.instruction.a();
        Intrinsics.checkNotNullParameter(r4, "configProvider");
        this.a = r4;
        this.b = CollectionsKt.emptyList();
        this.c = CollectionsKt.emptyList();
        this.d = CollectionsKt.emptyList();
        this.e = new com.obric.assistant.settings.d(0);
        this.f = d(((ComplexTaskCaseFromPCConfig) r4.invoke()).getLocalLimitCount());
        this.h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static List d(int r17) {
        List r0 = CollectionsKt.listOf(new Integer[]{2131912317, 2131912322, 2131912323, 2131912324, 2131912325, 2131912326, 2131912327, 2131912328, 2131912329, 2131912318, 2131912319, 2131912320, 2131912321});
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L17;
        int r4 = ((Number) r3.next()).intValue();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(AppHost.a.getApplication().getString(r4));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L14;
        FLogger.a.i("PanelInstructionLoader", "get default instruction failed: " + r4 + ", " + r6.getMessage());
    L14:
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = "";
    L16:
        r1.add((String) r5);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L17:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r1.iterator();
    L19:
        if (r9.hasNext() == false) goto L29;
        String r10 = (String) r9.next();
        PanelInstructionItem r11 = null;
        if ((!StringsKt.isBlank(r10)) == false) goto L23;
        String r12 = r10;
    L24:
        if (r12 == null) goto L26;
        r11 = new PanelInstructionItem(null, r12, r12, PanelInstructionType.RECOMMEND_LOCAL, null, null, 0, ErrorCode.PERMISSION_ERROR, null);
    L26:
        if (r11 == null) goto L19;
        r8.add(r11);
        goto L19
    L23:
        r12 = null;
        goto L24
    L29:
        return CollectionsKt.take(r8, r17);
    }

    public static e g(String r4) {
        e r1 = null;
        if (StringsKt.isBlank(r4) == false) goto L28;
        return null;
    L28:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl((e) ((Gson) i.getValue()).fromJson(r4, e.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        e r3 = (e) r2;
        if (r3 == null) goto L27;
        String r5 = r3.a();
        if (r5 != null) goto L17;
    L20:
        boolean r6 = true;
    L22:
        if ((!r6) == false) goto L24;
        r1 = r3;
    L24:
        if (r1 == null) goto L27;
        return r1;
    L17:
        if (StringsKt.isBlank(r5) == true) goto L20;
        r6 = false;
    L27:
        return new e(r4, 6);
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public final List<PanelInstructionItem> a(ComplexTaskCaseFromPCConfig r20) {
        List r1 = CollectionsKt.plus(CollectionsKt.plus(this.b, this.c), this.d);
        HashSet r2 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r5 = r4.next();
        PanelInstructionItem r6 = (PanelInstructionItem) r5;
        if (r2.add(TuplesKt.to(r6.getType(), r6.getDisplayText())) == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r3.iterator();
    L9:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L30;
        Object r10 = r8.next();
        PanelInstructionItem r11 = (PanelInstructionItem) r10;
        com.obric.assistant.settings.d r12 = this.e;
        if (c(r11, r12.d) == false) goto L15;
    L27:
        r9 = false;
    L28:
        if (r9 == false) goto L9;
        r7.add(r10);
        goto L9
    L15:
        if (c(r11, r12.e) == true) goto L28;
        int r13 = b.a[r12.a.ordinal()];
        if (r13 == 1) goto L25;
        if (r13 != 2) goto L23;
        r9 = c(r11, r12.c);
        goto L28
    L23:
        throw new NoWhenBranchMatchedException();
    L25:
        if (c(r11, r12.b) == true) goto L27;
    L30:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r7.iterator();
    L32:
        if (r15.hasNext() == false) goto L48;
        PanelInstructionItem r16 = (PanelInstructionItem) r15.next();
        int r17 = r20.getMaxTextLength();
        if (StringsKt.isBlank(r16.getDisplayText()) == false) goto L36;
    L45:
        PanelInstructionItem r18 = null;
    L46:
        if (r18 == null) goto L32;
        r14.add(r18);
        goto L32
    L36:
        if (StringsKt.isBlank(r16.getSendText()) == true) goto L45;
        String r19 = StringsKt.replace$default(StringsKt.replace$default(r16.getDisplayText(), "\r", " ", false, 4, null), "\n", " ", false, 4, null);
        if (r17 > 0) goto L41;
    L44:
        r18 = PanelInstructionItem.copy$default(r16, null, r19, null, null, null, null, 0, 125, null);
        goto L46
    L41:
        if (r19.length() <= r17) goto L44;
        r18 = PanelInstructionItem.copy$default(r16, null, StringsKt.take(r19, RangesKt.coerceAtLeast(r17 - 1, 1)) + 8230, null, null, null, null, 0, 125, null);
        goto L46
    L48:
        return r14;
    }

    public final Object b(Continuation<? super d> r9) {
        if ((r9 instanceof PanelInstructionLoader$getRefreshedPanelItems$1) == false) goto L7;
        PanelInstructionLoader$getRefreshedPanelItems$1 r0 = (PanelInstructionLoader$getRefreshedPanelItems$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ComplexTaskCaseFromPCConfig r4 = (ComplexTaskCaseFromPCConfig) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L21:
        List<PanelInstructionItem> r11 = (List) r10;
        boolean r5 = !Intrinsics.areEqual(this.b, r11);
        if (r5 == false) goto L24;
        this.b = r11;
    L24:
        List<PanelInstructionItem> r12 = a(r4);
        this.f = r12;
        return new d(r5, r12);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        ComplexTaskCaseFromPCConfig r13 = (ComplexTaskCaseFromPCConfig) this.a.invoke();
        int r6 = r13.getShortcutLimitCount();
        r0.L$0 = r13;
        r0.label = 1;
        if (r6 > 0) goto L17;
        Object r7 = CollectionsKt.emptyList();
    L18:
        if (r7 != r2) goto L20;
        return r2;
    L20:
        Object r8 = r7;
        r4 = r13;
        r10 = r8;
        goto L21
    L17:
        r7 = BuildersKt.withContext(Dispatchers.getIO(), new PanelInstructionLoader$loadShortcutItems$2(r6, this, null), r0);
    L7:
        r0 = new PanelInstructionLoader$getRefreshedPanelItems$1(this, r9);
        goto L8
    }

    public final Object e(Continuation<? super List<PanelInstructionItem>> r3) {
        return CoroutineScopeKt.coroutineScope(new PanelInstructionLoader$loadPanelItems$2(this, null), r3);
    }

    public static boolean c(PanelInstructionItem r6, Set r7) {
        if (r7.isEmpty() == false) goto L5;
        return false;
    L5:
        Set r8 = r7;
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L34;
        String r0 = (String) r9.next();
        if ((!StringsKt.isBlank(r0)) == true) goto L16;
    L24:
        boolean r1 = false;
    L25:
        if (r1 == false) goto L12;
        return true;
    L16:
        if (StringsKt.contains$default(r6.getDisplayText(), r0, false, 2, null) == false) goto L18;
    L21:
        boolean r2 = true;
    L22:
        if (r2 == false) goto L24;
        r1 = true;
        goto L25
    L18:
        if (StringsKt.contains$default(r6.getSendText(), r0, false, 2, null) == true) goto L21;
        r2 = false;
        goto L22
    L34:
        return false;
    L8:
        if (r8.isEmpty() == false) goto L10;
        return false;
    }

    public static PanelInstructionItem f(e r14, PanelInstructionType r15) {
        String r0 = r14.a();
        if (r0 != null) goto L5;
    L12:
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == false) goto L7;
        String r6 = r0;
    L8:
        if (r6 == null) goto L12;
        return new PanelInstructionItem(null, r6, r6, r15, r14.b(), r14.c(), 0, 65, null);
    L7:
        r6 = null;
        goto L8
    }
}
